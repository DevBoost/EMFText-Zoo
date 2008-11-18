SYNTAXDEF feature
FOR <http://www.tudresden.de/feature>
START FeatureModel

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		FeatureModel::= "FeatureModel"  name['"','"'] "{" ( "constraints"  ( constraints ";")* )? "}"  root  ;
		
		Constraint::= "Constraint" "(" (constrainedFeatures[] ("," constrainedFeatures[])*)? ")" 
					 language[] ":" expression['"','"'];
	
		
		Feature::= "Feature" name['"','"'] 
					
					("(" minCardinality[INTEGER]".." maxCardinality[INTEGER] ")")? 
					("/*" attributes* "*/")? 
					("[" attributes* "]")? 
					( groups* )?  ;
		
		Group::= "Group" ("(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")" )?
				   ("{" childFeatures* "}")?;
		
		Attribute::= type[] name[] "type"  "=" value['"','"'] ;
		
}