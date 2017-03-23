package exceptions;

/**
 * Created by tld on 22/03/2017.
 */
public class UndeclaredVariableException extends Exception {

    public UndeclaredVariableException(String idf) {
        super("The variable '" + idf + "' is not declared");
    }

}
