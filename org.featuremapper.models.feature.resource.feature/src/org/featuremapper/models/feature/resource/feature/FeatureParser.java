// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g 2008-11-18 19:13:52

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
import org.featuremapper.models.feature.Annotation;
//Implementation: org.featuremapper.models.feature.impl.AnnotationImpl
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUOTED_34_34", "TEXT", "INTEGER", "COMMENT", "FLOAT", "LB", "WS", "'FeatureModel'", "'{'", "'constraints'", "';'", "'}'", "'Constraint'", "'('", "','", "')'", "':'", "'Feature'", "'..'", "'/*'", "'*/'", "'['", "']'", "'Group'", "'type'", "'='"
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
            ruleMemo = new HashMap[20+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g"; }


    	private TokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:53:1: start returns [ EObject element = null] : c0= featuremodel ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        FeatureModel c0 = null;


        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:55:1: (c0= featuremodel )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:56:1: c0= featuremodel
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:60:1: featuremodel returns [FeatureModel element = null] : 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature ;
    public final FeatureModel featuremodel() throws RecognitionException {
        FeatureModel element =  null;

        Token a0=null;
        Constraint a1 = null;

        Feature a2 = null;



        	element = FeatureFactory.eINSTANCE.createFeatureModel();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:64:1: ( 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:65:2: 'FeatureModel' a0= QUOTED_34_34 ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )? a2= feature
            {
            match(input,11,FOLLOW_11_in_featuremodel81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_featuremodel88); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:67:2: ( ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:68:3: ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:68:3: ( '{' 'constraints' ( (a1= constraint ';' ) )? '}' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:69:4: '{' 'constraints' ( (a1= constraint ';' ) )? '}'
                    {
                    match(input,12,FOLLOW_12_in_featuremodel101); if (failed) return element;
                    match(input,13,FOLLOW_13_in_featuremodel106); if (failed) return element;
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:71:4: ( (a1= constraint ';' ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==16) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:72:5: (a1= constraint ';' )
                            {
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:72:5: (a1= constraint ';' )
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:73:6: a1= constraint ';'
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:83:1: constraint returns [Constraint element = null] : 'Constraint' '(' ( (a0= TEXT ( ( ',' a1= TEXT ) )* ) )? ')' a2= TEXT ':' a3= QUOTED_34_34 ;
    public final Constraint constraint() throws RecognitionException {
        Constraint element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;


        	element = FeatureFactory.eINSTANCE.createConstraint();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:87:1: ( 'Constraint' '(' ( (a0= TEXT ( ( ',' a1= TEXT ) )* ) )? ')' a2= TEXT ':' a3= QUOTED_34_34 )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:88:2: 'Constraint' '(' ( (a0= TEXT ( ( ',' a1= TEXT ) )* ) )? ')' a2= TEXT ':' a3= QUOTED_34_34
            {
            match(input,16,FOLLOW_16_in_constraint187); if (failed) return element;
            match(input,17,FOLLOW_17_in_constraint190); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:90:2: ( (a0= TEXT ( ( ',' a1= TEXT ) )* ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==TEXT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:91:3: (a0= TEXT ( ( ',' a1= TEXT ) )* )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:91:3: (a0= TEXT ( ( ',' a1= TEXT ) )* )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:92:4: a0= TEXT ( ( ',' a1= TEXT ) )*
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_constraint206); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:93:4: ( ( ',' a1= TEXT ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==18) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:94:5: ( ',' a1= TEXT )
                    	    {
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:94:5: ( ',' a1= TEXT )
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:95:6: ',' a1= TEXT
                    	    {
                    	    match(input,18,FOLLOW_18_in_constraint225); if (failed) return element;
                    	    a1=(Token)input.LT(1);
                    	    match(input,TEXT,FOLLOW_TEXT_in_constraint236); if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_constraint260); if (failed) return element;
            a2=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_constraint267); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("language"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("language"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            }
            match(input,20,FOLLOW_20_in_constraint271); if (failed) return element;
            a3=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_constraint278); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("expression"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expression"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:107:1: feature returns [Feature element = null] : 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '/*' (a3= attribute )* '*/' ) )? ( ( '[' (a4= attribute )* ']' ) )? ( ( (a5= group )* ) )? ;
    public final Feature feature() throws RecognitionException {
        Feature element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Attribute a3 = null;

        Attribute a4 = null;

        Group a5 = null;



        	element = FeatureFactory.eINSTANCE.createFeature();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:111:1: ( 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '/*' (a3= attribute )* '*/' ) )? ( ( '[' (a4= attribute )* ']' ) )? ( ( (a5= group )* ) )? )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:112:2: 'Feature' a0= QUOTED_34_34 ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )? ( ( '/*' (a3= attribute )* '*/' ) )? ( ( '[' (a4= attribute )* ']' ) )? ( ( (a5= group )* ) )?
            {
            match(input,21,FOLLOW_21_in_feature297); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_feature304); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:114:2: ( ( '(' a1= INTEGER '..' a2= INTEGER ')' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:115:3: ( '(' a1= INTEGER '..' a2= INTEGER ')' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:115:3: ( '(' a1= INTEGER '..' a2= INTEGER ')' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:116:4: '(' a1= INTEGER '..' a2= INTEGER ')'
                    {
                    match(input,17,FOLLOW_17_in_feature317); if (failed) return element;
                    a1=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_feature326); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
                    }
                    match(input,22,FOLLOW_22_in_feature332); if (failed) return element;
                    a2=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_feature341); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    match(input,19,FOLLOW_19_in_feature347); if (failed) return element;

                    }


                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:123:2: ( ( '/*' (a3= attribute )* '*/' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:124:3: ( '/*' (a3= attribute )* '*/' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:124:3: ( '/*' (a3= attribute )* '*/' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:125:4: '/*' (a3= attribute )* '*/'
                    {
                    match(input,23,FOLLOW_23_in_feature367); if (failed) return element;
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:126:4: (a3= attribute )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==TEXT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:127:5: a3= attribute
                    	    {
                    	    pushFollow(FOLLOW_attribute_in_feature382);
                    	    a3=attribute();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a3); copyLocalizationInfos(a3, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_feature394); if (failed) return element;

                    }


                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:132:2: ( ( '[' (a4= attribute )* ']' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:133:3: ( '[' (a4= attribute )* ']' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:133:3: ( '[' (a4= attribute )* ']' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:134:4: '[' (a4= attribute )* ']'
                    {
                    match(input,25,FOLLOW_25_in_feature414); if (failed) return element;
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:135:4: (a4= attribute )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==TEXT) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:136:5: a4= attribute
                    	    {
                    	    pushFollow(FOLLOW_attribute_in_feature429);
                    	    a4=attribute();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a4); copyLocalizationInfos(a4, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match(input,26,FOLLOW_26_in_feature441); if (failed) return element;

                    }


                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:141:2: ( ( (a5= group )* ) )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case 27:
                    {
                    alt11=1;
                    }
                    break;
                case EOF:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (synpred11()) ) {
                        alt11=1;
                    }
                    }
                    break;
                case 15:
                    {
                    int LA11_3 = input.LA(2);

                    if ( (synpred11()) ) {
                        alt11=1;
                    }
                    }
                    break;
                case 21:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (synpred11()) ) {
                        alt11=1;
                    }
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( (a5= group )* )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( (a5= group )* )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:143:4: (a5= group )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:143:4: (a5= group )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==27) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:144:5: a5= group
                    	    {
                    	    pushFollow(FOLLOW_group_in_feature471);
                    	    a5=group();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("groups"))).add(a5); copyLocalizationInfos(a5, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:150:1: group returns [Group element = null] : 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )? ;
    public final Group group() throws RecognitionException {
        Group element =  null;

        Token a0=null;
        Token a1=null;
        Feature a2 = null;



        	element = FeatureFactory.eINSTANCE.createGroup();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:154:1: ( 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )? )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:155:2: 'Group' ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )? ( ( '{' (a2= feature )* '}' ) )?
            {
            match(input,27,FOLLOW_27_in_group504); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:156:2: ( ( '(' a0= INTEGER '..' a1= INTEGER ')' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:157:3: ( '(' a0= INTEGER '..' a1= INTEGER ')' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:157:3: ( '(' a0= INTEGER '..' a1= INTEGER ')' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:158:4: '(' a0= INTEGER '..' a1= INTEGER ')'
                    {
                    match(input,17,FOLLOW_17_in_group516); if (failed) return element;
                    a0=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_group525); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
                    }
                    match(input,22,FOLLOW_22_in_group531); if (failed) return element;
                    a1=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_group540); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
                    }
                    match(input,19,FOLLOW_19_in_group546); if (failed) return element;

                    }


                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:165:2: ( ( '{' (a2= feature )* '}' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==12) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:166:3: ( '{' (a2= feature )* '}' )
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:166:3: ( '{' (a2= feature )* '}' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:167:4: '{' (a2= feature )* '}'
                    {
                    match(input,12,FOLLOW_12_in_group566); if (failed) return element;
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:168:4: (a2= feature )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:169:5: a2= feature
                    	    {
                    	    pushFollow(FOLLOW_feature_in_group581);
                    	    a2=feature();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("childFeatures"))).add(a2); copyLocalizationInfos(a2, element); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_group593); if (failed) return element;

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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:176:1: attribute returns [Attribute element = null] : a0= TEXT a1= TEXT 'type' '=' a2= QUOTED_34_34 ;
    public final Attribute attribute() throws RecognitionException {
        Attribute element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = FeatureFactory.eINSTANCE.createAttribute();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:180:1: (a0= TEXT a1= TEXT 'type' '=' a2= QUOTED_34_34 )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:181:2: a0= TEXT a1= TEXT 'type' '=' a2= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_attribute623); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("type"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_attribute631); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            match(input,28,FOLLOW_28_in_attribute635); if (failed) return element;
            match(input,29,FOLLOW_29_in_attribute638); if (failed) return element;
            a2=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute645); if (failed) return element;
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

    // $ANTLR start synpred11
    public final void synpred11_fragment() throws RecognitionException {   
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( ( ( group )* ) )
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( ( group )* )
        {
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:3: ( ( group )* )
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:143:4: ( group )*
        {
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:143:4: ( group )*
        loop19:
        do {
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }


            switch (alt19) {
        	case 1 :
        	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:144:5: group
        	    {
        	    pushFollow(FOLLOW_group_in_synpred11471);
        	    group();
        	    _fsp--;
        	    if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop19;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred11

    public final boolean synpred11() {
        backtracking++;
        int start = input.mark();
        try {
            synpred11_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_QUOTED_34_34_in_featuremodel88 = new BitSet(new long[]{0x0000000000201000L});
    public static final BitSet FOLLOW_12_in_featuremodel101 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_featuremodel106 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_constraint_in_featuremodel128 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel136 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_featuremodel153 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_feature_in_featuremodel168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_constraint187 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_constraint190 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_TEXT_in_constraint206 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_constraint225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_constraint236 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_constraint260 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_constraint267 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_constraint271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_constraint278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_feature297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_feature304 = new BitSet(new long[]{0x000000000A820002L});
    public static final BitSet FOLLOW_17_in_feature317 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature326 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_feature332 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature341 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_feature347 = new BitSet(new long[]{0x000000000A800002L});
    public static final BitSet FOLLOW_23_in_feature367 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_attribute_in_feature382 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_24_in_feature394 = new BitSet(new long[]{0x000000000A000002L});
    public static final BitSet FOLLOW_25_in_feature414 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_attribute_in_feature429 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_feature441 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_group_in_feature471 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_group504 = new BitSet(new long[]{0x0000000000021002L});
    public static final BitSet FOLLOW_17_in_group516 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group525 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_group531 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group540 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_group546 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_group566 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_feature_in_group581 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_15_in_group593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_attribute623 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_attribute631 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_attribute635 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_attribute638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_synpred11471 = new BitSet(new long[]{0x0000000008000002L});

}