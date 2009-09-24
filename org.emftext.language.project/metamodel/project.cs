SYNTAXDEF project
FOR <http://www.emftext.org/language/project>
START Project

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"plan" COLOR #7F0055, BOLD;
	"train" COLOR #7F0055, BOLD;
	"switch" COLOR #7F0055, BOLD;
	"connect" COLOR #7F0055, BOLD;
	"out:" COLOR #7F0055, BOLD;
	"in:" COLOR #7F0055, BOLD;
	"->" COLOR #7F0055, BOLD;
}

RULES {
	
	Project ::= "plan" (name['"','"'])? "{" 
			components* connections*
		"}";
	
	Train ::= "train" (name['"','"'])? ; 
	
	Track ::= "track" (name['"','"'])? 
		"{" 
			ports* 
			trains* 
		"}" ;
	
	Switch ::= "switch" (name['"','"'])?
		"{" 
			ports*
			trains* 
		"}" ;
	
	Connection ::= "connect" (name['"','"'])? source['"','"'] "->" target['"','"'] ;
	
	Out ::= "out:" (name['"','"'])? ;
	
	In  ::= "in:"  (name['"','"'])? ;
}