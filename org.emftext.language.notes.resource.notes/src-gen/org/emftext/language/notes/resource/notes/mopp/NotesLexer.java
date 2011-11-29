// $ANTLR 3.4

	package org.emftext.language.notes.resource.notes.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class NotesLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int LINEBREAK=4;
    public static final int ML_COMMENT=5;
    public static final int QUOTED_35_35=6;
    public static final int QUOTED_64_64=7;
    public static final int QUOTED_91_93=8;
    public static final int QUOTED_95_95=9;
    public static final int SL_COMMENT=10;
    public static final int TEXT=11;
    public static final int WHITESPACE=12;

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

    public NotesLexer() {} 
    public NotesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public NotesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Notes.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:15:7: ( ' ' )
            // Notes.g:15:9: ' '
            {
            match(' '); 

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
            // Notes.g:16:7: ( '*' )
            // Notes.g:16:9: '*'
            {
            match('*'); 

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
            // Notes.g:17:7: ( '=' )
            // Notes.g:17:9: '='
            {
            match('='); 

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
            // Notes.g:18:7: ( '>' )
            // Notes.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1116:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Notes.g:1117:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Notes.g:1117:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Notes.g:1117:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Notes.g:1117:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Notes.g:
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1120:11: ( ( '/*' ( ( . )* ) '*/' ) )
            // Notes.g:1121:2: ( '/*' ( ( . )* ) '*/' )
            {
            // Notes.g:1121:2: ( '/*' ( ( . )* ) '*/' )
            // Notes.g:1121:3: '/*' ( ( . )* ) '*/'
            {
            match("/*"); 



            // Notes.g:1121:7: ( ( . )* )
            // Notes.g:1121:8: ( . )*
            {
            // Notes.g:1121:8: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Notes.g:1121:8: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            match("*/"); 



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
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1124:11: ( ( ( '\\t' | '\\f' ) ) )
            // Notes.g:1125:2: ( ( '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f' ) {
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
            // Notes.g:1128:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Notes.g:1129:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Notes.g:1129:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Notes.g:1129:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Notes.g:1129:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else if ( (LA3_0=='\n') ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Notes.g:1129:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Notes.g:1129:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Notes.g:1129:20: '\\n'
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

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1132:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | ' ' )+ ) )
            // Notes.g:1133:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | ' ' )+ )
            {
            // Notes.g:1133:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | ' ' )+ )
            // Notes.g:1133:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | ' ' )+
            {
            // Notes.g:1133:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | ' ' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==' '||LA4_0=='-'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Notes.g:
            	    {
            	    if ( input.LA(1)==' '||input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "QUOTED_91_93"
    public final void mQUOTED_91_93() throws RecognitionException {
        try {
            int _type = QUOTED_91_93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1135:13: ( ( ( '[' ) (~ ( ']' ) )* ( ']' ) ) )
            // Notes.g:1136:2: ( ( '[' ) (~ ( ']' ) )* ( ']' ) )
            {
            // Notes.g:1136:2: ( ( '[' ) (~ ( ']' ) )* ( ']' ) )
            // Notes.g:1136:3: ( '[' ) (~ ( ']' ) )* ( ']' )
            {
            // Notes.g:1136:3: ( '[' )
            // Notes.g:1136:4: '['
            {
            match('['); 

            }


            // Notes.g:1136:8: (~ ( ']' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\\')||(LA5_0 >= '^' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Notes.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop5;
                }
            } while (true);


            // Notes.g:1136:17: ( ']' )
            // Notes.g:1136:18: ']'
            {
            match(']'); 

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
    // $ANTLR end "QUOTED_91_93"

    // $ANTLR start "QUOTED_95_95"
    public final void mQUOTED_95_95() throws RecognitionException {
        try {
            int _type = QUOTED_95_95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1138:13: ( ( ( '_' ) (~ ( '_' ) )* ( '_' ) ) )
            // Notes.g:1139:2: ( ( '_' ) (~ ( '_' ) )* ( '_' ) )
            {
            // Notes.g:1139:2: ( ( '_' ) (~ ( '_' ) )* ( '_' ) )
            // Notes.g:1139:3: ( '_' ) (~ ( '_' ) )* ( '_' )
            {
            // Notes.g:1139:3: ( '_' )
            // Notes.g:1139:4: '_'
            {
            match('_'); 

            }


            // Notes.g:1139:8: (~ ( '_' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '^')||(LA6_0 >= '`' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Notes.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '^')||(input.LA(1) >= '`' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop6;
                }
            } while (true);


            // Notes.g:1139:17: ( '_' )
            // Notes.g:1139:18: '_'
            {
            match('_'); 

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
    // $ANTLR end "QUOTED_95_95"

    // $ANTLR start "QUOTED_35_35"
    public final void mQUOTED_35_35() throws RecognitionException {
        try {
            int _type = QUOTED_35_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1141:13: ( ( ( '#' ) (~ ( '#' ) )* ( '#' ) ) )
            // Notes.g:1142:2: ( ( '#' ) (~ ( '#' ) )* ( '#' ) )
            {
            // Notes.g:1142:2: ( ( '#' ) (~ ( '#' ) )* ( '#' ) )
            // Notes.g:1142:3: ( '#' ) (~ ( '#' ) )* ( '#' )
            {
            // Notes.g:1142:3: ( '#' )
            // Notes.g:1142:4: '#'
            {
            match('#'); 

            }


            // Notes.g:1142:8: (~ ( '#' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\"')||(LA7_0 >= '$' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Notes.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\"')||(input.LA(1) >= '$' && input.LA(1) <= '\uFFFF') ) {
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


            // Notes.g:1142:17: ( '#' )
            // Notes.g:1142:18: '#'
            {
            match('#'); 

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
    // $ANTLR end "QUOTED_35_35"

    // $ANTLR start "QUOTED_64_64"
    public final void mQUOTED_64_64() throws RecognitionException {
        try {
            int _type = QUOTED_64_64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Notes.g:1144:13: ( ( ( '@' ) (~ ( '@' ) )* ( '@' ) ) )
            // Notes.g:1145:2: ( ( '@' ) (~ ( '@' ) )* ( '@' ) )
            {
            // Notes.g:1145:2: ( ( '@' ) (~ ( '@' ) )* ( '@' ) )
            // Notes.g:1145:3: ( '@' ) (~ ( '@' ) )* ( '@' )
            {
            // Notes.g:1145:3: ( '@' )
            // Notes.g:1145:4: '@'
            {
            match('@'); 

            }


            // Notes.g:1145:8: (~ ( '@' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '?')||(LA8_0 >= 'A' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Notes.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '?')||(input.LA(1) >= 'A' && input.LA(1) <= '\uFFFF') ) {
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


            // Notes.g:1145:17: ( '@' )
            // Notes.g:1145:18: '@'
            {
            match('@'); 

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
    // $ANTLR end "QUOTED_64_64"

    public void mTokens() throws RecognitionException {
        // Notes.g:1:8: ( T__13 | T__14 | T__15 | T__16 | SL_COMMENT | ML_COMMENT | WHITESPACE | LINEBREAK | TEXT | QUOTED_91_93 | QUOTED_95_95 | QUOTED_35_35 | QUOTED_64_64 )
        int alt9=13;
        switch ( input.LA(1) ) {
        case ' ':
            {
            int LA9_1 = input.LA(2);

            if ( (LA9_1==' '||LA9_1=='-'||(LA9_1 >= '0' && LA9_1 <= '9')||(LA9_1 >= 'A' && LA9_1 <= 'Z')||(LA9_1 >= 'a' && LA9_1 <= 'z')) ) {
                alt9=9;
            }
            else {
                alt9=1;
            }
            }
            break;
        case '*':
            {
            alt9=2;
            }
            break;
        case '=':
            {
            alt9=3;
            }
            break;
        case '>':
            {
            alt9=4;
            }
            break;
        case '/':
            {
            int LA9_5 = input.LA(2);

            if ( (LA9_5=='/') ) {
                alt9=5;
            }
            else if ( (LA9_5=='*') ) {
                alt9=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 5, input);

                throw nvae;

            }
            }
            break;
        case '\t':
        case '\f':
            {
            alt9=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt9=8;
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
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
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
            alt9=9;
            }
            break;
        case '[':
            {
            alt9=10;
            }
            break;
        case '_':
            {
            alt9=11;
            }
            break;
        case '#':
            {
            alt9=12;
            }
            break;
        case '@':
            {
            alt9=13;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 9, 0, input);

            throw nvae;

        }

        switch (alt9) {
            case 1 :
                // Notes.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // Notes.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // Notes.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // Notes.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // Notes.g:1:34: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 6 :
                // Notes.g:1:45: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 7 :
                // Notes.g:1:56: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 8 :
                // Notes.g:1:67: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 9 :
                // Notes.g:1:77: TEXT
                {
                mTEXT(); 


                }
                break;
            case 10 :
                // Notes.g:1:82: QUOTED_91_93
                {
                mQUOTED_91_93(); 


                }
                break;
            case 11 :
                // Notes.g:1:95: QUOTED_95_95
                {
                mQUOTED_95_95(); 


                }
                break;
            case 12 :
                // Notes.g:1:108: QUOTED_35_35
                {
                mQUOTED_35_35(); 


                }
                break;
            case 13 :
                // Notes.g:1:121: QUOTED_64_64
                {
                mQUOTED_64_64(); 


                }
                break;

        }

    }


 

}