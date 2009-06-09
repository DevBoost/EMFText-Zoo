SYNTAXDEF c
FOR <http://www.emftext.org/language/simple_c>
START CompilationUnit

OPTIONS {
	tokenspace = "1";
	autofixSimpleLeftrecursion = "false";
	overrideManifest = "false";
	tokenspace = "1";
}

TOKENS {
}

RULES {
	CompilationUnit ::= definitions* ;
	
	Method ::= "void" name[] "(" ")" "{" statements* "}" ;
	
	Variable ::= "int" name[] ";" ;

	Struct ::= "struct" name[] "{" "}" ;
	
	Statement ::= "return" ";";
}