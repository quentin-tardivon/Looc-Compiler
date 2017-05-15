package utils;

public class EnvironmentCounter {

    private int countFor;
    private int countIf;
    private int countElse;
    private int countBlock;

    public EnvironmentCounter() {
        this.countBlock = 0;
        this.countFor = 0;
        this.countElse = 0;
        this.countIf = 0;
    }

    public int incrementFor() {
        return (this.countFor)++;
    }

    public int incrementIf() {
        return (this.countIf)++;
    }

    public int incrementElse() {
        return (this.countElse)++;
    }

    public int incrementBlock() {
        return (this.countBlock)++;
    }

    public static String generateID(String label, int uniqID, int imbricLevel) {
        return label.toUpperCase() + "_" + uniqID + "_" + imbricLevel;
    }

}
