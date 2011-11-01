/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.UniqueConstraint;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver;

public class UniqueConstraintPropertiesReferenceResolver implements IHedlReferenceResolver<UniqueConstraint, Property> {
	
	private HedlDefaultResolverDelegate<UniqueConstraint, Property> delegate = new HedlDefaultResolverDelegate<UniqueConstraint, Property>();
	
	public void resolve(String identifier, UniqueConstraint container, EReference reference, int position, boolean resolveFuzzy, final IHedlReferenceResolveResult<Property> result) {
		EObject root = container.eContainer();
		delegate.tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, true);
	}
	
	public String deResolve(Property element, UniqueConstraint container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not used
	}
	
}
