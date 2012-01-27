/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class PlFollowSetProvider {
	
	public final static org.emftext.language.prolog.resource.pl.IPlExpectedElement TERMINALS[] = new org.emftext.language.prolog.resource.pl.IPlExpectedElement[17];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[10];
	
	public final static org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] LINKS = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[80];
	
	public final static org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_7_0_0_0);
		TERMINALS[1] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_8_0_0_0);
		TERMINALS[2] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_1_0_0_0);
		TERMINALS[3] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_2);
		TERMINALS[4] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_9_0_0_0);
		TERMINALS[5] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_2_0_0_1_0_0_0);
		TERMINALS[6] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_0);
		TERMINALS[7] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_2_0_0_0);
		TERMINALS[8] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_3);
		TERMINALS[9] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_1_0_0_0);
		TERMINALS[10] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_2_0_0_0);
		TERMINALS[11] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_2);
		TERMINALS[12] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_4_0_0_0);
		TERMINALS[13] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_5_0_0_0);
		TERMINALS[14] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedStructuralFeature(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_6_0_0_0);
		TERMINALS[15] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_0);
		TERMINALS[16] = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_11_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__ATOM);
		FEATURES[1] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CONJUNCTION__PARTS);
		FEATURES[2] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__CONJUNCTION);
		FEATURES[3] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__VARIABLE);
		FEATURES[4] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__PREDICATE);
		FEATURES[5] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getPrologProgram().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PROLOG_PROGRAM__CLAUSES);
		FEATURES[6] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__TERMS);
		FEATURES[7] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getList().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__HEAD_TERMS);
		FEATURES[8] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getList().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__TAIL);
		FEATURES[9] = org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__TERM);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[1] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[2] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[3] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[4] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[5] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[6] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[7] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[8] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[9] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[10] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[11] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[12] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[13] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]);
		LINKS[14] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]);
		LINKS[15] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[16] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]);
		LINKS[17] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]);
		LINKS[18] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[3]);
		LINKS[19] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(), FEATURES[1]);
		LINKS[20] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]);
		LINKS[21] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[22] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[23] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[24] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[25] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]);
		LINKS[26] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]);
		LINKS[27] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[28] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]);
		LINKS[29] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[30] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]);
		LINKS[31] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[3]);
		LINKS[32] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(), FEATURES[1]);
		LINKS[33] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[34] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]);
		LINKS[35] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[36] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]);
		LINKS[37] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[6]);
		LINKS[38] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[6]);
		LINKS[39] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[6]);
		LINKS[40] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[6]);
		LINKS[41] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[6]);
		LINKS[42] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[43] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]);
		LINKS[44] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[45] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]);
		LINKS[46] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[6]);
		LINKS[47] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[6]);
		LINKS[48] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[6]);
		LINKS[49] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[6]);
		LINKS[50] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[6]);
		LINKS[51] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[52] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]);
		LINKS[53] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[54] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]);
		LINKS[55] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[7]);
		LINKS[56] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[7]);
		LINKS[57] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[7]);
		LINKS[58] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[7]);
		LINKS[59] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[7]);
		LINKS[60] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[61] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]);
		LINKS[62] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[63] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]);
		LINKS[64] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[7]);
		LINKS[65] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[7]);
		LINKS[66] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[7]);
		LINKS[67] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[7]);
		LINKS[68] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[7]);
		LINKS[69] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[8]);
		LINKS[70] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[8]);
		LINKS[71] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]);
		LINKS[72] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[9]);
		LINKS[73] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]);
		LINKS[74] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[9]);
		LINKS[75] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[9]);
		LINKS[76] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[9]);
		LINKS[77] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[9]);
		LINKS[78] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[9]);
		LINKS[79] = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[9]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[2].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]), });
		TERMINALS[2].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]), });
		TERMINALS[2].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[3]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(), FEATURES[1]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getConjunction(), FEATURES[2]), });
		TERMINALS[3].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]), });
		TERMINALS[3].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[4]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getClause(), FEATURES[5]), });
		TERMINALS[5].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]), });
		TERMINALS[5].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[1]), });
		TERMINALS[5].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[3]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAssignment(), FEATURES[1]), });
		TERMINALS[6].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[12], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[14], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[6]), });
		TERMINALS[6].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[12], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[14], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[6]), });
		TERMINALS[8].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[12], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[14], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[7]), });
		TERMINALS[15].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[12], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[14], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[7]), });
		TERMINALS[9].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[7]), });
		TERMINALS[10].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[8]), });
		TERMINALS[10].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[8]), });
		TERMINALS[11].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[0], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getSmallAtom(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[1], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getString(), FEATURES[0]), new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getPredicate(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[12], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getNumeral(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[13], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariable(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[14], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getAnonymousVariable(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[4], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference(), FEATURES[9]), });
		TERMINALS[16].addFollower(TERMINALS[15], new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] {new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature(org.emftext.language.prolog.PrologPackage.eINSTANCE.getList(), FEATURES[9]), });
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
