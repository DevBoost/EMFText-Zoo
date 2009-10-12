SYNTAXDEF aterms
FOR <http://www.emftext.org/language/aterms>
START ATerm, Value

OPTIONS {
 	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES {
	"appl" COLOR #7F0055, BOLD;
	"Definition" COLOR #7F0055, BOLD;
	"Symbol" COLOR #7F0055, BOLD;
	"Cardinality" COLOR #7F0055, BOLD;
}

RULES {
	ATerm::= "appl"  "(" definitions ( "," definitions  )* production ")," "["  "[]"  "[" symbols ( "," symbols  )* "]"  "]"  ")"  ;
	
	Value::=literal['"','"']  ;
	
	Reference::= "cf(sort(" name['"','"']  "))"  ;
	
	StarCardinality::= "iter-star-sep"  "(" production separator['"','"']  ")"  ;
}