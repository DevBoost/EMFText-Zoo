// $ANTLR 3.1.1

	package org.emftext.language.uml_class.resource.uml_class.mopp;


import org.antlr.runtime.*;
import java.util.HashMap;
public class Uml_classParser extends Uml_classANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_34_34", "COMMENT", "INTEGER", "WHITESPACE", "LINEBREAK", "'classdiagramm'", "'{'", "'}'", "'method'", "'ac'", "'md'", "'('", "','", "')'", "':'", "'void'", "'attribute'", "'class'", "'extends'", "'association'", "'->'", "'..'", "'BOOLEAN'", "'STRING'", "'INTEGER'", "'TYPE'"
    };
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int T__21=21;
    public static final int COMMENT=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int WHITESPACE=8;
    public static final int T__29=29;
    public static final int INTEGER=7;
    public static final int T__30=30;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__16=16;
    public static final int TEXT=4;
    public static final int T__24=24;
    public static final int LINEBREAK=9;
    public static final int T__10=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__18=18;
    public static final int QUOTED_34_34=5;
    public static final int T__15=15;

    // delegates
    // delegators


        public Uml_classParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Uml_classParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[47+1];
             
             
        }
        

    public String[] getTokenNames() { return Uml_classParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g"; }


    	private org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolverFactory tokenResolverFactory = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolveResult tokenResolveResult = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private boolean reachedIndex = false;
    	private java.util.List<org.emftext.language.uml_class.resource.uml_class.IUml_classExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.language.uml_class.resource.uml_class.IUml_classExpectedElement>();
    	private int lastIndex = -1;
    	private int mismatchedTokenRecoveryTries = 0;
    	private java.util.Map<?, ?> options;
    	//helper lists to allow a lexer to pass errors to its parser
    	protected java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime.RecognitionException>());
    	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>> postParseCommands;
    	private boolean terminateParsing;
    	
    	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>() {
    			public boolean execute(org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for
    					// code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.language.uml_class.resource.uml_class.IUml_classProblem() {
    					public org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType getType() {
    						return org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType.ERROR;
    					}
    					public java.lang.String getMessage() {
    						return errorMessage;
    					}
    				}, line, charPositionInLine, startIndex, stopIndex);
    				return true;
    			}
    		}
    	);
    }

    public void addExpectedElement(org.emftext.language.uml_class.resource.uml_class.IUml_classExpectedElement expectedElement, java.lang.String message) {
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

    protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classDummyEObject dummy) {
    	java.lang.Object value = element.eGet(structuralFeature);
    	java.lang.Object mapKey = dummy.getValueByName("key");
    	java.lang.Object mapValue = dummy.getValueByName("value");
    	if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
    		org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.language.uml_class.resource.uml_class.util.Uml_classMapUtil.castToEMap(value);
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
    		assert(object instanceof org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classDummyEObject);
    		org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classDummyEObject dummy = (org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classDummyEObject) object;
    		org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
    		currentTarget = newEObject;
    	}
    	return currentTarget;
    }
    protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    }

    protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    	postParseCommands.add(new org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>() {
    		public boolean execute(org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
    			if (resource == null) {
    				// the resource can be null if the parser is used for
    				// code completion
    				return true;
    			}
    			org.emftext.language.uml_class.resource.uml_class.IUml_classLocationMap locationMap = resource.getLocationMap();
    			locationMap.setCharStart(target, locationMap.getCharStart(source));
    			locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    			locationMap.setColumn(target, locationMap.getColumn(source));
    			locationMap.setLine(target, locationMap.getLine(source));
    			return true;
    		}
    	});
    }

    protected void copyLocalizationInfos(final org.antlr.runtime.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    	postParseCommands.add(new org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>() {
    		public boolean execute(org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
    			if (resource == null) {
    				// the resource can be null if the parser is used for
    				// code completion
    				return true;
    			}
    			org.emftext.language.uml_class.resource.uml_class.IUml_classLocationMap locationMap = resource.getLocationMap();
    			locationMap.setCharStart(target, source.getStartIndex());
    			locationMap.setCharEnd(target, source.getStopIndex());
    			locationMap.setColumn(target, source.getCharPositionInLine());
    			locationMap.setLine(target, source.getLine());
    			return true;
    		}
    	});
    }

    public org.emftext.language.uml_class.resource.uml_class.IUml_classTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
    	try {
    		if (encoding == null) {
    			return new Uml_classParser(new org.antlr.runtime.CommonTokenStream(new Uml_classLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
    		} else {
    			return new Uml_classParser(new org.antlr.runtime.CommonTokenStream(new Uml_classLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
    		}
    	} catch (java.io.IOException e) {
    		org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.logError("Error while creating parser.", e);
    		return null;
    	}
    }

    // This default constructor is only used to call createInstance() on it
    public Uml_classParser() {
    	super(null);
    }

    protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime.RecognitionException {
    	lastPosition = 0;
    	((Uml_classLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    	((Uml_classLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    	java.lang.Object typeObject = getTypeObject();
    	if (typeObject == null) {
    		return start();
    	} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    		org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    		if (type.getInstanceClass() == org.emftext.language.uml_class.ClassDiagramm.class) {
    			return parse_org_emftext_language_uml_005Fclass_ClassDiagramm();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Method.class) {
    			return parse_org_emftext_language_uml_005Fclass_Method();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Attribute.class) {
    			return parse_org_emftext_language_uml_005Fclass_Attribute();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Parameter.class) {
    			return parse_org_emftext_language_uml_005Fclass_Parameter();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Class.class) {
    			return parse_org_emftext_language_uml_005Fclass_Class();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Association.class) {
    			return parse_org_emftext_language_uml_005Fclass_Association();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Boolean.class) {
    			return parse_org_emftext_language_uml_005Fclass_Boolean();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.String.class) {
    			return parse_org_emftext_language_uml_005Fclass_String();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.Integer.class) {
    			return parse_org_emftext_language_uml_005Fclass_Integer();
    		}
    		if (type.getInstanceClass() == org.emftext.language.uml_class.PrimitiveDataType.class) {
    			return parse_org_emftext_language_uml_005Fclass_PrimitiveDataType();
    		}
    		if (type.getInstanceClass() == org.emftext.language.primitive_types.BooleanObject.class) {
    			return parse_org_emftext_language_primitive_005Ftypes_BooleanObject();
    		}
    		if (type.getInstanceClass() == org.emftext.language.primitive_types.IntegerObject.class) {
    			return parse_org_emftext_language_primitive_005Ftypes_IntegerObject();
    		}
    		if (type.getInstanceClass() == org.emftext.language.primitive_types.StringObject.class) {
    			return parse_org_emftext_language_primitive_005Ftypes_StringObject();
    		}
    	}
    	throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classUnexpectedContentTypeException(typeObject);
    }

    private org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolveResult getFreshTokenResolveResult() {
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

    public org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation getMetaInformation() {
    	return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation();
    }

    public java.lang.Object getParseToIndexTypeObject() {
    	return parseToIndexTypeObject;
    }

    protected org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classReferenceResolverSwitch getReferenceResolverSwitch() {
    	return (org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
    }

    protected java.lang.Object getTypeObject() {
    	java.lang.Object typeObject = getParseToIndexTypeObject();
    	if (typeObject != null) {
    		return typeObject;
    	}
    	java.util.Map<?,?> options = getOptions();
    	if (options != null) {
    		typeObject = options.get(org.emftext.language.uml_class.resource.uml_class.IUml_classOptions.RESOURCE_CONTENT_TYPE);
    	}
    	return typeObject;
    }

    // Implementation that calls {@link #doParse()}  and handles the thrown
    // RecognitionExceptions.
    public org.emftext.language.uml_class.resource.uml_class.IUml_classParseResult parse() {
    	terminateParsing = false;
    	postParseCommands = new java.util.ArrayList<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>>();
    	org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classParseResult parseResult = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classParseResult();
    	try {
    		org.eclipse.emf.ecore.EObject result =  doParse();
    		if (lexerExceptions.isEmpty()) {
    			parseResult.setRoot(result);
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
    	parseResult.getPostParseCommands().addAll(postParseCommands);
    	return parseResult;
    }

    public java.util.List<org.emftext.language.uml_class.resource.uml_class.IUml_classExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
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
    protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
    	postParseCommands.add(new org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>() {
    		public boolean execute(org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
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
    public void reportError(final org.antlr.runtime.RecognitionException e)  {
    	java.lang.String message = e.getMessage();
    	if (e instanceof org.antlr.runtime.MismatchedTokenException) {
    		org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
    		java.lang.String tokenName = "<unknown>";
    		if (mte.expecting == Token.EOF) {
    			tokenName = "EOF";
    		} else {
    			tokenName = getTokenNames()[mte.expecting];
    			tokenName = org.emftext.language.uml_class.resource.uml_class.util.Uml_classStringUtil.formatTokenName(tokenName);
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
    	if (e.token instanceof org.antlr.runtime.CommonToken) {
    		final org.antlr.runtime.CommonToken ct = (org.antlr.runtime.CommonToken) e.token;
    		addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    	} else {
    		addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5); // TODO what the heck is this 5?
    	}
    }

    // Translates errors thrown by the lexer into human readable messages.
    public void reportLexicalError(final org.antlr.runtime.RecognitionException e)  {
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
    	addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    }

    public void setOptions(java.util.Map<?,?> options) {
    	this.options = options;
    }

    public void terminate() {
    	terminateParsing = true;
    }



    // $ANTLR start "start"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:410:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_uml_005Fclass_ClassDiagramm ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.language.uml_class.ClassDiagramm c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:411:1: ( (c0= parse_org_emftext_language_uml_005Fclass_ClassDiagramm ) EOF )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:412:1: (c0= parse_org_emftext_language_uml_005Fclass_ClassDiagramm ) EOF
            {
            if ( state.backtracking==0 ) {


            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:414:1: (c0= parse_org_emftext_language_uml_005Fclass_ClassDiagramm )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:415:2: c0= parse_org_emftext_language_uml_005Fclass_ClassDiagramm
            {
            if ( state.backtracking==0 ) {

              	
            }
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_ClassDiagramm_in_start82);
            c0=parse_org_emftext_language_uml_005Fclass_ClassDiagramm();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start87); if (state.failed) return element;

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


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_ClassDiagramm"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:422:1: parse_org_emftext_language_uml_005Fclass_ClassDiagramm returns [org.emftext.language.uml_class.ClassDiagramm element = null] : a0= 'classdiagramm' (a1= TEXT ) a2= '{' ( (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )* ( (a4_0= parse_org_emftext_language_uml_005Fclass_XClass ) )* ( (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation ) )* a6= '}' ;
    public final org.emftext.language.uml_class.ClassDiagramm parse_org_emftext_language_uml_005Fclass_ClassDiagramm() throws RecognitionException {
        org.emftext.language.uml_class.ClassDiagramm element =  null;
        int parse_org_emftext_language_uml_005Fclass_ClassDiagramm_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a6=null;
        org.emftext.language.uml_class.XDataType a3_0 = null;

        org.emftext.language.uml_class.XClass a4_0 = null;

        org.emftext.language.uml_class.XAssociation a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:425:1: (a0= 'classdiagramm' (a1= TEXT ) a2= '{' ( (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )* ( (a4_0= parse_org_emftext_language_uml_005Fclass_XClass ) )* ( (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation ) )* a6= '}' )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:426:1: a0= 'classdiagramm' (a1= TEXT ) a2= '{' ( (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )* ( (a4_0= parse_org_emftext_language_uml_005Fclass_XClass ) )* ( (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation ) )* a6= '}'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,10,FOLLOW_10_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm110); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:440:1: (a1= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:441:2: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm124); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
              		}
              		if (a1 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm139); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:482:1: ( (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=27 && LA1_0<=30)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:483:2: (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:486:2: (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:487:3: a3_0= parse_org_emftext_language_uml_005Fclass_XDataType
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm160);
            	    a3_0=parse_org_emftext_language_uml_005Fclass_XDataType();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      			}
            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
            	      			}
            	      			if (a3_0 != null) {
            	      				if (a3_0 != null) {
            	      					addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__PRIMITIVE_DATATYPES, a3_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a3_0, element); 			}
            	      		
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:510:1: ( (a4_0= parse_org_emftext_language_uml_005Fclass_XClass ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:511:2: (a4_0= parse_org_emftext_language_uml_005Fclass_XClass )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:514:2: (a4_0= parse_org_emftext_language_uml_005Fclass_XClass )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:515:3: a4_0= parse_org_emftext_language_uml_005Fclass_XClass
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm191);
            	    a4_0=parse_org_emftext_language_uml_005Fclass_XClass();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      			}
            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
            	      			}
            	      			if (a4_0 != null) {
            	      				if (a4_0 != null) {
            	      					addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__CLASS, a4_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a4_0, element); 			}
            	      		
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
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:538:1: ( (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:539:2: (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:542:2: (a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:543:3: a5_0= parse_org_emftext_language_uml_005Fclass_XAssociation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XAssociation_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm222);
            	    a5_0=parse_org_emftext_language_uml_005Fclass_XAssociation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      			}
            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
            	      			}
            	      			if (a5_0 != null) {
            	      				if (a5_0 != null) {
            	      					addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__ASSOCIATION, a5_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a5_0, element); 			}
            	      		
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a6=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm243); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a6, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_uml_005Fclass_ClassDiagramm_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_ClassDiagramm"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Method"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:576:1: parse_org_emftext_language_uml_005Fclass_Method returns [org.emftext.language.uml_class.Method element = null] : a0= 'method' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= '(' ( ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* ) )? a10= ')' a11= ':' ( (a12= TEXT ) | a13= 'void' | (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) ;
    public final org.emftext.language.uml_class.Method parse_org_emftext_language_uml_005Fclass_Method() throws RecognitionException {
        org.emftext.language.uml_class.Method element =  null;
        int parse_org_emftext_language_uml_005Fclass_Method_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        org.emftext.language.uml_class.XParameter a7_0 = null;

        org.emftext.language.uml_class.XParameter a9_0 = null;

        org.emftext.language.uml_class.XDataType a14_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:579:1: (a0= 'method' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= '(' ( ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* ) )? a10= ')' a11= ':' ( (a12= TEXT ) | a13= 'void' | (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:580:1: a0= 'method' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= '(' ( ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* ) )? a10= ')' a11= ':' ( (a12= TEXT ) | a13= 'void' | (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_uml_005Fclass_Method269); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:594:1: ( (a1= 'ac' (a2= TEXT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:595:2: (a1= 'ac' (a2= TEXT ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:598:2: (a1= 'ac' (a2= TEXT ) )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:599:3: a1= 'ac' (a2= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Method294); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:613:3: (a2= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:614:4: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method316); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      				}
                      				if (a2 != null) {
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__ACCESS), result);
                      					java.lang.Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
                      					}
                      					org.emftext.language.uml_class.AccessType resolved = (org.emftext.language.uml_class.AccessType)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__ACCESS), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      				}
                      			
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:647:1: ( (a3= 'md' (a4= TEXT ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:648:2: (a3= 'md' (a4= TEXT ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:651:2: (a3= 'md' (a4= TEXT ) )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:652:3: a3= 'md' (a4= TEXT )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a CsString
            	      		
            	    }
            	    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Method361); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
            	      			}
            	      			collectHiddenTokens(element);
            	      			copyLocalizationInfos((CommonToken)a3, element);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:666:3: (a4= TEXT )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:667:4: a4= TEXT
            	    {
            	    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method383); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      				}
            	      				if (element == null) {
            	      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
            	      				}
            	      				if (a4 != null) {
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	      					tokenResolver.setOptions(getOptions());
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
            	      					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__MODIFIER), result);
            	      					java.lang.Object resolvedObject = result.getResolvedToken();
            	      					if (resolvedObject == null) {
            	      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
            	      					}
            	      					org.emftext.language.uml_class.ModifierType resolved = (org.emftext.language.uml_class.ModifierType)resolvedObject;
            	      					if (resolved != null) {
            	      						addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.METHOD__MODIFIER, resolved);
            	      					}
            	      					collectHiddenTokens(element);
            	      					copyLocalizationInfos((CommonToken) a4, element);
            	      				}
            	      			
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:703:1: (a5= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:704:2: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method419); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
              		}
              		if (a5 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a5).getLine(), ((org.antlr.runtime.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a5).getStartIndex(), ((org.antlr.runtime.CommonToken) a5).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a5, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a6=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_uml_005Fclass_Method434); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a6, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:745:1: ( ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==TEXT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:746:2: ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:749:2: ( (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )* )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:750:3: (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:753:3: (a7_0= parse_org_emftext_language_uml_005Fclass_XParameter )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:754:4: a7_0= parse_org_emftext_language_uml_005Fclass_XParameter
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XParameter_in_parse_org_emftext_language_uml_005Fclass_Method464);
                    a7_0=parse_org_emftext_language_uml_005Fclass_XParameter();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      				}
                      				if (a7_0 != null) {
                      					if (a7_0 != null) {
                      						addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.METHOD__PARAMETER, a7_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a7_0, element); 				}
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:773:3: ( (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:774:4: (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:777:4: (a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter ) )
                    	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:778:5: a8= ',' (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a8=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_uml_005Fclass_Method509); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a8, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:792:5: (a9_0= parse_org_emftext_language_uml_005Fclass_XParameter )
                    	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:793:6: a9_0= parse_org_emftext_language_uml_005Fclass_XParameter
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XParameter_in_parse_org_emftext_language_uml_005Fclass_Method539);
                    	    a9_0=parse_org_emftext_language_uml_005Fclass_XParameter();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                    	      						}
                    	      						if (element == null) {
                    	      							element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                    	      						}
                    	      						if (a9_0 != null) {
                    	      							if (a9_0 != null) {
                    	      								addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.METHOD__PARAMETER, a9_0);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							copyLocalizationInfos(a9_0, element); 						}
                    	      					
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a10=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_uml_005Fclass_Method592); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a10, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a11=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Method603); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a11, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Compound

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:843:1: ( (a12= TEXT ) | a13= 'void' | (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case TEXT:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
                {
                alt8=3;
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
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:844:2: (a12= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:847:2: (a12= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:848:3: a12= TEXT
                    {
                    a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method624); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      			}
                      			if (a12 != null) {
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      				tokenResolver.setOptions(getOptions());
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN), result);
                      				java.lang.Object resolvedObject = result.getResolvedToken();
                      				if (resolvedObject == null) {
                      					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a12).getLine(), ((org.antlr.runtime.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a12).getStartIndex(), ((org.antlr.runtime.CommonToken) a12).getStopIndex());
                      				}
                      				String resolved = (String) resolvedObject;
                      				org.emftext.language.uml_class.Class proxy = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      				collectHiddenTokens(element);
                      				registerContextDependentProxy(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragmentFactory<org.emftext.language.uml_class.Method, org.emftext.language.uml_class.XClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMethodReturnReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN), resolved, proxy);
                      				if (proxy != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN), proxy);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken) a12, element);
                      				copyLocalizationInfos((CommonToken) a12, proxy);
                      			}
                      		
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:880:4: a13= 'void'
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a CsString
                      	
                    }
                    a13=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_uml_005Fclass_Method649); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a13, element);
                      	
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:892:4: (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:895:2: (a14_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:896:3: a14_0= parse_org_emftext_language_uml_005Fclass_XDataType
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Method671);
                    a14_0=parse_org_emftext_language_uml_005Fclass_XDataType();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
                      			}
                      			if (a14_0 != null) {
                      				if (a14_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PRETURN), a14_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a14_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_uml_005Fclass_Method_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Method"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Attribute"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:916:1: parse_org_emftext_language_uml_005Fclass_Attribute returns [org.emftext.language.uml_class.Attribute element = null] : a0= 'attribute' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= ':' ( (a7= TEXT ) | (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) ;
    public final org.emftext.language.uml_class.Attribute parse_org_emftext_language_uml_005Fclass_Attribute() throws RecognitionException {
        org.emftext.language.uml_class.Attribute element =  null;
        int parse_org_emftext_language_uml_005Fclass_Attribute_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        org.emftext.language.uml_class.XDataType a8_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:919:1: (a0= 'attribute' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= ':' ( (a7= TEXT ) | (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:920:1: a0= 'attribute' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) a6= ':' ( (a7= TEXT ) | (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_uml_005Fclass_Attribute705); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:934:1: ( (a1= 'ac' (a2= TEXT ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:935:2: (a1= 'ac' (a2= TEXT ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:938:2: (a1= 'ac' (a2= TEXT ) )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:939:3: a1= 'ac' (a2= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Attribute730); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:953:3: (a2= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:954:4: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute752); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
                      				}
                      				if (a2 != null) {
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__ACCESS), result);
                      					java.lang.Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
                      					}
                      					org.emftext.language.uml_class.AccessType resolved = (org.emftext.language.uml_class.AccessType)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__ACCESS), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      				}
                      			
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:987:1: ( (a3= 'md' (a4= TEXT ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:988:2: (a3= 'md' (a4= TEXT ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:991:2: (a3= 'md' (a4= TEXT ) )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:992:3: a3= 'md' (a4= TEXT )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a CsString
            	      		
            	    }
            	    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Attribute797); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
            	      			}
            	      			collectHiddenTokens(element);
            	      			copyLocalizationInfos((CommonToken)a3, element);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1006:3: (a4= TEXT )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1007:4: a4= TEXT
            	    {
            	    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute819); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      				}
            	      				if (element == null) {
            	      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
            	      				}
            	      				if (a4 != null) {
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	      					tokenResolver.setOptions(getOptions());
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
            	      					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__MODIFIER), result);
            	      					java.lang.Object resolvedObject = result.getResolvedToken();
            	      					if (resolvedObject == null) {
            	      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
            	      					}
            	      					org.emftext.language.uml_class.ModifierType resolved = (org.emftext.language.uml_class.ModifierType)resolvedObject;
            	      					if (resolved != null) {
            	      						addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__MODIFIER, resolved);
            	      					}
            	      					collectHiddenTokens(element);
            	      					copyLocalizationInfos((CommonToken) a4, element);
            	      				}
            	      			
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1043:1: (a5= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1044:2: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute855); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
              		}
              		if (a5 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a5).getLine(), ((org.antlr.runtime.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a5).getStartIndex(), ((org.antlr.runtime.CommonToken) a5).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a5, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a6=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Attribute870); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a6, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Compound

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1085:1: ( (a7= TEXT ) | (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==TEXT) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=27 && LA11_0<=30)) ) {
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
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1086:2: (a7= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1089:2: (a7= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1090:3: a7= TEXT
                    {
                    a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute891); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
                      			}
                      			if (a7 != null) {
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      				tokenResolver.setOptions(getOptions());
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE), result);
                      				java.lang.Object resolvedObject = result.getResolvedToken();
                      				if (resolvedObject == null) {
                      					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a7).getLine(), ((org.antlr.runtime.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a7).getStartIndex(), ((org.antlr.runtime.CommonToken) a7).getStopIndex());
                      				}
                      				String resolved = (String) resolvedObject;
                      				org.emftext.language.uml_class.Class proxy = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      				collectHiddenTokens(element);
                      				registerContextDependentProxy(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragmentFactory<org.emftext.language.uml_class.Attribute, org.emftext.language.uml_class.XClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE), resolved, proxy);
                      				if (proxy != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE), proxy);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken) a7, element);
                      				copyLocalizationInfos((CommonToken) a7, proxy);
                      			}
                      		
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1122:4: (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1125:2: (a8_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1126:3: a8_0= parse_org_emftext_language_uml_005Fclass_XDataType
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Attribute920);
                    a8_0=parse_org_emftext_language_uml_005Fclass_XDataType();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
                      			}
                      			if (a8_0 != null) {
                      				if (a8_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__PTYPE), a8_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a8_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_uml_005Fclass_Attribute_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Attribute"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Parameter"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1146:1: parse_org_emftext_language_uml_005Fclass_Parameter returns [org.emftext.language.uml_class.Parameter element = null] : (a0= TEXT ) a1= ':' ( (a2= TEXT ) | (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) ;
    public final org.emftext.language.uml_class.Parameter parse_org_emftext_language_uml_005Fclass_Parameter() throws RecognitionException {
        org.emftext.language.uml_class.Parameter element =  null;
        int parse_org_emftext_language_uml_005Fclass_Parameter_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.language.uml_class.XDataType a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1149:1: ( (a0= TEXT ) a1= ':' ( (a2= TEXT ) | (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1150:1: (a0= TEXT ) a1= ':' ( (a2= TEXT ) | (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1153:1: (a0= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1154:2: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Parameter957); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createParameter();
              		}
              		if (a0 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Parameter972); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createParameter();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Compound

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1195:1: ( (a2= TEXT ) | (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==TEXT) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=27 && LA12_0<=30)) ) {
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
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1196:2: (a2= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1199:2: (a2= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1200:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Parameter993); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createParameter();
                      			}
                      			if (a2 != null) {
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      				tokenResolver.setOptions(getOptions());
                      				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE), result);
                      				java.lang.Object resolvedObject = result.getResolvedToken();
                      				if (resolvedObject == null) {
                      					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
                      				}
                      				String resolved = (String) resolvedObject;
                      				org.emftext.language.uml_class.Class proxy = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      				collectHiddenTokens(element);
                      				registerContextDependentProxy(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragmentFactory<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.XClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE), resolved, proxy);
                      				if (proxy != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE), proxy);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken) a2, element);
                      				copyLocalizationInfos((CommonToken) a2, proxy);
                      			}
                      		
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1232:4: (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1235:2: (a3_0= parse_org_emftext_language_uml_005Fclass_XDataType )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1236:3: a3_0= parse_org_emftext_language_uml_005Fclass_XDataType
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Parameter1022);
                    a3_0=parse_org_emftext_language_uml_005Fclass_XDataType();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createParameter();
                      			}
                      			if (a3_0 != null) {
                      				if (a3_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__PTYPE), a3_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a3_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_uml_005Fclass_Parameter_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Parameter"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Class"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1256:1: parse_org_emftext_language_uml_005Fclass_Class returns [org.emftext.language.uml_class.Class element = null] : a0= 'class' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) ( (a6= 'extends' (a7= TEXT ) ) )? a8= '{' ( (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute ) )* ( (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod ) )* a11= '}' ;
    public final org.emftext.language.uml_class.Class parse_org_emftext_language_uml_005Fclass_Class() throws RecognitionException {
        org.emftext.language.uml_class.Class element =  null;
        int parse_org_emftext_language_uml_005Fclass_Class_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a11=null;
        org.emftext.language.uml_class.XAttribute a9_0 = null;

        org.emftext.language.uml_class.XMethod a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1259:1: (a0= 'class' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) ( (a6= 'extends' (a7= TEXT ) ) )? a8= '{' ( (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute ) )* ( (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod ) )* a11= '}' )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1260:1: a0= 'class' ( (a1= 'ac' (a2= TEXT ) ) )? ( (a3= 'md' (a4= TEXT ) ) )* (a5= TEXT ) ( (a6= 'extends' (a7= TEXT ) ) )? a8= '{' ( (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute ) )* ( (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod ) )* a11= '}'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_uml_005Fclass_Class1056); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1274:1: ( (a1= 'ac' (a2= TEXT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1275:2: (a1= 'ac' (a2= TEXT ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1278:2: (a1= 'ac' (a2= TEXT ) )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1279:3: a1= 'ac' (a2= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Class1081); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1293:3: (a2= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1294:4: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1103); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      				}
                      				if (a2 != null) {
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ACCESS), result);
                      					java.lang.Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
                      					}
                      					org.emftext.language.uml_class.AccessType resolved = (org.emftext.language.uml_class.AccessType)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ACCESS), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      				}
                      			
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1327:1: ( (a3= 'md' (a4= TEXT ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1328:2: (a3= 'md' (a4= TEXT ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1331:2: (a3= 'md' (a4= TEXT ) )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1332:3: a3= 'md' (a4= TEXT )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a CsString
            	      		
            	    }
            	    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Class1148); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
            	      			}
            	      			collectHiddenTokens(element);
            	      			copyLocalizationInfos((CommonToken)a3, element);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1346:3: (a4= TEXT )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1347:4: a4= TEXT
            	    {
            	    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1170); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      				}
            	      				if (element == null) {
            	      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
            	      				}
            	      				if (a4 != null) {
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	      					tokenResolver.setOptions(getOptions());
            	      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
            	      					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__MODIFIER), result);
            	      					java.lang.Object resolvedObject = result.getResolvedToken();
            	      					if (resolvedObject == null) {
            	      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
            	      					}
            	      					org.emftext.language.uml_class.ModifierType resolved = (org.emftext.language.uml_class.ModifierType)resolvedObject;
            	      					if (resolved != null) {
            	      						addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS__MODIFIER, resolved);
            	      					}
            	      					collectHiddenTokens(element);
            	      					copyLocalizationInfos((CommonToken) a4, element);
            	      				}
            	      			
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1383:1: (a5= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1384:2: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1206); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
              		}
              		if (a5 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a5).getLine(), ((org.antlr.runtime.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a5).getStartIndex(), ((org.antlr.runtime.CommonToken) a5).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a5, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1414:1: ( (a6= 'extends' (a7= TEXT ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1415:2: (a6= 'extends' (a7= TEXT ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1418:2: (a6= 'extends' (a7= TEXT ) )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1419:3: a6= 'extends' (a7= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a6=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_uml_005Fclass_Class1235); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a6, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1433:3: (a7= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1434:4: a7= TEXT
                    {
                    a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1257); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      				}
                      				if (a7 != null) {
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT), result);
                      					java.lang.Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a7).getLine(), ((org.antlr.runtime.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a7).getStartIndex(), ((org.antlr.runtime.CommonToken) a7).getStopIndex());
                      					}
                      					String resolved = (String) resolvedObject;
                      					org.emftext.language.uml_class.Class proxy = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
                      					collectHiddenTokens(element);
                      					registerContextDependentProxy(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragmentFactory<org.emftext.language.uml_class.Class, org.emftext.language.uml_class.XClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT), resolved, proxy);
                      					if (proxy != null) {
                      						addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT, proxy);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a7, element);
                      					copyLocalizationInfos((CommonToken) a7, proxy);
                      				}
                      			
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a8=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_uml_005Fclass_Class1288); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a8, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1482:1: ( (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==21) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1483:2: (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1486:2: (a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1487:3: a9_0= parse_org_emftext_language_uml_005Fclass_XAttribute
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XAttribute_in_parse_org_emftext_language_uml_005Fclass_Class1309);
            	    a9_0=parse_org_emftext_language_uml_005Fclass_XAttribute();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      			}
            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
            	      			}
            	      			if (a9_0 != null) {
            	      				if (a9_0 != null) {
            	      					addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS__ATTRIBUTE, a9_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a9_0, element); 			}
            	      		
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1510:1: ( (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==13) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1511:2: (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1514:2: (a10_0= parse_org_emftext_language_uml_005Fclass_XMethod )
            	    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1515:3: a10_0= parse_org_emftext_language_uml_005Fclass_XMethod
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XMethod_in_parse_org_emftext_language_uml_005Fclass_Class1340);
            	    a10_0=parse_org_emftext_language_uml_005Fclass_XMethod();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
            	      			}
            	      			if (element == null) {
            	      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
            	      			}
            	      			if (a10_0 != null) {
            	      				if (a10_0 != null) {
            	      					addObjectToList(element, org.emftext.language.uml_class.Uml_classPackage.CLASS__METHOD, a10_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a10_0, element); 			}
            	      		
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a11=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_uml_005Fclass_Class1361); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a11, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_uml_005Fclass_Class_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Class"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Association"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1548:1: parse_org_emftext_language_uml_005Fclass_Association returns [org.emftext.language.uml_class.Association element = null] : a0= 'association' (a1= TEXT ) a2= '(' (a3_0= parse_org_emftext_language_uml_005Fclass_XClass ) a4= '->' (a5_0= parse_org_emftext_language_uml_005Fclass_XClass ) a6= ':' (a7= QUOTED_34_34 ) a8= '..' (a9= QUOTED_34_34 ) a10= ')' ;
    public final org.emftext.language.uml_class.Association parse_org_emftext_language_uml_005Fclass_Association() throws RecognitionException {
        org.emftext.language.uml_class.Association element =  null;
        int parse_org_emftext_language_uml_005Fclass_Association_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        org.emftext.language.uml_class.XClass a3_0 = null;

        org.emftext.language.uml_class.XClass a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1551:1: (a0= 'association' (a1= TEXT ) a2= '(' (a3_0= parse_org_emftext_language_uml_005Fclass_XClass ) a4= '->' (a5_0= parse_org_emftext_language_uml_005Fclass_XClass ) a6= ':' (a7= QUOTED_34_34 ) a8= '..' (a9= QUOTED_34_34 ) a10= ')' )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1552:1: a0= 'association' (a1= TEXT ) a2= '(' (a3_0= parse_org_emftext_language_uml_005Fclass_XClass ) a4= '->' (a5_0= parse_org_emftext_language_uml_005Fclass_XClass ) a6= ':' (a7= QUOTED_34_34 ) a8= '..' (a9= QUOTED_34_34 ) a10= ')'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_uml_005Fclass_Association1387); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1566:1: (a1= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1567:2: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Association1401); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              		}
              		if (a1 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_uml_005Fclass_Association1416); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1608:1: (a3_0= parse_org_emftext_language_uml_005Fclass_XClass )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1609:2: a3_0= parse_org_emftext_language_uml_005Fclass_XClass
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_Association1430);
            a3_0=parse_org_emftext_language_uml_005Fclass_XClass();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              		}
              		if (a3_0 != null) {
              			if (a3_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__SOURCE), a3_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a3_0, element); 		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a4=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_uml_005Fclass_Association1443); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a4, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1639:1: (a5_0= parse_org_emftext_language_uml_005Fclass_XClass )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1640:2: a5_0= parse_org_emftext_language_uml_005Fclass_XClass
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_Association1457);
            a5_0=parse_org_emftext_language_uml_005Fclass_XClass();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              		}
              		if (a5_0 != null) {
              			if (a5_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__TARGET), a5_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a5_0, element); 		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a6=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Association1470); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a6, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1670:1: (a7= QUOTED_34_34 )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1671:2: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_uml_005Fclass_Association1484); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              		}
              		if (a7 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MIN_CARDINALITY), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a7).getLine(), ((org.antlr.runtime.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a7).getStartIndex(), ((org.antlr.runtime.CommonToken) a7).getStopIndex());
              			}
              			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MIN_CARDINALITY), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a7, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a8=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_uml_005Fclass_Association1499); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a8, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1712:1: (a9= QUOTED_34_34 )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1713:2: a9= QUOTED_34_34
            {
            a9=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_uml_005Fclass_Association1513); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              		}
              		if (a9 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MAX_CARDINALITY), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a9).getLine(), ((org.antlr.runtime.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a9).getStartIndex(), ((org.antlr.runtime.CommonToken) a9).getStopIndex());
              			}
              			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MAX_CARDINALITY), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a9, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a10=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_uml_005Fclass_Association1528); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a10, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_uml_005Fclass_Association_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Association"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Boolean"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1753:1: parse_org_emftext_language_uml_005Fclass_Boolean returns [org.emftext.language.uml_class.Boolean element = null] : a0= 'BOOLEAN' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject ) )? ;
    public final org.emftext.language.uml_class.Boolean parse_org_emftext_language_uml_005Fclass_Boolean() throws RecognitionException {
        org.emftext.language.uml_class.Boolean element =  null;
        int parse_org_emftext_language_uml_005Fclass_Boolean_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.primitive_types.BooleanObject a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1756:1: (a0= 'BOOLEAN' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject ) )? )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1757:1: a0= 'BOOLEAN' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_uml_005Fclass_Boolean1554); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createBoolean();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1771:1: (a1= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1772:2: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Boolean1568); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createBoolean();
              		}
              		if (a1 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1802:1: ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QUOTED_34_34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1803:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1806:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1807:3: a2_0= parse_org_emftext_language_primitive_005Ftypes_BooleanObject
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_primitive_005Ftypes_BooleanObject_in_parse_org_emftext_language_uml_005Fclass_Boolean1593);
                    a2_0=parse_org_emftext_language_primitive_005Ftypes_BooleanObject();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createBoolean();
                      			}
                      			if (a2_0 != null) {
                      				if (a2_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__VALUE), a2_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a2_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_uml_005Fclass_Boolean_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Boolean"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_String"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1826:1: parse_org_emftext_language_uml_005Fclass_String returns [org.emftext.language.uml_class.String element = null] : a0= 'STRING' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject ) )? ;
    public final org.emftext.language.uml_class.String parse_org_emftext_language_uml_005Fclass_String() throws RecognitionException {
        org.emftext.language.uml_class.String element =  null;
        int parse_org_emftext_language_uml_005Fclass_String_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.primitive_types.StringObject a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1829:1: (a0= 'STRING' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject ) )? )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1830:1: a0= 'STRING' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_uml_005Fclass_String1627); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createString();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1844:1: (a1= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1845:2: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_String1641); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createString();
              		}
              		if (a1 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1875:1: ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QUOTED_34_34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1876:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1879:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1880:3: a2_0= parse_org_emftext_language_primitive_005Ftypes_StringObject
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_primitive_005Ftypes_StringObject_in_parse_org_emftext_language_uml_005Fclass_String1666);
                    a2_0=parse_org_emftext_language_primitive_005Ftypes_StringObject();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createString();
                      			}
                      			if (a2_0 != null) {
                      				if (a2_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__VALUE), a2_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a2_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_uml_005Fclass_String_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_String"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_Integer"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1899:1: parse_org_emftext_language_uml_005Fclass_Integer returns [org.emftext.language.uml_class.Integer element = null] : a0= 'INTEGER' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject ) )? ;
    public final org.emftext.language.uml_class.Integer parse_org_emftext_language_uml_005Fclass_Integer() throws RecognitionException {
        org.emftext.language.uml_class.Integer element =  null;
        int parse_org_emftext_language_uml_005Fclass_Integer_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.primitive_types.IntegerObject a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1902:1: (a0= 'INTEGER' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject ) )? )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1903:1: a0= 'INTEGER' (a1= TEXT ) ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_uml_005Fclass_Integer1700); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createInteger();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1917:1: (a1= TEXT )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1918:2: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Integer1714); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createInteger();
              		}
              		if (a1 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__NAME), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1948:1: ( (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==QUOTED_34_34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1949:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1952:2: (a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1953:3: a2_0= parse_org_emftext_language_primitive_005Ftypes_IntegerObject
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_primitive_005Ftypes_IntegerObject_in_parse_org_emftext_language_uml_005Fclass_Integer1739);
                    a2_0=parse_org_emftext_language_primitive_005Ftypes_IntegerObject();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createInteger();
                      			}
                      			if (a2_0 != null) {
                      				if (a2_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__VALUE), a2_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a2_0, element); 			}
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_uml_005Fclass_Integer_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_Integer"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_PrimitiveDataType"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1972:1: parse_org_emftext_language_uml_005Fclass_PrimitiveDataType returns [org.emftext.language.uml_class.PrimitiveDataType element = null] : (a0= 'TYPE' (a1= TEXT ) | c0= parse_org_emftext_language_uml_005Fclass_Boolean | c1= parse_org_emftext_language_uml_005Fclass_String | c2= parse_org_emftext_language_uml_005Fclass_Integer );
    public final org.emftext.language.uml_class.PrimitiveDataType parse_org_emftext_language_uml_005Fclass_PrimitiveDataType() throws RecognitionException {
        org.emftext.language.uml_class.PrimitiveDataType element =  null;
        int parse_org_emftext_language_uml_005Fclass_PrimitiveDataType_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        org.emftext.language.uml_class.Boolean c0 = null;

        org.emftext.language.uml_class.String c1 = null;

        org.emftext.language.uml_class.Integer c2 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1975:1: (a0= 'TYPE' (a1= TEXT ) | c0= parse_org_emftext_language_uml_005Fclass_Boolean | c1= parse_org_emftext_language_uml_005Fclass_String | c2= parse_org_emftext_language_uml_005Fclass_Integer )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt21=1;
                }
                break;
            case 27:
                {
                alt21=2;
                }
                break;
            case 28:
                {
                alt21=3;
                }
                break;
            case 29:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1976:1: a0= 'TYPE' (a1= TEXT )
                    {
                    if ( state.backtracking==0 ) {

                      	// expected element is a CsString

                    }
                    a0=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1773); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      	if (element == null) {
                      		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createPrimitiveDataType();
                      	}
                      	collectHiddenTokens(element);
                      	copyLocalizationInfos((CommonToken)a0, element);

                    }
                    if ( state.backtracking==0 ) {

                      	// expected element is a Terminal

                    }
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1990:1: (a1= TEXT )
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:1991:2: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1787); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (terminateParsing) {
                      			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
                      		}
                      		if (element == null) {
                      			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createPrimitiveDataType();
                      		}
                      		if (a1 != null) {
                      			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      			tokenResolver.setOptions(getOptions());
                      			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
                      			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PRIMITIVE_DATA_TYPE__NAME), result);
                      			java.lang.Object resolvedObject = result.getResolvedToken();
                      			if (resolvedObject == null) {
                      				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
                      			}
                      			java.lang.String resolved = (java.lang.String)resolvedObject;
                      			if (resolved != null) {
                      				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PRIMITIVE_DATA_TYPE__NAME), resolved);
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken) a1, element);
                      		}
                      	
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2020:1: c0= parse_org_emftext_language_uml_005Fclass_Boolean
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1803);
                    c0=parse_org_emftext_language_uml_005Fclass_Boolean();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2021:2: c1= parse_org_emftext_language_uml_005Fclass_String
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1811);
                    c1=parse_org_emftext_language_uml_005Fclass_String();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2022:2: c2= parse_org_emftext_language_uml_005Fclass_Integer
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1819);
                    c2=parse_org_emftext_language_uml_005Fclass_Integer();

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
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_uml_005Fclass_PrimitiveDataType_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_PrimitiveDataType"


    // $ANTLR start "parse_org_emftext_language_primitive_005Ftypes_BooleanObject"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2026:1: parse_org_emftext_language_primitive_005Ftypes_BooleanObject returns [org.emftext.language.primitive_types.BooleanObject element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.language.primitive_types.BooleanObject parse_org_emftext_language_primitive_005Ftypes_BooleanObject() throws RecognitionException {
        org.emftext.language.primitive_types.BooleanObject element =  null;
        int parse_org_emftext_language_primitive_005Ftypes_BooleanObject_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2029:1: ( (a0= QUOTED_34_34 ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2030:1: (a0= QUOTED_34_34 )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2033:1: (a0= QUOTED_34_34 )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2034:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_BooleanObject1847); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.primitive_types.Primitive_typesFactory.eINSTANCE.createBooleanObject();
              		}
              		if (a0 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.BOOLEAN_OBJECT__VALUE), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.BOOLEAN_OBJECT__VALUE), resolved);
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
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_primitive_005Ftypes_BooleanObject_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_primitive_005Ftypes_BooleanObject"


    // $ANTLR start "parse_org_emftext_language_primitive_005Ftypes_IntegerObject"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2063:1: parse_org_emftext_language_primitive_005Ftypes_IntegerObject returns [org.emftext.language.primitive_types.IntegerObject element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.language.primitive_types.IntegerObject parse_org_emftext_language_primitive_005Ftypes_IntegerObject() throws RecognitionException {
        org.emftext.language.primitive_types.IntegerObject element =  null;
        int parse_org_emftext_language_primitive_005Ftypes_IntegerObject_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2066:1: ( (a0= QUOTED_34_34 ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2067:1: (a0= QUOTED_34_34 )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2070:1: (a0= QUOTED_34_34 )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2071:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_IntegerObject1880); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.primitive_types.Primitive_typesFactory.eINSTANCE.createIntegerObject();
              		}
              		if (a0 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.INTEGER_OBJECT__VALUE), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.INTEGER_OBJECT__VALUE), resolved);
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
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_primitive_005Ftypes_IntegerObject_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_primitive_005Ftypes_IntegerObject"


    // $ANTLR start "parse_org_emftext_language_primitive_005Ftypes_StringObject"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2100:1: parse_org_emftext_language_primitive_005Ftypes_StringObject returns [org.emftext.language.primitive_types.StringObject element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.language.primitive_types.StringObject parse_org_emftext_language_primitive_005Ftypes_StringObject() throws RecognitionException {
        org.emftext.language.primitive_types.StringObject element =  null;
        int parse_org_emftext_language_primitive_005Ftypes_StringObject_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2103:1: ( (a0= QUOTED_34_34 ) )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2104:1: (a0= QUOTED_34_34 )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2107:1: (a0= QUOTED_34_34 )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2108:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_StringObject1913); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.language.primitive_types.Primitive_typesFactory.eINSTANCE.createStringObject();
              		}
              		if (a0 != null) {
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.STRING_OBJECT__VALUE), result);
              			java.lang.Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.STRING_OBJECT__VALUE), resolved);
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
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_primitive_005Ftypes_StringObject_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_primitive_005Ftypes_StringObject"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XDataType"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2137:1: parse_org_emftext_language_uml_005Fclass_XDataType returns [org.emftext.language.uml_class.XDataType element = null] : (c0= parse_org_emftext_language_uml_005Fclass_Boolean | c1= parse_org_emftext_language_uml_005Fclass_String | c2= parse_org_emftext_language_uml_005Fclass_Integer | c3= parse_org_emftext_language_uml_005Fclass_PrimitiveDataType );
    public final org.emftext.language.uml_class.XDataType parse_org_emftext_language_uml_005Fclass_XDataType() throws RecognitionException {
        org.emftext.language.uml_class.XDataType element =  null;
        int parse_org_emftext_language_uml_005Fclass_XDataType_StartIndex = input.index();
        org.emftext.language.uml_class.Boolean c0 = null;

        org.emftext.language.uml_class.String c1 = null;

        org.emftext.language.uml_class.Integer c2 = null;

        org.emftext.language.uml_class.PrimitiveDataType c3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2138:1: (c0= parse_org_emftext_language_uml_005Fclass_Boolean | c1= parse_org_emftext_language_uml_005Fclass_String | c2= parse_org_emftext_language_uml_005Fclass_Integer | c3= parse_org_emftext_language_uml_005Fclass_PrimitiveDataType )
            int alt22=4;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2139:1: c0= parse_org_emftext_language_uml_005Fclass_Boolean
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_parse_org_emftext_language_uml_005Fclass_XDataType1937);
                    c0=parse_org_emftext_language_uml_005Fclass_Boolean();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2140:2: c1= parse_org_emftext_language_uml_005Fclass_String
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_parse_org_emftext_language_uml_005Fclass_XDataType1945);
                    c1=parse_org_emftext_language_uml_005Fclass_String();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2141:2: c2= parse_org_emftext_language_uml_005Fclass_Integer
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_parse_org_emftext_language_uml_005Fclass_XDataType1953);
                    c2=parse_org_emftext_language_uml_005Fclass_Integer();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2142:2: c3= parse_org_emftext_language_uml_005Fclass_PrimitiveDataType
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType_in_parse_org_emftext_language_uml_005Fclass_XDataType1961);
                    c3=parse_org_emftext_language_uml_005Fclass_PrimitiveDataType();

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
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_uml_005Fclass_XDataType_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XDataType"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XClass"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2146:1: parse_org_emftext_language_uml_005Fclass_XClass returns [org.emftext.language.uml_class.XClass element = null] : c0= parse_org_emftext_language_uml_005Fclass_Class ;
    public final org.emftext.language.uml_class.XClass parse_org_emftext_language_uml_005Fclass_XClass() throws RecognitionException {
        org.emftext.language.uml_class.XClass element =  null;
        int parse_org_emftext_language_uml_005Fclass_XClass_StartIndex = input.index();
        org.emftext.language.uml_class.Class c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2147:1: (c0= parse_org_emftext_language_uml_005Fclass_Class )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2148:1: c0= parse_org_emftext_language_uml_005Fclass_Class
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Class_in_parse_org_emftext_language_uml_005Fclass_XClass1980);
            c0=parse_org_emftext_language_uml_005Fclass_Class();

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
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_uml_005Fclass_XClass_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XClass"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XAssociation"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2152:1: parse_org_emftext_language_uml_005Fclass_XAssociation returns [org.emftext.language.uml_class.XAssociation element = null] : c0= parse_org_emftext_language_uml_005Fclass_Association ;
    public final org.emftext.language.uml_class.XAssociation parse_org_emftext_language_uml_005Fclass_XAssociation() throws RecognitionException {
        org.emftext.language.uml_class.XAssociation element =  null;
        int parse_org_emftext_language_uml_005Fclass_XAssociation_StartIndex = input.index();
        org.emftext.language.uml_class.Association c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2153:1: (c0= parse_org_emftext_language_uml_005Fclass_Association )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2154:1: c0= parse_org_emftext_language_uml_005Fclass_Association
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Association_in_parse_org_emftext_language_uml_005Fclass_XAssociation1999);
            c0=parse_org_emftext_language_uml_005Fclass_Association();

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
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_uml_005Fclass_XAssociation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XAssociation"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XParameter"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2158:1: parse_org_emftext_language_uml_005Fclass_XParameter returns [org.emftext.language.uml_class.XParameter element = null] : c0= parse_org_emftext_language_uml_005Fclass_Parameter ;
    public final org.emftext.language.uml_class.XParameter parse_org_emftext_language_uml_005Fclass_XParameter() throws RecognitionException {
        org.emftext.language.uml_class.XParameter element =  null;
        int parse_org_emftext_language_uml_005Fclass_XParameter_StartIndex = input.index();
        org.emftext.language.uml_class.Parameter c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2159:1: (c0= parse_org_emftext_language_uml_005Fclass_Parameter )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2160:1: c0= parse_org_emftext_language_uml_005Fclass_Parameter
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Parameter_in_parse_org_emftext_language_uml_005Fclass_XParameter2018);
            c0=parse_org_emftext_language_uml_005Fclass_Parameter();

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
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_uml_005Fclass_XParameter_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XParameter"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XAttribute"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2164:1: parse_org_emftext_language_uml_005Fclass_XAttribute returns [org.emftext.language.uml_class.XAttribute element = null] : c0= parse_org_emftext_language_uml_005Fclass_Attribute ;
    public final org.emftext.language.uml_class.XAttribute parse_org_emftext_language_uml_005Fclass_XAttribute() throws RecognitionException {
        org.emftext.language.uml_class.XAttribute element =  null;
        int parse_org_emftext_language_uml_005Fclass_XAttribute_StartIndex = input.index();
        org.emftext.language.uml_class.Attribute c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2165:1: (c0= parse_org_emftext_language_uml_005Fclass_Attribute )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2166:1: c0= parse_org_emftext_language_uml_005Fclass_Attribute
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Attribute_in_parse_org_emftext_language_uml_005Fclass_XAttribute2037);
            c0=parse_org_emftext_language_uml_005Fclass_Attribute();

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
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_uml_005Fclass_XAttribute_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XAttribute"


    // $ANTLR start "parse_org_emftext_language_uml_005Fclass_XMethod"
    // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2170:1: parse_org_emftext_language_uml_005Fclass_XMethod returns [org.emftext.language.uml_class.XMethod element = null] : c0= parse_org_emftext_language_uml_005Fclass_Method ;
    public final org.emftext.language.uml_class.XMethod parse_org_emftext_language_uml_005Fclass_XMethod() throws RecognitionException {
        org.emftext.language.uml_class.XMethod element =  null;
        int parse_org_emftext_language_uml_005Fclass_XMethod_StartIndex = input.index();
        org.emftext.language.uml_class.Method c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2171:1: (c0= parse_org_emftext_language_uml_005Fclass_Method )
            // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2172:1: c0= parse_org_emftext_language_uml_005Fclass_Method
            {
            pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Method_in_parse_org_emftext_language_uml_005Fclass_XMethod2056);
            c0=parse_org_emftext_language_uml_005Fclass_Method();

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
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_uml_005Fclass_XMethod_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_uml_005Fclass_XMethod"

    // $ANTLR start synpred25_Uml_class
    public final void synpred25_Uml_class_fragment() throws RecognitionException {   
        org.emftext.language.uml_class.Boolean c0 = null;


        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2139:1: (c0= parse_org_emftext_language_uml_005Fclass_Boolean )
        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2139:1: c0= parse_org_emftext_language_uml_005Fclass_Boolean
        {
        pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_synpred25_Uml_class1937);
        c0=parse_org_emftext_language_uml_005Fclass_Boolean();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Uml_class

    // $ANTLR start synpred26_Uml_class
    public final void synpred26_Uml_class_fragment() throws RecognitionException {   
        org.emftext.language.uml_class.String c1 = null;


        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2140:2: (c1= parse_org_emftext_language_uml_005Fclass_String )
        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2140:2: c1= parse_org_emftext_language_uml_005Fclass_String
        {
        pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_synpred26_Uml_class1945);
        c1=parse_org_emftext_language_uml_005Fclass_String();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Uml_class

    // $ANTLR start synpred27_Uml_class
    public final void synpred27_Uml_class_fragment() throws RecognitionException {   
        org.emftext.language.uml_class.Integer c2 = null;


        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2141:2: (c2= parse_org_emftext_language_uml_005Fclass_Integer )
        // /Users/jj2/workspaces/EMFTextDev/org.emftext.language.uml_class.resource.uml_class/src-gen/org/emftext/language/uml_class/resource/uml_class/mopp/Uml_class.g:2141:2: c2= parse_org_emftext_language_uml_005Fclass_Integer
        {
        pushFollow(FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_synpred27_Uml_class1953);
        c2=parse_org_emftext_language_uml_005Fclass_Integer();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_Uml_class

    // Delegated rules

    public final boolean synpred26_Uml_class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Uml_class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_Uml_class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Uml_class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_Uml_class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Uml_class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\13\uffff";
    static final String DFA22_eofS =
        "\13\uffff";
    static final String DFA22_minS =
        "\1\33\3\4\1\uffff\3\0\3\uffff";
    static final String DFA22_maxS =
        "\1\36\3\4\1\uffff\3\0\3\uffff";
    static final String DFA22_acceptS =
        "\4\uffff\1\4\3\uffff\1\1\1\2\1\3";
    static final String DFA22_specialS =
        "\5\uffff\1\2\1\0\1\1\3\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\2\1\3\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "2137:1: parse_org_emftext_language_uml_005Fclass_XDataType returns [org.emftext.language.uml_class.XDataType element = null] : (c0= parse_org_emftext_language_uml_005Fclass_Boolean | c1= parse_org_emftext_language_uml_005Fclass_String | c2= parse_org_emftext_language_uml_005Fclass_Integer | c3= parse_org_emftext_language_uml_005Fclass_PrimitiveDataType );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Uml_class()) ) {s = 9;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_Uml_class()) ) {s = 10;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_Uml_class()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_ClassDiagramm_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm124 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm139 = new BitSet(new long[]{0x0000000079401000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm160 = new BitSet(new long[]{0x0000000079401000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm191 = new BitSet(new long[]{0x0000000001401000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XAssociation_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm222 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_uml_005Fclass_ClassDiagramm243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_uml_005Fclass_Method269 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Method294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method316 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Method361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method383 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method419 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_uml_005Fclass_Method434 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XParameter_in_parse_org_emftext_language_uml_005Fclass_Method464 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_uml_005Fclass_Method509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XParameter_in_parse_org_emftext_language_uml_005Fclass_Method539 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_uml_005Fclass_Method592 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Method603 = new BitSet(new long[]{0x0000000078100010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Method624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_uml_005Fclass_Method649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Method671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_uml_005Fclass_Attribute705 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Attribute730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute752 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Attribute797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute819 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute855 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Attribute870 = new BitSet(new long[]{0x0000000078000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Attribute891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Attribute920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Parameter957 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Parameter972 = new BitSet(new long[]{0x0000000078000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Parameter993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XDataType_in_parse_org_emftext_language_uml_005Fclass_Parameter1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_uml_005Fclass_Class1056 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_uml_005Fclass_Class1081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1103 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_uml_005Fclass_Class1148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1170 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1206 = new BitSet(new long[]{0x0000000000800800L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_uml_005Fclass_Class1235 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Class1257 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_uml_005Fclass_Class1288 = new BitSet(new long[]{0x0000000000203000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XAttribute_in_parse_org_emftext_language_uml_005Fclass_Class1309 = new BitSet(new long[]{0x0000000000203000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XMethod_in_parse_org_emftext_language_uml_005Fclass_Class1340 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_uml_005Fclass_Class1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_uml_005Fclass_Association1387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Association1401 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_uml_005Fclass_Association1416 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_Association1430 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_uml_005Fclass_Association1443 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_XClass_in_parse_org_emftext_language_uml_005Fclass_Association1457 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_uml_005Fclass_Association1470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_uml_005Fclass_Association1484 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_uml_005Fclass_Association1499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_uml_005Fclass_Association1513 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_uml_005Fclass_Association1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_uml_005Fclass_Boolean1554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Boolean1568 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_parse_org_emftext_language_primitive_005Ftypes_BooleanObject_in_parse_org_emftext_language_uml_005Fclass_Boolean1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_uml_005Fclass_String1627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_String1641 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_parse_org_emftext_language_primitive_005Ftypes_StringObject_in_parse_org_emftext_language_uml_005Fclass_String1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_uml_005Fclass_Integer1700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_Integer1714 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_parse_org_emftext_language_primitive_005Ftypes_IntegerObject_in_parse_org_emftext_language_uml_005Fclass_Integer1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_BooleanObject1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_IntegerObject1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_language_primitive_005Ftypes_StringObject1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_parse_org_emftext_language_uml_005Fclass_XDataType1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_parse_org_emftext_language_uml_005Fclass_XDataType1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_parse_org_emftext_language_uml_005Fclass_XDataType1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_PrimitiveDataType_in_parse_org_emftext_language_uml_005Fclass_XDataType1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Class_in_parse_org_emftext_language_uml_005Fclass_XClass1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Association_in_parse_org_emftext_language_uml_005Fclass_XAssociation1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Parameter_in_parse_org_emftext_language_uml_005Fclass_XParameter2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Attribute_in_parse_org_emftext_language_uml_005Fclass_XAttribute2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Method_in_parse_org_emftext_language_uml_005Fclass_XMethod2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Boolean_in_synpred25_Uml_class1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_String_in_synpred26_Uml_class1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_uml_005Fclass_Integer_in_synpred27_Uml_class1953 = new BitSet(new long[]{0x0000000000000002L});

}