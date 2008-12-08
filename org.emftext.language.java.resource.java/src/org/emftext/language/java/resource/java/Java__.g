lexer grammar Java;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.emftext.language.java.resource.java;

}

T18 : 'package' ;
T19 : '.' ;
T20 : ';' ;
T21 : 'import' ;
T22 : 'class' ;
T23 : '<' ;
T24 : ',' ;
T25 : '>' ;
T26 : 'extends' ;
T27 : 'implements' ;
T28 : '{' ;
T29 : '}' ;
T30 : 'interface' ;
T31 : '@' ;
T32 : '(' ;
T33 : ')' ;
T34 : '=' ;
T35 : 'enum' ;
T36 : '&' ;
T37 : 'throws' ;
T38 : 'default' ;
T39 : '...' ;
T40 : 'new' ;
T41 : '[' ;
T42 : ']' ;
T43 : '?' ;
T44 : 'super' ;
T45 : 'assert' ;
T46 : ':' ;
T47 : 'if' ;
T48 : 'else' ;
T49 : 'for' ;
T50 : 'while' ;
T51 : 'do' ;
T52 : 'synchronized' ;
T53 : 'try' ;
T54 : 'finally' ;
T55 : 'catch' ;
T56 : 'switch' ;
T57 : 'case' ;
T58 : 'return' ;
T59 : 'throw' ;
T60 : 'break' ;
T61 : 'continue' ;
T62 : '++' ;
T63 : '--' ;
T64 : '~' ;
T65 : '!' ;
T66 : '+=' ;
T67 : '-=' ;
T68 : '*=' ;
T69 : '/=' ;
T70 : '&=' ;
T71 : '|=' ;
T72 : '^=' ;
T73 : '%=' ;
T74 : 'null' ;
T75 : 'void' ;
T76 : 'this' ;
T77 : 'public' ;
T78 : 'abstract' ;
T79 : 'protected' ;
T80 : 'private' ;
T81 : 'final' ;
T82 : 'static' ;
T83 : 'native' ;
T84 : 'transient' ;
T85 : 'volatile' ;
T86 : 'strictfp' ;
T87 : 'boolean' ;
T88 : 'char' ;
T89 : 'byte' ;
T90 : 'short' ;
T91 : 'int' ;
T92 : 'long' ;
T93 : 'float' ;
T94 : 'double' ;

// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2516
SL_COMMENT
:
	'//'(~('\n'|'\r'))*
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2520
ML_COMMENT
:
	'/*'.*'*/'
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2524
FLOATING_POINT_LITERAL
:
	('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))? |   ('.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+) (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('f'|'F'|'d'|'D')))
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2528
HEX_LITERAL
:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+('l'|'L')?
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2532
DECIMAL_LITERAL
:
	('0'|'1'..'9''0'..'9'*)('l'|'L')?
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2536
OCTAL_LITERAL
:
	'0'('0'..'7')+('l'|'L')?
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2540
BOOLEAN_LITERAL
:
	'true'|'false'
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2544
ADDITIVE_OPERATOR_LITERAL
:
	'+'|'-'
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2548
MULTIPLICATIVE_OPERATOR_LITERAL
:
	'*'|'/'|'%'
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2552
CHARACTER_LITERAL
:
	'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\''
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2556
STRING_LITERAL
:
	'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2560
IDENTIFIER
:
	('A'..'Z'|'a'..'z'|'0'..'9'|'_')+
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2564
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g" 2568
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
