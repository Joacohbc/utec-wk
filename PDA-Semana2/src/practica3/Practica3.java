package practica3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Practica3 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConexionBD.getConnection();

			String sql = "INSERT INTO persona "
					+ "(id_persona, documento, nombre, seg_nombre, apellido, seg_apellido) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, 300);
			ps.setString(2, "12345678911");
			ps.setString(3, "Alberta");
			ps.setString(4, "Joaquina");
			ps.setString(5, "Alvarez");
			ps.setString(6, "Perez");

			ps.executeUpdate();

			sql = "SELECT nombre, apellido FROM persona ORDER BY nombre, apellido";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("- Nombre: " + rs.getString(1));
				System.out.println("- Apellido: " + rs.getString(2));
				System.out.println("--------------------------------");
			}
		} catch (Exception e) {
			System.out.println("> Error: No se pudo ejecutar la sentencia INSERT");
			e.printStackTrace();

		}
	}
}
