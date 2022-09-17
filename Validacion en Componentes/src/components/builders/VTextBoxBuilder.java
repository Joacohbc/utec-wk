package components.builders;

import java.util.function.Function;

import javax.swing.Icon;
import javax.swing.JLabel;

import components.VTextBox;
import components.ValidationObject;

public abstract class VTextBoxBuilder {

	protected VTextBox textBox;

	protected void create() {
		textBox = new VTextBox(true);
	}

	protected void setExecuteValidation(Runnable executeValidation) {
		this.textBox.setExecuteValidation(executeValidation);
	}

	protected void setValidationFunc(Function<String, ValidationObject> validation) {
		this.textBox.setValidationFunc(validation);
	}

	public VTextBoxBuilder setErrorIcon(Icon errorIcon) {
		textBox.setErrorIcon(errorIcon);
		return this;
	}

	public VTextBoxBuilder setErrorLabel(JLabel errorLabel) {
		textBox.setErrorLabel(errorLabel);
		return this;
	}

	public VTextBox getResult() {
		return textBox;
	}

}
