SYNTAXDEF closure
FOR <http://emftext.org/language/closures>
START java.Containers.CompilationUnit, java.Containers.EmptyModel
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	srcFolder = "src-gen";
	overrideManifest = "false";
	overridePluginXML = "false";
	overrideClasspath = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel="true";
}

TOKENS{
}

TOKENSTYLES{
}



RULES{
	
	Closure::= "{" (parameters ("," parameters)*)? "=>" statements+  "}";
	
	
	
}

