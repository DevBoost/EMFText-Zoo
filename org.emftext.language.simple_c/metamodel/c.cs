SYNTAXDEF c
FOR <http://www.emftext.org/simple_c>
START CompilationUnit

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
	forceEOF = true;
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