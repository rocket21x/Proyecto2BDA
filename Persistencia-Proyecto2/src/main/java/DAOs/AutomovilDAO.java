/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOss.Automovil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.ConexionBD;

/**
 *
 * @author eduar
 */
public class AutomovilDAO {
    
    private Connection connection;
    
    public boolean registrarAutomovil(Automovil automovil) {
        try {
            Connection connection = ConexionBD.obtenerConexion();
            String query = "INSERT INTO Automovil (NumeroSerie, Marca, Linea, Color, Modelo, NumeroPlacasAnteriores) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, automovil.getNumeroSerie());
            statement.setString(2, automovil.getMarca());
            statement.setString(3, automovil.getLinea());
            statement.setString(4, automovil.getColor());
            statement.setInt(5, automovil.getModelo());
            statement.setString(6, automovil.getNumeroPlacasAnteriores());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
