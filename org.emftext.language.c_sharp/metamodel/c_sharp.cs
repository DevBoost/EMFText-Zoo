SYNTAXDEF cs
FOR <http://www.emftext.org/c_sharp>
START CompilationUnit

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
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