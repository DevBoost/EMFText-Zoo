/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver;

public class PropertyMappedByReferenceResolver implements IHedlReferenceResolver<Property, Property> {
	
	private HedlDefaultResolverDelegate<Property, Property> delegate = new HedlDefaultResolverDelegate<Property, Property>();
	
	public void resolve(String identifier, Property container, EReference reference, int position, boolean resolveFuzzy, final IHedlReferenceResolveResult<Property> result) {
		Type type = container.getType();
		if (type != null) {
			// the property that is referenced by the 'mappedBy' reference must be contained in the
			// type of the property
			delegate.tryToResolveIdentifierInObjectTree(identifier, container, type, reference, position, resolveFuzzy, result, true);
		}
	}
	
	public String deResolve(Property element, Property container, EReference reference) {
		return container.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not used
	}
	
}
