// $ANTLR 3.0.1 C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g 2008-11-25 17:28:20

package org.eclipse.bpel.model.resource.bpws;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BpwsLexer extends Lexer {
    public static final int INTEGER=5;
    public static final int WS=8;
    public static final int LB=7;
    public static final int FLOAT=6;
    public static final int T9=9;
    public static final int COMMENT=4;
    public static final int Tokens=10;
    public static final int EOF=-1;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public BpwsLexer() {;} 
    public BpwsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g"; }

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:17:4: ( 'Process' )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:17:6: 'Process'
            {
            match("Process"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:465:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:466:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:466:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:466:7: ~ ( '\\n' | '\\r' )
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
    // $ANTLR end COMMENT

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:469:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("468:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:8: ( '1' .. '9' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:19: '0' .. '9'
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
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:470:30: '0'
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:473:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("474:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:9: ( '1' .. '9' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:21: '0' .. '9'
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
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:43: ( '0' .. '9' )+
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
            	    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:474:44: '0' .. '9'
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:477:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:478:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:478:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='\n') ) {
                    alt9=1;
                }
                else {
                    alt9=2;}
            }
            else if ( (LA9_0=='\n') ) {
                alt9=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("478:2: ( '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:478:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:478:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:478:19: '\\n'
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
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:481:1: ( ( ' ' | '\\t' | '\\f' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:482:2: ( ' ' | '\\t' | '\\f' )
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

    public void mTokens() throws RecognitionException {
        // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:8: ( T9 | COMMENT | INTEGER | FLOAT | LB | WS )
        int alt10=6;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:10: T9
                {
                mT9(); 

                }
                break;
            case 2 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:13: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 3 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:21: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 4 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:29: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 5 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:35: LB
                {
                mLB(); 

                }
                break;
            case 6 :
                // C:\\work\\reusewareSvn\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:38: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\4\uffff\2\12\3\uffff\1\12\1\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\1\11\2\uffff\1\60\2\56\3\uffff\1\56\1\uffff";
    static final String DFA10_maxS =
        "\1\120\2\uffff\2\71\1\56\3\uffff\1\71\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\5\1\6\1\4\1\uffff\1\3";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\7\1\6\1\uffff\1\7\1\6\22\uffff\1\7\14\uffff\1\3\1\uffff"+
            "\1\2\1\5\11\4\26\uffff\1\1",
            "",
            "",
            "\1\10\11\4",
            "\1\10\1\uffff\12\11",
            "\1\10",
            "",
            "",
            "",
            "\1\10\1\uffff\12\11",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T9 | COMMENT | INTEGER | FLOAT | LB | WS );";
        }
    }
 

}