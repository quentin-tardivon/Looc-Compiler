package ASMGenerator;

/**
 * Created by mcdostone on 13/05/17.
 */
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


    public static String generateAffection(int depl) {
        return removeFromStack("R1")+
                formatASM("", "LDW", "R0, R1") +
                formatASM("", "STW", "R0, (BP)-" + (ASMUtils.offsetEnvironment + depl), "// Affection: move = " + depl);
    }


    public static String removeFromStack(String reg) {
        return formatASM("", "LDW", reg + ", (SP)") +
                formatASM("", "ADQ", "2, SP");
    }

}
