SYNTAXDEF quml 
FOR <http://www.eclipse.org/uml2/3.0.0/UML>
START Model
 
OPTIONS {
 	resourcePluginID = "org.emftext.language.quickuml.resource.quml";
	basePackage = "org.emftext.language.quickuml.resource.quml";
	tokenspace = "1";
}

TOKENSTYLES {
	"m" COLOR #000000, BOLD;
	"p" COLOR #000000, BOLD;
	"c" COLOR #000000, BOLD;
	"o" COLOR #000000, BOLD;
	"a" COLOR #000000, BOLD;
	"TEXT" COLOR #0000A0, BOLD;
}

RULES {
	
	Model ::= "m" name[] "{" (!1 packagedElement)* !0 "}";

	Package ::= "p" name[] "{" (!1 packagedElement)* !0 "}";

	Class ::= "c" name[] "{" ( !1 (ownedAttribute | ownedOperation))* !0 "}";

	Operation ::= "o" name[] "(" #0 (ownedParameter #0 ("," ownedParameter)*)? #0 ")";

	Property ::= "a" name[] ":" type[] (lower[] ".." upper[])?; 

	Parameter ::= "p" name[] ":" type[];
	
	Association ::= "a" name[] "{" ownedEnd ownedEnd "}";
}