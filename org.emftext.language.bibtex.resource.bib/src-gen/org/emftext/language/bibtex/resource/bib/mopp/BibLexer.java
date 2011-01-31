// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.bibtex.resource.bib.mopp;


import org.antlr.runtime3_2_0.*;

public class BibLexer extends Lexer {
    public static final int INTEGER=7;
    public static final int T__25=25;
    public static final int YEAR=6;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=9;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int COMMENT=8;
    public static final int QUOTED_34_34=5;
    public static final int LINEBREAK=10;

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public BibLexer() {;} 
    public BibLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BibLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Bib.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:16:7: ( 'title' )
            // Bib.g:16:9: 'title'
            {
            match("title"); 


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
            // Bib.g:17:7: ( '=' )
            // Bib.g:17:9: '='
            {
            match('='); 

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
            // Bib.g:18:7: ( 'booktitle' )
            // Bib.g:18:9: 'booktitle'
            {
            match("booktitle"); 


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
            // Bib.g:19:7: ( 'year' )
            // Bib.g:19:9: 'year'
            {
            match("year"); 


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
            // Bib.g:20:7: ( '{' )
            // Bib.g:20:9: '{'
            {
            match('{'); 

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
            // Bib.g:21:7: ( '}' )
            // Bib.g:21:9: '}'
            {
            match('}'); 

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
            // Bib.g:22:7: ( 'author' )
            // Bib.g:22:9: 'author'
            {
            match("author"); 


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
            // Bib.g:23:7: ( 'and' )
            // Bib.g:23:9: 'and'
            {
            match("and"); 


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
            // Bib.g:24:7: ( 'journal' )
            // Bib.g:24:9: 'journal'
            {
            match("journal"); 


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
            // Bib.g:25:7: ( 'volume' )
            // Bib.g:25:9: 'volume'
            {
            match("volume"); 


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
            // Bib.g:26:7: ( 'pages' )
            // Bib.g:26:9: 'pages'
            {
            match("pages"); 


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
            // Bib.g:27:7: ( '--' )
            // Bib.g:27:9: '--'
            {
            match("--"); 


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
            // Bib.g:28:7: ( '@INPROCEEDINGS' )
            // Bib.g:28:9: '@INPROCEEDINGS'
            {
            match("@INPROCEEDINGS"); 


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
            // Bib.g:29:7: ( ',' )
            // Bib.g:29:9: ','
            {
            match(','); 

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
            // Bib.g:30:7: ( '@ARTICLE' )
            // Bib.g:30:9: '@ARTICLE'
            {
            match("@ARTICLE"); 


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
            // Bib.g:2201:8: ( ( '%' (~ ( '\\n' | '\\r' ) )* ) )
            // Bib.g:2202:2: ( '%' (~ ( '\\n' | '\\r' ) )* )
            {
            // Bib.g:2202:2: ( '%' (~ ( '\\n' | '\\r' ) )* )
            // Bib.g:2202:3: '%' (~ ( '\\n' | '\\r' ) )*
            {
            match('%'); 
            // Bib.g:2202:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bib.g:2202:7: ~ ( '\\n' | '\\r' )
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


            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "YEAR"
    public final void mYEAR() throws RecognitionException {
        try {
            int _type = YEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:2205:5: ( ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) ) )
            // Bib.g:2206:2: ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
            {
            // Bib.g:2206:2: ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
            // Bib.g:2206:3: ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' )
            {
            if ( (input.LA(1)>='1' && input.LA(1)<='2') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Bib.g:2206:13: ( '0' .. '9' )
            // Bib.g:2206:14: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // Bib.g:2206:23: ( '0' .. '9' )
            // Bib.g:2206:24: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // Bib.g:2206:33: ( '0' .. '9' )
            // Bib.g:2206:34: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YEAR"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:2208:8: ( ( ( '0' .. '9' )+ ) )
            // Bib.g:2209:2: ( ( '0' .. '9' )+ )
            {
            // Bib.g:2209:2: ( ( '0' .. '9' )+ )
            // Bib.g:2209:3: ( '0' .. '9' )+
            {
            // Bib.g:2209:3: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Bib.g:2209:4: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:2211:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' )+ ) )
            // Bib.g:2212:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' )+ )
            {
            // Bib.g:2212:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' )+ )
            // Bib.g:2212:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' )+
            {
            // Bib.g:2212:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='-' && LA3_0<='.')||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bib.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


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
            // Bib.g:2214:11: ( ( ( ' ' | '\\t' | '\\f' )+ ) )
            // Bib.g:2215:2: ( ( ' ' | '\\t' | '\\f' )+ )
            {
            // Bib.g:2215:2: ( ( ' ' | '\\t' | '\\f' )+ )
            // Bib.g:2215:3: ( ' ' | '\\t' | '\\f' )+
            {
            // Bib.g:2215:3: ( ' ' | '\\t' | '\\f' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0=='\f'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bib.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

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
            // Bib.g:2218:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Bib.g:2219:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Bib.g:2219:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Bib.g:2219:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Bib.g:2219:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\n') ) {
                    alt5=1;
                }
                else {
                    alt5=2;}
            }
            else if ( (LA5_0=='\n') ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Bib.g:2219:4: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Bib.g:2219:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Bib.g:2219:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


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
            // Bib.g:2222:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Bib.g:2223:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Bib.g:2223:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Bib.g:2223:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Bib.g:2223:3: ( '\"' )
            // Bib.g:2223:4: '\"'
            {
            match('\"'); 

            }

            // Bib.g:2223:8: (~ ( '\"' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Bib.g:2223:9: ~ ( '\"' )
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

            	default :
            	    break loop6;
                }
            } while (true);

            // Bib.g:2223:17: ( '\"' )
            // Bib.g:2223:18: '\"'
            {
            match('\"'); 

            }


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
        // Bib.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | YEAR | INTEGER | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt7=22;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // Bib.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // Bib.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // Bib.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // Bib.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // Bib.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // Bib.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // Bib.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // Bib.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // Bib.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // Bib.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // Bib.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // Bib.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // Bib.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // Bib.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // Bib.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // Bib.g:1:100: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 17 :
                // Bib.g:1:108: YEAR
                {
                mYEAR(); 

                }
                break;
            case 18 :
                // Bib.g:1:113: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 19 :
                // Bib.g:1:121: TEXT
                {
                mTEXT(); 

                }
                break;
            case 20 :
                // Bib.g:1:126: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 21 :
                // Bib.g:1:137: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 22 :
                // Bib.g:1:147: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\21\1\uffff\2\21\2\uffff\5\21\3\uffff\2\41\4\uffff\10"+
        "\21\1\52\2\uffff\1\41\1\uffff\4\21\1\60\3\21\1\uffff\1\41\2\21\1"+
        "\67\1\21\1\uffff\3\21\1\74\1\75\1\21\1\uffff\3\21\1\102\2\uffff"+
        "\1\21\1\104\1\21\1\106\1\uffff\1\21\1\uffff\1\110\1\uffff\1\21\1"+
        "\uffff\1\112\1\uffff";
    static final String DFA7_eofS =
        "\113\uffff";
    static final String DFA7_minS =
        "\1\11\1\151\1\uffff\1\157\1\145\2\uffff\1\156\2\157\1\141\1\55"+
        "\1\101\2\uffff\2\55\4\uffff\1\164\1\157\1\141\1\164\1\144\1\165"+
        "\1\154\1\147\1\55\2\uffff\1\55\1\uffff\1\154\1\153\1\162\1\150\1"+
        "\55\1\162\1\165\1\145\1\uffff\1\55\1\145\1\164\1\55\1\157\1\uffff"+
        "\1\156\1\155\1\163\2\55\1\151\1\uffff\1\162\1\141\1\145\1\55\2\uffff"+
        "\1\164\1\55\1\154\1\55\1\uffff\1\154\1\uffff\1\55\1\uffff\1\145"+
        "\1\uffff\1\55\1\uffff";
    static final String DFA7_maxS =
        "\1\175\1\151\1\uffff\1\157\1\145\2\uffff\1\165\2\157\1\141\1\55"+
        "\1\111\2\uffff\2\172\4\uffff\1\164\1\157\1\141\1\164\1\144\1\165"+
        "\1\154\1\147\1\172\2\uffff\1\172\1\uffff\1\154\1\153\1\162\1\150"+
        "\1\172\1\162\1\165\1\145\1\uffff\1\172\1\145\1\164\1\172\1\157\1"+
        "\uffff\1\156\1\155\1\163\2\172\1\151\1\uffff\1\162\1\141\1\145\1"+
        "\172\2\uffff\1\164\1\172\1\154\1\172\1\uffff\1\154\1\uffff\1\172"+
        "\1\uffff\1\145\1\uffff\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\2\uffff\1\5\1\6\6\uffff\1\16\1\20\2\uffff\1\23\1\24"+
        "\1\25\1\26\11\uffff\1\15\1\17\1\uffff\1\22\10\uffff\1\14\5\uffff"+
        "\1\10\6\uffff\1\4\4\uffff\1\21\1\1\4\uffff\1\13\1\uffff\1\7\1\uffff"+
        "\1\12\1\uffff\1\11\1\uffff\1\3";
    static final String DFA7_specialS =
        "\113\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\22\1\23\1\uffff\1\22\1\23\22\uffff\1\22\1\uffff\1\24\2\uffff"+
            "\1\16\6\uffff\1\15\1\13\1\21\1\uffff\1\20\2\17\7\20\3\uffff"+
            "\1\2\2\uffff\1\14\32\21\4\uffff\1\21\1\uffff\1\7\1\3\7\21\1"+
            "\10\5\21\1\12\3\21\1\1\1\21\1\11\2\21\1\4\1\21\1\5\1\uffff\1"+
            "\6",
            "\1\25",
            "",
            "\1\26",
            "\1\27",
            "",
            "",
            "\1\31\6\uffff\1\30",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\37\7\uffff\1\36",
            "",
            "",
            "\2\21\1\uffff\12\40\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\2\21\1\uffff\12\20\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "",
            "\2\21\1\uffff\12\53\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\2\21\1\uffff\12\64\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\1\65",
            "\1\66",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\1\70",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\2\21\1\uffff\12\20\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\1\76",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "",
            "\1\103",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "\1\105",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "\1\107",
            "",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            "",
            "\1\111",
            "",
            "\2\21\1\uffff\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32"+
            "\21",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | YEAR | INTEGER | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}