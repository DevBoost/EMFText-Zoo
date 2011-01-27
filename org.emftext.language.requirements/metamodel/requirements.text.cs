SYNTAXDEF requirements
FOR <http://www.emftext.org/requirements>
START RequirementsSpec

OPTIONS {
	usePredefinedTokens = "false";
}


TOKENS {
	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
		
	DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '::')+$;
}


TOKENSTYLES {
	"STRING_LITERAL" COLOR #2A00FF;
	"TEXT" COLOR #000000;
	
	"Requirements" COLOR #7F0055, BOLD;
	"Documentation" COLOR #7F0055, BOLD;
	"customer" COLOR #7F0055, BOLD;
	"Categories" COLOR #7F0055, BOLD;
	"Components" COLOR #7F0055, BOLD;
	"component" COLOR #7F0055, BOLD;
	"related to" COLOR #7F0055, BOLD;
	"import" COLOR #7F0055, BOLD;
	"priority" COLOR #7F0055, BOLD;
	"+" COLOR #798f02, BOLD;
	"++" COLOR #e08400, BOLD;
	"+++" COLOR #ec3a0a, BOLD;
	
}


RULES {
	RequirementsSpec ::= "Requirements" "Documentation" 
							name[STRING_LITERAL] 
							("import" imports['<','>'] ";")*
							("customer" customer[STRING_LITERAL] )?
							description['(',')']?
							("Categories" "{"
								categories+
							"}")?
							("Components" "{"
								components+
							"}")?
							("Requirements" "{"
								requirements+
							"}")?;
							
	Requirement ::= id[] ":" name[] ( "[" category[] ("," category[])* "]")?
					 priority[
					 	low : "+",
					 	medium : "++",
					 	high : "+++"
					 ] "priority"
					description['(', ')'] 
					("component" realisingComponent[])?
					("related to" "[" related[] ("," related[])* "]")?;
	
	Category ::= name[] description[STRING_LITERAL];
	Component ::= name[] description[STRING_LITERAL];
}