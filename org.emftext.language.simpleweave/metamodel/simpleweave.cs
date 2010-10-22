SYNTAXDEF simpleweave
FOR <http://www.emftext.org/language/simpleweave>
START WModel

RULES{
	WModel::= "type" type[] "core" coreID['<','>'] "{" aspects+ "}"  ;
	
	Aspect::= "weave"  name[] ":" aspectID['<','>'] "{" weavings+ "}";
	
	Weaving ::= adviceContentID[] "into" joinPointID[];
}