SYNTAXDEF ecore 
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

OPTIONS {
	overridePluginXML = "false";
	memoize = "true";
	tokenspace = "1"; 
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
	DEFINE ML_COMMENT $'/*'.*'*/'$ ;

	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_DERIVED $'derived'$;
	DEFINE T_VOLATILE $'volatile'$;
	DEFINE T_UNIQUE $'unique'$;
	DEFINE T_ORDERED $'ordered'$;
	DEFINE T_UNSETTABLE $'unsettable'$;
	DEFINE T_CHANGEABLE $'changeable'$;
	DEFINE T_TRANSIENT $'transient'$;
	DEFINE T_ID $'iD'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;
	DEFINE T_INTERFACE_OR_CLASS $'interface'|'class'$;
	DEFINE T_SERIALIZABLE $'serializable'$;
	DEFINE CONTAINMENT $'containment'$;
}
 
RULES {
	EPackage ::= "package" #1 name[] (#1 nsPrefix[] ":")? (#1 nsURI['"', '"'])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::= !1(abstract[T_ABSTRACT] #1)? interface[T_INTERFACE_OR_CLASS] #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] 
				(#1 instanceTypeName['"','"'])? ("extends" #1 eSuperTypes[] ("," #1 eSuperTypes[])*)? 
				("[" (eAnnotations)* "]")?
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	EAttribute ::= !2 ( derived[T_DERIVED]|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]|
					unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|transient[T_TRANSIENT]|iD[T_ID] #1)* 
				"attribute" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral['"','"'])? ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	EParameter ::= (ordered[T_ORDERED]|unique[T_UNIQUE] #1)* eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	EReference ::= !2 ( containment[CONTAINMENT]|derived[T_DERIVED]|transient[T_TRANSIENT]
							|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]
							|unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|resolveProxies[T_RESOLVEPROXIES] #1)* 
					"reference" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral['"','"']) ?
					( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])?";";
	
	EOperation ::= !2 "operation" #1 
				( ordered[T_ORDERED]|unique[T_UNIQUE] #1)* 
				("void" | eType[]) 
				( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] #1 
				"(" (eParameters ("," #1 eParameters)* )? ")"
				("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
	
	EEnum ::=  (serializable[T_SERIALIZABLE])? "enum" #1 name[] instanceTypeName['"','"']
					#1 "{" (eLiterals)* !0 "}" 
					!0 ; 

	EEnumLiteral ::= !2 value[] #1 ":" #1 name[] #1 "=" #1 literal[]  ";";


	EAnnotation ::= !3 #0 source['"','"'] ("{" details "}")*;
	
	EStringToStringMapEntry ::= key['"','"'] ":" value['"','"'];
	
	EDataType ::= (serializable[T_SERIALIZABLE])? "datatype" #1 name[] #1 instanceTypeName['"','"'];
	
	ETypeParameter ::= name[];
	
	EGenericType ::= 
		"typed"  
		("<" (eTypeParameter[] | "?" "extends" eUpperBound | "?" "super" eLowerBound) ">")?
		eClassifier[] 
		("<" (eTypeArguments | "?") ("," (eTypeArguments | "?"))* ">")?
		;
}
