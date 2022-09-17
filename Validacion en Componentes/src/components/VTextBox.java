package components;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class VTextBox extends JTextField {

	// Variables que indica si el contenido es valido o no
	// Y cual es el mensaje de error
	private boolean contentValid;
	private String errorMessage;

	// Funcion que valida el texto
	private Function<String, ValidationObject> validationFunc;

	// Funcion que determina como se ejecetura la validacion
	private Runnable executeValidation;

	// El JLabel que mostrar los errores
	private JLabel errorLabel;

	private void initialize() {
		// Innicializo el Icon y el JLabel
		this.errorLabel = new JLabel();
		this.errorLabel.setIcon(new ImageIcon(VTextBox.class.getResource("/components/error.png")));
		this.errorLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, errorMessage, "Error de validacion en el campo",
						JOptionPane.ERROR_MESSAGE);
			}
		});
		this.errorLabel.setVisible(false);

		// Validacion predeterminada es Campo vacio
		this.contentValid = false;
		this.validationFunc = t -> {
			return !t.isBlank() ? new ValidationObject() : new ValidationObject("El campo no puede estar vacio");
		};

		// Validacion predeterminada es que muestre el error JLabel y cambie el borde
		// del boton
		this.executeValidation = () -> {
			executeValidationFunc();

			if (!contentValid) {
				setBorder(new LineBorder(Color.RED, 1, false));
				errorLabel.setToolTipText(errorMessage);
				errorLabel.setVisible(true);
			} else {
				setBorder(null);
				errorLabel.setVisible(false);
			}
		};

		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				executeValidation.run();
			}
		});
	}

	public VTextBox(boolean validOnType) {
		super();
		initialize();

		if (validOnType) {
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					executeValidation.run();
				}
			});
		}
	}

	// Ejecuta la validationFunc y asigna los campos a "contentValid" y a
	// "errorMessage"
	public void executeValidationFunc() {
		ValidationObject validation = validationFunc.apply(getText());
		contentValid = validation.isValid();
		errorMessage = validation.getErrorMessage();
	}

	//
	// Getters y Setters
	//

	// Abreviacion de getErrorLabel().getIcon()
	public Icon getErrorIcon() {
		return errorLabel.getIcon();
	}

	// Abreviacion de getErrorLabel().setIcon()
	public void setErrorIcon(Icon errorIcon) {
		errorLabel.setIcon(errorIcon);
	}

	public Runnable getExecuteValidation() {
		return executeValidation;
	}

	public void setExecuteValidation(Runnable executeValidation) {
		this.executeValidation = executeValidation;
	}

	public JLabel getErrorLabel() {
		// Antes de obtenerlo (para agregarlo al componente panel que contiene
		// el JTextField) que sette su ubicacion a 5 pixeles a la derecha de
		// JTextField
		this.errorLabel.setBounds(getX() + getWidth() + 5, getY(), 20, 20);
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	public Function<String, ValidationObject> getValidationFunc() {
		return validationFunc;
	}

	// El resultado de la funcion determina si el contenido es o no es valido y el
	// mensaje de error correspondiente
	public void setValidationFunc(Function<String, ValidationObject> validation) {
		this.validationFunc = validation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isContentValid() {
		return contentValid;
	}
}
