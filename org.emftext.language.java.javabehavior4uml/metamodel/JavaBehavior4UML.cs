SYNTAXDEF javabehavior
FOR <http://www.emftext.org/javaBehavior4UML>
START JavaMethodBehavior

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
    tokenspace = "1";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

TOKENSTYLES {
	"ML_COMMENT" COLOR #008000, ITALIC;
	"SL_COMMENT" COLOR #000080, ITALIC;
	"STRING_LITERAL" COLOR #2A00FF;
	"IDENTIFIER" COLOR #000000;
}

RULES{
	JavaMethodBehavior ::=	
        (imports !0 )*
        !0
        javaMethod
    ;
}