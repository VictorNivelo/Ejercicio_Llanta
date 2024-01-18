/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Colas;

import Controlador.TDA.Pilas.Excepcione.FullStackException;
import Controlador.TDA.listas.Exepciones.ListaVacia;

/**
 *
 * @author Victor
 * @param <E>
 */
public class QueueUltimate<E> {
    private Queue<E> tail;

    public QueueUltimate(Integer legngt) {
        this.tail = new Queue<>(legngt);
    }
    
    public void queue(E info) throws ListaVacia, FullStackException{
        tail.queue(info);
    }
    
    public E dequeue() throws ListaVacia{
        return tail.dequeue();
    }
    
    public Integer length(){
        return tail.getLongitud();
    }
    
    public Boolean isfull(){
        return tail.isFull();
    }
    
    public void print(){
        System.out.println("Queue");
        System.out.println(tail.toString());
        System.out.println("");
    }
}
