SYNTAXDEF pacad
FOR <http://www.emftext.org/language/pacad>
START PointAndClickAdventure

OPTIONS {
	usePredefinedTokens = "false";
	overridePluginXML = "false";
	reloadGeneratorModel = "true";
	additionalDependencies = "org.emftext.language.pacad.util";
	overrideDefaultResolverDelegate = "false";
	overrideTextResource = "false";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE INTEGER $('0'..'9')+$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')+$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
}

TOKENSTYLES {
	"COMMENT" COLOR #008000;
}

RULES {
	
	PointAndClickAdventure ::= main["main" : ""] "adventure" ("initialRoom" initialRoom[] | "extends" mainScript['<','>']) colorMappings* elements*;
	
	ColorMapping ::= person[] "(" red[] "," green[] "," blue[] ")" ;
	
	Import ::= "import" importedAdventure['<','>'];
	
	Object ::= visible["" : "invisible"] "object" id[] (declaredName['"','"'])?
				( ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" )| 
				("extends" parent[] ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")")?) );
	
	InternalObject ::= visible["" : "invisible"] "internal" "object" id[] (declaredName['"','"'])?
			(("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" 
			"(" definedWidth[INTEGER] "," definedHeight[INTEGER] ")") |
			("extends" parent[]
			("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" 
			"(" definedWidth[INTEGER] "," definedHeight[INTEGER] ")")?)) ;

	InventoryObject ::= visible["" : "invisible"] "inventory" "object" id[] (declaredName['"','"'])?
				( ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")" )| 
				("extends" parent[] ("(" definedPositionX[INTEGER] "," definedPositionY[INTEGER] ")")?) );
	
	Room ::= "room" id[] (declaredName['"','"'])? ("extends" parent[])? ("backgroundsound" declaredBackgroundSound['<','>'])? "{" containedObjects* "}";
	
	Command ::= "on" 
	            type[Use : "use", LookAt : "lookat", TalkTo : "talkto", Take : "take"]
	            subjects[]+
	            "do" "{" actions+ "}"
	            ;

	Hide ::= "hide" subject[];
	Show ::= "show" subject[];
	
	// hide all objects in a room, but cache which objects to hide
	//HideAll ::= "hideall";
	// show all cached objects in a room again
	//ShowAll ::= "showall";
	
	MoveAbsolute ::= "set" subject[] "to" newPositionX[INTEGER] "," newPositionY[INTEGER];
	MoveRelative ::= "move" subject[] deltaX[INTEGER] "," deltaY[INTEGER];
	PlaySound ::= "play" soundfile[];
	ShowText ::= speaker[]? "says" text['"','"']+; 
	
	// Inventory operations
	Store ::= "store" subject[];	
	Remove ::= "remove" subject[];	
}