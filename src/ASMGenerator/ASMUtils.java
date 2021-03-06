package ASMGenerator;


import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.binaries.Comparison;
import ASMGenerator.instructions.Affectation;
import ASMGenerator.instructions.ConditionFor;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Attribute;
import TDS.entries.Parameter;
import TDS.entries.Variable;
import core.Keywords;

import java.util.ArrayList;


/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */

public class ASMUtils {

    private static int labelsCounter = 0;
    public static final int ADDR_SIZE = 2;
    public static final int INT_SIZE = 2;
    public static final int CHAR_SIZE = 1;
    public static final int OFFSET_ENV = ADDR_SIZE * 2;
    public static final int CLASS_DESC_SIZE = ADDR_SIZE * 2;

    public static final String ADD = "ADD";
    public static final String DIFF = "SUB";
    public static final String MUL = "MUL";
    public static final String DIV = "DIV";
    public static final String LT = "BLW";
    public static final String LE = "BLE";
    public static final String GT = "BGT";
    public static final String GE = "BGE";
    public static final String EQ = "BEQ";
    public static final String NE = "BNE";



    public static String formatASM(String...params) {
        if(params.length == 3)
            return String.format("%-10s\t\t%-10s\t\t%-10s\n", (Object[])params);
        if(params.length == 4)
            return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%-10s\n",(Object[])params);

        if(params.length != 3 || params.length != 4) {
            try {
                throw new Exception("Problem with usage of formatASM:\n" + " - Only 3 or 4 params possible !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String generateAttribute(Attribute attr, SymbolTable localTDS) {
        StringBuffer asm = new StringBuffer();
        SymbolTable methodTDS = localTDS.getFather(localTDS.getImbricationLevel() - 2);
        int deplObject = countParameters(methodTDS) + 2;
        asm.append(generateStaticLinkLoader(localTDS.getImbricationLevel(), methodTDS.getImbricationLevel()));
        asm.append(formatASM("", "LDW", "R1, (R6)" + (deplObject * ADDR_SIZE)));
        asm.append(formatASM("", "ADQ", -(attr.getDepl() + ADDR_SIZE) + ",R1"));
        asm.append(formatASM("", "LDW", "R1, (R1)"));
        asm.append(addToStack("R1"));
        return asm.toString();
    }

    public static String generateReceiver(ASMGenerator.expressions.Variable v, SymbolTable localTDS) {
        Variable entry = v.getVariableEntry();
        StringBuffer asm = new StringBuffer();
        switch(entry.getName()) {
            case Entry.ATTRIBUTE:
                SymbolTable methodTDS = localTDS.getFather(localTDS.getImbricationLevel() - 2);
                int deplObject = countParameters(methodTDS) + 2;
                asm.append(generateStaticLinkLoader(localTDS.getImbricationLevel(), methodTDS.getImbricationLevel()));
                asm.append(formatASM("", "LDW", "R1, (R6)" + (deplObject * ADDR_SIZE)));
                asm.append(formatASM("", "ADQ", -(entry.getDepl() + ADDR_SIZE) + ",R1"));
                asm.append(addToStack("R1"));
                //asm.append(generateAttribute((Attribute) entry, localTDS));
                break;
            default:
                asm.append(generateStaticLinkLoader(localTDS.getImbricationLevel(), localTDS.getSymbolTable(entry).getImbricationLevel()));
                asm.append(formatASM("", "LDW", "R1, R6"));
                asm.append(formatASM("", "ADQ", (-(OFFSET_ENV + entry.getDepl())) + ", R1"));
                asm.append(addToStack("R1"));
        }
        return asm.toString();
    }

    public static String generateVariable(Variable v, SymbolTable localTDS) {
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.generateStaticLinkLoader(localTDS.getImbricationLevel(), localTDS.getSymbolTable(v).getImbricationLevel()));
        asm.append(formatASM("", "LDW", "R1, R6"));
        asm.append(formatASM("", "ADQ", (-(OFFSET_ENV + v.getDepl())) + ", R1"));
        asm.append(formatASM("", "LDW", "R1, (R1)"));
        asm.append(addToStack("R1"));
        return asm.toString();
    }

    private static String setupParameter(Variable v, SymbolTable localTDS) {
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.generateStaticLinkLoader(localTDS.getImbricationLevel(), localTDS.getSymbolTable(v).getImbricationLevel()));
        asm.append(formatASM("", "LDW", "R1, (R6)" + (-(OFFSET_ENV + v.getDepl()))));
        asm.append(addToStack("R1"));
        return asm.toString();
    }


    public static String generateAffection(Receiver r, SymbolTable localTDS, Expression e) {
        return r.generate() +//generateReceiver(v, localTDS) + //v.generate() +
                e.generate()
                + removeFromStack("R0")
                + removeFromStack("R1")
                + formatASM("", "STW", "R0, (R1)", "// Affection: " + r.getVariable().getVariableEntry().getNameVariable() + " = " + e.toString());
    }

    public static String removeFromStack(String reg) {
        return formatASM("", "LDW", reg + ", (SP)+");
    }

    private static String fill(char ch, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ch);
        return sb.toString();
    }

    private static String padString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }

    public static String generateComment(String... messages) {
        StringBuffer comment = new StringBuffer();
        int maxLength = 0;
        for(String m: messages) {
            if(maxLength < m.length())
                maxLength = m.length();
        }
        String sep = "-" + fill('-', maxLength + 2) + "-";
        comment.append(formatASM("\n//", sep, ""));
        for (String m: messages)
            comment.append(formatASM("//", String.format("| %s |", padString(m, maxLength)), ""));
        comment.append(formatASM("//", sep, ""));
        return comment.toString();
    }

    public static String stackStaticAndDynamic() {
        return ASMUtils.generateComment("New environment: Stack DYN and STAT") +
                formatASM("", "LDW", "R0, BP", "// Static and dynamic are the same") +
                formatASM("", "STW", "R0, -(SP)", "// DYN") +
                formatASM("", "LDW", "BP, SP") +
                formatASM("", "STW", "R0, -(SP)", "// STAT");
    }

    public static String generateLoocClassDescriptor(String className, SymbolTable classTDS, int numClass) {
        StringBuffer asm = new StringBuffer();
        int size = 0;
        int nbMethods = 0;
        for(String key: classTDS.getKeyEntries()) {
            size += ASMUtils.sizeof(classTDS.get(key));
            nbMethods += classTDS.get(key).getName().equals(Entry.METHOD) ? 1 : 0;
        }

        asm.append(generateComment("Setup class descriptor", className));
        asm.append(formatASM("", "LDW", "R0, #" + size) +
                ASMWriter.formatASM("", "STW",  "R0, (BC)" + (numClass * CLASS_DESC_SIZE), "// sizeof(" + className + ") = " + size) +
                ASMWriter.formatASM("", "LDW", "R0, #" + nbMethods) +
                ASMWriter.formatASM("", "STW",  "R0, (BC)" + ((numClass * CLASS_DESC_SIZE) + 2), "// count methods of " + className + " = " + nbMethods + "\n\n"));

        return asm.toString();
    }


    public static String generateLoocClassAffectation(SymbolTable classTDS, int numClass) {
        StringBuffer asm = new StringBuffer();
        asm.append(formatASM("", "LDW", "R0, BC") +
                formatASM("", "ADQ", (numClass * CLASS_DESC_SIZE) + ", R0") +
                formatASM("", "STW",  "R0, -(ST)") +
                formatASM("", "LDW",  "R1, (R0)") +
                formatASM("", "LDW", "R0, ST") +
                addToStack("R0")
        );
        asm.append(formatASM("", "SUB", "ST, R1, ST"));
        return asm.toString();
    }

    public static String generateMethod(SymbolTable methodTDS, ArrayList<Generable> instructions) {
        StringBuffer asm = new StringBuffer();
        asm.append(generateComment("Method " + methodTDS.getName(), "Class " + methodTDS.getFather().getName()));
        String labelMethod = methodTDS.getFather().getName() + methodTDS.getName();
        asm.append(ASMUtils.stackStaticAndDynamic(labelMethod));
        for(Generable g: instructions) {
            asm.append(g.generate());
        }

        return asm.toString();
    }

    public static String stackStaticAndDynamic(String label) {
        return formatASM("" + label, "LDW", "R0, BP", "// Static and dynamic are the same") +
                formatASM("", "STW", "R0, -(SP)", "// DYN") +
                formatASM("", "LDW", "BP, SP") +
                formatASM("", "STW", "R0, -(SP)", "// STAT");
    }

    public static String generateDeclaration(int deplType) {
        return formatASM("", "ADI", "SP, SP, #-" + deplType, "// Declaration: size = " + deplType);
    }

    public static int sizeof(Entry e) {
        switch(e.getName()) {
            case Entry.ATTRIBUTE:
            case Entry.VARIABLE:
                return ADDR_SIZE;
            default:
                return 0;
        }
    }

    public static String unstack(int depl) {
        return formatASM("", "ADQ", depl + ", SP", "// Unstack");
    }

    public static String generateReturn(Expression e) {
        StringBuffer asm = new StringBuffer();
        if(e != null) {
            asm.append(e.generate());
            asm.append(removeFromStack("R0"));
        }

        asm.append(formatASM("", "LDW", "SP, BP", " // Remove all locals variables"));
        asm.append(formatASM("", "LDW", "BP, (SP)+", ""));
        asm.append(formatASM("", "RTS", "// return"));
        return asm.toString();
    }

    public static String generateConstantInteger(int v) {
        return formatASM("", "LDW", "R1, #" + v) +
            addToStack("R1");
    }

    public static String generateConstantString(String s) {
        StringBuffer asm = new StringBuffer();
        asm.append(
                formatASM("", "LDW ",  "R0, #0x0000","//  push into the h9eap string '" + s + "'") +
                formatASM("", "STW " , "R0, (ST)-" + ADDR_SIZE) +
                formatASM("","ADQ" , "-" + ADDR_SIZE + ", ST"));
        for (int i = s.length() - 1; i >= 0 ; i--) {
            asm.append(formatASM("", "LDB ", "R0, #0x" + Integer.toHexString(s.charAt(i)) + "00") +
                    formatASM("", "STB ", "R0, (ST)-" + CHAR_SIZE) +
                    formatASM("", "ADQ", "-" + CHAR_SIZE + ", ST"));
        }
        asm.append(addToStack("R12"));
        return asm.toString();
    }

    public static String addToStack(String reg) {
        return formatASM("", "STW", reg + ", -(SP)");
    }

    public static String generateWrite(Expression e) {
        StringBuffer asm = new StringBuffer();
        asm.append(e.generate());

        switch (e.getType()) {
            case Keywords.STRING :
                asm.append(removeFromStack("R0"));
                asm.append(formatASM("", "STW", "R0, -(SP)", "// Stack param for WRITE"));
                asm.append(formatASM("", "TRP", "#WRITE_EXC") +
	                    formatASM("", "LDW", "R0, #0x0000", "// Pointeur sur retour ligne") +
		                formatASM("", "TRP", "#WRITE_EXC"));
                break;
            case Keywords.INTEGER:
                asm.append(
                    formatASM("", "JSR", "@itoa_", "") +
                    formatASM("", "ADI", "SP, SP, #" + INT_SIZE, "// Unstack params"));
                break;
            default:
                System.err.println(e.getType() + " is not supported for write");
                break;
        }

        return asm.toString();
    }

    public static String generateRead(Variable v) {
        StringBuffer asm = new StringBuffer();
        asm.append(formatASM("","LDW","R0, #0x0100" )+
                formatASM("","TRP","#READ_EXC")+
                formatASM("","LDW","R0, @0x0100")+
                formatASM("", "JSR", "@atoi_", ""));
        return asm.toString();
    }

    public static String generateOperator(String operator) {
        StringBuffer asm = new StringBuffer();

        if(operator.equals(ASMUtils.DIV))
            asm.append(formatASM("", "JSR", "@" + ASMWriter.DIV_ZERO));

        asm.append(removeFromStack("R2"));
        asm.append(removeFromStack("R1"));
        asm.append(formatASM("", operator, "R1, R2, R3", "// Make a " + operator) + addToStack("R3"));

        return asm.toString();
    }

    public static String generateComparison(String operator, String gotoLabel) {
        return removeFromStack("R2") +
                removeFromStack("R1") +
                formatASM("", "CMP", "R1, R2") +
                formatASM("", operator, "2")+
		        formatASM("", "JEA", "@" + gotoLabel);
    }

    public static int generateLabel() {
        return labelsCounter++;
    }

    public static String generateIf(Comparison c, Block b, Block elseBlock) {
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.generateComment("If " + c.toString()));
        int label = generateLabel();
        c.setGotoLabel("ELSE_" + label);
        asm.append(c.generate());
        asm.append(b.generate());
        asm.append(formatASM("", "JEA", "@FI_" + label));
        asm.append(formatASM("ELSE_" + label, "", ""));

        if(elseBlock != null)
            asm.append(elseBlock.generate());

        asm.append(formatASM("FI_" + label, "", ""));
        return asm.toString();
    }

    public static String generateFor(ConditionFor cond,  Block block, Affectation a) {
        StringBuffer asm = new StringBuffer();
        int label = generateLabel();
        cond.setBaseLabel("LOOP_" + label);
        cond.setGotoLabel("ENDLOOP_"+label);
        asm.append(cond.generate());
        asm.append(formatASM("//", "Instructions of for loop", ""));
        asm.append(block.generate());
        asm.append(formatASM("//", "Increment counter", ""));
        asm.append(a.generate());
        asm.append(formatASM("", "JEA", "@LOOP_" + label ,"// For, go back to condition "));
        asm.append(formatASM("ENDLOOP_" + label, "", ""));


        return asm.toString();
    }

    public static String unstackEnvironment() {
        return formatASM("", "LDW", "SP, BP", "// Unstack the environment") +
                formatASM("", "LDW", "BP, (SP)+", "");
    }

    public static String loadParameter(String reg, int numParameter) {
        return formatASM("", "LDW", "R0, (SP)" + ADDR_SIZE, "// Get parameter");
    }

    public static String generateStaticLinkLoader(int currentImbricationLevel, int imbricationLevelDeclaration) {
        if(currentImbricationLevel - imbricationLevelDeclaration == 0)
            return formatASM("", "LDW", "R6, BP");
        else
            return formatASM("", "LDW", "R0, #" + (currentImbricationLevel - imbricationLevelDeclaration), "// Find @variable with static link") +
                addToStack("R0") +
                formatASM("", "JSR", "@" + ASMWriter.BUILTIN_FIND_STATIC) +
                ASMUtils.unstack(ASMUtils.ADDR_SIZE);
    }

    public static String generateRead(Variable v, SymbolTable tds) {
        StringBuffer asm = new StringBuffer();

        if(!tds.contains(v))
            asm.append(ASMUtils.generateStaticLinkLoader(tds.getImbricationLevel(), tds.getSymbolTable(v).getImbricationLevel()));

        asm.append(formatASM("","LDW","R0, #0x0100" )+
                formatASM("","TRP","#READ_EXC")+
                formatASM("","LDW","R0, @0x0100")+
                formatASM("", "JSR", "@atoi_", ""));
        if(tds.contains(v))
            asm.append(formatASM("","STW","R0, (BP)-"+ (OFFSET_ENV + v.getDepl())));
        else
            asm.append(formatASM("", "STW", "R0, (R6)-" + (ASMUtils.OFFSET_ENV + v.getDepl()), "// Read " + v.getNameVariable()));

        return asm.toString();
    }

	public static String generateParameter(Parameter p, Expression e) {
        return e.generate();
	}

    public static String generateCallMethod(String labelMethod, Variable receiver, ArrayList<ASMGenerator.expressions.Parameter> params, SymbolTable localTDS, String typeReturn) {
        StringBuffer asm = new StringBuffer();
	    SymbolTable methodTDS = localTDS.getFather(localTDS.getImbricationLevel() - 2);
        if (receiver != null) {
	        asm.append(setupParameter(receiver, localTDS));
        }
        else {
	        int deplObject = countParameters(methodTDS) + 2;
	        asm.append(generateStaticLinkLoader(localTDS.getImbricationLevel(), methodTDS.getImbricationLevel()));
	        asm.append(formatASM("", "LDW", "R1, (R6)" + (deplObject * ADDR_SIZE)));
	        asm.append(addToStack("R1"));
        }
        for (ASMGenerator.expressions.Parameter p: params) {
            asm.append(p.generate());
        }
        asm.append(ASMUtils.formatASM("", "JSR", "@" + labelMethod));
        asm.append(ASMUtils.formatASM("", "ADI", "SP, SP, #" + ((params.size() + 1) * ADDR_SIZE)));
        if(typeReturn != null)
            asm.append(addToStack("R0"));
        return asm.toString();
    }

    private static String getBase(Variable v, SymbolTable tds) {
        StringBuffer asm = new StringBuffer();
        if(tds.contains(v))
            asm.append(formatASM("", "LDW", "R1, BP"));
        else {
            asm.append(generateStaticLinkLoader(tds.getImbricationLevel(), tds.getSymbolTable(v).getImbricationLevel()));
            asm.append(formatASM("", "LDW", "R1, R6"));
        }
        return asm.toString();
    }

    public static String generateEffectiveParam(Parameter p, SymbolTable localTDS) {
        StringBuffer asm = new StringBuffer();
        asm.append(getBase(p, localTDS));
        asm.append(formatASM("", "ADQ", (-p.getDepl() + ADDR_SIZE) + ", R1"));
        asm.append(formatASM("", "LDW", "R1, (R1)"));
        asm.append(addToStack("R1"));
        return asm.toString();
    }


    private static int countParameters(SymbolTable TDS) {
        int count = 0;
        for(String e: TDS.getKeyEntries()) {
            Entry tmp = TDS.get(e);
            count += tmp instanceof Parameter ? 1 : 0;
        }
        return count;
    }
}
