SYNTAXDEF tvl
FOR <http://www.emftext.org/language/threevaluedlogic>
START And, Or, Negation

OPTIONS {
	backtracking = "true";
	memoize = "true";
	reloadGeneratorModel = "true";
}

RULES {
	And      ::= children:Or ("AND" children)*;
	Or       ::= children:Negation ("OR" children)*;
	Negation ::= "NOT" body;
	Constant ::= value[];
}