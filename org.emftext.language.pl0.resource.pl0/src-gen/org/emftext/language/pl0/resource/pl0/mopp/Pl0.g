grammar Pl0;

options {
	superClass = Pl0ANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.pl0.resource.pl0.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.pl0.resource.pl0.mopp;
}

@members{
	private org.emftext.language.pl0.resource.pl0.IPl0TokenResolverFactory tokenResolverFactory = new org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolverFactory();
	@SuppressWarnings("unused")
	
	private int lastPosition;
	private org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolveResult tokenResolveResult = new org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private java.util.List<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal>();
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>> postParseCommands;
	private boolean terminateParsing;
	private int tokenIndexOfLastCompleteElement;
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>() {
			public boolean execute(org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.pl0.resource.pl0.IPl0Problem() {
					public org.emftext.language.pl0.resource.pl0.Pl0EProblemType getType() {
						return org.emftext.language.pl0.resource.pl0.Pl0EProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.pl0.resource.pl0.mopp.Pl0DummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.language.pl0.resource.pl0.util.Pl0MapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.language.pl0.resource.pl0.mopp.Pl0DummyEObject);
			org.emftext.language.pl0.resource.pl0.mopp.Pl0DummyEObject dummy = (org.emftext.language.pl0.resource.pl0.mopp.Pl0DummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		for (; endPos >= this.lastPosition; endPos--) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(endPos);
			int _channel = token.getChannel();
			if (_channel != 99) {
				break;
			}
		}
		for (int pos = this.lastPosition; pos < endPos; pos++) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
			int _channel = token.getChannel();
			if (_channel == 99) {
				if (token.getType() == Pl0Lexer.SL_COMMENT) {
					org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature("comments");
					if (feature != null) {
						// call token resolver
						org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolvedResolver = tokenResolverFactory.createCollectInTokenResolver("comments");
						resolvedResolver.setOptions(getOptions());
						org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult resolvedResult = getFreshTokenResolveResult();
						resolvedResolver.resolve(token.getText(), feature, resolvedResult);
						java.lang.Object resolvedObject = resolvedResult.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(resolvedResult.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) token).getLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) token).getStopIndex());
						}
						if (java.lang.String.class.isInstance(resolvedObject)) {
							((java.util.List) element.eGet(feature)).add((java.lang.String) resolvedObject);
						} else {
							System.out.println("WARNING: Attribute comments for token " + token + " has wrong type in element " + element + " (expected java.lang.String).");
						}
					} else {
						System.out.println("WARNING: Attribute comments for token " + token + " was not found in element " + element + ".");
					}
				}
				if (token.getType() == Pl0Lexer.ML_COMMENT) {
					org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature("comments");
					if (feature != null) {
						// call token resolver
						org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolvedResolver = tokenResolverFactory.createCollectInTokenResolver("comments");
						resolvedResolver.setOptions(getOptions());
						org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult resolvedResult = getFreshTokenResolveResult();
						resolvedResolver.resolve(token.getText(), feature, resolvedResult);
						java.lang.Object resolvedObject = resolvedResult.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(resolvedResult.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) token).getLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) token).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) token).getStopIndex());
						}
						if (java.lang.String.class.isInstance(resolvedObject)) {
							((java.util.List) element.eGet(feature)).add((java.lang.String) resolvedObject);
						} else {
							System.out.println("WARNING: Attribute comments for token " + token + " has wrong type in element " + element + " (expected java.lang.String).");
						}
					} else {
						System.out.println("WARNING: Attribute comments for token " + token + " was not found in element " + element + ".");
					}
				}
			}
		}
		this.lastPosition = (endPos < 0 ? 0 : endPos);
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>() {
			public boolean execute(org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
				org.emftext.language.pl0.resource.pl0.IPl0LocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_2_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>() {
			public boolean execute(org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
				org.emftext.language.pl0.resource.pl0.IPl0LocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new Pl0Parser(new org.antlr.runtime3_2_0.CommonTokenStream(new Pl0Lexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new Pl0Parser(new org.antlr.runtime3_2_0.CommonTokenStream(new Pl0Lexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.language.pl0.resource.pl0.mopp.Pl0Plugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	// This default constructor is only used to call createInstance() on it
	public Pl0Parser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((Pl0Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((Pl0Lexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.pl0.Program.class) {
				return parse_org_emftext_language_pl0_Program();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.Block.class) {
				return parse_org_emftext_language_pl0_Block();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.ConstDeclaration.class) {
				return parse_org_emftext_language_pl0_ConstDeclaration();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.VarDeclaration.class) {
				return parse_org_emftext_language_pl0_VarDeclaration();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.ProcedureDeclaration.class) {
				return parse_org_emftext_language_pl0_ProcedureDeclaration();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.Body.class) {
				return parse_org_emftext_language_pl0_Body();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.CallStatement.class) {
				return parse_org_emftext_language_pl0_CallStatement();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.WhileStatement.class) {
				return parse_org_emftext_language_pl0_WhileStatement();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.IfStatement.class) {
				return parse_org_emftext_language_pl0_IfStatement();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.OddCondition.class) {
				return parse_org_emftext_language_pl0_OddCondition();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.RelationalCondition.class) {
				return parse_org_emftext_language_pl0_RelationalCondition();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.Assignment.class) {
				return parse_org_emftext_language_pl0_Assignment();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.TermExpression.class) {
				return parse_org_emftext_language_pl0_TermExpression();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.OptionalTerm.class) {
				return parse_org_emftext_language_pl0_OptionalTerm();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.Term.class) {
				return parse_org_emftext_language_pl0_Term();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.OptionalFactor.class) {
				return parse_org_emftext_language_pl0_OptionalFactor();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.IdentReference.class) {
				return parse_org_emftext_language_pl0_IdentReference();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.Number.class) {
				return parse_org_emftext_language_pl0_Number();
			}
			if (type.getInstanceClass() == org.emftext.language.pl0.ExpressionFactor.class) {
				return parse_org_emftext_language_pl0_ExpressionFactor();
			}
		}
		throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0UnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public java.lang.Object getMissingSymbol(org.antlr.runtime3_2_0.IntStream arg0, org.antlr.runtime3_2_0.RecognitionException arg1, int arg2, org.antlr.runtime3_2_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	protected java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation getMetaInformation() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.language.pl0.resource.pl0.mopp.Pl0ReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.pl0.resource.pl0.mopp.Pl0ReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.pl0.resource.pl0.IPl0Options.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	// Implementation that calls {@link #doParse()}  and handles the thrown
	// RecognitionExceptions.
	public org.emftext.language.pl0.resource.pl0.IPl0ParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>>();
		org.emftext.language.pl0.resource.pl0.mopp.Pl0ParseResult parseResult = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				//? can be caused if a null is set on EMF models where not allowed;
				//? this will just happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_2_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.pl0.resource.pl0.IPl0TextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.language.pl0.resource.pl0.IPl0ParseResult result = parse();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
			}
			for (org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal>();
		java.util.List<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				System.out.println("FOLLOW ELEMENT " + expectedElementI);
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 98;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			System.out.println("REMAINING TOKEN: " + nextToken);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected terminals
				// can be set
				for (org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are kept
				for (org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal nextFollow : currentFollowSet) {
					System.out.println("CHECKING : " + nextFollow);
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						System.out.println("MATCH! " + nextFollow);
						java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement newFollower : newFollowers) {
							org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal newFollowTerminal = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(newFollower, followSetID);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements that were
		// added during the last iteration of the loop
		for (org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = java.lang.Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_2_0.CommonToken tokenAtIndex = (org.antlr.runtime3_2_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = java.lang.Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime3_2_0.IntStream input, int ttype, org.antlr.runtime3_2_0.BitSet follow) throws org.antlr.runtime3_2_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.language.pl0.resource.pl0.mopp.Pl0ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>() {
			public boolean execute(org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	// Translates errors thrown by the parser into human readable messages.
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			java.lang.String tokenName = "<unknown>";
			if (mte.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mte.expecting];
				tokenName = org.emftext.language.pl0.resource.pl0.util.Pl0StringUtil.formatTokenName(tokenName);
			}
			message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			java.lang.String tokenName = "<unknown>";
			if (mtne.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mtne.expecting];
			}
			message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
		}
		// the resource may be null if the parse is used for code completion
		final java.lang.String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_2_0.CommonToken) {
			final org.antlr.runtime3_2_0.CommonToken ct = (org.antlr.runtime3_2_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	// Translates errors thrown by the lexer into human readable messages.
	public void reportLexicalError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = "";
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			org.antlr.runtime3_2_0.EarlyExitException eee = (org.antlr.runtime3_2_0.EarlyExitException) e;
			message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message ="rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void completedElement(Object element) {
		if (element instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_0 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("program");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_1 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("PROGRAM");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_2 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getProgram().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_3 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("const");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_4 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("CONST");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_5 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("var");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_6 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("VAR");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_7 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("procedure");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_8 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("PROCEDURE");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_9 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("begin");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_10 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("BEGIN");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_11 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(".");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_12 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getConstDeclaration().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_13 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(",");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_14 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(";");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_15 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getVarDeclaration().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_16 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(",");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_17 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(";");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_18 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(";");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_19 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("=");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_20 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getConstDeclaration().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER), "NUMBER");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_21 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getProcedureDeclaration().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_22 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(";");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_23 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("call");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_24 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("CALL");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_25 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("while");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_26 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("WHILE");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_27 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("if");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_28 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("IF");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_29 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getAssignment().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_30 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("end");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_31 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("END");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_32 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(";");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_33 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("else");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_34 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("ELSE");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_35 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getCallStatement().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_36 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("odd");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_37 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("ODD");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_38 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getTermExpression().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP), "PLUS_MINUS");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_39 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getIdentReference().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT), "PL0ID");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_40 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getNumber().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER), "NUMBER");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_41 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("(");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_42 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("DO");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_43 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("do");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_44 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("then");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_45 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString("THEN");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_46 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getRelationalCondition().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP), "REL_OP");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_47 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(":=");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_48 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getOptionalTerm().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP), "PLUS_MINUS");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_49 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedCsString(")");
	private final static org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement TERMINAL_50 = new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedStructuralFeature(org.emftext.language.pl0.PL0Package.eINSTANCE.getOptionalFactor().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP), "MUL_DIV");
	
	public static void wire0() {
		TERMINAL_0.addFollower(TERMINAL_2);
		TERMINAL_1.addFollower(TERMINAL_2);
		TERMINAL_2.addFollower(TERMINAL_3);
		TERMINAL_2.addFollower(TERMINAL_4);
		TERMINAL_2.addFollower(TERMINAL_5);
		TERMINAL_2.addFollower(TERMINAL_6);
		TERMINAL_2.addFollower(TERMINAL_7);
		TERMINAL_2.addFollower(TERMINAL_8);
		TERMINAL_2.addFollower(TERMINAL_9);
		TERMINAL_2.addFollower(TERMINAL_10);
		TERMINAL_3.addFollower(TERMINAL_12);
		TERMINAL_4.addFollower(TERMINAL_12);
		TERMINAL_13.addFollower(TERMINAL_12);
		TERMINAL_14.addFollower(TERMINAL_5);
		TERMINAL_14.addFollower(TERMINAL_6);
		TERMINAL_14.addFollower(TERMINAL_7);
		TERMINAL_14.addFollower(TERMINAL_8);
		TERMINAL_14.addFollower(TERMINAL_9);
		TERMINAL_14.addFollower(TERMINAL_10);
		TERMINAL_5.addFollower(TERMINAL_15);
		TERMINAL_6.addFollower(TERMINAL_15);
		TERMINAL_16.addFollower(TERMINAL_15);
		TERMINAL_17.addFollower(TERMINAL_7);
		TERMINAL_17.addFollower(TERMINAL_8);
		TERMINAL_17.addFollower(TERMINAL_9);
		TERMINAL_17.addFollower(TERMINAL_10);
		TERMINAL_12.addFollower(TERMINAL_19);
		TERMINAL_19.addFollower(TERMINAL_20);
		TERMINAL_20.addFollower(TERMINAL_13);
		TERMINAL_20.addFollower(TERMINAL_14);
		TERMINAL_15.addFollower(TERMINAL_16);
		TERMINAL_15.addFollower(TERMINAL_17);
		TERMINAL_7.addFollower(TERMINAL_21);
		TERMINAL_8.addFollower(TERMINAL_21);
		TERMINAL_21.addFollower(TERMINAL_22);
		TERMINAL_22.addFollower(TERMINAL_3);
		TERMINAL_22.addFollower(TERMINAL_4);
		TERMINAL_22.addFollower(TERMINAL_5);
		TERMINAL_22.addFollower(TERMINAL_6);
		TERMINAL_22.addFollower(TERMINAL_7);
		TERMINAL_22.addFollower(TERMINAL_8);
		TERMINAL_22.addFollower(TERMINAL_9);
		TERMINAL_22.addFollower(TERMINAL_10);
		TERMINAL_18.addFollower(TERMINAL_7);
		TERMINAL_18.addFollower(TERMINAL_8);
		TERMINAL_18.addFollower(TERMINAL_9);
		TERMINAL_18.addFollower(TERMINAL_10);
		TERMINAL_9.addFollower(TERMINAL_23);
		TERMINAL_9.addFollower(TERMINAL_24);
		TERMINAL_9.addFollower(TERMINAL_25);
		TERMINAL_9.addFollower(TERMINAL_26);
		TERMINAL_9.addFollower(TERMINAL_27);
		TERMINAL_9.addFollower(TERMINAL_28);
		TERMINAL_9.addFollower(TERMINAL_29);
		TERMINAL_9.addFollower(TERMINAL_30);
		TERMINAL_9.addFollower(TERMINAL_31);
		TERMINAL_10.addFollower(TERMINAL_23);
		TERMINAL_10.addFollower(TERMINAL_24);
		TERMINAL_10.addFollower(TERMINAL_25);
		TERMINAL_10.addFollower(TERMINAL_26);
		TERMINAL_10.addFollower(TERMINAL_27);
		TERMINAL_10.addFollower(TERMINAL_28);
		TERMINAL_10.addFollower(TERMINAL_29);
		TERMINAL_10.addFollower(TERMINAL_30);
		TERMINAL_10.addFollower(TERMINAL_31);
		TERMINAL_32.addFollower(TERMINAL_23);
		TERMINAL_32.addFollower(TERMINAL_24);
		TERMINAL_32.addFollower(TERMINAL_25);
		TERMINAL_32.addFollower(TERMINAL_26);
		TERMINAL_32.addFollower(TERMINAL_27);
		TERMINAL_32.addFollower(TERMINAL_28);
		TERMINAL_32.addFollower(TERMINAL_29);
		TERMINAL_30.addFollower(TERMINAL_11);
		TERMINAL_30.addFollower(TERMINAL_18);
		TERMINAL_30.addFollower(TERMINAL_32);
		TERMINAL_30.addFollower(TERMINAL_30);
		TERMINAL_30.addFollower(TERMINAL_31);
		TERMINAL_30.addFollower(TERMINAL_33);
		TERMINAL_30.addFollower(TERMINAL_34);
		TERMINAL_31.addFollower(TERMINAL_11);
		TERMINAL_31.addFollower(TERMINAL_18);
		TERMINAL_31.addFollower(TERMINAL_32);
		TERMINAL_31.addFollower(TERMINAL_30);
		TERMINAL_31.addFollower(TERMINAL_31);
		TERMINAL_31.addFollower(TERMINAL_33);
		TERMINAL_31.addFollower(TERMINAL_34);
		TERMINAL_23.addFollower(TERMINAL_35);
		TERMINAL_24.addFollower(TERMINAL_35);
		TERMINAL_35.addFollower(TERMINAL_32);
		TERMINAL_35.addFollower(TERMINAL_30);
		TERMINAL_35.addFollower(TERMINAL_31);
		TERMINAL_25.addFollower(TERMINAL_36);
		TERMINAL_25.addFollower(TERMINAL_37);
		TERMINAL_25.addFollower(TERMINAL_38);
		TERMINAL_25.addFollower(TERMINAL_39);
		TERMINAL_25.addFollower(TERMINAL_40);
		TERMINAL_25.addFollower(TERMINAL_41);
		TERMINAL_26.addFollower(TERMINAL_36);
		TERMINAL_26.addFollower(TERMINAL_37);
		TERMINAL_26.addFollower(TERMINAL_38);
		TERMINAL_26.addFollower(TERMINAL_39);
		TERMINAL_26.addFollower(TERMINAL_40);
		TERMINAL_26.addFollower(TERMINAL_41);
		TERMINAL_42.addFollower(TERMINAL_9);
		TERMINAL_42.addFollower(TERMINAL_10);
		TERMINAL_43.addFollower(TERMINAL_9);
		TERMINAL_43.addFollower(TERMINAL_10);
		TERMINAL_27.addFollower(TERMINAL_36);
		TERMINAL_27.addFollower(TERMINAL_37);
		TERMINAL_27.addFollower(TERMINAL_38);
		TERMINAL_27.addFollower(TERMINAL_39);
		TERMINAL_27.addFollower(TERMINAL_40);
		TERMINAL_27.addFollower(TERMINAL_41);
		TERMINAL_28.addFollower(TERMINAL_36);
		TERMINAL_28.addFollower(TERMINAL_37);
		TERMINAL_28.addFollower(TERMINAL_38);
		TERMINAL_28.addFollower(TERMINAL_39);
		TERMINAL_28.addFollower(TERMINAL_40);
		TERMINAL_28.addFollower(TERMINAL_41);
		TERMINAL_44.addFollower(TERMINAL_9);
		TERMINAL_44.addFollower(TERMINAL_10);
		TERMINAL_45.addFollower(TERMINAL_9);
		TERMINAL_45.addFollower(TERMINAL_10);
		TERMINAL_33.addFollower(TERMINAL_9);
		TERMINAL_33.addFollower(TERMINAL_10);
		TERMINAL_34.addFollower(TERMINAL_9);
		TERMINAL_34.addFollower(TERMINAL_10);
		TERMINAL_36.addFollower(TERMINAL_38);
		TERMINAL_36.addFollower(TERMINAL_39);
		TERMINAL_36.addFollower(TERMINAL_40);
		TERMINAL_36.addFollower(TERMINAL_41);
		TERMINAL_37.addFollower(TERMINAL_38);
		TERMINAL_37.addFollower(TERMINAL_39);
		TERMINAL_37.addFollower(TERMINAL_40);
		TERMINAL_37.addFollower(TERMINAL_41);
		TERMINAL_46.addFollower(TERMINAL_38);
		TERMINAL_46.addFollower(TERMINAL_39);
		TERMINAL_46.addFollower(TERMINAL_40);
		TERMINAL_46.addFollower(TERMINAL_41);
		TERMINAL_29.addFollower(TERMINAL_47);
		TERMINAL_47.addFollower(TERMINAL_38);
		TERMINAL_47.addFollower(TERMINAL_39);
		TERMINAL_47.addFollower(TERMINAL_40);
		TERMINAL_47.addFollower(TERMINAL_41);
		TERMINAL_38.addFollower(TERMINAL_39);
		TERMINAL_38.addFollower(TERMINAL_40);
		TERMINAL_38.addFollower(TERMINAL_41);
		TERMINAL_48.addFollower(TERMINAL_39);
		TERMINAL_48.addFollower(TERMINAL_40);
		TERMINAL_48.addFollower(TERMINAL_41);
		TERMINAL_50.addFollower(TERMINAL_39);
		TERMINAL_50.addFollower(TERMINAL_40);
		TERMINAL_50.addFollower(TERMINAL_41);
		TERMINAL_39.addFollower(TERMINAL_50);
		TERMINAL_39.addFollower(TERMINAL_48);
		TERMINAL_39.addFollower(TERMINAL_42);
		TERMINAL_39.addFollower(TERMINAL_43);
		TERMINAL_39.addFollower(TERMINAL_44);
		TERMINAL_39.addFollower(TERMINAL_45);
		TERMINAL_39.addFollower(TERMINAL_46);
		TERMINAL_39.addFollower(TERMINAL_32);
		TERMINAL_39.addFollower(TERMINAL_30);
		TERMINAL_39.addFollower(TERMINAL_31);
		TERMINAL_39.addFollower(TERMINAL_49);
		TERMINAL_40.addFollower(TERMINAL_50);
		TERMINAL_40.addFollower(TERMINAL_48);
		TERMINAL_40.addFollower(TERMINAL_42);
		TERMINAL_40.addFollower(TERMINAL_43);
		TERMINAL_40.addFollower(TERMINAL_44);
		TERMINAL_40.addFollower(TERMINAL_45);
		TERMINAL_40.addFollower(TERMINAL_46);
		TERMINAL_40.addFollower(TERMINAL_32);
		TERMINAL_40.addFollower(TERMINAL_30);
		TERMINAL_40.addFollower(TERMINAL_31);
		TERMINAL_40.addFollower(TERMINAL_49);
		TERMINAL_41.addFollower(TERMINAL_38);
		TERMINAL_41.addFollower(TERMINAL_39);
		TERMINAL_41.addFollower(TERMINAL_40);
		TERMINAL_41.addFollower(TERMINAL_41);
		TERMINAL_49.addFollower(TERMINAL_50);
		TERMINAL_49.addFollower(TERMINAL_48);
		TERMINAL_49.addFollower(TERMINAL_42);
		TERMINAL_49.addFollower(TERMINAL_43);
		TERMINAL_49.addFollower(TERMINAL_44);
		TERMINAL_49.addFollower(TERMINAL_45);
		TERMINAL_49.addFollower(TERMINAL_46);
		TERMINAL_49.addFollower(TERMINAL_32);
		TERMINAL_49.addFollower(TERMINAL_30);
		TERMINAL_49.addFollower(TERMINAL_31);
		TERMINAL_49.addFollower(TERMINAL_49);
	}
	// wire the terminals
	static {
		wire0();
	}
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_0, 0));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_1, 0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_language_pl0_Program{ element = c0; }
	)
	EOF	
;

parse_org_emftext_language_pl0_Program returns [org.emftext.language.pl0.Program element = null]
@init{
}
:
	(
		a0 = 'program' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 1));
		}
		
		
		|		a1 = 'PROGRAM' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 2));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 3));
	}
	
	(
		a2 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
			}
			if (a2 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_3, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_4, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 4));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 4));
	}
	
	(
		a3_0 = parse_org_emftext_language_pl0_Block		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__BLOCK), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 5));
	}
	
	a4 = '.' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_language_pl0_Block returns [org.emftext.language.pl0.Block element = null]
@init{
}
:
	(
		(
			(
				a0 = 'const' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 7));
				}
				
				
				|				a1 = 'CONST' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 8));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 9));
			}
			
			(
				a2_0 = parse_org_emftext_language_pl0_ConstDeclaration				{
					if (terminateParsing) {
						throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, org.emftext.language.pl0.PL0Package.BLOCK__CONSTANTS, a2_0);
							completedElement(a2_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a2_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 10));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 10));
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 11));
					}
					
					(
						a4_0 = parse_org_emftext_language_pl0_ConstDeclaration						{
							if (terminateParsing) {
								throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									addObjectToList(element, org.emftext.language.pl0.PL0Package.BLOCK__CONSTANTS, a4_0);
									completedElement(a4_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a4_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 12));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 12));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 13));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 13));
			}
			
			a5 = ';' {
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 14));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 14));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 14));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 14));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 14));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 14));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 15));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 15));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 15));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 15));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 15));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 15));
	}
	
	(
		(
			(
				a6 = 'var' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 16));
				}
				
				
				|				a7 = 'VAR' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 17));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 18));
			}
			
			(
				a8_0 = parse_org_emftext_language_pl0_VarDeclaration				{
					if (terminateParsing) {
						throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							addObjectToList(element, org.emftext.language.pl0.PL0Package.BLOCK__VARIABLES, a8_0);
							completedElement(a8_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a8_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 19));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 19));
			}
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 20));
					}
					
					(
						a10_0 = parse_org_emftext_language_pl0_VarDeclaration						{
							if (terminateParsing) {
								throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
							}
							if (a10_0 != null) {
								if (a10_0 != null) {
									addObjectToList(element, org.emftext.language.pl0.PL0Package.BLOCK__VARIABLES, a10_0);
									completedElement(a10_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a10_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 21));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 21));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 22));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 22));
			}
			
			a11 = ';' {
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 23));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 23));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 23));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 23));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 24));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 24));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 24));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 24));
	}
	
	(
		(
			a12_0 = parse_org_emftext_language_pl0_ProcedureDeclaration			{
				if (terminateParsing) {
					throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
				}
				if (a12_0 != null) {
					if (a12_0 != null) {
						addObjectToList(element, org.emftext.language.pl0.PL0Package.BLOCK__PROCEDURES, a12_0);
						completedElement(a12_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a12_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 25));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 25));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 25));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 25));
	}
	
	(
		a13_0 = parse_org_emftext_language_pl0_Body		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
			}
			if (a13_0 != null) {
				if (a13_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__BODY), a13_0);
					completedElement(a13_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a13_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 26));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 26));
	}
	
;

parse_org_emftext_language_pl0_ConstDeclaration returns [org.emftext.language.pl0.ConstDeclaration element = null]
@init{
}
:
	(
		a0 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createConstDeclaration();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_19, 27));
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createConstDeclaration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_20, 28));
	}
	
	(
		a2 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createConstDeclaration();
			}
			if (a2 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 29));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 29));
	}
	
;

parse_org_emftext_language_pl0_VarDeclaration returns [org.emftext.language.pl0.VarDeclaration element = null]
@init{
}
:
	(
		a0 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createVarDeclaration();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 30));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 30));
	}
	
;

parse_org_emftext_language_pl0_ProcedureDeclaration returns [org.emftext.language.pl0.ProcedureDeclaration element = null]
@init{
}
:
	(
		a0 = 'procedure' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 31));
		}
		
		
		|		a1 = 'PROCEDURE' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 32));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 33));
	}
	
	(
		a2 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
			}
			if (a2 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_22, 34));
	}
	
	a3 = ';' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_3, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_4, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 35));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 35));
	}
	
	(
		a4_0 = parse_org_emftext_language_pl0_Block		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__BLOCK), a4_0);
					completedElement(a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 36));
	}
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 37));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 37));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 37));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 37));
	}
	
;

parse_org_emftext_language_pl0_Body returns [org.emftext.language.pl0.Body element = null]
@init{
}
:
	(
		a0 = 'begin' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_23, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_24, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_25, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_26, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_27, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_28, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_29, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 38));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 38));
		}
		
		
		|		a1 = 'BEGIN' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_23, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_24, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_25, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_26, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_27, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_28, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_29, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 39));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 39));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_23, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_24, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_25, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_26, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_27, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_28, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_29, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 40));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 40));
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_pl0_Statement				{
					if (terminateParsing) {
						throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, org.emftext.language.pl0.PL0Package.BODY__STATEMENTS, a2_0);
							completedElement(a2_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a2_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 41));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 41));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 41));
			}
			
			(
				(
					a3 = ';' {
						if (element == null) {
							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_23, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_24, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_25, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_26, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_27, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_28, 42));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_29, 42));
					}
					
					(
						a4_0 = parse_org_emftext_language_pl0_Statement						{
							if (terminateParsing) {
								throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									addObjectToList(element, org.emftext.language.pl0.PL0Package.BODY__STATEMENTS, a4_0);
									completedElement(a4_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a4_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 43));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 43));
						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 43));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 44));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 44));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 44));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 45));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 45));
	}
	
	(
		a5 = 'end' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 46));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 46));
		}
		
		
		|		a6 = 'END' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 47));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 47));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 48));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 48));
	}
	
;

parse_org_emftext_language_pl0_CallStatement returns [org.emftext.language.pl0.CallStatement element = null]
@init{
}
:
	(
		a0 = 'call' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createCallStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 49));
		}
		
		
		|		a1 = 'CALL' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createCallStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 50));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 51));
	}
	
	(
		a2 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createCallStatement();
			}
			if (a2 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.pl0.ProcedureDeclaration proxy = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ContextDependentURIFragmentFactory<org.emftext.language.pl0.CallStatement, org.emftext.language.pl0.ProcedureDeclaration>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCallStatementProcedureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 52));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 52));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 52));
	}
	
;

parse_org_emftext_language_pl0_WhileStatement returns [org.emftext.language.pl0.WhileStatement element = null]
@init{
}
:
	(
		a0 = 'while' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 53));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 53));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 53));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 53));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 53));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 53));
		}
		
		
		|		a1 = 'WHILE' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 54));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 54));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 54));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 54));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 54));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 54));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 55));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 55));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 55));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 55));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 55));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 55));
	}
	
	(
		a2_0 = parse_org_emftext_language_pl0_Condition		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__CONDITION), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 56));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 56));
	}
	
	(
		a3 = 'DO' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 57));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 57));
		}
		
		
		|		a4 = 'do' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 58));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 58));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 59));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 59));
	}
	
	(
		a5_0 = parse_org_emftext_language_pl0_Body		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__DO), a5_0);
					completedElement(a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 60));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 60));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 60));
	}
	
;

parse_org_emftext_language_pl0_IfStatement returns [org.emftext.language.pl0.IfStatement element = null]
@init{
}
:
	(
		a0 = 'if' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 61));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 61));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 61));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 61));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 61));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 61));
		}
		
		
		|		a1 = 'IF' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 62));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 62));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 62));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 62));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 62));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 62));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 63));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 63));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 63));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 63));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 63));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 63));
	}
	
	(
		a2_0 = parse_org_emftext_language_pl0_Condition		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__CONDITION), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 64));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 64));
	}
	
	(
		a3 = 'then' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 65));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 65));
		}
		
		
		|		a4 = 'THEN' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 66));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 66));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 67));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 67));
	}
	
	(
		a5_0 = parse_org_emftext_language_pl0_Body		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__THEN), a5_0);
					completedElement(a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 68));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 68));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 68));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 68));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 68));
	}
	
	(
		(
			(
				a6 = 'else' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 69));
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 69));
				}
				
				
				|				a7 = 'ELSE' {
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 70));
					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 70));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 71));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 71));
			}
			
			(
				a8_0 = parse_org_emftext_language_pl0_Body				{
					if (terminateParsing) {
						throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__ELSE), a8_0);
							completedElement(a8_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a8_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 72));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 72));
				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 72));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 73));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 73));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 73));
	}
	
;

parse_org_emftext_language_pl0_OddCondition returns [org.emftext.language.pl0.OddCondition element = null]
@init{
}
:
	(
		a0 = 'odd' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOddCondition();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 74));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 74));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 74));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 74));
		}
		
		
		|		a1 = 'ODD' {
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOddCondition();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 75));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 75));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 75));
			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 75));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 76));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 76));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 76));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 76));
	}
	
	(
		a2_0 = parse_org_emftext_language_pl0_Expression		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOddCondition();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ODD_CONDITION__EXPRESSION), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 77));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 77));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 77));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 77));
	}
	
;

parse_org_emftext_language_pl0_RelationalCondition returns [org.emftext.language.pl0.RelationalCondition element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_pl0_Expression		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createRelationalCondition();
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__LEFT), a0_0);
					completedElement(a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 78));
	}
	
	(
		a1 = REL_OP		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createRelationalCondition();
			}
			if (a1 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("REL_OP");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				org.emftext.language.pl0.RelationalOperator resolved = (org.emftext.language.pl0.RelationalOperator)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 79));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 79));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 79));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 79));
	}
	
	(
		a2_0 = parse_org_emftext_language_pl0_Expression		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createRelationalCondition();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__RIGHT), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 80));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 80));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 80));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 80));
	}
	
;

parse_org_emftext_language_pl0_Assignment returns [org.emftext.language.pl0.Assignment element = null]
@init{
}
:
	(
		a0 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createAssignment();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.pl0.VarDeclaration proxy = org.emftext.language.pl0.PL0Factory.eINSTANCE.createVarDeclaration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ContextDependentURIFragmentFactory<org.emftext.language.pl0.Assignment, org.emftext.language.pl0.VarDeclaration>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAssignmentLeftReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_47, 81));
	}
	
	a1 = ':=' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createAssignment();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 82));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 82));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 82));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 82));
	}
	
	(
		a2_0 = parse_org_emftext_language_pl0_Expression		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createAssignment();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__RIGHT), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 83));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 83));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 83));
	}
	
;

parse_org_emftext_language_pl0_TermExpression returns [org.emftext.language.pl0.TermExpression element = null]
@init{
}
:
	(
		(
			a0 = PLUS_MINUS			
			{
				if (terminateParsing) {
					throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createTermExpression();
				}
				if (a0 != null) {
					org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PLUS_MINUS");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
					}
					org.emftext.language.pl0.PlusMinusOperator resolved = (org.emftext.language.pl0.PlusMinusOperator)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP), resolved);
						completedElement(resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 84));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 84));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 84));
	}
	
	(
		a1_0 = parse_org_emftext_language_pl0_Term		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createTermExpression();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OBLIGATORY), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 85));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 85));
	}
	
	(
		(
			a2_0 = parse_org_emftext_language_pl0_OptionalTerm			{
				if (terminateParsing) {
					throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createTermExpression();
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OPTIONAL, a2_0);
						completedElement(a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 86));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 86));
	}
	
;

parse_org_emftext_language_pl0_OptionalTerm returns [org.emftext.language.pl0.OptionalTerm element = null]
@init{
}
:
	(
		a0 = PLUS_MINUS		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOptionalTerm();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PLUS_MINUS");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.language.pl0.PlusMinusOperator resolved = (org.emftext.language.pl0.PlusMinusOperator)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 87));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 87));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 87));
	}
	
	(
		a1_0 = parse_org_emftext_language_pl0_Term		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOptionalTerm();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__TERM), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 88));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 88));
	}
	
;

parse_org_emftext_language_pl0_Term returns [org.emftext.language.pl0.Term element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_pl0_Factor		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createTerm();
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM__OBLIGATORY), a0_0);
					completedElement(a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 89));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 89));
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_pl0_OptionalFactor			{
				if (terminateParsing) {
					throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createTerm();
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.pl0.PL0Package.TERM__OPTIONAL, a1_0);
						completedElement(a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 90));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 90));
	}
	
;

parse_org_emftext_language_pl0_OptionalFactor returns [org.emftext.language.pl0.OptionalFactor element = null]
@init{
}
:
	(
		a0 = MUL_DIV		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOptionalFactor();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MUL_DIV");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.language.pl0.MulDivOperator resolved = (org.emftext.language.pl0.MulDivOperator)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 91));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 91));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 91));
	}
	
	(
		a1_0 = parse_org_emftext_language_pl0_Factor		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOptionalFactor();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__FACTOR), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 92));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 92));
	}
	
;

parse_org_emftext_language_pl0_IdentReference returns [org.emftext.language.pl0.IdentReference element = null]
@init{
}
:
	(
		a0 = PL0ID		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIdentReference();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PL0ID");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.pl0.VarDeclaration proxy = org.emftext.language.pl0.PL0Factory.eINSTANCE.createVarDeclaration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ContextDependentURIFragmentFactory<org.emftext.language.pl0.IdentReference, org.emftext.language.pl0.Declaration>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getIdentReferenceIdentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 93));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 93));
	}
	
;

parse_org_emftext_language_pl0_Number returns [org.emftext.language.pl0.Number element = null]
@init{
}
:
	(
		a0 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createNumber();
			}
			if (a0 != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 94));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 94));
	}
	
;

parse_org_emftext_language_pl0_ExpressionFactor returns [org.emftext.language.pl0.ExpressionFactor element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createExpressionFactor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 95));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 95));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 95));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 95));
	}
	
	(
		a1_0 = parse_org_emftext_language_pl0_Expression		{
			if (terminateParsing) {
				throw new org.emftext.language.pl0.resource.pl0.mopp.Pl0TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createExpressionFactor();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.EXPRESSION_FACTOR__EXPRESSION), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 96));
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createExpressionFactor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_50, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_48, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 97));
		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 97));
	}
	
;

parse_org_emftext_language_pl0_Statement returns [org.emftext.language.pl0.Statement element = null]
:
	c0 = parse_org_emftext_language_pl0_CallStatement{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_language_pl0_WhileStatement{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_language_pl0_IfStatement{ element = c2; /* this is a subclass choice */ }
	|	c3 = parse_org_emftext_language_pl0_Assignment{ element = c3; /* this is a subclass choice */ }
	
;

parse_org_emftext_language_pl0_Condition returns [org.emftext.language.pl0.Condition element = null]
:
	c0 = parse_org_emftext_language_pl0_OddCondition{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_language_pl0_RelationalCondition{ element = c1; /* this is a subclass choice */ }
	
;

parse_org_emftext_language_pl0_Expression returns [org.emftext.language.pl0.Expression element = null]
:
	c0 = parse_org_emftext_language_pl0_TermExpression{ element = c0; /* this is a subclass choice */ }
	
;

parse_org_emftext_language_pl0_Factor returns [org.emftext.language.pl0.Factor element = null]
:
	c0 = parse_org_emftext_language_pl0_IdentReference{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_language_pl0_Number{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_language_pl0_ExpressionFactor{ element = c2; /* this is a subclass choice */ }
	
;

SL_COMMENT:
	'//'(~('\n'|'\r'|'\uffff'))* 
	{ _channel = 99; }
;
ML_COMMENT:
	'/*'.*'*/'	{ _channel = 99; }
;
PL0ID:
	(('a'..'z')|('A'..'Z'))((('a'..'z')|('A'..'Z'))|'0'..'9')*;
NUMBER:
	('0')|(('1'..'9')('0'..'9')*)
;
REL_OP:
	('<'|'<='|'='|'#'|'>'|'>=')
;
PLUS_MINUS:
	('+'|'-')
;
MUL_DIV:
	('*'|'/')
;
WHITESPACE:
	(' '|'\t'|'\f')
	{ _channel = 99; }
;
LINEBREAKS:
	('\r\n'|'\r'|'\n')
	{ _channel = 99; }
;

