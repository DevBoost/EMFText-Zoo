SYNTAXDEF java
FOR <http://www.reuseware.org/java>
START CompilationUnit

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
}

TOKENS {
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;

	DEFINE FLOATING_POINT_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))? |   ('.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+) (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('f'|'F'|'d'|'D')))$;
	DEFINE HEX_LITERAL $'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+('l'|'L')?$;
	DEFINE DECIMAL_LITERAL $('0'|'1'..'9''0'..'9'*)('l'|'L')?$;
	DEFINE OCTAL_LITERAL $'0'('0'..'7')+('l'|'L')?$;

	DEFINE BOOLEAN_LITERAL $'true'|'false'$;
	DEFINE CHARACTER_LITERAL $'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	
	PREDEFINED TEXT;
}

RULES {

CompilationUnit 
   ::=	annotations*
        ("package" package[] ("." package[])* ";" !1)?
        ("import" ("static")? imports ";")*
        classifierDeclarations+
	;
	
Import
	::= package[] ("." package[])*  "." classifiers[];
	
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
	::= "new" type 
		("<" typeArguments[] ("," typeArguments[])* ">")?
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
}
