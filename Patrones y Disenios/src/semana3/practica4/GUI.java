package semana3.practica4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import semana3.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSegNombre;
	private JTextField txtApellido;
	private JTextField txtSegApellido;
	private JSpinner spDocumento;

	public GUI() {
		setTitle("CRUD Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Documento:");
		lblNewLabel.setBounds(12, 14, 87, 17);
		contentPane.add(lblNewLabel);
		
		
		//
		// Cargar persona desde la Base de Datos
		//
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Realizo la busqueda
					Persona p = PersonaDAO.findByDocumento((Long) spDocumento.getValue());
					
					// Si la persona es Null sigmifica que no se encontro
					if (p == null) {
						JOptionPane.showMessageDialog(null, "No existe persona con ese documento", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Si se encontro cargo los TextBoxes con los datos
					txtNombre.setText(p.getNombre());
					txtSegNombre.setText(p.getSegNombre());
					txtApellido.setText(p.getApellido());
					txtSegApellido.setText(p.getSegApellido());
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Ocurrio un erro al dar de alta a la persona: " + e1.getMessage(), "Error con la BD",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(330, 10, 134, 24);
		contentPane.add(btnBuscar);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(104, 43, 360, 24);
		contentPane.add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 45, 87, 17);
		contentPane.add(lblNombre);

		txtSegNombre = new JTextField();
		txtSegNombre.setColumns(10);
		txtSegNombre.setBounds(104, 79, 360, 24);
		contentPane.add(txtSegNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Seg. Nombre:");
		lblNewLabel_1_1.setBounds(12, 81, 87, 17);
		contentPane.add(lblNewLabel_1_1);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(104, 115, 360, 24);
		contentPane.add(txtApellido);

		JLabel lblNewLabel_1_2 = new JLabel("Apellido: ");
		lblNewLabel_1_2.setBounds(12, 117, 87, 17);
		contentPane.add(lblNewLabel_1_2);

		txtSegApellido = new JTextField();
		txtSegApellido.setColumns(10);
		txtSegApellido.setBounds(104, 151, 360, 24);
		contentPane.add(txtSegApellido);

		JLabel lblNewLabel_1_3 = new JLabel("Seg. Apellido:");
		lblNewLabel_1_3.setBounds(12, 153, 87, 17);
		contentPane.add(lblNewLabel_1_3);
		
		//
		// Insertar persona en la Base de datos
		//
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					// Verifico que la persona no exista
					Persona bd = PersonaDAO.findByDocumento((Long) spDocumento.getValue());
					if (bd != null) {
						JOptionPane.showMessageDialog(null, "Ya existe una persona con ese documento", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// Creo el Objeto persona que voy a insertar
					Persona p = new Persona();
					p.setDocumento((Long) spDocumento.getValue());
					p.setNombre(txtNombre.getText());
					p.setSegNombre(txtSegNombre.getText());
					p.setApellido(txtApellido.getText());
					p.setSegApellido(txtSegApellido.getText());
					
					// Inserto la Persona
					if (PersonaDAO.save(p) > 0) {
						JOptionPane.showMessageDialog(null, "La persona creada con exito", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La persona no se pudo crear en la base de datos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error al crear la persona: " + e1.getMessage(),
							"Error con la BD", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInsertar.setBounds(12, 184, 142, 24);
		contentPane.add(btnInsertar);
		
		//
		// Borrar persona de la base de datos
		//
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Verifico que la persona exista
					Persona bd = PersonaDAO.findByDocumento((Long) spDocumento.getValue());
					if (bd == null) {
						JOptionPane.showMessageDialog(null, "No existe una persona con ese documento", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// Si existe la borro
					if (PersonaDAO.delete(bd.getId())) {
						JOptionPane.showMessageDialog(null, "La persona borrada con exito", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La persona no se pudo borrar en la base de datos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error al borrar la persona: " + e1.getMessage(),
							"Error con la BD", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBorrar.setBounds(320, 184, 144, 24);
		contentPane.add(btnBorrar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Verifico que la persona exista
					Persona bd = PersonaDAO.findByDocumento((Long) spDocumento.getValue());
					if (bd == null) {
						JOptionPane.showMessageDialog(null, "No existe una persona con ese documento", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					// Cargo los nuevos datos de la persona
					Persona p = new Persona();
					p.setDocumento((Long) spDocumento.getValue());
					p.setNombre(txtNombre.getText());
					p.setSegNombre(txtSegNombre.getText());
					p.setApellido(txtApellido.getText());
					p.setSegApellido(txtSegApellido.getText());
					
					// Y la modifico
					if (PersonaDAO.edit(bd.getId(), p)) {
						JOptionPane.showMessageDialog(null, "La persona modificada con exito", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La persona no se pudo modificar en la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar  la persona: " + e1.getMessage(),
							"Error con la BD", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setBounds(166, 184, 142, 24);
		contentPane.add(btnModificar);

		spDocumento = new JSpinner();
		spDocumento.setModel(new SpinnerNumberModel(new Long(0), new Long(0), null, new Long(1)));
		spDocumento.setBounds(105, 12, 213, 22);
		contentPane.add(spDocumento);

		//
		// Mostrar todas las personas
		//
		JButton btnConsultar = new JButton("Msotrar todas las personas");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Realizo la consulta
					ResultSet rs = PersonaDAO.returnAll();
					
					// Obtengo la meta data de la consulta
					ResultSetMetaData data = rs.getMetaData();
					
					// Creo un nuevo modelo (haciendolo no editable)
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false; // Hago todas las celdas no editables
						}
					};
				
					int colums = data.getColumnCount();
					
					// Agrego las columnas de la consulta en la JTable
					for (int i = 1; i <= colums; i++) {
						model.addColumn(data.getColumnName(i));
					}

					while (rs.next()) {
						List<Object> persona = new LinkedList<>();
						
						// Cargo los datos de cada fila en el lista
						for (int i = 1; i <= colums; i++) {
							persona.add(rs.getObject(i));
						}
						
						// Y la agrego lista a como fila en la JTable
						model.addRow(persona.toArray());
					}
					
					// Envuelvo la tabla en un JScrollPane
					JScrollPane panel = new JScrollPane(new JTable(model));
					
					// Y la muestro
					JOptionPane.showMessageDialog(null, panel, "Lista de personas", JOptionPane.INFORMATION_MESSAGE);
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Ocurrio un error al consultar las personas: " + e1.getMessage(), "Error con la BD",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConsultar.setBounds(12, 220, 452, 24);
		contentPane.add(btnConsultar);
	}
}
