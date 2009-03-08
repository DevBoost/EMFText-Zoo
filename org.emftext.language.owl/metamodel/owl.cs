SYNTAXDEF owl
FOR <http://org.emftext/owl.ecore> <owl.genmodel>
START OntologyDocument

OPTIONS {
	generateCodeFromGeneratorModel = "true";
}

TOKENS{
	
	DEFINE NOT $'not'$;
	DEFINE INVERSE $'inverse'$;
	DEFINE INT $('0'..'9')+$;
	DEFINE IRI $(('<')(~('>')|('\\''>'))*('>'))|(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)$;
	
}



RULES{
	OntologyDocument ::= namespace*  ontology;


	
	Annotation ::= propertyIri[IRI] target[IRI];
	
	
	Namespace ::= "Namespace:" prefix[IRI]? uri[IRI];
	
	Ontology ::= "Ontology:" uri[IRI]? 
					("import" imports[IRI])* 
					("annotations" annotations+)? 
					frames*;
	
	// ONTOLOGY Class definitions and Axioms			
	Class ::= "Class:" iri[IRI] (("Annotations:" annotations+) | classAxioms)*;
	SubClassOf ::= "SubClassOf:" description;
	EquivalentTo ::= "EquivalentTo:" description;
	DisjointWith ::= "DisjointWith:" description;
	DisjointUnionWith ::= "DisjointUnionWith:" description;
	
	
	// Descriptions
	Description ::= conjunctions ("or" conjunctions)*;
	Conjunction ::= (clazz[IRI] "that")? primaries ("and" primaries)*;								
		
	ClassAtomic ::= not[NOT]? clazz[IRI];
	IndividualsAtomic ::= not[NOT]? "{" individuals[IRI] ("," individuals[IRI])* "}";
	NestedDescription ::= not[NOT]? "{" description "}";
	
	ObjectPropertySome ::= not[NOT]? inverse[INVERSE]? property[IRI] "some" primary;
	ObjectPropertyOnly ::= not[NOT]? inverse[INVERSE]? property[IRI] "only" primary;
	ObjectPropertySelf ::= not[NOT]? inverse[INVERSE]? property[IRI] "self";
	ObjectPropertyValue ::= not[NOT]? inverse[INVERSE]? property[IRI] "value" individual[IRI];
	ObjectPropertyMin ::= not[NOT]? inverse[INVERSE]? property[IRI] "min" value[INT] primary?;
	ObjectPropertyMax ::= not[NOT]? inverse[INVERSE]? property[IRI] "max" value[INT] primary?;
	ObjectPropertyExactly ::= not[NOT]? inverse[INVERSE]? property[IRI] "exactly" value[INT] primary?;

	DataPropertySome ::= not[NOT]? dataProperty[IRI] "some" dataPrimary;
	DataPropertyOnly ::= not[NOT]? dataProperty[IRI] "only" dataPrimary;
	DataPropertyValue ::= not[NOT]? dataProperty[IRI] "value" literal;
	DataPropertyMin ::= not[NOT]? dataProperty[IRI] "min" value[INT] dataPrimary;
	DataPropertyMax ::= not[NOT]? dataProperty[IRI] "max" value[INT] dataPrimary;
	DataPropertyExactly ::= not[NOT]? dataProperty[IRI] "exactly" value[INT] dataPrimary;

	DataProperty ::= "DataProperty:" iri[IRI] (dataPropertyAxioms)*;
	
	TypedLiteral ::= lexicalValue['"','"'] "^^" theDatatype[IRI];
	
	Integer ::= "integer";
	
}