SYNTAXDEF modelquery
FOR <http://www.emftext.org/language/modelquery>
START ModelQuery

OPTIONS {
	usePredefinedTokens = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE TEXT $('A'..'Z')+$;
}

RULES {
	@SuppressWarnings(featureWithoutSyntax)
	ModelQuery ::= ("query" queries['$','$'])+;
}