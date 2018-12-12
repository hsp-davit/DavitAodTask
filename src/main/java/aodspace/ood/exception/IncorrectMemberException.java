package aodspace.ood.exception;

/**
 * throw exception when member not exist
 * 
 * @author davit
 *
 */
public class IncorrectMemberException extends RuntimeException {

	private static final long serialVersionUID = 5457297037511634551L;

	/**
	 * call default constructor
	 */
	public IncorrectMemberException() {
		super();
	}

	/**
	 * call constructor whit parameter
	 * 
	 * @param message
	 */
	public IncorrectMemberException(String message) {
		super(message);
	}
}
