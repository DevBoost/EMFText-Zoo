//*******************************************************************************
// Copyright (c) 2006-2010 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF pico
FOR <http://www.emftext.org/language/pico>
START Program

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE PICOID $('a'..'z')('a'..'z'|'0'..'9')*$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {

	Natural ::= "natural";
	
	String ::= "string";
	
	NilType ::= "nil";
	
	Program ::= "begin" declarations statements (";" statements)* "end" ;
	
	Declarations ::= "declare" idTypes ("," idTypes)* ";" ;
	
	IDType ::= picoID[PICOID] ":" type ;
	
	
	Assignment::= left[PICOID] ":=" right;
	
	IfStatement::= "if" condition "then" then* "else" else* "fi";
	
	WhileStatement::= "while" condition "do" body* "od";
	
	VariableReference ::= variable[PICOID];
	
	// TODO add other expressions
}