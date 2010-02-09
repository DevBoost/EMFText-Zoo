SYNTAXDEF text.secprop
FOR <http://www.emftext.org/language/SecProp> <secprop.text.genmodel>
START SecPropModel

OPTIONS {
	baseResourcePlugin="org.emftext.language.secprop.resource";
}

TOKENSTYLES{
	"access" COLOR #3EB93B, BOLD;
	"encryption" COLOR #C80000, BOLD;
}

RULES{
	
	SecPropModel::= "secprop" "{" (!1 ( elements | channels | data ))* !0 "}"  ;
	
	Element::= "element" name[] ";";
	
	Channel::= "channel" name[] ":" source[] "-->" target[] ";";
	
	Data::= "data"  name[] "on" channel[] "{" (!1 (securityInformation))* !0 "}"  ;
	
	Access::= "access"  value[] ";"  ;
	
	Encryption::= "encryption"  value[] ";"  ;
	
}