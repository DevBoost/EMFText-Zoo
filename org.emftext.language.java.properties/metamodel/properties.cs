SYNTAXDEF propjava
FOR <http://www.emftext.org/language/java/properties>
START java.Containers.CompilationUnit

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T_READONLY $'readonly'$;
}

TOKENSTYLES {
	"T_READONLY" COLOR #7F0055, BOLD;
}

RULES {
	Property ::= ( readonly[T_READONLY] )? "property" typeReference name[];
}