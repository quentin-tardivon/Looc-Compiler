package exceptions;

/**
 * Created by madmax on 23/03/2017.
 */
public class UndeclaredClassException extends Exception {

    public UndeclaredClassException(String idf) {
        super("The class '" + idf + "' is not declared");
    }
}
