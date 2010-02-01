// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.pl0.resource.pl0.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class Pl0Parser extends Pl0ANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PL0ID", "NUMBER", "REL_OP", "PLUS_MINUS", "MUL_DIV", "SL_COMMENT", "ML_COMMENT", "WHITESPACE", "LINEBREAKS", "'program'", "'PROGRAM'", "'.'", "'const'", "'CONST'", "','", "';'", "'var'", "'VAR'", "'='", "'procedure'", "'PROCEDURE'", "'begin'", "'BEGIN'", "'end'", "'END'", "'call'", "'CALL'", "'while'", "'WHILE'", "'DO'", "'do'", "'if'", "'IF'", "'then'", "'THEN'", "'else'", "'ELSE'", "'odd'", "'ODD'", "':='", "'('", "')'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LINEBREAKS=12;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int ML_COMMENT=10;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int MUL_DIV=8;
    public static final int REL_OP=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int NUMBER=5;
    public static final int WHITESPACE=11;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int PLUS_MINUS=7;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int PL0ID=4;
    public static final int SL_COMMENT=9;

    // delegates
    // delegators


        public Pl0Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Pl0Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[54+1];
             
             
        }
        

    public String[] getTokenNames() { return Pl0Parser.tokenNames; }
    public String getGrammarFileName() { return "D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g"; }


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



    // $ANTLR start "start"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:814:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_pl0_Program ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.pl0.Program c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:815:1: ( (c0= parse_org_emftext_language_pl0_Program ) EOF )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:816:2: (c0= parse_org_emftext_language_pl0_Program ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_0, 0));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_1, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:822:2: (c0= parse_org_emftext_language_pl0_Program )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:823:3: c0= parse_org_emftext_language_pl0_Program
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Program_in_start82);
            c0=parse_org_emftext_language_pl0_Program();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

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


    // $ANTLR start "parse_org_emftext_language_pl0_Program"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:828:1: parse_org_emftext_language_pl0_Program returns [org.emftext.language.pl0.Program element = null] : (a0= 'program' | a1= 'PROGRAM' ) (a2= PL0ID ) (a3_0= parse_org_emftext_language_pl0_Block ) a4= '.' ;
    public final org.emftext.language.pl0.Program parse_org_emftext_language_pl0_Program() throws RecognitionException {
        org.emftext.language.pl0.Program element =  null;
        int parse_org_emftext_language_pl0_Program_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.language.pl0.Block a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:831:1: ( (a0= 'program' | a1= 'PROGRAM' ) (a2= PL0ID ) (a3_0= parse_org_emftext_language_pl0_Block ) a4= '.' )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:832:2: (a0= 'program' | a1= 'PROGRAM' ) (a2= PL0ID ) (a3_0= parse_org_emftext_language_pl0_Block ) a4= '.'
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:832:2: (a0= 'program' | a1= 'PROGRAM' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:833:3: a0= 'program'
                    {
                    a0=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_pl0_Program116); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 1));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:846:6: a1= 'PROGRAM'
                    {
                    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_pl0_Program139); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 2));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_2, 3));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:864:2: (a2= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:865:3: a2= PL0ID
            {
            a2=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_Program167); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:904:2: (a3_0= parse_org_emftext_language_pl0_Block )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:905:3: a3_0= parse_org_emftext_language_pl0_Block
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Block_in_parse_org_emftext_language_pl0_Program192);
            a3_0=parse_org_emftext_language_pl0_Block();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 5));
              	
            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_pl0_Program210); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProgram();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_pl0_Program_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Program"


    // $ANTLR start "parse_org_emftext_language_pl0_Block"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:939:1: parse_org_emftext_language_pl0_Block returns [org.emftext.language.pl0.Block element = null] : ( ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' ) )? ( ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' ) )? ( (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration ) )* (a13_0= parse_org_emftext_language_pl0_Body ) ;
    public final org.emftext.language.pl0.Block parse_org_emftext_language_pl0_Block() throws RecognitionException {
        org.emftext.language.pl0.Block element =  null;
        int parse_org_emftext_language_pl0_Block_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a11=null;
        org.emftext.language.pl0.ConstDeclaration a2_0 = null;

        org.emftext.language.pl0.ConstDeclaration a4_0 = null;

        org.emftext.language.pl0.VarDeclaration a8_0 = null;

        org.emftext.language.pl0.VarDeclaration a10_0 = null;

        org.emftext.language.pl0.ProcedureDeclaration a12_0 = null;

        org.emftext.language.pl0.Body a13_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:942:1: ( ( ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' ) )? ( ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' ) )? ( (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration ) )* (a13_0= parse_org_emftext_language_pl0_Body ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:943:2: ( ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' ) )? ( ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' ) )? ( (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration ) )* (a13_0= parse_org_emftext_language_pl0_Body )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:943:2: ( ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=16 && LA4_0<=17)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:944:3: ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:944:3: ( (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';' )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:945:4: (a0= 'const' | a1= 'CONST' ) (a2_0= parse_org_emftext_language_pl0_ConstDeclaration ) ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )* a5= ';'
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:945:4: (a0= 'const' | a1= 'CONST' )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==16) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==17) ) {
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
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:946:5: a0= 'const'
                            {
                            a0=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_pl0_Block254); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 7));
                              				
                            }

                            }
                            break;
                        case 2 :
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:959:10: a1= 'CONST'
                            {
                            a1=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_pl0_Block287); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 8));
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 9));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:977:4: (a2_0= parse_org_emftext_language_pl0_ConstDeclaration )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:978:5: a2_0= parse_org_emftext_language_pl0_ConstDeclaration
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_ConstDeclaration_in_parse_org_emftext_language_pl0_Block329);
                    a2_0=parse_org_emftext_language_pl0_ConstDeclaration();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 10));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 10));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1000:4: ( (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==18) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1001:5: (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) )
                    	    {
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1001:5: (a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration ) )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1002:6: a3= ',' (a4_0= parse_org_emftext_language_pl0_ConstDeclaration )
                    	    {
                    	    a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_pl0_Block370); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_12, 11));
                    	      					
                    	    }
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1014:6: (a4_0= parse_org_emftext_language_pl0_ConstDeclaration )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1015:7: a4_0= parse_org_emftext_language_pl0_ConstDeclaration
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_ConstDeclaration_in_parse_org_emftext_language_pl0_Block404);
                    	    a4_0=parse_org_emftext_language_pl0_ConstDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 12));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 12));
                    	      					
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
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 13));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 13));
                      			
                    }
                    a5=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_pl0_Block465); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 14));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 14));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 14));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 14));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 14));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 14));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_5, 15));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_6, 15));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 15));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 15));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 15));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 15));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1074:2: ( ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=20 && LA7_0<=21)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1075:3: ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1075:3: ( (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';' )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1076:4: (a6= 'var' | a7= 'VAR' ) (a8_0= parse_org_emftext_language_pl0_VarDeclaration ) ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )* a11= ';'
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1076:4: (a6= 'var' | a7= 'VAR' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==20) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==21) ) {
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
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1077:5: a6= 'var'
                            {
                            a6=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_pl0_Block513); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 16));
                              				
                            }

                            }
                            break;
                        case 2 :
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1090:10: a7= 'VAR'
                            {
                            a7=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_pl0_Block546); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 17));
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 18));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1108:4: (a8_0= parse_org_emftext_language_pl0_VarDeclaration )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1109:5: a8_0= parse_org_emftext_language_pl0_VarDeclaration
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_VarDeclaration_in_parse_org_emftext_language_pl0_Block588);
                    a8_0=parse_org_emftext_language_pl0_VarDeclaration();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 19));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 19));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1131:4: ( (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==18) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1132:5: (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) )
                    	    {
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1132:5: (a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration ) )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1133:6: a9= ',' (a10_0= parse_org_emftext_language_pl0_VarDeclaration )
                    	    {
                    	    a9=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_pl0_Block629); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_15, 20));
                    	      					
                    	    }
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1145:6: (a10_0= parse_org_emftext_language_pl0_VarDeclaration )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1146:7: a10_0= parse_org_emftext_language_pl0_VarDeclaration
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_VarDeclaration_in_parse_org_emftext_language_pl0_Block663);
                    	    a10_0=parse_org_emftext_language_pl0_VarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 21));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 21));
                    	      					
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
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 22));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 22));
                      			
                    }
                    a11=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_pl0_Block724); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBlock();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 23));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 23));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 23));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 23));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 24));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 24));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 24));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 24));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1201:2: ( (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=23 && LA8_0<=24)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1202:3: (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration )
            	    {
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1202:3: (a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration )
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1203:4: a12_0= parse_org_emftext_language_pl0_ProcedureDeclaration
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_ProcedureDeclaration_in_parse_org_emftext_language_pl0_Block766);
            	    a12_0=parse_org_emftext_language_pl0_ProcedureDeclaration();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 25));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 25));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 25));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 25));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1228:2: (a13_0= parse_org_emftext_language_pl0_Body )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1229:3: a13_0= parse_org_emftext_language_pl0_Body
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_Block796);
            a13_0=parse_org_emftext_language_pl0_Body();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 26));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 26));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_pl0_Block_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Block"


    // $ANTLR start "parse_org_emftext_language_pl0_ConstDeclaration"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1253:1: parse_org_emftext_language_pl0_ConstDeclaration returns [org.emftext.language.pl0.ConstDeclaration element = null] : (a0= PL0ID ) a1= '=' (a2= NUMBER ) ;
    public final org.emftext.language.pl0.ConstDeclaration parse_org_emftext_language_pl0_ConstDeclaration() throws RecognitionException {
        org.emftext.language.pl0.ConstDeclaration element =  null;
        int parse_org_emftext_language_pl0_ConstDeclaration_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1256:1: ( (a0= PL0ID ) a1= '=' (a2= NUMBER ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1257:2: (a0= PL0ID ) a1= '=' (a2= NUMBER )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1257:2: (a0= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1258:3: a0= PL0ID
            {
            a0=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_ConstDeclaration833); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_19, 27));
              	
            }
            a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_pl0_ConstDeclaration854); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createConstDeclaration();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_20, 28));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1302:2: (a2= NUMBER )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1303:3: a2= NUMBER
            {
            a2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_pl0_ConstDeclaration872); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_13, 29));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_14, 29));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_pl0_ConstDeclaration_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_ConstDeclaration"


    // $ANTLR start "parse_org_emftext_language_pl0_VarDeclaration"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1338:1: parse_org_emftext_language_pl0_VarDeclaration returns [org.emftext.language.pl0.VarDeclaration element = null] : (a0= PL0ID ) ;
    public final org.emftext.language.pl0.VarDeclaration parse_org_emftext_language_pl0_VarDeclaration() throws RecognitionException {
        org.emftext.language.pl0.VarDeclaration element =  null;
        int parse_org_emftext_language_pl0_VarDeclaration_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1341:1: ( (a0= PL0ID ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1342:2: (a0= PL0ID )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1342:2: (a0= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1343:3: a0= PL0ID
            {
            a0=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_VarDeclaration912); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_16, 30));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_17, 30));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_pl0_VarDeclaration_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_VarDeclaration"


    // $ANTLR start "parse_org_emftext_language_pl0_ProcedureDeclaration"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1378:1: parse_org_emftext_language_pl0_ProcedureDeclaration returns [org.emftext.language.pl0.ProcedureDeclaration element = null] : (a0= 'procedure' | a1= 'PROCEDURE' ) (a2= PL0ID ) a3= ';' (a4_0= parse_org_emftext_language_pl0_Block ) a5= ';' ;
    public final org.emftext.language.pl0.ProcedureDeclaration parse_org_emftext_language_pl0_ProcedureDeclaration() throws RecognitionException {
        org.emftext.language.pl0.ProcedureDeclaration element =  null;
        int parse_org_emftext_language_pl0_ProcedureDeclaration_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        org.emftext.language.pl0.Block a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1381:1: ( (a0= 'procedure' | a1= 'PROCEDURE' ) (a2= PL0ID ) a3= ';' (a4_0= parse_org_emftext_language_pl0_Block ) a5= ';' )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1382:2: (a0= 'procedure' | a1= 'PROCEDURE' ) (a2= PL0ID ) a3= ';' (a4_0= parse_org_emftext_language_pl0_Block ) a5= ';'
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1382:2: (a0= 'procedure' | a1= 'PROCEDURE' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
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
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1383:3: a0= 'procedure'
                    {
                    a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_pl0_ProcedureDeclaration952); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 31));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1396:6: a1= 'PROCEDURE'
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_pl0_ProcedureDeclaration975); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 32));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_21, 33));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1414:2: (a2= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1415:3: a2= PL0ID
            {
            a2=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_ProcedureDeclaration1003); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_22, 34));
              	
            }
            a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_pl0_ProcedureDeclaration1024); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1466:2: (a4_0= parse_org_emftext_language_pl0_Block )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1467:3: a4_0= parse_org_emftext_language_pl0_Block
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Block_in_parse_org_emftext_language_pl0_ProcedureDeclaration1042);
            a4_0=parse_org_emftext_language_pl0_Block();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 36));
              	
            }
            a5=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_pl0_ProcedureDeclaration1060); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createProcedureDeclaration();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_7, 37));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_8, 37));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 37));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 37));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_pl0_ProcedureDeclaration_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_ProcedureDeclaration"


    // $ANTLR start "parse_org_emftext_language_pl0_Body"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1505:1: parse_org_emftext_language_pl0_Body returns [org.emftext.language.pl0.Body element = null] : (a0= 'begin' | a1= 'BEGIN' ) ( ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* ) )? (a5= 'end' | a6= 'END' ) ;
    public final org.emftext.language.pl0.Body parse_org_emftext_language_pl0_Body() throws RecognitionException {
        org.emftext.language.pl0.Body element =  null;
        int parse_org_emftext_language_pl0_Body_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        org.emftext.language.pl0.Statement a2_0 = null;

        org.emftext.language.pl0.Statement a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1508:1: ( (a0= 'begin' | a1= 'BEGIN' ) ( ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* ) )? (a5= 'end' | a6= 'END' ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1509:2: (a0= 'begin' | a1= 'BEGIN' ) ( ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* ) )? (a5= 'end' | a6= 'END' )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1509:2: (a0= 'begin' | a1= 'BEGIN' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            else if ( (LA10_0==26) ) {
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
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1510:3: a0= 'begin'
                    {
                    a0=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_pl0_Body1093); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

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

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1531:6: a1= 'BEGIN'
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_pl0_Body1116); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

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

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1565:2: ( ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==PL0ID||(LA12_0>=29 && LA12_0<=32)||(LA12_0>=35 && LA12_0<=36)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1566:3: ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1566:3: ( (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )* )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1567:4: (a2_0= parse_org_emftext_language_pl0_Statement ) ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )*
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1567:4: (a2_0= parse_org_emftext_language_pl0_Statement )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1568:5: a2_0= parse_org_emftext_language_pl0_Statement
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_Statement_in_parse_org_emftext_language_pl0_Body1155);
                    a2_0=parse_org_emftext_language_pl0_Statement();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 41));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 41));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 41));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1591:4: ( (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1592:5: (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) )
                    	    {
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1592:5: (a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement ) )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1593:6: a3= ';' (a4_0= parse_org_emftext_language_pl0_Statement )
                    	    {
                    	    a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_pl0_Body1196); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_23, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_24, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_25, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_26, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_27, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_28, 42));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_29, 42));
                    	      					
                    	    }
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1611:6: (a4_0= parse_org_emftext_language_pl0_Statement )
                    	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1612:7: a4_0= parse_org_emftext_language_pl0_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_Statement_in_parse_org_emftext_language_pl0_Body1230);
                    	    a4_0=parse_org_emftext_language_pl0_Statement();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 43));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 43));
                    	      						addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 43));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 44));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 44));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 44));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 45));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 45));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1652:2: (a5= 'end' | a6= 'END' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            else if ( (LA13_0==28) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1653:3: a5= 'end'
                    {
                    a5=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_pl0_Body1308); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 46));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 46));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1672:6: a6= 'END'
                    {
                    a6=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_pl0_Body1331); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createBody();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 47));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 47));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_11, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_18, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 48));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 48));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_pl0_Body_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Body"


    // $ANTLR start "parse_org_emftext_language_pl0_CallStatement"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1704:1: parse_org_emftext_language_pl0_CallStatement returns [org.emftext.language.pl0.CallStatement element = null] : (a0= 'call' | a1= 'CALL' ) (a2= PL0ID ) ;
    public final org.emftext.language.pl0.CallStatement parse_org_emftext_language_pl0_CallStatement() throws RecognitionException {
        org.emftext.language.pl0.CallStatement element =  null;
        int parse_org_emftext_language_pl0_CallStatement_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1707:1: ( (a0= 'call' | a1= 'CALL' ) (a2= PL0ID ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1708:2: (a0= 'call' | a1= 'CALL' ) (a2= PL0ID )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1708:2: (a0= 'call' | a1= 'CALL' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            else if ( (LA14_0==30) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1709:3: a0= 'call'
                    {
                    a0=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_pl0_CallStatement1374); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createCallStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 49));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1722:6: a1= 'CALL'
                    {
                    a1=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_pl0_CallStatement1397); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createCallStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 50));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_35, 51));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1740:2: (a2= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1741:3: a2= PL0ID
            {
            a2=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_CallStatement1425); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 52));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 52));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 52));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_pl0_CallStatement_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_CallStatement"


    // $ANTLR start "parse_org_emftext_language_pl0_WhileStatement"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1781:1: parse_org_emftext_language_pl0_WhileStatement returns [org.emftext.language.pl0.WhileStatement element = null] : (a0= 'while' | a1= 'WHILE' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'DO' | a4= 'do' ) (a5_0= parse_org_emftext_language_pl0_Body ) ;
    public final org.emftext.language.pl0.WhileStatement parse_org_emftext_language_pl0_WhileStatement() throws RecognitionException {
        org.emftext.language.pl0.WhileStatement element =  null;
        int parse_org_emftext_language_pl0_WhileStatement_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        org.emftext.language.pl0.Condition a2_0 = null;

        org.emftext.language.pl0.Body a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1784:1: ( (a0= 'while' | a1= 'WHILE' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'DO' | a4= 'do' ) (a5_0= parse_org_emftext_language_pl0_Body ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1785:2: (a0= 'while' | a1= 'WHILE' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'DO' | a4= 'do' ) (a5_0= parse_org_emftext_language_pl0_Body )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1785:2: (a0= 'while' | a1= 'WHILE' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1786:3: a0= 'while'
                    {
                    a0=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_language_pl0_WhileStatement1465); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 53));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 53));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 53));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 53));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 53));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 53));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1804:6: a1= 'WHILE'
                    {
                    a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_language_pl0_WhileStatement1488); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 54));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 54));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 54));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 54));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 54));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 54));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 55));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 55));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 55));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 55));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 55));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 55));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1832:2: (a2_0= parse_org_emftext_language_pl0_Condition )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1833:3: a2_0= parse_org_emftext_language_pl0_Condition
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Condition_in_parse_org_emftext_language_pl0_WhileStatement1516);
            a2_0=parse_org_emftext_language_pl0_Condition();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 56));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 56));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1855:2: (a3= 'DO' | a4= 'do' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==33) ) {
                alt16=1;
            }
            else if ( (LA16_0==34) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1856:3: a3= 'DO'
                    {
                    a3=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_language_pl0_WhileStatement1538); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 57));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 57));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1870:6: a4= 'do'
                    {
                    a4=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_language_pl0_WhileStatement1561); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createWhileStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 58));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 58));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 59));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 59));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1890:2: (a5_0= parse_org_emftext_language_pl0_Body )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1891:3: a5_0= parse_org_emftext_language_pl0_Body
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_WhileStatement1589);
            a5_0=parse_org_emftext_language_pl0_Body();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 60));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 60));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 60));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_pl0_WhileStatement_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_WhileStatement"


    // $ANTLR start "parse_org_emftext_language_pl0_IfStatement"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1916:1: parse_org_emftext_language_pl0_IfStatement returns [org.emftext.language.pl0.IfStatement element = null] : (a0= 'if' | a1= 'IF' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'then' | a4= 'THEN' ) (a5_0= parse_org_emftext_language_pl0_Body ) ( ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) ) )? ;
    public final org.emftext.language.pl0.IfStatement parse_org_emftext_language_pl0_IfStatement() throws RecognitionException {
        org.emftext.language.pl0.IfStatement element =  null;
        int parse_org_emftext_language_pl0_IfStatement_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        org.emftext.language.pl0.Condition a2_0 = null;

        org.emftext.language.pl0.Body a5_0 = null;

        org.emftext.language.pl0.Body a8_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1919:1: ( (a0= 'if' | a1= 'IF' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'then' | a4= 'THEN' ) (a5_0= parse_org_emftext_language_pl0_Body ) ( ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) ) )? )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1920:2: (a0= 'if' | a1= 'IF' ) (a2_0= parse_org_emftext_language_pl0_Condition ) (a3= 'then' | a4= 'THEN' ) (a5_0= parse_org_emftext_language_pl0_Body ) ( ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) ) )?
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1920:2: (a0= 'if' | a1= 'IF' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            else if ( (LA17_0==36) ) {
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
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1921:3: a0= 'if'
                    {
                    a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_language_pl0_IfStatement1626); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 61));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 61));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 61));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 61));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 61));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 61));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1939:6: a1= 'IF'
                    {
                    a1=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_pl0_IfStatement1649); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 62));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 62));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 62));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 62));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 62));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 62));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_36, 63));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_37, 63));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 63));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 63));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 63));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 63));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1967:2: (a2_0= parse_org_emftext_language_pl0_Condition )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1968:3: a2_0= parse_org_emftext_language_pl0_Condition
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Condition_in_parse_org_emftext_language_pl0_IfStatement1677);
            a2_0=parse_org_emftext_language_pl0_Condition();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 64));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 64));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1990:2: (a3= 'then' | a4= 'THEN' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            else if ( (LA18_0==38) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:1991:3: a3= 'then'
                    {
                    a3=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_language_pl0_IfStatement1699); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 65));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 65));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2005:6: a4= 'THEN'
                    {
                    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_language_pl0_IfStatement1722); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 66));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 66));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 67));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 67));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2025:2: (a5_0= parse_org_emftext_language_pl0_Body )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2026:3: a5_0= parse_org_emftext_language_pl0_Body
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_IfStatement1750);
            a5_0=parse_org_emftext_language_pl0_Body();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_33, 68));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_34, 68));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 68));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 68));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 68));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2051:2: ( ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=39 && LA20_0<=40)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2052:3: ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2052:3: ( (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body ) )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2053:4: (a6= 'else' | a7= 'ELSE' ) (a8_0= parse_org_emftext_language_pl0_Body )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2053:4: (a6= 'else' | a7= 'ELSE' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==39) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==40) ) {
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
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2054:5: a6= 'else'
                            {
                            a6=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_language_pl0_IfStatement1783); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 69));
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 69));
                              				
                            }

                            }
                            break;
                        case 2 :
                            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2068:10: a7= 'ELSE'
                            {
                            a7=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_language_pl0_IfStatement1816); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createIfStatement();
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					// expected elements (follow set)
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 70));
                              					addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 70));
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_9, 71));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_10, 71));
                      			
                    }
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2088:4: (a8_0= parse_org_emftext_language_pl0_Body )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2089:5: a8_0= parse_org_emftext_language_pl0_Body
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_IfStatement1858);
                    a8_0=parse_org_emftext_language_pl0_Body();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 72));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 72));
                      				addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 72));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 73));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 73));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 73));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_pl0_IfStatement_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_IfStatement"


    // $ANTLR start "parse_org_emftext_language_pl0_OddCondition"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2123:1: parse_org_emftext_language_pl0_OddCondition returns [org.emftext.language.pl0.OddCondition element = null] : (a0= 'odd' | a1= 'ODD' ) (a2_0= parse_org_emftext_language_pl0_Expression ) ;
    public final org.emftext.language.pl0.OddCondition parse_org_emftext_language_pl0_OddCondition() throws RecognitionException {
        org.emftext.language.pl0.OddCondition element =  null;
        int parse_org_emftext_language_pl0_OddCondition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.pl0.Expression a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2126:1: ( (a0= 'odd' | a1= 'ODD' ) (a2_0= parse_org_emftext_language_pl0_Expression ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2127:2: (a0= 'odd' | a1= 'ODD' ) (a2_0= parse_org_emftext_language_pl0_Expression )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2127:2: (a0= 'odd' | a1= 'ODD' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            else if ( (LA21_0==42) ) {
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
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2128:3: a0= 'odd'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_language_pl0_OddCondition1918); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOddCondition();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 74));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 74));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 74));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 74));
                      		
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2144:6: a1= 'ODD'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_language_pl0_OddCondition1941); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createOddCondition();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 75));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 75));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 75));
                      			addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 75));
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 76));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 76));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 76));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 76));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2168:2: (a2_0= parse_org_emftext_language_pl0_Expression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2169:3: a2_0= parse_org_emftext_language_pl0_Expression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_OddCondition1969);
            a2_0=parse_org_emftext_language_pl0_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 77));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 77));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 77));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 77));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_pl0_OddCondition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_OddCondition"


    // $ANTLR start "parse_org_emftext_language_pl0_RelationalCondition"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2195:1: parse_org_emftext_language_pl0_RelationalCondition returns [org.emftext.language.pl0.RelationalCondition element = null] : (a0_0= parse_org_emftext_language_pl0_Expression ) (a1= REL_OP ) (a2_0= parse_org_emftext_language_pl0_Expression ) ;
    public final org.emftext.language.pl0.RelationalCondition parse_org_emftext_language_pl0_RelationalCondition() throws RecognitionException {
        org.emftext.language.pl0.RelationalCondition element =  null;
        int parse_org_emftext_language_pl0_RelationalCondition_StartIndex = input.index();
        Token a1=null;
        org.emftext.language.pl0.Expression a0_0 = null;

        org.emftext.language.pl0.Expression a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2198:1: ( (a0_0= parse_org_emftext_language_pl0_Expression ) (a1= REL_OP ) (a2_0= parse_org_emftext_language_pl0_Expression ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2199:2: (a0_0= parse_org_emftext_language_pl0_Expression ) (a1= REL_OP ) (a2_0= parse_org_emftext_language_pl0_Expression )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2199:2: (a0_0= parse_org_emftext_language_pl0_Expression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2200:3: a0_0= parse_org_emftext_language_pl0_Expression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_RelationalCondition2006);
            a0_0=parse_org_emftext_language_pl0_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_46, 78));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2221:2: (a1= REL_OP )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2222:3: a1= REL_OP
            {
            a1=(Token)match(input,REL_OP,FOLLOW_REL_OP_in_parse_org_emftext_language_pl0_RelationalCondition2028); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 79));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 79));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 79));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 79));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2257:2: (a2_0= parse_org_emftext_language_pl0_Expression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2258:3: a2_0= parse_org_emftext_language_pl0_Expression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_RelationalCondition2053);
            a2_0=parse_org_emftext_language_pl0_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_42, 80));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_43, 80));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_44, 80));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_45, 80));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_pl0_RelationalCondition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_RelationalCondition"


    // $ANTLR start "parse_org_emftext_language_pl0_Assignment"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2284:1: parse_org_emftext_language_pl0_Assignment returns [org.emftext.language.pl0.Assignment element = null] : (a0= PL0ID ) a1= ':=' (a2_0= parse_org_emftext_language_pl0_Expression ) ;
    public final org.emftext.language.pl0.Assignment parse_org_emftext_language_pl0_Assignment() throws RecognitionException {
        org.emftext.language.pl0.Assignment element =  null;
        int parse_org_emftext_language_pl0_Assignment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.pl0.Expression a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2287:1: ( (a0= PL0ID ) a1= ':=' (a2_0= parse_org_emftext_language_pl0_Expression ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2288:2: (a0= PL0ID ) a1= ':=' (a2_0= parse_org_emftext_language_pl0_Expression )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2288:2: (a0= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2289:3: a0= PL0ID
            {
            a0=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_Assignment2090); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_47, 81));
              	
            }
            a1=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_language_pl0_Assignment2111); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createAssignment();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 82));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 82));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 82));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 82));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2340:2: (a2_0= parse_org_emftext_language_pl0_Expression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2341:3: a2_0= parse_org_emftext_language_pl0_Expression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_Assignment2129);
            a2_0=parse_org_emftext_language_pl0_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_32, 83));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_30, 83));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_31, 83));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_pl0_Assignment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Assignment"


    // $ANTLR start "parse_org_emftext_language_pl0_TermExpression"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2366:1: parse_org_emftext_language_pl0_TermExpression returns [org.emftext.language.pl0.TermExpression element = null] : ( (a0= PLUS_MINUS ) )? (a1_0= parse_org_emftext_language_pl0_Term ) ( (a2_0= parse_org_emftext_language_pl0_OptionalTerm ) )* ;
    public final org.emftext.language.pl0.TermExpression parse_org_emftext_language_pl0_TermExpression() throws RecognitionException {
        org.emftext.language.pl0.TermExpression element =  null;
        int parse_org_emftext_language_pl0_TermExpression_StartIndex = input.index();
        Token a0=null;
        org.emftext.language.pl0.Term a1_0 = null;

        org.emftext.language.pl0.OptionalTerm a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2369:1: ( ( (a0= PLUS_MINUS ) )? (a1_0= parse_org_emftext_language_pl0_Term ) ( (a2_0= parse_org_emftext_language_pl0_OptionalTerm ) )* )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2370:2: ( (a0= PLUS_MINUS ) )? (a1_0= parse_org_emftext_language_pl0_Term ) ( (a2_0= parse_org_emftext_language_pl0_OptionalTerm ) )*
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2370:2: ( (a0= PLUS_MINUS ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==PLUS_MINUS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2371:3: (a0= PLUS_MINUS )
                    {
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2371:3: (a0= PLUS_MINUS )
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2372:4: a0= PLUS_MINUS
                    {
                    a0=(Token)match(input,PLUS_MINUS,FOLLOW_PLUS_MINUS_in_parse_org_emftext_language_pl0_TermExpression2171); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 84));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 84));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 84));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2407:2: (a1_0= parse_org_emftext_language_pl0_Term )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2408:3: a1_0= parse_org_emftext_language_pl0_Term
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Term_in_parse_org_emftext_language_pl0_TermExpression2205);
            a1_0=parse_org_emftext_language_pl0_Term();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2438:2: ( (a2_0= parse_org_emftext_language_pl0_OptionalTerm ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==PLUS_MINUS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2439:3: (a2_0= parse_org_emftext_language_pl0_OptionalTerm )
            	    {
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2439:3: (a2_0= parse_org_emftext_language_pl0_OptionalTerm )
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2440:4: a2_0= parse_org_emftext_language_pl0_OptionalTerm
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_OptionalTerm_in_parse_org_emftext_language_pl0_TermExpression2232);
            	    a2_0=parse_org_emftext_language_pl0_OptionalTerm();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_pl0_TermExpression_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_TermExpression"


    // $ANTLR start "parse_org_emftext_language_pl0_OptionalTerm"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2473:1: parse_org_emftext_language_pl0_OptionalTerm returns [org.emftext.language.pl0.OptionalTerm element = null] : (a0= PLUS_MINUS ) (a1_0= parse_org_emftext_language_pl0_Term ) ;
    public final org.emftext.language.pl0.OptionalTerm parse_org_emftext_language_pl0_OptionalTerm() throws RecognitionException {
        org.emftext.language.pl0.OptionalTerm element =  null;
        int parse_org_emftext_language_pl0_OptionalTerm_StartIndex = input.index();
        Token a0=null;
        org.emftext.language.pl0.Term a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2476:1: ( (a0= PLUS_MINUS ) (a1_0= parse_org_emftext_language_pl0_Term ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2477:2: (a0= PLUS_MINUS ) (a1_0= parse_org_emftext_language_pl0_Term )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2477:2: (a0= PLUS_MINUS )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2478:3: a0= PLUS_MINUS
            {
            a0=(Token)match(input,PLUS_MINUS,FOLLOW_PLUS_MINUS_in_parse_org_emftext_language_pl0_OptionalTerm2277); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 87));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 87));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 87));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2512:2: (a1_0= parse_org_emftext_language_pl0_Term )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2513:3: a1_0= parse_org_emftext_language_pl0_Term
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Term_in_parse_org_emftext_language_pl0_OptionalTerm2302);
            a1_0=parse_org_emftext_language_pl0_Term();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_pl0_OptionalTerm_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_OptionalTerm"


    // $ANTLR start "parse_org_emftext_language_pl0_Term"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2545:1: parse_org_emftext_language_pl0_Term returns [org.emftext.language.pl0.Term element = null] : (a0_0= parse_org_emftext_language_pl0_Factor ) ( (a1_0= parse_org_emftext_language_pl0_OptionalFactor ) )* ;
    public final org.emftext.language.pl0.Term parse_org_emftext_language_pl0_Term() throws RecognitionException {
        org.emftext.language.pl0.Term element =  null;
        int parse_org_emftext_language_pl0_Term_StartIndex = input.index();
        org.emftext.language.pl0.Factor a0_0 = null;

        org.emftext.language.pl0.OptionalFactor a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2548:1: ( (a0_0= parse_org_emftext_language_pl0_Factor ) ( (a1_0= parse_org_emftext_language_pl0_OptionalFactor ) )* )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2549:2: (a0_0= parse_org_emftext_language_pl0_Factor ) ( (a1_0= parse_org_emftext_language_pl0_OptionalFactor ) )*
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2549:2: (a0_0= parse_org_emftext_language_pl0_Factor )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2550:3: a0_0= parse_org_emftext_language_pl0_Factor
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Factor_in_parse_org_emftext_language_pl0_Term2339);
            a0_0=parse_org_emftext_language_pl0_Factor();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2581:2: ( (a1_0= parse_org_emftext_language_pl0_OptionalFactor ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==MUL_DIV) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2582:3: (a1_0= parse_org_emftext_language_pl0_OptionalFactor )
            	    {
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2582:3: (a1_0= parse_org_emftext_language_pl0_OptionalFactor )
            	    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2583:4: a1_0= parse_org_emftext_language_pl0_OptionalFactor
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_pl0_OptionalFactor_in_parse_org_emftext_language_pl0_Term2366);
            	    a1_0=parse_org_emftext_language_pl0_OptionalFactor();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_pl0_Term_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Term"


    // $ANTLR start "parse_org_emftext_language_pl0_OptionalFactor"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2617:1: parse_org_emftext_language_pl0_OptionalFactor returns [org.emftext.language.pl0.OptionalFactor element = null] : (a0= MUL_DIV ) (a1_0= parse_org_emftext_language_pl0_Factor ) ;
    public final org.emftext.language.pl0.OptionalFactor parse_org_emftext_language_pl0_OptionalFactor() throws RecognitionException {
        org.emftext.language.pl0.OptionalFactor element =  null;
        int parse_org_emftext_language_pl0_OptionalFactor_StartIndex = input.index();
        Token a0=null;
        org.emftext.language.pl0.Factor a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2620:1: ( (a0= MUL_DIV ) (a1_0= parse_org_emftext_language_pl0_Factor ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2621:2: (a0= MUL_DIV ) (a1_0= parse_org_emftext_language_pl0_Factor )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2621:2: (a0= MUL_DIV )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2622:3: a0= MUL_DIV
            {
            a0=(Token)match(input,MUL_DIV,FOLLOW_MUL_DIV_in_parse_org_emftext_language_pl0_OptionalFactor2411); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 91));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 91));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 91));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2656:2: (a1_0= parse_org_emftext_language_pl0_Factor )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2657:3: a1_0= parse_org_emftext_language_pl0_Factor
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Factor_in_parse_org_emftext_language_pl0_OptionalFactor2436);
            a1_0=parse_org_emftext_language_pl0_Factor();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_pl0_OptionalFactor_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_OptionalFactor"


    // $ANTLR start "parse_org_emftext_language_pl0_IdentReference"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2690:1: parse_org_emftext_language_pl0_IdentReference returns [org.emftext.language.pl0.IdentReference element = null] : (a0= PL0ID ) ;
    public final org.emftext.language.pl0.IdentReference parse_org_emftext_language_pl0_IdentReference() throws RecognitionException {
        org.emftext.language.pl0.IdentReference element =  null;
        int parse_org_emftext_language_pl0_IdentReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2693:1: ( (a0= PL0ID ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2694:2: (a0= PL0ID )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2694:2: (a0= PL0ID )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2695:3: a0= PL0ID
            {
            a0=(Token)match(input,PL0ID,FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_IdentReference2473); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_pl0_IdentReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_IdentReference"


    // $ANTLR start "parse_org_emftext_language_pl0_Number"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2743:1: parse_org_emftext_language_pl0_Number returns [org.emftext.language.pl0.Number element = null] : (a0= NUMBER ) ;
    public final org.emftext.language.pl0.Number parse_org_emftext_language_pl0_Number() throws RecognitionException {
        org.emftext.language.pl0.Number element =  null;
        int parse_org_emftext_language_pl0_Number_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2746:1: ( (a0= NUMBER ) )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2747:2: (a0= NUMBER )
            {
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2747:2: (a0= NUMBER )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2748:3: a0= NUMBER
            {
            a0=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_language_pl0_Number2513); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_pl0_Number_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Number"


    // $ANTLR start "parse_org_emftext_language_pl0_ExpressionFactor"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2792:1: parse_org_emftext_language_pl0_ExpressionFactor returns [org.emftext.language.pl0.ExpressionFactor element = null] : a0= '(' (a1_0= parse_org_emftext_language_pl0_Expression ) a2= ')' ;
    public final org.emftext.language.pl0.ExpressionFactor parse_org_emftext_language_pl0_ExpressionFactor() throws RecognitionException {
        org.emftext.language.pl0.ExpressionFactor element =  null;
        int parse_org_emftext_language_pl0_ExpressionFactor_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.language.pl0.Expression a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2795:1: (a0= '(' (a1_0= parse_org_emftext_language_pl0_Expression ) a2= ')' )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2796:2: a0= '(' (a1_0= parse_org_emftext_language_pl0_Expression ) a2= ')'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_language_pl0_ExpressionFactor2549); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createExpressionFactor();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_38, 95));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_39, 95));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_40, 95));
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_41, 95));
              	
            }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2811:2: (a1_0= parse_org_emftext_language_pl0_Expression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2812:3: a1_0= parse_org_emftext_language_pl0_Expression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_ExpressionFactor2567);
            a1_0=parse_org_emftext_language_pl0_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.language.pl0.resource.pl0.mopp.Pl0ExpectedTerminal(TERMINAL_49, 96));
              	
            }
            a2=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_language_pl0_ExpressionFactor2585); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.language.pl0.PL0Factory.eINSTANCE.createExpressionFactor();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_pl0_ExpressionFactor_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_ExpressionFactor"


    // $ANTLR start "parse_org_emftext_language_pl0_Statement"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2857:1: parse_org_emftext_language_pl0_Statement returns [org.emftext.language.pl0.Statement element = null] : (c0= parse_org_emftext_language_pl0_CallStatement | c1= parse_org_emftext_language_pl0_WhileStatement | c2= parse_org_emftext_language_pl0_IfStatement | c3= parse_org_emftext_language_pl0_Assignment );
    public final org.emftext.language.pl0.Statement parse_org_emftext_language_pl0_Statement() throws RecognitionException {
        org.emftext.language.pl0.Statement element =  null;
        int parse_org_emftext_language_pl0_Statement_StartIndex = input.index();
        org.emftext.language.pl0.CallStatement c0 = null;

        org.emftext.language.pl0.WhileStatement c1 = null;

        org.emftext.language.pl0.IfStatement c2 = null;

        org.emftext.language.pl0.Assignment c3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2858:1: (c0= parse_org_emftext_language_pl0_CallStatement | c1= parse_org_emftext_language_pl0_WhileStatement | c2= parse_org_emftext_language_pl0_IfStatement | c3= parse_org_emftext_language_pl0_Assignment )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
                {
                alt25=1;
                }
                break;
            case 31:
            case 32:
                {
                alt25=2;
                }
                break;
            case 35:
            case 36:
                {
                alt25=3;
                }
                break;
            case PL0ID:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2859:2: c0= parse_org_emftext_language_pl0_CallStatement
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_CallStatement_in_parse_org_emftext_language_pl0_Statement2610);
                    c0=parse_org_emftext_language_pl0_CallStatement();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2860:4: c1= parse_org_emftext_language_pl0_WhileStatement
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_WhileStatement_in_parse_org_emftext_language_pl0_Statement2620);
                    c1=parse_org_emftext_language_pl0_WhileStatement();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2861:4: c2= parse_org_emftext_language_pl0_IfStatement
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_IfStatement_in_parse_org_emftext_language_pl0_Statement2630);
                    c2=parse_org_emftext_language_pl0_IfStatement();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2862:4: c3= parse_org_emftext_language_pl0_Assignment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_Assignment_in_parse_org_emftext_language_pl0_Statement2640);
                    c3=parse_org_emftext_language_pl0_Assignment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_language_pl0_Statement_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Statement"


    // $ANTLR start "parse_org_emftext_language_pl0_Condition"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2866:1: parse_org_emftext_language_pl0_Condition returns [org.emftext.language.pl0.Condition element = null] : (c0= parse_org_emftext_language_pl0_OddCondition | c1= parse_org_emftext_language_pl0_RelationalCondition );
    public final org.emftext.language.pl0.Condition parse_org_emftext_language_pl0_Condition() throws RecognitionException {
        org.emftext.language.pl0.Condition element =  null;
        int parse_org_emftext_language_pl0_Condition_StartIndex = input.index();
        org.emftext.language.pl0.OddCondition c0 = null;

        org.emftext.language.pl0.RelationalCondition c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2867:1: (c0= parse_org_emftext_language_pl0_OddCondition | c1= parse_org_emftext_language_pl0_RelationalCondition )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=41 && LA26_0<=42)) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=PL0ID && LA26_0<=NUMBER)||LA26_0==PLUS_MINUS||LA26_0==44) ) {
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
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2868:2: c0= parse_org_emftext_language_pl0_OddCondition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_OddCondition_in_parse_org_emftext_language_pl0_Condition2661);
                    c0=parse_org_emftext_language_pl0_OddCondition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2869:4: c1= parse_org_emftext_language_pl0_RelationalCondition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_RelationalCondition_in_parse_org_emftext_language_pl0_Condition2671);
                    c1=parse_org_emftext_language_pl0_RelationalCondition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_language_pl0_Condition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Condition"


    // $ANTLR start "parse_org_emftext_language_pl0_Expression"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2873:1: parse_org_emftext_language_pl0_Expression returns [org.emftext.language.pl0.Expression element = null] : c0= parse_org_emftext_language_pl0_TermExpression ;
    public final org.emftext.language.pl0.Expression parse_org_emftext_language_pl0_Expression() throws RecognitionException {
        org.emftext.language.pl0.Expression element =  null;
        int parse_org_emftext_language_pl0_Expression_StartIndex = input.index();
        org.emftext.language.pl0.TermExpression c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2874:1: (c0= parse_org_emftext_language_pl0_TermExpression )
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2875:2: c0= parse_org_emftext_language_pl0_TermExpression
            {
            pushFollow(FOLLOW_parse_org_emftext_language_pl0_TermExpression_in_parse_org_emftext_language_pl0_Expression2692);
            c0=parse_org_emftext_language_pl0_TermExpression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; /* this is a subclass choice */ 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_language_pl0_Expression_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Expression"


    // $ANTLR start "parse_org_emftext_language_pl0_Factor"
    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2879:1: parse_org_emftext_language_pl0_Factor returns [org.emftext.language.pl0.Factor element = null] : (c0= parse_org_emftext_language_pl0_IdentReference | c1= parse_org_emftext_language_pl0_Number | c2= parse_org_emftext_language_pl0_ExpressionFactor );
    public final org.emftext.language.pl0.Factor parse_org_emftext_language_pl0_Factor() throws RecognitionException {
        org.emftext.language.pl0.Factor element =  null;
        int parse_org_emftext_language_pl0_Factor_StartIndex = input.index();
        org.emftext.language.pl0.IdentReference c0 = null;

        org.emftext.language.pl0.Number c1 = null;

        org.emftext.language.pl0.ExpressionFactor c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2880:1: (c0= parse_org_emftext_language_pl0_IdentReference | c1= parse_org_emftext_language_pl0_Number | c2= parse_org_emftext_language_pl0_ExpressionFactor )
            int alt27=3;
            switch ( input.LA(1) ) {
            case PL0ID:
                {
                alt27=1;
                }
                break;
            case NUMBER:
                {
                alt27=2;
                }
                break;
            case 44:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2881:2: c0= parse_org_emftext_language_pl0_IdentReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_IdentReference_in_parse_org_emftext_language_pl0_Factor2713);
                    c0=parse_org_emftext_language_pl0_IdentReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2882:4: c1= parse_org_emftext_language_pl0_Number
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_Number_in_parse_org_emftext_language_pl0_Factor2723);
                    c1=parse_org_emftext_language_pl0_Number();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // D:\\EMFText\\Workspaces\\EMFTextWS\\org.emftext.language.pl0.resource.pl0\\src-gen\\org\\emftext\\language\\pl0\\resource\\pl0\\mopp\\Pl0.g:2883:4: c2= parse_org_emftext_language_pl0_ExpressionFactor
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_pl0_ExpressionFactor_in_parse_org_emftext_language_pl0_Factor2733);
                    c2=parse_org_emftext_language_pl0_ExpressionFactor();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_language_pl0_Factor_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_pl0_Factor"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Program_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_pl0_Program116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_pl0_Program139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_Program167 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Block_in_parse_org_emftext_language_pl0_Program192 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_pl0_Program210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_pl0_Block254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_pl0_Block287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_ConstDeclaration_in_parse_org_emftext_language_pl0_Block329 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_pl0_Block370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_ConstDeclaration_in_parse_org_emftext_language_pl0_Block404 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_pl0_Block465 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_pl0_Block513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_pl0_Block546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_VarDeclaration_in_parse_org_emftext_language_pl0_Block588 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_pl0_Block629 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_VarDeclaration_in_parse_org_emftext_language_pl0_Block663 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_pl0_Block724 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_ProcedureDeclaration_in_parse_org_emftext_language_pl0_Block766 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_Block796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_ConstDeclaration833 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_pl0_ConstDeclaration854 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_pl0_ConstDeclaration872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_VarDeclaration912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_pl0_ProcedureDeclaration952 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_pl0_ProcedureDeclaration975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_ProcedureDeclaration1003 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_pl0_ProcedureDeclaration1024 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Block_in_parse_org_emftext_language_pl0_ProcedureDeclaration1042 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_pl0_ProcedureDeclaration1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_pl0_Body1093 = new BitSet(new long[]{0x00000019F8000010L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_pl0_Body1116 = new BitSet(new long[]{0x00000019F8000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Statement_in_parse_org_emftext_language_pl0_Body1155 = new BitSet(new long[]{0x0000000018080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_pl0_Body1196 = new BitSet(new long[]{0x00000019E0000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Statement_in_parse_org_emftext_language_pl0_Body1230 = new BitSet(new long[]{0x0000000018080000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_pl0_Body1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_pl0_Body1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_pl0_CallStatement1374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_pl0_CallStatement1397 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_CallStatement1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_language_pl0_WhileStatement1465 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_language_pl0_WhileStatement1488 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Condition_in_parse_org_emftext_language_pl0_WhileStatement1516 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_language_pl0_WhileStatement1538 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_language_pl0_WhileStatement1561 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_WhileStatement1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_language_pl0_IfStatement1626 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_pl0_IfStatement1649 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Condition_in_parse_org_emftext_language_pl0_IfStatement1677 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_language_pl0_IfStatement1699 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_language_pl0_IfStatement1722 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_IfStatement1750 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_language_pl0_IfStatement1783 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_language_pl0_IfStatement1816 = new BitSet(new long[]{0x0000000007B30000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Body_in_parse_org_emftext_language_pl0_IfStatement1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_language_pl0_OddCondition1918 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_language_pl0_OddCondition1941 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_OddCondition1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_RelationalCondition2006 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_REL_OP_in_parse_org_emftext_language_pl0_RelationalCondition2028 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_RelationalCondition2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_Assignment2090 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_language_pl0_Assignment2111 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_Assignment2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_MINUS_in_parse_org_emftext_language_pl0_TermExpression2171 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Term_in_parse_org_emftext_language_pl0_TermExpression2205 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_OptionalTerm_in_parse_org_emftext_language_pl0_TermExpression2232 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_PLUS_MINUS_in_parse_org_emftext_language_pl0_OptionalTerm2277 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Term_in_parse_org_emftext_language_pl0_OptionalTerm2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Factor_in_parse_org_emftext_language_pl0_Term2339 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_OptionalFactor_in_parse_org_emftext_language_pl0_Term2366 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_MUL_DIV_in_parse_org_emftext_language_pl0_OptionalFactor2411 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Factor_in_parse_org_emftext_language_pl0_OptionalFactor2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PL0ID_in_parse_org_emftext_language_pl0_IdentReference2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_language_pl0_Number2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_language_pl0_ExpressionFactor2549 = new BitSet(new long[]{0x00001600000000B0L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Expression_in_parse_org_emftext_language_pl0_ExpressionFactor2567 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_language_pl0_ExpressionFactor2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_CallStatement_in_parse_org_emftext_language_pl0_Statement2610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_WhileStatement_in_parse_org_emftext_language_pl0_Statement2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_IfStatement_in_parse_org_emftext_language_pl0_Statement2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Assignment_in_parse_org_emftext_language_pl0_Statement2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_OddCondition_in_parse_org_emftext_language_pl0_Condition2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_RelationalCondition_in_parse_org_emftext_language_pl0_Condition2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_TermExpression_in_parse_org_emftext_language_pl0_Expression2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_IdentReference_in_parse_org_emftext_language_pl0_Factor2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_Number_in_parse_org_emftext_language_pl0_Factor2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_pl0_ExpressionFactor_in_parse_org_emftext_language_pl0_Factor2733 = new BitSet(new long[]{0x0000000000000002L});

}