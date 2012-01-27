// $ANTLR 3.4

	package org.emftext.language.prolog.resource.pl.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PlParser extends PlANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANONYMOUS", "CAPITAL_WORD", "FLOAT", "LINEBREAK", "QUOTED_39_39", "SL_COMMENT", "SMALL_WORD", "WHITESPACE", "'('", "')'", "','", "'.'", "':-'", "'['", "']'", "'is'", "'|'"
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
    public static final int ANONYMOUS=4;
    public static final int CAPITAL_WORD=5;
    public static final int FLOAT=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_39_39=8;
    public static final int SL_COMMENT=9;
    public static final int SMALL_WORD=10;
    public static final int WHITESPACE=11;

    // delegates
    public PlANTLRParserBase[] getDelegates() {
        return new PlANTLRParserBase[] {};
    }

    // delegators


    public PlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(35 + 1);
         

    }

    public String[] getTokenNames() { return PlParser.tokenNames; }
    public String getGrammarFileName() { return "Pl.g"; }


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
    	



    // $ANTLR start "start"
    // Pl.g:530:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_prolog_PrologProgram ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.language.prolog.PrologProgram c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Pl.g:531:2: ( (c0= parse_org_emftext_language_prolog_PrologProgram ) EOF )
            // Pl.g:532:2: (c0= parse_org_emftext_language_prolog_PrologProgram ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Pl.g:538:2: (c0= parse_org_emftext_language_prolog_PrologProgram )
            // Pl.g:539:3: c0= parse_org_emftext_language_prolog_PrologProgram
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_PrologProgram_in_start82);
            c0=parse_org_emftext_language_prolog_PrologProgram();

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



    // $ANTLR start "parse_org_emftext_language_prolog_PrologProgram"
    // Pl.g:547:1: parse_org_emftext_language_prolog_PrologProgram returns [org.emftext.language.prolog.PrologProgram element = null] : ( (a0_0= parse_org_emftext_language_prolog_Clause ) )+ ;
    public final org.emftext.language.prolog.PrologProgram parse_org_emftext_language_prolog_PrologProgram() throws RecognitionException {
        org.emftext.language.prolog.PrologProgram element =  null;

        int parse_org_emftext_language_prolog_PrologProgram_StartIndex = input.index();

        org.emftext.language.prolog.Clause a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Pl.g:550:2: ( ( (a0_0= parse_org_emftext_language_prolog_Clause ) )+ )
            // Pl.g:551:2: ( (a0_0= parse_org_emftext_language_prolog_Clause ) )+
            {
            // Pl.g:551:2: ( (a0_0= parse_org_emftext_language_prolog_Clause ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==QUOTED_39_39||LA1_0==SMALL_WORD) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Pl.g:552:3: (a0_0= parse_org_emftext_language_prolog_Clause )
            	    {
            	    // Pl.g:552:3: (a0_0= parse_org_emftext_language_prolog_Clause )
            	    // Pl.g:553:4: a0_0= parse_org_emftext_language_prolog_Clause
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Clause_in_parse_org_emftext_language_prolog_PrologProgram124);
            	    a0_0=parse_org_emftext_language_prolog_Clause();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[3]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_prolog_PrologProgram_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_PrologProgram"



    // $ANTLR start "parse_org_emftext_language_prolog_Clause"
    // Pl.g:582:1: parse_org_emftext_language_prolog_Clause returns [org.emftext.language.prolog.Clause element = null] : (a0_0= parse_org_emftext_language_prolog_Predicate ) ( (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) ) )? a3= '.' ;
    public final org.emftext.language.prolog.Clause parse_org_emftext_language_prolog_Clause() throws RecognitionException {
        org.emftext.language.prolog.Clause element =  null;

        int parse_org_emftext_language_prolog_Clause_StartIndex = input.index();

        Token a1=null;
        Token a3=null;
        org.emftext.language.prolog.Predicate a0_0 =null;

        org.emftext.language.prolog.Conjunction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Pl.g:585:2: ( (a0_0= parse_org_emftext_language_prolog_Predicate ) ( (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) ) )? a3= '.' )
            // Pl.g:586:2: (a0_0= parse_org_emftext_language_prolog_Predicate ) ( (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) ) )? a3= '.'
            {
            // Pl.g:586:2: (a0_0= parse_org_emftext_language_prolog_Predicate )
            // Pl.g:587:3: a0_0= parse_org_emftext_language_prolog_Predicate
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Clause169);
            a0_0=parse_org_emftext_language_prolog_Predicate();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[5]);
            	}

            // Pl.g:613:2: ( (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Pl.g:614:3: (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) )
                    {
                    // Pl.g:614:3: (a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction ) )
                    // Pl.g:615:4: a1= ':-' (a2_0= parse_org_emftext_language_prolog_Conjunction )
                    {
                    a1=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_prolog_Clause196); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[6]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[7]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[8]);
                    			}

                    // Pl.g:631:4: (a2_0= parse_org_emftext_language_prolog_Conjunction )
                    // Pl.g:632:5: a2_0= parse_org_emftext_language_prolog_Conjunction
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Conjunction_in_parse_org_emftext_language_prolog_Clause222);
                    a2_0=parse_org_emftext_language_prolog_Conjunction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[9]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[10]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_prolog_Clause263); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createClause();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[12]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_prolog_Clause_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Clause"



    // $ANTLR start "parse_org_emftext_language_prolog_Conjunction"
    // Pl.g:681:1: parse_org_emftext_language_prolog_Conjunction returns [org.emftext.language.prolog.Conjunction element = null] : (a0_0= parse_org_emftext_language_prolog_Part ) ( (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) ) )* ;
    public final org.emftext.language.prolog.Conjunction parse_org_emftext_language_prolog_Conjunction() throws RecognitionException {
        org.emftext.language.prolog.Conjunction element =  null;

        int parse_org_emftext_language_prolog_Conjunction_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.prolog.Part a0_0 =null;

        org.emftext.language.prolog.Part a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Pl.g:684:2: ( (a0_0= parse_org_emftext_language_prolog_Part ) ( (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) ) )* )
            // Pl.g:685:2: (a0_0= parse_org_emftext_language_prolog_Part ) ( (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) ) )*
            {
            // Pl.g:685:2: (a0_0= parse_org_emftext_language_prolog_Part )
            // Pl.g:686:3: a0_0= parse_org_emftext_language_prolog_Part
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_Part_in_parse_org_emftext_language_prolog_Conjunction296);
            a0_0=parse_org_emftext_language_prolog_Part();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[14]);
            	}

            // Pl.g:712:2: ( (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Pl.g:713:3: (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) )
            	    {
            	    // Pl.g:713:3: (a1= ',' (a2_0= parse_org_emftext_language_prolog_Part ) )
            	    // Pl.g:714:4: a1= ',' (a2_0= parse_org_emftext_language_prolog_Part )
            	    {
            	    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_prolog_Conjunction323); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createConjunction();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_2_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[15]);
            	    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[16]);
            	    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[17]);
            	    			}

            	    // Pl.g:730:4: (a2_0= parse_org_emftext_language_prolog_Part )
            	    // Pl.g:731:5: a2_0= parse_org_emftext_language_prolog_Part
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Part_in_parse_org_emftext_language_prolog_Conjunction349);
            	    a2_0=parse_org_emftext_language_prolog_Part();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[18]);
            	    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[19]);
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
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[21]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_prolog_Conjunction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Conjunction"



    // $ANTLR start "parse_org_emftext_language_prolog_Predicate"
    // Pl.g:767:1: parse_org_emftext_language_prolog_Predicate returns [org.emftext.language.prolog.Predicate element = null] : (a0_0= parse_org_emftext_language_prolog_Atom ) ( (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' ) )? ;
    public final org.emftext.language.prolog.Predicate parse_org_emftext_language_prolog_Predicate() throws RecognitionException {
        org.emftext.language.prolog.Predicate element =  null;

        int parse_org_emftext_language_prolog_Predicate_StartIndex = input.index();

        Token a1=null;
        Token a3=null;
        Token a5=null;
        org.emftext.language.prolog.Atom a0_0 =null;

        org.emftext.language.prolog.Term a2_0 =null;

        org.emftext.language.prolog.Term a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Pl.g:770:2: ( (a0_0= parse_org_emftext_language_prolog_Atom ) ( (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' ) )? )
            // Pl.g:771:2: (a0_0= parse_org_emftext_language_prolog_Atom ) ( (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' ) )?
            {
            // Pl.g:771:2: (a0_0= parse_org_emftext_language_prolog_Atom )
            // Pl.g:772:3: a0_0= parse_org_emftext_language_prolog_Atom
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_Atom_in_parse_org_emftext_language_prolog_Predicate409);
            a0_0=parse_org_emftext_language_prolog_Atom();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            // Pl.g:805:2: ( (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Pl.g:806:3: (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' )
                    {
                    // Pl.g:806:3: (a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')' )
                    // Pl.g:807:4: a1= '(' (a2_0= parse_org_emftext_language_prolog_Term ) ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )* a5= ')'
                    {
                    a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_prolog_Predicate436); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[31]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[32]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[33]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[34]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[35]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[36]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[37]);
                    			}

                    // Pl.g:827:4: (a2_0= parse_org_emftext_language_prolog_Term )
                    // Pl.g:828:5: a2_0= parse_org_emftext_language_prolog_Term
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Predicate462);
                    a2_0=parse_org_emftext_language_prolog_Term();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[38]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[39]);
                    			}

                    // Pl.g:854:4: ( (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==14) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Pl.g:855:5: (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) )
                    	    {
                    	    // Pl.g:855:5: (a3= ',' (a4_0= parse_org_emftext_language_prolog_Term ) )
                    	    // Pl.g:856:6: a3= ',' (a4_0= parse_org_emftext_language_prolog_Term )
                    	    {
                    	    a3=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_prolog_Predicate503); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[40]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[41]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[42]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[43]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[44]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[45]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[46]);
                    	    					}

                    	    // Pl.g:876:6: (a4_0= parse_org_emftext_language_prolog_Term )
                    	    // Pl.g:877:7: a4_0= parse_org_emftext_language_prolog_Term
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Predicate537);
                    	    a4_0=parse_org_emftext_language_prolog_Term();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[47]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[48]);
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
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[49]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[50]);
                    			}

                    a5=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_prolog_Predicate598); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createPredicate();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_3_0_0_1_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
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

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_prolog_Predicate_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Predicate"



    // $ANTLR start "parse_org_emftext_language_prolog_Numeral"
    // Pl.g:948:1: parse_org_emftext_language_prolog_Numeral returns [org.emftext.language.prolog.Numeral element = null] : (a0= FLOAT ) ;
    public final org.emftext.language.prolog.Numeral parse_org_emftext_language_prolog_Numeral() throws RecognitionException {
        org.emftext.language.prolog.Numeral element =  null;

        int parse_org_emftext_language_prolog_Numeral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Pl.g:951:2: ( (a0= FLOAT ) )
            // Pl.g:952:2: (a0= FLOAT )
            {
            // Pl.g:952:2: (a0= FLOAT )
            // Pl.g:953:3: a0= FLOAT
            {
            a0=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_parse_org_emftext_language_prolog_Numeral650); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[73]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_prolog_Numeral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Numeral"



    // $ANTLR start "parse_org_emftext_language_prolog_Variable"
    // Pl.g:996:1: parse_org_emftext_language_prolog_Variable returns [org.emftext.language.prolog.Variable element = null] : (a0= CAPITAL_WORD ) ;
    public final org.emftext.language.prolog.Variable parse_org_emftext_language_prolog_Variable() throws RecognitionException {
        org.emftext.language.prolog.Variable element =  null;

        int parse_org_emftext_language_prolog_Variable_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Pl.g:999:2: ( (a0= CAPITAL_WORD ) )
            // Pl.g:1000:2: (a0= CAPITAL_WORD )
            {
            // Pl.g:1000:2: (a0= CAPITAL_WORD )
            // Pl.g:1001:3: a0= CAPITAL_WORD
            {
            a0=(Token)match(input,CAPITAL_WORD,FOLLOW_CAPITAL_WORD_in_parse_org_emftext_language_prolog_Variable690); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[80]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_prolog_Variable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Variable"



    // $ANTLR start "parse_org_emftext_language_prolog_AnonymousVariable"
    // Pl.g:1044:1: parse_org_emftext_language_prolog_AnonymousVariable returns [org.emftext.language.prolog.AnonymousVariable element = null] : (a0= ANONYMOUS ) ;
    public final org.emftext.language.prolog.AnonymousVariable parse_org_emftext_language_prolog_AnonymousVariable() throws RecognitionException {
        org.emftext.language.prolog.AnonymousVariable element =  null;

        int parse_org_emftext_language_prolog_AnonymousVariable_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Pl.g:1047:2: ( (a0= ANONYMOUS ) )
            // Pl.g:1048:2: (a0= ANONYMOUS )
            {
            // Pl.g:1048:2: (a0= ANONYMOUS )
            // Pl.g:1049:3: a0= ANONYMOUS
            {
            a0=(Token)match(input,ANONYMOUS,FOLLOW_ANONYMOUS_in_parse_org_emftext_language_prolog_AnonymousVariable730); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[87]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_prolog_AnonymousVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_AnonymousVariable"



    // $ANTLR start "parse_org_emftext_language_prolog_SmallAtom"
    // Pl.g:1092:1: parse_org_emftext_language_prolog_SmallAtom returns [org.emftext.language.prolog.SmallAtom element = null] : (a0= SMALL_WORD ) ;
    public final org.emftext.language.prolog.SmallAtom parse_org_emftext_language_prolog_SmallAtom() throws RecognitionException {
        org.emftext.language.prolog.SmallAtom element =  null;

        int parse_org_emftext_language_prolog_SmallAtom_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Pl.g:1095:2: ( (a0= SMALL_WORD ) )
            // Pl.g:1096:2: (a0= SMALL_WORD )
            {
            // Pl.g:1096:2: (a0= SMALL_WORD )
            // Pl.g:1097:3: a0= SMALL_WORD
            {
            a0=(Token)match(input,SMALL_WORD,FOLLOW_SMALL_WORD_in_parse_org_emftext_language_prolog_SmallAtom770); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[94]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_prolog_SmallAtom_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_SmallAtom"



    // $ANTLR start "parse_org_emftext_language_prolog_String"
    // Pl.g:1140:1: parse_org_emftext_language_prolog_String returns [org.emftext.language.prolog.String element = null] : (a0= QUOTED_39_39 ) ;
    public final org.emftext.language.prolog.String parse_org_emftext_language_prolog_String() throws RecognitionException {
        org.emftext.language.prolog.String element =  null;

        int parse_org_emftext_language_prolog_String_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Pl.g:1143:2: ( (a0= QUOTED_39_39 ) )
            // Pl.g:1144:2: (a0= QUOTED_39_39 )
            {
            // Pl.g:1144:2: (a0= QUOTED_39_39 )
            // Pl.g:1145:3: a0= QUOTED_39_39
            {
            a0=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_parse_org_emftext_language_prolog_String810); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[101]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_prolog_String_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_String"



    // $ANTLR start "parse_org_emftext_language_prolog_VariableReference"
    // Pl.g:1188:1: parse_org_emftext_language_prolog_VariableReference returns [org.emftext.language.prolog.VariableReference element = null] : (a0= CAPITAL_WORD ) ;
    public final org.emftext.language.prolog.VariableReference parse_org_emftext_language_prolog_VariableReference() throws RecognitionException {
        org.emftext.language.prolog.VariableReference element =  null;

        int parse_org_emftext_language_prolog_VariableReference_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Pl.g:1191:2: ( (a0= CAPITAL_WORD ) )
            // Pl.g:1192:2: (a0= CAPITAL_WORD )
            {
            // Pl.g:1192:2: (a0= CAPITAL_WORD )
            // Pl.g:1193:3: a0= CAPITAL_WORD
            {
            a0=(Token)match(input,CAPITAL_WORD,FOLLOW_CAPITAL_WORD_in_parse_org_emftext_language_prolog_VariableReference850); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[107]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_prolog_VariableReference_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_VariableReference"



    // $ANTLR start "parse_org_emftext_language_prolog_List"
    // Pl.g:1239:1: parse_org_emftext_language_prolog_List returns [org.emftext.language.prolog.List element = null] : a0= '[' ( ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? ) )? a6= ']' ;
    public final org.emftext.language.prolog.List parse_org_emftext_language_prolog_List() throws RecognitionException {
        org.emftext.language.prolog.List element =  null;

        int parse_org_emftext_language_prolog_List_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.prolog.Term a1_0 =null;

        org.emftext.language.prolog.Term a3_0 =null;

        org.emftext.language.prolog.Tail a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Pl.g:1242:2: (a0= '[' ( ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? ) )? a6= ']' )
            // Pl.g:1243:2: a0= '[' ( ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? ) )? a6= ']'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_prolog_List886); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
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

            // Pl.g:1264:2: ( ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0 >= ANONYMOUS && LA8_0 <= FLOAT)||LA8_0==QUOTED_39_39||LA8_0==SMALL_WORD||LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Pl.g:1265:3: ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? )
                    {
                    // Pl.g:1265:3: ( (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )? )
                    // Pl.g:1266:4: (a1_0= parse_org_emftext_language_prolog_Term ) ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )* ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )?
                    {
                    // Pl.g:1266:4: (a1_0= parse_org_emftext_language_prolog_Term )
                    // Pl.g:1267:5: a1_0= parse_org_emftext_language_prolog_Term
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_List915);
                    a1_0=parse_org_emftext_language_prolog_Term();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[116]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[117]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[118]);
                    			}

                    // Pl.g:1294:4: ( (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Pl.g:1295:5: (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) )
                    	    {
                    	    // Pl.g:1295:5: (a2= ',' (a3_0= parse_org_emftext_language_prolog_Term ) )
                    	    // Pl.g:1296:6: a2= ',' (a3_0= parse_org_emftext_language_prolog_Term )
                    	    {
                    	    a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_prolog_List956); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[119]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[120]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[121]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[122]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[123]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[124]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[125]);
                    	    					}

                    	    // Pl.g:1316:6: (a3_0= parse_org_emftext_language_prolog_Term )
                    	    // Pl.g:1317:7: a3_0= parse_org_emftext_language_prolog_Term
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_List990);
                    	    a3_0=parse_org_emftext_language_prolog_Term();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[126]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[127]);
                    	    						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[128]);
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
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[129]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[130]);
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[131]);
                    			}

                    // Pl.g:1353:4: ( (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==20) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Pl.g:1354:5: (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) )
                            {
                            // Pl.g:1354:5: (a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail ) )
                            // Pl.g:1355:6: a4= '|' (a5_0= parse_org_emftext_language_prolog_Tail )
                            {
                            a4=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_prolog_List1064); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_1_0_0_2_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            					}

                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[132]);
                            						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[133]);
                            					}

                            // Pl.g:1370:6: (a5_0= parse_org_emftext_language_prolog_Tail )
                            // Pl.g:1371:7: a5_0= parse_org_emftext_language_prolog_Tail
                            {
                            pushFollow(FOLLOW_parse_org_emftext_language_prolog_Tail_in_parse_org_emftext_language_prolog_List1098);
                            a5_0=parse_org_emftext_language_prolog_Tail();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[134]);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[135]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[136]);
            	}

            a6=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_prolog_List1172); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createList();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_10_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[143]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_prolog_List_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_List"



    // $ANTLR start "parse_org_emftext_language_prolog_Assignment"
    // Pl.g:1432:1: parse_org_emftext_language_prolog_Assignment returns [org.emftext.language.prolog.Assignment element = null] : (a0_0= parse_org_emftext_language_prolog_VariableReference ) a1= 'is' (a2_0= parse_org_emftext_language_prolog_Term ) ;
    public final org.emftext.language.prolog.Assignment parse_org_emftext_language_prolog_Assignment() throws RecognitionException {
        org.emftext.language.prolog.Assignment element =  null;

        int parse_org_emftext_language_prolog_Assignment_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.prolog.VariableReference a0_0 =null;

        org.emftext.language.prolog.Term a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Pl.g:1435:2: ( (a0_0= parse_org_emftext_language_prolog_VariableReference ) a1= 'is' (a2_0= parse_org_emftext_language_prolog_Term ) )
            // Pl.g:1436:2: (a0_0= parse_org_emftext_language_prolog_VariableReference ) a1= 'is' (a2_0= parse_org_emftext_language_prolog_Term )
            {
            // Pl.g:1436:2: (a0_0= parse_org_emftext_language_prolog_VariableReference )
            // Pl.g:1437:3: a0_0= parse_org_emftext_language_prolog_VariableReference
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_parse_org_emftext_language_prolog_Assignment1205);
            a0_0=parse_org_emftext_language_prolog_VariableReference();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[144]);
            	}

            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_prolog_Assignment1223); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.prolog.PrologFactory.eINSTANCE.createAssignment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.prolog.resource.pl.grammar.PlGrammarInformationProvider.PL_11_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[151]);
            	}

            // Pl.g:1482:2: (a2_0= parse_org_emftext_language_prolog_Term )
            // Pl.g:1483:3: a2_0= parse_org_emftext_language_prolog_Term
            {
            pushFollow(FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Assignment1241);
            a2_0=parse_org_emftext_language_prolog_Term();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(org.emftext.language.prolog.resource.pl.mopp.PlExpectationConstants.EXPECTATIONS[153]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_prolog_Assignment_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Assignment"



    // $ANTLR start "parse_org_emftext_language_prolog_Part"
    // Pl.g:1511:1: parse_org_emftext_language_prolog_Part returns [org.emftext.language.prolog.Part element = null] : (c0= parse_org_emftext_language_prolog_Predicate |c1= parse_org_emftext_language_prolog_Assignment );
    public final org.emftext.language.prolog.Part parse_org_emftext_language_prolog_Part() throws RecognitionException {
        org.emftext.language.prolog.Part element =  null;

        int parse_org_emftext_language_prolog_Part_StartIndex = input.index();

        org.emftext.language.prolog.Predicate c0 =null;

        org.emftext.language.prolog.Assignment c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Pl.g:1512:2: (c0= parse_org_emftext_language_prolog_Predicate |c1= parse_org_emftext_language_prolog_Assignment )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==QUOTED_39_39||LA9_0==SMALL_WORD) ) {
                alt9=1;
            }
            else if ( (LA9_0==CAPITAL_WORD) ) {
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
                    // Pl.g:1513:2: c0= parse_org_emftext_language_prolog_Predicate
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Part1270);
                    c0=parse_org_emftext_language_prolog_Predicate();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Pl.g:1514:4: c1= parse_org_emftext_language_prolog_Assignment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Assignment_in_parse_org_emftext_language_prolog_Part1280);
                    c1=parse_org_emftext_language_prolog_Assignment();

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
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_prolog_Part_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Part"



    // $ANTLR start "parse_org_emftext_language_prolog_Atom"
    // Pl.g:1518:1: parse_org_emftext_language_prolog_Atom returns [org.emftext.language.prolog.Atom element = null] : (c0= parse_org_emftext_language_prolog_SmallAtom |c1= parse_org_emftext_language_prolog_String );
    public final org.emftext.language.prolog.Atom parse_org_emftext_language_prolog_Atom() throws RecognitionException {
        org.emftext.language.prolog.Atom element =  null;

        int parse_org_emftext_language_prolog_Atom_StartIndex = input.index();

        org.emftext.language.prolog.SmallAtom c0 =null;

        org.emftext.language.prolog.String c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Pl.g:1519:2: (c0= parse_org_emftext_language_prolog_SmallAtom |c1= parse_org_emftext_language_prolog_String )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==SMALL_WORD) ) {
                alt10=1;
            }
            else if ( (LA10_0==QUOTED_39_39) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // Pl.g:1520:2: c0= parse_org_emftext_language_prolog_SmallAtom
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_parse_org_emftext_language_prolog_Atom1301);
                    c0=parse_org_emftext_language_prolog_SmallAtom();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Pl.g:1521:4: c1= parse_org_emftext_language_prolog_String
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_String_in_parse_org_emftext_language_prolog_Atom1311);
                    c1=parse_org_emftext_language_prolog_String();

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
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_prolog_Atom_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Atom"



    // $ANTLR start "parse_org_emftext_language_prolog_Term"
    // Pl.g:1525:1: parse_org_emftext_language_prolog_Term returns [org.emftext.language.prolog.Term element = null] : (c0= parse_org_emftext_language_prolog_Predicate |c1= parse_org_emftext_language_prolog_Numeral |c2= parse_org_emftext_language_prolog_Variable |c3= parse_org_emftext_language_prolog_AnonymousVariable |c4= parse_org_emftext_language_prolog_SmallAtom |c5= parse_org_emftext_language_prolog_String |c6= parse_org_emftext_language_prolog_VariableReference |c7= parse_org_emftext_language_prolog_List );
    public final org.emftext.language.prolog.Term parse_org_emftext_language_prolog_Term() throws RecognitionException {
        org.emftext.language.prolog.Term element =  null;

        int parse_org_emftext_language_prolog_Term_StartIndex = input.index();

        org.emftext.language.prolog.Predicate c0 =null;

        org.emftext.language.prolog.Numeral c1 =null;

        org.emftext.language.prolog.Variable c2 =null;

        org.emftext.language.prolog.AnonymousVariable c3 =null;

        org.emftext.language.prolog.SmallAtom c4 =null;

        org.emftext.language.prolog.String c5 =null;

        org.emftext.language.prolog.VariableReference c6 =null;

        org.emftext.language.prolog.List c7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Pl.g:1526:2: (c0= parse_org_emftext_language_prolog_Predicate |c1= parse_org_emftext_language_prolog_Numeral |c2= parse_org_emftext_language_prolog_Variable |c3= parse_org_emftext_language_prolog_AnonymousVariable |c4= parse_org_emftext_language_prolog_SmallAtom |c5= parse_org_emftext_language_prolog_String |c6= parse_org_emftext_language_prolog_VariableReference |c7= parse_org_emftext_language_prolog_List )
            int alt11=8;
            switch ( input.LA(1) ) {
            case SMALL_WORD:
                {
                int LA11_1 = input.LA(2);

                if ( (synpred11_Pl()) ) {
                    alt11=1;
                }
                else if ( (synpred15_Pl()) ) {
                    alt11=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39:
                {
                int LA11_2 = input.LA(2);

                if ( (synpred11_Pl()) ) {
                    alt11=1;
                }
                else if ( (synpred16_Pl()) ) {
                    alt11=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }
                }
                break;
            case FLOAT:
                {
                alt11=2;
                }
                break;
            case CAPITAL_WORD:
                {
                int LA11_4 = input.LA(2);

                if ( (synpred13_Pl()) ) {
                    alt11=3;
                }
                else if ( (synpred17_Pl()) ) {
                    alt11=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;

                }
                }
                break;
            case ANONYMOUS:
                {
                alt11=4;
                }
                break;
            case 17:
                {
                alt11=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // Pl.g:1527:2: c0= parse_org_emftext_language_prolog_Predicate
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Term1332);
                    c0=parse_org_emftext_language_prolog_Predicate();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Pl.g:1528:4: c1= parse_org_emftext_language_prolog_Numeral
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Numeral_in_parse_org_emftext_language_prolog_Term1342);
                    c1=parse_org_emftext_language_prolog_Numeral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Pl.g:1529:4: c2= parse_org_emftext_language_prolog_Variable
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Variable_in_parse_org_emftext_language_prolog_Term1352);
                    c2=parse_org_emftext_language_prolog_Variable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Pl.g:1530:4: c3= parse_org_emftext_language_prolog_AnonymousVariable
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_AnonymousVariable_in_parse_org_emftext_language_prolog_Term1362);
                    c3=parse_org_emftext_language_prolog_AnonymousVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Pl.g:1531:4: c4= parse_org_emftext_language_prolog_SmallAtom
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_parse_org_emftext_language_prolog_Term1372);
                    c4=parse_org_emftext_language_prolog_SmallAtom();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Pl.g:1532:4: c5= parse_org_emftext_language_prolog_String
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_String_in_parse_org_emftext_language_prolog_Term1382);
                    c5=parse_org_emftext_language_prolog_String();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Pl.g:1533:4: c6= parse_org_emftext_language_prolog_VariableReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_parse_org_emftext_language_prolog_Term1392);
                    c6=parse_org_emftext_language_prolog_VariableReference();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Pl.g:1534:4: c7= parse_org_emftext_language_prolog_List
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_List_in_parse_org_emftext_language_prolog_Term1402);
                    c7=parse_org_emftext_language_prolog_List();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_prolog_Term_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Term"



    // $ANTLR start "parse_org_emftext_language_prolog_Tail"
    // Pl.g:1538:1: parse_org_emftext_language_prolog_Tail returns [org.emftext.language.prolog.Tail element = null] : (c0= parse_org_emftext_language_prolog_Variable |c1= parse_org_emftext_language_prolog_List );
    public final org.emftext.language.prolog.Tail parse_org_emftext_language_prolog_Tail() throws RecognitionException {
        org.emftext.language.prolog.Tail element =  null;

        int parse_org_emftext_language_prolog_Tail_StartIndex = input.index();

        org.emftext.language.prolog.Variable c0 =null;

        org.emftext.language.prolog.List c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Pl.g:1539:2: (c0= parse_org_emftext_language_prolog_Variable |c1= parse_org_emftext_language_prolog_List )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==CAPITAL_WORD) ) {
                alt12=1;
            }
            else if ( (LA12_0==17) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Pl.g:1540:2: c0= parse_org_emftext_language_prolog_Variable
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_Variable_in_parse_org_emftext_language_prolog_Tail1423);
                    c0=parse_org_emftext_language_prolog_Variable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Pl.g:1541:4: c1= parse_org_emftext_language_prolog_List
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_prolog_List_in_parse_org_emftext_language_prolog_Tail1433);
                    c1=parse_org_emftext_language_prolog_List();

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
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_prolog_Tail_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_prolog_Tail"

    // $ANTLR start synpred11_Pl
    public final void synpred11_Pl_fragment() throws RecognitionException {
        org.emftext.language.prolog.Predicate c0 =null;


        // Pl.g:1527:2: (c0= parse_org_emftext_language_prolog_Predicate )
        // Pl.g:1527:2: c0= parse_org_emftext_language_prolog_Predicate
        {
        pushFollow(FOLLOW_parse_org_emftext_language_prolog_Predicate_in_synpred11_Pl1332);
        c0=parse_org_emftext_language_prolog_Predicate();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_Pl

    // $ANTLR start synpred13_Pl
    public final void synpred13_Pl_fragment() throws RecognitionException {
        org.emftext.language.prolog.Variable c2 =null;


        // Pl.g:1529:4: (c2= parse_org_emftext_language_prolog_Variable )
        // Pl.g:1529:4: c2= parse_org_emftext_language_prolog_Variable
        {
        pushFollow(FOLLOW_parse_org_emftext_language_prolog_Variable_in_synpred13_Pl1352);
        c2=parse_org_emftext_language_prolog_Variable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred13_Pl

    // $ANTLR start synpred15_Pl
    public final void synpred15_Pl_fragment() throws RecognitionException {
        org.emftext.language.prolog.SmallAtom c4 =null;


        // Pl.g:1531:4: (c4= parse_org_emftext_language_prolog_SmallAtom )
        // Pl.g:1531:4: c4= parse_org_emftext_language_prolog_SmallAtom
        {
        pushFollow(FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_synpred15_Pl1372);
        c4=parse_org_emftext_language_prolog_SmallAtom();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred15_Pl

    // $ANTLR start synpred16_Pl
    public final void synpred16_Pl_fragment() throws RecognitionException {
        org.emftext.language.prolog.String c5 =null;


        // Pl.g:1532:4: (c5= parse_org_emftext_language_prolog_String )
        // Pl.g:1532:4: c5= parse_org_emftext_language_prolog_String
        {
        pushFollow(FOLLOW_parse_org_emftext_language_prolog_String_in_synpred16_Pl1382);
        c5=parse_org_emftext_language_prolog_String();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred16_Pl

    // $ANTLR start synpred17_Pl
    public final void synpred17_Pl_fragment() throws RecognitionException {
        org.emftext.language.prolog.VariableReference c6 =null;


        // Pl.g:1533:4: (c6= parse_org_emftext_language_prolog_VariableReference )
        // Pl.g:1533:4: c6= parse_org_emftext_language_prolog_VariableReference
        {
        pushFollow(FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_synpred17_Pl1392);
        c6=parse_org_emftext_language_prolog_VariableReference();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred17_Pl

    // Delegated rules

    public final boolean synpred16_Pl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_Pl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Pl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Pl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_Pl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Pl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_Pl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Pl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_Pl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Pl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_PrologProgram_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Clause_in_parse_org_emftext_language_prolog_PrologProgram124 = new BitSet(new long[]{0x0000000000000502L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Clause169 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_prolog_Clause196 = new BitSet(new long[]{0x0000000000000520L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Conjunction_in_parse_org_emftext_language_prolog_Clause222 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_prolog_Clause263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Part_in_parse_org_emftext_language_prolog_Conjunction296 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_prolog_Conjunction323 = new BitSet(new long[]{0x0000000000000520L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Part_in_parse_org_emftext_language_prolog_Conjunction349 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Atom_in_parse_org_emftext_language_prolog_Predicate409 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_prolog_Predicate436 = new BitSet(new long[]{0x0000000000020570L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Predicate462 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_prolog_Predicate503 = new BitSet(new long[]{0x0000000000020570L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Predicate537 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_prolog_Predicate598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_parse_org_emftext_language_prolog_Numeral650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPITAL_WORD_in_parse_org_emftext_language_prolog_Variable690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANONYMOUS_in_parse_org_emftext_language_prolog_AnonymousVariable730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SMALL_WORD_in_parse_org_emftext_language_prolog_SmallAtom770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_parse_org_emftext_language_prolog_String810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPITAL_WORD_in_parse_org_emftext_language_prolog_VariableReference850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_prolog_List886 = new BitSet(new long[]{0x0000000000060570L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_List915 = new BitSet(new long[]{0x0000000000144000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_prolog_List956 = new BitSet(new long[]{0x0000000000020570L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_List990 = new BitSet(new long[]{0x0000000000144000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_prolog_List1064 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Tail_in_parse_org_emftext_language_prolog_List1098 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_prolog_List1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_parse_org_emftext_language_prolog_Assignment1205 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_prolog_Assignment1223 = new BitSet(new long[]{0x0000000000020570L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Term_in_parse_org_emftext_language_prolog_Assignment1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Part1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Assignment_in_parse_org_emftext_language_prolog_Part1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_parse_org_emftext_language_prolog_Atom1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_String_in_parse_org_emftext_language_prolog_Atom1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Predicate_in_parse_org_emftext_language_prolog_Term1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Numeral_in_parse_org_emftext_language_prolog_Term1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Variable_in_parse_org_emftext_language_prolog_Term1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_AnonymousVariable_in_parse_org_emftext_language_prolog_Term1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_parse_org_emftext_language_prolog_Term1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_String_in_parse_org_emftext_language_prolog_Term1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_parse_org_emftext_language_prolog_Term1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_List_in_parse_org_emftext_language_prolog_Term1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Variable_in_parse_org_emftext_language_prolog_Tail1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_List_in_parse_org_emftext_language_prolog_Tail1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Predicate_in_synpred11_Pl1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_Variable_in_synpred13_Pl1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_SmallAtom_in_synpred15_Pl1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_String_in_synpred16_Pl1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_prolog_VariableReference_in_synpred17_Pl1392 = new BitSet(new long[]{0x0000000000000002L});

}