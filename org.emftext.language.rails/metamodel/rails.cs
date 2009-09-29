SYNTAXDEF rails
FOR <http://www.emftext.org/language/rails>
START Project

OPTIONS {
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"project" COLOR #000080, BOLD;
	"train" COLOR #000080, BOLD;
	"track" COLOR #000080, BOLD;
	"switch" COLOR #000080, BOLD;
	"connect" COLOR #000080, BOLD;
	"out:" COLOR #000080, BOLD;
	"in:" COLOR #000080, BOLD;
	"->" COLOR #000080, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	
	Project ::= "project" (name[])? "{" 
			components* connections*
		"}";
	
	Train ::= "train" (name[])? ; 
	
	Track ::= "track" (name[])? 
		"{" 
			ports* 
			trains* 
		"}" ;
	
	Switch ::= "switch" (name[])?
		"{" 
			ports*
			trains* 
		"}" ;
	
	Connection ::= "connect" (name[])? source[] "->" target[] ;
	
	Out ::= "out:" (name[])? ;
	
	In  ::= "in:"  (name[])? ;
}