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
public class RolControl extends DaoImplement<Persona>{
    private ListaDinamica<Persona> listaP = new ListaDinamica<>();
    private Persona persona;

    
    public RolControl(){
        super (Persona.class);
    }
    

//    public RolControl() {
//        super(persona).class);
//    }

    public ListaDinamica<Persona> getListaP() {
        listaP = all();
        return listaP;
    }

    public void setListaP(ListaDinamica<Persona> listaP) {
        this.listaP = listaP;
    }

    public Persona getPersona() {
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
//    public ListaDinamica<Persona> getListaRol() {
//        listaP = all();
//        return listaP;
//    }

//    public void setListaRol(ListaDinamica<Persona> listaRol) {
//        this.listaP = listaRol;
//    }
//
//    public Rol getRol() {
//        if(persona ==null){
//            persona = new Rol();
//        }
//        return persona;
//    }
//
//    public void setRol(Rol rol) {
//        this.persona = rol;
//    }
    
    public Boolean Persist(){
        persona.setId_Persona(all().getLongitud()+1);
        return Persist();
//        return Persist(persona);
    }
    
    public static void main(String[] args) {
        RolControl rc = new RolControl();
        rc.getPersona().setNombre("administrador");
        rc.getPersona().setApellido("amen");

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
