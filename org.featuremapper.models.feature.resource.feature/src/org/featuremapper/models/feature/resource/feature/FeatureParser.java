// $ANTLR 3.0.1 C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g 2008-11-25 16:53:51

package org.featuremapper.models.feature.resource.feature;

//+++++++++++++++++++++++imports for org.featuremapper.models.feature begin++++++++++++++++++++++
import org.featuremapper.models.feature.FeatureModel;
//Implementation: org.featuremapper.models.feature.impl.FeatureModelImpl
import org.featuremapper.models.feature.Feature;
//Implementation: org.featuremapper.models.feature.impl.FeatureImpl
import org.featuremapper.models.feature.Group;
//Implementation: org.featuremapper.models.feature.impl.GroupImpl
import org.featuremapper.models.feature.Constraint;
//Implementation: org.featuremapper.models.feature.impl.ConstraintImpl
import org.featuremapper.models.feature.Attribute;
//Implementation: org.featuremapper.models.feature.impl.AttributeImpl
import org.featuremapper.models.feature.*;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class FeatureParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUOTED_34_34", "TEXT", "INTEGER", "COMMENT", "FLOAT", "LB", "WS", "'FeatureModel'", "'{'", "'constraints'", "';'", "'}'", "'Constraint'", "':'", "'Feature'", "'('", "'..'", "')'", "'['", "']'", "'Group'", "'='"
    };
    public static final int INTEGER=6;
    public static final int WS=10;
    public static final int LB=9;
    public static final int FLOAT=8;
    public static final int TEXT=5;
    public static final int COMMENT=7;
    public static final int EOF=-1;
    public static final int QUOTED_34_34=4;

        public FeatureParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[16+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g"; }


    	private TokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:51:1: start returns [ EObject element = null] : c0= featuremodel ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        FeatureModel c0 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:53:1: (c0= featuremodel )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:54:1: c0= featuremodel
            {
            pushFollow(FOLLOW_featuremodel_in_start61);
            c0=featuremodel();
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


    // $ANTLR start featuremodel
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:58:1: featuremodel returns [FeatureModel element = null] : 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature ;
    public final FeatureModel featuremodel() throws RecognitionException {
        FeatureModel element =  null;

        Token a0=null;
        Constraint a1 = null;

        Feature a2 = null;



        	element = FeatureFactory.eINSTANCE.createFeatureModel();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:62:1: ( 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:63:2: 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature
            {
            match(input,11,FOLLOW_11_in_featuremodel81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_featuremodel88); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:65:2: ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:66:3: ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:66:3: ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:67:4: '{' 'constraints' ( (a1= constraint ';' ) )? '}'
                    {
                    match(input,12,FOLLOW_12_in_featuremodel101); if (failed) return element;
                    match(input,13,FOLLOW_13_in_featuremodel106); if (failed) return element;
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:69:4: ( (a1= constraint ';' ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==16) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:70:5: (a1= constraint ';' )
                            {
                            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:70:5: (a1= constraint ';' )
                            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:71:6: a1= constraint ';'
                            {
                            pushFollow(FOLLOW_constraint_in_featuremodel128);
                            a1=constraint();
                            _fsp--;
                            if (failed) return element;
                            if ( backtracking==0 ) {
                              ((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(a1); copyLocalizationInfos(a1, element); 
                            }
                            match(input,14,FOLLOW_14_in_featuremodel136); if (failed) return element;

                            }


                            }
                            break;

                    }

                    match(input,15,FOLLOW_15_in_featuremodel153); if (failed) return element;

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_feature_in_featuremodel168);
            a2=feature();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("root"), a2); copyLocalizationInfos(a2, element); 
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
    // $ANTLR end featuremodel


    // $ANTLR start constraint
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:81:1: constraint returns [Constraint element = null] : 'Constraint' a0= TEXT ':' a1= QUOTED_34_34 ;
    public final Constraint constraint() throws RecognitionException {
        Constraint element =  null;

        Token a0=null;
        Token a1=null;


        	element = FeatureFactory.eINSTANCE.createConstraint();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:85:1: ( 'Constraint' a0= TEXT ':' a1= QUOTED_34_34 )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:86:2: 'Constraint' a0= TEXT ':' a1= QUOTED_34_34
            {
            match(input,16,FOLLOW_16_in_constraint187); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_constraint194); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("language"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("language"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,17,FOLLOW_17_in_constraint198); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_constraint205); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("expression"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expression"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
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
    // $ANTLR end constraint


    // $ANTLR start feature
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:92:1: feature returns [Feature element = null] : 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '[' (a3= attribute )* ']' ) )? ( ( (a4= group )* ) )? ;
    public final Feature feature() throws RecognitionException {
        Feature element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Attribute a3 = null;

        Group a4 = null;



        	element = FeatureFactory.eINSTANCE.createFeature();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:96:1: ( 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '[' (a3= attribute )* ']' ) )? ( ( (a4= group )* ) )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:97:2: 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '[' (a3= attribute )* ']' ) )? ( ( (a4= group )* ) )?
            {
            match(input,18,FOLLOW_18_in_feature224); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_feature231); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:99:2: ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:100:3: ( '(' a1= INTEGER '..' a2= INTEGER ')' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:100:3: ( '(' a1= INTEGER '..' a2= INTEGER ')' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:101:4: '(' a1= INTEGER '..' a2= INTEGER ')'
                    {
                    match(input,19,FOLLOW_19_in_feature244); if (failed) return element;
                    a1=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_feature253); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
                    }
                    match(input,20,FOLLOW_20_in_feature259); if (failed) return element;
                    a2=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_feature268); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    match(input,21,FOLLOW_21_in_feature274); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:108:2: ( ( '[' (a3= attribute )* ']' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:109:3: ( '[' (a3= attribute )* ']' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:109:3: ( '[' (a3= attribute )* ']' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:110:4: '[' (a3= attribute )* ']'
                    {
                    match(input,22,FOLLOW_22_in_feature294); if (failed) return element;
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:111:4: (a3= attribute )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:112:5: a3= attribute
                    	    {
                    	    pushFollow(FOLLOW_attribute_in_feature309);
                    	    a3=attribute();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a3); copyLocalizationInfos(a3, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,23,FOLLOW_23_in_feature321); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:117:2: ( ( (a4= group )* ) )?
            int alt7=2;
            switch ( input.LA(1) ) {
                case 24:
                    {
                    alt7=1;
                    }
                    break;
                case EOF:
                    {
                    int LA7_2 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }
                    }
                    break;
                case 15:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }
                    }
                    break;
                case 18:
                    {
                    int LA7_4 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:118:3: ( (a4= group )* )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:118:3: ( (a4= group )* )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:119:4: (a4= group )*
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:119:4: (a4= group )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==24) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:120:5: a4= group
                    	    {
                    	    pushFollow(FOLLOW_group_in_feature351);
                    	    a4=group();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("groups"))).add(a4); copyLocalizationInfos(a4, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }


                    }
                    break;

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
    // $ANTLR end feature


    // $ANTLR start group
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:126:1: group returns [Group element = null] : 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )? ;
    public final Group group() throws RecognitionException {
        Group element =  null;

        Token a0=null;
        Token a1=null;
        Feature a2 = null;



        	element = FeatureFactory.eINSTANCE.createGroup();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:130:1: ( 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:131:2: 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )?
            {
            match(input,24,FOLLOW_24_in_group384); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:132:2: ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:133:3: ( '(' a0= INTEGER '..' a1= INTEGER ')' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:133:3: ( '(' a0= INTEGER '..' a1= INTEGER ')' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:134:4: '(' a0= INTEGER '..' a1= INTEGER ')'
                    {
                    match(input,19,FOLLOW_19_in_group396); if (failed) return element;
                    a0=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_group405); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
                    }
                    match(input,20,FOLLOW_20_in_group411); if (failed) return element;
                    a1=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_group420); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
                    }
                    match(input,21,FOLLOW_21_in_group426); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:141:2: ( ( '{' (a2= feature )* '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( '{' (a2= feature )* '}' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( '{' (a2= feature )* '}' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:143:4: '{' (a2= feature )* '}'
                    {
                    match(input,12,FOLLOW_12_in_group446); if (failed) return element;
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:144:4: (a2= feature )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:145:5: a2= feature
                    	    {
                    	    pushFollow(FOLLOW_feature_in_group461);
                    	    a2=feature();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("childFeatures"))).add(a2); copyLocalizationInfos(a2, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_group473); if (failed) return element;

                    }


                    }
                    break;

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
    // $ANTLR end group


    // $ANTLR start attribute
    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:152:1: attribute returns [Attribute element = null] : a0= TEXT a1= TEXT '=' a2= QUOTED_34_34 ;
    public final Attribute attribute() throws RecognitionException {
        Attribute element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = FeatureFactory.eINSTANCE.createAttribute();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:156:1: (a0= TEXT a1= TEXT '=' a2= QUOTED_34_34 )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:157:2: a0= TEXT a1= TEXT '=' a2= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_attribute503); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("type"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_attribute511); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            match(input,25,FOLLOW_25_in_attribute515); if (failed) return element;
            a2=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute522); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
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
    // $ANTLR end attribute

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:118:3: ( ( ( group )* ) )
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:118:3: ( ( group )* )
        {
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:118:3: ( ( group )* )
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:119:4: ( group )*
        {
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:119:4: ( group )*
        loop13:
        do {
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }


            switch (alt13) {
        	case 1 :
        	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:120:5: group
        	    {
        	    pushFollow(FOLLOW_group_in_synpred7351);
        	    group();
        	    _fsp--;
        	    if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop13;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred7

    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_featuremodel_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_featuremodel81 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_featuremodel88 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_12_in_featuremodel101 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_featuremodel106 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_constraint_in_featuremodel128 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel136 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_featuremodel153 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_feature_in_featuremodel168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_constraint187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_constraint194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_constraint198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_constraint205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_feature224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_feature231 = new BitSet(new long[]{0x0000000001480002L});
    public static final BitSet FOLLOW_19_in_feature244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature253 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_feature259 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature268 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_feature274 = new BitSet(new long[]{0x0000000001400002L});
    public static final BitSet FOLLOW_22_in_feature294 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_attribute_in_feature309 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_feature321 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_group_in_feature351 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_group384 = new BitSet(new long[]{0x0000000000081002L});
    public static final BitSet FOLLOW_19_in_group396 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group405 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_group411 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group420 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_group426 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_group446 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_feature_in_group461 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_group473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_attribute503 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_attribute511 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_attribute515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_synpred7351 = new BitSet(new long[]{0x0000000001000002L});

}