package prueba.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import prueba.DatabaseManager;

public class DAOProductor {

	// Aca tenemos el alta, buscar productor x id y listar todos los productores

	private static final String INSERT_PRODUCTOR = "INSERT INTO PRODUCTORES (ID_PROD, NOMBRE, TELEFONO) values (?,?, ?)";
	private static final String ALL_PRODUCTORES = "SELECT * FROM PRODUCTORES ORDER BY id_prod";
	private static final String BUSCAR_PRODUCTOR = "SELECT * FROM PRODUCTORES WHERE ID_PROD=?";
	private static final String BORRAR_TODO = "DELETE FROM PRODUCTORES";

	// Inserta un Productor pasado por par�metro

	public static boolean insert(Productor p) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PRODUCTOR);
			statement.setInt(1, p.getId());
			statement.setString(2, p.getNombre());
			statement.setString(3, p.getTelefono());
			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	// Fin de insert Productor

	// Obtiene todos los Productores ingresados
	public static LinkedList<Productor> findAll() {
		var lista_prod = new LinkedList<Productor>();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PRODUCTORES);

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				Productor prod = getProductorFromResultSet(resultado);
				lista_prod.add(prod);
			}
			return lista_prod;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	// Fin de listar todos los Productores

	// Borrar todos los Productores

	public static boolean eliminarTodo() {
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(BORRAR_TODO);

			sentencia.executeUpdate(); // Ejecutar esa consulta SQL y borra todos los Productores
			sentencia.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Buscar Prodcutor por ID_PROD

	// Buscar un Productor por ID
	public static Productor buscarProductor(int id) {
		ResultSet resultado = null;
		Productor resp = null;
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(BUSCAR_PRODUCTOR);
			sentencia.setInt(1, id);
			resultado = sentencia.executeQuery(); // Ejecutar esa consulta SQL y devuelve la lista en �sta variable de
													// nombre resultado.
			while (resultado.next()) {
				resp = getProductorFromResultSet(resultado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
	}

	// getProductorFromResultSet --- Decodifica lo de la BD --> instancia Productor
	private static Productor getProductorFromResultSet(ResultSet resultado) throws SQLException {

		int id = resultado.getInt("ID_PROD");
		String nombre = resultado.getString("NOMBRE");
		String tel = resultado.getString("TELEFONO");

		Productor p = new Productor(id, nombre, tel);

		return p;
	}

}
