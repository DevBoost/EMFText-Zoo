SYNTAXDEF template_call
FOR  <http://www.emftext.org/language/template_concepts/call>
START TemplateCall

OPTIONS {
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "true";
	overrideManifest = "false";
	overridePluginXML = "false";
}

TOKENS {
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {
	TemplateCall ::= "CALL" target['"','"'] "USING" parameterModel['"','"'];
}