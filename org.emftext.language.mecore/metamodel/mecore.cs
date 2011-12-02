@SuppressWarnings(tokenOverlapping,noRuleForMetaClass,minOccurenceMismatch)
SYNTAXDEF mecore
FOR <http://www.emftext.org/language/mecore> <mecore.genmodel>
START MPackage

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	usePredefinedTokens = "false";
	overrideBuilder = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	
	additionalDependencies = "org.eclipse.emf.codegen.ecore";
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
	"QUOTED_60_62", "<>" COLOR #0080C0, BOLD;
} 

RULES {
	MPackage ::= (name[LOWER])? namespace['<','>'] (!0 imports)* (!0 contents)*;
	MImport  ::= "import" importedPackage['<','>'] "as" prefix[LOWER];

	@SuppressWarnings(optionalKeyword)
	MClass   ::= abstract["abstract" : ""] 
				 interface["interface" : ""]
	             name[UPPER]
	             (":" supertypes[UPPER] ("," supertypes[UPPER])* )? 
	             ("(" features* operations* ")")? ;
	             
	@SuppressWarnings(featureWithoutSyntax, optionalKeyword)
	MEnum    ::= "enum" name[UPPER] ("(" literals* ")")?;
	MEnumLiteral ::= name[UPPER] literal['"','"']?;
	
	@SuppressWarnings(explicitSyntaxChoice)
	MFeature ::= ncReference["~" : ""] name[LOWER] (type[UPPER]|type[LOWER]) multiplicity? ("<>" opposite[UPPER])?;
	MOperation ::= name[LOWER] "(" (parameters ("," parameters)*)? ")" type[UPPER]  multiplicity?;
	MParameter ::= name[LOWER] type[UPPER] multiplicity?;
	
	MSimpleMultiplicity ::= value[star : "*", optional : "?", plus : "+"];
	MComplexMultiplicity ::= "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")";
}