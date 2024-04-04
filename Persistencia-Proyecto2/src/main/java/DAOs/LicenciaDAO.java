/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.Licencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.ConexionBD;

/**
 *
 * @author jesus
 */
public class LicenciaDAO {
    
    public void RegistrarLicencia(Licencia lic){
        try (Connection connection = ConexionBD.obtenerConexion(); 
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Cliente (Vigencia,Monto,Tipo,RFC) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, lic.getVigencia());
            statement.setString(1, lic.getMonto());
            statement.setString(1, lic.getTipo());
            statement.setString(1, lic.getPersona());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
  
    
}
