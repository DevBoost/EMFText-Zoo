SYNTAXDEF formsextension
FOR <http://www.emftext.org/language/formsextension> 
START ExtendedForm
IMPORTS {
	forms : <http://www.emftext.org/language/forms> WITH SYNTAX forms <../../org.emftext.language.forms/metamodel/forms.cs>
}

OPTIONS {
	overrideBuilder = "false";
	usePredefinedTokens ="false";
	defaultTokenName = "IDENTIFIER";
}

RULES {
	ExtendedForm ::= "JavaFile:" compilationUnit['[',']'] "Method:" javaMethod['[',']'] !0 
					"FORM" caption[STRING_LITERAL] !1 groups*;
	
}