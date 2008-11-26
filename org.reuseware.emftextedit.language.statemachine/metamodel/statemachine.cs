SYNTAXDEF statemachine
FOR <http://www.eclipse.org/uml2/2.1.0/UML>
START StateMachine

TOKENS{
		DEFINE SL_COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE ML_COMMENT $'/*'.*'*/'$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		StateMachine	::= "StateMachine" name['"','"'] "{" region "}" ;
		
		Region 			::= ( subvertex ";" | transition ";")*;
		
		State 			::= "state" name['"','"'] "{"
							("entry" ":" entry)?
							("exit" ":" exit)?
							"do" ":" doActivity							
							"}";
		
		Pseudostate 	::= kind[] "state" name['"', '"'];
							
		FinalState		::= "final" "state"	name['"','"'] "{"
							("entry" ":" entry)?
							("exit" ":" exit)?
							"do" ":" doActivity							
							"}"; 					
							
		Transition		::= "transition" 
							"from" source['"','"']
							"to" target['"','"']
							"when" trigger
							( "do" ":" effect )?;
							
		Trigger			::= name['"','"']; 
		
		Activity		::= name['"','"'];
										
}