/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;

/**
 *
 * @author Victor
 */
public class PersonaControlador {
    private Persona persona;
    private Persona[] MatrizPersona;
    
    public PersonaControlador(){
    }

    public PersonaControlador(Integer tamano) {
            this.MatrizPersona = new Persona[tamano];
        
    }
    
    //metodo que permite guardar
    public Boolean Guardar(){
        Integer pos = VerificarPosicion();
        if (pos > -1) {
            persona.setId_Persona(pos+1);
            MatrizPersona[VerificarPosicion()] = persona;
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
        
        for(int i = 0; i < this.MatrizPersona.length; i++){
            if(this.MatrizPersona[i] == null){
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
        for (int i = 0; i > this.getMatrizPersona().length; i++) {
            System.out.println(getMatrizPersona()[i]);
        }
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona ;
    }

    public Persona[] getMatrizPersona() {
        return MatrizPersona;
    }

    public void setMatrizPersona(Persona[] MatrizPersona) {
        this.MatrizPersona = MatrizPersona;
    }
    
}
