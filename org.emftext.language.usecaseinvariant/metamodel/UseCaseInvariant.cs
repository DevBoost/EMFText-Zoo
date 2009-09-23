SYNTAXDEF ucinv
FOR <http://www.emftext.org/language/UseCaseInvariant>
START UseCaseModel

OPTIONS {
	reloadGeneratorModel = "true";
	tokenspace = "1";
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"invariants" COLOR #7F0055, BOLD;
	"actor" COLOR #7F0055, BOLD;
	"counter" COLOR #7F0055, BOLD;
	"set" COLOR #7F0055, BOLD;
	"of" COLOR #7F0055, BOLD;
	"excluding" COLOR #7F0055, BOLD;
	"including" COLOR #7F0055, BOLD;
}

RULES {

UseCaseModel 
   ::=
        "invariants" "for" name[] ":" (!1 invariants)* !0 "."
	;

NormalActor
   ::=
        "actor" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

CounterActor
   ::=
        "counter" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

SingleValue 
   ::=
        type[] ("(" #0 ID[] #0 ")")?
	;

SetOfValues
   ::=
        "set" "of" type[] ("excluding" excluding)? ("including" including)?
	;
}