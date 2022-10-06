package reposo.ej2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import reposo.ConexionBD;

public class DAOUniversidad {
	private static final String INSERT_UNIVERSIDAD= "INSERT INTO universidad (nombre, ubicacion) VALUES(?,?)";
	private static final String UPDATE_UNIVERSIDAD = "UPDATE universidad SET nombre = ?, ubicacion = ? WHERE id_universidad = ?";
	private static final String SELECT_UNIVERSIDAD = "SELECT id_universidad , nombre, ubicacion FROM universidad";
	private static final String FIND_BY_ID = "SELECT id_universidad , nombre, ubicacion FROM universidad WHERE id_universidad = ?";
	private static final String FIND_BY_NOMBRE = "SELECT id_universidad , nombre, ubicacion FROM universidad WHERE nombre = ?";
	private static final String DELETE_UNIVERSIDAD = "DELETE FROM universidad WHERE id_universidad = ?";
	
	public static List<Universidad> findAll() throws SQLException {
		Statement s = ConexionBD.getConnection().createStatement();
		ResultSet rs = s.executeQuery(SELECT_UNIVERSIDAD);
		
		List<Universidad> universidades = new LinkedList<>();
		while(rs.next()) {
			Universidad u = new Universidad();
			u.setId(rs.getLong(1));
			u.setNombre(rs.getString(2));
			u.setUbicacion(rs.getString(3));
			universidades.add(u);
		}
		
		return universidades;
 	}

	public static ResultSet findAllResultSet() throws SQLException {
		Statement s = ConexionBD.getConnection().createStatement();
		return s.executeQuery(SELECT_UNIVERSIDAD);
 	}
	
	public static Universidad findByNombre(String nombre) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(FIND_BY_NOMBRE);
		ps.setString(1, nombre);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Universidad u = new Universidad();
			u.setId(rs.getLong(1));
			u.setNombre(rs.getString(2));
			u.setUbicacion(rs.getString(3));
			return u;
		}else {
			return null;
		}
	}
	
	public static Universidad findById(Long id) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(FIND_BY_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Universidad u = new Universidad();
			u.setId(rs.getLong(1));
			u.setNombre(rs.getString(2));
			u.setUbicacion(rs.getString(3));
			return u;
		}else {
			return null;
		}
	}
	
	public static boolean insert(Universidad u) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(INSERT_UNIVERSIDAD);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getUbicacion());
		return ps.executeUpdate() > 0;
	}

	public static boolean update(Long id, Universidad u) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(UPDATE_UNIVERSIDAD);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getUbicacion());
		ps.setLong(3, id);
		return ps.executeUpdate() > 0;
	}
	
	public static boolean delete(Long id) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(DELETE_UNIVERSIDAD);
		ps.setLong(1, id);
		return ps.executeUpdate() > 0;
	}
}
