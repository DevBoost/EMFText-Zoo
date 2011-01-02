/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.sumup.resource.sumup.mopp;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.sumup.Sheet;

public class SumupBuilder implements
		org.emftext.language.sumup.resource.sumup.ISumupBuilder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		if (uri.toString().endsWith("evaluated.sumup")) return false;
		return true;
	}

	public org.eclipse.core.runtime.IStatus build(
			org.emftext.language.sumup.resource.sumup.mopp.SumupResource resource,
			org.eclipse.core.runtime.IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		if (resource.getErrors().isEmpty()
				&& resource.getContents().size() == 1
				&& resource.getContents().get(0) instanceof Sheet) {
			boolean changes = evaluateSheet((Sheet) resource.getContents().get(
					0));
			if (changes && resource.getErrors().isEmpty()) {
 				URI outUri = resource.getURI().trimFileExtension();
				outUri = outUri.appendFileExtension("evaluated.sumup");
				SumupResource out = (SumupResource) resource.getResourceSet()
						.createResource(outUri);
				out.getContents().add(resource.getContents().get(0));
				try {
					out.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;

	}

	private boolean evaluateSheet(Sheet sheet) {
		if (sheet.getEntries().size() > 0) {
			// invoke petrinets evaluation
			return true;
		}
		return false;

	}
}
