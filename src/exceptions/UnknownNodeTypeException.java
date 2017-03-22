package exceptions;

/**
 * Created by tld on 22/03/2017.
 */
public class UnknownNodeTypeException extends Exception {

    public UnknownNodeTypeException(String idf) {

            super("Type unknown :'" + idf );

    }

}
