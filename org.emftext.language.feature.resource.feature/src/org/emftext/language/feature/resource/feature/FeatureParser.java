// $ANTLR 3.1.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g 2009-04-11 19:18:23

	package org.emftext.language.feature.resource.feature;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.InternalEObject;
	import org.eclipse.emf.common.util.URI;
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
	import org.emftext.runtime.IOptions;
	import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
	import org.eclipse.emf.ecore.EClass;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class FeatureParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUOTED_34_34", "TEXT", "INTEGER", "COMMENT", "FLOAT", "WHITESPACE", "LINEBREAK", "'FeatureModel'", "'{'", "'constraints'", "';'", "'}'", "'Constraint'", "':'", "'Feature'", "'('", "'..'", "')'", "'['", "']'", "'Group'", "'='"
    };
    public static final int T__12=12;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int FLOAT=8;
    public static final int T__21=21;
    public static final int COMMENT=7;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int WHITESPACE=9;
    public static final int INTEGER=6;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int TEXT=5;
    public static final int T__24=24;
    public static final int LINEBREAK=10;
    public static final int T__25=25;
    public static final int T__18=18;
    public static final int T__15=15;
    public static final int QUOTED_34_34=4;

    // delegates
    // delegators


        public FeatureParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FeatureParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[16+1];
             
             
        }
        

    public String[] getTokenNames() { return FeatureParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
    	
    	// This default constructor is only used to call createInstance() on it
    	public FeatureParser() {
    		super();
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		lastPosition = 0;
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((FeatureLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = null;
    		Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);
    		}
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass)typeObject;
    			if (type.getInstanceClass() == org.featuremapper.models.feature.FeatureModel.class) {
    				return featuremodel();
    			}
    			if (type.getInstanceClass() == org.featuremapper.models.feature.Constraint.class) {
    				return constraint();
    			}
    			if (type.getInstanceClass() == org.featuremapper.models.feature.Feature.class) {
    				return feature();
    			}
    			if (type.getInstanceClass() == org.featuremapper.models.feature.Group.class) {
    				return group();
    			}
    			if (type.getInstanceClass() == org.featuremapper.models.feature.Attribute.class) {
    				return attribute();
    			}
    		}
    		throw new org.emftext.runtime.resource.impl.UnexpectedContentTypeException(typeObject);
    	}
    	
    	@SuppressWarnings("unchecked")
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
    	}
    	
    	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
    		tokenResolveResult.clear();
    		return tokenResolveResult;
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
    		try {
    			if (encoding == null) {
    				return new FeatureParser(new org.antlr.runtime.CommonTokenStream(new FeatureLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new FeatureParser(new org.antlr.runtime.CommonTokenStream(new FeatureLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}



    // $ANTLR start "start"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:102:1: start returns [ EObject element = null] : (c0= featuremodel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;
        int start_StartIndex = input.index();
        org.featuremapper.models.feature.FeatureModel c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:103:1: ( (c0= featuremodel ) EOF )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:104:2: (c0= featuremodel ) EOF
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:104:2: (c0= featuremodel )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:105:3: c0= featuremodel
            {
            pushFollow(FOLLOW_featuremodel_in_start79);
            c0=featuremodel();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start86); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "featuremodel"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:110:1: featuremodel returns [org.featuremapper.models.feature.FeatureModel element = null] : a0= 'FeatureModel' (a1= QUOTED_34_34 ) ( (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' ) )? (a7_0= feature ) ;
    public final org.featuremapper.models.feature.FeatureModel featuremodel() throws RecognitionException {
        org.featuremapper.models.feature.FeatureModel element =  null;
        int featuremodel_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        org.featuremapper.models.feature.Constraint a4_0 = null;

        org.featuremapper.models.feature.Feature a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:113:1: (a0= 'FeatureModel' (a1= QUOTED_34_34 ) ( (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' ) )? (a7_0= feature ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:114:2: a0= 'FeatureModel' (a1= QUOTED_34_34 ) ( (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' ) )? (a7_0= feature )
            {
            a0=(Token)match(input,11,FOLLOW_11_in_featuremodel109); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:122:2: (a1= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:123:3: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_featuremodel124); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:145:2: ( (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:146:3: (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:146:3: (a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:147:4: a2= '{' a3= 'constraints' ( ( (a4_0= constraint ) a5= ';' ) )? a6= '}'
                    {
                    a2=(Token)match(input,12,FOLLOW_12_in_featuremodel151); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a2, element);
                      			
                    }
                    a3=(Token)match(input,13,FOLLOW_13_in_featuremodel166); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a3, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:163:4: ( ( (a4_0= constraint ) a5= ';' ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==16) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:164:5: ( (a4_0= constraint ) a5= ';' )
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:164:5: ( (a4_0= constraint ) a5= ';' )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:165:6: (a4_0= constraint ) a5= ';'
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:165:6: (a4_0= constraint )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:166:7: a4_0= constraint
                            {
                            pushFollow(FOLLOW_constraint_in_featuremodel202);
                            a4_0=constraint();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (element == null) {
                              								element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                              							}
                              							if (a4_0 != null) {
                              								addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__CONSTRAINTS, a4_0);
                              							}
                              							collectHiddenTokens(element);
                              							copyLocalizationInfos(a4_0, element); 						
                            }

                            }

                            a5=(Token)match(input,14,FOLLOW_14_in_featuremodel233); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              						if (element == null) {
                              							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                              						}
                              						collectHiddenTokens(element);
                              						copyLocalizationInfos((CommonToken)a5, element);
                              					
                            }

                            }


                            }
                            break;

                    }

                    a6=(Token)match(input,15,FOLLOW_15_in_featuremodel270); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a6, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:199:2: (a7_0= feature )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:200:3: a7_0= feature
            {
            pushFollow(FOLLOW_feature_in_featuremodel299);
            a7_0=feature();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
              			}
              			if (a7_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__ROOT), a7_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a7_0, element); 		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, featuremodel_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "featuremodel"


    // $ANTLR start "constraint"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:213:1: constraint returns [org.featuremapper.models.feature.Constraint element = null] : a0= 'Constraint' (a1= TEXT ) a2= ':' (a3= QUOTED_34_34 ) ;
    public final org.featuremapper.models.feature.Constraint constraint() throws RecognitionException {
        org.featuremapper.models.feature.Constraint element =  null;
        int constraint_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:216:1: (a0= 'Constraint' (a1= TEXT ) a2= ':' (a3= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:217:2: a0= 'Constraint' (a1= TEXT ) a2= ':' (a3= QUOTED_34_34 )
            {
            a0=(Token)match(input,16,FOLLOW_16_in_constraint329); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:225:2: (a1= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:226:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_constraint344); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            a2=(Token)match(input,17,FOLLOW_17_in_constraint362); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:256:2: (a3= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:257:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_constraint377); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createConstraint();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a3, element);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, constraint_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "constraint"


    // $ANTLR start "feature"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:281:1: feature returns [org.featuremapper.models.feature.Feature element = null] : a0= 'Feature' (a1= QUOTED_34_34 ) ( (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' ) )? ( (a7= '[' ( (a8_0= attribute ) )* a9= ']' ) )? ( ( ( (a10_0= group ) )* ) )? ;
    public final org.featuremapper.models.feature.Feature feature() throws RecognitionException {
        org.featuremapper.models.feature.Feature element =  null;
        int feature_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        org.featuremapper.models.feature.Attribute a8_0 = null;

        org.featuremapper.models.feature.Group a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:284:1: (a0= 'Feature' (a1= QUOTED_34_34 ) ( (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' ) )? ( (a7= '[' ( (a8_0= attribute ) )* a9= ']' ) )? ( ( ( (a10_0= group ) )* ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:285:2: a0= 'Feature' (a1= QUOTED_34_34 ) ( (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' ) )? ( (a7= '[' ( (a8_0= attribute ) )* a9= ']' ) )? ( ( ( (a10_0= group ) )* ) )?
            {
            a0=(Token)match(input,18,FOLLOW_18_in_feature410); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:293:2: (a1= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:294:3: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_feature425); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:316:2: ( (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:317:3: (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:317:3: (a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:318:4: a2= '(' (a3= INTEGER ) a4= '..' (a5= INTEGER ) a6= ')'
                    {
                    a2=(Token)match(input,19,FOLLOW_19_in_feature452); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a2, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:326:4: (a3= INTEGER )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:327:5: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_feature473); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      					}
                      					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY), result);
                      					Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                      					}
                      					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a3, element);
                      				
                    }

                    }

                    a4=(Token)match(input,20,FOLLOW_20_in_feature501); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:357:4: (a5= INTEGER )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:358:5: a5= INTEGER
                    {
                    a5=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_feature522); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      					}
                      					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY), result);
                      					Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                      					}
                      					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a5, element);
                      				
                    }

                    }

                    a6=(Token)match(input,21,FOLLOW_21_in_feature550); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a6, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:391:2: ( (a7= '[' ( (a8_0= attribute ) )* a9= ']' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:392:3: (a7= '[' ( (a8_0= attribute ) )* a9= ']' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:392:3: (a7= '[' ( (a8_0= attribute ) )* a9= ']' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:393:4: a7= '[' ( (a8_0= attribute ) )* a9= ']'
                    {
                    a7=(Token)match(input,22,FOLLOW_22_in_feature584); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a7, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:401:4: ( (a8_0= attribute ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:402:5: (a8_0= attribute )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:402:5: (a8_0= attribute )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:403:6: a8_0= attribute
                    	    {
                    	    pushFollow(FOLLOW_attribute_in_feature612);
                    	    a8_0=attribute();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                    	      						}
                    	      						if (a8_0 != null) {
                    	      							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE__ATTRIBUTES, a8_0);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos(a8_0, element); 					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    a9=(Token)match(input,23,FOLLOW_23_in_feature647); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a9, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:426:2: ( ( ( (a10_0= group ) )* ) )?
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

                    if ( (synpred7_Feature()) ) {
                        alt7=1;
                    }
                    }
                    break;
                case 15:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (synpred7_Feature()) ) {
                        alt7=1;
                    }
                    }
                    break;
                case 18:
                    {
                    int LA7_4 = input.LA(2);

                    if ( (synpred7_Feature()) ) {
                        alt7=1;
                    }
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:427:3: ( ( (a10_0= group ) )* )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:427:3: ( ( (a10_0= group ) )* )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:428:4: ( (a10_0= group ) )*
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:428:4: ( (a10_0= group ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==24) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:429:5: (a10_0= group )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:429:5: (a10_0= group )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:430:6: a10_0= group
                    	    {
                    	    pushFollow(FOLLOW_group_in_feature694);
                    	    a10_0=group();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
                    	      						}
                    	      						if (a10_0 != null) {
                    	      							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.FEATURE__GROUPS, a10_0);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos(a10_0, element); 					
                    	    }

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
            if ( state.backtracking>0 ) { memoize(input, 4, feature_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "feature"


    // $ANTLR start "group"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:447:1: group returns [org.featuremapper.models.feature.Group element = null] : a0= 'Group' ( (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' ) )? ( (a6= '{' ( (a7_0= feature ) )* a8= '}' ) )? ;
    public final org.featuremapper.models.feature.Group group() throws RecognitionException {
        org.featuremapper.models.feature.Group element =  null;
        int group_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        org.featuremapper.models.feature.Feature a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:450:1: (a0= 'Group' ( (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' ) )? ( (a6= '{' ( (a7_0= feature ) )* a8= '}' ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:451:2: a0= 'Group' ( (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' ) )? ( (a6= '{' ( (a7_0= feature ) )* a8= '}' ) )?
            {
            a0=(Token)match(input,24,FOLLOW_24_in_group754); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:459:2: ( (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:460:3: (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:460:3: (a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:461:4: a1= '(' (a2= INTEGER ) a3= '..' (a4= INTEGER ) a5= ')'
                    {
                    a1=(Token)match(input,19,FOLLOW_19_in_group774); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a1, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:469:4: (a2= INTEGER )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:470:5: a2= INTEGER
                    {
                    a2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_group795); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      					}
                      					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY), result);
                      					Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                      					}
                      					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      				
                    }

                    }

                    a3=(Token)match(input,20,FOLLOW_20_in_group823); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a3, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:500:4: (a4= INTEGER )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:501:5: a4= INTEGER
                    {
                    a4=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_group844); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      					}
                      					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY), result);
                      					Object resolvedObject = result.getResolvedToken();
                      					if (resolvedObject == null) {
                      						getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                      					}
                      					java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
                      					if (resolved != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY), resolved);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a4, element);
                      				
                    }

                    }

                    a5=(Token)match(input,21,FOLLOW_21_in_group872); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:534:2: ( (a6= '{' ( (a7_0= feature ) )* a8= '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:535:3: (a6= '{' ( (a7_0= feature ) )* a8= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:535:3: (a6= '{' ( (a7_0= feature ) )* a8= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:536:4: a6= '{' ( (a7_0= feature ) )* a8= '}'
                    {
                    a6=(Token)match(input,12,FOLLOW_12_in_group906); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a6, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:544:4: ( (a7_0= feature ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:545:5: (a7_0= feature )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:545:5: (a7_0= feature )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:546:6: a7_0= feature
                    	    {
                    	    pushFollow(FOLLOW_feature_in_group934);
                    	    a7_0=feature();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                    	      						}
                    	      						if (a7_0 != null) {
                    	      							addObjectToList(element, org.featuremapper.models.feature.FeaturePackage.GROUP__CHILD_FEATURES, a7_0);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos(a7_0, element); 					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    a8=(Token)match(input,15,FOLLOW_15_in_group969); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createGroup();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a8, element);
                      			
                    }

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
            if ( state.backtracking>0 ) { memoize(input, 5, group_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "group"


    // $ANTLR start "attribute"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:571:1: attribute returns [org.featuremapper.models.feature.Attribute element = null] : (a0= TEXT ) (a1= TEXT ) a2= '=' (a3= QUOTED_34_34 ) ;
    public final org.featuremapper.models.feature.Attribute attribute() throws RecognitionException {
        org.featuremapper.models.feature.Attribute element =  null;
        int attribute_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:574:1: ( (a0= TEXT ) (a1= TEXT ) a2= '=' (a3= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:575:2: (a0= TEXT ) (a1= TEXT ) a2= '=' (a3= QUOTED_34_34 )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:575:2: (a0= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:576:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_attribute1013); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:598:2: (a1= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:599:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_attribute1035); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            a2=(Token)match(input,25,FOLLOW_25_in_attribute1053); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:629:2: (a3= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:630:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_attribute1068); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createAttribute();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a3, element);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, attribute_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "attribute"

    // $ANTLR start synpred7_Feature
    public final void synpred7_Feature_fragment() throws RecognitionException {   
        org.featuremapper.models.feature.Group a10_0 = null;


        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:427:3: ( ( ( (a10_0= group ) )* ) )
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:427:3: ( ( (a10_0= group ) )* )
        {
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:427:3: ( ( (a10_0= group ) )* )
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:428:4: ( (a10_0= group ) )*
        {
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:428:4: ( (a10_0= group ) )*
        loop13:
        do {
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }


            switch (alt13) {
        	case 1 :
        	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:429:5: (a10_0= group )
        	    {
        	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:429:5: (a10_0= group )
        	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:430:6: a10_0= group
        	    {
        	    pushFollow(FOLLOW_group_in_synpred7_Feature694);
        	    a10_0=group();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop13;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred7_Feature

    // Delegated rules

    public final boolean synpred7_Feature() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Feature_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_featuremodel_in_start79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_featuremodel109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_featuremodel124 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_12_in_featuremodel151 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_featuremodel166 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_constraint_in_featuremodel202 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_featuremodel233 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_featuremodel270 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_feature_in_featuremodel299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_constraint329 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_constraint344 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_constraint362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_constraint377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_feature410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_feature425 = new BitSet(new long[]{0x0000000001480002L});
    public static final BitSet FOLLOW_19_in_feature452 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature473 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_feature501 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_feature522 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_feature550 = new BitSet(new long[]{0x0000000001400002L});
    public static final BitSet FOLLOW_22_in_feature584 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_attribute_in_feature612 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_feature647 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_group_in_feature694 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_group754 = new BitSet(new long[]{0x0000000000081002L});
    public static final BitSet FOLLOW_19_in_group774 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group795 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_group823 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_group844 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_group872 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_group906 = new BitSet(new long[]{0x0000000000049000L});
    public static final BitSet FOLLOW_feature_in_group934 = new BitSet(new long[]{0x0000000000049000L});
    public static final BitSet FOLLOW_15_in_group969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_attribute1013 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_attribute1035 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_attribute1053 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_attribute1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_synpred7_Feature694 = new BitSet(new long[]{0x0000000001000002L});

}