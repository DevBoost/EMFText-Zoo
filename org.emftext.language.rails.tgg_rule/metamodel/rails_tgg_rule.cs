SYNTAXDEF rails_tgg_rule
FOR <http://www.emftext.org/language/rails/tgg_rule>
START AnnotatedProject

IMPORTS {
    project : <http://www.emftext.org/language/rails> WITH SYNTAX rails <../../org.emftext.language.rails/metamodel/rails.cs>
}

OPTIONS {
    //reloadGeneratorModel = "true";
    //generateCodeFromGeneratorModel = "true";
    resourcePluginID = "org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule";
    basePackage = "org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
    DEFINE T_TYPE $'++'$;
    DEFINE IDENT $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
}

TOKENSTYLES {
    "IDENT" COLOR #000000, BOLD;
	"T_TYPE" COLOR #00BB00, BOLD;
    "COMMENT" COLOR #008000;
}

RULES {
	TGGRuleAnnotation ::= (identifiers[IDENT])+ (type[T_TYPE])?;
    AnnotatedProject    ::= annotation body ;
    AnnotatedConnection ::= annotation body ;
    AnnotatedTrain      ::= annotation body ;
    AnnotatedPort       ::= annotation body ;
    AnnotatedComponent  ::= annotation body ;
}