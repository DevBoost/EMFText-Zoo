SYNTAXDEF customburger
FOR <http://www.emftext.org/language/customburger>
START MenuTemplate

IMPORTS {
	hamburger : <http://www.emftext.org/language/hamburger> WITH SYNTAX java <../../org.emftext.language.hamburger/metamodel/hamburger.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideManifest = "false";
}

TOKENSTYLES {
	"<%TEMPLATE INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"QUOTED_34_34" COLOR #C08000, BOLD;
}

RULES {
	MenuTemplate ::= "<%TEMPLATE INPUT=" inputMetaClass['"','"'] "%>" body;
	IfRefMenuFries ::= "<%IF" condition[] "%>" body "<%ENDIF%>";
	ForRefHamburgerToppings ::= "<%FOR" collection[] "%>" body "<%ENDFOR%>";
	PhAttMeatWeight ::= "<%=" expression[] "%>";
}