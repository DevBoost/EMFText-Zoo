/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.javabehavior4uml.resource.actions;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.javabehavior4uml.JavaMethodBehavior;
import org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorPlugin;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.ui.JavabehaviorMarkerHelper;
import org.emftext.language.java.javabehavior4uml.util.UML2JavaWrapper;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.types.TypesFactory;

public class AddToUMLClassifierAction implements IObjectActionDelegate {
	
	private ISelection selection;

	public void run(IAction action) {
       	if (selection instanceof IStructuredSelection) {	
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object next = i.next();
                if (next instanceof EditPart) {
                	//navigate from edit part to model
                	next = ((EditPart)next).getModel();
                } 
                if (next instanceof EObject) {
                	if (!(next instanceof Element)) {
                		//maybe only the diagram
                		for(EObject diagramElement : ((EObject)next).eContents()) {
                			for(EObject candidate : diagramElement.eCrossReferences()) {
                				if (candidate instanceof Element) {
                					next = candidate;
                				}
                			}
                		}
                	}

                	//find the first 
                 	if (next instanceof Element) {
                 		Element selectedElement = (Element) next;
	                	openBehavior(selectedElement);
                 	}
                }
            }
        }
	}

	private void openBehavior(Element selectedElement) {

		if (selectedElement instanceof BehavioralFeature) {
			
			Resource umlResource = selectedElement.eResource();
			BehavioralFeature operation = (BehavioralFeature) selectedElement;

			
			if(umlResource != null && operation.eContainer() instanceof BehavioredClassifier) {
				BehavioredClassifier classifier = (BehavioredClassifier) operation.eContainer();
				URI uri = umlResource.getURI();
				uri = uri.appendFileExtension(classifier.getName());
				uri = uri.appendFileExtension(operation.getName());
				uri = uri.appendFileExtension("javabehavior");
				ResourceSet rs = umlResource.getResourceSet();
				Resource behaviorResource = rs.getResource(uri, false);
				if (behaviorResource == null) {
					//create
					behaviorResource = rs.createResource(uri);
					JavaMethodBehavior behavior = Javabehavior4umlFactory.eINSTANCE.createJavaMethodBehavior();
					operation.getMethods().add(behavior);
					ClassMethod javaMethod = MembersFactory.eINSTANCE.createClassMethod();
					javaMethod.setName(operation.getName());
					javaMethod.setTypeReference(TypesFactory.eINSTANCE.createVoid());
					javaMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
					behavior.setJavaMethod(javaMethod);
					classifier.getOwnedBehaviors().add(behavior);
					behaviorResource.getContents().add(behavior);
					try {
						behaviorResource.save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				IFile file = (IFile) WorkspaceSynchronizer.getFile(behaviorResource);
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorRegistry editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
				IEditorDescriptor editorDescriptor = editorRegistry.getDefaultEditor(file.getName());
				
				if (editorDescriptor != null) {
			        try {			        
			        	IEditorPart editor = page.openEditor(
							      new FileEditorInput(file),
							      editorDescriptor.getId());
			        	
			        	if (editor instanceof IEditingDomainProvider) {
			        		rs = ((IEditingDomainProvider)editor).getEditingDomain().getResourceSet();
			    			registerPackage(
			    					(Package) operation.eContainer().eContainer(), 
			    					rs);	
			        	}
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
				try {
					JavabehaviorMarkerHelper.unmark(behaviorResource);
				} catch (CoreException e) {
					JavabehaviorPlugin.logError("Error: ", e);
				}
			}
		}
	}
	
	private void registerPackage(Package umlPackage, ResourceSet resourceSet) {
		for(CompilationUnit cu : UML2JavaWrapper.wrapPackage(umlPackage)) {
			URI uri = JavaUniquePathConstructor.getJavaFileResourceURI(
					JavaUniquePathConstructor.packageName(cu) + "." + 
					cu.getClassifiers().get(0).getName());
			synchronized (resourceSet) {
				Resource resource = resourceSet.getResource(uri, false);
				if (resource == null) {
					resource = resourceSet.createResource(uri);
				}
				JavaClasspath.get(resourceSet).registerClassifierSource(cu, uri);
				resource.getContents().clear();
				resource.getContents().add(cu);
			}
		}
	}


	
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
}
