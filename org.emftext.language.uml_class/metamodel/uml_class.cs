SYNTAXDEF uml_class
FOR <http://org.emftext/uml_class>
START ClassDiagramm

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
    //tokenspace = "1";
    overrideManifest = "false";
}

TOKENS{
		//DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
		//DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
		//DEFINE BOOLEAN$('true'|'false')$;
}

TOKENSTYLES {
    "classdiagramm" COLOR #0000CC, BOLD;
    "ac" COLOR #0000CC, BOLD;
    "md" COLOR #0000CC, BOLD;
    "void" COLOR #0000CC, BOLD;
    "class" COLOR #0000CC, BOLD;
    "extends" COLOR #0000CC, BOLD;
    "attribute" COLOR #0000CC, BOLD;
    "method" COLOR #0000CC, BOLD;
    "association" COLOR #0000CC, BOLD;
    "->" COLOR #0000CC, BOLD;
    ".." COLOR #0000CC, BOLD;
    ":" COLOR #0000CC, BOLD;
    "BOOLEAN" COLOR #0000CC, BOLD;
    "STRING" COLOR #0000CC, BOLD;
    "INTEGER" COLOR #0000CC, BOLD;
    //"TEXT" COLOR #0000A0, BOLD;
}

RULES{
		
		ClassDiagramm::= "classdiagramm"  name[] 
		                  "{" 
		                          class (class)*
		                          association*
		                  "}"  ;
		
		Method::= ( "ac" access[])?
		          ("md" modifier[] )*
		          name[]
		          "("
		              (parameter)*
		          ")" ":"
		          (return[]?| "void")
		          ;
		
		Attribute::=  ( "ac" access[])?
		              ( "md" modifier[] )*
		              name[]
		              ":"
		              type[]
		              ;
		              
		Parameter::=  name[] ":" type[] ;
		
		Class::= "class" 
		                  ( "ac" access[])?
                          ( "md" modifier[] )*
                          name[]
                          ("extends" parent[])?
                          "{"
                                "attribute" "{" attribute* "}"
                                "method" "{" method* "}"
                          "}"
                          ;
		
		Association::= "association"
		                  targetDesc[]
		                  "("
		                      source[] "->" target[]
		                      ":"
		                      minCardinality[INTEGER]
		                      ".."
		                      maxCardinality[INTEGER]
		                  ")" ;
		                  
	    Boolean ::= "BOOLEAN" name[] value? ;
        
        String ::= "STRING" name[] value? ;
        
        Integer ::= "INTEGER" name[] value? ;
        
        BooleanObject ::= value[] ;
        
        IntegerObject ::= value[INTEGER] ;
        
        StringObject ::= value[TEXT];
		
}