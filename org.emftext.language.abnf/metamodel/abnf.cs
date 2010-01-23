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
	DEFINE STAR $'*'$;
	DEFINE DIGIT $('0'..'9')$;
	DEFINE DIGITS $($ + DIGIT + DIGIT + $)$;
	DEFINE FRAGMENT HEXDIGIT $($ + DIGIT + $|'a'..'f'|'A'..'F'$ + $)$;
	DEFINE HEXDIGITS HEXDIGIT + HEXDIGIT;
	DEFINE RULENAME $('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'-')*$;
	
	DEFINE FRAGMENT CRLF    $('\r\n'|'\r'|'\n')$;
	DEFINE FRAGMENT SP      $' '$;
	DEFINE FRAGMENT HTAB    $'\t'$;
	DEFINE FRAGMENT WSP     $($ + SP + $|$ + HTAB + $)$;
	DEFINE FRAGMENT VCHAR   $('!'..'~')$; // visible (printing) characters
	DEFINE FRAGMENT COMMENT $(';'($ + WSP + $|$ + VCHAR + $)*$ + CRLF + $)$; 
	DEFINE CNL  COMMENT + $|$ + CRLF; // comment or new line
	DEFINE CWSP WSP     + $|$ + COMMENT + $|$ + CRLF + WSP + $$;
}

TOKENSTYLES {
	"RULENAME" COLOR #000080, BOLD;
	"QUOTED_34_34" COLOR #606060;
	"CWSP" COLOR #008000;
	"CNL" COLOR #008000;
	"%x" COLOR #A000A0;
	"%b" COLOR #A000A0;
	"%d" COLOR #A000A0;
	"DIGITS" COLOR #A000A0;
	"HEXDIGITS" COLOR #A000A0;
}

RULES {
	
	RuleSet ::= (rules | (whitespace[CWSP]* whitespace[CNL]))+;
	
	Rule    ::= 
		name[RULENAME] whitespace[CWSP]* "="  whitespace[CWSP]* (alternatives whitespace[CWSP]*)* comment[CNL]; // CRLF
		
	IncrementalAlternativRule ::= 
		name[RULENAME] whitespace[CWSP]* "=/" whitespace[CWSP]* (alternatives whitespace[CWSP]*)* comment[CNL]; // CRLF
	
	RuleReference ::= rule[RULENAME];
	
	Alternative ::= concatenation (whitespace[CWSP]* "/" whitespace[CWSP]* concatenation)*;

	//alternation    =  concatenation
    //              *(*c-wsp "/" *c-wsp concatenation)

	Concatenation ::= repetition (whitespace[CWSP]+ repetition)*;

	Repetition ::= (repeat)? element;
	// element        =  rulename / group / option / char-val / num-val / prose-val

	OptionalSequence ::= "[" whitespace[CWSP]* alternatives* whitespace[CWSP]* "]";
	
	Group ::= "(" whitespace[CWSP]* alternatives* whitespace[CWSP]* ")";
	
	BinaryTerminal      ::= "%b" value[DIGITS] tail?;
	DecimalTerminal     ::= "%d" value[DIGITS] tail?;
	HexadecimalTerminal ::= "%x" (value[HEXDIGITS]|value[DIGITS]) tail?;
	DecRangeEnd            ::= "-" value[DIGITS];
	HexRangeEnd            ::= "-" (value[HEXDIGITS]|value[DIGITS]);
	AdditionalDecTerminal  ::= "." value[DIGITS] tail?;
	AdditionalHexTerminal  ::= "." (value[HEXDIGITS]|value[DIGITS]) tail?;
	StringTerminal      ::= value['"','"'];
	
	Multiplicity ::= (lowerBound[DIGIT])? (repeat[STAR])? (upperBound[DIGIT])?;
}