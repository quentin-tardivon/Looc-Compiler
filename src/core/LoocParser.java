// $ANTLR 3.3 Nov 30, 2010 12:50:56 Looc.g 2017-05-20 13:49:54

package core;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class LoocParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASS_DEC", "VAR_DEC", "ROOT", "FORMAL_PARAM", "FORMAL_PARAMS", "EFFECTIVE_PARAMS", "BODY", "METHOD", "FOR", "IF", "EGAL", "DO", "PLUS", "DIFF", "THEN", "ELSE", "PRINT", "AFFECT", "MUL", "DIV", "NEG", "RETURN", "WRITE", "READ", "ACCESS", "THIS", "CALL", "SUPER", "BLOCK", "VARS", "METHODS", "ATTRIBUTES", "CLASS", "IDF", "OPER", "INT", "STRING", "WS", "NEWLINE", "COMMENT", "LINE_COMMENT", "'class'", "'inherit'", "'='", "'('", "')'", "'method'", "':'", "'{'", "'}'", "','", "'var'", "';'", "'int'", "'string'", "':='", "'for'", "'in'", "'..'", "'do'", "'end'", "'if'", "'then'", "'else'", "'fi'", "'new'", "'+'", "'-'", "'*'", "'/'", "'this'", "'super'", "'.'", "'write'", "'return'", "'read'"
    };
    public static final int EOF=-1;
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
    public static final int T__79=79;
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
    public static final int ATTRIBUTES=35;
    public static final int CLASS=36;
    public static final int IDF=37;
    public static final int OPER=38;
    public static final int INT=39;
    public static final int STRING=40;
    public static final int WS=41;
    public static final int NEWLINE=42;
    public static final int COMMENT=43;
    public static final int LINE_COMMENT=44;

    // delegates
    // delegators


        public LoocParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LoocParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LoocParser.tokenNames; }
    public String getGrammarFileName() { return "Looc.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // Looc.g:52:1: program : ( class_decl )* ( var_decl )* ( instruction )+ -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ ) ;
    public final LoocParser.program_return program() throws RecognitionException {
        LoocParser.program_return retval = new LoocParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LoocParser.class_decl_return class_decl1 = null;

        LoocParser.var_decl_return var_decl2 = null;

        LoocParser.instruction_return instruction3 = null;


        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        RewriteRuleSubtreeStream stream_class_decl=new RewriteRuleSubtreeStream(adaptor,"rule class_decl");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        try {
            // Looc.g:57:8: ( ( class_decl )* ( var_decl )* ( instruction )+ -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ ) )
            // Looc.g:57:13: ( class_decl )* ( var_decl )* ( instruction )+
            {
            // Looc.g:57:13: ( class_decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==45) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Looc.g:57:13: class_decl
            	    {
            	    pushFollow(FOLLOW_class_decl_in_program185);
            	    class_decl1=class_decl();

            	    state._fsp--;

            	    stream_class_decl.add(class_decl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // Looc.g:57:25: ( var_decl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==55) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Looc.g:57:25: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_program188);
            	    var_decl2=var_decl();

            	    state._fsp--;

            	    stream_var_decl.add(var_decl2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Looc.g:57:35: ( instruction )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDF||LA3_0==52||LA3_0==60||LA3_0==63||LA3_0==65||(LA3_0>=77 && LA3_0<=79)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Looc.g:57:35: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_program191);
            	    instruction3=instruction();

            	    state._fsp--;

            	    stream_instruction.add(instruction3.getTree());

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



            // AST REWRITE
            // elements: class_decl, var_decl, instruction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 57:48: -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ )
            {
                // Looc.g:57:51: ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);

                // Looc.g:57:58: ( class_decl )*
                while ( stream_class_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_class_decl.nextTree());

                }
                stream_class_decl.reset();
                // Looc.g:57:70: ( var_decl )*
                while ( stream_var_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_var_decl.nextTree());

                }
                stream_var_decl.reset();
                if ( !(stream_instruction.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_instruction.hasNext() ) {
                    adaptor.addChild(root_1, stream_instruction.nextTree());

                }
                stream_instruction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class class_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "class_decl"
    // Looc.g:59:1: class_decl : 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')' -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl ) ;
    public final LoocParser.class_decl_return class_decl() throws RecognitionException {
        LoocParser.class_decl_return retval = new LoocParser.class_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal4=null;
        Token CLASS5=null;
        Token string_literal6=null;
        Token CLASS7=null;
        Token char_literal8=null;
        Token char_literal9=null;
        Token char_literal11=null;
        LoocParser.class_item_decl_return class_item_decl10 = null;


        Object string_literal4_tree=null;
        Object CLASS5_tree=null;
        Object string_literal6_tree=null;
        Object CLASS7_tree=null;
        Object char_literal8_tree=null;
        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleSubtreeStream stream_class_item_decl=new RewriteRuleSubtreeStream(adaptor,"rule class_item_decl");
        try {
            // Looc.g:59:11: ( 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')' -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl ) )
            // Looc.g:59:15: 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')'
            {
            string_literal4=(Token)match(input,45,FOLLOW_45_in_class_decl217);  
            stream_45.add(string_literal4);

            CLASS5=(Token)match(input,CLASS,FOLLOW_CLASS_in_class_decl219);  
            stream_CLASS.add(CLASS5);

            // Looc.g:59:29: ( 'inherit' CLASS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==46) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Looc.g:59:30: 'inherit' CLASS
                    {
                    string_literal6=(Token)match(input,46,FOLLOW_46_in_class_decl222);  
                    stream_46.add(string_literal6);

                    CLASS7=(Token)match(input,CLASS,FOLLOW_CLASS_in_class_decl224);  
                    stream_CLASS.add(CLASS7);


                    }
                    break;

            }

            char_literal8=(Token)match(input,47,FOLLOW_47_in_class_decl229);  
            stream_47.add(char_literal8);

            char_literal9=(Token)match(input,48,FOLLOW_48_in_class_decl231);  
            stream_48.add(char_literal9);

            pushFollow(FOLLOW_class_item_decl_in_class_decl232);
            class_item_decl10=class_item_decl();

            state._fsp--;

            stream_class_item_decl.add(class_item_decl10.getTree());
            char_literal11=(Token)match(input,49,FOLLOW_49_in_class_decl233);  
            stream_49.add(char_literal11);



            // AST REWRITE
            // elements: CLASS, CLASS, class_item_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 59:75: -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl )
            {
                // Looc.g:59:78: ^( CLASS_DEC CLASS ( CLASS )? class_item_decl )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLASS_DEC, "CLASS_DEC"), root_1);

                adaptor.addChild(root_1, stream_CLASS.nextNode());
                // Looc.g:59:96: ( CLASS )?
                if ( stream_CLASS.hasNext() ) {
                    adaptor.addChild(root_1, stream_CLASS.nextNode());

                }
                stream_CLASS.reset();
                adaptor.addChild(root_1, stream_class_item_decl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "class_decl"

    public static class class_item_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "class_item_decl"
    // Looc.g:63:1: class_item_decl : ( var_decl )* ( method_decl )* -> ( ^( ATTRIBUTES ( var_decl )* ) )? ( ^( METHODS ( method_decl )* ) )? ;
    public final LoocParser.class_item_decl_return class_item_decl() throws RecognitionException {
        LoocParser.class_item_decl_return retval = new LoocParser.class_item_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LoocParser.var_decl_return var_decl12 = null;

        LoocParser.method_decl_return method_decl13 = null;


        RewriteRuleSubtreeStream stream_method_decl=new RewriteRuleSubtreeStream(adaptor,"rule method_decl");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        try {
            // Looc.g:63:16: ( ( var_decl )* ( method_decl )* -> ( ^( ATTRIBUTES ( var_decl )* ) )? ( ^( METHODS ( method_decl )* ) )? )
            // Looc.g:63:18: ( var_decl )* ( method_decl )*
            {
            // Looc.g:63:18: ( var_decl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==55) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Looc.g:63:18: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_class_item_decl257);
            	    var_decl12=var_decl();

            	    state._fsp--;

            	    stream_var_decl.add(var_decl12.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // Looc.g:63:28: ( method_decl )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==50) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Looc.g:63:28: method_decl
            	    {
            	    pushFollow(FOLLOW_method_decl_in_class_item_decl260);
            	    method_decl13=method_decl();

            	    state._fsp--;

            	    stream_method_decl.add(method_decl13.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);



            // AST REWRITE
            // elements: var_decl, method_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 63:41: -> ( ^( ATTRIBUTES ( var_decl )* ) )? ( ^( METHODS ( method_decl )* ) )?
            {
                // Looc.g:63:44: ( ^( ATTRIBUTES ( var_decl )* ) )?
                if ( stream_var_decl.hasNext() ) {
                    // Looc.g:63:44: ^( ATTRIBUTES ( var_decl )* )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                    // Looc.g:63:57: ( var_decl )*
                    while ( stream_var_decl.hasNext() ) {
                        adaptor.addChild(root_1, stream_var_decl.nextTree());

                    }
                    stream_var_decl.reset();

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_var_decl.reset();
                // Looc.g:63:69: ( ^( METHODS ( method_decl )* ) )?
                if ( stream_method_decl.hasNext() ) {
                    // Looc.g:63:69: ^( METHODS ( method_decl )* )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODS, "METHODS"), root_1);

                    // Looc.g:63:79: ( method_decl )*
                    while ( stream_method_decl.hasNext() ) {
                        adaptor.addChild(root_1, stream_method_decl.nextTree());

                    }
                    stream_method_decl.reset();

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_method_decl.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "class_item_decl"

    public static class method_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_decl"
    // Looc.g:66:1: method_decl : 'method' IDF '(' ( method_args )? ')' function_decl -> ^( METHOD IDF ( method_args )? function_decl ) ;
    public final LoocParser.method_decl_return method_decl() throws RecognitionException {
        LoocParser.method_decl_return retval = new LoocParser.method_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal14=null;
        Token IDF15=null;
        Token char_literal16=null;
        Token char_literal18=null;
        LoocParser.method_args_return method_args17 = null;

        LoocParser.function_decl_return function_decl19 = null;


        Object string_literal14_tree=null;
        Object IDF15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal18_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_function_decl=new RewriteRuleSubtreeStream(adaptor,"rule function_decl");
        RewriteRuleSubtreeStream stream_method_args=new RewriteRuleSubtreeStream(adaptor,"rule method_args");
        try {
            // Looc.g:66:12: ( 'method' IDF '(' ( method_args )? ')' function_decl -> ^( METHOD IDF ( method_args )? function_decl ) )
            // Looc.g:66:16: 'method' IDF '(' ( method_args )? ')' function_decl
            {
            string_literal14=(Token)match(input,50,FOLLOW_50_in_method_decl289);  
            stream_50.add(string_literal14);

            IDF15=(Token)match(input,IDF,FOLLOW_IDF_in_method_decl291);  
            stream_IDF.add(IDF15);

            char_literal16=(Token)match(input,48,FOLLOW_48_in_method_decl293);  
            stream_48.add(char_literal16);

            // Looc.g:66:33: ( method_args )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDF) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Looc.g:66:33: method_args
                    {
                    pushFollow(FOLLOW_method_args_in_method_decl295);
                    method_args17=method_args();

                    state._fsp--;

                    stream_method_args.add(method_args17.getTree());

                    }
                    break;

            }

            char_literal18=(Token)match(input,49,FOLLOW_49_in_method_decl298);  
            stream_49.add(char_literal18);

            pushFollow(FOLLOW_function_decl_in_method_decl300);
            function_decl19=function_decl();

            state._fsp--;

            stream_function_decl.add(function_decl19.getTree());


            // AST REWRITE
            // elements: method_args, function_decl, IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 66:64: -> ^( METHOD IDF ( method_args )? function_decl )
            {
                // Looc.g:66:67: ^( METHOD IDF ( method_args )? function_decl )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHOD, "METHOD"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                // Looc.g:66:80: ( method_args )?
                if ( stream_method_args.hasNext() ) {
                    adaptor.addChild(root_1, stream_method_args.nextTree());

                }
                stream_method_args.reset();
                adaptor.addChild(root_1, stream_function_decl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_decl"

    public static class function_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_decl"
    // Looc.g:68:1: function_decl : ( ':' type '{' ( var_decl )* ( instruction )+ '}' -> type ^( BODY ( var_decl )* ( instruction )+ ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BODY ( var_decl )* ( instruction )+ ) );
    public final LoocParser.function_decl_return function_decl() throws RecognitionException {
        LoocParser.function_decl_return retval = new LoocParser.function_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        Token char_literal22=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token char_literal29=null;
        LoocParser.type_return type21 = null;

        LoocParser.var_decl_return var_decl23 = null;

        LoocParser.instruction_return instruction24 = null;

        LoocParser.var_decl_return var_decl27 = null;

        LoocParser.instruction_return instruction28 = null;


        Object char_literal20_tree=null;
        Object char_literal22_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        Object char_literal29_tree=null;
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:68:14: ( ':' type '{' ( var_decl )* ( instruction )+ '}' -> type ^( BODY ( var_decl )* ( instruction )+ ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BODY ( var_decl )* ( instruction )+ ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==51) ) {
                alt12=1;
            }
            else if ( (LA12_0==52) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // Looc.g:68:18: ':' type '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal20=(Token)match(input,51,FOLLOW_51_in_function_decl322);  
                    stream_51.add(char_literal20);

                    pushFollow(FOLLOW_type_in_function_decl324);
                    type21=type();

                    state._fsp--;

                    stream_type.add(type21.getTree());
                    char_literal22=(Token)match(input,52,FOLLOW_52_in_function_decl325);  
                    stream_52.add(char_literal22);

                    // Looc.g:68:29: ( var_decl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==55) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Looc.g:68:29: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_function_decl326);
                    	    var_decl23=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl23.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    // Looc.g:68:39: ( instruction )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDF||LA9_0==52||LA9_0==60||LA9_0==63||LA9_0==65||(LA9_0>=77 && LA9_0<=79)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Looc.g:68:39: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_function_decl329);
                    	    instruction24=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction24.getTree());

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

                    char_literal25=(Token)match(input,53,FOLLOW_53_in_function_decl331);  
                    stream_53.add(char_literal25);



                    // AST REWRITE
                    // elements: instruction, type, var_decl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 68:55: -> type ^( BODY ( var_decl )* ( instruction )+ )
                    {
                        adaptor.addChild(root_0, stream_type.nextTree());
                        // Looc.g:68:63: ^( BODY ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);

                        // Looc.g:68:70: ( var_decl )*
                        while ( stream_var_decl.hasNext() ) {
                            adaptor.addChild(root_1, stream_var_decl.nextTree());

                        }
                        stream_var_decl.reset();
                        if ( !(stream_instruction.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_instruction.hasNext() ) {
                            adaptor.addChild(root_1, stream_instruction.nextTree());

                        }
                        stream_instruction.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // Looc.g:69:7: '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal26=(Token)match(input,52,FOLLOW_52_in_function_decl353);  
                    stream_52.add(char_literal26);

                    // Looc.g:69:10: ( var_decl )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==55) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Looc.g:69:10: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_function_decl354);
                    	    var_decl27=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // Looc.g:69:20: ( instruction )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==IDF||LA11_0==52||LA11_0==60||LA11_0==63||LA11_0==65||(LA11_0>=77 && LA11_0<=79)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Looc.g:69:20: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_function_decl357);
                    	    instruction28=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction28.getTree());

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

                    char_literal29=(Token)match(input,53,FOLLOW_53_in_function_decl360);  
                    stream_53.add(char_literal29);



                    // AST REWRITE
                    // elements: instruction, var_decl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:37: -> ^( BODY ( var_decl )* ( instruction )+ )
                    {
                        // Looc.g:69:40: ^( BODY ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);

                        // Looc.g:69:47: ( var_decl )*
                        while ( stream_var_decl.hasNext() ) {
                            adaptor.addChild(root_1, stream_var_decl.nextTree());

                        }
                        stream_var_decl.reset();
                        if ( !(stream_instruction.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_instruction.hasNext() ) {
                            adaptor.addChild(root_1, stream_instruction.nextTree());

                        }
                        stream_instruction.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_decl"

    public static class method_args_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_args"
    // Looc.g:73:1: method_args : method_arg ( ',' method_arg )* -> ^( FORMAL_PARAMS method_arg ( method_arg )* ) ;
    public final LoocParser.method_args_return method_args() throws RecognitionException {
        LoocParser.method_args_return retval = new LoocParser.method_args_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal31=null;
        LoocParser.method_arg_return method_arg30 = null;

        LoocParser.method_arg_return method_arg32 = null;


        Object char_literal31_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_method_arg=new RewriteRuleSubtreeStream(adaptor,"rule method_arg");
        try {
            // Looc.g:73:12: ( method_arg ( ',' method_arg )* -> ^( FORMAL_PARAMS method_arg ( method_arg )* ) )
            // Looc.g:73:15: method_arg ( ',' method_arg )*
            {
            pushFollow(FOLLOW_method_arg_in_method_args382);
            method_arg30=method_arg();

            state._fsp--;

            stream_method_arg.add(method_arg30.getTree());
            // Looc.g:73:26: ( ',' method_arg )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==54) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Looc.g:73:27: ',' method_arg
            	    {
            	    char_literal31=(Token)match(input,54,FOLLOW_54_in_method_args385);  
            	    stream_54.add(char_literal31);

            	    pushFollow(FOLLOW_method_arg_in_method_args387);
            	    method_arg32=method_arg();

            	    state._fsp--;

            	    stream_method_arg.add(method_arg32.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);



            // AST REWRITE
            // elements: method_arg, method_arg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 73:44: -> ^( FORMAL_PARAMS method_arg ( method_arg )* )
            {
                // Looc.g:73:47: ^( FORMAL_PARAMS method_arg ( method_arg )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMAL_PARAMS, "FORMAL_PARAMS"), root_1);

                adaptor.addChild(root_1, stream_method_arg.nextTree());
                // Looc.g:73:74: ( method_arg )*
                while ( stream_method_arg.hasNext() ) {
                    adaptor.addChild(root_1, stream_method_arg.nextTree());

                }
                stream_method_arg.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_args"

    public static class method_arg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_arg"
    // Looc.g:75:1: method_arg : IDF ':' type -> ^( FORMAL_PARAM IDF type ) ;
    public final LoocParser.method_arg_return method_arg() throws RecognitionException {
        LoocParser.method_arg_return retval = new LoocParser.method_arg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDF33=null;
        Token char_literal34=null;
        LoocParser.type_return type35 = null;


        Object IDF33_tree=null;
        Object char_literal34_tree=null;
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:75:11: ( IDF ':' type -> ^( FORMAL_PARAM IDF type ) )
            // Looc.g:75:13: IDF ':' type
            {
            IDF33=(Token)match(input,IDF,FOLLOW_IDF_in_method_arg409);  
            stream_IDF.add(IDF33);

            char_literal34=(Token)match(input,51,FOLLOW_51_in_method_arg411);  
            stream_51.add(char_literal34);

            pushFollow(FOLLOW_type_in_method_arg413);
            type35=type();

            state._fsp--;

            stream_type.add(type35.getTree());


            // AST REWRITE
            // elements: type, IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 75:26: -> ^( FORMAL_PARAM IDF type )
            {
                // Looc.g:75:29: ^( FORMAL_PARAM IDF type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMAL_PARAM, "FORMAL_PARAM"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method_arg"

    public static class var_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_decl"
    // Looc.g:77:1: var_decl : 'var' IDF ':' type ';' -> ^( VAR_DEC IDF type ) ;
    public final LoocParser.var_decl_return var_decl() throws RecognitionException {
        LoocParser.var_decl_return retval = new LoocParser.var_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal36=null;
        Token IDF37=null;
        Token char_literal38=null;
        Token char_literal40=null;
        LoocParser.type_return type39 = null;


        Object string_literal36_tree=null;
        Object IDF37_tree=null;
        Object char_literal38_tree=null;
        Object char_literal40_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:77:9: ( 'var' IDF ':' type ';' -> ^( VAR_DEC IDF type ) )
            // Looc.g:77:12: 'var' IDF ':' type ';'
            {
            string_literal36=(Token)match(input,55,FOLLOW_55_in_var_decl431);  
            stream_55.add(string_literal36);

            IDF37=(Token)match(input,IDF,FOLLOW_IDF_in_var_decl433);  
            stream_IDF.add(IDF37);

            char_literal38=(Token)match(input,51,FOLLOW_51_in_var_decl435);  
            stream_51.add(char_literal38);

            pushFollow(FOLLOW_type_in_var_decl437);
            type39=type();

            state._fsp--;

            stream_type.add(type39.getTree());
            char_literal40=(Token)match(input,56,FOLLOW_56_in_var_decl439);  
            stream_56.add(char_literal40);



            // AST REWRITE
            // elements: type, IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 77:35: -> ^( VAR_DEC IDF type )
            {
                // Looc.g:77:38: ^( VAR_DEC IDF type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_DEC, "VAR_DEC"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_decl"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // Looc.g:80:1: type : ( 'int' -> 'int' | 'string' -> 'string' | CLASS -> CLASS );
    public final LoocParser.type_return type() throws RecognitionException {
        LoocParser.type_return retval = new LoocParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal41=null;
        Token string_literal42=null;
        Token CLASS43=null;

        Object string_literal41_tree=null;
        Object string_literal42_tree=null;
        Object CLASS43_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");

        try {
            // Looc.g:80:5: ( 'int' -> 'int' | 'string' -> 'string' | CLASS -> CLASS )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt14=1;
                }
                break;
            case 58:
                {
                alt14=2;
                }
                break;
            case CLASS:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // Looc.g:80:9: 'int'
                    {
                    string_literal41=(Token)match(input,57,FOLLOW_57_in_type459);  
                    stream_57.add(string_literal41);



                    // AST REWRITE
                    // elements: 57
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:15: -> 'int'
                    {
                        adaptor.addChild(root_0, stream_57.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // Looc.g:81:7: 'string'
                    {
                    string_literal42=(Token)match(input,58,FOLLOW_58_in_type471);  
                    stream_58.add(string_literal42);



                    // AST REWRITE
                    // elements: 58
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:16: -> 'string'
                    {
                        adaptor.addChild(root_0, stream_58.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // Looc.g:82:8: CLASS
                    {
                    CLASS43=(Token)match(input,CLASS,FOLLOW_CLASS_in_type484);  
                    stream_CLASS.add(CLASS43);



                    // AST REWRITE
                    // elements: CLASS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:14: -> CLASS
                    {
                        adaptor.addChild(root_0, stream_CLASS.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class instruction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instruction"
    // Looc.g:85:1: instruction : ( IDF ':=' expression ';' -> ^( AFFECT IDF expression ) | 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end' -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) ) | 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi' -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? ) | print | 'do' expression ';' -> ^( DO expression ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BLOCK ( var_decl )* ( instruction )+ ) | return_decl ';' -> ^( RETURN return_decl ) | read ';' -> ^( READ read ) );
    public final LoocParser.instruction_return instruction() throws RecognitionException {
        LoocParser.instruction_return retval = new LoocParser.instruction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDF44=null;
        Token string_literal45=null;
        Token char_literal47=null;
        Token string_literal48=null;
        Token IDF49=null;
        Token string_literal50=null;
        Token string_literal52=null;
        Token string_literal54=null;
        Token string_literal56=null;
        Token string_literal57=null;
        Token string_literal59=null;
        Token string_literal60=null;
        Token string_literal61=null;
        Token string_literal63=null;
        Token char_literal65=null;
        Token char_literal66=null;
        Token char_literal69=null;
        Token char_literal71=null;
        Token char_literal73=null;
        List list_a=null;
        List list_b=null;
        LoocParser.expression_return expression46 = null;

        LoocParser.expression_return expression51 = null;

        LoocParser.expression_return expression53 = null;

        LoocParser.instruction_return instruction55 = null;

        LoocParser.expression_return expression58 = null;

        LoocParser.print_return print62 = null;

        LoocParser.expression_return expression64 = null;

        LoocParser.var_decl_return var_decl67 = null;

        LoocParser.instruction_return instruction68 = null;

        LoocParser.return_decl_return return_decl70 = null;

        LoocParser.read_return read72 = null;

        RuleReturnScope a = null;
        RuleReturnScope b = null;
        Object IDF44_tree=null;
        Object string_literal45_tree=null;
        Object char_literal47_tree=null;
        Object string_literal48_tree=null;
        Object IDF49_tree=null;
        Object string_literal50_tree=null;
        Object string_literal52_tree=null;
        Object string_literal54_tree=null;
        Object string_literal56_tree=null;
        Object string_literal57_tree=null;
        Object string_literal59_tree=null;
        Object string_literal60_tree=null;
        Object string_literal61_tree=null;
        Object string_literal63_tree=null;
        Object char_literal65_tree=null;
        Object char_literal66_tree=null;
        Object char_literal69_tree=null;
        Object char_literal71_tree=null;
        Object char_literal73_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_read=new RewriteRuleSubtreeStream(adaptor,"rule read");
        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        RewriteRuleSubtreeStream stream_return_decl=new RewriteRuleSubtreeStream(adaptor,"rule return_decl");
        try {
            // Looc.g:85:12: ( IDF ':=' expression ';' -> ^( AFFECT IDF expression ) | 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end' -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) ) | 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi' -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? ) | print | 'do' expression ';' -> ^( DO expression ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BLOCK ( var_decl )* ( instruction )+ ) | return_decl ';' -> ^( RETURN return_decl ) | read ';' -> ^( READ read ) )
            int alt21=8;
            switch ( input.LA(1) ) {
            case IDF:
                {
                alt21=1;
                }
                break;
            case 60:
                {
                alt21=2;
                }
                break;
            case 65:
                {
                alt21=3;
                }
                break;
            case 77:
                {
                alt21=4;
                }
                break;
            case 63:
                {
                alt21=5;
                }
                break;
            case 52:
                {
                alt21=6;
                }
                break;
            case 78:
                {
                alt21=7;
                }
                break;
            case 79:
                {
                alt21=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // Looc.g:85:15: IDF ':=' expression ';'
                    {
                    IDF44=(Token)match(input,IDF,FOLLOW_IDF_in_instruction497);  
                    stream_IDF.add(IDF44);

                    string_literal45=(Token)match(input,59,FOLLOW_59_in_instruction499);  
                    stream_59.add(string_literal45);

                    pushFollow(FOLLOW_expression_in_instruction501);
                    expression46=expression();

                    state._fsp--;

                    stream_expression.add(expression46.getTree());
                    char_literal47=(Token)match(input,56,FOLLOW_56_in_instruction503);  
                    stream_56.add(char_literal47);



                    // AST REWRITE
                    // elements: IDF, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:39: -> ^( AFFECT IDF expression )
                    {
                        // Looc.g:85:42: ^( AFFECT IDF expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFFECT, "AFFECT"), root_1);

                        adaptor.addChild(root_1, stream_IDF.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // Looc.g:86:6: 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end'
                    {
                    string_literal48=(Token)match(input,60,FOLLOW_60_in_instruction521);  
                    stream_60.add(string_literal48);

                    IDF49=(Token)match(input,IDF,FOLLOW_IDF_in_instruction523);  
                    stream_IDF.add(IDF49);

                    string_literal50=(Token)match(input,61,FOLLOW_61_in_instruction525);  
                    stream_61.add(string_literal50);

                    pushFollow(FOLLOW_expression_in_instruction527);
                    expression51=expression();

                    state._fsp--;

                    stream_expression.add(expression51.getTree());
                    string_literal52=(Token)match(input,62,FOLLOW_62_in_instruction529);  
                    stream_62.add(string_literal52);

                    pushFollow(FOLLOW_expression_in_instruction531);
                    expression53=expression();

                    state._fsp--;

                    stream_expression.add(expression53.getTree());
                    string_literal54=(Token)match(input,63,FOLLOW_63_in_instruction533);  
                    stream_63.add(string_literal54);

                    // Looc.g:86:53: ( instruction )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDF||LA15_0==52||LA15_0==60||LA15_0==63||LA15_0==65||(LA15_0>=77 && LA15_0<=79)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Looc.g:86:53: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction535);
                    	    instruction55=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction55.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    string_literal56=(Token)match(input,64,FOLLOW_64_in_instruction538);  
                    stream_64.add(string_literal56);



                    // AST REWRITE
                    // elements: expression, instruction, IDF, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 86:72: -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) )
                    {
                        // Looc.g:86:75: ^( FOR IDF expression expression ^( BODY ( instruction )+ ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);

                        adaptor.addChild(root_1, stream_IDF.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        // Looc.g:86:107: ^( BODY ( instruction )+ )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_2);

                        if ( !(stream_instruction.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_instruction.hasNext() ) {
                            adaptor.addChild(root_2, stream_instruction.nextTree());

                        }
                        stream_instruction.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // Looc.g:87:6: 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi'
                    {
                    string_literal57=(Token)match(input,65,FOLLOW_65_in_instruction564);  
                    stream_65.add(string_literal57);

                    pushFollow(FOLLOW_expression_in_instruction566);
                    expression58=expression();

                    state._fsp--;

                    stream_expression.add(expression58.getTree());
                    string_literal59=(Token)match(input,66,FOLLOW_66_in_instruction568);  
                    stream_66.add(string_literal59);

                    // Looc.g:87:30: (a+= instruction )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDF||LA16_0==52||LA16_0==60||LA16_0==63||LA16_0==65||(LA16_0>=77 && LA16_0<=79)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Looc.g:87:30: a+= instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction572);
                    	    a=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(a.getTree());
                    	    if (list_a==null) list_a=new ArrayList();
                    	    list_a.add(a.getTree());


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

                    // Looc.g:87:45: ( 'else' (b+= instruction )+ )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==67) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // Looc.g:87:46: 'else' (b+= instruction )+
                            {
                            string_literal60=(Token)match(input,67,FOLLOW_67_in_instruction576);  
                            stream_67.add(string_literal60);

                            // Looc.g:87:54: (b+= instruction )+
                            int cnt17=0;
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==IDF||LA17_0==52||LA17_0==60||LA17_0==63||LA17_0==65||(LA17_0>=77 && LA17_0<=79)) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // Looc.g:87:54: b+= instruction
                            	    {
                            	    pushFollow(FOLLOW_instruction_in_instruction580);
                            	    b=instruction();

                            	    state._fsp--;

                            	    stream_instruction.add(b.getTree());
                            	    if (list_b==null) list_b=new ArrayList();
                            	    list_b.add(b.getTree());


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt17 >= 1 ) break loop17;
                                        EarlyExitException eee =
                                            new EarlyExitException(17, input);
                                        throw eee;
                                }
                                cnt17++;
                            } while (true);


                            }
                            break;

                    }

                    string_literal61=(Token)match(input,68,FOLLOW_68_in_instruction585);  
                    stream_68.add(string_literal61);



                    // AST REWRITE
                    // elements: expression, a, b
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: a, b
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",list_a);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"token b",list_b);
                    root_0 = (Object)adaptor.nil();
                    // 87:76: -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? )
                    {
                        // Looc.g:87:79: ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        // Looc.g:87:95: ^( THEN ( $a)+ )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN, "THEN"), root_2);

                        if ( !(stream_a.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_a.hasNext() ) {
                            adaptor.addChild(root_2, stream_a.nextTree());

                        }
                        stream_a.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // Looc.g:87:107: ( ^( ELSE ( $b)+ ) )?
                        if ( stream_b.hasNext() ) {
                            // Looc.g:87:108: ^( ELSE ( $b)+ )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE, "ELSE"), root_2);

                            if ( !(stream_b.hasNext()) ) {
                                throw new RewriteEarlyExitException();
                            }
                            while ( stream_b.hasNext() ) {
                                adaptor.addChild(root_2, stream_b.nextTree());

                            }
                            stream_b.reset();

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_b.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // Looc.g:88:6: print
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_print_in_instruction620);
                    print62=print();

                    state._fsp--;

                    adaptor.addChild(root_0, print62.getTree());

                    }
                    break;
                case 5 :
                    // Looc.g:89:11: 'do' expression ';'
                    {
                    string_literal63=(Token)match(input,63,FOLLOW_63_in_instruction632);  
                    stream_63.add(string_literal63);

                    pushFollow(FOLLOW_expression_in_instruction634);
                    expression64=expression();

                    state._fsp--;

                    stream_expression.add(expression64.getTree());
                    char_literal65=(Token)match(input,56,FOLLOW_56_in_instruction636);  
                    stream_56.add(char_literal65);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 89:31: -> ^( DO expression )
                    {
                        // Looc.g:89:34: ^( DO expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DO, "DO"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // Looc.g:90:12: '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal66=(Token)match(input,52,FOLLOW_52_in_instruction657);  
                    stream_52.add(char_literal66);

                    // Looc.g:90:16: ( var_decl )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==55) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // Looc.g:90:16: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_instruction659);
                    	    var_decl67=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl67.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // Looc.g:90:26: ( instruction )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDF||LA20_0==52||LA20_0==60||LA20_0==63||LA20_0==65||(LA20_0>=77 && LA20_0<=79)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Looc.g:90:26: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction662);
                    	    instruction68=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction68.getTree());

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

                    char_literal69=(Token)match(input,53,FOLLOW_53_in_instruction665);  
                    stream_53.add(char_literal69);



                    // AST REWRITE
                    // elements: var_decl, instruction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 90:43: -> ^( BLOCK ( var_decl )* ( instruction )+ )
                    {
                        // Looc.g:90:46: ^( BLOCK ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);

                        // Looc.g:90:54: ( var_decl )*
                        while ( stream_var_decl.hasNext() ) {
                            adaptor.addChild(root_1, stream_var_decl.nextTree());

                        }
                        stream_var_decl.reset();
                        if ( !(stream_instruction.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_instruction.hasNext() ) {
                            adaptor.addChild(root_1, stream_instruction.nextTree());

                        }
                        stream_instruction.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // Looc.g:91:8: return_decl ';'
                    {
                    pushFollow(FOLLOW_return_decl_in_instruction686);
                    return_decl70=return_decl();

                    state._fsp--;

                    stream_return_decl.add(return_decl70.getTree());
                    char_literal71=(Token)match(input,56,FOLLOW_56_in_instruction688);  
                    stream_56.add(char_literal71);



                    // AST REWRITE
                    // elements: return_decl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 91:24: -> ^( RETURN return_decl )
                    {
                        // Looc.g:91:27: ^( RETURN return_decl )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN, "RETURN"), root_1);

                        adaptor.addChild(root_1, stream_return_decl.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 8 :
                    // Looc.g:92:10: read ';'
                    {
                    pushFollow(FOLLOW_read_in_instruction707);
                    read72=read();

                    state._fsp--;

                    stream_read.add(read72.getTree());
                    char_literal73=(Token)match(input,56,FOLLOW_56_in_instruction708);  
                    stream_56.add(char_literal73);



                    // AST REWRITE
                    // elements: read
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 92:18: -> ^( READ read )
                    {
                        // Looc.g:92:21: ^( READ read )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(READ, "READ"), root_1);

                        adaptor.addChild(root_1, stream_read.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instruction"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // Looc.g:94:1: expression : ( operation | 'new' CLASS -> ^( 'new' CLASS ) );
    public final LoocParser.expression_return expression() throws RecognitionException {
        LoocParser.expression_return retval = new LoocParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal75=null;
        Token CLASS76=null;
        LoocParser.operation_return operation74 = null;


        Object string_literal75_tree=null;
        Object CLASS76_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");

        try {
            // Looc.g:94:12: ( operation | 'new' CLASS -> ^( 'new' CLASS ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDF||(LA22_0>=INT && LA22_0<=STRING)||LA22_0==48||LA22_0==71||(LA22_0>=74 && LA22_0<=75)) ) {
                alt22=1;
            }
            else if ( (LA22_0==69) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // Looc.g:94:16: operation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_operation_in_expression726);
                    operation74=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation74.getTree());

                    }
                    break;
                case 2 :
                    // Looc.g:95:5: 'new' CLASS
                    {
                    string_literal75=(Token)match(input,69,FOLLOW_69_in_expression732);  
                    stream_69.add(string_literal75);

                    CLASS76=(Token)match(input,CLASS,FOLLOW_CLASS_in_expression734);  
                    stream_CLASS.add(CLASS76);



                    // AST REWRITE
                    // elements: 69, CLASS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 95:17: -> ^( 'new' CLASS )
                    {
                        // Looc.g:95:20: ^( 'new' CLASS )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_69.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_CLASS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class operation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operation"
    // Looc.g:98:1: operation : ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )* ;
    public final LoocParser.operation_return operation() throws RecognitionException {
        LoocParser.operation_return retval = new LoocParser.operation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal78=null;
        Token char_literal79=null;
        LoocParser.multiop_return mult = null;

        LoocParser.multiop_return multiop77 = null;


        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_multiop=new RewriteRuleSubtreeStream(adaptor,"rule multiop");
        try {
            // Looc.g:98:11: ( ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )* )
            // Looc.g:98:13: ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )*
            {
            // Looc.g:98:13: ( multiop -> multiop )
            // Looc.g:98:14: multiop
            {
            pushFollow(FOLLOW_multiop_in_operation752);
            multiop77=multiop();

            state._fsp--;

            stream_multiop.add(multiop77.getTree());


            // AST REWRITE
            // elements: multiop
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 98:22: -> multiop
            {
                adaptor.addChild(root_0, stream_multiop.nextTree());

            }

            retval.tree = root_0;
            }

            // Looc.g:98:34: ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==70) ) {
                    alt23=1;
                }
                else if ( (LA23_0==71) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // Looc.g:98:35: '+' mult= multiop
            	    {
            	    char_literal78=(Token)match(input,70,FOLLOW_70_in_operation760);  
            	    stream_70.add(char_literal78);

            	    pushFollow(FOLLOW_multiop_in_operation764);
            	    mult=multiop();

            	    state._fsp--;

            	    stream_multiop.add(mult.getTree());


            	    // AST REWRITE
            	    // elements: operation, mult
            	    // token labels: 
            	    // rule labels: mult, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_mult=new RewriteRuleSubtreeStream(adaptor,"rule mult",mult!=null?mult.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 98:52: -> ^( PLUS $operation $mult)
            	    {
            	        // Looc.g:98:55: ^( PLUS $operation $mult)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS, "PLUS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_mult.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // Looc.g:99:4: '-' mult= multiop
            	    {
            	    char_literal79=(Token)match(input,71,FOLLOW_71_in_operation781);  
            	    stream_71.add(char_literal79);

            	    pushFollow(FOLLOW_multiop_in_operation785);
            	    mult=multiop();

            	    state._fsp--;

            	    stream_multiop.add(mult.getTree());


            	    // AST REWRITE
            	    // elements: operation, mult
            	    // token labels: 
            	    // rule labels: mult, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_mult=new RewriteRuleSubtreeStream(adaptor,"rule mult",mult!=null?mult.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 99:21: -> ^( DIFF $operation $mult)
            	    {
            	        // Looc.g:99:24: ^( DIFF $operation $mult)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIFF, "DIFF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_mult.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operation"

    public static class multiop_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiop"
    // Looc.g:101:1: multiop : ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )* ;
    public final LoocParser.multiop_return multiop() throws RecognitionException {
        LoocParser.multiop_return retval = new LoocParser.multiop_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal81=null;
        Token char_literal82=null;
        LoocParser.comparaison_return cmp = null;

        LoocParser.comparaison_return comparaison80 = null;


        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_comparaison=new RewriteRuleSubtreeStream(adaptor,"rule comparaison");
        try {
            // Looc.g:101:9: ( ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )* )
            // Looc.g:101:11: ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )*
            {
            // Looc.g:101:11: ( comparaison -> comparaison )
            // Looc.g:101:12: comparaison
            {
            pushFollow(FOLLOW_comparaison_in_multiop808);
            comparaison80=comparaison();

            state._fsp--;

            stream_comparaison.add(comparaison80.getTree());


            // AST REWRITE
            // elements: comparaison
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 101:24: -> comparaison
            {
                adaptor.addChild(root_0, stream_comparaison.nextTree());

            }

            retval.tree = root_0;
            }

            // Looc.g:101:40: ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==72) ) {
                    alt24=1;
                }
                else if ( (LA24_0==73) ) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // Looc.g:101:41: '*' cmp= comparaison
            	    {
            	    char_literal81=(Token)match(input,72,FOLLOW_72_in_multiop816);  
            	    stream_72.add(char_literal81);

            	    pushFollow(FOLLOW_comparaison_in_multiop820);
            	    cmp=comparaison();

            	    state._fsp--;

            	    stream_comparaison.add(cmp.getTree());


            	    // AST REWRITE
            	    // elements: multiop, cmp
            	    // token labels: 
            	    // rule labels: cmp, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_cmp=new RewriteRuleSubtreeStream(adaptor,"rule cmp",cmp!=null?cmp.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 101:61: -> ^( MUL $multiop $cmp)
            	    {
            	        // Looc.g:101:64: ^( MUL $multiop $cmp)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MUL, "MUL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_cmp.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // Looc.g:102:4: '/' cmp= comparaison
            	    {
            	    char_literal82=(Token)match(input,73,FOLLOW_73_in_multiop837);  
            	    stream_73.add(char_literal82);

            	    pushFollow(FOLLOW_comparaison_in_multiop841);
            	    cmp=comparaison();

            	    state._fsp--;

            	    stream_comparaison.add(cmp.getTree());


            	    // AST REWRITE
            	    // elements: multiop, cmp
            	    // token labels: 
            	    // rule labels: cmp, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_cmp=new RewriteRuleSubtreeStream(adaptor,"rule cmp",cmp!=null?cmp.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 102:24: -> ^( DIV $multiop $cmp)
            	    {
            	        // Looc.g:102:27: ^( DIV $multiop $cmp)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIV, "DIV"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_cmp.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiop"

    public static class comparaison_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparaison"
    // Looc.g:104:1: comparaison : moinsunaire ( OPER moinsunaire )? ;
    public final LoocParser.comparaison_return comparaison() throws RecognitionException {
        LoocParser.comparaison_return retval = new LoocParser.comparaison_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPER84=null;
        LoocParser.moinsunaire_return moinsunaire83 = null;

        LoocParser.moinsunaire_return moinsunaire85 = null;


        Object OPER84_tree=null;

        try {
            // Looc.g:105:2: ( moinsunaire ( OPER moinsunaire )? )
            // Looc.g:105:4: moinsunaire ( OPER moinsunaire )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_moinsunaire_in_comparaison864);
            moinsunaire83=moinsunaire();

            state._fsp--;

            adaptor.addChild(root_0, moinsunaire83.getTree());
            // Looc.g:105:16: ( OPER moinsunaire )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==OPER) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Looc.g:105:17: OPER moinsunaire
                    {
                    OPER84=(Token)match(input,OPER,FOLLOW_OPER_in_comparaison867); 
                    OPER84_tree = (Object)adaptor.create(OPER84);
                    root_0 = (Object)adaptor.becomeRoot(OPER84_tree, root_0);

                    pushFollow(FOLLOW_moinsunaire_in_comparaison870);
                    moinsunaire85=moinsunaire();

                    state._fsp--;

                    adaptor.addChild(root_0, moinsunaire85.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparaison"

    public static class moinsunaire_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moinsunaire"
    // Looc.g:107:1: moinsunaire : ( '-' )? atom ;
    public final LoocParser.moinsunaire_return moinsunaire() throws RecognitionException {
        LoocParser.moinsunaire_return retval = new LoocParser.moinsunaire_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal86=null;
        LoocParser.atom_return atom87 = null;


        Object char_literal86_tree=null;

        try {
            // Looc.g:108:2: ( ( '-' )? atom )
            // Looc.g:108:4: ( '-' )? atom
            {
            root_0 = (Object)adaptor.nil();

            // Looc.g:108:4: ( '-' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==71) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Looc.g:108:5: '-'
                    {
                    char_literal86=(Token)match(input,71,FOLLOW_71_in_moinsunaire882); 
                    char_literal86_tree = (Object)adaptor.create(char_literal86);
                    root_0 = (Object)adaptor.becomeRoot(char_literal86_tree, root_0);


                    }
                    break;

            }

            pushFollow(FOLLOW_atom_in_moinsunaire887);
            atom87=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom87.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moinsunaire"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // Looc.g:110:1: atom : ( INT | STRING | IDF ( call )? | 'this' ( call )? | 'super' ( call )? | '(' expression ')' -> expression );
    public final LoocParser.atom_return atom() throws RecognitionException {
        LoocParser.atom_return retval = new LoocParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT88=null;
        Token STRING89=null;
        Token IDF90=null;
        Token string_literal92=null;
        Token string_literal94=null;
        Token char_literal96=null;
        Token char_literal98=null;
        LoocParser.call_return call91 = null;

        LoocParser.call_return call93 = null;

        LoocParser.call_return call95 = null;

        LoocParser.expression_return expression97 = null;


        Object INT88_tree=null;
        Object STRING89_tree=null;
        Object IDF90_tree=null;
        Object string_literal92_tree=null;
        Object string_literal94_tree=null;
        Object char_literal96_tree=null;
        Object char_literal98_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:110:5: ( INT | STRING | IDF ( call )? | 'this' ( call )? | 'super' ( call )? | '(' expression ')' -> expression )
            int alt30=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt30=1;
                }
                break;
            case STRING:
                {
                alt30=2;
                }
                break;
            case IDF:
                {
                alt30=3;
                }
                break;
            case 74:
                {
                alt30=4;
                }
                break;
            case 75:
                {
                alt30=5;
                }
                break;
            case 48:
                {
                alt30=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // Looc.g:110:7: INT
                    {
                    root_0 = (Object)adaptor.nil();

                    INT88=(Token)match(input,INT,FOLLOW_INT_in_atom894); 
                    INT88_tree = (Object)adaptor.create(INT88);
                    adaptor.addChild(root_0, INT88_tree);


                    }
                    break;
                case 2 :
                    // Looc.g:111:4: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING89=(Token)match(input,STRING,FOLLOW_STRING_in_atom899); 
                    STRING89_tree = (Object)adaptor.create(STRING89);
                    adaptor.addChild(root_0, STRING89_tree);


                    }
                    break;
                case 3 :
                    // Looc.g:112:4: IDF ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    IDF90=(Token)match(input,IDF,FOLLOW_IDF_in_atom904); 
                    IDF90_tree = (Object)adaptor.create(IDF90);
                    root_0 = (Object)adaptor.becomeRoot(IDF90_tree, root_0);

                    // Looc.g:112:9: ( call )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==76) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // Looc.g:112:10: call
                            {
                            pushFollow(FOLLOW_call_in_atom908);
                            call91=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call91.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // Looc.g:113:4: 'this' ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,74,FOLLOW_74_in_atom916); 
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    root_0 = (Object)adaptor.becomeRoot(string_literal92_tree, root_0);

                    // Looc.g:113:12: ( call )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==76) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Looc.g:113:13: call
                            {
                            pushFollow(FOLLOW_call_in_atom920);
                            call93=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call93.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // Looc.g:114:4: 'super' ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal94=(Token)match(input,75,FOLLOW_75_in_atom928); 
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    root_0 = (Object)adaptor.becomeRoot(string_literal94_tree, root_0);

                    // Looc.g:114:13: ( call )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==76) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // Looc.g:114:14: call
                            {
                            pushFollow(FOLLOW_call_in_atom932);
                            call95=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call95.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // Looc.g:115:4: '(' expression ')'
                    {
                    char_literal96=(Token)match(input,48,FOLLOW_48_in_atom940);  
                    stream_48.add(char_literal96);

                    pushFollow(FOLLOW_expression_in_atom942);
                    expression97=expression();

                    state._fsp--;

                    stream_expression.add(expression97.getTree());
                    char_literal98=(Token)match(input,49,FOLLOW_49_in_atom944);  
                    stream_49.add(char_literal98);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 115:23: -> expression
                    {
                        adaptor.addChild(root_0, stream_expression.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class call_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call"
    // Looc.g:118:1: call : '.' IDF '(' ( expression ( ',' expression )* )? ')' -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? ) ;
    public final LoocParser.call_return call() throws RecognitionException {
        LoocParser.call_return retval = new LoocParser.call_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal99=null;
        Token IDF100=null;
        Token char_literal101=null;
        Token char_literal103=null;
        Token char_literal105=null;
        LoocParser.expression_return expression102 = null;

        LoocParser.expression_return expression104 = null;


        Object char_literal99_tree=null;
        Object IDF100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        Object char_literal105_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:118:6: ( '.' IDF '(' ( expression ( ',' expression )* )? ')' -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? ) )
            // Looc.g:118:8: '.' IDF '(' ( expression ( ',' expression )* )? ')'
            {
            char_literal99=(Token)match(input,76,FOLLOW_76_in_call957);  
            stream_76.add(char_literal99);

            IDF100=(Token)match(input,IDF,FOLLOW_IDF_in_call959);  
            stream_IDF.add(IDF100);

            char_literal101=(Token)match(input,48,FOLLOW_48_in_call961);  
            stream_48.add(char_literal101);

            // Looc.g:118:19: ( expression ( ',' expression )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDF||(LA32_0>=INT && LA32_0<=STRING)||LA32_0==48||LA32_0==69||LA32_0==71||(LA32_0>=74 && LA32_0<=75)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Looc.g:118:20: expression ( ',' expression )*
                    {
                    pushFollow(FOLLOW_expression_in_call963);
                    expression102=expression();

                    state._fsp--;

                    stream_expression.add(expression102.getTree());
                    // Looc.g:118:30: ( ',' expression )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==54) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // Looc.g:118:31: ',' expression
                    	    {
                    	    char_literal103=(Token)match(input,54,FOLLOW_54_in_call965);  
                    	    stream_54.add(char_literal103);

                    	    pushFollow(FOLLOW_expression_in_call966);
                    	    expression104=expression();

                    	    state._fsp--;

                    	    stream_expression.add(expression104.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal105=(Token)match(input,49,FOLLOW_49_in_call971);  
            stream_49.add(char_literal105);



            // AST REWRITE
            // elements: expression, IDF, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 118:52: -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? )
            {
                // Looc.g:118:55: ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                // Looc.g:118:66: ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )?
                if ( stream_expression.hasNext() ) {
                    // Looc.g:118:67: ^( EFFECTIVE_PARAMS ( expression ( expression )* )? )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECTIVE_PARAMS, "EFFECTIVE_PARAMS"), root_2);

                    // Looc.g:118:86: ( expression ( expression )* )?
                    if ( stream_expression.hasNext()||stream_expression.hasNext() ) {
                        adaptor.addChild(root_2, stream_expression.nextTree());
                        // Looc.g:118:97: ( expression )*
                        while ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_2, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                    }
                    stream_expression.reset();
                    stream_expression.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call"

    public static class print_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "print"
    // Looc.g:120:1: print : 'write' expression ';' -> ^( WRITE expression ) ;
    public final LoocParser.print_return print() throws RecognitionException {
        LoocParser.print_return retval = new LoocParser.print_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal106=null;
        Token char_literal108=null;
        LoocParser.expression_return expression107 = null;


        Object string_literal106_tree=null;
        Object char_literal108_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:120:6: ( 'write' expression ';' -> ^( WRITE expression ) )
            // Looc.g:120:9: 'write' expression ';'
            {
            string_literal106=(Token)match(input,77,FOLLOW_77_in_print1003);  
            stream_77.add(string_literal106);

            pushFollow(FOLLOW_expression_in_print1005);
            expression107=expression();

            state._fsp--;

            stream_expression.add(expression107.getTree());
            char_literal108=(Token)match(input,56,FOLLOW_56_in_print1007);  
            stream_56.add(char_literal108);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 120:32: -> ^( WRITE expression )
            {
                // Looc.g:120:35: ^( WRITE expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WRITE, "WRITE"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "print"

    public static class return_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "return_decl"
    // Looc.g:122:1: return_decl : 'return' '(' expression ')' -> expression ;
    public final LoocParser.return_decl_return return_decl() throws RecognitionException {
        LoocParser.return_decl_return retval = new LoocParser.return_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal109=null;
        Token char_literal110=null;
        Token char_literal112=null;
        LoocParser.expression_return expression111 = null;


        Object string_literal109_tree=null;
        Object char_literal110_tree=null;
        Object char_literal112_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:122:12: ( 'return' '(' expression ')' -> expression )
            // Looc.g:122:15: 'return' '(' expression ')'
            {
            string_literal109=(Token)match(input,78,FOLLOW_78_in_return_decl1023);  
            stream_78.add(string_literal109);

            char_literal110=(Token)match(input,48,FOLLOW_48_in_return_decl1024);  
            stream_48.add(char_literal110);

            pushFollow(FOLLOW_expression_in_return_decl1026);
            expression111=expression();

            state._fsp--;

            stream_expression.add(expression111.getTree());
            char_literal112=(Token)match(input,49,FOLLOW_49_in_return_decl1028);  
            stream_49.add(char_literal112);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 122:42: -> expression
            {
                adaptor.addChild(root_0, stream_expression.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_decl"

    public static class read_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "read"
    // Looc.g:124:1: read : 'read' IDF -> IDF ;
    public final LoocParser.read_return read() throws RecognitionException {
        LoocParser.read_return retval = new LoocParser.read_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal113=null;
        Token IDF114=null;

        Object string_literal113_tree=null;
        Object IDF114_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");

        try {
            // Looc.g:124:6: ( 'read' IDF -> IDF )
            // Looc.g:124:8: 'read' IDF
            {
            string_literal113=(Token)match(input,79,FOLLOW_79_in_read1041);  
            stream_79.add(string_literal113);

            IDF114=(Token)match(input,IDF,FOLLOW_IDF_in_read1043);  
            stream_IDF.add(IDF114);



            // AST REWRITE
            // elements: IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 124:19: -> IDF
            {
                adaptor.addChild(root_0, stream_IDF.nextNode());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "read"

    // Delegated rules


 

    public static final BitSet FOLLOW_class_decl_in_program185 = new BitSet(new long[]{0x9090202000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_var_decl_in_program188 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_program191 = new BitSet(new long[]{0x9090002000000002L,0x000000000000E002L});
    public static final BitSet FOLLOW_45_in_class_decl217 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_CLASS_in_class_decl219 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_46_in_class_decl222 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_CLASS_in_class_decl224 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_class_decl229 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_class_decl231 = new BitSet(new long[]{0x0086000000000000L});
    public static final BitSet FOLLOW_class_item_decl_in_class_decl232 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_class_decl233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_in_class_item_decl257 = new BitSet(new long[]{0x0084000000000002L});
    public static final BitSet FOLLOW_method_decl_in_class_item_decl260 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_method_decl289 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_IDF_in_method_decl291 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_method_decl293 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_method_args_in_method_decl295 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_method_decl298 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_function_decl_in_method_decl300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_function_decl322 = new BitSet(new long[]{0x0600001000000000L});
    public static final BitSet FOLLOW_type_in_function_decl324 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_function_decl325 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_var_decl_in_function_decl326 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_function_decl329 = new BitSet(new long[]{0x90B0002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_53_in_function_decl331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_function_decl353 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_var_decl_in_function_decl354 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_function_decl357 = new BitSet(new long[]{0x90B0002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_53_in_function_decl360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_arg_in_method_args382 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_method_args385 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_method_arg_in_method_args387 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_IDF_in_method_arg409 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_method_arg411 = new BitSet(new long[]{0x0600001000000000L});
    public static final BitSet FOLLOW_type_in_method_arg413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_var_decl431 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_IDF_in_var_decl433 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_var_decl435 = new BitSet(new long[]{0x0600001000000000L});
    public static final BitSet FOLLOW_type_in_var_decl437 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_var_decl439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_type459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_type471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_type484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_instruction497 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_instruction499 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_instruction501 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_instruction503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_instruction521 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_IDF_in_instruction523 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_instruction525 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_instruction527 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_instruction529 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_instruction531 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_instruction533 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_instruction535 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E003L});
    public static final BitSet FOLLOW_64_in_instruction538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_instruction564 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_instruction566 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_instruction568 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_instruction572 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E01AL});
    public static final BitSet FOLLOW_67_in_instruction576 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_instruction580 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E012L});
    public static final BitSet FOLLOW_68_in_instruction585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_instruction620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_instruction632 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_instruction634 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_instruction636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_instruction657 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_var_decl_in_instruction659 = new BitSet(new long[]{0x9090002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_instruction_in_instruction662 = new BitSet(new long[]{0x90B0002000000000L,0x000000000000E002L});
    public static final BitSet FOLLOW_53_in_instruction665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_decl_in_instruction686 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_instruction688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_instruction707 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_instruction708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_expression726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_expression732 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_CLASS_in_expression734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiop_in_operation752 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_70_in_operation760 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_multiop_in_operation764 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_71_in_operation781 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_multiop_in_operation785 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_comparaison_in_multiop808 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_72_in_multiop816 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_comparaison_in_multiop820 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_73_in_multiop837 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_comparaison_in_multiop841 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_moinsunaire_in_comparaison864 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_OPER_in_comparaison867 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_moinsunaire_in_comparaison870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_moinsunaire882 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000C80L});
    public static final BitSet FOLLOW_atom_in_moinsunaire887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_atom904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_call_in_atom908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_atom916 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_call_in_atom920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_atom928 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_call_in_atom932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_atom940 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_atom942 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_atom944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_call957 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_IDF_in_call959 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_call961 = new BitSet(new long[]{0x000301A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_call963 = new BitSet(new long[]{0x0042000000000000L});
    public static final BitSet FOLLOW_54_in_call965 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_call966 = new BitSet(new long[]{0x0042000000000000L});
    public static final BitSet FOLLOW_49_in_call971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_print1003 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_print1005 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_print1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_return_decl1023 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_return_decl1024 = new BitSet(new long[]{0x000101A000000000L,0x0000000000000CA0L});
    public static final BitSet FOLLOW_expression_in_return_decl1026 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_return_decl1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_read1041 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_IDF_in_read1043 = new BitSet(new long[]{0x0000000000000002L});

}