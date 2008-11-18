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
T14 : ':' ;
T15 : 'root' ;
T16 : 'name' ;
T17 : 'children' ;
T18 : 'parent' ;
T19 : '}' ;
T20 : 'Feature' ;
T21 : 'minCardinality' ;
T22 : 'maxCardinality' ;
T23 : 'attributes' ;
T24 : 'groups' ;
T25 : 'parentGroup' ;
T26 : 'annotations' ;
T27 : 'Group' ;
T28 : 'parentFeature' ;
T29 : 'childFeatures' ;
T30 : 'Constraint' ;
T31 : 'language' ;
T32 : 'expression' ;
T33 : 'constrainedFeatures' ;
T34 : 'Attribute' ;
T35 : 'feature' ;
T36 : 'type' ;
T37 : 'value' ;
T38 : 'Annotation' ;

// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 258
COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 262
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 266
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 270
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 274
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 278
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "D:\userdata\work\ete.examples\EMFTextEdit Languages\org.featuremapper.models.feature.resource.feature\src\org\featuremapper\models\feature\resource\feature\Feature.g" 282
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
