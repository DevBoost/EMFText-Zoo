 SYNTAXDEF xml
FOR <http://www.emftext.org/xml> <./xml.genmodel>
START Document

OPTIONS{
	tokenspace="1";
	defaultTokenName="IDENTIFIER";
	generateCodeFromGeneratorModel="false";
	backtracking="true";
	usePredefinedTokens="false";
	reloadGeneratorModel="true";
	resourcePluginID="org.emftext.language.xml.resource.xml";
	basePackage="org.emftext.language.xml.resource.xml";
}

TOKENS{
	DEFINE T_OPEN $'<'$;
	DEFINE T_CLOSE $'>'$;
	
	
	DEFINE T_EQUALS $'='$;
	DEFINE IDENTIFIER$( 'a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z'
    | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')*$;
    
	DEFINE PCDATA $'>' (~('<'|'>'))* '<'$;
	
	DEFINE ATTRDATA $('"' (~('"'))* '"'| '\'' (~('\''))* '\'')$;
	DEFINE WS_LB $(('\r\n'|'\r'|'\n'|' '|'\t'|'\f')+)$;
}

RULES{
	
	Document::= ("<" root ">")? ;
	
	Node::=  start attributes*  ( nodes | pcdata )* "/" end[IDENTIFIER]  ;
	
	PCData ::= value[PCDATA];
	
	EmptyNode::= start attributes*  "/"  ;
	
	Attribute::=name[IDENTIFIER] "=" value[ATTRDATA] ;
	
	Tag::= name[IDENTIFIER] ;
	
}