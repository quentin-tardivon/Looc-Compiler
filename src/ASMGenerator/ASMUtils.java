package ASMGenerator;


import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.binaries.Comparison;
import ASMGenerator.instructions.Affectation;
import ASMGenerator.instructions.ConditionFor;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.Keywords;

import java.util.ArrayList;

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

    private static String generateAffection(Variable v, Expression e) {
        return  e.generate() +
                removeFromStack("R0")+
                formatASM("", "STW", "R0, (BP)-" + (ASMUtils.OFFSET_ENV + v.getDepl()), "// Affection: " + v.getNameVariable() + " = " + e.toString());
    }

    public static String generateAffection(ASMGenerator.expressions.Variable v, SymbolTable localTDS, Expression e) {
        Variable varEntry = v.getVariableEntry();
        System.out.println(v);
        if(localTDS.contains(varEntry))
            return ASMUtils.generateAffection(varEntry, e);
        else
            return ASMUtils.generateAffectionWithStaticLink(localTDS.getImbricationLevel(), localTDS.getSymbolTable(varEntry).getImbricationLevel(), varEntry, e);
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


    public static String generateLoocClassAffectation(String className, SymbolTable classTDS, int numClass) {
        StringBuffer asm = new StringBuffer();
        asm.append(formatASM("", "LDW", "R0, BC") +
                formatASM("", "ADQ", (numClass * CLASS_DESC_SIZE) + ", R0") +
                formatASM("", "STW",  "R0, -(ST)") +
                formatASM("", "LDW", "R0, ST") +
                addToStack("R0")
        );

        for(String key: classTDS.getKeyEntries()) {
            if (classTDS.get(key).getName().equals(Entry.VARIABLE)) {
                asm.append(formatASM("", "ADI", "ST, ST, #-2"));
            }
        }
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
        asm.append(ASMUtils.formatASM("", "LDW", "SP, BP")
                + ASMUtils.formatASM("", "LDW", "BP, (SP)+"));
        asm.append(ASMUtils.formatASM("", "RTS", ""));
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
                formatASM("", "LDW ",  "R0, #0x0000","//  push into the heap string '" + s + "'") +
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
        asm.append(removeFromStack("R0"));
        asm.append(formatASM("", "STW", "R0, -(SP)", "// Stack param for WRITE"));

        switch (e.getType()) {
            case Keywords.STRING :
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

    public static  String generateRead(Variable v) {
        StringBuffer asm = new StringBuffer();
        asm.append(formatASM("","LDW","R0, #0x0100" )+
                formatASM("","TRP","#READ_EXC")+
                formatASM("","LDW","R0, @0x0100")+
                formatASM("", "JSR", "@atoi_", ""));
                //formatASM("","STW","R0, (BP)-"+ (OFFSET_ENV + v.getDepl()), " // Read " + v.getNameVariable()));
        return asm.toString();
    }

    public static String generateOperator(String operator) {
        return removeFromStack("R2") +
                removeFromStack("R1") +
                formatASM("", operator, "R1, R2, R3", "// Make a " + operator) +
                addToStack("R3");
    }

    public static String generateComparison(String operator, String gotoLabel) {
        return removeFromStack("R2") +
                removeFromStack("R1") +
                formatASM("", "CMP", "R1, R2") +
                formatASM("", operator, gotoLabel+"-($+2)");
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
        return formatASM("", "LDW", "R0, #" + (currentImbricationLevel - imbricationLevelDeclaration), "// Find @variable with static link") +
                addToStack("R0") +
                formatASM("", "JSR", "@" + ASMWriter.BUILTIN_FIND_STATIC) +
                ASMUtils.unstack(ASMUtils.ADDR_SIZE);
    }

    private static String generateAffectionWithStaticLink(int currentImbricationLevel, int imbricationLevelDeclaration, Variable v, Expression e) {
        StringBuffer asm = new StringBuffer();
        asm.append(e.generate());
        asm.append(generateStaticLinkLoader(currentImbricationLevel, imbricationLevelDeclaration));
        asm.append(removeFromStack("R0"));
        asm.append(formatASM("", "STW", "R0, (R6)-" + (ASMUtils.OFFSET_ENV + v.getDepl()), "// Affection: " + v.getNameVariable() + " = " + e.toString()));
        return asm.toString();
    }

    public static String generateVariableStaticLink(int currentImbricationLevel, int imbricationLevelDeclaration, int depl) {
        return generateStaticLinkLoader(currentImbricationLevel, imbricationLevelDeclaration) +
                formatASM("", "LDW", "R1, (R6)-" + (OFFSET_ENV + depl), "// Stack variable: move = " + depl) +
                addToStack("R1");
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

    public static String generateVariable(Variable v, SymbolTable localTDS) {
        StringBuffer asm = new StringBuffer();
        if(localTDS.contains(v))
            asm.append(ASMUtils.generateVariable(v, "BP"));
        else {
            asm.append(ASMUtils.generateStaticLinkLoader(localTDS.getImbricationLevel(), localTDS.getSymbolTable(v).getImbricationLevel()));
            asm.append(ASMUtils.generateVariable(v, "R6"));
        }
        return asm.toString();
    }

    private static String generateVariable(Variable v, String baseReg) {
        return formatASM("", "LDW", "R1, (" + baseReg + ")-" + (OFFSET_ENV + v.getDepl())) + addToStack("R1");
    }

}
