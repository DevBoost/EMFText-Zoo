SYNTAXDEF tvl
FOR <http://www.emftext.org/language/threevaluedlogic>
START And, Or, Negation

OPTIONS {
	backtracking = "true";
	memoize = "true";
	reloadGeneratorModel = "true";
	tokenspace = "1";
}

RULES {
	And      ::= children:Or ("AND" children)*;
	Or       ::= (children:Negation,Nested, Constant) ("OR" children)*;
	Negation ::= "NOT" body:Nested, Constant;
	Nested   ::= "(" body:And ")";
	Constant ::= value[];
}