SYNTAXDEF company
FOR <http://org.emftext/company.ecore>
START Company

OPTIONS {
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE DECIMAL_DOUBLE_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('d'|'D')? | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('d'|'D')? | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('d'|'D')? | ('0'..'9')+ ('d'|'D'))$;
}


TOKENSTYLES {
	"company" COLOR #7F0055, BOLD;
	"department" COLOR #7F0055, BOLD;
	"employee" COLOR #7F0055, BOLD;
	"address" COLOR #7F0055, BOLD;
	"salary" COLOR #7F0055, BOLD;
	"mentor" COLOR #7F0055, BOLD;
	"manager"  COLOR #7F0055, BOLD;
}


RULES {
	Company ::= "company"  name['"','"'] "{" (departments)* "}";
	Department ::= "department" name['"','"']  "{"
				"manager" manager 
				(subDepartments | ("employee" employees))*
				"}";
	Employee ::=  name['"','"'] "{" "address" address['"','"'] 
	 								"salary" salary[DECIMAL_DOUBLE_LITERAL] 
	 								("mentor" mentor['"','"'])? 
	 							"}";
}