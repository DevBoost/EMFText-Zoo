//
// this is an implementation of RFC2234 - Augmented Backus Naur Form
// see http://www.ietf.org/rfc/rfc2234.txt for details
//
SYNTAXDEF abnf
FOR <http://www.emftext.org/language/abnf>
START RuleSet

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE RULENAME $('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'-')*$;
	DEFINE STAR $'*'$;
	DEFINE INT  $('0'..'9')+$;
	
	//DEFINE CRLF $'\r''n'|'\r'|'n'$;
	
	DEFINE CNL $(';'((' '|'\t') | ('!'..'~'))*('\r\n'|'\r'|'\n')) | ('\r\n'|'\r'|'\n')$; // comment or new line
	DEFINE CWSP $(' '|'\t') | (';'((' '|'\t') | ('!'..'~'))*('\r\n'|'\r'|'\n') | ('\r\n'|'\r'|'\n') (' '|'\t'))$;
	//DEFINE COMMENT $';'((' '|'\t') | ('!'..'~'))*('\r''n'|'\r'|'n')$;

	//DEFINE VCHAR $'!'..'~'$; // visible (printing) characters

	// WSP =  SP / HTAB
	// SP  = ' '
	// HTAB = '\t'
}

RULES {
	
	RuleSet ::= (rules | (whitespace[CWSP]* whitespace[CNL]))+;
	
	Rule    ::= 
		name[RULENAME] whitespace[CWSP]* "="  whitespace[CWSP]* (alternatives whitespace[CWSP]*)* comment[CNL]; // CRLF
		
	IncrementalAlternativRule ::= 
		name[RULENAME] whitespace[CWSP]* "=/" whitespace[CWSP]* (alternatives whitespace[CWSP]*)* comment[CNL]; // CRLF
	
	RuleReference ::= rule[RULENAME];
	
	Alternative ::= alternatives ("/" alternatives)*;
	OptionalSequence ::= "[" elements* "]";
	
	Group ::= "(" elements* ")";
	
	BinaryTerminal      ::= "%b" value[INT];
	DecimalTerminal     ::= "%d" value[INT];
	HexadecimalTerminal ::= "%x" value[INT];
	StringTerminal      ::= value['"','"'];
	
	Multiplicity ::= (lowerBound[INT])? (repeat[STAR])? (upperBound[INT])?;
}