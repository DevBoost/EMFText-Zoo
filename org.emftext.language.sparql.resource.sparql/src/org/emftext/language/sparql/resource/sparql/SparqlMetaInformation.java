package org.emftext.language.sparql.resource.sparql;

public class SparqlMetaInformation extends org.emftext.runtime.resource.impl.AbstractTextResourcePluginMetaInformation {
	
	public class TokenStyleImpl extends org.emftext.runtime.resource.impl.AbstractTokenStyle {
		
		private int[] color;
		private boolean bold;
		private boolean italic;
		private boolean strikethrough;
		private boolean underline;
		
		public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {
			super();
			this.color = color;
			this.bold = bold;
			this.italic = italic;
			this.strikethrough = striketrough;
			this.underline = underline;
		}
		
		public int[] getColorAsRGB() {
			return color;
		}
		
		public boolean isBold() {
			return bold;
		}
		
		public boolean isItalic() {
			return italic;
		}
		
		public boolean isStrikethrough() {
			return strikethrough;
		}
		
		public boolean isUnderline() {
			return underline;
		}
	}
	
	public class BracketPair extends org.emftext.runtime.resource.impl.AbstractBracketPair {
		
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
	
	public java.lang.String getSyntaxName() {
		return "sparql";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/sparql";
	}
	
	public org.emftext.runtime.resource.ITextScanner createLexer() {
		return new org.emftext.language.sparql.resource.sparql.SparqlAntlrScanner(this, new org.emftext.language.sparql.resource.sparql.SparqlLexer());
	}
	
	public org.emftext.runtime.resource.ITextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.sparql.resource.sparql.SparqlParser().createInstance(inputStream, encoding);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getSparqlQueries(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getPrologue(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getBaseDecl(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getPrefixDecl(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getIRI_REF_STRING(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getPNAME_NS(),
			org.emftext.language.sparql.SparqlPackage.eINSTANCE.getINTEGER(),
		};
	}
	
	public org.emftext.runtime.resource.IReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.sparql.resource.sparql.SparqlReferenceResolverSwitch();
	}
	
	public org.emftext.runtime.resource.ITokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.sparql.resource.sparql.SparqlTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.sparql/metamodel/sparql.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.sparql.resource.sparql.SparqlParser(null).getTokenNames();
	}
	
	public org.emftext.runtime.resource.ITokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("BASE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("PREFIX".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if (":".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		return null;
	}
	
	public java.util.Collection<org.emftext.runtime.resource.IBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.runtime.resource.IBracketPair> result = new java.util.ArrayList<org.emftext.runtime.resource.IBracketPair>();
		return result;
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
		};
	}
	
	public org.emftext.runtime.resource.IHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.sparql.resource.sparql.SparqlHoverTextProvider();
	}
	
}
