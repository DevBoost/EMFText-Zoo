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
START     Expression

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	forceEOF = "true";
	tokenspace = "1";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE ADDITIVE_OPERATOR $ '+' | '-' $;
	DEFINE MULTIPLICATIVE_OPERATOR $ '*' | '/' $;
	DEFINE INTEGER_LITERAL $('1'..'9') ('0'..'9')* | '0'$;
	DEFINE REAL_LITERAL $ (('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')*)?$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {

	@operator(type="binary_left_associative", weight="1", identifier="Expression")
	Additive ::= left (operator[ADDITIVE_OPERATOR]) right;

	@operator(type="binary_left_associative", weight="2", identifier="Expression")
	Multiplicative ::= left operator[MULTIPLICATIVE_OPERATOR] right;
	
	@operator(type="binary_right_associative", weight="3", identifier="Expression")
	Potence ::= base "^" exponent;
	
 	@operator(type="unary_prefix", weight="4", identifier="Expression")	
	Negation ::= operator[ADDITIVE_OPERATOR] body;
	
	@operator(type="primitive", weight="5", identifier="Expression")
	BracketExp ::= "(" body ")";

	@operator(type="primitive", weight="5", identifier="Expression")
	IntegerLiteralExp ::= intValue[INTEGER_LITERAL];

	@operator(type="primitive", weight="5", identifier="Expression")
	RealLiteralExp ::= floatValue[REAL_LITERAL];
}
