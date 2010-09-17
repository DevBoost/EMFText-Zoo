SYNTAXDEF formsembedded
FOR <http://www.emftext.org/language/formsembedded>
START java.Containers.CompilationUnit

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
	EmbeddedForm ::= "form" name[IDENTIFIER] "=" "form" "{" form "}" ";" ;

}