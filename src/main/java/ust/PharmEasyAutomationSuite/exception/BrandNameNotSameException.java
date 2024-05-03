package ust.PharmEasyAutomationSuite.exception;

public class BrandNameNotSameException extends Exception {
	public BrandNameNotSameException() {
		super("Selected brand name products are not displayed.");
	}

	public BrandNameNotSameException(String message) {
		super(message);
	}

	public BrandNameNotSameException(String message, Throwable cause) {
		super(message, cause);
	}

	public BrandNameNotSameException(Throwable cause) {
		super(cause);
	}

}
