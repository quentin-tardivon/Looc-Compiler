package ASMGenerator;


import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.binaries.Comparison;
import ASMGenerator.instructions.Affectation;
import ASMGenerator.instructions.ConditionFor;
import TDS.Entry;

public class ASMUtils {

    private static int labelsCounter = 0;
    public static final int ADDR_SIZE = 2;
    public static final int INT_SIZE = 2;
    public static final int CHAR_SIZE = 1;
    public static final int OFFSET_ENV = ADDR_SIZE * 2;

    public static final String ADD = "ADD";
    public static final String DIFF = "SUB";
    public static final String MUL = "MUL";
    public static final String DIV = "DIV";
    public static final String LT = "BGE";
    public static final String LE = "BGT";
    public static final String GT = "BLE";
    public static final String GE = "BLW";
    public static final String EQ = "BNE";
    public static final String NE = "BEQ";



    public static String formatASM(String...params) {
        if(params.length == 3)
            return String.format("%-10s\t\t%-10s\t\t%-10s\n", (Object[])params);
        if(params.length == 4)
            return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%10s\n",(Object[])params);

        if(params.length != 3 || params.length != 4) {
            try {
                throw new Exception("Problem with usage of formatASM:\n" + " - Only 3 or 4 params possible !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String generateAffection(int depl, Expression e) {
        return  e.generate() +
                removeFromStack("R0")+
                formatASM("", "STW", "R0, (BP)-" + (ASMUtils.OFFSET_ENV + depl), "// Affection: move = " + depl);
    }

    public static String removeFromStack(String reg) {
        return formatASM("", "LDW", reg + ", (SP)+");
                //formatASM("", "ADQ", "2, SP");
    }

    public static String stackStaticAndDynamic(String label) {
    /*    return formatASM(label, "STW", "BP, -(SP)", "// Stack the dynamic link") +
                formatASM("", "LDW", "R0, (SP)", "// Static and dynamic are the same") +
                formatASM("", "STW", "BP, -(SP)", "// Stack the static link") +
                formatASM("STW", "R0, BP", "");
                //formatASM("",  "STW", "R0, -(SP)", "// Stack the dynamic link") +
//                formatASM("", "LDW", "BP, SP") +
                //formatASM("", "STW", "BP, -(SP)", "// Stack the static link");
                */
        return formatASM("\n\n" + label, "LDW", "R0, BP", "// Static and dynamic are the same") +
                formatASM("", "STW", "R0, -(SP)", "// Stack dynamic link") +
                formatASM("", "LDW", "BP, SP") +
                formatASM("", "STW", "R0, -(SP)", "// Stack static link");
    }


    public static String stackStaticAndDynamic() {
        return formatASM("\n\n", "LDW", "R0, BP", "// Static and dynamic are the same") +
                formatASM("", "STW", "R0, -(SP)", "// Stack dynamic link") +
                formatASM("", "LDW", "BP, SP") +
                formatASM("", "STW", "R0, -(SP)", "// Stack static link");
                                //formatASM("", "STW", "BP, -(SP)", "// Stack the static link");
    }

    public static String generateDeclaration(int deplType) {
        return formatASM("", "ADI", "SP, SP, #-" + deplType, "// Declaration: size = " + deplType);
    }

    public static int sizeof(Entry e) {
        switch(e.getName()) {
            case Entry.VARIABLE:
                switch(e.get(Entry.TYPE)) {
                    case "int":
                        return INT_SIZE;
                    default:
                        return ADDR_SIZE;
                }
            default:
                return 0;
        }
    }

    public static String unstack(int depl) {
        return formatASM("", "ADQ", depl + ", SP", "// Unstack");
    }

    public static String generateReturn(int depl) {
        return formatASM("", "STW", "R0, (BP)-" + (OFFSET_ENV + depl), "// Store result int R0") +
                formatASM("", "LDW", "SP, BP", " // Remove all locals variables") +
                formatASM("", "LDW", "BP, (SP)+", "") +
                formatASM("", "RTS", "// return");
    }

    public static String generateConstantInteger(int v) {
        return formatASM("", "LDW", "R1, #" + v) +
            addToStack("R1");
    }

    public static String generateConstantString(String s) {
        StringBuffer asm = new StringBuffer();
        asm.append(
                formatASM("//", "push into the heap string '" + s + "'", "") +
                formatASM("", "LDW ",  "R0, #0x0000") +
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

    public static String generateVariable(int depl) {
        return formatASM("", "LDW", "R1, (BP)-" + (OFFSET_ENV + depl), "// Stack variable: move = " + depl) +
            addToStack("R1");
    }

    public static String generateWrite(Expression e) {
        return e.generate() +
                removeFromStack("R0")+
                formatASM("", "STW", "R0, -(SP)", "// Stack param for WRITE") +
                formatASM("", "JSR", "@itoa_", "") +
                formatASM("", "ADI", "SP, SP, #" + INT_SIZE, "// Unstack params");
    }

    public static String generateOperator(String operator) {
        return removeFromStack("R2") +
                removeFromStack("R1") +
                formatASM("", operator, "R1, R2, R3", "// Make a " + operator) +
                addToStack("R3");
    }

    public static String generateComparison(String operator, String gotoLabel, String labelBase) {
        return removeFromStack("R2") +
                removeFromStack("R1") +
                formatASM(labelBase, "CMP", "R1, R2") +
                formatASM("", operator, gotoLabel+"-$-2", "// X " + getComparisonOperator(operator) + " Y");
    }

    public static int generateLabel() {
        return labelsCounter++;
    }

    public static String generateIf(Comparison c, Block b, Block elseBlock) {
        StringBuffer asm = new StringBuffer();
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

    private static String getComparisonOperator(String op) {
        switch(op) {
            case EQ:
                return "==";
            case NE:
                return "!=";
            case GE:
                return ">=";
            case GT:
                return ">";
            case LE:
                return "<=";
            case LT:
                return "<";
        }
        return null;
    }

    public static String generateFor(ConditionFor cond,  Block block, Affectation a) {
        StringBuffer asm = new StringBuffer();
        int label = generateLabel();
        cond.setBaseLabel("LOOP_" + label);
        cond.setGotoLabel("ENDLOOP_"+label);
        asm.append(cond.generate());
        asm.append(block.generate());
        asm.append(a.generate());
        asm.append(formatASM("", "JEA", "@LOOP_" + label ,"// For, go back to condition "));
        asm.append(formatASM("ENDLOOP_" + label, "", ""));


        return asm.toString();
    }

    public static String unstackEnvironment() {
        return formatASM("", "LDW", "SP, BP", " // Unstack the environment") +
                formatASM("", "LDW", "BP, (SP)+", "");
    }

    public static String loadParameter(String reg, int numParameter) {
        return formatASM("", "LDW", "R0, (SP)" + ADDR_SIZE, "// Get parameter");
    }

    public static String generateAffectionWithStaticLink(int currentImbricationLevel, int imbricationLevelDeclaration, int depl, Expression e) {
        System.out.println(currentImbricationLevel + " - " + imbricationLevelDeclaration);
        StringBuffer asm = new StringBuffer();
        asm.append(formatASM("", "LDW", "R0, #" + (currentImbricationLevel - imbricationLevelDeclaration), "// Find @variable with static link"));
        asm.append(addToStack("R0"));
        asm.append(formatASM("", "JSR", "@" + ASMWriter.BUILTIN_FIND_STATIC));
        asm.append(unstack(ADDR_SIZE));
        asm.append(e.generate());
        asm.append(removeFromStack("R0"));
        asm.append(formatASM("", "STW", "R0, (R6)-" + (ASMUtils.OFFSET_ENV + depl), "// Affection: move = " + depl));
        return asm.toString();
    }
}
