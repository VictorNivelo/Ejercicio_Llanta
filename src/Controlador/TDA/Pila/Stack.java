/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Pila;

import Controlador.TDA.Pila.Excepcione.FullStackException;
import Controlador.TDA.listas.Exepciones.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
/**
 *
 * @author Victor
 */
class Stack<E> extends ListaDinamica<E>{
    private final Integer tope;

    public Stack(Integer topeQ) {
        this.tope = topeQ;
    }
    
    public Boolean isFull(){
        return getLongitud() >= tope;
    }
    
    public void push(E info) throws ListaVacia, FullStackException{
        if(isFull()){
            throw new FullStackException("Pilas llena");
//            error
        }
        else{
            Agregar(info, 0);
        }
    }
    
    public E pop() throws ListaVacia{
        E info = extractFirst();        
        return info;
    }
}
