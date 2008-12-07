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
T17 : ':' ;
T18 : 'Feature' ;
T19 : '(' ;
T20 : '..' ;
T21 : ')' ;
T22 : '[' ;
T23 : ']' ;
T24 : 'Group' ;
T25 : '=' ;

// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 163
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 167
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 171
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 175
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 179
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 183
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "D:\Projekte\Eclipse Workspaces\EMFText Java5 DEV\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 187
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
