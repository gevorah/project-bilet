package customExceptions;

public class RepeatUserException extends Exception {

	String id;

	public RepeatUserException(String id) {
		this.id = id;
	}
	
	public String exceptionMessage() {
		
		return "the username is already registered";
	}
}
