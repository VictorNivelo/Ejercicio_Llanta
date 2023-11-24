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
 * @author Victor
 */
public class PilasPrueba {
    
    private Double calculoOperac(Double a, Double b, Character operacion) {
        if (operacion == '+') {
            return a + b;
        } 
        else if (operacion == '-') {
            return a - b;
        }
        else if (operacion == '*') {
            return a * b;
        }
        else if (operacion == '/') {
            return a / b;
        }
        return  Double.NaN;
    }
    
    private Boolean ValidadorOperacion(Character a){
        return (a == '+' || a == '-' || a == '*' || a == '/') ;
    }
    
    public Double calcular(String info) throws ListaVacia, FullStackException{
        StackUltimate<Double> pila = new StackUltimate<>(10);
        Double resp = Double.NaN;
        for(Character a: info.toCharArray()){
            if(Character.isDigit(a)){
                pila.push(Double.valueOf(a.toString()));
            }
            else{
                if(ValidadorOperacion(a)){
                    Double oper1 = pila.pop();
                    Double oper2 = pila.pop();
                    pila.push(calculoOperac(oper1, oper2, a));
                }
            }
        }
        if(pila.length() == 1){
            resp = pila.pop();
        }
        else{
            resp = Double.NaN;
        }
        return resp;
    }

    public static void main(String[] args) throws ListaVacia, FullStackException {
        
        String info = "64 * 46+-";
        PilasPrueba ta = new PilasPrueba();
        try {
            System.out.println(ta.calcular(info));
            //como validar para mas digitos ejemplos 100 o mas numeros
            //NaN no es un dato numerico
        } 
        catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        
//        StackUltimate<Integer> stack = new StackUltimate<>(5);
//
//        try {
//            stack.push(6);
//            stack.push(7);
//            stack.push(8);
//            stack.push(9);
//            stack.push(10);
//            stack.print();
//            stack.pop();
//        } 
//        catch (Exception e) {
//            System.out.println("Error" + e.getMessage());
//        }
//
//        QueueUltimate<Integer> tail = new QueueUltimate<>(6);
//
//        try {
//            tail.queue(6);
//            tail.queue(7);
//            tail.queue(8);
//            tail.queue(9);
//            tail.queue(10);
//            tail.print();
//            tail.dequeue();
//            tail.print();
//        } 
//        catch (Exception e) {
//            System.out.println("Error" + e.getMessage());
//        }
    }

}
