/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(),
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram(),
		};
	}
	
}
