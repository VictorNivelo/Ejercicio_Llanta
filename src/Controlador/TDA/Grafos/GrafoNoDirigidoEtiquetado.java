/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Grafos;

import Controlador.TDA.Grafos.Excepcion.VerticeException;
import Controlador.Utiles.Utiles;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigidoEtiquetado<E> extends GradoDirigidoEtiquetado<E>{
    
    public GrafoNoDirigidoEtiquetado(Integer numVer, Class clazz) {
        super(numVer, clazz);
    }

    public void insertarArista(Integer v1, Integer v2, Double peso) throws Exception {
        if (v1.intValue() <= num_vertice() && v2.intValue() <= num_vertice()) {
            if (!existe_arista(v1, v2)) {
                setNumeroVertices(num_aristas() + 1);
                getListaAdyacencia()[v1].Agregar(new Adyacencia(v2, peso));
                getListaAdyacencia()[v2].Agregar(new Adyacencia(v1, peso));
            }
        } 
        else {
            throw new VerticeException();
        }
    }
}
//    public static void main(String[] args) {
//        
//        GrafoNoDirigidoEtiquetado<String> ged = new GrafoNoDirigidoEtiquetado<>(6, String.class);
//        
//
////        Grafo f = new GrafoNoDirigido(3);
//        
//        try {
//            ged.insertar_arista(1, 2, 25.0);
//            ged.insertEdgeE("a", "b", 30.0);
//            ged.insertar_arista(5, 6, 35.0);
//            
//            ged.etiquetarVertice(1, "Estefania");
//            ged.etiquetarVertice(2, "Luna");
//            
////            f.insertar_arista(1, 2, 50.0);
////            f.insertar_arista(2, 3, 50.0);
////            f.insertar_arista(3, 4, 10.0);
////            f.insertar_arista(1, 5, 10.0);
////            f.insertar_arista(1, 6, 3.0);
//
//            
//            DibujarGrafo p = new DibujarGrafo();
//            p.updateFile(ged);
//            Utiles.abrirNavegadorPredeterminadorWindows("d3/grafo.html");
//        } 
//        catch (Exception ex) {
//            System.out.println("Error " + ex);
//        }
//    }

//    @Override
//    public String toString() {
//        return super.getEtiquetasString();
//    }

//}
