package semana3.practica2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
	public static void main(String[] args) {
		try {
			
			System.out.println(PersonaDAO.findAll());
			ResultSet rs = PersonaDAO.returnAll();
			ResultSetMetaData data = rs.getMetaData();

			DefaultTableModel model = new DefaultTableModel();
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
			
			JScrollPane panel = new JScrollPane(new JTable(model));
			JOptionPane.showMessageDialog(null, panel, "Lista de perosnas", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
