/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0FoldingInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProgram(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProcedureDeclaration(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getBody(),
		};
	}
	
}
