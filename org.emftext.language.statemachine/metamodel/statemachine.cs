SYNTAXDEF statemachine FOR <http://www.eclipse.org/uml2/2.1.0/UML> START StateMachine

OPTIONS {
  tokenspace = "1";
}

TOKENS {
	DEFINE PSEUDOKIND $'initial'$ ;
}

RULES{	
  StateMachine  ::= "StateMachine" name[] "{" region "}" ;	
  Region        ::= ( subvertex ";" | transition ";")*;
  
  State         ::= "state" name[] "{" ("entry" ":" entry)? ("exit" ":" exit)? 
                    "do" ":" doActivity "}";
  Pseudostate   ::=  kind[PSEUDOKIND] "state" name[];
  FinalState    ::= "final" "state" name[] "{" ("entry" ":" entry)? ("exit" ":" exit)?
                    "do" ":" doActivity "}"; 					
  
  Transition    ::= "transition" "from" source[] "to" target[] "when" trigger 
                    ( "do" ":" effect )?;		
  Trigger       ::= name['"','"'];	
  Activity      ::= name['"','"'];										
}