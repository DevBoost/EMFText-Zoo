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

SYNTAXDEF rq
FOR <http://www.emftext.org/sparql>
START SparqlQueries

IMPORTS{
}

OPTIONS{	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	tokenspace="1";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens="false";
	generateCodeFromGeneratorModel="true";
	reloadGeneratorModel="false";
	resourcePluginID = "org.emftext.language.sparql.resource.sparql";
	basePackage = "org.emftext.language.sparql.resource.sparql";
	overridePluginXML = "true";
}

TOKENS{
	DEFINE DEF_IRI_REF $'<' (~( '^' | '<' | '>' | '"' | '{' | '}' | '`' | '\\' | '\u0000'..'\u0020' ))* '>'$;
	
	DEFINE DEF_LANGTAG  $ '@' ('A'..'Z' | 'a'..'z')+ ('-' ('A'..'Z' | 'a'..'z' | '0'..'9')+)* $;
	
	DEFINE DEF_INTEGER $('+'|'-')? ('0'..'9')+$;
	DEFINE DEF_DECIMAL $('+'|'-')? ((('0'..'9')+ '.' ('0'..'9')* )| ('.' ('0'..'9')+ ))$;
	DEFINE DEF_DOUBLE  $('+'|'-')? ((('0'..'9')+ '.' ('0'..'9')*)  | ('.' ('0'..'9')+) | (('0'..'9')+ )) ('e'|'E') ('+'|'-')? ('0'..'9')+ $;
	
		//folgende 3 Definition sind in VARNAME, PN_PREFIX und PN_LOCAL eingearbeitet
	// PN_CHARS_BASE $ ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '\u10000'..'\uEFFFF') $;
	// PN_CHARS_U  $ ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '\u10000'..'\uEFFFF' | '_' ) $;
	// PN_CHARS $ ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '\u10000'..'\uEFFFF' | '_' | '.' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040') $;
	
		
	DEFINE VARNAME 	$ ('?'|'\u0024') ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' )  ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' )* $; // | '\u10000'..'\uEFFFF' fehlt
	DEFINE DEF_PNAME_NS $ (('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD') (('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.')* ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '.' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040'))?)? ':' $;  // | '\u10000'..'\uEFFFF' fehlt
	DEFINE DEF_PN_LOCAL $ ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' ) (('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.' )* ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '.' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040'))? $ ;	// | '\u10000'..'\uEFFFF' fehlt
	
	DEFINE DEF_STRING_LITERAL_LONG1 $ '\'\'\'' ( ( '\'' | '\'\'' )? ( ~( '\'' | '\\' ) | ('\\'('t'|'b'|'n'|'r'|'f'|'\\'|'\"'|'\'')) ) )* '\'\'\'' $;
	DEFINE DEF_STRING_LITERAL_LONG2 $ '"""'    ( ( '"'  | '""'  )? ( ~( '"' | '\\' ) | ('\\'('t'|'b'|'n'|'r'|'f'|'\\'|'\"'|'\'')) ) )* '"""' $;
	DEFINE DEF_STRING_LITERAL1 $ '\'' ( ~( '\u0027' | '\u005C' | '\u000A' | '\u000D' ) | ('\\'('t'|'b'|'n'|'r'|'f'|'\\'|'\"'|'\'')) )* '\''$;
	DEFINE DEF_STRING_LITERAL2 $ '"'  ( ~( '\u0022' | '\u005C' | '\u000A' | '\u000D' ) | ('\\'('t'|'b'|'n'|'r'|'f'|'\\'|'\"'|'\'')) )* '"'$;
	
	
	DEFINE COMMENT $'#'(~('\n'|'\r'))*$;
	
	//DEFINE DEF_WS $( '\u0020' | '\u0009' | '\u000D' | '\u000A')$;  //=WITHSPACE, überflüssig?
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES{	
	SparqlQueries ::= prologue query+;
	
	Prologue ::= basedeclaration? prefixdeclaration* ; 
	BaseDecl ::= "BASE" iriref  ;
	PrefixDecl ::= "PREFIX" pnamens iriref  ;
	
	SelectQuery ::= "SELECT" solutionsdisplay? ( var+ | "*" ) datasetclause* whereclause solutionmodifier;
	ConstructQuery ::= "CONSTRUCT" constructtemplate datasetclause* whereclause solutionmodifier ;
	DescribeQuery ::= "DESCRIBE" ( varoririref+ | "*" ) datasetclause* whereclause? solutionmodifier ;
	AskQuery ::= "ASK" datasetclause* whereclause ;
	
	DistinctNE ::= "DISTINCT";
	ReducedNE ::= "REDUCED" ;
	DatasetClause ::= "FROM" graphclause ;
	DefaultGraphClause ::= sourceselector ;
	NamedGraphClause ::= "NAMED" sourceselector ;
	
	WhereClause ::= where? groupgraphpattern;
	
	SolutionModifier ::= orderclause? limitoffsetclauses? ;
	
	OrderClause ::= "ORDER" "BY" ordercondition+ ;
	OrderConditionLeftNE ::= ascOrDecs brackettedexpression ;
	
	LimitOffsetClausesLeftNE ::= limitclause offsetclause? ;
	LimitOffsetClausesRightNE ::= offsetclause limitclause? ; 
	LimitClause ::= "LIMIT" integer ;
	OffsetClause ::= "OFFSET" integer ;
	
	GroupGraphPattern ::= "{" triplesblock? additionalGGPelements* "}" ;
	AdditionalGGPElement ::= patternOrFilterNE (".")? triplesblock? ;
	TriplesBlock ::= triplessamesubject ( "." triplessamesubject? )* ;
	
	OptionalGraphPattern ::= "OPTIONAL" groupgraphpattern ;
	GraphGraphPattern ::= "GRAPH" varoririref groupgraphpattern;
	GroupOrUnionGraphPattern ::= groupgraphpattern ( "UNION" groupgraphpattern )* ;
	
	Filter ::= "FILTER" constraint ;
	FunctionCall ::=  iriref arglist ;
	ArgListNILNE ::= nil ;
	ArgListExpressionNE ::= "(" expression ( "," addexpression )* ")" ;
	
	ConstructTemplate ::= "{" (constructtriples ( "." constructtriples? )* )? "}" ;
	
	TriplesSameSubjectLeftNE ::= varorterm propertylistnotempty ;
	TriplesSameSubjectRightNE ::= triplesnode propertylistnotempty?;
	
	PropertyListNotEmpty ::= verb objectlist ( ";" ( verb objectlist )? )* ;
	ObjectList ::= object ( "," object )* ;
	Object ::= graphnode ; //abstract möglich?
	
	BlankNodePropertyList ::= "[" propertylistnotempty "]" ;
	Collection ::= "(" graphnode+ ")" ;
	
	Expression ::= conditionalorexpression ;
	AdditionalExpressionNE ::= conditionalorexpression ;
	
	ConditionalOrExpression ::=	conditionalandexpression addconditionalandexpression* ;
	AdditionalConditionalAndExpressionNE ::= "||" conditionalandexpression ;
	
	ConditionalAndExpression ::= valuelogical addvaluelogical* ;
	ValueLogical ::= relationalexpression ;
	AdditionalValueLogicalNE ::= "&&" relationalexpression ;
	
	RelationalExpression ::= numericexpression addnumericexpression?;
	EqualsNumericExpressionNE ::=  "=" additiveexpression ;
	NotEqualNumericExpressionNE ::=  "!=" additiveexpression ;
	SmallerNumericExpressionNE ::=  "<" additiveexpression ;
	BiggerNumericExpressionNE ::=  ">" additiveexpression ;
	SmallerOrEqualNumericExpressionNE ::=  "<=" additiveexpression ;
	BiggerOrEqualNumericExpressionNE ::=  ">=" additiveexpression ;	
	NumericExpression ::= additiveexpression ;
	
	AdditiveExpression ::=  multiplicativeexpression addmultiplicativeexpression *;
	PlusMultiplicativeExpressionNE ::= "+" multiplicativeexpression ;
	MinusMultiplicativeExpressionNE ::= "-" multiplicativeexpression ;
	
	MultiplicativeExpression ::= unaryexpression addunaryexpression * ;
	TimesAdditionalUnaryExpressionNE ::= "*" unaryexpression ;
	DividedByAdditionalUnaryExpressionNE ::= "/" unaryexpression ;
	
	NotPrimaryExpressionNE ::= "!" primaryexpression;
	PlusPrimaryExpressionNE ::= "+" primaryexpression;
	MinusPrimaryExpressionNE ::= "-" primaryexpression;
	
	BrackettedExpression ::= "("  expression  ")" ; 
	
	StrBuiltInCallNE 			::= ("str" | "STR") "(" expression ")" ;
	LangBuiltInCallNE 			::= ("lang" | "LANG") "(" expression ")" ;
	LangmatchesBuiltInCallNE 	::= ("langMatches" | "LANGMATCHES") "(" expression "," addexpression ")" ;
	DatatypeBuiltInCallNE 		::= ("datatype" | "DATATYPE") "(" expression ")" ;
	BoundBuiltInCallNE 			::= ("bound" | "BOUND") "(" var ")" ;
	SameTermBuiltInCallNE 		::= "sameTerm" "(" expression "," addexpression ")" ;
	IsIRIBuiltInCallNE 			::= "isIRI" "(" expression ")" ;
	IsURIBuiltInCallNE 			::= "isURI" "(" expression ")" ;
	IsBlankBuiltInCallNE 		::= ("isBlank" | "isBLANK") "(" expression ")" ;
	IsLiteralBuiltInCallNE 		::= ("isLiteral" | "isLITERAL") "(" expression ")" ;
	
	RegexExpression ::=    	("regex"|"REGEX") "(" expression "," addexpression ( "," addexpression )? ")" ;
	
	IRIrefOrFunction ::= iriref arglist? ;
	RDFLiteral ::= string langtagoririrefNE? ;
	UpIRIrefNE ::= "^^" iriref ;
	
	TrueBooleanLiteralNE ::= "true";
	FalseBooleanLiteralNE ::= "false";
	
	IRI_REF ::= iri_ref[DEF_IRI_REF] ;
	//WS ::= ws[DEF_WS] ; //ws=WHITESPACE/darum entfernt
	PNAME_LN ::= pname_ns pn_local ;
	PNAME_NS ::= pn_prefix[DEF_PNAME_NS] ;	
	
	Var ::= varname[VARNAME] ;
	PN_LOCAL ::= pn_local[DEF_PN_LOCAL];
	BLANK_NODE_LABEL ::= "_:" pn_local[DEF_PN_LOCAL];
	LANGTAG ::= langtag[DEF_LANGTAG];
	
	INTEGER ::= integer[DEF_INTEGER];
	DECIMAL ::= decimal[DEF_DECIMAL];
	DOUBLE	::= double[DEF_DOUBLE];
	
	STRING_LITERAL_LONG1 ::= string[DEF_STRING_LITERAL_LONG1];
	STRING_LITERAL_LONG2 ::= string[DEF_STRING_LITERAL_LONG2];
	STRING_LITERAL1 ::= string[DEF_STRING_LITERAL1];
	STRING_LITERAL2 ::= string[DEF_STRING_LITERAL2];
	
	NotInList ::= "("  ")"; //ws=WHITESPACE, darum entfernt
	ANON  	  ::= "["  "]"; //ws=WHITESPACE, darum entfernt
	
	WhereLiteral ::= "WHERE";
	AscendingLiteral ::= "ASC";
	DescendingLiteral ::= "DESC";
	VerbANE ::= "a" ;
}