/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * A ContainedFeature represents a specific path to a metaclass by navigating a
 * structural feature. ContainedFeatures are used during code completion to
 * reconstruct containment trees that are not create by the parser, for example,
 * if the first character of the contained object has not been typed yet.
 */
public class NotesContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private org.eclipse.emf.ecore.EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	
	public NotesContainedFeature(org.eclipse.emf.ecore.EClass containerClass, org.eclipse.emf.ecore.EStructuralFeature feature) {
		super();
		this.containerClass = containerClass;
		this.feature = feature;
	}
	
	public org.eclipse.emf.ecore.EClass getContainerClass() {
		return containerClass;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public String toString() {
		return (feature == null ? "null" : feature.getName()) + "->" + (containerClass == null ? "null" : containerClass.getName());
	}
	
}
