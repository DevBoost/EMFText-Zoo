SYNTAXDEF pcheck
FOR <http://deftproject.org/parametercheck>
START ParameterCheckModel

OPTIONS {
	usePredefinedTokens = "true";
	srcFolder = "src-gen";
	resourcePluginID = "org.emftext.language.parametercheck.resource.pcheck";
	generateCodeFromGeneratorModel = "true";
	basePackage = "org.emftext.language.parametercheck.resource.pcheck";
	
}

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"method" COLOR #7F0055, BOLD;
	"check" COLOR #7F0055, BOLD;
	"throws" COLOR #7F0055, BOLD;
	"true" COLOR #7F0055, BOLD;
	"false" COLOR #7F0055, BOLD;
	
}

RULES{
	
	ParameterCheckModel::= 
				method+ 
			 ;
	
	Method::= "method" name[] "(" (parameter ("," parameter )*)? ")"  
					"check" check ("," check)* ";" ;
	
	Parameter::=   ("!")? type[] name[];
	
	ParameterUsage::= parameter[]  "<" "asString" "=" asString[] ">" ;
	
	Check::=  name[]  "<" exceptionIfTrue[] ">" 
				"(" (parameterusage  ("," parameterusage)*)? ")" exception ;
	
	Exception::=  "throws" (package[] ":")? name[] "(" (parameterusage  ("," parameterusage)*)? ")" ;
	
}

//questions:
// - how to use packages in exceptions such as org.deft.repository.exception:DeftNullArgumentException (problems with dots in package)
// - how to convert exclamation mark in parameter to ignoreInMethodDecl = true