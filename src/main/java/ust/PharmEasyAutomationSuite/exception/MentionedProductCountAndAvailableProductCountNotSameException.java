package ust.PharmEasyAutomationSuite.exception;

public class MentionedProductCountAndAvailableProductCountNotSameException extends Exception {
	public MentionedProductCountAndAvailableProductCountNotSameException() {
		super("The mentioned product count and available product count are not the same.");
	}

	public MentionedProductCountAndAvailableProductCountNotSameException(String message) {
		super(message);
	}

	public MentionedProductCountAndAvailableProductCountNotSameException(String message, Throwable cause) {
		super(message, cause);
	}

	public MentionedProductCountAndAvailableProductCountNotSameException(Throwable cause) {
		super(cause);
	}

}
