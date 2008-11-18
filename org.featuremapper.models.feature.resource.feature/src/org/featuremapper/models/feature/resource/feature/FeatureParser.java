// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g 2008-11-18 18:00:15

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
import org.featuremapper.models.feature.impl.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUOTED_34_34", "TEXT", "INTEGER", "COMMENT", "FLOAT", "LB", "WS", "'FeatureModel'", "'{'", "'constraints'", "':'", "'root'", "'name'", "'children'", "'parent'", "'}'", "'Feature'", "'minCardinality'", "'maxCardinality'", "'attributes'", "'groups'", "'parentGroup'", "'annotations'", "'Group'", "'parentFeature'", "'childFeatures'", "'Constraint'", "'language'", "'expression'", "'constrainedFeatures'", "'Attribute'", "'feature'", "'type'", "'value'", "'Annotation'"
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
            ruleMemo = new HashMap[32+1];
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:54:1: start returns [ EObject element = null] : c0= featuremodel ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        FeatureModel c0 = null;


        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:56:1: (c0= featuremodel )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:57:1: c0= featuremodel
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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:61:1: featuremodel returns [FeatureModel element = null] : 'FeatureModel' '{' ( ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT ) )* '}' ;
    public final FeatureModel featuremodel() throws RecognitionException {
        FeatureModel element =  null;

        Token a2=null;
        Token a4=null;
        Constraint a0 = null;

        Feature a1 = null;

        FeatureModel a3 = null;



        	element = FeatureFactory.eINSTANCE.createFeatureModel();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:65:1: ( 'FeatureModel' '{' ( ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:66:2: 'FeatureModel' '{' ( ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT ) )* '}'
            {
            match(input,11,FOLLOW_11_in_featuremodel81); if (failed) return element;
            match(input,12,FOLLOW_12_in_featuremodel84); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:68:2: ( ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||(LA2_0>=15 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:69:3: ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:69:3: ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT )
            	    int alt1=5;
            	    switch ( input.LA(1) ) {
            	    case 13:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 15:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt1=4;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt1=5;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("69:3: ( 'constraints' ':' a0= constraint | 'root' ':' a1= feature | 'name' ':' a2= QUOTED_34_34 | 'children' ':' a3= featuremodel | 'parent' ':' a4= TEXT )", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:70:4: 'constraints' ':' a0= constraint
            	            {
            	            match(input,13,FOLLOW_13_in_featuremodel96); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_featuremodel101); if (failed) return element;
            	            pushFollow(FOLLOW_constraint_in_featuremodel110);
            	            a0=constraint();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(a0); copyLocalizationInfos(a0, element); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:75:4: 'root' ':' a1= feature
            	            {
            	            match(input,15,FOLLOW_15_in_featuremodel122); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_featuremodel127); if (failed) return element;
            	            pushFollow(FOLLOW_feature_in_featuremodel136);
            	            a1=feature();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              element.eSet(element.eClass().getEStructuralFeature("root"), a1); copyLocalizationInfos(a1, element); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:80:4: 'name' ':' a2= QUOTED_34_34
            	            {
            	            match(input,16,FOLLOW_16_in_featuremodel148); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_featuremodel153); if (failed) return element;
            	            a2=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_featuremodel162); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:85:4: 'children' ':' a3= featuremodel
            	            {
            	            match(input,17,FOLLOW_17_in_featuremodel174); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_featuremodel179); if (failed) return element;
            	            pushFollow(FOLLOW_featuremodel_in_featuremodel188);
            	            a3=featuremodel();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("children"))).add(a3); copyLocalizationInfos(a3, element); 
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:90:4: 'parent' ':' a4= TEXT
            	            {
            	            match(input,18,FOLLOW_18_in_featuremodel200); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_featuremodel205); if (failed) return element;
            	            a4=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_featuremodel214); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("parent"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;FeatureModel proxy = FeatureFactory.eINSTANCE.createFeatureModel();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parent"), proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); 
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_featuremodel226); if (failed) return element;

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


    // $ANTLR start feature
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:98:1: feature returns [Feature element = null] : 'Feature' '{' ( ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT ) )* '}' ;
    public final Feature feature() throws RecognitionException {
        Feature element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        Token a7=null;
        Attribute a3 = null;

        Group a4 = null;

        Annotation a6 = null;



        	element = FeatureFactory.eINSTANCE.createFeature();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:102:1: ( 'Feature' '{' ( ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:103:2: 'Feature' '{' ( ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT ) )* '}'
            {
            match(input,20,FOLLOW_20_in_feature244); if (failed) return element;
            match(input,12,FOLLOW_12_in_feature247); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:105:2: ( ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13||LA4_0==16||(LA4_0>=21 && LA4_0<=26)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:106:3: ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:106:3: ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT )
            	    int alt3=8;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt3=1;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt3=2;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt3=3;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt3=4;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt3=5;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt3=6;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt3=7;
            	        }
            	        break;
            	    case 13:
            	        {
            	        alt3=8;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("106:3: ( 'name' ':' a0= QUOTED_34_34 | 'minCardinality' ':' a1= INTEGER | 'maxCardinality' ':' a2= INTEGER | 'attributes' ':' a3= attribute | 'groups' ':' a4= group | 'parentGroup' ':' a5= TEXT | 'annotations' ':' a6= annotation | 'constraints' ':' a7= TEXT )", 3, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:107:4: 'name' ':' a0= QUOTED_34_34
            	            {
            	            match(input,16,FOLLOW_16_in_feature259); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature264); if (failed) return element;
            	            a0=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_feature273); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:112:4: 'minCardinality' ':' a1= INTEGER
            	            {
            	            match(input,21,FOLLOW_21_in_feature285); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature290); if (failed) return element;
            	            a1=(Token)input.LT(1);
            	            match(input,INTEGER,FOLLOW_INTEGER_in_feature299); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:117:4: 'maxCardinality' ':' a2= INTEGER
            	            {
            	            match(input,22,FOLLOW_22_in_feature311); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature316); if (failed) return element;
            	            a2=(Token)input.LT(1);
            	            match(input,INTEGER,FOLLOW_INTEGER_in_feature325); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:122:4: 'attributes' ':' a3= attribute
            	            {
            	            match(input,23,FOLLOW_23_in_feature337); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature342); if (failed) return element;
            	            pushFollow(FOLLOW_attribute_in_feature351);
            	            a3=attribute();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("attributes"))).add(a3); copyLocalizationInfos(a3, element); 
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:127:4: 'groups' ':' a4= group
            	            {
            	            match(input,24,FOLLOW_24_in_feature363); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature368); if (failed) return element;
            	            pushFollow(FOLLOW_group_in_feature377);
            	            a4=group();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("groups"))).add(a4); copyLocalizationInfos(a4, element); 
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:132:4: 'parentGroup' ':' a5= TEXT
            	            {
            	            match(input,25,FOLLOW_25_in_feature389); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature394); if (failed) return element;
            	            a5=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_feature403); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("parentGroup"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Group proxy = FeatureFactory.eINSTANCE.createGroup();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parentGroup"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
            	            }

            	            }
            	            break;
            	        case 7 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:137:4: 'annotations' ':' a6= annotation
            	            {
            	            match(input,26,FOLLOW_26_in_feature415); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature420); if (failed) return element;
            	            pushFollow(FOLLOW_annotation_in_feature429);
            	            a6=annotation();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a6); copyLocalizationInfos(a6, element); 
            	            }

            	            }
            	            break;
            	        case 8 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:142:4: 'constraints' ':' a7= TEXT
            	            {
            	            match(input,13,FOLLOW_13_in_feature441); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_feature446); if (failed) return element;
            	            a7=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_feature455); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("constraints"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Constraint proxy = FeatureFactory.eINSTANCE.createConstraint();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constraints"))).add(proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); 
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_feature467); if (failed) return element;

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
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:150:1: group returns [Group element = null] : 'Group' '{' ( ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature ) )* '}' ;
    public final Group group() throws RecognitionException {
        Group element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Feature a3 = null;



        	element = FeatureFactory.eINSTANCE.createGroup();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:154:1: ( 'Group' '{' ( ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:155:2: 'Group' '{' ( ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature ) )* '}'
            {
            match(input,27,FOLLOW_27_in_group485); if (failed) return element;
            match(input,12,FOLLOW_12_in_group488); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:157:2: ( ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=21 && LA6_0<=22)||(LA6_0>=28 && LA6_0<=29)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:158:3: ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:158:3: ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature )
            	    int alt5=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("158:3: ( 'minCardinality' ':' a0= INTEGER | 'maxCardinality' ':' a1= INTEGER | 'parentFeature' ':' a2= TEXT | 'childFeatures' ':' a3= feature )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:159:4: 'minCardinality' ':' a0= INTEGER
            	            {
            	            match(input,21,FOLLOW_21_in_group500); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_group505); if (failed) return element;
            	            a0=(Token)input.LT(1);
            	            match(input,INTEGER,FOLLOW_INTEGER_in_group514); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("minCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("minCardinality"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:164:4: 'maxCardinality' ':' a1= INTEGER
            	            {
            	            match(input,22,FOLLOW_22_in_group526); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_group531); if (failed) return element;
            	            a1=(Token)input.LT(1);
            	            match(input,INTEGER,FOLLOW_INTEGER_in_group540); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("INTEGER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("maxCardinality"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("maxCardinality"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:169:4: 'parentFeature' ':' a2= TEXT
            	            {
            	            match(input,28,FOLLOW_28_in_group552); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_group557); if (failed) return element;
            	            a2=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_group566); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("parentFeature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("parentFeature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:174:4: 'childFeatures' ':' a3= feature
            	            {
            	            match(input,29,FOLLOW_29_in_group578); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_group583); if (failed) return element;
            	            pushFollow(FOLLOW_feature_in_group592);
            	            a3=feature();
            	            _fsp--;
            	            if (failed) return element;
            	            if ( backtracking==0 ) {
            	              ((List) element.eGet(element.eClass().getEStructuralFeature("childFeatures"))).add(a3); copyLocalizationInfos(a3, element); 
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_group604); if (failed) return element;

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


    // $ANTLR start constraint
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:182:1: constraint returns [Constraint element = null] : 'Constraint' '{' ( ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT ) )* '}' ;
    public final Constraint constraint() throws RecognitionException {
        Constraint element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = FeatureFactory.eINSTANCE.createConstraint();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:186:1: ( 'Constraint' '{' ( ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:187:2: 'Constraint' '{' ( ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT ) )* '}'
            {
            match(input,30,FOLLOW_30_in_constraint622); if (failed) return element;
            match(input,12,FOLLOW_12_in_constraint625); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:189:2: ( ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=31 && LA8_0<=33)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:190:3: ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:190:3: ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT )
            	    int alt7=3;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt7=3;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("190:3: ( 'language' ':' a0= QUOTED_34_34 | 'expression' ':' a1= QUOTED_34_34 | 'constrainedFeatures' ':' a2= TEXT )", 7, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:191:4: 'language' ':' a0= QUOTED_34_34
            	            {
            	            match(input,31,FOLLOW_31_in_constraint637); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_constraint642); if (failed) return element;
            	            a0=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_constraint651); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("language"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("language"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:196:4: 'expression' ':' a1= QUOTED_34_34
            	            {
            	            match(input,32,FOLLOW_32_in_constraint663); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_constraint668); if (failed) return element;
            	            a1=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_constraint677); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("expression"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("expression"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:201:4: 'constrainedFeatures' ':' a2= TEXT
            	            {
            	            match(input,33,FOLLOW_33_in_constraint689); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_constraint694); if (failed) return element;
            	            a2=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_constraint703); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("constrainedFeatures"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("constrainedFeatures"))).add(proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_constraint715); if (failed) return element;

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


    // $ANTLR start attribute
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:209:1: attribute returns [Attribute element = null] : 'Attribute' '{' ( ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 ) )* '}' ;
    public final Attribute attribute() throws RecognitionException {
        Attribute element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;


        	element = FeatureFactory.eINSTANCE.createAttribute();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:213:1: ( 'Attribute' '{' ( ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:2: 'Attribute' '{' ( ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 ) )* '}'
            {
            match(input,34,FOLLOW_34_in_attribute733); if (failed) return element;
            match(input,12,FOLLOW_12_in_attribute736); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:216:2: ( ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16||(LA10_0>=35 && LA10_0<=37)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:217:3: ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:217:3: ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 )
            	    int alt9=4;
            	    switch ( input.LA(1) ) {
            	    case 35:
            	        {
            	        alt9=1;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt9=2;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt9=3;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt9=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("217:3: ( 'feature' ':' a0= TEXT | 'name' ':' a1= QUOTED_34_34 | 'type' ':' a2= QUOTED_34_34 | 'value' ':' a3= QUOTED_34_34 )", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:218:4: 'feature' ':' a0= TEXT
            	            {
            	            match(input,35,FOLLOW_35_in_attribute748); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_attribute753); if (failed) return element;
            	            a0=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_attribute762); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:223:4: 'name' ':' a1= QUOTED_34_34
            	            {
            	            match(input,16,FOLLOW_16_in_attribute774); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_attribute779); if (failed) return element;
            	            a1=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute788); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:228:4: 'type' ':' a2= QUOTED_34_34
            	            {
            	            match(input,36,FOLLOW_36_in_attribute800); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_attribute805); if (failed) return element;
            	            a2=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute814); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("type"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:233:4: 'value' ':' a3= QUOTED_34_34
            	            {
            	            match(input,37,FOLLOW_37_in_attribute826); if (failed) return element;
            	            match(input,14,FOLLOW_14_in_attribute831); if (failed) return element;
            	            a3=(Token)input.LT(1);
            	            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute840); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_attribute852); if (failed) return element;

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


    // $ANTLR start annotation
    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:241:1: annotation returns [Annotation element = null] : 'Annotation' '{' ( ( 'feature' ':' a0= TEXT ) )* '}' ;
    public final Annotation annotation() throws RecognitionException {
        Annotation element =  null;

        Token a0=null;


        	element = FeatureFactory.eINSTANCE.createAnnotation();

        try {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:245:1: ( 'Annotation' '{' ( ( 'feature' ':' a0= TEXT ) )* '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:246:2: 'Annotation' '{' ( ( 'feature' ':' a0= TEXT ) )* '}'
            {
            match(input,38,FOLLOW_38_in_annotation870); if (failed) return element;
            match(input,12,FOLLOW_12_in_annotation873); if (failed) return element;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:248:2: ( ( 'feature' ':' a0= TEXT ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==35) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:249:3: ( 'feature' ':' a0= TEXT )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:249:3: ( 'feature' ':' a0= TEXT )
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:250:4: 'feature' ':' a0= TEXT
            	    {
            	    match(input,35,FOLLOW_35_in_annotation885); if (failed) return element;
            	    match(input,14,FOLLOW_14_in_annotation890); if (failed) return element;
            	    a0=(Token)input.LT(1);
            	    match(input,TEXT,FOLLOW_TEXT_in_annotation899); if (failed) return element;
            	    if ( backtracking==0 ) {
            	      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Feature proxy = FeatureFactory.eINSTANCE.createFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_annotation911); if (failed) return element;

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
    // $ANTLR end annotation


 

    public static final BitSet FOLLOW_featuremodel_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_featuremodel81 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_featuremodel84 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_13_in_featuremodel96 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel101 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_constraint_in_featuremodel110 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_15_in_featuremodel122 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel127 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_feature_in_featuremodel136 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_16_in_featuremodel148 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_featuremodel162 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_17_in_featuremodel174 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel179 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_featuremodel_in_featuremodel188 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_18_in_featuremodel200 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_featuremodel214 = new BitSet(new long[]{0x00000000000FA000L});
    public static final BitSet FOLLOW_19_in_featuremodel226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_feature244 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_feature247 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_16_in_feature259 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_feature273 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_21_in_feature285 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature290 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature299 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_22_in_feature311 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature316 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature325 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_23_in_feature337 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature342 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_attribute_in_feature351 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_24_in_feature363 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature368 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_group_in_feature377 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_25_in_feature389 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature394 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_feature403 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_26_in_feature415 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature420 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_annotation_in_feature429 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_13_in_feature441 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_feature446 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_feature455 = new BitSet(new long[]{0x0000000007E92000L});
    public static final BitSet FOLLOW_19_in_feature467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_group485 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_group488 = new BitSet(new long[]{0x0000000030680000L});
    public static final BitSet FOLLOW_21_in_group500 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_group505 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group514 = new BitSet(new long[]{0x0000000030680000L});
    public static final BitSet FOLLOW_22_in_group526 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_group531 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group540 = new BitSet(new long[]{0x0000000030680000L});
    public static final BitSet FOLLOW_28_in_group552 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_group557 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_group566 = new BitSet(new long[]{0x0000000030680000L});
    public static final BitSet FOLLOW_29_in_group578 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_group583 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_feature_in_group592 = new BitSet(new long[]{0x0000000030680000L});
    public static final BitSet FOLLOW_19_in_group604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_constraint622 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_constraint625 = new BitSet(new long[]{0x0000000380080000L});
    public static final BitSet FOLLOW_31_in_constraint637 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_constraint642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_constraint651 = new BitSet(new long[]{0x0000000380080000L});
    public static final BitSet FOLLOW_32_in_constraint663 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_constraint668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_constraint677 = new BitSet(new long[]{0x0000000380080000L});
    public static final BitSet FOLLOW_33_in_constraint689 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_constraint694 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_constraint703 = new BitSet(new long[]{0x0000000380080000L});
    public static final BitSet FOLLOW_19_in_constraint715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute733 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_attribute736 = new BitSet(new long[]{0x0000003800090000L});
    public static final BitSet FOLLOW_35_in_attribute748 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_attribute753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_attribute762 = new BitSet(new long[]{0x0000003800090000L});
    public static final BitSet FOLLOW_16_in_attribute774 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_attribute779 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute788 = new BitSet(new long[]{0x0000003800090000L});
    public static final BitSet FOLLOW_36_in_attribute800 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_attribute805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute814 = new BitSet(new long[]{0x0000003800090000L});
    public static final BitSet FOLLOW_37_in_attribute826 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_attribute831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute840 = new BitSet(new long[]{0x0000003800090000L});
    public static final BitSet FOLLOW_19_in_attribute852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_annotation870 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_annotation873 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_35_in_annotation885 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_annotation890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_annotation899 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_19_in_annotation911 = new BitSet(new long[]{0x0000000000000002L});

}