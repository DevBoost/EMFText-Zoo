SYNTAXDEF office
FOR <http://emftext.org/office>
START OfficeModel

OPTIONS {
	generateCodeFromGeneratorModel = "true";
}

RULES { 
	OfficeModel ::= "officemodel" name[]
					"{" elements* "}" ;
	
	Office ::= "office" name[];
	
	Employee ::= "employee" name[] 
				 "works" "in" worksIn[] 
				 "works" "with" 
				 worksWith[] ("," worksWith[])* ;
}