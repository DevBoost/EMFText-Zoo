SYNTAXDEF ecore 
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

IMPORTS {
		ecore:<http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	overridePluginXML = "false";
}

TOKENS {
	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_DERIVED $'derived'$;
	DEFINE T_VOLATILE $'volatile'$;
	DEFINE T_UNIQUE $'unique'$;
	DEFINE T_ORDERED $'ordered'$;
	DEFINE T_UNSETTABLE $'unsettable'$;
	DEFINE T_CHANGEABLE $'changeable'$;
	DEFINE T_TRANSIENT $'transient'$;
	DEFINE T_ID $'id'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;
	DEFINE T_INTERFACE $'interface'$;
	DEFINE T_SERIALIZABLE $'serializable'$;
	DEFINE CONTAINMENT $'containment'$;
}
 
RULES {
	EPackage ::= "package" #1 name[] (#1 nsPrefix[] ":")? (#1 nsURI['<', '>'])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::= !1(abstract[T_ABSTRACT] #1)? ("class"|interface[T_INTERFACE]) #1 name[] (#1 instanceTypeName['"','"'])? ("extends" #1 eSuperTypes[] ("," #1 eSuperTypes[])*)? 
				("[" (eAnnotations)* "]")?
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	ecore.EAttribute ::= !2 (derived[T_DERIVED]|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]|
					unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|transient[T_TRANSIENT]|iD[T_ID] #1)* 
				"attribute" #1 eType[] #1 name[] ("=" defaultValueLiteral['"','"'])? ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	ecore.EParameter ::= (ordered[T_ORDERED]|unique[T_UNIQUE] #1)* eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	ecore.EReference ::= !2 (containment[CONTAINMENT]|derived[T_DERIVED]|transient[T_TRANSIENT]
							|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]
							|unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|resolveProxies[T_RESOLVEPROXIES] #1)* 
					"reference" #1 eType[] #1 name[] ("=" defaultValueLiteral['"','"']) ?
					( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])?";";
	
	ecore.EOperation ::= !2 "operation" #1 (ordered[T_ORDERED]|unique[T_UNIQUE] #1)* ("void" | eType[]) ( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 name[] #1 
						"(" (eParameters ("," #1 eParameters)* )? ")"
						("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
	
	ecore.EEnum ::=  (serializable[T_SERIALIZABLE])? "enum" #1 name[] instanceTypeName['"','"']
					#1 "{" (eLiterals)* !0 "}" 
					!0 ; 

	ecore.EEnumLiteral ::= !2 value[] #1 ":" #1 name[] #1 "=" #1 literal[]  ";";


	ecore.EAnnotation ::= !3 #0 source['"','"'] ("{" details "}")*;
	
	ecore.EStringToStringMapEntry ::= key['"','"'] ":" value['"','"'];
	
	ecore.EDataType ::= (serializable[T_SERIALIZABLE])? "datatype" #1 name[] #1 instanceTypeName['"','"'];
}
