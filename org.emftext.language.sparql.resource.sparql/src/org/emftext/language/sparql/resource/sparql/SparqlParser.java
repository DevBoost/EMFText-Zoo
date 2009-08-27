// $ANTLR 3.1.1 E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g 2009-08-27 12:34:39

	package org.emftext.language.sparql.resource.sparql;
	
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;


import org.antlr.runtime.*;
import java.util.HashMap;
public class SparqlParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEF_IRI_REF", "DEF_INTEGER", "WHITESPACE", "LINEBREAKS", "IDENTIFIER", "'BASE'", "'PREFIX'", "':'"
    };
    public static final int T__11=11;
    public static final int IDENTIFIER=8;
    public static final int T__10=10;
    public static final int DEF_INTEGER=5;
    public static final int WHITESPACE=6;
    public static final int LINEBREAKS=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int DEF_IRI_REF=4;

    // delegates
    // delegators


        public SparqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SparqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[10+1];
             
             
        }
        

    public String[] getTokenNames() { return SparqlParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new org.emftext.language.sparql.resource.sparql.SparqlTokenResolverFactory();
    	private org.emftext.language.sparql.resource.sparql.SparqlTokenResolveResult tokenResolveResult = new org.emftext.language.sparql.resource.sparql.SparqlTokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private boolean reachedIndex = false;
    	private java.util.List<org.emftext.runtime.resource.IExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.runtime.resource.IExpectedElement>();
    	private int lastIndex = -1;
    	private int mismatchedTokenRecoveryTries = 0;
    	private java.util.Map<?, ?> options;
    	private org.emftext.runtime.resource.ITextResource resource;
    	//helper lists to allow a lexer to pass errors to its parser
    	protected java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime.RecognitionException>());
    	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	
    	protected void addErrorToResource(final java.lang.String errorMessage, int line, int charPositionInLine, int startIndex, int stopIndex) {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			// the resource can be null if the parser is used for
    			// code completion
    			return;
    		}
    		resource.addProblem(new org.emftext.runtime.resource.impl.AbstractProblem() {
    			public org.emftext.runtime.resource.EProblemType getType() {
    				return org.emftext.runtime.resource.EProblemType.ERROR;
    			}
    			public java.lang.String getMessage() {
    				return errorMessage;
    			}
    		}, line, charPositionInLine, startIndex, stopIndex);
    	}
    	
    	public void addExpectedElement(org.emftext.runtime.resource.IExpectedElement expectedElement, java.lang.String message) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		if (this.reachedIndex) {
    			return;
    		}
    		int currentIndex = java.lang.Math.max(0, input.index());
    		//System.out.println("addExpectedElement() currentIndex = " + currentIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			//System.out.println("addExpectedElement() index = " + index);
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime.CommonToken tokenAtIndex = (org.antlr.runtime.CommonToken) input.get(index);
    			//System.out.println("addExpectedElement() tokenAtIndex = " + tokenAtIndex);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = java.lang.Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    		System.out.println("Adding expected element (" + message + "): " + expectedElement + "");
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.sparql.resource.sparql.SparqlDummyEObject dummy) {
    		java.lang.Object value = element.eGet(structuralFeature);
    		java.lang.Object mapKey = dummy.getValueByName("key");
    		java.lang.Object mapValue = dummy.getValueByName("value");
    		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
    			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.runtime.util.MapUtil.castToEMap(value);
    			if (mapKey != null && mapValue != null) {
    				valueMap.put(mapKey, mapValue);
    			}
    		}
    	}
    	
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
    		org.eclipse.emf.ecore.EObject currentTarget = target;
    		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
    			assert(object instanceof org.emftext.language.sparql.resource.sparql.SparqlDummyEObject);
    			org.emftext.language.sparql.resource.sparql.SparqlDummyEObject dummy = (org.emftext.language.sparql.resource.sparql.SparqlDummyEObject) object;
    			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
    			currentTarget = newEObject;
    		}
    		return currentTarget;
    	}
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			// the resource can be null if the parser is used for
    			// code completion
    			return;
    		}
    		final org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
    		locationMap.setCharStart(target, locationMap.getCharStart(source));
    		locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    		locationMap.setColumn(target, locationMap.getColumn(source));
    		locationMap.setLine(target, locationMap.getLine(source));
    	}
    	
    	protected void copyLocalizationInfos(org.antlr.runtime.CommonToken source, org.eclipse.emf.ecore.EObject target) {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			// the resource can be null if the parser is used for
    			// code completion
    			return;
    		}
    		final org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
    		locationMap.setCharStart(target, source.getStartIndex());
    		locationMap.setCharEnd(target, source.getStopIndex());
    		locationMap.setColumn(target, source.getCharPositionInLine());
    		locationMap.setLine(target, source.getLine());
    	}
    	
    	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
    		try {
    			if (encoding == null) {
    				return new SparqlParser(new org.antlr.runtime.CommonTokenStream(new SparqlLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new SparqlParser(new org.antlr.runtime.CommonTokenStream(new SparqlLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	// This default constructor is only used to call createInstance() on it
    	public SparqlParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime.RecognitionException {
    		((SparqlLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((SparqlLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		java.lang.Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.language.sparql.SparqlQueries.class) {
    				return parse_org_emftext_language_sparql_SparqlQueries();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.Prologue.class) {
    				return parse_org_emftext_language_sparql_Prologue();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.BaseDecl.class) {
    				return parse_org_emftext_language_sparql_BaseDecl();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.PrefixDecl.class) {
    				return parse_org_emftext_language_sparql_PrefixDecl();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.IRI_REF_STRING.class) {
    				return parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.PNAME_NS.class) {
    				return parse_org_emftext_language_sparql_PNAME_005FNS();
    			}
    			if (type.getInstanceClass() == org.emftext.language.sparql.INTEGER.class) {
    				return parse_org_emftext_language_sparql_INTEGER();
    			}
    		}
    		throw new org.emftext.runtime.resource.impl.UnexpectedContentTypeException(typeObject);
    	}
    	
    	private org.emftext.language.sparql.resource.sparql.SparqlTokenResolveResult getFreshTokenResolveResult() {
    		tokenResolveResult.clear();
    		return tokenResolveResult;
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public java.lang.Object getMissingSymbol(org.antlr.runtime.IntStream arg0, org.antlr.runtime.RecognitionException arg1, int arg2, org.antlr.runtime.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	protected java.util.Map<?,?> getOptions() {
    		return options;
    	}
    	
    	public java.lang.Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected org.emftext.language.sparql.resource.sparql.SparqlReferenceResolverSwitch getReferenceResolverSwitch() {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			return null;
    		}
    		return (org.emftext.language.sparql.resource.sparql.SparqlReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
    	}
    	
    	public org.emftext.runtime.resource.ITextResource getResource() {
    		return resource;
    	}
    	
    	protected java.lang.Object getTypeObject() {
    		java.lang.Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.emftext.runtime.IOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	// Implementation that calls {@link #doParse()}  and handles the thrown
    	// RecognitionExceptions.
    	public org.eclipse.emf.ecore.EObject parse() {
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				return result;
    			}
    		} catch (org.antlr.runtime.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				//? can be caused if a null is set on EMF models where not allowed;
    				//? this will just happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		return null;
    	}
    	
    	public java.util.List<org.emftext.runtime.resource.IExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
    		rememberExpectedElements = true;
    		parseToIndexTypeObject = type;
    		parse();
    		return this.expectedElements;
    	}
    	
    	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime.IntStream input, int ttype, org.antlr.runtime.BitSet follow) throws org.antlr.runtime.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.language.sparql.resource.sparql.SparqlContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory,ContainerType element, org.eclipse.emf.ecore.EReference reference, String id,org.eclipse.emf.ecore.EObject proxy) {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			// the resource can be null if the parser is used for
    			// code completion
    			return;
    		}
    		resource.registerContextDependentProxy(factory, element, reference, id, proxy);
    	}
    	
    	// Translates errors thrown by the parser into human readable messages.
    	public void reportError(org.antlr.runtime.RecognitionException e)  {
    		java.lang.String message = e.getMessage();
    		if (e instanceof org.antlr.runtime.MismatchedTokenException) {
    			org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
    			java.lang.String tokenName = "<unknown>";
    			if (mte.expecting == Token.EOF) {
    				tokenName = "EOF";
    			} else {
    				tokenName = getTokenNames()[mte.expecting];
    				tokenName = org.emftext.runtime.util.StringUtil.formatTokenName(tokenName);
    			}
    			message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime.MismatchedTreeNodeException) {
    			org.antlr.runtime.MismatchedTreeNodeException mtne = (org.antlr.runtime.MismatchedTreeNodeException) e;
    			java.lang.String tokenName = "<unknown>";
    			if (mtne.expecting == Token.EOF) {
    				tokenName = "EOF";
    			} else {
    				tokenName = getTokenNames()[mtne.expecting];
    			}
    			message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
    		} else if (e instanceof org.antlr.runtime.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime.MismatchedSetException) {
    			org.antlr.runtime.MismatchedSetException mse = (org.antlr.runtime.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime.MismatchedNotSetException) {
    			org.antlr.runtime.MismatchedNotSetException mse = (org.antlr.runtime.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime.FailedPredicateException) {
    			org.antlr.runtime.FailedPredicateException fpe = (org.antlr.runtime.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
    		}
    		// the resource may be null if the parse is used for code completion
    		final java.lang.String finalMessage = message;
    		if (resource != null) {
    			if (e.token instanceof org.antlr.runtime.CommonToken) {
    				org.antlr.runtime.CommonToken ct = (org.antlr.runtime.CommonToken) e.token;
    				resource.addProblem(
    					new org.emftext.runtime.resource.impl.AbstractProblem() {
    						public org.emftext.runtime.resource.EProblemType getType() {
    							return org.emftext.runtime.resource.EProblemType.ERROR;
    						}
    						public java.lang.String getMessage() {
    							return finalMessage;
    						}
    					}, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    				} else {
    					resource.addProblem(
    						new org.emftext.runtime.resource.impl.AbstractProblem() {
    							public org.emftext.runtime.resource.EProblemType getType() {
    								return org.emftext.runtime.resource.EProblemType.ERROR;
    							}
    							public java.lang.String getMessage() {
    								return finalMessage;
    							}
    						},
    						e.token.getCharPositionInLine(), e.token.getLine(), 1, 5); // TODO what the heck is this 5?
    					}
    				}
    			}
    			
    			// Translates errors thrown by the lexer into human readable messages.
    			public void reportLexicalError(org.antlr.runtime.RecognitionException e)  {
    				java.lang.String message = "";
    				if (e instanceof org.antlr.runtime.MismatchedTokenException) {
    					org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
    					message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    				} else if (e instanceof org.antlr.runtime.NoViableAltException) {
    					message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    				} else if (e instanceof org.antlr.runtime.EarlyExitException) {
    					org.antlr.runtime.EarlyExitException eee = (org.antlr.runtime.EarlyExitException) e;
    					message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    				} else if (e instanceof org.antlr.runtime.MismatchedSetException) {
    					org.antlr.runtime.MismatchedSetException mse = (org.antlr.runtime.MismatchedSetException) e;
    					message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    				} else if (e instanceof org.antlr.runtime.MismatchedNotSetException) {
    					org.antlr.runtime.MismatchedNotSetException mse = (org.antlr.runtime.MismatchedNotSetException) e;
    					message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    				} else if (e instanceof org.antlr.runtime.MismatchedRangeException) {
    					org.antlr.runtime.MismatchedRangeException mre = (org.antlr.runtime.MismatchedRangeException) e;
    					message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    				} else if (e instanceof org.antlr.runtime.FailedPredicateException) {
    					org.antlr.runtime.FailedPredicateException fpe = (org.antlr.runtime.FailedPredicateException) e;
    					message ="rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    				}
    				final java.lang.String finalMessage = message;
    				// the resource may be null if the parse is used for code completion
    				if (resource != null) {
    					resource.addProblem(
    						new org.emftext.runtime.resource.impl.AbstractProblem() {
    														public org.emftext.runtime.resource.EProblemType getType() {
    								return org.emftext.runtime.resource.EProblemType.ERROR;
    							}
    														public java.lang.String getMessage() {
    								return finalMessage;
    							}
    						}, e.index,e.line,lexerExceptionsPosition.get(lexerExceptions.indexOf(e)),lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    					}
    				}
    				
    				public void setOptions(java.util.Map<?,?> options) {
    					this.options = options;
    				}
    				
    				public void setResource(org.emftext.runtime.resource.ITextResource resource) {
    					this.resource = resource;
    				}
    				
    			


    // $ANTLR start "start"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:406:4: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_sparql_SparqlQueries ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.sparql.SparqlQueries c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:407:4: ( (c0= parse_org_emftext_language_sparql_SparqlQueries ) EOF )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:408:5: (c0= parse_org_emftext_language_sparql_SparqlQueries ) EOF
            {
            if ( state.backtracking==0 ) {

              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:410:5: (c0= parse_org_emftext_language_sparql_SparqlQueries )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:411:6: c0= parse_org_emftext_language_sparql_SparqlQueries
            {
            if ( state.backtracking==0 ) {

              					
            }
            pushFollow(FOLLOW_parse_org_emftext_language_sparql_SparqlQueries_in_start110);
            c0=parse_org_emftext_language_sparql_SparqlQueries();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start123); if (state.failed) return element;

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


    // $ANTLR start "parse_org_emftext_language_sparql_SparqlQueries"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:418:4: parse_org_emftext_language_sparql_SparqlQueries returns [org.emftext.language.sparql.SparqlQueries element = null] : (a0_0= parse_org_emftext_language_sparql_Prologue ) ;
    public final org.emftext.language.sparql.SparqlQueries parse_org_emftext_language_sparql_SparqlQueries() throws RecognitionException {
        org.emftext.language.sparql.SparqlQueries element =  null;
        int parse_org_emftext_language_sparql_SparqlQueries_StartIndex = input.index();
        org.emftext.language.sparql.Prologue a0_0 = null;



        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:421:4: ( (a0_0= parse_org_emftext_language_sparql_Prologue ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:422:5: (a0_0= parse_org_emftext_language_sparql_Prologue )
            {
            if ( state.backtracking==0 ) {

              					// expected element is a Terminal
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:425:5: (a0_0= parse_org_emftext_language_sparql_Prologue )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:426:6: a0_0= parse_org_emftext_language_sparql_Prologue
            {
            pushFollow(FOLLOW_parse_org_emftext_language_sparql_Prologue_in_parse_org_emftext_language_sparql_SparqlQueries183);
            a0_0=parse_org_emftext_language_sparql_Prologue();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              						if (element == null) {
              							element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createSparqlQueries();
              						}
              						String tokenName = "null";
              						if (a0_0 != null) {
              							if (a0_0 != null) {
              								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__PROLOGUE), a0_0);
              							}
              							collectHiddenTokens(element);
              							copyLocalizationInfos(a0_0, element); 						}
              					
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_sparql_SparqlQueries_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_SparqlQueries"


    // $ANTLR start "parse_org_emftext_language_sparql_Prologue"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:442:4: parse_org_emftext_language_sparql_Prologue returns [org.emftext.language.sparql.Prologue element = null] : ( (a0_0= parse_org_emftext_language_sparql_BaseDecl ) )? ( (a1_0= parse_org_emftext_language_sparql_PrefixDecl ) )* ;
    public final org.emftext.language.sparql.Prologue parse_org_emftext_language_sparql_Prologue() throws RecognitionException {
        org.emftext.language.sparql.Prologue element =  null;
        int parse_org_emftext_language_sparql_Prologue_StartIndex = input.index();
        org.emftext.language.sparql.BaseDecl a0_0 = null;

        org.emftext.language.sparql.PrefixDecl a1_0 = null;



        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:445:4: ( ( (a0_0= parse_org_emftext_language_sparql_BaseDecl ) )? ( (a1_0= parse_org_emftext_language_sparql_PrefixDecl ) )* )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:446:5: ( (a0_0= parse_org_emftext_language_sparql_BaseDecl ) )? ( (a1_0= parse_org_emftext_language_sparql_PrefixDecl ) )*
            {
            if ( state.backtracking==0 ) {

              					// expected element before STAR or QUESTIONMARK or PLUS
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:449:5: ( (a0_0= parse_org_emftext_language_sparql_BaseDecl ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==9) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:450:6: (a0_0= parse_org_emftext_language_sparql_BaseDecl )
                    {
                    if ( state.backtracking==0 ) {

                      						// expected element is a Terminal
                      					
                    }
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:453:6: (a0_0= parse_org_emftext_language_sparql_BaseDecl )
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:454:7: a0_0= parse_org_emftext_language_sparql_BaseDecl
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_sparql_BaseDecl_in_parse_org_emftext_language_sparql_Prologue271);
                    a0_0=parse_org_emftext_language_sparql_BaseDecl();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      							if (element == null) {
                      								element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createPrologue();
                      							}
                      							String tokenName = "null";
                      							if (a0_0 != null) {
                      								if (a0_0 != null) {
                      									element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__BASEDECLARATION), a0_0);
                      								}
                      								collectHiddenTokens(element);
                      								copyLocalizationInfos(a0_0, element); 							}
                      						
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              					// expected element before STAR or QUESTIONMARK or PLUS
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:472:5: ( (a1_0= parse_org_emftext_language_sparql_PrefixDecl ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:473:6: (a1_0= parse_org_emftext_language_sparql_PrefixDecl )
            	    {
            	    if ( state.backtracking==0 ) {

            	      						// expected element is a Terminal
            	      					
            	    }
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:476:6: (a1_0= parse_org_emftext_language_sparql_PrefixDecl )
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:477:7: a1_0= parse_org_emftext_language_sparql_PrefixDecl
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_sparql_PrefixDecl_in_parse_org_emftext_language_sparql_Prologue340);
            	    a1_0=parse_org_emftext_language_sparql_PrefixDecl();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      							if (element == null) {
            	      								element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createPrologue();
            	      							}
            	      							String tokenName = "null";
            	      							if (a1_0 != null) {
            	      								if (a1_0 != null) {
            	      									addObjectToList(element, org.emftext.language.sparql.SparqlPackage.PROLOGUE__PREFIXDECLARATION, a1_0);
            	      								}
            	      								collectHiddenTokens(element);
            	      								copyLocalizationInfos(a1_0, element); 							}
            	      						
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              					// expected element after STAR or PLUS
              				
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_sparql_Prologue_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_Prologue"


    // $ANTLR start "parse_org_emftext_language_sparql_BaseDecl"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:497:4: parse_org_emftext_language_sparql_BaseDecl returns [org.emftext.language.sparql.BaseDecl element = null] : a0= 'BASE' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING ) ;
    public final org.emftext.language.sparql.BaseDecl parse_org_emftext_language_sparql_BaseDecl() throws RecognitionException {
        org.emftext.language.sparql.BaseDecl element =  null;
        int parse_org_emftext_language_sparql_BaseDecl_StartIndex = input.index();
        Token a0=null;
        org.emftext.language.sparql.IRI_REF_STRING a1_0 = null;



        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:500:4: (a0= 'BASE' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:501:5: a0= 'BASE' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING )
            {
            if ( state.backtracking==0 ) {

              					// expected element is a CsString
              				
            }
            a0=(Token)match(input,9,FOLLOW_9_in_parse_org_emftext_language_sparql_BaseDecl426); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              					if (element == null) {
              						element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createBaseDecl();
              					}
              					collectHiddenTokens(element);
              					copyLocalizationInfos((CommonToken)a0, element);
              				
            }
            if ( state.backtracking==0 ) {

              					// expected element is a Terminal
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:515:5: (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:516:6: a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING
            {
            pushFollow(FOLLOW_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_in_parse_org_emftext_language_sparql_BaseDecl456);
            a1_0=parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              						if (element == null) {
              							element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createBaseDecl();
              						}
              						String tokenName = "null";
              						if (a1_0 != null) {
              							if (a1_0 != null) {
              								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__IRIREF), a1_0);
              							}
              							collectHiddenTokens(element);
              							copyLocalizationInfos(a1_0, element); 						}
              					
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_sparql_BaseDecl_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_BaseDecl"


    // $ANTLR start "parse_org_emftext_language_sparql_PrefixDecl"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:532:4: parse_org_emftext_language_sparql_PrefixDecl returns [org.emftext.language.sparql.PrefixDecl element = null] : a0= 'PREFIX' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING ) ;
    public final org.emftext.language.sparql.PrefixDecl parse_org_emftext_language_sparql_PrefixDecl() throws RecognitionException {
        org.emftext.language.sparql.PrefixDecl element =  null;
        int parse_org_emftext_language_sparql_PrefixDecl_StartIndex = input.index();
        Token a0=null;
        org.emftext.language.sparql.IRI_REF_STRING a1_0 = null;



        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:535:4: (a0= 'PREFIX' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:536:5: a0= 'PREFIX' (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING )
            {
            if ( state.backtracking==0 ) {

              					// expected element is a CsString
              				
            }
            a0=(Token)match(input,10,FOLLOW_10_in_parse_org_emftext_language_sparql_PrefixDecl522); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              					if (element == null) {
              						element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createPrefixDecl();
              					}
              					collectHiddenTokens(element);
              					copyLocalizationInfos((CommonToken)a0, element);
              				
            }
            if ( state.backtracking==0 ) {

              					// expected element is a Terminal
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:550:5: (a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:551:6: a1_0= parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING
            {
            pushFollow(FOLLOW_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_in_parse_org_emftext_language_sparql_PrefixDecl552);
            a1_0=parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              						if (element == null) {
              							element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createPrefixDecl();
              						}
              						String tokenName = "null";
              						if (a1_0 != null) {
              							if (a1_0 != null) {
              								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__IRIREF), a1_0);
              							}
              							collectHiddenTokens(element);
              							copyLocalizationInfos(a1_0, element); 						}
              					
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_sparql_PrefixDecl_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_PrefixDecl"


    // $ANTLR start "parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:567:4: parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING returns [org.emftext.language.sparql.IRI_REF_STRING element = null] : (a0= DEF_IRI_REF ) ;
    public final org.emftext.language.sparql.IRI_REF_STRING parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING() throws RecognitionException {
        org.emftext.language.sparql.IRI_REF_STRING element =  null;
        int parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_StartIndex = input.index();
        Token a0=null;


        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:570:4: ( (a0= DEF_IRI_REF ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:571:5: (a0= DEF_IRI_REF )
            {
            if ( state.backtracking==0 ) {

              					// expected element is a Terminal
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:574:5: (a0= DEF_IRI_REF )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:575:6: a0= DEF_IRI_REF
            {
            a0=(Token)match(input,DEF_IRI_REF,FOLLOW_DEF_IRI_REF_in_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING625); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              						if (element == null) {
              							element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createIRI_REF_STRING();
              						}
              						String tokenName = "DEF_IRI_REF";
              						if (a0 != null) {
              							org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DEF_IRI_REF");
              							tokenResolver.setOptions(getOptions());
              							org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              							tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__IRI_REF), result);
              							java.lang.Object resolvedObject = result.getResolvedToken();
              							if (resolvedObject == null) {
              								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              							}
              							java.lang.String resolved = (java.lang.String)resolvedObject;
              							if (resolved != null) {
              								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__IRI_REF), resolved);
              							}
              							collectHiddenTokens(element);
              							copyLocalizationInfos((CommonToken) a0, element);
              						}
              					
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING"


    // $ANTLR start "parse_org_emftext_language_sparql_PNAME_005FNS"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:602:4: parse_org_emftext_language_sparql_PNAME_005FNS returns [org.emftext.language.sparql.PNAME_NS element = null] : a0= ':' ;
    public final org.emftext.language.sparql.PNAME_NS parse_org_emftext_language_sparql_PNAME_005FNS() throws RecognitionException {
        org.emftext.language.sparql.PNAME_NS element =  null;
        int parse_org_emftext_language_sparql_PNAME_005FNS_StartIndex = input.index();
        Token a0=null;


        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:605:4: (a0= ':' )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:606:5: a0= ':'
            {
            if ( state.backtracking==0 ) {

              					// expected element is a CsString
              				
            }
            a0=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_sparql_PNAME_005FNS697); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              					if (element == null) {
              						element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createPNAME_NS();
              					}
              					collectHiddenTokens(element);
              					copyLocalizationInfos((CommonToken)a0, element);
              				
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_sparql_PNAME_005FNS_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_PNAME_005FNS"


    // $ANTLR start "parse_org_emftext_language_sparql_INTEGER"
    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:619:4: parse_org_emftext_language_sparql_INTEGER returns [org.emftext.language.sparql.INTEGER element = null] : (a0= DEF_INTEGER ) ;
    public final org.emftext.language.sparql.INTEGER parse_org_emftext_language_sparql_INTEGER() throws RecognitionException {
        org.emftext.language.sparql.INTEGER element =  null;
        int parse_org_emftext_language_sparql_INTEGER_StartIndex = input.index();
        Token a0=null;


        			
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:622:4: ( (a0= DEF_INTEGER ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:623:5: (a0= DEF_INTEGER )
            {
            if ( state.backtracking==0 ) {

              					// expected element is a Terminal
              				
            }
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:626:5: (a0= DEF_INTEGER )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:627:6: a0= DEF_INTEGER
            {
            a0=(Token)match(input,DEF_INTEGER,FOLLOW_DEF_INTEGER_in_parse_org_emftext_language_sparql_INTEGER760); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              						if (element == null) {
              							element = org.emftext.language.sparql.SparqlFactory.eINSTANCE.createINTEGER();
              						}
              						String tokenName = "DEF_INTEGER";
              						if (a0 != null) {
              							org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DEF_INTEGER");
              							tokenResolver.setOptions(getOptions());
              							org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              							tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__VALUE), result);
              							java.lang.Object resolvedObject = result.getResolvedToken();
              							if (resolvedObject == null) {
              								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              							}
              							java.lang.String resolved = (java.lang.String)resolvedObject;
              							if (resolved != null) {
              								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__VALUE), resolved);
              							}
              							collectHiddenTokens(element);
              							copyLocalizationInfos((CommonToken) a0, element);
              						}
              					
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_sparql_INTEGER_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_sparql_INTEGER"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_SparqlQueries_in_start110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_Prologue_in_parse_org_emftext_language_sparql_SparqlQueries183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_BaseDecl_in_parse_org_emftext_language_sparql_Prologue271 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_PrefixDecl_in_parse_org_emftext_language_sparql_Prologue340 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_9_in_parse_org_emftext_language_sparql_BaseDecl426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_in_parse_org_emftext_language_sparql_BaseDecl456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parse_org_emftext_language_sparql_PrefixDecl522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING_in_parse_org_emftext_language_sparql_PrefixDecl552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_IRI_REF_in_parse_org_emftext_language_sparql_IRI_005FREF_005FSTRING625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_sparql_PNAME_005FNS697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_INTEGER_in_parse_org_emftext_language_sparql_INTEGER760 = new BitSet(new long[]{0x0000000000000002L});

}