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
	"<%FOR" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
}

RULES {		
	MenuTemplate ::= body;
	ForRefHamburgerToppings ::= "<%FOR" collection[] "%>" body "<%ENDFOR%>";	
}