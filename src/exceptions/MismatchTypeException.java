package exceptions;

/**
 * Created by tld on 22/03/2017.
 */
public class MismatchTypeException extends Exception {


    public MismatchTypeException(String type1 , String type2, String idf1,String idf2) {
        super("Cannot assign '" + type1 + ":" + idf1 + " to " + type2  + ":" +idf2);
    }

}
