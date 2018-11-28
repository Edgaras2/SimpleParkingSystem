package parking;

public class DublicateCarException extends Exception {

	public final static String ERROR1 = "Car with such a car plate is already parked in parking lot.";
	public final static String ERROR2 = "Car with such a car plate is not registered.";
	private String errorMessage;

	DublicateCarException(String errorMessage, Throwable t) {
		this.errorMessage = errorMessage;
		System.err.println(errorMessage);
	}
}
