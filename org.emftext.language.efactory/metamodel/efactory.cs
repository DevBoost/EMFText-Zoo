SYNTAXDEF efactory
FOR <http://www.googlecode.com/efactory/EFactory>
START Factory

IMPORTS {
	somePrefix : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	overrideBuilder = "false";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE LONG $('-')?('0'..'9')+$;
	DEFINE DOUBLE $('-')?('0'..'9')+'.'('0'..'9')+$;
	DEFINE DATE $('0'..'1')'0'..'9''.''0'..'3''0'..'9''.' '0'..'9''0'..'9''0'..'9''0'..'9'$;
	DEFINE PLUS_EQUALS $'+''='$;
	DEFINE EQUALS $'='$;
	DEFINE BOOLEAN $'true'|'false'$;
	DEFINE STRING $('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')$;
	
	@SuppressWarnings(tokenOverlapping)
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')*$;
	
	@SuppressWarnings(unusedToken)
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	@SuppressWarnings(unusedToken)
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	@SuppressWarnings(unusedToken)
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"SL_COMMENT" COLOR #00A000;
}

RULES {
	Factory ::= epackages+ imports* annotations* root;

	PackageImport::= "use" ePackage[STRING] ("as" alias[IDENTIFIER])?;

	Import ::= "import" importURI[STRING];

	GlobalNameMapping ::= "@Name" "{" nameFeature[IDENTIFIER] "}";
	CustomNameMapping ::= "@Name" "{" eClass[IDENTIFIER] "=" nameFeature[IDENTIFIER] "}";
	
	Feature ::= eFeature[IDENTIFIER] (isMany[PLUS_EQUALS] | isMany[EQUALS]) value;
	
	NewObject ::= "new" eClass[IDENTIFIER] (name[IDENTIFIER])? ("{" features* "}")?;
	
	Reference ::= value[IDENTIFIER];
	Containment ::= value;

	EnumAttribute ::= ":" value[STRING];
	StringAttribute ::= value[STRING];
	IntegerAttribute ::= value[LONG];
	DoubleAttribute ::= value[DOUBLE];
	DateAttribute ::= value[DATE];
	NullAttribute ::= "NULL";

	BooleanAttribute ::= value[BOOLEAN];	
}