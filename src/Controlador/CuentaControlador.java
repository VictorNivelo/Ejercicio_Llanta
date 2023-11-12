/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;

/**
 *
 * @author Victor
 */
public class CuentaControlador {
    
    private Cuenta[] cuentaPersona;
    
    public CuentaControlador(){
        
    }
    
    public Cuenta[] getCuentaPersona() {
        return cuentaPersona;
    }

    public void setCuentaPersona(Cuenta[] cuentaPersona) {
        this.cuentaPersona = cuentaPersona;
    }
    
}
