/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.time.LocalDate;

/**
 *
 * @author jesus
 */
public class ControlLicencia {
    
    
    
    public void insertarCliente(String nombres, String apellidoPaterno, String apellidoMaterno, String calle, String numCasa, String cp, LocalDate fechaNacimiento, int edad) {
        Cliente cliente = new Cliente();
        cliente.setNombres(nombres);
        cliente.setApellidoPaterno(apellidoPaterno);
        cliente.setApellidoMaterno(apellidoMaterno);
        cliente.setCalle(calle);
        cliente.setNumCasa(numCasa);
        cliente.setCp(cp);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setEdad(edad);
 
        try {
            clienteDAO.insertarCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insetar Cliente");
        }
    }
    
    
  
    
}
