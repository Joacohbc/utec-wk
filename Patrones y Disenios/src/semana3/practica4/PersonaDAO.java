package semana3.practica4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import semana3.ConexionBD;
import semana3.Persona;

public class PersonaDAO {
	private static final String COUNT_PERSONAS = "SELECT count(*) FROM persona";
	private static final String ALL_PERSONAS = "SELECT * FROM persona";
	private static final String FIND_PERSONA_BY_DOCUMENTO = "SELECT * FROM persona WHERE documento = ?";
	private static final String BUCAR_PERSONA = "SELECT * FROM persona WHERE nombre = ? AND apellido = ?";
	private static final String SAVE_PERSONA = "INSERT INTO persona (documento, nombre, seg_nombre, apellido, seg_apellido) VALUES (?,?,?,?,?)";
	private static final String UPDATE_PERSONA = "UPDATE persona SET nombre = ?, seg_nombre = ?, apellido = ?, seg_apellido = ? WHERE id_persona = ?";
	private static final String DELETE_PERSONA = "DELETE FROM persona WHERE id_persona = ?";

	// Consultas
	public static int countAll() throws SQLException {
		Statement stmt = ConexionBD.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(COUNT_PERSONAS);
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
	
	public static Persona findByDocumento(Long documento) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(FIND_PERSONA_BY_DOCUMENTO);
		ps.setLong(1, documento);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Persona p = new Persona();
			p.setId(rs.getLong(1));
			p.setDocumento(rs.getLong(2));
			p.setNombre(rs.getString(3));
			p.setSegNombre(rs.getString(4));
			p.setApellido(rs.getString(5));
			p.setSegApellido(rs.getString(6));
			return p;
		}else {
			return null;
		}
	}
	
	public static Persona findPersona(String nombre, String apellido) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(BUCAR_PERSONA);
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Persona p = new Persona();
			p.setId(rs.getLong(1));
			p.setDocumento(rs.getLong(2));
			p.setNombre(rs.getString(3));
			p.setSegNombre(rs.getString(4));
			p.setApellido(rs.getString(5));
			p.setSegApellido(rs.getString(6));
			return p;
		}else {
			return null;
		}
	}

	public static ResultSet returnAll() throws SQLException {
		Statement stmt = ConexionBD.getConnection().createStatement();
		return stmt.executeQuery(ALL_PERSONAS);
	}

	// Inserts, Update y Delete
	public static int save(Persona p) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(SAVE_PERSONA);
		ps.setLong(1, p.getDocumento());
		ps.setString(2, p.getNombre());
		ps.setString(3, p.getSegNombre());
		ps.setString(4, p.getApellido());
		ps.setString(5, p.getSegApellido());
		return ps.executeUpdate();
	}

	public static boolean edit(Long id, Persona p) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(UPDATE_PERSONA);
		ps.setString(1, p.getNombre());
		ps.setString(2, p.getSegNombre());
		ps.setString(3, p.getApellido());
		ps.setString(4, p.getSegApellido());
		ps.setLong(5, id);
		return ps.executeUpdate() > 0;
	}

	public static boolean delete(Long id) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(DELETE_PERSONA);
		ps.setLong(1, id);
		return ps.executeUpdate() > 0;
	}

}
