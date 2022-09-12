package practica1;

import java.sql.ResultSet;
import java.sql.Statement;

import compartido.ConexionBD;

public class PersonaDAO {
    private static final String CONTAR_PERSONAS = "SELECT count(*) FROM persona";

    public static int contarPersonas() {
        try {
            Statement stmt = ConexionBD.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(CONTAR_PERSONAS);
            return rs.next() ? rs.getInt(1) : 0; 
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
