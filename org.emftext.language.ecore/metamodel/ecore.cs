SYNTAXDEF ecore 
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

IMPORTS {
		ecore:<http://www.eclipse.org/emf/2002/Ecore>
}

TOKENS {
	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_DERIVED $'derived'$;
	DEFINE CONTAINMENT $'containment'$;
}

RULES {
	EPackage ::= "package" #1 name[] (#1 nsPrefix[] ":")? (#1 nsURI['<', '>'])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::= !1(abstract[T_ABSTRACT] #1)? "class" #1 name[] #1 ("extends" #1 eSuperTypes[] ("," #1 eSuperTypes[])*)? 
				("[" (eAnnotations)* "]")?
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	ecore.EAttribute ::= !2 (derived[T_DERIVED] #1)? "attribute" #1 eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	ecore.EParameter ::= eType[] #1 name[];
	
	ecore.EReference ::= !2 (containment[CONTAINMENT] #1 )? (derived[T_DERIVED] #1)? "reference" #1 eType[] #1 name[] 
					( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])?";";
	
	ecore.EOperation ::= !2 "operation" #1 ("void" | eType[]) ( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 name[] #1 
						"(" (eParameters ("," #1 eParameters)* )? ")"
						("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
	
	ecore.EEnum ::=  "enum" #1 name[]
					#1 "{" (eLiterals)* !0 "}"
					!0 ; 

	ecore.EEnumLiteral ::= !2 value[] #1 ":" #1 name[] #1 "=" #1 literal[]  ";";


	ecore.EAnnotation ::= !3 #0 source['"','"'] ("{" details "}")*;
	
	ecore.EStringToStringMapEntry ::= key['"','"'] ":" value['"','"'];
	
	ecore.EDataType ::= "datatype" #1 name[] #1 instanceTypeName['"','"'];
}
