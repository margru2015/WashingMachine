package app;

public class TempException extends Exception {
	
	public TempException() {
		super("Temperatura spoza zakresu!");
	}
	
	public TempException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "TempException: " + super.getMessage();
	}
	
}