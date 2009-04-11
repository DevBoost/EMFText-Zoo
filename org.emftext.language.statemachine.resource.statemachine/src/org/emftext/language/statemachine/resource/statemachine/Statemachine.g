grammar Statemachine;

options {
	superClass = AbstractEMFTextParser;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.statemachine.resource.statemachine;
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
	package org.emftext.language.statemachine.resource.statemachine;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.InternalEObject;
	import org.eclipse.emf.common.util.URI;
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
	import org.emftext.runtime.IOptions;
	import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
	import org.eclipse.emf.ecore.EClass;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new StatemachineTokenResolverFactory();
	private int lastPosition;
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
	
	// This default constructor is only used to call createInstance() on it
	public StatemachineParser() {
		super();
	}
	
	protected EObject doParse() throws RecognitionException {
		lastPosition = 0;
		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = null;
		Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);
		}
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass)typeObject;
			if (type.getInstanceClass() == org.eclipse.uml2.uml.StateMachine.class) {
				return statemachine();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.Region.class) {
				return region();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.State.class) {
				return state();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.Pseudostate.class) {
				return pseudostate();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.FinalState.class) {
				return finalstate();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.Transition.class) {
				return transition();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.Trigger.class) {
				return trigger();
			}
			if (type.getInstanceClass() == org.eclipse.uml2.uml.Activity.class) {
				return activity();
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
				return new StatemachineParser(new org.antlr.runtime.CommonTokenStream(new StatemachineLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
			} else {
				return new StatemachineParser(new org.antlr.runtime.CommonTokenStream(new StatemachineLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
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
		c0 = statemachine{ element = c0; }
	)
	EOF	
;

statemachine returns [org.eclipse.uml2.uml.StateMachine element = null]
@init{
}
:
	a0 = 'StateMachine' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	a2 = '{' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3_0 = region		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
			}
			if (a3_0 != null) {
				addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REGION, a3_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a3_0, element); 		}
	)
	
	a4 = '}' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

region returns [org.eclipse.uml2.uml.Region element = null]
@init{
}
:
	(
		(
			a0_0 = vertex			{
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.REGION__SUBVERTEX, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = 'transitions' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3_0 = transition			{
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
				}
				if (a3_0 != null) {
					addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.REGION__TRANSITION, a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		)
		
	)*	
	a4 = '}' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

state returns [org.eclipse.uml2.uml.State element = null]
@init{
}
:
	a0 = 'state' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	a2 = '{' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3 = 'entry' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			a4 = ':' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			(
				a5_0 = behavior				{
					if (element == null) {
						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
					}
					if (a5_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__ENTRY), a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			)
			
		)
		
	)?	
	(
		(
			a6 = 'exit' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
			a7 = ':' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				a8_0 = behavior				{
					if (element == null) {
						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
					}
					if (a8_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__EXIT), a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			)
			
		)
		
	)?	
	a9 = 'do' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	
	a10 = ':' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a10, element);
	}
	
	(
		a11_0 = behavior		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
			}
			if (a11_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__DO_ACTIVITY), a11_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a11_0, element); 		}
	)
	
	a12 = '}' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a12, element);
	}
	
	a13 = ';' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = finalstate{ element = c0; }
	
;

pseudostate returns [org.eclipse.uml2.uml.Pseudostate element = null]
@init{
}
:
	(
		a0 = PSEUDOKIND		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PSEUDOKIND");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			org.eclipse.uml2.uml.PseudostateKind resolved = (org.eclipse.uml2.uml.PseudostateKind)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	a1 = 'state' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
		}
	)
	
	a3 = ';' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
;

finalstate returns [org.eclipse.uml2.uml.FinalState element = null]
@init{
}
:
	a0 = 'final' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = 'state' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
		}
	)
	
	a3 = '{' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		(
			a4 = 'entry' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			a5 = ':' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6_0 = behavior				{
					if (element == null) {
						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
					}
					if (a6_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__ENTRY), a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			)
			
		)
		
	)?	
	(
		(
			a7 = 'exit' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			a8 = ':' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			
			(
				a9_0 = behavior				{
					if (element == null) {
						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
					}
					if (a9_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__EXIT), a9_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a9_0, element); 				}
			)
			
		)
		
	)?	
	a10 = 'do' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a10, element);
	}
	
	a11 = ':' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a11, element);
	}
	
	(
		a12_0 = behavior		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
			}
			if (a12_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__DO_ACTIVITY), a12_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a12_0, element); 		}
	)
	
	a13 = '}' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	a14 = ';' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a14, element);
	}
	
;

transition returns [org.eclipse.uml2.uml.Transition element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.eclipse.uml2.uml.State proxy = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.eclipse.uml2.uml.Transition, org.eclipse.uml2.uml.Vertex>(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	)
	
	a1 = '->' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = TEXT		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.eclipse.uml2.uml.State proxy = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.eclipse.uml2.uml.Transition, org.eclipse.uml2.uml.Vertex>(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
			copyLocalizationInfos((CommonToken) a2, proxy);
		}
	)
	
	a3 = 'when' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = trigger		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
			}
			if (a4_0 != null) {
				addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.TRANSITION__TRIGGER, a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
	(
		(
			a5 = 'do' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			a6 = ':' {
				if (element == null) {
					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
			(
				a7_0 = behavior				{
					if (element == null) {
						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
					}
					if (a7_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__EFFECT), a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)
		
	)?	
	a8 = ';' {
		if (element == null) {
			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	
;

trigger returns [org.eclipse.uml2.uml.Trigger element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTrigger();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

activity returns [org.eclipse.uml2.uml.Activity element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActivity();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

vertex returns [org.eclipse.uml2.uml.Vertex element = null]
:
	c0 = state{ element = c0; }
	|	c1 = pseudostate{ element = c1; }
	|	c2 = finalstate{ element = c2; }
	
;

behavior returns [org.eclipse.uml2.uml.Behavior element = null]
:
	c0 = statemachine{ element = c0; }
	|	c1 = activity{ element = c1; }
	
;

PSEUDOKIND:
	'initial';
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
