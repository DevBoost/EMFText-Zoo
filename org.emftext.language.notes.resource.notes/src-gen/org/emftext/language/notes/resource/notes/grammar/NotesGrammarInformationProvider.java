/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static NotesGrammarInformationProvider INSTANCE = new NotesGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_0_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME), "TEXT", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesLineBreak NOTES_0_0_0_1 = new org.emftext.language.notes.resource.notes.grammar.NotesLineBreak(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesLineBreak NOTES_0_0_0_2 = new org.emftext.language.notes.resource.notes.grammar.NotesLineBreak(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesContainment NOTES_0_0_0_3 = new org.emftext.language.notes.resource.notes.grammar.NotesContainment(org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__PARTS), org.emftext.language.notes.resource.notes.grammar.NotesCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.notes.NotesPackage.eINSTANCE.getPart(), }, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_0_0_0_0, NOTES_0_0_0_1, NOTES_0_0_0_2, NOTES_0_0_0_3);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_0_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_0 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument(), NOTES_0_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesKeyword NOTES_1_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesKeyword("=", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_1_0_0_1 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME), "TEXT", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_1_0_0_2 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID), "QUOTED_91_93", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.QUESTIONMARK, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesKeyword NOTES_1_0_0_3_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesKeyword(">", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_1_0_0_3_0_0_1 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION), "QUOTED_91_93", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_1_0_0_3_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_1_0_0_3_0_0_0, NOTES_1_0_0_3_0_0_1);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_1_0_0_3_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_1_0_0_3_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesCompound NOTES_1_0_0_3 = new org.emftext.language.notes.resource.notes.grammar.NotesCompound(NOTES_1_0_0_3_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.QUESTIONMARK);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesKeyword NOTES_1_0_0_4 = new org.emftext.language.notes.resource.notes.grammar.NotesKeyword("=", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesLineBreak NOTES_1_0_0_5 = new org.emftext.language.notes.resource.notes.grammar.NotesLineBreak(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesContainment NOTES_1_0_0_6 = new org.emftext.language.notes.resource.notes.grammar.NotesContainment(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__BULLETS), org.emftext.language.notes.resource.notes.grammar.NotesCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), }, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_1_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_1_0_0_0, NOTES_1_0_0_1, NOTES_1_0_0_2, NOTES_1_0_0_3, NOTES_1_0_0_4, NOTES_1_0_0_5, NOTES_1_0_0_6);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_1_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_1_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_1 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(), NOTES_1_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesKeyword NOTES_2_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesKeyword("*", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesContainment NOTES_2_0_0_1 = new org.emftext.language.notes.resource.notes.grammar.NotesContainment(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__TEXT_PARTS), org.emftext.language.notes.resource.notes.grammar.NotesCardinality.PLUS, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.notes.NotesPackage.eINSTANCE.getTextPart(), }, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesLineBreak NOTES_2_0_0_2_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesLineBreak(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesKeyword NOTES_2_0_0_2_0_0_1 = new org.emftext.language.notes.resource.notes.grammar.NotesKeyword(" ", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesContainment NOTES_2_0_0_2_0_0_2 = new org.emftext.language.notes.resource.notes.grammar.NotesContainment(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__SUB_POINTS), org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), }, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_2_0_0_2_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_2_0_0_2_0_0_0, NOTES_2_0_0_2_0_0_1, NOTES_2_0_0_2_0_0_2);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_2_0_0_2_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_2_0_0_2_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesCompound NOTES_2_0_0_2 = new org.emftext.language.notes.resource.notes.grammar.NotesCompound(NOTES_2_0_0_2_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.STAR);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_2_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_2_0_0_0, NOTES_2_0_0_1, NOTES_2_0_0_2);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_2_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_2_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_2 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(), NOTES_2_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_3_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT), "TEXT", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_3_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_3_0_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_3_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_3_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_3 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(), NOTES_3_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_4_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT), "QUOTED_95_95", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_4_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_4_0_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_4_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_4_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_4 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(), NOTES_4_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_5_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT), "QUOTED_35_35", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_5_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_5_0_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_5_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_5_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_5 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(), NOTES_5_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder NOTES_6_0_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT), "QUOTED_64_64", org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, 0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesSequence NOTES_6_0_0 = new org.emftext.language.notes.resource.notes.grammar.NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_6_0_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesChoice NOTES_6_0 = new org.emftext.language.notes.resource.notes.grammar.NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE, NOTES_6_0_0);
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule NOTES_6 = new org.emftext.language.notes.resource.notes.grammar.NotesRule(org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(), NOTES_6_0, org.emftext.language.notes.resource.notes.grammar.NotesCardinality.ONE);
	
	public final static org.emftext.language.notes.resource.notes.grammar.NotesRule[] RULES = new org.emftext.language.notes.resource.notes.grammar.NotesRule[] {
		NOTES_0,
		NOTES_1,
		NOTES_2,
		NOTES_3,
		NOTES_4,
		NOTES_5,
		NOTES_6,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.language.notes.resource.notes.grammar.NotesRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.language.notes.resource.notes.grammar.NotesKeyword) {
			keywords.add(((org.emftext.language.notes.resource.notes.grammar.NotesKeyword) element).getValue());
		} else if (element instanceof org.emftext.language.notes.resource.notes.grammar.NotesBooleanTerminal) {
			keywords.add(((org.emftext.language.notes.resource.notes.grammar.NotesBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.language.notes.resource.notes.grammar.NotesBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.language.notes.resource.notes.grammar.NotesEnumerationTerminal) {
			org.emftext.language.notes.resource.notes.grammar.NotesEnumerationTerminal terminal = (org.emftext.language.notes.resource.notes.grammar.NotesEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
