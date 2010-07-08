/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.closures.resource.closure.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.closures.AbstractClosure;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.closures.resource.closure.util.ClosureEObjectUtil;
import org.emftext.language.java.containers.CompilationUnit;

public class ClosureCallClosureReferenceResolver implements org.emftext.language.java.closures.resource.closure.IClosureReferenceResolver<org.emftext.language.java.closures.ClosureCall, org.emftext.language.java.closures.AbstractClosure> {
	
	private org.emftext.language.java.closures.resource.closure.analysis.ClosureDefaultResolverDelegate<org.emftext.language.java.closures.ClosureCall, org.emftext.language.java.closures.AbstractClosure> delegate = new org.emftext.language.java.closures.resource.closure.analysis.ClosureDefaultResolverDelegate<org.emftext.language.java.closures.ClosureCall, org.emftext.language.java.closures.AbstractClosure>();
	
	public synchronized void resolve(final java.lang.String identifier,final org.emftext.language.java.closures.ClosureCall container,final org.eclipse.emf.ecore.EReference reference,final int position,final boolean resolveFuzzy,final org.emftext.language.java.closures.resource.closure.IClosureReferenceResolveResult<org.emftext.language.java.closures.AbstractClosure> result) {
		
		
//		EObject root = ClosureEObjectUtil.findRootContainer(container);
//		if(root instanceof CompilationUnit){
//			CompilationUnit compilationUnit = (CompilationUnit)root;
//			Resource resource = compilationUnit.eResource();
//			
//			Collection<AbstractClosure> closures = 
//				ClosureEObjectUtil.getObjectsByType(resource.getAllContents(), ClosuresPackage.eINSTANCE.getAbstractClosure());
//
//			for(AbstractClosure closure : closures){
//				if(closure.getName() != null){
//					if(closure.getName().equals(identifier)){
//						result.addMapping(identifier, closure);
//						break;
//					}
//				}
//			}
//		}
		
				delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);

	}
	
	public java.lang.String deResolve(org.emftext.language.java.closures.AbstractClosure element, org.emftext.language.java.closures.ClosureCall container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
