package practica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Practica2 {
	private static final String URL_ORACLE = "jdbc:oracle:thin:@192.168.0.250:1521:xe";
	private static final String USER = "utec";
	private static final String PASSWORD = "utec";

	// Metodo para cerrar la Conexion,(para hacer mas clean el Finally)
	public static void Close(Object obj) {
		try {
			if (obj == null) {
				return;
			}

			if (obj instanceof Connection) {
				Connection conn = ((Connection) obj);
				if (!conn.isClosed())
					conn.close();
			} else if (obj instanceof PreparedStatement) {
				PreparedStatement ps = ((PreparedStatement) obj);
				if (!ps.isClosed())
					ps.close();
			} else if (obj instanceof ResultSet) {
				ResultSet rs = ((ResultSet) obj);
				if (!rs.isClosed())
					rs.close();
			} else if (obj instanceof Statement) {
				Statement s = ((Statement) obj);
				if (!s.isClosed())
					s.close();
			}

		} catch (Exception e) {
			System.out.println("> Error: al cerrar el objeto");
			e.printStackTrace();
		}
	}

	// Metodo para obtener la conexion
	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		// Verifico qu este el driver la conexion a Oracle
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
	}

	public static void main(String[] args) {
		String idPersonaST = JOptionPane.showInputDialog("Id: ");
		Integer idPersona; // Integer es el tipo wrapper del tipo nativo int
		idPersona = Integer.parseInt(idPersonaST);

		String documento = JOptionPane.showInputDialog("Documento: ");
		String apellido1 = JOptionPane.showInputDialog("Apellido1: ");
		String apellido2 = JOptionPane.showInputDialog("Apellido2: ");
		String nombre1 = JOptionPane.showInputDialog("Nombre1: ");
		String nombre2 = JOptionPane.showInputDialog("Nombre2: ");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			
			// Ingresare a Joaquin Genova
			String sql = "INSERT INTO persona "
					+ "(id_persona, documento, nombre, seg_nombre, apellido, seg_apellido) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, idPersona);
			ps.setString(2, documento);
			ps.setString(3, nombre1);
			ps.setString(4, nombre2);
			ps.setString(5, apellido1);
			ps.setString(6, apellido2);
			ps.executeUpdate();
			Close(ps);
			
			sql = "SELECT nombre, apellido FROM persona ORDER BY nombre, apellido";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
                System.out.println("- Nombre: " + rs.getString(1));
                System.out.println("- Apellido: " + rs.getString(2));
                System.out.println("--------------------------------");
			}

		} catch (Exception e) {
			System.out.println("> Error: No se pudo ejecutar la sentencia INSERT");
			e.printStackTrace();

		} finally {
			Close(conn);
			Close(ps);
			Close(rs);
		}
	}
}
