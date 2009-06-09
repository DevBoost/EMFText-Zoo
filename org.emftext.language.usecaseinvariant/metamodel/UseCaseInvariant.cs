SYNTAXDEF ucinv
FOR <http://www.emftext.org/language/UseCaseInvariant>
START UseCaseModel

OPTIONS {
	reloadGeneratorModel = "true";
	overridePluginXML = "false";
	overrideManifest = "false";
	tokenspace = "1";
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
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