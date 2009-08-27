// $ANTLR 3.1.1 E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g 2009-08-27 12:34:40

	package org.emftext.language.sparql.resource.sparql;


import org.antlr.runtime.*;

public class SparqlLexer extends Lexer {
    public static final int T__11=11;
    public static final int IDENTIFIER=8;
    public static final int T__10=10;
    public static final int DEF_INTEGER=5;
    public static final int WHITESPACE=6;
    public static final int LINEBREAKS=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int DEF_IRI_REF=4;

    	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public SparqlLexer() {;} 
    public SparqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SparqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:16:6: ( 'BASE' )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:16:8: 'BASE'
            {
            match("BASE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:17:7: ( 'PREFIX' )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:17:9: 'PREFIX'
            {
            match("PREFIX"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:18:7: ( ':' )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:18:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "DEF_IRI_REF"
    public final void mDEF_IRI_REF() throws RecognitionException {
        try {
            int _type = DEF_IRI_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:654:15: ( '<' ( '^' | '<' | '>' | '\"' | '{' | '}' | '`' | '\\\\' | ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) )* '>' )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:5: '<' ( '^' | '<' | '>' | '\"' | '{' | '}' | '`' | '\\\\' | ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) )* '>'
            {
            match('<'); 
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:9: ( '^' | '<' | '>' | '\"' | '{' | '}' | '`' | '\\\\' | ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) )*
            loop1:
            do {
                int alt1=10;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:11: '^'
            	    {
            	    match('^'); 

            	    }
            	    break;
            	case 2 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:17: '<'
            	    {
            	    match('<'); 

            	    }
            	    break;
            	case 3 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:23: '>'
            	    {
            	    match('>'); 

            	    }
            	    break;
            	case 4 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:29: '\"'
            	    {
            	    match('\"'); 

            	    }
            	    break;
            	case 5 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:35: '{'
            	    {
            	    match('{'); 

            	    }
            	    break;
            	case 6 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:41: '}'
            	    {
            	    match('}'); 

            	    }
            	    break;
            	case 7 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:47: '`'
            	    {
            	    match('`'); 

            	    }
            	    break;
            	case 8 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:53: '\\\\'
            	    {
            	    match('\\'); 

            	    }
            	    break;
            	case 9 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:60: ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:60: ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:61: '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    match('#'); 
            	    match('x'); 
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:67: ( '0' .. '2' )
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:655:68: '0' .. '2'
            	    {
            	    matchRange('0','2'); 

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEF_IRI_REF"

    // $ANTLR start "DEF_INTEGER"
    public final void mDEF_INTEGER() throws RecognitionException {
        try {
            int _type = DEF_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:656:15: ( ( '+' | '-' )? ( '0' .. '9' )* )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:657:5: ( '+' | '-' )? ( '0' .. '9' )*
            {
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:657:5: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:657:16: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:657:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEF_INTEGER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:658:14: ( ( ' ' | '\\t' | '\\f' ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:659:5: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAKS"
    public final void mLINEBREAKS() throws RecognitionException {
        try {
            int _type = LINEBREAKS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:662:14: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:663:5: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:663:5: ( '\\r\\n' | '\\r' | '\\n' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\n') ) {
                    alt4=1;
                }
                else {
                    alt4=2;}
            }
            else if ( (LA4_0=='\n') ) {
                alt4=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:663:6: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:663:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:663:18: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINEBREAKS"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:666:14: ( ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u064a' | '\\u066e' .. '\\u066f' | '\\u0671' .. '\\u06d3' | '\\u06d5' | '\\u06e5' .. '\\u06e6' | '\\u06ee' .. '\\u06ef' | '\\u06fa' .. '\\u06fc' | '\\u06ff' | '\\u0710' | '\\u0712' .. '\\u072f' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07a5' | '\\u07b1' | '\\u0904' .. '\\u0939' | '\\u093d' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bd' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e1' | '\\u09f0' .. '\\u09f3' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a72' .. '\\u0a74' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae1' | '\\u0af1' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3d' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b71' | '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bf9' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c60' .. '\\u0c61' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbd' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d60' .. '\\u0d61' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0e01' .. '\\u0e30' | '\\u0e32' .. '\\u0e33' | '\\u0e3f' .. '\\u0e46' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb0' | '\\u0eb2' .. '\\u0eb3' | '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f40' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f88' .. '\\u0f8b' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u1050' .. '\\u1055' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1711' | '\\u1720' .. '\\u1731' | '\\u1740' .. '\\u1751' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1780' .. '\\u17b3' | '\\u17d7' | '\\u17db' .. '\\u17dc' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a8' | '\\u1900' .. '\\u191c' | '\\u1950' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' | '\\ufb1f' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\uff04' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' ) ( '\\u0000' .. '\\u0008' | '\\u000e' .. '\\u001b' | '\\u0024' | '\\u0030' .. '\\u0039' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u007f' .. '\\u009f' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00ad' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u0300' .. '\\u0357' | '\\u035d' .. '\\u036f' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u0483' .. '\\u0486' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u0591' .. '\\u05a1' | '\\u05a3' .. '\\u05b9' | '\\u05bb' .. '\\u05bd' | '\\u05bf' | '\\u05c1' .. '\\u05c2' | '\\u05c4' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u066e' .. '\\u06d3' | '\\u06d5' .. '\\u06dd' | '\\u06df' .. '\\u06e8' | '\\u06ea' .. '\\u06fc' | '\\u06ff' | '\\u070f' .. '\\u074a' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07b1' | '\\u0901' .. '\\u0939' | '\\u093c' .. '\\u094d' | '\\u0950' .. '\\u0954' | '\\u0958' .. '\\u0963' | '\\u0966' .. '\\u096f' | '\\u0981' .. '\\u0983' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bc' .. '\\u09c4' | '\\u09c7' .. '\\u09c8' | '\\u09cb' .. '\\u09cd' | '\\u09d7' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e3' | '\\u09e6' .. '\\u09f3' | '\\u0a01' .. '\\u0a03' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a3c' | '\\u0a3e' .. '\\u0a42' | '\\u0a47' .. '\\u0a48' | '\\u0a4b' .. '\\u0a4d' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a66' .. '\\u0a74' | '\\u0a81' .. '\\u0a83' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abc' .. '\\u0ac5' | '\\u0ac7' .. '\\u0ac9' | '\\u0acb' .. '\\u0acd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae3' | '\\u0ae6' .. '\\u0aef' | '\\u0af1' | '\\u0b01' .. '\\u0b03' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3c' .. '\\u0b43' | '\\u0b47' .. '\\u0b48' | '\\u0b4b' .. '\\u0b4d' | '\\u0b56' .. '\\u0b57' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b66' .. '\\u0b6f' | '\\u0b71' | '\\u0b82' .. '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bbe' .. '\\u0bc2' | '\\u0bc6' .. '\\u0bc8' | '\\u0bca' .. '\\u0bcd' | '\\u0bd7' | '\\u0be7' .. '\\u0bef' | '\\u0bf9' | '\\u0c01' .. '\\u0c03' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c3e' .. '\\u0c44' | '\\u0c46' .. '\\u0c48' | '\\u0c4a' .. '\\u0c4d' | '\\u0c55' .. '\\u0c56' | '\\u0c60' .. '\\u0c61' | '\\u0c66' .. '\\u0c6f' | '\\u0c82' .. '\\u0c83' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbc' .. '\\u0cc4' | '\\u0cc6' .. '\\u0cc8' | '\\u0cca' .. '\\u0ccd' | '\\u0cd5' .. '\\u0cd6' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0ce6' .. '\\u0cef' | '\\u0d02' .. '\\u0d03' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d3e' .. '\\u0d43' | '\\u0d46' .. '\\u0d48' | '\\u0d4a' .. '\\u0d4d' | '\\u0d57' | '\\u0d60' .. '\\u0d61' | '\\u0d66' .. '\\u0d6f' | '\\u0d82' .. '\\u0d83' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0dca' | '\\u0dcf' .. '\\u0dd4' | '\\u0dd6' | '\\u0dd8' .. '\\u0ddf' | '\\u0df2' .. '\\u0df3' | '\\u0e01' .. '\\u0e3a' | '\\u0e3f' .. '\\u0e4e' | '\\u0e50' .. '\\u0e59' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb9' | '\\u0ebb' .. '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0ec8' .. '\\u0ecd' | '\\u0ed0' .. '\\u0ed9' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f18' .. '\\u0f19' | '\\u0f20' .. '\\u0f29' | '\\u0f35' | '\\u0f37' | '\\u0f39' | '\\u0f3e' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f71' .. '\\u0f84' | '\\u0f86' .. '\\u0f8b' | '\\u0f90' .. '\\u0f97' | '\\u0f99' .. '\\u0fbc' | '\\u0fc6' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u102c' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1050' .. '\\u1059' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u1369' .. '\\u1371' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1714' | '\\u1720' .. '\\u1734' | '\\u1740' .. '\\u1753' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1772' .. '\\u1773' | '\\u1780' .. '\\u17d3' | '\\u17d7' | '\\u17db' .. '\\u17dd' | '\\u17e0' .. '\\u17e9' | '\\u180b' .. '\\u180d' | '\\u1810' .. '\\u1819' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a9' | '\\u1900' .. '\\u191c' | '\\u1920' .. '\\u192b' | '\\u1930' .. '\\u193b' | '\\u1946' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u200c' .. '\\u200f' | '\\u202a' .. '\\u202e' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2060' .. '\\u2063' | '\\u206a' .. '\\u206f' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u20d0' .. '\\u20dc' | '\\u20e1' | '\\u20e5' .. '\\u20ea' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u302f' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u3099' .. '\\u309a' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe00' .. '\\ufe0f' | '\\ufe20' .. '\\ufe23' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\ufeff' | '\\uff04' | '\\uff10' .. '\\uff19' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' | '\\ufff9' .. '\\ufffb' )* )
            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:667:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u064a' | '\\u066e' .. '\\u066f' | '\\u0671' .. '\\u06d3' | '\\u06d5' | '\\u06e5' .. '\\u06e6' | '\\u06ee' .. '\\u06ef' | '\\u06fa' .. '\\u06fc' | '\\u06ff' | '\\u0710' | '\\u0712' .. '\\u072f' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07a5' | '\\u07b1' | '\\u0904' .. '\\u0939' | '\\u093d' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bd' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e1' | '\\u09f0' .. '\\u09f3' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a72' .. '\\u0a74' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae1' | '\\u0af1' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3d' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b71' | '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bf9' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c60' .. '\\u0c61' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbd' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d60' .. '\\u0d61' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0e01' .. '\\u0e30' | '\\u0e32' .. '\\u0e33' | '\\u0e3f' .. '\\u0e46' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb0' | '\\u0eb2' .. '\\u0eb3' | '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f40' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f88' .. '\\u0f8b' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u1050' .. '\\u1055' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1711' | '\\u1720' .. '\\u1731' | '\\u1740' .. '\\u1751' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1780' .. '\\u17b3' | '\\u17d7' | '\\u17db' .. '\\u17dc' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a8' | '\\u1900' .. '\\u191c' | '\\u1950' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' | '\\ufb1f' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\uff04' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' ) ( '\\u0000' .. '\\u0008' | '\\u000e' .. '\\u001b' | '\\u0024' | '\\u0030' .. '\\u0039' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u007f' .. '\\u009f' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00ad' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u0300' .. '\\u0357' | '\\u035d' .. '\\u036f' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u0483' .. '\\u0486' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u0591' .. '\\u05a1' | '\\u05a3' .. '\\u05b9' | '\\u05bb' .. '\\u05bd' | '\\u05bf' | '\\u05c1' .. '\\u05c2' | '\\u05c4' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u066e' .. '\\u06d3' | '\\u06d5' .. '\\u06dd' | '\\u06df' .. '\\u06e8' | '\\u06ea' .. '\\u06fc' | '\\u06ff' | '\\u070f' .. '\\u074a' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07b1' | '\\u0901' .. '\\u0939' | '\\u093c' .. '\\u094d' | '\\u0950' .. '\\u0954' | '\\u0958' .. '\\u0963' | '\\u0966' .. '\\u096f' | '\\u0981' .. '\\u0983' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bc' .. '\\u09c4' | '\\u09c7' .. '\\u09c8' | '\\u09cb' .. '\\u09cd' | '\\u09d7' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e3' | '\\u09e6' .. '\\u09f3' | '\\u0a01' .. '\\u0a03' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a3c' | '\\u0a3e' .. '\\u0a42' | '\\u0a47' .. '\\u0a48' | '\\u0a4b' .. '\\u0a4d' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a66' .. '\\u0a74' | '\\u0a81' .. '\\u0a83' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abc' .. '\\u0ac5' | '\\u0ac7' .. '\\u0ac9' | '\\u0acb' .. '\\u0acd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae3' | '\\u0ae6' .. '\\u0aef' | '\\u0af1' | '\\u0b01' .. '\\u0b03' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3c' .. '\\u0b43' | '\\u0b47' .. '\\u0b48' | '\\u0b4b' .. '\\u0b4d' | '\\u0b56' .. '\\u0b57' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b66' .. '\\u0b6f' | '\\u0b71' | '\\u0b82' .. '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bbe' .. '\\u0bc2' | '\\u0bc6' .. '\\u0bc8' | '\\u0bca' .. '\\u0bcd' | '\\u0bd7' | '\\u0be7' .. '\\u0bef' | '\\u0bf9' | '\\u0c01' .. '\\u0c03' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c3e' .. '\\u0c44' | '\\u0c46' .. '\\u0c48' | '\\u0c4a' .. '\\u0c4d' | '\\u0c55' .. '\\u0c56' | '\\u0c60' .. '\\u0c61' | '\\u0c66' .. '\\u0c6f' | '\\u0c82' .. '\\u0c83' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbc' .. '\\u0cc4' | '\\u0cc6' .. '\\u0cc8' | '\\u0cca' .. '\\u0ccd' | '\\u0cd5' .. '\\u0cd6' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0ce6' .. '\\u0cef' | '\\u0d02' .. '\\u0d03' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d3e' .. '\\u0d43' | '\\u0d46' .. '\\u0d48' | '\\u0d4a' .. '\\u0d4d' | '\\u0d57' | '\\u0d60' .. '\\u0d61' | '\\u0d66' .. '\\u0d6f' | '\\u0d82' .. '\\u0d83' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0dca' | '\\u0dcf' .. '\\u0dd4' | '\\u0dd6' | '\\u0dd8' .. '\\u0ddf' | '\\u0df2' .. '\\u0df3' | '\\u0e01' .. '\\u0e3a' | '\\u0e3f' .. '\\u0e4e' | '\\u0e50' .. '\\u0e59' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb9' | '\\u0ebb' .. '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0ec8' .. '\\u0ecd' | '\\u0ed0' .. '\\u0ed9' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f18' .. '\\u0f19' | '\\u0f20' .. '\\u0f29' | '\\u0f35' | '\\u0f37' | '\\u0f39' | '\\u0f3e' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f71' .. '\\u0f84' | '\\u0f86' .. '\\u0f8b' | '\\u0f90' .. '\\u0f97' | '\\u0f99' .. '\\u0fbc' | '\\u0fc6' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u102c' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1050' .. '\\u1059' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u1369' .. '\\u1371' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1714' | '\\u1720' .. '\\u1734' | '\\u1740' .. '\\u1753' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1772' .. '\\u1773' | '\\u1780' .. '\\u17d3' | '\\u17d7' | '\\u17db' .. '\\u17dd' | '\\u17e0' .. '\\u17e9' | '\\u180b' .. '\\u180d' | '\\u1810' .. '\\u1819' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a9' | '\\u1900' .. '\\u191c' | '\\u1920' .. '\\u192b' | '\\u1930' .. '\\u193b' | '\\u1946' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u200c' .. '\\u200f' | '\\u202a' .. '\\u202e' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2060' .. '\\u2063' | '\\u206a' .. '\\u206f' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u20d0' .. '\\u20dc' | '\\u20e1' | '\\u20e5' .. '\\u20ea' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u302f' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u3099' .. '\\u309a' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe00' .. '\\ufe0f' | '\\ufe20' .. '\\ufe23' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\ufeff' | '\\uff04' | '\\uff10' .. '\\uff19' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' | '\\ufff9' .. '\\ufffb' )*
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u0236')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u03FB')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048A' && input.LA(1)<='\u04CE')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0500' && input.LA(1)<='\u050F')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u066E' && input.LA(1)<='\u066F')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06EE' && input.LA(1)<='\u06EF')||(input.LA(1)>='\u06FA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072F')||(input.LA(1)>='\u074D' && input.LA(1)<='\u074F')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||input.LA(1)=='\u07B1'||(input.LA(1)>='\u0904' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||input.LA(1)=='\u09BD'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09F0' && input.LA(1)<='\u09F3')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE1')||input.LA(1)=='\u0AF1'||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||input.LA(1)=='\u0B71'||input.LA(1)=='\u0B83'||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||input.LA(1)=='\u0BF9'||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CBD'||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E3F' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||input.LA(1)=='\u0EBD'||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F8')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1711')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1731')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1751')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DB' && input.LA(1)<='\u17DC')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1950' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1D6B')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20B1')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213D' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FA5')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFC')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||input.LA(1)=='\uFE69'||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFF04'||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF65' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFE0' && input.LA(1)<='\uFFE1')||(input.LA(1)>='\uFFE5' && input.LA(1)<='\uFFE6') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:667:4943: ( '\\u0000' .. '\\u0008' | '\\u000e' .. '\\u001b' | '\\u0024' | '\\u0030' .. '\\u0039' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u007f' .. '\\u009f' | '\\u00a2' .. '\\u00a5' | '\\u00aa' | '\\u00ad' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u0236' | '\\u0250' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u0300' .. '\\u0357' | '\\u035d' .. '\\u036f' | '\\u037a' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u03fb' | '\\u0400' .. '\\u0481' | '\\u0483' .. '\\u0486' | '\\u048a' .. '\\u04ce' | '\\u04d0' .. '\\u04f5' | '\\u04f8' .. '\\u04f9' | '\\u0500' .. '\\u050f' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u0591' .. '\\u05a1' | '\\u05a3' .. '\\u05b9' | '\\u05bb' .. '\\u05bd' | '\\u05bf' | '\\u05c1' .. '\\u05c2' | '\\u05c4' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u0658' | '\\u0660' .. '\\u0669' | '\\u066e' .. '\\u06d3' | '\\u06d5' .. '\\u06dd' | '\\u06df' .. '\\u06e8' | '\\u06ea' .. '\\u06fc' | '\\u06ff' | '\\u070f' .. '\\u074a' | '\\u074d' .. '\\u074f' | '\\u0780' .. '\\u07b1' | '\\u0901' .. '\\u0939' | '\\u093c' .. '\\u094d' | '\\u0950' .. '\\u0954' | '\\u0958' .. '\\u0963' | '\\u0966' .. '\\u096f' | '\\u0981' .. '\\u0983' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bc' .. '\\u09c4' | '\\u09c7' .. '\\u09c8' | '\\u09cb' .. '\\u09cd' | '\\u09d7' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e3' | '\\u09e6' .. '\\u09f3' | '\\u0a01' .. '\\u0a03' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a3c' | '\\u0a3e' .. '\\u0a42' | '\\u0a47' .. '\\u0a48' | '\\u0a4b' .. '\\u0a4d' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a66' .. '\\u0a74' | '\\u0a81' .. '\\u0a83' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abc' .. '\\u0ac5' | '\\u0ac7' .. '\\u0ac9' | '\\u0acb' .. '\\u0acd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae3' | '\\u0ae6' .. '\\u0aef' | '\\u0af1' | '\\u0b01' .. '\\u0b03' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3c' .. '\\u0b43' | '\\u0b47' .. '\\u0b48' | '\\u0b4b' .. '\\u0b4d' | '\\u0b56' .. '\\u0b57' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b66' .. '\\u0b6f' | '\\u0b71' | '\\u0b82' .. '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb5' | '\\u0bb7' .. '\\u0bb9' | '\\u0bbe' .. '\\u0bc2' | '\\u0bc6' .. '\\u0bc8' | '\\u0bca' .. '\\u0bcd' | '\\u0bd7' | '\\u0be7' .. '\\u0bef' | '\\u0bf9' | '\\u0c01' .. '\\u0c03' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c3e' .. '\\u0c44' | '\\u0c46' .. '\\u0c48' | '\\u0c4a' .. '\\u0c4d' | '\\u0c55' .. '\\u0c56' | '\\u0c60' .. '\\u0c61' | '\\u0c66' .. '\\u0c6f' | '\\u0c82' .. '\\u0c83' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbc' .. '\\u0cc4' | '\\u0cc6' .. '\\u0cc8' | '\\u0cca' .. '\\u0ccd' | '\\u0cd5' .. '\\u0cd6' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0ce6' .. '\\u0cef' | '\\u0d02' .. '\\u0d03' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d3e' .. '\\u0d43' | '\\u0d46' .. '\\u0d48' | '\\u0d4a' .. '\\u0d4d' | '\\u0d57' | '\\u0d60' .. '\\u0d61' | '\\u0d66' .. '\\u0d6f' | '\\u0d82' .. '\\u0d83' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0dca' | '\\u0dcf' .. '\\u0dd4' | '\\u0dd6' | '\\u0dd8' .. '\\u0ddf' | '\\u0df2' .. '\\u0df3' | '\\u0e01' .. '\\u0e3a' | '\\u0e3f' .. '\\u0e4e' | '\\u0e50' .. '\\u0e59' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb9' | '\\u0ebb' .. '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0ec8' .. '\\u0ecd' | '\\u0ed0' .. '\\u0ed9' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f18' .. '\\u0f19' | '\\u0f20' .. '\\u0f29' | '\\u0f35' | '\\u0f37' | '\\u0f39' | '\\u0f3e' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f71' .. '\\u0f84' | '\\u0f86' .. '\\u0f8b' | '\\u0f90' .. '\\u0f97' | '\\u0f99' .. '\\u0fbc' | '\\u0fc6' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u102c' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1050' .. '\\u1059' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10f8' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12ae' | '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12ce' | '\\u12d0' .. '\\u12d6' | '\\u12d8' .. '\\u12ee' | '\\u12f0' .. '\\u130e' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131e' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135a' | '\\u1369' .. '\\u1371' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1714' | '\\u1720' .. '\\u1734' | '\\u1740' .. '\\u1753' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1772' .. '\\u1773' | '\\u1780' .. '\\u17d3' | '\\u17d7' | '\\u17db' .. '\\u17dd' | '\\u17e0' .. '\\u17e9' | '\\u180b' .. '\\u180d' | '\\u1810' .. '\\u1819' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a9' | '\\u1900' .. '\\u191c' | '\\u1920' .. '\\u192b' | '\\u1930' .. '\\u193b' | '\\u1946' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1d00' .. '\\u1d6b' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u200c' .. '\\u200f' | '\\u202a' .. '\\u202e' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2060' .. '\\u2063' | '\\u206a' .. '\\u206f' | '\\u2071' | '\\u207f' | '\\u20a0' .. '\\u20b1' | '\\u20d0' .. '\\u20dc' | '\\u20e1' | '\\u20e5' .. '\\u20ea' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u213d' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u302f' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u3099' .. '\\u309a' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fa5' | '\\ua000' .. '\\ua48c' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfc' | '\\ufe00' .. '\\ufe0f' | '\\ufe20' .. '\\ufe23' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe69' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\ufeff' | '\\uff04' | '\\uff10' .. '\\uff19' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff65' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\uffe0' .. '\\uffe1' | '\\uffe5' .. '\\uffe6' | '\\ufff9' .. '\\ufffb' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\b')||(LA5_0>='\u000E' && LA5_0<='\u001B')||LA5_0=='$'||(LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u007F' && LA5_0<='\u009F')||(LA5_0>='\u00A2' && LA5_0<='\u00A5')||LA5_0=='\u00AA'||LA5_0=='\u00AD'||LA5_0=='\u00B5'||LA5_0=='\u00BA'||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u0236')||(LA5_0>='\u0250' && LA5_0<='\u02C1')||(LA5_0>='\u02C6' && LA5_0<='\u02D1')||(LA5_0>='\u02E0' && LA5_0<='\u02E4')||LA5_0=='\u02EE'||(LA5_0>='\u0300' && LA5_0<='\u0357')||(LA5_0>='\u035D' && LA5_0<='\u036F')||LA5_0=='\u037A'||LA5_0=='\u0386'||(LA5_0>='\u0388' && LA5_0<='\u038A')||LA5_0=='\u038C'||(LA5_0>='\u038E' && LA5_0<='\u03A1')||(LA5_0>='\u03A3' && LA5_0<='\u03CE')||(LA5_0>='\u03D0' && LA5_0<='\u03F5')||(LA5_0>='\u03F7' && LA5_0<='\u03FB')||(LA5_0>='\u0400' && LA5_0<='\u0481')||(LA5_0>='\u0483' && LA5_0<='\u0486')||(LA5_0>='\u048A' && LA5_0<='\u04CE')||(LA5_0>='\u04D0' && LA5_0<='\u04F5')||(LA5_0>='\u04F8' && LA5_0<='\u04F9')||(LA5_0>='\u0500' && LA5_0<='\u050F')||(LA5_0>='\u0531' && LA5_0<='\u0556')||LA5_0=='\u0559'||(LA5_0>='\u0561' && LA5_0<='\u0587')||(LA5_0>='\u0591' && LA5_0<='\u05A1')||(LA5_0>='\u05A3' && LA5_0<='\u05B9')||(LA5_0>='\u05BB' && LA5_0<='\u05BD')||LA5_0=='\u05BF'||(LA5_0>='\u05C1' && LA5_0<='\u05C2')||LA5_0=='\u05C4'||(LA5_0>='\u05D0' && LA5_0<='\u05EA')||(LA5_0>='\u05F0' && LA5_0<='\u05F2')||(LA5_0>='\u0600' && LA5_0<='\u0603')||(LA5_0>='\u0610' && LA5_0<='\u0615')||(LA5_0>='\u0621' && LA5_0<='\u063A')||(LA5_0>='\u0640' && LA5_0<='\u0658')||(LA5_0>='\u0660' && LA5_0<='\u0669')||(LA5_0>='\u066E' && LA5_0<='\u06D3')||(LA5_0>='\u06D5' && LA5_0<='\u06DD')||(LA5_0>='\u06DF' && LA5_0<='\u06E8')||(LA5_0>='\u06EA' && LA5_0<='\u06FC')||LA5_0=='\u06FF'||(LA5_0>='\u070F' && LA5_0<='\u074A')||(LA5_0>='\u074D' && LA5_0<='\u074F')||(LA5_0>='\u0780' && LA5_0<='\u07B1')||(LA5_0>='\u0901' && LA5_0<='\u0939')||(LA5_0>='\u093C' && LA5_0<='\u094D')||(LA5_0>='\u0950' && LA5_0<='\u0954')||(LA5_0>='\u0958' && LA5_0<='\u0963')||(LA5_0>='\u0966' && LA5_0<='\u096F')||(LA5_0>='\u0981' && LA5_0<='\u0983')||(LA5_0>='\u0985' && LA5_0<='\u098C')||(LA5_0>='\u098F' && LA5_0<='\u0990')||(LA5_0>='\u0993' && LA5_0<='\u09A8')||(LA5_0>='\u09AA' && LA5_0<='\u09B0')||LA5_0=='\u09B2'||(LA5_0>='\u09B6' && LA5_0<='\u09B9')||(LA5_0>='\u09BC' && LA5_0<='\u09C4')||(LA5_0>='\u09C7' && LA5_0<='\u09C8')||(LA5_0>='\u09CB' && LA5_0<='\u09CD')||LA5_0=='\u09D7'||(LA5_0>='\u09DC' && LA5_0<='\u09DD')||(LA5_0>='\u09DF' && LA5_0<='\u09E3')||(LA5_0>='\u09E6' && LA5_0<='\u09F3')||(LA5_0>='\u0A01' && LA5_0<='\u0A03')||(LA5_0>='\u0A05' && LA5_0<='\u0A0A')||(LA5_0>='\u0A0F' && LA5_0<='\u0A10')||(LA5_0>='\u0A13' && LA5_0<='\u0A28')||(LA5_0>='\u0A2A' && LA5_0<='\u0A30')||(LA5_0>='\u0A32' && LA5_0<='\u0A33')||(LA5_0>='\u0A35' && LA5_0<='\u0A36')||(LA5_0>='\u0A38' && LA5_0<='\u0A39')||LA5_0=='\u0A3C'||(LA5_0>='\u0A3E' && LA5_0<='\u0A42')||(LA5_0>='\u0A47' && LA5_0<='\u0A48')||(LA5_0>='\u0A4B' && LA5_0<='\u0A4D')||(LA5_0>='\u0A59' && LA5_0<='\u0A5C')||LA5_0=='\u0A5E'||(LA5_0>='\u0A66' && LA5_0<='\u0A74')||(LA5_0>='\u0A81' && LA5_0<='\u0A83')||(LA5_0>='\u0A85' && LA5_0<='\u0A8D')||(LA5_0>='\u0A8F' && LA5_0<='\u0A91')||(LA5_0>='\u0A93' && LA5_0<='\u0AA8')||(LA5_0>='\u0AAA' && LA5_0<='\u0AB0')||(LA5_0>='\u0AB2' && LA5_0<='\u0AB3')||(LA5_0>='\u0AB5' && LA5_0<='\u0AB9')||(LA5_0>='\u0ABC' && LA5_0<='\u0AC5')||(LA5_0>='\u0AC7' && LA5_0<='\u0AC9')||(LA5_0>='\u0ACB' && LA5_0<='\u0ACD')||LA5_0=='\u0AD0'||(LA5_0>='\u0AE0' && LA5_0<='\u0AE3')||(LA5_0>='\u0AE6' && LA5_0<='\u0AEF')||LA5_0=='\u0AF1'||(LA5_0>='\u0B01' && LA5_0<='\u0B03')||(LA5_0>='\u0B05' && LA5_0<='\u0B0C')||(LA5_0>='\u0B0F' && LA5_0<='\u0B10')||(LA5_0>='\u0B13' && LA5_0<='\u0B28')||(LA5_0>='\u0B2A' && LA5_0<='\u0B30')||(LA5_0>='\u0B32' && LA5_0<='\u0B33')||(LA5_0>='\u0B35' && LA5_0<='\u0B39')||(LA5_0>='\u0B3C' && LA5_0<='\u0B43')||(LA5_0>='\u0B47' && LA5_0<='\u0B48')||(LA5_0>='\u0B4B' && LA5_0<='\u0B4D')||(LA5_0>='\u0B56' && LA5_0<='\u0B57')||(LA5_0>='\u0B5C' && LA5_0<='\u0B5D')||(LA5_0>='\u0B5F' && LA5_0<='\u0B61')||(LA5_0>='\u0B66' && LA5_0<='\u0B6F')||LA5_0=='\u0B71'||(LA5_0>='\u0B82' && LA5_0<='\u0B83')||(LA5_0>='\u0B85' && LA5_0<='\u0B8A')||(LA5_0>='\u0B8E' && LA5_0<='\u0B90')||(LA5_0>='\u0B92' && LA5_0<='\u0B95')||(LA5_0>='\u0B99' && LA5_0<='\u0B9A')||LA5_0=='\u0B9C'||(LA5_0>='\u0B9E' && LA5_0<='\u0B9F')||(LA5_0>='\u0BA3' && LA5_0<='\u0BA4')||(LA5_0>='\u0BA8' && LA5_0<='\u0BAA')||(LA5_0>='\u0BAE' && LA5_0<='\u0BB5')||(LA5_0>='\u0BB7' && LA5_0<='\u0BB9')||(LA5_0>='\u0BBE' && LA5_0<='\u0BC2')||(LA5_0>='\u0BC6' && LA5_0<='\u0BC8')||(LA5_0>='\u0BCA' && LA5_0<='\u0BCD')||LA5_0=='\u0BD7'||(LA5_0>='\u0BE7' && LA5_0<='\u0BEF')||LA5_0=='\u0BF9'||(LA5_0>='\u0C01' && LA5_0<='\u0C03')||(LA5_0>='\u0C05' && LA5_0<='\u0C0C')||(LA5_0>='\u0C0E' && LA5_0<='\u0C10')||(LA5_0>='\u0C12' && LA5_0<='\u0C28')||(LA5_0>='\u0C2A' && LA5_0<='\u0C33')||(LA5_0>='\u0C35' && LA5_0<='\u0C39')||(LA5_0>='\u0C3E' && LA5_0<='\u0C44')||(LA5_0>='\u0C46' && LA5_0<='\u0C48')||(LA5_0>='\u0C4A' && LA5_0<='\u0C4D')||(LA5_0>='\u0C55' && LA5_0<='\u0C56')||(LA5_0>='\u0C60' && LA5_0<='\u0C61')||(LA5_0>='\u0C66' && LA5_0<='\u0C6F')||(LA5_0>='\u0C82' && LA5_0<='\u0C83')||(LA5_0>='\u0C85' && LA5_0<='\u0C8C')||(LA5_0>='\u0C8E' && LA5_0<='\u0C90')||(LA5_0>='\u0C92' && LA5_0<='\u0CA8')||(LA5_0>='\u0CAA' && LA5_0<='\u0CB3')||(LA5_0>='\u0CB5' && LA5_0<='\u0CB9')||(LA5_0>='\u0CBC' && LA5_0<='\u0CC4')||(LA5_0>='\u0CC6' && LA5_0<='\u0CC8')||(LA5_0>='\u0CCA' && LA5_0<='\u0CCD')||(LA5_0>='\u0CD5' && LA5_0<='\u0CD6')||LA5_0=='\u0CDE'||(LA5_0>='\u0CE0' && LA5_0<='\u0CE1')||(LA5_0>='\u0CE6' && LA5_0<='\u0CEF')||(LA5_0>='\u0D02' && LA5_0<='\u0D03')||(LA5_0>='\u0D05' && LA5_0<='\u0D0C')||(LA5_0>='\u0D0E' && LA5_0<='\u0D10')||(LA5_0>='\u0D12' && LA5_0<='\u0D28')||(LA5_0>='\u0D2A' && LA5_0<='\u0D39')||(LA5_0>='\u0D3E' && LA5_0<='\u0D43')||(LA5_0>='\u0D46' && LA5_0<='\u0D48')||(LA5_0>='\u0D4A' && LA5_0<='\u0D4D')||LA5_0=='\u0D57'||(LA5_0>='\u0D60' && LA5_0<='\u0D61')||(LA5_0>='\u0D66' && LA5_0<='\u0D6F')||(LA5_0>='\u0D82' && LA5_0<='\u0D83')||(LA5_0>='\u0D85' && LA5_0<='\u0D96')||(LA5_0>='\u0D9A' && LA5_0<='\u0DB1')||(LA5_0>='\u0DB3' && LA5_0<='\u0DBB')||LA5_0=='\u0DBD'||(LA5_0>='\u0DC0' && LA5_0<='\u0DC6')||LA5_0=='\u0DCA'||(LA5_0>='\u0DCF' && LA5_0<='\u0DD4')||LA5_0=='\u0DD6'||(LA5_0>='\u0DD8' && LA5_0<='\u0DDF')||(LA5_0>='\u0DF2' && LA5_0<='\u0DF3')||(LA5_0>='\u0E01' && LA5_0<='\u0E3A')||(LA5_0>='\u0E3F' && LA5_0<='\u0E4E')||(LA5_0>='\u0E50' && LA5_0<='\u0E59')||(LA5_0>='\u0E81' && LA5_0<='\u0E82')||LA5_0=='\u0E84'||(LA5_0>='\u0E87' && LA5_0<='\u0E88')||LA5_0=='\u0E8A'||LA5_0=='\u0E8D'||(LA5_0>='\u0E94' && LA5_0<='\u0E97')||(LA5_0>='\u0E99' && LA5_0<='\u0E9F')||(LA5_0>='\u0EA1' && LA5_0<='\u0EA3')||LA5_0=='\u0EA5'||LA5_0=='\u0EA7'||(LA5_0>='\u0EAA' && LA5_0<='\u0EAB')||(LA5_0>='\u0EAD' && LA5_0<='\u0EB9')||(LA5_0>='\u0EBB' && LA5_0<='\u0EBD')||(LA5_0>='\u0EC0' && LA5_0<='\u0EC4')||LA5_0=='\u0EC6'||(LA5_0>='\u0EC8' && LA5_0<='\u0ECD')||(LA5_0>='\u0ED0' && LA5_0<='\u0ED9')||(LA5_0>='\u0EDC' && LA5_0<='\u0EDD')||LA5_0=='\u0F00'||(LA5_0>='\u0F18' && LA5_0<='\u0F19')||(LA5_0>='\u0F20' && LA5_0<='\u0F29')||LA5_0=='\u0F35'||LA5_0=='\u0F37'||LA5_0=='\u0F39'||(LA5_0>='\u0F3E' && LA5_0<='\u0F47')||(LA5_0>='\u0F49' && LA5_0<='\u0F6A')||(LA5_0>='\u0F71' && LA5_0<='\u0F84')||(LA5_0>='\u0F86' && LA5_0<='\u0F8B')||(LA5_0>='\u0F90' && LA5_0<='\u0F97')||(LA5_0>='\u0F99' && LA5_0<='\u0FBC')||LA5_0=='\u0FC6'||(LA5_0>='\u1000' && LA5_0<='\u1021')||(LA5_0>='\u1023' && LA5_0<='\u1027')||(LA5_0>='\u1029' && LA5_0<='\u102A')||(LA5_0>='\u102C' && LA5_0<='\u1032')||(LA5_0>='\u1036' && LA5_0<='\u1039')||(LA5_0>='\u1040' && LA5_0<='\u1049')||(LA5_0>='\u1050' && LA5_0<='\u1059')||(LA5_0>='\u10A0' && LA5_0<='\u10C5')||(LA5_0>='\u10D0' && LA5_0<='\u10F8')||(LA5_0>='\u1100' && LA5_0<='\u1159')||(LA5_0>='\u115F' && LA5_0<='\u11A2')||(LA5_0>='\u11A8' && LA5_0<='\u11F9')||(LA5_0>='\u1200' && LA5_0<='\u1206')||(LA5_0>='\u1208' && LA5_0<='\u1246')||LA5_0=='\u1248'||(LA5_0>='\u124A' && LA5_0<='\u124D')||(LA5_0>='\u1250' && LA5_0<='\u1256')||LA5_0=='\u1258'||(LA5_0>='\u125A' && LA5_0<='\u125D')||(LA5_0>='\u1260' && LA5_0<='\u1286')||LA5_0=='\u1288'||(LA5_0>='\u128A' && LA5_0<='\u128D')||(LA5_0>='\u1290' && LA5_0<='\u12AE')||LA5_0=='\u12B0'||(LA5_0>='\u12B2' && LA5_0<='\u12B5')||(LA5_0>='\u12B8' && LA5_0<='\u12BE')||LA5_0=='\u12C0'||(LA5_0>='\u12C2' && LA5_0<='\u12C5')||(LA5_0>='\u12C8' && LA5_0<='\u12CE')||(LA5_0>='\u12D0' && LA5_0<='\u12D6')||(LA5_0>='\u12D8' && LA5_0<='\u12EE')||(LA5_0>='\u12F0' && LA5_0<='\u130E')||LA5_0=='\u1310'||(LA5_0>='\u1312' && LA5_0<='\u1315')||(LA5_0>='\u1318' && LA5_0<='\u131E')||(LA5_0>='\u1320' && LA5_0<='\u1346')||(LA5_0>='\u1348' && LA5_0<='\u135A')||(LA5_0>='\u1369' && LA5_0<='\u1371')||(LA5_0>='\u13A0' && LA5_0<='\u13F4')||(LA5_0>='\u1401' && LA5_0<='\u166C')||(LA5_0>='\u166F' && LA5_0<='\u1676')||(LA5_0>='\u1681' && LA5_0<='\u169A')||(LA5_0>='\u16A0' && LA5_0<='\u16EA')||(LA5_0>='\u16EE' && LA5_0<='\u16F0')||(LA5_0>='\u1700' && LA5_0<='\u170C')||(LA5_0>='\u170E' && LA5_0<='\u1714')||(LA5_0>='\u1720' && LA5_0<='\u1734')||(LA5_0>='\u1740' && LA5_0<='\u1753')||(LA5_0>='\u1760' && LA5_0<='\u176C')||(LA5_0>='\u176E' && LA5_0<='\u1770')||(LA5_0>='\u1772' && LA5_0<='\u1773')||(LA5_0>='\u1780' && LA5_0<='\u17D3')||LA5_0=='\u17D7'||(LA5_0>='\u17DB' && LA5_0<='\u17DD')||(LA5_0>='\u17E0' && LA5_0<='\u17E9')||(LA5_0>='\u180B' && LA5_0<='\u180D')||(LA5_0>='\u1810' && LA5_0<='\u1819')||(LA5_0>='\u1820' && LA5_0<='\u1877')||(LA5_0>='\u1880' && LA5_0<='\u18A9')||(LA5_0>='\u1900' && LA5_0<='\u191C')||(LA5_0>='\u1920' && LA5_0<='\u192B')||(LA5_0>='\u1930' && LA5_0<='\u193B')||(LA5_0>='\u1946' && LA5_0<='\u196D')||(LA5_0>='\u1970' && LA5_0<='\u1974')||(LA5_0>='\u1D00' && LA5_0<='\u1D6B')||(LA5_0>='\u1E00' && LA5_0<='\u1E9B')||(LA5_0>='\u1EA0' && LA5_0<='\u1EF9')||(LA5_0>='\u1F00' && LA5_0<='\u1F15')||(LA5_0>='\u1F18' && LA5_0<='\u1F1D')||(LA5_0>='\u1F20' && LA5_0<='\u1F45')||(LA5_0>='\u1F48' && LA5_0<='\u1F4D')||(LA5_0>='\u1F50' && LA5_0<='\u1F57')||LA5_0=='\u1F59'||LA5_0=='\u1F5B'||LA5_0=='\u1F5D'||(LA5_0>='\u1F5F' && LA5_0<='\u1F7D')||(LA5_0>='\u1F80' && LA5_0<='\u1FB4')||(LA5_0>='\u1FB6' && LA5_0<='\u1FBC')||LA5_0=='\u1FBE'||(LA5_0>='\u1FC2' && LA5_0<='\u1FC4')||(LA5_0>='\u1FC6' && LA5_0<='\u1FCC')||(LA5_0>='\u1FD0' && LA5_0<='\u1FD3')||(LA5_0>='\u1FD6' && LA5_0<='\u1FDB')||(LA5_0>='\u1FE0' && LA5_0<='\u1FEC')||(LA5_0>='\u1FF2' && LA5_0<='\u1FF4')||(LA5_0>='\u1FF6' && LA5_0<='\u1FFC')||(LA5_0>='\u200C' && LA5_0<='\u200F')||(LA5_0>='\u202A' && LA5_0<='\u202E')||(LA5_0>='\u203F' && LA5_0<='\u2040')||LA5_0=='\u2054'||(LA5_0>='\u2060' && LA5_0<='\u2063')||(LA5_0>='\u206A' && LA5_0<='\u206F')||LA5_0=='\u2071'||LA5_0=='\u207F'||(LA5_0>='\u20A0' && LA5_0<='\u20B1')||(LA5_0>='\u20D0' && LA5_0<='\u20DC')||LA5_0=='\u20E1'||(LA5_0>='\u20E5' && LA5_0<='\u20EA')||LA5_0=='\u2102'||LA5_0=='\u2107'||(LA5_0>='\u210A' && LA5_0<='\u2113')||LA5_0=='\u2115'||(LA5_0>='\u2119' && LA5_0<='\u211D')||LA5_0=='\u2124'||LA5_0=='\u2126'||LA5_0=='\u2128'||(LA5_0>='\u212A' && LA5_0<='\u212D')||(LA5_0>='\u212F' && LA5_0<='\u2131')||(LA5_0>='\u2133' && LA5_0<='\u2139')||(LA5_0>='\u213D' && LA5_0<='\u213F')||(LA5_0>='\u2145' && LA5_0<='\u2149')||(LA5_0>='\u2160' && LA5_0<='\u2183')||(LA5_0>='\u3005' && LA5_0<='\u3007')||(LA5_0>='\u3021' && LA5_0<='\u302F')||(LA5_0>='\u3031' && LA5_0<='\u3035')||(LA5_0>='\u3038' && LA5_0<='\u303C')||(LA5_0>='\u3041' && LA5_0<='\u3096')||(LA5_0>='\u3099' && LA5_0<='\u309A')||(LA5_0>='\u309D' && LA5_0<='\u309F')||(LA5_0>='\u30A1' && LA5_0<='\u30FF')||(LA5_0>='\u3105' && LA5_0<='\u312C')||(LA5_0>='\u3131' && LA5_0<='\u318E')||(LA5_0>='\u31A0' && LA5_0<='\u31B7')||(LA5_0>='\u31F0' && LA5_0<='\u31FF')||(LA5_0>='\u3400' && LA5_0<='\u4DB5')||(LA5_0>='\u4E00' && LA5_0<='\u9FA5')||(LA5_0>='\uA000' && LA5_0<='\uA48C')||(LA5_0>='\uAC00' && LA5_0<='\uD7A3')||(LA5_0>='\uF900' && LA5_0<='\uFA2D')||(LA5_0>='\uFA30' && LA5_0<='\uFA6A')||(LA5_0>='\uFB00' && LA5_0<='\uFB06')||(LA5_0>='\uFB13' && LA5_0<='\uFB17')||(LA5_0>='\uFB1D' && LA5_0<='\uFB28')||(LA5_0>='\uFB2A' && LA5_0<='\uFB36')||(LA5_0>='\uFB38' && LA5_0<='\uFB3C')||LA5_0=='\uFB3E'||(LA5_0>='\uFB40' && LA5_0<='\uFB41')||(LA5_0>='\uFB43' && LA5_0<='\uFB44')||(LA5_0>='\uFB46' && LA5_0<='\uFBB1')||(LA5_0>='\uFBD3' && LA5_0<='\uFD3D')||(LA5_0>='\uFD50' && LA5_0<='\uFD8F')||(LA5_0>='\uFD92' && LA5_0<='\uFDC7')||(LA5_0>='\uFDF0' && LA5_0<='\uFDFC')||(LA5_0>='\uFE00' && LA5_0<='\uFE0F')||(LA5_0>='\uFE20' && LA5_0<='\uFE23')||(LA5_0>='\uFE33' && LA5_0<='\uFE34')||(LA5_0>='\uFE4D' && LA5_0<='\uFE4F')||LA5_0=='\uFE69'||(LA5_0>='\uFE70' && LA5_0<='\uFE74')||(LA5_0>='\uFE76' && LA5_0<='\uFEFC')||LA5_0=='\uFEFF'||LA5_0=='\uFF04'||(LA5_0>='\uFF10' && LA5_0<='\uFF19')||(LA5_0>='\uFF21' && LA5_0<='\uFF3A')||LA5_0=='\uFF3F'||(LA5_0>='\uFF41' && LA5_0<='\uFF5A')||(LA5_0>='\uFF65' && LA5_0<='\uFFBE')||(LA5_0>='\uFFC2' && LA5_0<='\uFFC7')||(LA5_0>='\uFFCA' && LA5_0<='\uFFCF')||(LA5_0>='\uFFD2' && LA5_0<='\uFFD7')||(LA5_0>='\uFFDA' && LA5_0<='\uFFDC')||(LA5_0>='\uFFE0' && LA5_0<='\uFFE1')||(LA5_0>='\uFFE5' && LA5_0<='\uFFE6')||(LA5_0>='\uFFF9' && LA5_0<='\uFFFB')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001B')||input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u007F' && input.LA(1)<='\u009F')||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00AD'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u0236')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||(input.LA(1)>='\u0300' && input.LA(1)<='\u0357')||(input.LA(1)>='\u035D' && input.LA(1)<='\u036F')||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u03FB')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u0483' && input.LA(1)<='\u0486')||(input.LA(1)>='\u048A' && input.LA(1)<='\u04CE')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0500' && input.LA(1)<='\u050F')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u0591' && input.LA(1)<='\u05A1')||(input.LA(1)>='\u05A3' && input.LA(1)<='\u05B9')||(input.LA(1)>='\u05BB' && input.LA(1)<='\u05BD')||input.LA(1)=='\u05BF'||(input.LA(1)>='\u05C1' && input.LA(1)<='\u05C2')||input.LA(1)=='\u05C4'||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0600' && input.LA(1)<='\u0603')||(input.LA(1)>='\u0610' && input.LA(1)<='\u0615')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u0658')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u066E' && input.LA(1)<='\u06D3')||(input.LA(1)>='\u06D5' && input.LA(1)<='\u06DD')||(input.LA(1)>='\u06DF' && input.LA(1)<='\u06E8')||(input.LA(1)>='\u06EA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||(input.LA(1)>='\u070F' && input.LA(1)<='\u074A')||(input.LA(1)>='\u074D' && input.LA(1)<='\u074F')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07B1')||(input.LA(1)>='\u0901' && input.LA(1)<='\u0939')||(input.LA(1)>='\u093C' && input.LA(1)<='\u094D')||(input.LA(1)>='\u0950' && input.LA(1)<='\u0954')||(input.LA(1)>='\u0958' && input.LA(1)<='\u0963')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0981' && input.LA(1)<='\u0983')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09BC' && input.LA(1)<='\u09C4')||(input.LA(1)>='\u09C7' && input.LA(1)<='\u09C8')||(input.LA(1)>='\u09CB' && input.LA(1)<='\u09CD')||input.LA(1)=='\u09D7'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E3')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F3')||(input.LA(1)>='\u0A01' && input.LA(1)<='\u0A03')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||input.LA(1)=='\u0A3C'||(input.LA(1)>='\u0A3E' && input.LA(1)<='\u0A42')||(input.LA(1)>='\u0A47' && input.LA(1)<='\u0A48')||(input.LA(1)>='\u0A4B' && input.LA(1)<='\u0A4D')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A81' && input.LA(1)<='\u0A83')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||(input.LA(1)>='\u0ABC' && input.LA(1)<='\u0AC5')||(input.LA(1)>='\u0AC7' && input.LA(1)<='\u0AC9')||(input.LA(1)>='\u0ACB' && input.LA(1)<='\u0ACD')||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE3')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||input.LA(1)=='\u0AF1'||(input.LA(1)>='\u0B01' && input.LA(1)<='\u0B03')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||(input.LA(1)>='\u0B3C' && input.LA(1)<='\u0B43')||(input.LA(1)>='\u0B47' && input.LA(1)<='\u0B48')||(input.LA(1)>='\u0B4B' && input.LA(1)<='\u0B4D')||(input.LA(1)>='\u0B56' && input.LA(1)<='\u0B57')||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||input.LA(1)=='\u0B71'||(input.LA(1)>='\u0B82' && input.LA(1)<='\u0B83')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BBE' && input.LA(1)<='\u0BC2')||(input.LA(1)>='\u0BC6' && input.LA(1)<='\u0BC8')||(input.LA(1)>='\u0BCA' && input.LA(1)<='\u0BCD')||input.LA(1)=='\u0BD7'||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||input.LA(1)=='\u0BF9'||(input.LA(1)>='\u0C01' && input.LA(1)<='\u0C03')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C3E' && input.LA(1)<='\u0C44')||(input.LA(1)>='\u0C46' && input.LA(1)<='\u0C48')||(input.LA(1)>='\u0C4A' && input.LA(1)<='\u0C4D')||(input.LA(1)>='\u0C55' && input.LA(1)<='\u0C56')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C82' && input.LA(1)<='\u0C83')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||(input.LA(1)>='\u0CBC' && input.LA(1)<='\u0CC4')||(input.LA(1)>='\u0CC6' && input.LA(1)<='\u0CC8')||(input.LA(1)>='\u0CCA' && input.LA(1)<='\u0CCD')||(input.LA(1)>='\u0CD5' && input.LA(1)<='\u0CD6')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D02' && input.LA(1)<='\u0D03')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D3E' && input.LA(1)<='\u0D43')||(input.LA(1)>='\u0D46' && input.LA(1)<='\u0D48')||(input.LA(1)>='\u0D4A' && input.LA(1)<='\u0D4D')||input.LA(1)=='\u0D57'||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D82' && input.LA(1)<='\u0D83')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||input.LA(1)=='\u0DCA'||(input.LA(1)>='\u0DCF' && input.LA(1)<='\u0DD4')||input.LA(1)=='\u0DD6'||(input.LA(1)>='\u0DD8' && input.LA(1)<='\u0DDF')||(input.LA(1)>='\u0DF2' && input.LA(1)<='\u0DF3')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E3A')||(input.LA(1)>='\u0E3F' && input.LA(1)<='\u0E4E')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB9')||(input.LA(1)>='\u0EBB' && input.LA(1)<='\u0EBD')||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EC8' && input.LA(1)<='\u0ECD')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F18' && input.LA(1)<='\u0F19')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||input.LA(1)=='\u0F35'||input.LA(1)=='\u0F37'||input.LA(1)=='\u0F39'||(input.LA(1)>='\u0F3E' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F71' && input.LA(1)<='\u0F84')||(input.LA(1)>='\u0F86' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u0F90' && input.LA(1)<='\u0F97')||(input.LA(1)>='\u0F99' && input.LA(1)<='\u0FBC')||input.LA(1)=='\u0FC6'||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u102C' && input.LA(1)<='\u1032')||(input.LA(1)>='\u1036' && input.LA(1)<='\u1039')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1059')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F8')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1714')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1734')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1753')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1772' && input.LA(1)<='\u1773')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17D3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DB' && input.LA(1)<='\u17DD')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u180B' && input.LA(1)<='\u180D')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A9')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1920' && input.LA(1)<='\u192B')||(input.LA(1)>='\u1930' && input.LA(1)<='\u193B')||(input.LA(1)>='\u1946' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1D6B')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u200C' && input.LA(1)<='\u200F')||(input.LA(1)>='\u202A' && input.LA(1)<='\u202E')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||(input.LA(1)>='\u2060' && input.LA(1)<='\u2063')||(input.LA(1)>='\u206A' && input.LA(1)<='\u206F')||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20B1')||(input.LA(1)>='\u20D0' && input.LA(1)<='\u20DC')||input.LA(1)=='\u20E1'||(input.LA(1)>='\u20E5' && input.LA(1)<='\u20EA')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213D' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u302F')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u3099' && input.LA(1)<='\u309A')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FA5')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||(input.LA(1)>='\uFB1D' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFC')||(input.LA(1)>='\uFE00' && input.LA(1)<='\uFE0F')||(input.LA(1)>='\uFE20' && input.LA(1)<='\uFE23')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||input.LA(1)=='\uFE69'||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFEFF'||input.LA(1)=='\uFF04'||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF65' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFE0' && input.LA(1)<='\uFFE1')||(input.LA(1)>='\uFFE5' && input.LA(1)<='\uFFE6')||(input.LA(1)>='\uFFF9' && input.LA(1)<='\uFFFB') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:8: ( T__9 | T__10 | T__11 | DEF_IRI_REF | DEF_INTEGER | WHITESPACE | LINEBREAKS | IDENTIFIER )
        int alt6=8;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:27: DEF_IRI_REF
                {
                mDEF_IRI_REF(); 

                }
                break;
            case 5 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:39: DEF_INTEGER
                {
                mDEF_INTEGER(); 

                }
                break;
            case 6 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:51: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 7 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:62: LINEBREAKS
                {
                mLINEBREAKS(); 

                }
                break;
            case 8 :
                // E:\\Arbeit\\eclipse-SDK-3.4.1-win32-EMFText-Java5-DEV workspace\\org.emftext.language.sparql.resource.sparql\\src\\org\\emftext\\language\\sparql\\resource\\sparql\\Sparql.g:1:73: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA1_eotS =
        "\1\uffff\1\12\12\uffff";
    static final String DFA1_eofS =
        "\14\uffff";
    static final String DFA1_minS =
        "\2\42\12\uffff";
    static final String DFA1_maxS =
        "\2\175\12\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\1\1\2\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\3";
    static final String DFA1_specialS =
        "\14\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\1\11\30\uffff\1\3\1\uffff\1\1\35\uffff\1\10\1\uffff\1"+
            "\2\1\uffff\1\7\32\uffff\1\5\1\uffff\1\6",
            "\2\13\30\uffff\1\13\1\uffff\1\13\35\uffff\1\13\1\uffff\1\13"+
            "\1\uffff\1\13\32\uffff\1\13\1\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 655:9: ( '^' | '<' | '>' | '\"' | '{' | '}' | '`' | '\\\\' | ( '#' 'x' ( '0' .. '2' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) )*";
        }
    }
    static final String DFA6_eotS =
        "\1\5\2\10\6\uffff\4\10\1\17\1\10\1\uffff\1\10\1\22\1\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\11\1\101\1\122\6\uffff\1\123\2\105\1\106\1\0\1\111\1\uffff\1"+
        "\130\1\0\1\uffff";
    static final String DFA6_maxS =
        "\1\uffe6\1\101\1\122\6\uffff\1\123\2\105\1\106\1\ufffb\1\111\1"+
        "\uffff\1\130\1\ufffb\1\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\6\uffff\1\1\2\uffff\1\2";
    static final String DFA6_specialS =
        "\23\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\6\1\7\1\uffff\1\6\1\7\22\uffff\1\6\3\uffff\1\10\25\uffff"+
            "\1\3\1\uffff\1\4\4\uffff\1\10\1\1\15\10\1\2\12\10\4\uffff\1"+
            "\10\1\uffff\32\10\47\uffff\4\10\4\uffff\1\10\12\uffff\1\10\4"+
            "\uffff\1\10\5\uffff\27\10\1\uffff\37\10\1\uffff\u013f\10\31"+
            "\uffff\162\10\4\uffff\14\10\16\uffff\5\10\11\uffff\1\10\u008b"+
            "\uffff\1\10\13\uffff\1\10\1\uffff\3\10\1\uffff\1\10\1\uffff"+
            "\24\10\1\uffff\54\10\1\uffff\46\10\1\uffff\5\10\4\uffff\u0082"+
            "\10\10\uffff\105\10\1\uffff\46\10\2\uffff\2\10\6\uffff\20\10"+
            "\41\uffff\46\10\2\uffff\1\10\7\uffff\47\10\110\uffff\33\10\5"+
            "\uffff\3\10\56\uffff\32\10\5\uffff\13\10\43\uffff\2\10\1\uffff"+
            "\143\10\1\uffff\1\10\17\uffff\2\10\7\uffff\2\10\12\uffff\3\10"+
            "\2\uffff\1\10\20\uffff\1\10\1\uffff\36\10\35\uffff\3\10\60\uffff"+
            "\46\10\13\uffff\1\10\u0152\uffff\66\10\3\uffff\1\10\22\uffff"+
            "\1\10\7\uffff\12\10\43\uffff\10\10\2\uffff\2\10\2\uffff\26\10"+
            "\1\uffff\7\10\1\uffff\1\10\3\uffff\4\10\3\uffff\1\10\36\uffff"+
            "\2\10\1\uffff\3\10\16\uffff\4\10\21\uffff\6\10\4\uffff\2\10"+
            "\2\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff\2\10\1\uffff"+
            "\2\10\37\uffff\4\10\1\uffff\1\10\23\uffff\3\10\20\uffff\11\10"+
            "\1\uffff\3\10\1\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff"+
            "\5\10\3\uffff\1\10\22\uffff\1\10\17\uffff\2\10\17\uffff\1\10"+
            "\23\uffff\10\10\2\uffff\2\10\2\uffff\26\10\1\uffff\7\10\1\uffff"+
            "\2\10\1\uffff\5\10\3\uffff\1\10\36\uffff\2\10\1\uffff\3\10\17"+
            "\uffff\1\10\21\uffff\1\10\1\uffff\6\10\3\uffff\3\10\1\uffff"+
            "\4\10\3\uffff\2\10\1\uffff\1\10\1\uffff\2\10\3\uffff\2\10\3"+
            "\uffff\3\10\3\uffff\10\10\1\uffff\3\10\77\uffff\1\10\13\uffff"+
            "\10\10\1\uffff\3\10\1\uffff\27\10\1\uffff\12\10\1\uffff\5\10"+
            "\46\uffff\2\10\43\uffff\10\10\1\uffff\3\10\1\uffff\27\10\1\uffff"+
            "\12\10\1\uffff\5\10\3\uffff\1\10\40\uffff\1\10\1\uffff\2\10"+
            "\43\uffff\10\10\1\uffff\3\10\1\uffff\27\10\1\uffff\20\10\46"+
            "\uffff\2\10\43\uffff\22\10\3\uffff\30\10\1\uffff\11\10\1\uffff"+
            "\1\10\2\uffff\7\10\72\uffff\60\10\1\uffff\2\10\13\uffff\10\10"+
            "\72\uffff\2\10\1\uffff\1\10\2\uffff\2\10\1\uffff\1\10\2\uffff"+
            "\1\10\6\uffff\4\10\1\uffff\7\10\1\uffff\3\10\1\uffff\1\10\1"+
            "\uffff\1\10\2\uffff\2\10\1\uffff\4\10\1\uffff\2\10\11\uffff"+
            "\1\10\2\uffff\5\10\1\uffff\1\10\25\uffff\2\10\42\uffff\1\10"+
            "\77\uffff\10\10\1\uffff\42\10\35\uffff\4\10\164\uffff\42\10"+
            "\1\uffff\5\10\1\uffff\2\10\45\uffff\6\10\112\uffff\46\10\12"+
            "\uffff\51\10\7\uffff\132\10\5\uffff\104\10\5\uffff\122\10\6"+
            "\uffff\7\10\1\uffff\77\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff\47\10\1\uffff\1\10\1"+
            "\uffff\4\10\2\uffff\37\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff\7\10\1\uffff\7\10\1"+
            "\uffff\27\10\1\uffff\37\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\7\10\1\uffff\47\10\1\uffff\23\10\105\uffff\125\10\14\uffff"+
            "\u026c\10\2\uffff\10\10\12\uffff\32\10\5\uffff\113\10\3\uffff"+
            "\3\10\17\uffff\15\10\1\uffff\4\10\16\uffff\22\10\16\uffff\22"+
            "\10\16\uffff\15\10\1\uffff\3\10\17\uffff\64\10\43\uffff\1\10"+
            "\3\uffff\2\10\103\uffff\130\10\10\uffff\51\10\127\uffff\35\10"+
            "\63\uffff\36\10\2\uffff\5\10\u038b\uffff\154\10\u0094\uffff"+
            "\u009c\10\4\uffff\132\10\6\uffff\26\10\2\uffff\6\10\2\uffff"+
            "\46\10\2\uffff\6\10\2\uffff\10\10\1\uffff\1\10\1\uffff\1\10"+
            "\1\uffff\1\10\1\uffff\37\10\2\uffff\65\10\1\uffff\7\10\1\uffff"+
            "\1\10\3\uffff\3\10\1\uffff\7\10\3\uffff\4\10\2\uffff\6\10\4"+
            "\uffff\15\10\5\uffff\3\10\1\uffff\7\10\102\uffff\2\10\23\uffff"+
            "\1\10\34\uffff\1\10\15\uffff\1\10\40\uffff\22\10\120\uffff\1"+
            "\10\4\uffff\1\10\2\uffff\12\10\1\uffff\1\10\3\uffff\5\10\6\uffff"+
            "\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff\4\10\1\uffff\3\10\1"+
            "\uffff\7\10\3\uffff\3\10\5\uffff\5\10\26\uffff\44\10\u0e81\uffff"+
            "\3\10\31\uffff\11\10\7\uffff\5\10\2\uffff\5\10\4\uffff\126\10"+
            "\6\uffff\3\10\1\uffff\137\10\5\uffff\50\10\4\uffff\136\10\21"+
            "\uffff\30\10\70\uffff\20\10\u0200\uffff\u19b6\10\112\uffff\u51a6"+
            "\10\132\uffff\u048d\10\u0773\uffff\u2ba4\10\u215c\uffff\u012e"+
            "\10\2\uffff\73\10\u0095\uffff\7\10\14\uffff\5\10\5\uffff\1\10"+
            "\1\uffff\12\10\1\uffff\15\10\1\uffff\5\10\1\uffff\1\10\1\uffff"+
            "\2\10\1\uffff\2\10\1\uffff\154\10\41\uffff\u016b\10\22\uffff"+
            "\100\10\2\uffff\66\10\50\uffff\15\10\66\uffff\2\10\30\uffff"+
            "\3\10\31\uffff\1\10\6\uffff\5\10\1\uffff\u0087\10\7\uffff\1"+
            "\10\34\uffff\32\10\4\uffff\1\10\1\uffff\32\10\12\uffff\132\10"+
            "\3\uffff\6\10\2\uffff\6\10\2\uffff\6\10\2\uffff\3\10\3\uffff"+
            "\2\10\3\uffff\2\10",
            "\1\11",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\11\10\5\uffff\16\10\10\uffff\1\10\13\uffff\12\10\7\uffff"+
            "\32\10\4\uffff\1\10\1\uffff\32\10\4\uffff\41\10\2\uffff\4\10"+
            "\4\uffff\1\10\2\uffff\1\10\7\uffff\1\10\4\uffff\1\10\5\uffff"+
            "\27\10\1\uffff\37\10\1\uffff\u013f\10\31\uffff\162\10\4\uffff"+
            "\14\10\16\uffff\5\10\11\uffff\1\10\21\uffff\130\10\5\uffff\23"+
            "\10\12\uffff\1\10\13\uffff\1\10\1\uffff\3\10\1\uffff\1\10\1"+
            "\uffff\24\10\1\uffff\54\10\1\uffff\46\10\1\uffff\5\10\4\uffff"+
            "\u0082\10\1\uffff\4\10\3\uffff\105\10\1\uffff\46\10\2\uffff"+
            "\2\10\6\uffff\20\10\41\uffff\46\10\2\uffff\1\10\7\uffff\47\10"+
            "\11\uffff\21\10\1\uffff\27\10\1\uffff\3\10\1\uffff\1\10\1\uffff"+
            "\2\10\1\uffff\1\10\13\uffff\33\10\5\uffff\3\10\15\uffff\4\10"+
            "\14\uffff\6\10\13\uffff\32\10\5\uffff\31\10\7\uffff\12\10\4"+
            "\uffff\146\10\1\uffff\11\10\1\uffff\12\10\1\uffff\23\10\2\uffff"+
            "\1\10\17\uffff\74\10\2\uffff\3\10\60\uffff\62\10\u014f\uffff"+
            "\71\10\2\uffff\22\10\2\uffff\5\10\3\uffff\14\10\2\uffff\12\10"+
            "\21\uffff\3\10\1\uffff\10\10\2\uffff\2\10\2\uffff\26\10\1\uffff"+
            "\7\10\1\uffff\1\10\3\uffff\4\10\2\uffff\11\10\2\uffff\2\10\2"+
            "\uffff\3\10\11\uffff\1\10\4\uffff\2\10\1\uffff\5\10\2\uffff"+
            "\16\10\15\uffff\3\10\1\uffff\6\10\4\uffff\2\10\2\uffff\26\10"+
            "\1\uffff\7\10\1\uffff\2\10\1\uffff\2\10\1\uffff\2\10\2\uffff"+
            "\1\10\1\uffff\5\10\4\uffff\2\10\2\uffff\3\10\13\uffff\4\10\1"+
            "\uffff\1\10\7\uffff\17\10\14\uffff\3\10\1\uffff\11\10\1\uffff"+
            "\3\10\1\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff\5\10\2"+
            "\uffff\12\10\1\uffff\3\10\1\uffff\3\10\2\uffff\1\10\17\uffff"+
            "\4\10\2\uffff\12\10\1\uffff\1\10\17\uffff\3\10\1\uffff\10\10"+
            "\2\uffff\2\10\2\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff"+
            "\5\10\2\uffff\10\10\3\uffff\2\10\2\uffff\3\10\10\uffff\2\10"+
            "\4\uffff\2\10\1\uffff\3\10\4\uffff\12\10\1\uffff\1\10\20\uffff"+
            "\2\10\1\uffff\6\10\3\uffff\3\10\1\uffff\4\10\3\uffff\2\10\1"+
            "\uffff\1\10\1\uffff\2\10\3\uffff\2\10\3\uffff\3\10\3\uffff\10"+
            "\10\1\uffff\3\10\4\uffff\5\10\3\uffff\3\10\1\uffff\4\10\11\uffff"+
            "\1\10\17\uffff\11\10\11\uffff\1\10\7\uffff\3\10\1\uffff\10\10"+
            "\1\uffff\3\10\1\uffff\27\10\1\uffff\12\10\1\uffff\5\10\4\uffff"+
            "\7\10\1\uffff\3\10\1\uffff\4\10\7\uffff\2\10\11\uffff\2\10\4"+
            "\uffff\12\10\22\uffff\2\10\1\uffff\10\10\1\uffff\3\10\1\uffff"+
            "\27\10\1\uffff\12\10\1\uffff\5\10\2\uffff\11\10\1\uffff\3\10"+
            "\1\uffff\4\10\7\uffff\2\10\7\uffff\1\10\1\uffff\2\10\4\uffff"+
            "\12\10\22\uffff\2\10\1\uffff\10\10\1\uffff\3\10\1\uffff\27\10"+
            "\1\uffff\20\10\4\uffff\6\10\2\uffff\3\10\1\uffff\4\10\11\uffff"+
            "\1\10\10\uffff\2\10\4\uffff\12\10\22\uffff\2\10\1\uffff\22\10"+
            "\3\uffff\30\10\1\uffff\11\10\1\uffff\1\10\2\uffff\7\10\3\uffff"+
            "\1\10\4\uffff\6\10\1\uffff\1\10\1\uffff\10\10\22\uffff\2\10"+
            "\15\uffff\72\10\4\uffff\20\10\1\uffff\12\10\47\uffff\2\10\1"+
            "\uffff\1\10\2\uffff\2\10\1\uffff\1\10\2\uffff\1\10\6\uffff\4"+
            "\10\1\uffff\7\10\1\uffff\3\10\1\uffff\1\10\1\uffff\1\10\2\uffff"+
            "\2\10\1\uffff\15\10\1\uffff\3\10\2\uffff\5\10\1\uffff\1\10\1"+
            "\uffff\6\10\2\uffff\12\10\2\uffff\2\10\42\uffff\1\10\27\uffff"+
            "\2\10\6\uffff\12\10\13\uffff\1\10\1\uffff\1\10\1\uffff\1\10"+
            "\4\uffff\12\10\1\uffff\42\10\6\uffff\24\10\1\uffff\6\10\4\uffff"+
            "\10\10\1\uffff\44\10\11\uffff\1\10\71\uffff\42\10\1\uffff\5"+
            "\10\1\uffff\2\10\1\uffff\7\10\3\uffff\4\10\6\uffff\12\10\6\uffff"+
            "\12\10\106\uffff\46\10\12\uffff\51\10\7\uffff\132\10\5\uffff"+
            "\104\10\5\uffff\122\10\6\uffff\7\10\1\uffff\77\10\1\uffff\1"+
            "\10\1\uffff\4\10\2\uffff\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\47\10\1\uffff\1\10\1\uffff\4\10\2\uffff\37\10\1\uffff\1\10"+
            "\1\uffff\4\10\2\uffff\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\7\10\1\uffff\7\10\1\uffff\27\10\1\uffff\37\10\1\uffff\1\10"+
            "\1\uffff\4\10\2\uffff\7\10\1\uffff\47\10\1\uffff\23\10\16\uffff"+
            "\11\10\56\uffff\125\10\14\uffff\u026c\10\2\uffff\10\10\12\uffff"+
            "\32\10\5\uffff\113\10\3\uffff\3\10\17\uffff\15\10\1\uffff\7"+
            "\10\13\uffff\25\10\13\uffff\24\10\14\uffff\15\10\1\uffff\3\10"+
            "\1\uffff\2\10\14\uffff\124\10\3\uffff\1\10\3\uffff\3\10\2\uffff"+
            "\12\10\41\uffff\3\10\2\uffff\12\10\6\uffff\130\10\10\uffff\52"+
            "\10\126\uffff\35\10\3\uffff\14\10\4\uffff\14\10\12\uffff\50"+
            "\10\2\uffff\5\10\u038b\uffff\154\10\u0094\uffff\u009c\10\4\uffff"+
            "\132\10\6\uffff\26\10\2\uffff\6\10\2\uffff\46\10\2\uffff\6\10"+
            "\2\uffff\10\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff"+
            "\37\10\2\uffff\65\10\1\uffff\7\10\1\uffff\1\10\3\uffff\3\10"+
            "\1\uffff\7\10\3\uffff\4\10\2\uffff\6\10\4\uffff\15\10\5\uffff"+
            "\3\10\1\uffff\7\10\17\uffff\4\10\32\uffff\5\10\20\uffff\2\10"+
            "\23\uffff\1\10\13\uffff\4\10\6\uffff\6\10\1\uffff\1\10\15\uffff"+
            "\1\10\40\uffff\22\10\36\uffff\15\10\4\uffff\1\10\3\uffff\6\10"+
            "\27\uffff\1\10\4\uffff\1\10\2\uffff\12\10\1\uffff\1\10\3\uffff"+
            "\5\10\6\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff\4\10\1"+
            "\uffff\3\10\1\uffff\7\10\3\uffff\3\10\5\uffff\5\10\26\uffff"+
            "\44\10\u0e81\uffff\3\10\31\uffff\17\10\1\uffff\5\10\2\uffff"+
            "\5\10\4\uffff\126\10\2\uffff\2\10\2\uffff\3\10\1\uffff\137\10"+
            "\5\uffff\50\10\4\uffff\136\10\21\uffff\30\10\70\uffff\20\10"+
            "\u0200\uffff\u19b6\10\112\uffff\u51a6\10\132\uffff\u048d\10"+
            "\u0773\uffff\u2ba4\10\u215c\uffff\u012e\10\2\uffff\73\10\u0095"+
            "\uffff\7\10\14\uffff\5\10\5\uffff\14\10\1\uffff\15\10\1\uffff"+
            "\5\10\1\uffff\1\10\1\uffff\2\10\1\uffff\2\10\1\uffff\154\10"+
            "\41\uffff\u016b\10\22\uffff\100\10\2\uffff\66\10\50\uffff\15"+
            "\10\3\uffff\20\10\20\uffff\4\10\17\uffff\2\10\30\uffff\3\10"+
            "\31\uffff\1\10\6\uffff\5\10\1\uffff\u0087\10\2\uffff\1\10\4"+
            "\uffff\1\10\13\uffff\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff"+
            "\32\10\12\uffff\132\10\3\uffff\6\10\2\uffff\6\10\2\uffff\6\10"+
            "\2\uffff\3\10\3\uffff\2\10\3\uffff\2\10\22\uffff\3\10",
            "\1\20",
            "",
            "\1\21",
            "\11\10\5\uffff\16\10\10\uffff\1\10\13\uffff\12\10\7\uffff"+
            "\32\10\4\uffff\1\10\1\uffff\32\10\4\uffff\41\10\2\uffff\4\10"+
            "\4\uffff\1\10\2\uffff\1\10\7\uffff\1\10\4\uffff\1\10\5\uffff"+
            "\27\10\1\uffff\37\10\1\uffff\u013f\10\31\uffff\162\10\4\uffff"+
            "\14\10\16\uffff\5\10\11\uffff\1\10\21\uffff\130\10\5\uffff\23"+
            "\10\12\uffff\1\10\13\uffff\1\10\1\uffff\3\10\1\uffff\1\10\1"+
            "\uffff\24\10\1\uffff\54\10\1\uffff\46\10\1\uffff\5\10\4\uffff"+
            "\u0082\10\1\uffff\4\10\3\uffff\105\10\1\uffff\46\10\2\uffff"+
            "\2\10\6\uffff\20\10\41\uffff\46\10\2\uffff\1\10\7\uffff\47\10"+
            "\11\uffff\21\10\1\uffff\27\10\1\uffff\3\10\1\uffff\1\10\1\uffff"+
            "\2\10\1\uffff\1\10\13\uffff\33\10\5\uffff\3\10\15\uffff\4\10"+
            "\14\uffff\6\10\13\uffff\32\10\5\uffff\31\10\7\uffff\12\10\4"+
            "\uffff\146\10\1\uffff\11\10\1\uffff\12\10\1\uffff\23\10\2\uffff"+
            "\1\10\17\uffff\74\10\2\uffff\3\10\60\uffff\62\10\u014f\uffff"+
            "\71\10\2\uffff\22\10\2\uffff\5\10\3\uffff\14\10\2\uffff\12\10"+
            "\21\uffff\3\10\1\uffff\10\10\2\uffff\2\10\2\uffff\26\10\1\uffff"+
            "\7\10\1\uffff\1\10\3\uffff\4\10\2\uffff\11\10\2\uffff\2\10\2"+
            "\uffff\3\10\11\uffff\1\10\4\uffff\2\10\1\uffff\5\10\2\uffff"+
            "\16\10\15\uffff\3\10\1\uffff\6\10\4\uffff\2\10\2\uffff\26\10"+
            "\1\uffff\7\10\1\uffff\2\10\1\uffff\2\10\1\uffff\2\10\2\uffff"+
            "\1\10\1\uffff\5\10\4\uffff\2\10\2\uffff\3\10\13\uffff\4\10\1"+
            "\uffff\1\10\7\uffff\17\10\14\uffff\3\10\1\uffff\11\10\1\uffff"+
            "\3\10\1\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff\5\10\2"+
            "\uffff\12\10\1\uffff\3\10\1\uffff\3\10\2\uffff\1\10\17\uffff"+
            "\4\10\2\uffff\12\10\1\uffff\1\10\17\uffff\3\10\1\uffff\10\10"+
            "\2\uffff\2\10\2\uffff\26\10\1\uffff\7\10\1\uffff\2\10\1\uffff"+
            "\5\10\2\uffff\10\10\3\uffff\2\10\2\uffff\3\10\10\uffff\2\10"+
            "\4\uffff\2\10\1\uffff\3\10\4\uffff\12\10\1\uffff\1\10\20\uffff"+
            "\2\10\1\uffff\6\10\3\uffff\3\10\1\uffff\4\10\3\uffff\2\10\1"+
            "\uffff\1\10\1\uffff\2\10\3\uffff\2\10\3\uffff\3\10\3\uffff\10"+
            "\10\1\uffff\3\10\4\uffff\5\10\3\uffff\3\10\1\uffff\4\10\11\uffff"+
            "\1\10\17\uffff\11\10\11\uffff\1\10\7\uffff\3\10\1\uffff\10\10"+
            "\1\uffff\3\10\1\uffff\27\10\1\uffff\12\10\1\uffff\5\10\4\uffff"+
            "\7\10\1\uffff\3\10\1\uffff\4\10\7\uffff\2\10\11\uffff\2\10\4"+
            "\uffff\12\10\22\uffff\2\10\1\uffff\10\10\1\uffff\3\10\1\uffff"+
            "\27\10\1\uffff\12\10\1\uffff\5\10\2\uffff\11\10\1\uffff\3\10"+
            "\1\uffff\4\10\7\uffff\2\10\7\uffff\1\10\1\uffff\2\10\4\uffff"+
            "\12\10\22\uffff\2\10\1\uffff\10\10\1\uffff\3\10\1\uffff\27\10"+
            "\1\uffff\20\10\4\uffff\6\10\2\uffff\3\10\1\uffff\4\10\11\uffff"+
            "\1\10\10\uffff\2\10\4\uffff\12\10\22\uffff\2\10\1\uffff\22\10"+
            "\3\uffff\30\10\1\uffff\11\10\1\uffff\1\10\2\uffff\7\10\3\uffff"+
            "\1\10\4\uffff\6\10\1\uffff\1\10\1\uffff\10\10\22\uffff\2\10"+
            "\15\uffff\72\10\4\uffff\20\10\1\uffff\12\10\47\uffff\2\10\1"+
            "\uffff\1\10\2\uffff\2\10\1\uffff\1\10\2\uffff\1\10\6\uffff\4"+
            "\10\1\uffff\7\10\1\uffff\3\10\1\uffff\1\10\1\uffff\1\10\2\uffff"+
            "\2\10\1\uffff\15\10\1\uffff\3\10\2\uffff\5\10\1\uffff\1\10\1"+
            "\uffff\6\10\2\uffff\12\10\2\uffff\2\10\42\uffff\1\10\27\uffff"+
            "\2\10\6\uffff\12\10\13\uffff\1\10\1\uffff\1\10\1\uffff\1\10"+
            "\4\uffff\12\10\1\uffff\42\10\6\uffff\24\10\1\uffff\6\10\4\uffff"+
            "\10\10\1\uffff\44\10\11\uffff\1\10\71\uffff\42\10\1\uffff\5"+
            "\10\1\uffff\2\10\1\uffff\7\10\3\uffff\4\10\6\uffff\12\10\6\uffff"+
            "\12\10\106\uffff\46\10\12\uffff\51\10\7\uffff\132\10\5\uffff"+
            "\104\10\5\uffff\122\10\6\uffff\7\10\1\uffff\77\10\1\uffff\1"+
            "\10\1\uffff\4\10\2\uffff\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\47\10\1\uffff\1\10\1\uffff\4\10\2\uffff\37\10\1\uffff\1\10"+
            "\1\uffff\4\10\2\uffff\7\10\1\uffff\1\10\1\uffff\4\10\2\uffff"+
            "\7\10\1\uffff\7\10\1\uffff\27\10\1\uffff\37\10\1\uffff\1\10"+
            "\1\uffff\4\10\2\uffff\7\10\1\uffff\47\10\1\uffff\23\10\16\uffff"+
            "\11\10\56\uffff\125\10\14\uffff\u026c\10\2\uffff\10\10\12\uffff"+
            "\32\10\5\uffff\113\10\3\uffff\3\10\17\uffff\15\10\1\uffff\7"+
            "\10\13\uffff\25\10\13\uffff\24\10\14\uffff\15\10\1\uffff\3\10"+
            "\1\uffff\2\10\14\uffff\124\10\3\uffff\1\10\3\uffff\3\10\2\uffff"+
            "\12\10\41\uffff\3\10\2\uffff\12\10\6\uffff\130\10\10\uffff\52"+
            "\10\126\uffff\35\10\3\uffff\14\10\4\uffff\14\10\12\uffff\50"+
            "\10\2\uffff\5\10\u038b\uffff\154\10\u0094\uffff\u009c\10\4\uffff"+
            "\132\10\6\uffff\26\10\2\uffff\6\10\2\uffff\46\10\2\uffff\6\10"+
            "\2\uffff\10\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff"+
            "\37\10\2\uffff\65\10\1\uffff\7\10\1\uffff\1\10\3\uffff\3\10"+
            "\1\uffff\7\10\3\uffff\4\10\2\uffff\6\10\4\uffff\15\10\5\uffff"+
            "\3\10\1\uffff\7\10\17\uffff\4\10\32\uffff\5\10\20\uffff\2\10"+
            "\23\uffff\1\10\13\uffff\4\10\6\uffff\6\10\1\uffff\1\10\15\uffff"+
            "\1\10\40\uffff\22\10\36\uffff\15\10\4\uffff\1\10\3\uffff\6\10"+
            "\27\uffff\1\10\4\uffff\1\10\2\uffff\12\10\1\uffff\1\10\3\uffff"+
            "\5\10\6\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff\4\10\1"+
            "\uffff\3\10\1\uffff\7\10\3\uffff\3\10\5\uffff\5\10\26\uffff"+
            "\44\10\u0e81\uffff\3\10\31\uffff\17\10\1\uffff\5\10\2\uffff"+
            "\5\10\4\uffff\126\10\2\uffff\2\10\2\uffff\3\10\1\uffff\137\10"+
            "\5\uffff\50\10\4\uffff\136\10\21\uffff\30\10\70\uffff\20\10"+
            "\u0200\uffff\u19b6\10\112\uffff\u51a6\10\132\uffff\u048d\10"+
            "\u0773\uffff\u2ba4\10\u215c\uffff\u012e\10\2\uffff\73\10\u0095"+
            "\uffff\7\10\14\uffff\5\10\5\uffff\14\10\1\uffff\15\10\1\uffff"+
            "\5\10\1\uffff\1\10\1\uffff\2\10\1\uffff\2\10\1\uffff\154\10"+
            "\41\uffff\u016b\10\22\uffff\100\10\2\uffff\66\10\50\uffff\15"+
            "\10\3\uffff\20\10\20\uffff\4\10\17\uffff\2\10\30\uffff\3\10"+
            "\31\uffff\1\10\6\uffff\5\10\1\uffff\u0087\10\2\uffff\1\10\4"+
            "\uffff\1\10\13\uffff\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff"+
            "\32\10\12\uffff\132\10\3\uffff\6\10\2\uffff\6\10\2\uffff\6\10"+
            "\2\uffff\3\10\3\uffff\2\10\3\uffff\2\10\22\uffff\3\10",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | DEF_IRI_REF | DEF_INTEGER | WHITESPACE | LINEBREAKS | IDENTIFIER );";
        }
    }
 

}