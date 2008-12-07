// $ANTLR 3.0.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g 2008-12-07 14:05:48

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "LB", "WS", "'void'", "'('", "')'", "'{'", "'}'", "'int'", "';'", "'struct'", "'return'"
    };
    public static final int LB=5;
    public static final int WS=6;
    public static final int TEXT=4;
    public static final int EOF=-1;

        public CParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[11+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g"; }


    	private TokenResolverFactory tokenResolverFactory = new CTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((CLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:55:1: start returns [ EObject element = null] : c0= compilationunit EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        CompilationUnit c0 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:57:1: (c0= compilationunit EOF )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:58:1: c0= compilationunit EOF
            {
            pushFollow(FOLLOW_compilationunit_in_start61);
            c0=compilationunit();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
               element = c0; 
            }
            match(input,EOF,FOLLOW_EOF_in_start65); if (failed) return element;

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


    // $ANTLR start compilationunit
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:63:1: compilationunit returns [CompilationUnit element = null] : (a0= definition )* ;
    public final CompilationUnit compilationunit() throws RecognitionException {
        CompilationUnit element =  null;

        Definition a0 = null;



        	element = CFactory.eINSTANCE.createCompilationUnit();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:67:1: ( (a0= definition )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:68:2: (a0= definition )*
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:68:2: (a0= definition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7||LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:69:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_compilationunit92);
            	    a0=definition();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("definitions"))).add(a0); copyLocalizationInfos(a0, element); 
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
    // $ANTLR end compilationunit


    // $ANTLR start method
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:73:1: method returns [Method element = null] : a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}' ;
    public final Method method() throws RecognitionException {
        Method element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Statement a5 = null;



        	element = CFactory.eINSTANCE.createMethod();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:77:1: (a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:78:2: a0= 'void' a1= TEXT a2= '(' a3= ')' a4= '{' (a5= statement )* a6= '}'
            {
            a0=(Token)input.LT(1);
            match(input,7,FOLLOW_7_in_method119); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_method127); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,8,FOLLOW_8_in_method135); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)input.LT(1);
            match(input,9,FOLLOW_9_in_method143); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a3, element); 
            }
            a4=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_method151); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:83:2: (a5= statement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:84:3: a5= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_method163);
            	    a5=statement();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("statements"))).add(a5); copyLocalizationInfos(a5, element); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            a6=(Token)input.LT(1);
            match(input,11,FOLLOW_11_in_method175); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a6, element); 
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
    // $ANTLR end method


    // $ANTLR start variable
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:89:1: variable returns [Variable element = null] : a0= 'int' a1= TEXT a2= ';' ;
    public final Variable variable() throws RecognitionException {
        Variable element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = CFactory.eINSTANCE.createVariable();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:93:1: (a0= 'int' a1= TEXT a2= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:94:2: a0= 'int' a1= TEXT a2= ';'
            {
            a0=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_variable198); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_variable206); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_variable214); if (failed) return element;
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
    // $ANTLR end variable


    // $ANTLR start struct
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:99:1: struct returns [Struct element = null] : a0= 'struct' a1= TEXT a2= '{' a3= '}' ;
    public final Struct struct() throws RecognitionException {
        Struct element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;


        	element = CFactory.eINSTANCE.createStruct();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:103:1: (a0= 'struct' a1= TEXT a2= '{' a3= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:104:2: a0= 'struct' a1= TEXT a2= '{' a3= '}'
            {
            a0=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_struct237); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_struct245); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_struct253); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)input.LT(1);
            match(input,11,FOLLOW_11_in_struct261); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a3, element); 
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
    // $ANTLR end struct


    // $ANTLR start statement
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:110:1: statement returns [Statement element = null] : a0= 'return' a1= ';' ;
    public final Statement statement() throws RecognitionException {
        Statement element =  null;

        Token a0=null;
        Token a1=null;


        	element = CFactory.eINSTANCE.createStatement();

        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:114:1: (a0= 'return' a1= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:115:2: a0= 'return' a1= ';'
            {
            a0=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_statement284); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_statement292); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
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
    // $ANTLR end statement


    // $ANTLR start definition
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:119:1: definition returns [Definition element = null] : (c0= method | c1= variable | c2= struct );
    public final Definition definition() throws RecognitionException {
        Definition element =  null;

        Method c0 = null;

        Variable c1 = null;

        Struct c2 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:121:1: (c0= method | c1= variable | c2= struct )
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
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("119:1: definition returns [Definition element = null] : (c0= method | c1= variable | c2= struct );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:122:2: c0= method
                    {
                    pushFollow(FOLLOW_method_in_definition311);
                    c0=method();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:123:2: c1= variable
                    {
                    pushFollow(FOLLOW_variable_in_definition321);
                    c1=variable();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_c.resource.c\\src\\org\\emftext\\language\\simple_c\\resource\\c\\C.g:124:2: c2= struct
                    {
                    pushFollow(FOLLOW_struct_in_definition331);
                    c2=struct();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
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
    // $ANTLR end definition


 

    public static final BitSet FOLLOW_compilationunit_in_start61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_compilationunit92 = new BitSet(new long[]{0x0000000000005082L});
    public static final BitSet FOLLOW_7_in_method119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_method127 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_method135 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_method143 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_method151 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_statement_in_method163 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_11_in_method175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_variable198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_variable206 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_variable214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_struct237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_struct245 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_struct253 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_struct261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_statement284 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statement292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_definition311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_definition321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_in_definition331 = new BitSet(new long[]{0x0000000000000002L});

}