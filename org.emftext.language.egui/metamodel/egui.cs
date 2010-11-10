SYNTAXDEF egui
FOR <http://www.emftext.org/language/egui>
START Application

IMPORTS {
	action : <http://www.emftext.org/language/egui/actions>
	sm : <http://www.emftext.org/language/egui/statemodel>
	screen : <http://www.emftext.org/language/egui/screenmodel>
	widget : <http://www.emftext.org/language/egui/widgets>
	
	java : <http://www.emftext.org/java/members>
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"COMMENT" COLOR #00A000;
}

RULES {
	Application ::= "application" name[] statemodel screens*;
	
	// the state model
	sm.StateModel ::= "statemodel" "{" states* events* transitions* "}";
	sm.State      ::= "state" name[] action ";";
	sm.Event      ::= "event" name[] ";";
	sm.Transition ::= source[] "-" ("(" event[] ")-")? ">" target[] ";";
	
	// the screen model
	screen.Screen ::= "screen" name[] "{" children* "}";

	// the widgets
	widget.Button    ::= "button" name[] label['"','"'] ";";
	widget.List      ::= "list" name[] ";";
	widget.TextField ::= "textfield" name[] ";";
	
	// actions
	action.ShowScreenAction ::= "show" screen[];
	action.JavaAction       ::= "call" method['<','>'];
}