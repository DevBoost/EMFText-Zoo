SYNTAXDEF dynamicui
FOR <http://www.dynamicui.org/>
START UIElement


RULES {
	UIElement ::= name[] properties* "{" children* "}";
	Property ::= name[] "=" value['"','"'];
}