// $ANTLR 3.3 Nov 30, 2010 12:50:56 Looc.g 2017-01-23 17:03:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LoocLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int IDF=4;
    public static final int WS=5;

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

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:3:6: ( 'var' )
            // Looc.g:3:8: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:4:6: ( ':' )
            // Looc.g:4:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:5:6: ( 'int' )
            // Looc.g:5:8: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:6:6: ( 'string' )
            // Looc.g:6:8: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "IDF"
    public final void mIDF() throws RecognitionException {
        try {
            int _type = IDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:20:5: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' )* )
            // Looc.g:20:7: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' )*
            {
            // Looc.g:20:7: ( 'a' .. 'z' )
            // Looc.g:20:8: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // Looc.g:20:17: ( 'a' .. 'z' | 'A' .. 'Z' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Looc.g:23:4: ( ( ' ' | '\\t' | '\\n' )+ )
            // Looc.g:23:6: ( ' ' | '\\t' | '\\n' )+
            {
            // Looc.g:23:6: ( ' ' | '\\t' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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

    public void mTokens() throws RecognitionException {
        // Looc.g:1:8: ( T__6 | T__7 | T__8 | T__9 | IDF | WS )
        int alt3=6;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // Looc.g:1:10: T__6
                {
                mT__6(); 

                }
                break;
            case 2 :
                // Looc.g:1:15: T__7
                {
                mT__7(); 

                }
                break;
            case 3 :
                // Looc.g:1:20: T__8
                {
                mT__8(); 

                }
                break;
            case 4 :
                // Looc.g:1:25: T__9
                {
                mT__9(); 

                }
                break;
            case 5 :
                // Looc.g:1:30: IDF
                {
                mIDF(); 

                }
                break;
            case 6 :
                // Looc.g:1:34: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\1\uffff\1\5\1\uffff\2\5\2\uffff\3\5\1\15\1\16\1\5\2\uffff\2\5\1"+
        "\22\1\uffff";
    static final String DFA3_eofS =
        "\23\uffff";
    static final String DFA3_minS =
        "\1\11\1\141\1\uffff\1\156\1\164\2\uffff\1\162\1\164\1\162\2\101"+
        "\1\151\2\uffff\1\156\1\147\1\101\1\uffff";
    static final String DFA3_maxS =
        "\1\172\1\141\1\uffff\1\156\1\164\2\uffff\1\162\1\164\1\162\2\172"+
        "\1\151\2\uffff\1\156\1\147\1\172\1\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\2\uffff\1\5\1\6\6\uffff\1\1\1\3\3\uffff\1\4";
    static final String DFA3_specialS =
        "\23\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\6\25\uffff\1\6\31\uffff\1\2\46\uffff\10\5\1\3\11\5\1\4\2"+
            "\5\1\1\4\5",
            "\1\7",
            "",
            "\1\10",
            "\1\11",
            "",
            "",
            "\1\12",
            "\1\13",
            "\1\14",
            "\32\5\6\uffff\32\5",
            "\32\5\6\uffff\32\5",
            "\1\17",
            "",
            "",
            "\1\20",
            "\1\21",
            "\32\5\6\uffff\32\5",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__6 | T__7 | T__8 | T__9 | IDF | WS );";
        }
    }
 

}