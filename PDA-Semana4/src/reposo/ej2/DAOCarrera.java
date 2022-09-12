package reposo.ej2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import reposo.ConexionBD;

public class DAOCarrera {

	private static final String INSERT_CARRERA = "INSERT INTO carrera (nombre,id_universidad) VALUES(?,?)";
	private static final String UPDATE_CARRERA = "UPDATE carrera SET nombre = ?, id_universidad = ? WHERE id_carrera = ?";
	private static final String SELECT_CARRERA = "SELECT id_carrera, nombre, id_universidad FROM carrera";
	private static final String FIND_BY_ID_CARRERA = "SELECT id_carrera, nombre, id_universidad FROM carrera WHERE id_carrera = ?";
	private static final String FIND_BY_NOMBRE = "SELECT id_carrera, nombre, id_universidad FROM carrera WHERE nombre = ?";
	private static final String DELETE_CARRERA = "DELETE FROM carrera WHERE id_carrera = ?";
	
	public static List<Carrera> findAll() throws SQLException {
		Statement s = ConexionBD.getConnection().createStatement();
		ResultSet rs = s.executeQuery(SELECT_CARRERA);
		
		List<Carrera> carreras = new LinkedList<>();
		while(rs.next()) {
			Carrera c = new Carrera();
			c.setId(rs.getLong(1));
			c.setNombre(rs.getString(2));
			c.setUniversidad(DAOUniversidad.findById(rs.getLong(3)));
			carreras.add(c);
		}
		
		return carreras;
 	}

	public static ResultSet findAllResultSet() throws SQLException {
		Statement s = ConexionBD.getConnection().createStatement();
		return s.executeQuery(SELECT_CARRERA);
 	}
	
	public static Carrera findByNombre(String nombre) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(FIND_BY_NOMBRE);
		ps.setString(1, nombre);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Carrera c = new Carrera();
			c.setId(rs.getLong(1));
			c.setNombre(rs.getString(2));
			return c;
		}else {
			return null;
		}
	}
	
	public static Carrera findById(Long id) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(FIND_BY_ID_CARRERA);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Carrera c = new Carrera();
			c.setId(rs.getLong(1));
			c.setNombre(rs.getString(2));
			return c;
		}else {
			return null;
		}
	}
	
	public static boolean insert(Carrera c) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(INSERT_CARRERA);
		ps.setString(1, c.getNombre());
		ps.setLong(2, c.getUniversidad().getId());
		return ps.executeUpdate() > 0;
	}

	public static boolean update(Long id, Carrera c) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(UPDATE_CARRERA);
		ps.setString(1, c.getNombre());
		ps.setLong(2, c.getUniversidad().getId());
		ps.setLong(3, id);
		return ps.executeUpdate() > 0;
	}
	
	public static boolean delete(Long id) throws SQLException {
		PreparedStatement ps = ConexionBD.getConnection().prepareStatement(DELETE_CARRERA);
		ps.setLong(1, id);
		return ps.executeUpdate() > 0;
	}
}
