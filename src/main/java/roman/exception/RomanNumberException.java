package roman.exception;

public class RomanNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -842432531202439187L;

	public RomanNumberException() {
		super();
	}

	public RomanNumberException(String message) {
		super(message);
	}

	public RomanNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public RomanNumberException(Throwable cause) {
		super(cause);
	}

}
