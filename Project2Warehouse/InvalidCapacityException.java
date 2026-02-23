public class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
    public InvalidCapacityException() {
    	super("Invalid size");
    }
}