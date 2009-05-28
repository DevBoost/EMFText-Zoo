SYNTAXDEF conference
FOR <http://www.emftext.org/language/conference>

START Conference

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"QUOTED_34_34" COLOR #404040;
}

RULES {
	Conference ::= 
		"CONFERENCE" name['"','"'] 
		"(" organizers['"','"'] ("," organizers['"','"'])* ")" 
	    ( elements )* 
	    "REGISTERED" "SPEAKERS" ":" speakers ("," speakers)*;
		
	Participant ::= name['"','"'] "FROM" country [];
		
	Talk ::= "TALK" name['"','"'] "PRESENTED" "BY" presenter['"','"'];
		
	Track ::= "TRACK" name['"','"'] ":" slots*;
		
	Slot ::= "AT" hour[] ":" minute[] ":" talk;
	
	Lunch ::= "AT" hour[] ":" minute[] "LUNCH";
}