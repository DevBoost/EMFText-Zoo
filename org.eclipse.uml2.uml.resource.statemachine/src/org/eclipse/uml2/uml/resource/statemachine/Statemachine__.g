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

T11 : 'StateMachine' ;
T12 : '{' ;
T13 : '}' ;
T14 : ';' ;
T15 : 'state' ;
T16 : 'entry' ;
T17 : ':' ;
T18 : 'exit' ;
T19 : 'do' ;
T20 : 'final' ;
T21 : 'transition' ;
T22 : 'from' ;
T23 : 'to' ;
T24 : 'when' ;

// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 732
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 736
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 740
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 744
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 748
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 752
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\userdata\eclipse\ldta-runtime\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 756
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
