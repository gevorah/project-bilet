package customExceptions;

public class RepeatUserException extends Exception {



	public RepeatUserException()  {
			
		super();
	}
	
	public String Message(String name ) {
		
		return "the user with this nickname "+ name +" is already registered in the game";
	}
}
