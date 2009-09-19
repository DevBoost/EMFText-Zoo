 SYNTAXDEF petrinet
FOR <http://org.emftext/petrinet>
START PetriNet

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES{
	"PN" COLOR #7F0055, BOLD;
	"A" COLOR #7F0055, BOLD;
	"Tr" COLOR #7F0055, BOLD;
	"P" COLOR #7F0055, BOLD;
	"To" COLOR #7F0055, BOLD;
	"->" COLOR #7F0055, BOLD;
}

RULES{
	
	PetriNet::= "PN"  "{" (name['"','"'])? "(" (nodes)* ")" "(" (arcs)* ")" "}" ;
	
	Arc::= "A" (name['"','"'])? source[] "->" target[] ;
	
	Transition::= "Tr" (name['"','"'])? ;
	
	Place::= "P" "{" (name['"','"'])? (marking)* "}" ;
	
	Token::= "To" (name['"','"'])? ;
	
}