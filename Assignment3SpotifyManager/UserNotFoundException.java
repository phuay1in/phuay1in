
public class UserNotFoundException extends Exception{
	public UserNotFoundException() {
		super("User was not found");
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
