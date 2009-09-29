SYNTAXDEF pn
FOR <http://www-st.inf.tu-dresden.de/tornado2/textual_rules/test/annPetrinet>
START APetriNet

IMPORTS {
    petrinet : <http://www.emftext.org/language/petrinet> WITH SYNTAX petrinet <../../org.emftext.language.petrinet/metamodel/petrinet.cs>
}

OPTIONS {
    //reloadGeneratorModel = "true";
    //generateCodeFromGeneratorModel = "true";
}

TOKENS {
    //DEFINE T_TYPE $'++'$;
    DEFINE IDENT2 $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+'++'$;
    DEFINE IDENT $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
}

TOKENSTYLES {
    "IDENT" COLOR #000000, BOLD;
    "IDENT2" COLOR #00BB00, BOLD;
    //"T_TYPE" COLOR #00BB00, BOLD;
    "COMMENT" COLOR #008000;
}

RULES {
    APetriNet ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    AArc      ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    ANode     ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    AToken    ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
}