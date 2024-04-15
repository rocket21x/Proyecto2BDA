package persistencia;

/**
 *
 * @author jesus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Laptop
 */
public class ConexionBD {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=agenciafiscal";
    private static final String USER = "agencia";
    private static final String PASSWORD = "12345678";

    //"Imperial99" jdbc:mysql://127.0.0.1:3306/?user=root;
    /**
     * Conexion a BD
     *
     * @return
     * @throws SQLException
     */
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
    public static Connection obtenerConexion() throws SQLException {
    Connection conexion = null;
    // Registrar el controlador JDBC
    //Class.forName("com.mysql.cj.jdbc.Driver");
    // Establecer la conexión a la base de datos
    conexion = DriverManager.getConnection(URL, USER, PASSWORD);
    System.out.println("Conexión exitosa a la base de datos.");

    PreparedStatement statement = conexion.prepareStatement("USE agenciafiscal;");
    statement.execute(); // Ejecutar la instrucción USE para seleccionar la base de datos

    return conexion;
}


}
