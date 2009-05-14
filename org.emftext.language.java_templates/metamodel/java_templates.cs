SYNTAXDEF java_template
FOR <http://www.emftext.org/language/java_templates>
START JavaTemplate

IMPORTS {
	java : <http://www.emftext.org/java> <../../org.emftext.language.java/metamodel/java.genmodel> 
		WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	overrideManifest = "false";
}

TOKENSTYLES {
	"<%TEMPLATE" COLOR #C00000, BOLD; 
	"INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"SL_COMMENT" COLOR #00A000, ITALIC;
}

RULES {
	JavaTemplate ::= "<%TEMPLATE" "INPUT=" inputMetaClass[STRING_LITERAL] "%>" body;
	
	PhNamedElementName ::= "<%=" expression[STRING_LITERAL] "%>";
	
	IfAnnotationParameter ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfArrayInitializationValue ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForArrayInitializationValue ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	ForExpression ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfTypeReference ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForTypeReference ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfConcreteClassifier ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForConcreteClassifier ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfConditionalExpressionChild ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfTypeArgument ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForTypeArgument ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfImport ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForImport ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfSelf ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfMember ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForMember ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfAnnotationInstanceOrModifier ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForAnnotationInstanceOrModifier ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfModifier ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForModifier ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfParameter ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForParameter ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfReference ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfReferenceableElement ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfStatement ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForStatement ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfForLoopInitializer ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfSwitchCase ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForSwitchCase ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
}
