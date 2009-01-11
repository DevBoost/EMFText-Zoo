SYNTAXDEF java
FOR <http://www.emftext.org/java>
START containers.CompilationUnit

IMPORTS {
	annotations : <http://www.emftext.org/java/annotations>
	imports : <http://www.emftext.org/java/imports>
	references : <http://www.emftext.org/java/references>
	generics : <http://www.emftext.org/java/generics>
	arrays : <http://www.emftext.org/java/arrays>
	classifiers : <http://www.emftext.org/java/classifiers>
	enumerations : <http://www.emftext.org/java/enumerations>
	containers : <http://www.emftext.org/java/containers>
	instantiations : <http://www.emftext.org/java/instantiations>
	parameters : <http://www.emftext.org/java/parameters>
	variables : <http://www.emftext.org/java/variables>
	members : <http://www.emftext.org/java/members>
	commons : <http://www.emftext.org/java/commons>
	expressions : <http://www.emftext.org/java/expressions> 
	operators : <http://www.emftext.org/java/operators> 
	literals : <http://www.emftext.org/java/literals>
	modifiers : <http://www.emftext.org/java/modifiers>
	statements : <http://www.emftext.org/java/statements> 
	types : <http://www.emftext.org/java/types>
}
 
OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
	//backtracking = false;
	standardTextTokenName = IDENTIFIER;
	overridePluginXML = false;
	overridePrinter = false;
	generateCodeFromGeneratorModel = false;
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'))* ('\n'|'\r')$ COLLECT IN comments;
	DEFINE ML_COMMENT $'/*'.*'*/'$ COLLECT IN comments;

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
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'0'..'9')*$;
	DEFINE IMPORT_ALL_LITERAL $'.*'$;
	
	//PREDEFINED WS COLLECT IN whitespaces;
}

RULES {

containers.CompilationUnit 
   ::=	("package" package[] (#0 "." #0 package[])* #0 ";" )?
        !0 !0
        ("import" imports #0 ";" !0 )*
        !0
   		annotations*
        (classifiers !0 !0)+
        ("\u001a")?
	;
	
imports.ClassifierImport
	::= parts #0 ("." #0 parts)* #0 (("." #0 classifiers[]) | classifiers[IMPORT_ALL_LITERAL]);

imports.StaticImport
	::= static parts #0 ("." #0 parts)* #0 (("." #0 staticMembers[]) | staticMembers[IMPORT_ALL_LITERAL]);

classifiers.Class
	::=	modifiers* "class" name[] ("<" typeParameters ("," typeParameters)* ">")?
        ("extends" extends)?
        ("implements" (implements ("," implements)*))?
        "{" 
        	(!1 members (";")*)* !0 (";")*
        "}"
	;

classifiers.Interface
	::=	modifiers* "interface" name[] ("<" #0 typeParameters (#0 "," typeParameters)* #0 ">")?
		("extends" (extends ("," extends)*))? 
	    "{"
        	(!1 members (";")*)* !0 (";")*
		"}"
	;

classifiers.Enumeration
    ::= modifiers* "enum" name[] 
    	("implements" (implements ("," implements)*))? 
    	"{" 
    		(constants ("," constants)*)? (",")? 
    		(";" (members (";")?)*)?
    	"}"
    ;

classifiers.Annotation
	::=	modifiers* "@" "interface" name[]
	       "{" ((members (";")?) | (";")?)* "}"
	;

annotations.AnnotationInstance
	::=	"@" annotation 
		("(" (elementValue | (elementValuePairs ("," elementValuePairs)*)) ")")? 
	;

annotations.AnnotationElementValuePair
	::= key[] "=" value
	;

annotations.AnnotationElementValueArray
    ::= "{" (values ("," values)*)? (",")? "}"
    ;

generics.TypeParameter
	::=	name[] ("extends" extendTypes ("&" extendTypes)*)?
	;

enumerations.EnumConstant
    ::= name[] ("(" arguments ("," arguments)* ")" )? members* 
    ;

statements.Block
	::=	modifiers* "{" #1 statements* #0 "}"
	;

members.Constructor
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? name[]
	"(" (parameters ("," parameters)* )? ")" 
	("throws" exceptions ("," exceptions)*)? body
	;

members.Method
	::=	annotations* modifiers* ("<" #0 typeParameters (#0 "," typeParameters)* #0 ">")? (type arrayDimensions*) name[]  
	"(" #0 (parameters ("," parameters)* )? #0 ")" arrayDimensions*
	("throws" exceptions ("," exceptions)*)? (body | ";")
	;
	
annotations.AnnotationMethod
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? (type arrayDimensions*) name[]  
	"(" (parameters ("," parameters)* )? ")" arrayDimensions*
	("throws" exceptions ("," exceptions)*)? "default" defaultValue (body | ";")
	;

parameters.OrdinaryParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments ("," typeArguments)* ">")? name[] arrayDimensions*
	;

parameters.VariableLengthParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments ("," typeArguments)* ">")? "..." name[] 
	;

variables.LocalVariable
	::= modifiers* type arrayDimensions* ("<" typeArguments ("," typeArguments)* ">")? name[] localArrayDimensions* ("=" initialValue)? ("," additionalLocalVariables)*
	;

statements.LocalVariableStatement
	::= variable ";" ;

variables.AdditionalLocalVariable
	::= name[] arrayDimensions* ("=" initialValue)?
	;

members.Field
	::= annotations* modifiers* type arrayDimensions* ("<" typeArguments ("," typeArguments)* ">")? name[] localArrayDimensions* ("=" initialValue)? ("," additionalFields)* ";"
	;

members.AdditionalField
	::= name[] arrayDimensions* ("=" initialValue)?
	;

// INSTANTIATIONS
instantiations.NewConstructorCall 
	::= "new" 
		// these are the arguments for the constructor type parameters
		("<" typeArguments ("," typeArguments)* ">")?
		type 
		// these are the arguments for the class type parameters
		("<" classTypeArguments ("," classTypeArguments)* ">")?
		"(" (arguments ("," arguments)* )? ")"
		("{" (members (";")?)* "}")?
     ;
     
instantiations.ExplicitConstructorCall 
	::= ("<" typeArguments ("," typeArguments)* ">")?
		callTarget "(" (arguments ("," arguments)* )? ")"
     ;

arrays.ArrayInstantiationByValues
	::= ("new" type arrayDimensions+)? arrayInitializer
	;

arrays.ArrayInstantiationBySize 
	::= "new" type 
		("[" sizes "]")+
		arrayDimensions*
	;

arrays.ArrayInitializer
    ::= "{" ( (arrayInitializers | initialValues) ("," (arrayInitializers | initialValues) )* )? (",")? "}"    
    ;
    
references.Reference
	::= primary ("[" arraySelectors? "]")* (#0 "." #0 next)? 
	;
	
types.TypeReferenceSequence
	::= parts (#0 "." #0 parts)*
	;

references.PlainPackageOrClassifierReference
	::= target[] 
	;
	
references.ParameterizedPackageOrClassifierReference
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
	;
	
references.MethodCall
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
		"(" (arguments ("," arguments)* )? ")"
	;

// ATTENTION: This definition must reside after the definition for references.MethodCall!
// Otherwise method calls can not be parsed, because the ANTLR backtracking does not work here. 
references.PackageOrClassifierOrVariableReference
	::= target[]
	;

// TODO move to generics package
generics.ExplicitGenericMethodCall
	::= "<" typeArguments ("," typeArguments)* ">"
		target[]
		"(" (arguments ("," arguments)* )? ")"
	;

generics.QualifiedTypeArgument
	::= type arrayDimensions*
	;

generics.UnknownTypeArgument
	::= "?"
	;

generics.ExtendsTypeArgument
	::= "?" "extends" extendTypes ("&" extendTypes)* arrayDimensions*
	;

generics.SuperTypeArgument
	::= "?" "super" superType arrayDimensions*
	;

statements.Assert
	::= "assert" expression1 (":" expression2)? ";" ;
	
statements.Condition 
	::= "if" "(" expression ")" ifStatement ("else" elseStatement)? ;
	
statements.ForLoop
	::= "for" "(" init? ";" condition? ";" (updates ("," updates)* )? ")" body;

statements.ForEachLoop
	::= "for" "(" next ":" collection ")" body;
	
statements.WhileLoop
	::= "while" "(" condition ")" body;
	
statements.DoWhileLoop	
	::= "do" body "while" "(" condition ")" ";" ;
	
statements.EmptyStatement	
	::= ";" ;
	
statements.SynchronizedBlock
	::= "synchronized" "(" lockExpression ")" body;
	
statements.TryBlock
	::= "try" tryBlock
		catches* 
		("finally" finallyBlock)?;

statements.CatchClause
	::=	"catch" "(" parameter ")" catchBlock
	;

statements.Switch
	::= "switch" "(" variable ")" "{" (cases*) "}";
	
statements.NormalSwitchCase
	::= "case" condition ":" body* ;
	
statements.DefaultSwitchCase
	::= "default" ":" body* ;
	
statements.Return
	::= "return" expression? ";" ;
	
statements.Throw
	::= "throw" expression ";" ;
	
statements.Break
	::= "break" (target[])? ";" ;
	
statements.Continue
	::= "continue" (target[])? ";" ;
	
statements.JumpLabel
	::= name[] ":" statement ;

// TODO was a subtype of Expression, but this generalization was
// temporarily removed, because variable declarations could not
// be distinguished from single expressions
statements.ExpressionStatement 
	::= expression ";" 
	;

expressions.ParExpression ::= "(" expression ")" ;

expressions.ExpressionList
	::= expressions ("," expressions)* ;
 
expressions.Expression
	::= conditionalExpression (assignmentOperator expression)? ;
	
expressions.ConditionalExpression
    ::= conditionalOrExpression ( "?" expression ":" expression )? ;
    
expressions.ConditionalOrExpression
    ::= conditionalAndExpression ( "||" conditionalAndExpression )* ;

expressions.ConditionalAndExpression
    ::= inclusiveOrExpression ( "&&" inclusiveOrExpression )* ;
   
expressions.InclusiveOrExpression
    ::= exclusiveOrExpression ( "|" exclusiveOrExpression )* ;

expressions.ExclusiveOrExpression
    ::=   andExpression ( "^" andExpression )* ;

expressions.AndExpression
    ::=   equalityExpression ( "&" equalityExpression )* ;
  
expressions.EqualityExpression
    ::= instanceOfExpression ( (equal | notEqual) instanceOfExpression )* ;
    
expressions.InstanceOfExpression
    ::= relationExpression ("instanceof" type arrayDimensions*)? ;
    
expressions.RelationExpression
	::= shiftExpression ( relationOperator shiftExpression)*;
	
expressions.ShiftExpression
	::= additiveExpression ( shiftOperator additiveExpression)*;

expressions.AdditiveExpression
    ::= multiplicativeExpression ( additiveOperator multiplicativeExpression )* ;
    
expressions.MultiplicativeExpression
    ::=	unaryExpression ( multiplicativeOperator unaryExpression )* ;
    
expressions.UnaryExpression
    ::= (additiveOperator | plusplus | minusminus)? unaryExpressionNotPlusMinus
    ;
    
expressions.UnaryExpressionNotPlusMinus
	::= (complement | negate) primary
	|   castExpression
	|   primary ( plusplus | minusminus)?
    ;
    
expressions.CastExpression
    ::= "(" typeReference arrayDimensions* ")" expression
    ;
    
references.Primary 
	::=	
	  reference
	| literal
	;    

operators.Assignment                   ::= "=";
operators.AssignmentPlus               ::= "+=";
operators.AssignmentMinus              ::= "-=";
operators.AssignmentMultiplication     ::= "*=";
operators.AssignmentDivision           ::= "/=";
operators.AssignmentAnd                ::= "&=";
operators.AssignmentOr                 ::= "|=";
operators.AssignmentExclusiveOr        ::= "^=";
operators.AssignmentModulo             ::= "%=";
operators.AssignmentLeftShift          ::= "<" #0 "<" #0 "=";
operators.AssignmentRightShift         ::= ">" #0 ">" #0 "=";
operators.AssignmentUnsignedRightShift ::= ">" #0 ">" #0 ">" #0 "=";

operators.AdditiveOperator		::= value[ADDITIVE_OPERATOR_LITERAL] ;
operators.MultiplicativeOperator	::= value[MULTIPLICATIVE_OPERATOR_LITERAL] ;

operators.LessThan 			::= "<";
operators.LessThanOrEqual		::= "<" #0 "=";
operators.GreaterThan			::= ">";
operators.GreaterThanOrEqual	::= ">" #0 "=";

operators.LeftShift 			::= "<" #0 "<" ;
operators.RightShift 			::= ">" #0 ">" ;
operators.UnsignedRightShift	::= ">" #0 ">" #0 ">" ;

operators.Equal		::= "==";	
operators.NotEqual	::= "!=";
operators.PlusPlus 	::= "++" ;
operators.MinusMinus 	::= "--" ;
operators.Complement 	::= "~" ;
operators.Negate 		::= "!" ;

arrays.ArrayDimension ::= ("[" #0 "]");

literals.NullLiteral ::= "null";
literals.VoidLiteral ::= "void";
literals.ClassLiteral ::= "class";
literals.This ::= "this";
literals.Super ::= "super";

modifiers.Public ::= "public";
modifiers.Abstract ::= "abstract";
modifiers.Protected ::= "protected";
modifiers.Private ::= "private";
modifiers.Final ::= "final";
modifiers.Static ::= "static";

modifiers.Native ::= "native";
modifiers.Synchronized ::= "synchronized";
modifiers.Transient ::= "transient";
modifiers.Volatile ::= "volatile";
modifiers.Strictfp ::= "strictfp";

types.Boolean ::= "boolean";
types.Char ::= "char";
types.Byte ::= "byte";
types.Short ::= "short";
types.Int ::= "int";
types.Long ::= "long";
types.Float ::= "float";
types.Double ::= "double";

literals.IntegerLiteral 
	::= value[DECIMAL_LITERAL] | value[HEX_LITERAL] | value[OCTAL_LITERAL];

literals.FloatingPointLiteral 
	::= value[FLOATING_POINT_LITERAL];

literals.CharacterLiteral 
	::= value[CHARACTER_LITERAL];

literals.StringLiteral 
	::= value[STRING_LITERAL];

literals.BooleanLiteral 
	::= value[BOOLEAN_LITERAL];
	
//comments.SingleLineComment
//	::= content[SL_COMMENT];
	
//comments.MultiLineComment
//	::= content[ML_COMMENT];
}
