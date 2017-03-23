package exceptions;

/**
 * Created by madmax on 23/03/2017.
 */
public class UndeclaredMethodException extends Exception {

    public UndeclaredMethodException(String idf) {
        super("The method '" + idf + "' is not declared");
    }
}

