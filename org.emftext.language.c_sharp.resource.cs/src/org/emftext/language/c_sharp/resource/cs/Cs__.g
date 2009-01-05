lexer grammar Cs;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.emftext.language.c_sharp.resource.cs;

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

// $ANTLR src "E:\Programme\Arbeit\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\org.emftext.language.c_sharp.resource.cs\src\org\emftext\language\c_sharp\resource\cs\Cs.g" 107
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "E:\Programme\Arbeit\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\org.emftext.language.c_sharp.resource.cs\src\org\emftext\language\c_sharp\resource\cs\Cs.g" 111
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "E:\Programme\Arbeit\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\org.emftext.language.c_sharp.resource.cs\src\org\emftext\language\c_sharp\resource\cs\Cs.g" 115
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
