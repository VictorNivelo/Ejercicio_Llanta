/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Util;

import Controlador.RolControlador;
import Modelo.Cuenta;
import Modelo.Rol;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Victor
 */
public class UtilVista {
    
    public static void CargarComboRoles(JComboBox cbx){
        
        RolControlador rolControlador = new RolControlador();
        cbx.removeAllItems();
        
        for(int i = 0; i < rolControlador.getRoles().length; i++){
            cbx.addItem(rolControlador.getRoles()[i]);
        }
    }
    
    public static Rol ObtenerRolControlador(JComboBox cbx){
        return (Rol)cbx.getSelectedItem();
    }
    
    
}
