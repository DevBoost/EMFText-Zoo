SYNTAXDEF eag
FOR <http://www.emftext.org/language/eag>
START AttributeGrammar

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE BIN_OP $'+'|'-'|'*'|'/'$;
	DEFINE ASS_OP $'+='|'='$;
}

RULES {
	AttributeGrammar ::= (!1 imports)+ (!1 attributes)+ (!1 computations)+;
	Import ::= "import" #1 importedPackage['<','>'] #1 ("as" prefix[])?;
	Attribute ::= kind[] "attribute" type[] name[];
	//Property ::= type[] name[] ";";
	Computation ::= "computation" context[] #1 "::" #1 targetAttribute[] #1 "{" !1 body !0 "}";

	Assignment ::= left operator[ASS_OP] right ";";

	Variable ::= name[];
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	Reference ::= target[];
	
	ForLoop ::= "for" "(" variable ":" collection ")" "{" body "}";
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="2")
	ExpressionChain ::= previous "." next;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="2")
	BinaryExpression ::= left operator[BIN_OP] right;
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	AttributeValue ::= targetAttribute[] "(" expression ")";

	@Operator(type="primitive", superclass="Expression", weight="20")
	ThisReference ::= "this";
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	Value ::= "value";

	//ReturnStatement ::= "return" expression ";";
}
