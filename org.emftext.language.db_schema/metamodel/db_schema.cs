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
	"fkey" COLOR #0000CC, BOLD;
	"column" COLOR #0000CC, BOLD;
	"database" COLOR #0000CC, BOLD;
	"pkey" COLOR #0000CC, BOLD;
	"procedure" COLOR #0000CC, BOLD;
	":" COLOR #0000CC, BOLD;
	"BOOLEAN" COLOR #00CCCC, BOLD;
	"VARCHAR" COLOR #00CCCC, BOLD;
	"INTEGER" COLOR #00CCCC, BOLD;
	"TYPE" COLOR #00CCCC, BOLD;
	
}

RULES{
		
		Database ::=  "database" name[] "{" 
							
							types* 
							table* 
							procedure*
							
					  "}" ;
		
		Table ::= "table" name[] "{" 
						
						fkey* 
						pkey* 
						column* 
						
					"}"  ;
		
		FKey ::= "fkey" reference[] "column" column[] ("," column[])*  ;
		
		PKey ::= "pkey" "column" column[] ("," column[])*  ;
		
		Column ::= "column" name[] ":" type[] ;
		
		Procedure ::= "procedure" name[] "(" 
								
								(parameter ("," parameter)*)? ")" 
								
								":" return[]? ;
	
		Parameter ::= name[] ":" type[] ;
		
		BOOLEAN ::= "BOOLEAN" placeholder[] value? ;
		
		VARCHAR ::= "VARCHAR" placeholder[] value? ;
		
		INTEGER ::= "INTEGER" placeholder[] value? ;
		
		Type ::= "TYPE" placeholder[] ; //allgemeiner Typ, verwendbar für die Erstellung von Regeln
		
		BooleanObject ::= value[] ;
		
		IntegerObject ::= value[INTEGER] ;
		
		StringObject ::= value[TEXT];
		
		
		
		
		
}