/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.util;

/**
 * Class PlTextResourceUtil can be used to perform common tasks on text resources,
 * such as loading and saving resources, as well as, checking them for errors.
 * This class is deprecated and has been replaced by
 * org.emftext.language.prolog.resource.pl.util.PlResourceUtil.
 */
public class PlTextResourceUtil {
	
	/**
	 * Use org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.prolog.resource.pl.mopp.PlResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.language.prolog.resource.pl.util.PlEclipseProxy().getResource(file);
	}
	
	/**
	 * Use org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.prolog.resource.pl.mopp.PlResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.prolog.resource.pl.mopp.PlResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource(uri);
	}
	
	/**
	 * Use org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.prolog.resource.pl.mopp.PlResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResource(uri, options);
	}
	
}
