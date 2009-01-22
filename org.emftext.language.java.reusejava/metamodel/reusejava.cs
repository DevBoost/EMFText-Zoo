SYNTAXDEF reusejava
FOR <http://www.emftext.org/reusejava>
START java.Containers.CompilationUnit, java.Containers.Package

IMPORTS {
	// copy all the rules from java.cs
	java : <http://www.emftext.org/java> WITH SYNTAX java
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
}

RULES {
	MemberSlot ::= "<" "<" name[] ">" ">"  ";" ;		
	StatementPrototype ::= ">" ">" name[] ":" statement;	
}
