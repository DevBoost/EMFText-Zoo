SYNTAXDEF project
FOR <http://www.emftext.org/language/project>
START Project

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES{
	"Train" COLOR #7F0055, BOLD;
	"P" COLOR #7F0055, BOLD;
	"T" COLOR #7F0055, BOLD;
	"S" COLOR #7F0055, BOLD;
	"C" COLOR #7F0055, BOLD;
	"O" COLOR #7F0055, BOLD;
	"I" COLOR #7F0055, BOLD;
	"->" COLOR #7F0055, BOLD;
}

RULES {
	
	Train::= "Train" (name['"','"'])? ; 
	
	Project::= "P" "{" (name['"','"'])? "(" (components)* ")" "(" (connections)* ")" "}";
	
	Track::= "T" "{" (name['"','"'])? "(" (ports)* ")" "(" (trains)* ")" "}" ;
	
	Switch::= "S" "{" (name['"','"'])? "(" (ports)* ")" "(" (trains)* ")" "}" ;
	
	Connection::= "C" (name['"','"'])? source[] "->" target[] ;
	
	Out::= "O" (name['"','"'])?  ;
	
	In::= "I" (name['"','"'])? ;
	
}