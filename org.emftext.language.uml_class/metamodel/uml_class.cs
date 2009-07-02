SYNTAXDEF uml_class
FOR <http://org.emftext/uml_class>
START ClassDiagramm

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
    tokenspace = "1";
    overrideManifest = "false";
}

TOKENS{
		//DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INT $('-')?('1'..'9')('0'..'9')*|'0'$;
		//DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
		//DEFINE BOOLEAN$('true'|'false')$;
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
		                      minCardinality[INT]
		                      ".."
		                      maxCardinality[INT]
		                  ")" ;
		                  
	    Boolean ::= "BOOLEAN" name[] value? ;
        
        String ::= "STRING" name[] value? ;
        
        Integer ::= "INTEGER" name[] value? ;
        
        BooleanObject ::= value[] ;
        
        IntegerObject ::= value[INT] ;
        
        StringObject ::= value[TEXT];
		
}