SYNTAXDEF ecore_change
FOR <http://www.eclipse.org/emf/2003/Change>
START ChangeDescription

OPTIONS {
	resourcePluginID = "org.emftext.language.ecore.change.resource.ecore_change";
	basePackage = "org.emftext.language.ecore.change.resource.ecore_change";
}

RULES {
	ChangeDescription ::= objectChanges*;
	EObjectToChangesMapEntry ::= "change" value* "in" key[];
	FeatureChange ::= "feature" featureName[] "to" value[];
}