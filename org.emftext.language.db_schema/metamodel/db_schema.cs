SYNTAXDEF db_schema
FOR <http://org.emftext/db_schema>
START Database

OPTIONS{
	generateCodeFromGeneratorModel = "true";
 	//resourcePluginID = "org.emftext.language.dbschema.resource.database";
	//basePackage = "org.emftext.language.dbschema.resource.database";
	reloadGeneratorModel = "true";
    tokenspace = "1";
    overrideManifest = "false";
}
TOKENS{
		//DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
		//DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
		//DEFINE ANNUMBERS $('@')('system'|'class'|'prop'|'func'|'assoc'|'param'|'type'|'!')(('1'..'9')('0'..'9')* | '0')$;
}
TOKENSTYLES {
	"table" COLOR #000000, BOLD;
	"fkeys" COLOR #000000, BOLD;
	"column" COLOR #000000, BOLD;
	"columns" COLOR #000000, BOLD;
	"database" COLOR #000000, BOLD;
	"pkeys" COLOR #000000, BOLD;
	"reference" COLOR #000000, BOLD;
	//"TEXT" COLOR #0000A0, BOLD;
}

RULES{
		
		Database ::=  "database" name[] "{" type* table* procedure* "}" ;
		
		Table ::= "table" name[] "{" "fkeys" "{" (fkey ("," fkey)*)? "}" "pkeys" "{" (pkey[] ("," pkey[])*)? "}" "columns" "{" column* "}"  "}"  ;
		
		FKey ::= "reference" reference[] "column" column[] ("," column[])*  ;
		
		Column ::= name[] ":" type[] ;
		
		Procedure ::= "procedure" name[] "(" (parameter ("," parameter)*)? ")" ":" return[]? ;
	
		Parameter ::= name[] ":" type[] ;
		
		BOOLEAN ::= "BOOLEAN" name[] value? ;
		
		VARCHAR ::= "VARCHAR" name[] value? ;
		
		INTEGER ::= "INTEGER" name[] value? ;
		
		BooleanObject ::= value[] ;
		
		IntegerObject ::= value[INTEGER] ;
		
		StringObject ::= value[TEXT];
		
	
//		3.sprache! POSTPROCESSOR
//		org.emftext.language.template_concepts
//		tornado2 auscheken -> genmodel -> modelCode erstellen
//		TransformationSetupFactory Class ! erstellt regeln
//		trunk/tornado/plugin... textual
		
		
		
		
}