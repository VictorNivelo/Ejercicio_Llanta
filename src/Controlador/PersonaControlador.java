/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Tda.listas.ListaDinamica;
import Modelo.Persona;

/**
 *
 * @author Victor
 */
public class PersonaControlador {
    private Persona personaControl;
    private ListaDinamica<Persona> ListaPersona;
//    private Persona[] MatrizPersona;
    
    public PersonaControlador(){
    }

    public PersonaControlador(Integer tamano) {
        this.ListaPersona  = new ListaDinamica<>();
//        this.MatrizPersona = new ;
//        this.MatrizPersona = new Persona[tamano];
    }

    //metodo que permite guardar
    public Boolean Guardar(){
        Integer pos = VerificarPosicion();
        if (pos > -1) {
            personaControl.setId_Persona(pos+1);
            ListaPersona.getCabezera();
//            MatrizPersona[VerificarPosicion()] = persona;
            return true;
        } 
        else {
            return false;
        }
    }
    
//    public Boolean Verificar(){
//        Boolean band = false;
//        
//        for(int i=0; i < this.personas.length; i++){
//            if(this.personas[i] !=null){
//                band = true;
//                break;
//            }
//        }
//        return band;
//    }
    
    public Integer VerificarPosicion(){
        
        Integer band = -1;
        
        for(int i = 0; i < this.ListaPersona.getLongitud(); i++){
            if(this.ListaPersona.getLongitud() == null){
                band = i;
                break;
            }
            else{
                band = 1;
            }
        }
        return band;
    }
    
    public void Imprimir() {
        for (int i = 0; i > this.getListaPersona().getLongitud(); i++) {
            System.out.println(getListaPersona().getLongitud());
        }
    }

    public Persona getPersona() {
        if (personaControl == null) {
            personaControl = new Persona();
        }
        return personaControl;
    }

    public void setPersona(Persona persona) {
        this.personaControl = persona ;
    }
    
    

//    public Persona[] getMatrizPersona() {
//        return MatrizPersona;
//    }
//
//    public void setMatrizPersona(Persona[] MatrizPersona) {
//        this.MatrizPersona = MatrizPersona;
//    }

    public ListaDinamica<Persona> getListaPersona() {
        return ListaPersona;
    }

    public void setListaPersona(ListaDinamica<Persona> MatrizPersona) {
        this.ListaPersona = MatrizPersona;
    }
    
}
