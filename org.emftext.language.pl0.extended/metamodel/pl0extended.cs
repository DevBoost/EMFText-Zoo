SYNTAXDEF pl0extended
FOR <http://www.emftext.org/language/pl0extended>
START ProgramWithImports

IMPORTS {
	pl0 : <http://www.emftext.org/language/pl0> <../../org.emftext.language.pl0/metamodel/pl0.genmodel>
		WITH SYNTAX bool <../../org.emftext.language.pl0/metamodel/pl0.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

RULES {
	@Foldable
	ProgramWithImports   ::= 	("PROGRAM"|"program") name[PL0ID] !0!0
								("import" #1 imports)* !0!0
								 block ".";
								 
	Import ::= programReference['<','>'];
	
	ExternalIdentReference ::= importReference[PL0ID] #0 "." #0 referencedDeclaration[PL0ID];
}