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
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		(
			'{'
			'constraints'
			(
				(
					a1 = constraint{((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(a1); copyLocalizationInfos(a1, element); }
					';'
				)
			)?
			'}'
		)
	)?
	a2 = feature{element.eSet(element.eClass().getEStructuralFeature("root"), a2); copyLocalizationInfos(a2, element); }
;

constraint returns [Constraint element = null]
@init{
	element = FeatureFactory.eINSTANCE.createConstraint();
}
:
	'Constraint'
	'('
	(
		(
			a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
			(
				(
					','
					a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
				)
			)*
		)
	)?
	')'
	a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("language"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("language"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
	':'
	a3 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("expression"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expression"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
;

feature returns [Feature element = null]
@init{
	element = FeatureFactory.eINSTANCE.createFeature();
}
:
	'Feature'
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		(
			'('
			a1 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
			'..'
			a2 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
			')'
		)
	)?
	(
		(
			'/*'
			(
				a3 = attribute{((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a3); copyLocalizationInfos(a3, element); }
			)*
			'*/'
		)
	)?
	(
		(
			'['
			(
				a4 = attribute{((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a4); copyLocalizationInfos(a4, element); }
			)*
			']'
		)
	)?
	(
		(
			(
				a5 = group{((List) element.eGet(element.eClass().getEStructuralFeature("groups"))).add(a5); copyLocalizationInfos(a5, element); }
			)*
		)
	)?
;

group returns [Group element = null]
@init{
	element = FeatureFactory.eINSTANCE.createGroup();
}
:
	'Group'
	(
		(
			'('
			a0 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
			'..'
			a1 = INTEGER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
			')'
		)
	)?
	(
		(
			'{'
			(
				a2 = feature{((List) element.eGet(element.eClass().getEStructuralFeature("childFeatures"))).add(a2); copyLocalizationInfos(a2, element); }
			)*
			'}'
		)
	)?
;

attribute returns [Attribute element = null]
@init{
	element = FeatureFactory.eINSTANCE.createAttribute();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("type"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	'type'
	'='
	a2 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
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
