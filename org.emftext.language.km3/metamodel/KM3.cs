// Add * to CARDINALITY token resolver
// Fix token resolvers for boolean attributes (abstract, unique, ordered)
SYNTAXDEF km3
FOR <http://www.eclipse.org/gmt/2005/KM3> <KM3.genmodel>
START Metamodel

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	resourcePluginID = "org.emftext.language.km3.resource.km3";
	basePackage = "org.emftext.language.km3.resource.km3";
	defaultTokenName ="NAME";
}

TOKENS {
	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_UNIQUE $'unique'$;
	DEFINE T_ORDERED $'ordered'$;
	DEFINE T_CONTAINER $'container'$;
	
	DEFINE NAME $(('a'..'z')|('A'..'Z')) (('a'..'z')|('A'..'Z')|('0'..'9'))*$;
	DEFINE CARDINALITY $('0'..'9')|('*')$;
	
	DEFINE COMMENT $'--'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"COMMENT" COLOR #008200, ITALIC;
	"CARDINALITY" COLOR #ff0000;
	"NAME" COLOR #000000;
	"T_ABSTRACT" COLOR #7f0055, BOLD;
	"T_UNIQUE" COLOR #7f0055, BOLD;
	"T_ORDERED" COLOR #7f0055, BOLD;
	"T_CONTAINER" COLOR #7f0055, BOLD;
	
	"[" COLOR #7f0055, BOLD;
	"]" COLOR #7f0055, BOLD;
	
	"package" COLOR #7f0055, BOLD;
	"class" COLOR #7f0055, BOLD;
	"datatype" COLOR #7f0055, BOLD;
	"reference" COLOR #7f0055, BOLD;
	"attribute" COLOR #7f0055, BOLD;
	"operation" COLOR #7f0055, BOLD;
	"enumeration" COLOR #7f0055, BOLD;
	"literal" COLOR #7f0055, BOLD;
}

RULES {
	Metamodel ::= contents*;
	
	Package   ::= "package" name[] "{" contents* "}";
	
	Class     ::= 
		(isAbstract[T_ABSTRACT])? "class" name[] ("extends" supertypes[] ("," supertypes[])*)?
		"{" 
			structuralFeatures* 
			operations* 
		"}";
		
	Reference ::= 
		"reference" name[] ("[" (lower[CARDINALITY] "-")? upper[CARDINALITY] "]")?
		(isContainer[T_CONTAINER] | 
		isOrdered[T_ORDERED] |
		isUnique[T_UNIQUE])*
		":"
		type[]
		";";
		// TODO add subsetOf, derivedFrom
		// TODO add opposite
		
	Attribute ::= 
		"attribute" name[] ("[" (lower[CARDINALITY] "-")? upper[CARDINALITY] "]")? 
		(isOrdered[T_ORDERED] | 
		isUnique[T_UNIQUE])*
		":" 
		type[]
		";";
		// TODO add subsetOf, derivedFrom
		
	Operation ::= 
		"operation" name[] "(" (parameters ("," parameters)*)? ")" (":" type[]) ";";
		
	Parameter ::=
		name[] ":" type[];

	DataType ::= "datatype" name[] ";";
	
	Enumeration ::= "enumeration" name[] "{" literals* "}";
	
	EnumLiteral ::= "literal" name[] ";";	
}