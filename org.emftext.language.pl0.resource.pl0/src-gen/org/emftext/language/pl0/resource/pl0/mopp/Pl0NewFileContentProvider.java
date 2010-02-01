package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0NewFileContentProvider {
	
	public org.emftext.language.pl0.resource.pl0.IPl0MetaInformation getMetaInformation() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation();
	}
	
	public java.lang.String getNewFileContent(java.lang.String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProgram(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, java.lang.String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.pl0.resource.pl0.util.Pl0MinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.pl0.resource.pl0.IPl0TextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			org.emftext.language.pl0.resource.pl0.mopp.Pl0Plugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0Printer(outputStream, new org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource());
	}
	
}
