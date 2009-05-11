SYNTAXDEF hamburger
FOR <http://www.emftext.org/language/hamburger>
START Menu

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"MENU" COLOR #000000, BOLD;
	"HAMBURGER" COLOR #A0A0A0, BOLD;
	"MEAT" COLOR #9d3838, BOLD;
	"TEXT" COLOR #003f9d, BOLD;
	"grams" COLOR #003f9d, BOLD;
	"ONIONS" COLOR #A0A000, BOLD;
	"SALAD" COLOR #008000, BOLD;
	"FRIES" COLOR #d2b600, BOLD;
	"DRINK" COLOR #009bd3, BOLD;
}

RULES {
	Menu ::= "MENU" burger fries? drink?;
	Hamburger ::= "HAMBURGER" toppings*;
	
	Meat ::= weight "grams" "MEAT";
	MeatWeight ::= weight[];
	Onions ::= "ONIONS";
	Salad ::= "SALAD";
	
	Fries ::= size[] "FRIES";
	SoftDrink ::= size[] "DRINK";
}