SYNTAXDEF feature
FOR <http://www.tudresden.de/feature>
START FeatureModel

OPTIONS {
	tokenspace = "1";
	resourcePluginID = "org.emftext.language.feature.resource.feature";
	basePackage = "org.emftext.language.feature.resource.feature";
	overrideManifest = "false";
}

TOKENS{
		DEFINE COMMENT$'//'(~('\\n'|'\\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		FeatureModel::= "FeatureModel"  name['"','"'] 
						( "{" "constraints"  ( constraints ";")? "}" )? 
						root;
		Constraint::= "Constraint" language[] ":" expression['"','"'];
		Feature::= "Feature" name['"','"'] 
					("(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")")?
					("[" attributes* "]")? 
					( groups* )?  ;
		Group::= "Group" ("(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")" )?
				   ("{" childFeatures* "}")?;
		Attribute::= type[] name[] #1 "=" value['"','"'] !2;
		
}