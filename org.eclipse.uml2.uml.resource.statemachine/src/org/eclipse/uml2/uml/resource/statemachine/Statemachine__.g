lexer grammar Statemachine;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.eclipse.uml2.uml.resource.statemachine;

}

T8 : 'StateMachine' ;
T9 : '{' ;
T10 : '}' ;
T11 : ';' ;
T12 : 'state' ;
T13 : 'entry' ;
T14 : ':' ;
T15 : 'exit' ;
T16 : 'do' ;
T17 : 'final' ;
T18 : 'transition' ;
T19 : 'from' ;
T20 : 'to' ;
T21 : 'when' ;

// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.eclipse.uml2.uml.resource.statemachine/src/org/eclipse/uml2/uml/resource/statemachine/Statemachine.g" 732
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.eclipse.uml2.uml.resource.statemachine/src/org/eclipse/uml2/uml/resource/statemachine/Statemachine.g" 736
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.eclipse.uml2.uml.resource.statemachine/src/org/eclipse/uml2/uml/resource/statemachine/Statemachine.g" 740
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.eclipse.uml2.uml.resource.statemachine/src/org/eclipse/uml2/uml/resource/statemachine/Statemachine.g" 744
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
