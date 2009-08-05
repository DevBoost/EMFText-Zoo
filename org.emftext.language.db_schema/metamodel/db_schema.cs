SYNTAXDEF db_schema
FOR <http://org.emftext/db_schema>
START Database

OPTIONS{
	generateCodeFromGeneratorModel = "true";
 	reloadGeneratorModel = "true";
    tokenspace = "1";
    overrideManifest = "false";
}
TOKENS{
		DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
}

TOKENSTYLES {
	"table" COLOR #0000CC, BOLD;
	"fkeys" COLOR #0000CC, BOLD;
	"column" COLOR #0000CC, BOLD;
	"columns" COLOR #0000CC, BOLD;
	"database" COLOR #0000CC, BOLD;
	"pkeys" COLOR #0000CC, BOLD;
	"reference" COLOR #0000CC, BOLD;
	"procedure" COLOR #0000CC, BOLD;
	":" COLOR #0000CC, BOLD;
	"BOOLEAN" COLOR #00CCCC, BOLD;
	"VARCHAR" COLOR #00CCCC, BOLD;
	"INTEGER" COLOR #00CCCC, BOLD;
	
}

RULES{
		
		Database ::=  "database" name[] "{" 
							table* 
							procedure* 
					  "}" ;
		
		Table ::= "table" name[] "{" 
						"fkeys" "{" 
							(fkey ("," fkey)*)? 
						"}" 
						"pkeys" "{" 
							(pkey[] ("," pkey[])*)? 
						"}" 
						"columns" "{" 
							column* 
						"}"  
					"}"  ;
		
		FKey ::= "reference" reference[] "column" column[] ("," column[])*  ;
		
		Column ::= name[] ":" type ;
		
		Procedure ::= "procedure" name[] "(" (parameter ("," parameter)*)? ")" ":" return? ;
	
		Parameter ::= name[] ":" type ;
		
		BOOLEAN ::= "BOOLEAN" value? ;
		
		VARCHAR ::= "VARCHAR" value? ;
		
		INTEGER ::= "INTEGER" value? ;
		
		Type ::= "Type" ; //allgemeiner Typ, verwendbar für die Erstellung von Regeln
		
		BooleanObject ::= value[] ;
		
		IntegerObject ::= value[INTEGER] ;
		
		StringObject ::= value[TEXT];
		
		
		
		
		
}