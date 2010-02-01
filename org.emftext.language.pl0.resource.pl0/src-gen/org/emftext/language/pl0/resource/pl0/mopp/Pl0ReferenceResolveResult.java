/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

// A basic implementation of IResolveResult interface
// that collects mappings in a list.
//
// @param <ReferenceType> the type of the references that can be contained in this result
//
public class Pl0ReferenceResolveResult<ReferenceType> implements org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	
	public Pl0ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.IPl0ReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.IPl0ReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.language.pl0.resource.pl0.mopp.Pl0URIMapping<ReferenceType>(identifier, uri, warning));
	}
}
