/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0SyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProgram(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getBlock(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getConstDeclaration(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getVarDeclaration(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProcedureDeclaration(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getBody(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getCallStatement(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getWhileStatement(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getIfStatement(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getOddCondition(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getRelationalCondition(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getAssignment(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getTermExpression(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getOptionalTerm(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getTerm(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getOptionalFactor(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getIdentReference(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getNumber(),
			org.emftext.language.pl0.PL0Package.eINSTANCE.getExpressionFactor(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.pl0.PL0Package.eINSTANCE.getProgram(),
		};
	}
	
}
