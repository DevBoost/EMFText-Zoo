SYNTAXDEF treejava
FOR <http://www.emftext.org/language/treejava>
START java.Containers.CompilationUnit
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

RULES {
	Node ::= "#"  typeReference name[]? ( ">" "(" children+ ")" )?;
}