package customExceptions;

public class NoFoundException extends Exception {

	public NoFoundException() {
		super();
	}

	public String message() {

		return "the user identified with this nickName is not registered";
	}

}
