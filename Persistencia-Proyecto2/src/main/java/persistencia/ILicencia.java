package persistencia;

import DTOs.Persona;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author eduar
 */
public interface ILicencia {
    public void insertarLicencia(Date fechaExpedicion, Integer vigencia, BigDecimal monto, String tipo, Persona persona); 
    
    public void asignarLicencia();
    
    public void calcularCosto();
}