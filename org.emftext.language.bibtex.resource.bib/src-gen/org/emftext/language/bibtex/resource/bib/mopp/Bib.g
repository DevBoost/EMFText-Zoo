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
	public java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_3_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_3_0.ANTLRStringStream) input).index());
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
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>());
	
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_3_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
				return new BibParser(new org.antlr.runtime3_3_0.CommonTokenStream(new BibLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new BibParser(new org.antlr.runtime3_3_0.CommonTokenStream(new BibLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream, encoding))));
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
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_3_0.RecognitionException {
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
			if (type.getInstanceClass() == org.emftext.language.bibtex.AuthorField.class) {
				return parse_org_emftext_language_bibtex_AuthorField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.Author.class) {
				return parse_org_emftext_language_bibtex_Author();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.EditorField.class) {
				return parse_org_emftext_language_bibtex_EditorField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.Editor.class) {
				return parse_org_emftext_language_bibtex_Editor();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.KeywordField.class) {
				return parse_org_emftext_language_bibtex_KeywordField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.Keyword.class) {
				return parse_org_emftext_language_bibtex_Keyword();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.TitleField.class) {
				return parse_org_emftext_language_bibtex_TitleField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.BookTitleField.class) {
				return parse_org_emftext_language_bibtex_BookTitleField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.SeriesField.class) {
				return parse_org_emftext_language_bibtex_SeriesField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.AddressField.class) {
				return parse_org_emftext_language_bibtex_AddressField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.MonthField.class) {
				return parse_org_emftext_language_bibtex_MonthField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.OrganizationField.class) {
				return parse_org_emftext_language_bibtex_OrganizationField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.PublisherField.class) {
				return parse_org_emftext_language_bibtex_PublisherField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.JournalField.class) {
				return parse_org_emftext_language_bibtex_JournalField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.NoteField.class) {
				return parse_org_emftext_language_bibtex_NoteField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.EidField.class) {
				return parse_org_emftext_language_bibtex_EidField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.AbstractField.class) {
				return parse_org_emftext_language_bibtex_AbstractField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.ReviewField.class) {
				return parse_org_emftext_language_bibtex_ReviewField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.UrlField.class) {
				return parse_org_emftext_language_bibtex_UrlField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.YearField.class) {
				return parse_org_emftext_language_bibtex_YearField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.VolumeField.class) {
				return parse_org_emftext_language_bibtex_VolumeField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.PartField.class) {
				return parse_org_emftext_language_bibtex_PartField();
			}
			if (type.getInstanceClass() == org.emftext.language.bibtex.NumberField.class) {
				return parse_org_emftext_language_bibtex_NumberField();
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
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_3_0.IntStream arg0, org.antlr.runtime3_3_0.RecognitionException arg1, int arg2, org.antlr.runtime3_3_0.BitSet arg3) {
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
		} catch (org.antlr.runtime3_3_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_3_0.RecognitionException re : lexerExceptions) {
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
		final org.antlr.runtime3_3_0.CommonTokenStream tokenStream = (org.antlr.runtime3_3_0.CommonTokenStream) getTokenStream();
		org.emftext.language.bibtex.resource.bib.IBibParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_3_0.Lexer lexer = (org.antlr.runtime3_3_0.Lexer) tokenStream.getTokenSource();
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
		int followSetID = 316;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_3_0.CommonToken nextToken = (org.antlr.runtime3_3_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
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
			org.antlr.runtime3_3_0.CommonToken tokenAtIndex = (org.antlr.runtime3_3_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_3_0.IntStream input, int ttype, org.antlr.runtime3_3_0.BitSet follow) throws org.antlr.runtime3_3_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_3_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_3_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_3_0.CommonToken) {
			final org.antlr.runtime3_3_0.CommonToken ct = (org.antlr.runtime3_3_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			org.antlr.runtime3_3_0.EarlyExitException eee = (org.antlr.runtime3_3_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedRangeException) {
			org.antlr.runtime3_3_0.MismatchedRangeException mre = (org.antlr.runtime3_3_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
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
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_language_bibtex_BibtexKeyField returns [org.emftext.language.bibtex.BibtexKeyField element = null]
@init{
}
:
	(
		(
			a0 = ID			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBibtexKeyField();
					incompleteObjects.push(element);
				}
				if (a0 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("ID");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_1_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 2);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 2);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 2);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 2);
		}
		
		
		|		(
			a1 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBibtexKeyField();
					incompleteObjects.push(element);
				}
				if (a1 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_1_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 3);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 3);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 3);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 3);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 4);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 4);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 4);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 4);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_11, 5);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_12, 6);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 6);
	}
	
	(
		(
			a2 = '\"' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 7, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 7, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
			}
			
			(
				a3_0 = parse_org_emftext_language_bibtex_Author				{
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
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 8);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 8);
			}
			
			(
				(
					a4 = 'and' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 9, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 9, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
					}
					
					(
						a5_0 = parse_org_emftext_language_bibtex_Author						{
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
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 10);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 10);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 11);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 11);
			}
			
			a6 = '\"' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 12);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 12);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 12);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 12);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 13);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 13);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 13);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 13);
		}
		
		
		|		(
			a7 = '{' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 14, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 14, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
			}
			
			(
				a8_0 = parse_org_emftext_language_bibtex_Author				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
						incompleteObjects.push(element);
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							Object value = a8_0;
							addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_1, a8_0, true);
						copyLocalizationInfos(a8_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 15);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 15);
			}
			
			(
				(
					a9 = 'and' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
					}
					
					(
						a10_0 = parse_org_emftext_language_bibtex_Author						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
								incompleteObjects.push(element);
							}
							if (a10_0 != null) {
								if (a10_0 != null) {
									Object value = a10_0;
									addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_2_0_0_1, a10_0, true);
								copyLocalizationInfos(a10_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 17);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 17);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 18);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 18);
			}
			
			a11 = '}' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 19);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 19);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 19);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 19);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 20);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 20);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 20);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 20);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 21);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 21);
	}
	
;

parse_org_emftext_language_bibtex_Author returns [org.emftext.language.bibtex.Author element = null]
@init{
}
:
	(
		(
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_20, 22);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 22);
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
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_0_0_0_0_1_0_0_0, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 23);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 24);
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_0_0_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 25);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 25);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 26);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 26);
		}
		
		
		|		(
			(
				(
					a3 = TEXT					
					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
							incompleteObjects.push(element);
						}
						if (a3 != null) {
							org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
							}
							java.lang.String resolved = (java.lang.String) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_1_0_0_0_0_0_0_0, resolved, true);
							copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 27);
				}
				
				a4 = ',' {
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
						incompleteObjects.push(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_1_0_0_0_0_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 28);
				}
				
				(
					a5 = TEXT					
					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
							incompleteObjects.push(element);
						}
						if (a5 != null) {
							org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStopIndex());
							}
							java.lang.String resolved = (java.lang.String) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_1_0_0_0_0_0_0_2, resolved, true);
							copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a5, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_24, 29);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 29);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 29);
				}
				
				(
					(
						(
							a6 = TEXT							
							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
									incompleteObjects.push(element);
								}
								if (a6 != null) {
									org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
									tokenResolver.setOptions(getOptions());
									org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
									tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), result);
									Object resolvedObject = result.getResolvedToken();
									if (resolvedObject == null) {
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
									}
									java.lang.String resolved = (java.lang.String) resolvedObject;
									if (resolved != null) {
										Object value = resolved;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), value);
										completedElement(value, false);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_1_0_0_0_0_0_0_3_0_0_0, resolved, true);
									copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 30);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 30);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 31);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 31);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 32);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 32);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 33);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 33);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 34);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 34);
	}
	
;

parse_org_emftext_language_bibtex_EditorField returns [org.emftext.language.bibtex.EditorField element = null]
@init{
}
:
	a0 = 'editor' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_26, 35);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_27, 36);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_28, 36);
	}
	
	(
		(
			a2 = '{' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 37, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 37, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
			}
			
			(
				a3_0 = parse_org_emftext_language_bibtex_Editor				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
						incompleteObjects.push(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 38);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 38);
			}
			
			(
				(
					a4 = 'and' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 39, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 39, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
					}
					
					(
						a5_0 = parse_org_emftext_language_bibtex_Editor						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
								incompleteObjects.push(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 40);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 40);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 41);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 41);
			}
			
			a6 = '}' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 42);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 42);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 43);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 43);
		}
		
		
		|		(
			a7 = '\"' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 44, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 44, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
			}
			
			(
				a8_0 = parse_org_emftext_language_bibtex_Editor				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
						incompleteObjects.push(element);
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							Object value = a8_0;
							addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_1, a8_0, true);
						copyLocalizationInfos(a8_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 45);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 45);
			}
			
			(
				(
					a9 = 'and' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
					}
					
					(
						a10_0 = parse_org_emftext_language_bibtex_Editor						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
								incompleteObjects.push(element);
							}
							if (a10_0 != null) {
								if (a10_0 != null) {
									Object value = a10_0;
									addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_2_0_0_1, a10_0, true);
								copyLocalizationInfos(a10_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 47);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 47);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 48);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 48);
			}
			
			a11 = '\"' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 49);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 49);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 50);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 50);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 51);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 51);
	}
	
;

parse_org_emftext_language_bibtex_Editor returns [org.emftext.language.bibtex.Editor element = null]
@init{
}
:
	(
		(
			(
				a0 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_35, 52);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 52);
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
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
								incompleteObjects.push(element);
							}
							if (a1 != null) {
								org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_0_0_0_0_1_0_0_0, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 53);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 54);
			}
			
			(
				a2 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
						incompleteObjects.push(element);
					}
					if (a2 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_0_0_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 55);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 55);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 56);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 56);
		}
		
		
		|		(
			(
				a3 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
						incompleteObjects.push(element);
					}
					if (a3 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_1_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_37, 57);
			}
			
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_1_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_38, 58);
			}
			
			(
				a5 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
						incompleteObjects.push(element);
					}
					if (a5 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_1_0_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a5, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 59);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 59);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 59);
			}
			
			(
				(
					(
						a6 = TEXT						
						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
								incompleteObjects.push(element);
							}
							if (a6 != null) {
								org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_1_0_0_0_3_0_0_0, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 60);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 60);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 61);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 61);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 62);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 62);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 63);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 63);
	}
	
;

parse_org_emftext_language_bibtex_KeywordField returns [org.emftext.language.bibtex.KeywordField element = null]
@init{
}
:
	a0 = 'keywords' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 64);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_42, 65);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_43, 65);
	}
	
	(
		a2 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 66, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 66, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
		}
		
		(
			a3_0 = parse_org_emftext_language_bibtex_Keyword			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
					incompleteObjects.push(element);
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						Object value = a3_0;
						addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_1, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 67);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 67);
		}
		
		(
			(
				a4 = ',' {
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
						incompleteObjects.push(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_2_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 68, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 68, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
				}
				
				(
					a5_0 = parse_org_emftext_language_bibtex_Keyword					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
							incompleteObjects.push(element);
						}
						if (a5_0 != null) {
							if (a5_0 != null) {
								Object value = a5_0;
								addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_2_0_0_1, a5_0, true);
							copyLocalizationInfos(a5_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 69);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 69);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 70);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 70);
		}
		
		a6 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_3, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 71);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 71);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 71);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 71);
		}
		
		
		|		a7 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 72, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 72, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
		}
		
		(
			a8_0 = parse_org_emftext_language_bibtex_Keyword			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
					incompleteObjects.push(element);
				}
				if (a8_0 != null) {
					if (a8_0 != null) {
						Object value = a8_0;
						addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_1, a8_0, true);
					copyLocalizationInfos(a8_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 73);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 73);
		}
		
		(
			(
				a9 = ',' {
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
						incompleteObjects.push(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_2_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 74, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 74, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
				}
				
				(
					a10_0 = parse_org_emftext_language_bibtex_Keyword					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
							incompleteObjects.push(element);
						}
						if (a10_0 != null) {
							if (a10_0 != null) {
								Object value = a10_0;
								addObjectToList(element, org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_2_0_0_1, a10_0, true);
							copyLocalizationInfos(a10_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 75);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 75);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 76);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 76);
		}
		
		a11 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_3, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 77);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 77);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 77);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 77);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 78);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 78);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 78);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 78);
	}
	
;

parse_org_emftext_language_bibtex_Keyword returns [org.emftext.language.bibtex.Keyword element = null]
@init{
}
:
	(
		(
			a0 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeyword();
					incompleteObjects.push(element);
				}
				if (a0 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 79);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 79);
		}
		
		
		|		(
			a1 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeyword();
					incompleteObjects.push(element);
				}
				if (a1 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 80);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 80);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 81);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 81);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_51, 82);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_52, 83);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_53, 83);
	}
	
	(
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
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 84);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 84);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 84);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 84);
		}
		
		
		|		(
			a3 = '{' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_1_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_54, 85);
			}
			
			(
				a4 = TEXT				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
						incompleteObjects.push(element);
					}
					if (a4 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_1_0_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_55, 86);
			}
			
			a5 = '}' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_1_0_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 87);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 87);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 87);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 87);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 88);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 88);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 88);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 88);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 89);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 89);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 89);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 89);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_57, 90);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_58, 91);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_59, 91);
	}
	
	(
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
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 92);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 92);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_60, 93);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_61, 94);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 95);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 95);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 96);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 96);
	}
	
;

parse_org_emftext_language_bibtex_SeriesField returns [org.emftext.language.bibtex.SeriesField element = null]
@init{
}
:
	a0 = 'series' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_63, 97);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_64, 98);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_65, 98);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 99);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 99);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_66, 100);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_67, 101);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 102);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 102);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 103);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 103);
	}
	
;

parse_org_emftext_language_bibtex_AddressField returns [org.emftext.language.bibtex.AddressField element = null]
@init{
}
:
	a0 = 'address' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_69, 104);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_70, 105);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_71, 105);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 106);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 106);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_72, 107);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_73, 108);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 109);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 109);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 110);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 110);
	}
	
;

parse_org_emftext_language_bibtex_MonthField returns [org.emftext.language.bibtex.MonthField element = null]
@init{
}
:
	a0 = 'month' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_75, 111);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_76, 112);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_77, 112);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 113);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 113);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 113);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 113);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_78, 114);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_79, 115);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 116);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 116);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 116);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 116);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 117);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 117);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 117);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 117);
	}
	
;

parse_org_emftext_language_bibtex_OrganizationField returns [org.emftext.language.bibtex.OrganizationField element = null]
@init{
}
:
	a0 = 'organization' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_81, 118);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_82, 119);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_83, 119);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 120);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 120);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_84, 121);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_85, 122);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 123);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 123);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 124);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 124);
	}
	
;

parse_org_emftext_language_bibtex_PublisherField returns [org.emftext.language.bibtex.PublisherField element = null]
@init{
}
:
	a0 = 'publisher' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_87, 125);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_88, 126);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_89, 126);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 127);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 127);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_90, 128);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_91, 129);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 130);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 130);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 131);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 131);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_93, 132);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_94, 133);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_95, 133);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 134);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 134);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_96, 135);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_97, 136);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 137);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 137);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 138);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 138);
	}
	
;

parse_org_emftext_language_bibtex_NoteField returns [org.emftext.language.bibtex.NoteField element = null]
@init{
}
:
	a0 = 'note' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_99, 139);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_100, 140);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_101, 140);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 141);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 141);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 141);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 141);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_102, 142);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_103, 143);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 144);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 144);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 144);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 144);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 145);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 145);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 145);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 145);
	}
	
;

parse_org_emftext_language_bibtex_EidField returns [org.emftext.language.bibtex.EidField element = null]
@init{
}
:
	a0 = 'eid' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_105, 146);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_106, 147);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_107, 147);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 148);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 148);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_108, 149);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_109, 150);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 151);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 151);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 152);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 152);
	}
	
;

parse_org_emftext_language_bibtex_AbstractField returns [org.emftext.language.bibtex.AbstractField element = null]
@init{
}
:
	a0 = 'abstract' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_111, 153);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_112, 154);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_113, 154);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 155);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 155);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 155);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 155);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_114, 156);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_115, 157);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 158);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 158);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 158);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 158);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 159);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 159);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 159);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 159);
	}
	
;

parse_org_emftext_language_bibtex_ReviewField returns [org.emftext.language.bibtex.ReviewField element = null]
@init{
}
:
	a0 = 'review' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_117, 160);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_118, 161);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_119, 161);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 162);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 162);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 162);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 162);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_120, 163);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_121, 164);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 165);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 165);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 165);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 165);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 166);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 166);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 166);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 166);
	}
	
;

parse_org_emftext_language_bibtex_UrlField returns [org.emftext.language.bibtex.UrlField element = null]
@init{
}
:
	a0 = 'url' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_123, 167);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_124, 168);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_125, 168);
	}
	
	(
		(
			a2 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
					incompleteObjects.push(element);
				}
				if (a2 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 169);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 169);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 169);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 169);
		}
		
		
		|		a3 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_126, 170);
		}
		
		(
			a4 = TEXT			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
					incompleteObjects.push(element);
				}
				if (a4 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_127, 171);
		}
		
		a5 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 172);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 172);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 172);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 172);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 173);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 173);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 173);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 173);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_129, 174);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_130, 175);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_131, 175);
	}
	
	(
		a2 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_132, 176);
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
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_0_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_133, 177);
		}
		
		a4 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_0_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 178);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 178);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 178);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 178);
		}
		
		
		|		a5 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_134, 179);
		}
		
		(
			a6 = YEAR			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
					incompleteObjects.push(element);
				}
				if (a6 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("YEAR");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_135, 180);
		}
		
		a7 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 181);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 181);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 181);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 181);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 182);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 182);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 182);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 182);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_137, 183);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_138, 184);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_139, 184);
	}
	
	(
		a2 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_140, 185);
		}
		
		(
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_141, 186);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_141, 187);
		}
		
		a4 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_0_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 188);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 188);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 188);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 188);
		}
		
		
		|		a5 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_142, 189);
		}
		
		(
			(
				a6 = INTEGER				
				{
					if (terminateParsing) {
						throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
						incompleteObjects.push(element);
					}
					if (a6 != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
						tokenResolver.setOptions(getOptions());
						org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_1_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_143, 190);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_143, 191);
		}
		
		a7 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 192);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 192);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 192);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 192);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 193);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 193);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 193);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 193);
	}
	
;

parse_org_emftext_language_bibtex_PartField returns [org.emftext.language.bibtex.PartField element = null]
@init{
}
:
	a0 = 'part' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_145, 194);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_146, 195);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_147, 195);
	}
	
	(
		a2 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_148, 196);
		}
		
		(
			a3 = INTEGER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
					incompleteObjects.push(element);
				}
				if (a3 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_0_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_149, 197);
		}
		
		a4 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_0_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 198);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 198);
		}
		
		
		|		a5 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_150, 199);
		}
		
		(
			a6 = INTEGER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
					incompleteObjects.push(element);
				}
				if (a6 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_151, 200);
		}
		
		a7 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 201);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 201);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 202);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 202);
	}
	
;

parse_org_emftext_language_bibtex_NumberField returns [org.emftext.language.bibtex.NumberField element = null]
@init{
}
:
	a0 = 'number' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_153, 203);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_154, 204);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_155, 204);
	}
	
	(
		a2 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_156, 205);
		}
		
		(
			a3 = INTEGER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
					incompleteObjects.push(element);
				}
				if (a3 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_0_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_157, 206);
		}
		
		a4 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_0_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 207);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 207);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 207);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 207);
		}
		
		
		|		a5 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_158, 208);
		}
		
		(
			a6 = INTEGER			
			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
					incompleteObjects.push(element);
				}
				if (a6 != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_1_1, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_159, 209);
		}
		
		a7 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_1_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 210);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 210);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 210);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 210);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 211);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 211);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 211);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 211);
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
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_161, 212);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_162, 213);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_163, 213);
	}
	
	(
		a2 = '{' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 214, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
		}
		
		(
			a3_0 = parse_org_emftext_language_bibtex_Page			{
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
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_1, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_165, 215);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_166, 215);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 215);
		}
		
		(
			(
				(
					a4 = '--' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_2_0_0_0_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 216, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
					}
					
					
					|					a5 = '-' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_2_0_0_0_0_1_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 217, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 218, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
				}
				
				(
					a6_0 = parse_org_emftext_language_bibtex_Page					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						if (a6_0 != null) {
							if (a6_0 != null) {
								Object value = a6_0;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE), value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_2_0_0_1, a6_0, true);
							copyLocalizationInfos(a6_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 219);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 220);
		}
		
		a7 = '}' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_3, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 221);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 221);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 221);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 221);
		}
		
		
		|		a8 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 222, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
		}
		
		(
			a9_0 = parse_org_emftext_language_bibtex_Page			{
				if (terminateParsing) {
					throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
					incompleteObjects.push(element);
				}
				if (a9_0 != null) {
					if (a9_0 != null) {
						Object value = a9_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__FROM_PAGE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_1, a9_0, true);
					copyLocalizationInfos(a9_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_168, 223);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_169, 223);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 223);
		}
		
		(
			(
				(
					a10 = '--' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_2_0_0_0_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 224, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
					}
					
					
					|					a11 = '-' {
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_2_0_0_0_0_1_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 225, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 226, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
				}
				
				(
					a12_0 = parse_org_emftext_language_bibtex_Page					{
						if (terminateParsing) {
							throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
							incompleteObjects.push(element);
						}
						if (a12_0 != null) {
							if (a12_0 != null) {
								Object value = a12_0;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE), value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_2_0_0_1, a12_0, true);
							copyLocalizationInfos(a12_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 227);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 228);
		}
		
		a13 = '\"' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_3, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a13, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 229);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 229);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 229);
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 229);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 230);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 230);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 230);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 230);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_26_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_165, 231);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_166, 231);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 231);
	}
	
;

parse_org_emftext_language_bibtex_InProceedingsEntry returns [org.emftext.language.bibtex.InProceedingsEntry element = null]
@init{
}
:
	(
		a0 = '@INPROCEEDINGS' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_0_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 232);
		}
		
		
		|		a1 = '@inproceedings' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_0_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 233);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 234);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 235, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 235, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
	}
	
	(
		a3_0 = parse_org_emftext_language_bibtex_BibtexKeyField		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
				incompleteObjects.push(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BIBTEX_KEY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 236);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 236);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_122, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_7);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_110, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_8);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_9);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_116, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_10);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_50, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_11);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_56, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_12);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_128, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_13);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_10, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_14);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_15);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_136, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_16);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_152, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_17);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_62, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_18);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_160, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_19);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_68, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_20);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_74, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_21);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_80, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_22);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_86, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_23);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_98, 237, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_24);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 237);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 237);
			}
			
			(
				(
					(
						(
							a5_0 = parse_org_emftext_language_bibtex_UrlField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__URL), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_0_0_0_0_0, a5_0, true);
									copyLocalizationInfos(a5_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 238);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 238);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 239);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 239);
				}
				
				
				|				(
					(
						(
							a6_0 = parse_org_emftext_language_bibtex_AbstractField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ABSTRACT), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_1_0_0_0_0, a6_0, true);
									copyLocalizationInfos(a6_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 240);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 240);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 241);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 241);
				}
				
				
				|				(
					(
						(
							a7_0 = parse_org_emftext_language_bibtex_KeywordField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__KEYWORD), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_2_0_0_0_0, a7_0, true);
									copyLocalizationInfos(a7_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 242);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 242);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 243);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 243);
				}
				
				
				|				(
					(
						(
							a8_0 = parse_org_emftext_language_bibtex_ReviewField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a8_0 != null) {
									if (a8_0 != null) {
										Object value = a8_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__REVIEW), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_3_0_0_0_0, a8_0, true);
									copyLocalizationInfos(a8_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 244);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 244);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 245);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 245);
				}
				
				
				|				(
					(
						a9_0 = parse_org_emftext_language_bibtex_TitleField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a9_0 != null) {
								if (a9_0 != null) {
									Object value = a9_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_4_0_0_0_0, a9_0, true);
								copyLocalizationInfos(a9_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 246);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 246);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 247);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 247);
				}
				
				
				|				(
					(
						a10_0 = parse_org_emftext_language_bibtex_BookTitleField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a10_0 != null) {
								if (a10_0 != null) {
									Object value = a10_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_5_0_0_0_0, a10_0, true);
								copyLocalizationInfos(a10_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 248);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 248);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 249);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 249);
				}
				
				
				|				(
					(
						a11_0 = parse_org_emftext_language_bibtex_YearField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a11_0 != null) {
								if (a11_0 != null) {
									Object value = a11_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_6_0_0_0_0, a11_0, true);
								copyLocalizationInfos(a11_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 250);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 250);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 251);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 251);
				}
				
				
				|				(
					(
						a12_0 = parse_org_emftext_language_bibtex_AuthorField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
								incompleteObjects.push(element);
							}
							if (a12_0 != null) {
								if (a12_0 != null) {
									Object value = a12_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_7_0_0_0_0, a12_0, true);
								copyLocalizationInfos(a12_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 252);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 252);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 253);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 253);
				}
				
				
				|				(
					(
						(
							a13_0 = parse_org_emftext_language_bibtex_EditorField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a13_0 != null) {
									if (a13_0 != null) {
										Object value = a13_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_8_0_0_0_0, a13_0, true);
									copyLocalizationInfos(a13_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 254);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 254);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 255);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 255);
				}
				
				
				|				(
					(
						(
							a14_0 = parse_org_emftext_language_bibtex_VolumeField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a14_0 != null) {
									if (a14_0 != null) {
										Object value = a14_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_9_0_0_0_0, a14_0, true);
									copyLocalizationInfos(a14_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 256);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 256);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 257);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 257);
				}
				
				
				|				(
					(
						(
							a15_0 = parse_org_emftext_language_bibtex_NumberField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a15_0 != null) {
									if (a15_0 != null) {
										Object value = a15_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_10_0_0_0_0, a15_0, true);
									copyLocalizationInfos(a15_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 258);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 258);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 259);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 259);
				}
				
				
				|				(
					(
						(
							a16_0 = parse_org_emftext_language_bibtex_SeriesField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a16_0 != null) {
									if (a16_0 != null) {
										Object value = a16_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_11_0_0_0_0, a16_0, true);
									copyLocalizationInfos(a16_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 260);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 260);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 261);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 261);
				}
				
				
				|				(
					(
						(
							a17_0 = parse_org_emftext_language_bibtex_PageField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a17_0 != null) {
									if (a17_0 != null) {
										Object value = a17_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_12_0_0_0_0, a17_0, true);
									copyLocalizationInfos(a17_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 262);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 262);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 263);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 263);
				}
				
				
				|				(
					(
						(
							a18_0 = parse_org_emftext_language_bibtex_AddressField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a18_0 != null) {
									if (a18_0 != null) {
										Object value = a18_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_13_0_0_0_0, a18_0, true);
									copyLocalizationInfos(a18_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 264);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 264);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 265);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 265);
				}
				
				
				|				(
					(
						(
							a19_0 = parse_org_emftext_language_bibtex_MonthField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a19_0 != null) {
									if (a19_0 != null) {
										Object value = a19_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_14_0_0_0_0, a19_0, true);
									copyLocalizationInfos(a19_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 266);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 266);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 267);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 267);
				}
				
				
				|				(
					(
						(
							a20_0 = parse_org_emftext_language_bibtex_OrganizationField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a20_0 != null) {
									if (a20_0 != null) {
										Object value = a20_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_15_0_0_0_0, a20_0, true);
									copyLocalizationInfos(a20_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 268);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 268);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 269);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 269);
				}
				
				
				|				(
					(
						(
							a21_0 = parse_org_emftext_language_bibtex_PublisherField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a21_0 != null) {
									if (a21_0 != null) {
										Object value = a21_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_16_0_0_0_0, a21_0, true);
									copyLocalizationInfos(a21_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 270);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 270);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 271);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 271);
				}
				
				
				|				(
					(
						(
							a22_0 = parse_org_emftext_language_bibtex_NoteField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
									incompleteObjects.push(element);
								}
								if (a22_0 != null) {
									if (a22_0 != null) {
										Object value = a22_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_17_0_0_0_0, a22_0, true);
									copyLocalizationInfos(a22_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 272);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 272);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 273);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 273);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 274);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 274);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 275);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 275);
	}
	
	a23 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a23, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
	}
	
;

parse_org_emftext_language_bibtex_ArticleEntry returns [org.emftext.language.bibtex.ArticleEntry element = null]
@init{
}
:
	(
		a0 = '@ARTICLE' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_0_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 277);
		}
		
		
		|		a1 = '@article' {
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_0_0_1_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 278);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 279);
	}
	
	a2 = '{' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 280, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 280, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
	}
	
	(
		a3_0 = parse_org_emftext_language_bibtex_BibtexKeyField		{
			if (terminateParsing) {
				throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
				incompleteObjects.push(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__BIBTEX_KEY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 281);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 281);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_122, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_7);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_110, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_8);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_9);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_116, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_10);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_50, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_25);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_92, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_26);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_136, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_27);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_128, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_28);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_10, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_29);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_160, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_30);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_152, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_31);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_74, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_32);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_144, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_33);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_104, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_34);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_98, 282, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_35);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 282);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 282);
			}
			
			(
				(
					(
						(
							a5_0 = parse_org_emftext_language_bibtex_UrlField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__URL), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_0_0_0_0_0, a5_0, true);
									copyLocalizationInfos(a5_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 283);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 283);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 284);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 284);
				}
				
				
				|				(
					(
						(
							a6_0 = parse_org_emftext_language_bibtex_AbstractField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__ABSTRACT), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_1_0_0_0_0, a6_0, true);
									copyLocalizationInfos(a6_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 285);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 285);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 286);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 286);
				}
				
				
				|				(
					(
						(
							a7_0 = parse_org_emftext_language_bibtex_KeywordField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__KEYWORD), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_2_0_0_0_0, a7_0, true);
									copyLocalizationInfos(a7_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 287);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 287);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 288);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 288);
				}
				
				
				|				(
					(
						(
							a8_0 = parse_org_emftext_language_bibtex_ReviewField							{
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
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__REVIEW), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_3_0_0_0_0, a8_0, true);
									copyLocalizationInfos(a8_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 289);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 289);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 290);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 290);
				}
				
				
				|				(
					(
						a9_0 = parse_org_emftext_language_bibtex_TitleField						{
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
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__TITLE), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_4_0_0_0_0, a9_0, true);
								copyLocalizationInfos(a9_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 291);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 291);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 292);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 292);
				}
				
				
				|				(
					(
						a10_0 = parse_org_emftext_language_bibtex_JournalField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a10_0 != null) {
								if (a10_0 != null) {
									Object value = a10_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__JOURNAL), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_5_0_0_0_0, a10_0, true);
								copyLocalizationInfos(a10_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 293);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 293);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 294);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 294);
				}
				
				
				|				(
					(
						a11_0 = parse_org_emftext_language_bibtex_VolumeField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a11_0 != null) {
								if (a11_0 != null) {
									Object value = a11_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__VOLUME), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_6_0_0_0_0, a11_0, true);
								copyLocalizationInfos(a11_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 295);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 295);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 296);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 296);
				}
				
				
				|				(
					(
						a12_0 = parse_org_emftext_language_bibtex_YearField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a12_0 != null) {
								if (a12_0 != null) {
									Object value = a12_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__YEAR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_7_0_0_0_0, a12_0, true);
								copyLocalizationInfos(a12_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 297);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 297);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 298);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 298);
				}
				
				
				|				(
					(
						a13_0 = parse_org_emftext_language_bibtex_AuthorField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a13_0 != null) {
								if (a13_0 != null) {
									Object value = a13_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__AUTHOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_8_0_0_0_0, a13_0, true);
								copyLocalizationInfos(a13_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 299);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 299);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 300);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 300);
				}
				
				
				|				(
					(
						a14_0 = parse_org_emftext_language_bibtex_PageField						{
							if (terminateParsing) {
								throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
								incompleteObjects.push(element);
							}
							if (a14_0 != null) {
								if (a14_0 != null) {
									Object value = a14_0;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PAGES), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_9_0_0_0_0, a14_0, true);
								copyLocalizationInfos(a14_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 301);
						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 301);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 302);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 302);
				}
				
				
				|				(
					(
						(
							a15_0 = parse_org_emftext_language_bibtex_NumberField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
									incompleteObjects.push(element);
								}
								if (a15_0 != null) {
									if (a15_0 != null) {
										Object value = a15_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NUMBER), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_10_0_0_0_0, a15_0, true);
									copyLocalizationInfos(a15_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 303);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 303);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 304);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 304);
				}
				
				
				|				(
					(
						(
							a16_0 = parse_org_emftext_language_bibtex_MonthField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
									incompleteObjects.push(element);
								}
								if (a16_0 != null) {
									if (a16_0 != null) {
										Object value = a16_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__MONTH), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_11_0_0_0_0, a16_0, true);
									copyLocalizationInfos(a16_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 305);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 305);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 306);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 306);
				}
				
				
				|				(
					(
						(
							a17_0 = parse_org_emftext_language_bibtex_PartField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
									incompleteObjects.push(element);
								}
								if (a17_0 != null) {
									if (a17_0 != null) {
										Object value = a17_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PART), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_12_0_0_0_0, a17_0, true);
									copyLocalizationInfos(a17_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 307);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 307);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 308);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 308);
				}
				
				
				|				(
					(
						(
							a18_0 = parse_org_emftext_language_bibtex_EidField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
									incompleteObjects.push(element);
								}
								if (a18_0 != null) {
									if (a18_0 != null) {
										Object value = a18_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__EID), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_13_0_0_0_0, a18_0, true);
									copyLocalizationInfos(a18_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 309);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 309);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 310);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 310);
				}
				
				
				|				(
					(
						(
							a19_0 = parse_org_emftext_language_bibtex_NoteField							{
								if (terminateParsing) {
									throw new org.emftext.language.bibtex.resource.bib.mopp.BibTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
									incompleteObjects.push(element);
								}
								if (a19_0 != null) {
									if (a19_0 != null) {
										Object value = a19_0;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NOTE), value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_14_0_0_0_0, a19_0, true);
									copyLocalizationInfos(a19_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 311);
							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 311);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 312);
					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 312);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 313);
				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 313);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 314);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 314);
	}
	
	a20 = '}' {
		if (element == null) {
			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a20, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
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
	(('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'.')+)
;
ID:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'.'| '/' |':'|'_')+)
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
WHITESPACE:
	((' ' | '\t' | '\f')+)
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

