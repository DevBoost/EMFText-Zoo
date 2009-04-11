grammar Feature;

options {
	superClass = AbstractEMFTextParser;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.feature.resource.feature;
}

@lexer::members {
	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
	}
}
@header{
	package org.emftext.language.feature.resource.feature;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.InternalEObject;
	import org.eclipse.emf.common.util.URI;
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
	import org.emftext.runtime.IOptions;
	import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
	import org.eclipse.emf.ecore.EClass;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();
	private int lastPosition;
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
	
	// This default constructor is only used to call createInstance() on it
	public FeatureParser() {
		super();
	}
	
	protected EObject doParse() throws RecognitionException {
		lastPosition = 0;
		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = null;
		Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);
		}
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass)typeObject;
			if (type.getInstanceClass() == org.featuremapper.models.feature.FeatureModel.class) {
				return featuremodel();
			}
			if (type.getInstanceClass() == org.featuremapper.models.feature.Constraint.class) {
				return constraint();
			}
			if (type.getInstanceClass() == org.featuremapper.models.feature.Feature.class) {
				return feature();
			}
			if (type.getInstanceClass() == org.featuremapper.models.feature.Group.class) {
				return group();
			}
			if (type.getInstanceClass() == org.featuremapper.models.feature.Attribute.class) {
				return attribute();
			}
		}
		throw new org.emftext.runtime.resource.impl.UnexpectedContentTypeException(typeObject);
	}
	
	@SuppressWarnings("unchecked")
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new FeatureParser(new org.antlr.runtime.CommonTokenStream(new FeatureLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
			} else {
				return new FeatureParser(new org.antlr.runtime.CommonTokenStream(new FeatureLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
}

start returns [ EObject element = null]
:
	(
		c0 = featuremodel{ element = c0; }
	)
	EOF	
;

featuremodel returns [org.featuremapper.models.feature.FeatureModel element = null]
@init{
}
:
	a0 = 'FeatureModel' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	(
		(
			a2 = '{' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			a3 = 'constraints' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				(
					(
						a4_0 = constraint						{
							if (element == null) {
								element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__CONSTRAINTS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
					a5 = ';' {
						if (element == null) {
							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
				)
				
			)?			
			a6 = '}' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)?	
	(
		a7_0 = feature		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
			}
			if (a7_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__ROOT), a7_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a7_0, element); 		}
	)
	
;

constraint returns [org.featuremapper.models.feature.Constraint element = null]
@init{
}
:
	a0 = 'Constraint' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = TEXT		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	a2 = ':' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a3, element);
		}
	)
	
;

feature returns [org.featuremapper.models.feature.Feature element = null]
@init{
}
:
	a0 = 'Feature' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3 = INTEGER				
				{
					if (element == null) {
						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY), resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a3, element);
				}
			)
			
			a4 = '..' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			(
				a5 = INTEGER				
				{
					if (element == null) {
						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY), resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a5, element);
				}
			)
			
			a6 = ')' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)?	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				(
					a8_0 = attribute					{
						if (element == null) {
							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
						}
						if (a8_0 != null) {
							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE__ATTRIBUTES, a8_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a8_0, element); 					}
				)
				
			)*			
			a9 = ']' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a9, element);
			}
			
		)
		
	)?	
	(
		(
			(
				(
					a10_0 = group					{
						if (element == null) {
							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
						}
						if (a10_0 != null) {
							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE__GROUPS, a10_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a10_0, element); 					}
				)
				
			)*			
		)
		
	)?	
;

group returns [org.featuremapper.models.feature.Group element = null]
@init{
}
:
	a0 = 'Group' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			a1 = '(' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2 = INTEGER				
				{
					if (element == null) {
						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY), resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			)
			
			a3 = '..' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4 = INTEGER				
				{
					if (element == null) {
						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY), resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a4, element);
				}
			)
			
			a5 = ')' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		(
			a6 = '{' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
			(
				(
					a7_0 = feature					{
						if (element == null) {
							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
						}
						if (a7_0 != null) {
							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.GROUP__CHILD_FEATURES, a7_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a7_0, element); 					}
				)
				
			)*			
			a8 = '}' {
				if (element == null) {
					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			
		)
		
	)?	
;

attribute returns [org.featuremapper.models.feature.Attribute element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	(
		a1 = TEXT		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	a2 = '=' {
		if (element == null) {
			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a3, element);
		}
	)
	
;

COMMENT:
	'//'(~('\n'|'\r'))*
	{ _channel = 99; }
;
INTEGER:
	('-')?('1'..'9')('0'..'9')*|'0';
FLOAT:
	('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ 	{ _channel = 99; }
;
TEXT:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+;
WHITESPACE:
	(' ' | '\t' | '\f')
	{ _channel = 99; }
;
LINEBREAK:
	('\r\n' | '\r' | '\n')
	{ _channel = 99; }
;
QUOTED_34_34:
	('"')(~('"')|('\\''"'))*('"')
;
