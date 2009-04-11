// $ANTLR 3.1.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g 2009-04-11 19:20:06

	package org.emftext.language.statemachine.resource.statemachine;
	
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
public class StatemachineParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "PSEUDOKIND", "QUOTED_34_34", "WHITESPACE", "LINEBREAK", "'StateMachine'", "'{'", "'}'", "'transitions'", "'state'", "'entry'", "':'", "'exit'", "'do'", "';'", "'final'", "'->'", "'when'"
    };
    public static final int T__12=12;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__9=9;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int WHITESPACE=7;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int TEXT=4;
    public static final int LINEBREAK=8;
    public static final int T__10=10;
    public static final int PSEUDOKIND=5;
    public static final int T__18=18;
    public static final int T__15=15;
    public static final int QUOTED_34_34=6;

    // delegates
    // delegators


        public StatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public StatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[22+1];
             
             
        }
        

    public String[] getTokenNames() { return StatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new StatemachineTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
    	
    	// This default constructor is only used to call createInstance() on it
    	public StatemachineParser() {
    		super();
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		lastPosition = 0;
    		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((StatemachineLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = null;
    		Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);
    		}
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass)typeObject;
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.StateMachine.class) {
    				return statemachine();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.Region.class) {
    				return region();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.State.class) {
    				return state();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.Pseudostate.class) {
    				return pseudostate();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.FinalState.class) {
    				return finalstate();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.Transition.class) {
    				return transition();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.Trigger.class) {
    				return trigger();
    			}
    			if (type.getInstanceClass() == org.eclipse.uml2.uml.Activity.class) {
    				return activity();
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
    				return new StatemachineParser(new org.antlr.runtime.CommonTokenStream(new StatemachineLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new StatemachineParser(new org.antlr.runtime.CommonTokenStream(new StatemachineLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}



    // $ANTLR start "start"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:111:1: start returns [ EObject element = null] : (c0= statemachine ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;
        int start_StartIndex = input.index();
        org.eclipse.uml2.uml.StateMachine c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:112:1: ( (c0= statemachine ) EOF )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:113:2: (c0= statemachine ) EOF
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:113:2: (c0= statemachine )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:114:3: c0= statemachine
            {
            pushFollow(FOLLOW_statemachine_in_start79);
            c0=statemachine();

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


    // $ANTLR start "statemachine"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:119:1: statemachine returns [org.eclipse.uml2.uml.StateMachine element = null] : a0= 'StateMachine' (a1= TEXT ) a2= '{' (a3_0= region ) a4= '}' ;
    public final org.eclipse.uml2.uml.StateMachine statemachine() throws RecognitionException {
        org.eclipse.uml2.uml.StateMachine element =  null;
        int statemachine_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.eclipse.uml2.uml.Region a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:122:1: (a0= 'StateMachine' (a1= TEXT ) a2= '{' (a3_0= region ) a4= '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:123:2: a0= 'StateMachine' (a1= TEXT ) a2= '{' (a3_0= region ) a4= '}'
            {
            a0=(Token)match(input,9,FOLLOW_9_in_statemachine109); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:131:2: (a1= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:132:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_statemachine124); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            a2=(Token)match(input,10,FOLLOW_10_in_statemachine142); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:162:2: (a3_0= region )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:163:3: a3_0= region
            {
            pushFollow(FOLLOW_region_in_statemachine157);
            a3_0=region();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
              			}
              			if (a3_0 != null) {
              				addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REGION, a3_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a3_0, element); 		
            }

            }

            a4=(Token)match(input,11,FOLLOW_11_in_statemachine172); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createStateMachine();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a4, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, statemachine_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "statemachine"


    // $ANTLR start "region"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:184:1: region returns [org.eclipse.uml2.uml.Region element = null] : ( (a0_0= vertex ) )* a1= 'transitions' a2= '{' ( (a3_0= transition ) )* a4= '}' ;
    public final org.eclipse.uml2.uml.Region region() throws RecognitionException {
        org.eclipse.uml2.uml.Region element =  null;
        int region_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.eclipse.uml2.uml.Vertex a0_0 = null;

        org.eclipse.uml2.uml.Transition a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:187:1: ( ( (a0_0= vertex ) )* a1= 'transitions' a2= '{' ( (a3_0= transition ) )* a4= '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:188:2: ( (a0_0= vertex ) )* a1= 'transitions' a2= '{' ( (a3_0= transition ) )* a4= '}'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:188:2: ( (a0_0= vertex ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PSEUDOKIND||LA1_0==13||LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:189:3: (a0_0= vertex )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:189:3: (a0_0= vertex )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:190:4: a0_0= vertex
            	    {
            	    pushFollow(FOLLOW_vertex_in_region207);
            	    a0_0=vertex();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
            	      				}
            	      				if (a0_0 != null) {
            	      					addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.REGION__SUBVERTEX, a0_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a0_0, element); 			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            a1=(Token)match(input,12,FOLLOW_12_in_region230); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            a2=(Token)match(input,10,FOLLOW_10_in_region241); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:218:2: ( (a3_0= transition ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEXT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:219:3: (a3_0= transition )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:219:3: (a3_0= transition )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:220:4: a3_0= transition
            	    {
            	    pushFollow(FOLLOW_transition_in_region261);
            	    a3_0=transition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
            	      				}
            	      				if (a3_0 != null) {
            	      					addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.REGION__TRANSITION, a3_0);
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos(a3_0, element); 			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            a4=(Token)match(input,11,FOLLOW_11_in_region284); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createRegion();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a4, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, region_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "region"


    // $ANTLR start "state"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:242:1: state returns [org.eclipse.uml2.uml.State element = null] : (a0= 'state' (a1= TEXT ) a2= '{' ( (a3= 'entry' a4= ':' (a5_0= behavior ) ) )? ( (a6= 'exit' a7= ':' (a8_0= behavior ) ) )? a9= 'do' a10= ':' (a11_0= behavior ) a12= '}' a13= ';' | c0= finalstate );
    public final org.eclipse.uml2.uml.State state() throws RecognitionException {
        org.eclipse.uml2.uml.State element =  null;
        int state_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        Token a10=null;
        Token a12=null;
        Token a13=null;
        org.eclipse.uml2.uml.Behavior a5_0 = null;

        org.eclipse.uml2.uml.Behavior a8_0 = null;

        org.eclipse.uml2.uml.Behavior a11_0 = null;

        org.eclipse.uml2.uml.FinalState c0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:245:1: (a0= 'state' (a1= TEXT ) a2= '{' ( (a3= 'entry' a4= ':' (a5_0= behavior ) ) )? ( (a6= 'exit' a7= ':' (a8_0= behavior ) ) )? a9= 'do' a10= ':' (a11_0= behavior ) a12= '}' a13= ';' | c0= finalstate )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:246:2: a0= 'state' (a1= TEXT ) a2= '{' ( (a3= 'entry' a4= ':' (a5_0= behavior ) ) )? ( (a6= 'exit' a7= ':' (a8_0= behavior ) ) )? a9= 'do' a10= ':' (a11_0= behavior ) a12= '}' a13= ';'
                    {
                    a0=(Token)match(input,13,FOLLOW_13_in_state310); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a0, element);
                      	
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:254:2: (a1= TEXT )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:255:3: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_state325); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      			}
                      			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                      			tokenResolver.setOptions(getOptions());
                      			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME), result);
                      			Object resolvedObject = result.getResolvedToken();
                      			if (resolvedObject == null) {
                      				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                      			}
                      			java.lang.String resolved = (java.lang.String)resolvedObject;
                      			if (resolved != null) {
                      				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME), resolved);
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken) a1, element);
                      		
                    }

                    }

                    a2=(Token)match(input,10,FOLLOW_10_in_state343); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a2, element);
                      	
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:285:2: ( (a3= 'entry' a4= ':' (a5_0= behavior ) ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==14) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:286:3: (a3= 'entry' a4= ':' (a5_0= behavior ) )
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:286:3: (a3= 'entry' a4= ':' (a5_0= behavior ) )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:287:4: a3= 'entry' a4= ':' (a5_0= behavior )
                            {
                            a3=(Token)match(input,14,FOLLOW_14_in_state363); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              				}
                              				collectHiddenTokens(element);
                              				copyLocalizationInfos((CommonToken)a3, element);
                              			
                            }
                            a4=(Token)match(input,15,FOLLOW_15_in_state378); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              				}
                              				collectHiddenTokens(element);
                              				copyLocalizationInfos((CommonToken)a4, element);
                              			
                            }
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:303:4: (a5_0= behavior )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:304:5: a5_0= behavior
                            {
                            pushFollow(FOLLOW_behavior_in_state399);
                            a5_0=behavior();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              					}
                              					if (a5_0 != null) {
                              						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__ENTRY), a5_0);
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos(a5_0, element); 				
                            }

                            }


                            }


                            }
                            break;

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:318:2: ( (a6= 'exit' a7= ':' (a8_0= behavior ) ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==16) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:319:3: (a6= 'exit' a7= ':' (a8_0= behavior ) )
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:319:3: (a6= 'exit' a7= ':' (a8_0= behavior ) )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:320:4: a6= 'exit' a7= ':' (a8_0= behavior )
                            {
                            a6=(Token)match(input,16,FOLLOW_16_in_state441); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              				}
                              				collectHiddenTokens(element);
                              				copyLocalizationInfos((CommonToken)a6, element);
                              			
                            }
                            a7=(Token)match(input,15,FOLLOW_15_in_state456); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              				}
                              				collectHiddenTokens(element);
                              				copyLocalizationInfos((CommonToken)a7, element);
                              			
                            }
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:336:4: (a8_0= behavior )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:337:5: a8_0= behavior
                            {
                            pushFollow(FOLLOW_behavior_in_state477);
                            a8_0=behavior();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              					if (element == null) {
                              						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                              					}
                              					if (a8_0 != null) {
                              						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__EXIT), a8_0);
                              					}
                              					collectHiddenTokens(element);
                              					copyLocalizationInfos(a8_0, element); 				
                            }

                            }


                            }


                            }
                            break;

                    }

                    a9=(Token)match(input,17,FOLLOW_17_in_state510); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a9, element);
                      	
                    }
                    a10=(Token)match(input,15,FOLLOW_15_in_state521); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a10, element);
                      	
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:367:2: (a11_0= behavior )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:368:3: a11_0= behavior
                    {
                    pushFollow(FOLLOW_behavior_in_state536);
                    a11_0=behavior();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      			}
                      			if (a11_0 != null) {
                      				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__DO_ACTIVITY), a11_0);
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos(a11_0, element); 		
                    }

                    }

                    a12=(Token)match(input,11,FOLLOW_11_in_state551); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a12, element);
                      	
                    }
                    a13=(Token)match(input,18,FOLLOW_18_in_state562); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((CommonToken)a13, element);
                      	
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:397:2: c0= finalstate
                    {
                    pushFollow(FOLLOW_finalstate_in_state578);
                    c0=finalstate();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
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
            if ( state.backtracking>0 ) { memoize(input, 4, state_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "state"


    // $ANTLR start "pseudostate"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:401:1: pseudostate returns [org.eclipse.uml2.uml.Pseudostate element = null] : (a0= PSEUDOKIND ) a1= 'state' (a2= TEXT ) a3= ';' ;
    public final org.eclipse.uml2.uml.Pseudostate pseudostate() throws RecognitionException {
        org.eclipse.uml2.uml.Pseudostate element =  null;
        int pseudostate_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:404:1: ( (a0= PSEUDOKIND ) a1= 'state' (a2= TEXT ) a3= ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:405:2: (a0= PSEUDOKIND ) a1= 'state' (a2= TEXT ) a3= ';'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:405:2: (a0= PSEUDOKIND )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:406:3: a0= PSEUDOKIND
            {
            a0=(Token)match(input,PSEUDOKIND,FOLLOW_PSEUDOKIND_in_pseudostate607); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PSEUDOKIND");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              			}
              			org.eclipse.uml2.uml.PseudostateKind resolved = (org.eclipse.uml2.uml.PseudostateKind)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }

            a1=(Token)match(input,13,FOLLOW_13_in_pseudostate625); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:436:2: (a2= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:437:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_pseudostate640); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              		
            }

            }

            a3=(Token)match(input,18,FOLLOW_18_in_pseudostate658); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPseudostate();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, pseudostate_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "pseudostate"


    // $ANTLR start "finalstate"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:469:1: finalstate returns [org.eclipse.uml2.uml.FinalState element = null] : a0= 'final' a1= 'state' (a2= TEXT ) a3= '{' ( (a4= 'entry' a5= ':' (a6_0= behavior ) ) )? ( (a7= 'exit' a8= ':' (a9_0= behavior ) ) )? a10= 'do' a11= ':' (a12_0= behavior ) a13= '}' a14= ';' ;
    public final org.eclipse.uml2.uml.FinalState finalstate() throws RecognitionException {
        org.eclipse.uml2.uml.FinalState element =  null;
        int finalstate_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        Token a10=null;
        Token a11=null;
        Token a13=null;
        Token a14=null;
        org.eclipse.uml2.uml.Behavior a6_0 = null;

        org.eclipse.uml2.uml.Behavior a9_0 = null;

        org.eclipse.uml2.uml.Behavior a12_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:472:1: (a0= 'final' a1= 'state' (a2= TEXT ) a3= '{' ( (a4= 'entry' a5= ':' (a6_0= behavior ) ) )? ( (a7= 'exit' a8= ':' (a9_0= behavior ) ) )? a10= 'do' a11= ':' (a12_0= behavior ) a13= '}' a14= ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:473:2: a0= 'final' a1= 'state' (a2= TEXT ) a3= '{' ( (a4= 'entry' a5= ':' (a6_0= behavior ) ) )? ( (a7= 'exit' a8= ':' (a9_0= behavior ) ) )? a10= 'do' a11= ':' (a12_0= behavior ) a13= '}' a14= ';'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_finalstate684); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_finalstate695); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:489:2: (a2= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:490:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_finalstate710); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              		
            }

            }

            a3=(Token)match(input,10,FOLLOW_10_in_finalstate728); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:520:2: ( (a4= 'entry' a5= ':' (a6_0= behavior ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:521:3: (a4= 'entry' a5= ':' (a6_0= behavior ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:521:3: (a4= 'entry' a5= ':' (a6_0= behavior ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:522:4: a4= 'entry' a5= ':' (a6_0= behavior )
                    {
                    a4=(Token)match(input,14,FOLLOW_14_in_finalstate748); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    a5=(Token)match(input,15,FOLLOW_15_in_finalstate763); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:538:4: (a6_0= behavior )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:539:5: a6_0= behavior
                    {
                    pushFollow(FOLLOW_behavior_in_finalstate784);
                    a6_0=behavior();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      					}
                      					if (a6_0 != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__ENTRY), a6_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a6_0, element); 				
                    }

                    }


                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:553:2: ( (a7= 'exit' a8= ':' (a9_0= behavior ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:554:3: (a7= 'exit' a8= ':' (a9_0= behavior ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:554:3: (a7= 'exit' a8= ':' (a9_0= behavior ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:555:4: a7= 'exit' a8= ':' (a9_0= behavior )
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_finalstate826); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a7, element);
                      			
                    }
                    a8=(Token)match(input,15,FOLLOW_15_in_finalstate841); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a8, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:571:4: (a9_0= behavior )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:572:5: a9_0= behavior
                    {
                    pushFollow(FOLLOW_behavior_in_finalstate862);
                    a9_0=behavior();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
                      					}
                      					if (a9_0 != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__EXIT), a9_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a9_0, element); 				
                    }

                    }


                    }


                    }
                    break;

            }

            a10=(Token)match(input,17,FOLLOW_17_in_finalstate895); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a10, element);
              	
            }
            a11=(Token)match(input,15,FOLLOW_15_in_finalstate906); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a11, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:602:2: (a12_0= behavior )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:603:3: a12_0= behavior
            {
            pushFollow(FOLLOW_behavior_in_finalstate921);
            a12_0=behavior();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              			}
              			if (a12_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__DO_ACTIVITY), a12_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a12_0, element); 		
            }

            }

            a13=(Token)match(input,11,FOLLOW_11_in_finalstate936); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a13, element);
              	
            }
            a14=(Token)match(input,18,FOLLOW_18_in_finalstate947); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createFinalState();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a14, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, finalstate_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "finalstate"


    // $ANTLR start "transition"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:632:1: transition returns [org.eclipse.uml2.uml.Transition element = null] : (a0= TEXT ) a1= '->' (a2= TEXT ) a3= 'when' (a4_0= trigger ) ( (a5= 'do' a6= ':' (a7_0= behavior ) ) )? a8= ';' ;
    public final org.eclipse.uml2.uml.Transition transition() throws RecognitionException {
        org.eclipse.uml2.uml.Transition element =  null;
        int transition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        org.eclipse.uml2.uml.Trigger a4_0 = null;

        org.eclipse.uml2.uml.Behavior a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:635:1: ( (a0= TEXT ) a1= '->' (a2= TEXT ) a3= 'when' (a4_0= trigger ) ( (a5= 'do' a6= ':' (a7_0= behavior ) ) )? a8= ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:636:2: (a0= TEXT ) a1= '->' (a2= TEXT ) a3= 'when' (a4_0= trigger ) ( (a5= 'do' a6= ':' (a7_0= behavior ) ) )? a8= ';'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:636:2: (a0= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:637:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_transition977); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.uml2.uml.State proxy = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.eclipse.uml2.uml.Transition, org.eclipse.uml2.uml.Vertex>(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		
            }

            }

            a1=(Token)match(input,20,FOLLOW_20_in_transition995); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:671:2: (a2= TEXT )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:672:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_transition1010); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.uml2.uml.State proxy = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createState();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.eclipse.uml2.uml.Transition, org.eclipse.uml2.uml.Vertex>(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              			copyLocalizationInfos((CommonToken) a2, proxy);
              		
            }

            }

            a3=(Token)match(input,21,FOLLOW_21_in_transition1028); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:706:2: (a4_0= trigger )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:707:3: a4_0= trigger
            {
            pushFollow(FOLLOW_trigger_in_transition1043);
            a4_0=trigger();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              			}
              			if (a4_0 != null) {
              				addObjectToList(element, org.eclipse.uml2.uml.UMLPackage.TRANSITION__TRIGGER, a4_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a4_0, element); 		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:718:2: ( (a5= 'do' a6= ':' (a7_0= behavior ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:719:3: (a5= 'do' a6= ':' (a7_0= behavior ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:719:3: (a5= 'do' a6= ':' (a7_0= behavior ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:720:4: a5= 'do' a6= ':' (a7_0= behavior )
                    {
                    a5=(Token)match(input,17,FOLLOW_17_in_transition1067); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }
                    a6=(Token)match(input,15,FOLLOW_15_in_transition1082); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a6, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:736:4: (a7_0= behavior )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:737:5: a7_0= behavior
                    {
                    pushFollow(FOLLOW_behavior_in_transition1103);
                    a7_0=behavior();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
                      					}
                      					if (a7_0 != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__EFFECT), a7_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a7_0, element); 				
                    }

                    }


                    }


                    }
                    break;

            }

            a8=(Token)match(input,18,FOLLOW_18_in_transition1136); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTransition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a8, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, transition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "transition"


    // $ANTLR start "trigger"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:761:1: trigger returns [org.eclipse.uml2.uml.Trigger element = null] : (a0= QUOTED_34_34 ) ;
    public final org.eclipse.uml2.uml.Trigger trigger() throws RecognitionException {
        org.eclipse.uml2.uml.Trigger element =  null;
        int trigger_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:764:1: ( (a0= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:765:2: (a0= QUOTED_34_34 )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:765:2: (a0= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:766:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_trigger1166); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createTrigger();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, trigger_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "trigger"


    // $ANTLR start "activity"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:790:1: activity returns [org.eclipse.uml2.uml.Activity element = null] : (a0= QUOTED_34_34 ) ;
    public final org.eclipse.uml2.uml.Activity activity() throws RecognitionException {
        org.eclipse.uml2.uml.Activity element =  null;
        int activity_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:793:1: ( (a0= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:794:2: (a0= QUOTED_34_34 )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:794:2: (a0= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:795:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_activity1203); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createActivity();
              			}
              			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME), result);
              			Object resolvedObject = result.getResolvedToken();
              			if (resolvedObject == null) {
              				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              			}
              			java.lang.String resolved = (java.lang.String)resolvedObject;
              			if (resolved != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME), resolved);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, activity_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "activity"


    // $ANTLR start "vertex"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:819:1: vertex returns [org.eclipse.uml2.uml.Vertex element = null] : (c0= state | c1= pseudostate | c2= finalstate );
    public final org.eclipse.uml2.uml.Vertex vertex() throws RecognitionException {
        org.eclipse.uml2.uml.Vertex element =  null;
        int vertex_StartIndex = input.index();
        org.eclipse.uml2.uml.State c0 = null;

        org.eclipse.uml2.uml.Pseudostate c1 = null;

        org.eclipse.uml2.uml.FinalState c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:820:1: (c0= state | c1= pseudostate | c2= finalstate )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt9=1;
                }
                break;
            case 19:
                {
                int LA9_2 = input.LA(2);

                if ( (synpred9_Statemachine()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case PSEUDOKIND:
                {
                alt9=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:821:2: c0= state
                    {
                    pushFollow(FOLLOW_state_in_vertex1232);
                    c0=state();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:822:4: c1= pseudostate
                    {
                    pushFollow(FOLLOW_pseudostate_in_vertex1242);
                    c1=pseudostate();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:823:4: c2= finalstate
                    {
                    pushFollow(FOLLOW_finalstate_in_vertex1252);
                    c2=finalstate();

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
            if ( state.backtracking>0 ) { memoize(input, 10, vertex_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "vertex"


    // $ANTLR start "behavior"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:827:1: behavior returns [org.eclipse.uml2.uml.Behavior element = null] : (c0= statemachine | c1= activity );
    public final org.eclipse.uml2.uml.Behavior behavior() throws RecognitionException {
        org.eclipse.uml2.uml.Behavior element =  null;
        int behavior_StartIndex = input.index();
        org.eclipse.uml2.uml.StateMachine c0 = null;

        org.eclipse.uml2.uml.Activity c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:828:1: (c0= statemachine | c1= activity )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==9) ) {
                alt10=1;
            }
            else if ( (LA10_0==QUOTED_34_34) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:829:2: c0= statemachine
                    {
                    pushFollow(FOLLOW_statemachine_in_behavior1273);
                    c0=statemachine();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:830:4: c1= activity
                    {
                    pushFollow(FOLLOW_activity_in_behavior1283);
                    c1=activity();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
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
            if ( state.backtracking>0 ) { memoize(input, 11, behavior_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "behavior"

    // $ANTLR start synpred9_Statemachine
    public final void synpred9_Statemachine_fragment() throws RecognitionException {   
        org.eclipse.uml2.uml.State c0 = null;


        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:821:2: (c0= state )
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:821:2: c0= state
        {
        pushFollow(FOLLOW_state_in_synpred9_Statemachine1232);
        c0=state();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_Statemachine

    // Delegated rules

    public final boolean synpred9_Statemachine() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Statemachine_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_statemachine_in_start79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_statemachine109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_statemachine124 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_statemachine142 = new BitSet(new long[]{0x0000000000083020L});
    public static final BitSet FOLLOW_region_in_statemachine157 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statemachine172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vertex_in_region207 = new BitSet(new long[]{0x0000000000083020L});
    public static final BitSet FOLLOW_12_in_region230 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_region241 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_transition_in_region261 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_region284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_state310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_state325 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_state343 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_14_in_state363 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_state378 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_state399 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_state441 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_state456 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_state477 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_state510 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_state521 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_state536 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_state551 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_state562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finalstate_in_state578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PSEUDOKIND_in_pseudostate607 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_pseudostate625 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_pseudostate640 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_pseudostate658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_finalstate684 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_finalstate695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_finalstate710 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_finalstate728 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_14_in_finalstate748 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_finalstate763 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_finalstate784 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_finalstate826 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_finalstate841 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_finalstate862 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_finalstate895 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_finalstate906 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_finalstate921 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_finalstate936 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_finalstate947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_transition977 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_transition995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_transition1010 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_transition1028 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_trigger_in_transition1043 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_transition1067 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_transition1082 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_behavior_in_transition1103 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_transition1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_trigger1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_activity1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_state_in_vertex1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pseudostate_in_vertex1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finalstate_in_vertex1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statemachine_in_behavior1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activity_in_behavior1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_state_in_synpred9_Statemachine1232 = new BitSet(new long[]{0x0000000000000002L});

}