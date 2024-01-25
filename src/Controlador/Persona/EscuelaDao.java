/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persona;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.ListaDinamica;

/**
 *
 * @author Victor
 */
public class EscuelaDao extends DaoImplement<Escuela>{
    private ListaDinamica<Escuela> listaEscuela = new ListaDinamica<>();
    private Escuela escuelas;
    
    public EscuelaDao(){
        super (Escuela.class);
    }

    public ListaDinamica<Escuela> getListaEscuela() {
        listaEscuela = all();
        return listaEscuela;
    }

    public void setListaEscuela(ListaDinamica<Escuela> listaEscuela) {
        this.listaEscuela = listaEscuela;
    }

    public Escuela getEscuelas() {
        if(escuelas == null){
            escuelas = new Escuela();
        }
        return escuelas;
    }

    public void setEscuelas(Escuela escuelas) {
        this.escuelas = escuelas;
    }

    public Boolean Persist(){
        escuelas.setId(all().getLongitud()+1);
        return Persist(escuelas);
    }
    
}
