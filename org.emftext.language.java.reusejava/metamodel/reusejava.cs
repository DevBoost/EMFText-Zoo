SYNTAXDEF reusejava
FOR <http://www.emftext.org/reusejava>
START java.Containers.CompilationUnit, java.Containers.Package, StatementUnit

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
}

RULES {
	StatementUnit ::=            "statements" name[] "{" statements "}" ;
	StatementVariationPoint ::=  "<" "<" name[] ">" ">"  ";" ;		
}
