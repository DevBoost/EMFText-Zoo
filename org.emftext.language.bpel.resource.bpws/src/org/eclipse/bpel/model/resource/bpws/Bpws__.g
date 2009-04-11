lexer grammar Bpws;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.eclipse.bpel.model.resource.bpws;

}

T9 : 'Process' ;

// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 464
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 468
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'{ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 472
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 476
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\work\reusewareSvn\EMFTextEdit Languages\org.eclipse.bpel.model.resource.bpws\src\org\eclipse\bpel\model\resource\bpws\Bpws.g" 480
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
