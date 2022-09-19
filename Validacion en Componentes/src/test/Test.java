package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import components.ValidationObject;
import components.vtextbox.VTextBox;
import components.vtextbox.builders.VTBOnlyText;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Test extends JFrame {

	private JPanel contentPane;
	private VTextBox txtNombre;
	private JButton btnNewButton;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombre = VTBOnlyText.get();
		txtNombre.setBounds(170, 93, 114, 21);
		contentPane.add(txtNombre);
		contentPane.add(txtNombre.getErrorLabelWithBounds());

		btnNewButton = new JButton("Validar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNombre.isContentValid() && txtEdad.isContentValid() && txtNacimiento.isContentValid()) {
					JOptionPane.showMessageDialog(null, "Datos correcto", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Datos inccorrecto", "Fallo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(170, 188, 114, 27);
		contentPane.add(btnNewButton);

		txtEdad = new VTextBox(null);
		txtEdad.setBounds(170, 126, 114, 21);
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
		contentPane.add(txtEdad.getErrorLabelWithBounds());

		txtNacimiento = new VTextBox(null);
		txtNacimiento.setBounds(170, 155, 114, 21);
		txtNacimiento.setValidationFunc(text -> {
			try {
				LocalDate.parse(text);
				return ValidationObject.VALID;
			} catch (Exception e) {
				return new ValidationObject("La fecha de nacimiento debe estar en el formato YYYY-MM-DD");
			}
		});
		contentPane.add(txtNacimiento);
		contentPane.add(txtNacimiento.getErrorLabelWithBounds());
	}
}
