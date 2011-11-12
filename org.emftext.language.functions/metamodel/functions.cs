SYNTAXDEF functions
FOR <http://www.emftext.org/functions>
START FunctionSet

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT $'//'.*('\r'|'\n')$;
	DEFINE LINEBREAK $('\r'|'\n')$;
	DEFINE WHITESPACE $' '|'\t'|'\f'$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'Ä'|'Ö'|'Ü'|'ä'|'ö'|'ü'|'ß')+$ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #404040;
}

RULES {
	FunctionSet ::= elements*;
	Function ::= 
		ignored["ignored" : ""] 
		"function" name[] (":" parent[])?
		("->" relatedTo[]*)? 
		(description['"','"'])?;
		
	Property ::= "property" name[] multiple["*" : ""] (":" datatype[])? (description['"','"'])?;
	Datatype ::= 
		ignored["ignored" : ""] 
		"datatype" name[] (description['"','"'])?  properties*;
}