SYNTAXDEF pcheck
FOR <http://deftproject.org/parametercheck>
START ParameterCheckModel

OPTIONS {
	//usePredefinedTokens = "true";
	srcFolder = "src-gen";
	resourcePluginID = "org.emftext.language.parametercheck.resource.pcheck";
	generateCodeFromGeneratorModel = "true";
	basePackage = "org.emftext.language.parametercheck.resource.pcheck";
	
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE EXCLAM $'!'$;
	DEFINE NAME_TYPE $'n' | 't'$;
	DEFINE STRING_LITERAL $'"' ('A'..'Z' | 'a'..'z' | '0'..'9')* '"'$;
	
}

TOKENSTYLES {
	"method" COLOR #7F0055, BOLD;
	"check" COLOR #7F0055, BOLD;
	"throw" COLOR #7F0055, BOLD;
}

RULES{
	
	ParameterCheckModel::= 
				method+ 
			 ;
	
	Method ::= "method" name[] "(" (parameter ("," parameter )*)? ")"  
					("check" check)+ ";" ;
	
	Parameter ::= ignoreInMethodDecl[EXCLAM]? type[] name[]; 
	
	ParameterUsage ::= (asString[NAME_TYPE] ":")? parameter[] | ParameterUsageLiteral; 
	
	ParameterUsageLiteral ::= value[STRING_LITERAL];
	
	Check ::= (exceptionIfTrue[EXCLAM])? name[]  
				"(" (parameterusage  ("," parameterusage)*)? ")" exception ;
	
	Exception::=  "throw" (package[] ":")? name[] "(" (parameterusage  ("," parameterusage)*)? ")" ;
	
}

//questions:
// - how to use packages in exceptions such as org.deft.repository.exception:DeftNullArgumentException (problems with dots in package)
