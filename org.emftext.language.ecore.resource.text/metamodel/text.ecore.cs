//*******************************************************************************
// Copyright (c) 2006-2010 
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

SYNTAXDEF text.ecore
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

OPTIONS {
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	memoize = "true";
	tokenspace = "0";
	resourcePluginID = "org.emftext.language.ecore.resource.text";
	basePackage = "org.emftext.language.ecore.resource.text";
	usePredefinedTokens = "false";
	baseResourcePlugin = "org.emftext.language.ecore.resource";
	saveChangedResourcesOnly = "true";
	licenceHeader = "platform:/resource/org.reuseware/licence.txt";
	overrideManifest = "false";
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
	DEFINE T_CONTAINMENT $'containment'$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
		
	DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '::')+$;
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"T_ABSTRACT" COLOR #7F0055, BOLD;
	"T_DERIVED" COLOR #7F0055, BOLD;
	"T_VOLATILE" COLOR #7F0055, BOLD;
	"T_UNIQUE" COLOR #7F0055, BOLD;
	"T_ORDERED" COLOR #7F0055, BOLD;
	"T_UNSETTABLE" COLOR #7F0055, BOLD;
	"T_CHANGEABLE" COLOR #7F0055, BOLD;
	"T_TRANSIENT" COLOR #7F0055, BOLD;
	"T_ID" COLOR #7F0055, BOLD;
	"T_RESOLVEPROXIES" COLOR #7F0055, BOLD;
	"T_INTERFACE_OR_CLASS" COLOR #7F0055, BOLD;
	"T_SERIALIZABLE" COLOR #7F0055, BOLD;
	"T_CONTAINMENT" COLOR #7F0055, BOLD;
	"SL_COMMENT"  COLOR #00bb00;
	"ML_COMMENT"  COLOR #00bb00;
	
	"package" COLOR #7F0055, BOLD;
	"attribute" COLOR #7F0055, BOLD;
	"reference" COLOR #7F0055, BOLD;
	"operation" COLOR #7F0055, BOLD;
	"datatype" COLOR #7F0055, BOLD;
	"extends" COLOR #7F0055, BOLD;
	"opposite" COLOR #7F0055, BOLD;
}
 
RULES {
	EPackage ::= (eAnnotations)* "package" #1 name[] (#1 nsPrefix[])? (#1 nsURI['"', '"'])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::=  (eAnnotations)* !1 (abstract[T_ABSTRACT] #1)? interface[T_INTERFACE_OR_CLASS] #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] 
				(#1 instanceTypeName['"','"'])? (#1 "extends" #1 eSuperTypes[] ("," #1 eSuperTypes[])*)? 
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	EAttribute ::= !2 (eAnnotations)* (( derived[T_DERIVED]|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]|
					unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|transient[T_TRANSIENT]|iD[T_ID]) #1)* 
				"attribute" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral['"','"'])? ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	EParameter ::= (eAnnotations)* ((ordered[T_ORDERED]|unique[T_UNIQUE]) #1)* eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	EReference ::= (eAnnotations)* !2 (( containment[T_CONTAINMENT]|derived[T_DERIVED]|transient[T_TRANSIENT]
							|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]
							|unsettable[T_UNSETTABLE]|changeable[T_CHANGEABLE]|resolveProxies[T_RESOLVEPROXIES]) #1)* 
					"reference" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral['"','"']) ?
					( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])?";";
	
	EOperation ::=  (eAnnotations)* !2
				(( ordered[T_ORDERED]|unique[T_UNIQUE]) #1)* 
				"operation" #1  ("void" | eType[]) 
				( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] #1 
				"(" (eParameters ("," #1 eParameters)* )? ")"
				("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
	
	EEnum ::=  (eAnnotations)* !2 (serializable[T_SERIALIZABLE] #1)? "enum" #1 name[] #1 instanceTypeName['"','"']?
					#1 "{" (eLiterals)* !0 "}" 
					!0 ; 

	EEnumLiteral ::=  (eAnnotations)* !3 value[] #1 ":" #1 name[] #1 "=" #1 literal['"','"']  ";";


	EAnnotation ::= !1 "@" source['"','"'] ("(" details ("," #1 details)* ")")?;
	
	EStringToStringMapEntry ::= key['"','"'] "=" value['"','"'];
	
	EDataType ::= (eAnnotations)* (serializable[T_SERIALIZABLE])? "datatype" #1 name[] #1 instanceTypeName['"','"'];
	
	ETypeParameter ::= (eAnnotations)* name[];
	
	EGenericType ::=
		"typed"  
		("<" (eTypeParameter[] | "?" #1 "extends" #1 eUpperBound | "?" #1 "super" #1 eLowerBound) ">")?
		eClassifier[] 
		("<" (eTypeArguments | "?") ("," (eTypeArguments | "?"))* ">")?
		;
}
