package exceptions;

/**
 * Created by quentin on 29/03/2017.
 */
public class MismatchOperationException extends Exception{
	public MismatchOperationException() {
		super("Cannot operate these elements");
	}
}
