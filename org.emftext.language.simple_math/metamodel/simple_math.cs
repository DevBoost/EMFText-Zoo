SYNTAXDEF sm
FOR       <http://www.emftext.org/simple_math>
START     Additive

OPTIONS {
	forceEOF = true;
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
