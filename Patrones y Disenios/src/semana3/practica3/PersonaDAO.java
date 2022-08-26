package semana3.practica3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import semana3.ConexionBD;
import semana3.Persona;

public class PersonaDAO {
	
	private static final String CONTAR_PERSONAS = "SELECT count(*) FROM persona";
	private static final String ALL_PERSONAS = "SELECT * FROM persona";
	private static final String SAVE_PERSONA = "INSERT INTO persona (id_persona, documento, nombre, seg_nombre, apellido, seg_apellido) VALUES (?,?,?,?,?,?)";
	
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
	
	public static void save(Persona p) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(SAVE_PERSONA);
		ps.setLong(1, 1002);
		ps.setLong(2, p.getDocumento());
		ps.setString(3, p.getNombre());
		ps.setString(4, p.getSegNombre());
		ps.setString(5, p.getApellido());
		ps.setString(6, p.getSegApellido());
		ps.executeUpdate();
	}
}
