// $ANTLR 3.1.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g 2009-04-11 19:18:24

	package org.emftext.language.feature.resource.feature;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FeatureLexer extends Lexer {
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
    public static final int T__24=24;
    public static final int TEXT=5;
    public static final int LINEBREAK=10;
    public static final int T__25=25;
    public static final int T__18=18;
    public static final int QUOTED_34_34=4;
    public static final int T__15=15;

    	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
    	}


    // delegates
    // delegators

    public FeatureLexer() {;} 
    public FeatureLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public FeatureLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:16:7: ( 'FeatureModel' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:16:9: 'FeatureModel'
            {
            match("FeatureModel"); 


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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:17:7: ( '{' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:17:9: '{'
            {
            match('{'); 

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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:18:7: ( 'constraints' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:18:9: 'constraints'
            {
            match("constraints"); 


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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:19:7: ( ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:19:9: ';'
            {
            match(';'); 

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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:20:7: ( '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:20:9: '}'
            {
            match('}'); 

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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:21:7: ( 'Constraint' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:21:9: 'Constraint'
            {
            match("Constraint"); 


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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:22:7: ( ':' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:22:9: ':'
            {
            match(':'); 

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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:23:7: ( 'Feature' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:23:9: 'Feature'
            {
            match("Feature"); 


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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:24:7: ( '(' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:24:9: '('
            {
            match('('); 

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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:25:7: ( '..' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:25:9: '..'
            {
            match(".."); 


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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:26:7: ( ')' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:26:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:27:7: ( '[' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:27:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:28:7: ( ']' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:28:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:29:7: ( 'Group' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:29:9: 'Group'
            {
            match("Group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:30:7: ( '=' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:30:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:654:8: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:655:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:655:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:655:7: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:658:8: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0>='1' && LA4_0<='9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:8: ( '1' .. '9' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:659:30: '0'
                    {
                    match('0'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:660:6: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:9: ( '1' .. '9' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:43: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:661:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:663:5: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:664:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:664:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:665:11: ( ( ' ' | '\\t' | '\\f' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:666:2: ( ' ' | '\\t' | '\\f' )
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:669:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:670:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:670:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\n') ) {
                    alt10=1;
                }
                else {
                    alt10=2;}
            }
            else if ( (LA10_0=='\n') ) {
                alt10=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:670:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:670:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:670:19: '\\n'
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:673:13: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:2: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:3: '\"'
            {
            match('\"'); 

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='\"') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='\uFFFF')) ) {
                            alt11=2;
                        }

                        else {
                            alt11=1;
                        }

                    }
                    else if ( ((LA11_2>='\u0000' && LA11_2<='!')||(LA11_2>='#' && LA11_2<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:8: ~ ( '\"' )
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
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:15: ( '\\\\' '\"' )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:15: ( '\\\\' '\"' )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:26: ( '\"' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:674:27: '\"'
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
        // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt12=22;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:100: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 17 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:108: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 18 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:116: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 19 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:122: TEXT
                {
                mTEXT(); 

                }
                break;
            case 20 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:127: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 21 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:138: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 22 :
                // C:\\Projekte\\Eclipse-Workspaces\\EMFText-ANT\\org.emftext.language.feature.resource.feature\\src\\org\\emftext\\language\\feature\\resource\\feature\\Feature.g:1:148: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\23\1\uffff\1\23\2\uffff\1\23\6\uffff\1\23\2\uffff\1"+
        "\23\2\34\4\uffff\5\23\1\uffff\1\34\1\uffff\13\23\1\56\3\23\1\uffff"+
        "\1\63\3\23\1\uffff\7\23\1\76\1\23\1\100\1\uffff\1\101\2\uffff";
    static final String DFA12_eofS =
        "\102\uffff";
    static final String DFA12_minS =
        "\1\11\1\145\1\uffff\1\157\2\uffff\1\157\6\uffff\1\162\2\uffff\1"+
        "\60\2\55\4\uffff\1\141\2\156\1\157\1\56\1\uffff\1\55\1\uffff\1\164"+
        "\2\163\2\165\2\164\1\160\3\162\1\55\1\145\2\141\1\uffff\1\55\2\151"+
        "\1\157\1\uffff\2\156\1\144\2\164\1\145\1\163\1\55\1\154\1\55\1\uffff"+
        "\1\55\2\uffff";
    static final String DFA12_maxS =
        "\1\175\1\145\1\uffff\1\157\2\uffff\1\157\6\uffff\1\162\2\uffff"+
        "\1\71\2\172\4\uffff\1\141\2\156\1\157\1\56\1\uffff\1\172\1\uffff"+
        "\1\164\2\163\2\165\2\164\1\160\3\162\1\172\1\145\2\141\1\uffff\1"+
        "\172\2\151\1\157\1\uffff\2\156\1\144\2\164\1\145\1\163\1\172\1\154"+
        "\1\172\1\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\uffff\1\7\1\11\1\12\1\13\1\14\1"+
        "\15\1\uffff\1\17\1\20\3\uffff\1\23\1\24\1\25\1\26\5\uffff\1\21\1"+
        "\uffff\1\22\17\uffff\1\16\4\uffff\1\10\12\uffff\1\6\1\uffff\1\3"+
        "\1\1";
    static final String DFA12_specialS =
        "\102\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\24\1\25\1\uffff\1\24\1\25\22\uffff\1\24\1\uffff\1\26\5\uffff"+
            "\1\10\1\12\3\uffff\1\20\1\11\1\17\1\22\11\21\1\7\1\4\1\uffff"+
            "\1\16\3\uffff\2\23\1\6\2\23\1\1\1\15\23\23\1\13\1\uffff\1\14"+
            "\1\uffff\1\23\1\uffff\2\23\1\3\27\23\1\2\1\uffff\1\5",
            "\1\27",
            "",
            "\1\30",
            "",
            "",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "",
            "",
            "\1\33\11\21",
            "\1\23\1\36\1\uffff\12\35\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "\1\23\1\36\1\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\36",
            "",
            "\1\23\1\36\1\uffff\12\35\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32"+
            "\23",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "\1\23\2\uffff\12\23\7\uffff\14\23\1\62\15\23\4\uffff\1\23"+
            "\1\uffff\32\23",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32"+
            "\23",
            "\1\77",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32"+
            "\23",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32"+
            "\23",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}