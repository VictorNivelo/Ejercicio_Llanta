/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persona;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.Persona;

/**
 *
 * @author Invitado xd
 */
public class PersonaDao extends DaoImplement<Persona>{
    private ListaDinamica<Persona> listaP = new ListaDinamica<>();
    private Persona persona;
    
    public PersonaDao(){
        super (Persona.class);
    }
    

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
    
    public Boolean Persist(){
        persona.setId_Persona(all().getLongitud()+1);
        return Persist(persona);
    }
    
}
