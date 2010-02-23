SYNTAXDEF dependencies
FOR <http://www.emftext.org/language/rolecore/dependencies>
START Graph

TOKENS{
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SET$':''='$;
	DEFINE REFERTO$'=''>'$;
}

TOKENSTYLES{
	"Equivalences" COLOR #7F0055, BOLD;
	"ModelPackage" COLOR #7F0055, BOLD;
	"Domain" COLOR #7F0055, BOLD;
}

RULES{
	
	Graph::= ("Data" dataPackage['"','"'])? 
	modelDomain modelDomain
		"Equivalences" modelEquivalence ;
	
	Domain::= "Domain" name[] "ModelPackage" modelPackage['"','"'] "{" (coreClasses)* "}"  ;
	
	Equivalence::= mandatory option? ;
	
	CoreClass::= type[] name[] mandatory option? ;
	
	Mandatory::= "(" edges * ")"  ;
	
	Option::= "[" edges* "]"  ;
	
	Edge::= leftTerm (referTo[REFERTO] rightTerms | set[SET] (value['"','"'] | rightTerms (operations['"','"'] rightTerms)*)) ";";
		
	Left::= (coreClass[])? ("role" role[])?  ;
	
	Right::= (coreClass[])? ("role" role[])?  ;
	
}