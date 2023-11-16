/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persona;

import Controlador.Dao.DaoImplement;
import Controlador.Tda.listas.ListaDinamica;
import Modelo.Rol;

/**
 *
 * @author Invitado xd
 */
public class RolControl extends DaoImplement<Rol>{
    private ListaDinamica<Rol> listaRol = new ListaDinamica<>();
    private Rol rol;

    public RolControl() {
        super(Rol.class);
    }
    
    public ListaDinamica<Rol> getListaRol() {
        listaRol = all();
        return listaRol;
    }

    public void setListaRol(ListaDinamica<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public Rol getRol() {
        if(rol ==null){
            rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Boolean Persist(){
        rol.setId_rol(all().getLongitud()+1);
        return Persist(rol);
    }
    
    public static void main(String[] args) {
        RolControl rc = new RolControl();
        rc.getRol().setDescripcion_rol("administrador");
        rc.getRol().setNombre_rol("amen");

        System.out.println(""+rc.rol.toString());

        rc.Persist();
//        rc.setRol(null);
//        rc.getRol().setDescripcion_rol("xd2");
//        rc.getRol().setNombre_rol("cash");
//        rc.Persist();
//        rc.setRol(null);
//        rc.getRol().setDescripcion_rol("xd3");
//        rc.getRol().setNombre_rol("cleinte");
//        rc.Persist();
//        rc.setRol(null);
    }
    
}
