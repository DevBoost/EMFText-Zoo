/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlContainment extends org.emftext.language.prolog.resource.pl.grammar.PlTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public PlContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.prolog.resource.pl.util.PlStringUtil.explode(allowedTypes, ", ", new org.emftext.language.prolog.resource.pl.IPlFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
