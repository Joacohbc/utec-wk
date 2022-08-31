package semana4.reposo.ej1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import semana4.reposo.ConexionBD;

public class Main {

	public static void main(String[] args) {
		try {
			PreparedStatement ps = ConexionBD.getConnection().prepareStatement("SELECT COUNT(*) FROM carreras");
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("Cantidad de carreras: " + rs.getLong(1));
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
