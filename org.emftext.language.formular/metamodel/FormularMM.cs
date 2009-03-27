SYNTAXDEF formular
FOR <http://www.emftext.org/language/formular>
START Formular

RULES {
	Formular ::= "FORMULAR" titel['"','"'] fragen*;
	Frage ::= "FRAGE" text['"','"'] ( erklaerung['"','"'] )? ("NUR" "BEI" abhaengigVon[])? antwortTyp;
	Auswahl ::= "AUSWAHL" (mehrfach[])? "(" optionen ("," optionen)* ")";
	Option ::= ( id[] ":")? text['"','"'];
	Datum ::= "DATUM";
	Freitext ::= "FREITEXT";
	Zahl ::= "ZAHL";
}