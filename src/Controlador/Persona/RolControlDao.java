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
 * @author Victor
 */
public class RolControlDao extends DaoImplement<Rol>{
    private ListaDinamica<Rol> listaP = new ListaDinamica<>();
    private Rol rol;

    public RolControlDao() {
        super(Rol.class);
    }
    
    public ListaDinamica<Rol> getListaRol() {
        listaP = all();
        return listaP;
    }

    public void setListaRol(ListaDinamica<Rol> listaRol) {
        this.listaP = listaRol;
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
        RolControlDao rc = new RolControlDao();
        rc.getRol().setDescripcion_rol("es un administrador");
        rc.getRol().setNombre_rol("administrador");
        rc.Persist();
        rc.setRol(null);
        
        rc.getRol().setDescripcion_rol("es un Cajero");
        rc.getRol().setNombre_rol("Cajero");
        rc.Persist();
        rc.setRol(null);
        
        rc.getRol().setDescripcion_rol("es un Cliente");
        rc.getRol().setNombre_rol("Cliente");
        rc.Persist();
        rc.setRol(null);

//        System.out.println(""+rc.all().toString());

//        rc.Persist();
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
