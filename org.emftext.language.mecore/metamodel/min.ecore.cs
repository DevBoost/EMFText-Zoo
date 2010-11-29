@SuppressWarnings(tokenOverlapping)
SYNTAXDEF min.ecore
FOR <http://www.emftext.org/language/mecore> <mecore.genmodel>
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
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"UPPER" COLOR #000000, BOLD;
	"COMMENT" COLOR #404040;
} 

RULES {
	MPackage ::= (name[LOWER])? namespace['<','>'] contents*;
	MClass   ::= abstract["abstract" : ""]
	             name[UPPER]
	             (":" supertypes[UPPER] ("," supertypes[UPPER])* )? 
	             ("(" features* ")")? ;
	MEnum    ::= "enum" name[UPPER] ("(" literals* ")")?;
	MEnumLiteral ::= name[UPPER] literal['"','"']?;
	MFeature ::= reference["~" : ""] name[LOWER] (type[UPPER]|type[LOWER]) multiplicity?;
	
	MSimpleMultiplicity ::= value[star : "*", optional : "?", plus : "+"];
	MComplexMultiplicity ::= "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")";
}