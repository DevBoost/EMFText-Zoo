// $ANTLR 3.4

	package org.emftext.language.notes.resource.notes.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class NotesParser extends NotesANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "ML_COMMENT", "QUOTED_35_35", "QUOTED_64_64", "QUOTED_91_93", "QUOTED_95_95", "SL_COMMENT", "TEXT", "WHITESPACE", "' '", "'*'", "'='", "'>'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int LINEBREAK=4;
    public static final int ML_COMMENT=5;
    public static final int QUOTED_35_35=6;
    public static final int QUOTED_64_64=7;
    public static final int QUOTED_91_93=8;
    public static final int QUOTED_95_95=9;
    public static final int SL_COMMENT=10;
    public static final int TEXT=11;
    public static final int WHITESPACE=12;

    // delegates
    public NotesANTLRParserBase[] getDelegates() {
        return new NotesANTLRParserBase[] {};
    }

    // delegators


    public NotesParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public NotesParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[20+1];
         

    }

    public String[] getTokenNames() { return NotesParser.tokenNames; }
    public String getGrammarFileName() { return "Notes.g"; }


    	private org.emftext.language.notes.resource.notes.INotesTokenResolverFactory tokenResolverFactory = new org.emftext.language.notes.resource.notes.mopp.NotesTokenResolverFactory();
    	
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
    	private java.util.List<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal>();
    	
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
    		postParseCommands.add(new org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>() {
    			public boolean execute(org.emftext.language.notes.resource.notes.INotesTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.language.notes.resource.notes.INotesProblem() {
    					public org.emftext.language.notes.resource.notes.NotesEProblemSeverity getSeverity() {
    						return org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR;
    					}
    					public org.emftext.language.notes.resource.notes.NotesEProblemType getType() {
    						return org.emftext.language.notes.resource.notes.NotesEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> getQuickFixes() {
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
    		org.emftext.language.notes.resource.notes.INotesExpectedElement terminal = org.emftext.language.notes.resource.notes.grammar.NotesFollowSetProvider.TERMINALS[terminalID];
    		org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] containmentTrace = new org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentTrace[i - 2] = org.emftext.language.notes.resource.notes.grammar.NotesFollowSetProvider.LINKS[ids[i]];
    		}
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal expectedElement = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>() {
    			public boolean execute(org.emftext.language.notes.resource.notes.INotesTextResource resource) {
    				org.emftext.language.notes.resource.notes.INotesLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>() {
    			public boolean execute(org.emftext.language.notes.resource.notes.INotesTextResource resource) {
    				org.emftext.language.notes.resource.notes.INotesLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		postParseCommands.add(new org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>() {
    			public boolean execute(org.emftext.language.notes.resource.notes.INotesTextResource resource) {
    				org.emftext.language.notes.resource.notes.INotesLocationMap locationMap = resource.getLocationMap();
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
    	
    	public org.emftext.language.notes.resource.notes.INotesTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new NotesParser(new org.antlr.runtime3_4_0.CommonTokenStream(new NotesLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new NotesParser(new org.antlr.runtime3_4_0.CommonTokenStream(new NotesLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public NotesParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((NotesLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((NotesLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.language.notes.NoteDocument.class) {
    				return parse_org_emftext_language_notes_NoteDocument();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.Section.class) {
    				return parse_org_emftext_language_notes_Section();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.BulletPoint.class) {
    				return parse_org_emftext_language_notes_BulletPoint();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.SimpleText.class) {
    				return parse_org_emftext_language_notes_SimpleText();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.Bold.class) {
    				return parse_org_emftext_language_notes_Bold();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.Italic.class) {
    				return parse_org_emftext_language_notes_Italic();
    			}
    			if (type.getInstanceClass() == org.emftext.language.notes.TypeWriter.class) {
    				return parse_org_emftext_language_notes_TypeWriter();
    			}
    		}
    		throw new org.emftext.language.notes.resource.notes.mopp.NotesUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(org.emftext.language.notes.resource.notes.INotesOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.language.notes.resource.notes.INotesParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>>();
    		org.emftext.language.notes.resource.notes.mopp.NotesParseResult parseResult = new org.emftext.language.notes.resource.notes.mopp.NotesParseResult();
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
    	
    	public java.util.List<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.notes.resource.notes.INotesTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.emftext.language.notes.resource.notes.INotesParseResult result = parse();
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
    			for (org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal>();
    		java.util.List<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 20;
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
    				for (org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.language.notes.resource.notes.INotesExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal newFollowTerminal = new org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal(container, newFollower, followSetID, newFollowerPair.getRight());
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
    		for (org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.language.notes.resource.notes.mopp.NotesExpectedTerminal expectedElement, int tokenIndex) {
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
    	



    // $ANTLR start "start"
    // Notes.g:506:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_notes_NoteDocument ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.language.notes.NoteDocument c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Notes.g:507:2: ( (c0= parse_org_emftext_language_notes_NoteDocument ) EOF )
            // Notes.g:508:2: (c0= parse_org_emftext_language_notes_NoteDocument ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Notes.g:513:2: (c0= parse_org_emftext_language_notes_NoteDocument )
            // Notes.g:514:3: c0= parse_org_emftext_language_notes_NoteDocument
            {
            pushFollow(FOLLOW_parse_org_emftext_language_notes_NoteDocument_in_start82);
            c0=parse_org_emftext_language_notes_NoteDocument();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_emftext_language_notes_NoteDocument"
    // Notes.g:522:1: parse_org_emftext_language_notes_NoteDocument returns [org.emftext.language.notes.NoteDocument element = null] : (a0= TEXT ) ( (a1_0= parse_org_emftext_language_notes_Part ) )* ;
    public final org.emftext.language.notes.NoteDocument parse_org_emftext_language_notes_NoteDocument() throws RecognitionException {
        org.emftext.language.notes.NoteDocument element =  null;

        int parse_org_emftext_language_notes_NoteDocument_StartIndex = input.index();

        Token a0=null;
        org.emftext.language.notes.Part a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Notes.g:525:2: ( (a0= TEXT ) ( (a1_0= parse_org_emftext_language_notes_Part ) )* )
            // Notes.g:526:2: (a0= TEXT ) ( (a1_0= parse_org_emftext_language_notes_Part ) )*
            {
            // Notes.g:526:2: (a0= TEXT )
            // Notes.g:527:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_notes_NoteDocument119); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createNoteDocument();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_0_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[2]);
            	}

            // Notes.g:563:2: ( (a1_0= parse_org_emftext_language_notes_Part ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 14 && LA1_0 <= 15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Notes.g:564:3: (a1_0= parse_org_emftext_language_notes_Part )
            	    {
            	    // Notes.g:564:3: (a1_0= parse_org_emftext_language_notes_Part )
            	    // Notes.g:565:4: a1_0= parse_org_emftext_language_notes_Part
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_notes_Part_in_parse_org_emftext_language_notes_NoteDocument149);
            	    a1_0=parse_org_emftext_language_notes_Part();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createNoteDocument();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__PARTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_0_0_0_3, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
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
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[4]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_notes_NoteDocument_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_NoteDocument"



    // $ANTLR start "parse_org_emftext_language_notes_Section"
    // Notes.g:594:1: parse_org_emftext_language_notes_Section returns [org.emftext.language.notes.Section element = null] : a0= '=' (a1= TEXT ) ( (a2= QUOTED_91_93 ) )? ( (a3= '>' (a4= QUOTED_91_93 ) ) )? a5= '=' ( (a6_0= parse_org_emftext_language_notes_BulletPoint ) )* ;
    public final org.emftext.language.notes.Section parse_org_emftext_language_notes_Section() throws RecognitionException {
        org.emftext.language.notes.Section element =  null;

        int parse_org_emftext_language_notes_Section_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.language.notes.BulletPoint a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Notes.g:597:2: (a0= '=' (a1= TEXT ) ( (a2= QUOTED_91_93 ) )? ( (a3= '>' (a4= QUOTED_91_93 ) ) )? a5= '=' ( (a6_0= parse_org_emftext_language_notes_BulletPoint ) )* )
            // Notes.g:598:2: a0= '=' (a1= TEXT ) ( (a2= QUOTED_91_93 ) )? ( (a3= '>' (a4= QUOTED_91_93 ) ) )? a5= '=' ( (a6_0= parse_org_emftext_language_notes_BulletPoint ) )*
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_notes_Section190); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[5]);
            	}

            // Notes.g:612:2: (a1= TEXT )
            // Notes.g:613:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_notes_Section208); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[8]);
            	}

            // Notes.g:650:2: ( (a2= QUOTED_91_93 ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUOTED_91_93) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Notes.g:651:3: (a2= QUOTED_91_93 )
                    {
                    // Notes.g:651:3: (a2= QUOTED_91_93 )
                    // Notes.g:652:4: a2= QUOTED_91_93
                    {
                    a2=(Token)match(input,QUOTED_91_93,FOLLOW_QUOTED_91_93_in_parse_org_emftext_language_notes_Section238); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
                    					startIncompleteElement(element);
                    				}
                    				if (a2 != null) {
                    					org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
                    					tokenResolver.setOptions(getOptions());
                    					org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    					}
                    					java.lang.String resolved = (java.lang.String) resolvedObject;
                    					if (resolved != null) {
                    						Object value = resolved;
                    						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_2, resolved, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[10]);
            	}

            // Notes.g:689:2: ( (a3= '>' (a4= QUOTED_91_93 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Notes.g:690:3: (a3= '>' (a4= QUOTED_91_93 ) )
                    {
                    // Notes.g:690:3: (a3= '>' (a4= QUOTED_91_93 ) )
                    // Notes.g:691:4: a3= '>' (a4= QUOTED_91_93 )
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_notes_Section277); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_3_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[11]);
                    			}

                    // Notes.g:705:4: (a4= QUOTED_91_93 )
                    // Notes.g:706:5: a4= QUOTED_91_93
                    {
                    a4=(Token)match(input,QUOTED_91_93,FOLLOW_QUOTED_91_93_in_parse_org_emftext_language_notes_Section303); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
                    						startIncompleteElement(element);
                    					}
                    					if (a4 != null) {
                    						org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
                    						tokenResolver.setOptions(getOptions());
                    						org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                    						}
                    						String resolved = (String) resolvedObject;
                    						org.emftext.language.notes.Section proxy = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
                    						collectHiddenTokens(element);
                    						registerContextDependentProxy(new org.emftext.language.notes.resource.notes.mopp.NotesContextDependentURIFragmentFactory<org.emftext.language.notes.Section, org.emftext.language.notes.Section>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSectionSuperSectionReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION), resolved, proxy);
                    						if (proxy != null) {
                    							Object value = proxy;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_3_0_0_1, proxy, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[12]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[13]);
            	}

            a5=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_notes_Section349); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[15]);
            	}

            // Notes.g:767:2: ( (a6_0= parse_org_emftext_language_notes_BulletPoint ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    switch ( input.LA(2) ) {
                    case TEXT:
                        {
                        int LA4_3 = input.LA(3);

                        if ( (synpred4_Notes()) ) {
                            alt4=1;
                        }


                        }
                        break;
                    case QUOTED_95_95:
                        {
                        int LA4_4 = input.LA(3);

                        if ( (synpred4_Notes()) ) {
                            alt4=1;
                        }


                        }
                        break;
                    case QUOTED_35_35:
                        {
                        int LA4_5 = input.LA(3);

                        if ( (synpred4_Notes()) ) {
                            alt4=1;
                        }


                        }
                        break;
                    case QUOTED_64_64:
                        {
                        int LA4_6 = input.LA(3);

                        if ( (synpred4_Notes()) ) {
                            alt4=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt4) {
            	case 1 :
            	    // Notes.g:768:3: (a6_0= parse_org_emftext_language_notes_BulletPoint )
            	    {
            	    // Notes.g:768:3: (a6_0= parse_org_emftext_language_notes_BulletPoint )
            	    // Notes.g:769:4: a6_0= parse_org_emftext_language_notes_BulletPoint
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_Section372);
            	    a6_0=parse_org_emftext_language_notes_BulletPoint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSection();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a6_0 != null) {
            	    					if (a6_0 != null) {
            	    						Object value = a6_0;
            	    						addObjectToList(element, org.emftext.language.notes.NotesPackage.SECTION__BULLETS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_1_0_0_6, a6_0, true);
            	    					copyLocalizationInfos(a6_0, element);
            	    				}
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
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[17]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_notes_Section_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_Section"



    // $ANTLR start "parse_org_emftext_language_notes_BulletPoint"
    // Notes.g:798:1: parse_org_emftext_language_notes_BulletPoint returns [org.emftext.language.notes.BulletPoint element = null] : a0= '*' ( (a1_0= parse_org_emftext_language_notes_TextPart ) )+ ( (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) ) )* ;
    public final org.emftext.language.notes.BulletPoint parse_org_emftext_language_notes_BulletPoint() throws RecognitionException {
        org.emftext.language.notes.BulletPoint element =  null;

        int parse_org_emftext_language_notes_BulletPoint_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.emftext.language.notes.TextPart a1_0 =null;

        org.emftext.language.notes.BulletPoint a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Notes.g:801:2: (a0= '*' ( (a1_0= parse_org_emftext_language_notes_TextPart ) )+ ( (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) ) )* )
            // Notes.g:802:2: a0= '*' ( (a1_0= parse_org_emftext_language_notes_TextPart ) )+ ( (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) ) )*
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_notes_BulletPoint413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.notes.NotesFactory.eINSTANCE.createBulletPoint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[21]);
            	}

            // Notes.g:819:2: ( (a1_0= parse_org_emftext_language_notes_TextPart ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= QUOTED_35_35 && LA5_0 <= QUOTED_64_64)||LA5_0==QUOTED_95_95||LA5_0==TEXT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Notes.g:820:3: (a1_0= parse_org_emftext_language_notes_TextPart )
            	    {
            	    // Notes.g:820:3: (a1_0= parse_org_emftext_language_notes_TextPart )
            	    // Notes.g:821:4: a1_0= parse_org_emftext_language_notes_TextPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_notes_TextPart_in_parse_org_emftext_language_notes_BulletPoint436);
            	    a1_0=parse_org_emftext_language_notes_TextPart();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createBulletPoint();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, org.emftext.language.notes.NotesPackage.BULLET_POINT__TEXT_PARTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_1, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[28]);
            	}

            // Notes.g:853:2: ( (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred6_Notes()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // Notes.g:854:3: (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) )
            	    {
            	    // Notes.g:854:3: (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) )
            	    // Notes.g:855:4: a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint )
            	    {
            	    a2=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_notes_BulletPoint471); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.notes.NotesFactory.eINSTANCE.createBulletPoint();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_2_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[29]);
            	    			}

            	    // Notes.g:869:4: (a3_0= parse_org_emftext_language_notes_BulletPoint )
            	    // Notes.g:870:5: a3_0= parse_org_emftext_language_notes_BulletPoint
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_BulletPoint497);
            	    a3_0=parse_org_emftext_language_notes_BulletPoint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.notes.NotesFactory.eINSTANCE.createBulletPoint();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, org.emftext.language.notes.NotesPackage.BULLET_POINT__SUB_POINTS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_2_0_0_2_0_0_2, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[30]);
            	    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[31]);
            	    				addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[32]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[35]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_notes_BulletPoint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_BulletPoint"



    // $ANTLR start "parse_org_emftext_language_notes_SimpleText"
    // Notes.g:908:1: parse_org_emftext_language_notes_SimpleText returns [org.emftext.language.notes.SimpleText element = null] : (a0= TEXT ) ;
    public final org.emftext.language.notes.SimpleText parse_org_emftext_language_notes_SimpleText() throws RecognitionException {
        org.emftext.language.notes.SimpleText element =  null;

        int parse_org_emftext_language_notes_SimpleText_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Notes.g:911:2: ( (a0= TEXT ) )
            // Notes.g:912:2: (a0= TEXT )
            {
            // Notes.g:912:2: (a0= TEXT )
            // Notes.g:913:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_notes_SimpleText557); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createSimpleText();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_3_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[42]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_notes_SimpleText_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_SimpleText"



    // $ANTLR start "parse_org_emftext_language_notes_Bold"
    // Notes.g:956:1: parse_org_emftext_language_notes_Bold returns [org.emftext.language.notes.Bold element = null] : (a0= QUOTED_95_95 ) ;
    public final org.emftext.language.notes.Bold parse_org_emftext_language_notes_Bold() throws RecognitionException {
        org.emftext.language.notes.Bold element =  null;

        int parse_org_emftext_language_notes_Bold_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Notes.g:959:2: ( (a0= QUOTED_95_95 ) )
            // Notes.g:960:2: (a0= QUOTED_95_95 )
            {
            // Notes.g:960:2: (a0= QUOTED_95_95 )
            // Notes.g:961:3: a0= QUOTED_95_95
            {
            a0=(Token)match(input,QUOTED_95_95,FOLLOW_QUOTED_95_95_in_parse_org_emftext_language_notes_Bold597); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createBold();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_95_95");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_4_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[49]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_notes_Bold_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_Bold"



    // $ANTLR start "parse_org_emftext_language_notes_Italic"
    // Notes.g:1004:1: parse_org_emftext_language_notes_Italic returns [org.emftext.language.notes.Italic element = null] : (a0= QUOTED_35_35 ) ;
    public final org.emftext.language.notes.Italic parse_org_emftext_language_notes_Italic() throws RecognitionException {
        org.emftext.language.notes.Italic element =  null;

        int parse_org_emftext_language_notes_Italic_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Notes.g:1007:2: ( (a0= QUOTED_35_35 ) )
            // Notes.g:1008:2: (a0= QUOTED_35_35 )
            {
            // Notes.g:1008:2: (a0= QUOTED_35_35 )
            // Notes.g:1009:3: a0= QUOTED_35_35
            {
            a0=(Token)match(input,QUOTED_35_35,FOLLOW_QUOTED_35_35_in_parse_org_emftext_language_notes_Italic637); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createItalic();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_35_35");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_5_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[56]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_notes_Italic_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_Italic"



    // $ANTLR start "parse_org_emftext_language_notes_TypeWriter"
    // Notes.g:1052:1: parse_org_emftext_language_notes_TypeWriter returns [org.emftext.language.notes.TypeWriter element = null] : (a0= QUOTED_64_64 ) ;
    public final org.emftext.language.notes.TypeWriter parse_org_emftext_language_notes_TypeWriter() throws RecognitionException {
        org.emftext.language.notes.TypeWriter element =  null;

        int parse_org_emftext_language_notes_TypeWriter_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Notes.g:1055:2: ( (a0= QUOTED_64_64 ) )
            // Notes.g:1056:2: (a0= QUOTED_64_64 )
            {
            // Notes.g:1056:2: (a0= QUOTED_64_64 )
            // Notes.g:1057:3: a0= QUOTED_64_64
            {
            a0=(Token)match(input,QUOTED_64_64,FOLLOW_QUOTED_64_64_in_parse_org_emftext_language_notes_TypeWriter677); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.notes.NotesFactory.eINSTANCE.createTypeWriter();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.notes.resource.notes.INotesTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_64_64");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.notes.resource.notes.INotesTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.notes.resource.notes.grammar.NotesGrammarInformationProvider.NOTES_6_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(org.emftext.language.notes.resource.notes.mopp.NotesExpectationConstants.EXPECTATIONS[63]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_notes_TypeWriter_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_TypeWriter"



    // $ANTLR start "parse_org_emftext_language_notes_Part"
    // Notes.g:1100:1: parse_org_emftext_language_notes_Part returns [org.emftext.language.notes.Part element = null] : (c0= parse_org_emftext_language_notes_Section |c1= parse_org_emftext_language_notes_BulletPoint );
    public final org.emftext.language.notes.Part parse_org_emftext_language_notes_Part() throws RecognitionException {
        org.emftext.language.notes.Part element =  null;

        int parse_org_emftext_language_notes_Part_StartIndex = input.index();

        org.emftext.language.notes.Section c0 =null;

        org.emftext.language.notes.BulletPoint c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Notes.g:1101:2: (c0= parse_org_emftext_language_notes_Section |c1= parse_org_emftext_language_notes_BulletPoint )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==14) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Notes.g:1102:2: c0= parse_org_emftext_language_notes_Section
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_Section_in_parse_org_emftext_language_notes_Part709);
                    c0=parse_org_emftext_language_notes_Section();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Notes.g:1103:4: c1= parse_org_emftext_language_notes_BulletPoint
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_Part719);
                    c1=parse_org_emftext_language_notes_BulletPoint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_notes_Part_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_Part"



    // $ANTLR start "parse_org_emftext_language_notes_TextPart"
    // Notes.g:1107:1: parse_org_emftext_language_notes_TextPart returns [org.emftext.language.notes.TextPart element = null] : (c0= parse_org_emftext_language_notes_SimpleText |c1= parse_org_emftext_language_notes_Bold |c2= parse_org_emftext_language_notes_Italic |c3= parse_org_emftext_language_notes_TypeWriter );
    public final org.emftext.language.notes.TextPart parse_org_emftext_language_notes_TextPart() throws RecognitionException {
        org.emftext.language.notes.TextPart element =  null;

        int parse_org_emftext_language_notes_TextPart_StartIndex = input.index();

        org.emftext.language.notes.SimpleText c0 =null;

        org.emftext.language.notes.Bold c1 =null;

        org.emftext.language.notes.Italic c2 =null;

        org.emftext.language.notes.TypeWriter c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Notes.g:1108:2: (c0= parse_org_emftext_language_notes_SimpleText |c1= parse_org_emftext_language_notes_Bold |c2= parse_org_emftext_language_notes_Italic |c3= parse_org_emftext_language_notes_TypeWriter )
            int alt8=4;
            switch ( input.LA(1) ) {
            case TEXT:
                {
                alt8=1;
                }
                break;
            case QUOTED_95_95:
                {
                alt8=2;
                }
                break;
            case QUOTED_35_35:
                {
                alt8=3;
                }
                break;
            case QUOTED_64_64:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // Notes.g:1109:2: c0= parse_org_emftext_language_notes_SimpleText
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_SimpleText_in_parse_org_emftext_language_notes_TextPart740);
                    c0=parse_org_emftext_language_notes_SimpleText();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Notes.g:1110:4: c1= parse_org_emftext_language_notes_Bold
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_Bold_in_parse_org_emftext_language_notes_TextPart750);
                    c1=parse_org_emftext_language_notes_Bold();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Notes.g:1111:4: c2= parse_org_emftext_language_notes_Italic
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_Italic_in_parse_org_emftext_language_notes_TextPart760);
                    c2=parse_org_emftext_language_notes_Italic();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Notes.g:1112:4: c3= parse_org_emftext_language_notes_TypeWriter
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_notes_TypeWriter_in_parse_org_emftext_language_notes_TextPart770);
                    c3=parse_org_emftext_language_notes_TypeWriter();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_notes_TextPart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_notes_TextPart"

    // $ANTLR start synpred4_Notes
    public final void synpred4_Notes_fragment() throws RecognitionException {
        org.emftext.language.notes.BulletPoint a6_0 =null;


        // Notes.g:768:3: ( (a6_0= parse_org_emftext_language_notes_BulletPoint ) )
        // Notes.g:768:3: (a6_0= parse_org_emftext_language_notes_BulletPoint )
        {
        // Notes.g:768:3: (a6_0= parse_org_emftext_language_notes_BulletPoint )
        // Notes.g:769:4: a6_0= parse_org_emftext_language_notes_BulletPoint
        {
        pushFollow(FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_synpred4_Notes372);
        a6_0=parse_org_emftext_language_notes_BulletPoint();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred4_Notes

    // $ANTLR start synpred6_Notes
    public final void synpred6_Notes_fragment() throws RecognitionException {
        Token a2=null;
        org.emftext.language.notes.BulletPoint a3_0 =null;


        // Notes.g:854:3: ( (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) ) )
        // Notes.g:854:3: (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) )
        {
        // Notes.g:854:3: (a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint ) )
        // Notes.g:855:4: a2= ' ' (a3_0= parse_org_emftext_language_notes_BulletPoint )
        {
        a2=(Token)match(input,13,FOLLOW_13_in_synpred6_Notes471); if (state.failed) return ;

        // Notes.g:869:4: (a3_0= parse_org_emftext_language_notes_BulletPoint )
        // Notes.g:870:5: a3_0= parse_org_emftext_language_notes_BulletPoint
        {
        pushFollow(FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_synpred6_Notes497);
        a3_0=parse_org_emftext_language_notes_BulletPoint();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

    }
    // $ANTLR end synpred6_Notes

    // Delegated rules

    public final boolean synpred6_Notes() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Notes_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Notes() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Notes_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_org_emftext_language_notes_NoteDocument_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_notes_NoteDocument119 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_Part_in_parse_org_emftext_language_notes_NoteDocument149 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_notes_Section190 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_notes_Section208 = new BitSet(new long[]{0x0000000000018100L});
    public static final BitSet FOLLOW_QUOTED_91_93_in_parse_org_emftext_language_notes_Section238 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_notes_Section277 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_91_93_in_parse_org_emftext_language_notes_Section303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_notes_Section349 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_Section372 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_notes_BulletPoint413 = new BitSet(new long[]{0x0000000000000AC0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_TextPart_in_parse_org_emftext_language_notes_BulletPoint436 = new BitSet(new long[]{0x0000000000002AC2L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_notes_BulletPoint471 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_BulletPoint497 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_notes_SimpleText557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_95_95_in_parse_org_emftext_language_notes_Bold597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_35_35_in_parse_org_emftext_language_notes_Italic637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_64_64_in_parse_org_emftext_language_notes_TypeWriter677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_Section_in_parse_org_emftext_language_notes_Part709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_parse_org_emftext_language_notes_Part719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_SimpleText_in_parse_org_emftext_language_notes_TextPart740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_Bold_in_parse_org_emftext_language_notes_TextPart750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_Italic_in_parse_org_emftext_language_notes_TextPart760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_TypeWriter_in_parse_org_emftext_language_notes_TextPart770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_synpred4_Notes372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred6_Notes471 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_notes_BulletPoint_in_synpred6_Notes497 = new BitSet(new long[]{0x0000000000000002L});

}