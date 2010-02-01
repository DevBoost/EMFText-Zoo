/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0BracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.pl0.resource.pl0.IPl0BracketPair {
		
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
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0BracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0BracketPair> result = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.IPl0BracketPair>();
		result.add(new BracketPair("(", ")", true));
		return result;
	}
	
}
