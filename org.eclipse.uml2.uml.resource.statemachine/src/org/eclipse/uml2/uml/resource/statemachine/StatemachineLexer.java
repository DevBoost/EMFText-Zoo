// $ANTLR 3.0.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g 2008-12-07 19:51:12

package org.eclipse.uml2.uml.resource.statemachine;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StatemachineLexer extends Lexer {
    public static final int T8=8;
    public static final int TEXT=4;
    public static final int T9=9;
    public static final int Tokens=22;
    public static final int EOF=-1;
    public static final int T21=21;
    public static final int T20=20;
    public static final int WS=7;
    public static final int LB=6;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int QUOTED_34_34=5;
    public static final int T18=18;
    public static final int T19=19;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public StatemachineLexer() {;} 
    public StatemachineLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g"; }

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:17:4: ( 'StateMachine' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:17:6: 'StateMachine'
            {
            match("StateMachine"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:18:4: ( '{' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:18:6: '{'
            {
            match('{'); 

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:19:5: ( '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:19:7: '}'
            {
            match('}'); 

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:20:5: ( ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:20:7: ';'
            {
            match(';'); 

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:21:5: ( 'state' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:21:7: 'state'
            {
            match("state"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:22:5: ( 'entry' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:22:7: 'entry'
            {
            match("entry"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:23:5: ( ':' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:23:7: ':'
            {
            match(':'); 

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:24:5: ( 'exit' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:24:7: 'exit'
            {
            match("exit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:25:5: ( 'do' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:25:7: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:26:5: ( 'final' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:26:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:27:5: ( 'transition' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:27:7: 'transition'
            {
            match("transition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:28:5: ( 'from' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:28:7: 'from'
            {
            match("from"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:29:5: ( 'to' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:29:7: 'to'
            {
            match("to"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:30:5: ( 'when' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:30:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:733:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    new NoViableAltException("734:2: ( '\\r\\n' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:19: '\\n'
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:737:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:738:2: ( ' ' | '\\t' | '\\f' )
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:741:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:
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

    // $ANTLR start QUOTED_34_34
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:745:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:2: ( '\"' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:3: '\"'
            {
            match('\"'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='\"') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFE')) ) {
                            alt3=2;
                        }

                        else {
                            alt3=1;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='!')||(LA3_2>='#' && LA3_2<='\uFFFE')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:15: ( '\\\\' '\"' )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:16: '\\\\' '\"'
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

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:26: ( '\"' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:27: '\"'
            {
            match('\"'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_34_34

    public void mTokens() throws RecognitionException {
        // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:8: ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | LB | WS | TEXT | QUOTED_34_34 )
        int alt4=18;
        switch ( input.LA(1) ) {
        case 'S':
            {
            int LA4_1 = input.LA(2);

            if ( (LA4_1=='t') ) {
                int LA4_16 = input.LA(3);

                if ( (LA4_16=='a') ) {
                    int LA4_26 = input.LA(4);

                    if ( (LA4_26=='t') ) {
                        int LA4_36 = input.LA(5);

                        if ( (LA4_36=='e') ) {
                            int LA4_44 = input.LA(6);

                            if ( (LA4_44=='M') ) {
                                int LA4_52 = input.LA(7);

                                if ( (LA4_52=='a') ) {
                                    int LA4_57 = input.LA(8);

                                    if ( (LA4_57=='c') ) {
                                        int LA4_59 = input.LA(9);

                                        if ( (LA4_59=='h') ) {
                                            int LA4_61 = input.LA(10);

                                            if ( (LA4_61=='i') ) {
                                                int LA4_63 = input.LA(11);

                                                if ( (LA4_63=='n') ) {
                                                    int LA4_65 = input.LA(12);

                                                    if ( (LA4_65=='e') ) {
                                                        int LA4_67 = input.LA(13);

                                                        if ( (LA4_67=='-'||(LA4_67>='0' && LA4_67<='9')||(LA4_67>='A' && LA4_67<='Z')||LA4_67=='_'||(LA4_67>='a' && LA4_67<='z')) ) {
                                                            alt4=17;
                                                        }
                                                        else {
                                                            alt4=1;}
                                                    }
                                                    else {
                                                        alt4=17;}
                                                }
                                                else {
                                                    alt4=17;}
                                            }
                                            else {
                                                alt4=17;}
                                        }
                                        else {
                                            alt4=17;}
                                    }
                                    else {
                                        alt4=17;}
                                }
                                else {
                                    alt4=17;}
                            }
                            else {
                                alt4=17;}
                        }
                        else {
                            alt4=17;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
            }
            else {
                alt4=17;}
            }
            break;
        case '{':
            {
            alt4=2;
            }
            break;
        case '}':
            {
            alt4=3;
            }
            break;
        case ';':
            {
            alt4=4;
            }
            break;
        case 's':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='t') ) {
                int LA4_17 = input.LA(3);

                if ( (LA4_17=='a') ) {
                    int LA4_27 = input.LA(4);

                    if ( (LA4_27=='t') ) {
                        int LA4_37 = input.LA(5);

                        if ( (LA4_37=='e') ) {
                            int LA4_45 = input.LA(6);

                            if ( (LA4_45=='-'||(LA4_45>='0' && LA4_45<='9')||(LA4_45>='A' && LA4_45<='Z')||LA4_45=='_'||(LA4_45>='a' && LA4_45<='z')) ) {
                                alt4=17;
                            }
                            else {
                                alt4=5;}
                        }
                        else {
                            alt4=17;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
            }
            else {
                alt4=17;}
            }
            break;
        case 'e':
            {
            switch ( input.LA(2) ) {
            case 'x':
                {
                int LA4_18 = input.LA(3);

                if ( (LA4_18=='i') ) {
                    int LA4_28 = input.LA(4);

                    if ( (LA4_28=='t') ) {
                        int LA4_38 = input.LA(5);

                        if ( (LA4_38=='-'||(LA4_38>='0' && LA4_38<='9')||(LA4_38>='A' && LA4_38<='Z')||LA4_38=='_'||(LA4_38>='a' && LA4_38<='z')) ) {
                            alt4=17;
                        }
                        else {
                            alt4=8;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
                }
                break;
            case 'n':
                {
                int LA4_19 = input.LA(3);

                if ( (LA4_19=='t') ) {
                    int LA4_29 = input.LA(4);

                    if ( (LA4_29=='r') ) {
                        int LA4_39 = input.LA(5);

                        if ( (LA4_39=='y') ) {
                            int LA4_47 = input.LA(6);

                            if ( (LA4_47=='-'||(LA4_47>='0' && LA4_47<='9')||(LA4_47>='A' && LA4_47<='Z')||LA4_47=='_'||(LA4_47>='a' && LA4_47<='z')) ) {
                                alt4=17;
                            }
                            else {
                                alt4=6;}
                        }
                        else {
                            alt4=17;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
                }
                break;
            default:
                alt4=17;}

            }
            break;
        case ':':
            {
            alt4=7;
            }
            break;
        case 'd':
            {
            int LA4_8 = input.LA(2);

            if ( (LA4_8=='o') ) {
                int LA4_20 = input.LA(3);

                if ( (LA4_20=='-'||(LA4_20>='0' && LA4_20<='9')||(LA4_20>='A' && LA4_20<='Z')||LA4_20=='_'||(LA4_20>='a' && LA4_20<='z')) ) {
                    alt4=17;
                }
                else {
                    alt4=9;}
            }
            else {
                alt4=17;}
            }
            break;
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'i':
                {
                int LA4_21 = input.LA(3);

                if ( (LA4_21=='n') ) {
                    int LA4_31 = input.LA(4);

                    if ( (LA4_31=='a') ) {
                        int LA4_40 = input.LA(5);

                        if ( (LA4_40=='l') ) {
                            int LA4_48 = input.LA(6);

                            if ( (LA4_48=='-'||(LA4_48>='0' && LA4_48<='9')||(LA4_48>='A' && LA4_48<='Z')||LA4_48=='_'||(LA4_48>='a' && LA4_48<='z')) ) {
                                alt4=17;
                            }
                            else {
                                alt4=10;}
                        }
                        else {
                            alt4=17;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
                }
                break;
            case 'r':
                {
                int LA4_22 = input.LA(3);

                if ( (LA4_22=='o') ) {
                    int LA4_32 = input.LA(4);

                    if ( (LA4_32=='m') ) {
                        int LA4_41 = input.LA(5);

                        if ( (LA4_41=='-'||(LA4_41>='0' && LA4_41<='9')||(LA4_41>='A' && LA4_41<='Z')||LA4_41=='_'||(LA4_41>='a' && LA4_41<='z')) ) {
                            alt4=17;
                        }
                        else {
                            alt4=12;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
                }
                break;
            default:
                alt4=17;}

            }
            break;
        case 't':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA4_23 = input.LA(3);

                if ( (LA4_23=='-'||(LA4_23>='0' && LA4_23<='9')||(LA4_23>='A' && LA4_23<='Z')||LA4_23=='_'||(LA4_23>='a' && LA4_23<='z')) ) {
                    alt4=17;
                }
                else {
                    alt4=13;}
                }
                break;
            case 'r':
                {
                int LA4_24 = input.LA(3);

                if ( (LA4_24=='a') ) {
                    int LA4_34 = input.LA(4);

                    if ( (LA4_34=='n') ) {
                        int LA4_42 = input.LA(5);

                        if ( (LA4_42=='s') ) {
                            int LA4_50 = input.LA(6);

                            if ( (LA4_50=='i') ) {
                                int LA4_56 = input.LA(7);

                                if ( (LA4_56=='t') ) {
                                    int LA4_58 = input.LA(8);

                                    if ( (LA4_58=='i') ) {
                                        int LA4_60 = input.LA(9);

                                        if ( (LA4_60=='o') ) {
                                            int LA4_62 = input.LA(10);

                                            if ( (LA4_62=='n') ) {
                                                int LA4_64 = input.LA(11);

                                                if ( (LA4_64=='-'||(LA4_64>='0' && LA4_64<='9')||(LA4_64>='A' && LA4_64<='Z')||LA4_64=='_'||(LA4_64>='a' && LA4_64<='z')) ) {
                                                    alt4=17;
                                                }
                                                else {
                                                    alt4=11;}
                                            }
                                            else {
                                                alt4=17;}
                                        }
                                        else {
                                            alt4=17;}
                                    }
                                    else {
                                        alt4=17;}
                                }
                                else {
                                    alt4=17;}
                            }
                            else {
                                alt4=17;}
                        }
                        else {
                            alt4=17;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
                }
                break;
            default:
                alt4=17;}

            }
            break;
        case 'w':
            {
            int LA4_11 = input.LA(2);

            if ( (LA4_11=='h') ) {
                int LA4_25 = input.LA(3);

                if ( (LA4_25=='e') ) {
                    int LA4_35 = input.LA(4);

                    if ( (LA4_35=='n') ) {
                        int LA4_43 = input.LA(5);

                        if ( (LA4_43=='-'||(LA4_43>='0' && LA4_43<='9')||(LA4_43>='A' && LA4_43<='Z')||LA4_43=='_'||(LA4_43>='a' && LA4_43<='z')) ) {
                            alt4=17;
                        }
                        else {
                            alt4=14;}
                    }
                    else {
                        alt4=17;}
                }
                else {
                    alt4=17;}
            }
            else {
                alt4=17;}
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=15;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt4=16;
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
        case 'u':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=17;
            }
            break;
        case '\"':
            {
            alt4=18;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | LB | WS | TEXT | QUOTED_34_34 );", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:10: T8
                {
                mT8(); 

                }
                break;
            case 2 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:13: T9
                {
                mT9(); 

                }
                break;
            case 3 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:16: T10
                {
                mT10(); 

                }
                break;
            case 4 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:20: T11
                {
                mT11(); 

                }
                break;
            case 5 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:24: T12
                {
                mT12(); 

                }
                break;
            case 6 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:28: T13
                {
                mT13(); 

                }
                break;
            case 7 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:32: T14
                {
                mT14(); 

                }
                break;
            case 8 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:36: T15
                {
                mT15(); 

                }
                break;
            case 9 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:40: T16
                {
                mT16(); 

                }
                break;
            case 10 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:44: T17
                {
                mT17(); 

                }
                break;
            case 11 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:48: T18
                {
                mT18(); 

                }
                break;
            case 12 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:52: T19
                {
                mT19(); 

                }
                break;
            case 13 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:56: T20
                {
                mT20(); 

                }
                break;
            case 14 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:60: T21
                {
                mT21(); 

                }
                break;
            case 15 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:64: LB
                {
                mLB(); 

                }
                break;
            case 16 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:67: WS
                {
                mWS(); 

                }
                break;
            case 17 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:70: TEXT
                {
                mTEXT(); 

                }
                break;
            case 18 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Java5 DEV\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:75: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


 

}