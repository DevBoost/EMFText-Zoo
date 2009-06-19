SYNTAXDEF tbool
FOR <http://www.emftext.org/language/tbool>
START ClassTemplate

IMPORTS {
	bool : <http://www.emftext.org/language/bool> <../../org.emftext.language.bool/metamodel/bool.genmodel> 
		WITH SYNTAX bool <../../org.emftext.language.bool/metamodel/bool.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	overrideManifest = "false";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
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
	PhTypedElement ::= "<%=" expression['"','"'] "%>";
	IfElseTypedElement ::= "<%IF" expression['"','"'] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	PhNamedElement ::= "<%=" expression['"','"'] "%>";
	IfElseNamedElement ::= "<%IF" expression['"','"'] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfClass ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForClass ::= "<%FOR" expression['"','"'] "%>" body body* "<%ENDFOR%>";
}