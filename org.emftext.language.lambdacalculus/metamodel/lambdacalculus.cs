SYNTAXDEF lambda
FOR <http://www.emftext.org/language/lambdacalculus>
START Expr

RULES {
	BoundVar ::= name[];

	FreeVar ::= name[];

	@Operator(superclass="Expr", weight="1", type="binary_left_associative")
	Appl ::= "(" function argument ")";

	@Operator(superclass="Expr", weight="1", type="binary_left_associative")
	Abstr ::= "(\\" body "." boundVar ")";
	
	@Operator(superclass="Expr", weight="1", type="primitive")
	Ref ::= refersTo[];
}