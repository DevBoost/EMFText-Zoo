SYNTAXDEF webtest
FOR <http://www.emftext.org/language/webtest>
START TestScript


OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "IDENTIFIER";
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	TestScript ::= "testScript" commands*;
	Load ::= "load" url['<','>'];
	Submit ::= "submit" form[];
	Input ::= "input" form[] field[] value['"','"'];
	AssertTitle ::= "assertTitle" expected['"','"'];
}