// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.bibtex.resource.bib.mopp;


import org.antlr.runtime3_3_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class BibParser extends BibANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "TEXT", "QUOTED_34_34", "YEAR", "INTEGER", "COMMENT", "LINEBREAK", "WHITESPACE", "'author'", "'='", "'\\\"'", "'and'", "'{'", "'}'", "','", "'editor'", "'keywords'", "'title'", "'booktitle'", "'series'", "'address'", "'month'", "'organization'", "'publisher'", "'journal'", "'note'", "'eid'", "'abstract'", "'review'", "'url'", "'year'", "'volume'", "'part'", "'number'", "'pages'", "'--'", "'-'", "'@INPROCEEDINGS'", "'@inproceedings'", "'@ARTICLE'", "'@article'"
    };
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int ID=4;
    public static final int TEXT=5;
    public static final int QUOTED_34_34=6;
    public static final int YEAR=7;
    public static final int INTEGER=8;
    public static final int COMMENT=9;
    public static final int LINEBREAK=10;
    public static final int WHITESPACE=11;

    // delegates
    // delegators


        public BibParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[130+1];
             
             
        }
        

    public String[] getTokenNames() { return BibParser.tokenNames; }
    public String getGrammarFileName() { return "Bib.g"; }


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
    	



    // $ANTLR start "start"
    // Bib.g:547:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.bibtex.Bibliography c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Bib.g:548:1: ( (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF )
            // Bib.g:549:2: (c0= parse_org_emftext_language_bibtex_Bibliography ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 0, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		expectedElementsIndexOfLastCompleteElement = 0;
              	
            }
            // Bib.g:557:2: (c0= parse_org_emftext_language_bibtex_Bibliography )
            // Bib.g:558:3: c0= parse_org_emftext_language_bibtex_Bibliography
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
    // Bib.g:566:1: parse_org_emftext_language_bibtex_Bibliography returns [org.emftext.language.bibtex.Bibliography element = null] : ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )* ;
    public final org.emftext.language.bibtex.Bibliography parse_org_emftext_language_bibtex_Bibliography() throws RecognitionException {
        org.emftext.language.bibtex.Bibliography element =  null;
        int parse_org_emftext_language_bibtex_Bibliography_StartIndex = input.index();
        org.emftext.language.bibtex.Entry a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Bib.g:569:1: ( ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )* )
            // Bib.g:570:2: ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )*
            {
            // Bib.g:570:2: ( (a0_0= parse_org_emftext_language_bibtex_Entry ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=41 && LA1_0<=44)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bib.g:571:3: (a0_0= parse_org_emftext_language_bibtex_Entry )
            	    {
            	    // Bib.g:571:3: (a0_0= parse_org_emftext_language_bibtex_Entry )
            	    // Bib.g:572:4: a0_0= parse_org_emftext_language_bibtex_Entry
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
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 1, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
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
    // Bib.g:603:1: parse_org_emftext_language_bibtex_BibtexKeyField returns [org.emftext.language.bibtex.BibtexKeyField element = null] : ( (a0= ID ) | (a1= TEXT ) ) ;
    public final org.emftext.language.bibtex.BibtexKeyField parse_org_emftext_language_bibtex_BibtexKeyField() throws RecognitionException {
        org.emftext.language.bibtex.BibtexKeyField element =  null;
        int parse_org_emftext_language_bibtex_BibtexKeyField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Bib.g:606:1: ( ( (a0= ID ) | (a1= TEXT ) ) )
            // Bib.g:607:2: ( (a0= ID ) | (a1= TEXT ) )
            {
            // Bib.g:607:2: ( (a0= ID ) | (a1= TEXT ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==TEXT) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Bib.g:608:3: (a0= ID )
                    {
                    // Bib.g:608:3: (a0= ID )
                    // Bib.g:609:4: a0= ID
                    {
                    a0=(Token)match(input,ID,FOLLOW_ID_in_parse_org_emftext_language_bibtex_BibtexKeyField174); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 2);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 2);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 2);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 2);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:648:6: (a1= TEXT )
                    {
                    // Bib.g:648:6: (a1= TEXT )
                    // Bib.g:649:4: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BibtexKeyField212); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 3);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 3);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 3);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 3);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 4);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 4);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 4);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 4);
              	
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


    // $ANTLR start "parse_org_emftext_language_bibtex_AuthorField"
    // Bib.g:698:1: parse_org_emftext_language_bibtex_AuthorField returns [org.emftext.language.bibtex.AuthorField element = null] : a0= 'author' a1= '=' ( (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' ) | (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' ) ) ;
    public final org.emftext.language.bibtex.AuthorField parse_org_emftext_language_bibtex_AuthorField() throws RecognitionException {
        org.emftext.language.bibtex.AuthorField element =  null;
        int parse_org_emftext_language_bibtex_AuthorField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a11=null;
        org.emftext.language.bibtex.Author a3_0 = null;

        org.emftext.language.bibtex.Author a5_0 = null;

        org.emftext.language.bibtex.Author a8_0 = null;

        org.emftext.language.bibtex.Author a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Bib.g:701:1: (a0= 'author' a1= '=' ( (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' ) | (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' ) ) )
            // Bib.g:702:2: a0= 'author' a1= '=' ( (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' ) | (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' ) )
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_bibtex_AuthorField261); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_11, 5);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_AuthorField275); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_12, 6);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_13, 6);
              	
            }
            // Bib.g:731:2: ( (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' ) | (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Bib.g:732:3: (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' )
                    {
                    // Bib.g:732:3: (a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"' )
                    // Bib.g:733:4: a2= '\\\"' (a3_0= parse_org_emftext_language_bibtex_Author ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )* a6= '\\\"'
                    {
                    a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_AuthorField298); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 7, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 7, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                      			
                    }
                    // Bib.g:748:4: (a3_0= parse_org_emftext_language_bibtex_Author )
                    // Bib.g:749:5: a3_0= parse_org_emftext_language_bibtex_Author
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField324);
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
                      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_1, a3_0, true);
                      						copyLocalizationInfos(a3_0, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 8);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 8);
                      			
                    }
                    // Bib.g:775:4: ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Bib.g:776:5: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) )
                    	    {
                    	    // Bib.g:776:5: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author ) )
                    	    // Bib.g:777:6: a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Author )
                    	    {
                    	    a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField365); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_2_0_0_0, null, true);
                    	      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 9, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 9, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                    	      					
                    	    }
                    	    // Bib.g:792:6: (a5_0= parse_org_emftext_language_bibtex_Author )
                    	    // Bib.g:793:7: a5_0= parse_org_emftext_language_bibtex_Author
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField399);
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
                    	      								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_2_0_0_1, a5_0, true);
                    	      								copyLocalizationInfos(a5_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 10);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 10);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 11);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 11);
                      			
                    }
                    a6=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_AuthorField460); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_0_0_0_0_3, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 12);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 12);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 12);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 12);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 13);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 13);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 13);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 13);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:854:6: (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' )
                    {
                    // Bib.g:854:6: (a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}' )
                    // Bib.g:855:4: a7= '{' (a8_0= parse_org_emftext_language_bibtex_Author ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )* a11= '}'
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_AuthorField501); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 14, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 14, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                      			
                    }
                    // Bib.g:870:4: (a8_0= parse_org_emftext_language_bibtex_Author )
                    // Bib.g:871:5: a8_0= parse_org_emftext_language_bibtex_Author
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField527);
                    a8_0=parse_org_emftext_language_bibtex_Author();

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 15);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 15);
                      			
                    }
                    // Bib.g:897:4: ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Bib.g:898:5: (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) )
                    	    {
                    	    // Bib.g:898:5: (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author ) )
                    	    // Bib.g:899:6: a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Author )
                    	    {
                    	    a9=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField568); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_2_0_0_0, null, true);
                    	      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_14, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_15, 16, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_1);
                    	      					
                    	    }
                    	    // Bib.g:914:6: (a10_0= parse_org_emftext_language_bibtex_Author )
                    	    // Bib.g:915:7: a10_0= parse_org_emftext_language_bibtex_Author
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField602);
                    	    a10_0=parse_org_emftext_language_bibtex_Author();

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 17);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 17);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_18, 18);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_19, 18);
                      			
                    }
                    a11=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_AuthorField663); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_2_0_0_3_0_1_0_0_0_3, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 19);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 19);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 19);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 19);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 20);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 20);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 20);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 20);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 21);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 21);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_bibtex_AuthorField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_AuthorField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Author"
    // Bib.g:986:1: parse_org_emftext_language_bibtex_Author returns [org.emftext.language.bibtex.Author element = null] : ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) ) ;
    public final org.emftext.language.bibtex.Author parse_org_emftext_language_bibtex_Author() throws RecognitionException {
        org.emftext.language.bibtex.Author element =  null;
        int parse_org_emftext_language_bibtex_Author_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Bib.g:989:1: ( ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) ) )
            // Bib.g:990:2: ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) )
            {
            // Bib.g:990:2: ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==TEXT) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==TEXT) ) {
                    alt8=1;
                }
                else if ( (LA8_1==18) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Bib.g:991:3: ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) )
                    {
                    // Bib.g:991:3: ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) )
                    // Bib.g:992:4: (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT )
                    {
                    // Bib.g:992:4: (a0= TEXT )
                    // Bib.g:993:5: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author730); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_20, 22);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 22);
                      			
                    }
                    // Bib.g:1029:4: ( ( (a1= TEXT ) ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==TEXT) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==TEXT) ) {
                            alt6=1;
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // Bib.g:1030:5: ( (a1= TEXT ) )
                            {
                            // Bib.g:1030:5: ( (a1= TEXT ) )
                            // Bib.g:1031:6: (a1= TEXT )
                            {
                            // Bib.g:1031:6: (a1= TEXT )
                            // Bib.g:1032:7: a1= TEXT
                            {
                            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author784); if (state.failed) return element;
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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 23);
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_21, 24);
                      			
                    }
                    // Bib.g:1074:4: (a2= TEXT )
                    // Bib.g:1075:5: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author858); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 25);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 25);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 26);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 26);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:1119:6: ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) )
                    {
                    // Bib.g:1119:6: ( ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) )
                    // Bib.g:1120:4: ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? )
                    {
                    // Bib.g:1120:4: ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? )
                    // Bib.g:1121:5: (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )?
                    {
                    // Bib.g:1121:5: (a3= TEXT )
                    // Bib.g:1122:6: a3= TEXT
                    {
                    a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author925); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_22, 27);
                      				
                    }
                    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_Author964); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAuthor();
                      						incompleteObjects.push(element);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_3_0_0_0_0_1_0_0_0_0_0_0_1, null, true);
                      					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_23, 28);
                      				
                    }
                    // Bib.g:1171:5: (a5= TEXT )
                    // Bib.g:1172:6: a5= TEXT
                    {
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author994); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_24, 29);
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 29);
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 29);
                      				
                    }
                    // Bib.g:1209:5: ( ( (a6= TEXT ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==TEXT) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Bib.g:1210:6: ( (a6= TEXT ) )
                            {
                            // Bib.g:1210:6: ( (a6= TEXT ) )
                            // Bib.g:1211:7: (a6= TEXT )
                            {
                            // Bib.g:1211:7: (a6= TEXT )
                            // Bib.g:1212:8: a6= TEXT
                            {
                            a6=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author1057); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              							// expected elements (follow set)
                              							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 30);
                              							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 30);
                              						
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 31);
                      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 31);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 32);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 32);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 33);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 33);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_16, 34);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_17, 34);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_bibtex_Author_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Author"


    // $ANTLR start "parse_org_emftext_language_bibtex_EditorField"
    // Bib.g:1279:1: parse_org_emftext_language_bibtex_EditorField returns [org.emftext.language.bibtex.EditorField element = null] : a0= 'editor' a1= '=' ( (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' ) | (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' ) ) ;
    public final org.emftext.language.bibtex.EditorField parse_org_emftext_language_bibtex_EditorField() throws RecognitionException {
        org.emftext.language.bibtex.EditorField element =  null;
        int parse_org_emftext_language_bibtex_EditorField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a11=null;
        org.emftext.language.bibtex.Editor a3_0 = null;

        org.emftext.language.bibtex.Editor a5_0 = null;

        org.emftext.language.bibtex.Editor a8_0 = null;

        org.emftext.language.bibtex.Editor a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Bib.g:1282:1: (a0= 'editor' a1= '=' ( (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' ) | (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' ) ) )
            // Bib.g:1283:2: a0= 'editor' a1= '=' ( (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' ) | (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' ) )
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_bibtex_EditorField1181); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_26, 35);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_EditorField1195); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_27, 36);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_28, 36);
              	
            }
            // Bib.g:1312:2: ( (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' ) | (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            else if ( (LA11_0==14) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // Bib.g:1313:3: (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' )
                    {
                    // Bib.g:1313:3: (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}' )
                    // Bib.g:1314:4: a2= '{' (a3_0= parse_org_emftext_language_bibtex_Editor ) ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )* a6= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_EditorField1218); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 37, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 37, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                      			
                    }
                    // Bib.g:1329:4: (a3_0= parse_org_emftext_language_bibtex_Editor )
                    // Bib.g:1330:5: a3_0= parse_org_emftext_language_bibtex_Editor
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1244);
                    a3_0=parse_org_emftext_language_bibtex_Editor();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 38);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 38);
                      			
                    }
                    // Bib.g:1356:4: ( (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==15) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Bib.g:1357:5: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) )
                    	    {
                    	    // Bib.g:1357:5: (a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor ) )
                    	    // Bib.g:1358:6: a4= 'and' (a5_0= parse_org_emftext_language_bibtex_Editor )
                    	    {
                    	    a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_EditorField1285); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_2_0_0_0, null, true);
                    	      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 39, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 39, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                    	      					
                    	    }
                    	    // Bib.g:1373:6: (a5_0= parse_org_emftext_language_bibtex_Editor )
                    	    // Bib.g:1374:7: a5_0= parse_org_emftext_language_bibtex_Editor
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1319);
                    	    a5_0=parse_org_emftext_language_bibtex_Editor();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 40);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 40);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 41);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 41);
                      			
                    }
                    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_EditorField1380); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_0_0_0_0_3, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 42);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 42);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 43);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 43);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:1431:6: (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' )
                    {
                    // Bib.g:1431:6: (a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"' )
                    // Bib.g:1432:4: a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Editor ) ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )* a11= '\\\"'
                    {
                    a7=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_EditorField1421); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 44, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 44, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                      			
                    }
                    // Bib.g:1447:4: (a8_0= parse_org_emftext_language_bibtex_Editor )
                    // Bib.g:1448:5: a8_0= parse_org_emftext_language_bibtex_Editor
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1447);
                    a8_0=parse_org_emftext_language_bibtex_Editor();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 45);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 45);
                      			
                    }
                    // Bib.g:1474:4: ( (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==15) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Bib.g:1475:5: (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) )
                    	    {
                    	    // Bib.g:1475:5: (a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor ) )
                    	    // Bib.g:1476:6: a9= 'and' (a10_0= parse_org_emftext_language_bibtex_Editor )
                    	    {
                    	    a9=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_bibtex_EditorField1488); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_2_0_0_0, null, true);
                    	      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_29, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_30, 46, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_2);
                    	      					
                    	    }
                    	    // Bib.g:1491:6: (a10_0= parse_org_emftext_language_bibtex_Editor )
                    	    // Bib.g:1492:7: a10_0= parse_org_emftext_language_bibtex_Editor
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1522);
                    	    a10_0=parse_org_emftext_language_bibtex_Editor();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 47);
                    	      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 47);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_33, 48);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_34, 48);
                      			
                    }
                    a11=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_EditorField1583); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditorField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_4_0_0_3_0_1_0_0_0_3, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 49);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 49);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 50);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 50);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 51);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 51);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_bibtex_EditorField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_EditorField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Editor"
    // Bib.g:1557:1: parse_org_emftext_language_bibtex_Editor returns [org.emftext.language.bibtex.Editor element = null] : ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) ;
    public final org.emftext.language.bibtex.Editor parse_org_emftext_language_bibtex_Editor() throws RecognitionException {
        org.emftext.language.bibtex.Editor element =  null;
        int parse_org_emftext_language_bibtex_Editor_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Bib.g:1560:1: ( ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) ) )
            // Bib.g:1561:2: ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) )
            {
            // Bib.g:1561:2: ( ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) ) | ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==TEXT) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==TEXT) ) {
                    alt14=1;
                }
                else if ( (LA14_1==18) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // Bib.g:1562:3: ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) )
                    {
                    // Bib.g:1562:3: ( (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT ) )
                    // Bib.g:1563:4: (a0= TEXT ) ( ( (a1= TEXT ) ) )? (a2= TEXT )
                    {
                    // Bib.g:1563:4: (a0= TEXT )
                    // Bib.g:1564:5: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1650); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_35, 52);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 52);
                      			
                    }
                    // Bib.g:1600:4: ( ( (a1= TEXT ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==TEXT) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==TEXT) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // Bib.g:1601:5: ( (a1= TEXT ) )
                            {
                            // Bib.g:1601:5: ( (a1= TEXT ) )
                            // Bib.g:1602:6: (a1= TEXT )
                            {
                            // Bib.g:1602:6: (a1= TEXT )
                            // Bib.g:1603:7: a1= TEXT
                            {
                            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1704); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 53);
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_36, 54);
                      			
                    }
                    // Bib.g:1645:4: (a2= TEXT )
                    // Bib.g:1646:5: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1778); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 55);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 55);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 56);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 56);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:1690:6: ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? )
                    {
                    // Bib.g:1690:6: ( (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )? )
                    // Bib.g:1691:4: (a3= TEXT ) a4= ',' (a5= TEXT ) ( ( (a6= TEXT ) ) )?
                    {
                    // Bib.g:1691:4: (a3= TEXT )
                    // Bib.g:1692:5: a3= TEXT
                    {
                    a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1838); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_37, 57);
                      			
                    }
                    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_Editor1871); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEditor();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_5_0_0_0_0_1_0_0_0_1, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_38, 58);
                      			
                    }
                    // Bib.g:1741:4: (a5= TEXT )
                    // Bib.g:1742:5: a5= TEXT
                    {
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1897); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_39, 59);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 59);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 59);
                      			
                    }
                    // Bib.g:1779:4: ( ( (a6= TEXT ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==TEXT) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // Bib.g:1780:5: ( (a6= TEXT ) )
                            {
                            // Bib.g:1780:5: ( (a6= TEXT ) )
                            // Bib.g:1781:6: (a6= TEXT )
                            {
                            // Bib.g:1781:6: (a6= TEXT )
                            // Bib.g:1782:7: a6= TEXT
                            {
                            a6=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1951); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 60);
                              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 60);
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 61);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 61);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 62);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 62);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_31, 63);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_32, 63);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_bibtex_Editor_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Editor"


    // $ANTLR start "parse_org_emftext_language_bibtex_KeywordField"
    // Bib.g:1842:1: parse_org_emftext_language_bibtex_KeywordField returns [org.emftext.language.bibtex.KeywordField element = null] : a0= 'keywords' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Keyword ) ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a6= '}' | a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Keyword ) ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a11= '\\\"' ) ;
    public final org.emftext.language.bibtex.KeywordField parse_org_emftext_language_bibtex_KeywordField() throws RecognitionException {
        org.emftext.language.bibtex.KeywordField element =  null;
        int parse_org_emftext_language_bibtex_KeywordField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a11=null;
        org.emftext.language.bibtex.Keyword a3_0 = null;

        org.emftext.language.bibtex.Keyword a5_0 = null;

        org.emftext.language.bibtex.Keyword a8_0 = null;

        org.emftext.language.bibtex.Keyword a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Bib.g:1845:1: (a0= 'keywords' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Keyword ) ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a6= '}' | a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Keyword ) ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a11= '\\\"' ) )
            // Bib.g:1846:2: a0= 'keywords' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Keyword ) ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a6= '}' | a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Keyword ) ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a11= '\\\"' )
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_bibtex_KeywordField2051); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_41, 64);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_KeywordField2065); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_42, 65);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_43, 65);
              	
            }
            // Bib.g:1875:2: (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Keyword ) ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a6= '}' | a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Keyword ) ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a11= '\\\"' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==16) ) {
                alt17=1;
            }
            else if ( (LA17_0==14) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // Bib.g:1876:3: a2= '{' (a3_0= parse_org_emftext_language_bibtex_Keyword ) ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a6= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_KeywordField2083); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 66, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 66, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                      		
                    }
                    // Bib.g:1891:3: (a3_0= parse_org_emftext_language_bibtex_Keyword )
                    // Bib.g:1892:4: a3_0= parse_org_emftext_language_bibtex_Keyword
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2105);
                    a3_0=parse_org_emftext_language_bibtex_Keyword();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 67);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 67);
                      		
                    }
                    // Bib.g:1918:3: ( (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==18) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Bib.g:1919:4: (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) )
                    	    {
                    	    // Bib.g:1919:4: (a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword ) )
                    	    // Bib.g:1920:5: a4= ',' (a5_0= parse_org_emftext_language_bibtex_Keyword )
                    	    {
                    	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_KeywordField2139); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                    	      						incompleteObjects.push(element);
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_2_0_0_0, null, true);
                    	      					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 68, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 68, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                    	      				
                    	    }
                    	    // Bib.g:1935:5: (a5_0= parse_org_emftext_language_bibtex_Keyword )
                    	    // Bib.g:1936:6: a5_0= parse_org_emftext_language_bibtex_Keyword
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2169);
                    	    a5_0=parse_org_emftext_language_bibtex_Keyword();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 69);
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 69);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 70);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 70);
                      		
                    }
                    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_KeywordField2220); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_0_3, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 71);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 71);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 71);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 71);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:1988:6: a7= '\\\"' (a8_0= parse_org_emftext_language_bibtex_Keyword ) ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )* a11= '\\\"'
                    {
                    a7=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_KeywordField2243); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 72, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 72, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                      		
                    }
                    // Bib.g:2003:3: (a8_0= parse_org_emftext_language_bibtex_Keyword )
                    // Bib.g:2004:4: a8_0= parse_org_emftext_language_bibtex_Keyword
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2265);
                    a8_0=parse_org_emftext_language_bibtex_Keyword();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 73);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 73);
                      		
                    }
                    // Bib.g:2030:3: ( (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==18) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Bib.g:2031:4: (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) )
                    	    {
                    	    // Bib.g:2031:4: (a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword ) )
                    	    // Bib.g:2032:5: a9= ',' (a10_0= parse_org_emftext_language_bibtex_Keyword )
                    	    {
                    	    a9=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_KeywordField2299); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                    	      						incompleteObjects.push(element);
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_2_0_0_0, null, true);
                    	      					copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_44, 74, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_45, 74, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_3);
                    	      				
                    	    }
                    	    // Bib.g:2047:5: (a10_0= parse_org_emftext_language_bibtex_Keyword )
                    	    // Bib.g:2048:6: a10_0= parse_org_emftext_language_bibtex_Keyword
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2329);
                    	    a10_0=parse_org_emftext_language_bibtex_Keyword();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 75);
                    	      					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 75);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_48, 76);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_49, 76);
                      		
                    }
                    a11=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_KeywordField2380); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createKeywordField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_6_0_0_3_0_1_3, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 77);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 77);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 77);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 77);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 78);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 78);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 78);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 78);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_bibtex_KeywordField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_KeywordField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Keyword"
    // Bib.g:2110:1: parse_org_emftext_language_bibtex_Keyword returns [org.emftext.language.bibtex.Keyword element = null] : ( (a0= TEXT ) | (a1= TEXT ) ) ;
    public final org.emftext.language.bibtex.Keyword parse_org_emftext_language_bibtex_Keyword() throws RecognitionException {
        org.emftext.language.bibtex.Keyword element =  null;
        int parse_org_emftext_language_bibtex_Keyword_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Bib.g:2113:1: ( ( (a0= TEXT ) | (a1= TEXT ) ) )
            // Bib.g:2114:2: ( (a0= TEXT ) | (a1= TEXT ) )
            {
            // Bib.g:2114:2: ( (a0= TEXT ) | (a1= TEXT ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==TEXT) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred18_Bib()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // Bib.g:2115:3: (a0= TEXT )
                    {
                    // Bib.g:2115:3: (a0= TEXT )
                    // Bib.g:2116:4: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Keyword2428); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 79);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 79);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2153:6: (a1= TEXT )
                    {
                    // Bib.g:2153:6: (a1= TEXT )
                    // Bib.g:2154:4: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Keyword2466); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 80);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 80);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_46, 81);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_47, 81);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_bibtex_Keyword_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Keyword"


    // $ANTLR start "parse_org_emftext_language_bibtex_TitleField"
    // Bib.g:2199:1: parse_org_emftext_language_bibtex_TitleField returns [org.emftext.language.bibtex.TitleField element = null] : a0= 'title' a1= '=' ( (a2= QUOTED_34_34 ) | (a3= '{' (a4= TEXT ) a5= '}' ) ) ;
    public final org.emftext.language.bibtex.TitleField parse_org_emftext_language_bibtex_TitleField() throws RecognitionException {
        org.emftext.language.bibtex.TitleField element =  null;
        int parse_org_emftext_language_bibtex_TitleField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Bib.g:2202:1: (a0= 'title' a1= '=' ( (a2= QUOTED_34_34 ) | (a3= '{' (a4= TEXT ) a5= '}' ) ) )
            // Bib.g:2203:2: a0= 'title' a1= '=' ( (a2= QUOTED_34_34 ) | (a3= '{' (a4= TEXT ) a5= '}' ) )
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_bibtex_TitleField2515); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_51, 82);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_TitleField2529); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_52, 83);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_53, 83);
              	
            }
            // Bib.g:2232:2: ( (a2= QUOTED_34_34 ) | (a3= '{' (a4= TEXT ) a5= '}' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QUOTED_34_34) ) {
                alt19=1;
            }
            else if ( (LA19_0==16) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // Bib.g:2233:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2233:3: (a2= QUOTED_34_34 )
                    // Bib.g:2234:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_TitleField2552); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 84);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 84);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 84);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 84);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2273:6: (a3= '{' (a4= TEXT ) a5= '}' )
                    {
                    // Bib.g:2273:6: (a3= '{' (a4= TEXT ) a5= '}' )
                    // Bib.g:2274:4: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_TitleField2590); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_1_0_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_54, 85);
                      			
                    }
                    // Bib.g:2288:4: (a4= TEXT )
                    // Bib.g:2289:5: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_TitleField2616); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_55, 86);
                      			
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_TitleField2649); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createTitleField();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_8_0_0_3_0_1_0_0_0_2, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 87);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 87);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 87);
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 87);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 88);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 88);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 88);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 88);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 89);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 89);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 89);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 89);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_bibtex_TitleField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_TitleField"


    // $ANTLR start "parse_org_emftext_language_bibtex_BookTitleField"
    // Bib.g:2361:1: parse_org_emftext_language_bibtex_BookTitleField returns [org.emftext.language.bibtex.BookTitleField element = null] : a0= 'booktitle' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.BookTitleField parse_org_emftext_language_bibtex_BookTitleField() throws RecognitionException {
        org.emftext.language.bibtex.BookTitleField element =  null;
        int parse_org_emftext_language_bibtex_BookTitleField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Bib.g:2364:1: (a0= 'booktitle' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:2365:2: a0= 'booktitle' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_bibtex_BookTitleField2701); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_57, 90);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_BookTitleField2715); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_58, 91);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_59, 91);
              	
            }
            // Bib.g:2394:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==QUOTED_34_34) ) {
                alt20=1;
            }
            else if ( (LA20_0==16) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // Bib.g:2395:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2395:3: (a2= QUOTED_34_34 )
                    // Bib.g:2396:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_BookTitleField2738); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 92);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 92);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2433:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_BookTitleField2771); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_60, 93);
                      		
                    }
                    // Bib.g:2447:3: (a4= TEXT )
                    // Bib.g:2448:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BookTitleField2793); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_61, 94);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_BookTitleField2820); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createBookTitleField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_9_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 95);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 95);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 96);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 96);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_bibtex_BookTitleField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_BookTitleField"


    // $ANTLR start "parse_org_emftext_language_bibtex_SeriesField"
    // Bib.g:2507:1: parse_org_emftext_language_bibtex_SeriesField returns [org.emftext.language.bibtex.SeriesField element = null] : a0= 'series' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.SeriesField parse_org_emftext_language_bibtex_SeriesField() throws RecognitionException {
        org.emftext.language.bibtex.SeriesField element =  null;
        int parse_org_emftext_language_bibtex_SeriesField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Bib.g:2510:1: (a0= 'series' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:2511:2: a0= 'series' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_bibtex_SeriesField2859); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_63, 97);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_SeriesField2873); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_64, 98);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_65, 98);
              	
            }
            // Bib.g:2540:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==QUOTED_34_34) ) {
                alt21=1;
            }
            else if ( (LA21_0==16) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // Bib.g:2541:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2541:3: (a2= QUOTED_34_34 )
                    // Bib.g:2542:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_SeriesField2896); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 99);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 99);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2579:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_SeriesField2929); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_66, 100);
                      		
                    }
                    // Bib.g:2593:3: (a4= TEXT )
                    // Bib.g:2594:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_SeriesField2951); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_67, 101);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_SeriesField2978); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createSeriesField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_10_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 102);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 102);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 103);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 103);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_bibtex_SeriesField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_SeriesField"


    // $ANTLR start "parse_org_emftext_language_bibtex_AddressField"
    // Bib.g:2653:1: parse_org_emftext_language_bibtex_AddressField returns [org.emftext.language.bibtex.AddressField element = null] : a0= 'address' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.AddressField parse_org_emftext_language_bibtex_AddressField() throws RecognitionException {
        org.emftext.language.bibtex.AddressField element =  null;
        int parse_org_emftext_language_bibtex_AddressField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Bib.g:2656:1: (a0= 'address' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:2657:2: a0= 'address' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_bibtex_AddressField3017); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_69, 104);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_AddressField3031); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_70, 105);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_71, 105);
              	
            }
            // Bib.g:2686:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==QUOTED_34_34) ) {
                alt22=1;
            }
            else if ( (LA22_0==16) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // Bib.g:2687:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2687:3: (a2= QUOTED_34_34 )
                    // Bib.g:2688:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_AddressField3054); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 106);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 106);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2725:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_AddressField3087); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_72, 107);
                      		
                    }
                    // Bib.g:2739:3: (a4= TEXT )
                    // Bib.g:2740:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_AddressField3109); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_73, 108);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_AddressField3136); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAddressField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_11_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 109);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 109);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 110);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 110);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_bibtex_AddressField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_AddressField"


    // $ANTLR start "parse_org_emftext_language_bibtex_MonthField"
    // Bib.g:2799:1: parse_org_emftext_language_bibtex_MonthField returns [org.emftext.language.bibtex.MonthField element = null] : a0= 'month' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.MonthField parse_org_emftext_language_bibtex_MonthField() throws RecognitionException {
        org.emftext.language.bibtex.MonthField element =  null;
        int parse_org_emftext_language_bibtex_MonthField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Bib.g:2802:1: (a0= 'month' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:2803:2: a0= 'month' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_bibtex_MonthField3175); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_75, 111);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_MonthField3189); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_76, 112);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_77, 112);
              	
            }
            // Bib.g:2832:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==QUOTED_34_34) ) {
                alt23=1;
            }
            else if ( (LA23_0==16) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // Bib.g:2833:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2833:3: (a2= QUOTED_34_34 )
                    // Bib.g:2834:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_MonthField3212); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 113);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 113);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 113);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 113);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:2873:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_MonthField3245); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_78, 114);
                      		
                    }
                    // Bib.g:2887:3: (a4= TEXT )
                    // Bib.g:2888:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_MonthField3267); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_79, 115);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_MonthField3294); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createMonthField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_12_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 116);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 116);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 116);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 116);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 117);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 117);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 117);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 117);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_bibtex_MonthField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_MonthField"


    // $ANTLR start "parse_org_emftext_language_bibtex_OrganizationField"
    // Bib.g:2951:1: parse_org_emftext_language_bibtex_OrganizationField returns [org.emftext.language.bibtex.OrganizationField element = null] : a0= 'organization' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.OrganizationField parse_org_emftext_language_bibtex_OrganizationField() throws RecognitionException {
        org.emftext.language.bibtex.OrganizationField element =  null;
        int parse_org_emftext_language_bibtex_OrganizationField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Bib.g:2954:1: (a0= 'organization' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:2955:2: a0= 'organization' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_bibtex_OrganizationField3333); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_81, 118);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_OrganizationField3347); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_82, 119);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_83, 119);
              	
            }
            // Bib.g:2984:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==QUOTED_34_34) ) {
                alt24=1;
            }
            else if ( (LA24_0==16) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // Bib.g:2985:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:2985:3: (a2= QUOTED_34_34 )
                    // Bib.g:2986:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_OrganizationField3370); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 120);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 120);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3023:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_OrganizationField3403); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_84, 121);
                      		
                    }
                    // Bib.g:3037:3: (a4= TEXT )
                    // Bib.g:3038:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_OrganizationField3425); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_85, 122);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_OrganizationField3452); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createOrganizationField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_13_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 123);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 123);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 124);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 124);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_bibtex_OrganizationField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_OrganizationField"


    // $ANTLR start "parse_org_emftext_language_bibtex_PublisherField"
    // Bib.g:3097:1: parse_org_emftext_language_bibtex_PublisherField returns [org.emftext.language.bibtex.PublisherField element = null] : a0= 'publisher' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.PublisherField parse_org_emftext_language_bibtex_PublisherField() throws RecognitionException {
        org.emftext.language.bibtex.PublisherField element =  null;
        int parse_org_emftext_language_bibtex_PublisherField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // Bib.g:3100:1: (a0= 'publisher' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3101:2: a0= 'publisher' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_bibtex_PublisherField3491); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_87, 125);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_PublisherField3505); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_88, 126);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_89, 126);
              	
            }
            // Bib.g:3130:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==QUOTED_34_34) ) {
                alt25=1;
            }
            else if ( (LA25_0==16) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // Bib.g:3131:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3131:3: (a2= QUOTED_34_34 )
                    // Bib.g:3132:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_PublisherField3528); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 127);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 127);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3169:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_PublisherField3561); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_90, 128);
                      		
                    }
                    // Bib.g:3183:3: (a4= TEXT )
                    // Bib.g:3184:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_PublisherField3583); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_91, 129);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_PublisherField3610); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPublisherField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_14_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 130);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 130);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 131);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 131);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_bibtex_PublisherField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_PublisherField"


    // $ANTLR start "parse_org_emftext_language_bibtex_JournalField"
    // Bib.g:3243:1: parse_org_emftext_language_bibtex_JournalField returns [org.emftext.language.bibtex.JournalField element = null] : a0= 'journal' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.JournalField parse_org_emftext_language_bibtex_JournalField() throws RecognitionException {
        org.emftext.language.bibtex.JournalField element =  null;
        int parse_org_emftext_language_bibtex_JournalField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // Bib.g:3246:1: (a0= 'journal' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3247:2: a0= 'journal' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_bibtex_JournalField3649); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_93, 132);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_JournalField3663); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_94, 133);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_95, 133);
              	
            }
            // Bib.g:3276:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==QUOTED_34_34) ) {
                alt26=1;
            }
            else if ( (LA26_0==16) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // Bib.g:3277:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3277:3: (a2= QUOTED_34_34 )
                    // Bib.g:3278:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_JournalField3686); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 134);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 134);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3315:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_JournalField3719); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_96, 135);
                      		
                    }
                    // Bib.g:3329:3: (a4= TEXT )
                    // Bib.g:3330:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_JournalField3741); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_97, 136);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_JournalField3768); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createJournalField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_15_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 137);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 137);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 138);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 138);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_bibtex_JournalField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_JournalField"


    // $ANTLR start "parse_org_emftext_language_bibtex_NoteField"
    // Bib.g:3389:1: parse_org_emftext_language_bibtex_NoteField returns [org.emftext.language.bibtex.NoteField element = null] : a0= 'note' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.NoteField parse_org_emftext_language_bibtex_NoteField() throws RecognitionException {
        org.emftext.language.bibtex.NoteField element =  null;
        int parse_org_emftext_language_bibtex_NoteField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // Bib.g:3392:1: (a0= 'note' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3393:2: a0= 'note' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_bibtex_NoteField3807); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_99, 139);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_NoteField3821); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_100, 140);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_101, 140);
              	
            }
            // Bib.g:3422:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==QUOTED_34_34) ) {
                alt27=1;
            }
            else if ( (LA27_0==16) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // Bib.g:3423:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3423:3: (a2= QUOTED_34_34 )
                    // Bib.g:3424:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_NoteField3844); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 141);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 141);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 141);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 141);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3463:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_NoteField3877); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_102, 142);
                      		
                    }
                    // Bib.g:3477:3: (a4= TEXT )
                    // Bib.g:3478:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_NoteField3899); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_103, 143);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_NoteField3926); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNoteField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_16_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 144);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 144);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 144);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 144);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 145);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 145);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 145);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 145);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_bibtex_NoteField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_NoteField"


    // $ANTLR start "parse_org_emftext_language_bibtex_EidField"
    // Bib.g:3541:1: parse_org_emftext_language_bibtex_EidField returns [org.emftext.language.bibtex.EidField element = null] : a0= 'eid' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.EidField parse_org_emftext_language_bibtex_EidField() throws RecognitionException {
        org.emftext.language.bibtex.EidField element =  null;
        int parse_org_emftext_language_bibtex_EidField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // Bib.g:3544:1: (a0= 'eid' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3545:2: a0= 'eid' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_bibtex_EidField3965); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_105, 146);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_EidField3979); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_106, 147);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_107, 147);
              	
            }
            // Bib.g:3574:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==QUOTED_34_34) ) {
                alt28=1;
            }
            else if ( (LA28_0==16) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // Bib.g:3575:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3575:3: (a2= QUOTED_34_34 )
                    // Bib.g:3576:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_EidField4002); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 148);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 148);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3613:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_EidField4035); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_108, 149);
                      		
                    }
                    // Bib.g:3627:3: (a4= TEXT )
                    // Bib.g:3628:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_EidField4057); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_109, 150);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_EidField4084); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createEidField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_17_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 151);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 151);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 152);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 152);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_bibtex_EidField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_EidField"


    // $ANTLR start "parse_org_emftext_language_bibtex_AbstractField"
    // Bib.g:3687:1: parse_org_emftext_language_bibtex_AbstractField returns [org.emftext.language.bibtex.AbstractField element = null] : a0= 'abstract' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.AbstractField parse_org_emftext_language_bibtex_AbstractField() throws RecognitionException {
        org.emftext.language.bibtex.AbstractField element =  null;
        int parse_org_emftext_language_bibtex_AbstractField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // Bib.g:3690:1: (a0= 'abstract' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3691:2: a0= 'abstract' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_language_bibtex_AbstractField4123); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_111, 153);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_AbstractField4137); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_112, 154);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_113, 154);
              	
            }
            // Bib.g:3720:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==QUOTED_34_34) ) {
                alt29=1;
            }
            else if ( (LA29_0==16) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // Bib.g:3721:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3721:3: (a2= QUOTED_34_34 )
                    // Bib.g:3722:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_AbstractField4160); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 155);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 155);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 155);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 155);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3761:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_AbstractField4193); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_114, 156);
                      		
                    }
                    // Bib.g:3775:3: (a4= TEXT )
                    // Bib.g:3776:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_AbstractField4215); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_115, 157);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_AbstractField4242); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createAbstractField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_18_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 158);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 158);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 158);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 158);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 159);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 159);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 159);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 159);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_bibtex_AbstractField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_AbstractField"


    // $ANTLR start "parse_org_emftext_language_bibtex_ReviewField"
    // Bib.g:3839:1: parse_org_emftext_language_bibtex_ReviewField returns [org.emftext.language.bibtex.ReviewField element = null] : a0= 'review' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.ReviewField parse_org_emftext_language_bibtex_ReviewField() throws RecognitionException {
        org.emftext.language.bibtex.ReviewField element =  null;
        int parse_org_emftext_language_bibtex_ReviewField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // Bib.g:3842:1: (a0= 'review' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3843:2: a0= 'review' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_language_bibtex_ReviewField4281); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_117, 160);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_ReviewField4295); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_118, 161);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_119, 161);
              	
            }
            // Bib.g:3872:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==QUOTED_34_34) ) {
                alt30=1;
            }
            else if ( (LA30_0==16) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // Bib.g:3873:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:3873:3: (a2= QUOTED_34_34 )
                    // Bib.g:3874:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_ReviewField4318); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 162);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 162);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 162);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 162);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:3913:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_ReviewField4351); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_120, 163);
                      		
                    }
                    // Bib.g:3927:3: (a4= TEXT )
                    // Bib.g:3928:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_ReviewField4373); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_121, 164);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_ReviewField4400); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createReviewField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_19_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 165);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 165);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 165);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 165);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 166);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 166);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 166);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 166);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_language_bibtex_ReviewField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_ReviewField"


    // $ANTLR start "parse_org_emftext_language_bibtex_UrlField"
    // Bib.g:3991:1: parse_org_emftext_language_bibtex_UrlField returns [org.emftext.language.bibtex.UrlField element = null] : a0= 'url' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) ;
    public final org.emftext.language.bibtex.UrlField parse_org_emftext_language_bibtex_UrlField() throws RecognitionException {
        org.emftext.language.bibtex.UrlField element =  null;
        int parse_org_emftext_language_bibtex_UrlField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // Bib.g:3994:1: (a0= 'url' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' ) )
            // Bib.g:3995:2: a0= 'url' a1= '=' ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_language_bibtex_UrlField4439); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_123, 167);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_UrlField4453); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_124, 168);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_125, 168);
              	
            }
            // Bib.g:4024:2: ( (a2= QUOTED_34_34 ) | a3= '{' (a4= TEXT ) a5= '}' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==QUOTED_34_34) ) {
                alt31=1;
            }
            else if ( (LA31_0==16) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // Bib.g:4025:3: (a2= QUOTED_34_34 )
                    {
                    // Bib.g:4025:3: (a2= QUOTED_34_34 )
                    // Bib.g:4026:4: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_UrlField4476); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 169);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 169);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 169);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 169);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:4065:6: a3= '{' (a4= TEXT ) a5= '}'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_UrlField4509); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_126, 170);
                      		
                    }
                    // Bib.g:4079:3: (a4= TEXT )
                    // Bib.g:4080:4: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_UrlField4531); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_127, 171);
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_UrlField4558); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createUrlField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_20_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 172);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 172);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 172);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 172);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 173);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 173);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 173);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 173);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_language_bibtex_UrlField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_UrlField"


    // $ANTLR start "parse_org_emftext_language_bibtex_YearField"
    // Bib.g:4143:1: parse_org_emftext_language_bibtex_YearField returns [org.emftext.language.bibtex.YearField element = null] : a0= 'year' a1= '=' (a2= '{' (a3= YEAR ) a4= '}' | a5= '\\\"' (a6= YEAR ) a7= '\\\"' ) ;
    public final org.emftext.language.bibtex.YearField parse_org_emftext_language_bibtex_YearField() throws RecognitionException {
        org.emftext.language.bibtex.YearField element =  null;
        int parse_org_emftext_language_bibtex_YearField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // Bib.g:4146:1: (a0= 'year' a1= '=' (a2= '{' (a3= YEAR ) a4= '}' | a5= '\\\"' (a6= YEAR ) a7= '\\\"' ) )
            // Bib.g:4147:2: a0= 'year' a1= '=' (a2= '{' (a3= YEAR ) a4= '}' | a5= '\\\"' (a6= YEAR ) a7= '\\\"' )
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_language_bibtex_YearField4597); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_129, 174);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_YearField4611); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_130, 175);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_131, 175);
              	
            }
            // Bib.g:4176:2: (a2= '{' (a3= YEAR ) a4= '}' | a5= '\\\"' (a6= YEAR ) a7= '\\\"' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            else if ( (LA32_0==14) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // Bib.g:4177:3: a2= '{' (a3= YEAR ) a4= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_YearField4629); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_132, 176);
                      		
                    }
                    // Bib.g:4191:3: (a3= YEAR )
                    // Bib.g:4192:4: a3= YEAR
                    {
                    a3=(Token)match(input,YEAR,FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField4651); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_133, 177);
                      		
                    }
                    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_YearField4678); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_0_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 178);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 178);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 178);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 178);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:4245:6: a5= '\\\"' (a6= YEAR ) a7= '\\\"'
                    {
                    a5=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField4701); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_134, 179);
                      		
                    }
                    // Bib.g:4259:3: (a6= YEAR )
                    // Bib.g:4260:4: a6= YEAR
                    {
                    a6=(Token)match(input,YEAR,FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField4723); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_135, 180);
                      		
                    }
                    a7=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField4750); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createYearField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_21_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 181);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 181);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 181);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 181);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 182);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 182);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 182);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 182);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_language_bibtex_YearField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_YearField"


    // $ANTLR start "parse_org_emftext_language_bibtex_VolumeField"
    // Bib.g:4323:1: parse_org_emftext_language_bibtex_VolumeField returns [org.emftext.language.bibtex.VolumeField element = null] : a0= 'volume' a1= '=' (a2= '\\\"' ( (a3= INTEGER ) ) a4= '\\\"' | a5= '{' ( (a6= INTEGER ) ) a7= '}' ) ;
    public final org.emftext.language.bibtex.VolumeField parse_org_emftext_language_bibtex_VolumeField() throws RecognitionException {
        org.emftext.language.bibtex.VolumeField element =  null;
        int parse_org_emftext_language_bibtex_VolumeField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // Bib.g:4326:1: (a0= 'volume' a1= '=' (a2= '\\\"' ( (a3= INTEGER ) ) a4= '\\\"' | a5= '{' ( (a6= INTEGER ) ) a7= '}' ) )
            // Bib.g:4327:2: a0= 'volume' a1= '=' (a2= '\\\"' ( (a3= INTEGER ) ) a4= '\\\"' | a5= '{' ( (a6= INTEGER ) ) a7= '}' )
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_language_bibtex_VolumeField4789); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_137, 183);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_VolumeField4803); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_138, 184);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_139, 184);
              	
            }
            // Bib.g:4356:2: (a2= '\\\"' ( (a3= INTEGER ) ) a4= '\\\"' | a5= '{' ( (a6= INTEGER ) ) a7= '}' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==14) ) {
                alt33=1;
            }
            else if ( (LA33_0==16) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // Bib.g:4357:3: a2= '\\\"' ( (a3= INTEGER ) ) a4= '\\\"'
                    {
                    a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_VolumeField4821); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_140, 185);
                      		
                    }
                    // Bib.g:4371:3: ( (a3= INTEGER ) )
                    // Bib.g:4372:4: (a3= INTEGER )
                    {
                    // Bib.g:4372:4: (a3= INTEGER )
                    // Bib.g:4373:5: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField4849); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_141, 186);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_141, 187);
                      		
                    }
                    a4=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_VolumeField4892); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_0_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 188);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 188);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 188);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 188);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:4432:6: a5= '{' ( (a6= INTEGER ) ) a7= '}'
                    {
                    a5=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_VolumeField4915); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_142, 189);
                      		
                    }
                    // Bib.g:4446:3: ( (a6= INTEGER ) )
                    // Bib.g:4447:4: (a6= INTEGER )
                    {
                    // Bib.g:4447:4: (a6= INTEGER )
                    // Bib.g:4448:5: a6= INTEGER
                    {
                    a6=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField4943); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_143, 190);
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_143, 191);
                      		
                    }
                    a7=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_VolumeField4986); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createVolumeField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_22_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 192);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 192);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 192);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 192);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 193);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 193);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 193);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 193);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_language_bibtex_VolumeField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_VolumeField"


    // $ANTLR start "parse_org_emftext_language_bibtex_PartField"
    // Bib.g:4517:1: parse_org_emftext_language_bibtex_PartField returns [org.emftext.language.bibtex.PartField element = null] : a0= 'part' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' ) ;
    public final org.emftext.language.bibtex.PartField parse_org_emftext_language_bibtex_PartField() throws RecognitionException {
        org.emftext.language.bibtex.PartField element =  null;
        int parse_org_emftext_language_bibtex_PartField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // Bib.g:4520:1: (a0= 'part' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' ) )
            // Bib.g:4521:2: a0= 'part' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' )
            {
            a0=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_bibtex_PartField5025); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_145, 194);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_PartField5039); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_146, 195);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_147, 195);
              	
            }
            // Bib.g:4550:2: (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            else if ( (LA34_0==14) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // Bib.g:4551:3: a2= '{' (a3= INTEGER ) a4= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_PartField5057); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_148, 196);
                      		
                    }
                    // Bib.g:4565:3: (a3= INTEGER )
                    // Bib.g:4566:4: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_PartField5079); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_149, 197);
                      		
                    }
                    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_PartField5106); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_0_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 198);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 198);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:4617:6: a5= '\\\"' (a6= INTEGER ) a7= '\\\"'
                    {
                    a5=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_PartField5129); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_150, 199);
                      		
                    }
                    // Bib.g:4631:3: (a6= INTEGER )
                    // Bib.g:4632:4: a6= INTEGER
                    {
                    a6=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_PartField5151); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_151, 200);
                      		
                    }
                    a7=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_PartField5178); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPartField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_23_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 201);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 201);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 202);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 202);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_language_bibtex_PartField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_PartField"


    // $ANTLR start "parse_org_emftext_language_bibtex_NumberField"
    // Bib.g:4691:1: parse_org_emftext_language_bibtex_NumberField returns [org.emftext.language.bibtex.NumberField element = null] : a0= 'number' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' ) ;
    public final org.emftext.language.bibtex.NumberField parse_org_emftext_language_bibtex_NumberField() throws RecognitionException {
        org.emftext.language.bibtex.NumberField element =  null;
        int parse_org_emftext_language_bibtex_NumberField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // Bib.g:4694:1: (a0= 'number' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' ) )
            // Bib.g:4695:2: a0= 'number' a1= '=' (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_language_bibtex_NumberField5217); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_153, 203);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_NumberField5231); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_154, 204);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_155, 204);
              	
            }
            // Bib.g:4724:2: (a2= '{' (a3= INTEGER ) a4= '}' | a5= '\\\"' (a6= INTEGER ) a7= '\\\"' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            else if ( (LA35_0==14) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // Bib.g:4725:3: a2= '{' (a3= INTEGER ) a4= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_NumberField5249); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_156, 205);
                      		
                    }
                    // Bib.g:4739:3: (a3= INTEGER )
                    // Bib.g:4740:4: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_NumberField5271); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_157, 206);
                      		
                    }
                    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_NumberField5298); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_0_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 207);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 207);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 207);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 207);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:4793:6: a5= '\\\"' (a6= INTEGER ) a7= '\\\"'
                    {
                    a5=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_NumberField5321); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_158, 208);
                      		
                    }
                    // Bib.g:4807:3: (a6= INTEGER )
                    // Bib.g:4808:4: a6= INTEGER
                    {
                    a6=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_NumberField5343); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_159, 209);
                      		
                    }
                    a7=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_NumberField5370); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createNumberField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_24_0_0_3_0_1_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 210);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 210);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 210);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 210);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 211);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 211);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 211);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 211);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_language_bibtex_NumberField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_NumberField"


    // $ANTLR start "parse_org_emftext_language_bibtex_PageField"
    // Bib.g:4871:1: parse_org_emftext_language_bibtex_PageField returns [org.emftext.language.bibtex.PageField element = null] : a0= 'pages' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )? a7= '}' | a8= '\\\"' (a9_0= parse_org_emftext_language_bibtex_Page ) ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )? a13= '\\\"' ) ;
    public final org.emftext.language.bibtex.PageField parse_org_emftext_language_bibtex_PageField() throws RecognitionException {
        org.emftext.language.bibtex.PageField element =  null;
        int parse_org_emftext_language_bibtex_PageField_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        Token a10=null;
        Token a11=null;
        Token a13=null;
        org.emftext.language.bibtex.Page a3_0 = null;

        org.emftext.language.bibtex.Page a6_0 = null;

        org.emftext.language.bibtex.Page a9_0 = null;

        org.emftext.language.bibtex.Page a12_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // Bib.g:4874:1: (a0= 'pages' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )? a7= '}' | a8= '\\\"' (a9_0= parse_org_emftext_language_bibtex_Page ) ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )? a13= '\\\"' ) )
            // Bib.g:4875:2: a0= 'pages' a1= '=' (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )? a7= '}' | a8= '\\\"' (a9_0= parse_org_emftext_language_bibtex_Page ) ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )? a13= '\\\"' )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_language_bibtex_PageField5409); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_161, 212);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_bibtex_PageField5423); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_162, 213);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_163, 213);
              	
            }
            // Bib.g:4904:2: (a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )? a7= '}' | a8= '\\\"' (a9_0= parse_org_emftext_language_bibtex_Page ) ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )? a13= '\\\"' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            else if ( (LA40_0==14) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // Bib.g:4905:3: a2= '{' (a3_0= parse_org_emftext_language_bibtex_Page ) ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )? a7= '}'
                    {
                    a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_PageField5441); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 214, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
                      		
                    }
                    // Bib.g:4919:3: (a3_0= parse_org_emftext_language_bibtex_Page )
                    // Bib.g:4920:4: a3_0= parse_org_emftext_language_bibtex_Page
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5463);
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
                      					retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_1, a3_0, true);
                      					copyLocalizationInfos(a3_0, element);
                      				}
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_165, 215);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_166, 215);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 215);
                      		
                    }
                    // Bib.g:4947:3: ( ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=39 && LA37_0<=40)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // Bib.g:4948:4: ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) )
                            {
                            // Bib.g:4948:4: ( (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page ) )
                            // Bib.g:4949:5: (a4= '--' | a5= '-' ) (a6_0= parse_org_emftext_language_bibtex_Page )
                            {
                            // Bib.g:4949:5: (a4= '--' | a5= '-' )
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==39) ) {
                                alt36=1;
                            }
                            else if ( (LA36_0==40) ) {
                                alt36=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 36, 0, input);

                                throw nvae;
                            }
                            switch (alt36) {
                                case 1 :
                                    // Bib.g:4950:6: a4= '--'
                                    {
                                    a4=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_language_bibtex_PageField5504); if (state.failed) return element;
                                    if ( state.backtracking==0 ) {

                                      						if (element == null) {
                                      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                                      							incompleteObjects.push(element);
                                      						}
                                      						collectHiddenTokens(element);
                                      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_2_0_0_0_0_0_0, null, true);
                                      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						// expected elements (follow set)
                                      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 216, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // Bib.g:4965:12: a5= '-'
                                    {
                                    a5=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_bibtex_PageField5542); if (state.failed) return element;
                                    if ( state.backtracking==0 ) {

                                      						if (element == null) {
                                      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                                      							incompleteObjects.push(element);
                                      						}
                                      						collectHiddenTokens(element);
                                      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_2_0_0_0_0_1_0, null, true);
                                      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						// expected elements (follow set)
                                      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 217, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                                      					
                                    }

                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 218, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                              				
                            }
                            // Bib.g:4985:5: (a6_0= parse_org_emftext_language_bibtex_Page )
                            // Bib.g:4986:6: a6_0= parse_org_emftext_language_bibtex_Page
                            {
                            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5591);
                            a6_0=parse_org_emftext_language_bibtex_Page();

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

                            }

                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 219);
                              				
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 220);
                      		
                    }
                    a7=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_PageField5642); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_0_3, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 221);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 221);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 221);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 221);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:5036:6: a8= '\\\"' (a9_0= parse_org_emftext_language_bibtex_Page ) ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )? a13= '\\\"'
                    {
                    a8=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_PageField5665); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 222, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_4);
                      		
                    }
                    // Bib.g:5050:3: (a9_0= parse_org_emftext_language_bibtex_Page )
                    // Bib.g:5051:4: a9_0= parse_org_emftext_language_bibtex_Page
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5687);
                    a9_0=parse_org_emftext_language_bibtex_Page();

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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_168, 223);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_169, 223);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 223);
                      		
                    }
                    // Bib.g:5078:3: ( ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=39 && LA39_0<=40)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // Bib.g:5079:4: ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) )
                            {
                            // Bib.g:5079:4: ( (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page ) )
                            // Bib.g:5080:5: (a10= '--' | a11= '-' ) (a12_0= parse_org_emftext_language_bibtex_Page )
                            {
                            // Bib.g:5080:5: (a10= '--' | a11= '-' )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==39) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==40) ) {
                                alt38=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // Bib.g:5081:6: a10= '--'
                                    {
                                    a10=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_language_bibtex_PageField5728); if (state.failed) return element;
                                    if ( state.backtracking==0 ) {

                                      						if (element == null) {
                                      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                                      							incompleteObjects.push(element);
                                      						}
                                      						collectHiddenTokens(element);
                                      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_2_0_0_0_0_0_0, null, true);
                                      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a10, element);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						// expected elements (follow set)
                                      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 224, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // Bib.g:5096:12: a11= '-'
                                    {
                                    a11=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_bibtex_PageField5766); if (state.failed) return element;
                                    if ( state.backtracking==0 ) {

                                      						if (element == null) {
                                      							element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                                      							incompleteObjects.push(element);
                                      						}
                                      						collectHiddenTokens(element);
                                      						retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_2_0_0_0_0_1_0, null, true);
                                      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						// expected elements (follow set)
                                      						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 225, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                                      					
                                    }

                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_164, 226, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_5);
                              				
                            }
                            // Bib.g:5116:5: (a12_0= parse_org_emftext_language_bibtex_Page )
                            // Bib.g:5117:6: a12_0= parse_org_emftext_language_bibtex_Page
                            {
                            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5815);
                            a12_0=parse_org_emftext_language_bibtex_Page();

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

                            }

                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 227);
                              				
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_170, 228);
                      		
                    }
                    a13=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_bibtex_PageField5866); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createPageField();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_25_0_0_3_0_1_3, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a13, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 229);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 229);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 229);
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 229);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 230);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 230);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 230);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 230);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_language_bibtex_PageField_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_PageField"


    // $ANTLR start "parse_org_emftext_language_bibtex_Page"
    // Bib.g:5177:1: parse_org_emftext_language_bibtex_Page returns [org.emftext.language.bibtex.Page element = null] : (a0= INTEGER ) ;
    public final org.emftext.language.bibtex.Page parse_org_emftext_language_bibtex_Page() throws RecognitionException {
        org.emftext.language.bibtex.Page element =  null;
        int parse_org_emftext_language_bibtex_Page_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // Bib.g:5180:1: ( (a0= INTEGER ) )
            // Bib.g:5181:2: (a0= INTEGER )
            {
            // Bib.g:5181:2: (a0= INTEGER )
            // Bib.g:5182:3: a0= INTEGER
            {
            a0=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_Page5909); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_165, 231);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_166, 231);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_167, 231);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_language_bibtex_Page_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Page"


    // $ANTLR start "parse_org_emftext_language_bibtex_InProceedingsEntry"
    // Bib.g:5221:1: parse_org_emftext_language_bibtex_InProceedingsEntry returns [org.emftext.language.bibtex.InProceedingsEntry element = null] : (a0= '@INPROCEEDINGS' | a1= '@inproceedings' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a23= '}' ;
    public final org.emftext.language.bibtex.InProceedingsEntry parse_org_emftext_language_bibtex_InProceedingsEntry() throws RecognitionException {
        org.emftext.language.bibtex.InProceedingsEntry element =  null;
        int parse_org_emftext_language_bibtex_InProceedingsEntry_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a23=null;
        org.emftext.language.bibtex.BibtexKeyField a3_0 = null;

        org.emftext.language.bibtex.UrlField a5_0 = null;

        org.emftext.language.bibtex.AbstractField a6_0 = null;

        org.emftext.language.bibtex.KeywordField a7_0 = null;

        org.emftext.language.bibtex.ReviewField a8_0 = null;

        org.emftext.language.bibtex.TitleField a9_0 = null;

        org.emftext.language.bibtex.BookTitleField a10_0 = null;

        org.emftext.language.bibtex.YearField a11_0 = null;

        org.emftext.language.bibtex.AuthorField a12_0 = null;

        org.emftext.language.bibtex.EditorField a13_0 = null;

        org.emftext.language.bibtex.VolumeField a14_0 = null;

        org.emftext.language.bibtex.NumberField a15_0 = null;

        org.emftext.language.bibtex.SeriesField a16_0 = null;

        org.emftext.language.bibtex.PageField a17_0 = null;

        org.emftext.language.bibtex.AddressField a18_0 = null;

        org.emftext.language.bibtex.MonthField a19_0 = null;

        org.emftext.language.bibtex.OrganizationField a20_0 = null;

        org.emftext.language.bibtex.PublisherField a21_0 = null;

        org.emftext.language.bibtex.NoteField a22_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }
            // Bib.g:5224:1: ( (a0= '@INPROCEEDINGS' | a1= '@inproceedings' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a23= '}' )
            // Bib.g:5225:2: (a0= '@INPROCEEDINGS' | a1= '@inproceedings' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a23= '}'
            {
            // Bib.g:5225:2: (a0= '@INPROCEEDINGS' | a1= '@inproceedings' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41) ) {
                alt41=1;
            }
            else if ( (LA41_0==42) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // Bib.g:5226:3: a0= '@INPROCEEDINGS'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_bibtex_InProceedingsEntry5949); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_0_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 232);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:5241:6: a1= '@inproceedings'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_language_bibtex_InProceedingsEntry5972); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_0_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 233);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_171, 234);
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_InProceedingsEntry5996); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 235, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 235, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
              	
            }
            // Bib.g:5276:2: (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField )
            // Bib.g:5277:3: a3_0= parse_org_emftext_language_bibtex_BibtexKeyField
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6014);
            a3_0=parse_org_emftext_language_bibtex_BibtexKeyField();

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 236);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 236);
              	
            }
            // Bib.g:5303:2: ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==18) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // Bib.g:5304:3: (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) )
            	    {
            	    // Bib.g:5304:3: (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) )
            	    // Bib.g:5305:4: a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )
            	    {
            	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_InProceedingsEntry6041); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

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
            	    // Bib.g:5338:4: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )
            	    int alt56=18;
            	    alt56 = dfa56.predict(input);
            	    switch (alt56) {
            	        case 1 :
            	            // Bib.g:5339:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
            	            {
            	            // Bib.g:5339:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
            	            int alt42=2;
            	            int LA42_0 = input.LA(1);

            	            if ( (LA42_0==33) ) {
            	                alt42=1;
            	            }
            	            switch (alt42) {
            	                case 1 :
            	                    // Bib.g:5340:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
            	                    {
            	                    // Bib.g:5340:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
            	                    // Bib.g:5341:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
            	                    {
            	                    // Bib.g:5341:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
            	                    // Bib.g:5342:8: a5_0= parse_org_emftext_language_bibtex_UrlField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6091);
            	                    a5_0=parse_org_emftext_language_bibtex_UrlField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__URL), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_0_0_0_0_0, a5_0, true);
            	                      									copyLocalizationInfos(a5_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 238);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 238);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 239);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 239);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Bib.g:5377:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
            	            {
            	            // Bib.g:5377:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
            	            int alt43=2;
            	            int LA43_0 = input.LA(1);

            	            if ( (LA43_0==31) ) {
            	                alt43=1;
            	            }
            	            switch (alt43) {
            	                case 1 :
            	                    // Bib.g:5378:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
            	                    {
            	                    // Bib.g:5378:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
            	                    // Bib.g:5379:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
            	                    {
            	                    // Bib.g:5379:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
            	                    // Bib.g:5380:8: a6_0= parse_org_emftext_language_bibtex_AbstractField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6196);
            	                    a6_0=parse_org_emftext_language_bibtex_AbstractField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ABSTRACT), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_1_0_0_0_0, a6_0, true);
            	                      									copyLocalizationInfos(a6_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 240);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 240);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 241);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 241);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Bib.g:5415:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
            	            {
            	            // Bib.g:5415:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
            	            int alt44=2;
            	            int LA44_0 = input.LA(1);

            	            if ( (LA44_0==20) ) {
            	                alt44=1;
            	            }
            	            switch (alt44) {
            	                case 1 :
            	                    // Bib.g:5416:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
            	                    {
            	                    // Bib.g:5416:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
            	                    // Bib.g:5417:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
            	                    {
            	                    // Bib.g:5417:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
            	                    // Bib.g:5418:8: a7_0= parse_org_emftext_language_bibtex_KeywordField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6301);
            	                    a7_0=parse_org_emftext_language_bibtex_KeywordField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__KEYWORD), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_5_0_0_1_0_2_0_0_0_0, a7_0, true);
            	                      									copyLocalizationInfos(a7_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 242);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 242);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 243);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 243);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Bib.g:5453:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
            	            {
            	            // Bib.g:5453:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
            	            int alt45=2;
            	            int LA45_0 = input.LA(1);

            	            if ( (LA45_0==32) ) {
            	                alt45=1;
            	            }
            	            switch (alt45) {
            	                case 1 :
            	                    // Bib.g:5454:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
            	                    {
            	                    // Bib.g:5454:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
            	                    // Bib.g:5455:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
            	                    {
            	                    // Bib.g:5455:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
            	                    // Bib.g:5456:8: a8_0= parse_org_emftext_language_bibtex_ReviewField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6406);
            	                    a8_0=parse_org_emftext_language_bibtex_ReviewField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 244);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 244);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 245);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 245);
            	              				
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // Bib.g:5491:10: ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            {
            	            // Bib.g:5491:10: ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            // Bib.g:5492:6: (a9_0= parse_org_emftext_language_bibtex_TitleField )
            	            {
            	            // Bib.g:5492:6: (a9_0= parse_org_emftext_language_bibtex_TitleField )
            	            // Bib.g:5493:7: a9_0= parse_org_emftext_language_bibtex_TitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6502);
            	            a9_0=parse_org_emftext_language_bibtex_TitleField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 246);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 246);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 247);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 247);
            	              				
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // Bib.g:5527:10: ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) )
            	            {
            	            // Bib.g:5527:10: ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) )
            	            // Bib.g:5528:6: (a10_0= parse_org_emftext_language_bibtex_BookTitleField )
            	            {
            	            // Bib.g:5528:6: (a10_0= parse_org_emftext_language_bibtex_BookTitleField )
            	            // Bib.g:5529:7: a10_0= parse_org_emftext_language_bibtex_BookTitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BookTitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6581);
            	            a10_0=parse_org_emftext_language_bibtex_BookTitleField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 248);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 248);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 249);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 249);
            	              				
            	            }

            	            }
            	            break;
            	        case 7 :
            	            // Bib.g:5563:10: ( (a11_0= parse_org_emftext_language_bibtex_YearField ) )
            	            {
            	            // Bib.g:5563:10: ( (a11_0= parse_org_emftext_language_bibtex_YearField ) )
            	            // Bib.g:5564:6: (a11_0= parse_org_emftext_language_bibtex_YearField )
            	            {
            	            // Bib.g:5564:6: (a11_0= parse_org_emftext_language_bibtex_YearField )
            	            // Bib.g:5565:7: a11_0= parse_org_emftext_language_bibtex_YearField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6660);
            	            a11_0=parse_org_emftext_language_bibtex_YearField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 250);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 250);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 251);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 251);
            	              				
            	            }

            	            }
            	            break;
            	        case 8 :
            	            // Bib.g:5599:10: ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            {
            	            // Bib.g:5599:10: ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            // Bib.g:5600:6: (a12_0= parse_org_emftext_language_bibtex_AuthorField )
            	            {
            	            // Bib.g:5600:6: (a12_0= parse_org_emftext_language_bibtex_AuthorField )
            	            // Bib.g:5601:7: a12_0= parse_org_emftext_language_bibtex_AuthorField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6739);
            	            a12_0=parse_org_emftext_language_bibtex_AuthorField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 252);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 252);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 253);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 253);
            	              				
            	            }

            	            }
            	            break;
            	        case 9 :
            	            // Bib.g:5635:10: ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )?
            	            {
            	            // Bib.g:5635:10: ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )?
            	            int alt46=2;
            	            int LA46_0 = input.LA(1);

            	            if ( (LA46_0==19) ) {
            	                alt46=1;
            	            }
            	            switch (alt46) {
            	                case 1 :
            	                    // Bib.g:5636:6: ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) )
            	                    {
            	                    // Bib.g:5636:6: ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) )
            	                    // Bib.g:5637:7: (a13_0= parse_org_emftext_language_bibtex_EditorField )
            	                    {
            	                    // Bib.g:5637:7: (a13_0= parse_org_emftext_language_bibtex_EditorField )
            	                    // Bib.g:5638:8: a13_0= parse_org_emftext_language_bibtex_EditorField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_EditorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6827);
            	                    a13_0=parse_org_emftext_language_bibtex_EditorField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 254);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 254);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 255);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 255);
            	              				
            	            }

            	            }
            	            break;
            	        case 10 :
            	            // Bib.g:5673:10: ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )?
            	            {
            	            // Bib.g:5673:10: ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )?
            	            int alt47=2;
            	            int LA47_0 = input.LA(1);

            	            if ( (LA47_0==35) ) {
            	                alt47=1;
            	            }
            	            switch (alt47) {
            	                case 1 :
            	                    // Bib.g:5674:6: ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	                    {
            	                    // Bib.g:5674:6: ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	                    // Bib.g:5675:7: (a14_0= parse_org_emftext_language_bibtex_VolumeField )
            	                    {
            	                    // Bib.g:5675:7: (a14_0= parse_org_emftext_language_bibtex_VolumeField )
            	                    // Bib.g:5676:8: a14_0= parse_org_emftext_language_bibtex_VolumeField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6932);
            	                    a14_0=parse_org_emftext_language_bibtex_VolumeField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 256);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 256);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 257);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 257);
            	              				
            	            }

            	            }
            	            break;
            	        case 11 :
            	            // Bib.g:5711:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
            	            {
            	            // Bib.g:5711:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
            	            int alt48=2;
            	            int LA48_0 = input.LA(1);

            	            if ( (LA48_0==37) ) {
            	                alt48=1;
            	            }
            	            switch (alt48) {
            	                case 1 :
            	                    // Bib.g:5712:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
            	                    {
            	                    // Bib.g:5712:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
            	                    // Bib.g:5713:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
            	                    {
            	                    // Bib.g:5713:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
            	                    // Bib.g:5714:8: a15_0= parse_org_emftext_language_bibtex_NumberField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7037);
            	                    a15_0=parse_org_emftext_language_bibtex_NumberField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 258);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 258);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 259);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 259);
            	              				
            	            }

            	            }
            	            break;
            	        case 12 :
            	            // Bib.g:5749:10: ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )?
            	            {
            	            // Bib.g:5749:10: ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )?
            	            int alt49=2;
            	            int LA49_0 = input.LA(1);

            	            if ( (LA49_0==23) ) {
            	                alt49=1;
            	            }
            	            switch (alt49) {
            	                case 1 :
            	                    // Bib.g:5750:6: ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) )
            	                    {
            	                    // Bib.g:5750:6: ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) )
            	                    // Bib.g:5751:7: (a16_0= parse_org_emftext_language_bibtex_SeriesField )
            	                    {
            	                    // Bib.g:5751:7: (a16_0= parse_org_emftext_language_bibtex_SeriesField )
            	                    // Bib.g:5752:8: a16_0= parse_org_emftext_language_bibtex_SeriesField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_SeriesField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7142);
            	                    a16_0=parse_org_emftext_language_bibtex_SeriesField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 260);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 260);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 261);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 261);
            	              				
            	            }

            	            }
            	            break;
            	        case 13 :
            	            // Bib.g:5787:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )?
            	            {
            	            // Bib.g:5787:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )?
            	            int alt50=2;
            	            int LA50_0 = input.LA(1);

            	            if ( (LA50_0==38) ) {
            	                alt50=1;
            	            }
            	            switch (alt50) {
            	                case 1 :
            	                    // Bib.g:5788:6: ( (a17_0= parse_org_emftext_language_bibtex_PageField ) )
            	                    {
            	                    // Bib.g:5788:6: ( (a17_0= parse_org_emftext_language_bibtex_PageField ) )
            	                    // Bib.g:5789:7: (a17_0= parse_org_emftext_language_bibtex_PageField )
            	                    {
            	                    // Bib.g:5789:7: (a17_0= parse_org_emftext_language_bibtex_PageField )
            	                    // Bib.g:5790:8: a17_0= parse_org_emftext_language_bibtex_PageField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7247);
            	                    a17_0=parse_org_emftext_language_bibtex_PageField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 262);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 262);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 263);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 263);
            	              				
            	            }

            	            }
            	            break;
            	        case 14 :
            	            // Bib.g:5825:10: ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )?
            	            {
            	            // Bib.g:5825:10: ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )?
            	            int alt51=2;
            	            int LA51_0 = input.LA(1);

            	            if ( (LA51_0==24) ) {
            	                alt51=1;
            	            }
            	            switch (alt51) {
            	                case 1 :
            	                    // Bib.g:5826:6: ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) )
            	                    {
            	                    // Bib.g:5826:6: ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) )
            	                    // Bib.g:5827:7: (a18_0= parse_org_emftext_language_bibtex_AddressField )
            	                    {
            	                    // Bib.g:5827:7: (a18_0= parse_org_emftext_language_bibtex_AddressField )
            	                    // Bib.g:5828:8: a18_0= parse_org_emftext_language_bibtex_AddressField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AddressField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7352);
            	                    a18_0=parse_org_emftext_language_bibtex_AddressField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 264);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 264);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 265);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 265);
            	              				
            	            }

            	            }
            	            break;
            	        case 15 :
            	            // Bib.g:5863:10: ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
            	            {
            	            // Bib.g:5863:10: ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
            	            int alt52=2;
            	            int LA52_0 = input.LA(1);

            	            if ( (LA52_0==25) ) {
            	                alt52=1;
            	            }
            	            switch (alt52) {
            	                case 1 :
            	                    // Bib.g:5864:6: ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) )
            	                    {
            	                    // Bib.g:5864:6: ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) )
            	                    // Bib.g:5865:7: (a19_0= parse_org_emftext_language_bibtex_MonthField )
            	                    {
            	                    // Bib.g:5865:7: (a19_0= parse_org_emftext_language_bibtex_MonthField )
            	                    // Bib.g:5866:8: a19_0= parse_org_emftext_language_bibtex_MonthField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7457);
            	                    a19_0=parse_org_emftext_language_bibtex_MonthField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 266);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 266);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 267);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 267);
            	              				
            	            }

            	            }
            	            break;
            	        case 16 :
            	            // Bib.g:5901:10: ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )?
            	            {
            	            // Bib.g:5901:10: ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )?
            	            int alt53=2;
            	            int LA53_0 = input.LA(1);

            	            if ( (LA53_0==26) ) {
            	                alt53=1;
            	            }
            	            switch (alt53) {
            	                case 1 :
            	                    // Bib.g:5902:6: ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) )
            	                    {
            	                    // Bib.g:5902:6: ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) )
            	                    // Bib.g:5903:7: (a20_0= parse_org_emftext_language_bibtex_OrganizationField )
            	                    {
            	                    // Bib.g:5903:7: (a20_0= parse_org_emftext_language_bibtex_OrganizationField )
            	                    // Bib.g:5904:8: a20_0= parse_org_emftext_language_bibtex_OrganizationField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_OrganizationField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7562);
            	                    a20_0=parse_org_emftext_language_bibtex_OrganizationField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 268);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 268);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 269);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 269);
            	              				
            	            }

            	            }
            	            break;
            	        case 17 :
            	            // Bib.g:5939:10: ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )?
            	            {
            	            // Bib.g:5939:10: ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )?
            	            int alt54=2;
            	            int LA54_0 = input.LA(1);

            	            if ( (LA54_0==27) ) {
            	                alt54=1;
            	            }
            	            switch (alt54) {
            	                case 1 :
            	                    // Bib.g:5940:6: ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) )
            	                    {
            	                    // Bib.g:5940:6: ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) )
            	                    // Bib.g:5941:7: (a21_0= parse_org_emftext_language_bibtex_PublisherField )
            	                    {
            	                    // Bib.g:5941:7: (a21_0= parse_org_emftext_language_bibtex_PublisherField )
            	                    // Bib.g:5942:8: a21_0= parse_org_emftext_language_bibtex_PublisherField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PublisherField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7667);
            	                    a21_0=parse_org_emftext_language_bibtex_PublisherField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 270);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 270);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 271);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 271);
            	              				
            	            }

            	            }
            	            break;
            	        case 18 :
            	            // Bib.g:5977:10: ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )?
            	            {
            	            // Bib.g:5977:10: ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )?
            	            int alt55=2;
            	            int LA55_0 = input.LA(1);

            	            if ( (LA55_0==29) ) {
            	                alt55=1;
            	            }
            	            switch (alt55) {
            	                case 1 :
            	                    // Bib.g:5978:6: ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) )
            	                    {
            	                    // Bib.g:5978:6: ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) )
            	                    // Bib.g:5979:7: (a22_0= parse_org_emftext_language_bibtex_NoteField )
            	                    {
            	                    // Bib.g:5979:7: (a22_0= parse_org_emftext_language_bibtex_NoteField )
            	                    // Bib.g:5980:8: a22_0= parse_org_emftext_language_bibtex_NoteField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NoteField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7772);
            	                    a22_0=parse_org_emftext_language_bibtex_NoteField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 272);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 272);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 273);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 273);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 274);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 274);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_5, 275);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_6, 275);
              	
            }
            a23=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_InProceedingsEntry7869); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createInProceedingsEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_27_0_0_7, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a23, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 276, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_language_bibtex_InProceedingsEntry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_InProceedingsEntry"


    // $ANTLR start "parse_org_emftext_language_bibtex_ArticleEntry"
    // Bib.g:6048:1: parse_org_emftext_language_bibtex_ArticleEntry returns [org.emftext.language.bibtex.ArticleEntry element = null] : (a0= '@ARTICLE' | a1= '@article' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a20= '}' ;
    public final org.emftext.language.bibtex.ArticleEntry parse_org_emftext_language_bibtex_ArticleEntry() throws RecognitionException {
        org.emftext.language.bibtex.ArticleEntry element =  null;
        int parse_org_emftext_language_bibtex_ArticleEntry_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a20=null;
        org.emftext.language.bibtex.BibtexKeyField a3_0 = null;

        org.emftext.language.bibtex.UrlField a5_0 = null;

        org.emftext.language.bibtex.AbstractField a6_0 = null;

        org.emftext.language.bibtex.KeywordField a7_0 = null;

        org.emftext.language.bibtex.ReviewField a8_0 = null;

        org.emftext.language.bibtex.TitleField a9_0 = null;

        org.emftext.language.bibtex.JournalField a10_0 = null;

        org.emftext.language.bibtex.VolumeField a11_0 = null;

        org.emftext.language.bibtex.YearField a12_0 = null;

        org.emftext.language.bibtex.AuthorField a13_0 = null;

        org.emftext.language.bibtex.PageField a14_0 = null;

        org.emftext.language.bibtex.NumberField a15_0 = null;

        org.emftext.language.bibtex.MonthField a16_0 = null;

        org.emftext.language.bibtex.PartField a17_0 = null;

        org.emftext.language.bibtex.EidField a18_0 = null;

        org.emftext.language.bibtex.NoteField a19_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }
            // Bib.g:6051:1: ( (a0= '@ARTICLE' | a1= '@article' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a20= '}' )
            // Bib.g:6052:2: (a0= '@ARTICLE' | a1= '@article' ) a2= '{' (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField ) ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )* a20= '}'
            {
            // Bib.g:6052:2: (a0= '@ARTICLE' | a1= '@article' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==43) ) {
                alt58=1;
            }
            else if ( (LA58_0==44) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // Bib.g:6053:3: a0= '@ARTICLE'
                    {
                    a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_language_bibtex_ArticleEntry7902); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_0_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 277);
                      		
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:6068:6: a1= '@article'
                    {
                    a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_language_bibtex_ArticleEntry7925); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_0_0_1_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 278);
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_172, 279);
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_bibtex_ArticleEntry7949); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_1, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_4, 280, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_9, 280, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_6);
              	
            }
            // Bib.g:6103:2: (a3_0= parse_org_emftext_language_bibtex_BibtexKeyField )
            // Bib.g:6104:3: a3_0= parse_org_emftext_language_bibtex_BibtexKeyField
            {
            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_ArticleEntry7967);
            a3_0=parse_org_emftext_language_bibtex_BibtexKeyField();

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 281);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 281);
              	
            }
            // Bib.g:6130:2: ( (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==18) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // Bib.g:6131:3: (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) )
            	    {
            	    // Bib.g:6131:3: (a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? ) )
            	    // Bib.g:6132:4: a4= ',' ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )
            	    {
            	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_bibtex_ArticleEntry7994); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

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
            	    // Bib.g:6162:4: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )
            	    int alt68=15;
            	    alt68 = dfa68.predict(input);
            	    switch (alt68) {
            	        case 1 :
            	            // Bib.g:6163:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
            	            {
            	            // Bib.g:6163:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
            	            int alt59=2;
            	            int LA59_0 = input.LA(1);

            	            if ( (LA59_0==33) ) {
            	                alt59=1;
            	            }
            	            switch (alt59) {
            	                case 1 :
            	                    // Bib.g:6164:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
            	                    {
            	                    // Bib.g:6164:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
            	                    // Bib.g:6165:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
            	                    {
            	                    // Bib.g:6165:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
            	                    // Bib.g:6166:8: a5_0= parse_org_emftext_language_bibtex_UrlField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_parse_org_emftext_language_bibtex_ArticleEntry8044);
            	                    a5_0=parse_org_emftext_language_bibtex_UrlField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__URL), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_0_0_0_0_0, a5_0, true);
            	                      									copyLocalizationInfos(a5_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 283);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 283);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 284);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 284);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Bib.g:6201:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
            	            {
            	            // Bib.g:6201:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
            	            int alt60=2;
            	            int LA60_0 = input.LA(1);

            	            if ( (LA60_0==31) ) {
            	                alt60=1;
            	            }
            	            switch (alt60) {
            	                case 1 :
            	                    // Bib.g:6202:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
            	                    {
            	                    // Bib.g:6202:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
            	                    // Bib.g:6203:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
            	                    {
            	                    // Bib.g:6203:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
            	                    // Bib.g:6204:8: a6_0= parse_org_emftext_language_bibtex_AbstractField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_parse_org_emftext_language_bibtex_ArticleEntry8149);
            	                    a6_0=parse_org_emftext_language_bibtex_AbstractField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__ABSTRACT), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_1_0_0_0_0, a6_0, true);
            	                      									copyLocalizationInfos(a6_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 285);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 285);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 286);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 286);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Bib.g:6239:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
            	            {
            	            // Bib.g:6239:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
            	            int alt61=2;
            	            int LA61_0 = input.LA(1);

            	            if ( (LA61_0==20) ) {
            	                alt61=1;
            	            }
            	            switch (alt61) {
            	                case 1 :
            	                    // Bib.g:6240:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
            	                    {
            	                    // Bib.g:6240:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
            	                    // Bib.g:6241:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
            	                    {
            	                    // Bib.g:6241:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
            	                    // Bib.g:6242:8: a7_0= parse_org_emftext_language_bibtex_KeywordField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_parse_org_emftext_language_bibtex_ArticleEntry8254);
            	                    a7_0=parse_org_emftext_language_bibtex_KeywordField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__KEYWORD), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_2_0_0_0_0, a7_0, true);
            	                      									copyLocalizationInfos(a7_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 287);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 287);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 288);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 288);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Bib.g:6277:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
            	            {
            	            // Bib.g:6277:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
            	            int alt62=2;
            	            int LA62_0 = input.LA(1);

            	            if ( (LA62_0==32) ) {
            	                alt62=1;
            	            }
            	            switch (alt62) {
            	                case 1 :
            	                    // Bib.g:6278:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
            	                    {
            	                    // Bib.g:6278:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
            	                    // Bib.g:6279:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
            	                    {
            	                    // Bib.g:6279:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
            	                    // Bib.g:6280:8: a8_0= parse_org_emftext_language_bibtex_ReviewField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_parse_org_emftext_language_bibtex_ArticleEntry8359);
            	                    a8_0=parse_org_emftext_language_bibtex_ReviewField();

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
            	                      										element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__REVIEW), value);
            	                      										completedElement(value, true);
            	                      									}
            	                      									collectHiddenTokens(element);
            	                      									retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_3_0_0_0_0, a8_0, true);
            	                      									copyLocalizationInfos(a8_0, element);
            	                      								}
            	                      							
            	                    }

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 289);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 289);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 290);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 290);
            	              				
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // Bib.g:6315:10: ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            {
            	            // Bib.g:6315:10: ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) )
            	            // Bib.g:6316:6: (a9_0= parse_org_emftext_language_bibtex_TitleField )
            	            {
            	            // Bib.g:6316:6: (a9_0= parse_org_emftext_language_bibtex_TitleField )
            	            // Bib.g:6317:7: a9_0= parse_org_emftext_language_bibtex_TitleField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_ArticleEntry8455);
            	            a9_0=parse_org_emftext_language_bibtex_TitleField();

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
            	              									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__TITLE), value);
            	              									completedElement(value, true);
            	              								}
            	              								collectHiddenTokens(element);
            	              								retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_5_0_0_1_0_4_0_0_0_0, a9_0, true);
            	              								copyLocalizationInfos(a9_0, element);
            	              							}
            	              						
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 291);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 291);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 292);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 292);
            	              				
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // Bib.g:6351:10: ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) )
            	            {
            	            // Bib.g:6351:10: ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) )
            	            // Bib.g:6352:6: (a10_0= parse_org_emftext_language_bibtex_JournalField )
            	            {
            	            // Bib.g:6352:6: (a10_0= parse_org_emftext_language_bibtex_JournalField )
            	            // Bib.g:6353:7: a10_0= parse_org_emftext_language_bibtex_JournalField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_JournalField_in_parse_org_emftext_language_bibtex_ArticleEntry8534);
            	            a10_0=parse_org_emftext_language_bibtex_JournalField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 293);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 293);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 294);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 294);
            	              				
            	            }

            	            }
            	            break;
            	        case 7 :
            	            // Bib.g:6387:10: ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	            {
            	            // Bib.g:6387:10: ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) )
            	            // Bib.g:6388:6: (a11_0= parse_org_emftext_language_bibtex_VolumeField )
            	            {
            	            // Bib.g:6388:6: (a11_0= parse_org_emftext_language_bibtex_VolumeField )
            	            // Bib.g:6389:7: a11_0= parse_org_emftext_language_bibtex_VolumeField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_ArticleEntry8613);
            	            a11_0=parse_org_emftext_language_bibtex_VolumeField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 295);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 295);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 296);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 296);
            	              				
            	            }

            	            }
            	            break;
            	        case 8 :
            	            // Bib.g:6423:10: ( (a12_0= parse_org_emftext_language_bibtex_YearField ) )
            	            {
            	            // Bib.g:6423:10: ( (a12_0= parse_org_emftext_language_bibtex_YearField ) )
            	            // Bib.g:6424:6: (a12_0= parse_org_emftext_language_bibtex_YearField )
            	            {
            	            // Bib.g:6424:6: (a12_0= parse_org_emftext_language_bibtex_YearField )
            	            // Bib.g:6425:7: a12_0= parse_org_emftext_language_bibtex_YearField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_ArticleEntry8692);
            	            a12_0=parse_org_emftext_language_bibtex_YearField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 297);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 297);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 298);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 298);
            	              				
            	            }

            	            }
            	            break;
            	        case 9 :
            	            // Bib.g:6459:10: ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            {
            	            // Bib.g:6459:10: ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) )
            	            // Bib.g:6460:6: (a13_0= parse_org_emftext_language_bibtex_AuthorField )
            	            {
            	            // Bib.g:6460:6: (a13_0= parse_org_emftext_language_bibtex_AuthorField )
            	            // Bib.g:6461:7: a13_0= parse_org_emftext_language_bibtex_AuthorField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_ArticleEntry8771);
            	            a13_0=parse_org_emftext_language_bibtex_AuthorField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 299);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 299);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 300);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 300);
            	              				
            	            }

            	            }
            	            break;
            	        case 10 :
            	            // Bib.g:6495:10: ( (a14_0= parse_org_emftext_language_bibtex_PageField ) )
            	            {
            	            // Bib.g:6495:10: ( (a14_0= parse_org_emftext_language_bibtex_PageField ) )
            	            // Bib.g:6496:6: (a14_0= parse_org_emftext_language_bibtex_PageField )
            	            {
            	            // Bib.g:6496:6: (a14_0= parse_org_emftext_language_bibtex_PageField )
            	            // Bib.g:6497:7: a14_0= parse_org_emftext_language_bibtex_PageField
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_ArticleEntry8850);
            	            a14_0=parse_org_emftext_language_bibtex_PageField();

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              						// expected elements (follow set)
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 301);
            	              						addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 301);
            	              					
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 302);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 302);
            	              				
            	            }

            	            }
            	            break;
            	        case 11 :
            	            // Bib.g:6531:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
            	            {
            	            // Bib.g:6531:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
            	            int alt63=2;
            	            int LA63_0 = input.LA(1);

            	            if ( (LA63_0==37) ) {
            	                alt63=1;
            	            }
            	            switch (alt63) {
            	                case 1 :
            	                    // Bib.g:6532:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
            	                    {
            	                    // Bib.g:6532:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
            	                    // Bib.g:6533:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
            	                    {
            	                    // Bib.g:6533:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
            	                    // Bib.g:6534:8: a15_0= parse_org_emftext_language_bibtex_NumberField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_parse_org_emftext_language_bibtex_ArticleEntry8938);
            	                    a15_0=parse_org_emftext_language_bibtex_NumberField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 303);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 303);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 304);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 304);
            	              				
            	            }

            	            }
            	            break;
            	        case 12 :
            	            // Bib.g:6569:10: ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
            	            {
            	            // Bib.g:6569:10: ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
            	            int alt64=2;
            	            int LA64_0 = input.LA(1);

            	            if ( (LA64_0==25) ) {
            	                alt64=1;
            	            }
            	            switch (alt64) {
            	                case 1 :
            	                    // Bib.g:6570:6: ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) )
            	                    {
            	                    // Bib.g:6570:6: ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) )
            	                    // Bib.g:6571:7: (a16_0= parse_org_emftext_language_bibtex_MonthField )
            	                    {
            	                    // Bib.g:6571:7: (a16_0= parse_org_emftext_language_bibtex_MonthField )
            	                    // Bib.g:6572:8: a16_0= parse_org_emftext_language_bibtex_MonthField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_parse_org_emftext_language_bibtex_ArticleEntry9043);
            	                    a16_0=parse_org_emftext_language_bibtex_MonthField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 305);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 305);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 306);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 306);
            	              				
            	            }

            	            }
            	            break;
            	        case 13 :
            	            // Bib.g:6607:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )?
            	            {
            	            // Bib.g:6607:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )?
            	            int alt65=2;
            	            int LA65_0 = input.LA(1);

            	            if ( (LA65_0==36) ) {
            	                alt65=1;
            	            }
            	            switch (alt65) {
            	                case 1 :
            	                    // Bib.g:6608:6: ( (a17_0= parse_org_emftext_language_bibtex_PartField ) )
            	                    {
            	                    // Bib.g:6608:6: ( (a17_0= parse_org_emftext_language_bibtex_PartField ) )
            	                    // Bib.g:6609:7: (a17_0= parse_org_emftext_language_bibtex_PartField )
            	                    {
            	                    // Bib.g:6609:7: (a17_0= parse_org_emftext_language_bibtex_PartField )
            	                    // Bib.g:6610:8: a17_0= parse_org_emftext_language_bibtex_PartField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PartField_in_parse_org_emftext_language_bibtex_ArticleEntry9148);
            	                    a17_0=parse_org_emftext_language_bibtex_PartField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 307);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 307);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 308);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 308);
            	              				
            	            }

            	            }
            	            break;
            	        case 14 :
            	            // Bib.g:6645:10: ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )?
            	            {
            	            // Bib.g:6645:10: ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )?
            	            int alt66=2;
            	            int LA66_0 = input.LA(1);

            	            if ( (LA66_0==30) ) {
            	                alt66=1;
            	            }
            	            switch (alt66) {
            	                case 1 :
            	                    // Bib.g:6646:6: ( (a18_0= parse_org_emftext_language_bibtex_EidField ) )
            	                    {
            	                    // Bib.g:6646:6: ( (a18_0= parse_org_emftext_language_bibtex_EidField ) )
            	                    // Bib.g:6647:7: (a18_0= parse_org_emftext_language_bibtex_EidField )
            	                    {
            	                    // Bib.g:6647:7: (a18_0= parse_org_emftext_language_bibtex_EidField )
            	                    // Bib.g:6648:8: a18_0= parse_org_emftext_language_bibtex_EidField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_EidField_in_parse_org_emftext_language_bibtex_ArticleEntry9253);
            	                    a18_0=parse_org_emftext_language_bibtex_EidField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 309);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 309);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 310);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 310);
            	              				
            	            }

            	            }
            	            break;
            	        case 15 :
            	            // Bib.g:6683:10: ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )?
            	            {
            	            // Bib.g:6683:10: ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )?
            	            int alt67=2;
            	            int LA67_0 = input.LA(1);

            	            if ( (LA67_0==29) ) {
            	                alt67=1;
            	            }
            	            switch (alt67) {
            	                case 1 :
            	                    // Bib.g:6684:6: ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) )
            	                    {
            	                    // Bib.g:6684:6: ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) )
            	                    // Bib.g:6685:7: (a19_0= parse_org_emftext_language_bibtex_NoteField )
            	                    {
            	                    // Bib.g:6685:7: (a19_0= parse_org_emftext_language_bibtex_NoteField )
            	                    // Bib.g:6686:8: a19_0= parse_org_emftext_language_bibtex_NoteField
            	                    {
            	                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NoteField_in_parse_org_emftext_language_bibtex_ArticleEntry9358);
            	                    a19_0=parse_org_emftext_language_bibtex_NoteField();

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

            	                    }

            	                    if ( state.backtracking==0 ) {

            	                      							// expected elements (follow set)
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 311);
            	                      							addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 311);
            	                      						
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 312);
            	              					addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 312);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 313);
            	      				addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 313);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_7, 314);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_8, 314);
              	
            }
            a20=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_bibtex_ArticleEntry9455); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.bibtex.BibtexFactory.eINSTANCE.createArticleEntry();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.language.bibtex.resource.bib.grammar.BibGrammarInformationProvider.BIB_28_0_0_7, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a20, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_0, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_1, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_2, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              		addExpectedElement(org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.TERMINAL_3, 315, org.emftext.language.bibtex.resource.bib.grammar.BibFollowSetProvider.FEATURE_0);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_language_bibtex_ArticleEntry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_ArticleEntry"


    // $ANTLR start "parse_org_emftext_language_bibtex_Entry"
    // Bib.g:6754:1: parse_org_emftext_language_bibtex_Entry returns [org.emftext.language.bibtex.Entry element = null] : (c0= parse_org_emftext_language_bibtex_InProceedingsEntry | c1= parse_org_emftext_language_bibtex_ArticleEntry );
    public final org.emftext.language.bibtex.Entry parse_org_emftext_language_bibtex_Entry() throws RecognitionException {
        org.emftext.language.bibtex.Entry element =  null;
        int parse_org_emftext_language_bibtex_Entry_StartIndex = input.index();
        org.emftext.language.bibtex.InProceedingsEntry c0 = null;

        org.emftext.language.bibtex.ArticleEntry c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }
            // Bib.g:6755:1: (c0= parse_org_emftext_language_bibtex_InProceedingsEntry | c1= parse_org_emftext_language_bibtex_ArticleEntry )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=41 && LA70_0<=42)) ) {
                alt70=1;
            }
            else if ( ((LA70_0>=43 && LA70_0<=44)) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // Bib.g:6756:2: c0= parse_org_emftext_language_bibtex_InProceedingsEntry
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_InProceedingsEntry_in_parse_org_emftext_language_bibtex_Entry9480);
                    c0=parse_org_emftext_language_bibtex_InProceedingsEntry();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Bib.g:6757:4: c1= parse_org_emftext_language_bibtex_ArticleEntry
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ArticleEntry_in_parse_org_emftext_language_bibtex_Entry9490);
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
            if ( state.backtracking>0 ) { memoize(input, 31, parse_org_emftext_language_bibtex_Entry_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_bibtex_Entry"

    // $ANTLR start synpred18_Bib
    public final void synpred18_Bib_fragment() throws RecognitionException {   
        Token a0=null;

        // Bib.g:2115:3: ( (a0= TEXT ) )
        // Bib.g:2115:3: (a0= TEXT )
        {
        // Bib.g:2115:3: (a0= TEXT )
        // Bib.g:2116:4: a0= TEXT
        {
        a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred18_Bib2428); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_Bib

    // $ANTLR start synpred43_Bib
    public final void synpred43_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.UrlField a5_0 = null;


        // Bib.g:5339:5: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? )
        // Bib.g:5339:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
        {
        // Bib.g:5339:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
        int alt80=2;
        int LA80_0 = input.LA(1);

        if ( (LA80_0==33) ) {
            alt80=1;
        }
        switch (alt80) {
            case 1 :
                // Bib.g:5340:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
                {
                // Bib.g:5340:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
                // Bib.g:5341:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
                {
                // Bib.g:5341:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
                // Bib.g:5342:8: a5_0= parse_org_emftext_language_bibtex_UrlField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_synpred43_Bib6091);
                a5_0=parse_org_emftext_language_bibtex_UrlField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred43_Bib

    // $ANTLR start synpred45_Bib
    public final void synpred45_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.AbstractField a6_0 = null;


        // Bib.g:5377:10: ( ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? )
        // Bib.g:5377:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
        {
        // Bib.g:5377:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==31) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // Bib.g:5378:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
                {
                // Bib.g:5378:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
                // Bib.g:5379:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
                {
                // Bib.g:5379:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
                // Bib.g:5380:8: a6_0= parse_org_emftext_language_bibtex_AbstractField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_synpred45_Bib6196);
                a6_0=parse_org_emftext_language_bibtex_AbstractField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred45_Bib

    // $ANTLR start synpred47_Bib
    public final void synpred47_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.KeywordField a7_0 = null;


        // Bib.g:5415:10: ( ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? )
        // Bib.g:5415:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
        {
        // Bib.g:5415:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
        int alt82=2;
        int LA82_0 = input.LA(1);

        if ( (LA82_0==20) ) {
            alt82=1;
        }
        switch (alt82) {
            case 1 :
                // Bib.g:5416:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
                {
                // Bib.g:5416:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
                // Bib.g:5417:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
                {
                // Bib.g:5417:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
                // Bib.g:5418:8: a7_0= parse_org_emftext_language_bibtex_KeywordField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_synpred47_Bib6301);
                a7_0=parse_org_emftext_language_bibtex_KeywordField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred47_Bib

    // $ANTLR start synpred49_Bib
    public final void synpred49_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.ReviewField a8_0 = null;


        // Bib.g:5453:10: ( ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? )
        // Bib.g:5453:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
        {
        // Bib.g:5453:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==32) ) {
            alt83=1;
        }
        switch (alt83) {
            case 1 :
                // Bib.g:5454:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
                {
                // Bib.g:5454:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
                // Bib.g:5455:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
                {
                // Bib.g:5455:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
                // Bib.g:5456:8: a8_0= parse_org_emftext_language_bibtex_ReviewField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_synpred49_Bib6406);
                a8_0=parse_org_emftext_language_bibtex_ReviewField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred49_Bib

    // $ANTLR start synpred55_Bib
    public final void synpred55_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.EditorField a13_0 = null;


        // Bib.g:5635:10: ( ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? )
        // Bib.g:5635:10: ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )?
        {
        // Bib.g:5635:10: ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )?
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( (LA84_0==19) ) {
            alt84=1;
        }
        switch (alt84) {
            case 1 :
                // Bib.g:5636:6: ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) )
                {
                // Bib.g:5636:6: ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) )
                // Bib.g:5637:7: (a13_0= parse_org_emftext_language_bibtex_EditorField )
                {
                // Bib.g:5637:7: (a13_0= parse_org_emftext_language_bibtex_EditorField )
                // Bib.g:5638:8: a13_0= parse_org_emftext_language_bibtex_EditorField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_EditorField_in_synpred55_Bib6827);
                a13_0=parse_org_emftext_language_bibtex_EditorField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred55_Bib

    // $ANTLR start synpred57_Bib
    public final void synpred57_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.VolumeField a14_0 = null;


        // Bib.g:5673:10: ( ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? )
        // Bib.g:5673:10: ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )?
        {
        // Bib.g:5673:10: ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==35) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // Bib.g:5674:6: ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) )
                {
                // Bib.g:5674:6: ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) )
                // Bib.g:5675:7: (a14_0= parse_org_emftext_language_bibtex_VolumeField )
                {
                // Bib.g:5675:7: (a14_0= parse_org_emftext_language_bibtex_VolumeField )
                // Bib.g:5676:8: a14_0= parse_org_emftext_language_bibtex_VolumeField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_synpred57_Bib6932);
                a14_0=parse_org_emftext_language_bibtex_VolumeField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred57_Bib

    // $ANTLR start synpred59_Bib
    public final void synpred59_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.NumberField a15_0 = null;


        // Bib.g:5711:10: ( ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? )
        // Bib.g:5711:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
        {
        // Bib.g:5711:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==37) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // Bib.g:5712:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
                {
                // Bib.g:5712:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
                // Bib.g:5713:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
                {
                // Bib.g:5713:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
                // Bib.g:5714:8: a15_0= parse_org_emftext_language_bibtex_NumberField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_synpred59_Bib7037);
                a15_0=parse_org_emftext_language_bibtex_NumberField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred59_Bib

    // $ANTLR start synpred61_Bib
    public final void synpred61_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.SeriesField a16_0 = null;


        // Bib.g:5749:10: ( ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? )
        // Bib.g:5749:10: ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )?
        {
        // Bib.g:5749:10: ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )?
        int alt87=2;
        int LA87_0 = input.LA(1);

        if ( (LA87_0==23) ) {
            alt87=1;
        }
        switch (alt87) {
            case 1 :
                // Bib.g:5750:6: ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) )
                {
                // Bib.g:5750:6: ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) )
                // Bib.g:5751:7: (a16_0= parse_org_emftext_language_bibtex_SeriesField )
                {
                // Bib.g:5751:7: (a16_0= parse_org_emftext_language_bibtex_SeriesField )
                // Bib.g:5752:8: a16_0= parse_org_emftext_language_bibtex_SeriesField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_SeriesField_in_synpred61_Bib7142);
                a16_0=parse_org_emftext_language_bibtex_SeriesField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred61_Bib

    // $ANTLR start synpred63_Bib
    public final void synpred63_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.PageField a17_0 = null;


        // Bib.g:5787:10: ( ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? )
        // Bib.g:5787:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )?
        {
        // Bib.g:5787:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==38) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // Bib.g:5788:6: ( (a17_0= parse_org_emftext_language_bibtex_PageField ) )
                {
                // Bib.g:5788:6: ( (a17_0= parse_org_emftext_language_bibtex_PageField ) )
                // Bib.g:5789:7: (a17_0= parse_org_emftext_language_bibtex_PageField )
                {
                // Bib.g:5789:7: (a17_0= parse_org_emftext_language_bibtex_PageField )
                // Bib.g:5790:8: a17_0= parse_org_emftext_language_bibtex_PageField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PageField_in_synpred63_Bib7247);
                a17_0=parse_org_emftext_language_bibtex_PageField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred63_Bib

    // $ANTLR start synpred65_Bib
    public final void synpred65_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.AddressField a18_0 = null;


        // Bib.g:5825:10: ( ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? )
        // Bib.g:5825:10: ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )?
        {
        // Bib.g:5825:10: ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==24) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // Bib.g:5826:6: ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) )
                {
                // Bib.g:5826:6: ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) )
                // Bib.g:5827:7: (a18_0= parse_org_emftext_language_bibtex_AddressField )
                {
                // Bib.g:5827:7: (a18_0= parse_org_emftext_language_bibtex_AddressField )
                // Bib.g:5828:8: a18_0= parse_org_emftext_language_bibtex_AddressField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AddressField_in_synpred65_Bib7352);
                a18_0=parse_org_emftext_language_bibtex_AddressField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred65_Bib

    // $ANTLR start synpred67_Bib
    public final void synpred67_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.MonthField a19_0 = null;


        // Bib.g:5863:10: ( ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? )
        // Bib.g:5863:10: ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
        {
        // Bib.g:5863:10: ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==25) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // Bib.g:5864:6: ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) )
                {
                // Bib.g:5864:6: ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) )
                // Bib.g:5865:7: (a19_0= parse_org_emftext_language_bibtex_MonthField )
                {
                // Bib.g:5865:7: (a19_0= parse_org_emftext_language_bibtex_MonthField )
                // Bib.g:5866:8: a19_0= parse_org_emftext_language_bibtex_MonthField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_synpred67_Bib7457);
                a19_0=parse_org_emftext_language_bibtex_MonthField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred67_Bib

    // $ANTLR start synpred69_Bib
    public final void synpred69_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.OrganizationField a20_0 = null;


        // Bib.g:5901:10: ( ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? )
        // Bib.g:5901:10: ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )?
        {
        // Bib.g:5901:10: ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )?
        int alt91=2;
        int LA91_0 = input.LA(1);

        if ( (LA91_0==26) ) {
            alt91=1;
        }
        switch (alt91) {
            case 1 :
                // Bib.g:5902:6: ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) )
                {
                // Bib.g:5902:6: ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) )
                // Bib.g:5903:7: (a20_0= parse_org_emftext_language_bibtex_OrganizationField )
                {
                // Bib.g:5903:7: (a20_0= parse_org_emftext_language_bibtex_OrganizationField )
                // Bib.g:5904:8: a20_0= parse_org_emftext_language_bibtex_OrganizationField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_OrganizationField_in_synpred69_Bib7562);
                a20_0=parse_org_emftext_language_bibtex_OrganizationField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred69_Bib

    // $ANTLR start synpred71_Bib
    public final void synpred71_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.PublisherField a21_0 = null;


        // Bib.g:5939:10: ( ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? )
        // Bib.g:5939:10: ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )?
        {
        // Bib.g:5939:10: ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==27) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // Bib.g:5940:6: ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) )
                {
                // Bib.g:5940:6: ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) )
                // Bib.g:5941:7: (a21_0= parse_org_emftext_language_bibtex_PublisherField )
                {
                // Bib.g:5941:7: (a21_0= parse_org_emftext_language_bibtex_PublisherField )
                // Bib.g:5942:8: a21_0= parse_org_emftext_language_bibtex_PublisherField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PublisherField_in_synpred71_Bib7667);
                a21_0=parse_org_emftext_language_bibtex_PublisherField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred71_Bib

    // $ANTLR start synpred76_Bib
    public final void synpred76_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.UrlField a5_0 = null;


        // Bib.g:6163:5: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? )
        // Bib.g:6163:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
        {
        // Bib.g:6163:5: ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )?
        int alt108=2;
        int LA108_0 = input.LA(1);

        if ( (LA108_0==33) ) {
            alt108=1;
        }
        switch (alt108) {
            case 1 :
                // Bib.g:6164:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
                {
                // Bib.g:6164:6: ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) )
                // Bib.g:6165:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
                {
                // Bib.g:6165:7: (a5_0= parse_org_emftext_language_bibtex_UrlField )
                // Bib.g:6166:8: a5_0= parse_org_emftext_language_bibtex_UrlField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_synpred76_Bib8044);
                a5_0=parse_org_emftext_language_bibtex_UrlField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred76_Bib

    // $ANTLR start synpred78_Bib
    public final void synpred78_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.AbstractField a6_0 = null;


        // Bib.g:6201:10: ( ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? )
        // Bib.g:6201:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
        {
        // Bib.g:6201:10: ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )?
        int alt109=2;
        int LA109_0 = input.LA(1);

        if ( (LA109_0==31) ) {
            alt109=1;
        }
        switch (alt109) {
            case 1 :
                // Bib.g:6202:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
                {
                // Bib.g:6202:6: ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) )
                // Bib.g:6203:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
                {
                // Bib.g:6203:7: (a6_0= parse_org_emftext_language_bibtex_AbstractField )
                // Bib.g:6204:8: a6_0= parse_org_emftext_language_bibtex_AbstractField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_synpred78_Bib8149);
                a6_0=parse_org_emftext_language_bibtex_AbstractField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred78_Bib

    // $ANTLR start synpred80_Bib
    public final void synpred80_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.KeywordField a7_0 = null;


        // Bib.g:6239:10: ( ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? )
        // Bib.g:6239:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
        {
        // Bib.g:6239:10: ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )?
        int alt110=2;
        int LA110_0 = input.LA(1);

        if ( (LA110_0==20) ) {
            alt110=1;
        }
        switch (alt110) {
            case 1 :
                // Bib.g:6240:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
                {
                // Bib.g:6240:6: ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) )
                // Bib.g:6241:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
                {
                // Bib.g:6241:7: (a7_0= parse_org_emftext_language_bibtex_KeywordField )
                // Bib.g:6242:8: a7_0= parse_org_emftext_language_bibtex_KeywordField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_synpred80_Bib8254);
                a7_0=parse_org_emftext_language_bibtex_KeywordField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred80_Bib

    // $ANTLR start synpred82_Bib
    public final void synpred82_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.ReviewField a8_0 = null;


        // Bib.g:6277:10: ( ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? )
        // Bib.g:6277:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
        {
        // Bib.g:6277:10: ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )?
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( (LA111_0==32) ) {
            alt111=1;
        }
        switch (alt111) {
            case 1 :
                // Bib.g:6278:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
                {
                // Bib.g:6278:6: ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) )
                // Bib.g:6279:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
                {
                // Bib.g:6279:7: (a8_0= parse_org_emftext_language_bibtex_ReviewField )
                // Bib.g:6280:8: a8_0= parse_org_emftext_language_bibtex_ReviewField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_synpred82_Bib8359);
                a8_0=parse_org_emftext_language_bibtex_ReviewField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred82_Bib

    // $ANTLR start synpred90_Bib
    public final void synpred90_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.NumberField a15_0 = null;


        // Bib.g:6531:10: ( ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? )
        // Bib.g:6531:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
        {
        // Bib.g:6531:10: ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )?
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( (LA112_0==37) ) {
            alt112=1;
        }
        switch (alt112) {
            case 1 :
                // Bib.g:6532:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
                {
                // Bib.g:6532:6: ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) )
                // Bib.g:6533:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
                {
                // Bib.g:6533:7: (a15_0= parse_org_emftext_language_bibtex_NumberField )
                // Bib.g:6534:8: a15_0= parse_org_emftext_language_bibtex_NumberField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_synpred90_Bib8938);
                a15_0=parse_org_emftext_language_bibtex_NumberField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred90_Bib

    // $ANTLR start synpred92_Bib
    public final void synpred92_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.MonthField a16_0 = null;


        // Bib.g:6569:10: ( ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? )
        // Bib.g:6569:10: ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
        {
        // Bib.g:6569:10: ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )?
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( (LA113_0==25) ) {
            alt113=1;
        }
        switch (alt113) {
            case 1 :
                // Bib.g:6570:6: ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) )
                {
                // Bib.g:6570:6: ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) )
                // Bib.g:6571:7: (a16_0= parse_org_emftext_language_bibtex_MonthField )
                {
                // Bib.g:6571:7: (a16_0= parse_org_emftext_language_bibtex_MonthField )
                // Bib.g:6572:8: a16_0= parse_org_emftext_language_bibtex_MonthField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_synpred92_Bib9043);
                a16_0=parse_org_emftext_language_bibtex_MonthField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred92_Bib

    // $ANTLR start synpred94_Bib
    public final void synpred94_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.PartField a17_0 = null;


        // Bib.g:6607:10: ( ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? )
        // Bib.g:6607:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )?
        {
        // Bib.g:6607:10: ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==36) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // Bib.g:6608:6: ( (a17_0= parse_org_emftext_language_bibtex_PartField ) )
                {
                // Bib.g:6608:6: ( (a17_0= parse_org_emftext_language_bibtex_PartField ) )
                // Bib.g:6609:7: (a17_0= parse_org_emftext_language_bibtex_PartField )
                {
                // Bib.g:6609:7: (a17_0= parse_org_emftext_language_bibtex_PartField )
                // Bib.g:6610:8: a17_0= parse_org_emftext_language_bibtex_PartField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_PartField_in_synpred94_Bib9148);
                a17_0=parse_org_emftext_language_bibtex_PartField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred94_Bib

    // $ANTLR start synpred96_Bib
    public final void synpred96_Bib_fragment() throws RecognitionException {   
        org.emftext.language.bibtex.EidField a18_0 = null;


        // Bib.g:6645:10: ( ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? )
        // Bib.g:6645:10: ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )?
        {
        // Bib.g:6645:10: ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==30) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // Bib.g:6646:6: ( (a18_0= parse_org_emftext_language_bibtex_EidField ) )
                {
                // Bib.g:6646:6: ( (a18_0= parse_org_emftext_language_bibtex_EidField ) )
                // Bib.g:6647:7: (a18_0= parse_org_emftext_language_bibtex_EidField )
                {
                // Bib.g:6647:7: (a18_0= parse_org_emftext_language_bibtex_EidField )
                // Bib.g:6648:8: a18_0= parse_org_emftext_language_bibtex_EidField
                {
                pushFollow(FOLLOW_parse_org_emftext_language_bibtex_EidField_in_synpred96_Bib9253);
                a18_0=parse_org_emftext_language_bibtex_EidField();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred96_Bib

    // Delegated rules

    public final boolean synpred67_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_Bib() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_Bib_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA56 dfa56 = new DFA56(this);
    protected DFA68 dfa68 = new DFA68(this);
    static final String DFA56_eotS =
        "\25\uffff";
    static final String DFA56_eofS =
        "\25\uffff";
    static final String DFA56_minS =
        "\1\14\1\uffff\2\0\21\uffff";
    static final String DFA56_maxS =
        "\1\46\1\uffff\2\0\21\uffff";
    static final String DFA56_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\1\14\1\15\1\16\1\17\1\20\1\21\1\22";
    static final String DFA56_specialS =
        "\2\uffff\1\0\1\1\21\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\12\4\uffff\1\2\1\3\1\13\1\5\1\7\1\10\1\16\1\20\1\21\1\22"+
            "\1\23\1\uffff\1\24\1\uffff\1\4\1\6\1\1\1\11\1\14\1\uffff\1\15"+
            "\1\17",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "5338:4: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_BookTitleField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( ( (a13_0= parse_org_emftext_language_bibtex_EditorField ) ) )? | ( ( (a14_0= parse_org_emftext_language_bibtex_VolumeField ) ) )? | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_SeriesField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PageField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_AddressField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a20_0= parse_org_emftext_language_bibtex_OrganizationField ) ) )? | ( ( (a21_0= parse_org_emftext_language_bibtex_PublisherField ) ) )? | ( ( (a22_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_2 = input.LA(1);

                         
                        int index56_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_Bib()) ) {s = 1;}

                        else if ( (synpred45_Bib()) ) {s = 4;}

                        else if ( (synpred47_Bib()) ) {s = 5;}

                        else if ( (synpred49_Bib()) ) {s = 6;}

                        else if ( (synpred55_Bib()) ) {s = 11;}

                        else if ( (synpred57_Bib()) ) {s = 12;}

                        else if ( (synpred59_Bib()) ) {s = 13;}

                        else if ( (synpred61_Bib()) ) {s = 14;}

                        else if ( (synpred63_Bib()) ) {s = 15;}

                        else if ( (synpred65_Bib()) ) {s = 16;}

                        else if ( (synpred67_Bib()) ) {s = 17;}

                        else if ( (synpred69_Bib()) ) {s = 18;}

                        else if ( (synpred71_Bib()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index56_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_3 = input.LA(1);

                         
                        int index56_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_Bib()) ) {s = 1;}

                        else if ( (synpred45_Bib()) ) {s = 4;}

                        else if ( (synpred47_Bib()) ) {s = 5;}

                        else if ( (synpred49_Bib()) ) {s = 6;}

                        else if ( (synpred55_Bib()) ) {s = 11;}

                        else if ( (synpred57_Bib()) ) {s = 12;}

                        else if ( (synpred59_Bib()) ) {s = 13;}

                        else if ( (synpred61_Bib()) ) {s = 14;}

                        else if ( (synpred63_Bib()) ) {s = 15;}

                        else if ( (synpred65_Bib()) ) {s = 16;}

                        else if ( (synpred67_Bib()) ) {s = 17;}

                        else if ( (synpred69_Bib()) ) {s = 18;}

                        else if ( (synpred71_Bib()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index56_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\22\uffff";
    static final String DFA68_eofS =
        "\22\uffff";
    static final String DFA68_minS =
        "\1\14\1\uffff\2\0\16\uffff";
    static final String DFA68_maxS =
        "\1\46\1\uffff\2\0\16\uffff";
    static final String DFA68_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\1\14\1\15\1\16\1\17";
    static final String DFA68_specialS =
        "\2\uffff\1\0\1\1\16\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\13\4\uffff\1\2\1\3\1\uffff\1\5\1\7\3\uffff\1\16\2\uffff"+
            "\1\10\1\21\1\20\1\4\1\6\1\1\1\12\1\11\1\17\1\15\1\14",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "6162:4: ( ( ( (a5_0= parse_org_emftext_language_bibtex_UrlField ) ) )? | ( ( (a6_0= parse_org_emftext_language_bibtex_AbstractField ) ) )? | ( ( (a7_0= parse_org_emftext_language_bibtex_KeywordField ) ) )? | ( ( (a8_0= parse_org_emftext_language_bibtex_ReviewField ) ) )? | ( (a9_0= parse_org_emftext_language_bibtex_TitleField ) ) | ( (a10_0= parse_org_emftext_language_bibtex_JournalField ) ) | ( (a11_0= parse_org_emftext_language_bibtex_VolumeField ) ) | ( (a12_0= parse_org_emftext_language_bibtex_YearField ) ) | ( (a13_0= parse_org_emftext_language_bibtex_AuthorField ) ) | ( (a14_0= parse_org_emftext_language_bibtex_PageField ) ) | ( ( (a15_0= parse_org_emftext_language_bibtex_NumberField ) ) )? | ( ( (a16_0= parse_org_emftext_language_bibtex_MonthField ) ) )? | ( ( (a17_0= parse_org_emftext_language_bibtex_PartField ) ) )? | ( ( (a18_0= parse_org_emftext_language_bibtex_EidField ) ) )? | ( ( (a19_0= parse_org_emftext_language_bibtex_NoteField ) ) )? )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_2 = input.LA(1);

                         
                        int index68_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_Bib()) ) {s = 1;}

                        else if ( (synpred78_Bib()) ) {s = 4;}

                        else if ( (synpred80_Bib()) ) {s = 5;}

                        else if ( (synpred82_Bib()) ) {s = 6;}

                        else if ( (synpred90_Bib()) ) {s = 13;}

                        else if ( (synpred92_Bib()) ) {s = 14;}

                        else if ( (synpred94_Bib()) ) {s = 15;}

                        else if ( (synpred96_Bib()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index68_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA68_3 = input.LA(1);

                         
                        int index68_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_Bib()) ) {s = 1;}

                        else if ( (synpred78_Bib()) ) {s = 4;}

                        else if ( (synpred80_Bib()) ) {s = 5;}

                        else if ( (synpred82_Bib()) ) {s = 6;}

                        else if ( (synpred90_Bib()) ) {s = 13;}

                        else if ( (synpred92_Bib()) ) {s = 14;}

                        else if ( (synpred94_Bib()) ) {s = 15;}

                        else if ( (synpred96_Bib()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index68_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Bibliography_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Entry_in_parse_org_emftext_language_bibtex_Bibliography124 = new BitSet(new long[]{0x00001E0000000002L});
    public static final BitSet FOLLOW_ID_in_parse_org_emftext_language_bibtex_BibtexKeyField174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BibtexKeyField212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_bibtex_AuthorField261 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_AuthorField275 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_AuthorField298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField324 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField399 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_AuthorField460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_AuthorField501 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField527 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_AuthorField568 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Author_in_parse_org_emftext_language_bibtex_AuthorField602 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_AuthorField663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author730 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author784 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author925 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_Author964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author994 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Author1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_bibtex_EditorField1181 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_EditorField1195 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_EditorField1218 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1244 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_EditorField1285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1319 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_EditorField1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_EditorField1421 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1447 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_bibtex_EditorField1488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Editor_in_parse_org_emftext_language_bibtex_EditorField1522 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_EditorField1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1650 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1704 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1838 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_Editor1871 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1897 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Editor1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_bibtex_KeywordField2051 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_KeywordField2065 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_KeywordField2083 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2105 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_KeywordField2139 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2169 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_KeywordField2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_KeywordField2243 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2265 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_KeywordField2299 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Keyword_in_parse_org_emftext_language_bibtex_KeywordField2329 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_KeywordField2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Keyword2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_Keyword2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_bibtex_TitleField2515 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_TitleField2529 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_TitleField2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_TitleField2590 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_TitleField2616 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_TitleField2649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_bibtex_BookTitleField2701 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_BookTitleField2715 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_BookTitleField2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_BookTitleField2771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_BookTitleField2793 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_BookTitleField2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_bibtex_SeriesField2859 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_SeriesField2873 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_SeriesField2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_SeriesField2929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_SeriesField2951 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_SeriesField2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_bibtex_AddressField3017 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_AddressField3031 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_AddressField3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_AddressField3087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_AddressField3109 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_AddressField3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_bibtex_MonthField3175 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_MonthField3189 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_MonthField3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_MonthField3245 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_MonthField3267 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_MonthField3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_bibtex_OrganizationField3333 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_OrganizationField3347 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_OrganizationField3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_OrganizationField3403 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_OrganizationField3425 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_OrganizationField3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_bibtex_PublisherField3491 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_PublisherField3505 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_PublisherField3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_PublisherField3561 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_PublisherField3583 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_PublisherField3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_bibtex_JournalField3649 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_JournalField3663 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_JournalField3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_JournalField3719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_JournalField3741 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_JournalField3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_bibtex_NoteField3807 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_NoteField3821 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_NoteField3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_NoteField3877 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_NoteField3899 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_NoteField3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_bibtex_EidField3965 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_EidField3979 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_EidField4002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_EidField4035 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_EidField4057 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_EidField4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_language_bibtex_AbstractField4123 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_AbstractField4137 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_AbstractField4160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_AbstractField4193 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_AbstractField4215 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_AbstractField4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_language_bibtex_ReviewField4281 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_ReviewField4295 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_ReviewField4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_ReviewField4351 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_ReviewField4373 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_ReviewField4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_language_bibtex_UrlField4439 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_UrlField4453 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_bibtex_UrlField4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_UrlField4509 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_bibtex_UrlField4531 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_UrlField4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_language_bibtex_YearField4597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_YearField4611 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_YearField4629 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField4651 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_YearField4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField4701 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_YEAR_in_parse_org_emftext_language_bibtex_YearField4723 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_YearField4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_language_bibtex_VolumeField4789 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_VolumeField4803 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_VolumeField4821 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField4849 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_VolumeField4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_VolumeField4915 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_VolumeField4943 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_VolumeField4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_bibtex_PartField5025 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_PartField5039 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_PartField5057 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_PartField5079 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_PartField5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_PartField5129 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_PartField5151 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_PartField5178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_language_bibtex_NumberField5217 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_NumberField5231 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_NumberField5249 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_NumberField5271 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_NumberField5298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_NumberField5321 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_NumberField5343 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_NumberField5370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_language_bibtex_PageField5409 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_bibtex_PageField5423 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_PageField5441 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5463 = new BitSet(new long[]{0x0000018000020000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_language_bibtex_PageField5504 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_bibtex_PageField5542 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5591 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_PageField5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_PageField5665 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5687 = new BitSet(new long[]{0x0000018000004000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_language_bibtex_PageField5728 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_bibtex_PageField5766 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_Page_in_parse_org_emftext_language_bibtex_PageField5815 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_bibtex_PageField5866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_emftext_language_bibtex_Page5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_bibtex_InProceedingsEntry5949 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_language_bibtex_InProceedingsEntry5972 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_InProceedingsEntry5996 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6014 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_InProceedingsEntry6041 = new BitSet(new long[]{0x0000006FAFFE1000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6091 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6196 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6301 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6406 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6502 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BookTitleField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6581 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6660 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6739 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_EditorField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6827 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_InProceedingsEntry6932 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7037 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_SeriesField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7142 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7247 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AddressField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7352 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7457 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_OrganizationField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7562 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PublisherField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7667 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NoteField_in_parse_org_emftext_language_bibtex_InProceedingsEntry7772 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_InProceedingsEntry7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_language_bibtex_ArticleEntry7902 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_language_bibtex_ArticleEntry7925 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_bibtex_ArticleEntry7949 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_BibtexKeyField_in_parse_org_emftext_language_bibtex_ArticleEntry7967 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_bibtex_ArticleEntry7994 = new BitSet(new long[]{0x0000007FF2361000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_parse_org_emftext_language_bibtex_ArticleEntry8044 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_parse_org_emftext_language_bibtex_ArticleEntry8149 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_parse_org_emftext_language_bibtex_ArticleEntry8254 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_parse_org_emftext_language_bibtex_ArticleEntry8359 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_TitleField_in_parse_org_emftext_language_bibtex_ArticleEntry8455 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_JournalField_in_parse_org_emftext_language_bibtex_ArticleEntry8534 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_parse_org_emftext_language_bibtex_ArticleEntry8613 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_YearField_in_parse_org_emftext_language_bibtex_ArticleEntry8692 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AuthorField_in_parse_org_emftext_language_bibtex_ArticleEntry8771 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PageField_in_parse_org_emftext_language_bibtex_ArticleEntry8850 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_parse_org_emftext_language_bibtex_ArticleEntry8938 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_parse_org_emftext_language_bibtex_ArticleEntry9043 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PartField_in_parse_org_emftext_language_bibtex_ArticleEntry9148 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_EidField_in_parse_org_emftext_language_bibtex_ArticleEntry9253 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NoteField_in_parse_org_emftext_language_bibtex_ArticleEntry9358 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_bibtex_ArticleEntry9455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_InProceedingsEntry_in_parse_org_emftext_language_bibtex_Entry9480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ArticleEntry_in_parse_org_emftext_language_bibtex_Entry9490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred18_Bib2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_synpred43_Bib6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_synpred45_Bib6196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_synpred47_Bib6301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_synpred49_Bib6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_EditorField_in_synpred55_Bib6827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_VolumeField_in_synpred57_Bib6932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_synpred59_Bib7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_SeriesField_in_synpred61_Bib7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PageField_in_synpred63_Bib7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AddressField_in_synpred65_Bib7352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_synpred67_Bib7457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_OrganizationField_in_synpred69_Bib7562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PublisherField_in_synpred71_Bib7667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_UrlField_in_synpred76_Bib8044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_AbstractField_in_synpred78_Bib8149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_KeywordField_in_synpred80_Bib8254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_ReviewField_in_synpred82_Bib8359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_NumberField_in_synpred90_Bib8938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_MonthField_in_synpred92_Bib9043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_PartField_in_synpred94_Bib9148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_bibtex_EidField_in_synpred96_Bib9253 = new BitSet(new long[]{0x0000000000000002L});

}