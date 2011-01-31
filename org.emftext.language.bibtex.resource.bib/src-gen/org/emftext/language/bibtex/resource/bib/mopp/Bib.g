grammar Bib;

options {
	superClass = BibANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.bibtex.resource.bib.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.bibtex.resource.bib.mopp;
}

@members{
	private org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory tokenResolverFactory = new org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	private org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolveResult tokenResolveResult = new org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolveResult();
	
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
	private java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	
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
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	private boolean terminateParsing;
	
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
		postParseCommands.add(new org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>() {
			public boolean execute(org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.bibtex.resource.bib.IBibProblem() {
					public org.emftext.language.bibtex.resource.bib.BibEProblemSeverity getSeverity() {
						return org.emftext.language.bibtex.resource.bib.BibEProblemSeverity.ERROR;
					}
					public org.emftext.language.bibtex.resource.bib.BibEProblemType getType() {
						return org.emftext.language.bibtex.resource.bib.BibEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.language.bibtex.resource.bib.IBibExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		if (!this.rememberExpectedElements) {
			return;
		}
		org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement = new org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal(terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.bibtex.resource.bib.mopp.BibDummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<Object, Object> valueMap = org.emftext.language.bibtex.resource.bib.util.BibMapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject container, int featureID, Object object) {
		return ((java.util.List<Object>) container.eGet(container.eClass().getEStructuralFeature(featureID))).add(object);
	}
	
	@SuppressWarnings("unchecked")
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EStructuralFeature feature, Object object) {
		return ((java.util.List<Object>) container.eGet(feature)).add(object);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.language.bibtex.resource.bib.mopp.BibDummyEObject);
			org.emftext.language.bibtex.resource.bib.mopp.BibDummyEObject dummy = (org.emftext.language.bibtex.resource.bib.mopp.BibDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>() {
			public boolean execute(org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
				org.emftext.language.bibtex.resource.bib.IBibLocationMap locationMap = resource.getLocationMap();
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_2_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>() {
			public boolean execute(org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
				org.emftext.language.bibtex.resource.bib.IBibLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		postParseCommands.add(new org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>() {
			public boolean execute(org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
				org.emftext.language.bibtex.resource.bib.IBibLocationMap locationMap = resource.getLocationMap();
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
	
	public org.emftext.language.bibtex.resource.bib.IBibTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new BibParser(new org.antlr.runtime3_2_0.CommonTokenStream(new BibLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new BibParser(new org.antlr.runtime3_2_0.CommonTokenStream(new BibLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.language.bibtex.resource.bib.mopp.BibPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public BibParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((BibLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((BibLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.bibtex.Bibliography.class) {
				return parse_org_emftext_language_bibtex_Bibliography();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.BibtexKeyField.class) {
				return parse_org_emftext_language_bibtex_BibtexKeyField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.TitleField.class) {
				return parse_org_emftext_language_bibtex_TitleField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.BookTitleField.class) {
				return parse_org_emftext_language_bibtex_BookTitleField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.YearField.class) {
				return parse_org_emftext_language_bibtex_YearField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.AuthorField.class) {
				return parse_org_emftext_language_bibtex_AuthorField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.Author.class) {
				return parse_org_emftext_language_bibtex_Author();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.JournalField.class) {
				return parse_org_emftext_language_bibtex_JournalField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.VolumeField.class) {
				return parse_org_emftext_language_bibtex_VolumeField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.PageField.class) {
				return parse_org_emftext_language_bibtex_PageField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.Page.class) {
				return parse_org_emftext_language_bibtex_Page();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.InProceedingsEntry.class) {
				return parse_org_emftext_language_bibtex_InProceedingsEntry();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.ArticleEntry.class) {
				return parse_org_emftext_language_bibtex_ArticleEntry();
			}
		}
		throw new org.emftext.language.bibtex.resource.bib.mopp.BibUnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_2_0.IntStream arg0, org.antlr.runtime3_2_0.RecognitionException arg1, int arg2, org.antlr.runtime3_2_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	protected java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation getMetaInformation() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation();
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.bibtex.resource.bib.IBibOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.language.bibtex.resource.bib.IBibParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>>();
		org.emftext.language.bibtex.resource.bib.mopp.BibParseResult parseResult = new org.emftext.language.bibtex.resource.bib.mopp.BibParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
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
	
	public java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.bibtex.resource.bib.IBibTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.language.bibtex.resource.bib.IBibParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_2_0.Lexer lexer = (org.antlr.runtime3_2_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal>();
		java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 79;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.bibtex.resource.bib.IBibExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal newFollowTerminal = new org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
		for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
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
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_2_0.IntStream input, int ttype, org.antlr.runtime3_2_0.BitSet follow) throws org.antlr.runtime3_2_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
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
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parse is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_2_0.CommonToken) {
			final org.antlr.runtime3_2_0.CommonToken ct = (org.antlr.runtime3_2_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			org.antlr.runtime3_2_0.EarlyExitException eee = (org.antlr.runtime3_2_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private String formatTokenName(int tokenType)  {
		String tokenName = "<unknown>";
		if (tokenType == org.antlr.runtime3_2_0.Token.EOF) {
			tokenName = "EOF";
		} else {
			if (tokenType < 0) {
				return tokenName;
			}
			tokenName = getTokenNames()[tokenType];
			tokenName = org.emftext.language.bibtex.resource.bib.util.BibStringUtil.formatTokenName(tokenName);
		}
		return tokenName;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	
	public <T> T createDynamicProxy(Class<T> clazz) {
		Object proxy = java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{clazz, org.eclipse.emf.ecore.EObject.class, org.eclipse.emf.ecore.InternalEObject.class}, new java.lang.reflect.InvocationHandler() {
			
			private org.eclipse.emf.ecore.EObject dummyObject = new org.eclipse.emf.ecore.impl.EObjectImpl() {};
			
			public Object invoke(Object object, java.lang.reflect.Method method, Object[] args) throws Throwable {
				// search in dummyObject for the requested method
				java.lang.reflect.Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (java.lang.reflect.Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								Class<?> parameterType = parameterTypes[p];
								Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
		});
		return (T) proxy;
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_bibtex_Bibliography{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_bibtex_Bibliography returns [org.emftext.language.bibtex.Bibliography element = null]
@init{
}
:
	(
		(
			a0_0 = parse_org_emftext_language_bibtex_Entry			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBibliography();
					incompleteObjects.push(element);
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						Object value = a0_0;
						addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.BIBLIOGRAPHY__ENTRIES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_0_0_0_0, a0_0, true);
					copyLocalizationInfos(a0_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_language_bibtex_BibtexKeyField returns [org.emftext.language.bibtex.BibtexKeyField element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBibtexKeyField();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_1_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 2);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 2);
	}
	
;

parse_org_emftext_language_bibtex_TitleField returns [org.emftext.language.bibtex.TitleField element = null]
@init{
}
:
	a0 = 'title' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 3);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 4);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 5);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 5);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 5);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 5);
	}
	
;

parse_org_emftext_language_bibtex_BookTitleField returns [org.emftext.language.bibtex.BookTitleField element = null]
@init{
}
:
	a0 = 'booktitle' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_11, 6);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_12, 7);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 8);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 8);
	}
	
;

parse_org_emftext_language_bibtex_YearField returns [org.emftext.language.bibtex.YearField element = null]
@init{
}
:
	a0 = 'year' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 9);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 10);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 11);
	}
	
	(
		a3 = YEAR		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("YEAR");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 12);
	}
	
	a4 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 13);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 13);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 13);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 13);
	}
	
;

parse_org_emftext_language_bibtex_AuthorField returns [org.emftext.language.bibtex.AuthorField element = null]
@init{
}
:
	a0 = 'author' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 14);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_20, 15);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
	}
	
	(
		a3_0 = parse_org_emftext_language_bibtex_Author		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
				incompleteObjects.push(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_4, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 17);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 17);
	}
	
	(
		(
			a4 = 'and' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 18, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
			}
			
			(
				a5_0 = parse_org_emftext_language_bibtex_Author				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
						incompleteObjects.push(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_5_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 19);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 19);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 20);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 20);
	}
	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 21);
	}
	
;

parse_org_emftext_language_bibtex_Author returns [org.emftext.language.bibtex.Author element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_24, 22);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 22);
	}
	
	(
		(
			(
				a1 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
						incompleteObjects.push(element);
					}
					if (a1 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 23);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 24);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 25);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 25);
	}
	
;

parse_org_emftext_language_bibtex_JournalField returns [org.emftext.language.bibtex.JournalField element = null]
@init{
}
:
	a0 = 'journal' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_27, 26);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_28, 27);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 28);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 29);
	}
	
	a4 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 30);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 30);
	}
	
;

parse_org_emftext_language_bibtex_VolumeField returns [org.emftext.language.bibtex.VolumeField element = null]
@init{
}
:
	a0 = 'volume' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 31);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 32);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 33);
	}
	
	(
		a3 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_35, 34);
	}
	
	a4 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 35);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 35);
	}
	
;

parse_org_emftext_language_bibtex_PageField returns [org.emftext.language.bibtex.PageField element = null]
@init{
}
:
	a0 = 'pages' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_37, 36);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_38, 37);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 38, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
	}
	
	(
		a3_0 = parse_org_emftext_language_bibtex_Page		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
				incompleteObjects.push(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__FROM_PAGE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_4, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 39);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 39);
	}
	
	(
		(
			a4 = '--' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 40, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
			}
			
			(
				a5_0 = parse_org_emftext_language_bibtex_Page				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
						incompleteObjects.push(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_5_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 41);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 42);
	}
	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 43);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 43);
	}
	
;

parse_org_emftext_language_bibtex_Page returns [org.emftext.language.bibtex.Page element = null]
@init{
}
:
	(
		a0 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPage();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 44);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 44);
	}
	
;

parse_org_emftext_language_bibtex_InProceedingsEntry returns [org.emftext.language.bibtex.InProceedingsEntry element = null]
@init{
}
:
	a0 = '@INPROCEEDINGS' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_42, 45);
	}
	
	a1 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
	}
	
	(
		a2_0 = parse_org_emftext_language_bibtex_BibtexKeyField		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
				incompleteObjects.push(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BIBTEX_KEY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 47);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_10, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_7);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_8);
			}
			
			(
				(
					(
						a4_0 = parse_org_emftext_language_bibtex_TitleField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_2_0_0_0_0_0_0, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 49);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 49);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 50);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 50);
				}
				
				
				|				(
					(
						a5_0 = parse_org_emftext_language_bibtex_BookTitleField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_2_0_1_0_0_0_0, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 51);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 51);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 52);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 52);
				}
				
				
				|				(
					(
						a6_0 = parse_org_emftext_language_bibtex_YearField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									Object value = a6_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_2_0_2_0_0_0_0, a6_0, true);
								copyLocalizationInfos(a6_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 53);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 53);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 54);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 54);
				}
				
				
				|				(
					(
						a7_0 = parse_org_emftext_language_bibtex_AuthorField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_2_0_3_0_0_0_0, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 55);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 55);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 56);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 56);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 57);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 57);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 58);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 58);
	}
	
	a8 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 59, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 59, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_language_bibtex_ArticleEntry returns [org.emftext.language.bibtex.ArticleEntry element = null]
@init{
}
:
	a0 = '@ARTICLE' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_43, 60);
	}
	
	a1 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 61, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
	}
	
	(
		a2_0 = parse_org_emftext_language_bibtex_BibtexKeyField		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
				incompleteObjects.push(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__BIBTEX_KEY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 62);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_9);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_26, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_10);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_11);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_12);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_13);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_14);
			}
			
			(
				(
					(
						a4_0 = parse_org_emftext_language_bibtex_TitleField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_0_0_0_0_0, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 64);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 64);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 65);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 65);
				}
				
				
				|				(
					(
						a5_0 = parse_org_emftext_language_bibtex_JournalField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__JOURNAL), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_1_0_0_0_0, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 66);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 66);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 67);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 67);
				}
				
				
				|				(
					(
						a6_0 = parse_org_emftext_language_bibtex_VolumeField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									Object value = a6_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__VOLUME), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_2_0_0_0_0, a6_0, true);
								copyLocalizationInfos(a6_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 68);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 68);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 69);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 69);
				}
				
				
				|				(
					(
						a7_0 = parse_org_emftext_language_bibtex_YearField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__YEAR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_3_0_0_0_0, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 70);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 70);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 71);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 71);
				}
				
				
				|				(
					(
						a8_0 = parse_org_emftext_language_bibtex_AuthorField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a8_0 != null) {
								if (a8_0 != null) {
									Object value = a8_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__AUTHOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_4_0_0_0_0, a8_0, true);
								copyLocalizationInfos(a8_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 72);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 72);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 73);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 73);
				}
				
				
				|				(
					(
						a9_0 = parse_org_emftext_language_bibtex_PageField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a9_0 != null) {
								if (a9_0 != null) {
									Object value = a9_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PAGES), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_2_0_5_0_0_0_0, a9_0, true);
								copyLocalizationInfos(a9_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 74);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 74);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 75);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 75);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 76);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 76);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 77);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 77);
	}
	
	a10 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 78, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 78, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_language_bibtex_Entry returns [org.emftext.language.bibtex.Entry element = null]
:
	c0 = parse_org_emftext_language_bibtex_InProceedingsEntry{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_bibtex_ArticleEntry{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	('%'(~('\n'|'\r'))*)
	{ _channel = 99; }
;
YEAR:
	(('1' |'2')('0'..'9')('0'..'9')('0'..'9'))
;
INTEGER:
	(('0'..'9')+)
;
TEXT:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-'|'.')+)
;
WHITESPACE:
	((' ' | '\t' | '\f')+)
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

