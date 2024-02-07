
package Controlador.TDA.Arbol;

import Controlador.TDA.Lista.ListaDinamica;

/**
 *
 * @author Victor
 */
public class ArbolEntero {
    private Nodo<Integer> ramaInterger;
    private Integer Altura;
    private ListaDinamica<ListaDinamica<Nodo>> longitud;
    private ListaDinamica<Integer> orden;
    private Integer NroNodos;

    public ArbolEntero() {
        ramaInterger = null;
        
    }
    
    public Nodo<Integer> getRamaInterger() {
        return ramaInterger;
    }

    public void setRamaInterger(Nodo<Integer> ramaInterger) {
        this.ramaInterger = ramaInterger;
    }

    public Integer getAltura() {
        return Altura;
    }

    public void setAltura(Integer Altura) {
        this.Altura = Altura;
    }

    public ListaDinamica<ListaDinamica<Nodo>> getLongitud() {
        return longitud;
    }

    public void setLongitud(ListaDinamica<ListaDinamica<Nodo>> longitud) {
        this.longitud = longitud;
    }

    public ListaDinamica<Integer> getOrden() {
        return orden;
    }

    public void setOrden(ListaDinamica<Integer> orden) {
        this.orden = orden;
    }

    public Integer getNroNodos() {
        return NroNodos;
    }

    public void setNroNodos(Integer NroNodos) {
        this.NroNodos = NroNodos;
    }
    
    private Integer CalcularLongitus(Nodo<Integer> tree){
        if(tree == null){
            return 0;
        }
        else{
            return null;
//            integer izquierda = CalcularLongitus(tree.getIzquierda());
        }
    }
    
    private void calcularNivel(Nodo<Integer> tree){
        if (tree != null) {

        } 
        else if (tree == null) {
            tree =null;
        }
    }
    
    private void level(){
        
    }
    
    public boolean insertar(Integer dato){
        if(ramaInterger == null){
            return true;
        }
        else{
            return false;
            
//            while (true) {
//                Integer i = 0;
//                boolean f = false;
//            }
        }
        //reset.getlongitod if(reset = null) = new.getpadre = padre pafdreanterido .getlogitud = new numero de nodos++
        //level reture true
        //else{reesetu.g et longtis = nuol todo ,o qu no tengo es ugya la null o al codigo abteridojn}
    }
    
    public static void main(String[] args) {
        try {
            /*
            para mañana graficar el arbol
            insertar valores al arbol
            cada uno de sus valores
            */
            //interger auxiliar
            //i aux.leng
            //sput.imprimir todo el atbol porque se necesita el 
            //auz en la pocicion medio para presentarlo mejor y aux mefip es igua a cero
            //for desde 1 para que see presententbien 
            //arbol.insetrt en la pocicion cero
            //de que nivel es el arbpol
            //la altura es y la altura del arbol con sus niveles .arbol.getlevel.getxise
            
        } catch (Exception e) {
        }
    }
}
