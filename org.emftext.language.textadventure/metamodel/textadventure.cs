SYNTAXDEF tas // tas = Text Adventure Specification
FOR <http://www.emftext.org/language/textadventure>
START Adventure

OPTIONS {
	reloadGeneratorModel = "true";
	tokenspace = "1";
	overrideManifest = "false";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"ADVENTURE" COLOR #000000, BOLD;
	"ROOM" COLOR #000000, BOLD;
	"CONTAINS" COLOR #000000, BOLD;
	"DOOR" COLOR #000000, BOLD;
	"BETWEEN" COLOR #000000, BOLD;
	"AND" COLOR #000000, BOLD;
	"STAIRS" COLOR #000000, BOLD;
	"FROM" COLOR #000000, BOLD;
	"TO" COLOR #000000, BOLD;
	"FROM" COLOR #000000, BOLD;
	"KEY" COLOR #000000, BOLD;
	"FOR" COLOR #000000, BOLD;
	
	"TEXT" COLOR #000000;
	"COMMENT" COLOR #00bb00, ITALIC;
}

RULES {
	Adventure ::= "ADVENTURE" name['"','"'] elements*;
	Room ::= "ROOM" name[] ("CONTAINS" items ("," items)*)?;
	Door ::= "DOOR" (name[])? "BETWEEN" from[] "AND" to[];
	Stairs ::= "STAIRS" "FROM" from[] "TO" to[];
	Item ::= name[];
	Key ::= "KEY" (name[])? "FOR" opens[];
}