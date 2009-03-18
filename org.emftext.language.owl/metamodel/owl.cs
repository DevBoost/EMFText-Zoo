SYNTAXDEF owl
FOR <http://org.emftext/owl.ecore> <owl.genmodel>
START OntologyDocument

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
	tokenspace = "1";
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

	Annotation ::= "Annotations:" ( annotations? propertyIri[IRI] target (!1 "," annotations? propertyIri[IRI] target)*)?;
	
	IRITarget ::= target[IRI];
	
	LiteralTarget ::= literal;
	
	Namespace ::= "Namespace:" prefix[IRI]? uri[IRI] !1;
	
	Ontology ::= "Ontology:" (uri[IRI] versionIRI[IRI] ? !1)? 
					("Import:" imports[IRI] !1)* 
					annotations* 
					(frames !1)*;
	
	// ONTOLOGY Class definitions and Axioms			
	Class ::= "Class:" iri[IRI] (
				(annotations) 
				| ("SubClassOf:" (superClassesDescriptions ("," superClassesDescriptions )*)? !1)
				| ("EquivalentTo:" (equivalentClassesDescriptions ("," equivalentClassesDescriptions)*)? !1)
				| ("DisjointWith:" (disjointWithClassesDescriptions ("," disjointWithClassesDescriptions )*)? !1)
				| ("DisjointUnionOf:" (disjointUnionWithClassesDescriptions ("," disjointUnionWithClassesDescriptions)*)? !1)
			)*;
	
	// ONTOLOGY Property definitions and Axioms			
	ObjectProperty ::= "ObjectProperty:" iri[IRI] ((annotations) |
		( "Domain:" propertyDomain ("," propertyDomain)* !1) |
		( "Range:" propertyRange ("," propertyRange)* !1) | 
		( "Characteristics:" characteristics[CHARACTERISTICS] ("," characteristics[CHARACTERISTICS])* !1) | 
		( "SubPropertyOf:" superProperties ("," superProperties)* !1) |
		( "EquivalentTo:" equivalentProperties ("," equivalentProperties)* !1) |
		( "DisjointWith:" disjointProperties ("," disjointProperties)* !1) |
		( "InverseOf:" inverseProperties ("," inverseProperties)* !1) |
		( "SubPropertyChain:" subPropertyChains ("o" subPropertyChains)+ !1))*;
	
	// DataProperty definitions	
	DataProperty ::= "DataProperty:" iri[IRI] (
		(annotations) 
		| ("Domain:" (domain ("," domain)*)!1)
		| ("Range:" (range ("," range)*)!1)
		| ("Characteristics:" characteristic[CHARACTERISTICS] !1)
		| ("SubPropertyOf:" (superProperties[IRI] ("," superProperties[IRI])*) !1)
		| ("EquivalentTo:" (equivalentProperties[IRI] ("," equivalentProperties[IRI])*)!1)
		| ("DisjointWith:" (disjointProperties[IRI] ("," disjointProperties[IRI])*)! 1)
	)*;
	
	// Annotation Property definition
	AnnotationProperty ::= "AnnotationProperty:" iri[IRI] (
		(annotations)
		| ("Domain:" (domains[IRI] ("," domains[IRI])*)!1)
		| ("Range:" (ranges[IRI] ("," ranges[IRI])*)!1)
		| ("SubPropertyOf:" (superAnnotationProperties[IRI]("," superAnnotationProperties[IRI])*)!1)
	)*;

	// Individual Property definition
	Individual ::= "Individual:" iri[IRI] (
		(annotations)
		| ("Types:" (types ("," types)*)!1)
		| ("SameAs:" (sameAs[IRI] ("," sameAs[IRI])*)!1)
		| ("DifferentFrom:" (differentFrom[IRI] ("," differentFrom[IRI])*)!1)
		| ("Facts:" (facts ("," facts)*)!1)
	)*;

	// Datatype definition
	Datatype ::= "Datatype:" iri[IRI] (
		(annotations) ("EquivalentTo:" dataRange)? (annotations)
	)*;

	ObjectPropertyFact ::= not[NOT]? objectProperty[IRI] individual[IRI];
	 
	DataPropertyFact ::= not[NOT]? dataProperty[IRI] literal;
	
	// MISC Frame TODO
	EquivalentClasses ::= "EquivalentClasses:" annotations? descriptions ("," descriptions)+;
	DisjointClasses ::= "DisjointClasses:" annotations? descriptions ("," descriptions)+;
	EquivalentProperties ::= "EquivalentProperties:" annotations? objectProperties[IRI] ("," objectProperties[IRI])+;
	DisjointProperties ::= "DisjointProperties:" annotations? objectProperties[IRI] ("," objectProperties[IRI])+;  
	SameIndividuals ::= "SameIndividual:" annotations? individuals[IRI] ("," individuals[IRI])+;
	DifferentIndividuals ::= "DifferentIndividuals:" annotations? individuals[IRI] ("," individuals[IRI])+;
	HasKey ::=  "HasKey:" description annotations? ( objectPropertyReferences | dataProperties[IRI] )+;
	
	// Descriptions
	
	Disjunction ::= (annotations ("," annotations)*)? conjunctions:Conjunction ("or" conjunctions:Conjunction)*;
	Conjunction ::= (clazz[IRI] "that")? primaries:Primary ("and" primaries:Primary)*;								
		
	ObjectPropertySome ::= not[NOT]? inverse[INVERSE]? feature[IRI] "some" (primary|dataPrimary);
	ObjectPropertyOnly ::= not[NOT]? inverse[INVERSE]? feature[IRI] "only" (primary|dataPrimary);
	ObjectPropertySelf ::= not[NOT]? inverse[INVERSE]? objectProperty[IRI] "Self";
	ObjectPropertyValue ::= not[NOT]? inverse[INVERSE]? feature[IRI] "value" (individual[IRI]|literal);

 	ObjectPropertyMin ::= not[NOT]? inverse[INVERSE]? feature[IRI] "min" value[INT] (primary|dataPrimary)?;
	ObjectPropertyMax ::= not[NOT]? inverse[INVERSE]? feature[IRI] "max" value[INT] (primary|dataPrimary)?;
	ObjectPropertyExactly ::= not[NOT]? inverse[INVERSE]? feature[IRI] "exactly" value[INT] (primary|dataPrimary)?;


	ClassAtomic ::= not[NOT]? clazz[IRI];
	IndividualsAtomic ::= not[NOT]? "{" individuals[IRI] ("," individuals[IRI])* "}";
	NestedDescription ::= not[NOT]? "(" description:Disjunction ")";
	
	ObjectPropertyReference ::= inverse[INVERSE]? objectProperty[IRI];

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
}