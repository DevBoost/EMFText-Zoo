grammar Simpletemplate;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.emftext.language.simple_template.resource.simpletemplate;

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
package org.emftext.language.simple_template.resource.simpletemplate;

//+++++++++++++++++++++++imports for org.emftext.language.simple_template begin++++++++++++++++++++++
import org.emftext.language.simple_template.Template;
//Implementation: org.emftext.language.simple_template.impl.TemplateImpl
import org.emftext.language.simple_template.Section;
//Implementation: org.emftext.language.simple_template.impl.SectionImpl
import org.emftext.language.simple_template.CompoundSection;
//Implementation: org.emftext.language.simple_template.impl.CompoundSectionImpl
import org.emftext.language.simple_template.Static;
//Implementation: org.emftext.language.simple_template.impl.StaticImpl
import org.emftext.language.simple_template.Condition;
//Implementation: org.emftext.language.simple_template.impl.ConditionImpl
import org.emftext.language.simple_template.Loop;
//Implementation: org.emftext.language.simple_template.impl.LoopImpl
import org.emftext.language.simple_template.Placeholder;
//Implementation: org.emftext.language.simple_template.impl.PlaceholderImpl
import org.emftext.language.simple_template.*;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new SimpletemplateTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((SimpletemplateLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((SimpletemplateLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = template{ element = c0; }

;

template returns [Template element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createTemplate();
}
:
	a0 = compoundsection{element.eSet(element.eClass().getEStructuralFeature("content"), a0); copyLocalizationInfos(a0, element); }
;

condition returns [Condition element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createCondition();
}
:
	a0 = '<%'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = 'if'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = '('{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
	a4 = ')'{copyLocalizationInfos((CommonToken)a4, element); }
	a5 = '{'{copyLocalizationInfos((CommonToken)a5, element); }
	a6 = '%>'{copyLocalizationInfos((CommonToken)a6, element); }
	a7 = compoundsection{element.eSet(element.eClass().getEStructuralFeature("body"), a7); copyLocalizationInfos(a7, element); }
	a8 = '<%'{copyLocalizationInfos((CommonToken)a8, element); }
	a9 = '}'{copyLocalizationInfos((CommonToken)a9, element); }
	a10 = '%>'{copyLocalizationInfos((CommonToken)a10, element); }
;

loop returns [Loop element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createLoop();
}
:
	a0 = '<%'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = 'for'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = '('{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("count"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("count"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
	a4 = ')'{copyLocalizationInfos((CommonToken)a4, element); }
	a5 = '{'{copyLocalizationInfos((CommonToken)a5, element); }
	a6 = '%>'{copyLocalizationInfos((CommonToken)a6, element); }
	a7 = compoundsection{element.eSet(element.eClass().getEStructuralFeature("body"), a7); copyLocalizationInfos(a7, element); }
	a8 = '<%'{copyLocalizationInfos((CommonToken)a8, element); }
	a9 = '}'{copyLocalizationInfos((CommonToken)a9, element); }
	a10 = '%>'{copyLocalizationInfos((CommonToken)a10, element); }
;

placeholder returns [Placeholder element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createPlaceholder();
}
:
	a0 = '<%='{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("pathToInputModelElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("pathToInputModelElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
	a2 = '%>'{copyLocalizationInfos((CommonToken)a2, element); }
;

compoundsection returns [CompoundSection element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createCompoundSection();
}
:
	(
		a0 = section{((List) element.eGet(element.eClass().getEStructuralFeature("contents"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
;

keywordstatic returns [Static element = null]
@init{
	element = Simple_templateFactory.eINSTANCE.createStatic();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("text"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("text"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

section
returns [Section element = null]
:
	c0 = condition{ element = c0; }	|
	c1 = loop{ element = c1; }	|
	c2 = placeholder{ element = c2; }	|
	c3 = keywordstatic{ element = c3; }
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
