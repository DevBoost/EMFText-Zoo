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
	"ParameterCheckModel" COLOR #7F0055, BOLD;
	"check" COLOR #7F0055, BOLD;
	"parameterusage" COLOR #7F0055, BOLD;
	"parameters" COLOR #7F0055, BOLD;
	
}

RULES{
	
	ParameterCheckModel::= "ParameterCheckModel"  
			"{" 
				method+ 
				checkOrigin+
			"}" 
			 ;
	
	Method::= name[]  
					"(" (parameter ("," parameter )*)? ")"  
					"parameterusage"  "{" (parameterusage  ("," parameterusage)*)? "}" 
					"check" "{" (check ("," check)* )?"}"  ;
	
	Parameter::=   type[] name[];
	
	ParameterUsage::= parameter[]  "(" (nameAsString[]? valueAsString[]?) ")" ;
	
	Check::=  name[]  "("exceptionIfTrue[] ")" 
				"parameterusage"  "{" (parameterusage  ("," parameterusage)*)? "}" originOfCheck[]? exception ;
	
	OriginOfCheck::=  package[] ":" name[];
	
	Exception::=  package[] ":" name[] "parameterusage"  "{" (parameterusage  ("," parameterusage)*)? "}" ;
	
}