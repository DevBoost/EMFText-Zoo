@SuppressWarnings(noRuleForMetaClass)
SYNTAXDEF calc
FOR <http://www.emftext.org/language/calc>
START Calculation

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE IDENT $('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*$;
	DEFINE NUMBER $('0'..'9')+(('.'|',')('0'..'9')*)?$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')+$;
	DEFINE LINEBREAKS $('\r'|'\n')+$;
	DEFINE COMMENT $'//'.*('\r'|'\n')+$;
}

RULES {
	Calculation ::= 
		"input" inputVariables*
		"output" outputVariables*
		rules*;
		
	Variable ::= type[IDENT] name[IDENT];
	
	Rule ::= ("wenn" condition)? assignment;
	
	Assigment ::= left[IDENT] "=" right;
	
	@Operator(type="unary_prefix", weight="8", superclass="Expression")	
	Negation      ::= "-" body;
	@Operator(type="primitive", weight="9", superclass="Expression")
	Compound      ::= "(" body ")";
	@Operator(type="primitive", weight="9", superclass="Expression")
	FunctionCall  ::= name[IDENT] "(" (arguments (";" arguments)*)? ")";

	@Operator(type="binary_left_associative", weight="6", superclass="Expression")
	Additive      ::= left operator[PLUS : "+", MINUS : "-"] right;

	@Operator(type="binary_left_associative", weight="7", superclass="Expression")
	Multiplictive ::= left operator[MUL : "*", DIV : "/"] right;

	@Operator(type="binary_left_associative", weight="5", superclass="Expression")
	Compare       ::= left operator[EQ : "==", LT : "<", LTE : "<=", GT : ">", GTE : ">="] right;

	@Operator(type="binary_left_associative", weight="4", superclass="Expression")
	Or ::= left "oder" right;

	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	And ::= left "und" right;

	@Operator(type="primitive", weight="9", superclass="Expression")
	NumberLiteral ::= value[NUMBER];

	@Operator(type="primitive", weight="9", superclass="Expression")
	StringLiteral ::= value['"','"'];

	@Operator(type="primitive", weight="9", superclass="Expression")
	VariableReference ::= variable[IDENT];
}