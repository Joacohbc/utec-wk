package components.builders;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import components.ValidationObject;
import validation.Validaciones;

public class VTBBuilderOnlyText extends VTextBoxBuilder {

	public VTBBuilderOnlyText() {
		create();

		setValidationFunc(text -> {
			if (!Validaciones.ValidarLargo(text, 20)) {
				return new ValidationObject(
						"El campo es obligaotrio (no puede ser vacio) y debe tener un maximo de 20");
			}

			if (!Validaciones.ValidarSoloLetras(text, true)) {
				return new ValidationObject("El campo solo puede contener letras y espacios");
			}

			return ValidationObject.IS_VALID;
		});

		setExecuteValidation(() -> {
			textBox.executeValidationFunc();

			System.out.println(textBox.isContentValid());
			if (!textBox.isContentValid()) {
				textBox.setBorder(new LineBorder(Color.RED, 1, false));
				textBox.getErrorLabel().setToolTipText(textBox.getErrorMessage());
				textBox.getErrorLabel().setVisible(true);
				return;
			}

			textBox.setBorder(null);
			textBox.getErrorLabel().setVisible(false);
		});

		setErrorIcon(new ImageIcon(VTBBuilderOnlyText.class.getResource("/components/error2.png")));
	}
}
