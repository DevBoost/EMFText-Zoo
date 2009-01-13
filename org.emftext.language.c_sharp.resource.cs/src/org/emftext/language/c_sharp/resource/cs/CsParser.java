// $ANTLR 3.1.1 E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g 2009-01-13 17:50:05

package org.emftext.language.c_sharp.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.impl.EMFTextParserImpl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CsParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "LB", "WS", "'void'", "'('", "')'", "'{'", "'}'", "'int'", "';'", "'struct'", "'return'"
    };
    public static final int WS=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int LB=5;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private int lastPosition;

    	protected EObject doParse() throws RecognitionException {
    	lastPosition = 0;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}

    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element, Object o) {
    		int currentPos = getTokenStream().index();
    		int endPos = currentPos - 1;
    		for (; endPos >= lastPosition; endPos--) {
    			org.antlr.runtime.Token token = getTokenStream().get(endPos);
    			int _channel = token.getChannel();
    			if (_channel != 99) {
    				break;
    			}
    		}
    		for (int pos = lastPosition; pos < endPos; pos++) {
    			org.antlr.runtime.Token token = getTokenStream().get(pos);
    			int _channel = token.getChannel();
    			if (_channel == 99) {
    			}
    		}
    		lastPosition = endPos;
    	}



    // $ANTLR start "start"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:61:1: start returns [ EObject element = null] : c0= compilationunit EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        org.emftext.language.c_sharp.CompilationUnit c0 = null;


        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:63:1: (c0= compilationunit EOF )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:64:1: c0= compilationunit EOF
            {
            pushFollow(FOLLOW_compilationunit_in_start65);
            c0=compilationunit();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }
            match(input,EOF,FOLLOW_EOF_in_start69); if (state.failed) return element;

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
    // $ANTLR end "start"


    // $ANTLR start "compilationunit"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:69:1: compilationunit returns [org.emftext.language.c_sharp.CompilationUnit element = null] : (a0= definition )* ;
    public final org.emftext.language.c_sharp.CompilationUnit compilationunit() throws RecognitionException {
        org.emftext.language.c_sharp.CompilationUnit element =  null;

        org.emftext.language.c_sharp.Definition a0 = null;




        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:72:1: ( (a0= definition )* )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:73:2: (a0= definition )*
            {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:73:2: (a0= definition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7||LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:74:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_compilationunit96);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createCompilationUnit(); ((List) element.eGet(element.eClass().getEStructuralFeature("definitions"))).add(a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
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
    // $ANTLR end "compilationunit"


    // $ANTLR start "method"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:78:1: method returns [org.emftext.language.c_sharp.Method element = null] : a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}' ;
    public final org.emftext.language.c_sharp.Method method() throws RecognitionException {
        org.emftext.language.c_sharp.Method element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        org.emftext.language.c_sharp.Statement a5 = null;




        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:81:1: (a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}' )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:82:2: a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}'
            {
            a0=(Token)match(input,7,FOLLOW_7_in_method123); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_method131); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,8,FOLLOW_8_in_method139); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,9,FOLLOW_9_in_method147); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            a4=(Token)match(input,10,FOLLOW_10_in_method155); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:87:2: (a5= statement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:88:3: a5= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_method167);
            	    a5=statement();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod(); ((List) element.eGet(element.eClass().getEStructuralFeature("statements"))).add(a5); collectHiddenTokens(element, a5);copyLocalizationInfos(a5, element); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            a6=(Token)match(input,11,FOLLOW_11_in_method179); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createMethod();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
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
    // $ANTLR end "method"


    // $ANTLR start "variable"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:93:1: variable returns [org.emftext.language.c_sharp.Variable element = null] : a0= 'int' a1= TEXT a2= ';' ;
    public final org.emftext.language.c_sharp.Variable variable() throws RecognitionException {
        org.emftext.language.c_sharp.Variable element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:96:1: (a0= 'int' a1= TEXT a2= ';' )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:97:2: a0= 'int' a1= TEXT a2= ';'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_variable202); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_variable210); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,13,FOLLOW_13_in_variable218); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createVariable();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
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
    // $ANTLR end "variable"


    // $ANTLR start "struct"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:102:1: struct returns [org.emftext.language.c_sharp.Struct element = null] : a0= 'struct' a1= TEXT a2= '{' a3= '}' ;
    public final org.emftext.language.c_sharp.Struct struct() throws RecognitionException {
        org.emftext.language.c_sharp.Struct element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:105:1: (a0= 'struct' a1= TEXT a2= '{' a3= '}' )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:106:2: a0= 'struct' a1= TEXT a2= '{' a3= '}'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_struct241); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_struct249); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,10,FOLLOW_10_in_struct257); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,11,FOLLOW_11_in_struct265); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStruct();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
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
    // $ANTLR end "struct"


    // $ANTLR start "statement"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:112:1: statement returns [org.emftext.language.c_sharp.Statement element = null] : a0= 'return' a1= ';' ;
    public final org.emftext.language.c_sharp.Statement statement() throws RecognitionException {
        org.emftext.language.c_sharp.Statement element =  null;

        Token a0=null;
        Token a1=null;



        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:115:1: (a0= 'return' a1= ';' )
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:116:2: a0= 'return' a1= ';'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_statement288); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStatement();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,13,FOLLOW_13_in_statement296); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.language.c_sharp.impl.C_sharpFactoryImpl.eINSTANCE.createStatement();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
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
    // $ANTLR end "statement"


    // $ANTLR start "definition"
    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:120:1: definition returns [org.emftext.language.c_sharp.Definition element = null] : (c0= method | c1= variable | c2= struct );
    public final org.emftext.language.c_sharp.Definition definition() throws RecognitionException {
        org.emftext.language.c_sharp.Definition element =  null;

        org.emftext.language.c_sharp.Method c0 = null;

        org.emftext.language.c_sharp.Variable c1 = null;

        org.emftext.language.c_sharp.Struct c2 = null;


        try {
            // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:122:1: (c0= method | c1= variable | c2= struct )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 7:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:123:2: c0= method
                    {
                    pushFollow(FOLLOW_method_in_definition315);
                    c0=method();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:124:2: c1= variable
                    {
                    pushFollow(FOLLOW_variable_in_definition325);
                    c1=variable();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // E:\\Programme\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.c_sharp.resource.cs\\src\\org\\emftext\\language\\c_sharp\\resource\\cs\\Cs.g:125:2: c2= struct
                    {
                    pushFollow(FOLLOW_struct_in_definition335);
                    c2=struct();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
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
    // $ANTLR end "definition"

    // Delegated rules


 

    public static final BitSet FOLLOW_compilationunit_in_start65 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_compilationunit96 = new BitSet(new long[]{0x0000000000005082L});
    public static final BitSet FOLLOW_7_in_method123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_method131 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_method139 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_method147 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_method155 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_statement_in_method167 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_11_in_method179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_variable202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_variable210 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_variable218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_struct241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_struct249 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_struct257 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_struct265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_statement288 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statement296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_definition315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_definition325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_in_definition335 = new BitSet(new long[]{0x0000000000000002L});

}