SYNTAXDEF fj 
FOR <http://www.emftext.org/language/featherweight_java>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
	backtracking = "true";
	memoize = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"class"   COLOR #7F0055, BOLD;
	"extends" COLOR #7F0055, BOLD;
	"new"     COLOR #7F0055, BOLD;
	"return"  COLOR #7F0055, BOLD;
	"this"    COLOR #7F0055, BOLD;
	"super"   COLOR #7F0055, BOLD;
}

RULES {
	Class  ::= "class" name[] "extends" superclass[] "{" 
			members* 
		"}";
		
	Constructor ::= name[] "(" (parameters ("," parameters)*)? ")" "{" 
			"super" "(" ")" ";"
			initialisations*
		"}";
		
	Parameter ::= type[] name[];
	FieldInitialisiation ::= "this" "." field[] "=" parameter[] ";";
	Method ::= returnType[] name[] "(" (parameters ("," parameters)*)? ")" "{" "return" returnValue ";" "}";
	Field  ::= type[] name[] ";";
	
	// expressions
	ConstructorCall ::= "new" type[] "(" (arguments ("," arguments)*)? ")";
	FieldAccess     ::= expression : FieldAccessChild "." field[];
	MethodCall      ::= method[] "(" ")";
	This            ::= "this";
	ParameterAccess ::= parameter[];
	Cast            ::= "(" type[] ")" expression;
}