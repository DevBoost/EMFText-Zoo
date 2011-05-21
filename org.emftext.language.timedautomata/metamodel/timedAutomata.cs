SYNTAXDEF ta
FOR <http://www.emftext.org/language/timedAutomata/core>
START Project

IMPORTS {
	//org.emftext.language.timedAutomata.bnf:<bnf>
	//org.emftext.language.timedAutomata.bnf.expressions:<expressions>
	//org.emftext.language.timedAutomata.bnf.declarations:<declarations>
	//org.emftext.language.timedAutomata.bnf.types:<types>
	//org.emftext.language.timedAutomata.core:<core>
	//org.emftext.language.simpleGraph:<http://www.emftext.org/language/simpleGraph>
}

OPTIONS {
	reloadGeneratorModel = "true";
	resourcePluginID = "org.emftext.language.timedautomata.resource.ta";
	basePackage = "org.emftext.language.timedautomata.resource.ta";
	resourceUIPluginID = "org.emftext.language.timedautomata.resource.ta.ui";
	uiBasePackage = "org.emftext.language.timedautomata.resource.ta.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

RULES {
	Project ::= "project" id[] templates*;
	Template ::= "template" id[] locations* edges*;
	Location ::= "location" id[];
	Edge ::= "edge" id[] "from" source[] "to" target[];
}