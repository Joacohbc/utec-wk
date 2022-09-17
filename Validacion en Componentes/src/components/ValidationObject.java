package components;

public class ValidationObject {

	public static final ValidationObject IS_VALID = new ValidationObject();

	private boolean valid;
	private String errorMessage;

	// Constructor de caso Invalido
	public ValidationObject(String errorMessage) {
		super();
		this.valid = false;
		this.errorMessage = errorMessage;
	}

	// Constructor de caso Valido
	public ValidationObject() {
		super();
		this.valid = true;
		this.errorMessage = "";
	}

	public boolean isValid() {
		return valid;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
