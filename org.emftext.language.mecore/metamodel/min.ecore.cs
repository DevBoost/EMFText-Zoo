@SuppressWarnings(tokenOverlapping)
SYNTAXDEF min.ecore
FOR <http://www.emftext.org/language/mecore>
START MPackage

OPTIONS {
	baseResourcePlugin = "org.emftext.language.ecore.resource";
	resourcePluginID = "org.emftext.language.ecore.resource.mecore";
	basePackage = "org.emftext.language.ecore.resource.mecore";
	resourceUIPluginID = "org.emftext.language.ecore.resource.mecore.ui";
	uiBasePackage = "org.emftext.language.ecore.resource.mecore.ui";
	
	overrideResourceFactory = "false";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE INTEGER $('-')?('0'..'9')+$;
	DEFINE UPPER $('A'..'Z')('a'..'z'|'A'..'Z')*$;
	DEFINE LOWER $('a'..'z')('a'..'z'|'A'..'Z')*$;
	DEFINE WHITESPACES $(' '|'\t'|'\f')+$;
	DEFINE LINEBREAKS $('\r'|'\n')+$;
}

RULES {
	MPackage ::= (name[LOWER])? namespace['<','>'] contents*;
	MClass   ::= name[UPPER] ("(" features* ")")?;
	MFeature ::= name[LOWER] ":" (type[UPPER]|type[LOWER]) multiplicity?;
	
	MSimpleMultiplicity ::= value[star : "*", optional : "?", plus : "+"];
	MComplexMultiplicity ::= "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")";
}