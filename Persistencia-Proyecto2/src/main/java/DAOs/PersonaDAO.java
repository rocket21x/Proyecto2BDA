package DAOs;

import DTOss.Persona;
import com.github.lgooddatepicker.components.DatePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; // Importa la clase Date de java.sql
import persistencia.ConexionBD;

/**
 *
 * @author jesus
 */
public class PersonaDAO {

    public void RegistrarPersona(Persona p) {
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Persona (RFC, NombreCompleto, FechaNacimiento, Telefono) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, p.getRFC());
            statement.setString(2, p.getNombreCompleto());

            java.util.Date utilDate = java.sql.Date.valueOf(p.getFechaNacimiento());

            // Convierte java.util.Date a java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Utiliza el método setDate para establecer la fecha en el PreparedStatement
            statement.setDate(3, sqlDate);

            statement.setString(4, p.getTelefono());

            // Ejecutar la consulta
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Opcional: Lanza una excepción personalizada o maneja de otra manera la excepción.
        }
    }

}
