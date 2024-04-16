package DAOs;

import DTOss.Licencia;
import DTOss.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.ConexionBD;

/**
 *
 * @author jesus
 */
public class LicenciaDAO {

    public void RegistrarLicencia(Licencia lic) {
    try (Connection connection = ConexionBD.obtenerConexion(); 
         PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Licencia (Vigencia, Monto, Tipo, RFC) VALUES (?, ?, ?, ?)")) {
        
        statement.setInt(1, lic.getVigencia());
        statement.setBigDecimal(2, lic.getMonto());
        statement.setString(3, lic.getTipo());
        statement.setString(4, lic.getRFC());
        
        int filasInsertadas = statement.executeUpdate();
        
        if (filasInsertadas > 0) {
            System.out.println("La licencia se registró correctamente.");
        } else {
            System.out.println("No se pudo registrar la licencia.");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al intentar registrar la licencia.");
    }
}


    public boolean existePersonaConRFC(String RFC) {
    boolean existe = false;
    try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement("SELECT 1 FROM Persona WHERE RFC = ? LIMIT 1")) {
        statement.setString(1, RFC);
        try (ResultSet resultSet = statement.executeQuery()) {
            existe = resultSet.next();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return existe;
}


    public Persona obtenerPersonaPorRFC(String RFC) {
        Persona persona = null;
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM Persona WHERE RFC = ?")) {
            statement.setString(1, RFC);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona = new Persona();
                persona.setRFC(resultSet.getString("RFC"));
                persona.setNombreCompleto(resultSet.getString("NombreCompleto"));
                persona.setFechaNacimiento(resultSet.getDate("FechaNacimiento").toLocalDate());
                persona.setTelefono(resultSet.getString("Telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }

}
