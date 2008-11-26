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

T12 : 'StateMachine' ;
T13 : '{' ;
T14 : '}' ;
T15 : ';' ;
T16 : 'state' ;
T17 : 'entry' ;
T18 : ':' ;
T19 : 'exit' ;
T20 : 'do' ;
T21 : 'final' ;
T22 : 'transition' ;
T23 : 'from' ;
T24 : 'to' ;
T25 : 'when' ;

// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 732
SL_COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 736
ML_COMMENT
:
	'/*'.*'*/'{ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 740
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 744
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 748
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 752
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 756
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.statemachine\src\org\eclipse\uml2\uml\resource\statemachine\Statemachine.g" 760
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
