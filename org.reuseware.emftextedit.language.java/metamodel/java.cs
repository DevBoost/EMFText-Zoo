SYNTAXDEF java
FOR <http://www.reuseware.org/java>
START CompilationUnit

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE ML_COMMENT $'/*'.*'*/'$;

	DEFINE FLOATING_POINT_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))? |   ('.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+) (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('f'|'F'|'d'|'D')))$;
	DEFINE HEX_LITERAL $'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+('l'|'L')?$;
	DEFINE DECIMAL_LITERAL $('0'|'1'..'9''0'..'9'*)('l'|'L')?$;
	DEFINE OCTAL_LITERAL $'0'('0'..'7')+('l'|'L')?$;

	DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	DEFINE CHARACTER_LITERAL $'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	
	//DEFINE IDENTIFIER $('\u0024'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u00ff'|'\u0100'..'\u1fff'|'\u3040'..'\u318f'|'\u3300'..'\u337f'|'\u3400'..'\u3d2d'|'\u4e00'..'\u9fff'|'\uf900'..'\ufaff')(('\u0024'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u00ff'|'\u0100'..'\u1fff'|'\u3040'..'\u318f'|'\u3300'..'\u337f'|'\u3400'..'\u3d2d'|'\u4e00'..'\u9fff'|'\uf900'..'\ufaff')|('\u0030'..'\u0039'|'\u0660'..'\u0669'|'\u06f0'..'\u06f9'|'\u0966'..'\u096f'|'\u09e6'..'\u09ef'|'\u0a66'..'\u0a6f'|'\u0ae6'..'\u0aef'|'\u0b66'..'\u0b6f'|'\u0be7'..'\u0bef'|'\u0c66'..'\u0c6f'|'\u0ce6'..'\u0cef'|'\u0d66'..'\u0d6f'|'\u0e50'..'\u0e59'|'\u0ed0'..'\u0ed9'|'\u1040'..'\u1049'))+$;
}

RULES {

CompilationUnit 
   ::=	comments*
   		annotations*
   		comments*
        ("package" package[] ("." package[])* ";" )?
        comments*
        ("import" imports ";")*
        classifiers+
	;
	
Import
	::= static? package[] ("." package[])*  "." classifiers[];
	
Class
	::=	modifiers* "class" name[] ("<" typeParameters ("," typeParameters)* ">")?
        ("extends" extends)?
        ("implements" implements)?
        "{" !1 (members (";")?)* "}"
	;

Interface
	::=	modifiers* "interface" name[] ("<" typeParameters ("," typeParameters)* ">")?
	       ("extends" (extends ("," extends)*))? 
	       "{" ((members (";")?) | (";")?)* "}"
	;

Annotation
	::=	modifiers* "@" "interface" name[]
	       "{" ((members (";")?) | (";")?)* "}"
	;

AnnotationInstance
	::=	"@" annotation 
		("(" (elementValue | (elementValuePairs ("," elementValuePairs)*)) ")")? 
	;

AnnotationElementValuePair
	::= key[] "=" value
	;

AnnotationElementValueArray
    ::= "{" (values ("," values)*)? (",")? "}"
    ;

Enumeration
    ::= modifiers* "enum" name[] ("implements" (implements[] ("," implements[])*))? "{" (constants ("," constants)*)? (",")? ((";" members*)? | (";")?) "}"
    ;

TypeParameter
	::=	name[] ("extends" extendTypes ("&" extendTypes)*)?
	;

EnumConstant
    ::= name[] ("(" arguments ("," arguments)* ")" )? members* 
    ;

Block
	::=	modifiers* "{" statements* "}"
	;

Constructor
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? name[]
	"(" (parameters ("," parameters)* )? ")" 
	("throws" exceptions[] ("," exceptions[])?)? body
	;

Method
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? (type arrayDimensions*) name[]  
	"(" (parameters ("," parameters)* )? ")" arrayDimensions*
	("throws" exceptions[] ("," exceptions[])?)? (body | ";")
	;
	
AnnotationMethod
	::=	annotations* modifiers* ("<" typeParameters ("," typeParameters)* ">")? (type arrayDimensions*) name[]  
	"(" (parameters ("," parameters)* )? ")" arrayDimensions*
	("throws" exceptions[] ("," exceptions[])?)? "default" defaultValue (body | ";")
	;

OrdinaryParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions*
	;

VariableLengthParameter
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? "..." name[] 
	;

LocalVariable
	::= modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions* ("=" initialValue)? ("," additionalLocalVariables)*
	;

LocalVariableStatement
	::= variable ";" ;

AdditionalLocalVariable
	::= name[] arrayDimensions* ("=" initialValue)?
	;

Field
	::= annotations* modifiers* type arrayDimensions* ("<" typeArguments[] ("," typeArguments[])* ">")? name[] arrayDimensions* ("=" initialValue)? ("," additionalFields)*
	;

AdditionalField
	::= name[] arrayDimensions* ("=" initialValue)?
	;

// INSTANTIATIONS
NewConstructorCall 
	::= "new" 
		// these are the arguments for the constructor type parameters
		("<" typeArguments[] ("," typeArguments[])* ">")?
		type 
		// these are the arguments for the class type parameters
		("<" classTypeArguments[] ("," classTypeArguments[])* ">")?
		"(" (arguments ("," arguments)* )? ")"
		("{" (members (";")?)* "}")?
     ;
     
ExplicitConstructorCall 
	::= ("<" typeArguments[] ("," typeArguments[])* ">")?
		callTarget "(" (arguments ("," arguments)* )? ")"
     ;

ArrayInstantiationByValues
	::= "new" type arrayDimensions+
		"{" (initialValues ((",") initialValues)* (",")? )? "}"
	;

ArrayInstantiationBySize 
	::= "new" type 
		("[" sizes "]")+
		arrayDimensions*
	;

Reference
	::= primary ("[" arraySelectors? "]")* ("." next)? 
	;
	
TypeReferenceSequence
	::= parts ("." parts)*
	;

PackageOrClassifierReference
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
	;

PackageOrClassifierOrMethodOrVariableReference
	::= target[] 
		("<" typeArguments ("," typeArguments)* ">")?
		("(" (arguments ("," arguments)* )? ")")?
	;

ExplicitGenericInvocation
	::= ("<" typeArguments ("," typeArguments)* ">")?
		target[]
		("(" (arguments ("," arguments)* )? ")")?
	;

QualifiedTypeArgument
	::= type
	;

UnknownTypeArgument
	::= "?"
	;

ExtendsTypeArgument
	::= "?" "extends" extendTypes ("&" extendTypes)*
	;

SuperTypeArgument
	::= "?" "super" superType
	;

Assert
	::= "assert" expression1 (":" expression2)? ";" ;
	
Condition 
	::= "if" "(" expression ")" ifStatement ("else" elseStatement)? ;
	
ForLoop
	::= "for" "(" init? ";" condition? ";" (updates ("," updates)* )? ")" body;

ForEachLoop
	::= "for" "(" next ":" collection ")" body;
	
WhileLoop
	::= "while" "(" condition ")" body;
	
DoWhileLoop	
	::= "do" body "while" "(" condition ")" ";" ;
	
EmptyStatement	
	::= ";" ;
	
SynchronizedBlock
	::= "synchronized" "(" lockExpression ")" body;
	
TryBlock
	::= "try" tryBlock
		catches* 
		("finally" finallyBlock)?;

CatchClause
	::=	"catch" "(" parameter ")" catchBlock
	;

Switch
	::= "switch" "(" variable ")" "{" cases* default? "}" ;
	
NormalSwitchCase
	::= "case" condition ":" body* ;
	
DefaultSwitchCase
	::= "default" ":" body* ;
	
Return
	::= "return" expression? ";" ;
	
Throw
	::= "throw" expression ";" ;
	
Break
	::= "break" ";" ;
	
Continue
	::= "continue"  ";" ;
	
JumpLabel
	::= name[] ":" statement ;

Assignment
	::= target ("=" value)?
	;

// TODO was a subtype of Expression, but this generalization was
// temporarily removed, because variable declarations could not
// be distinguished from single expressions
ExpressionStatement 
	::= expression ";" 
	;

ExpressionList
	::= expressions ("," expressions)* 
	;

BooleanExpression
	::=	
	left[]
	( "="
    |   "+="
    |   "-="
    |   "*="
    |   "/="
    |   "&="
    |   "|="
    |   "^="
    |   "%="
    |   "<" "<" "="
    |   ">" ">" "="
    |   ">" ">" ">" "=" )
    right[]
	;

ArrayDimension ::= ("[" "]");

NullLiteral ::= "null";
VoidLiteral ::= "void";
ClassLiteral ::= "class";
This ::= "this";
Super ::= "super";

Public ::= "public";
Abstract ::= "abstract";
Protected ::= "protected";
Private ::= "private";
Final ::= "final";
Static ::= "static";

Native ::= "native";
Synchronized ::= "synchronized";
Transient ::= "transient";
Volatile ::= "volatile";
Strictfp ::= "strictfp";

Boolean ::= "boolean";
Char ::= "char";
Byte ::= "byte";
Short ::= "short";
Int ::= "int";
Long ::= "long";
Float ::= "float";
Double ::= "double";

IntegerLiteral 
	::= value[DECIMAL_LITERAL] | value[HEX_LITERAL] | value[OCTAL_LITERAL];

FloatingPointLiteral 
	::= value[FLOATING_POINT_LITERAL];

CharacterLiteral 
	::= value[CHARACTER_LITERAL];

StringLiteral 
	::= value[STRING_LITERAL];

BooleanLiteral 
	::= value[BOOLEAN_LITERAL];
	
SingleLineComment
	::= content[SL_COMMENT];
	
MultiLineComment
	::= content[ML_COMMENT];
}
