SYNTAXDEF simpleweave
FOR <http://www.emftext.org/language/simpleweave>
START WModel

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	WModel::= "type" type[] "core" coreID['<','>'] "{" aspects+ "}"  ;
	
	Aspect::= "weave"  name[] ":" aspectID['<','>'] "{" weavings+ "}";
	
	Weaving ::= adviceContentID[] "into" joinPointID[];
}