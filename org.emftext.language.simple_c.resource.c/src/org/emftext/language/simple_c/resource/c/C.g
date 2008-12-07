grammar C;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.emftext.language.simple_c.resource.c;

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
package org.emftext.language.simple_c.resource.c;

//+++++++++++++++++++++++imports for org.emftext.language.simple_c begin++++++++++++++++++++++
import org.emftext.language.simple_c.NamedElement;
//Implementation: org.emftext.language.simple_c.impl.NamedElementImpl
import org.emftext.language.simple_c.CompilationUnit;
//Implementation: org.emftext.language.simple_c.impl.CompilationUnitImpl
import org.emftext.language.simple_c.Method;
//Implementation: org.emftext.language.simple_c.impl.MethodImpl
import org.emftext.language.simple_c.Struct;
//Implementation: org.emftext.language.simple_c.impl.StructImpl
import org.emftext.language.simple_c.Variable;
//Implementation: org.emftext.language.simple_c.impl.VariableImpl
import org.emftext.language.simple_c.Statement;
//Implementation: org.emftext.language.simple_c.impl.StatementImpl
import org.emftext.language.simple_c.Definition;
//Implementation: org.emftext.language.simple_c.impl.DefinitionImpl
import org.emftext.language.simple_c.*;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new CTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((CLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = compilationunit{ element = c0; }
	EOF

;

compilationunit returns [CompilationUnit element = null]
@init{
	element = CFactory.eINSTANCE.createCompilationUnit();
}
:
	(
		a0 = definition{((List) element.eGet(element.eClass().getEStructuralFeature("definitions"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
;

method returns [Method element = null]
@init{
	element = CFactory.eINSTANCE.createMethod();
}
:
	a0 = 'void'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = '('{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = '{'{copyLocalizationInfos((CommonToken)a4, element); }
	(
		a5 = statement{((List) element.eGet(element.eClass().getEStructuralFeature("statements"))).add(a5); copyLocalizationInfos(a5, element); }
	)*
	a6 = '}'{copyLocalizationInfos((CommonToken)a6, element); }
;

variable returns [Variable element = null]
@init{
	element = CFactory.eINSTANCE.createVariable();
}
:
	a0 = 'int'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = ';'{copyLocalizationInfos((CommonToken)a2, element); }
;

struct returns [Struct element = null]
@init{
	element = CFactory.eINSTANCE.createStruct();
}
:
	a0 = 'struct'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = '{'{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = '}'{copyLocalizationInfos((CommonToken)a3, element); }
;

statement returns [Statement element = null]
@init{
	element = CFactory.eINSTANCE.createStatement();
}
:
	a0 = 'return'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = ';'{copyLocalizationInfos((CommonToken)a1, element); }
;

definition
returns [Definition element = null]
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
