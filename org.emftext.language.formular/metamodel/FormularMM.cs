SYNTAXDEF formular
FOR <http://www.emftext.org/language/formular>
START Formular

OPTIONS {
	overridePluginXML = "false";
}

TOKENSTYLES {
	"TEXT" COLOR #da0000;
	"FORMULAR" COLOR #000000, BOLD;
	"FRAGE" COLOR #000000, BOLD;
	"AUSWAHL" COLOR #000000, BOLD;
	"NUR" COLOR #da0000, BOLD;
	"BEI" COLOR #da0000, BOLD;
	"DATUM" COLOR #000000, BOLD;
	"FREITEXT" COLOR #000000, BOLD;
	"ZAHL" COLOR #000000, BOLD;
	"ENTSCHEIDUNG" COLOR #000000, BOLD;
	"GRUPPE" COLOR #000000, BOLD;
	"ENTSCHEIDUNG" COLOR #000000, BOLD;
}
  
RULES {
	Formular ::= "FORMULAR" titel['"','"'] gruppen*;
	Gruppe ::= "GRUPPE" name['"','"'] fragen*;
	Frage ::= "FRAGE" text['"','"'] ( erklaerung['"','"'] )? ("NUR" "BEI" abhaengigVon[])? ":" antwortTyp;
	Auswahl ::= "AUSWAHL" (mehrfach[])? "(" optionen ("," optionen)* ")";
	Option ::= ( id[] ":")? text['"','"'];
	Datum ::= "DATUM";
	Freitext ::= "FREITEXT";
	Zahl ::= "ZAHL";
	Entscheidung ::=  "ENTSCHEIDUNG" "(" optionen "," optionen ")"; 
}