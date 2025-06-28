package Models;

public class Conversion {
    public String value, result, errorMessage;
    public int sourceBase, targetBase;

    public Conversion(String value, int sourceBase, int targetBase) {
        this.value = value;
        this.sourceBase = sourceBase;
        this.targetBase = targetBase;
    }
}
