// $ANTLR 3.1.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g 2009-04-11 19:20:07

	package org.emftext.language.statemachine.resource.statemachine;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StatemachineLexer extends Lexer {
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
    public static final int QUOTED_34_34=6;
    public static final int T__15=15;

    	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
    	}


    // delegates
    // delegators

    public StatemachineLexer() {;} 
    public StatemachineLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StatemachineLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:16:6: ( 'StateMachine' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:16:8: 'StateMachine'
            {
            match("StateMachine"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:17:7: ( '{' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:17:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:18:7: ( '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:18:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:19:7: ( 'transitions' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:19:9: 'transitions'
            {
            match("transitions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:20:7: ( 'state' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:20:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:21:7: ( 'entry' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:21:9: 'entry'
            {
            match("entry"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:22:7: ( ':' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:22:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:23:7: ( 'exit' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:23:9: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:24:7: ( 'do' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:24:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:25:7: ( ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:25:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:26:7: ( 'final' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:26:9: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:27:7: ( '->' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:27:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:28:7: ( 'when' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:28:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "PSEUDOKIND"
    public final void mPSEUDOKIND() throws RecognitionException {
        try {
            int _type = PSEUDOKIND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:834:11: ( 'initial' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:835:2: 'initial'
            {
            match("initial"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PSEUDOKIND"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:836:5: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:837:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:837:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:838:11: ( ( ' ' | '\\t' | '\\f' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:839:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:842:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:843:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:843:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:843:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:843:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:843:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:846:13: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:2: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:3: '\"'
            {
            match('\"'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='\"') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFF')) ) {
                            alt3=2;
                        }

                        else {
                            alt3=1;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='!')||(LA3_2>='#' && LA3_2<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:15: ( '\\\\' '\"' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:15: ( '\\\\' '\"' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:26: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:847:27: '\"'
            {
            match('\"'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | PSEUDOKIND | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt4=18;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:27: T__12
                {
                mT__12(); 

                }
                break;
            case 5 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:33: T__13
                {
                mT__13(); 

                }
                break;
            case 6 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:39: T__14
                {
                mT__14(); 

                }
                break;
            case 7 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:45: T__15
                {
                mT__15(); 

                }
                break;
            case 8 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:51: T__16
                {
                mT__16(); 

                }
                break;
            case 9 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:57: T__17
                {
                mT__17(); 

                }
                break;
            case 10 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:63: T__18
                {
                mT__18(); 

                }
                break;
            case 11 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:69: T__19
                {
                mT__19(); 

                }
                break;
            case 12 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:75: T__20
                {
                mT__20(); 

                }
                break;
            case 13 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:81: T__21
                {
                mT__21(); 

                }
                break;
            case 14 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:87: PSEUDOKIND
                {
                mPSEUDOKIND(); 

                }
                break;
            case 15 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:98: TEXT
                {
                mTEXT(); 

                }
                break;
            case 16 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:103: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 17 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:114: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 18 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.statemachine.resource.statemachine\\src\\org\\emftext\\language\\statemachine\\resource\\statemachine\\Statemachine.g:1:124: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\16\2\uffff\3\16\1\uffff\1\16\1\uffff\4\16\4\uffff\5"+
        "\16\1\41\1\16\1\uffff\7\16\1\uffff\7\16\1\61\1\16\1\63\3\16\1\67"+
        "\1\70\1\uffff\1\71\1\uffff\3\16\3\uffff\3\16\1\100\2\16\1\uffff"+
        "\5\16\1\110\1\111\2\uffff";
    static final String DFA4_eofS =
        "\112\uffff";
    static final String DFA4_minS =
        "\1\11\1\164\2\uffff\1\162\1\164\1\156\1\uffff\1\157\1\uffff\1\151"+
        "\1\76\1\150\1\156\4\uffff\3\141\1\164\1\151\1\55\1\156\1\uffff\1"+
        "\145\1\151\1\164\1\156\1\164\1\162\1\164\1\uffff\1\141\1\156\1\164"+
        "\1\145\1\163\1\145\1\171\1\55\1\154\1\55\1\151\1\115\1\151\2\55"+
        "\1\uffff\1\55\1\uffff\2\141\1\164\3\uffff\1\154\1\143\1\151\1\55"+
        "\1\150\1\157\1\uffff\1\151\2\156\1\163\1\145\2\55\2\uffff";
    static final String DFA4_maxS =
        "\1\175\1\164\2\uffff\1\162\1\164\1\170\1\uffff\1\157\1\uffff\1"+
        "\151\1\76\1\150\1\156\4\uffff\3\141\1\164\1\151\1\172\1\156\1\uffff"+
        "\1\145\1\151\1\164\1\156\1\164\1\162\1\164\1\uffff\1\141\1\156\1"+
        "\164\1\145\1\163\1\145\1\171\1\172\1\154\1\172\1\151\1\115\1\151"+
        "\2\172\1\uffff\1\172\1\uffff\2\141\1\164\3\uffff\1\154\1\143\1\151"+
        "\1\172\1\150\1\157\1\uffff\1\151\2\156\1\163\1\145\2\172\2\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\3\3\uffff\1\7\1\uffff\1\12\4\uffff\1\17\1\20\1\21"+
        "\1\22\7\uffff\1\14\7\uffff\1\11\17\uffff\1\10\1\uffff\1\15\3\uffff"+
        "\1\5\1\6\1\13\6\uffff\1\16\7\uffff\1\4\1\1";
    static final String DFA4_specialS =
        "\112\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\17\1\20\1\uffff\1\17\1\20\22\uffff\1\17\1\uffff\1\21\12"+
            "\uffff\1\13\2\uffff\12\16\1\7\1\11\5\uffff\22\16\1\1\7\16\4"+
            "\uffff\1\16\1\uffff\3\16\1\10\1\6\1\12\2\16\1\15\11\16\1\5\1"+
            "\4\2\16\1\14\3\16\1\2\1\uffff\1\3",
            "\1\22",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25\11\uffff\1\26",
            "",
            "\1\27",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "",
            "",
            "",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\42",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\62",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\101",
            "\1\102",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32"+
            "\16",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | PSEUDOKIND | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}