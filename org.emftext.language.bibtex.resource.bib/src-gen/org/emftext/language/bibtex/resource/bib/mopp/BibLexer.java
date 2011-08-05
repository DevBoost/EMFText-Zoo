// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.language.bibtex.resource.bib.mopp;


import org.antlr.runtime3_3_0.*;

public class BibLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int ID=4;
    public static final int TEXT=5;
    public static final int QUOTED_34_34=6;
    public static final int YEAR=7;
    public static final int INTEGER=8;
    public static final int COMMENT=9;
    public static final int LINEBREAK=10;
    public static final int WHITESPACE=11;

    	public java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_3_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_3_0.ANTLRStringStream) input).index());
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

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:16:7: ( 'author' )
            // Bib.g:16:9: 'author'
            {
            match("author"); 


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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:18:7: ( '\\\"' )
            // Bib.g:18:9: '\\\"'
            {
            match('\"'); 

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
            // Bib.g:19:7: ( 'and' )
            // Bib.g:19:9: 'and'
            {
            match("and"); 


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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:22:7: ( ',' )
            // Bib.g:22:9: ','
            {
            match(','); 

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
            // Bib.g:23:7: ( 'editor' )
            // Bib.g:23:9: 'editor'
            {
            match("editor"); 


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
            // Bib.g:24:7: ( 'keywords' )
            // Bib.g:24:9: 'keywords'
            {
            match("keywords"); 


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
            // Bib.g:25:7: ( 'title' )
            // Bib.g:25:9: 'title'
            {
            match("title"); 


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
            // Bib.g:26:7: ( 'booktitle' )
            // Bib.g:26:9: 'booktitle'
            {
            match("booktitle"); 


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
            // Bib.g:27:7: ( 'series' )
            // Bib.g:27:9: 'series'
            {
            match("series"); 


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
            // Bib.g:28:7: ( 'address' )
            // Bib.g:28:9: 'address'
            {
            match("address"); 


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
            // Bib.g:29:7: ( 'month' )
            // Bib.g:29:9: 'month'
            {
            match("month"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:30:7: ( 'organization' )
            // Bib.g:30:9: 'organization'
            {
            match("organization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:31:7: ( 'publisher' )
            // Bib.g:31:9: 'publisher'
            {
            match("publisher"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:32:7: ( 'journal' )
            // Bib.g:32:9: 'journal'
            {
            match("journal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:33:7: ( 'note' )
            // Bib.g:33:9: 'note'
            {
            match("note"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:34:7: ( 'eid' )
            // Bib.g:34:9: 'eid'
            {
            match("eid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:35:7: ( 'abstract' )
            // Bib.g:35:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:36:7: ( 'review' )
            // Bib.g:36:9: 'review'
            {
            match("review"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:37:7: ( 'url' )
            // Bib.g:37:9: 'url'
            {
            match("url"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:38:7: ( 'year' )
            // Bib.g:38:9: 'year'
            {
            match("year"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:39:7: ( 'volume' )
            // Bib.g:39:9: 'volume'
            {
            match("volume"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:40:7: ( 'part' )
            // Bib.g:40:9: 'part'
            {
            match("part"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:41:7: ( 'number' )
            // Bib.g:41:9: 'number'
            {
            match("number"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:42:7: ( 'pages' )
            // Bib.g:42:9: 'pages'
            {
            match("pages"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:43:7: ( '--' )
            // Bib.g:43:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:44:7: ( '-' )
            // Bib.g:44:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:45:7: ( '@INPROCEEDINGS' )
            // Bib.g:45:9: '@INPROCEEDINGS'
            {
            match("@INPROCEEDINGS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:46:7: ( '@inproceedings' )
            // Bib.g:46:9: '@inproceedings'
            {
            match("@inproceedings"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:47:7: ( '@ARTICLE' )
            // Bib.g:47:9: '@ARTICLE'
            {
            match("@ARTICLE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:48:7: ( '@article' )
            // Bib.g:48:9: '@article'
            {
            match("@article"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:6761:8: ( ( '%' (~ ( '\\n' | '\\r' ) )* ) )
            // Bib.g:6762:2: ( '%' (~ ( '\\n' | '\\r' ) )* )
            {
            // Bib.g:6762:2: ( '%' (~ ( '\\n' | '\\r' ) )* )
            // Bib.g:6762:3: '%' (~ ( '\\n' | '\\r' ) )*
            {
            match('%'); 
            // Bib.g:6762:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bib.g:6762:7: ~ ( '\\n' | '\\r' )
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
            // Bib.g:6765:5: ( ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) ) )
            // Bib.g:6766:2: ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
            {
            // Bib.g:6766:2: ( ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
            // Bib.g:6766:3: ( '1' | '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' )
            {
            if ( (input.LA(1)>='1' && input.LA(1)<='2') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Bib.g:6766:13: ( '0' .. '9' )
            // Bib.g:6766:14: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // Bib.g:6766:23: ( '0' .. '9' )
            // Bib.g:6766:24: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // Bib.g:6766:33: ( '0' .. '9' )
            // Bib.g:6766:34: '0' .. '9'
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
            // Bib.g:6768:8: ( ( ( '0' .. '9' )+ ) )
            // Bib.g:6769:2: ( ( '0' .. '9' )+ )
            {
            // Bib.g:6769:2: ( ( '0' .. '9' )+ )
            // Bib.g:6769:3: ( '0' .. '9' )+
            {
            // Bib.g:6769:3: ( '0' .. '9' )+
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
            	    // Bib.g:6769:4: '0' .. '9'
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
            // Bib.g:6771:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' )+ ) )
            // Bib.g:6772:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' )+ )
            {
            // Bib.g:6772:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' )+ )
            // Bib.g:6772:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' )+
            {
            // Bib.g:6772:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='-' && LA3_0<='.')||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bib.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:6774:3: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' | '/' | ':' | '_' )+ ) )
            // Bib.g:6775:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' | '/' | ':' | '_' )+ )
            {
            // Bib.g:6775:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' | '/' | ':' | '_' )+ )
            // Bib.g:6775:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' | '/' | ':' | '_' )+
            {
            // Bib.g:6775:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '.' | '/' | ':' | '_' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='-' && LA4_0<=':')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bib.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:6777:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Bib.g:6778:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Bib.g:6778:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Bib.g:6778:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Bib.g:6778:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Bib.g:6778:4: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Bib.g:6778:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Bib.g:6778:20: '\\n'
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:6781:11: ( ( ( ' ' | '\\t' | '\\f' )+ ) )
            // Bib.g:6782:2: ( ( ' ' | '\\t' | '\\f' )+ )
            {
            // Bib.g:6782:2: ( ( ' ' | '\\t' | '\\f' )+ )
            // Bib.g:6782:3: ( ' ' | '\\t' | '\\f' )+
            {
            // Bib.g:6782:3: ( ' ' | '\\t' | '\\f' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0=='\f'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bib.g:6785:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Bib.g:6786:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Bib.g:6786:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Bib.g:6786:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Bib.g:6786:3: ( '\"' )
            // Bib.g:6786:4: '\"'
            {
            match('\"'); 

            }

            // Bib.g:6786:8: (~ ( '\"' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Bib.g:6786:9: ~ ( '\"' )
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
            	    break loop7;
                }
            } while (true);

            // Bib.g:6786:17: ( '\"' )
            // Bib.g:6786:18: '\"'
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
        // Bib.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | COMMENT | YEAR | INTEGER | TEXT | ID | LINEBREAK | WHITESPACE | QUOTED_34_34 )
        int alt8=41;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // Bib.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // Bib.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // Bib.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // Bib.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // Bib.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // Bib.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // Bib.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // Bib.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // Bib.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // Bib.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // Bib.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // Bib.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // Bib.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // Bib.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // Bib.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // Bib.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // Bib.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // Bib.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // Bib.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // Bib.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // Bib.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // Bib.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // Bib.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // Bib.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // Bib.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // Bib.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // Bib.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // Bib.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // Bib.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // Bib.g:1:184: T__41
                {
                mT__41(); 

                }
                break;
            case 31 :
                // Bib.g:1:190: T__42
                {
                mT__42(); 

                }
                break;
            case 32 :
                // Bib.g:1:196: T__43
                {
                mT__43(); 

                }
                break;
            case 33 :
                // Bib.g:1:202: T__44
                {
                mT__44(); 

                }
                break;
            case 34 :
                // Bib.g:1:208: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 35 :
                // Bib.g:1:216: YEAR
                {
                mYEAR(); 

                }
                break;
            case 36 :
                // Bib.g:1:221: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 37 :
                // Bib.g:1:229: TEXT
                {
                mTEXT(); 

                }
                break;
            case 38 :
                // Bib.g:1:234: ID
                {
                mID(); 

                }
                break;
            case 39 :
                // Bib.g:1:237: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 40 :
                // Bib.g:1:247: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 41 :
                // Bib.g:1:258: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\42\1\uffff\1\43\3\uffff\16\42\1\67\2\uffff\2\75\1\42"+
        "\3\uffff\4\42\3\uffff\21\42\1\124\5\uffff\1\75\1\uffff\1\42\1\127"+
        "\3\42\1\133\15\42\1\151\2\42\1\uffff\1\75\1\42\1\uffff\3\42\1\uffff"+
        "\7\42\1\170\2\42\1\173\2\42\1\uffff\1\176\1\42\1\u0080\5\42\1\u0086"+
        "\2\42\1\u0089\2\42\1\uffff\1\u008c\1\42\1\uffff\2\42\1\uffff\1\42"+
        "\1\uffff\1\u0091\2\42\1\u0094\1\42\1\uffff\1\42\1\u0097\1\uffff"+
        "\2\42\1\uffff\1\42\1\u009b\1\u009c\1\u009d\1\uffff\1\u009e\1\42"+
        "\1\uffff\2\42\1\uffff\2\42\1\u00a4\4\uffff\1\u00a5\1\u00a6\3\42"+
        "\3\uffff\1\u00aa\1\42\1\u00ac\1\uffff\1\42\1\uffff\1\42\1\u00af"+
        "\1\uffff";
    static final String DFA8_eofS =
        "\u00b0\uffff";
    static final String DFA8_minS =
        "\1\11\1\55\1\uffff\1\0\3\uffff\17\55\1\101\1\uffff\3\55\3\uffff"+
        "\4\55\3\uffff\22\55\5\uffff\1\55\1\uffff\26\55\1\uffff\2\55\1\uffff"+
        "\3\55\1\uffff\15\55\1\uffff\16\55\1\uffff\2\55\1\uffff\2\55\1\uffff"+
        "\1\55\1\uffff\5\55\1\uffff\2\55\1\uffff\2\55\1\uffff\4\55\1\uffff"+
        "\2\55\1\uffff\2\55\1\uffff\3\55\4\uffff\5\55\3\uffff\3\55\1\uffff"+
        "\1\55\1\uffff\2\55\1\uffff";
    static final String DFA8_maxS =
        "\1\175\1\172\1\uffff\1\uffff\3\uffff\17\172\1\151\1\uffff\3\172"+
        "\3\uffff\4\172\3\uffff\22\172\5\uffff\1\172\1\uffff\26\172\1\uffff"+
        "\2\172\1\uffff\3\172\1\uffff\15\172\1\uffff\16\172\1\uffff\2\172"+
        "\1\uffff\2\172\1\uffff\1\172\1\uffff\5\172\1\uffff\2\172\1\uffff"+
        "\2\172\1\uffff\4\172\1\uffff\2\172\1\uffff\2\172\1\uffff\3\172\4"+
        "\uffff\5\172\3\uffff\3\172\1\uffff\1\172\1\uffff\2\172\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\6\1\7\20\uffff\1\42\3\uffff\1\46\1\47"+
        "\1\50\4\uffff\1\45\1\3\1\51\22\uffff\1\35\1\36\1\37\1\40\1\41\1"+
        "\uffff\1\44\26\uffff\1\34\2\uffff\1\4\3\uffff\1\23\15\uffff\1\26"+
        "\16\uffff\1\31\2\uffff\1\22\2\uffff\1\27\1\uffff\1\43\5\uffff\1"+
        "\12\2\uffff\1\16\2\uffff\1\33\4\uffff\1\1\2\uffff\1\10\2\uffff\1"+
        "\14\3\uffff\1\32\1\25\1\30\1\15\5\uffff\1\21\1\24\1\11\3\uffff\1"+
        "\13\1\uffff\1\20\2\uffff\1\17";
    static final String DFA8_specialS =
        "\3\uffff\1\0\u00ac\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\35\1\34\1\uffff\1\35\1\34\22\uffff\1\35\1\uffff\1\3\2\uffff"+
            "\1\27\6\uffff\1\6\1\25\1\32\1\33\1\31\2\30\7\31\1\33\2\uffff"+
            "\1\2\2\uffff\1\26\32\32\4\uffff\1\33\1\uffff\1\1\1\12\2\32\1"+
            "\7\4\32\1\17\1\10\1\32\1\14\1\20\1\15\1\16\1\32\1\21\1\13\1"+
            "\11\1\22\1\24\2\32\1\23\1\32\1\4\1\uffff\1\5",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\32\1\41\1\32\1\40\11\32\1\37\6\32\1\36\5\32",
            "",
            "\0\44",
            "",
            "",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\3"+
            "\32\1\45\4\32\1\46\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\47\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\50\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\51\13\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\52\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\53\13\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\54\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\56\23\32\1\55\5\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\57\13\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\60\5\32\1\61\5\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\62\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\63\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\64\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\65\13\32",
            "\1\66\1\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff"+
            "\32\32",
            "\1\72\7\uffff\1\70\27\uffff\1\73\7\uffff\1\71",
            "",
            "\2\32\1\33\12\74\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\31\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\76\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\3"+
            "\32\1\77\26\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\3"+
            "\32\1\100\26\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\101\7\32",
            "",
            "",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\102\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\3"+
            "\32\1\103\26\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\30"+
            "\32\1\104\1\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\105\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\106\13\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\107\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\15"+
            "\32\1\110\14\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\6"+
            "\32\1\111\23\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\32\1\112\30\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\6"+
            "\32\1\114\12\32\1\113\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\24"+
            "\32\1\115\5\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\116\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\14"+
            "\32\1\117\15\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\25"+
            "\32\1\120\4\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\121\16\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\122\31\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\123\16\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "",
            "",
            "",
            "",
            "\2\32\1\33\12\125\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff"+
            "\32\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\7"+
            "\32\1\126\22\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\130\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\131\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\132\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\26"+
            "\32\1\134\3\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\135\16\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\12"+
            "\32\1\136\17\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\137\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\140\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\141\31\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\142\16\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\143\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\144\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\145\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\146\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\32\1\147\30\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\150\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\152\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\24"+
            "\32\1\153\5\32",
            "",
            "\2\32\1\33\12\154\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff"+
            "\32\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\155\13\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\156\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\157\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\160\13\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\161\13\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\162\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\163\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\164\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\7"+
            "\32\1\165\22\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\15"+
            "\32\1\166\14\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\167\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\171\7\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\15"+
            "\32\1\172\14\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\174\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\175\25\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\14"+
            "\32\1\177\15\32",
            "\2\32\1\33\12\31\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\u0081\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\u0082\7\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\u0083\31\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\u0084\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\u0085\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\u0087\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\u0088\7\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\u008a\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\u008b\7\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\u008d\31\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\u008e\10\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\26"+
            "\32\1\u008f\3\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\u0090\25\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\u0092\7\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\2"+
            "\32\1\u0093\27\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\3"+
            "\32\1\u0095\26\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\u0096\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\31"+
            "\32\1\u0098",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\7"+
            "\32\1\u0099\22\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\u009a\16\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\u009f\6\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\22"+
            "\32\1\u00a0\7\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\13"+
            "\32\1\u00a1\16\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\1"+
            "\u00a2\31\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\u00a3\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "",
            "",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\4"+
            "\32\1\u00a7\25\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\23"+
            "\32\1\u00a8\6\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\21"+
            "\32\1\u00a9\10\32",
            "",
            "",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\10"+
            "\32\1\u00ab\21\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\16"+
            "\32\1\u00ad\13\32",
            "",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\15"+
            "\32\1\u00ae\14\32",
            "\2\32\1\33\12\32\1\33\6\uffff\32\32\4\uffff\1\33\1\uffff\32"+
            "\32",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | COMMENT | YEAR | INTEGER | TEXT | ID | LINEBREAK | WHITESPACE | QUOTED_34_34 );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_3 = input.LA(1);

                        s = -1;
                        if ( ((LA8_3>='\u0000' && LA8_3<='\uFFFF')) ) {s = 36;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}