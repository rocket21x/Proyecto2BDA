/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAOs.*;
import DTOs.*;
import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class ControlPersona {
    
    private PersonaDAO personaDAO;
    
    public void RegistrarLicencia(String RFC, String nombreCompleto,LocalDate fechaNacimiento, String Telefono){
        Persona per = new Persona();
        per.setRFC(RFC);
        per.setNombreCompleto(nombreCompleto);
        per.setFechaNacimiento(fechaNacimiento);
        per.setTelefono(Telefono);
        
        
        try {
            personaDAO.RegistrarPersona(per);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insetar licencia");
        }
    
    }
}
