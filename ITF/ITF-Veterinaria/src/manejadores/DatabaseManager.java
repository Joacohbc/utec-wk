package manejadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@192.168.0.250:1521:xe";
	private static String USUARIO = "utec";
	private static String CLAVE = "utec";
	
	static{
		try {
			Locale.setDefault(new Locale("es","ES"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING,USUARIO,CLAVE);
		} catch (SQLException e) {
			System.out.println("Error creando la conexion a la base de datos");
		} 

	}
	
	public static Connection getConnection() {
		
		return databaseConnection;
		
	}

}


