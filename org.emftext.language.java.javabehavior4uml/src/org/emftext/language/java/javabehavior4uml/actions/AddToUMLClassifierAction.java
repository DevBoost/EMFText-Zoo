package org.emftext.language.java.javabehavior4uml.actions;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
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
					javaMethod.setType(TypesFactory.eINSTANCE.createVoid());
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
				
			}
		}
	}
	
	private void registerPackage(Package umlPackage, ResourceSet resourceSet) {
		for(CompilationUnit cu : UML2JavaWrapper.wrapPackage(umlPackage)) {
			URI uri = JavaUniquePathConstructor.getJavaFileResourceURI(
					JavaUniquePathConstructor.packageName(cu) + "." + cu.getClassifiers().get(0).getName());
			
			Resource resource = resourceSet.createResource(uri);
			JavaClasspath.get(resourceSet).registerClassifierSource(cu, uri);
			resource.getContents().clear();
			resource.getContents().add(cu);
		}
	}


	
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
}
