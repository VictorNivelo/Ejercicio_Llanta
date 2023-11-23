/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Tda.Colas;

import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Controlador.Tda.listas.ListaDinamica;
/**
 *
 * @author Invitado xd
 */
class Queue<E> extends ListaDinamica<E>{
    private Integer cima;

    public Queue(Integer Tope) {
        this.cima = cima;
    }
    
    public Boolean isFull(){
        return getLongitud().intValue() >= cima.intValue();
    }
    
    public void queue(E info) throws ListaVacia, FullStackException{
        if(isFull()){
            throw new FullStackException("Cola llena");
//            error
        }
        else{
            Agregar(info);
        }
    }
    
    public E dequeue() throws ListaVacia{
        E info = extractFirst();        
        return info;
    }
}
