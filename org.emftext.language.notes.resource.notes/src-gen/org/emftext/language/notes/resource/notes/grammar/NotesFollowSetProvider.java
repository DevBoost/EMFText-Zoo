/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class NotesFollowSetProvider {
	
	public final static org.emftext.language.notes.resource.notes.INotesExpectedElement TERMINALS[] = new org.emftext.language.notes.resource.notes.INotesExpectedElement[13];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[4];
	
	public final static org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] LINKS = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[47];
	
	public final static org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_0_0_0_0);
		TERMINALS[1] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_0);
		TERMINALS[2] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_0);
		TERMINALS[3] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_1);
		TERMINALS[4] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_2);
		TERMINALS[5] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_3_0_0_0);
		TERMINALS[6] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_4);
		TERMINALS[7] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_3_0_0_1);
		TERMINALS[8] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_3_0_0_0);
		TERMINALS[9] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_4_0_0_0);
		TERMINALS[10] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_5_0_0_0);
		TERMINALS[11] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_6_0_0_0);
		TERMINALS[12] = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_2_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__PARTS);
		FEATURES[1] = org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__BULLETS);
		FEATURES[2] = org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__TEXT_PARTS);
		FEATURES[3] = org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__SUB_POINTS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[1] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[2] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[3] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[4] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[1]);
		LINKS[5] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[6] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[1]);
		LINKS[7] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[8] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[9] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[10] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[11] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[12] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[13] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[14] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[15] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[16] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[17] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[18] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[3]);
		LINKS[19] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[20] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[21] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[22] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[23] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[24] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[25] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[26] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[27] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[28] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[29] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[30] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[31] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[32] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[33] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[34] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[35] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[36] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[37] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[38] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[39] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[40] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
		LINKS[41] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]);
		LINKS[42] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]);
		LINKS[43] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]);
		LINKS[44] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]);
		LINKS[45] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]);
		LINKS[46] = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[0].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]), });
		TERMINALS[1].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[1]), });
		TERMINALS[6].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[2].addFollower(TERMINALS[8], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]), });
		TERMINALS[2].addFollower(TERMINALS[9], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]), });
		TERMINALS[2].addFollower(TERMINALS[10], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]), });
		TERMINALS[2].addFollower(TERMINALS[11], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]), });
		TERMINALS[12].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[3]), });
		TERMINALS[8].addFollower(TERMINALS[8], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[9], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[10], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[11], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[8].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]), });
		TERMINALS[9].addFollower(TERMINALS[8], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[9], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[10], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[11], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[9].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]), });
		TERMINALS[10].addFollower(TERMINALS[8], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]), });
		TERMINALS[10].addFollower(TERMINALS[9], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]), });
		TERMINALS[10].addFollower(TERMINALS[10], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]), });
		TERMINALS[10].addFollower(TERMINALS[11], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]), });
		TERMINALS[10].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[10].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]), });
		TERMINALS[11].addFollower(TERMINALS[8], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[9], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[10], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[11], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[1], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), FEATURES[0]), });
		TERMINALS[11].addFollower(TERMINALS[2], new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] {new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), FEATURES[0]), });
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
