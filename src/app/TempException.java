package app;

public class TempException extends Exception {
	
	public TempException() {
		super("Temperatura spoza zakresu!");
	}
	
	@Override
	public String getMessage() {
		return "TempException: " + super.getMessage();
	}
	
}