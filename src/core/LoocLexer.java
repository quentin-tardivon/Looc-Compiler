// $ANTLR 3.3 Nov 30, 2010 12:50:56 Looc.g 2017-04-02 21:31:33

package core;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LoocLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int CLASS_DEC=4;
    public static final int VAR_DEC=5;
    public static final int ROOT=6;
    public static final int FORMAL_PARAM=7;
    public static final int FORMAL_PARAMS=8;
    public static final int EFFECTIVE_PARAMS=9;
    public static final int BODY=10;
    public static final int METHOD=11;
    public static final int FOR=12;
    public static final int IF=13;
    public static final int EGAL=14;
    public static final int DO=15;
    public static final int PLUS=16;
    public static final int DIFF=17;
    public static final int THEN=18;
    public static final int ELSE=19;
    public static final int PRINT=20;
    public static final int AFFECT=21;
    public static final int MUL=22;
    public static final int DIV=23;
    public static final int NEG=24;
    public static final int RETURN=25;
    public static final int WRITE=26;
    public static final int READ=27;
    public static final int ACCESS=28;
    public static final int THIS=29;
    public static final int CALL=30;
    public static final int SUPER=31;
    public static final int BLOCK=32;
    public static final int VARS=33;
    public static final int METHODS=34;
    public static final int CLASS=35;
    public static final int IDF=36;
    public static final int OPER=37;
    public static final int INT=38;
    public static final int STRING=39;
    public static final int WS=40;
    public static final int NEWLINE=41;
    public static final int COMMENT=42;
    public static final int LINE_COMMENT=43;

    // delegates
    // delegators

    public LoocLexer() {;} 
    public LoocLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LoocLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Looc.g"; }

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:7:7: ( 'class' )
            // Looc.g:7:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:8:7: ( 'inherit' )
            // Looc.g:8:9: 'inherit'
            {
            match("inherit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:9:7: ( '=' )
            // Looc.g:9:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:10:7: ( '(' )
            // Looc.g:10:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:11:7: ( ')' )
            // Looc.g:11:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:12:7: ( 'method' )
            // Looc.g:12:9: 'method'
            {
            match("method"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:13:7: ( ':' )
            // Looc.g:13:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:14:7: ( '{' )
            // Looc.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:15:7: ( '}' )
            // Looc.g:15:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:16:7: ( ',' )
            // Looc.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:17:7: ( 'var' )
            // Looc.g:17:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:18:7: ( ';' )
            // Looc.g:18:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:19:7: ( 'int' )
            // Looc.g:19:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:20:7: ( 'string' )
            // Looc.g:20:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:21:7: ( ':=' )
            // Looc.g:21:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:22:7: ( 'for' )
            // Looc.g:22:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:23:7: ( 'in' )
            // Looc.g:23:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:24:7: ( '..' )
            // Looc.g:24:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:25:7: ( 'do' )
            // Looc.g:25:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:26:7: ( 'end' )
            // Looc.g:26:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:27:7: ( 'if' )
            // Looc.g:27:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:28:7: ( 'then' )
            // Looc.g:28:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:29:7: ( 'else' )
            // Looc.g:29:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:30:7: ( 'fi' )
            // Looc.g:30:9: 'fi'
            {
            match("fi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:31:7: ( 'new' )
            // Looc.g:31:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:32:7: ( '+' )
            // Looc.g:32:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:33:7: ( '-' )
            // Looc.g:33:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:34:7: ( '*' )
            // Looc.g:34:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:35:7: ( '/' )
            // Looc.g:35:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:36:7: ( 'this' )
            // Looc.g:36:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:37:7: ( 'super' )
            // Looc.g:37:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:38:7: ( '.' )
            // Looc.g:38:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:39:7: ( 'write' )
            // Looc.g:39:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:40:7: ( 'return' )
            // Looc.g:40:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:41:7: ( 'read' )
            // Looc.g:41:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "IDF"
    public final void mIDF() throws RecognitionException {
        try {
            int _type = IDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:132:4: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Looc.g:132:7: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // Looc.g:132:7: ( 'a' .. 'z' )
            // Looc.g:132:8: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // Looc.g:132:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Looc.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDF"

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:134:6: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' )* )
            // Looc.g:134:8: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' )*
            {
            // Looc.g:134:8: ( 'A' .. 'Z' )
            // Looc.g:134:9: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            // Looc.g:134:18: ( 'a' .. 'z' | 'A' .. 'Z' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Looc.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:136:4: ( ( '0' .. '9' )+ )
            // Looc.g:136:6: ( '0' .. '9' )+
            {
            // Looc.g:136:6: ( '0' .. '9' )+
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
            	    // Looc.g:136:6: '0' .. '9'
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:138:7: ( '\"' ( . )* '\"' )
            // Looc.g:138:9: '\"' ( . )* '\"'
            {
            match('\"'); 
            // Looc.g:138:12: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\"') ) {
                    alt4=2;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Looc.g:138:13: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "OPER"
    public final void mOPER() throws RecognitionException {
        try {
            int _type = OPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:140:5: ( '<' | '<=' | '>' | '>=' | '==' | '!=' )
            int alt5=6;
            switch ( input.LA(1) ) {
            case '<':
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='=') ) {
                    alt5=2;
                }
                else {
                    alt5=1;}
                }
                break;
            case '>':
                {
                int LA5_2 = input.LA(2);

                if ( (LA5_2=='=') ) {
                    alt5=4;
                }
                else {
                    alt5=3;}
                }
                break;
            case '=':
                {
                alt5=5;
                }
                break;
            case '!':
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Looc.g:140:8: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // Looc.g:140:12: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 3 :
                    // Looc.g:140:17: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 4 :
                    // Looc.g:140:21: '>='
                    {
                    match(">="); 


                    }
                    break;
                case 5 :
                    // Looc.g:140:26: '=='
                    {
                    match("=="); 


                    }
                    break;
                case 6 :
                    // Looc.g:140:31: '!='
                    {
                    match("!="); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:142:3: ( ( ' ' | '\\t' | '\\n' )+ )
            // Looc.g:142:6: ( ' ' | '\\t' | '\\n' )+
            {
            // Looc.g:142:6: ( ' ' | '\\t' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Looc.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:144:8: ( ( '\\r' )? '\\n' )
            // Looc.g:144:10: ( '\\r' )? '\\n'
            {
            // Looc.g:144:10: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Looc.g:144:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:147:2: ( '/*' ( ( . )* ) '*/' )
            // Looc.g:147:4: '/*' ( ( . )* ) '*/'
            {
            match("/*"); 

            // Looc.g:147:9: ( ( . )* )
            // Looc.g:147:10: ( . )*
            {
            // Looc.g:147:10: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Looc.g:147:10: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            match("*/"); 

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:150:2: ( '//' ( ( . )* ) '\\n' )
            // Looc.g:150:4: '//' ( ( . )* ) '\\n'
            {
            match("//"); 

            // Looc.g:150:9: ( ( . )* )
            // Looc.g:150:10: ( . )*
            {
            // Looc.g:150:10: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\n') ) {
                    alt9=2;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Looc.g:150:10: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            match('\n'); 
             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // Looc.g:1:8: ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | IDF | CLASS | INT | STRING | OPER | WS | NEWLINE | COMMENT | LINE_COMMENT )
        int alt10=44;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // Looc.g:1:10: T__44
                {
                mT__44(); 

                }
                break;
            case 2 :
                // Looc.g:1:16: T__45
                {
                mT__45(); 

                }
                break;
            case 3 :
                // Looc.g:1:22: T__46
                {
                mT__46(); 

                }
                break;
            case 4 :
                // Looc.g:1:28: T__47
                {
                mT__47(); 

                }
                break;
            case 5 :
                // Looc.g:1:34: T__48
                {
                mT__48(); 

                }
                break;
            case 6 :
                // Looc.g:1:40: T__49
                {
                mT__49(); 

                }
                break;
            case 7 :
                // Looc.g:1:46: T__50
                {
                mT__50(); 

                }
                break;
            case 8 :
                // Looc.g:1:52: T__51
                {
                mT__51(); 

                }
                break;
            case 9 :
                // Looc.g:1:58: T__52
                {
                mT__52(); 

                }
                break;
            case 10 :
                // Looc.g:1:64: T__53
                {
                mT__53(); 

                }
                break;
            case 11 :
                // Looc.g:1:70: T__54
                {
                mT__54(); 

                }
                break;
            case 12 :
                // Looc.g:1:76: T__55
                {
                mT__55(); 

                }
                break;
            case 13 :
                // Looc.g:1:82: T__56
                {
                mT__56(); 

                }
                break;
            case 14 :
                // Looc.g:1:88: T__57
                {
                mT__57(); 

                }
                break;
            case 15 :
                // Looc.g:1:94: T__58
                {
                mT__58(); 

                }
                break;
            case 16 :
                // Looc.g:1:100: T__59
                {
                mT__59(); 

                }
                break;
            case 17 :
                // Looc.g:1:106: T__60
                {
                mT__60(); 

                }
                break;
            case 18 :
                // Looc.g:1:112: T__61
                {
                mT__61(); 

                }
                break;
            case 19 :
                // Looc.g:1:118: T__62
                {
                mT__62(); 

                }
                break;
            case 20 :
                // Looc.g:1:124: T__63
                {
                mT__63(); 

                }
                break;
            case 21 :
                // Looc.g:1:130: T__64
                {
                mT__64(); 

                }
                break;
            case 22 :
                // Looc.g:1:136: T__65
                {
                mT__65(); 

                }
                break;
            case 23 :
                // Looc.g:1:142: T__66
                {
                mT__66(); 

                }
                break;
            case 24 :
                // Looc.g:1:148: T__67
                {
                mT__67(); 

                }
                break;
            case 25 :
                // Looc.g:1:154: T__68
                {
                mT__68(); 

                }
                break;
            case 26 :
                // Looc.g:1:160: T__69
                {
                mT__69(); 

                }
                break;
            case 27 :
                // Looc.g:1:166: T__70
                {
                mT__70(); 

                }
                break;
            case 28 :
                // Looc.g:1:172: T__71
                {
                mT__71(); 

                }
                break;
            case 29 :
                // Looc.g:1:178: T__72
                {
                mT__72(); 

                }
                break;
            case 30 :
                // Looc.g:1:184: T__73
                {
                mT__73(); 

                }
                break;
            case 31 :
                // Looc.g:1:190: T__74
                {
                mT__74(); 

                }
                break;
            case 32 :
                // Looc.g:1:196: T__75
                {
                mT__75(); 

                }
                break;
            case 33 :
                // Looc.g:1:202: T__76
                {
                mT__76(); 

                }
                break;
            case 34 :
                // Looc.g:1:208: T__77
                {
                mT__77(); 

                }
                break;
            case 35 :
                // Looc.g:1:214: T__78
                {
                mT__78(); 

                }
                break;
            case 36 :
                // Looc.g:1:220: IDF
                {
                mIDF(); 

                }
                break;
            case 37 :
                // Looc.g:1:224: CLASS
                {
                mCLASS(); 

                }
                break;
            case 38 :
                // Looc.g:1:230: INT
                {
                mINT(); 

                }
                break;
            case 39 :
                // Looc.g:1:234: STRING
                {
                mSTRING(); 

                }
                break;
            case 40 :
                // Looc.g:1:241: OPER
                {
                mOPER(); 

                }
                break;
            case 41 :
                // Looc.g:1:246: WS
                {
                mWS(); 

                }
                break;
            case 42 :
                // Looc.g:1:249: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 43 :
                // Looc.g:1:257: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 44 :
                // Looc.g:1:265: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\2\32\1\45\2\uffff\1\32\1\50\3\uffff\1\32\1\uffff\2\32\1"+
        "\57\4\32\3\uffff\1\67\2\32\10\uffff\1\32\1\75\1\76\1\uffff\1\32"+
        "\2\uffff\4\32\1\104\2\uffff\1\105\4\32\3\uffff\4\32\1\120\2\uffff"+
        "\1\32\1\122\2\32\1\125\2\uffff\1\126\3\32\1\132\5\32\1\uffff\1\32"+
        "\1\uffff\2\32\2\uffff\1\143\1\144\1\145\1\uffff\2\32\1\150\1\151"+
        "\3\32\1\155\3\uffff\1\156\1\32\2\uffff\1\32\1\161\1\162\2\uffff"+
        "\1\163\1\164\4\uffff";
    static final String DFA10_eofS =
        "\165\uffff";
    static final String DFA10_minS =
        "\1\11\1\154\1\146\1\75\2\uffff\1\145\1\75\3\uffff\1\141\1\uffff"+
        "\1\164\1\151\1\56\1\157\1\154\1\150\1\145\3\uffff\1\52\1\162\1\145"+
        "\10\uffff\1\141\2\60\1\uffff\1\164\2\uffff\2\162\1\160\1\162\1\60"+
        "\2\uffff\1\60\1\144\1\163\1\145\1\167\3\uffff\1\151\1\141\1\163"+
        "\1\145\1\60\2\uffff\1\150\1\60\1\151\1\145\1\60\2\uffff\1\60\1\145"+
        "\1\156\1\163\1\60\1\164\1\165\1\144\1\163\1\162\1\uffff\1\157\1"+
        "\uffff\1\156\1\162\2\uffff\3\60\1\uffff\1\145\1\162\2\60\1\151\1"+
        "\144\1\147\1\60\3\uffff\1\60\1\156\2\uffff\1\164\2\60\2\uffff\2"+
        "\60\4\uffff";
    static final String DFA10_maxS =
        "\1\175\1\154\1\156\1\75\2\uffff\1\145\1\75\3\uffff\1\141\1\uffff"+
        "\1\165\1\157\1\56\1\157\1\156\1\150\1\145\3\uffff\1\57\1\162\1\145"+
        "\10\uffff\1\141\2\172\1\uffff\1\164\2\uffff\2\162\1\160\1\162\1"+
        "\172\2\uffff\1\172\1\144\1\163\1\151\1\167\3\uffff\1\151\1\164\1"+
        "\163\1\145\1\172\2\uffff\1\150\1\172\1\151\1\145\1\172\2\uffff\1"+
        "\172\1\145\1\156\1\163\1\172\1\164\1\165\1\144\1\163\1\162\1\uffff"+
        "\1\157\1\uffff\1\156\1\162\2\uffff\3\172\1\uffff\1\145\1\162\2\172"+
        "\1\151\1\144\1\147\1\172\3\uffff\1\172\1\156\2\uffff\1\164\2\172"+
        "\2\uffff\2\172\4\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\4\1\5\2\uffff\1\10\1\11\1\12\1\uffff\1\14\7\uffff\1\32"+
        "\1\33\1\34\3\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\51\3\uffff"+
        "\1\3\1\uffff\1\17\1\7\5\uffff\1\22\1\40\5\uffff\1\53\1\54\1\35\5"+
        "\uffff\1\21\1\25\5\uffff\1\30\1\23\12\uffff\1\15\1\uffff\1\13\2"+
        "\uffff\1\20\1\24\3\uffff\1\31\10\uffff\1\27\1\26\1\36\2\uffff\1"+
        "\43\1\1\3\uffff\1\37\1\41\2\uffff\1\6\1\16\1\42\1\2";
    static final String DFA10_specialS =
        "\165\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\41\1\37\2\uffff\1\40\22\uffff\1\41\1\36\1\35\5\uffff\1\4"+
            "\1\5\1\26\1\24\1\12\1\25\1\17\1\27\12\34\1\7\1\14\1\36\1\3\1"+
            "\36\2\uffff\32\33\6\uffff\2\32\1\1\1\20\1\21\1\16\2\32\1\2\3"+
            "\32\1\6\1\23\3\32\1\31\1\15\1\22\1\32\1\13\1\30\3\32\1\10\1"+
            "\uffff\1\11",
            "\1\42",
            "\1\44\7\uffff\1\43",
            "\1\36",
            "",
            "",
            "\1\46",
            "\1\47",
            "",
            "",
            "",
            "\1\51",
            "",
            "\1\52\1\53",
            "\1\55\5\uffff\1\54",
            "\1\56",
            "\1\60",
            "\1\62\1\uffff\1\61",
            "\1\63",
            "\1\64",
            "",
            "",
            "",
            "\1\65\4\uffff\1\66",
            "\1\70",
            "\1\71",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\72",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\7\32\1\73\13\32\1"+
            "\74\6\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\77",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\106",
            "\1\107",
            "\1\110\3\uffff\1\111",
            "\1\112",
            "",
            "",
            "",
            "\1\113",
            "\1\115\22\uffff\1\114",
            "\1\116",
            "\1\117",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\121",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\123",
            "\1\124",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\127",
            "\1\130",
            "\1\131",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "",
            "\1\141",
            "\1\142",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\146",
            "\1\147",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\152",
            "\1\153",
            "\1\154",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\157",
            "",
            "",
            "\1\160",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | IDF | CLASS | INT | STRING | OPER | WS | NEWLINE | COMMENT | LINE_COMMENT );";
        }
    }
 

}