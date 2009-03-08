SYNTAXDEF topf
FOR <http://org.emftext.languages/plugin>
START ToolProductFamily

OPTIONS {
	overridePluginXML = "false";
	tokenspace = "1"; 
}

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		ToolProductFamily::= "ToolProductFamily" ":" name['"','"'] "plugins" "{" ( plugins  )* "}"  ;
		
		Plugin::= pluginId['\'','\''] ";";
		
}