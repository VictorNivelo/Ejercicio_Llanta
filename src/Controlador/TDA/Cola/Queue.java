/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Cola;

import Controlador.TDA.Pila.Excepcione.FullStackException;
import Controlador.TDA.listas.Exepciones.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
/**
 *
 * @author Victor
 */
class Queue<E> extends ListaDinamica<E>{
    private Integer cima;

    public Queue(Integer cimaQ) {
        this.cima = cimaQ;
    }
    
    public Boolean isFull(){
        return getLongitud() >= cima;
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
