package prueba.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import prueba.DatabaseManager;

public class DAOAnimal {

	private static final String FIND_ALL = "SELECT * FROM animales ORDER BY id";
	private static final String FIND_BY_ID = "SELECT * FROM animales WHERE id = ?";
	private static final String INSERT = "INSERT INTO animales VALUES(?,?,?,?)";
	private static final String UPDATE = "UPDATE animales SET descripcion = ?, categoria = ?, id_prod = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM animales WHERE id = ?";
	private static final String DELETE_ALL = "DELETE FROM animales";

	public static List<Animal> findAll() throws SQLException {
		Statement s = DatabaseManager.getConnection().createStatement();
		ResultSet rs = s.executeQuery(FIND_ALL);

		List<Animal> lista = new LinkedList<>();
		while (rs.next()) {
			lista.add(getFromResultSet(rs));
		}

		return lista;
	}

	public static Animal buscarAnimal(int id) throws SQLException {
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(FIND_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return getFromResultSet(rs);
		} else {
			return null;
		}
	}

	public static boolean insert(Animal c) throws SQLException {
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(INSERT);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getDescripcion());
		ps.setString(3, c.getCategoria().name());
		ps.setInt(4, c.getProductor().getId());
		return ps.executeUpdate() > 0;
	}

	public static boolean update(int id, Animal c) throws SQLException {
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(UPDATE);
		ps.setInt(4, id);
		ps.setString(1, c.getDescripcion());
		ps.setString(2, c.getCategoria().name());
		ps.setInt(3, c.getProductor().getId());
		return ps.executeUpdate() > 0;
	}

	public static boolean delete(int id) throws SQLException {
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(DELETE);
		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}

	public static boolean eliminarTodo() throws SQLException {
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(DELETE_ALL);
		return ps.executeUpdate() > 0;
	}
	
	private static Animal getFromResultSet(ResultSet rs) throws SQLException {
		Animal obj = new Animal();
		obj.setId(rs.getInt(1));
		obj.setDescripcion(rs.getString(2));
		obj.setCategoria(Categoria.valueOf(rs.getString(3)));
		obj.setProductor(DAOProductor.buscarProductor(rs.getInt(4)));
		return obj;
	}
}
