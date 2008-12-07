// $ANTLR 3.0.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g 2008-12-07 18:51:54

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SimpletemplateParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "LB", "WS", "'<%'", "'if'", "'('", "')'", "'{'", "'%>'", "'}'", "'for'", "'<%='"
    };
    public static final int LB=5;
    public static final int WS=6;
    public static final int TEXT=4;
    public static final int EOF=-1;

        public SimpletemplateParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[12+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g"; }


    	private TokenResolverFactory tokenResolverFactory = new SimpletemplateTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((SimpletemplateLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((SimpletemplateLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:55:1: start returns [ EObject element = null] : c0= template ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        Template c0 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:57:1: (c0= template )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:58:1: c0= template
            {
            pushFollow(FOLLOW_template_in_start61);
            c0=template();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
               element = c0; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end start


    // $ANTLR start template
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:62:1: template returns [Template element = null] : a0= compoundsection ;
    public final Template template() throws RecognitionException {
        Template element =  null;

        CompoundSection a0 = null;



        	element = Simple_templateFactory.eINSTANCE.createTemplate();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:66:1: (a0= compoundsection )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:67:2: a0= compoundsection
            {
            pushFollow(FOLLOW_compoundsection_in_template85);
            a0=compoundsection();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("content"), a0); copyLocalizationInfos(a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end template


    // $ANTLR start condition
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:70:1: condition returns [Condition element = null] : a0= '<%' a1= 'if' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>' ;
    public final Condition condition() throws RecognitionException {
        Condition element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        CompoundSection a7 = null;



        	element = Simple_templateFactory.eINSTANCE.createCondition();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:74:1: (a0= '<%' a1= 'if' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:75:2: a0= '<%' a1= 'if' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>'
            {
            a0=(Token)input.LT(1);
            match(input,7,FOLLOW_7_in_condition108); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,8,FOLLOW_8_in_condition116); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,9,FOLLOW_9_in_condition124); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_condition132); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            }
            a4=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_condition140); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
            }
            a5=(Token)input.LT(1);
            match(input,11,FOLLOW_11_in_condition148); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a5, element); 
            }
            a6=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_condition156); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a6, element); 
            }
            pushFollow(FOLLOW_compoundsection_in_condition164);
            a7=compoundsection();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("body"), a7); copyLocalizationInfos(a7, element); 
            }
            a8=(Token)input.LT(1);
            match(input,7,FOLLOW_7_in_condition172); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a8, element); 
            }
            a9=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_condition180); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a9, element); 
            }
            a10=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_condition188); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a10, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end condition


    // $ANTLR start loop
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:88:1: loop returns [Loop element = null] : a0= '<%' a1= 'for' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>' ;
    public final Loop loop() throws RecognitionException {
        Loop element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        CompoundSection a7 = null;



        	element = Simple_templateFactory.eINSTANCE.createLoop();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:92:1: (a0= '<%' a1= 'for' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:93:2: a0= '<%' a1= 'for' a2= '(' a3= TEXT a4= ')' a5= '{' a6= '%>' a7= compoundsection a8= '<%' a9= '}' a10= '%>'
            {
            a0=(Token)input.LT(1);
            match(input,7,FOLLOW_7_in_loop211); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_loop219); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,9,FOLLOW_9_in_loop227); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_loop235); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("count"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("count"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            }
            a4=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_loop243); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
            }
            a5=(Token)input.LT(1);
            match(input,11,FOLLOW_11_in_loop251); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a5, element); 
            }
            a6=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_loop259); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a6, element); 
            }
            pushFollow(FOLLOW_compoundsection_in_loop267);
            a7=compoundsection();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("body"), a7); copyLocalizationInfos(a7, element); 
            }
            a8=(Token)input.LT(1);
            match(input,7,FOLLOW_7_in_loop275); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a8, element); 
            }
            a9=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_loop283); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a9, element); 
            }
            a10=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_loop291); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a10, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end loop


    // $ANTLR start placeholder
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:106:1: placeholder returns [Placeholder element = null] : a0= '<%=' a1= TEXT a2= '%>' ;
    public final Placeholder placeholder() throws RecognitionException {
        Placeholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = Simple_templateFactory.eINSTANCE.createPlaceholder();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:110:1: (a0= '<%=' a1= TEXT a2= '%>' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:111:2: a0= '<%=' a1= TEXT a2= '%>'
            {
            a0=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_placeholder314); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_placeholder322); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("pathToInputModelElement"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("pathToInputModelElement"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_placeholder330); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end placeholder


    // $ANTLR start compoundsection
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:116:1: compoundsection returns [CompoundSection element = null] : (a0= section )* ;
    public final CompoundSection compoundsection() throws RecognitionException {
        CompoundSection element =  null;

        Section a0 = null;



        	element = Simple_templateFactory.eINSTANCE.createCompoundSection();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:120:1: ( (a0= section )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:121:2: (a0= section )*
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:121:2: (a0= section )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==8||LA1_2==14) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0==TEXT||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:122:3: a0= section
            	    {
            	    pushFollow(FOLLOW_section_in_compoundsection357);
            	    a0=section();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("contents"))).add(a0); copyLocalizationInfos(a0, element); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end compoundsection


    // $ANTLR start keywordstatic
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:126:1: keywordstatic returns [Static element = null] : a0= TEXT ;
    public final Static keywordstatic() throws RecognitionException {
        Static element =  null;

        Token a0=null;


        	element = Simple_templateFactory.eINSTANCE.createStatic();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:130:1: (a0= TEXT )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:131:2: a0= TEXT
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_keywordstatic384); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("text"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("text"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end keywordstatic


    // $ANTLR start section
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:134:1: section returns [Section element = null] : (c0= condition | c1= loop | c2= placeholder | c3= keywordstatic );
    public final Section section() throws RecognitionException {
        Section element =  null;

        Condition c0 = null;

        Loop c1 = null;

        Placeholder c2 = null;

        Static c3 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:136:1: (c0= condition | c1= loop | c2= placeholder | c3= keywordstatic )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 7:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==8) ) {
                    alt2=1;
                }
                else if ( (LA2_1==14) ) {
                    alt2=2;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("134:1: section returns [Section element = null] : (c0= condition | c1= loop | c2= placeholder | c3= keywordstatic );", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            case TEXT:
                {
                alt2=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("134:1: section returns [Section element = null] : (c0= condition | c1= loop | c2= placeholder | c3= keywordstatic );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:137:2: c0= condition
                    {
                    pushFollow(FOLLOW_condition_in_section403);
                    c0=condition();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:138:2: c1= loop
                    {
                    pushFollow(FOLLOW_loop_in_section413);
                    c1=loop();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:139:2: c2= placeholder
                    {
                    pushFollow(FOLLOW_placeholder_in_section423);
                    c2=placeholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:140:2: c3= keywordstatic
                    {
                    pushFollow(FOLLOW_keywordstatic_in_section433);
                    c3=keywordstatic();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end section


 

    public static final BitSet FOLLOW_template_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundsection_in_template85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_condition108 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_condition116 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_condition124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_condition132 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_condition140 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_condition148 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_condition156 = new BitSet(new long[]{0x0000000000008090L});
    public static final BitSet FOLLOW_compoundsection_in_condition164 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_condition172 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_condition180 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_condition188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_loop211 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_loop219 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_loop227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_loop235 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_loop243 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_loop251 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_loop259 = new BitSet(new long[]{0x0000000000008090L});
    public static final BitSet FOLLOW_compoundsection_in_loop267 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_loop275 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_loop283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_loop291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_placeholder314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_placeholder322 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_placeholder330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_section_in_compoundsection357 = new BitSet(new long[]{0x0000000000008092L});
    public static final BitSet FOLLOW_TEXT_in_keywordstatic384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_section403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_in_section413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_placeholder_in_section423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keywordstatic_in_section433 = new BitSet(new long[]{0x0000000000000002L});

}