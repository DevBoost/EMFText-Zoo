SYNTAXDEF SPARQL
FOR <http://org.emftext/sparql> <SPARQL.genmodel>
START SparqlQueries

IMPORTS{
	PrimitiveTypes:<SPARQL-PrimitiveTypes>
}

OPTIONS{
	generateCodeFromGeneratorModel="true";
	overrideManifest="false";
	reloadGeneratorModel="true";
	tokenspace="1";
	usePredefinedTokens="false";
}

TOKENS{
	//DEFINE IRI_REF$'<' ( '^' | '<' | '>' | '"' | '{' | '}' | '^' | '`' | '\\' | ('\\''x'('0'..'2')('0'..'9'|'a'..'f'|'A'..'F'))* '>'$;
	
	DEFINE DEF_INTEGER$('+'|'-')?('0'..'9')+$;
	
	
	//DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
	//DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	//DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
	
	SparqlQueries::=  prologue;
	//prologue query  ;
	
	//Prologue::=basedeclaration? prefixdeclaration  ;
	
	//BaseDecl::= "BASE" iriref  ;
	
	//PrefixDecl::= "PREFIX" pnamens iriref  ;
	
	
	INTEGER::= integer[DEF_INTEGER];
	
	
}