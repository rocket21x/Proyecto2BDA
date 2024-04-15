package DAOs;

import DTOss.Placas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ConexionBD;

public class PlacasDAO {

    public void insertarPlacas(Placas placas) {
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Placas (NumeroPlacas, FechaEmision, FechaRecepcion, CostoTramite, TipoTramite, NumeroSerieAutomovil, RFCPersona) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, placas.getNumeroPlacas());
            statement.setDate(2, new java.sql.Date(placas.getFechaEmision().getTime()));
            statement.setDate(3, placas.getFechaRecepcion() != null ? new java.sql.Date(placas.getFechaRecepcion().getTime()) : null);
            statement.setBigDecimal(4, placas.getCostoTramite());
            statement.setString(5, placas.getTipoTramite());
            statement.setString(6, placas.getNumeroSerieAutomovil());
            statement.setString(7, placas.getRfcPersona());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Placas> obtenerTodasLasPlacas() {
        List<Placas> placasList = new ArrayList<>();
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM Placas")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Placas placas = new Placas();
                placas.setNumeroPlacas(resultSet.getString("NumeroPlacas"));
                placas.setFechaEmision(resultSet.getDate("FechaEmision"));
                placas.setFechaRecepcion(resultSet.getDate("FechaRecepcion"));
                placas.setCostoTramite(resultSet.getBigDecimal("CostoTramite"));
                placas.setTipoTramite(resultSet.getString("TipoTramite"));
                placas.setNumeroSerieAutomovil(resultSet.getString("NumeroSerieAutomovil"));
                placas.setRfcPersona(resultSet.getString("RFCPersona"));

                placasList.add(placas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placasList;
    }

    public void desactivarPlacasActuales(String numeroSerieAutomovil) {
        try (Connection connection = ConexionBD.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE Placas SET FechaRecepcion = ? WHERE NumeroSerieAutomovil = ? AND FechaRecepcion IS NULL")) {
            statement.setDate(1, new java.sql.Date(new Date().getTime()));
            statement.setString(2, numeroSerieAutomovil);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
