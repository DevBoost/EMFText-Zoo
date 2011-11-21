SYNTAXDEF functions
FOR <http://www.emftext.org/functions>
START FunctionSet

OPTIONS {
	usePredefinedTokens = "false";
	additionalDependencies = "org.eclipse.emf.workspace,org.eclipse.ui.console,org.eclipse.jface,org.emftext.language.functions.generators";
	
	overrideBuilder = "false";
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
	FunctionSet ::= name[] ("{" elements* "}" | subsets*);
	Function ::= 
		ignored["ignored" : ""] 
		"function" name[] (":" parent[])? (costs[])?
		("->" relatedTo[]*)?
		(description['"','"'])?;
		
	Property ::= "property" name[] multiple["*" : ""] (":" datatype[])? (description['"','"'])?;
	Datatype ::= 
		ignored["ignored" : ""] 
		"datatype" name[] (description['"','"'])?  properties*;
}