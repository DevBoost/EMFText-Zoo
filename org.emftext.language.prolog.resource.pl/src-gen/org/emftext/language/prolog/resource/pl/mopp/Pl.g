grammar Pl;

options {
	superClass = PlANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.prolog.resource.pl.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.prolog.resource.pl.mopp;
}

@members{
	private org.emftext.language.prolog.resource.pl.IPlTokenResolverFactory tokenResolverFactory = new org.emftext.language.prolog.resource.pl.mopp.PlTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>() {
			public boolean execute(org.emftext.language.prolog.resource.pl.IPlTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.prolog.resource.pl.IPlProblem() {
					public org.emftext.language.prolog.resource.pl.PlEProblemSeverity getSeverity() {
						return org.emftext.language.prolog.resource.pl.PlEProblemSeverity.ERROR;
					}
					public org.emftext.language.prolog.resource.pl.PlEProblemType getType() {
						return org.emftext.language.prolog.resource.pl.PlEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.emftext.language.prolog.resource.pl.IPlExpectedElement terminal = org.emftext.language.prolog.resource.pl.grammar.PlFollowSetProvider.TERMINALS[terminalID];
		org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] containmentTrace = new org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentTrace[i - 2] = org.emftext.language.prolog.resource.pl.grammar.PlFollowSetProvider.LINKS[ids[i]];
		}
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal expectedElement = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>() {
			public boolean execute(org.emftext.language.prolog.resource.pl.IPlTextResource resource) {
				org.emftext.language.prolog.resource.pl.IPlLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>() {
			public boolean execute(org.emftext.language.prolog.resource.pl.IPlTextResource resource) {
				org.emftext.language.prolog.resource.pl.IPlLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
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
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>() {
			public boolean execute(org.emftext.language.prolog.resource.pl.IPlTextResource resource) {
				org.emftext.language.prolog.resource.pl.IPlLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new PlParser(new org.antlr.runtime3_4_0.CommonTokenStream(new PlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new PlParser(new org.antlr.runtime3_4_0.CommonTokenStream(new PlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.emftext.language.prolog.resource.pl.util.PlRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public PlParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((PlLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((PlLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.prolog.PrologProgram.class) {
				return parse_org_emftext_language_prolog_PrologProgram();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Clause.class) {
				return parse_org_emftext_language_prolog_Clause();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Conjunction.class) {
				return parse_org_emftext_language_prolog_Conjunction();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Predicate.class) {
				return parse_org_emftext_language_prolog_Predicate();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Numeral.class) {
				return parse_org_emftext_language_prolog_Numeral();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Variable.class) {
				return parse_org_emftext_language_prolog_Variable();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.AnonymousVariable.class) {
				return parse_org_emftext_language_prolog_AnonymousVariable();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.SmallAtom.class) {
				return parse_org_emftext_language_prolog_SmallAtom();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.String.class) {
				return parse_org_emftext_language_prolog_String();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.VariableReference.class) {
				return parse_org_emftext_language_prolog_VariableReference();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.List.class) {
				return parse_org_emftext_language_prolog_List();
			}
			if (type.getInstanceClass() == org.emftext.language.prolog.Assignment.class) {
				return parse_org_emftext_language_prolog_Assignment();
			}
		}
		throw new org.emftext.language.prolog.resource.pl.mopp.PlUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.prolog.resource.pl.IPlOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.language.prolog.resource.pl.IPlParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>>();
		org.emftext.language.prolog.resource.pl.mopp.PlParseResult parseResult = new org.emftext.language.prolog.resource.pl.mopp.PlParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.prolog.resource.pl.IPlTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.emftext.language.prolog.resource.pl.IPlParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal>();
		java.util.List<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 38;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.prolog.resource.pl.IPlExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal newFollowTerminal = new org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal(container, newFollower, followSetID, newFollowerPair.getRight());
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
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.prolog.resource.pl.mopp.PlExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[1]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_prolog_PrologProgram{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_prolog_PrologProgram returns [org.emftext.language.prolog.PrologProgram element = null]
@init{
}
:
	(
		(
			a0_0 = parse_org_emftext_language_prolog_Clause			{
				if (terminateParsing) {
					throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPrologProgram();
					startIncompleteElement(element);
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						Object value = a0_0;
						addObjectToList(element, org.emftext.language.prolog.PrologPackage.PROLOG_PROGRAM__CLAUSES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_0_0_0_0, a0_0, true);
					copyLocalizationInfos(a0_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[3]);
	}
	
;

parse_org_emftext_language_prolog_Clause returns [org.emftext.language.prolog.Clause element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_prolog_Predicate		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__PREDICATE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			a1 = ':-' {
				if (element == null) {
					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[6]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[7]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[8]);
			}
			
			(
				a2_0 = parse_org_emftext_language_prolog_Conjunction				{
					if (terminateParsing) {
						throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.CLAUSE__CONJUNCTION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[9]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[10]);
	}
	
	a3 = '.' {
		if (element == null) {
			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[12]);
	}
	
;

parse_org_emftext_language_prolog_Conjunction returns [org.emftext.language.prolog.Conjunction element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_prolog_Part		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createConjunction();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.prolog.PrologPackage.CONJUNCTION__PARTS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_2_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createConjunction();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_2_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[17]);
			}
			
			(
				a2_0 = parse_org_emftext_language_prolog_Part				{
					if (terminateParsing) {
						throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createConjunction();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.prolog.PrologPackage.CONJUNCTION__PARTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_2_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[18]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[19]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[21]);
	}
	
;

parse_org_emftext_language_prolog_Predicate returns [org.emftext.language.prolog.Predicate element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_prolog_Atom		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.PREDICATE__ATOM), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[30]);
	}
	
	(
		(
			a1 = '(' {
				if (element == null) {
					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[35]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[37]);
			}
			
			(
				a2_0 = parse_org_emftext_language_prolog_Term				{
					if (terminateParsing) {
						throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.prolog.PrologPackage.PREDICATE__TERMS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[38]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[39]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[40]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[41]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[42]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[43]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[44]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[45]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[46]);
					}
					
					(
						a4_0 = parse_org_emftext_language_prolog_Term						{
							if (terminateParsing) {
								throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
								startIncompleteElement(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									addObjectToList(element, org.emftext.language.prolog.PrologPackage.PREDICATE__TERMS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_2_0_0_1, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[47]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[48]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[50]);
			}
			
			a5 = ')' {
				if (element == null) {
					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[52]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[53]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[54]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[55]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[58]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[66]);
	}
	
;

parse_org_emftext_language_prolog_Numeral returns [org.emftext.language.prolog.Numeral element = null]
@init{
}
:
	(
		a0 = FLOAT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createNumeral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("FLOAT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.NUMERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Double resolved = (java.lang.Double) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.NUMERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[73]);
	}
	
;

parse_org_emftext_language_prolog_Variable returns [org.emftext.language.prolog.Variable element = null]
@init{
}
:
	(
		a0 = CAPITAL_WORD		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createVariable();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CAPITAL_WORD");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[80]);
	}
	
;

parse_org_emftext_language_prolog_AnonymousVariable returns [org.emftext.language.prolog.AnonymousVariable element = null]
@init{
}
:
	(
		a0 = ANONYMOUS		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createAnonymousVariable();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("ANONYMOUS");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ANONYMOUS_VARIABLE__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ANONYMOUS_VARIABLE__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[87]);
	}
	
;

parse_org_emftext_language_prolog_SmallAtom returns [org.emftext.language.prolog.SmallAtom element = null]
@init{
}
:
	(
		a0 = SMALL_WORD		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createSmallAtom();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("SMALL_WORD");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.SMALL_ATOM__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.SMALL_ATOM__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_7_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[94]);
	}
	
;

parse_org_emftext_language_prolog_String returns [org.emftext.language.prolog.String element = null]
@init{
}
:
	(
		a0 = QUOTED_39_39		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createString();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.STRING__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.STRING__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_8_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[97]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[101]);
	}
	
;

parse_org_emftext_language_prolog_VariableReference returns [org.emftext.language.prolog.VariableReference element = null]
@init{
}
:
	(
		a0 = CAPITAL_WORD		
		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createVariableReference();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.prolog.resource.pl.IPlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CAPITAL_WORD");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.prolog.resource.pl.IPlTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE_REFERENCE__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.prolog.Variable proxy = org.emftext.language.prolog.PrologFactory.eINSTANCE.createVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.prolog.resource.pl.mopp.PlContextDependentURIFragmentFactory<org.emftext.language.prolog.VariableReference, org.emftext.language.prolog.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE_REFERENCE__VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.VARIABLE_REFERENCE__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_9_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[107]);
	}
	
;

parse_org_emftext_language_prolog_List returns [org.emftext.language.prolog.List element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[115]);
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_language_prolog_Term				{
					if (terminateParsing) {
						throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, org.emftext.language.prolog.PrologPackage.LIST__HEAD_TERMS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[116]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[118]);
			}
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[119]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[120]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[121]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[122]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[123]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[124]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[125]);
					}
					
					(
						a3_0 = parse_org_emftext_language_prolog_Term						{
							if (terminateParsing) {
								throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
								startIncompleteElement(element);
							}
							if (a3_0 != null) {
								if (a3_0 != null) {
									Object value = a3_0;
									addObjectToList(element, org.emftext.language.prolog.PrologPackage.LIST__HEAD_TERMS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_1_0_0_1, a3_0, true);
								copyLocalizationInfos(a3_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[126]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[127]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[128]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[129]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[130]);
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[131]);
			}
			
			(
				(
					a4 = '|' {
						if (element == null) {
							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[132]);
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[133]);
					}
					
					(
						a5_0 = parse_org_emftext_language_prolog_Tail						{
							if (terminateParsing) {
								throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.LIST__TAIL), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[134]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[135]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[136]);
	}
	
	a6 = ']' {
		if (element == null) {
			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[143]);
	}
	
;

parse_org_emftext_language_prolog_Assignment returns [org.emftext.language.prolog.Assignment element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_prolog_VariableReference		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createAssignment();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_11_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[144]);
	}
	
	a1 = 'is' {
		if (element == null) {
			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createAssignment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[151]);
	}
	
	(
		a2_0 = parse_org_emftext_language_prolog_Term		{
			if (terminateParsing) {
				throw new org.emftext.language.prolog.resource.pl.mopp.PlTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createAssignment();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.prolog.PrologPackage.ASSIGNMENT__TERM), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_11_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[153]);
	}
	
;

parse_org_emftext_language_prolog_Part returns [org.emftext.language.prolog.Part element = null]
:
	c0 = parse_org_emftext_language_prolog_Predicate{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_prolog_Assignment{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_prolog_Atom returns [org.emftext.language.prolog.Atom element = null]
:
	c0 = parse_org_emftext_language_prolog_SmallAtom{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_prolog_String{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_prolog_Term returns [org.emftext.language.prolog.Term element = null]
:
	c0 = parse_org_emftext_language_prolog_Predicate{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_prolog_Numeral{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_prolog_Variable{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_prolog_AnonymousVariable{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_prolog_SmallAtom{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_prolog_String{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_prolog_VariableReference{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_prolog_List{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_prolog_Tail returns [org.emftext.language.prolog.Tail element = null]
:
	c0 = parse_org_emftext_language_prolog_Variable{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_prolog_List{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') (('0'..'9'))* | '0') ('.' (('0'..'9'))+)? )
;
CAPITAL_WORD:
	(('A'..'Z')(('a'..'z') | ('A'..'Z') | ('0'..'9') | ('+'|'-'|'*'|'/'|'_'))*)
;
SMALL_WORD:
	(('a'..'z')(('a'..'z') | ('A'..'Z') | ('0'..'9') | ('+'|'-'|'*'|'/'|'_'))*)
;
ANONYMOUS:
	('_'(('A'..'Z')(('a'..'z') | ('A'..'Z') | ('0'..'9') | ('+'|'-'|'*'|'/'|'_'))*)?)
;
SL_COMMENT:
	('%'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
QUOTED_39_39:
	(('\'')(~('\''))*('\''))
;

