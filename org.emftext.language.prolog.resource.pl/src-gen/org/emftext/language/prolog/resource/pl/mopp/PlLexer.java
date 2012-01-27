// $ANTLR 3.4

	package org.emftext.language.prolog.resource.pl.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PlLexer extends Lexer {
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
    public static final int ANONYMOUS=4;
    public static final int CAPITAL_WORD=5;
    public static final int FLOAT=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_39_39=8;
    public static final int SL_COMMENT=9;
    public static final int SMALL_WORD=10;
    public static final int WHITESPACE=11;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PlLexer() {} 
    public PlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Pl.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:15:7: ( '(' )
            // Pl.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:16:7: ( ')' )
            // Pl.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:17:7: ( ',' )
            // Pl.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:18:7: ( '.' )
            // Pl.g:18:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:19:7: ( ':-' )
            // Pl.g:19:9: ':-'
            {
            match(":-"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:20:7: ( '[' )
            // Pl.g:20:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:21:7: ( ']' )
            // Pl.g:21:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:22:7: ( 'is' )
            // Pl.g:22:9: 'is'
            {
            match("is"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:23:7: ( '|' )
            // Pl.g:23:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1545:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Pl.g:1546:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1549:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Pl.g:1550:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Pl.g:1550:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Pl.g:1550:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Pl.g:1550:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=2;
                }
            }
            else if ( (LA1_0=='\n') ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Pl.g:1550:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Pl.g:1550:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Pl.g:1550:20: '\\n'
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1553:6: ( ( ( '-' )? ( ( '1' .. '9' ) ( ( '0' .. '9' ) )* | '0' ) ( '.' ( ( '0' .. '9' ) )+ )? ) )
            // Pl.g:1554:2: ( ( '-' )? ( ( '1' .. '9' ) ( ( '0' .. '9' ) )* | '0' ) ( '.' ( ( '0' .. '9' ) )+ )? )
            {
            // Pl.g:1554:2: ( ( '-' )? ( ( '1' .. '9' ) ( ( '0' .. '9' ) )* | '0' ) ( '.' ( ( '0' .. '9' ) )+ )? )
            // Pl.g:1554:3: ( '-' )? ( ( '1' .. '9' ) ( ( '0' .. '9' ) )* | '0' ) ( '.' ( ( '0' .. '9' ) )+ )?
            {
            // Pl.g:1554:3: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Pl.g:1554:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Pl.g:1554:9: ( ( '1' .. '9' ) ( ( '0' .. '9' ) )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0 >= '1' && LA4_0 <= '9')) ) {
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
                    // Pl.g:1554:10: ( '1' .. '9' ) ( ( '0' .. '9' ) )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Pl.g:1554:21: ( ( '0' .. '9' ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Pl.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Pl.g:1554:37: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            // Pl.g:1554:42: ( '.' ( ( '0' .. '9' ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Pl.g:1554:43: '.' ( ( '0' .. '9' ) )+
                    {
                    match('.'); 

                    // Pl.g:1554:47: ( ( '0' .. '9' ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Pl.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "CAPITAL_WORD"
    public final void mCAPITAL_WORD() throws RecognitionException {
        try {
            int _type = CAPITAL_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1556:13: ( ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* ) )
            // Pl.g:1557:2: ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )
            {
            // Pl.g:1557:2: ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )
            // Pl.g:1557:3: ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Pl.g:1557:13: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '*' && LA7_0 <= '+')||LA7_0=='-'||(LA7_0 >= '/' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Pl.g:
            	    {
            	    if ( (input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CAPITAL_WORD"

    // $ANTLR start "SMALL_WORD"
    public final void mSMALL_WORD() throws RecognitionException {
        try {
            int _type = SMALL_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1559:11: ( ( ( 'a' .. 'z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* ) )
            // Pl.g:1560:2: ( ( 'a' .. 'z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )
            {
            // Pl.g:1560:2: ( ( 'a' .. 'z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )
            // Pl.g:1560:3: ( 'a' .. 'z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Pl.g:1560:13: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '*' && LA8_0 <= '+')||LA8_0=='-'||(LA8_0 >= '/' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Pl.g:
            	    {
            	    if ( (input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SMALL_WORD"

    // $ANTLR start "ANONYMOUS"
    public final void mANONYMOUS() throws RecognitionException {
        try {
            int _type = ANONYMOUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1562:10: ( ( '_' ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )? ) )
            // Pl.g:1563:2: ( '_' ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )? )
            {
            // Pl.g:1563:2: ( '_' ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )? )
            // Pl.g:1563:3: '_' ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )?
            {
            match('_'); 

            // Pl.g:1563:6: ( ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= 'A' && LA10_0 <= 'Z')) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Pl.g:1563:7: ( 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Pl.g:1563:17: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | ( '+' | '-' | '*' | '/' | '_' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '*' && LA9_0 <= '+')||LA9_0=='-'||(LA9_0 >= '/' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Pl.g:
                    	    {
                    	    if ( (input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANONYMOUS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1565:11: ( ( '%' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Pl.g:1566:2: ( '%' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Pl.g:1566:2: ( '%' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Pl.g:1566:3: '%' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match('%'); 

            // Pl.g:1566:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Pl.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "QUOTED_39_39"
    public final void mQUOTED_39_39() throws RecognitionException {
        try {
            int _type = QUOTED_39_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Pl.g:1569:13: ( ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) ) )
            // Pl.g:1570:2: ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) )
            {
            // Pl.g:1570:2: ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) )
            // Pl.g:1570:3: ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' )
            {
            // Pl.g:1570:3: ( '\\'' )
            // Pl.g:1570:4: '\\''
            {
            match('\''); 

            }


            // Pl.g:1570:9: (~ ( '\\'' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\u0000' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Pl.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // Pl.g:1570:19: ( '\\'' )
            // Pl.g:1570:20: '\\''
            {
            match('\''); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_39_39"

    public void mTokens() throws RecognitionException {
        // Pl.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | WHITESPACE | LINEBREAK | FLOAT | CAPITAL_WORD | SMALL_WORD | ANONYMOUS | SL_COMMENT | QUOTED_39_39 )
        int alt13=17;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt13=1;
            }
            break;
        case ')':
            {
            alt13=2;
            }
            break;
        case ',':
            {
            alt13=3;
            }
            break;
        case '.':
            {
            alt13=4;
            }
            break;
        case ':':
            {
            alt13=5;
            }
            break;
        case '[':
            {
            alt13=6;
            }
            break;
        case ']':
            {
            alt13=7;
            }
            break;
        case 'i':
            {
            int LA13_8 = input.LA(2);

            if ( (LA13_8=='s') ) {
                int LA13_18 = input.LA(3);

                if ( ((LA13_18 >= '*' && LA13_18 <= '+')||LA13_18=='-'||(LA13_18 >= '/' && LA13_18 <= '9')||(LA13_18 >= 'A' && LA13_18 <= 'Z')||LA13_18=='_'||(LA13_18 >= 'a' && LA13_18 <= 'z')) ) {
                    alt13=14;
                }
                else {
                    alt13=8;
                }
            }
            else {
                alt13=14;
            }
            }
            break;
        case '|':
            {
            alt13=9;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt13=10;
            }
            break;
        case '\n':
        case '\r':
            {
            alt13=11;
            }
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt13=12;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt13=13;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt13=14;
            }
            break;
        case '_':
            {
            alt13=15;
            }
            break;
        case '%':
            {
            alt13=16;
            }
            break;
        case '\'':
            {
            alt13=17;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 13, 0, input);

            throw nvae;

        }

        switch (alt13) {
            case 1 :
                // Pl.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // Pl.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // Pl.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // Pl.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // Pl.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // Pl.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // Pl.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // Pl.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // Pl.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // Pl.g:1:64: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 11 :
                // Pl.g:1:75: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 12 :
                // Pl.g:1:85: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 13 :
                // Pl.g:1:91: CAPITAL_WORD
                {
                mCAPITAL_WORD(); 


                }
                break;
            case 14 :
                // Pl.g:1:104: SMALL_WORD
                {
                mSMALL_WORD(); 


                }
                break;
            case 15 :
                // Pl.g:1:115: ANONYMOUS
                {
                mANONYMOUS(); 


                }
                break;
            case 16 :
                // Pl.g:1:125: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 17 :
                // Pl.g:1:136: QUOTED_39_39
                {
                mQUOTED_39_39(); 


                }
                break;

        }

    }


 

}