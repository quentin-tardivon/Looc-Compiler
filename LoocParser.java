// $ANTLR 3.3 Nov 30, 2010 12:50:56 Looc.g 2017-01-23 17:03:04

  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LoocParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDF", "WS", "'var'", "':'", "'int'", "'string'"
    };
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int IDF=4;
    public static final int WS=5;

    // delegates
    // delegators


        public LoocParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LoocParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return LoocParser.tokenNames; }
    public String getGrammarFileName() { return "Looc.g"; }


      HashMap<String, Integer> memory = new HashMap<String, Integer>();



    // $ANTLR start "program"
    // Looc.g:11:1: program : ( var_decl )* ;
    public final void program() throws RecognitionException {
        try {
            // Looc.g:11:8: ( ( var_decl )* )
            // Looc.g:11:10: ( var_decl )*
            {
            // Looc.g:11:10: ( var_decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==6) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Looc.g:11:10: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_program21);
            	    var_decl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "var_decl"
    // Looc.g:15:1: var_decl : 'var' IDF ':' type ;
    public final void var_decl() throws RecognitionException {
        try {
            // Looc.g:15:9: ( 'var' IDF ':' type )
            // Looc.g:15:11: 'var' IDF ':' type
            {
            match(input,6,FOLLOW_6_in_var_decl32); 
            match(input,IDF,FOLLOW_IDF_in_var_decl34); 
            match(input,7,FOLLOW_7_in_var_decl36); 
            pushFollow(FOLLOW_type_in_var_decl38);
            type();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "var_decl"


    // $ANTLR start "type"
    // Looc.g:17:1: type : ( 'int' | 'string' );
    public final void type() throws RecognitionException {
        try {
            // Looc.g:17:5: ( 'int' | 'string' )
            // Looc.g:
            {
            if ( (input.LA(1)>=8 && input.LA(1)<=9) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_var_decl_in_program21 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_6_in_var_decl32 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDF_in_var_decl34 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_var_decl36 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_type_in_var_decl38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});

}