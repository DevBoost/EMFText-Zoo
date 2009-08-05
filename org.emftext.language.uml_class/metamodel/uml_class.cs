SYNTAXDEF uml_class
FOR <http://org.emftext/uml_class>
START ClassDiagramm

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
    overrideManifest = "false";
}

TOKENS{
		DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
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
    "BOOLEAN" COLOR #00BBCC, BOLD;
    "STRING" COLOR #00BBCC, BOLD;
    "INTEGER" COLOR #00BBCC, BOLD;
   
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
		              (parameter ("," parameter)*)?
		          ")" ":"
		          (return[]? | "void" | p_return? )
		          ;
		
		Attribute::=  ( "ac" access[])?
		              ( "md" modifier[] )*
		              name[]
		              ":"
		              ( type[] | p_type? )
		              ;
		              
		Parameter::=  name[] ":" ( type[] | p_type? ) ;
		
		Class::= "class" 
		                  ( "ac" access[])?
                          ( "md" modifier[] )*
                          name[]
                          ("extends" parent[])?
                          "{"
                                "attribute" "{" (attribute ("," attribute)*)? "}"
                                "method" "{" (method ("," method)*)? "}"
                          "}"
                          ;
		
		Association::= "association"
		                  targetDesc[]
		                  "("
		                      source[] "->" target[]
		                      ":"
		                      minCardinality['"','"']
		                      ".."
		                      maxCardinality['"','"']
		                  ")" ;
		                  
	    Boolean ::= "BOOLEAN" value? ;
        
        String ::= "STRING" value? ;
        
        Integer ::= "INTEGER" value? ;
        
        PrimitiveDataType ::= "Type" ; //allgemeiner Typ, verwendbar für die Erstellung von Regeln
        
        BooleanObject ::= value['"','"'] ;
        
        IntegerObject ::= value['"','"'] ;
        
        StringObject ::= value['"','"'];
		
}