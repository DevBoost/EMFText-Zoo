lexer grammar Uml;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.eclipse.uml2.uml.resource.uml;

}

T11 : 'StateMachine' ;
T12 : ';' ;
T13 : 'state' ;
T14 : '{' ;
T15 : 'entry' ;
T16 : ':' ;
T17 : 'exit' ;
T18 : 'do' ;
T19 : '}' ;
T20 : 'final' ;
T21 : 'transition' ;
T22 : 'from' ;
T23 : 'to' ;
T24 : 'when' ;

// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 712
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 716
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 720
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 724
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 728
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 732
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.eclipse.uml2.uml.resource.uml\src\org\eclipse\uml2\uml\resource\uml\Uml.g" 736
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
