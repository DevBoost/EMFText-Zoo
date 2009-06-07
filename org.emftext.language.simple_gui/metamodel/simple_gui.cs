SYNTAXDEF simplegui
FOR <http://www.emftext.org/language/simple_gui>
START Frame

OPTIONS {
	overrideManifest = "false";
}

RULES {
	Frame ::= "F" "(" name[] ")" "contains" children* ";";
	
	Panel ::= "P" "(" name[] ")" "contains" children* ";";
	
	Button ::= "B" "(" name[] ")";

	Label ::= "L" "(" name[] ")";
	
	Image ::= "I" "(" key[] ")";
}