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
	Application ::= "application" name[] !0 !0 statemodel (!0 !0 screens)*;
	
	// the state model
	sm.StateModel ::= "statemodel" #1 "{" (!1 states)* (!1 events)* (!1 transitions)* !0 "}";
	sm.State      ::= "state" name[] action ";";
	sm.Event      ::= "event" name[] ";";
	sm.Transition ::= source[] "-" ("(" event[] ")-")? ">" #1 target[] ";";
	
	// the screen model
	screen.Screen ::= "screen" name[] #1 "{" (!1 children)* !0 "}";

	// the widgets
	widget.Panel     ::= "panel" name[] #1 "{" (!1 children)* !0 "}";
	widget.Button    ::= "button" name[] #1 label['"','"'] ";";
	widget.UIList      ::= "list" name[] ";";
	widget.TextField ::= "textfield" name[] ";";
	
	// actions
	action.ShowScreenAction ::= "show" screen[];
	action.JavaAction       ::= "call" #1 method['<','>'];
}