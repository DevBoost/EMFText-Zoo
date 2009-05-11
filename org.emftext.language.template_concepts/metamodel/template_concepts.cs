ABSTRACT SYNTAXDEF template_concepts
FOR <http://www.emftext.org/language/template_concepts>

RULES {
	Placeholder ::= "<%=" expression[] "%>";
	//IfCondition ::= "<%IF" condition[] "%>" body "<%ENFIF%>";
	//ForLoop     ::= "<%FOR" collection[] "%>" body "<%ENDFOR%>";
}