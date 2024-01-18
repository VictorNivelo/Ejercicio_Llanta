/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Util;

import Controlador.Persona.RolControlDao;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Modelo.Rol;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilVistaLista {
    public static void cargarcomboRoles(JComboBox cbx) throws ListaVacia{
        RolControlDao rc = new RolControlDao();
        cbx.removeAllItems();
        
        if(rc.getListaRol().EstaVacio()){
            throw new ListaVacia("No hay roles que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaRol().getLongitud(); i++) {
            cbx.addItem(rc.getListaRol().getInfo(i));
           }
        }
    }
    
    public static Rol obtenerRolControl(JComboBox cbx){
        return (Rol) cbx.getSelectedItem();
    }
}
