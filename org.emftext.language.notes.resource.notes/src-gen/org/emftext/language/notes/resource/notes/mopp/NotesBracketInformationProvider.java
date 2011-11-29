/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.notes.resource.notes.INotesBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.notes.resource.notes.INotesBracketPair> result = new java.util.ArrayList<org.emftext.language.notes.resource.notes.INotesBracketPair>();
		result.add(new BracketPair("[", "]", false));
		return result;
	}
	
}
