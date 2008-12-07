lexer grammar Simpletemplate;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.emftext.language.simple_template.resource.simpletemplate;

}

T7 : '<%' ;
T8 : 'if' ;
T9 : '(' ;
T10 : ')' ;
T11 : '{' ;
T12 : '%>' ;
T13 : '}' ;
T14 : 'for' ;
T15 : '<%=' ;

// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_template.resource.simpletemplate\src\org\emftext\language\simple_template\resource\simpletemplate\Simpletemplate.g" 143
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_template.resource.simpletemplate\src\org\emftext\language\simple_template\resource\simpletemplate\Simpletemplate.g" 147
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.emftext.language.simple_template.resource.simpletemplate\src\org\emftext\language\simple_template\resource\simpletemplate\Simpletemplate.g" 151
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
