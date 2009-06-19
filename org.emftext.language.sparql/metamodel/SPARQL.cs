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
	DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
	
	SparqlQueries::=prologue query  ;
	
	Prologue::=basedeclaration? prefixdeclaration  ;
	
	BaseDecl::= "BASE" iriref  ;
	
	PrefixDecl::= "PREFIX" pnamens iriref  ;
	
	
}