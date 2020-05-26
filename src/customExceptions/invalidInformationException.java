package customExceptions;

public class invalidInformationException extends Exception {


	public invalidInformationException () {
		super();
		
	}
	
	public String message() {
		
		return "Please complete the fields completely";
	}
}
