// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g 2008-11-19 18:36:21

package org.eclipse.bpel.model.resource.bpws;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BpwsLexer extends Lexer {
    public static final int T114=114;
    public static final int T115=115;
    public static final int T116=116;
    public static final int T117=117;
    public static final int T118=118;
    public static final int T119=119;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T120=120;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T122=122;
    public static final int T21=21;
    public static final int T121=121;
    public static final int T20=20;
    public static final int T124=124;
    public static final int T123=123;
    public static final int T127=127;
    public static final int T128=128;
    public static final int T125=125;
    public static final int T126=126;
    public static final int T129=129;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T131=131;
    public static final int T34=34;
    public static final int COMMENT=6;
    public static final int T130=130;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T135=135;
    public static final int T30=30;
    public static final int T134=134;
    public static final int T133=133;
    public static final int T32=32;
    public static final int T132=132;
    public static final int T31=31;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T100=100;
    public static final int T43=43;
    public static final int T42=42;
    public static final int T102=102;
    public static final int T41=41;
    public static final int T101=101;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int T44=44;
    public static final int T109=109;
    public static final int T107=107;
    public static final int T108=108;
    public static final int T105=105;
    public static final int WS=10;
    public static final int T106=106;
    public static final int T103=103;
    public static final int T104=104;
    public static final int T50=50;
    public static final int T59=59;
    public static final int T113=113;
    public static final int T52=52;
    public static final int T112=112;
    public static final int T51=51;
    public static final int T111=111;
    public static final int T54=54;
    public static final int T110=110;
    public static final int QUOTED_34_34=5;
    public static final int T53=53;
    public static final int T56=56;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int T159=159;
    public static final int T158=158;
    public static final int T161=161;
    public static final int T162=162;
    public static final int T163=163;
    public static final int T164=164;
    public static final int T165=165;
    public static final int FLOAT=8;
    public static final int T166=166;
    public static final int T167=167;
    public static final int T168=168;
    public static final int T72=72;
    public static final int T71=71;
    public static final int T70=70;
    public static final int T160=160;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int T169=169;
    public static final int T174=174;
    public static final int T175=175;
    public static final int T172=172;
    public static final int T173=173;
    public static final int T178=178;
    public static final int T179=179;
    public static final int T176=176;
    public static final int T177=177;
    public static final int T170=170;
    public static final int T171=171;
    public static final int T61=61;
    public static final int T60=60;
    public static final int INTEGER=7;
    public static final int T99=99;
    public static final int T97=97;
    public static final int T98=98;
    public static final int T95=95;
    public static final int T96=96;
    public static final int T137=137;
    public static final int T136=136;
    public static final int T139=139;
    public static final int T138=138;
    public static final int T143=143;
    public static final int T144=144;
    public static final int T145=145;
    public static final int T146=146;
    public static final int T140=140;
    public static final int T141=141;
    public static final int T142=142;
    public static final int TEXT=4;
    public static final int T94=94;
    public static final int Tokens=180;
    public static final int T93=93;
    public static final int T92=92;
    public static final int T91=91;
    public static final int T90=90;
    public static final int T88=88;
    public static final int T89=89;
    public static final int T84=84;
    public static final int T85=85;
    public static final int T86=86;
    public static final int T87=87;
    public static final int T149=149;
    public static final int T148=148;
    public static final int T147=147;
    public static final int T156=156;
    public static final int T157=157;
    public static final int T154=154;
    public static final int T155=155;
    public static final int LB=9;
    public static final int T152=152;
    public static final int T11=11;
    public static final int T153=153;
    public static final int T12=12;
    public static final int T150=150;
    public static final int T13=13;
    public static final int T151=151;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T81=81;
    public static final int T16=16;
    public static final int T80=80;
    public static final int T17=17;
    public static final int T83=83;
    public static final int T18=18;
    public static final int T82=82;
    public static final int T19=19;

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
    public String getGrammarFileName() { return "D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:17:5: ( 'Process' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:17:7: 'Process'
            {
            match("Process"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:18:5: ( '{' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:18:7: '{'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:19:5: ( 'documentationElement' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:19:7: 'documentationElement'
            {
            match("documentationElement"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:20:5: ( ':' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:20:7: ':'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:21:5: ( 'element' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:21:7: 'element'
            {
            match("element"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:22:5: ( 'eExtensibilityElements' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:22:7: 'eExtensibilityElements'
            {
            match("eExtensibilityElements"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:23:5: ( 'documentation' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:23:7: 'documentation'
            {
            match("documentation"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:24:5: ( 'name' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:24:7: 'name'
            {
            match("name"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:25:5: ( 'targetNamespace' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:25:7: 'targetNamespace'
            {
            match("targetNamespace"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:26:5: ( 'queryLanguage' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:26:7: 'queryLanguage'
            {
            match("queryLanguage"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:27:5: ( 'expressionLanguage' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:27:7: 'expressionLanguage'
            {
            match("expressionLanguage"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:28:5: ( 'suppressJoinFailure' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:28:7: 'suppressJoinFailure'
            {
            match("suppressJoinFailure"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:29:5: ( 'variableAccessSerializable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:29:7: 'variableAccessSerializable'
            {
            match("variableAccessSerializable"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:30:5: ( 'partnerLinks' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:30:7: 'partnerLinks'
            {
            match("partnerLinks"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:31:5: ( 'variables' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:31:7: 'variables'
            {
            match("variables"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:32:5: ( 'activity' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:32:7: 'activity'
            {
            match("activity"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:33:5: ( 'faultHandlers' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:33:7: 'faultHandlers'
            {
            match("faultHandlers"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:34:5: ( 'eventHandlers' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:34:7: 'eventHandlers'
            {
            match("eventHandlers"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:35:5: ( 'correlationSets' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:35:7: 'correlationSets'
            {
            match("correlationSets"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:36:5: ( 'imports' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:36:7: 'imports'
            {
            match("imports"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:37:5: ( 'extensions' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:37:7: 'extensions'
            {
            match("extensions"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:38:5: ( 'exitOnStandardFault' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:38:7: 'exitOnStandardFault'
            {
            match("exitOnStandardFault"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:39:5: ( 'messageExchanges' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:39:7: 'messageExchanges'
            {
            match("messageExchanges"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:40:5: ( '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:40:7: '}'
            {
            match('}'); 

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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:41:5: ( 'PartnerLink' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:41:7: 'PartnerLink'
            {
            match("PartnerLink"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:42:5: ( 'myRole' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:42:7: 'myRole'
            {
            match("myRole"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:43:5: ( 'partnerRole' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:43:7: 'partnerRole'
            {
            match("partnerRole"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:44:5: ( 'PartnerLinkType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:44:7: 'PartnerLinkType'
            {
            match("PartnerLinkType"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:45:5: ( 'initializePartnerRole' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:45:7: 'initializePartnerRole'
            {
            match("initializePartnerRole"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:46:5: ( 'FaultHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:46:7: 'FaultHandler'
            {
            match("FaultHandler"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:47:5: ( 'catch' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:47:7: 'catch'
            {
            match("catch"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:48:5: ( 'catchAll' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:48:7: 'catchAll'
            {
            match("catchAll"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:49:5: ( 'Activity' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:49:7: 'Activity'
            {
            match("Activity"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:50:5: ( 'targets' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:50:7: 'targets'
            {
            match("targets"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:51:5: ( 'sources' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:51:7: 'sources'
            {
            match("sources"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:52:5: ( 'CorrelationSet' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:52:7: 'CorrelationSet'
            {
            match("CorrelationSet"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:53:5: ( 'properties' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:53:7: 'properties'
            {
            match("properties"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:54:5: ( 'Invoke' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:54:7: 'Invoke'
            {
            match("Invoke"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:55:5: ( 'partnerLink' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:55:7: 'partnerLink'
            {
            match("partnerLink"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:56:5: ( 'correlations' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:56:7: 'correlations'
            {
            match("correlations"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:57:5: ( 'portType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:57:7: 'portType'
            {
            match("portType"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:58:5: ( 'operation' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:58:7: 'operation'
            {
            match("operation"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:59:5: ( 'outputVariable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:59:7: 'outputVariable'
            {
            match("outputVariable"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:60:5: ( 'inputVariable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:60:7: 'inputVariable'
            {
            match("inputVariable"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:61:5: ( 'compensationHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:61:7: 'compensationHandler'
            {
            match("compensationHandler"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:62:5: ( 'faultHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:62:7: 'faultHandler'
            {
            match("faultHandler"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:63:5: ( 'toPart' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:63:7: 'toPart'
            {
            match("toPart"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:64:5: ( 'fromPart' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:64:7: 'fromPart'
            {
            match("fromPart"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:65:5: ( 'Link' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:65:7: 'Link'
            {
            match("Link"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:66:5: ( 'Catch' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:66:7: 'Catch'
            {
            match("Catch"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:67:5: ( 'faultName' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:67:7: 'faultName'
            {
            match("faultName"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:68:5: ( 'faultVariable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:68:7: 'faultVariable'
            {
            match("faultVariable"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:69:5: ( 'faultMessageType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:69:7: 'faultMessageType'
            {
            match("faultMessageType"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:70:5: ( 'faultElement' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:70:7: 'faultElement'
            {
            match("faultElement"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:71:5: ( 'Reply' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:71:7: 'Reply'
            {
            match("Reply"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:72:5: ( 'variable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:72:7: 'variable'
            {
            match("variable"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:73:5: ( 'PartnerActivity' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:73:7: 'PartnerActivity'
            {
            match("PartnerActivity"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:74:5: ( 'Receive' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:74:7: 'Receive'
            {
            match("Receive"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:75:5: ( 'createInstance' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:75:7: 'createInstance'
            {
            match("createInstance"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:76:5: ( 'Exit' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:76:7: 'Exit'
            {
            match("Exit"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:77:5: ( 'Throw' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:77:7: 'Throw'
            {
            match("Throw"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:78:5: ( 'Wait' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:78:7: 'Wait'
            {
            match("Wait"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:79:5: ( 'for' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:79:7: 'for'
            {
            match("for"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:80:5: ( 'until' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:80:7: 'until'
            {
            match("until"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:81:5: ( 'Empty' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:81:7: 'Empty'
            {
            match("Empty"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:82:5: ( 'Sequence' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:82:7: 'Sequence'
            {
            match("Sequence"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:83:5: ( 'activities' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:83:7: 'activities'
            {
            match("activities"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:84:5: ( 'While' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:84:7: 'While'
            {
            match("While"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:85:5: ( 'condition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:85:7: 'condition'
            {
            match("condition"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:86:5: ( 'Pick' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:86:7: 'Pick'
            {
            match("Pick"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:87:5: ( 'messages' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:87:7: 'messages'
            {
            match("messages"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:88:5: ( 'alarm' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:88:7: 'alarm'
            {
            match("alarm"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:89:5: ( 'Flow' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:89:7: 'Flow'
            {
            match("Flow"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:90:5: ( 'links' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:90:7: 'links'
            {
            match("links"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:91:5: ( 'completionCondition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:91:7: 'completionCondition'
            {
            match("completionCondition"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:92:5: ( 'OnAlarm' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:92:7: 'OnAlarm'
            {
            match("OnAlarm"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:93:5: ( 'repeatEvery' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:93:7: 'repeatEvery'
            {
            match("repeatEvery"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:94:5: ( 'Assign' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:94:7: 'Assign'
            {
            match("Assign"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:95:5: ( 'copy' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:95:7: 'copy'
            {
            match("copy"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:96:5: ( 'validate' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:96:7: 'validate'
            {
            match("validate"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:97:5: ( 'Copy' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:97:7: 'Copy'
            {
            match("Copy"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:98:5: ( 'to' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:98:7: 'to'
            {
            match("to"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:99:5: ( 'from' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:99:7: 'from'
            {
            match("from"); 


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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:100:5: ( 'keepSrcElementName' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:100:7: 'keepSrcElementName'
            {
            match("keepSrcElementName"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start T95
    public final void mT95() throws RecognitionException {
        try {
            int _type = T95;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:101:5: ( 'ignoreMissingFromData' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:101:7: 'ignoreMissingFromData'
            {
            match("ignoreMissingFromData"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T95

    // $ANTLR start T96
    public final void mT96() throws RecognitionException {
        try {
            int _type = T96;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:102:5: ( 'CompensateScope' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:102:7: 'CompensateScope'
            {
            match("CompensateScope"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T96

    // $ANTLR start T97
    public final void mT97() throws RecognitionException {
        try {
            int _type = T97;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:103:5: ( 'target' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:103:7: 'target'
            {
            match("target"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T97

    // $ANTLR start T98
    public final void mT98() throws RecognitionException {
        try {
            int _type = T98;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:104:5: ( 'CompensationHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:104:7: 'CompensationHandler'
            {
            match("CompensationHandler"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T98

    // $ANTLR start T99
    public final void mT99() throws RecognitionException {
        try {
            int _type = T99;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:105:5: ( 'To' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:105:7: 'To'
            {
            match("To"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start T100
    public final void mT100() throws RecognitionException {
        try {
            int _type = T100;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:106:6: ( 'part' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:106:8: 'part'
            {
            match("part"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T100

    // $ANTLR start T101
    public final void mT101() throws RecognitionException {
        try {
            int _type = T101;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:107:6: ( 'property' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:107:8: 'property'
            {
            match("property"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T101

    // $ANTLR start T102
    public final void mT102() throws RecognitionException {
        try {
            int _type = T102;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:108:6: ( 'query' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:108:8: 'query'
            {
            match("query"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T102

    // $ANTLR start T103
    public final void mT103() throws RecognitionException {
        try {
            int _type = T103;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:109:6: ( 'expression' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:109:8: 'expression'
            {
            match("expression"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T103

    // $ANTLR start T104
    public final void mT104() throws RecognitionException {
        try {
            int _type = T104;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:110:6: ( 'From' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:110:8: 'From'
            {
            match("From"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T104

    // $ANTLR start T105
    public final void mT105() throws RecognitionException {
        try {
            int _type = T105;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:111:6: ( 'opaque' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:111:8: 'opaque'
            {
            match("opaque"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T105

    // $ANTLR start T106
    public final void mT106() throws RecognitionException {
        try {
            int _type = T106;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:112:6: ( 'endpointReference' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:112:8: 'endpointReference'
            {
            match("endpointReference"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T106

    // $ANTLR start T107
    public final void mT107() throws RecognitionException {
        try {
            int _type = T107;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:113:6: ( 'literal' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:113:8: 'literal'
            {
            match("literal"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T107

    // $ANTLR start T108
    public final void mT108() throws RecognitionException {
        try {
            int _type = T108;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:114:6: ( 'unsafeLiteral' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:114:8: 'unsafeLiteral'
            {
            match("unsafeLiteral"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T108

    // $ANTLR start T109
    public final void mT109() throws RecognitionException {
        try {
            int _type = T109;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:115:6: ( 'serviceRef' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:115:8: 'serviceRef'
            {
            match("serviceRef"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T109

    // $ANTLR start T110
    public final void mT110() throws RecognitionException {
        try {
            int _type = T110;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:116:6: ( 'type' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:116:8: 'type'
            {
            match("type"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T110

    // $ANTLR start T111
    public final void mT111() throws RecognitionException {
        try {
            int _type = T111;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:117:6: ( 'OnMessage' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:117:8: 'OnMessage'
            {
            match("OnMessage"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T111

    // $ANTLR start T112
    public final void mT112() throws RecognitionException {
        try {
            int _type = T112;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:118:6: ( 'Expression' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:118:8: 'Expression'
            {
            match("Expression"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T112

    // $ANTLR start T113
    public final void mT113() throws RecognitionException {
        try {
            int _type = T113;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:119:6: ( 'elementType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:119:8: 'elementType'
            {
            match("elementType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T113

    // $ANTLR start T114
    public final void mT114() throws RecognitionException {
        try {
            int _type = T114;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:120:6: ( 'body' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:120:8: 'body'
            {
            match("body"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T114

    // $ANTLR start T115
    public final void mT115() throws RecognitionException {
        try {
            int _type = T115;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:121:6: ( 'BooleanExpression' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:121:8: 'BooleanExpression'
            {
            match("BooleanExpression"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T115

    // $ANTLR start T116
    public final void mT116() throws RecognitionException {
        try {
            int _type = T116;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:122:6: ( 'Correlation' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:122:8: 'Correlation'
            {
            match("Correlation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T116

    // $ANTLR start T117
    public final void mT117() throws RecognitionException {
        try {
            int _type = T117;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:123:6: ( 'initiate' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:123:8: 'initiate'
            {
            match("initiate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T117

    // $ANTLR start T118
    public final void mT118() throws RecognitionException {
        try {
            int _type = T118;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:124:6: ( 'pattern' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:124:8: 'pattern'
            {
            match("pattern"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T118

    // $ANTLR start T119
    public final void mT119() throws RecognitionException {
        try {
            int _type = T119;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:125:6: ( 'set' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:125:8: 'set'
            {
            match("set"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T119

    // $ANTLR start T120
    public final void mT120() throws RecognitionException {
        try {
            int _type = T120;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:126:6: ( 'EventHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:126:8: 'EventHandler'
            {
            match("EventHandler"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T120

    // $ANTLR start T121
    public final void mT121() throws RecognitionException {
        try {
            int _type = T121;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:127:6: ( 'events' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:127:8: 'events'
            {
            match("events"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T121

    // $ANTLR start T122
    public final void mT122() throws RecognitionException {
        try {
            int _type = T122;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:128:6: ( 'Source' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:128:8: 'Source'
            {
            match("Source"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T122

    // $ANTLR start T123
    public final void mT123() throws RecognitionException {
        try {
            int _type = T123;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:129:6: ( 'transitionCondition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:129:8: 'transitionCondition'
            {
            match("transitionCondition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T123

    // $ANTLR start T124
    public final void mT124() throws RecognitionException {
        try {
            int _type = T124;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:130:6: ( 'Target' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:130:8: 'Target'
            {
            match("Target"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T124

    // $ANTLR start T125
    public final void mT125() throws RecognitionException {
        try {
            int _type = T125;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:131:6: ( 'PartnerLinks' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:131:8: 'PartnerLinks'
            {
            match("PartnerLinks"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T125

    // $ANTLR start T126
    public final void mT126() throws RecognitionException {
        try {
            int _type = T126;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:132:6: ( 'children' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:132:8: 'children'
            {
            match("children"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T126

    // $ANTLR start T127
    public final void mT127() throws RecognitionException {
        try {
            int _type = T127;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:133:6: ( 'Variables' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:133:8: 'Variables'
            {
            match("Variables"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T127

    // $ANTLR start T128
    public final void mT128() throws RecognitionException {
        try {
            int _type = T128;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:134:6: ( 'CorrelationSets' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:134:8: 'CorrelationSets'
            {
            match("CorrelationSets"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T128

    // $ANTLR start T129
    public final void mT129() throws RecognitionException {
        try {
            int _type = T129;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:135:6: ( 'Links' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:135:8: 'Links'
            {
            match("Links"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T129

    // $ANTLR start T130
    public final void mT130() throws RecognitionException {
        try {
            int _type = T130;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:136:6: ( 'CatchAll' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:136:8: 'CatchAll'
            {
            match("CatchAll"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T130

    // $ANTLR start T131
    public final void mT131() throws RecognitionException {
        try {
            int _type = T131;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:137:6: ( 'Correlations' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:137:8: 'Correlations'
            {
            match("Correlations"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T131

    // $ANTLR start T132
    public final void mT132() throws RecognitionException {
        try {
            int _type = T132;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:138:6: ( 'Variable' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:138:8: 'Variable'
            {
            match("Variable"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T132

    // $ANTLR start T133
    public final void mT133() throws RecognitionException {
        try {
            int _type = T133;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:139:6: ( 'messageType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:139:8: 'messageType'
            {
            match("messageType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T133

    // $ANTLR start T134
    public final void mT134() throws RecognitionException {
        try {
            int _type = T134;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:140:6: ( 'XSDElement' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:140:8: 'XSDElement'
            {
            match("XSDElement"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T134

    // $ANTLR start T135
    public final void mT135() throws RecognitionException {
        try {
            int _type = T135;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:141:6: ( 'UnknownExtensibilityAttribute' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:141:8: 'UnknownExtensibilityAttribute'
            {
            match("UnknownExtensibilityAttribute"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T135

    // $ANTLR start T136
    public final void mT136() throws RecognitionException {
        try {
            int _type = T136;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:142:6: ( 'OnEvent' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:142:8: 'OnEvent'
            {
            match("OnEvent"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T136

    // $ANTLR start T137
    public final void mT137() throws RecognitionException {
        try {
            int _type = T137;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:143:6: ( 'Import' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:143:8: 'Import'
            {
            match("Import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T137

    // $ANTLR start T138
    public final void mT138() throws RecognitionException {
        try {
            int _type = T138;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:144:6: ( 'namespace' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:144:8: 'namespace'
            {
            match("namespace"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T138

    // $ANTLR start T139
    public final void mT139() throws RecognitionException {
        try {
            int _type = T139;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:145:6: ( 'location' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:145:8: 'location'
            {
            match("location"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T139

    // $ANTLR start T140
    public final void mT140() throws RecognitionException {
        try {
            int _type = T140;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:146:6: ( 'importType' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:146:8: 'importType'
            {
            match("importType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T140

    // $ANTLR start T141
    public final void mT141() throws RecognitionException {
        try {
            int _type = T141;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:147:6: ( 'Rethrow' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:147:8: 'Rethrow'
            {
            match("Rethrow"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T141

    // $ANTLR start T142
    public final void mT142() throws RecognitionException {
        try {
            int _type = T142;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:148:6: ( 'Condition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:148:8: 'Condition'
            {
            match("Condition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T142

    // $ANTLR start T143
    public final void mT143() throws RecognitionException {
        try {
            int _type = T143;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:149:6: ( 'Targets' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:149:8: 'Targets'
            {
            match("Targets"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T143

    // $ANTLR start T144
    public final void mT144() throws RecognitionException {
        try {
            int _type = T144;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:150:6: ( 'joinCondition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:150:8: 'joinCondition'
            {
            match("joinCondition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T144

    // $ANTLR start T145
    public final void mT145() throws RecognitionException {
        try {
            int _type = T145;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:151:6: ( 'Sources' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:151:8: 'Sources'
            {
            match("Sources"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T145

    // $ANTLR start T146
    public final void mT146() throws RecognitionException {
        try {
            int _type = T146;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:152:6: ( 'Query' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:152:8: 'Query'
            {
            match("Query"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T146

    // $ANTLR start T147
    public final void mT147() throws RecognitionException {
        try {
            int _type = T147;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:153:6: ( 'value' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:153:8: 'value'
            {
            match("value"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T147

    // $ANTLR start T148
    public final void mT148() throws RecognitionException {
        try {
            int _type = T148;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:154:6: ( 'ServiceRef' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:154:8: 'ServiceRef'
            {
            match("ServiceRef"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T148

    // $ANTLR start T149
    public final void mT149() throws RecognitionException {
        try {
            int _type = T149;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:155:6: ( 'referenceScheme' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:155:8: 'referenceScheme'
            {
            match("referenceScheme"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T149

    // $ANTLR start T150
    public final void mT150() throws RecognitionException {
        try {
            int _type = T150;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:156:6: ( 'Extensions' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:156:8: 'Extensions'
            {
            match("Extensions"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T150

    // $ANTLR start T151
    public final void mT151() throws RecognitionException {
        try {
            int _type = T151;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:157:6: ( 'ExtensionActivity' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:157:8: 'ExtensionActivity'
            {
            match("ExtensionActivity"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T151

    // $ANTLR start T152
    public final void mT152() throws RecognitionException {
        try {
            int _type = T152;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:158:6: ( 'FromPart' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:158:8: 'FromPart'
            {
            match("FromPart"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T152

    // $ANTLR start T153
    public final void mT153() throws RecognitionException {
        try {
            int _type = T153;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:159:6: ( 'ToPart' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:159:8: 'ToPart'
            {
            match("ToPart"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T153

    // $ANTLR start T154
    public final void mT154() throws RecognitionException {
        try {
            int _type = T154;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:160:6: ( 'OpaqueActivity' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:160:8: 'OpaqueActivity'
            {
            match("OpaqueActivity"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T154

    // $ANTLR start T155
    public final void mT155() throws RecognitionException {
        try {
            int _type = T155;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:161:6: ( 'ForEach' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:161:8: 'ForEach'
            {
            match("ForEach"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T155

    // $ANTLR start T156
    public final void mT156() throws RecognitionException {
        try {
            int _type = T156;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:162:6: ( 'startCounterValue' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:162:8: 'startCounterValue'
            {
            match("startCounterValue"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T156

    // $ANTLR start T157
    public final void mT157() throws RecognitionException {
        try {
            int _type = T157;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:163:6: ( 'finalCounterValue' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:163:8: 'finalCounterValue'
            {
            match("finalCounterValue"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T157

    // $ANTLR start T158
    public final void mT158() throws RecognitionException {
        try {
            int _type = T158;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:164:6: ( 'parallel' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:164:8: 'parallel'
            {
            match("parallel"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T158

    // $ANTLR start T159
    public final void mT159() throws RecognitionException {
        try {
            int _type = T159;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:165:6: ( 'counterName' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:165:8: 'counterName'
            {
            match("counterName"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T159

    // $ANTLR start T160
    public final void mT160() throws RecognitionException {
        try {
            int _type = T160;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:166:6: ( 'RepeatUntil' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:166:8: 'RepeatUntil'
            {
            match("RepeatUntil"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T160

    // $ANTLR start T161
    public final void mT161() throws RecognitionException {
        try {
            int _type = T161;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:167:6: ( 'TerminationHandler' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:167:8: 'TerminationHandler'
            {
            match("TerminationHandler"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T161

    // $ANTLR start T162
    public final void mT162() throws RecognitionException {
        try {
            int _type = T162;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:168:6: ( 'Validate' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:168:8: 'Validate'
            {
            match("Validate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T162

    // $ANTLR start T163
    public final void mT163() throws RecognitionException {
        try {
            int _type = T163;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:169:6: ( 'If' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:169:8: 'If'
            {
            match("If"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T163

    // $ANTLR start T164
    public final void mT164() throws RecognitionException {
        try {
            int _type = T164;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:170:6: ( 'elseIf' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:170:8: 'elseIf'
            {
            match("elseIf"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T164

    // $ANTLR start T165
    public final void mT165() throws RecognitionException {
        try {
            int _type = T165;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:171:6: ( 'else' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:171:8: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T165

    // $ANTLR start T166
    public final void mT166() throws RecognitionException {
        try {
            int _type = T166;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:172:6: ( 'ElseIf' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:172:8: 'ElseIf'
            {
            match("ElseIf"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T166

    // $ANTLR start T167
    public final void mT167() throws RecognitionException {
        try {
            int _type = T167;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:173:6: ( 'Else' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:173:8: 'Else'
            {
            match("Else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T167

    // $ANTLR start T168
    public final void mT168() throws RecognitionException {
        try {
            int _type = T168;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:174:6: ( 'CompletionCondition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:174:8: 'CompletionCondition'
            {
            match("CompletionCondition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T168

    // $ANTLR start T169
    public final void mT169() throws RecognitionException {
        try {
            int _type = T169;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:175:6: ( 'branches' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:175:8: 'branches'
            {
            match("branches"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T169

    // $ANTLR start T170
    public final void mT170() throws RecognitionException {
        try {
            int _type = T170;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:176:6: ( 'Branches' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:176:8: 'Branches'
            {
            match("Branches"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T170

    // $ANTLR start T171
    public final void mT171() throws RecognitionException {
        try {
            int _type = T171;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:177:6: ( 'countCompletedBranchesOnly' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:177:8: 'countCompletedBranchesOnly'
            {
            match("countCompletedBranchesOnly"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T171

    // $ANTLR start T172
    public final void mT172() throws RecognitionException {
        try {
            int _type = T172;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:178:6: ( 'ExtensibleElement' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:178:8: 'ExtensibleElement'
            {
            match("ExtensibleElement"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T172

    // $ANTLR start T173
    public final void mT173() throws RecognitionException {
        try {
            int _type = T173;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:179:6: ( 'Documentation' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:179:8: 'Documentation'
            {
            match("Documentation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T173

    // $ANTLR start T174
    public final void mT174() throws RecognitionException {
        try {
            int _type = T174;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:180:6: ( 'lang' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:180:8: 'lang'
            {
            match("lang"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T174

    // $ANTLR start T175
    public final void mT175() throws RecognitionException {
        try {
            int _type = T175;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:181:6: ( 'source' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:181:8: 'source'
            {
            match("source"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T175

    // $ANTLR start T176
    public final void mT176() throws RecognitionException {
        try {
            int _type = T176;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:182:6: ( 'MessageExchanges' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:182:8: 'MessageExchanges'
            {
            match("MessageExchanges"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T176

    // $ANTLR start T177
    public final void mT177() throws RecognitionException {
        try {
            int _type = T177;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:183:6: ( 'MessageExchange' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:183:8: 'MessageExchange'
            {
            match("MessageExchange"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T177

    // $ANTLR start T178
    public final void mT178() throws RecognitionException {
        try {
            int _type = T178;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:184:6: ( 'Compensate' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:184:8: 'Compensate'
            {
            match("Compensate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T178

    // $ANTLR start T179
    public final void mT179() throws RecognitionException {
        try {
            int _type = T179;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:185:6: ( 'mustUnderstand' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:185:8: 'mustUnderstand'
            {
            match("mustUnderstand"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T179

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4272:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4273:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4273:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4273:7: ~ ( '\\n' | '\\r' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4276:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("4275:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:8: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:19: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4277:30: '0'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4280:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
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
                    new NoViableAltException("4281:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:9: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:21: '0' .. '9'
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
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:43: ( '0' .. '9' )+
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4281:44: '0' .. '9'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4284:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4285:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4285:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    new NoViableAltException("4285:2: ( '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4285:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4285:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4285:19: '\\n'
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4288:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4289:2: ( ' ' | '\\t' | '\\f' )
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4292:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4293:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4293:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:
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
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4296:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:2: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:3: '\"'
            {
            match('\"'); 

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:8: ~ ( '\"' )
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
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:15: ( '\\\\' '\"' )
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:16: '\\\\' '\"'
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

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:26: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:4297:27: '\"'
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
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | T120 | T121 | T122 | T123 | T124 | T125 | T126 | T127 | T128 | T129 | T130 | T131 | T132 | T133 | T134 | T135 | T136 | T137 | T138 | T139 | T140 | T141 | T142 | T143 | T144 | T145 | T146 | T147 | T148 | T149 | T150 | T151 | T152 | T153 | T154 | T155 | T156 | T157 | T158 | T159 | T160 | T161 | T162 | T163 | T164 | T165 | T166 | T167 | T168 | T169 | T170 | T171 | T172 | T173 | T174 | T175 | T176 | T177 | T178 | T179 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 )
        int alt12=176;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:182: T54
                {
                mT54(); 

                }
                break;
            case 45 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:186: T55
                {
                mT55(); 

                }
                break;
            case 46 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:190: T56
                {
                mT56(); 

                }
                break;
            case 47 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:194: T57
                {
                mT57(); 

                }
                break;
            case 48 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:198: T58
                {
                mT58(); 

                }
                break;
            case 49 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:202: T59
                {
                mT59(); 

                }
                break;
            case 50 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:206: T60
                {
                mT60(); 

                }
                break;
            case 51 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:210: T61
                {
                mT61(); 

                }
                break;
            case 52 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:214: T62
                {
                mT62(); 

                }
                break;
            case 53 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:218: T63
                {
                mT63(); 

                }
                break;
            case 54 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:222: T64
                {
                mT64(); 

                }
                break;
            case 55 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:226: T65
                {
                mT65(); 

                }
                break;
            case 56 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:230: T66
                {
                mT66(); 

                }
                break;
            case 57 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:234: T67
                {
                mT67(); 

                }
                break;
            case 58 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:238: T68
                {
                mT68(); 

                }
                break;
            case 59 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:242: T69
                {
                mT69(); 

                }
                break;
            case 60 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:246: T70
                {
                mT70(); 

                }
                break;
            case 61 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:250: T71
                {
                mT71(); 

                }
                break;
            case 62 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:254: T72
                {
                mT72(); 

                }
                break;
            case 63 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:258: T73
                {
                mT73(); 

                }
                break;
            case 64 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:262: T74
                {
                mT74(); 

                }
                break;
            case 65 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:266: T75
                {
                mT75(); 

                }
                break;
            case 66 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:270: T76
                {
                mT76(); 

                }
                break;
            case 67 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:274: T77
                {
                mT77(); 

                }
                break;
            case 68 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:278: T78
                {
                mT78(); 

                }
                break;
            case 69 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:282: T79
                {
                mT79(); 

                }
                break;
            case 70 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:286: T80
                {
                mT80(); 

                }
                break;
            case 71 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:290: T81
                {
                mT81(); 

                }
                break;
            case 72 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:294: T82
                {
                mT82(); 

                }
                break;
            case 73 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:298: T83
                {
                mT83(); 

                }
                break;
            case 74 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:302: T84
                {
                mT84(); 

                }
                break;
            case 75 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:306: T85
                {
                mT85(); 

                }
                break;
            case 76 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:310: T86
                {
                mT86(); 

                }
                break;
            case 77 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:314: T87
                {
                mT87(); 

                }
                break;
            case 78 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:318: T88
                {
                mT88(); 

                }
                break;
            case 79 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:322: T89
                {
                mT89(); 

                }
                break;
            case 80 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:326: T90
                {
                mT90(); 

                }
                break;
            case 81 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:330: T91
                {
                mT91(); 

                }
                break;
            case 82 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:334: T92
                {
                mT92(); 

                }
                break;
            case 83 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:338: T93
                {
                mT93(); 

                }
                break;
            case 84 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:342: T94
                {
                mT94(); 

                }
                break;
            case 85 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:346: T95
                {
                mT95(); 

                }
                break;
            case 86 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:350: T96
                {
                mT96(); 

                }
                break;
            case 87 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:354: T97
                {
                mT97(); 

                }
                break;
            case 88 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:358: T98
                {
                mT98(); 

                }
                break;
            case 89 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:362: T99
                {
                mT99(); 

                }
                break;
            case 90 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:366: T100
                {
                mT100(); 

                }
                break;
            case 91 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:371: T101
                {
                mT101(); 

                }
                break;
            case 92 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:376: T102
                {
                mT102(); 

                }
                break;
            case 93 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:381: T103
                {
                mT103(); 

                }
                break;
            case 94 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:386: T104
                {
                mT104(); 

                }
                break;
            case 95 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:391: T105
                {
                mT105(); 

                }
                break;
            case 96 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:396: T106
                {
                mT106(); 

                }
                break;
            case 97 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:401: T107
                {
                mT107(); 

                }
                break;
            case 98 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:406: T108
                {
                mT108(); 

                }
                break;
            case 99 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:411: T109
                {
                mT109(); 

                }
                break;
            case 100 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:416: T110
                {
                mT110(); 

                }
                break;
            case 101 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:421: T111
                {
                mT111(); 

                }
                break;
            case 102 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:426: T112
                {
                mT112(); 

                }
                break;
            case 103 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:431: T113
                {
                mT113(); 

                }
                break;
            case 104 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:436: T114
                {
                mT114(); 

                }
                break;
            case 105 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:441: T115
                {
                mT115(); 

                }
                break;
            case 106 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:446: T116
                {
                mT116(); 

                }
                break;
            case 107 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:451: T117
                {
                mT117(); 

                }
                break;
            case 108 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:456: T118
                {
                mT118(); 

                }
                break;
            case 109 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:461: T119
                {
                mT119(); 

                }
                break;
            case 110 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:466: T120
                {
                mT120(); 

                }
                break;
            case 111 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:471: T121
                {
                mT121(); 

                }
                break;
            case 112 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:476: T122
                {
                mT122(); 

                }
                break;
            case 113 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:481: T123
                {
                mT123(); 

                }
                break;
            case 114 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:486: T124
                {
                mT124(); 

                }
                break;
            case 115 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:491: T125
                {
                mT125(); 

                }
                break;
            case 116 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:496: T126
                {
                mT126(); 

                }
                break;
            case 117 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:501: T127
                {
                mT127(); 

                }
                break;
            case 118 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:506: T128
                {
                mT128(); 

                }
                break;
            case 119 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:511: T129
                {
                mT129(); 

                }
                break;
            case 120 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:516: T130
                {
                mT130(); 

                }
                break;
            case 121 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:521: T131
                {
                mT131(); 

                }
                break;
            case 122 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:526: T132
                {
                mT132(); 

                }
                break;
            case 123 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:531: T133
                {
                mT133(); 

                }
                break;
            case 124 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:536: T134
                {
                mT134(); 

                }
                break;
            case 125 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:541: T135
                {
                mT135(); 

                }
                break;
            case 126 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:546: T136
                {
                mT136(); 

                }
                break;
            case 127 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:551: T137
                {
                mT137(); 

                }
                break;
            case 128 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:556: T138
                {
                mT138(); 

                }
                break;
            case 129 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:561: T139
                {
                mT139(); 

                }
                break;
            case 130 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:566: T140
                {
                mT140(); 

                }
                break;
            case 131 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:571: T141
                {
                mT141(); 

                }
                break;
            case 132 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:576: T142
                {
                mT142(); 

                }
                break;
            case 133 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:581: T143
                {
                mT143(); 

                }
                break;
            case 134 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:586: T144
                {
                mT144(); 

                }
                break;
            case 135 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:591: T145
                {
                mT145(); 

                }
                break;
            case 136 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:596: T146
                {
                mT146(); 

                }
                break;
            case 137 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:601: T147
                {
                mT147(); 

                }
                break;
            case 138 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:606: T148
                {
                mT148(); 

                }
                break;
            case 139 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:611: T149
                {
                mT149(); 

                }
                break;
            case 140 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:616: T150
                {
                mT150(); 

                }
                break;
            case 141 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:621: T151
                {
                mT151(); 

                }
                break;
            case 142 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:626: T152
                {
                mT152(); 

                }
                break;
            case 143 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:631: T153
                {
                mT153(); 

                }
                break;
            case 144 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:636: T154
                {
                mT154(); 

                }
                break;
            case 145 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:641: T155
                {
                mT155(); 

                }
                break;
            case 146 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:646: T156
                {
                mT156(); 

                }
                break;
            case 147 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:651: T157
                {
                mT157(); 

                }
                break;
            case 148 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:656: T158
                {
                mT158(); 

                }
                break;
            case 149 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:661: T159
                {
                mT159(); 

                }
                break;
            case 150 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:666: T160
                {
                mT160(); 

                }
                break;
            case 151 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:671: T161
                {
                mT161(); 

                }
                break;
            case 152 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:676: T162
                {
                mT162(); 

                }
                break;
            case 153 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:681: T163
                {
                mT163(); 

                }
                break;
            case 154 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:686: T164
                {
                mT164(); 

                }
                break;
            case 155 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:691: T165
                {
                mT165(); 

                }
                break;
            case 156 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:696: T166
                {
                mT166(); 

                }
                break;
            case 157 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:701: T167
                {
                mT167(); 

                }
                break;
            case 158 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:706: T168
                {
                mT168(); 

                }
                break;
            case 159 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:711: T169
                {
                mT169(); 

                }
                break;
            case 160 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:716: T170
                {
                mT170(); 

                }
                break;
            case 161 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:721: T171
                {
                mT171(); 

                }
                break;
            case 162 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:726: T172
                {
                mT172(); 

                }
                break;
            case 163 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:731: T173
                {
                mT173(); 

                }
                break;
            case 164 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:736: T174
                {
                mT174(); 

                }
                break;
            case 165 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:741: T175
                {
                mT175(); 

                }
                break;
            case 166 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:746: T176
                {
                mT176(); 

                }
                break;
            case 167 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:751: T177
                {
                mT177(); 

                }
                break;
            case 168 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:756: T178
                {
                mT178(); 

                }
                break;
            case 169 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:761: T179
                {
                mT179(); 

                }
                break;
            case 170 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:766: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 171 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:774: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 172 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:782: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 173 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:788: LB
                {
                mLB(); 

                }
                break;
            case 174 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:791: WS
                {
                mWS(); 

                }
                break;
            case 175 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:794: TEXT
                {
                mTEXT(); 

                }
                break;
            case 176 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.bpel.model.resource.bpws\\src\\org\\eclipse\\bpel\\model\\resource\\bpws\\Bpws.g:1:799: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\61\1\uffff\1\61\1\uffff\14\61\1\uffff\31\61\1\uffff"+
        "\1\61\2\u008a\4\uffff\14\61\1\u009c\43\61\1\u00cb\12\61\1\u00dc"+
        "\32\61\1\u008a\2\uffff\20\61\1\uffff\3\61\1\u0110\14\61\1\u011f"+
        "\35\61\1\uffff\20\61\1\uffff\42\61\1\u0170\6\61\1\u0178\2\61\1\u017c"+
        "\3\61\1\u0180\2\61\1\uffff\6\61\1\u018a\7\61\1\uffff\1\61\1\u0194"+
        "\3\61\1\u0198\14\61\1\u01a7\1\61\1\u01a9\5\61\1\u01b0\6\61\1\u01b8"+
        "\5\61\1\u01be\3\61\1\u01c3\4\61\1\u01c8\6\61\1\u01cf\13\61\1\u01db"+
        "\14\61\1\uffff\7\61\1\uffff\3\61\1\uffff\3\61\1\uffff\1\u01f7\4"+
        "\61\1\u01fc\3\61\1\uffff\5\61\1\u0205\3\61\1\uffff\3\61\1\uffff"+
        "\3\61\1\u0215\12\61\1\uffff\1\61\1\uffff\6\61\1\uffff\1\u0228\5"+
        "\61\1\u022e\1\uffff\1\u022f\4\61\1\uffff\2\61\1\u0236\1\61\1\uffff"+
        "\2\61\1\u023a\1\61\1\uffff\1\u023c\1\u023d\4\61\1\uffff\1\u0242"+
        "\12\61\1\uffff\7\61\1\u0254\5\61\1\u025a\5\61\1\u0260\4\61\1\u0267"+
        "\1\u0268\1\61\1\uffff\1\61\1\u026c\2\61\1\uffff\10\61\1\uffff\17"+
        "\61\1\uffff\6\61\1\u028e\5\61\1\u0294\5\61\1\uffff\1\u029a\1\u029b"+
        "\1\61\1\u029d\1\61\2\uffff\6\61\1\uffff\1\u02a5\1\u02a7\1\u02a8"+
        "\1\uffff\1\61\2\uffff\1\61\1\u02ac\2\61\1\uffff\21\61\1\uffff\3"+
        "\61\1\u02c4\1\61\1\uffff\5\61\1\uffff\1\u02cc\3\61\1\u02d0\1\61"+
        "\2\uffff\2\61\1\u02d4\1\uffff\6\61\1\u02dc\27\61\1\u02f6\2\61\1"+
        "\uffff\3\61\1\u02fe\1\61\1\uffff\5\61\2\uffff\1\61\1\uffff\2\61"+
        "\1\u0308\1\u0309\3\61\1\uffff\1\u030e\2\uffff\2\61\1\u0311\1\uffff"+
        "\2\61\1\u0314\1\61\1\u0316\1\u0317\21\61\1\uffff\7\61\1\uffff\3"+
        "\61\1\uffff\3\61\1\uffff\2\61\1\u0338\1\u033b\2\61\1\u033e\1\uffff"+
        "\1\61\1\u0340\1\u0341\1\u0342\7\61\1\u034a\1\u034b\6\61\1\u0352"+
        "\2\61\1\u0355\2\61\1\uffff\3\61\1\u035b\2\61\1\u035e\1\uffff\1\u035f"+
        "\4\61\1\u0364\3\61\2\uffff\4\61\1\uffff\2\61\1\uffff\1\u036e\1\61"+
        "\1\uffff\1\u0370\2\uffff\5\61\1\u0376\1\u0377\1\61\1\u0379\1\u037b"+
        "\17\61\1\u038b\6\61\1\uffff\1\61\1\u0393\1\uffff\2\61\1\uffff\1"+
        "\61\3\uffff\5\61\1\u039c\1\61\2\uffff\5\61\1\u03a3\1\uffff\2\61"+
        "\1\uffff\5\61\1\uffff\2\61\2\uffff\1\61\1\u03ae\2\61\1\uffff\1\u03b2"+
        "\10\61\1\uffff\1\61\1\uffff\1\u03bd\4\61\2\uffff\1\61\1\uffff\1"+
        "\u03c3\1\uffff\11\61\1\u03cd\1\u03cf\4\61\1\uffff\3\61\1\u03d7\3"+
        "\61\1\uffff\2\61\1\u03dd\1\u03de\4\61\1\uffff\6\61\1\uffff\3\61"+
        "\1\u03ec\6\61\1\uffff\1\61\1\u03f5\1\61\1\uffff\3\61\1\u03fa\2\61"+
        "\1\u03fd\2\61\1\u0400\1\uffff\5\61\1\uffff\1\u0406\4\61\1\u040d"+
        "\3\61\1\uffff\1\61\1\uffff\2\61\1\u0414\4\61\1\uffff\3\61\1\u041d"+
        "\1\u041e\2\uffff\6\61\1\u0426\6\61\1\uffff\1\61\1\u042e\3\61\1\u0434"+
        "\2\61\1\uffff\2\61\1\u0439\1\61\1\uffff\2\61\1\uffff\2\61\1\uffff"+
        "\1\61\1\u0440\3\61\1\uffff\5\61\1\u0449\1\uffff\6\61\1\uffff\7\61"+
        "\1\u0457\2\uffff\1\u0459\1\u045a\3\61\1\u045e\1\61\1\uffff\7\61"+
        "\1\uffff\2\61\1\u0469\1\61\1\u046b\1\uffff\4\61\1\uffff\1\u0470"+
        "\5\61\1\uffff\10\61\1\uffff\1\61\1\u0480\1\u0481\6\61\1\u0488\3"+
        "\61\1\uffff\1\u048c\2\uffff\1\u048d\2\61\1\uffff\5\61\1\u0495\4"+
        "\61\1\uffff\1\61\1\uffff\4\61\1\uffff\3\61\1\u04a2\5\61\1\u04a8"+
        "\1\u04a9\4\61\2\uffff\6\61\1\uffff\3\61\2\uffff\6\61\1\u04bd\1\uffff"+
        "\3\61\1\u04c1\1\u04c3\3\61\1\u04c7\3\61\1\uffff\1\u04cb\4\61\2\uffff"+
        "\1\61\1\u04d1\1\u04d2\6\61\1\u04d9\5\61\1\u04df\3\61\1\uffff\3\61"+
        "\1\uffff\1\u04e6\1\uffff\1\61\1\u04e8\1\61\1\uffff\3\61\1\uffff"+
        "\1\u04ed\3\61\1\u04f2\2\uffff\6\61\1\uffff\3\61\1\u04fc\1\61\1\uffff"+
        "\5\61\1\u0503\1\uffff\1\61\1\uffff\4\61\1\uffff\3\61\1\u050c\1\uffff"+
        "\3\61\1\u0510\2\61\1\u0513\2\61\1\uffff\1\u0516\5\61\1\uffff\2\61"+
        "\1\u051e\1\u051f\2\61\1\u0522\1\61\1\uffff\1\61\1\u0525\1\61\1\uffff"+
        "\2\61\1\uffff\2\61\1\uffff\7\61\2\uffff\1\u0532\1\u0533\1\uffff"+
        "\2\61\1\uffff\1\u0536\1\61\1\u0538\1\u0539\2\61\1\u053c\1\u053d"+
        "\2\61\1\u0540\1\u0541\2\uffff\1\61\1\u0543\1\uffff\1\61\2\uffff"+
        "\2\61\2\uffff\2\61\2\uffff\1\61\1\uffff\3\61\1\u054d\1\u054e\1\61"+
        "\1\u0550\2\61\2\uffff\1\61\1\uffff\11\61\1\u055d\1\u055e\1\61\2"+
        "\uffff\2\61\1\u0562\1\uffff";
    static final String DFA12_eofS =
        "\u0563\uffff";
    static final String DFA12_minS =
        "\1\11\1\141\1\uffff\1\157\1\uffff\1\105\2\141\1\165\1\145\2\141"+
        "\1\143\2\141\1\147\1\145\1\uffff\1\141\1\143\1\141\1\146\1\160\1"+
        "\151\1\145\1\154\2\141\1\156\1\145\1\141\1\156\2\145\2\157\1\141"+
        "\1\123\1\156\1\157\1\165\1\157\1\145\1\uffff\1\60\2\55\4\uffff\1"+
        "\162\1\157\2\143\1\145\1\151\1\144\1\145\1\170\1\155\1\141\1\162"+
        "\1\55\1\160\1\145\1\162\1\165\1\141\1\160\1\154\1\162\1\157\1\162"+
        "\1\164\1\141\1\165\1\162\1\156\1\157\1\151\1\155\1\164\1\145\1\151"+
        "\1\160\1\156\1\163\1\122\1\163\1\165\1\157\1\162\1\157\1\164\1\163"+
        "\1\155\1\164\1\166\1\55\1\160\1\141\1\164\1\156\1\143\1\145\1\151"+
        "\1\160\1\163\1\162\1\55\2\162\2\151\1\163\1\165\1\161\2\156\1\143"+
        "\1\101\1\141\1\146\1\145\1\141\1\144\1\141\1\157\1\154\1\104\1\153"+
        "\1\151\1\145\1\143\1\163\1\56\1\55\2\uffff\1\164\1\143\1\153\1\165"+
        "\1\156\1\145\1\162\1\164\1\160\1\145\1\155\1\164\1\145\1\156\1\147"+
        "\1\141\1\uffff\1\145\1\162\1\166\1\55\2\162\1\160\2\151\1\141\1"+
        "\164\1\160\1\164\1\151\1\162\1\154\1\55\1\141\1\155\1\154\1\162"+
        "\1\156\1\171\1\160\1\144\1\143\1\141\1\165\1\164\2\157\1\163\1\157"+
        "\1\164\1\154\1\155\1\105\1\167\2\151\1\162\1\144\1\160\1\171\1\143"+
        "\1\157\1\uffff\1\157\1\162\1\161\1\160\1\153\2\145\1\150\1\156\1"+
        "\164\1\162\1\145\1\164\1\145\1\147\1\141\1\uffff\1\157\1\155\1\164"+
        "\1\154\1\151\1\141\1\162\1\165\1\166\1\147\1\153\1\145\1\141\1\154"+
        "\1\166\1\145\1\161\2\145\1\160\1\156\1\171\1\156\1\154\2\151\1\105"+
        "\2\156\1\162\1\165\1\163\1\156\1\145\1\55\1\155\1\164\1\156\1\145"+
        "\1\117\1\157\1\55\2\145\1\55\1\163\1\145\1\162\1\55\1\171\1\151"+
        "\1\uffff\1\143\1\164\1\162\1\145\1\144\1\141\1\55\1\154\2\145\1"+
        "\124\1\166\1\155\1\164\1\uffff\1\154\1\55\1\144\1\145\1\164\1\55"+
        "\1\145\1\151\1\150\2\164\1\151\2\162\1\141\1\154\1\125\1\164\1\55"+
        "\1\141\1\55\1\166\1\147\1\145\1\151\1\145\1\55\1\150\1\153\1\162"+
        "\1\141\2\165\1\55\1\171\1\141\1\151\1\162\1\164\1\55\1\145\1\156"+
        "\1\171\1\55\1\145\1\162\1\167\1\151\1\55\1\145\1\154\1\146\1\143"+
        "\1\145\1\151\1\55\1\163\1\162\1\164\1\141\1\145\1\163\1\165\1\141"+
        "\1\162\1\123\1\143\1\55\1\143\1\145\1\144\1\141\1\154\1\157\1\103"+
        "\1\171\1\155\1\141\1\145\1\163\1\uffff\1\145\1\110\2\163\1\156\1"+
        "\151\1\146\1\uffff\2\156\1\160\1\uffff\1\151\2\164\1\uffff\1\55"+
        "\1\143\1\145\1\103\1\145\1\55\1\141\1\142\1\145\1\uffff\1\154\2"+
        "\162\1\171\1\151\1\55\1\105\1\103\1\141\1\uffff\1\162\1\154\1\103"+
        "\1\uffff\1\156\1\145\1\164\1\55\1\145\1\126\1\141\1\164\1\145\1"+
        "\147\1\145\1\156\1\110\1\141\1\uffff\1\143\1\uffff\1\151\1\156\1"+
        "\154\1\164\1\156\1\145\1\uffff\1\55\1\145\2\164\1\145\1\164\1\55"+
        "\1\uffff\1\55\1\164\1\166\1\157\1\110\1\uffff\2\163\1\55\1\146\1"+
        "\uffff\2\164\1\55\1\156\1\uffff\2\55\2\145\1\156\1\143\1\uffff\1"+
        "\55\1\141\1\151\1\162\1\156\1\163\1\145\1\164\1\145\1\162\1\150"+
        "\1\uffff\1\150\2\141\1\142\1\145\1\167\1\157\1\55\1\145\1\147\1"+
        "\162\1\163\1\156\1\55\1\141\1\151\1\163\1\123\1\156\1\55\1\164\1"+
        "\163\1\141\1\164\2\55\1\141\1\uffff\1\145\1\55\1\157\1\163\1\uffff"+
        "\1\164\1\154\1\162\1\145\1\156\1\164\1\160\1\164\1\uffff\1\141\1"+
        "\154\1\141\1\145\1\141\1\157\1\162\1\145\1\141\1\162\1\157\1\163"+
        "\1\164\1\151\1\154\1\uffff\1\111\1\141\1\154\1\124\1\115\1\145\1"+
        "\55\1\144\1\141\1\162\1\150\1\164\1\55\1\141\1\151\1\163\1\164\1"+
        "\154\1\uffff\2\55\1\151\1\55\1\126\2\uffff\1\125\1\145\1\167\1\141"+
        "\1\163\1\151\1\uffff\3\55\1\uffff\1\141\2\uffff\1\114\1\55\1\143"+
        "\1\145\1\uffff\1\154\1\157\1\155\1\164\1\141\1\101\1\105\1\156\1"+
        "\143\2\145\1\156\1\164\1\154\1\155\2\156\1\uffff\1\156\1\145\1\101"+
        "\1\55\1\164\1\uffff\1\156\1\157\1\151\2\164\1\uffff\1\55\1\151\1"+
        "\143\1\151\1\55\1\141\2\uffff\1\156\1\122\1\55\1\uffff\1\165\1\163"+
        "\2\145\1\114\1\154\1\55\1\151\1\145\1\151\1\156\1\145\1\162\1\163"+
        "\1\155\1\165\1\164\1\156\1\164\1\116\1\155\1\141\1\151\1\157\1\154"+
        "\1\156\1\162\1\145\1\151\1\171\1\55\1\151\1\105\1\uffff\1\145\1"+
        "\156\1\164\1\55\1\171\1\uffff\1\164\1\157\1\141\1\151\1\154\2\uffff"+
        "\1\157\1\uffff\1\141\1\156\2\55\1\156\1\151\1\142\1\uffff\1\55\2"+
        "\uffff\1\164\1\151\1\55\1\uffff\1\145\1\122\1\55\1\156\2\55\1\147"+
        "\1\143\1\166\1\143\1\105\2\163\1\105\3\145\1\105\1\144\1\164\1\105"+
        "\1\151\1\143\1\uffff\1\141\1\144\1\156\1\157\1\141\1\122\1\171\1"+
        "\uffff\1\142\1\145\1\157\1\uffff\1\155\1\147\1\145\1\uffff\1\156"+
        "\1\112\2\55\1\151\1\157\1\55\1\uffff\1\145\3\55\1\145\1\144\1\155"+
        "\1\151\1\163\1\145\1\156\2\55\1\151\1\141\1\160\1\164\1\157\1\156"+
        "\1\55\1\163\1\151\1\55\1\172\1\160\1\uffff\1\163\1\171\1\170\1\55"+
        "\1\162\1\144\1\55\1\uffff\1\55\1\151\1\156\1\164\1\157\1\55\1\156"+
        "\1\162\1\164\2\uffff\1\144\1\157\1\154\1\156\1\uffff\1\151\1\164"+
        "\1\uffff\1\55\1\145\1\uffff\1\55\2\uffff\1\145\1\164\2\145\1\154"+
        "\2\55\1\170\2\55\1\156\1\170\1\151\1\141\1\170\1\156\2\164\1\154"+
        "\1\163\2\156\1\145\1\160\1\151\1\55\1\156\1\145\1\165\1\146\1\164"+
        "\1\157\1\uffff\1\143\1\55\1\uffff\1\156\1\154\1\uffff\1\163\3\uffff"+
        "\1\163\1\154\1\145\2\141\1\55\1\164\2\uffff\1\157\1\155\1\154\1"+
        "\151\1\156\1\55\1\uffff\1\164\1\141\1\uffff\2\145\1\163\1\160\1"+
        "\143\1\uffff\1\163\1\154\2\uffff\1\157\1\55\1\145\1\156\1\uffff"+
        "\1\55\2\151\1\154\1\156\1\145\1\101\1\157\1\145\1\uffff\1\146\1"+
        "\uffff\1\55\1\151\1\162\1\123\1\145\2\uffff\1\160\1\uffff\1\55\1"+
        "\uffff\4\164\1\143\1\153\2\151\1\145\2\55\1\144\1\146\1\145\1\154"+
        "\1\uffff\1\103\1\163\1\141\1\55\1\145\1\151\1\143\1\uffff\1\153"+
        "\1\145\2\55\1\145\1\156\1\142\1\147\1\uffff\1\145\1\156\2\145\1"+
        "\157\1\103\1\uffff\1\141\1\142\1\120\1\55\1\151\1\145\1\150\1\164"+
        "\1\145\1\156\1\uffff\1\157\1\55\1\103\1\uffff\1\141\1\154\1\145"+
        "\1\55\1\105\1\143\1\55\1\156\1\162\1\55\1\uffff\1\166\1\171\1\143"+
        "\1\155\1\162\1\uffff\1\55\1\145\2\151\1\150\1\55\1\166\1\157\1\162"+
        "\1\uffff\1\141\1\uffff\1\141\1\145\1\55\1\151\1\157\1\160\1\147"+
        "\1\uffff\1\162\1\156\1\145\2\55\2\uffff\1\162\1\164\1\154\1\145"+
        "\1\162\1\123\1\55\1\164\1\156\1\157\1\156\1\154\1\141\1\uffff\1"+
        "\156\1\55\2\141\1\162\1\55\1\156\1\143\1\uffff\1\157\1\142\1\55"+
        "\1\162\1\uffff\1\154\1\164\1\uffff\1\110\1\141\1\uffff\1\151\1\55"+
        "\1\150\2\145\1\uffff\1\156\2\157\1\141\1\171\1\55\1\uffff\1\151"+
        "\1\156\1\163\1\156\2\162\1\uffff\1\164\1\156\1\141\1\145\1\126\1"+
        "\106\1\163\1\55\2\uffff\2\55\1\145\1\124\1\126\1\55\1\145\1\uffff"+
        "\1\145\1\110\1\156\1\143\1\145\1\162\1\147\1\uffff\2\156\1\55\1"+
        "\145\1\55\1\uffff\1\110\1\157\1\156\1\154\1\uffff\1\55\1\145\1\151"+
        "\1\141\1\154\1\164\1\uffff\1\145\1\156\2\163\3\156\1\160\1\uffff"+
        "\1\164\2\55\1\147\1\144\1\145\1\171\1\144\1\143\1\55\2\141\1\163"+
        "\1\uffff\1\55\2\uffff\1\55\1\171\1\141\1\uffff\1\164\1\144\1\141"+
        "\1\144\1\145\1\55\1\164\1\106\1\147\1\144\1\uffff\1\164\1\uffff"+
        "\1\141\1\160\1\144\1\145\1\uffff\1\155\1\166\1\156\1\55\1\171\1"+
        "\155\1\164\1\163\1\151\2\55\1\147\1\145\1\171\1\154\2\uffff\1\165"+
        "\1\106\1\156\1\105\1\151\1\145\1\uffff\1\154\1\151\1\123\2\uffff"+
        "\1\160\1\154\1\163\1\102\1\156\1\151\1\55\1\uffff\1\156\1\162\1"+
        "\145\2\55\1\156\1\145\1\151\1\55\1\145\1\151\1\144\1\uffff\1\55"+
        "\1\145\1\116\1\151\1\142\2\uffff\1\145\2\55\1\145\2\141\1\143\1"+
        "\154\1\164\1\55\1\165\1\154\2\145\1\165\1\55\1\162\1\144\1\164\1"+
        "\uffff\1\145\1\157\1\163\1\uffff\1\55\1\uffff\1\144\1\55\1\164\1"+
        "\uffff\1\156\1\164\1\154\1\uffff\1\55\1\141\1\157\1\151\1\55\2\uffff"+
        "\1\155\1\147\1\165\2\145\1\151\1\uffff\1\145\1\165\1\162\1\55\1"+
        "\145\1\uffff\1\141\1\154\1\151\1\162\1\155\1\55\1\uffff\1\154\1"+
        "\uffff\1\151\1\164\1\171\1\145\1\uffff\1\155\1\156\1\154\1\55\1"+
        "\uffff\2\145\1\154\1\55\1\155\1\157\1\55\1\162\1\151\1\uffff\1\55"+
        "\1\156\1\145\1\157\1\122\1\104\1\uffff\1\145\1\157\2\55\1\162\1"+
        "\145\1\55\1\151\1\uffff\1\156\1\55\1\164\1\uffff\1\145\1\156\1\uffff"+
        "\1\145\1\141\1\uffff\1\143\1\162\1\156\1\157\1\141\1\162\1\156\2"+
        "\uffff\2\55\1\uffff\2\164\1\uffff\1\55\1\156\2\55\1\154\1\150\2"+
        "\55\1\154\1\164\2\55\2\uffff\1\171\1\55\1\uffff\1\164\2\uffff\1"+
        "\151\1\145\2\uffff\1\145\1\141\2\uffff\1\101\1\uffff\1\163\1\172"+
        "\1\163\2\55\1\164\1\55\1\141\1\117\2\uffff\1\164\1\uffff\1\142\1"+
        "\156\1\162\2\154\1\151\1\145\1\171\1\142\2\55\1\165\2\uffff\1\164"+
        "\1\145\1\55\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\162\1\uffff\1\157\1\uffff\1\170\1\141\1\171\2\165\1\141"+
        "\1\162\1\154\2\162\1\156\1\171\1\uffff\1\162\1\163\1\157\1\156\1"+
        "\165\1\151\1\145\1\170\1\157\1\150\1\156\2\157\1\160\2\145\2\162"+
        "\1\141\1\123\1\156\1\157\1\165\1\157\1\145\1\uffff\1\71\2\172\4"+
        "\uffff\1\162\1\157\2\143\1\145\1\164\1\144\1\163\1\170\1\155\1\141"+
        "\1\162\1\172\1\160\1\145\1\164\1\165\1\141\1\160\1\162\1\164\1\157"+
        "\1\162\1\164\1\141\1\165\1\162\1\156\1\157\1\151\1\165\1\164\1\145"+
        "\2\160\1\156\1\163\1\122\1\163\1\165\1\157\1\162\1\157\1\164\1\163"+
        "\1\162\1\164\1\166\1\172\1\160\1\145\1\164\1\156\1\164\1\145\1\164"+
        "\1\160\1\163\1\162\1\172\2\162\2\151\1\164\1\165\1\162\1\156\1\164"+
        "\1\143\1\115\1\141\1\160\1\145\1\141\1\144\1\141\1\157\1\162\1\104"+
        "\1\153\1\151\1\145\1\143\1\163\1\56\1\172\2\uffff\1\164\1\143\1"+
        "\153\1\165\1\156\1\145\1\162\1\164\1\160\1\145\1\155\1\164\1\145"+
        "\1\156\1\147\1\141\1\uffff\1\145\1\162\1\166\1\172\2\162\1\160\1"+
        "\165\1\151\2\164\1\160\1\164\1\151\1\162\1\154\1\172\1\141\1\155"+
        "\1\154\1\162\1\156\1\171\1\160\1\144\1\143\1\141\1\165\1\164\2\157"+
        "\1\163\1\157\1\164\1\154\1\155\1\105\1\167\2\151\1\162\1\144\1\160"+
        "\1\171\1\143\1\157\1\uffff\1\157\1\162\1\161\1\160\1\153\1\154\1"+
        "\145\1\150\1\156\1\164\1\162\1\145\1\164\1\145\1\147\1\141\1\uffff"+
        "\1\157\1\155\1\164\1\154\1\151\1\141\1\162\1\165\1\166\1\147\1\153"+
        "\1\145\1\141\1\154\1\166\1\145\1\161\2\145\1\160\1\156\1\171\1\156"+
        "\1\154\2\151\1\105\2\156\1\162\1\165\1\163\1\156\1\145\1\172\1\155"+
        "\1\164\1\156\1\145\1\117\1\157\1\172\2\145\1\172\1\163\1\145\1\162"+
        "\1\172\1\171\1\151\1\uffff\1\143\1\164\1\162\1\145\1\144\1\141\1"+
        "\172\1\154\2\145\1\124\1\166\1\155\1\164\1\uffff\1\154\1\172\1\144"+
        "\1\145\1\164\1\172\1\154\1\151\1\150\2\164\1\151\2\162\1\141\1\154"+
        "\1\125\1\164\1\172\1\141\1\172\1\166\1\147\1\145\1\151\1\154\1\172"+
        "\1\150\1\153\1\162\1\141\2\165\1\172\1\171\1\141\1\151\1\162\1\164"+
        "\1\172\1\145\1\156\1\171\1\172\1\145\1\162\1\167\1\151\1\172\1\145"+
        "\1\154\1\146\1\143\1\145\1\151\1\172\1\163\1\162\1\164\1\141\1\145"+
        "\1\163\1\165\1\141\1\162\1\123\1\143\1\172\1\143\1\145\1\144\1\141"+
        "\1\154\1\157\1\103\1\171\1\155\1\141\1\145\1\163\1\uffff\1\145\3"+
        "\163\1\156\1\151\1\146\1\uffff\2\156\1\160\1\uffff\1\151\2\164\1"+
        "\uffff\1\172\1\143\1\145\1\103\1\145\1\172\1\141\1\142\1\145\1\uffff"+
        "\1\154\2\162\1\171\1\151\1\172\1\126\1\103\1\141\1\uffff\1\162\1"+
        "\154\1\145\1\uffff\1\156\1\145\1\164\1\172\1\145\1\126\1\141\1\164"+
        "\1\145\1\147\1\145\1\156\1\110\1\141\1\uffff\1\143\1\uffff\1\151"+
        "\1\156\1\154\1\164\1\156\1\145\1\uffff\1\172\1\145\2\164\1\145\1"+
        "\164\1\172\1\uffff\1\172\1\164\1\166\1\157\1\110\1\uffff\2\163\1"+
        "\172\1\146\1\uffff\2\164\1\172\1\156\1\uffff\2\172\2\145\1\156\1"+
        "\143\1\uffff\1\172\1\141\1\151\1\162\1\156\1\163\1\145\1\164\1\145"+
        "\1\162\1\150\1\uffff\1\150\2\141\1\142\1\145\1\167\1\157\1\172\1"+
        "\145\1\147\1\162\1\163\1\156\1\172\1\141\1\151\1\163\1\123\1\156"+
        "\1\172\1\164\1\163\1\141\1\164\2\172\1\141\1\uffff\1\145\1\172\1"+
        "\157\1\163\1\uffff\1\164\1\154\1\162\1\145\1\156\1\164\1\160\1\164"+
        "\1\uffff\1\141\1\154\1\141\1\145\1\141\1\157\1\162\1\145\1\141\1"+
        "\162\1\157\1\163\1\164\1\151\1\154\1\uffff\1\111\1\141\1\164\1\163"+
        "\1\115\1\145\1\172\1\144\1\141\1\162\1\150\1\164\1\172\1\141\1\151"+
        "\1\163\1\164\1\154\1\uffff\2\172\1\151\1\172\1\126\2\uffff\1\125"+
        "\1\145\1\167\1\141\1\163\1\151\1\uffff\3\172\1\uffff\1\141\2\uffff"+
        "\1\114\1\172\1\143\1\145\1\uffff\1\154\1\157\1\155\1\164\1\141\1"+
        "\101\1\105\1\156\1\143\2\145\1\156\1\164\1\154\1\155\2\156\1\uffff"+
        "\1\156\1\145\1\114\1\172\1\164\1\uffff\1\156\1\157\1\151\2\164\1"+
        "\uffff\1\172\1\151\1\143\1\151\1\172\1\141\2\uffff\1\156\1\122\1"+
        "\172\1\uffff\1\165\1\163\2\145\1\122\1\154\1\172\1\171\1\145\1\171"+
        "\1\156\1\145\1\162\1\163\1\155\1\165\1\164\1\156\1\164\1\116\1\155"+
        "\1\141\1\151\1\157\1\154\1\156\1\162\1\145\1\151\1\171\1\172\1\151"+
        "\1\163\1\uffff\1\145\1\156\1\164\1\172\1\171\1\uffff\1\164\1\157"+
        "\1\141\1\151\1\154\2\uffff\1\157\1\uffff\1\141\1\156\2\172\1\156"+
        "\1\151\1\157\1\uffff\1\172\2\uffff\1\164\1\151\1\172\1\uffff\1\145"+
        "\1\122\1\172\1\156\2\172\1\147\1\143\1\166\1\143\1\105\2\163\1\105"+
        "\3\145\1\105\1\144\1\164\1\105\1\151\1\143\1\uffff\1\141\1\144\1"+
        "\156\1\157\1\141\1\122\1\171\1\uffff\1\142\1\145\1\157\1\uffff\1"+
        "\155\1\147\1\145\1\uffff\1\156\1\112\2\172\1\151\1\157\1\172\1\uffff"+
        "\1\145\3\172\1\145\1\144\1\155\1\151\1\163\1\145\1\156\2\172\1\151"+
        "\1\141\1\160\1\164\1\157\1\156\1\172\1\163\1\151\2\172\1\160\1\uffff"+
        "\1\163\1\171\1\170\1\172\1\162\1\144\1\172\1\uffff\1\172\1\151\1"+
        "\156\1\164\1\157\1\172\1\156\1\162\1\164\2\uffff\1\144\1\157\1\154"+
        "\1\156\1\uffff\1\151\1\164\1\uffff\1\172\1\145\1\uffff\1\172\2\uffff"+
        "\1\145\1\164\2\145\1\154\2\172\1\170\2\172\1\156\1\170\1\151\1\141"+
        "\1\170\1\156\2\164\1\154\1\163\2\156\1\145\1\160\1\151\1\172\1\156"+
        "\1\145\1\165\1\146\1\164\1\157\1\uffff\1\143\1\172\1\uffff\1\156"+
        "\1\154\1\uffff\1\163\3\uffff\1\163\1\154\1\145\2\141\1\172\1\164"+
        "\2\uffff\1\157\1\155\1\154\1\151\1\156\1\172\1\uffff\1\164\1\141"+
        "\1\uffff\2\145\1\163\1\160\1\143\1\uffff\1\163\1\154\2\uffff\1\157"+
        "\1\172\1\151\1\156\1\uffff\1\172\2\151\1\154\1\156\1\145\1\163\1"+
        "\157\1\145\1\uffff\1\146\1\uffff\1\172\1\151\1\162\1\123\1\145\2"+
        "\uffff\1\160\1\uffff\1\172\1\uffff\4\164\1\143\1\153\2\151\1\145"+
        "\2\172\1\144\1\146\1\145\1\154\1\uffff\1\103\1\163\1\141\1\172\1"+
        "\145\1\151\1\143\1\uffff\1\153\1\145\2\172\1\145\1\156\1\142\1\147"+
        "\1\uffff\1\145\1\156\2\145\1\157\1\103\1\uffff\1\141\1\142\1\120"+
        "\1\172\1\151\1\145\1\150\1\164\1\145\1\156\1\uffff\1\157\1\172\1"+
        "\103\1\uffff\1\141\1\154\1\145\1\172\1\105\1\143\1\172\1\156\1\162"+
        "\1\172\1\uffff\1\166\1\171\1\143\1\155\1\162\1\uffff\1\172\1\145"+
        "\2\151\1\150\1\172\1\166\1\157\1\162\1\uffff\1\141\1\uffff\1\141"+
        "\1\145\1\172\1\151\1\157\1\160\1\147\1\uffff\1\162\1\156\1\145\2"+
        "\172\2\uffff\1\162\1\164\1\154\1\145\1\162\1\163\1\172\1\164\1\156"+
        "\1\157\1\156\1\154\1\141\1\uffff\1\156\1\172\2\141\1\162\1\172\1"+
        "\156\1\143\1\uffff\1\157\1\142\1\172\1\162\1\uffff\1\154\1\164\1"+
        "\uffff\1\110\1\141\1\uffff\1\151\1\172\1\150\2\145\1\uffff\1\156"+
        "\2\157\1\141\1\171\1\172\1\uffff\1\151\1\156\1\163\1\156\2\162\1"+
        "\uffff\1\164\1\156\1\141\1\145\1\126\1\106\1\163\1\172\2\uffff\2"+
        "\172\1\145\1\124\1\126\1\172\1\145\1\uffff\1\145\1\110\1\156\1\143"+
        "\1\145\1\162\1\147\1\uffff\2\156\1\172\1\145\1\172\1\uffff\1\110"+
        "\1\157\1\156\1\154\1\uffff\1\172\1\145\1\151\1\141\1\154\1\164\1"+
        "\uffff\1\145\1\156\2\163\3\156\1\160\1\uffff\1\164\2\172\1\147\1"+
        "\144\1\145\1\171\1\144\1\143\1\172\2\141\1\163\1\uffff\1\172\2\uffff"+
        "\1\172\1\171\1\141\1\uffff\1\164\1\144\1\141\1\144\1\145\1\172\1"+
        "\164\1\106\1\147\1\144\1\uffff\1\164\1\uffff\1\141\1\160\1\144\1"+
        "\145\1\uffff\1\155\1\166\1\156\1\172\1\171\1\155\1\164\1\163\1\151"+
        "\2\172\1\147\1\145\1\171\1\154\2\uffff\1\165\1\106\1\156\1\105\1"+
        "\151\1\145\1\uffff\1\154\1\151\1\123\2\uffff\1\160\1\154\1\163\1"+
        "\102\1\156\1\151\1\172\1\uffff\1\156\1\162\1\145\2\172\1\156\1\145"+
        "\1\151\1\172\1\145\1\151\1\144\1\uffff\1\172\1\145\1\116\1\151\1"+
        "\142\2\uffff\1\145\2\172\1\145\2\141\1\143\1\154\1\164\1\172\1\165"+
        "\1\154\2\145\1\165\1\172\1\162\1\144\1\164\1\uffff\1\145\1\157\1"+
        "\163\1\uffff\1\172\1\uffff\1\144\1\172\1\164\1\uffff\1\156\1\164"+
        "\1\154\1\uffff\1\172\1\141\1\157\1\151\1\172\2\uffff\1\155\1\147"+
        "\1\165\2\145\1\151\1\uffff\1\145\1\165\1\162\1\172\1\145\1\uffff"+
        "\1\141\1\154\1\151\1\162\1\155\1\172\1\uffff\1\154\1\uffff\1\151"+
        "\1\164\1\171\1\145\1\uffff\1\155\1\156\1\154\1\172\1\uffff\2\145"+
        "\1\154\1\172\1\155\1\157\1\172\1\162\1\151\1\uffff\1\172\1\156\1"+
        "\145\1\157\1\122\1\104\1\uffff\1\145\1\157\2\172\1\162\1\145\1\172"+
        "\1\151\1\uffff\1\156\1\172\1\164\1\uffff\1\145\1\156\1\uffff\1\145"+
        "\1\141\1\uffff\1\143\1\162\1\156\1\157\1\141\1\162\1\156\2\uffff"+
        "\2\172\1\uffff\2\164\1\uffff\1\172\1\156\2\172\1\154\1\150\2\172"+
        "\1\154\1\164\2\172\2\uffff\1\171\1\172\1\uffff\1\164\2\uffff\1\151"+
        "\1\145\2\uffff\1\145\1\141\2\uffff\1\101\1\uffff\1\163\1\172\1\163"+
        "\2\172\1\164\1\172\1\141\1\117\2\uffff\1\164\1\uffff\1\142\1\156"+
        "\1\162\2\154\1\151\1\145\1\171\1\142\2\172\1\165\2\uffff\1\164\1"+
        "\145\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\14\uffff\1\30\31\uffff\1\u00aa\3\uffff"+
        "\1\u00ad\1\u00ae\1\u00af\1\u00b0\127\uffff\1\u00ab\1\u00ac\20\uffff"+
        "\1\122\56\uffff\1\u0099\20\uffff\1\131\63\uffff\1\155\16\uffff\1"+
        "\77\120\uffff\1\106\7\uffff\1\u009b\3\uffff\1\10\3\uffff\1\144\11"+
        "\uffff\1\132\11\uffff\1\123\3\uffff\1\117\16\uffff\1\136\1\uffff"+
        "\1\111\6\uffff\1\121\7\uffff\1\61\5\uffff\1\74\4\uffff\1\u009d\4"+
        "\uffff\1\76\6\uffff\1\u00a4\13\uffff\1\150\33\uffff\1\134\4\uffff"+
        "\1\u0089\10\uffff\1\110\17\uffff\1\37\22\uffff\1\62\5\uffff\1\167"+
        "\1\67\6\uffff\1\101\3\uffff\1\75\1\uffff\1\104\1\100\4\uffff\1\112"+
        "\21\uffff\1\u0088\5\uffff\1\157\5\uffff\1\u009a\6\uffff\1\127\1"+
        "\57\3\uffff\1\u00a5\41\uffff\1\32\5\uffff\1\116\5\uffff\1\46\1\177"+
        "\1\uffff\1\137\7\uffff\1\u009c\1\uffff\1\162\1\u008f\3\uffff\1\160"+
        "\27\uffff\1\1\7\uffff\1\5\3\uffff\1\42\3\uffff\1\43\7\uffff\1\154"+
        "\31\uffff\1\24\7\uffff\1\u0091\11\uffff\1\72\1\u0083\4\uffff\1\u0085"+
        "\2\uffff\1\u0087\2\uffff\1\141\1\uffff\1\114\1\176\40\uffff\1\120"+
        "\2\uffff\1\70\2\uffff\1\u0094\1\uffff\1\133\1\51\1\20\7\uffff\1"+
        "\60\1\164\6\uffff\1\40\2\uffff\1\153\5\uffff\1\107\2\uffff\1\u008e"+
        "\1\41\4\uffff\1\170\11\uffff\1\102\1\uffff\1\u0081\5\uffff\1\u009f"+
        "\1\u00a0\1\uffff\1\u0098\1\uffff\1\172\17\uffff\1\u0080\7\uffff"+
        "\1\17\10\uffff\1\63\6\uffff\1\105\12\uffff\1\u0084\3\uffff\1\52"+
        "\12\uffff\1\145\5\uffff\1\165\11\uffff\1\25\1\uffff\1\135\7\uffff"+
        "\1\143\5\uffff\1\45\1\103\15\uffff\1\u0082\10\uffff\1\u00a8\4\uffff"+
        "\1\146\2\uffff\1\u008c\2\uffff\1\u008a\5\uffff\1\174\6\uffff\1\31"+
        "\6\uffff\1\147\10\uffff\1\47\1\33\7\uffff\1\u0095\7\uffff\1\173"+
        "\5\uffff\1\152\4\uffff\1\u0096\6\uffff\1\115\10\uffff\1\163\15\uffff"+
        "\1\16\1\uffff\1\56\1\66\3\uffff\1\50\12\uffff\1\36\1\uffff\1\171"+
        "\4\uffff\1\156\17\uffff\1\7\1\22\6\uffff\1\12\3\uffff\1\21\1\64"+
        "\7\uffff\1\54\14\uffff\1\142\5\uffff\1\u0086\1\u00a3\23\uffff\1"+
        "\73\3\uffff\1\u00a9\1\uffff\1\44\3\uffff\1\53\3\uffff\1\u0090\5"+
        "\uffff\1\34\1\71\6\uffff\1\11\5\uffff\1\23\6\uffff\1\166\1\uffff"+
        "\1\126\4\uffff\1\u008b\4\uffff\1\u00a7\11\uffff\1\65\6\uffff\1\27"+
        "\10\uffff\1\u00a6\3\uffff\1\140\2\uffff\1\u0092\2\uffff\1\u0093"+
        "\7\uffff\1\u00a2\1\u008d\2\uffff\1\151\2\uffff\1\13\14\uffff\1\u0097"+
        "\1\124\2\uffff\1\26\1\uffff\1\161\1\14\2\uffff\1\55\1\113\2\uffff"+
        "\1\130\1\u009e\1\uffff\1\3\11\uffff\1\35\1\125\1\uffff\1\6\14\uffff"+
        "\1\15\1\u00a1\3\uffff\1\175";
    static final String DFA12_specialS =
        "\u0563\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\60\1\57\1\uffff\1\60\1\57\22\uffff\1\60\1\uffff\1\62\12"+
            "\uffff\1\54\1\uffff\1\53\1\56\11\55\1\4\6\uffff\1\23\1\43\1"+
            "\24\1\51\1\31\1\22\2\61\1\25\2\61\1\27\1\52\1\61\1\37\1\1\1"+
            "\50\1\30\1\35\1\32\1\46\1\44\1\33\1\45\2\61\4\uffff\1\61\1\uffff"+
            "\1\14\1\42\1\16\1\3\1\5\1\15\2\61\1\17\1\47\1\41\1\36\1\20\1"+
            "\6\1\26\1\13\1\10\1\40\1\11\1\7\1\34\1\12\4\61\1\2\1\uffff\1"+
            "\21",
            "\1\63\7\uffff\1\65\10\uffff\1\64",
            "",
            "\1\66",
            "",
            "\1\73\46\uffff\1\72\1\uffff\1\71\7\uffff\1\67\1\uffff\1\70",
            "\1\74",
            "\1\76\15\uffff\1\77\2\uffff\1\75\6\uffff\1\100",
            "\1\101",
            "\1\102\11\uffff\1\103\4\uffff\1\104\1\105",
            "\1\106",
            "\1\107\15\uffff\1\111\2\uffff\1\110",
            "\1\112\10\uffff\1\113",
            "\1\114\7\uffff\1\116\5\uffff\1\115\2\uffff\1\117",
            "\1\122\6\uffff\1\120\6\uffff\1\121\2\uffff\1\123",
            "\1\126\5\uffff\1\125\1\124",
            "\1\127\17\uffff\1\131\3\uffff\1\130",
            "",
            "\1\132\12\uffff\1\135\2\uffff\1\134\2\uffff\1\133",
            "\1\136\17\uffff\1\137",
            "\1\141\15\uffff\1\140",
            "\1\143\6\uffff\1\144\1\142",
            "\1\145\4\uffff\1\146",
            "\1\147",
            "\1\150",
            "\1\154\1\153\10\uffff\1\151\1\uffff\1\152",
            "\1\155\3\uffff\1\160\2\uffff\1\157\6\uffff\1\156",
            "\1\161\6\uffff\1\162",
            "\1\163",
            "\1\165\11\uffff\1\164",
            "\1\166\7\uffff\1\167\5\uffff\1\170",
            "\1\171\1\uffff\1\172",
            "\1\173",
            "\1\174",
            "\1\176\2\uffff\1\175",
            "\1\u0080\2\uffff\1\177",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\1\u0088\11\55",
            "\1\61\1\u008b\1\uffff\12\u0089\7\uffff\32\61\4\uffff\1\61"+
            "\1\uffff\32\61",
            "\1\61\1\u008b\1\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff"+
            "\32\61",
            "",
            "",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0093\6\uffff\1\u0092\3\uffff\1\u0091",
            "\1\u0094",
            "\1\u0096\15\uffff\1\u0095",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\61\2\uffff\12\61\7\uffff\17\61\1\u009b\12\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f\1\uffff\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\5\uffff\1\u00a5",
            "\1\u00a6\1\uffff\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b4\1\u00b5\1\uffff\1\u00b3\1\uffff\1\u00b1\2\uffff\1"+
            "\u00b2",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b9\6\uffff\1\u00b8",
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
            "\1\u00c4",
            "\1\u00c7\1\u00c6\1\uffff\1\u00c8\1\uffff\1\u00c5",
            "\1\u00c9",
            "\1\u00ca",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u00cc",
            "\1\u00ce\3\uffff\1\u00cd",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d2\14\uffff\1\u00d1\3\uffff\1\u00d3",
            "\1\u00d4",
            "\1\u00d5\6\uffff\1\u00d6\3\uffff\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\61\2\uffff\12\61\7\uffff\17\61\1\u00db\12\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e2\1\u00e1",
            "\1\u00e3",
            "\1\u00e4\1\u00e5",
            "\1\u00e6",
            "\1\u00e7\5\uffff\1\u00e8",
            "\1\u00e9",
            "\1\u00ea\3\uffff\1\u00eb\7\uffff\1\u00ec",
            "\1\u00ed",
            "\1\u00ef\11\uffff\1\u00ee",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5\5\uffff\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u008b",
            "\1\61\1\u008b\1\uffff\12\u0089\7\uffff\32\61\4\uffff\1\61"+
            "\1\uffff\32\61",
            "",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0115\13\uffff\1\u0114",
            "\1\u0116",
            "\1\u0118\22\uffff\1\u0117",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0143\6\uffff\1\u0142",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\61\2\uffff\12\61\7\uffff\10\61\1\u0177\21\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u0179",
            "\1\u017a",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u017b\7\61",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0181",
            "\1\u0182",
            "",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\15"+
            "\61\1\u0189\14\61",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "",
            "\1\u0192",
            "\1\61\2\uffff\12\61\7\uffff\17\61\1\u0193\12\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0199\6\uffff\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\61\2\uffff\12\61\7\uffff\17\61\1\u01a6\12\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u01a8",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae\6\uffff\1\u01af",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u01b7\7\61",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "\1\61\2\uffff\12\61\7\uffff\10\61\1\u01c2\21\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01d0",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "",
            "\1\u01e8",
            "\1\u01ea\52\uffff\1\u01e9",
            "\1\u01eb",
            "\1\u01ec",
            "\1\u01ed",
            "\1\u01ee",
            "\1\u01ef",
            "",
            "\1\u01f0",
            "\1\u01f1",
            "\1\u01f2",
            "",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "",
            "\1\61\2\uffff\12\61\7\uffff\13\61\1\u01f6\16\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u01f8",
            "\1\u01f9",
            "\1\u01fa",
            "\1\u01fb",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u01fd",
            "\1\u01fe",
            "\1\u01ff",
            "",
            "\1\u0200",
            "\1\u0201",
            "\1\u0202",
            "\1\u0203",
            "\1\u0204",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0207\2\uffff\1\u0206\4\uffff\1\u0209\1\u020a\7\uffff\1"+
            "\u0208",
            "\1\u020b",
            "\1\u020c",
            "",
            "\1\u020d",
            "\1\u020e",
            "\1\u0210\41\uffff\1\u020f",
            "",
            "\1\u0211",
            "\1\u0212",
            "\1\u0213",
            "\1\61\2\uffff\12\61\7\uffff\1\u0214\31\61\4\uffff\1\61\1\uffff"+
            "\32\61",
            "\1\u0216",
            "\1\u0217",
            "\1\u0218",
            "\1\u0219",
            "\1\u021a",
            "\1\u021b",
            "\1\u021c",
            "\1\u021d",
            "\1\u021e",
            "\1\u021f",
            "",
            "\1\u0220",
            "",
            "\1\u0221",
            "\1\u0222",
            "\1\u0223",
            "\1\u0224",
            "\1\u0225",
            "\1\u0226",
            "",
            "\1\61\2\uffff\12\61\7\uffff\1\u0227\31\61\4\uffff\1\61\1\uffff"+
            "\32\61",
            "\1\u0229",
            "\1\u022a",
            "\1\u022b",
            "\1\u022c",
            "\1\u022d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0230",
            "\1\u0231",
            "\1\u0232",
            "\1\u0233",
            "",
            "\1\u0234",
            "\1\u0235",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0237",
            "",
            "\1\u0238",
            "\1\u0239",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u023b",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u023e",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0243",
            "\1\u0244",
            "\1\u0245",
            "\1\u0246",
            "\1\u0247",
            "\1\u0248",
            "\1\u0249",
            "\1\u024a",
            "\1\u024b",
            "\1\u024c",
            "",
            "\1\u024d",
            "\1\u024e",
            "\1\u024f",
            "\1\u0250",
            "\1\u0251",
            "\1\u0252",
            "\1\u0253",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0255",
            "\1\u0256",
            "\1\u0257",
            "\1\u0258",
            "\1\u0259",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u025b",
            "\1\u025c",
            "\1\u025d",
            "\1\u025e",
            "\1\u025f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0261",
            "\1\u0262",
            "\1\u0263",
            "\1\u0264",
            "\1\61\2\uffff\12\61\7\uffff\15\61\1\u0266\14\61\4\uffff\1"+
            "\61\1\uffff\22\61\1\u0265\7\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0269",
            "",
            "\1\u026a",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u026b\7\61",
            "\1\u026d",
            "\1\u026e",
            "",
            "\1\u026f",
            "\1\u0270",
            "\1\u0271",
            "\1\u0272",
            "\1\u0273",
            "\1\u0274",
            "\1\u0275",
            "\1\u0276",
            "",
            "\1\u0277",
            "\1\u0278",
            "\1\u0279",
            "\1\u027a",
            "\1\u027b",
            "\1\u027c",
            "\1\u027d",
            "\1\u027e",
            "\1\u027f",
            "\1\u0280",
            "\1\u0281",
            "\1\u0282",
            "\1\u0283",
            "\1\u0284",
            "\1\u0285",
            "",
            "\1\u0286",
            "\1\u0287",
            "\1\u0289\7\uffff\1\u0288",
            "\1\u028a\36\uffff\1\u028b",
            "\1\u028c",
            "\1\u028d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u028f",
            "\1\u0290",
            "\1\u0291",
            "\1\u0292",
            "\1\u0293",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0295",
            "\1\u0296",
            "\1\u0297",
            "\1\u0298",
            "\1\u0299",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u029c",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u029e",
            "",
            "",
            "\1\u029f",
            "\1\u02a0",
            "\1\u02a1",
            "\1\u02a2",
            "\1\u02a3",
            "\1\u02a4",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u02a6\7\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u02a9",
            "",
            "",
            "\1\u02aa",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u02ab\7\61",
            "\1\u02ad",
            "\1\u02ae",
            "",
            "\1\u02af",
            "\1\u02b0",
            "\1\u02b1",
            "\1\u02b2",
            "\1\u02b3",
            "\1\u02b4",
            "\1\u02b5",
            "\1\u02b6",
            "\1\u02b7",
            "\1\u02b8",
            "\1\u02b9",
            "\1\u02ba",
            "\1\u02bb",
            "\1\u02bc",
            "\1\u02bd",
            "\1\u02be",
            "\1\u02bf",
            "",
            "\1\u02c0",
            "\1\u02c1",
            "\1\u02c3\12\uffff\1\u02c2",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u02c5",
            "",
            "\1\u02c6",
            "\1\u02c7",
            "\1\u02c8",
            "\1\u02c9",
            "\1\u02ca",
            "",
            "\1\61\2\uffff\12\61\7\uffff\23\61\1\u02cb\6\61\4\uffff\1\61"+
            "\1\uffff\32\61",
            "\1\u02cd",
            "\1\u02ce",
            "\1\u02cf",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u02d1",
            "",
            "",
            "\1\u02d2",
            "\1\u02d3",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u02d5",
            "\1\u02d6",
            "\1\u02d7",
            "\1\u02d8",
            "\1\u02d9\5\uffff\1\u02da",
            "\1\u02db",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u02dd\17\uffff\1\u02de",
            "\1\u02df",
            "\1\u02e1\17\uffff\1\u02e0",
            "\1\u02e2",
            "\1\u02e3",
            "\1\u02e4",
            "\1\u02e5",
            "\1\u02e6",
            "\1\u02e7",
            "\1\u02e8",
            "\1\u02e9",
            "\1\u02ea",
            "\1\u02eb",
            "\1\u02ec",
            "\1\u02ed",
            "\1\u02ee",
            "\1\u02ef",
            "\1\u02f0",
            "\1\u02f1",
            "\1\u02f2",
            "\1\u02f3",
            "\1\u02f4",
            "\1\u02f5",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u02f7",
            "\1\u02f9\16\uffff\1\u02f8\36\uffff\1\u02fa",
            "",
            "\1\u02fb",
            "\1\u02fc",
            "\1\u02fd",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u02ff",
            "",
            "\1\u0300",
            "\1\u0301",
            "\1\u0302",
            "\1\u0303",
            "\1\u0304",
            "",
            "",
            "\1\u0305",
            "",
            "\1\u0306",
            "\1\u0307",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u030a",
            "\1\u030b",
            "\1\u030c\14\uffff\1\u030d",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\u030f",
            "\1\u0310",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0312",
            "\1\u0313",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0315",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0318",
            "\1\u0319",
            "\1\u031a",
            "\1\u031b",
            "\1\u031c",
            "\1\u031d",
            "\1\u031e",
            "\1\u031f",
            "\1\u0320",
            "\1\u0321",
            "\1\u0322",
            "\1\u0323",
            "\1\u0324",
            "\1\u0325",
            "\1\u0326",
            "\1\u0327",
            "\1\u0328",
            "",
            "\1\u0329",
            "\1\u032a",
            "\1\u032b",
            "\1\u032c",
            "\1\u032d",
            "\1\u032e",
            "\1\u032f",
            "",
            "\1\u0330",
            "\1\u0331",
            "\1\u0332",
            "",
            "\1\u0333",
            "\1\u0334",
            "\1\u0335",
            "",
            "\1\u0336",
            "\1\u0337",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\1\u0339\31\61\4\uffff\1\61\1\uffff"+
            "\22\61\1\u033a\7\61",
            "\1\u033c",
            "\1\u033d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u033f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0343",
            "\1\u0344",
            "\1\u0345",
            "\1\u0346",
            "\1\u0347",
            "\1\u0348",
            "\1\u0349",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u034c",
            "\1\u034d",
            "\1\u034e",
            "\1\u034f",
            "\1\u0350",
            "\1\u0351",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0353",
            "\1\u0354",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0356",
            "\1\u0357",
            "",
            "\1\u0358",
            "\1\u0359",
            "\1\u035a",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u035c",
            "\1\u035d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0360",
            "\1\u0361",
            "\1\u0362",
            "\1\u0363",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0365",
            "\1\u0366",
            "\1\u0367",
            "",
            "",
            "\1\u0368",
            "\1\u0369",
            "\1\u036a",
            "\1\u036b",
            "",
            "\1\u036c",
            "\1\u036d",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u036f",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\u0371",
            "\1\u0372",
            "\1\u0373",
            "\1\u0374",
            "\1\u0375",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0378",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u037a\7\61",
            "\1\u037c",
            "\1\u037d",
            "\1\u037e",
            "\1\u037f",
            "\1\u0380",
            "\1\u0381",
            "\1\u0382",
            "\1\u0383",
            "\1\u0384",
            "\1\u0385",
            "\1\u0386",
            "\1\u0387",
            "\1\u0388",
            "\1\u0389",
            "\1\u038a",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u038c",
            "\1\u038d",
            "\1\u038e",
            "\1\u038f",
            "\1\u0390",
            "\1\u0391",
            "",
            "\1\u0392",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0394",
            "\1\u0395",
            "",
            "\1\u0396",
            "",
            "",
            "",
            "\1\u0397",
            "\1\u0398",
            "\1\u0399",
            "\1\u039a",
            "\1\u039b",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u039d",
            "",
            "",
            "\1\u039e",
            "\1\u039f",
            "\1\u03a0",
            "\1\u03a1",
            "\1\u03a2",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u03a4",
            "\1\u03a5",
            "",
            "\1\u03a6",
            "\1\u03a7",
            "\1\u03a8",
            "\1\u03a9",
            "\1\u03aa",
            "",
            "\1\u03ab",
            "\1\u03ac",
            "",
            "",
            "\1\u03ad",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03b0\3\uffff\1\u03af",
            "\1\u03b1",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03b3",
            "\1\u03b4",
            "\1\u03b5",
            "\1\u03b6",
            "\1\u03b7",
            "\1\u03b8\61\uffff\1\u03b9",
            "\1\u03ba",
            "\1\u03bb",
            "",
            "\1\u03bc",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03be",
            "\1\u03bf",
            "\1\u03c0",
            "\1\u03c1",
            "",
            "",
            "\1\u03c2",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u03c4",
            "\1\u03c5",
            "\1\u03c6",
            "\1\u03c7",
            "\1\u03c8",
            "\1\u03c9",
            "\1\u03ca",
            "\1\u03cb",
            "\1\u03cc",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\13\61\1\u03ce\16\61\4\uffff\1"+
            "\61\1\uffff\32\61",
            "\1\u03d0",
            "\1\u03d1",
            "\1\u03d2",
            "\1\u03d3",
            "",
            "\1\u03d4",
            "\1\u03d5",
            "\1\u03d6",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03d8",
            "\1\u03d9",
            "\1\u03da",
            "",
            "\1\u03db",
            "\1\u03dc",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03df",
            "\1\u03e0",
            "\1\u03e1",
            "\1\u03e2",
            "",
            "\1\u03e3",
            "\1\u03e4",
            "\1\u03e5",
            "\1\u03e6",
            "\1\u03e7",
            "\1\u03e8",
            "",
            "\1\u03e9",
            "\1\u03ea",
            "\1\u03eb",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03ed",
            "\1\u03ee",
            "\1\u03ef",
            "\1\u03f0",
            "\1\u03f1",
            "\1\u03f2",
            "",
            "\1\u03f3",
            "\1\61\2\uffff\12\61\7\uffff\22\61\1\u03f4\7\61\4\uffff\1\61"+
            "\1\uffff\32\61",
            "\1\u03f6",
            "",
            "\1\u03f7",
            "\1\u03f8",
            "\1\u03f9",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03fb",
            "\1\u03fc",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u03fe",
            "\1\u03ff",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0401",
            "\1\u0402",
            "\1\u0403",
            "\1\u0404",
            "\1\u0405",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0407",
            "\1\u0408",
            "\1\u0409",
            "\1\u040a",
            "\1\61\2\uffff\12\61\7\uffff\23\61\1\u040b\6\61\4\uffff\1\61"+
            "\1\uffff\22\61\1\u040c\7\61",
            "\1\u040e",
            "\1\u040f",
            "\1\u0410",
            "",
            "\1\u0411",
            "",
            "\1\u0412",
            "\1\u0413",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0415",
            "\1\u0416",
            "\1\u0417",
            "\1\u0418",
            "",
            "\1\u0419",
            "\1\u041a",
            "\1\u041b",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u041c\7\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\u041f",
            "\1\u0420",
            "\1\u0421",
            "\1\u0422",
            "\1\u0423",
            "\1\u0425\37\uffff\1\u0424",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0427",
            "\1\u0428",
            "\1\u0429",
            "\1\u042a",
            "\1\u042b",
            "\1\u042c",
            "",
            "\1\u042d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u042f",
            "\1\u0430",
            "\1\u0431",
            "\1\61\2\uffff\12\61\7\uffff\22\61\1\u0432\7\61\4\uffff\1\61"+
            "\1\uffff\22\61\1\u0433\7\61",
            "\1\u0435",
            "\1\u0436",
            "",
            "\1\u0437",
            "\1\u0438",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u043a",
            "",
            "\1\u043b",
            "\1\u043c",
            "",
            "\1\u043d",
            "\1\u043e",
            "",
            "\1\u043f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0441",
            "\1\u0442",
            "\1\u0443",
            "",
            "\1\u0444",
            "\1\u0445",
            "\1\u0446",
            "\1\u0447",
            "\1\u0448",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u044a",
            "\1\u044b",
            "\1\u044c",
            "\1\u044d",
            "\1\u044e",
            "\1\u044f",
            "",
            "\1\u0450",
            "\1\u0451",
            "\1\u0452",
            "\1\u0453",
            "\1\u0454",
            "\1\u0455",
            "\1\u0456",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u0458\7\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u045b",
            "\1\u045c",
            "\1\u045d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u045f",
            "",
            "\1\u0460",
            "\1\u0461",
            "\1\u0462",
            "\1\u0463",
            "\1\u0464",
            "\1\u0465",
            "\1\u0466",
            "",
            "\1\u0467",
            "\1\u0468",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u046a",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u046c",
            "\1\u046d",
            "\1\u046e",
            "\1\u046f",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0471",
            "\1\u0472",
            "\1\u0473",
            "\1\u0474",
            "\1\u0475",
            "",
            "\1\u0476",
            "\1\u0477",
            "\1\u0478",
            "\1\u0479",
            "\1\u047a",
            "\1\u047b",
            "\1\u047c",
            "\1\u047d",
            "",
            "\1\u047e",
            "\1\61\2\uffff\12\61\7\uffff\4\61\1\u047f\25\61\4\uffff\1\61"+
            "\1\uffff\32\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0482",
            "\1\u0483",
            "\1\u0484",
            "\1\u0485",
            "\1\u0486",
            "\1\u0487",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0489",
            "\1\u048a",
            "\1\u048b",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u048e",
            "\1\u048f",
            "",
            "\1\u0490",
            "\1\u0491",
            "\1\u0492",
            "\1\u0493",
            "\1\u0494",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0496",
            "\1\u0497",
            "\1\u0498",
            "\1\u0499",
            "",
            "\1\u049a",
            "",
            "\1\u049b",
            "\1\u049c",
            "\1\u049d",
            "\1\u049e",
            "",
            "\1\u049f",
            "\1\u04a0",
            "\1\u04a1",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04a3",
            "\1\u04a4",
            "\1\u04a5",
            "\1\u04a6",
            "\1\u04a7",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04aa",
            "\1\u04ab",
            "\1\u04ac",
            "\1\u04ad",
            "",
            "",
            "\1\u04ae",
            "\1\u04af",
            "\1\u04b0",
            "\1\u04b1",
            "\1\u04b2",
            "\1\u04b3",
            "",
            "\1\u04b4",
            "\1\u04b5",
            "\1\u04b6",
            "",
            "",
            "\1\u04b7",
            "\1\u04b8",
            "\1\u04b9",
            "\1\u04ba",
            "\1\u04bb",
            "\1\u04bc",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u04be",
            "\1\u04bf",
            "\1\u04c0",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u04c2\7\61",
            "\1\u04c4",
            "\1\u04c5",
            "\1\u04c6",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04c8",
            "\1\u04c9",
            "\1\u04ca",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04cc",
            "\1\u04cd",
            "\1\u04ce",
            "\1\u04cf",
            "",
            "",
            "\1\u04d0",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04d3",
            "\1\u04d4",
            "\1\u04d5",
            "\1\u04d6",
            "\1\u04d7",
            "\1\u04d8",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04da",
            "\1\u04db",
            "\1\u04dc",
            "\1\u04dd",
            "\1\u04de",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04e0",
            "\1\u04e1",
            "\1\u04e2",
            "",
            "\1\u04e3",
            "\1\u04e4",
            "\1\u04e5",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u04e7",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04e9",
            "",
            "\1\u04ea",
            "\1\u04eb",
            "\1\u04ec",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04ee",
            "\1\u04ef",
            "\1\u04f0",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22"+
            "\61\1\u04f1\7\61",
            "",
            "",
            "\1\u04f3",
            "\1\u04f4",
            "\1\u04f5",
            "\1\u04f6",
            "\1\u04f7",
            "\1\u04f8",
            "",
            "\1\u04f9",
            "\1\u04fa",
            "\1\u04fb",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u04fd",
            "",
            "\1\u04fe",
            "\1\u04ff",
            "\1\u0500",
            "\1\u0501",
            "\1\u0502",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0504",
            "",
            "\1\u0505",
            "\1\u0506",
            "\1\u0507",
            "\1\u0508",
            "",
            "\1\u0509",
            "\1\u050a",
            "\1\u050b",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u050d",
            "\1\u050e",
            "\1\u050f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0511",
            "\1\u0512",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0514",
            "\1\u0515",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0517",
            "\1\u0518",
            "\1\u0519",
            "\1\u051a",
            "\1\u051b",
            "",
            "\1\u051c",
            "\1\u051d",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0520",
            "\1\u0521",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0523",
            "",
            "\1\u0524",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0526",
            "",
            "\1\u0527",
            "\1\u0528",
            "",
            "\1\u0529",
            "\1\u052a",
            "",
            "\1\u052b",
            "\1\u052c",
            "\1\u052d",
            "\1\u052e",
            "\1\u052f",
            "\1\u0530",
            "\1\u0531",
            "",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0534",
            "\1\u0535",
            "",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0537",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u053a",
            "\1\u053b",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u053e",
            "\1\u053f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "",
            "\1\u0542",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "",
            "\1\u0544",
            "",
            "",
            "\1\u0545",
            "\1\u0546",
            "",
            "",
            "\1\u0547",
            "\1\u0548",
            "",
            "",
            "\1\u0549",
            "",
            "\1\u054a",
            "\1\u054b",
            "\1\u054c",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u054f",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u0551",
            "\1\u0552",
            "",
            "",
            "\1\u0553",
            "",
            "\1\u0554",
            "\1\u0555",
            "\1\u0556",
            "\1\u0557",
            "\1\u0558",
            "\1\u0559",
            "\1\u055a",
            "\1\u055b",
            "\1\u055c",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
            "\1\u055f",
            "",
            "",
            "\1\u0560",
            "\1\u0561",
            "\1\61\2\uffff\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32"+
            "\61",
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
            return "1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | T120 | T121 | T122 | T123 | T124 | T125 | T126 | T127 | T128 | T129 | T130 | T131 | T132 | T133 | T134 | T135 | T136 | T137 | T138 | T139 | T140 | T141 | T142 | T143 | T144 | T145 | T146 | T147 | T148 | T149 | T150 | T151 | T152 | T153 | T154 | T155 | T156 | T157 | T158 | T159 | T160 | T161 | T162 | T163 | T164 | T165 | T166 | T167 | T168 | T169 | T170 | T171 | T172 | T173 | T174 | T175 | T176 | T177 | T178 | T179 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 );";
        }
    }
 

}