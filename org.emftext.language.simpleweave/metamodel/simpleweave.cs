SYNTAXDEF simpleweave
FOR <http://www.emftext.org/language/simpleweave>
START WModel

RULES{
	WModel::= "core" coreID['<','>'] "{" aspects+ "}"  ;
	
	Aspect::= "weave"  aspectID['<','>'] "{" weavings+ "}";
	
	Weaving ::= adviceContentID[] "into" joinPointID[];
}