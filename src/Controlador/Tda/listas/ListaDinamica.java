/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Tda.listas;

import Controlador.Tda.listas.Exepciones.ListaVacia;

/**
 *
 * @author Victor
 * @param <E>
 */
public class ListaDinamica<E> {
    private Nodo<E> cabezera;
    private Nodo<E> ultimo;
    private Integer Longitud;

    public ListaDinamica() {
        cabezera = null;
        ultimo = null;
        Longitud = 0;
    }
    
    public Boolean EstaVacio(){
        return(cabezera == null || Longitud == 0 );
    }
    
    public void AgregarCabeza(E info){
        Nodo<E> Ayuda ;
        if(EstaVacio()){
            Ayuda = new Nodo<>(info);
            cabezera = Ayuda;
            ultimo = Ayuda;
            Longitud++;
        }
        else{
            Nodo<E> CabezaAyuda = cabezera;
            Ayuda = new Nodo<>(info, CabezaAyuda);
            cabezera = Ayuda;
            Longitud++;
        }
    }
    
    public void AgregarFinal(E info){
        Nodo<E> Ayuda;
        if(EstaVacio()){
            AgregarCabeza(info);
//            Ayuda = new Nodo<>(info);
//            cabezera = Ayuda;
//            ultimo = Ayuda;
//            Longitud++;
        }
        else{
            Ayuda = new Nodo<>(info, null);
            ultimo.setSiguiente(Ayuda);
            ultimo = Ayuda;
            Longitud++;
        }
    }
    
    public void Agregar(E info){
        AgregarFinal(info);
    }
    
    
    
    private E ObtenerPrimero() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
    }
        return cabezera.getInfo();
    }
    
//    public E ObtenerPrimero(Integer pos) throws EstaVacia{
//        
//        if (!EstaVacio()) {
//            E info = null;
//            if (pos >= 0 && pos < Longitud) {
//                if (pos == 0) {
//                    info = cabezera.getInfo();
//                } 
//                else {
//                    Nodo<E> ayuda = cabezera;
//                    for (int i = 0; i < pos; i++) {
//                        ayuda = ayuda.getSiguiente();
//                    }
//                    info = ayuda.getInfo();
//                }
//
//            } 
//            else {
//                throw new EstaVacia("La lista esta vacia");
//            }
//            return cabezera.getInfo();
//        } 
//        else {
//            throw new EstaVacia("La lista esta vacia");
//        }
//    }
    
    private E ObtenerUltimo() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        return ultimo.getInfo();
    }
    
    public E getInfo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        return getNodo(indice).getInfo();
    }
    
    private Nodo<E> getNodo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Longitud){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return cabezera;
        }
        else if(indice == (Longitud -1)){
            return ultimo;
        }
        else{
            Nodo<E> Buscar = cabezera;
            int contador =0;
            while(contador < indice){
                contador++;
                Buscar = Buscar.getSiguiente();
            }
            return Buscar;
        }
    }
       
    public void Agregar (E info, Integer indice)throws ListaVacia{
        if(EstaVacio() || indice == 0){
            AgregarCabeza(info);
        }
        else if(indice.intValue() == Longitud){
            AgregarFinal(info);
        }
        else{
            Nodo<E> BuscarPrevio = getNodo(indice - 1);
            Nodo<E> Buscar= getNodo(indice);
            Nodo<E> Ayuda = new Nodo<>(info, Buscar);
            BuscarPrevio.setSiguiente(Ayuda);
            Longitud++;
        }
    }
    
    public ListaDinamica<E> obtenerLista() {
        ListaDinamica<E> lista = new ListaDinamica<>();
        Nodo<E> actual = cabezera;

        while (actual != null) {
            lista.AgregarFinal(actual.getInfo());
            actual = actual.getSiguiente();
        }

        return lista;
    }
    
    public Object[] CovertirEnArreglo() {
        Object[] Arreglos = new Object[Longitud];
        Nodo<E> actual = cabezera;

        for (int i = 0; i < Longitud; i++) {
            Arreglos[i] = actual.getInfo();
            actual = actual.getSiguiente();
        }

        return Arreglos;
    }

    @Override
    public String toString() {
        StringBuilder StringB = new StringBuilder("Datos de lista \n");
        try {
            EstaVacio();
            
            Nodo<E> ayuda = cabezera;
            
            while(ayuda != null){
                StringB.append(ayuda.getInfo().toString());
                ayuda = ayuda.getSiguiente();
            }
        } 
        catch (Exception e) {
            StringB.append(e.getMessage());
        }
        return StringB.toString();
    }

    public Nodo<E> getCabezera() {
        return cabezera;
    }

    public void setCabezera(Nodo<E> cabezera) {
        this.cabezera = cabezera;
    }

    public Nodo<E> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<E> ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getLongitud() {
        return Longitud;
    }

    public void setLongitud(Integer Longitud) {
        this.Longitud = Longitud;
    }
    
}
