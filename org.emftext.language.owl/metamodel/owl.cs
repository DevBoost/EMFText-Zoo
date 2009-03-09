SYNTAXDEF owl
FOR <http://org.emftext/owl.ecore> <owl.genmodel>
START OntologyDocument

OPTIONS {
	//generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
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
	Class ::= "Class:" iri[IRI] (
				("Annotations:" annotations) 
				| ("SubClassOf:" superClassesDescriptions)
				| ("EquivalentTo:" equivalentClassesDescriptions)
				| ("DisjointWith:" disjointWithClassesDescriptions)
				| ("DisjointUnionWith:" disjointUnionWithClassesDescriptions)
			)*;
	
	// ONTOLOGY Property definitions and Axioms			
	ObjectProperty ::= "ObjectProperty:" iri[IRI] (("Annotations:" annotations+) |
	( "Domain:" propertyDomain) |
	( "Range:" propertyRange) | 
	( "Characteristics:" characteristic[]) | 
	( "SubPropertyOf:" superProperties) |
	( "EquivalentTo:" equivalentProperties) |
	( "DisjointWith:" disjointProperties) |
	( "InverseOf:" inverseProperties) |
	( "SubPropertyChain:" subPropertyChains ("o" subPropertyChains) +))*;
	
	
	DataProperty ::= "DataProperty:" iri[IRI] (
	("Annotations:" annotations) 
	| ("Domain:" domain)
	| ("Range:" range)
	| ("Characteristics:" "Functional")
	| ("SubPropertyOf:" superProperties[IRI])
	| ("EquivalentTo:" equivalentProperties[IRI])
	| ("DisjointWith:" disjointProperties[IRI])
	)*;
	
	AnnotationProperty ::= "AnnotationProperty:" iri[IRI] (
	("Annotations:" annotations)
	| ("Domain:" domains[IRI])
	| ("Range:" ranges[IRI])
	| ("SubPropertyOf:" superAnnotationProperties[IRI])
	)*;
	
	Individual ::= "Individual:" iri[IRI] (
		("Annotations:" annotations)
		| ("Types:" types)
		| ("SameAs:" sameAs[IRI])
		| ("DifferentFrom:" differentFrom[IRI])
		| ("Facts:" facts)
	)*;
	
	ObjectPropertyFact ::= not[NOT]? objectProperty[IRI] individual[IRI];
	 
	DataPropertyFact ::= not[NOT]? dataProperty[IRI] literal;
	
	// MISC Frame TODO
	Misc ::= "Misc";
	
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

	// DataRanges
	DataRange ::= dataConjunctions ("or" dataConjunctions)*;
	DataConjunction ::= dataPrimaries ("and" dataPrimaries)*; 
	DatatypeReference ::= not[NOT]? theDatatype[IRI] (facets)*;
	Facet ::= facetType[] literal;
	NestedDataRange ::= not[NOT]? "(" dataRange ")";
	DataPrimaryLiterals ::= not[NOT]? "{" literals ("," literals)* "}";
		
	
	// TBD
	
	TypedLiteral ::= lexicalValue['"','"'] "^^" theDatatype[IRI];
	
	Integer ::= "integer";
	
}