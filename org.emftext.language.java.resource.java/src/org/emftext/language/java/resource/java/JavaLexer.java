// $ANTLR 3.0.1 /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g 2008-12-08 09:47:04

package org.emftext.language.java.resource.java;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JavaLexer extends Lexer {
    public static final int T29=29;
    public static final int T70=70;
    public static final int T74=74;
    public static final int BOOLEAN_LITERAL=13;
    public static final int T85=85;
    public static final int T20=20;
    public static final int T18=18;
    public static final int STRING_LITERAL=12;
    public static final int T32=32;
    public static final int ADDITIVE_OPERATOR_LITERAL=5;
    public static final int T81=81;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T62=62;
    public static final int DECIMAL_LITERAL=7;
    public static final int T68=68;
    public static final int T73=73;
    public static final int T84=84;
    public static final int T33=33;
    public static final int T78=78;
    public static final int WS=16;
    public static final int T42=42;
    public static final int T71=71;
    public static final int T72=72;
    public static final int T94=94;
    public static final int FLOATING_POINT_LITERAL=10;
    public static final int T76=76;
    public static final int T75=75;
    public static final int T89=89;
    public static final int LB=17;
    public static final int T67=67;
    public static final int T31=31;
    public static final int T60=60;
    public static final int T82=82;
    public static final int T49=49;
    public static final int IDENTIFIER=4;
    public static final int T30=30;
    public static final int CHARACTER_LITERAL=11;
    public static final int T79=79;
    public static final int T36=36;
    public static final int T58=58;
    public static final int T93=93;
    public static final int T35=35;
    public static final int OCTAL_LITERAL=9;
    public static final int T83=83;
    public static final int T61=61;
    public static final int HEX_LITERAL=8;
    public static final int T45=45;
    public static final int T34=34;
    public static final int T64=64;
    public static final int T25=25;
    public static final int T91=91;
    public static final int T37=37;
    public static final int T86=86;
    public static final int T26=26;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T77=77;
    public static final int ML_COMMENT=15;
    public static final int T38=38;
    public static final int SL_COMMENT=14;
    public static final int T69=69;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int T55=55;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T92=92;
    public static final int T43=43;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T66=66;
    public static final int T88=88;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T65=65;
    public static final int T56=56;
    public static final int T87=87;
    public static final int T80=80;
    public static final int T59=59;
    public static final int MULTIPLICATIVE_OPERATOR_LITERAL=6;
    public static final int T48=48;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=95;
    public static final int T53=53;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T90=90;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public JavaLexer() {;} 
    public JavaLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g"; }

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:17:5: ( 'package' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:17:7: 'package'
            {
            match("package"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:18:5: ( '.' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:18:7: '.'
            {
            match('.'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:19:5: ( ';' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:19:7: ';'
            {
            match(';'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:20:5: ( 'import' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:20:7: 'import'
            {
            match("import"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:21:5: ( 'class' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:21:7: 'class'
            {
            match("class"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:22:5: ( '<' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:22:7: '<'
            {
            match('<'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:23:5: ( ',' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:23:7: ','
            {
            match(','); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:24:5: ( '>' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:24:7: '>'
            {
            match('>'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:25:5: ( 'extends' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:25:7: 'extends'
            {
            match("extends"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:26:5: ( 'implements' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:26:7: 'implements'
            {
            match("implements"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:27:5: ( '{' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:27:7: '{'
            {
            match('{'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:28:5: ( '}' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:28:7: '}'
            {
            match('}'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:29:5: ( 'interface' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:29:7: 'interface'
            {
            match("interface"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:30:5: ( '@' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:30:7: '@'
            {
            match('@'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:31:5: ( '(' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:31:7: '('
            {
            match('('); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:32:5: ( ')' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:32:7: ')'
            {
            match(')'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:33:5: ( '=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:33:7: '='
            {
            match('='); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:34:5: ( 'enum' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:34:7: 'enum'
            {
            match("enum"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:35:5: ( '&' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:35:7: '&'
            {
            match('&'); 

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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:36:5: ( 'throws' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:36:7: 'throws'
            {
            match("throws"); 


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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:37:5: ( 'default' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:37:7: 'default'
            {
            match("default"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:38:5: ( '...' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:38:7: '...'
            {
            match("..."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:39:5: ( 'new' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:39:7: 'new'
            {
            match("new"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:40:5: ( '[' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:40:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:41:5: ( ']' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:41:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:42:5: ( '?' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:42:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:43:5: ( 'super' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:43:7: 'super'
            {
            match("super"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:44:5: ( 'assert' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:44:7: 'assert'
            {
            match("assert"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:45:5: ( ':' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:45:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:46:5: ( 'if' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:46:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:47:5: ( 'else' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:47:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:48:5: ( 'for' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:48:7: 'for'
            {
            match("for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:49:5: ( 'while' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:49:7: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:50:5: ( 'do' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:50:7: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:51:5: ( 'synchronized' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:51:7: 'synchronized'
            {
            match("synchronized"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:52:5: ( 'try' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:52:7: 'try'
            {
            match("try"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:53:5: ( 'finally' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:53:7: 'finally'
            {
            match("finally"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:54:5: ( 'catch' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:54:7: 'catch'
            {
            match("catch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:55:5: ( 'switch' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:55:7: 'switch'
            {
            match("switch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:56:5: ( 'case' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:56:7: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:57:5: ( 'return' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:57:7: 'return'
            {
            match("return"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:58:5: ( 'throw' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:58:7: 'throw'
            {
            match("throw"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:59:5: ( 'break' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:59:7: 'break'
            {
            match("break"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:60:5: ( 'continue' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:60:7: 'continue'
            {
            match("continue"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:61:5: ( '++' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:61:7: '++'
            {
            match("++"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:62:5: ( '--' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:62:7: '--'
            {
            match("--"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:63:5: ( '~' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:63:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:64:5: ( '!' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:64:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:65:5: ( '+=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:65:7: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:66:5: ( '-=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:66:7: '-='
            {
            match("-="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:67:5: ( '*=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:67:7: '*='
            {
            match("*="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:68:5: ( '/=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:68:7: '/='
            {
            match("/="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:69:5: ( '&=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:69:7: '&='
            {
            match("&="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:70:5: ( '|=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:70:7: '|='
            {
            match("|="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:71:5: ( '^=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:71:7: '^='
            {
            match("^="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:72:5: ( '%=' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:72:7: '%='
            {
            match("%="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:73:5: ( 'null' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:73:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:74:5: ( 'void' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:74:7: 'void'
            {
            match("void"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:75:5: ( 'this' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:75:7: 'this'
            {
            match("this"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:76:5: ( 'public' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:76:7: 'public'
            {
            match("public"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:77:5: ( 'abstract' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:77:7: 'abstract'
            {
            match("abstract"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:78:5: ( 'protected' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:78:7: 'protected'
            {
            match("protected"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:79:5: ( 'private' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:79:7: 'private'
            {
            match("private"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:80:5: ( 'final' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:80:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start T82
    public final void mT82() throws RecognitionException {
        try {
            int _type = T82;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:81:5: ( 'static' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:81:7: 'static'
            {
            match("static"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start T83
    public final void mT83() throws RecognitionException {
        try {
            int _type = T83;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:82:5: ( 'native' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:82:7: 'native'
            {
            match("native"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T83

    // $ANTLR start T84
    public final void mT84() throws RecognitionException {
        try {
            int _type = T84;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:83:5: ( 'transient' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:83:7: 'transient'
            {
            match("transient"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T84

    // $ANTLR start T85
    public final void mT85() throws RecognitionException {
        try {
            int _type = T85;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:84:5: ( 'volatile' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:84:7: 'volatile'
            {
            match("volatile"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start T86
    public final void mT86() throws RecognitionException {
        try {
            int _type = T86;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:85:5: ( 'strictfp' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:85:7: 'strictfp'
            {
            match("strictfp"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T86

    // $ANTLR start T87
    public final void mT87() throws RecognitionException {
        try {
            int _type = T87;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:86:5: ( 'boolean' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:86:7: 'boolean'
            {
            match("boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T87

    // $ANTLR start T88
    public final void mT88() throws RecognitionException {
        try {
            int _type = T88;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:87:5: ( 'char' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:87:7: 'char'
            {
            match("char"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T88

    // $ANTLR start T89
    public final void mT89() throws RecognitionException {
        try {
            int _type = T89;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:88:5: ( 'byte' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:88:7: 'byte'
            {
            match("byte"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T89

    // $ANTLR start T90
    public final void mT90() throws RecognitionException {
        try {
            int _type = T90;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:89:5: ( 'short' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:89:7: 'short'
            {
            match("short"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T90

    // $ANTLR start T91
    public final void mT91() throws RecognitionException {
        try {
            int _type = T91;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:90:5: ( 'int' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:90:7: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T91

    // $ANTLR start T92
    public final void mT92() throws RecognitionException {
        try {
            int _type = T92;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:91:5: ( 'long' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:91:7: 'long'
            {
            match("long"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T92

    // $ANTLR start T93
    public final void mT93() throws RecognitionException {
        try {
            int _type = T93;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:92:5: ( 'float' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:92:7: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T93

    // $ANTLR start T94
    public final void mT94() throws RecognitionException {
        try {
            int _type = T94;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:93:5: ( 'double' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:93:7: 'double'
            {
            match("double"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2517:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2518:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2518:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2518:7: ~ ( '\\n' | '\\r' )
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
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2521:1: ( '/*' ( . )* '*/' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2522:2: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2522:6: ( . )*
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
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2522:6: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start FLOATING_POINT_LITERAL
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2525:1: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? | ( '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? ) | ( ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) ( ( 'f' | 'F' | 'd' | 'D' ) )? ) | ( ( '0' .. '9' )+ ( ( 'f' | 'F' | 'd' | 'D' ) ) ) )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:2: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:2: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:3: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    match('.'); 
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:18: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:30: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:31: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:41: ( '+' | '-' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0=='+'||LA5_0=='-') ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse =
                                            new MismatchedSetException(null,input);
                                        recover(mse);    throw mse;
                                    }


                                    }
                                    break;

                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:52: ( '0' .. '9' )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:53: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

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
                            break;

                    }

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:66: ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='D'||LA8_0=='F'||LA8_0=='d'||LA8_0=='f') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:67: ( 'f' | 'F' | 'd' | 'D' )
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:91: ( '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:91: ( '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:92: '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    {
                    match('.'); 
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:96: ( '0' .. '9' )+
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
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:97: '0' .. '9'
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

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:108: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:109: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:119: ( '+' | '-' )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='+'||LA10_0=='-') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse =
                                            new MismatchedSetException(null,input);
                                        recover(mse);    throw mse;
                                    }


                                    }
                                    break;

                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:130: ( '0' .. '9' )+
                            int cnt11=0;
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:131: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

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
                            break;

                    }

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:144: ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='D'||LA13_0=='F'||LA13_0=='d'||LA13_0=='f') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:145: ( 'f' | 'F' | 'd' | 'D' )
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:170: ( ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) ( ( 'f' | 'F' | 'd' | 'D' ) )? )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:170: ( ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) ( ( 'f' | 'F' | 'd' | 'D' ) )? )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:171: ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:171: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:172: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:183: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:184: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:194: ( '+' | '-' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='+'||LA15_0=='-') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:205: ( '0' .. '9' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:206: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:218: ( ( 'f' | 'F' | 'd' | 'D' ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='D'||LA17_0=='F'||LA17_0=='d'||LA17_0=='f') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:219: ( 'f' | 'F' | 'd' | 'D' )
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:244: ( ( '0' .. '9' )+ ( ( 'f' | 'F' | 'd' | 'D' ) ) )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:244: ( ( '0' .. '9' )+ ( ( 'f' | 'F' | 'd' | 'D' ) ) )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:245: ( '0' .. '9' )+ ( ( 'f' | 'F' | 'd' | 'D' ) )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:245: ( '0' .. '9' )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:246: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:257: ( ( 'f' | 'F' | 'd' | 'D' ) )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2526:258: ( 'f' | 'F' | 'd' | 'D' )
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }


                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOATING_POINT_LITERAL

    // $ANTLR start HEX_LITERAL
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            int _type = HEX_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2529:1: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ( 'l' | 'L' )? )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2530:2: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ( 'l' | 'L' )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2530:14: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='F')||(LA20_0>='a' && LA20_0<='f')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2530:43: ( 'l' | 'L' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='L'||LA21_0=='l') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HEX_LITERAL

    // $ANTLR start DECIMAL_LITERAL
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2533:1: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( 'l' | 'L' )? )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:2: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( 'l' | 'L' )?
            {
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:2: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='0') ) {
                alt23=1;
            }
            else if ( ((LA23_0>='1' && LA23_0<='9')) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2534:2: ( '0' | '1' .. '9' ( '0' .. '9' )* )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:3: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:7: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:15: ( '0' .. '9' )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:15: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2534:25: ( 'l' | 'L' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='L'||LA24_0=='l') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DECIMAL_LITERAL

    // $ANTLR start OCTAL_LITERAL
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = OCTAL_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2537:1: ( '0' ( '0' .. '7' )+ ( 'l' | 'L' )? )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2538:2: '0' ( '0' .. '7' )+ ( 'l' | 'L' )?
            {
            match('0'); 
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2538:5: ( '0' .. '7' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='7')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2538:6: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2538:16: ( 'l' | 'L' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='L'||LA26_0=='l') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OCTAL_LITERAL

    // $ANTLR start BOOLEAN_LITERAL
    public final void mBOOLEAN_LITERAL() throws RecognitionException {
        try {
            int _type = BOOLEAN_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2541:1: ( 'true' | 'false' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='t') ) {
                alt27=1;
            }
            else if ( (LA27_0=='f') ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2540:1: BOOLEAN_LITERAL : ( 'true' | 'false' );", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2542:2: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2542:9: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOLEAN_LITERAL

    // $ANTLR start ADDITIVE_OPERATOR_LITERAL
    public final void mADDITIVE_OPERATOR_LITERAL() throws RecognitionException {
        try {
            int _type = ADDITIVE_OPERATOR_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2545:1: ( '+' | '-' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ADDITIVE_OPERATOR_LITERAL

    // $ANTLR start MULTIPLICATIVE_OPERATOR_LITERAL
    public final void mMULTIPLICATIVE_OPERATOR_LITERAL() throws RecognitionException {
        try {
            int _type = MULTIPLICATIVE_OPERATOR_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2549:1: ( '*' | '/' | '%' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
            {
            if ( input.LA(1)=='%'||input.LA(1)=='*'||input.LA(1)=='/' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MULTIPLICATIVE_OPERATOR_LITERAL

    // $ANTLR start CHARACTER_LITERAL
    public final void mCHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = CHARACTER_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2553:1: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ) | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:2: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ) | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ) | ~ ( '\\'' | '\\\\' ) )
            int alt29=4;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt29=1;
                    }
                    break;
                case 'u':
                    {
                    alt29=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt29=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("2554:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ) | ~ ( '\\'' | '\\\\' ) )", 29, 1, input);

                    throw nvae;
                }

            }
            else if ( ((LA29_0>='\u0000' && LA29_0<='&')||(LA29_0>='(' && LA29_0<='[')||(LA29_0>=']' && LA29_0<='\uFFFE')) ) {
                alt29=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2554:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ) | ~ ( '\\'' | '\\\\' ) )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:49: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    {
                    match('\\'); 
                    match('u'); 
                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }


                    }
                    break;
                case 3 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
                    {
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
                    int alt28=3;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='\\') ) {
                        int LA28_1 = input.LA(2);

                        if ( ((LA28_1>='0' && LA28_1<='3')) ) {
                            int LA28_2 = input.LA(3);

                            if ( (LA28_2=='\'') ) {
                                alt28=3;
                            }
                            else if ( ((LA28_2>='0' && LA28_2<='7')) ) {
                                int LA28_5 = input.LA(4);

                                if ( (LA28_5=='\'') ) {
                                    alt28=2;
                                }
                                else if ( ((LA28_5>='0' && LA28_5<='7')) ) {
                                    alt28=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )", 28, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )", 28, 2, input);

                                throw nvae;
                            }
                        }
                        else if ( ((LA28_1>='4' && LA28_1<='7')) ) {
                            int LA28_3 = input.LA(3);

                            if ( (LA28_3=='\'') ) {
                                alt28=3;
                            }
                            else if ( ((LA28_3>='0' && LA28_3<='7')) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )", 28, 3, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )", 28, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("2554:170: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:171: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                            {
                            match('\\'); 
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:175: ( '0' .. '3' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:176: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:185: ( '0' .. '7' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:186: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:195: ( '0' .. '7' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:196: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }


                            }
                            break;
                        case 2 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:206: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                            {
                            match('\\'); 
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:210: ( '0' .. '7' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:211: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }

                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:220: ( '0' .. '7' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:221: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }


                            }
                            break;
                        case 3 :
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:231: '\\\\' ( '0' .. '7' )
                            {
                            match('\\'); 
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:235: ( '0' .. '7' )
                            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:236: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2554:247: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CHARACTER_LITERAL

    // $ANTLR start STRING_LITERAL
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2557:1: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:2: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )*
            loop30:
            do {
                int alt30=5;
                int LA30_0 = input.LA(1);

                if ( (LA30_0=='\\') ) {
                    switch ( input.LA(2) ) {
                    case 'u':
                        {
                        alt30=2;
                        }
                        break;
                    case '\"':
                    case '\'':
                    case '\\':
                    case 'b':
                    case 'f':
                    case 'n':
                    case 'r':
                    case 't':
                        {
                        alt30=1;
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        {
                        alt30=3;
                        }
                        break;

                    }

                }
                else if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFE')) ) {
                    alt30=4;
                }


                switch (alt30) {
            	case 1 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:6: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:47: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:47: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:48: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    match('\\'); 
            	    match('u'); 
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:169: '\\\\' ( '0' .. '7' )
            	    {
            	    match('\\'); 
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:173: ( '0' .. '7' )
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:174: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }


            	    }
            	    break;
            	case 4 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2558:184: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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
            	    break loop30;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING_LITERAL

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2561:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2562:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            {
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2562:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>='0' && LA31_0<='9')||(LA31_0>='A' && LA31_0<='Z')||LA31_0=='_'||(LA31_0>='a' && LA31_0<='z')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2565:1: ( ( ' ' | '\\t' | '\\f' ) )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2566:2: ( ' ' | '\\t' | '\\f' )
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

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2569:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2570:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2570:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\r') ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1=='\n') ) {
                    alt32=1;
                }
                else {
                    alt32=2;}
            }
            else if ( (LA32_0=='\n') ) {
                alt32=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2570:2: ( '\\r\\n' | '\\r' | '\\n' )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2570:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2570:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:2570:19: '\\n'
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

    public void mTokens() throws RecognitionException {
        // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:8: ( T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | SL_COMMENT | ML_COMMENT | FLOATING_POINT_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | BOOLEAN_LITERAL | ADDITIVE_OPERATOR_LITERAL | MULTIPLICATIVE_OPERATOR_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENTIFIER | WS | LB )
        int alt33=91;
        alt33 = dfa33.predict(input);
        switch (alt33) {
            case 1 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:10: T18
                {
                mT18(); 

                }
                break;
            case 2 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:14: T19
                {
                mT19(); 

                }
                break;
            case 3 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:18: T20
                {
                mT20(); 

                }
                break;
            case 4 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:22: T21
                {
                mT21(); 

                }
                break;
            case 5 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:26: T22
                {
                mT22(); 

                }
                break;
            case 6 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:30: T23
                {
                mT23(); 

                }
                break;
            case 7 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:34: T24
                {
                mT24(); 

                }
                break;
            case 8 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:38: T25
                {
                mT25(); 

                }
                break;
            case 9 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:42: T26
                {
                mT26(); 

                }
                break;
            case 10 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:46: T27
                {
                mT27(); 

                }
                break;
            case 11 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:50: T28
                {
                mT28(); 

                }
                break;
            case 12 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:54: T29
                {
                mT29(); 

                }
                break;
            case 13 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:58: T30
                {
                mT30(); 

                }
                break;
            case 14 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:62: T31
                {
                mT31(); 

                }
                break;
            case 15 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:66: T32
                {
                mT32(); 

                }
                break;
            case 16 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:70: T33
                {
                mT33(); 

                }
                break;
            case 17 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:74: T34
                {
                mT34(); 

                }
                break;
            case 18 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:78: T35
                {
                mT35(); 

                }
                break;
            case 19 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:82: T36
                {
                mT36(); 

                }
                break;
            case 20 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:86: T37
                {
                mT37(); 

                }
                break;
            case 21 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:90: T38
                {
                mT38(); 

                }
                break;
            case 22 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:94: T39
                {
                mT39(); 

                }
                break;
            case 23 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:98: T40
                {
                mT40(); 

                }
                break;
            case 24 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:102: T41
                {
                mT41(); 

                }
                break;
            case 25 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:106: T42
                {
                mT42(); 

                }
                break;
            case 26 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:110: T43
                {
                mT43(); 

                }
                break;
            case 27 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:114: T44
                {
                mT44(); 

                }
                break;
            case 28 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:118: T45
                {
                mT45(); 

                }
                break;
            case 29 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:122: T46
                {
                mT46(); 

                }
                break;
            case 30 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:126: T47
                {
                mT47(); 

                }
                break;
            case 31 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:130: T48
                {
                mT48(); 

                }
                break;
            case 32 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:134: T49
                {
                mT49(); 

                }
                break;
            case 33 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:138: T50
                {
                mT50(); 

                }
                break;
            case 34 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:142: T51
                {
                mT51(); 

                }
                break;
            case 35 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:146: T52
                {
                mT52(); 

                }
                break;
            case 36 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:150: T53
                {
                mT53(); 

                }
                break;
            case 37 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:154: T54
                {
                mT54(); 

                }
                break;
            case 38 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:158: T55
                {
                mT55(); 

                }
                break;
            case 39 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:162: T56
                {
                mT56(); 

                }
                break;
            case 40 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:166: T57
                {
                mT57(); 

                }
                break;
            case 41 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:170: T58
                {
                mT58(); 

                }
                break;
            case 42 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:174: T59
                {
                mT59(); 

                }
                break;
            case 43 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:178: T60
                {
                mT60(); 

                }
                break;
            case 44 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:182: T61
                {
                mT61(); 

                }
                break;
            case 45 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:186: T62
                {
                mT62(); 

                }
                break;
            case 46 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:190: T63
                {
                mT63(); 

                }
                break;
            case 47 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:194: T64
                {
                mT64(); 

                }
                break;
            case 48 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:198: T65
                {
                mT65(); 

                }
                break;
            case 49 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:202: T66
                {
                mT66(); 

                }
                break;
            case 50 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:206: T67
                {
                mT67(); 

                }
                break;
            case 51 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:210: T68
                {
                mT68(); 

                }
                break;
            case 52 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:214: T69
                {
                mT69(); 

                }
                break;
            case 53 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:218: T70
                {
                mT70(); 

                }
                break;
            case 54 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:222: T71
                {
                mT71(); 

                }
                break;
            case 55 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:226: T72
                {
                mT72(); 

                }
                break;
            case 56 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:230: T73
                {
                mT73(); 

                }
                break;
            case 57 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:234: T74
                {
                mT74(); 

                }
                break;
            case 58 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:238: T75
                {
                mT75(); 

                }
                break;
            case 59 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:242: T76
                {
                mT76(); 

                }
                break;
            case 60 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:246: T77
                {
                mT77(); 

                }
                break;
            case 61 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:250: T78
                {
                mT78(); 

                }
                break;
            case 62 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:254: T79
                {
                mT79(); 

                }
                break;
            case 63 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:258: T80
                {
                mT80(); 

                }
                break;
            case 64 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:262: T81
                {
                mT81(); 

                }
                break;
            case 65 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:266: T82
                {
                mT82(); 

                }
                break;
            case 66 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:270: T83
                {
                mT83(); 

                }
                break;
            case 67 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:274: T84
                {
                mT84(); 

                }
                break;
            case 68 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:278: T85
                {
                mT85(); 

                }
                break;
            case 69 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:282: T86
                {
                mT86(); 

                }
                break;
            case 70 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:286: T87
                {
                mT87(); 

                }
                break;
            case 71 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:290: T88
                {
                mT88(); 

                }
                break;
            case 72 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:294: T89
                {
                mT89(); 

                }
                break;
            case 73 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:298: T90
                {
                mT90(); 

                }
                break;
            case 74 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:302: T91
                {
                mT91(); 

                }
                break;
            case 75 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:306: T92
                {
                mT92(); 

                }
                break;
            case 76 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:310: T93
                {
                mT93(); 

                }
                break;
            case 77 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:314: T94
                {
                mT94(); 

                }
                break;
            case 78 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:318: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 79 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:329: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 80 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:340: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); 

                }
                break;
            case 81 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:363: HEX_LITERAL
                {
                mHEX_LITERAL(); 

                }
                break;
            case 82 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:375: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); 

                }
                break;
            case 83 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:391: OCTAL_LITERAL
                {
                mOCTAL_LITERAL(); 

                }
                break;
            case 84 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:405: BOOLEAN_LITERAL
                {
                mBOOLEAN_LITERAL(); 

                }
                break;
            case 85 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:421: ADDITIVE_OPERATOR_LITERAL
                {
                mADDITIVE_OPERATOR_LITERAL(); 

                }
                break;
            case 86 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:447: MULTIPLICATIVE_OPERATOR_LITERAL
                {
                mMULTIPLICATIVE_OPERATOR_LITERAL(); 

                }
                break;
            case 87 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:479: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); 

                }
                break;
            case 88 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:497: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 89 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:512: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 90 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:523: WS
                {
                mWS(); 

                }
                break;
            case 91 :
                // /Volumes/WINDOWS_HD/LocalDocuments/EclipseWorspaces/Reuseware09/org.emftext.language.java.resource.java/src/org/emftext/language/java/resource/java/Java.g:1:526: LB
                {
                mLB(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA19_eotS =
        "\6\uffff";
    static final String DFA19_eofS =
        "\6\uffff";
    static final String DFA19_minS =
        "\2\56\4\uffff";
    static final String DFA19_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\1\1\4\1\3";
    static final String DFA19_specialS =
        "\6\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\4\1\5\1\4\35\uffff\1\4\1\5\1\4",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "2524:1: FLOATING_POINT_LITERAL : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? | ( '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( ( 'f' | 'F' | 'd' | 'D' ) )? ) | ( ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) ( ( 'f' | 'F' | 'd' | 'D' ) )? ) | ( ( '0' .. '9' )+ ( ( 'f' | 'F' | 'd' | 'D' ) ) ) );";
        }
    }
    static final String DFA33_eotS =
        "\1\uffff\1\55\1\64\1\uffff\2\55\3\uffff\1\55\6\uffff\1\101\3\55"+
        "\3\uffff\2\55\1\uffff\4\55\2\133\2\uffff\2\137\2\uffff\1\137\2\55"+
        "\2\151\5\uffff\3\55\3\uffff\2\55\1\164\7\55\2\uffff\3\55\1\u0084"+
        "\23\55\13\uffff\3\55\1\u009e\1\151\1\uffff\2\55\1\65\1\151\4\55"+
        "\1\u00a5\1\55\1\uffff\12\55\1\u00b2\4\55\1\uffff\2\55\1\u00b9\12"+
        "\55\1\u00c4\11\55\1\u00cf\1\u009e\1\uffff\1\65\5\55\1\uffff\3\55"+
        "\1\u00d9\2\55\1\u00dc\1\u00dd\1\u00de\2\55\1\u00e1\1\uffff\1\55"+
        "\1\u00e3\2\55\1\u00e6\1\55\1\uffff\12\55\1\uffff\3\55\1\u00f5\2"+
        "\55\1\u00f8\1\55\1\u00fa\1\u00cf\1\uffff\1\65\7\55\1\u0102\1\uffff"+
        "\1\u0103\1\55\3\uffff\2\55\1\uffff\1\u0108\1\uffff\2\55\1\uffff"+
        "\4\55\1\u010f\1\u0110\3\55\1\u0115\1\u00e1\1\u0116\1\u0117\1\55"+
        "\1\uffff\1\u0119\1\55\1\uffff\1\55\1\uffff\3\55\1\u011f\1\55\1\u0121"+
        "\1\55\2\uffff\3\55\1\u0126\1\uffff\1\55\1\u0128\1\u0129\1\55\1\u012b"+
        "\1\u012c\2\uffff\1\55\1\u012e\2\55\3\uffff\1\u0131\1\uffff\3\55"+
        "\1\u0135\1\u0136\1\uffff\1\55\1\uffff\2\55\1\u013a\1\55\1\uffff"+
        "\1\u013c\2\uffff\1\55\2\uffff\1\55\1\uffff\1\55\1\u0140\1\uffff"+
        "\1\u0141\2\55\2\uffff\2\55\1\u0146\1\uffff\1\55\1\uffff\1\u0148"+
        "\1\55\1\u014a\2\uffff\1\u014b\1\u014c\1\u014d\1\55\1\uffff\1\u014f"+
        "\1\uffff\1\55\4\uffff\1\u0151\1\uffff\1\55\1\uffff\1\55\1\u0154"+
        "\1\uffff";
    static final String DFA33_eofS =
        "\u0155\uffff";
    static final String DFA33_minS =
        "\1\11\1\141\1\56\1\uffff\1\146\1\141\3\uffff\1\154\6\uffff\1\75"+
        "\1\150\1\145\1\141\3\uffff\1\150\1\142\1\uffff\1\141\1\150\1\145"+
        "\1\157\1\53\1\55\2\uffff\1\75\1\52\2\uffff\1\75\2\157\2\56\5\uffff"+
        "\1\151\1\143\1\142\3\uffff\1\164\1\160\1\60\1\163\1\141\1\156\1"+
        "\141\1\165\1\163\1\164\2\uffff\1\141\1\151\1\146\1\60\1\154\1\164"+
        "\1\167\1\141\1\151\1\157\1\160\1\156\2\163\1\156\1\154\1\162\1\157"+
        "\1\151\2\164\1\145\1\157\13\uffff\1\151\1\156\1\60\1\56\1\60\1\uffff"+
        "\1\53\1\56\1\60\1\56\1\164\1\166\1\153\1\154\1\60\1\154\1\uffff"+
        "\1\143\1\145\1\163\1\164\1\162\1\155\2\145\1\156\1\145\1\60\1\157"+
        "\1\163\1\141\1\142\1\uffff\1\154\1\151\1\60\1\151\2\164\1\162\1"+
        "\145\1\143\1\145\1\164\1\141\1\163\1\60\1\141\1\154\1\165\1\145"+
        "\1\141\1\154\1\144\1\141\1\147\2\60\1\uffff\1\60\1\145\2\141\1\151"+
        "\1\162\1\uffff\1\162\1\145\1\150\1\60\1\163\1\151\3\60\1\156\1\163"+
        "\1\60\1\uffff\1\167\1\60\1\165\1\154\1\60\1\166\1\uffff\1\143\1"+
        "\151\1\143\1\164\1\162\1\150\2\162\1\154\1\145\1\uffff\1\164\1\145"+
        "\1\162\1\60\1\153\1\145\1\60\1\164\2\60\1\uffff\1\60\1\143\1\164"+
        "\1\147\1\143\1\146\1\164\1\155\1\60\1\uffff\1\60\1\156\3\uffff\1"+
        "\144\1\151\1\uffff\1\60\1\uffff\1\154\1\145\1\uffff\1\145\1\164"+
        "\1\143\1\150\2\60\1\162\1\164\1\141\4\60\1\156\1\uffff\1\60\1\141"+
        "\1\uffff\1\151\1\uffff\1\164\2\145\1\60\1\141\1\60\1\145\2\uffff"+
        "\1\165\1\163\1\145\1\60\1\uffff\1\164\2\60\1\146\2\60\2\uffff\1"+
        "\157\1\60\1\143\1\171\3\uffff\1\60\1\uffff\1\156\1\154\1\145\2\60"+
        "\1\uffff\1\143\1\uffff\1\156\1\145\1\60\1\156\1\uffff\1\60\2\uffff"+
        "\1\160\2\uffff\1\156\1\uffff\1\164\1\60\1\uffff\1\60\1\145\1\144"+
        "\2\uffff\1\145\1\164\1\60\1\uffff\1\164\1\uffff\1\60\1\151\1\60"+
        "\2\uffff\3\60\1\163\1\uffff\1\60\1\uffff\1\172\4\uffff\1\60\1\uffff"+
        "\1\145\1\uffff\1\144\1\60\1\uffff";
    static final String DFA33_maxS =
        "\1\176\1\165\1\71\1\uffff\1\156\1\157\3\uffff\1\170\6\uffff\1\75"+
        "\1\162\1\157\1\165\3\uffff\1\171\1\163\1\uffff\1\157\1\150\1\145"+
        "\1\171\2\75\2\uffff\2\75\2\uffff\1\75\2\157\2\172\5\uffff\1\157"+
        "\1\143\1\142\3\uffff\1\164\1\160\1\172\1\164\1\141\1\156\1\141\1"+
        "\165\1\163\1\164\2\uffff\1\171\1\162\1\146\1\172\1\154\1\164\1\167"+
        "\1\162\1\151\1\157\1\160\1\156\2\163\1\156\1\154\1\162\1\157\1\151"+
        "\2\164\1\145\1\157\13\uffff\1\154\1\156\1\146\2\172\1\uffff\1\71"+
        "\1\146\2\172\1\164\1\166\1\153\1\154\1\172\1\157\1\uffff\1\143\1"+
        "\145\1\163\1\164\1\162\1\155\2\145\1\156\1\145\1\172\1\157\1\163"+
        "\1\141\1\142\1\uffff\1\154\1\151\1\172\1\151\2\164\1\162\1\145\1"+
        "\143\1\145\1\164\1\141\1\163\1\172\1\141\1\154\1\165\1\145\1\141"+
        "\1\154\1\144\1\141\1\147\2\172\1\uffff\1\172\1\145\2\141\1\151\1"+
        "\162\1\uffff\1\162\1\145\1\150\1\172\1\163\1\151\3\172\1\156\1\163"+
        "\1\172\1\uffff\1\167\1\172\1\165\1\154\1\172\1\166\1\uffff\1\143"+
        "\1\151\1\143\1\164\1\162\1\150\2\162\1\154\1\145\1\uffff\1\164\1"+
        "\145\1\162\1\172\1\153\1\145\1\172\1\164\2\172\1\uffff\1\172\1\143"+
        "\1\164\1\147\1\143\1\146\1\164\1\155\1\172\1\uffff\1\172\1\156\3"+
        "\uffff\1\144\1\151\1\uffff\1\172\1\uffff\1\154\1\145\1\uffff\1\145"+
        "\1\164\1\143\1\150\2\172\1\162\1\164\1\141\4\172\1\156\1\uffff\1"+
        "\172\1\141\1\uffff\1\151\1\uffff\1\164\2\145\1\172\1\141\1\172\1"+
        "\145\2\uffff\1\165\1\163\1\145\1\172\1\uffff\1\164\2\172\1\146\2"+
        "\172\2\uffff\1\157\1\172\1\143\1\171\3\uffff\1\172\1\uffff\1\156"+
        "\1\154\1\145\2\172\1\uffff\1\143\1\uffff\1\156\1\145\1\172\1\156"+
        "\1\uffff\1\172\2\uffff\1\160\2\uffff\1\156\1\uffff\1\164\1\172\1"+
        "\uffff\1\172\1\145\1\144\2\uffff\1\145\1\164\1\172\1\uffff\1\164"+
        "\1\uffff\1\172\1\151\1\172\2\uffff\3\172\1\163\1\uffff\1\172\1\uffff"+
        "\1\172\4\uffff\1\172\1\uffff\1\145\1\uffff\1\144\1\172\1\uffff";
    static final String DFA33_acceptS =
        "\3\uffff\1\3\2\uffff\1\6\1\7\1\10\1\uffff\1\13\1\14\1\16\1\17\1"+
        "\20\1\21\4\uffff\1\30\1\31\1\32\2\uffff\1\35\6\uffff\1\57\1\60\2"+
        "\uffff\1\66\1\67\5\uffff\1\127\1\130\1\131\1\132\1\133\3\uffff\1"+
        "\26\1\2\1\120\12\uffff\1\65\1\23\27\uffff\1\61\1\55\1\125\1\56\1"+
        "\62\1\63\1\126\1\116\1\64\1\117\1\70\5\uffff\1\122\12\uffff\1\36"+
        "\17\uffff\1\42\31\uffff\1\123\6\uffff\1\112\14\uffff\1\44\6\uffff"+
        "\1\27\12\uffff\1\40\12\uffff\1\121\11\uffff\1\50\2\uffff\1\107\1"+
        "\22\1\37\2\uffff\1\124\1\uffff\1\73\2\uffff\1\71\16\uffff\1\110"+
        "\2\uffff\1\72\1\uffff\1\113\7\uffff\1\46\1\5\4\uffff\1\52\6\uffff"+
        "\1\111\1\33\4\uffff\1\100\1\114\1\41\1\uffff\1\53\5\uffff\1\74\1"+
        "\uffff\1\4\4\uffff\1\24\1\uffff\1\115\1\102\1\uffff\1\101\1\47\1"+
        "\uffff\1\34\2\uffff\1\51\3\uffff\1\77\1\1\3\uffff\1\11\1\uffff\1"+
        "\25\3\uffff\1\45\1\106\4\uffff\1\54\1\uffff\1\105\1\uffff\1\75\1"+
        "\104\1\76\1\15\1\uffff\1\103\1\uffff\1\12\2\uffff\1\43";
    static final String DFA33_specialS =
        "\u0155\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\56\1\57\1\uffff\1\56\1\57\22\uffff\1\56\1\41\1\54\2\uffff"+
            "\1\46\1\20\1\53\1\15\1\16\1\42\1\36\1\7\1\37\1\2\1\43\1\51\11"+
            "\52\1\31\1\3\1\6\1\17\1\10\1\26\1\14\32\55\1\24\1\uffff\1\25"+
            "\1\45\1\55\1\uffff\1\30\1\35\1\5\1\22\1\11\1\32\2\55\1\4\2\55"+
            "\1\50\1\55\1\23\1\55\1\1\1\55\1\34\1\27\1\21\1\55\1\47\1\33"+
            "\3\55\1\12\1\44\1\13\1\40",
            "\1\61\20\uffff\1\60\2\uffff\1\62",
            "\1\63\1\uffff\12\65",
            "",
            "\1\70\6\uffff\1\67\1\66",
            "\1\71\6\uffff\1\74\3\uffff\1\72\2\uffff\1\73",
            "",
            "",
            "",
            "\1\76\1\uffff\1\75\11\uffff\1\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100",
            "\1\103\11\uffff\1\102",
            "\1\104\11\uffff\1\105",
            "\1\107\3\uffff\1\110\17\uffff\1\106",
            "",
            "",
            "",
            "\1\113\13\uffff\1\111\1\114\1\uffff\1\112\1\uffff\1\115",
            "\1\117\20\uffff\1\116",
            "",
            "\1\121\7\uffff\1\120\2\uffff\1\123\2\uffff\1\122",
            "\1\124",
            "\1\125",
            "\1\130\2\uffff\1\127\6\uffff\1\126",
            "\1\132\21\uffff\1\131",
            "\1\134\17\uffff\1\135",
            "",
            "",
            "\1\136",
            "\1\142\4\uffff\1\140\15\uffff\1\141",
            "",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\65\1\uffff\10\147\2\153\7\uffff\3\55\1\154\1\152\1\154\5"+
            "\55\1\150\13\55\1\146\2\55\4\uffff\1\55\1\uffff\3\55\1\154\1"+
            "\152\1\154\5\55\1\150\13\55\1\146\2\55",
            "\1\65\1\uffff\12\155\7\uffff\3\55\1\154\1\152\1\154\5\55\1"+
            "\150\16\55\4\uffff\1\55\1\uffff\3\55\1\154\1\152\1\154\5\55"+
            "\1\150\16\55",
            "",
            "",
            "",
            "",
            "",
            "\1\157\5\uffff\1\156",
            "\1\160",
            "\1\161",
            "",
            "",
            "",
            "\1\162",
            "\1\163",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\166\1\165",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "",
            "\1\175\23\uffff\1\176\3\uffff\1\177",
            "\1\u0081\10\uffff\1\u0080",
            "\1\u0082",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\24\55\1\u0083\5\55",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0089\20\uffff\1\u0088",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0099\2\uffff\1\u009a",
            "\1\u009b",
            "\12\u009c\7\uffff\6\u009c\32\uffff\6\u009c",
            "\1\65\1\uffff\10\147\2\153\7\uffff\3\55\1\154\1\152\1\154\5"+
            "\55\1\u009d\16\55\4\uffff\1\55\1\uffff\3\55\1\154\1\152\1\154"+
            "\5\55\1\u009d\16\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\65\1\uffff\1\65\2\uffff\12\u009f",
            "\1\65\1\uffff\12\153\12\uffff\1\154\1\152\1\154\35\uffff\1"+
            "\154\1\152\1\154",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\65\1\uffff\12\155\7\uffff\3\55\1\154\1\152\1\154\5\55\1"+
            "\150\16\55\4\uffff\1\55\1\uffff\3\55\1\154\1\152\1\154\5\55"+
            "\1\150\16\55",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u00a4\25\55",
            "\1\u00a7\2\uffff\1\u00a6",
            "",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\12\u009c\7\uffff\6\u009c\5\55\1\u00ce\16\55\4\uffff\1\55\1"+
            "\uffff\6\u009c\5\55\1\u00ce\16\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\u009f\7\uffff\3\55\1\u00d0\1\55\1\u00d0\24\55\4\uffff\1"+
            "\55\1\uffff\3\55\1\u00d0\1\55\1\u00d0\24\55",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00da",
            "\1\u00db",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00df",
            "\1\u00e0",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u00e2",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00e4",
            "\1\u00e5",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f6",
            "\1\u00f7",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f9",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0104",
            "",
            "",
            "",
            "\1\u0105",
            "\1\u0106",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u0107\7\55",
            "",
            "\1\u0109",
            "\1\u010a",
            "",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\13\55\1\u0114\16"+
            "\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0118",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u011a",
            "",
            "\1\u011b",
            "",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0120",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0122",
            "",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0127",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u012a",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u012d",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u012f",
            "\1\u0130",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0137",
            "",
            "\1\u0138",
            "\1\u0139",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u013b",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u013d",
            "",
            "",
            "\1\u013e",
            "",
            "\1\u013f",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0142",
            "\1\u0143",
            "",
            "",
            "\1\u0144",
            "\1\u0145",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0147",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0149",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u014e",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0150",
            "",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0152",
            "",
            "\1\u0153",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | SL_COMMENT | ML_COMMENT | FLOATING_POINT_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | BOOLEAN_LITERAL | ADDITIVE_OPERATOR_LITERAL | MULTIPLICATIVE_OPERATOR_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENTIFIER | WS | LB );";
        }
    }
 

}