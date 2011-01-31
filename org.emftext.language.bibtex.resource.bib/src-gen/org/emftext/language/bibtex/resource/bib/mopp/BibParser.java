// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.bibtex.resource.bib.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class BibParser extends BibANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_34_34", "YEAR", "INTEGER", "COMMENT", "WHITESPACE", "LINEBREAK", "'title'", "'='", "'booktitle'", "'year'", "'{'", "'}'", "'author'", "'and'", "'journal'", "'volume'", "'pages'", "'--'", "'@INPROCEEDINGS'", "','", "'@ARTICLE'"
    };
    public static final int INTEGER=7;
    public static final int YEAR=6;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=9;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int COMMENT=8;
    public static final int QUOTED_34_34=5;
    public static final int LINEBREAK=10;

    // delegates
    // delegators


        public BibParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[30+1];
             
             
        }
        

    public String[] getTokenNames() { return BibParser.tokenNames; }
    public String getGrammarFileName() { return "Bib.g"; }


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
    	



    // $ANTLR start "start"
    // Bib.g:626:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.bibtex.Bibliography c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Bib.g:627:1: ( (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF )
            // Bib.g:628:2: (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		expectedElementsIndexOfLastCompleteElement = 0;
              	
            }
            // Bib.g:634:2: (c0= parse_org_emftext_language_bibtex_Bibliography )
            // Bib.g:635:3: c0= parse_org_emftext_language_bibtex_Bibliography
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Bibliography_in_start82);
            c0=parse_org_emftext_language_bibtex_Bibliography();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		retrieveLayoutInformation(element, null, null, false);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_org_emftext_language_bibtex_Bibliography"
    // Bib.g:643:1: parse_org_emftext_language_bibtex_Bibliography returns [org.emftext.language.bibtex.Bibliography element = null] : ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )* ;
    public final org.emftext.language.bibtex.Bibliography parse_org_emftext_language_bibtex_Bibliography() throws RecognitionException {
        org.emftext.language.bibtex.Bibliography element =  null;
        int parse_org_emftext_language_bibtex_Bibliography_StartIndex = input.index();
        org.emftext.language.bibtex.Entry a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Bib.g:646:1: ( ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )* )
            // Bib.g:647:2: ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )*
            {
            // Bib.g:647:2: ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23||LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bib.g:648:3: (a0_0= parse_org_emftext_language_bibtex_Entry )
            	    {
            	    // Bib.g:648:3: (a0_0= parse_org_emftext_language_bibtex_Entry )
            	    // Bib.g:649:4: a0_0= parse_org_emftext_language_bibtex_Entry
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Entry_in_parse_org_emftext_language_bibtex_Bibliography124);
            	    a0_0=parse_org_emftext_language_bibtex_Entry();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_bibtex_Bibliography_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Bibliography"


    // $ANTLR start "parse_org_emftext_language_bibtex_BibtexKeyField"
    // Bib.g:678:1: parse_org_emftext_language_bibtex_BibtexKeyField returns [org.emftext.language.bibtex.BibtexKeyField element = null] : (a0= TEXT ) ;
    public final org.emftext.language.bibtex.BibtexKeyField parse_org_emftext_language_bibtex_BibtexKeyField() throws RecognitionException {
        org.emftext.language.bibtex.BibtexKeyField element =  null;
        int parse_org_emftext_language_bibtex_BibtexKeyField_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Bib.g:681:1: ( (a0= TEXT ) )
            // Bib.g:682:2: (a0= TEXT )
            {
            // Bib.g:682:2: (a0= TEXT )
            // Bib.g:683:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BibtexKeyField169); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 2);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 2);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_bibtex_BibtexKeyField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_BibtexKeyField"


    // $ANTLR start "parse_org_emftext_language_bibtex_TitleField"
    // Bib.g:721:1: parse_org_emftext_language_bibtex_TitleField returns [org.emftext.language.bibtex.TitleField element = null] : a0= 'title' a1= '=' (a2= QUOTED_34_34 ) ;
    public final org.emftext.language.bibtex.TitleField parse_org_emftext_language_bibtex_TitleField() throws RecognitionException {
        org.emftext.language.bibtex.TitleField element =  null;
        int parse_org_emftext_language_bibtex_TitleField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Bib.g:724:1: (a0= 'title' a1= '=' (a2= QUOTED_34_34 ) )
            // Bib.g:725:2: a0= 'title' a1= '=' (a2= QUOTED_34_34 )
            {
            a0=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_bibtex_TitleField205); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 3);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_TitleField219); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 4);
              	
            }
            // Bib.g:753:2: (a2= QUOTED_34_34 )
            // Bib.g:754:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_TitleField237); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 5);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 5);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 5);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 5);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_bibtex_TitleField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_TitleField"


    // $ANTLR start "parse_org_emftext_language_bibtex_BookTitleField"
    // Bib.g:794:1: parse_org_emftext_language_bibtex_BookTitleField returns [org.emftext.language.bibtex.BookTitleField element = null] : a0= 'booktitle' a1= '=' (a2= QUOTED_34_34 ) ;
    public final org.emftext.language.bibtex.BookTitleField parse_org_emftext_language_bibtex_BookTitleField() throws RecognitionException {
        org.emftext.language.bibtex.BookTitleField element =  null;
        int parse_org_emftext_language_bibtex_BookTitleField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Bib.g:797:1: (a0= 'booktitle' a1= '=' (a2= QUOTED_34_34 ) )
            // Bib.g:798:2: a0= 'booktitle' a1= '=' (a2= QUOTED_34_34 )
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_BookTitleField273); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_11, 6);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_BookTitleField287); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_12, 7);
              	
            }
            // Bib.g:826:2: (a2= QUOTED_34_34 )
            // Bib.g:827:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_BookTitleField305); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 8);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 8);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_bibtex_BookTitleField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_BookTitleField"


    // $ANTLR start "parse_org_emftext_language_bibtex_YearField"
    // Bib.g:865:1: parse_org_emftext_language_bibtex_YearField returns [org.emftext.language.bibtex.YearField element = null] : a0= 'year' a1= '=' a2= '{' (a3= YEAR ) a4= '}' ;
    public final org.emftext.language.bibtex.YearField parse_org_emftext_language_bibtex_YearField() throws RecognitionException {
        org.emftext.language.bibtex.YearField element =  null;
        int parse_org_emftext_language_bibtex_YearField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Bib.g:868:1: (a0= 'year' a1= '=' a2= '{' (a3= YEAR ) a4= '}' )
            // Bib.g:869:2: a0= 'year' a1= '=' a2= '{' (a3= YEAR ) a4= '}'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField341); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 9);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_YearField355); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 10);
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_YearField369); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 11);
              	
            }
            // Bib.g:911:2: (a3= YEAR )
            // Bib.g:912:3: a3= YEAR
            {
            a3=(Token)match(input,YEAR,FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField387); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 12);
              	
            }
            a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_YearField408); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 13);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 13);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 13);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 13);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_bibtex_YearField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_YearField"


    // $ANTLR start "parse_org_emftext_language_bibtex_AuthorField"
    // Bib.g:966:1: parse_org_emftext_language_bibtex_AuthorField returns [org.emftext.language.bibtex.AuthorField element = null] : a0= 'author' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '}' ;
    public final org.emftext.language.bibtex.AuthorField parse_org_emftext_language_bibtex_AuthorField() throws RecognitionException {
        org.emftext.language.bibtex.AuthorField element =  null;
        int parse_org_emftext_language_bibtex_AuthorField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.bibtex.Author a3_0 = null;

        org.emftext.language.bibtex.Author a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Bib.g:969:1: (a0= 'author' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '}' )
            // Bib.g:970:2: a0= 'author' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '}'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_AuthorField437); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 14);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_AuthorField451); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_20, 15);
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField465); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
              	
            }
            // Bib.g:1012:2: (a3_0= parse_org_emftext_language_bibtex_Author )
            // Bib.g:1013:3: a3_0= parse_org_emftext_language_bibtex_Author
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField483);
            a3_0=parse_org_emftext_language_bibtex_Author();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 17);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 17);
              	
            }
            // Bib.g:1039:2: ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Bib.g:1040:3: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) )
            	    {
            	    // Bib.g:1040:3: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) )
            	    // Bib.g:1041:4: a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author )
            	    {
            	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_AuthorField510); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_5_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 18, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
            	      			
            	    }
            	    // Bib.g:1055:4: (a5_0= parse_org_emftext_language_bibtex_Author )
            	    // Bib.g:1056:5: a5_0= parse_org_emftext_language_bibtex_Author
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField536);
            	    a5_0=parse_org_emftext_language_bibtex_Author();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 19);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 19);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 20);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 20);
              	
            }
            a6=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_AuthorField577); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_6, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 21);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_bibtex_AuthorField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_AuthorField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Author"
    // Bib.g:1109:1: parse_org_emftext_language_bibtex_Author returns [org.emftext.language.bibtex.Author element = null] : (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ;
    public final org.emftext.language.bibtex.Author parse_org_emftext_language_bibtex_Author() throws RecognitionException {
        org.emftext.language.bibtex.Author element =  null;
        int parse_org_emftext_language_bibtex_Author_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Bib.g:1112:1: ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) )
            // Bib.g:1113:2: (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT )
            {
            // Bib.g:1113:2: (a0= TEXT )
            // Bib.g:1114:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author610); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_24, 22);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 22);
              	
            }
            // Bib.g:1150:2: ( ( (a1= TEXT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TEXT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==TEXT) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // Bib.g:1151:3: ( (a1= TEXT ) )
                    {
                    // Bib.g:1151:3: ( (a1= TEXT ) )
                    // Bib.g:1152:4: (a1= TEXT )
                    {
                    // Bib.g:1152:4: (a1= TEXT )
                    // Bib.g:1153:5: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author646); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 23);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_25, 24);
              	
            }
            // Bib.g:1195:2: (a2= TEXT )
            // Bib.g:1196:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author696); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 25);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 25);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_bibtex_Author_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Author"


    // $ANTLR start "parse_org_emftext_language_bibtex_JournalField"
    // Bib.g:1234:1: parse_org_emftext_language_bibtex_JournalField returns [org.emftext.language.bibtex.JournalField element = null] : a0= 'journal' a1= '=' a2= '{' (a3= TEXT ) a4= '}' ;
    public final org.emftext.language.bibtex.JournalField parse_org_emftext_language_bibtex_JournalField() throws RecognitionException {
        org.emftext.language.bibtex.JournalField element =  null;
        int parse_org_emftext_language_bibtex_JournalField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Bib.g:1237:1: (a0= 'journal' a1= '=' a2= '{' (a3= TEXT ) a4= '}' )
            // Bib.g:1238:2: a0= 'journal' a1= '=' a2= '{' (a3= TEXT ) a4= '}'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_bibtex_JournalField732); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_27, 26);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_JournalField746); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_28, 27);
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_JournalField760); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 28);
              	
            }
            // Bib.g:1280:2: (a3= TEXT )
            // Bib.g:1281:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_JournalField778); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 29);
              	
            }
            a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_JournalField799); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_7_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 30);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 30);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_bibtex_JournalField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_JournalField"


    // $ANTLR start "parse_org_emftext_language_bibtex_VolumeField"
    // Bib.g:1333:1: parse_org_emftext_language_bibtex_VolumeField returns [org.emftext.language.bibtex.VolumeField element = null] : a0= 'volume' a1= '=' a2= '{' (a3= INTEGER ) a4= '}' ;
    public final org.emftext.language.bibtex.VolumeField parse_org_emftext_language_bibtex_VolumeField() throws RecognitionException {
        org.emftext.language.bibtex.VolumeField element =  null;
        int parse_org_emftext_language_bibtex_VolumeField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Bib.g:1336:1: (a0= 'volume' a1= '=' a2= '{' (a3= INTEGER ) a4= '}' )
            // Bib.g:1337:2: a0= 'volume' a1= '=' a2= '{' (a3= INTEGER ) a4= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_bibtex_VolumeField828); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 31);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_VolumeField842); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 32);
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_VolumeField856); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 33);
              	
            }
            // Bib.g:1379:2: (a3= INTEGER )
            // Bib.g:1380:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField874); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_35, 34);
              	
            }
            a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_VolumeField895); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 35);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 35);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_bibtex_VolumeField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_VolumeField"


    // $ANTLR start "parse_org_emftext_language_bibtex_PageField"
    // Bib.g:1432:1: parse_org_emftext_language_bibtex_PageField returns [org.emftext.language.bibtex.PageField element = null] : a0= 'pages' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) ) )? a6= '}' ;
    public final org.emftext.language.bibtex.PageField parse_org_emftext_language_bibtex_PageField() throws RecognitionException {
        org.emftext.language.bibtex.PageField element =  null;
        int parse_org_emftext_language_bibtex_PageField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.bibtex.Page a3_0 = null;

        org.emftext.language.bibtex.Page a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Bib.g:1435:1: (a0= 'pages' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) ) )? a6= '}' )
            // Bib.g:1436:2: a0= 'pages' a1= '=' a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) ) )? a6= '}'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_bibtex_PageField924); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_37, 36);
              	
            }
            a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_PageField938); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_38, 37);
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_PageField952); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 38, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
              	
            }
            // Bib.g:1478:2: (a3_0= parse_org_emftext_language_bibtex_Page )
            // Bib.g:1479:3: a3_0= parse_org_emftext_language_bibtex_Page
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField970);
            a3_0=parse_org_emftext_language_bibtex_Page();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 39);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 39);
              	
            }
            // Bib.g:1505:2: ( (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Bib.g:1506:3: (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) )
                    {
                    // Bib.g:1506:3: (a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page ) )
                    // Bib.g:1507:4: a4= '--' (a5_0= parse_org_emftext_language_bibtex_Page )
                    {
                    a4=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_bibtex_PageField997); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_5_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 40, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                      			
                    }
                    // Bib.g:1521:4: (a5_0= parse_org_emftext_language_bibtex_Page )
                    // Bib.g:1522:5: a5_0= parse_org_emftext_language_bibtex_Page
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField1023);
                    a5_0=parse_org_emftext_language_bibtex_Page();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 41);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 42);
              	
            }
            a6=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_PageField1064); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_6, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 43);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 43);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_bibtex_PageField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_PageField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Page"
    // Bib.g:1571:1: parse_org_emftext_language_bibtex_Page returns [org.emftext.language.bibtex.Page element = null] : (a0= INTEGER ) ;
    public final org.emftext.language.bibtex.Page parse_org_emftext_language_bibtex_Page() throws RecognitionException {
        org.emftext.language.bibtex.Page element =  null;
        int parse_org_emftext_language_bibtex_Page_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Bib.g:1574:1: ( (a0= INTEGER ) )
            // Bib.g:1575:2: (a0= INTEGER )
            {
            // Bib.g:1575:2: (a0= INTEGER )
            // Bib.g:1576:3: a0= INTEGER
            {
            a0=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_Page1097); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_40, 44);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 44);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_bibtex_Page_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Page"


    // $ANTLR start "parse_org_emftext_language_bibtex_InProceedingsEntry"
    // Bib.g:1614:1: parse_org_emftext_language_bibtex_InProceedingsEntry returns [org.emftext.language.bibtex.InProceedingsEntry element = null] : a0= '@INPROCEEDINGS' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) ) )+ a8= '}' ;
    public final org.emftext.language.bibtex.InProceedingsEntry parse_org_emftext_language_bibtex_InProceedingsEntry() throws RecognitionException {
        org.emftext.language.bibtex.InProceedingsEntry element =  null;
        int parse_org_emftext_language_bibtex_InProceedingsEntry_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a8=null;
        org.emftext.language.bibtex.BibtexKeyField a2_0 = null;

        org.emftext.language.bibtex.TitleField a4_0 = null;

        org.emftext.language.bibtex.BookTitleField a5_0 = null;

        org.emftext.language.bibtex.YearField a6_0 = null;

        org.emftext.language.bibtex.AuthorField a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Bib.g:1617:1: (a0= '@INPROCEEDINGS' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) ) )+ a8= '}' )
            // Bib.g:1618:2: a0= '@INPROCEEDINGS' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) ) )+ a8= '}'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_bibtex_InProceedingsEntry1133); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_42, 45);
              	
            }
            a1=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_InProceedingsEntry1147); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
              	
            }
            // Bib.g:1646:2: (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField )
            // Bib.g:1647:3: a2_0= parse_org_emftext_language_bibtex_BibtexKeyField
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1165);
            a2_0=parse_org_emftext_language_bibtex_BibtexKeyField();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 47);
              	
            }
            // Bib.g:1672:2: ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Bib.g:1673:3: (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) )
            	    {
            	    // Bib.g:1673:3: (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) ) )
            	    // Bib.g:1674:4: a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) )
            	    {
            	    a3=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_bibtex_InProceedingsEntry1192); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_5_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_10, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_7);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 48, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_8);
            	      			
            	    }
            	    // Bib.g:1691:4: ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) ) )
            	    int alt5=4;
            	    switch ( input.LA(1) ) {
            	    case 11:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 13:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 14:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // Bib.g:1692:5: ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            {
            	            // Bib.g:1692:5: ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            // Bib.g:1693:6: (a4_0= parse_org_emftext_language_bibtex_TitleField )
            	            {
            	            // Bib.g:1693:6: (a4_0= parse_org_emftext_language_bibtex_TitleField )
            	            // Bib.g:1694:7: a4_0= parse_org_emftext_language_bibtex_TitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1233);
            	            a4_0=parse_org_emftext_language_bibtex_TitleField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 49);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 49);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 50);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 50);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Bib.g:1728:10: ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) )
            	            {
            	            // Bib.g:1728:10: ( (a5_0= parse_org_emftext_language_bibtex_BookTitleField ) )
            	            // Bib.g:1729:6: (a5_0= parse_org_emftext_language_bibtex_BookTitleField )
            	            {
            	            // Bib.g:1729:6: (a5_0= parse_org_emftext_language_bibtex_BookTitleField )
            	            // Bib.g:1730:7: a5_0= parse_org_emftext_language_bibtex_BookTitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BookTitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1312);
            	            a5_0=parse_org_emftext_language_bibtex_BookTitleField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 51);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 51);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 52);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 52);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Bib.g:1764:10: ( (a6_0= parse_org_emftext_language_bibtex_YearField ) )
            	            {
            	            // Bib.g:1764:10: ( (a6_0= parse_org_emftext_language_bibtex_YearField ) )
            	            // Bib.g:1765:6: (a6_0= parse_org_emftext_language_bibtex_YearField )
            	            {
            	            // Bib.g:1765:6: (a6_0= parse_org_emftext_language_bibtex_YearField )
            	            // Bib.g:1766:7: a6_0= parse_org_emftext_language_bibtex_YearField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1391);
            	            a6_0=parse_org_emftext_language_bibtex_YearField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 53);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 53);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 54);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 54);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Bib.g:1800:10: ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            {
            	            // Bib.g:1800:10: ( (a7_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            // Bib.g:1801:6: (a7_0= parse_org_emftext_language_bibtex_AuthorField )
            	            {
            	            // Bib.g:1801:6: (a7_0= parse_org_emftext_language_bibtex_AuthorField )
            	            // Bib.g:1802:7: a7_0= parse_org_emftext_language_bibtex_AuthorField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1470);
            	            a7_0=parse_org_emftext_language_bibtex_AuthorField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 55);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 55);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 56);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 56);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 57);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 57);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 58);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 58);
              	
            }
            a8=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_InProceedingsEntry1550); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_7, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 59, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 59, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_bibtex_InProceedingsEntry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_InProceedingsEntry"


    // $ANTLR start "parse_org_emftext_language_bibtex_ArticleEntry"
    // Bib.g:1867:1: parse_org_emftext_language_bibtex_ArticleEntry returns [org.emftext.language.bibtex.ArticleEntry element = null] : a0= '@ARTICLE' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) ) )+ a10= '}' ;
    public final org.emftext.language.bibtex.ArticleEntry parse_org_emftext_language_bibtex_ArticleEntry() throws RecognitionException {
        org.emftext.language.bibtex.ArticleEntry element =  null;
        int parse_org_emftext_language_bibtex_ArticleEntry_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a10=null;
        org.emftext.language.bibtex.BibtexKeyField a2_0 = null;

        org.emftext.language.bibtex.TitleField a4_0 = null;

        org.emftext.language.bibtex.JournalField a5_0 = null;

        org.emftext.language.bibtex.VolumeField a6_0 = null;

        org.emftext.language.bibtex.YearField a7_0 = null;

        org.emftext.language.bibtex.AuthorField a8_0 = null;

        org.emftext.language.bibtex.PageField a9_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Bib.g:1870:1: (a0= '@ARTICLE' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) ) )+ a10= '}' )
            // Bib.g:1871:2: a0= '@ARTICLE' a1= '{' (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) ) )+ a10= '}'
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_bibtex_ArticleEntry1579); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_43, 60);
              	
            }
            a1=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_ArticleEntry1593); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 61, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
              	
            }
            // Bib.g:1899:2: (a2_0= parse_org_emftext_language_bibtex_BibtexKeyField )
            // Bib.g:1900:3: a2_0= parse_org_emftext_language_bibtex_BibtexKeyField
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_ArticleEntry1611);
            a2_0=parse_org_emftext_language_bibtex_BibtexKeyField();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 62);
              	
            }
            // Bib.g:1925:2: ( (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Bib.g:1926:3: (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) )
            	    {
            	    // Bib.g:1926:3: (a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) ) )
            	    // Bib.g:1927:4: a3= ',' ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) )
            	    {
            	    a3=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_bibtex_ArticleEntry1638); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_5_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_9);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_26, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_10);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_11);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_12);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 63, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_14);
            	      			
            	    }
            	    // Bib.g:1946:4: ( ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a7_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a9_0= parse_org_emftext_language_bibtex_PageField ) ) )
            	    int alt7=6;
            	    switch ( input.LA(1) ) {
            	    case 11:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case 20:
            	        {
            	        alt7=3;
            	        }
            	        break;
            	    case 14:
            	        {
            	        alt7=4;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt7=5;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt7=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // Bib.g:1947:5: ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            {
            	            // Bib.g:1947:5: ( (a4_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            // Bib.g:1948:6: (a4_0= parse_org_emftext_language_bibtex_TitleField )
            	            {
            	            // Bib.g:1948:6: (a4_0= parse_org_emftext_language_bibtex_TitleField )
            	            // Bib.g:1949:7: a4_0= parse_org_emftext_language_bibtex_TitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_ArticleEntry1679);
            	            a4_0=parse_org_emftext_language_bibtex_TitleField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 64);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 64);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 65);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 65);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Bib.g:1983:10: ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) )
            	            {
            	            // Bib.g:1983:10: ( (a5_0= parse_org_emftext_language_bibtex_JournalField ) )
            	            // Bib.g:1984:6: (a5_0= parse_org_emftext_language_bibtex_JournalField )
            	            {
            	            // Bib.g:1984:6: (a5_0= parse_org_emftext_language_bibtex_JournalField )
            	            // Bib.g:1985:7: a5_0= parse_org_emftext_language_bibtex_JournalField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_JournalField_in_parse_org_emftext_language_bibtex_ArticleEntry1758);
            	            a5_0=parse_org_emftext_language_bibtex_JournalField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 66);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 66);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 67);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 67);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Bib.g:2019:10: ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	            {
            	            // Bib.g:2019:10: ( (a6_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	            // Bib.g:2020:6: (a6_0= parse_org_emftext_language_bibtex_VolumeField )
            	            {
            	            // Bib.g:2020:6: (a6_0= parse_org_emftext_language_bibtex_VolumeField )
            	            // Bib.g:2021:7: a6_0= parse_org_emftext_language_bibtex_VolumeField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_ArticleEntry1837);
            	            a6_0=parse_org_emftext_language_bibtex_VolumeField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 68);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 68);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 69);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 69);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Bib.g:2055:10: ( (a7_0= parse_org_emftext_language_bibtex_YearField ) )
            	            {
            	            // Bib.g:2055:10: ( (a7_0= parse_org_emftext_language_bibtex_YearField ) )
            	            // Bib.g:2056:6: (a7_0= parse_org_emftext_language_bibtex_YearField )
            	            {
            	            // Bib.g:2056:6: (a7_0= parse_org_emftext_language_bibtex_YearField )
            	            // Bib.g:2057:7: a7_0= parse_org_emftext_language_bibtex_YearField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_ArticleEntry1916);
            	            a7_0=parse_org_emftext_language_bibtex_YearField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 70);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 70);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 71);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 71);
            	              				
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // Bib.g:2091:10: ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            {
            	            // Bib.g:2091:10: ( (a8_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            // Bib.g:2092:6: (a8_0= parse_org_emftext_language_bibtex_AuthorField )
            	            {
            	            // Bib.g:2092:6: (a8_0= parse_org_emftext_language_bibtex_AuthorField )
            	            // Bib.g:2093:7: a8_0= parse_org_emftext_language_bibtex_AuthorField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_ArticleEntry1995);
            	            a8_0=parse_org_emftext_language_bibtex_AuthorField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 72);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 72);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 73);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 73);
            	              				
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // Bib.g:2127:10: ( (a9_0= parse_org_emftext_language_bibtex_PageField ) )
            	            {
            	            // Bib.g:2127:10: ( (a9_0= parse_org_emftext_language_bibtex_PageField ) )
            	            // Bib.g:2128:6: (a9_0= parse_org_emftext_language_bibtex_PageField )
            	            {
            	            // Bib.g:2128:6: (a9_0= parse_org_emftext_language_bibtex_PageField )
            	            // Bib.g:2129:7: a9_0= parse_org_emftext_language_bibtex_PageField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_ArticleEntry2074);
            	            a9_0=parse_org_emftext_language_bibtex_PageField();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 74);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 74);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 75);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 75);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 76);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 76);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 77);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 77);
              	
            }
            a10=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_ArticleEntry2154); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_7, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 78, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 78, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_bibtex_ArticleEntry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_ArticleEntry"


    // $ANTLR start "parse_org_emftext_language_bibtex_Entry"
    // Bib.g:2194:1: parse_org_emftext_language_bibtex_Entry returns [org.emftext.language.bibtex.Entry element = null] : (c0= parse_org_emftext_language_bibtex_InProceedingsEntry | c1= parse_org_emftext_language_bibtex_ArticleEntry );
    public final org.emftext.language.bibtex.Entry parse_org_emftext_language_bibtex_Entry() throws RecognitionException {
        org.emftext.language.bibtex.Entry element =  null;
        int parse_org_emftext_language_bibtex_Entry_StartIndex = input.index();
        org.emftext.language.bibtex.InProceedingsEntry c0 = null;

        org.emftext.language.bibtex.ArticleEntry c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Bib.g:2195:1: (c0= parse_org_emftext_language_bibtex_InProceedingsEntry | c1= parse_org_emftext_language_bibtex_ArticleEntry )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==25) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // Bib.g:2196:2: c0= parse_org_emftext_language_bibtex_InProceedingsEntry
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_InProceedingsEntry_in_parse_org_emftext_language_bibtex_Entry2179);
                    c0=parse_org_emftext_language_bibtex_InProceedingsEntry();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2197:4: c1= parse_org_emftext_language_bibtex_ArticleEntry
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ArticleEntry_in_parse_org_emftext_language_bibtex_Entry2189);
                    c1=parse_org_emftext_language_bibtex_ArticleEntry();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_bibtex_Entry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Entry"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Bibliography_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Entry_in_parse_org_emftext_language_bibtex_Bibliography124 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BibtexKeyField169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_bibtex_TitleField205 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_TitleField219 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_TitleField237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_BookTitleField273 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_BookTitleField287 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_BookTitleField305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField341 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_YearField355 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_YearField369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField387 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_YearField408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_AuthorField437 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_AuthorField451 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField483 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_AuthorField510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField536 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_AuthorField577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author646 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_bibtex_JournalField732 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_JournalField746 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_JournalField760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_JournalField778 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_JournalField799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_bibtex_VolumeField828 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_VolumeField842 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_VolumeField856 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_VolumeField895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_bibtex_PageField924 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_PageField938 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_PageField952 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField970 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_bibtex_PageField997 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField1023 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_PageField1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_Page1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_bibtex_InProceedingsEntry1133 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_InProceedingsEntry1147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1165 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_bibtex_InProceedingsEntry1192 = new BitSet(new long[]{0x0000000000026800L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1233 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BookTitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1312 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1391 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry1470 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_InProceedingsEntry1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_bibtex_ArticleEntry1579 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_ArticleEntry1593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_ArticleEntry1611 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_bibtex_ArticleEntry1638 = new BitSet(new long[]{0x00000000003A6800L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_ArticleEntry1679 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_JournalField_in_parse_org_emftext_language_bibtex_ArticleEntry1758 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_ArticleEntry1837 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_ArticleEntry1916 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_ArticleEntry1995 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_ArticleEntry2074 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_ArticleEntry2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_InProceedingsEntry_in_parse_org_emftext_language_bibtex_Entry2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ArticleEntry_in_parse_org_emftext_language_bibtex_Entry2189 = new BitSet(new long[]{0x0000000000000002L});

}