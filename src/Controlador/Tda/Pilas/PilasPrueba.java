/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Tda.Pilas;

import Controlador.Tda.Colas.QueueUltimate;
import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.ListaVacia;

/**
 *
 * @author Invitado xd
 */
public class PilasPrueba {

    public static void main(String[] args) throws ListaVacia, FullStackException {
        StackUltimate<Integer> stack = new StackUltimate<>(5);

        try {
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.push(10);
            stack.print();
            stack.pop();
        } 
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        QueueUltimate<Integer> tail = new QueueUltimate<>(5);

        try {
            tail.queue(6);
            tail.queue(7);
            tail.queue(8);
            tail.queue(9);
            tail.queue(10);
            tail.print();
            tail.dequeue();
            tail.print();
        } 
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

}
