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

SYNTAXDEF sm
FOR       <http://www.emftext.org/language/simple_math>
START     Root

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	forceEOF = "true";
	tokenspace = "1";
}

TOKENS {
	DEFINE ADDITIVE_OPERATOR $ '+' | '-' $;
	DEFINE MULTIPLICATIVE_OPERATOR $ '*' | '/' $;
	DEFINE INTEGER_LITERAL $('1'..'9') ('0'..'9')* | '0'$;
	DEFINE REAL_LITERAL $ (('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')*)?$;
}

RULES {
	Root ::= exp;
	
	@Leftassoc(weight="1", identifier="Expression")
	Multiplicative ::= left operator[MULTIPLICATIVE_OPERATOR] right;
	
	@Leftassoc(weight="2", identifier="Expression")
	Additive ::= left operator[ADDITIVE_OPERATOR] right;

	@Unary(weight="3", identifier="Expression")	
	Negation ::= "-" body;
	
	@Primitive(weight="5", identifier="Expression")
	BracketExp ::= "(" body ")";

	@Primitive(weight="5", identifier="Expression")
	IntegerLiteralExp ::= intValue[INTEGER_LITERAL];

	@Primitive(weight="5", identifier="Expression")
	RealLiteralExp ::= floatValue[REAL_LITERAL];
}
