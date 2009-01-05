grammar Cs;
options {
	superClass = EMFTextParserImpl; 
	backtrack = true;
}
@lexer::header{
package org.emftext.language.c_sharp.resource.cs;

}

@lexer::members{
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header{
package org.emftext.language.c_sharp.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.impl.EMFTextParserImpl;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = compilationunit{ element = c0; }
	EOF

;

compilationunit returns [org.emftext.language.c_sharp.CompilationUnit element = null]
@init{
}
:
	(
		a0 = definition{if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createCompilationUnit(); ((List) element.eGet(element.eClass().getEStructuralFeature("definitions"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
;

method returns [org.emftext.language.c_sharp.Method element = null]
@init{
}
:
	a0 = 'void'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = '('{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); copyLocalizationInfos((CommonToken)a2, element); }
	a3 = ')'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); copyLocalizationInfos((CommonToken)a3, element); }
	a4 = '{'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); copyLocalizationInfos((CommonToken)a4, element); }
	(
		a5 = statement{if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); ((List) element.eGet(element.eClass().getEStructuralFeature("statements"))).add(a5); copyLocalizationInfos(a5, element); }
	)*
	a6 = '}'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); copyLocalizationInfos((CommonToken)a6, element); }
;

variable returns [org.emftext.language.c_sharp.Variable element = null]
@init{
}
:
	a0 = 'int'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable(); copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = ';'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable(); copyLocalizationInfos((CommonToken)a2, element); }
;

struct returns [org.emftext.language.c_sharp.Struct element = null]
@init{
}
:
	a0 = 'struct'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct(); copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = '{'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct(); copyLocalizationInfos((CommonToken)a2, element); }
	a3 = '}'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct(); copyLocalizationInfos((CommonToken)a3, element); }
;

statement returns [org.emftext.language.c_sharp.Statement element = null]
@init{
}
:
	a0 = 'return'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStatement(); copyLocalizationInfos((CommonToken)a0, element); }
	a1 = ';'{ if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStatement(); copyLocalizationInfos((CommonToken)a1, element); }
;

definition
returns [org.emftext.language.c_sharp.Definition element = null]
:
	c0 = method{ element = c0; }	|
	c1 = variable{ element = c1; }	|
	c2 = struct{ element = c2; }
;

LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
