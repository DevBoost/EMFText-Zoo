SYNTAXDEF pr
FOR <http://www-st.inf.tu-dresden.de/tornado2/textual_rules/test/annProject>
START AProject

IMPORTS {
    project : <http://www.emftext.org/language/project> WITH SYNTAX project <../../org.emftext.language.project/metamodel/project.cs>
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
    "COMMENT" COLOR #008000;
}

RULES {
    AProject    ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    AConnection ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    ATrain      ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    APort       ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
    AComponent  ::= (identifier[IDENT] | identifier[IDENT2])+ body ;
}