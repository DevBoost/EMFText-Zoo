/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesNewFileContentProvider {
	
	public org.emftext.language.notes.resource.notes.INotesMetaInformation getMetaInformation() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "Conference XY\n\n* partless bullet\n\n=First Section[sec1]=\n* first bullet point\n\n=Second Section[sec2]>[sec1]=\n* another bullet\n* another bullet\n* another bullet\n* another _bold bullet_ and it goes on with an #italic# bullet and a last @type writer@ bullet\n\n=Section 3>[sec2]=\n* another bullet\n* another bullet\n * sub bullet works as well _bold_\n * sub bullet works as well _bold_\n * sub bullet works as well _bold_\n* sub bullet works as well _bold_".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.notes.resource.notes.util.NotesMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.notes.resource.notes.INotesTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.notes.resource.notes.INotesTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.language.notes.resource.notes.mopp.NotesResource());
	}
	
}
