/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Cliente (Vigencia,Monto,Tipo,RFC) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, lic.getVigencia());
            statement.setBigDecimal(2, lic.getMonto());
            statement.setString(3, lic.getTipo());
            statement.setString(4, lic.getPersona().getRFC());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existePersonaConRFC(String RFC) {
        boolean existe = false;
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM personas WHERE RFC = ?")) {
            statement.setString(1, RFC);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                existe = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public Persona obtenerPersonaPorRFC(String RFC) {
        Persona persona = null;
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM personas WHERE RFC = ?")) {
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
