package semana4.reposo.ej2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUni;
	private JTextField txtUbicacionUni;
	private JComboBox<Universidad> cmbUniversidad;
	private JTextField txtNombreCarr;
	private JComboBox<Carrera> cmbCarreras;
	private JComboBox<Universidad> cmbUniCarrAlta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel pCarreras = new JPanel();
		tabbedPane.addTab("Carreras", null, pCarreras, null);
		pCarreras.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(12, 14, 60, 17);
		pCarreras.add(lblNewLabel_1);
		
		txtNombreCarr = new JTextField();
		txtNombreCarr.setColumns(10);
		txtNombreCarr.setBounds(90, 12, 325, 21);
		pCarreras.add(txtNombreCarr);
		
		JButton btnAltaCarr = new JButton("Alta");
		btnAltaCarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Carrera c = new Carrera();
					c.setNombre(txtNombreCarr.getText());
					c.setUniversidad((Universidad) cmbUniCarrAlta.getSelectedItem());
					DAOCarrera.insert(c);
					recargarCarreras(cmbCarreras);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAltaCarr.setBounds(12, 78, 399, 27);
		pCarreras.add(btnAltaCarr);
		
		cmbCarreras = new JComboBox<Carrera>();
		cmbCarreras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				recargarCarreras(cmbCarreras);
			}
		});
		cmbCarreras.setBounds(12, 117, 399, 26);
		pCarreras.add(cmbCarreras);
		
		JButton btnBorrarCarr = new JButton("Borrar");
		btnBorrarCarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long id = ((Carrera) cmbCarreras.getSelectedItem()).getId();
					DAOCarrera.delete(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBorrarCarr.setBounds(12, 155, 200, 27);
		pCarreras.add(btnBorrarCarr);
		
		JButton btnModifCarr = new JButton("Modificar");
		btnModifCarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Carrera c = new Carrera();
					c.setNombre(txtNombreCarr.getText());
					c.setUniversidad((Universidad) cmbUniCarrAlta.getSelectedItem());
					long id = ((Carrera) cmbCarreras.getSelectedItem()).getId();
					DAOCarrera.update(id, c);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModifCarr.setBounds(224, 155, 187, 27);
		pCarreras.add(btnModifCarr);
		
		JButton btnListarCarr = new JButton("Listar");
		btnListarCarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Carrera> list = DAOCarrera.findAll();
					
					// Creo un nuevo modelo (haciendolo no editable)
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false; // Hago todas las celdas no editables
						}
					};
					
					String[] titulos = {"Id", "Nombre", "Universidad"};
					model.setColumnIdentifiers(titulos);
					
					for (Carrera c: list) {
						Object[] carrera = {
								c.getId(),
								c.getNombre(),
								c.getUniversidad().getNombre()
						};
						model.addRow(carrera);
					}
					// Envuelvo la tabla en un JScrollPane
					JScrollPane panel = new JScrollPane(new JTable(model));

					// Y la muestro
					JOptionPane.showMessageDialog(null, panel, "Lista de carreras", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnListarCarr.setBounds(12, 194, 399, 27);
		pCarreras.add(btnListarCarr);
		
		cmbUniCarrAlta = new JComboBox<Universidad>();
		cmbUniCarrAlta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				recargarUniversidades(cmbUniCarrAlta);
			}
		});
		cmbUniCarrAlta.setBounds(12, 43, 399, 26);
		pCarreras.add(cmbUniCarrAlta);

		JPanel pUniversidad = new JPanel();
		tabbedPane.addTab("Universidades", null, pUniversidad, null);
		pUniversidad.setLayout(null);

		txtNombreUni = new JTextField();
		txtNombreUni.setBounds(86, 12, 325, 21);
		pUniversidad.add(txtNombreUni);
		txtNombreUni.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(12, 14, 60, 17);
		pUniversidad.add(lblNewLabel);

		txtUbicacionUni = new JTextField();
		txtUbicacionUni.setColumns(10);
		txtUbicacionUni.setBounds(86, 45, 325, 21);
		pUniversidad.add(txtUbicacionUni);

		JLabel lblNombre = new JLabel("Ubicacion:");
		lblNombre.setBounds(12, 47, 76, 17);
		pUniversidad.add(lblNombre);

		JButton btnAltaUni = new JButton("Alta");
		btnAltaUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Universidad u = new Universidad();
				u.setNombre(txtNombreUni.getText());
				u.setUbicacion(txtUbicacionUni.getText());
				try {
					DAOUniversidad.insert(u);
					recargarUniversidades(cmbUniversidad);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAltaUni.setBounds(12, 78, 399, 27);
		pUniversidad.add(btnAltaUni);

		JButton btnModifUni = new JButton("Modificar");
		btnModifUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long id = ((Universidad) cmbUniversidad.getSelectedItem()).getId();
					Universidad u = new Universidad();
					u.setNombre(txtNombreUni.getText());
					u.setUbicacion(txtUbicacionUni.getText());
					DAOUniversidad.update(id, u);
					recargarUniversidades(cmbUniversidad);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModifUni.setBounds(224, 155, 187, 27);
		pUniversidad.add(btnModifUni);

		JButton btnBorrarUni = new JButton("Borrar");
		btnBorrarUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long id = ((Universidad) cmbUniversidad.getSelectedItem()).getId();
					DAOUniversidad.delete(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBorrarUni.setBounds(12, 155, 200, 27);
		pUniversidad.add(btnBorrarUni);

		cmbUniversidad = new JComboBox<Universidad>();
		cmbUniversidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				recargarUniversidades(cmbUniversidad);
			}
		});
		cmbUniversidad.setBounds(12, 117, 399, 26);
		pUniversidad.add(cmbUniversidad);

		JButton btnListarUni = new JButton("Listar");
		btnListarUni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ResultSet rs = DAOUniversidad.findAllResultSet();
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
					JOptionPane.showMessageDialog(null, panel, "Lista de carreras", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnListarUni.setBounds(12, 194, 399, 27);
		pUniversidad.add(btnListarUni);
	}

	private void recargarUniversidades(JComboBox<Universidad> cmb) {
		try {
			List<Universidad> list = DAOUniversidad.findAll();
			cmb.removeAllItems();
			for (Universidad universidad : list) {
				cmb.addItem(universidad);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void recargarCarreras(JComboBox<Carrera> cmb) {
		try {
			List<Carrera> list = DAOCarrera.findAll();
			cmb.removeAllItems();
			for (Carrera carrera : list) {
				cmb.addItem(carrera);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
