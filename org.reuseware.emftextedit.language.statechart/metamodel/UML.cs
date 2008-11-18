SYNTAXDEF uml
FOR <http://www.eclipse.org/uml2/2.1.0/UML>
START StateMachine

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		StateMachine	::= "StateMachine" name['"','"'] region ;
		
		Region 			::= ( subvertex ";")*;
		
		State 			::= "state" name['"','"'] "{"
							("entry" ":" entry)?
							("exit" ":" exit)?
							"do" ":" doActivity							
							"}";
							
		FinalState		::= "final" "state"	name['"','"'] "{"
							("entry" ":" entry)?
							("exit" ":" exit)?
							"do" ":" doActivity							
							"}"; 					
							
		Transition		::= "transition" 
							"from" source[]
							"to" target[]
							"when" trigger
							"do" effect;
							
		Trigger			::= name['"','"']; 
		
		Activity		::= name['"','"'];
										
}