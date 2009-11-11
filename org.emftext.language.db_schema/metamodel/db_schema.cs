// *******************************************************************************
// Copyright (c) 2006-2009 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF db_schema
FOR <http://org.emftext/db_schema>
START Database

OPTIONS{
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	generateCodeFromGeneratorModel = "true";
 	reloadGeneratorModel = "true";
    tokenspace = "1";
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
		
		FKey ::= "fkey" name[] "table" reference "column" column[] ("," column[])*  ; 
		
		PKey ::= "pkey" name[] "column" column[] ("," column[])*  ;
		
		Column ::= "column" name[] ":" type ;
		
		Procedure ::= "procedure" name[] "(" 
								
								(parameter ("," parameter)*)? ")" 
								
								":" return? ;
	
		Parameter ::= name[] ":" type ;
		
		BOOLEAN ::= "BOOLEAN" name[] value? ;
		
		VARCHAR ::= "VARCHAR" name[] value? ;
		
		INTEGER ::= "INTEGER" name[] value? ;
		
		Type ::= "TYPE" name[] ; //allgemeiner Typ, verwendbar für die Erstellung von Regeln
		
		BooleanObject ::= value[] ;
		
		IntegerObject ::= value[INTEGER] ;
		
		StringObject ::= value[TEXT]; 
		
		
		
		
		
}