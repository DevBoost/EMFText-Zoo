SYNTAXDEF owl
FOR <http://org.emftext/owl.ecore> <owl.genmodel>
START OntologyDocument

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
} 

TOKENS{
	
	DEFINE NOT $'not'$;
	DEFINE INVERSE $'inverse'$;
	DEFINE INT $('+'|'-')?('0'..'9')+$;
	DEFINE FLOAT $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('f'|'F') 
				| ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('f'|'F') 
				| (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('f'|'F') 
				| ('0'..'9')+ ('f'|'F'))$;
	DEFINE FACETKINDS $'length'|'minLength'|'maxLength'
						|'pattern'|'langPattern'|'<='|'<'
						|'>'|'>='$;
	DEFINE CHARACTERISTICS $'Functional'|'InverseFunctional'|'Reflexive'
						|'Irreflexive'|'Symmetric'|'Asymmetric'|'Transitive'$; 
	DEFINE IRI $(('<')(~('>')|('\\''>'))*('>'))|(('A'..'Z' | ':' | 'a'..'z' | '0'..'9' | '_' | '-' )+)$;
}



RULES{
	OntologyDocument ::= namespace*  ontology;


	
	Annotation ::= "Annotations:" ( annotations? propertyIri[IRI] target ("," annotations? propertyIri[IRI] target)*)?;
	
	IRITarget ::= target[IRI];
	
	LiteralTarget ::= literal;
	
	Namespace ::= "Namespace:" prefix[IRI]? uri[IRI];
	
	Ontology ::= "Ontology:" (uri[IRI] versionIRI[IRI] ?)? 
					("Import:" imports[IRI])* 
					annotations* 
					frames*;
	
	// ONTOLOGY Class definitions and Axioms			
	Class ::= "Class:" iri[IRI] (
				(annotations) 
				| ("SubClassOf:" (superClassesDescriptions ("," superClassesDescriptions )*)?)
				| ("EquivalentTo:" (equivalentClassesDescriptions ("," equivalentClassesDescriptions)*)?)
				| ("DisjointWith:" (disjointWithClassesDescriptions ("," disjointWithClassesDescriptions )*)?)
				| ("DisjointUnionWith:" (disjointUnionWithClassesDescriptions ("," disjointUnionWithClassesDescriptions)*)?)
			)*;
	
	// ONTOLOGY Property definitions and Axioms			
	ObjectProperty ::= "ObjectProperty:" iri[IRI] ((annotations) |
		( "Domain:" (propertyDomain ("," propertyDomain)*)?) |
		( "Range:" (propertyRange ("," propertyRange)*)?) | 
		( "Characteristics:" (characteristics[CHARACTERISTICS] ("," characteristics[CHARACTERISTICS])*)?) | 
		( "SubPropertyOf:" (superProperties ("," superProperties)*)?) |
		( "EquivalentTo:" (equivalentProperties ("," equivalentProperties)*)?) |
		( "DisjointWith:" (disjointProperties ("," disjointProperties)*)?) |
		( "InverseOf:" (inverseProperties ("," inverseProperties)*)?) |
		( "SubPropertyChain:" subPropertyChains ("o" subPropertyChains) +))*;
	
	
	DataProperty ::= "DataProperty:" iri[IRI] (
		(annotations) 
		| ("Domain:" (domain ("," domain)*))
		| ("Range:" (range ("," range)*))
		| ("Characteristics:" characteristic[CHARACTERISTICS])
		| ("SubPropertyOf:" (superProperties[IRI] ("," superProperties[IRI])*))
		| ("EquivalentTo:" (equivalentProperties[IRI] ("," equivalentProperties[IRI])*))
		| ("DisjointWith:" (disjointProperties[IRI] ("," disjointProperties[IRI])*))
	)*;
	
	AnnotationProperty ::= "AnnotationProperty:" iri[IRI] (
		(annotations)
		| ("Domain:" (domains[IRI] ("," domains[IRI])*))
		| ("Range:" (ranges[IRI] ("," ranges[IRI])*))
		| ("SubPropertyOf:" (superAnnotationProperties[IRI]("," superAnnotationProperties[IRI])*))
	)*;
	
	Individual ::= "Individual:" iri[IRI] (
		(annotations)
		| ("Types:" (types ("," types)*))
		| ("SameAs:" (sameAs[IRI] ("," sameAs[IRI])*))
		| ("DifferentFrom:" (differentFrom[IRI] ("," differentFrom[IRI])*))
		| ("Facts:" (facts ("," facts)*))
	)*;
	
	ObjectPropertyFact ::= not[NOT]? objectProperty[IRI] individual[IRI];
	 
	DataPropertyFact ::= not[NOT]? dataProperty[IRI] literal;
	
	// MISC Frame TODO
	Misc ::= "Misc";
	
	// Descriptions
	Description ::= (annotations ("," annotations)*)? conjunctions ("or" conjunctions)*;
	Conjunction ::= (clazz[IRI] "that")? primaries ("and" primaries)*;								
		
	ClassAtomic ::= not[NOT]? clazz[IRI];
	IndividualsAtomic ::= not[NOT]? "{" individuals[IRI] ("," individuals[IRI])* "}";
	NestedDescription ::= not[NOT]? "{" description "}";
	
	ObjectPropertySome ::= not[NOT]? propertyReference "some" primary;
	ObjectPropertyOnly ::= not[NOT]? propertyReference "only" primary;
	ObjectPropertySelf ::= not[NOT]? propertyReference "self";
	ObjectPropertyValue ::= not[NOT]? propertyReference "value" individual[IRI];
	ObjectPropertyMin ::= not[NOT]? propertyReference "min" value[INT] primary?;
	ObjectPropertyMax ::= not[NOT]? propertyReference "max" value[INT] primary?;
	ObjectPropertyExactly ::= not[NOT]? propertyReference "exactly" value[INT] primary?;

	DataPropertySome ::= not[NOT]? dataProperty[IRI] "some" dataPrimary;
	DataPropertyOnly ::= not[NOT]? dataProperty[IRI] "only" dataPrimary;
	DataPropertyValue ::= not[NOT]? dataProperty[IRI] "value" literal;
	DataPropertyMin ::= not[NOT]? dataProperty[IRI] "min" value[INT] dataPrimary;
	DataPropertyMax ::= not[NOT]? dataProperty[IRI] "max" value[INT] dataPrimary;
	DataPropertyExactly ::= not[NOT]? dataProperty[IRI] "exactly" value[INT] dataPrimary;

	ObjectPropertyReference ::= inverse[INVERSE]? property[IRI];

	// DataRanges
	DataRange ::= dataConjunctions ("or" dataConjunctions)*;
	DataConjunction ::= dataPrimaries ("and" dataPrimaries)*; 
	DatatypeReference ::= not[NOT]? theDatatype[IRI] ("[" facets ("," facets)* "]")?;
	Facet ::= facetType[FACETKINDS] literal;
	NestedDataRange ::= not[NOT]? "(" dataRange ")";
	DataPrimaryLiterals ::= not[NOT]? "{" literals ("," literals)* "}";
		
	
	// Literals
	
	TypedLiteral ::= lexicalValue['"','"'] "^^" theDatatype[IRI];
	AbbreviatedXSDStringLiteral ::= value['"','"'];
	AbbreviatedRDFTextLiteral ::= value['"','"'] "@" languageTag[IRI];
	IntegerLiteral ::= value[INT];
	DecimalLiteral ::= preComma[INT] "." postComma[INT];
	FloatingPointLiteral ::= literal[FLOAT];
	
	Datatype ::= iri[IRI];
}