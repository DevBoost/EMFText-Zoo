/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlNewFileContentProvider {
	
	public org.emftext.language.prolog.resource.pl.IPlMetaInformation getMetaInformation() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "d(3,4).\nd(X,2).\n\ndExpr(Tn,X,DT) :- dTerm(TX,DT).\n\ndExpr(E+T,X,DE+DT) :- dExpr(E,X,DE), dTerm(T,X,DT, F_, 'asd'), X is [cos(pi)].\n\ntest(C,x, R).\ntest(X).\ntest(muh(d),X).\n\nlist([a,b,c | [d,e]] ).\n".replace("\n", System.getProperty("line.separator"));
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.prolog.resource.pl.util.PlMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.prolog.resource.pl.IPlTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new org.emftext.language.prolog.resource.pl.util.PlRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.language.prolog.resource.pl.mopp.PlResource());
	}
	
}
