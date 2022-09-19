package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import components.VTextBox;
import components.ValidationObject;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Test extends JFrame {

	private JPanel contentPane;
	private JButton btnValidar;
	private VTextBox txtEdad;
	private VTextBox txtNacimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txtEdad.isContentValid() && txtNacimiento.isContentValid()) {
					JOptionPane.showMessageDialog(null, "Datos correcto", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Datos inccorrecto", "Fallo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValidar.setBounds(180, 155, 114, 27);
		contentPane.add(btnValidar);

		txtEdad = new VTextBox(null);
		txtEdad.setBounds(180, 122, 114, 21);
		txtEdad.setValidationFunc(text -> {
			try {
				int edad = Integer.parseInt(text);
				if (edad < 0) {
					return new ValidationObject("Le edad debe ser un numero positivo");
				}
				return ValidationObject.VALID;
			} catch (Exception e) {
				return new ValidationObject("La edad es un campo numerico");
			}

		});
		contentPane.add(txtEdad);

		txtNacimiento = new VTextBox(null);
		txtNacimiento.setBounds(180, 59, 114, 21);
		txtNacimiento.setValidationFunc(text -> {
			try {
				LocalDate.parse(text);
				return ValidationObject.VALID;
			} catch (Exception e) {
				return new ValidationObject("La fecha de nacimiento debe estar en el formato YYYY-MM-DD");
			}
		});
		contentPane.add(txtNacimiento);

		VTextBox txtNombre = new VTextBox(null);
		txtNombre.setBounds(180, 89, 114, 21);
		txtNombre.setValidationFunc(
				t -> t.isBlank() ? new ValidationObject("El nombre no debe ser vacio") : ValidationObject.VALID);
		contentPane.add(txtNombre);

	}
}
