SYNTAXDEF java_template
FOR <http://www.emftext.org/language/java_templates>
START JavaTemplate

IMPORTS {
	java : <http://www.emftext.org/java> <../../org.emftext.language.java/metamodel/java.genmodel> 
		WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENSTYLES {
	"<%TEMPLATE INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
}

RULES {
	JavaTemplate ::= "<%TEMPLATE INPUT=" inputMetaClass[STRING_LITERAL] "%>" body;
	
	IfAnnotationParameter ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfExpression ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfArrayInitializationValue ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForArrayInitializationValue ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfTypeReference ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForTypeReference ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfConcreteClassifier ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForConcreteClassifier ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfConditionalExpressionChild ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfTypeArgument ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForTypeArgument ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfImport ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForImport ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfSelf ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfMember ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForMember ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfAnnotationInstanceOrModifier ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForAnnotationInstanceOrModifier ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfModifier ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForModifier ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfParameter ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForParameter ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfReference ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfForLoopInitializer ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfSwitchCase ::= "<%IF" condition[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForSwitchCase ::= "<%FOR" collection[STRING_LITERAL] "%>" body "<%ENDFOR%>";
}
