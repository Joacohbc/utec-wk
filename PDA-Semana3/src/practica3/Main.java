package practica3;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import compartido.Persona;

public class Main {
	public static void main(String[] args) {
		try {
			Persona p = new Persona();
			p.setDocumento(Long.parseLong(JOptionPane.showInputDialog("Documento: ")));
			p.setNombre(JOptionPane.showInputDialog("Nombre: "));
			p.setSegNombre(JOptionPane.showInputDialog("Segundo Nombre: "));
			p.setApellido(JOptionPane.showInputDialog("Apellido: "));
			p.setSegApellido(JOptionPane.showInputDialog("Segundo Apellido: "));
			PersonaDAO.save(p);

			ResultSet rs = PersonaDAO.returnAll();
			ResultSetMetaData data = rs.getMetaData();

			DefaultTableModel model = new DefaultTableModel() {
				   @Override
				    public boolean isCellEditable(int row, int column) {
				       return false; // Hago todas las celdas no editables
				    }
			};
			
			int colums = data.getColumnCount();
			for (int i = 1; i <= colums; i++) {
				model.addColumn(data.getColumnName(i));
			}

			while (rs.next()) {
				List<Object> persona = new LinkedList<>();
				for (int i = 1; i <= colums; i++) {
					persona.add(rs.getObject(i));
				}
				model.addRow(persona.toArray());
			}
			
			JTable table = new JTable(model);
			JScrollPane panel = new JScrollPane(table);
			JOptionPane.showMessageDialog(null, panel, "Lista de personas", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El Documento debe ser un numero", "Error de ingreso",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
