@SuppressWarnings(tokenOverlapping)
SYNTAXDEF mecore
FOR <http://www.emftext.org/language/mecore> <mecore.genmodel>
START MPackage

OPTIONS {
	//baseResourcePlugin = "org.emftext.language.mecore.resource";
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	resourcePluginID = "org.emftext.language.mecore.resource.mecore";
	basePackage = "org.emftext.language.mecore.resource.mecore";
	resourceUIPluginID = "org.emftext.language.mecore.resource.mecore.ui";
	uiBasePackage = "org.emftext.language.mecore.resource.mecore.ui";
	
	usePredefinedTokens = "false";
	overrideBuilder = "false";
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
	"abstract" COLOR #800040, BOLD;
	"COMMENT" COLOR #404040;
} 

RULES {
	MPackage ::= (name[LOWER])? namespace['<','>'] (!0 contents)*;
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