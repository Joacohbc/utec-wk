package components.vtextbox.builders;

import javax.swing.ImageIcon;

import components.ValidationObject;
import components.vtextbox.VTextBox;
import validation.Validaciones;

public class VTBOnlyText {

	public static VTextBox get() {
		VTextBox vtb = new VTextBox(null);

		vtb.setValidationFunc(text -> {
			if (!Validaciones.ValidarLargo(text, 20)) {
				return new ValidationObject(
						"El campo es obligaotrio (no puede ser vacio) y debe tener un maximo de 20");
			}

			if (!Validaciones.ValidarSoloLetras(text, true)) {
				return new ValidationObject("El campo solo puede contener letras y espacios");
			}

			return ValidationObject.VALID;
		});

		vtb.setErrorIcon(new ImageIcon(VTBOnlyText.class.getResource("/components/error2.png")));
		return vtb;
	}
}
