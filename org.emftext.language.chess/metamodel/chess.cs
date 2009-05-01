SYNTAXDEF cg
FOR <http://www.emftext.org/language/chess>
START ChessGame

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE DIGIT $'1'..'8'$;
	DEFINE CHAR  $('a'..'z')|('A'..'Z')$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"DIGIT" COLOR #000000, BOLD;
	"CHAR" COLOR #000000, BOLD;
	"COMMENT" COLOR #00bb00, BOLD;
	"-------------------------" COLOR #808080;
	"|" COLOR #808080;
	
	"MOVE" COLOR #00bbff, BOLD;
	"TO" COLOR #00bbff, BOLD;
}

RULES {
	ChessGame ::= board moves*; 
	Board ::= 
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0
		"|" rows !0
		"-------------------------" !0 
		;
	Row ::= 
		squares squares squares squares squares squares squares squares
		;
	EmptySquare ::= #2 "|";
	NonEmptySquare ::= player[CHAR] piece[CHAR] "|";
	
	Move ::= "MOVE" fromColumn[CHAR] fromRow[DIGIT] "TO" toColumn[CHAR] toRow[DIGIT];
}