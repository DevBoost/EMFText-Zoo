SYNTAXDEF feature
FOR <http://www.tudresden.de/feature>
START FeatureModel

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		FeatureModel::= "FeatureModel"  "{" ( "constraints"  ":" constraints | "root"  ":" root | "name"  ":" name['"','"'] | "children"  ":" children | "parent"  ":" parent[] )* "}"  ;
		
		Feature::= "Feature"  "{" ( "name"  ":" name['"','"'] | "minCardinality"  ":" minCardinality[INTEGER]| "maxCardinality"  ":" maxCardinality[INTEGER]| "attributes"  ":" attributes | "groups"  ":" groups | "parentGroup"  ":" parentGroup[]| "annotations"  ":" annotations | "constraints"  ":" constraints[] )* "}"  ;
		
		Group::= "Group"  "{" ( "minCardinality"  ":" minCardinality[INTEGER]| "maxCardinality"  ":" maxCardinality[INTEGER]| "parentFeature"  ":" parentFeature[]| "childFeatures"  ":" childFeatures  )* "}"  ;
		
		Constraint::= "Constraint"  "{" ( "language"  ":" language['"','"'] | "expression"  ":" expression['"','"'] | "constrainedFeatures"  ":" constrainedFeatures[] )* "}"  ;
		
		Attribute::= "Attribute"  "{" ( "feature"  ":" feature[]| "name"  ":" name['"','"'] | "type"  ":" type['"','"'] | "value"  ":" value['"','"']  )* "}"  ;
		
		Annotation::= "Annotation"  "{" ( "feature"  ":" feature[] )* "}"  ;
		
}