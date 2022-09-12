package practica2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import compartido.ConexionBD;
import compartido.Persona;

public class PersonaDAO {
	private static final String CONTAR_PERSONAS = "SELECT count(*) FROM persona";
	private static final String ALL_PERSONAS = "SELECT * FROM persona";

	public static int countAll() throws SQLException {
		Statement stmt = ConexionBD.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(CONTAR_PERSONAS);
		return rs.next() ? rs.getInt(1) : 0;
	}

	public static List<Persona> findAll() throws SQLException {
		Statement stmt = ConexionBD.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(ALL_PERSONAS);

		List<Persona> list = new LinkedList<>();
		while (rs.next()) {
			Persona p = new Persona();
			p.setDocumento(rs.getLong(2));
			p.setNombre(rs.getString(3));
			p.setSegNombre(rs.getString(4));
			p.setApellido(rs.getString(5));
			p.setSegApellido(rs.getString(6));
			list.add(p);
		}

		return list;
	}
	
	public static ResultSet returnAll() throws SQLException {
		Statement stmt = ConexionBD.getConnection().createStatement();
		return stmt.executeQuery(ALL_PERSONAS);
	}

}
