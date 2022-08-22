package semana1.conexionDB;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	/*
	 * Lo tenia todo en 3, clases, asi que quedo un poco disperso en solo una. Lo
	 * ordeno con comentarios
	 */

	// El main donde ejecuto las Querys
	public static void main(String[] args) {
		
		// Para cambiar la fecha de formato de la BD
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String insertSQL = "INSERT INTO persona VALUES (?, ?, ?, ?, ?, ?, ?)";

		Object[] values1 = { "0", 123456780, "Juan", "Pedro", "Garcia", "Morales", sdf.format(new Date()) };
		BDUtils.ExecuteDML(insertSQL, values1);

		Object[] values2 = { "1", 123456781, "Maria", "Paola", "Gonazales", "Rodriguez", "15/02/02" };
		BDUtils.ExecuteDML(insertSQL, values2);

		Object[] values3 = { "2", 123456782, "Martin", "Alvaro", "Carrera", "Silvera", "14/03/19" };
		BDUtils.ExecuteDML(insertSQL, values3);

		Object[] values4 = { "3", 123456783, "Dolores", "De Panza", "Ymusho", "Eztres", "20/12/12" };
		BDUtils.ExecuteDML(insertSQL, values4);

		Object[] values5 = { "4", 123456784, "Tania", "Guadalupe", "Elamor", "Demivida", "06/01/02" };
		BDUtils.ExecuteDML(insertSQL, values5);

		System.out.println("> Las fueron personas insertadas correctamente");
		Object[] objs = {};
		BDUtils.ExecuteQuery("SELECT documento, apellido, nombre FROM persona", objs, 3);
	}
}
