lexer grammar Feature;
@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.featuremapper.models.feature.resource.feature;

}

T11 : 'FeatureModel' ;
T12 : '{' ;
T13 : 'constraints' ;
T14 : ';' ;
T15 : '}' ;
T16 : 'Constraint' ;
T17 : '(' ;
T18 : ',' ;
T19 : ')' ;
T20 : ':' ;
T21 : 'Feature' ;
T22 : '..' ;
T23 : '/*' ;
T24 : '*/' ;
T25 : '[' ;
T26 : ']' ;
T27 : 'Group' ;
T28 : 'type' ;
T29 : '=' ;

// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 189
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 193
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 197
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 201
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 205
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 209
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 213
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
