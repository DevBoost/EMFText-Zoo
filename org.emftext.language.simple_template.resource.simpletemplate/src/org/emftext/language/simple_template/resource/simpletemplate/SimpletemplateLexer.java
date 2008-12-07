// $ANTLR 3.0.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g 2008-12-07 18:51:55

package org.emftext.language.simple_template.resource.simpletemplate;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SimpletemplateLexer extends Lexer {
    public static final int WS=6;
    public static final int T7=7;
    public static final int T10=10;
    public static final int LB=5;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T8=8;
    public static final int T14=14;
    public static final int T9=9;
    public static final int TEXT=4;
    public static final int T15=15;
    public static final int Tokens=16;
    public static final int EOF=-1;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public SimpletemplateLexer() {;} 
    public SimpletemplateLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g"; }

    // $ANTLR start T7
    public final void mT7() throws RecognitionException {
        try {
            int _type = T7;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:17:4: ( '<%' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:17:6: '<%'
            {
            match("<%"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T7

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:18:4: ( 'if' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:18:6: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:19:4: ( '(' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:19:6: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:20:5: ( ')' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:20:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:21:5: ( '{' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:21:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:22:5: ( '%>' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:22:7: '%>'
            {
            match("%>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:23:5: ( '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:23:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:24:5: ( 'for' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:24:7: 'for'
            {
            match("for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:25:5: ( '<%=' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:25:7: '<%='
            {
            match("<%="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:144:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:145:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:145:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=2;}
            }
            else if ( (LA1_0=='\n') ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("145:2: ( '\\r\\n' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:145:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:145:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:145:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LB

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:148:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:149:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start TEXT
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:152:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:153:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:153:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT

    public void mTokens() throws RecognitionException {
        // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:8: ( T7 | T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | LB | WS | TEXT )
        int alt3=12;
        switch ( input.LA(1) ) {
        case '<':
            {
            int LA3_1 = input.LA(2);

            if ( (LA3_1=='%') ) {
                int LA3_12 = input.LA(3);

                if ( (LA3_12=='=') ) {
                    alt3=9;
                }
                else {
                    alt3=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T7 | T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | LB | WS | TEXT );", 3, 1, input);

                throw nvae;
            }
            }
            break;
        case 'i':
            {
            int LA3_2 = input.LA(2);

            if ( (LA3_2=='f') ) {
                int LA3_13 = input.LA(3);

                if ( (LA3_13=='-'||(LA3_13>='0' && LA3_13<='9')||(LA3_13>='A' && LA3_13<='Z')||LA3_13=='_'||(LA3_13>='a' && LA3_13<='z')) ) {
                    alt3=12;
                }
                else {
                    alt3=2;}
            }
            else {
                alt3=12;}
            }
            break;
        case '(':
            {
            alt3=3;
            }
            break;
        case ')':
            {
            alt3=4;
            }
            break;
        case '{':
            {
            alt3=5;
            }
            break;
        case '%':
            {
            alt3=6;
            }
            break;
        case '}':
            {
            alt3=7;
            }
            break;
        case 'f':
            {
            int LA3_8 = input.LA(2);

            if ( (LA3_8=='o') ) {
                int LA3_14 = input.LA(3);

                if ( (LA3_14=='r') ) {
                    int LA3_18 = input.LA(4);

                    if ( (LA3_18=='-'||(LA3_18>='0' && LA3_18<='9')||(LA3_18>='A' && LA3_18<='Z')||LA3_18=='_'||(LA3_18>='a' && LA3_18<='z')) ) {
                        alt3=12;
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=12;}
            }
            else {
                alt3=12;}
            }
            break;
        case '\n':
        case '\r':
            {
            alt3=10;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt3=11;
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
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
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
            alt3=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T7 | T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | LB | WS | TEXT );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:10: T7
                {
                mT7(); 

                }
                break;
            case 2 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:13: T8
                {
                mT8(); 

                }
                break;
            case 3 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:16: T9
                {
                mT9(); 

                }
                break;
            case 4 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:19: T10
                {
                mT10(); 

                }
                break;
            case 5 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:23: T11
                {
                mT11(); 

                }
                break;
            case 6 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:27: T12
                {
                mT12(); 

                }
                break;
            case 7 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:31: T13
                {
                mT13(); 

                }
                break;
            case 8 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:35: T14
                {
                mT14(); 

                }
                break;
            case 9 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:39: T15
                {
                mT15(); 

                }
                break;
            case 10 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:43: LB
                {
                mLB(); 

                }
                break;
            case 11 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:46: WS
                {
                mWS(); 

                }
                break;
            case 12 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.emftext.language.simple_template.resource.simpletemplate\\src\\org\\emftext\\language\\simple_template\\resource\\simpletemplate\\Simpletemplate.g:1:49: TEXT
                {
                mTEXT(); 

                }
                break;

        }

    }


 

}