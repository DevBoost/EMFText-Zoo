//*******************************************************************************
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

SYNTAXDEF uml_class
FOR <http://org.emftext/uml_class>
START ClassDiagramm

OPTIONS{	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
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
    "p" COLOR #0000CC, BOLD;
    "->" COLOR #0000CC, BOLD;
    ".." COLOR #0000CC, BOLD;
    ":" COLOR #0000CC, BOLD;
    "BOOLEAN" COLOR #00BBCC, BOLD;
    "STRING" COLOR #00BBCC, BOLD;
    "INTEGER" COLOR #00BBCC, BOLD;
    "TYPE" COLOR #00BBCC, BOLD;
   
}

RULES{
		
		ClassDiagramm::= "classdiagramm"  name[]
		                  "{" 
		                          primitiveDatatypes*
		                          class*
		                          association*
		                  		  
		                  "}"  ;
		
		Method::=	"method" 
					( "ac" access[])?
		          	( "md" modifier[] )*
		          	name[]
		          	"("
		          	    (parameter ("," parameter)*)? 
		          	")" 
		          	":"
		          	(return[] | "void" | p_return )
		          	;
		
		Attribute::=  "attribute"
					  ( "ac" access[])?
		              ( "md" modifier[] )*
		              name[]
		              ":"
		              ( type[] | p_type )
		              ;
		              
		Parameter::=  name[] ":" ( type[] | p_type ) ; 
		
		Class::= "class"
					( "ac" access[])?
                    ( "md" modifier[] )*
                    name[]
                    ("extends" parent[])?
                    "{"
                         attribute* 
                         method*
                   	"}"
                    ;
		
		Association::= "association"
		                  name[]
		                  "("
		                      source "->" target 
		                      ":"
		                      minCardinality['"','"']
		                      ".."
		                      maxCardinality['"','"']
		                  ")" ;
		                  
	    Boolean ::= "BOOLEAN" name[] value? ;
        
        String ::= "STRING" name[] value? ;
        
        Integer ::= "INTEGER" name[] value? ;
        
        //allgemeiner Typ, verwendbar für die Erstellung von Regeln
        PrimitiveDataType ::= "TYPE" name[] ; 
        
        BooleanObject ::= value['"','"'] ; 
        
        IntegerObject ::= value['"','"'] ;
        
        StringObject ::= value['"','"'];
		
}