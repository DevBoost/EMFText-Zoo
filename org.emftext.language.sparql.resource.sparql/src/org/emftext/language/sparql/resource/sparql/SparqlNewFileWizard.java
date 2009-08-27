package org.emftext.language.sparql.resource.sparql;
public class SparqlNewFileWizard extends org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard {
	
	public java.lang.String getFileExtension() {
		return "sparql";
	}
	
	public org.emftext.runtime.resource.ITextResourcePluginMetaInformation getMetaInformation() {
		return new org.emftext.language.sparql.resource.sparql.SparqlMetaInformation();
	}
	
	public java.lang.String getExampleContent() {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getSparqlQueries(),
		}, getMetaInformation().getClassesWithSyntax());
	}
	
	public org.emftext.runtime.resource.ITextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.language.sparql.resource.sparql.SparqlPrinter(outputStream, new org.emftext.language.sparql.resource.sparql.SparqlResource());
	}
}
