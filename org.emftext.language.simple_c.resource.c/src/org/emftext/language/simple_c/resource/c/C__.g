lexer grammar C;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.emftext.language.simple_c.resource.c;

}

T7 : 'void' ;
T8 : '(' ;
T9 : ')' ;
T10 : '{' ;
T11 : '}' ;
T12 : 'int' ;
T13 : ';' ;
T14 : 'struct' ;
T15 : 'return' ;

// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_c.resource.c\src\org\emftext\language\simple_c\resource\c\C.g" 127
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_c.resource.c\src\org\emftext\language\simple_c\resource\c\C.g" 131
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_c.resource.c\src\org\emftext\language\simple_c\resource\c\C.g" 135
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
