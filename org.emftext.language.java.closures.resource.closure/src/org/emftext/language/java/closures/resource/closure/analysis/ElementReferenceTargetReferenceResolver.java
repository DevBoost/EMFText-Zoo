/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.java.closures.resource.closure.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.closures.resource.closure.util.ClosureEObjectUtil;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.java.util.JavaEObjectUtil;

public class ElementReferenceTargetReferenceResolver implements org.emftext.language.java.closures.resource.closure.IClosureReferenceResolver<org.emftext.language.java.references.ElementReference, org.emftext.language.java.references.ReferenceableElement> {
	
	private org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver delegate = new org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver();
		
	public synchronized void resolve(final java.lang.String identifier, final org.emftext.language.java.references.ElementReference container, final org.eclipse.emf.ecore.EReference reference, final int position, final boolean resolveFuzzy, final org.emftext.language.java.closures.resource.closure.IClosureReferenceResolveResult<org.emftext.language.java.references.ReferenceableElement> result) {
		
				
		try{
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.java.resource.java.IJavaReferenceResolveResult<org.emftext.language.java.references.ReferenceableElement>() {
				
				public boolean wasResolvedUniquely() {
					return result.wasResolvedUniquely();
				}
				
				public boolean wasResolvedMultiple() {
					return result.wasResolvedMultiple();
				}
				
				public boolean wasResolved() {
					return result.wasResolved();
				}
				
				public void setErrorMessage(String message) {
					result.setErrorMessage(message);
				}
				
				public java.util.Collection<org.emftext.language.java.resource.java.IJavaReferenceMapping<org.emftext.language.java.references.ReferenceableElement>> getMappings() {
					throw new UnsupportedOperationException();
				}
				
				public String getErrorMessage() {
					return result.getErrorMessage();
				}
				
				public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
					result.addMapping(identifier, newIdentifier);
				}
				
				public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
					result.addMapping(identifier, newIdentifier, warning);
				}
				
				public void addMapping(String identifier, org.emftext.language.java.references.ReferenceableElement target) {
					result.addMapping(identifier, target);
				}
				
				public void addMapping(String identifier, org.emftext.language.java.references.ReferenceableElement target, String warning) {
					result.addMapping(identifier, target, warning);
				}
			});						
		}
		catch(Exception e){}
		
		// resolve local method call with closures as parameter in it
		if(result.getMappings() == null){
		
			// workaround necessary to resolve the parameters of a method call
			// who is one parameter a closure
			if(container instanceof MethodCall){
				
				EObject root = ClosureEObjectUtil.findRootContainer(container);
				if(root instanceof CompilationUnit){
					CompilationUnit compilationUnit = (CompilationUnit)root;
					Resource resource = compilationUnit.eResource();
					
					Collection<ClassMethod> methods = 
						JavaEObjectUtil.getObjectsByType(resource.getAllContents(), MembersPackage.eINSTANCE.getClassMethod());
	
					// local methods
					for(ClassMethod method : methods){
						if(method.getName().equals(identifier)){
							result.addMapping(identifier, method);
							break;
						}
					}
					
					// identifiers is local method which has to be called in closure
					// save this method name
					if(container.eContainer() instanceof IdentifierReference){
						
						ReferenceableElement referencableElement = 
							((IdentifierReference)container.eContainer()).getTarget();
						
						if(referencableElement instanceof Closure){
							Closure closure = (Closure) referencableElement;
							PostProcessorHelper.add(closure.getName(), identifier);
							result.addMapping(identifier, closure);
						}
					}
				}
			}
			
			// call of the inner method of a closure
			if(container instanceof IdentifierReference){
				
				EObject root = ClosureEObjectUtil.findRootContainer(container);
				if(root instanceof CompilationUnit){
					CompilationUnit compilationUnit = (CompilationUnit)root;
					Resource resource = compilationUnit.eResource();
					
					Collection<Closure> closures = 
						JavaEObjectUtil.getObjectsByType(resource.getAllContents(), ClosuresPackage.eINSTANCE.getClosure());
	
					// local methods
					for(Closure closure : closures){
						if(closure.getName() != null){
							if(closure.getName().equals(identifier)){
								result.addMapping(identifier, closure);
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.java.references.ReferenceableElement element, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
