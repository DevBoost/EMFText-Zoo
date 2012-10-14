SYNTAXDEF txt
FOR <http://www.devboost.org/stanford/language>
START PlainText

// overview of different kinds of words can be found here:
// http://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	overrideMetaInformation = "false";
	overrideParsingStrategy = "false";
	overrideDynamicTokenStyler = "false";
	overrideLocationMap = "false";
	overrideTextResource = "false";
	licenceHeader = "platform:/resource/org.devboost.stanford.language/metamodel/licenseComment.txt";
}

TOKENS {
	DEFINE EVERYTHING $('\u0000'..'\uFFFF')+$;
}

RULES {
	PlainText ::= content[EVERYTHING]; 
}