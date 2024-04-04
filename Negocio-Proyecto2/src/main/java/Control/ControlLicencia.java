/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.time.LocalDate;
import DTOs.*;
import DAOs.*;

/**
 *
 * @author jesus
 */
public class ControlLicencia {
    private LicenciaDAO licenciaDAO;
    
    public void RegistrarLicencia(Persona RFC,int vigencia, String tipo){
        Licencia lic = new Licencia();
        lic.setPersona(RFC);
        lic.setVigencia(vigencia);
        lic.setTipo(tipo);
        try {
            licenciaDAO.RegistrarLicencia(lic);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insetar licencia");
        }
        
        
    }
    
    
    
    
  
    
}
