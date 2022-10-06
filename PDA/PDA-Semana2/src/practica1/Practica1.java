package practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Practica1 {

    private static final String URL_ORACLE = "jdbc:oracle:thin:@192.168.0.250:1521:xe";
    private static final String USER = "utec";
    private static final String PASSWORD = "utec";

    // Metodo para cerrar la Conexion,(para hacer mas clean el Finally)
    public static void Close(Object obj) {
        try {
            if (obj == null) {
                return;
            }

            if (obj instanceof Connection) {
                Connection conn = ((Connection) obj);
                if (!conn.isClosed())
                    conn.close();
            } else if (obj instanceof PreparedStatement) {
                PreparedStatement ps = ((PreparedStatement) obj);
                if (!ps.isClosed())
                    ps.close();
            } else if (obj instanceof ResultSet) {
                ResultSet rs = ((ResultSet) obj);
                if (!rs.isClosed())
                    rs.close();
            } else if (obj instanceof Statement) {
                Statement s = ((Statement) obj);
                if (!s.isClosed())
                    s.close();
            }

        } catch (Exception e) {
            System.out.println("> Error: al cerrar el objeto");
            e.printStackTrace();
        }
    }

    // Metodo para obtener la conexion
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Verifico qu este el driver la conexion a Oracle
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
    }

    public static void main(String[] args) {

        String apellido = JOptionPane.showInputDialog("Apellido: ");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = getConnection();

            String sql = "SELECT * FROM persona WHERE LOWER(apellido)=LOWER('"+apellido+"')";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("- ID: "+rs.getString(1));
                System.out.println("- Documento: " + rs.getString(2));
                System.out.println("- Nombre: " + rs.getString(3));
                System.out.println("- Segundo Nombre: " + rs.getString(4));
                System.out.println("- Apellido: " + rs.getString(5));
                System.out.println("- Segundo Apellido: " + rs.getString(6));
                System.out.println("- Nacimiento: " + rs.getString(7));
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("> Error: No se pudo ejecutar la sentencia SELECT");
            e.printStackTrace();

        } finally {
            Close(conn);
            Close(st);
            Close(rs);
        }
    }
}
