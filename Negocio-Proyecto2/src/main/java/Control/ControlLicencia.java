package Control;

import java.time.LocalDate;
import DTOss.*;
import DAOs.*;

/**
 *
 * @author jesus
 */
public class ControlLicencia {
    private LicenciaDAO licenciaDAO;

    public ControlLicencia() {
        this.licenciaDAO = new LicenciaDAO();;
    }

    
    
    
    public void RegistrarLicencia(String RFC,int vigencia, String tipo){
        Licencia lic = new Licencia();
        lic.setRFC(RFC);
        lic.setVigencia(vigencia);
        lic.setTipo(tipo);
        try {
            licenciaDAO.RegistrarLicencia(lic);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insetar licencia");
        }
        
        
    }
    public boolean ValidarLicencia(String RFC) {
    try {
        // Verificar si existe una persona con el RFC especificado
        boolean personaExiste = licenciaDAO.existePersonaConRFC(RFC);
        if (personaExiste) {
            System.out.println("La licencia es valida para el RFC " + RFC);
            return true; // La licencia es válida si la persona existe en la base de datos
        } else {
            System.out.println("La licencia no es valida para el RFC " + RFC + " (no se encontro la persona)");
            return false; // La licencia no es válida si la persona no existe en la base de datos
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al validar RFC");
        return false; // En caso de error, consideramos la licencia como no válida
    }
}

    public Persona ObtenerPersonaPorRFC(String RFC){
        try {
            return licenciaDAO.obtenerPersonaPorRFC(RFC);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener Persona por RFC");
        }
        return null;
       
    
    }
    
    
    
    
  
    
}
