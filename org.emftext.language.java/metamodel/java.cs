SYNTAXDEF java
FOR <http://www.emftext.org/java>
START core.CompilationUnit

IMPORTS {
	core : <http://www.emftext.org/java/core>
	comments : <http://www.emftext.org/java/comments>
	types : <http://www.emftext.org/java/types>
}

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
	standardTextTokenName = IDENTIFIER;
	overridePluginXML = false;
	generateCodeFromGeneratorModel = false;
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE ML_COMMENT $'/*'.*'*/'$;

	DEFINE FLOATING_POINT_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))? |   ('.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+) (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('f'|'F'|'d'|'D')))$;
	DEFINE HEX_LITERAL $'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+('l'|'L')?$;
	DEFINE DECIMAL_LITERAL $('0'|'1'..'9''0'..'9'*)('l'|'L')?$;
	DEFINE OCTAL_LITERAL $'0'('0'..'7')+('l'|'L')?$;

	DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	
	DEFINE ADDITIVE_OPERATOR_LITERAL $'+'|'-'$;
	DEFINE MULTIPLICATIVE_OPERATOR_LITERAL $'*'|'/'|'%'$;
	
	DEFINE CHARACTER_LITERAL $'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	
	//DEFINE IDENTIFIER $('\u0024'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u00ff'|'\u0100'..'\u1fff'|'\u3040'..'\u318f'|'\u3300'..'\u337f'|'\u3400'..'\u3d2d'|'\u4e00'..'\u9fff'|'\uf900'..'\ufaff')(('\u0024'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u00ff'|'\u0100'..'\u1fff'|'\u3040'..'\u318f'|'\u3300'..'\u337f'|'\u3400'..'\u3d2d'|'\u4e00'..'\u9fff'|'\uf900'..'\ufaff')|('\u0030'..'\u0039'|'\u0660'..'\u0669'|'\u06f0'..'\u06f9'|'\u0966'..'\u096f'|'\u09e6'..'\u09ef'|'\u0a66'..'\u0a6f'|'\u0ae6'..'\u0aef'|'\u0b66'..'\u0b6f'|'\u0be7'..'\u0bef'|'\u0c66'..'\u0c6f'|'\u0ce6'..'\u0cef'|'\u0d66'..'\u0d6f'|'\u0e50'..'\u0e59'|'\u0ed0'..'\u0ed9'|'\u1040'..'\u1049'))+$;
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
}

RULES {

core.CompilationUnit 
   ::=	comments*
   		annotations*
        comments* 
        ("package" package[] (#0 "." #0 package[])* #0 ";" )?
        !0 !0
        comments*
        ("import" imports #0 ";" !0 )*
        !0
        (classifiers !0 !0)+
	;
	
core.Import
	::= static? package[] #0 ("." #0 package[])* #0 "." #0 classifiers[];
	
core.Class
	::=	modifiers* "class" name[] ("<" typeParameters ("," typeParameters)* ">")?
        ("extends" extends)?
        ("implements" implements)?
        "{" (!1 members (";")?)* !0 "}"
	;

core.Interface
	::=	modifiers* "interface" name[] ("<" #0 typeParameters (#0 "," typeParameters)* #0 ">")?
	       ("extends" (extends ("," extends)*))? 
	       "{" ((members (";")?) | (";")?)* "}"
	;

core.Annotation
	::=	modifiers* "@" "interface" name[]
	       "{" ((members (";")?) | (";")?)* "}"
	;

core.AnnotationInstance
	::=	"@" annotation 
		("(" (elementValue | (elementValuePairs ("," elementValuePairs)*)) ")")? 
	;

core.AnnotationElementValuePair
	::= key[] "=" value
	;

core.AnnotationElementValueArray
    ::= "{" (values ("," values)*)? (",")? "}"
    ;

core.Enumeration
    ::= modifiers* "enum" name[] ("implements" (implements[] ("," implements[])*))? "{" (constants ("," constants)*)? (",")? ((";" members*)? | (";")?) "}"
    ;

core.TypeParameter
	::=	name[] ("extends" extendTypes ("&" extendTypes)*)?
	;

core.EnumConstant
    ::= name[] ("(" arguments ("," arguments)* ")" )? members* 
    ;

core.Block
	::=	modifiers* "{" #1 statements* #0 "}"
	;

core.Constructor
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? name[]
	"(" (parameters ("," parameters)* )? ")" 
	("throws" exceptions[] ("," exceptions[])?)? body
	;

core.Method
	::=	annotations* modifiers* ("<" #0 typeParameters (#0 "," typeParameters)* #0 ">")? (type arrayDimensions*) name[]  
	"(" #0 (parameters ("," parameters)* )? #0 ")" arrayDimensions*
	("throws" exceptions[] ("," exceptions[])?)? (body | ";")
	;
	
core.AnnotationMethod
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? (type arrayDimensions*) name[]  
	"(" (parameters ("," parameters)* )? ")" arrayDimensions*
	("throws" exceptions[] ("," exceptions[])?)? "default" defaultValue (body | ";")
	;

core.OrdinaryParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions*
	;

core.VariableLengthParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? "..." name[] 
	;

core.LocalVariable
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions* ("=" initialValue)? ("," additionalLocalVariables)*
	;

core.LocalVariableStatement
	::= variable ";" ;

core.AdditionalLocalVariable
	::= name[] arrayDimensions* ("=" initialValue)?
	;

core.Field
	::= annotations* modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions* ("=" initialValue)? ("," additionalFields)*
	;

core.AdditionalField
	::= name[] arrayDimensions* ("=" initialValue)?
	;

// INSTANTIATIONS
core.NewConstructorCall 
	::= "new" 
		// these are the arguments for the constructor type parameters
		("<" typeArguments[] ("," typeArguments[])* ">")?
		type 
		// these are the arguments for the class type parameters
		("<" classTypeArguments[] ("," classTypeArguments[])* ">")?
		"(" (arguments ("," arguments)* )? ")"
		("{" (members (";")?)* "}")?
     ;
     
core.ExplicitConstructorCall 
	::= ("<" typeArguments[] ("," typeArguments[])* ">")?
		callTarget "(" (arguments ("," arguments)* )? ")"
     ;

core.ArrayInstantiationByValues
	::= ("new" type arrayDimensions+)? arrayInitializer
	;

core.ArrayInstantiationBySize 
	::= "new" type 
		("[" sizes "]")+
		arrayDimensions*
	;

core.ArrayInitializer
    ::= "{" ( (arrayInitializers | initialValues) ("," (arrayInitializers | initialValues) )* (",")? )? "}"    
    ;
    
core.Reference
	::= primary ("[" arraySelectors? "]")* (#0 "." #0 next)? 
	;
	
types.TypeReferenceSequence
	::= parts (#0 "." #0 parts)*
	;

core.PackageOrClassifierReference
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
	;

core.PackageOrClassifierOrMethodOrVariableReference
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
		("(" (arguments ("," arguments)* )? ")")?
	;

core.ExplicitGenericInvocation
	::= ("<" typeArguments ("," typeArguments)* ">")?
		target[]
		("(" (arguments ("," arguments)* )? ")")?
	;

core.QualifiedTypeArgument
	::= type
	;

core.UnknownTypeArgument
	::= "?"
	;

core.ExtendsTypeArgument
	::= "?" "extends" extendTypes ("&" extendTypes)*
	;

core.SuperTypeArgument
	::= "?" "super" superType
	;

core.Assert
	::= "assert" expression1 (":" expression2)? ";" ;
	
core.Condition 
	::= "if" "(" expression ")" ifStatement ("else" elseStatement)? ;
	
core.ForLoop
	::= "for" "(" init? ";" condition? ";" (updates ("," updates)* )? ")" body;

core.ForEachLoop
	::= "for" "(" next ":" collection ")" body;
	
core.WhileLoop
	::= "while" "(" condition ")" body;
	
core.DoWhileLoop	
	::= "do" body "while" "(" condition ")" ";" ;
	
core.EmptyStatement	
	::= ";" ;
	
core.SynchronizedBlock
	::= "synchronized" "(" lockExpression ")" body;
	
core.TryBlock
	::= "try" tryBlock
		catches* 
		("finally" finallyBlock)?;

core.CatchClause
	::=	"catch" "(" parameter ")" catchBlock
	;

core.Switch
	::= "switch" "(" variable ")" "{" cases* default? "}" ;
	
core.NormalSwitchCase
	::= "case" condition ":" body* ;
	
core.DefaultSwitchCase
	::= "default" ":" body* ;
	
core.Return
	::= "return" expression? ";" ;
	
core.Throw
	::= "throw" expression ";" ;
	
core.Break
	::= "break" ";" ;
	
core.Continue
	::= "continue"  ";" ;
	
core.JumpLabel
	::= name[] ":" statement ;

core.Assignment
	::= target "=" value;

// TODO was a subtype of Expression, but this generalization was
// temporarily removed, because variable declarations could not
// be distinguished from single expressions
core.ExpressionStatement 
	::= expression ";" 
	;

core.ParExpression ::= "(" expression ")" ;

core.ExpressionList
	::= expressions ("," expressions)* ;

core.InclusiveOrExpression
    ::= exclusiveOrExpression ( "|" exclusiveOrExpression )* ;

core.ExclusiveOrExpression
    ::=   andExpression ( "^" andExpression )* ;

core.AndExpression
    ::=   equalityExpression ( "&" equalityExpression )* ;
  
core.EqualityExpression
    ::= instanceOfExpression ( (equal | notEqual) instanceOfExpression )* ;
    
core.InstanceOfExpression
    ::= relationExpression ("instanceof" type)? ;
    
core.RelationExpression
	::= shiftExpression ( relationOperator shiftExpression)*;
	
core.ShiftExpression
	::= additiveExpression ( shiftOperator additiveExpression)*;

core.AdditiveExpression
    ::= multiplicativeExpression ( additiveOperator multiplicativeExpression )* ;
    
core.MultiplicativeExpression
    ::=	unaryExpression ( multiplicativeOperator unaryExpression )* ;
    
core.UnaryExpression
    ::= (additiveOperator | plusplus | minusminus)? unaryExpressionNotPlusMinus
    ;
    
core.UnaryExpressionNotPlusMinus
	::= (complement | negate) primary
	|   castExpression
	|   primary ( plusplus | minusminus)?
    ;
core.CastExpression
    ::= "(" primitiveType ")" unaryExpression
    |  	"(" type ")" unaryExpressionNotPlusMinus
    ;
    
core.Primary 
	::=	reference
	| literal
	| parExpression
	;    

core.AdditiveOperator		::= value[ADDITIVE_OPERATOR_LITERAL] ;
core.MultiplicativeOperator	::= value[MULTIPLICATIVE_OPERATOR_LITERAL] ;

core.LessThan 			::= "<";
core.LessThanOrEqual		::= "<" "=";
core.GreaterThan			::= ">";
core.GreaterThanOrEqual	::= ">" "=";

core.LeftShift 			::= "<" "<" ;
core.RightShift 			::= ">" ">" ;
core.UnsignedRightShift	::= ">" ">" ">" ;

core.Equal		::= "==";	
core.NotEqual	::= "!=";
core.PlusPlus 	::= "++" ;
core.MinusMinus 	::= "--" ;
core.Complement 	::= "~" ;
core.Negate 		::= "!" ;

core.ArrayDimension ::= ("[" "]");

core.NullLiteral ::= "null";
types.VoidLiteral ::= "void";
core.ClassLiteral ::= "class";
core.This ::= "this";
core.Super ::= "super";

core.Public ::= "public";
core.Abstract ::= "abstract";
core.Protected ::= "protected";
core.Private ::= "private";
core.Final ::= "final";
core.Static ::= "static";

core.Native ::= "native";
core.Synchronized ::= "synchronized";
core.Transient ::= "transient";
core.Volatile ::= "volatile";
core.Strictfp ::= "strictfp";

types.Boolean ::= "boolean";
types.Char ::= "char";
types.Byte ::= "byte";
types.Short ::= "short";
types.Int ::= "int";
types.Long ::= "long";
types.Float ::= "float";
types.Double ::= "double";

core.IntegerLiteral 
	::= value[DECIMAL_LITERAL] | value[HEX_LITERAL] | value[OCTAL_LITERAL];

core.FloatingPointLiteral 
	::= value[FLOATING_POINT_LITERAL];

core.CharacterLiteral 
	::= value[CHARACTER_LITERAL];

core.StringLiteral 
	::= value[STRING_LITERAL];

core.BooleanLiteral 
	::= value[BOOLEAN_LITERAL];
	
comments.SingleLineComment
	::= content[SL_COMMENT];
	
comments.MultiLineComment
	::= content[ML_COMMENT];
}
