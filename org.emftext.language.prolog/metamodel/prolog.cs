SYNTAXDEF pl
FOR <http://www.emftext.org/language/prolog>
START PrologProgram


OPTIONS {
	usePredefinedTokens = "false";
	//defaultTokenName = "IDENTIFIER";
	reloadGeneratorModel = "true";
}


TOKENS {
	//DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE FRAGMENT DIGIT $('0'..'9')$;
	DEFINE FLOAT $('-')?(('1'..'9') ($ + DIGIT + $)* | '0') ('.' ($ + DIGIT + $)+)? $;
	DEFINE FRAGMENT UPPER $('A'..'Z')$;
	DEFINE FRAGMENT LOWER $('a'..'z')$;
	DEFINE FRAGMENT SPECIAL $('+'|'-'|'*'|'/'|'_')$;
	DEFINE FRAGMENT CHAR $($ + LOWER + $ | $ + UPPER + $ | $ + DIGIT + $ | $ + SPECIAL + $)$;
	DEFINE CAPITAL_WORD UPPER + CHAR + $*$;
	DEFINE SMALL_WORD   LOWER + CHAR + $*$;
	DEFINE ANONYMOUS $'_'($ + CAPITAL_WORD + $)?$;
	DEFINE SL_COMMENT $'%'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	PrologProgram ::= clauses+;
	Clause ::= predicate ( ":-" predicateList)? ".";
	PredicateList ::= predicate ("," predicate)*;
	Predicate ::= atom ("("termList")")?;
	TermList ::= term ("," term)*;
	Numeral ::= value[FLOAT];
	Variable ::= name[CAPITAL_WORD];
	AnonymousVariable ::= text[ANONYMOUS];
	Structure ::= atom "("termList")";
	SmallAtom ::= text[SMALL_WORD];
	String ::= text['\'','\''];
	VariableReference ::= variable[CAPITAL_WORD];
}