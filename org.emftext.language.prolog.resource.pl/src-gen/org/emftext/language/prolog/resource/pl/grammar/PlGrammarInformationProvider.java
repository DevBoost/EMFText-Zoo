/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static PlGrammarInformationProvider INSTANCE = new PlGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_0_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PROLOG_PROGRAM__CLAUSES), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.PLUS, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_0_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_0 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram(), PL_0_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__PREDICATE), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_1_0_0_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(":-", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_1_0_0_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__CONJUNCTION), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_1_0_0_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_1_0_0_1_0_0_0, PL_1_0_0_1_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_1_0_0_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_1_0_0_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_1_0_0_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.QUESTIONMARK);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_1_0_0_2 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(".", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_1_0_0_0, PL_1_0_0_1, PL_1_0_0_2);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_1 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), PL_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_2_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CONJUNCTION__PARTS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getPart(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_2_0_0_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(",", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_2_0_0_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CONJUNCTION__PARTS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getPart(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_2_0_0_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_2_0_0_1_0_0_0, PL_2_0_0_1_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_2_0_0_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_2_0_0_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_2_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_2_0_0_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.STAR);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_2_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_2_0_0_0, PL_2_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_2_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_2_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_2 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), PL_2_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_3_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__ATOM), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getAtom(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_3_0_0_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword("(", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_3_0_0_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__TERMS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_3_0_0_1_0_0_2_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(",", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_3_0_0_1_0_0_2_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__TERMS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_3_0_0_1_0_0_2_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0_1_0_0_2_0_0_0, PL_3_0_0_1_0_0_2_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_3_0_0_1_0_0_2_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0_1_0_0_2_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_3_0_0_1_0_0_2 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_3_0_0_1_0_0_2_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.STAR);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_3_0_0_1_0_0_3 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(")", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_3_0_0_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0_1_0_0_0, PL_3_0_0_1_0_0_1, PL_3_0_0_1_0_0_2, PL_3_0_0_1_0_0_3);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_3_0_0_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_3_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_3_0_0_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.QUESTIONMARK);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_3_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0_0, PL_3_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_3_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_3_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_3 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), PL_3_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_4_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.NUMERAL__VALUE), "FLOAT", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_4_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_4_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_4_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_4_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_4 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), PL_4_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_5_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE__NAME), "CAPITAL_WORD", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_5_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_5_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_5_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_5_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_5 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), PL_5_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_6_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ANONYMOUS_VARIABLE__TEXT), "ANONYMOUS", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_6_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_6_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_6_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_6_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_6 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), PL_6_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_7_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.SMALL_ATOM__TEXT), "SMALL_WORD", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_7_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_7_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_7_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_7_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_7 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), PL_7_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_8_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.STRING__TEXT), "QUOTED_39_39", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_8_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_8_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_8_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_8_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_8 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), PL_8_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder PL_9_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlPlaceholder(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE_REFERENCE__VARIABLE), "CAPITAL_WORD", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_9_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_9_0_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_9_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_9_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_9 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), PL_9_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_10_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword("[", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_10_0_0_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__HEAD_TERMS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_10_0_0_1_0_0_1_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword(",", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_10_0_0_1_0_0_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__HEAD_TERMS), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_10_0_0_1_0_0_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0_1_0_0_0, PL_10_0_0_1_0_0_1_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_10_0_0_1_0_0_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_10_0_0_1_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_10_0_0_1_0_0_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.STAR);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_10_0_0_1_0_0_2_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword("|", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_10_0_0_1_0_0_2_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__TAIL), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTail(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_10_0_0_1_0_0_2_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0_2_0_0_0, PL_10_0_0_1_0_0_2_0_0_1);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_10_0_0_1_0_0_2_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0_2_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_10_0_0_1_0_0_2 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_10_0_0_1_0_0_2_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.QUESTIONMARK);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_10_0_0_1_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0_0, PL_10_0_0_1_0_0_1, PL_10_0_0_1_0_0_2);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_10_0_0_1_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_1_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlCompound PL_10_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlCompound(PL_10_0_0_1_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.QUESTIONMARK);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_10_0_0_2 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword("]", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_10_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0_0, PL_10_0_0_1, PL_10_0_0_2);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_10_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_10_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_10 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), PL_10_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_11_0_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__VARIABLE), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlKeyword PL_11_0_0_1 = new org.emftext.language.prolog.resource.pl.grammar.PlKeyword("is", org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlContainment PL_11_0_0_2 = new org.emftext.language.prolog.resource.pl.grammar.PlContainment(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__TERM), org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.prolog.PrologPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlSequence PL_11_0_0 = new org.emftext.language.prolog.resource.pl.grammar.PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_11_0_0_0, PL_11_0_0_1, PL_11_0_0_2);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlChoice PL_11_0 = new org.emftext.language.prolog.resource.pl.grammar.PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE, PL_11_0_0);
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule PL_11 = new org.emftext.language.prolog.resource.pl.grammar.PlRule(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(), PL_11_0, org.emftext.language.prolog.resource.pl.grammar.PlCardinality.ONE);
	
	public final static org.emftext.language.prolog.resource.pl.grammar.PlRule[] RULES = new org.emftext.language.prolog.resource.pl.grammar.PlRule[] {
		PL_0,
		PL_1,
		PL_2,
		PL_3,
		PL_4,
		PL_5,
		PL_6,
		PL_7,
		PL_8,
		PL_9,
		PL_10,
		PL_11,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.language.prolog.resource.pl.grammar.PlRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.language.prolog.resource.pl.grammar.PlKeyword) {
			keywords.add(((org.emftext.language.prolog.resource.pl.grammar.PlKeyword) element).getValue());
		} else if (element instanceof org.emftext.language.prolog.resource.pl.grammar.PlBooleanTerminal) {
			keywords.add(((org.emftext.language.prolog.resource.pl.grammar.PlBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.language.prolog.resource.pl.grammar.PlBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.language.prolog.resource.pl.grammar.PlEnumerationTerminal) {
			org.emftext.language.prolog.resource.pl.grammar.PlEnumerationTerminal terminal = (org.emftext.language.prolog.resource.pl.grammar.PlEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
