SYNTAXDEF martinfowlerdsl
FOR <http://www.emftext.org/language/martinfowlerdsl>
START StateMachine

TOKENS {
	DEFINE T_RESETTING $'resetting'$;
}

TOKENSTYLES {
	"T_RESETTING" COLOR #800055, BOLD;
}

RULES {
	StateMachine ::= 
		"events"   (events: Event)*   "end"
  		"commands" (events: Command)* "end"
  		"start" start[]
		states+;
 
	State ::= 
		"state" name[]
		("actions" "{" (actions[])+ "}")?
		transitions*
  		"end";
 
	Event      ::= (resetting[T_RESETTING])? name[] code[];
	Command    ::= name[] code[];
	Transition ::= trigger[] "=>" target[];
}