/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAOs.*;
import DTOss.*;

/**
 *
 * @author eduar
 */
public class ControlAutomovil {
    private AutomovilDAO automovilDAO;
    
    public ControlAutomovil() {
        this.automovilDAO = new AutomovilDAO();
    }

    public boolean registrarAutomovil(Automovil automovil) {
        return automovilDAO.registrarAutomovil(automovil);
    }
}
