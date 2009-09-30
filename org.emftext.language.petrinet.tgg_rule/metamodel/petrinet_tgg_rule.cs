SYNTAXDEF petrinet.tgg_rule
FOR <http://www.emftext.org/language/petrinet_tgg_rule>
START AnnotatedPetriNet

IMPORTS {
    petrinet : <http://www.emftext.org/language/petrinet> WITH SYNTAX petrinet <../../org.emftext.language.petrinet/metamodel/petrinet.cs>
}

OPTIONS {
    //reloadGeneratorModel = "true";
    //generateCodeFromGeneratorModel = "true";
    resourcePluginID = "org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule";
    basePackage = "org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule";
}

TOKENS {
    DEFINE T_TYPE $'++'$;
    //DEFINE IDENT2 $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+'++'$;
    DEFINE IDENT $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
}

TOKENSTYLES {
    "IDENT" COLOR #000000, BOLD;
	"T_TYPE" COLOR #00BB00, BOLD;
    "COMMENT" COLOR #008000;
}

RULES {
	TGGRuleAnnotation ::= (identifiers[IDENT])+ type[T_TYPE];
    AnnotatedPetriNet ::= annotation body ;
    AnnotatedArc      ::= annotation body ;
    AnnotatedNode     ::= annotation body ;
    AnnotatedToken    ::= annotation body ;
}