package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classMetaInformation implements org.emftext.language.uml_class.resource.uml_class.IUml_classMetaInformation {
	
	public class TokenStyleImpl implements org.emftext.language.uml_class.resource.uml_class.IUml_classTokenStyle {
		
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
	
	public class BracketPair implements org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair {
		
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
		return "uml_class";
	}
	
	public java.lang.String getURI() {
		return "http://org.emftext/uml_class";
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTextScanner createLexer() {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classAntlrScanner(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classLexer());
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classParser().createInstance(inputStream, encoding);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getClassDiagramm(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getMethod(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getAttribute(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getParameter(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getClass_(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getAssociation(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getBoolean(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getString(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getInteger(),
			org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getPrimitiveDataType(),
			org.emftext.language.primitive_types.Primitive_typesPackage.eINSTANCE.getBooleanObject(),
			org.emftext.language.primitive_types.Primitive_typesPackage.eINSTANCE.getIntegerObject(),
			org.emftext.language.primitive_types.Primitive_typesPackage.eINSTANCE.getStringObject(),
		};
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classReferenceResolverSwitch();
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.uml_class/metamodel/uml_class.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classParser(null).getTokenNames();
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("classdiagramm".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("ac".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("md".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("void".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("class".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("extends".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("attribute".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("method".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("association".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("p".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("..".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if (":".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xCC}, true, false, false, false);
		}
		if ("BOOLEAN".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xBB, 0xCC}, true, false, false, false);
		}
		if ("STRING".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xBB, 0xCC}, true, false, false, false);
		}
		if ("INTEGER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xBB, 0xCC}, true, false, false, false);
		}
		if ("TYPE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xBB, 0xCC}, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
	public java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair> result = new java.util.ArrayList<org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
		};
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classHoverTextProvider();
	}
	
}
