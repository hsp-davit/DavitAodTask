package aodspace.ood.exception;

/**
 * throw exception when member not found
 * 
 * @author davit
 *
 */
public class MemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2046283280801798096L;

	/**
	 * call default constructor
	 */
	public MemberNotFoundException() {
		super();
	}

	/**
	 * call constructor whit parameter
	 * 
	 * @param message
	 */
	public MemberNotFoundException(String message) {
		super(message);
	}
}
