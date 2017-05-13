package ASMGenerator;


import ASMGenerator.expressions.Expression;
import TDS.Entry;

public class ASMUtils {


    public static final int INT_SIZE = 2;
    private static final int offsetEnvironment = INT_SIZE * 3;


    public static String formatASM(String...params) {
        if(params.length == 3)
            return String.format("%-10s\t\t%-10s\t\t%-10s\n", params);
        if(params.length == 4)
            return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%10s\n", params);

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
                removeFromStack("R1")+
                formatASM("", "LDW", "R0, R1") +
                formatASM("", "STW", "R0, (BP)-" + (ASMUtils.offsetEnvironment + depl), "// Affection: move = " + depl);
    }

    public static String removeFromStack(String reg) {
        return formatASM("", "LDW", reg + ", (SP)") +
                formatASM("", "ADQ", "2, SP");
    }

    public static String stackStaticAndDynamic() {
        return formatASM("", "STW", "BP, -(SP)", "// Stack the dynamic link") +
                formatASM("", "STW", "BP, -(SP)", "// Stack the static link");
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
                        return 0;
                }
            default:
                return 0;
        }
    }

    public static String generateReturn(int depl) {
        return formatASM("", "STW", "R0, (BP)-" + (offsetEnvironment + depl), "// Return instruction");
    }

    public static String generateIntegerConstant(int v) {
        return formatASM("", "LDW", "R1, #" + v) +
            addToStack("R1");
    }

    public static String addToStack(String reg) {
        return formatASM("", "STW", reg + ", -(SP)");
    }

    public static String generateSum() {
        return removeFromStack("R1") +
            removeFromStack("R2") +
            formatASM("", "ADD", "R1, R2, R3", "// Make a sum") +
            addToStack("R3");
    }

    public static String generateVariable(int depl) {
        return formatASM("", "LDW", "R1, (BP)-" + depl, "// Stack variable: move = " + depl) +
            addToStack("R1");
    }

    public static String generateMultiplication() {
       return removeFromStack("R1") +
            removeFromStack("R2") +
            formatASM("", "MUL", "R1, R2, R3", "// Make a mult") +
            addToStack("R3");
    }
}
