
public class InvalidUserFormatException extends Exception {
	public InvalidUserFormatException() {
		super("Invalid User Format");
	}
	public InvalidUserFormatException(String message) {
		super(message);
	}
}
