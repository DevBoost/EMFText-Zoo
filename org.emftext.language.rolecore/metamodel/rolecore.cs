SYNTAXDEF rolecore
FOR <http://www.emftext.org/language/rolecore>
START RCPackage

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
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
	DEFINE T_ID $'iD'$;
	DEFINE T_CONTAINMENT $'containment'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;

	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"RCPackage" COLOR #00A000, BOLD;
	"CoreClass" COLOR #606060, BOLD;
	"Role" COLOR #00A000, BOLD;
	"is" COLOR #00A000, BOLD;
	"played" COLOR #00A000, BOLD;
	"by" COLOR #00A000, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	RCPackage ::= "RCPackage" name[] coreClasses* roles*;
	
	Role      ::= 
		"Role" name[] "is" "played" "by" player[]			
		"{" ( eStructuralFeatures | eOperations )* !0 "}";
		
	CoreClass ::= 
		"CoreClass" name[]
		"{" ( eStructuralFeatures | eOperations )* !0 "}";

	EAttribute ::= 
		(
			derived[T_DERIVED] | 
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] | 
			changeable[T_CHANGEABLE] | 
			transient[T_TRANSIENT] | 
			iD[T_ID] 
		#1)* 
		"attribute" #1 eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	EParameter ::= 
		//(eAnnotations)* 
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1)* eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	EReference ::= 
		(
			containment[T_CONTAINMENT] |
			derived[T_DERIVED] |
			transient[T_TRANSIENT] |
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] |
			changeable[T_CHANGEABLE] |
			resolveProxies[T_RESOLVEPROXIES]
		)* 
		"reference" #1 eType[] #1 name[] 
		( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])? ";";
	
	EOperation ::=
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1 )* 
		"operation" #1 ("void" | eType[]) 
		( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 
		//("<" eTypeParameters ("," eTypeParameters)* ">")? 
		name[] #1 
		"(" (eParameters ("," #1 eParameters)* )? ")"
		("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
}