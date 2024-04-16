/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAOs.*;
import DTOss.*;
import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class ControlPersona {
    
    private PersonaDAO personaDAO;
    

    /**
     * Constructor 
     */
    public ControlPersona() {
        this.personaDAO = new PersonaDAO(); // Inicializa personaDAO
    }
    
    /**
     * registra una persona en la base de datos con los metodos de la persistencia
     * @param RFC
     * @param nombreCompleto
     * @param fechaNacimiento
     * @param Telefono 
     */
    public void RegistrarPersona(String RFC, String nombreCompleto,LocalDate fechaNacimiento, String Telefono){
        Persona per = new Persona();
        per.setRFC(RFC);
        per.setNombreCompleto(nombreCompleto);
        per.setFechaNacimiento(fechaNacimiento);
        per.setTelefono(Telefono);
        
        
        try {
            personaDAO.RegistrarPersona(per);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insetar Persona");
        }
    
    }
}
