/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.debug;

public class PlSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.emftext.language.prolog.resource.pl.debug.PlStackFrame) {
			org.emftext.language.prolog.resource.pl.debug.PlStackFrame frame = (org.emftext.language.prolog.resource.pl.debug.PlStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
