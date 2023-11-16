/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persona;

import Controlador.Dao.DaoImplement;
import Controlador.Tda.listas.ListaDinamica;
import Modelo.Persona;
import Modelo.Rol;

/**
 *
 * @author Victor
 */
public class RolControl extends DaoImplement<Rol>{
    private ListaDinamica<Rol> listaP = new ListaDinamica<>();
    private Rol persona;

    public RolControl() {
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
        if(persona ==null){
            persona = new Rol();
        }
        return persona;
    }

    public void setRol(Rol rol) {
        this.persona = rol;
    }
    
    public Boolean Persist(){
        persona.setId_rol(all().getLongitud()+1);
        return Persist(persona);
    }
    
    public static void main(String[] args) {
        RolControl rc = new RolControl();
        rc.getRol().setDescripcion_rol("administrador");
        rc.getRol().setNombre_rol("amen");

        System.out.println(""+rc.persona.toString());

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
