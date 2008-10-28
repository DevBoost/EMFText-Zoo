SYNTAXDEF java
FOR <http://www.reuseware.org/J2SE5>
START Model

RULES {

CompilationUnit 
   ::=	annotations? 
        packageDeclaration?
        importDeclaration*
        typeDeclaration*
	;

PackageDeclaration
	::=	'package' qualifiedName ';'
	;
	
ImportDeclaration
	::=	'import' 'static'? Identifier ('.' Identifier)* ('.' '*')? ';'
	;
	
TypeDeclaration
	::=	classOrInterfaceDeclaration
    |   ';'
	;
	
ClassOrInterfaceDeclaration
	::=	modifier* (classDeclaration | interfaceDeclaration)
	;
	
ClassDeclaration
	::=	normalClassDeclaration
    |   enumDeclaration
	;
	
NormalClassDeclaration
	::=	'class' Identifier (typeParameters)?
        ('extends' type)?
        ('implements' typeList)?
        classBody
	;
	
TypeParameters
	::=	'<' typeParameter (',' typeParameter)* '>'
	;

TypeParameter
	::=	Identifier ('extends' bound)?
	;
		
Bound
	::=	type ('&' type)*
	;

EnumDeclaration
	::=	ENUM Identifier ('implements' typeList)? enumBody
	;
	
EnumBody
	::=	'{' enumConstants? ','? enumBodyDeclarations? '}'
	;

EnumConstants
	::=	enumConstant (',' enumConstant)*
	;
	
enumConstant
	::=	annotations? Identifier (arguments)? (classBody)?
	;
	
enumBodyDeclarations
	::=	';' (classBodyDeclaration)*
	;
	
interfaceDeclaration
	::=	normalInterfaceDeclaration
		| annotationTypeDeclaration
	;
	
normalInterfaceDeclaration
	::=	'interface' Identifier typeParameters? ('extends' typeList)? interfaceBody
	;
	
typeList
	::=	type (',' type)*
	;
	
classBody
	::=	'{' classBodyDeclaration* '}'
	;
	
interfaceBody
	::=	'{' interfaceBodyDeclaration* '}'
	;

classBodyDeclaration
	::=	';'
	|	'static'? block
	|	modifier* memberDecl
	;
	
memberDecl
	::=	genericMethodOrConstructorDecl
	|	methodDeclaration
	|	fieldDeclaration
	|	'void' Identifier voidMethodDeclaratorRest
	|	Identifier constructorDeclaratorRest
	|	interfaceDeclaration
	|	classDeclaration
	;
	
genericMethodOrConstructorDecl
	::=	typeParameters genericMethodOrConstructorRest
	;
	
genericMethodOrConstructorRest
	::=	(type | 'void') Identifier methodDeclaratorRest
	|	Identifier constructorDeclaratorRest
	;

methodDeclaration
	::=	type Identifier methodDeclaratorRest
	;

fieldDeclaration
	::=	type variableDeclarators ';'
	;
		
interfaceBodyDeclaration
	::=	modifier* interfaceMemberDecl
	|   ';'
	;

interfaceMemberDecl
	::=	interfaceMethodOrFieldDecl
	|   interfaceGenericMethodDecl
    |   'void' Identifier voidInterfaceMethodDeclaratorRest
    |   interfaceDeclaration
    |   classDeclaration
	;
	
interfaceMethodOrFieldDecl
	::=	type Identifier interfaceMethodOrFieldRest
	;
	
interfaceMethodOrFieldRest
	::=	constantDeclaratorsRest ';'
	|	interfaceMethodDeclaratorRest
	;
	
methodDeclaratorRest
	::=	formalParameters ('[' ']')*
        ('throws' qualifiedNameList)?
        (   methodBody
        |   ';'
        )
	;
	
voidMethodDeclaratorRest
	::=	formalParameters ('throws' qualifiedNameList)?
        (   methodBody
        |   ';'
        )
	;
	
interfaceMethodDeclaratorRest
	::=	formalParameters ('[' ']')* ('throws' qualifiedNameList)? ';'
	;
	
interfaceGenericMethodDecl
	::=	typeParameters (type | 'void') Identifier
        interfaceMethodDeclaratorRest
	;
	
voidInterfaceMethodDeclaratorRest
	::=	formalParameters ('throws' qualifiedNameList)? ';'
	;
	
constructorDeclaratorRest
	::=	formalParameters ('throws' qualifiedNameList)? methodBody
	;

constantDeclarator
	::=	Identifier constantDeclaratorRest
	;
	
variableDeclarators
	::=	variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	::=	Identifier variableDeclaratorRest?
	;
	
variableDeclaratorRest
	::=	('[' ']')+ ('=' variableInitializer)?
	|	'=' variableInitializer
	;
	
constantDeclaratorsRest
    ::=   constantDeclaratorRest (',' constantDeclarator)*
    ;

constantDeclaratorRest
	::=	('[' ']')* '=' variableInitializer
	;
	
variableDeclaratorId
	::=	Identifier ('[' ']')*
	;

variableInitializer
	::=	arrayInitializer
    |   expression
	;
	
arrayInitializer
	::=	'{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
	;

modifier
    ::=   annotation
    |   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    ;

packageOrTypeName
	::=	Identifier ('.' Identifier)*
	;

enumConstantName
    ::=   Identifier
    ;

typeName
	::=   Identifier
    |   packageOrTypeName '.' Identifier
	;

type
	::=	Identifier (typeArguments)? ('.' Identifier (typeArguments)? )* ('[' ']')*
	|	primitiveType ('[' ']')*
	;

primitiveType
    ::=   'boolean'
    |	'char'
    |	'byte'
    |	'short'
    |	'int'
    |	'long'
    |	'float'
    |	'double'
    ;

variableModifier
	::=	'final'
    |   annotation
	;

typeArguments
	::=	'<' typeArgument (',' typeArgument)* '>'
	;
	
typeArgument
	::=	type
	|	'?' (('extends' | 'super') type)?
	;
	
qualifiedNameList
	::=	qualifiedName (',' qualifiedName)*
	;
	
formalParameters
	::=	'(' formalParameterDecls? ')'
	;
	
formalParameterDecls
	::=	variableModifier* type formalParameterDeclsRest?
	;
	
formalParameterDeclsRest
	::=	variableDeclaratorId (',' formalParameterDecls)?
	|   '...' variableDeclaratorId
	;
	
methodBody
	::=	block
	;

qualifiedName
	::=	Identifier ('.' Identifier)*
	;
	
literal	
	::=   integerLiteral
    |   FloatingPointLiteral
    |   CharacterLiteral
    |   StringLiteral
    |   booleanLiteral
    |   'null'
	;

integerLiteral
    ::=   HexLiteral
    |   OctalLiteral
    |   DecimalLiteral
    ;

booleanLiteral
    ::=   'true'
    |   'false'
    ;


annotations
	::=	annotation+
	;

annotation
	::=	'@' annotationName ('(' elementValuePairs? ')')?
	;
	
annotationName
	::= Identifier ('.' Identifier)*
	;
	
elementValuePairs
	::= elementValuePair (',' elementValuePair)*
	;
	
elementValuePair
	::= (Identifier '=')? elementValue
	;
	
elementValue
	::=	conditionalExpression
	|   annotation
	|   elementValueArrayInitializer
	;
	
elementValueArrayInitializer
	::=	'{' (elementValue (',' elementValue )*)? '}'
	;
	
annotationTypeDeclaration
	::=	'@' 'interface' Identifier annotationTypeBody
	;
	
annotationTypeBody
	::=	'{' (annotationTypeElementDeclarations)? '}'
	;
	
annotationTypeElementDeclarations
	::=	(annotationTypeElementDeclaration) (annotationTypeElementDeclaration)*
	;
	
annotationTypeElementDeclaration
	::=	(modifier)* annotationTypeElementRest
	;
	
annotationTypeElementRest
	::=	type annotationMethodOrConstantRest ';'
	|   classDeclaration ';'?
	|   interfaceDeclaration ';'?
	|   enumDeclaration ';'?
	|   annotationTypeDeclaration ';'?
	;
	
annotationMethodOrConstantRest
	::=	annotationMethodRest
	|   annotationConstantRest
	;
	
annotationMethodRest
 	::=	Identifier '(' ')' (defaultValue)?
 	;
 	
annotationConstantRest
 	::=	variableDeclarators
 	;
 	
defaultValue
 	::=	'default' elementValue
 	;

block
	::=	'{' blockStatement* '}'
	;
	
blockStatement
	::=	localVariableDeclaration
	|	classOrInterfaceDeclaration
    	|	statement
	;
	
localVariableDeclaration
	::=	variableModifier* type variableDeclarators ';'
	;
	
statement
	::= block
    | 'assert' expression ('::=' expression)? ';'
    | 'if' parExpression statement ('else' statement)?
    | 'for' '(' forControl ')' statement
    | 'while' parExpression statement
    | 'do' statement 'while' parExpression ';'
    | 'try' block
      (	catches 'finally' block
      | catches
      | 'finally' block
      )
    | 'switch' parExpression '{' switchBlockStatementGroups '}'
    | 'synchronized' parExpression block
    | 'return' expression? ';'
    | 'throw' expression ';'
    | 'break' Identifier? ';'
    | 'continue' Identifier? ';'
    | ';'
    | statementExpression ';'
    | Identifier '::=' statement
	;
	
catches
	::=	catchClause (catchClause)*
	;
	
catchClause
	::=	'catch' '(' formalParameter ')' block
	;

formalParameter
	::=	variableModifier* type variableDeclaratorId
	;
		
switchBlockStatementGroups
	::=	(switchBlockStatementGroup)*
	;
	
switchBlockStatementGroup
	::=	switchLabel blockStatement*
	;
	
switchLabel
	::=	'case' constantExpression '::='
	|   'case' enumConstantName '::='
	|   'default' '::='
	;
	
moreStatementExpressions
	::=	(',' statementExpression)*
	;

forControl
	::=	forVarControl
	|	forInit? ';' expression? ';' forUpdate?
	;

forInit
	::=	variableModifier* type variableDeclarators
	|	expressionList
	;
	
forVarControl
	::=	variableModifier* type Identifier '::=' expression
	;

forUpdate
	::=	expressionList
	;

parExpression
	::=	'(' expression ')'
	;
	
expressionList
    ::=   expression (',' expression)*
    ;

statementExpression
	::=	expression
	;
	
constantExpression
	::=	expression
	;
	
expression
	::=	conditionalExpression (assignmentOperator expression)?
	;
	
assignmentOperator
	::=	'='
    |   '+='
    |   '-='
    |   '*='
    |   '/='
    |   '&='
    |   '|='
    |   '^='
    |   '%='
    |   '<' '<' '='
    |   '>' '>' '='
    |   '>' '>' '>' '='
	;

conditionalExpression
    ::=   conditionalOrExpression ( '?' expression '::=' expression )?
	;

conditionalOrExpression
    ::=   conditionalAndExpression ( '||' conditionalAndExpression )*
	;

conditionalAndExpression
    ::=   inclusiveOrExpression ( '&&' inclusiveOrExpression )*
	;

inclusiveOrExpression
    ::=   exclusiveOrExpression ( '|' exclusiveOrExpression )*
	;

exclusiveOrExpression
    ::=   andExpression ( '^' andExpression )*
	;

andExpression
    ::=   equalityExpression ( '&' equalityExpression )*
	;

equalityExpression
    ::=   instanceOfExpression ( ('==' | '!=') instanceOfExpression )*
	;

instanceOfExpression
    ::=   relationalExpression ('instanceof' type)?
	;

relationalExpression
    ::=   shiftExpression ( relationalOp shiftExpression )*
	;
	
relationalOp
	::=	('<' '=' | '>' '=' | '<' | '>')
	;

shiftExpression
    ::=   additiveExpression ( shiftOp additiveExpression )*
	;

shiftOp
	::=	('<' '<' | '>' '>' '>' | '>' '>')
	;


additiveExpression
    ::=   multiplicativeExpression ( ('+' | '-') multiplicativeExpression )*
	;

multiplicativeExpression
    ::=   unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
	;
	
unaryExpression
    ::=   '+' unaryExpression
    |	'-' unaryExpression
    |   '++' unaryExpression
    |   '--' unaryExpression
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus
    ::=   '~' unaryExpression
    | 	'!' unaryExpression
    |   castExpression
    |   primary selector* ('++'|'--')?
    ;

castExpression
    ::=  '(' primitiveType ')' unaryExpression
    |  '(' (type | expression) ')' unaryExpressionNotPlusMinus
    ;

primary
    ::=	parExpression
    |   nonWildcardTypeArguments
        (explicitGenericInvocationSuffix | 'this' arguments)
    |   'this' ('.' Identifier)* (identifierSuffix)?
    |   'super' superSuffix
    |   literal
    |   'new' creator
    |   Identifier ('.' Identifier)* (identifierSuffix)?
    |   primitiveType ('[' ']')* '.' 'class'
    |   'void' '.' 'class'
	;

identifierSuffix
	::=	('[' ']')+ '.' 'class'
	|	('[' expression ']')+
    |   arguments
    |   '.' 'class'
    |   '.' explicitGenericInvocation
    |   '.' 'this'
    |   '.' 'super' arguments
    |   '.' 'new' (nonWildcardTypeArguments)? innerCreator
	;
	
creator
	::=	nonWildcardTypeArguments? createdName
        (arrayCreatorRest | classCreatorRest)
	;

createdName
	::=	Identifier typeArguments?
        ('.' Identifier typeArguments?)*
    |	primitiveType
	;
	
innerCreator
	::=	Identifier classCreatorRest
	;

arrayCreatorRest
	::=	'['
        (   ']' ('[' ']')* arrayInitializer
        |   expression ']' ('[' expression ']')* ('[' ']')*
        )
	;

classCreatorRest
	::=	arguments classBody?
	;
	
explicitGenericInvocation
	::=	nonWildcardTypeArguments explicitGenericInvocationSuffix
	;
	
nonWildcardTypeArguments
	::=	'<' typeList '>'
	;
	
explicitGenericInvocationSuffix
	::=	'super' superSuffix
	|   Identifier arguments
	;
	
selector
	::=	'.' Identifier (arguments)?
	|   '.' 'this'
	|   '.' 'super' superSuffix
	|   '.' 'new' (nonWildcardTypeArguments)? innerCreator
	|   '[' expression ']'
	;
	
superSuffix
	::=	arguments
	|   '.' Identifier (arguments)?
    ;

arguments
	::=	'(' expressionList? ')'
	;
 
}