/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.listas.ListaDinamica;
import Modelo.Rol;

/**
 *
 * @author Victor
 */
public class RolControlLista {
    private ListaDinamica<Rol> roles;
    
    public RolControlLista() {
        roles = new ListaDinamica<>();
        roles.Agregar(new Rol(1, "Administrador", "Es un admin"));
        roles.Agregar(new Rol(2, "Cajero", "Es un cajero"));
        roles.Agregar(new Rol(3, "Cliente", "Es un cliente"));
        roles.Agregar(new Rol(4, "Guardia", "Es un guardia"));
    }

    public ListaDinamica<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ListaDinamica<Rol> roles) {
        this.roles = roles;
    }
}
