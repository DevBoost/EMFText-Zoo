SYNTAXDEF xml
FOR <http://www.emftext.org/language/emfxml>
START CompactElement, OpeningElement
 
RULES {
 	CompactElement ::= "<" name[] attributes* "/" ">";
 	OpeningElement ::= "<" name[] attributes* ">" children* "<" "/" name[] ">";
 	//PCDataElement  ::= "<" name[] attributes* data['>', '<'] "/" name[] ">";
 	
 	Attribute      ::= name[] "=" value['"', '"'];
}