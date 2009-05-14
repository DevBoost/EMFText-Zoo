SYNTAXDEF custom_sandwich
FOR <http://www.emftext.org/language/custom_sandwich>
START RecipeTemplate

IMPORTS {
	sandwich : <http://www.emftext.org/language/sandwich> WITH SYNTAX sandwich <../../org.emftext.language.sandwich/metamodel/sandwich.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideManifest = "false";
}

TOKENSTYLES {
	"<%TEMPLATE INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ELSE%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"QUOTED_34_34" COLOR #C08000, BOLD;
}

RULES {
	RecipeTemplate ::= "<%TEMPLATE INPUT=" inputMetaClass['"','"'] "%>" body;
	IfFeatureRecipeIngredients ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForFeatureRecipeIngredients ::= "<%FOR" expression['"','"'] "%>" body "<%ENDFOR%>";
	IfFeatureRecipeInstructions ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForFeatureRecipeInstructions ::= "<%FOR" expression['"','"'] "%>" body "<%ENDFOR%>";
	IfElseFeatureInstructionUsing ::= "<%IF" expression['"','"'] "%>" thenBody "<%ELSE%>" elseBody "<%ENDIF%>";
	PhFeatureIngredientName ::= "<%=" expression['"','"'] "%>";
}