// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g 2008-11-18 19:13:52

package org.featuremapper.models.feature.resource.feature;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FeatureLexer extends Lexer {
    public static final int INTEGER=6;
    public static final int T29=29;
    public static final int FLOAT=8;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int TEXT=5;
    public static final int T25=25;
    public static final int Tokens=30;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int WS=10;
    public static final int LB=9;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int COMMENT=7;
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

    public FeatureLexer() {;} 
    public FeatureLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:17:5: ( 'FeatureModel' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:17:7: 'FeatureModel'
            {
            match("FeatureModel"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:18:5: ( '{' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:18:7: '{'
            {
            match('{'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:19:5: ( 'constraints' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:19:7: 'constraints'
            {
            match("constraints"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:20:5: ( ';' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:20:7: ';'
            {
            match(';'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:21:5: ( '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:21:7: '}'
            {
            match('}'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:22:5: ( 'Constraint' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:22:7: 'Constraint'
            {
            match("Constraint"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:23:5: ( '(' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:23:7: '('
            {
            match('('); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:24:5: ( ',' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:24:7: ','
            {
            match(','); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:25:5: ( ')' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:25:7: ')'
            {
            match(')'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:26:5: ( ':' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:26:7: ':'
            {
            match(':'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:27:5: ( 'Feature' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:27:7: 'Feature'
            {
            match("Feature"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:28:5: ( '..' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:28:7: '..'
            {
            match(".."); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:29:5: ( '/*' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:29:7: '/*'
            {
            match("/*"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:30:5: ( '*/' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:30:7: '*/'
            {
            match("*/"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:31:5: ( '[' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:31:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:32:5: ( ']' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:32:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:33:5: ( 'Group' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:33:7: 'Group'
            {
            match("Group"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:34:5: ( 'type' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:34:7: 'type'
            {
            match("type"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:35:5: ( '=' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:35:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:189:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:190:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:190:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:190:7: ~ ( '\\n' | '\\r' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:193:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("192:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:8: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:19: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:194:30: '0'
                    {
                    match('0'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:197:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("198:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:9: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:21: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:43: ( '0' .. '9' )+
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:198:44: '0' .. '9'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:201:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:202:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:202:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    new NoViableAltException("202:2: ( '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:202:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:202:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:202:19: '\\n'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:205:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:206:2: ( ' ' | '\\t' | '\\f' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:209:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:210:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:210:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='-'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:213:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:2: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:3: '\"'
            {
            match('\"'); 

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='\"') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='\uFFFE')) ) {
                            alt11=2;
                        }

                        else {
                            alt11=1;
                        }

                    }
                    else if ( ((LA11_2>='\u0000' && LA11_2<='!')||(LA11_2>='#' && LA11_2<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:8: ~ ( '\"' )
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:15: ( '\\\\' '\"' )
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:16: '\\\\' '\"'
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

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:26: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:214:27: '\"'
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
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 )
        int alt12=26;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:86: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 21 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:94: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 22 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:102: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 23 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:108: LB
                {
                mLB(); 

                }
                break;
            case 24 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:111: WS
                {
                mWS(); 

                }
                break;
            case 25 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:114: TEXT
                {
                mTEXT(); 

                }
                break;
            case 26 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:119: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\30\1\uffff\1\30\2\uffff\1\30\11\uffff\2\30\1\uffff\1"+
        "\30\2\44\4\uffff\3\30\2\uffff\3\30\1\44\2\uffff\11\30\1\63\3\30"+
        "\1\67\1\uffff\3\30\1\uffff\1\74\3\30\1\uffff\7\30\1\107\1\30\1\111"+
        "\1\uffff\1\112\2\uffff";
    static final String DFA12_eofS =
        "\113\uffff";
    static final String DFA12_minS =
        "\1\11\1\145\1\uffff\1\157\2\uffff\1\157\5\uffff\1\52\3\uffff\1"+
        "\162\1\171\1\uffff\1\60\2\55\4\uffff\1\141\2\156\2\uffff\1\157\1"+
        "\160\1\56\1\55\2\uffff\1\164\2\163\1\165\1\145\1\165\2\164\1\160"+
        "\1\55\3\162\1\55\1\uffff\1\145\2\141\1\uffff\1\55\2\151\1\157\1"+
        "\uffff\2\156\1\144\2\164\1\145\1\163\1\55\1\154\1\55\1\uffff\1\55"+
        "\2\uffff";
    static final String DFA12_maxS =
        "\1\175\1\145\1\uffff\1\157\2\uffff\1\157\5\uffff\1\57\3\uffff\1"+
        "\162\1\171\1\uffff\1\71\2\172\4\uffff\1\141\2\156\2\uffff\1\157"+
        "\1\160\1\56\1\172\2\uffff\1\164\2\163\1\165\1\145\1\165\2\164\1"+
        "\160\1\172\3\162\1\172\1\uffff\1\145\2\141\1\uffff\1\172\2\151\1"+
        "\157\1\uffff\2\156\1\144\2\164\1\145\1\163\1\172\1\154\1\172\1\uffff"+
        "\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1\14\1"+
        "\uffff\1\16\1\17\1\20\2\uffff\1\23\3\uffff\1\27\1\30\1\31\1\32\3"+
        "\uffff\1\15\1\24\4\uffff\1\26\1\25\16\uffff\1\22\3\uffff\1\21\4"+
        "\uffff\1\13\12\uffff\1\6\1\uffff\1\3\1\1";
    static final String DFA12_specialS =
        "\113\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\27\1\26\1\uffff\1\27\1\26\22\uffff\1\27\1\uffff\1\31\5\uffff"+
            "\1\7\1\11\1\15\1\uffff\1\10\1\23\1\13\1\14\1\25\11\24\1\12\1"+
            "\4\1\uffff\1\22\3\uffff\2\30\1\6\2\30\1\1\1\20\23\30\1\16\1"+
            "\uffff\1\17\1\uffff\1\30\1\uffff\2\30\1\3\20\30\1\21\6\30\1"+
            "\2\1\uffff\1\5",
            "\1\32",
            "",
            "\1\33",
            "",
            "",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "\1\35\4\uffff\1\36",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "",
            "\1\41\11\24",
            "\1\30\1\43\1\uffff\12\42\7\uffff\32\30\4\uffff\1\30\1\uffff"+
            "\32\30",
            "\1\30\1\43\1\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff"+
            "\32\30",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\43",
            "\1\30\1\43\1\uffff\12\42\7\uffff\32\30\4\uffff\1\30\1\uffff"+
            "\32\30",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\30\2\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\30\2\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "\1\30\2\uffff\12\30\7\uffff\14\30\1\73\15\30\4\uffff\1\30"+
            "\1\uffff\32\30",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\30\2\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\110",
            "\1\30\2\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "",
            "\1\30\2\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
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
            return "1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 );";
        }
    }
 

}