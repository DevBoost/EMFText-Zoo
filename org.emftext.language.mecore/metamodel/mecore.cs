@SuppressWarnings(tokenOverlapping,noRuleForMetaClass)
SYNTAXDEF mecore
FOR <http://www.emftext.org/language/mecore> <mecore.genmodel>
START MPackage

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	usePredefinedTokens = "false";
	overrideBuilder = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE INTEGER $('-')?('0'..'9')+$;
	DEFINE UPPER $('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'.')*$;
	DEFINE LOWER $('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'.')*$;
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
	MPackage ::= (name[LOWER])? namespace['<','>'] (!0 imports)* (!0 contents)*;
	MImport  ::= "import" importedPackage['<','>'] "as" prefix[LOWER];
	MClass   ::= abstract["abstract" : ""] 
				 interface["interface" : ""]
	             name[UPPER]
	             (":" supertypes[UPPER] ("," supertypes[UPPER])* )? 
	             ("(" features* operations* ")")? ;
	MEnum    ::= "enum" name[UPPER] ("(" literals* ")")?;
	MEnumLiteral ::= name[UPPER] literal['"','"']?;
	MFeature ::= ncReference["~" : ""] name[LOWER] (type[UPPER]|type[LOWER]) multiplicity? ("<>" opposite[UPPER])?;
	MOperation ::= name[LOWER] "(" (parameters ("," parameters)*)? ")" type[UPPER]  multiplicity?;
	MParameter ::= name[LOWER] type[UPPER] multiplicity?;
	
	MSimpleMultiplicity ::= value[star : "*", optional : "?", plus : "+"];
	MComplexMultiplicity ::= "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")";
}