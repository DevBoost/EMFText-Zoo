// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g 2008-11-18 18:31:07

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
    public static final int Tokens=39;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int WS=10;
    public static final int LB=9;
    public static final int T38=38;
    public static final int T11=11;
    public static final int T37=37;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T34=34;
    public static final int COMMENT=7;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T36=36;
    public static final int T17=17;
    public static final int T35=35;
    public static final int QUOTED_34_34=4;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:20:5: ( ':' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:20:7: ':'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:21:5: ( 'root' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:21:7: 'root'
            {
            match("root"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:22:5: ( 'name' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:22:7: 'name'
            {
            match("name"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:23:5: ( 'children' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:23:7: 'children'
            {
            match("children"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:24:5: ( 'parent' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:24:7: 'parent'
            {
            match("parent"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:25:5: ( '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:25:7: '}'
            {
            match('}'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:26:5: ( 'Feature' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:26:7: 'Feature'
            {
            match("Feature"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:27:5: ( 'minCardinality' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:27:7: 'minCardinality'
            {
            match("minCardinality"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:28:5: ( 'maxCardinality' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:28:7: 'maxCardinality'
            {
            match("maxCardinality"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:29:5: ( 'attributes' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:29:7: 'attributes'
            {
            match("attributes"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:30:5: ( 'groups' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:30:7: 'groups'
            {
            match("groups"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:31:5: ( 'parentGroup' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:31:7: 'parentGroup'
            {
            match("parentGroup"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:32:5: ( 'annotations' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:32:7: 'annotations'
            {
            match("annotations"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:34:5: ( 'parentFeature' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:34:7: 'parentFeature'
            {
            match("parentFeature"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:35:5: ( 'childFeatures' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:35:7: 'childFeatures'
            {
            match("childFeatures"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:36:5: ( 'Constraint' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:36:7: 'Constraint'
            {
            match("Constraint"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:37:5: ( 'language' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:37:7: 'language'
            {
            match("language"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:38:5: ( 'expression' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:38:7: 'expression'
            {
            match("expression"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:39:5: ( 'constrainedFeatures' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:39:7: 'constrainedFeatures'
            {
            match("constrainedFeatures"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:40:5: ( 'Attribute' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:40:7: 'Attribute'
            {
            match("Attribute"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:41:5: ( 'feature' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:41:7: 'feature'
            {
            match("feature"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:42:5: ( 'type' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:42:7: 'type'
            {
            match("type"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:43:5: ( 'value' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:43:7: 'value'
            {
            match("value"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:44:5: ( 'Annotation' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:44:7: 'Annotation'
            {
            match("Annotation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:259:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:260:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:260:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:260:7: ~ ( '\\n' | '\\r' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:263:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("262:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:8: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:19: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:264:30: '0'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:267:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("268:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:9: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:21: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:43: ( '0' .. '9' )+
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:268:44: '0' .. '9'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:271:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:272:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:272:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    new NoViableAltException("272:2: ( '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:272:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:272:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:272:19: '\\n'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:275:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:276:2: ( ' ' | '\\t' | '\\f' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:279:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:280:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:280:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:283:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:2: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:3: '\"'
            {
            match('\"'); 

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:8: ~ ( '\"' )
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:15: ( '\\\\' '\"' )
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:16: '\\\\' '\"'
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

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:26: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:284:27: '\"'
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
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 )
        int alt12=35;
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
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:122: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 30 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:130: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 31 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:138: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 32 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:144: LB
                {
                mLB(); 

                }
                break;
            case 33 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:147: WS
                {
                mWS(); 

                }
                break;
            case 34 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:150: TEXT
                {
                mTEXT(); 

                }
                break;
            case 35 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.featuremapper.models.feature.resource.feature\\src\\org\\featuremapper\\models\\feature\\resource\\feature\\Feature.g:1:155: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\32\1\uffff\1\32\1\uffff\3\32\1\uffff\13\32\1\uffff\1"+
        "\32\2\63\4\uffff\25\32\1\63\2\uffff\27\32\1\137\1\140\15\32\1\156"+
        "\4\32\2\uffff\6\32\1\172\6\32\1\uffff\1\u0081\4\32\1\u0088\4\32"+
        "\1\u008d\1\uffff\6\32\1\uffff\1\u0095\5\32\1\uffff\4\32\1\uffff"+
        "\5\32\1\u00a4\1\32\1\uffff\2\32\1\u00a8\7\32\1\u00b0\3\32\1\uffff"+
        "\3\32\1\uffff\7\32\1\uffff\2\32\1\u00c1\10\32\1\u00ca\1\32\1\u00cc"+
        "\1\u00cd\1\u00ce\1\uffff\2\32\1\u00d1\2\32\1\u00d4\2\32\1\uffff"+
        "\1\u00d7\3\uffff\1\u00d8\1\32\1\uffff\2\32\1\uffff\2\32\2\uffff"+
        "\1\32\1\u00df\1\u00e0\3\32\2\uffff\1\u00e4\1\u00e5\1\32\2\uffff"+
        "\3\32\1\u00ea\1\uffff";
    static final String DFA12_eofS =
        "\u00eb\uffff";
    static final String DFA12_minS =
        "\1\11\1\145\1\uffff\1\150\1\uffff\1\157\2\141\1\uffff\1\141\1\156"+
        "\2\162\1\157\1\141\1\170\1\156\1\145\1\171\1\141\1\uffff\1\60\2"+
        "\55\4\uffff\1\141\1\156\1\151\1\157\1\155\1\162\1\156\1\170\1\164"+
        "\1\156\2\157\2\156\1\160\1\156\1\164\1\141\1\160\1\154\1\56\1\55"+
        "\2\uffff\1\164\1\163\1\154\1\164\2\145\2\103\1\162\1\157\2\165\1"+
        "\163\1\147\1\162\1\157\1\162\1\164\1\145\2\165\1\164\1\144\2\55"+
        "\1\156\2\141\1\151\1\164\2\160\1\164\1\165\1\145\1\164\1\151\1\165"+
        "\1\55\1\145\2\162\1\106\2\uffff\1\164\2\162\1\142\1\141\1\163\1"+
        "\55\1\162\1\141\1\163\1\141\1\142\1\162\1\uffff\1\55\1\145\1\141"+
        "\2\145\1\55\2\144\1\165\1\164\1\55\1\uffff\1\141\1\147\1\163\1\164"+
        "\1\165\1\145\1\uffff\1\55\1\151\1\141\1\156\1\145\1\162\1\uffff"+
        "\2\151\1\164\1\151\1\uffff\1\151\1\145\2\151\1\164\1\55\1\157\1"+
        "\uffff\1\156\1\164\1\55\1\141\1\157\2\156\1\145\1\157\1\156\1\55"+
        "\2\157\1\145\1\uffff\1\144\1\145\1\165\1\uffff\1\164\1\165\2\141"+
        "\1\163\1\156\1\164\1\uffff\2\156\1\55\1\145\1\144\1\163\1\162\1"+
        "\165\1\160\2\154\1\55\1\163\3\55\1\uffff\1\154\1\106\1\55\1\145"+
        "\1\162\1\55\2\151\1\uffff\1\55\3\uffff\1\55\1\145\1\uffff\1\163"+
        "\1\145\1\uffff\2\164\2\uffff\1\141\2\55\2\171\1\164\2\uffff\2\55"+
        "\1\165\2\uffff\1\162\1\145\1\163\1\55\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\145\1\uffff\1\157\1\uffff\1\157\2\141\1\uffff\1\151\1"+
        "\164\2\162\1\157\1\141\1\170\1\164\1\145\1\171\1\141\1\uffff\1\71"+
        "\2\172\4\uffff\1\141\1\156\1\151\1\157\1\155\1\162\1\156\1\170\1"+
        "\164\1\156\2\157\2\156\1\160\1\156\1\164\1\141\1\160\1\154\1\56"+
        "\1\172\2\uffff\1\164\1\163\1\154\1\164\2\145\2\103\1\162\1\157\2"+
        "\165\1\163\1\147\1\162\1\157\1\162\1\164\1\145\2\165\1\164\1\144"+
        "\2\172\1\156\2\141\1\151\1\164\2\160\1\164\1\165\1\145\1\164\1\151"+
        "\1\165\1\172\1\145\3\162\2\uffff\1\164\2\162\1\142\1\141\1\163\1"+
        "\172\1\162\1\141\1\163\1\141\1\142\1\162\1\uffff\1\172\1\145\1\141"+
        "\2\145\1\172\2\144\1\165\1\164\1\172\1\uffff\1\141\1\147\1\163\1"+
        "\164\1\165\1\145\1\uffff\1\172\1\151\1\141\1\156\1\145\1\162\1\uffff"+
        "\2\151\1\164\1\151\1\uffff\1\151\1\145\2\151\1\164\1\172\1\157\1"+
        "\uffff\1\156\1\164\1\172\1\141\1\157\2\156\1\145\1\157\1\156\1\172"+
        "\2\157\1\145\1\uffff\1\144\1\164\1\165\1\uffff\1\164\1\165\2\141"+
        "\1\163\1\156\1\164\1\uffff\2\156\1\172\1\145\1\144\1\163\1\162\1"+
        "\165\1\160\2\154\1\172\1\163\3\172\1\uffff\1\154\1\106\1\172\1\145"+
        "\1\162\1\172\2\151\1\uffff\1\172\3\uffff\1\172\1\145\1\uffff\1\163"+
        "\1\145\1\uffff\2\164\2\uffff\1\141\2\172\2\171\1\164\2\uffff\2\172"+
        "\1\165\2\uffff\1\162\1\145\1\163\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\3\uffff\1\11\13\uffff\1\35\3\uffff\1\40"+
        "\1\41\1\42\1\43\26\uffff\1\37\1\36\53\uffff\1\5\1\6\15\uffff\1\32"+
        "\13\uffff\1\21\6\uffff\1\33\6\uffff\1\10\4\uffff\1\16\7\uffff\1"+
        "\12\16\uffff\1\31\3\uffff\1\7\7\uffff\1\25\20\uffff\1\30\10\uffff"+
        "\1\15\1\uffff\1\24\1\26\1\34\2\uffff\1\3\2\uffff\1\17\2\uffff\1"+
        "\20\1\1\6\uffff\1\23\1\22\3\uffff\1\13\1\14\4\uffff\1\27";
    static final String DFA12_specialS =
        "\u00eb\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\31\1\30\1\uffff\1\31\1\30\22\uffff\1\31\1\uffff\1\33\12"+
            "\uffff\1\25\1\uffff\1\24\1\27\11\26\1\4\6\uffff\1\20\1\32\1"+
            "\15\2\32\1\1\1\14\23\32\4\uffff\1\32\1\uffff\1\12\1\32\1\3\1"+
            "\32\1\17\1\21\1\13\4\32\1\16\1\11\1\6\1\32\1\7\1\32\1\5\1\32"+
            "\1\22\1\32\1\23\4\32\1\2\1\uffff\1\10",
            "\1\34",
            "",
            "\1\36\6\uffff\1\35",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "",
            "\1\43\7\uffff\1\42",
            "\1\45\5\uffff\1\44",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53\5\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "\1\60\11\26",
            "\1\32\1\62\1\uffff\12\61\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\32\1\62\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\62",
            "\1\32\1\62\1\uffff\12\61\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162\53\uffff\1\163",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\32\2\uffff\12\32\7\uffff\5\32\1\u0086\1\u0087\23\32\4\uffff"+
            "\1\32\1\uffff\32\32",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "",
            "\1\32\2\uffff\12\32\7\uffff\14\32\1\u0094\15\32\4\uffff\1"+
            "\32\1\uffff\32\32",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "\1\u00b5\16\uffff\1\u00b6",
            "\1\u00b7",
            "",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00cb",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00d2",
            "\1\u00d3",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00d5",
            "\1\u00d6",
            "",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "",
            "",
            "",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "",
            "",
            "\1\u00de",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
            "\1\u00e6",
            "",
            "",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\32\2\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32"+
            "\32",
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
            return "1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 );";
        }
    }
 

}