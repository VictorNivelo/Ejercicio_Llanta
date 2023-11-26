/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Tda.Pilas;

import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.ListaVacia;

/**
 *
 * @author Victor
 */
public class StackUltimate<E> {
    private Stack<E> stack;

    public StackUltimate(Integer legngt) {
        this.stack = new Stack<>(legngt);
    }
    
    public void push(E info) throws ListaVacia, FullStackException{
        stack.push(info);
    }
    
    public E pop() throws ListaVacia{
        return stack.pop();
    }
    
    public Integer length(){
        return stack.getLongitud();
    }
    
    public Boolean isfull(){
        return stack.isFull();
    }
    
    public void print(){
        System.out.println("Stack");
        System.out.println(stack.toString());
        System.out.println("");
    }
}
