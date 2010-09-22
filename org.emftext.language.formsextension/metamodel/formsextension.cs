@SuppressWarnings(unusedResolverClass)
SYNTAXDEF formsextension
FOR <http://www.emftext.org/language/formsextension> 
START ExtendedForm

IMPORTS {
	forms : <http://www.emftext.org/language/forms> WITH SYNTAX forms <../../org.emftext.language.forms/metamodel/forms.cs>
}

OPTIONS {
	overrideBuilder = "false";
	usePredefinedTokens ="false";
	resolveProxyElementsAfterParsing = "false";
	additionalDependencies = "org.emftext.language.java.resource";
}

RULES {
	ExtendedForm ::= "JavaFile:" compilationUnit['[',']'] "Method:" javaMethod['[',']'] !0 
					"FORM" caption['"','"'] !1 groups*;
}