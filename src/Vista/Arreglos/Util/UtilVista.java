/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Util;

import Controlador.RolControlador;
import Controlador.Tda.listas.Exepciones.EstaVacia;
import Modelo.Persona;
import Modelo.Rol;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilVista {
    
    public static void CargarComboRoles(JComboBox cbx) {

        RolControlador rolControlador = new RolControlador();
        cbx.removeAllItems();

        for (int i = 0; i < rolControlador.getRoles().length; i++) {
            cbx.addItem(rolControlador.getRoles()[i]);
        }
    }

    public static Rol ObtenerRolControlador(JComboBox cbx) {
        return (Rol) cbx.getSelectedItem();
    }
    
    public static void CargarComboR(JComboBox cbx) throws EstaVacia{
        
        
        Controlador.Persona.RolControl rolControlador = new Controlador.Persona.RolControl();
        cbx.removeAllItems();
        
//        if(rc.){
//            
//        }
        
        for(int i = 0; i < rolControlador.getListaP().getLongitud(); i++){
            cbx.addItem(rolControlador.getListaP().ObtenerInfo(i));
        }
    }
    
    public static Persona ObtenerRolCont(JComboBox cbx){
        return (Persona)cbx.getSelectedItem();
    }
    
    
   
}
