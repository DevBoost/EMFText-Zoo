// $ANTLR 3.0.1 C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g 2008-11-26 14:40:25

package org.eclipse.uml2.uml.resource.statemachine;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StatemachineLexer extends Lexer {
    public static final int INTEGER=8;
    public static final int FLOAT=9;
    public static final int TEXT=5;
    public static final int T25=25;
    public static final int Tokens=26;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int ML_COMMENT=7;
    public static final int WS=11;
    public static final int SL_COMMENT=6;
    public static final int LB=10;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int QUOTED_34_34=4;
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
    public String getGrammarFileName() { return "C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:17:5: ( 'StateMachine' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:17:7: 'StateMachine'
            {
            match("StateMachine"); 


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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:18:5: ( '{' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:18:7: '{'
            {
            match('{'); 

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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:19:5: ( '}' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:19:7: '}'
            {
            match('}'); 

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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:20:5: ( ';' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:20:7: ';'
            {
            match(';'); 

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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:21:5: ( 'state' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:21:7: 'state'
            {
            match("state"); 


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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:22:5: ( 'entry' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:22:7: 'entry'
            {
            match("entry"); 


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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:23:5: ( ':' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:23:7: ':'
            {
            match(':'); 

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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:24:5: ( 'exit' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:24:7: 'exit'
            {
            match("exit"); 


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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:25:5: ( 'do' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:25:7: 'do'
            {
            match("do"); 


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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:26:5: ( 'final' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:26:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:27:5: ( 'transition' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:27:7: 'transition'
            {
            match("transition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:28:5: ( 'from' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:28:7: 'from'
            {
            match("from"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:29:5: ( 'to' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:29:7: 'to'
            {
            match("to"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:30:5: ( 'when' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:30:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:733:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:734:7: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
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
            	    break loop1;
                }
            } while (true);

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SL_COMMENT

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:737:1: ( '/*' ( . )* '*/' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:738:2: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:738:6: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFE')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:738:6: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:741:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-'||(LA5_0>='1' && LA5_0<='9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='0') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("740:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:2: ( '-' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:8: ( '1' .. '9' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:18: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:742:30: '0'
                    {
                    match('0'); 
                     channel=99; 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTEGER

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:745:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:2: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='1' && LA8_0<='9')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("746:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:9: ( '1' .. '9' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:20: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:43: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:746:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:749:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:750:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:750:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    new NoViableAltException("750:2: ( '\\r\\n' | '\\r' | '\\n' )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:750:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:750:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:750:19: '\\n'
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:753:1: ( ( ' ' | '\\t' | '\\f' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:754:2: ( ' ' | '\\t' | '\\f' )
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:757:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:758:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:758:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='-'||(LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:761:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:2: ( '\"' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:3: '\"'
            {
            match('\"'); 

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2=='\"') ) {
                        int LA12_4 = input.LA(3);

                        if ( ((LA12_4>='\u0000' && LA12_4<='\uFFFE')) ) {
                            alt12=2;
                        }

                        else {
                            alt12=1;
                        }

                    }
                    else if ( ((LA12_2>='\u0000' && LA12_2<='!')||(LA12_2>='#' && LA12_2<='\uFFFE')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFE')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:8: ~ ( '\"' )
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
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:15: ( '\\\\' '\"' )
            	    {
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:15: ( '\\\\' '\"' )
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:26: ( '\"' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:762:27: '\"'
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
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | SL_COMMENT | ML_COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 )
        int alt13=22;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:66: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 16 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:77: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 17 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:88: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 18 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:96: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 19 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:102: LB
                {
                mLB(); 

                }
                break;
            case 20 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:105: WS
                {
                mWS(); 

                }
                break;
            case 21 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:108: TEXT
                {
                mTEXT(); 

                }
                break;
            case 22 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.statemachine\\src\\org\\eclipse\\uml2\\uml\\resource\\statemachine\\Statemachine.g:1:113: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\1\22\3\uffff\2\22\1\uffff\4\22\1\uffff\1\22\2\43\4\uffff"+
        "\4\22\1\50\3\22\1\54\1\22\2\uffff\1\22\1\43\2\uffff\4\22\1\uffff"+
        "\3\22\1\uffff\4\22\1\71\1\22\1\73\1\22\1\75\1\22\1\77\1\100\1\uffff"+
        "\1\101\1\uffff\1\22\1\uffff\1\22\3\uffff\10\22\1\114\1\22\1\uffff"+
        "\1\116\1\uffff";
    static final String DFA13_eofS =
        "\117\uffff";
    static final String DFA13_minS =
        "\1\11\1\164\3\uffff\1\164\1\156\1\uffff\1\157\1\151\1\157\1\150"+
        "\1\52\1\60\2\55\4\uffff\2\141\1\164\1\151\1\55\1\156\1\157\1\141"+
        "\1\55\1\145\2\uffff\1\56\1\55\2\uffff\2\164\1\162\1\164\1\uffff"+
        "\1\141\1\155\1\156\1\uffff\1\156\2\145\1\171\1\55\1\154\1\55\1\163"+
        "\1\55\1\115\2\55\1\uffff\1\55\1\uffff\1\151\1\uffff\1\141\3\uffff"+
        "\1\164\1\143\1\151\1\150\1\157\1\151\2\156\1\55\1\145\1\uffff\1"+
        "\55\1\uffff";
    static final String DFA13_maxS =
        "\1\175\1\164\3\uffff\1\164\1\170\1\uffff\1\157\2\162\1\150\1\57"+
        "\1\71\2\172\4\uffff\2\141\1\164\1\151\1\172\1\156\1\157\1\141\1"+
        "\172\1\145\2\uffff\1\56\1\172\2\uffff\2\164\1\162\1\164\1\uffff"+
        "\1\141\1\155\1\156\1\uffff\1\156\2\145\1\171\1\172\1\154\1\172\1"+
        "\163\1\172\1\115\2\172\1\uffff\1\172\1\uffff\1\151\1\uffff\1\141"+
        "\3\uffff\1\164\1\143\1\151\1\150\1\157\1\151\2\156\1\172\1\145\1"+
        "\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\3\1\4\2\uffff\1\7\10\uffff\1\23\1\24\1\25\1\26\12"+
        "\uffff\1\20\1\17\2\uffff\1\22\1\21\4\uffff\1\11\3\uffff\1\15\14"+
        "\uffff\1\10\1\uffff\1\14\1\uffff\1\16\1\uffff\1\5\1\6\1\12\12\uffff"+
        "\1\13\1\uffff\1\1";
    static final String DFA13_specialS =
        "\117\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\21\1\20\1\uffff\1\21\1\20\22\uffff\1\21\1\uffff\1\23\12"+
            "\uffff\1\15\1\uffff\1\14\1\17\11\16\1\7\1\4\5\uffff\22\22\1"+
            "\1\7\22\4\uffff\1\22\1\uffff\3\22\1\10\1\6\1\11\14\22\1\5\1"+
            "\12\2\22\1\13\3\22\1\2\1\uffff\1\3",
            "\1\24",
            "",
            "",
            "",
            "\1\25",
            "\1\26\11\uffff\1\27",
            "",
            "\1\30",
            "\1\31\10\uffff\1\32",
            "\1\34\2\uffff\1\33",
            "\1\35",
            "\1\36\4\uffff\1\37",
            "\1\40\11\16",
            "\1\22\1\42\1\uffff\12\41\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "\1\22\1\42\1\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\55",
            "",
            "",
            "\1\42",
            "\1\22\1\42\1\uffff\12\41\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\72",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\74",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\76",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "",
            "\1\102",
            "",
            "\1\103",
            "",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\115",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | SL_COMMENT | ML_COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 );";
        }
    }
 

}