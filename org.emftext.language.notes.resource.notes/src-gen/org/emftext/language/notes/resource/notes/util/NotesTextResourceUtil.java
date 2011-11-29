/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.util;

/**
 * Class NotesTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.notes.resource.notes.util.NotesResourceUtil.
 */
public class NotesTextResourceUtil {
	
	/**
	 * Use
	 * org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.notes.resource.notes.mopp.NotesResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.language.notes.resource.notes.util.NotesEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.notes.resource.notes.mopp.NotesResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.notes.resource.notes.mopp.NotesResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.notes.resource.notes.mopp.NotesResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.notes.resource.notes.util.NotesResourceUtil.getResource(uri, options);
	}
	
}
