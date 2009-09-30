grammar Uml_class;

options {
	superClass = Uml_classANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.uml_class.resource.uml_class.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.uml_class.resource.uml_class.mopp;
}

@members{
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
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
{
}
(
	{
	}
	c0 = parse_org_emftext_language_uml_005Fclass_ClassDiagramm{ element = c0; }
)
EOF
;

parse_org_emftext_language_uml_005Fclass_ClassDiagramm returns [org.emftext.language.uml_class.ClassDiagramm element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'classdiagramm' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

{
	// expected element is a CsString
}
a2 = '{' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a3_0 = parse_org_emftext_language_uml_005Fclass_XDataType		{
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
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a4_0 = parse_org_emftext_language_uml_005Fclass_XClass		{
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
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a5_0 = parse_org_emftext_language_uml_005Fclass_XAssociation		{
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
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a CsString
}
a6 = '}' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClassDiagramm();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a6, element);
}

;

parse_org_emftext_language_uml_005Fclass_Method returns [org.emftext.language.uml_class.Method element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'method' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = 'ac' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2 = TEXT			
			{
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
		)
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a3 = 'md' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a3, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a4 = TEXT			
			{
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
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a Terminal
}
(
	a5 = TEXT	
	{
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
)

{
	// expected element is a CsString
}
a6 = '(' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a6, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a7_0 = parse_org_emftext_language_uml_005Fclass_XParameter			{
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
		)
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a CsString
				}
				a8 = ',' {
					if (element == null) {
						element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				
				{
					// expected element is a Terminal
				}
				(
					a9_0 = parse_org_emftext_language_uml_005Fclass_XParameter					{
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
				)
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
	)
	
)?
{
	// expected element is a CsString
}
a10 = ')' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a10, element);
}

{
	// expected element is a CsString
}
a11 = ':' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a11, element);
}

{
	// expected element is a Compound
}
(
	{
		// expected element is a Terminal
	}
	(
		a12 = TEXT		
		{
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
	)
	
	
	|	{
		// expected element is a CsString
	}
	a13 = 'void' {
		if (element == null) {
			element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	
	|	{
		// expected element is a Terminal
	}
	(
		a14_0 = parse_org_emftext_language_uml_005Fclass_XDataType		{
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
	)
	
)

;

parse_org_emftext_language_uml_005Fclass_Attribute returns [org.emftext.language.uml_class.Attribute element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'attribute' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = 'ac' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2 = TEXT			
			{
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
		)
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a3 = 'md' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a3, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a4 = TEXT			
			{
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
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a Terminal
}
(
	a5 = TEXT	
	{
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
)

{
	// expected element is a CsString
}
a6 = ':' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAttribute();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a6, element);
}

{
	// expected element is a Compound
}
(
	{
		// expected element is a Terminal
	}
	(
		a7 = TEXT		
		{
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
	)
	
	
	|	{
		// expected element is a Terminal
	}
	(
		a8_0 = parse_org_emftext_language_uml_005Fclass_XDataType		{
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
	)
	
)

;

parse_org_emftext_language_uml_005Fclass_Parameter returns [org.emftext.language.uml_class.Parameter element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = TEXT	
	{
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
)

{
	// expected element is a CsString
}
a1 = ':' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createParameter();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Compound
}
(
	{
		// expected element is a Terminal
	}
	(
		a2 = TEXT		
		{
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
	)
	
	
	|	{
		// expected element is a Terminal
	}
	(
		a3_0 = parse_org_emftext_language_uml_005Fclass_XDataType		{
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
	)
	
)

;

parse_org_emftext_language_uml_005Fclass_Class returns [org.emftext.language.uml_class.Class element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'class' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = 'ac' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2 = TEXT			
			{
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
		)
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a3 = 'md' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a3, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a4 = TEXT			
			{
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
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a Terminal
}
(
	a5 = TEXT	
	{
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
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a6 = 'extends' {
			if (element == null) {
				element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a6, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a7 = TEXT			
			{
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
		)
		
	)
	
)?
{
	// expected element is a CsString
}
a8 = '{' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a8, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a9_0 = parse_org_emftext_language_uml_005Fclass_XAttribute		{
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
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a10_0 = parse_org_emftext_language_uml_005Fclass_XMethod		{
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
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a CsString
}
a11 = '}' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createClass();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a11, element);
}

;

parse_org_emftext_language_uml_005Fclass_Association returns [org.emftext.language.uml_class.Association element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'association' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

{
	// expected element is a CsString
}
a2 = '(' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element is a Terminal
}
(
	a3_0 = parse_org_emftext_language_uml_005Fclass_XClass	{
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
)

{
	// expected element is a CsString
}
a4 = '->' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a4, element);
}

{
	// expected element is a Terminal
}
(
	a5_0 = parse_org_emftext_language_uml_005Fclass_XClass	{
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
)

{
	// expected element is a CsString
}
a6 = ':' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a6, element);
}

{
	// expected element is a Terminal
}
(
	a7 = QUOTED_34_34	
	{
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
)

{
	// expected element is a CsString
}
a8 = '..' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a8, element);
}

{
	// expected element is a Terminal
}
(
	a9 = QUOTED_34_34	
	{
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
)

{
	// expected element is a CsString
}
a10 = ')' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createAssociation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a10, element);
}

;

parse_org_emftext_language_uml_005Fclass_Boolean returns [org.emftext.language.uml_class.Boolean element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'BOOLEAN' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createBoolean();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a2_0 = parse_org_emftext_language_primitive_005Ftypes_BooleanObject		{
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
	)
	
)?
;

parse_org_emftext_language_uml_005Fclass_String returns [org.emftext.language.uml_class.String element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'STRING' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createString();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a2_0 = parse_org_emftext_language_primitive_005Ftypes_StringObject		{
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
	)
	
)?
;

parse_org_emftext_language_uml_005Fclass_Integer returns [org.emftext.language.uml_class.Integer element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'INTEGER' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createInteger();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a2_0 = parse_org_emftext_language_primitive_005Ftypes_IntegerObject		{
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
	)
	
)?
;

parse_org_emftext_language_uml_005Fclass_PrimitiveDataType returns [org.emftext.language.uml_class.PrimitiveDataType element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = 'TYPE' {
	if (element == null) {
		element = org.emftext.language.uml_class.Uml_classFactory.eINSTANCE.createPrimitiveDataType();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = TEXT	
	{
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
)

|//derived choice rules for sub-classes: 

c0 = parse_org_emftext_language_uml_005Fclass_Boolean{ element = c0; /* this is a subclass choice */ }
|c1 = parse_org_emftext_language_uml_005Fclass_String{ element = c1; /* this is a subclass choice */ }
|c2 = parse_org_emftext_language_uml_005Fclass_Integer{ element = c2; /* this is a subclass choice */ }

;

parse_org_emftext_language_primitive_005Ftypes_BooleanObject returns [org.emftext.language.primitive_types.BooleanObject element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUOTED_34_34	
	{
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
)

;

parse_org_emftext_language_primitive_005Ftypes_IntegerObject returns [org.emftext.language.primitive_types.IntegerObject element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUOTED_34_34	
	{
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
)

;

parse_org_emftext_language_primitive_005Ftypes_StringObject returns [org.emftext.language.primitive_types.StringObject element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUOTED_34_34	
	{
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
)

;

parse_org_emftext_language_uml_005Fclass_XDataType returns [org.emftext.language.uml_class.XDataType element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Boolean{ element = c0; /* this is a subclass choice */ }
|c1 = parse_org_emftext_language_uml_005Fclass_String{ element = c1; /* this is a subclass choice */ }
|c2 = parse_org_emftext_language_uml_005Fclass_Integer{ element = c2; /* this is a subclass choice */ }
|c3 = parse_org_emftext_language_uml_005Fclass_PrimitiveDataType{ element = c3; /* this is a subclass choice */ }

;

parse_org_emftext_language_uml_005Fclass_XClass returns [org.emftext.language.uml_class.XClass element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Class{ element = c0; /* this is a subclass choice */ }

;

parse_org_emftext_language_uml_005Fclass_XAssociation returns [org.emftext.language.uml_class.XAssociation element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Association{ element = c0; /* this is a subclass choice */ }

;

parse_org_emftext_language_uml_005Fclass_XParameter returns [org.emftext.language.uml_class.XParameter element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Parameter{ element = c0; /* this is a subclass choice */ }

;

parse_org_emftext_language_uml_005Fclass_XAttribute returns [org.emftext.language.uml_class.XAttribute element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Attribute{ element = c0; /* this is a subclass choice */ }

;

parse_org_emftext_language_uml_005Fclass_XMethod returns [org.emftext.language.uml_class.XMethod element = null]
:
c0 = parse_org_emftext_language_uml_005Fclass_Method{ element = c0; /* this is a subclass choice */ }

;

COMMENT:
'//'(~('\n'|'\r'))*
{ _channel = 99; }
;
INTEGER:
('-')?('1'..'9')('0'..'9')*|'0'{ _channel = 99; }
;
TEXT:
('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+;
WHITESPACE:
(' ' | '\t' | '\f')
{ _channel = 99; }
;
LINEBREAK:
('\r\n' | '\r' | '\n')
{ _channel = 99; }
;
QUOTED_34_34:
('"')(~('"'))*('"')
;
