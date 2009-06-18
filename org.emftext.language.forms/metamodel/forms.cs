SYNTAXDEF forms
FOR <http://www.emftext.org/language/forms>
START Form

TOKENSTYLES {
	"TEXT" COLOR #da0000;
	"FORM" COLOR #000000, BOLD;
	"ITEM" COLOR #000000, BOLD;
	"CHOICE" COLOR #000000, BOLD;
	"ONLY" COLOR #da0000, BOLD;
	"IF" COLOR #da0000, BOLD;
	"DATE" COLOR #000000, BOLD;
	"FREETEXT" COLOR #000000, BOLD;
	"NUMBER" COLOR #000000, BOLD;
	"DECISION" COLOR #000000, BOLD;
	"GROUP" COLOR #000000, BOLD;
}
  
RULES {
	Form ::= "FORM" caption['"','"'] groups*;
	Group ::= "GROUP" name['"','"'] items*;
	Item ::= "ITEM" text['"','"'] ( explanation['"','"'] )? ("ONLY" "IF" dependentOf[])? ":" itemType;
	Choice ::= "CHOICE" (multiple[])? "(" options ("," options)* ")";
	Option ::= ( id[] ":")? text['"','"'];
	Date ::= "DATE";
	FreeText ::= "FREETEXT";
	Number ::= "NUMBER";
	Decision ::=  "DECISION" "(" options "," options ")"; 
}