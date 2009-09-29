SYNTAXDEF petrinet
FOR <http://www.emftext.org/language/petrinet>
START PetriNet

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"net" COLOR #7F0055, BOLD;
	"arc" COLOR #7F0055, BOLD;
	"transition" COLOR #7F0055, BOLD;
	"place" COLOR #7F0055, BOLD;
	"token" COLOR #7F0055, BOLD;
	"->" COLOR #7F0055, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	
	PetriNet::= "net"  (name[])?  "{" nodes* arcs* "}" ;
	
	Arc::= "arc" (name[])? source[] "->" target[] ;
	
	Transition::= "transition" (name[])? ;
	
	Place::= "place" (name[])? ("{" marking* "}")? ;
	
	Token::= "token" (name[])? ;
}