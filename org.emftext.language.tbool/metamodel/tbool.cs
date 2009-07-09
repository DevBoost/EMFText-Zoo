SYNTAXDEF tbool
FOR <http://www.emftext.org/language/tbool>
START ClassTemplate

IMPORTS {
	bool : <http://www.emftext.org/language/bool> <../../org.emftext.language.bool/metamodel/bool.genmodel> 
		WITH SYNTAX bool <../../org.emftext.language.bool/metamodel/bool.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"class" COLOR #7F0055, BOLD;
	"void" COLOR #7F0055, BOLD;
	"<%TEMPLATE" COLOR #C00000, BOLD; 
	"INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"COMMENT" COLOR #00A000, ITALIC;
}

RULES {
	ClassTemplate ::= "<%TEMPLATE" "INPUT=" inputMetaClass['"','"'] "%>" body;
	PhNamedElementName ::= "<%=" expression['"','"'] "%>";
	IfClassMembers ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForClassMembers ::= "<%FOR" (variable[] ":")? expression['"','"'] "%>" body+ "<%ENDFOR%>";
}