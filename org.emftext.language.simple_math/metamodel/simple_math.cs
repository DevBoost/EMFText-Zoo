//*******************************************************************************
// Copyright (c) 2006-2009 
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
START     Additive

OPTIONS {
	forceEOF = "true";
	tokenspace = "1";
}

TOKENS {
	DEFINE ADDITIVE_OPERATOR $ '+' | '-'$;
	DEFINE MULTIPLICATIVE_OPERATOR $ '*' | '/' $;
	DEFINE INTEGER_LITERAL $('1'..'9') ('0'..'9')* | '0'$;
	DEFINE REAL_LITERAL $ (('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')*)?$;
	
	DEFINE REAL_TYPE $'Real'$;
	DEFINE INTEGER_TYPE $'Integer'$;
}

RULES {
		Additive ::= left (right)*;
		AdditivePart ::= operator[ADDITIVE_OPERATOR] mul;
		
		Multiplicative ::= left (right)*;
		MultiplicativePart ::= operator[MULTIPLICATIVE_OPERATOR] unary;
		
		UnaryMath ::= (operator[ADDITIVE_OPERATOR])? atom;
		
		IntegerLiteralExp ::= intValue[INTEGER_LITERAL];
		RealLiteralExp ::= floatValue[REAL_LITERAL];
		
		RealType ::= typename[REAL_TYPE];
		IntegerType ::= typename[INTEGER_TYPE];
		
		BracketExp ::= "(" body ")";
}
