SYNTAXDEF hamburger
FOR <http://www.emftext.org/language/hamburger>
START Menu

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"HAMBURGER" COLOR #d2b600, BOLD;
	"MEAT" COLOR #9d3838, BOLD;
	"TEXT" COLOR #003f9d, BOLD;
	"grams" COLOR #003f9d, BOLD;
	"ONIONS" COLOR #A0A000, BOLD;
	"SALAD" COLOR #008000, BOLD;
}

RULES {
	Menu ::= "MENU" burger fries? drink?;
	Hamburger ::= "HAMBURGER" toppings*;
	
	Meat ::= weight[] "grams" "MEAT";
	Onions ::= "ONIONS";
	Salad ::= "SALAD";
	
	Fries ::= size[] "FRIES";
	SoftDrink ::= size[] "DRINK";
}