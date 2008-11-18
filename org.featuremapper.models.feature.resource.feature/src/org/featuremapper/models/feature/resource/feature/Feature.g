grammar Feature;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.featuremapper.models.feature.resource.feature;

}

@lexer::members{
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header{
package org.featuremapper.models.feature.resource.feature;

//+++++++++++++++++++++++imports for org.featuremapper.models.feature begin++++++++++++++++++++++
import org.featuremapper.models.feature.FeatureModel;
//Implementation: org.featuremapper.models.feature.impl.FeatureModelImpl
import org.featuremapper.models.feature.Feature;
//Implementation: org.featuremapper.models.feature.impl.FeatureImpl
import org.featuremapper.models.feature.Group;
//Implementation: org.featuremapper.models.feature.impl.GroupImpl
import org.featuremapper.models.feature.Constraint;
//Implementation: org.featuremapper.models.feature.impl.ConstraintImpl
import org.featuremapper.models.feature.Attribute;
//Implementation: org.featuremapper.models.feature.impl.AttributeImpl
import org.featuremapper.models.feature.Annotation;
//Implementation: org.featuremapper.models.feature.impl.AnnotationImpl
import org.featuremapper.models.feature.*;
import org.featuremapper.models.feature.impl.*;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = featuremodel{ element = c0; }

;

featuremodel returns [FeatureModel element = null]
@init{
	element = FeatureFactory.eINSTANCE.createFeatureModel();
}
:
	'FeatureModel'
	'{'
	(
		(
			'constraints'
			':'
			a0 = constraint{((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(a0); copyLocalizationInfos(a0, element); }

			|
			'root'
			':'
			a1 = feature{element.eSet(element.eClass().getEStructuralFeature("root"), a1); copyLocalizationInfos(a1, element); }

			|
			'name'
			':'
			a2 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'children'
			':'
			a3 = featuremodel{((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a3); copyLocalizationInfos(a3, element); }

			|
			'parent'
			':'
			a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("parent"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FeatureModel proxy = FeatureFactory.eINSTANCE.createFeatureModel();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parent"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
		)
	)*
	'}'
;

feature returns [Feature element = null]
@init{
	element = FeatureFactory.eINSTANCE.createFeature();
}
:
	'Feature'
	'{'
	(
		(
			'name'
			':'
			a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'minCardinality'
			':'
			a1 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'maxCardinality'
			':'
			a2 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'attributes'
			':'
			a3 = attribute{((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a3); copyLocalizationInfos(a3, element); }

			|
			'groups'
			':'
			a4 = group{((List) element.eGet(element.eClass().getEStructuralFeature("groups"))).add(a4); copyLocalizationInfos(a4, element); }

			|
			'parentGroup'
			':'
			a5 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("parentGroup"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Group proxy = FeatureFactory.eINSTANCE.createGroup();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parentGroup"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }

			|
			'annotations'
			':'
			a6 = annotation{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a6); copyLocalizationInfos(a6, element); }

			|
			'constraints'
			':'
			a7 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("constraints"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Constraint proxy = FeatureFactory.eINSTANCE.createConstraint();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }
		)
	)*
	'}'
;

group returns [Group element = null]
@init{
	element = FeatureFactory.eINSTANCE.createGroup();
}
:
	'Group'
	'{'
	(
		(
			'minCardinality'
			':'
			a0 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'maxCardinality'
			':'
			a1 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'parentFeature'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("parentFeature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parentFeature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }

			|
			'childFeatures'
			':'
			a3 = feature{((List) element.eGet(element.eClass().getEStructuralFeature("childFeatures"))).add(a3); copyLocalizationInfos(a3, element); }
		)
	)*
	'}'
;

constraint returns [Constraint element = null]
@init{
	element = FeatureFactory.eINSTANCE.createConstraint();
}
:
	'Constraint'
	'{'
	(
		(
			'language'
			':'
			a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("language"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("language"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

			|
			'expression'
			':'
			a1 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("expression"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expression"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'constrainedFeatures'
			':'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }
		)
	)*
	'}'
;

attribute returns [Attribute element = null]
@init{
	element = FeatureFactory.eINSTANCE.createAttribute();
}
:
	'Attribute'
	'{'
	(
		(
			'feature'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }

			|
			'name'
			':'
			a1 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

			|
			'type'
			':'
			a2 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("type"), resolved); copyLocalizationInfos((CommonToken) a2, element); }

			|
			'value'
			':'
			a3 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
		)
	)*
	'}'
;

annotation returns [Annotation element = null]
@init{
	element = FeatureFactory.eINSTANCE.createAnnotation();
}
:
	'Annotation'
	'{'
	(
		(
			'feature'
			':'
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
		)
	)*
	'}'
;

COMMENT
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
INTEGER
:
	('-')?('1'..'9')('0'..'9')*|'0'
;
FLOAT
:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ { channel=99; }
;
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
