package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
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

	private ValidationObject validation;

	// Funcion que valida el texto
	private Function<String, ValidationObject> validationFunc;

	// Funcion que determina como se ejecetura la validacion
	private Runnable executeValidation;

	// El JLabel que mostrar los errores
	private JLabel errorLabel;

	private void init() {
		// Predeterminadamente se muestra el error JLabel y cambia el borde
		// del boton a rojo
		this.executeValidation = () -> {
			validation = validationFunc.apply(getText());

			if (!validation.isValid()) {
				setBorder(new LineBorder(Color.RED, 1, false));
				errorLabel.setToolTipText(validation.getErrorMessage());
				errorLabel.setVisible(true);
			} else {
				setBorder(new LineBorder(Color.GREEN, 1, false));
				errorLabel.setVisible(false);
			}
		};

		// Que ejecute la accion de validar luego de 500ms de que el usuario
		// no haya escrito en el JTextField
		DocListener listener = new DocListener(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeValidation.run();
			}
		});

		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listener.stop();
				executeValidation.run();
			}

			@Override
			public void focusGained(FocusEvent e) {
				listener.start();
			}
		});

		this.getDocument().addDocumentListener(listener);
	}

	// Inicializa el VTextBox sin ningun valor predeterminado
	public VTextBox() {
		super();
	}

	public VTextBox(Function<String, ValidationObject> validationFunc, boolean showIcon, Icon icon) {
		super();
		init();

		this.validationFunc = validationFunc;

		// Si el se quiere mostrar el JLabel
		if (showIcon) {
			// Inicializo el Icon y el JLabel
			this.errorLabel = new JLabel();
			this.errorLabel.setIcon(icon);
			this.errorLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, validation.getErrorMessage(), "Error de validacion en el campo",
							JOptionPane.ERROR_MESSAGE);
				}
			});
			this.errorLabel.setVisible(false);

			this.addHierarchyListener(new HierarchyListener() {

				// Cuando cambie el comonente padre (osea que ya haya sido agregado
				// al panel le digo que agregue el Label al panel)
				public void hierarchyChanged(HierarchyEvent e) {

					// Si tiene el padre que agregue el label
					if (e.getChangedParent() != null) {

						errorLabel.setBounds(getX() + getWidth() + 5, getY(), 20, 20);
						e.getChangedParent().add(errorLabel);
					}
				}
			});
		}
	}

	public VTextBox(Function<String, ValidationObject> validationFunc) {
		this(validationFunc, true, new ImageIcon(VTextBox.class.getResource("/components/error.png")));
		this.validationFunc = validationFunc;
	}

	//
	// Metodos
	//

	// Ejecuta la validationFunc y asigna los campos a "contentValid" y a
	// "errorMessage"
	public void setVaidationsFileds() {
		validation = validationFunc.apply(getText());
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
		return validation.getErrorMessage();
	}

	public boolean isContentValid() {
		return validation.isValid();
	}
}
