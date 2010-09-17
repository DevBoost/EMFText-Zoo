SYNTAXDEF javaforms
FOR <http://www.emftext.org/language/javaforms>
START forms.Form

IMPORTS {
	forms : <http://www.emftext.org/language/forms> WITH SYNTAX forms <../../org.emftext.language.forms/metamodel/forms.cs>
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>

}
OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "false"; 
	defaultTokenName = "IDENTIFIER";
	tokenspace = "1";
	overrideBuilder = "false" ; 
}

 
RULES {
	ConditionalItem ::= (name[IDENTIFIER] "=")? "ITEM" text[STRING_LITERAL] ( explanation[STRING_LITERAL] )? ("ONLY" "IF" ( "(" condition:java.Expressions.AssignmentExpression? ")" | dependentOf[IDENTIFIER] ))? ":" itemType !0;

}

 