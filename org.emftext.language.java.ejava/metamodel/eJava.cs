SYNTAXDEF ejava
FOR <http://www.emftext.org/language/eJava>
START EPackageWrapper
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	srcFolder = "src-gen";
	overrideManifest = "false";
	overridePluginXML = "false";
	overrideClasspath = "false";
	//overrideBuildProperties = "false";
}

RULES {
	EPackageWrapper
	   ::=	("epackage" namespaces[] (#0 "." #0 namespaces[])* #0 ";" )?
	        !0 !0
	        (imports !0 )*
	        (";" !0)*
	        !0
	        (classifiers:EClassifierClassWrapper (";")* !0 !0)+
	        ("\\u001a")?
		;
		
	EClassifierClassWrapper
		::= 	  
			"eclass" name[] 
	        "{" 
	        	(!1 members:EOperationWrapper)* !0
	        "}"
	    ;    
	EOperationWrapper
		::= 	  
			 name[] "(" ")" "{" (!2 statements)* !1 "}"
	    ;
	    
	EObjectInstantiation ::= "#"  type;
}