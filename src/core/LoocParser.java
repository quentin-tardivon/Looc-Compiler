// $ANTLR 3.3 Nov 30, 2010 12:50:56 Looc.g 2017-05-20 14:46:53

package core;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class LoocParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASS_DEC", "VAR_DEC", "ROOT", "FORMAL_PARAM", "FORMAL_PARAMS", "EFFECTIVE_PARAMS", "BODY", "METHOD", "FOR", "IF", "EGAL", "DO", "PLUS", "DIFF", "THEN", "ELSE", "PRINT", "AFFECT", "MUL", "DIV", "NEG", "RETURN", "WRITE", "READ", "ACCESS", "THIS", "CALL", "SUPER", "BLOCK", "VARS", "METHODS", "ATTRIBUTES", "ATTR_DEC", "CLASS", "IDF", "OPER", "INT", "STRING", "WS", "NEWLINE", "COMMENT", "LINE_COMMENT", "'class'", "'inherit'", "'='", "'('", "')'", "'method'", "':'", "'{'", "'}'", "','", "'var'", "';'", "'int'", "'string'", "':='", "'for'", "'in'", "'..'", "'do'", "'end'", "'if'", "'then'", "'else'", "'fi'", "'new'", "'+'", "'-'", "'*'", "'/'", "'this'", "'super'", "'.'", "'write'", "'return'", "'read'"
    };
    public static final int EOF=-1;
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
    public static final int T__80=80;
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
    public static final int ATTR_DEC=36;
    public static final int CLASS=37;
    public static final int IDF=38;
    public static final int OPER=39;
    public static final int INT=40;
    public static final int STRING=41;
    public static final int WS=42;
    public static final int NEWLINE=43;
    public static final int COMMENT=44;
    public static final int LINE_COMMENT=45;

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
    // Looc.g:53:1: program : ( class_decl )* ( var_decl )* ( instruction )+ -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ ) ;
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
            // Looc.g:58:8: ( ( class_decl )* ( var_decl )* ( instruction )+ -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ ) )
            // Looc.g:58:13: ( class_decl )* ( var_decl )* ( instruction )+
            {
            // Looc.g:58:13: ( class_decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Looc.g:58:13: class_decl
            	    {
            	    pushFollow(FOLLOW_class_decl_in_program189);
            	    class_decl1=class_decl();

            	    state._fsp--;

            	    stream_class_decl.add(class_decl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // Looc.g:58:25: ( var_decl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==56) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Looc.g:58:25: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_program192);
            	    var_decl2=var_decl();

            	    state._fsp--;

            	    stream_var_decl.add(var_decl2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Looc.g:58:35: ( instruction )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDF||LA3_0==53||LA3_0==61||LA3_0==64||LA3_0==66||(LA3_0>=78 && LA3_0<=80)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Looc.g:58:35: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_program195);
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
            // 58:48: -> ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ )
            {
                // Looc.g:58:51: ^( ROOT ( class_decl )* ( var_decl )* ( instruction )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);

                // Looc.g:58:58: ( class_decl )*
                while ( stream_class_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_class_decl.nextTree());

                }
                stream_class_decl.reset();
                // Looc.g:58:70: ( var_decl )*
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
    // Looc.g:60:1: class_decl : 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')' -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl ) ;
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
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleSubtreeStream stream_class_item_decl=new RewriteRuleSubtreeStream(adaptor,"rule class_item_decl");
        try {
            // Looc.g:60:11: ( 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')' -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl ) )
            // Looc.g:60:15: 'class' CLASS ( 'inherit' CLASS )? '=' '(' class_item_decl ')'
            {
            string_literal4=(Token)match(input,46,FOLLOW_46_in_class_decl221);  
            stream_46.add(string_literal4);

            CLASS5=(Token)match(input,CLASS,FOLLOW_CLASS_in_class_decl223);  
            stream_CLASS.add(CLASS5);

            // Looc.g:60:29: ( 'inherit' CLASS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==47) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Looc.g:60:30: 'inherit' CLASS
                    {
                    string_literal6=(Token)match(input,47,FOLLOW_47_in_class_decl226);  
                    stream_47.add(string_literal6);

                    CLASS7=(Token)match(input,CLASS,FOLLOW_CLASS_in_class_decl228);  
                    stream_CLASS.add(CLASS7);


                    }
                    break;

            }

            char_literal8=(Token)match(input,48,FOLLOW_48_in_class_decl233);  
            stream_48.add(char_literal8);

            char_literal9=(Token)match(input,49,FOLLOW_49_in_class_decl235);  
            stream_49.add(char_literal9);

            pushFollow(FOLLOW_class_item_decl_in_class_decl236);
            class_item_decl10=class_item_decl();

            state._fsp--;

            stream_class_item_decl.add(class_item_decl10.getTree());
            char_literal11=(Token)match(input,50,FOLLOW_50_in_class_decl237);  
            stream_50.add(char_literal11);



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
            // 60:75: -> ^( CLASS_DEC CLASS ( CLASS )? class_item_decl )
            {
                // Looc.g:60:78: ^( CLASS_DEC CLASS ( CLASS )? class_item_decl )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLASS_DEC, "CLASS_DEC"), root_1);

                adaptor.addChild(root_1, stream_CLASS.nextNode());
                // Looc.g:60:96: ( CLASS )?
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
    // Looc.g:64:1: class_item_decl : ( attr_decl )* ( method_decl )* -> ( ^( ATTRIBUTES ( attr_decl )* ) )? ( ^( METHODS ( method_decl )* ) )? ;
    public final LoocParser.class_item_decl_return class_item_decl() throws RecognitionException {
        LoocParser.class_item_decl_return retval = new LoocParser.class_item_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LoocParser.attr_decl_return attr_decl12 = null;

        LoocParser.method_decl_return method_decl13 = null;


        RewriteRuleSubtreeStream stream_method_decl=new RewriteRuleSubtreeStream(adaptor,"rule method_decl");
        RewriteRuleSubtreeStream stream_attr_decl=new RewriteRuleSubtreeStream(adaptor,"rule attr_decl");
        try {
            // Looc.g:64:16: ( ( attr_decl )* ( method_decl )* -> ( ^( ATTRIBUTES ( attr_decl )* ) )? ( ^( METHODS ( method_decl )* ) )? )
            // Looc.g:64:18: ( attr_decl )* ( method_decl )*
            {
            // Looc.g:64:18: ( attr_decl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==56) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Looc.g:64:18: attr_decl
            	    {
            	    pushFollow(FOLLOW_attr_decl_in_class_item_decl261);
            	    attr_decl12=attr_decl();

            	    state._fsp--;

            	    stream_attr_decl.add(attr_decl12.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // Looc.g:64:29: ( method_decl )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==51) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Looc.g:64:29: method_decl
            	    {
            	    pushFollow(FOLLOW_method_decl_in_class_item_decl264);
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
            // elements: attr_decl, method_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 64:42: -> ( ^( ATTRIBUTES ( attr_decl )* ) )? ( ^( METHODS ( method_decl )* ) )?
            {
                // Looc.g:64:45: ( ^( ATTRIBUTES ( attr_decl )* ) )?
                if ( stream_attr_decl.hasNext() ) {
                    // Looc.g:64:45: ^( ATTRIBUTES ( attr_decl )* )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                    // Looc.g:64:58: ( attr_decl )*
                    while ( stream_attr_decl.hasNext() ) {
                        adaptor.addChild(root_1, stream_attr_decl.nextTree());

                    }
                    stream_attr_decl.reset();

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_attr_decl.reset();
                // Looc.g:64:71: ( ^( METHODS ( method_decl )* ) )?
                if ( stream_method_decl.hasNext() ) {
                    // Looc.g:64:71: ^( METHODS ( method_decl )* )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODS, "METHODS"), root_1);

                    // Looc.g:64:81: ( method_decl )*
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
    // Looc.g:67:1: method_decl : 'method' IDF '(' ( method_args )? ')' function_decl -> ^( METHOD IDF ( method_args )? function_decl ) ;
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
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_function_decl=new RewriteRuleSubtreeStream(adaptor,"rule function_decl");
        RewriteRuleSubtreeStream stream_method_args=new RewriteRuleSubtreeStream(adaptor,"rule method_args");
        try {
            // Looc.g:67:12: ( 'method' IDF '(' ( method_args )? ')' function_decl -> ^( METHOD IDF ( method_args )? function_decl ) )
            // Looc.g:67:16: 'method' IDF '(' ( method_args )? ')' function_decl
            {
            string_literal14=(Token)match(input,51,FOLLOW_51_in_method_decl293);  
            stream_51.add(string_literal14);

            IDF15=(Token)match(input,IDF,FOLLOW_IDF_in_method_decl295);  
            stream_IDF.add(IDF15);

            char_literal16=(Token)match(input,49,FOLLOW_49_in_method_decl297);  
            stream_49.add(char_literal16);

            // Looc.g:67:33: ( method_args )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDF) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Looc.g:67:33: method_args
                    {
                    pushFollow(FOLLOW_method_args_in_method_decl299);
                    method_args17=method_args();

                    state._fsp--;

                    stream_method_args.add(method_args17.getTree());

                    }
                    break;

            }

            char_literal18=(Token)match(input,50,FOLLOW_50_in_method_decl302);  
            stream_50.add(char_literal18);

            pushFollow(FOLLOW_function_decl_in_method_decl304);
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
            // 67:64: -> ^( METHOD IDF ( method_args )? function_decl )
            {
                // Looc.g:67:67: ^( METHOD IDF ( method_args )? function_decl )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHOD, "METHOD"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                // Looc.g:67:80: ( method_args )?
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
    // Looc.g:69:1: function_decl : ( ':' type '{' ( var_decl )* ( instruction )+ '}' -> type ^( BODY ( var_decl )* ( instruction )+ ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BODY ( var_decl )* ( instruction )+ ) );
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
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:69:14: ( ':' type '{' ( var_decl )* ( instruction )+ '}' -> type ^( BODY ( var_decl )* ( instruction )+ ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BODY ( var_decl )* ( instruction )+ ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==52) ) {
                alt12=1;
            }
            else if ( (LA12_0==53) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // Looc.g:69:18: ':' type '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal20=(Token)match(input,52,FOLLOW_52_in_function_decl326);  
                    stream_52.add(char_literal20);

                    pushFollow(FOLLOW_type_in_function_decl328);
                    type21=type();

                    state._fsp--;

                    stream_type.add(type21.getTree());
                    char_literal22=(Token)match(input,53,FOLLOW_53_in_function_decl329);  
                    stream_53.add(char_literal22);

                    // Looc.g:69:29: ( var_decl )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==56) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Looc.g:69:29: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_function_decl330);
                    	    var_decl23=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl23.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    // Looc.g:69:39: ( instruction )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDF||LA9_0==53||LA9_0==61||LA9_0==64||LA9_0==66||(LA9_0>=78 && LA9_0<=80)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Looc.g:69:39: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_function_decl333);
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

                    char_literal25=(Token)match(input,54,FOLLOW_54_in_function_decl335);  
                    stream_54.add(char_literal25);



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
                    // 69:55: -> type ^( BODY ( var_decl )* ( instruction )+ )
                    {
                        adaptor.addChild(root_0, stream_type.nextTree());
                        // Looc.g:69:63: ^( BODY ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);

                        // Looc.g:69:70: ( var_decl )*
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
                    // Looc.g:70:7: '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal26=(Token)match(input,53,FOLLOW_53_in_function_decl357);  
                    stream_53.add(char_literal26);

                    // Looc.g:70:10: ( var_decl )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==56) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Looc.g:70:10: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_function_decl358);
                    	    var_decl27=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // Looc.g:70:20: ( instruction )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==IDF||LA11_0==53||LA11_0==61||LA11_0==64||LA11_0==66||(LA11_0>=78 && LA11_0<=80)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Looc.g:70:20: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_function_decl361);
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

                    char_literal29=(Token)match(input,54,FOLLOW_54_in_function_decl364);  
                    stream_54.add(char_literal29);



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
                    // 70:37: -> ^( BODY ( var_decl )* ( instruction )+ )
                    {
                        // Looc.g:70:40: ^( BODY ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);

                        // Looc.g:70:47: ( var_decl )*
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
    // Looc.g:74:1: method_args : method_arg ( ',' method_arg )* -> ^( FORMAL_PARAMS method_arg ( method_arg )* ) ;
    public final LoocParser.method_args_return method_args() throws RecognitionException {
        LoocParser.method_args_return retval = new LoocParser.method_args_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal31=null;
        LoocParser.method_arg_return method_arg30 = null;

        LoocParser.method_arg_return method_arg32 = null;


        Object char_literal31_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_method_arg=new RewriteRuleSubtreeStream(adaptor,"rule method_arg");
        try {
            // Looc.g:74:12: ( method_arg ( ',' method_arg )* -> ^( FORMAL_PARAMS method_arg ( method_arg )* ) )
            // Looc.g:74:15: method_arg ( ',' method_arg )*
            {
            pushFollow(FOLLOW_method_arg_in_method_args386);
            method_arg30=method_arg();

            state._fsp--;

            stream_method_arg.add(method_arg30.getTree());
            // Looc.g:74:26: ( ',' method_arg )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==55) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Looc.g:74:27: ',' method_arg
            	    {
            	    char_literal31=(Token)match(input,55,FOLLOW_55_in_method_args389);  
            	    stream_55.add(char_literal31);

            	    pushFollow(FOLLOW_method_arg_in_method_args391);
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
            // 74:44: -> ^( FORMAL_PARAMS method_arg ( method_arg )* )
            {
                // Looc.g:74:47: ^( FORMAL_PARAMS method_arg ( method_arg )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMAL_PARAMS, "FORMAL_PARAMS"), root_1);

                adaptor.addChild(root_1, stream_method_arg.nextTree());
                // Looc.g:74:74: ( method_arg )*
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
    // Looc.g:76:1: method_arg : IDF ':' type -> ^( FORMAL_PARAM IDF type ) ;
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
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:76:11: ( IDF ':' type -> ^( FORMAL_PARAM IDF type ) )
            // Looc.g:76:13: IDF ':' type
            {
            IDF33=(Token)match(input,IDF,FOLLOW_IDF_in_method_arg413);  
            stream_IDF.add(IDF33);

            char_literal34=(Token)match(input,52,FOLLOW_52_in_method_arg415);  
            stream_52.add(char_literal34);

            pushFollow(FOLLOW_type_in_method_arg417);
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
            // 76:26: -> ^( FORMAL_PARAM IDF type )
            {
                // Looc.g:76:29: ^( FORMAL_PARAM IDF type )
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
    // Looc.g:78:1: var_decl : 'var' IDF ':' type ';' -> ^( VAR_DEC IDF type ) ;
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
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:78:9: ( 'var' IDF ':' type ';' -> ^( VAR_DEC IDF type ) )
            // Looc.g:78:12: 'var' IDF ':' type ';'
            {
            string_literal36=(Token)match(input,56,FOLLOW_56_in_var_decl435);  
            stream_56.add(string_literal36);

            IDF37=(Token)match(input,IDF,FOLLOW_IDF_in_var_decl437);  
            stream_IDF.add(IDF37);

            char_literal38=(Token)match(input,52,FOLLOW_52_in_var_decl439);  
            stream_52.add(char_literal38);

            pushFollow(FOLLOW_type_in_var_decl441);
            type39=type();

            state._fsp--;

            stream_type.add(type39.getTree());
            char_literal40=(Token)match(input,57,FOLLOW_57_in_var_decl443);  
            stream_57.add(char_literal40);



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
            // 78:35: -> ^( VAR_DEC IDF type )
            {
                // Looc.g:78:38: ^( VAR_DEC IDF type )
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

    public static class attr_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr_decl"
    // Looc.g:79:1: attr_decl : 'var' IDF ':' type ';' -> ^( ATTR_DEC IDF type ) ;
    public final LoocParser.attr_decl_return attr_decl() throws RecognitionException {
        LoocParser.attr_decl_return retval = new LoocParser.attr_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal41=null;
        Token IDF42=null;
        Token char_literal43=null;
        Token char_literal45=null;
        LoocParser.type_return type44 = null;


        Object string_literal41_tree=null;
        Object IDF42_tree=null;
        Object char_literal43_tree=null;
        Object char_literal45_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Looc.g:79:10: ( 'var' IDF ':' type ';' -> ^( ATTR_DEC IDF type ) )
            // Looc.g:79:13: 'var' IDF ':' type ';'
            {
            string_literal41=(Token)match(input,56,FOLLOW_56_in_attr_decl460);  
            stream_56.add(string_literal41);

            IDF42=(Token)match(input,IDF,FOLLOW_IDF_in_attr_decl462);  
            stream_IDF.add(IDF42);

            char_literal43=(Token)match(input,52,FOLLOW_52_in_attr_decl464);  
            stream_52.add(char_literal43);

            pushFollow(FOLLOW_type_in_attr_decl466);
            type44=type();

            state._fsp--;

            stream_type.add(type44.getTree());
            char_literal45=(Token)match(input,57,FOLLOW_57_in_attr_decl468);  
            stream_57.add(char_literal45);



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
            // 79:36: -> ^( ATTR_DEC IDF type )
            {
                // Looc.g:79:39: ^( ATTR_DEC IDF type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTR_DEC, "ATTR_DEC"), root_1);

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
    // $ANTLR end "attr_decl"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // Looc.g:82:1: type : ( 'int' -> 'int' | 'string' -> 'string' | CLASS -> CLASS );
    public final LoocParser.type_return type() throws RecognitionException {
        LoocParser.type_return retval = new LoocParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal46=null;
        Token string_literal47=null;
        Token CLASS48=null;

        Object string_literal46_tree=null;
        Object string_literal47_tree=null;
        Object CLASS48_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");

        try {
            // Looc.g:82:5: ( 'int' -> 'int' | 'string' -> 'string' | CLASS -> CLASS )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt14=1;
                }
                break;
            case 59:
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
                    // Looc.g:82:9: 'int'
                    {
                    string_literal46=(Token)match(input,58,FOLLOW_58_in_type488);  
                    stream_58.add(string_literal46);



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
                    // 82:15: -> 'int'
                    {
                        adaptor.addChild(root_0, stream_58.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // Looc.g:83:7: 'string'
                    {
                    string_literal47=(Token)match(input,59,FOLLOW_59_in_type500);  
                    stream_59.add(string_literal47);



                    // AST REWRITE
                    // elements: 59
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:16: -> 'string'
                    {
                        adaptor.addChild(root_0, stream_59.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // Looc.g:84:8: CLASS
                    {
                    CLASS48=(Token)match(input,CLASS,FOLLOW_CLASS_in_type513);  
                    stream_CLASS.add(CLASS48);



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
                    // 84:14: -> CLASS
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
    // Looc.g:87:1: instruction : ( IDF ':=' expression ';' -> ^( AFFECT IDF expression ) | 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end' -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) ) | 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi' -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? ) | print | 'do' expression ';' -> ^( DO expression ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BLOCK ( var_decl )* ( instruction )+ ) | return_decl ';' -> ^( RETURN return_decl ) | read ';' -> ^( READ read ) );
    public final LoocParser.instruction_return instruction() throws RecognitionException {
        LoocParser.instruction_return retval = new LoocParser.instruction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDF49=null;
        Token string_literal50=null;
        Token char_literal52=null;
        Token string_literal53=null;
        Token IDF54=null;
        Token string_literal55=null;
        Token string_literal57=null;
        Token string_literal59=null;
        Token string_literal61=null;
        Token string_literal62=null;
        Token string_literal64=null;
        Token string_literal65=null;
        Token string_literal66=null;
        Token string_literal68=null;
        Token char_literal70=null;
        Token char_literal71=null;
        Token char_literal74=null;
        Token char_literal76=null;
        Token char_literal78=null;
        List list_a=null;
        List list_b=null;
        LoocParser.expression_return expression51 = null;

        LoocParser.expression_return expression56 = null;

        LoocParser.expression_return expression58 = null;

        LoocParser.instruction_return instruction60 = null;

        LoocParser.expression_return expression63 = null;

        LoocParser.print_return print67 = null;

        LoocParser.expression_return expression69 = null;

        LoocParser.var_decl_return var_decl72 = null;

        LoocParser.instruction_return instruction73 = null;

        LoocParser.return_decl_return return_decl75 = null;

        LoocParser.read_return read77 = null;

        RuleReturnScope a = null;
        RuleReturnScope b = null;
        Object IDF49_tree=null;
        Object string_literal50_tree=null;
        Object char_literal52_tree=null;
        Object string_literal53_tree=null;
        Object IDF54_tree=null;
        Object string_literal55_tree=null;
        Object string_literal57_tree=null;
        Object string_literal59_tree=null;
        Object string_literal61_tree=null;
        Object string_literal62_tree=null;
        Object string_literal64_tree=null;
        Object string_literal65_tree=null;
        Object string_literal66_tree=null;
        Object string_literal68_tree=null;
        Object char_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal74_tree=null;
        Object char_literal76_tree=null;
        Object char_literal78_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_read=new RewriteRuleSubtreeStream(adaptor,"rule read");
        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        RewriteRuleSubtreeStream stream_return_decl=new RewriteRuleSubtreeStream(adaptor,"rule return_decl");
        try {
            // Looc.g:87:12: ( IDF ':=' expression ';' -> ^( AFFECT IDF expression ) | 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end' -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) ) | 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi' -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? ) | print | 'do' expression ';' -> ^( DO expression ) | '{' ( var_decl )* ( instruction )+ '}' -> ^( BLOCK ( var_decl )* ( instruction )+ ) | return_decl ';' -> ^( RETURN return_decl ) | read ';' -> ^( READ read ) )
            int alt21=8;
            switch ( input.LA(1) ) {
            case IDF:
                {
                alt21=1;
                }
                break;
            case 61:
                {
                alt21=2;
                }
                break;
            case 66:
                {
                alt21=3;
                }
                break;
            case 78:
                {
                alt21=4;
                }
                break;
            case 64:
                {
                alt21=5;
                }
                break;
            case 53:
                {
                alt21=6;
                }
                break;
            case 79:
                {
                alt21=7;
                }
                break;
            case 80:
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
                    // Looc.g:87:15: IDF ':=' expression ';'
                    {
                    IDF49=(Token)match(input,IDF,FOLLOW_IDF_in_instruction526);  
                    stream_IDF.add(IDF49);

                    string_literal50=(Token)match(input,60,FOLLOW_60_in_instruction528);  
                    stream_60.add(string_literal50);

                    pushFollow(FOLLOW_expression_in_instruction530);
                    expression51=expression();

                    state._fsp--;

                    stream_expression.add(expression51.getTree());
                    char_literal52=(Token)match(input,57,FOLLOW_57_in_instruction532);  
                    stream_57.add(char_literal52);



                    // AST REWRITE
                    // elements: expression, IDF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 87:39: -> ^( AFFECT IDF expression )
                    {
                        // Looc.g:87:42: ^( AFFECT IDF expression )
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
                    // Looc.g:88:6: 'for' IDF 'in' expression '..' expression 'do' ( instruction )+ 'end'
                    {
                    string_literal53=(Token)match(input,61,FOLLOW_61_in_instruction550);  
                    stream_61.add(string_literal53);

                    IDF54=(Token)match(input,IDF,FOLLOW_IDF_in_instruction552);  
                    stream_IDF.add(IDF54);

                    string_literal55=(Token)match(input,62,FOLLOW_62_in_instruction554);  
                    stream_62.add(string_literal55);

                    pushFollow(FOLLOW_expression_in_instruction556);
                    expression56=expression();

                    state._fsp--;

                    stream_expression.add(expression56.getTree());
                    string_literal57=(Token)match(input,63,FOLLOW_63_in_instruction558);  
                    stream_63.add(string_literal57);

                    pushFollow(FOLLOW_expression_in_instruction560);
                    expression58=expression();

                    state._fsp--;

                    stream_expression.add(expression58.getTree());
                    string_literal59=(Token)match(input,64,FOLLOW_64_in_instruction562);  
                    stream_64.add(string_literal59);

                    // Looc.g:88:53: ( instruction )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDF||LA15_0==53||LA15_0==61||LA15_0==64||LA15_0==66||(LA15_0>=78 && LA15_0<=80)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Looc.g:88:53: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction564);
                    	    instruction60=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction60.getTree());

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

                    string_literal61=(Token)match(input,65,FOLLOW_65_in_instruction567);  
                    stream_65.add(string_literal61);



                    // AST REWRITE
                    // elements: expression, IDF, instruction, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 88:72: -> ^( FOR IDF expression expression ^( BODY ( instruction )+ ) )
                    {
                        // Looc.g:88:75: ^( FOR IDF expression expression ^( BODY ( instruction )+ ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);

                        adaptor.addChild(root_1, stream_IDF.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        // Looc.g:88:107: ^( BODY ( instruction )+ )
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
                    // Looc.g:89:6: 'if' expression 'then' (a+= instruction )+ ( 'else' (b+= instruction )+ )? 'fi'
                    {
                    string_literal62=(Token)match(input,66,FOLLOW_66_in_instruction593);  
                    stream_66.add(string_literal62);

                    pushFollow(FOLLOW_expression_in_instruction595);
                    expression63=expression();

                    state._fsp--;

                    stream_expression.add(expression63.getTree());
                    string_literal64=(Token)match(input,67,FOLLOW_67_in_instruction597);  
                    stream_67.add(string_literal64);

                    // Looc.g:89:30: (a+= instruction )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDF||LA16_0==53||LA16_0==61||LA16_0==64||LA16_0==66||(LA16_0>=78 && LA16_0<=80)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Looc.g:89:30: a+= instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction601);
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

                    // Looc.g:89:45: ( 'else' (b+= instruction )+ )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==68) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // Looc.g:89:46: 'else' (b+= instruction )+
                            {
                            string_literal65=(Token)match(input,68,FOLLOW_68_in_instruction605);  
                            stream_68.add(string_literal65);

                            // Looc.g:89:54: (b+= instruction )+
                            int cnt17=0;
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==IDF||LA17_0==53||LA17_0==61||LA17_0==64||LA17_0==66||(LA17_0>=78 && LA17_0<=80)) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // Looc.g:89:54: b+= instruction
                            	    {
                            	    pushFollow(FOLLOW_instruction_in_instruction609);
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

                    string_literal66=(Token)match(input,69,FOLLOW_69_in_instruction614);  
                    stream_69.add(string_literal66);



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
                    // 89:76: -> ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? )
                    {
                        // Looc.g:89:79: ^( IF expression ^( THEN ( $a)+ ) ( ^( ELSE ( $b)+ ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        // Looc.g:89:95: ^( THEN ( $a)+ )
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
                        // Looc.g:89:107: ( ^( ELSE ( $b)+ ) )?
                        if ( stream_b.hasNext() ) {
                            // Looc.g:89:108: ^( ELSE ( $b)+ )
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
                    // Looc.g:90:6: print
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_print_in_instruction649);
                    print67=print();

                    state._fsp--;

                    adaptor.addChild(root_0, print67.getTree());

                    }
                    break;
                case 5 :
                    // Looc.g:91:11: 'do' expression ';'
                    {
                    string_literal68=(Token)match(input,64,FOLLOW_64_in_instruction661);  
                    stream_64.add(string_literal68);

                    pushFollow(FOLLOW_expression_in_instruction663);
                    expression69=expression();

                    state._fsp--;

                    stream_expression.add(expression69.getTree());
                    char_literal70=(Token)match(input,57,FOLLOW_57_in_instruction665);  
                    stream_57.add(char_literal70);



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
                    // 91:31: -> ^( DO expression )
                    {
                        // Looc.g:91:34: ^( DO expression )
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
                    // Looc.g:92:12: '{' ( var_decl )* ( instruction )+ '}'
                    {
                    char_literal71=(Token)match(input,53,FOLLOW_53_in_instruction686);  
                    stream_53.add(char_literal71);

                    // Looc.g:92:16: ( var_decl )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==56) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // Looc.g:92:16: var_decl
                    	    {
                    	    pushFollow(FOLLOW_var_decl_in_instruction688);
                    	    var_decl72=var_decl();

                    	    state._fsp--;

                    	    stream_var_decl.add(var_decl72.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // Looc.g:92:26: ( instruction )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDF||LA20_0==53||LA20_0==61||LA20_0==64||LA20_0==66||(LA20_0>=78 && LA20_0<=80)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Looc.g:92:26: instruction
                    	    {
                    	    pushFollow(FOLLOW_instruction_in_instruction691);
                    	    instruction73=instruction();

                    	    state._fsp--;

                    	    stream_instruction.add(instruction73.getTree());

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

                    char_literal74=(Token)match(input,54,FOLLOW_54_in_instruction694);  
                    stream_54.add(char_literal74);



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
                    // 92:43: -> ^( BLOCK ( var_decl )* ( instruction )+ )
                    {
                        // Looc.g:92:46: ^( BLOCK ( var_decl )* ( instruction )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);

                        // Looc.g:92:54: ( var_decl )*
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
                    // Looc.g:93:8: return_decl ';'
                    {
                    pushFollow(FOLLOW_return_decl_in_instruction715);
                    return_decl75=return_decl();

                    state._fsp--;

                    stream_return_decl.add(return_decl75.getTree());
                    char_literal76=(Token)match(input,57,FOLLOW_57_in_instruction717);  
                    stream_57.add(char_literal76);



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
                    // 93:24: -> ^( RETURN return_decl )
                    {
                        // Looc.g:93:27: ^( RETURN return_decl )
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
                    // Looc.g:94:10: read ';'
                    {
                    pushFollow(FOLLOW_read_in_instruction736);
                    read77=read();

                    state._fsp--;

                    stream_read.add(read77.getTree());
                    char_literal78=(Token)match(input,57,FOLLOW_57_in_instruction737);  
                    stream_57.add(char_literal78);



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
                    // 94:18: -> ^( READ read )
                    {
                        // Looc.g:94:21: ^( READ read )
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
    // Looc.g:96:1: expression : ( operation | 'new' CLASS -> ^( 'new' CLASS ) );
    public final LoocParser.expression_return expression() throws RecognitionException {
        LoocParser.expression_return retval = new LoocParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal80=null;
        Token CLASS81=null;
        LoocParser.operation_return operation79 = null;


        Object string_literal80_tree=null;
        Object CLASS81_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");

        try {
            // Looc.g:96:12: ( operation | 'new' CLASS -> ^( 'new' CLASS ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDF||(LA22_0>=INT && LA22_0<=STRING)||LA22_0==49||LA22_0==72||(LA22_0>=75 && LA22_0<=76)) ) {
                alt22=1;
            }
            else if ( (LA22_0==70) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // Looc.g:96:16: operation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_operation_in_expression755);
                    operation79=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation79.getTree());

                    }
                    break;
                case 2 :
                    // Looc.g:97:5: 'new' CLASS
                    {
                    string_literal80=(Token)match(input,70,FOLLOW_70_in_expression761);  
                    stream_70.add(string_literal80);

                    CLASS81=(Token)match(input,CLASS,FOLLOW_CLASS_in_expression763);  
                    stream_CLASS.add(CLASS81);



                    // AST REWRITE
                    // elements: CLASS, 70
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:17: -> ^( 'new' CLASS )
                    {
                        // Looc.g:97:20: ^( 'new' CLASS )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_70.nextNode(), root_1);

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
    // Looc.g:100:1: operation : ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )* ;
    public final LoocParser.operation_return operation() throws RecognitionException {
        LoocParser.operation_return retval = new LoocParser.operation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal83=null;
        Token char_literal84=null;
        LoocParser.multiop_return mult = null;

        LoocParser.multiop_return multiop82 = null;


        Object char_literal83_tree=null;
        Object char_literal84_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_multiop=new RewriteRuleSubtreeStream(adaptor,"rule multiop");
        try {
            // Looc.g:100:11: ( ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )* )
            // Looc.g:100:13: ( multiop -> multiop ) ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )*
            {
            // Looc.g:100:13: ( multiop -> multiop )
            // Looc.g:100:14: multiop
            {
            pushFollow(FOLLOW_multiop_in_operation781);
            multiop82=multiop();

            state._fsp--;

            stream_multiop.add(multiop82.getTree());


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
            // 100:22: -> multiop
            {
                adaptor.addChild(root_0, stream_multiop.nextTree());

            }

            retval.tree = root_0;
            }

            // Looc.g:100:34: ( '+' mult= multiop -> ^( PLUS $operation $mult) | '-' mult= multiop -> ^( DIFF $operation $mult) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==71) ) {
                    alt23=1;
                }
                else if ( (LA23_0==72) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // Looc.g:100:35: '+' mult= multiop
            	    {
            	    char_literal83=(Token)match(input,71,FOLLOW_71_in_operation789);  
            	    stream_71.add(char_literal83);

            	    pushFollow(FOLLOW_multiop_in_operation793);
            	    mult=multiop();

            	    state._fsp--;

            	    stream_multiop.add(mult.getTree());


            	    // AST REWRITE
            	    // elements: mult, operation
            	    // token labels: 
            	    // rule labels: mult, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_mult=new RewriteRuleSubtreeStream(adaptor,"rule mult",mult!=null?mult.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 100:52: -> ^( PLUS $operation $mult)
            	    {
            	        // Looc.g:100:55: ^( PLUS $operation $mult)
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
            	    // Looc.g:101:4: '-' mult= multiop
            	    {
            	    char_literal84=(Token)match(input,72,FOLLOW_72_in_operation810);  
            	    stream_72.add(char_literal84);

            	    pushFollow(FOLLOW_multiop_in_operation814);
            	    mult=multiop();

            	    state._fsp--;

            	    stream_multiop.add(mult.getTree());


            	    // AST REWRITE
            	    // elements: mult, operation
            	    // token labels: 
            	    // rule labels: mult, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_mult=new RewriteRuleSubtreeStream(adaptor,"rule mult",mult!=null?mult.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 101:21: -> ^( DIFF $operation $mult)
            	    {
            	        // Looc.g:101:24: ^( DIFF $operation $mult)
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
    // Looc.g:103:1: multiop : ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )* ;
    public final LoocParser.multiop_return multiop() throws RecognitionException {
        LoocParser.multiop_return retval = new LoocParser.multiop_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal86=null;
        Token char_literal87=null;
        LoocParser.comparaison_return cmp = null;

        LoocParser.comparaison_return comparaison85 = null;


        Object char_literal86_tree=null;
        Object char_literal87_tree=null;
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_comparaison=new RewriteRuleSubtreeStream(adaptor,"rule comparaison");
        try {
            // Looc.g:103:9: ( ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )* )
            // Looc.g:103:11: ( comparaison -> comparaison ) ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )*
            {
            // Looc.g:103:11: ( comparaison -> comparaison )
            // Looc.g:103:12: comparaison
            {
            pushFollow(FOLLOW_comparaison_in_multiop837);
            comparaison85=comparaison();

            state._fsp--;

            stream_comparaison.add(comparaison85.getTree());


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
            // 103:24: -> comparaison
            {
                adaptor.addChild(root_0, stream_comparaison.nextTree());

            }

            retval.tree = root_0;
            }

            // Looc.g:103:40: ( '*' cmp= comparaison -> ^( MUL $multiop $cmp) | '/' cmp= comparaison -> ^( DIV $multiop $cmp) )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==73) ) {
                    alt24=1;
                }
                else if ( (LA24_0==74) ) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // Looc.g:103:41: '*' cmp= comparaison
            	    {
            	    char_literal86=(Token)match(input,73,FOLLOW_73_in_multiop845);  
            	    stream_73.add(char_literal86);

            	    pushFollow(FOLLOW_comparaison_in_multiop849);
            	    cmp=comparaison();

            	    state._fsp--;

            	    stream_comparaison.add(cmp.getTree());


            	    // AST REWRITE
            	    // elements: cmp, multiop
            	    // token labels: 
            	    // rule labels: cmp, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_cmp=new RewriteRuleSubtreeStream(adaptor,"rule cmp",cmp!=null?cmp.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 103:61: -> ^( MUL $multiop $cmp)
            	    {
            	        // Looc.g:103:64: ^( MUL $multiop $cmp)
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
            	    // Looc.g:104:4: '/' cmp= comparaison
            	    {
            	    char_literal87=(Token)match(input,74,FOLLOW_74_in_multiop866);  
            	    stream_74.add(char_literal87);

            	    pushFollow(FOLLOW_comparaison_in_multiop870);
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
            	    // 104:24: -> ^( DIV $multiop $cmp)
            	    {
            	        // Looc.g:104:27: ^( DIV $multiop $cmp)
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
    // Looc.g:106:1: comparaison : moinsunaire ( OPER moinsunaire )? ;
    public final LoocParser.comparaison_return comparaison() throws RecognitionException {
        LoocParser.comparaison_return retval = new LoocParser.comparaison_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPER89=null;
        LoocParser.moinsunaire_return moinsunaire88 = null;

        LoocParser.moinsunaire_return moinsunaire90 = null;


        Object OPER89_tree=null;

        try {
            // Looc.g:107:2: ( moinsunaire ( OPER moinsunaire )? )
            // Looc.g:107:4: moinsunaire ( OPER moinsunaire )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_moinsunaire_in_comparaison893);
            moinsunaire88=moinsunaire();

            state._fsp--;

            adaptor.addChild(root_0, moinsunaire88.getTree());
            // Looc.g:107:16: ( OPER moinsunaire )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==OPER) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Looc.g:107:17: OPER moinsunaire
                    {
                    OPER89=(Token)match(input,OPER,FOLLOW_OPER_in_comparaison896); 
                    OPER89_tree = (Object)adaptor.create(OPER89);
                    root_0 = (Object)adaptor.becomeRoot(OPER89_tree, root_0);

                    pushFollow(FOLLOW_moinsunaire_in_comparaison899);
                    moinsunaire90=moinsunaire();

                    state._fsp--;

                    adaptor.addChild(root_0, moinsunaire90.getTree());

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
    // Looc.g:109:1: moinsunaire : ( '-' )? atom ;
    public final LoocParser.moinsunaire_return moinsunaire() throws RecognitionException {
        LoocParser.moinsunaire_return retval = new LoocParser.moinsunaire_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal91=null;
        LoocParser.atom_return atom92 = null;


        Object char_literal91_tree=null;

        try {
            // Looc.g:110:2: ( ( '-' )? atom )
            // Looc.g:110:4: ( '-' )? atom
            {
            root_0 = (Object)adaptor.nil();

            // Looc.g:110:4: ( '-' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==72) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Looc.g:110:5: '-'
                    {
                    char_literal91=(Token)match(input,72,FOLLOW_72_in_moinsunaire911); 
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    root_0 = (Object)adaptor.becomeRoot(char_literal91_tree, root_0);


                    }
                    break;

            }

            pushFollow(FOLLOW_atom_in_moinsunaire916);
            atom92=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom92.getTree());

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
    // Looc.g:112:1: atom : ( INT | STRING | IDF ( call )? | 'this' ( call )? | 'super' ( call )? | '(' expression ')' -> expression );
    public final LoocParser.atom_return atom() throws RecognitionException {
        LoocParser.atom_return retval = new LoocParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT93=null;
        Token STRING94=null;
        Token IDF95=null;
        Token string_literal97=null;
        Token string_literal99=null;
        Token char_literal101=null;
        Token char_literal103=null;
        LoocParser.call_return call96 = null;

        LoocParser.call_return call98 = null;

        LoocParser.call_return call100 = null;

        LoocParser.expression_return expression102 = null;


        Object INT93_tree=null;
        Object STRING94_tree=null;
        Object IDF95_tree=null;
        Object string_literal97_tree=null;
        Object string_literal99_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:112:5: ( INT | STRING | IDF ( call )? | 'this' ( call )? | 'super' ( call )? | '(' expression ')' -> expression )
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
            case 75:
                {
                alt30=4;
                }
                break;
            case 76:
                {
                alt30=5;
                }
                break;
            case 49:
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
                    // Looc.g:112:7: INT
                    {
                    root_0 = (Object)adaptor.nil();

                    INT93=(Token)match(input,INT,FOLLOW_INT_in_atom923); 
                    INT93_tree = (Object)adaptor.create(INT93);
                    adaptor.addChild(root_0, INT93_tree);


                    }
                    break;
                case 2 :
                    // Looc.g:113:4: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING94=(Token)match(input,STRING,FOLLOW_STRING_in_atom928); 
                    STRING94_tree = (Object)adaptor.create(STRING94);
                    adaptor.addChild(root_0, STRING94_tree);


                    }
                    break;
                case 3 :
                    // Looc.g:114:4: IDF ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    IDF95=(Token)match(input,IDF,FOLLOW_IDF_in_atom933); 
                    IDF95_tree = (Object)adaptor.create(IDF95);
                    root_0 = (Object)adaptor.becomeRoot(IDF95_tree, root_0);

                    // Looc.g:114:9: ( call )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==77) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // Looc.g:114:10: call
                            {
                            pushFollow(FOLLOW_call_in_atom937);
                            call96=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call96.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // Looc.g:115:4: 'this' ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal97=(Token)match(input,75,FOLLOW_75_in_atom945); 
                    string_literal97_tree = (Object)adaptor.create(string_literal97);
                    root_0 = (Object)adaptor.becomeRoot(string_literal97_tree, root_0);

                    // Looc.g:115:12: ( call )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==77) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Looc.g:115:13: call
                            {
                            pushFollow(FOLLOW_call_in_atom949);
                            call98=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call98.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // Looc.g:116:4: 'super' ( call )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal99=(Token)match(input,76,FOLLOW_76_in_atom957); 
                    string_literal99_tree = (Object)adaptor.create(string_literal99);
                    root_0 = (Object)adaptor.becomeRoot(string_literal99_tree, root_0);

                    // Looc.g:116:13: ( call )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==77) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // Looc.g:116:14: call
                            {
                            pushFollow(FOLLOW_call_in_atom961);
                            call100=call();

                            state._fsp--;

                            root_0 = (Object)adaptor.becomeRoot(call100.getTree(), root_0);

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // Looc.g:117:4: '(' expression ')'
                    {
                    char_literal101=(Token)match(input,49,FOLLOW_49_in_atom969);  
                    stream_49.add(char_literal101);

                    pushFollow(FOLLOW_expression_in_atom971);
                    expression102=expression();

                    state._fsp--;

                    stream_expression.add(expression102.getTree());
                    char_literal103=(Token)match(input,50,FOLLOW_50_in_atom973);  
                    stream_50.add(char_literal103);



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
                    // 117:23: -> expression
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
    // Looc.g:120:1: call : '.' IDF '(' ( expression ( ',' expression )* )? ')' -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? ) ;
    public final LoocParser.call_return call() throws RecognitionException {
        LoocParser.call_return retval = new LoocParser.call_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal104=null;
        Token IDF105=null;
        Token char_literal106=null;
        Token char_literal108=null;
        Token char_literal110=null;
        LoocParser.expression_return expression107 = null;

        LoocParser.expression_return expression109 = null;


        Object char_literal104_tree=null;
        Object IDF105_tree=null;
        Object char_literal106_tree=null;
        Object char_literal108_tree=null;
        Object char_literal110_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:120:6: ( '.' IDF '(' ( expression ( ',' expression )* )? ')' -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? ) )
            // Looc.g:120:8: '.' IDF '(' ( expression ( ',' expression )* )? ')'
            {
            char_literal104=(Token)match(input,77,FOLLOW_77_in_call986);  
            stream_77.add(char_literal104);

            IDF105=(Token)match(input,IDF,FOLLOW_IDF_in_call988);  
            stream_IDF.add(IDF105);

            char_literal106=(Token)match(input,49,FOLLOW_49_in_call990);  
            stream_49.add(char_literal106);

            // Looc.g:120:19: ( expression ( ',' expression )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDF||(LA32_0>=INT && LA32_0<=STRING)||LA32_0==49||LA32_0==70||LA32_0==72||(LA32_0>=75 && LA32_0<=76)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Looc.g:120:20: expression ( ',' expression )*
                    {
                    pushFollow(FOLLOW_expression_in_call992);
                    expression107=expression();

                    state._fsp--;

                    stream_expression.add(expression107.getTree());
                    // Looc.g:120:30: ( ',' expression )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==55) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // Looc.g:120:31: ',' expression
                    	    {
                    	    char_literal108=(Token)match(input,55,FOLLOW_55_in_call994);  
                    	    stream_55.add(char_literal108);

                    	    pushFollow(FOLLOW_expression_in_call995);
                    	    expression109=expression();

                    	    state._fsp--;

                    	    stream_expression.add(expression109.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal110=(Token)match(input,50,FOLLOW_50_in_call1000);  
            stream_50.add(char_literal110);



            // AST REWRITE
            // elements: IDF, expression, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 120:52: -> ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? )
            {
                // Looc.g:120:55: ^( CALL IDF ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                // Looc.g:120:66: ( ^( EFFECTIVE_PARAMS ( expression ( expression )* )? ) )?
                if ( stream_expression.hasNext() ) {
                    // Looc.g:120:67: ^( EFFECTIVE_PARAMS ( expression ( expression )* )? )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECTIVE_PARAMS, "EFFECTIVE_PARAMS"), root_2);

                    // Looc.g:120:86: ( expression ( expression )* )?
                    if ( stream_expression.hasNext()||stream_expression.hasNext() ) {
                        adaptor.addChild(root_2, stream_expression.nextTree());
                        // Looc.g:120:97: ( expression )*
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
    // Looc.g:122:1: print : 'write' expression ';' -> ^( WRITE expression ) ;
    public final LoocParser.print_return print() throws RecognitionException {
        LoocParser.print_return retval = new LoocParser.print_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal111=null;
        Token char_literal113=null;
        LoocParser.expression_return expression112 = null;


        Object string_literal111_tree=null;
        Object char_literal113_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:122:6: ( 'write' expression ';' -> ^( WRITE expression ) )
            // Looc.g:122:9: 'write' expression ';'
            {
            string_literal111=(Token)match(input,78,FOLLOW_78_in_print1032);  
            stream_78.add(string_literal111);

            pushFollow(FOLLOW_expression_in_print1034);
            expression112=expression();

            state._fsp--;

            stream_expression.add(expression112.getTree());
            char_literal113=(Token)match(input,57,FOLLOW_57_in_print1036);  
            stream_57.add(char_literal113);



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
            // 122:32: -> ^( WRITE expression )
            {
                // Looc.g:122:35: ^( WRITE expression )
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
    // Looc.g:124:1: return_decl : 'return' '(' expression ')' -> expression ;
    public final LoocParser.return_decl_return return_decl() throws RecognitionException {
        LoocParser.return_decl_return retval = new LoocParser.return_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal114=null;
        Token char_literal115=null;
        Token char_literal117=null;
        LoocParser.expression_return expression116 = null;


        Object string_literal114_tree=null;
        Object char_literal115_tree=null;
        Object char_literal117_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Looc.g:124:12: ( 'return' '(' expression ')' -> expression )
            // Looc.g:124:15: 'return' '(' expression ')'
            {
            string_literal114=(Token)match(input,79,FOLLOW_79_in_return_decl1052);  
            stream_79.add(string_literal114);

            char_literal115=(Token)match(input,49,FOLLOW_49_in_return_decl1053);  
            stream_49.add(char_literal115);

            pushFollow(FOLLOW_expression_in_return_decl1055);
            expression116=expression();

            state._fsp--;

            stream_expression.add(expression116.getTree());
            char_literal117=(Token)match(input,50,FOLLOW_50_in_return_decl1057);  
            stream_50.add(char_literal117);



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
            // 124:42: -> expression
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
    // Looc.g:126:1: read : 'read' IDF -> IDF ;
    public final LoocParser.read_return read() throws RecognitionException {
        LoocParser.read_return retval = new LoocParser.read_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal118=null;
        Token IDF119=null;

        Object string_literal118_tree=null;
        Object IDF119_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");

        try {
            // Looc.g:126:6: ( 'read' IDF -> IDF )
            // Looc.g:126:8: 'read' IDF
            {
            string_literal118=(Token)match(input,80,FOLLOW_80_in_read1070);  
            stream_80.add(string_literal118);

            IDF119=(Token)match(input,IDF,FOLLOW_IDF_in_read1072);  
            stream_IDF.add(IDF119);



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
            // 126:19: -> IDF
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


 

    public static final BitSet FOLLOW_class_decl_in_program189 = new BitSet(new long[]{0x2120404000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_var_decl_in_program192 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_program195 = new BitSet(new long[]{0x2120004000000002L,0x000000000001C005L});
    public static final BitSet FOLLOW_46_in_class_decl221 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_CLASS_in_class_decl223 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_class_decl226 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_CLASS_in_class_decl228 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_class_decl233 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_class_decl235 = new BitSet(new long[]{0x010C000000000000L});
    public static final BitSet FOLLOW_class_item_decl_in_class_decl236 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_class_decl237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_decl_in_class_item_decl261 = new BitSet(new long[]{0x0108000000000002L});
    public static final BitSet FOLLOW_method_decl_in_class_item_decl264 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_method_decl293 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_method_decl295 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_method_decl297 = new BitSet(new long[]{0x0004004000000000L});
    public static final BitSet FOLLOW_method_args_in_method_decl299 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_method_decl302 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_function_decl_in_method_decl304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_function_decl326 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_type_in_function_decl328 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_function_decl329 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_var_decl_in_function_decl330 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_function_decl333 = new BitSet(new long[]{0x2160004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_54_in_function_decl335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_function_decl357 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_var_decl_in_function_decl358 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_function_decl361 = new BitSet(new long[]{0x2160004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_54_in_function_decl364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_arg_in_method_args386 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_method_args389 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_method_arg_in_method_args391 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_IDF_in_method_arg413 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_method_arg415 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_type_in_method_arg417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_var_decl435 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_var_decl437 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_var_decl439 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_type_in_var_decl441 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_var_decl443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_attr_decl460 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_attr_decl462 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_attr_decl464 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_type_in_attr_decl466 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_attr_decl468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_type488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_type500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_type513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_instruction526 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_instruction528 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_instruction530 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_instruction532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_instruction550 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_instruction552 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_instruction554 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_instruction556 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_instruction558 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_instruction560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_instruction562 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_instruction564 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C007L});
    public static final BitSet FOLLOW_65_in_instruction567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_instruction593 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_instruction595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_instruction597 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_instruction601 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C035L});
    public static final BitSet FOLLOW_68_in_instruction605 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_instruction609 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C025L});
    public static final BitSet FOLLOW_69_in_instruction614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_instruction649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_instruction661 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_instruction663 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_instruction665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_instruction686 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_var_decl_in_instruction688 = new BitSet(new long[]{0x2120004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_instruction_in_instruction691 = new BitSet(new long[]{0x2160004000000000L,0x000000000001C005L});
    public static final BitSet FOLLOW_54_in_instruction694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_decl_in_instruction715 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_instruction717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_instruction736 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_instruction737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_expression755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_expression761 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_CLASS_in_expression763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiop_in_operation781 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_71_in_operation789 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_multiop_in_operation793 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_72_in_operation810 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_multiop_in_operation814 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_comparaison_in_multiop837 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_73_in_multiop845 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_comparaison_in_multiop849 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_74_in_multiop866 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_comparaison_in_multiop870 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_moinsunaire_in_comparaison893 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_OPER_in_comparaison896 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_moinsunaire_in_comparaison899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_moinsunaire911 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001900L});
    public static final BitSet FOLLOW_atom_in_moinsunaire916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_atom933 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_call_in_atom937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_atom945 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_call_in_atom949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_atom957 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_call_in_atom961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_atom969 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_atom971 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_atom973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_call986 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_call988 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_call990 = new BitSet(new long[]{0x0006034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_call992 = new BitSet(new long[]{0x0084000000000000L});
    public static final BitSet FOLLOW_55_in_call994 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_call995 = new BitSet(new long[]{0x0084000000000000L});
    public static final BitSet FOLLOW_50_in_call1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_print1032 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_print1034 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_print1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_return_decl1052 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_return_decl1053 = new BitSet(new long[]{0x0002034000000000L,0x0000000000001940L});
    public static final BitSet FOLLOW_expression_in_return_decl1055 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_return_decl1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_read1070 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_IDF_in_read1072 = new BitSet(new long[]{0x0000000000000002L});

}