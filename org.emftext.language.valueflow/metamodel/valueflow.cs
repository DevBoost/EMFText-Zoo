SYNTAXDEF valueflow
FOR <http://www.emftext.org/language/valueflow>
START Model

TOKENSTYLES {
	"TEXT" COLOR #000000;
}

RULES{		
		Model::= "flowmodel" name['"','"'] "{" agents* !0 "}";
		
		Agent::= !1 "agent" name['"','"'] "{" states* !0 "}";
		
		Initial::= !2 "start" name['"','"'] ("next" nextState[])? ";";
		
		GiveState::= !2 "give"  name['"','"'] "value" value['"','"'] ("("#0 ID[] #0 ")")? "to" giveTo['"','"'] ("next" nextState['"','"'])? ";";
		
		TakeState::= !2 "take"  name['"','"'] "from" takeFrom['"','"'] ("next" nextState[])? ";";	
}