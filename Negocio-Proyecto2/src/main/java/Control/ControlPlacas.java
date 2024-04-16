package Control;

import DAOs.PlacasDAO;
import DTOss.Placas;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ControlPlacas {
    
    private final PlacasDAO placasDAO;
    
    public ControlPlacas() {
        this.placasDAO = new PlacasDAO();
    }
    
    public void solicitarNuevasPlacas(String rfcPersona, String numeroSerieAutomovil) {
        // Verificar si hay placas activas para el automóvil y desactivarlas si es necesario
        placasDAO.desactivarPlacasActuales(numeroSerieAutomovil);
        
        // Generar número alfanumérico de seis caracteres para las nuevas placas
        String numeroPlacas = generarNumeroPlacas();
        
        // Establecer la fecha de emisión como la fecha actual
        Date fechaEmision = new Date();
        
        // Insertar las nuevas placas en la base de datos
        Placas placas = new Placas(numeroPlacas, fechaEmision, null, BigDecimal.ZERO, "Nuevo", numeroSerieAutomovil, rfcPersona);
        placasDAO.insertarPlacas(placas);
    }
    
    private String generarNumeroPlacas() {
        // Generar tres letras aleatorias
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            sb.append(letra);
        }
        
        // Agregar el guión
        sb.append('-');
        
        // Generar tres dígitos aleatorios
        int numero = random.nextInt(1000);
        sb.append(String.format("%03d", numero)); // Formatear el número para que tenga tres dígitos
        
        return sb.toString();
    }
    
    public List<Placas> obtenerTodasLasPlacas() {
        return placasDAO.obtenerTodasLasPlacas();
    }

}
