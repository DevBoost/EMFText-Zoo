SYNTAXDEF pico
FOR <http://www.emftext.org/language/pico>
START Program

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE PICOID $('a'..'z')('a'..'z'|'0'..'9')*$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {

	Natural ::= "natural";
	
	String ::= "string";
	
	Nil ::= "nil";
	
	Program ::= "begin" declarations statements (";" statements)* "end" ;
	
	Declarations ::= "declare" idTypes ("," idTypes)* ";" ;
	
	IDType ::= picoID[PICOID] ":" type ;
	
	
	Assignment::= left[PICOID] ":=" right;
	
	IfStatement::= "if" condition "then" then* "else" else* "fi";
	
	WhileStatement::= "while" condition "do" body* "od";
	
	VariableReference ::= variable[PICOID];
	
	// TODO add other expressions
}