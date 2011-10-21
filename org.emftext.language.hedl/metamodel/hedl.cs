@SuppressWarnings(noRuleForMetaClass)

SYNTAXDEF hedl
FOR <http://www.emftext.org/language/hedl>
START EntityModel

OPTIONS {
	disableLaunchSupport = "true";
	usePredefinedTokens = "false";
	overrideBuilder = "false";
	additionalDependencies = "org.eclipse.emf.workspace,org.emftext.language.hedl.codegen";
}

TOKENS {
	DEFINE UPPER $('A'..'Z')('A'..'Z'|'a'..'z'|'0'..'9'|'_')*$;
	DEFINE LOWER $('a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'_')*$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')+$;
	DEFINE LINEBREAK  $('\r'|'\n')+$;
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE ML_COMMENT $'/**'.*'*/'$;
}

TOKENSTYLES {
	"UPPER" COLOR #000000, BOLD;
}

RULES {
	EntityModel ::= (entities | enums)*;
	
	Entity ::= name[UPPER] "{" properties* "}";
	
	Property ::= 
		readonly["readonly" : ""] 
		nullable["nullable" : ""] 
		unique["unique" : ""] 
		type[UPPER]
		name[LOWER] 
		";";
		
	Enum ::= "enum" name[UPPER] "{" literals* "}";
	
	EnumLiteral ::= comment[ML_COMMENT]? name[UPPER];
}