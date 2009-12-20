SYNTAXDEF efactory
FOR <http://www.googlecode.com/efactory/EFactory>
START Factory

IMPORTS {
	somePrefix : <http://www.eclipse.org/emf/2002/Ecore>
}

TOKENS {
	DEFINE LONG $('-')?('0'..'9')+$;
	DEFINE DOUBLE $('-')?('0'..'9')+'.'('0'..'9')+$;
	DEFINE DATE $('0'..'1')'0'..'9''.''0'..'3''0'..'9''.' '0'..'9''0'..'9''0'..'9''0'..'9'$;
	DEFINE IS_MANY $('+')?('=')$;
	DEFINE BOOLEAN $'true'|'false'$;
	DEFINE STRING $('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')$;
}

RULES {
	Factory ::= epackages+ imports* annotations* root;

	PackageImport::= "use" ePackageURI[STRING] ("as" alias[])?;

	Import ::= "import" importURI[STRING];

	GlobalNameMapping ::= "@Name" "{" nameFeature[] "}";
	CustomNameMapping ::= "@Name" "{" eClass[] "=" nameFeature[] "}";
	
	Feature ::= eFeature[] isMany[IS_MANY] value;
	
	NewObject ::= "new" eClass[] (name[])? ("{" features* "}")?;
	
	Reference ::= value[];
	Containment ::= value;

	EnumAttribute ::= ":" value[STRING];
	StringAttribute ::= value[STRING];
	IntegerAttribute ::= value[LONG];
	DoubleAttribute ::= value[DOUBLE];
	DateAttribute ::= value[DATE];
	NullAttribute ::= "NULL";

	BooleanAttribute ::= value[BOOLEAN];	
}