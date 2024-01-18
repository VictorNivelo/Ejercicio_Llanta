
package Controlador.TDA.Grafos;

import Controlador.TDA.Grafos.Excepcion.VerticeException;
import Controlador.TDA.Grafos.PaintGraph;
import Controlador.Utiles.Utiles;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigido extends GrafoDirigido{
    
    public GrafoNoDirigido (Integer numV){
        super(numV);
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
//        DibujarGrafo dibujarGrafo = new DibujarGrafo();
//        dibujarGrafo.updateFile(this);
    }
    
    public static void main(String[] args) {

        Grafo f = new GrafoNoDirigido(6);
        
        try {
            f.insertar_arista(1, 2, 50.0);
            f.insertar_arista(2, 3, 50.0);
            f.insertar_arista(3, 4, 10.0);
            f.insertar_arista(1, 5, 10.0);
            f.insertar_arista(1, 6, 3.0);

            
            PaintGraph p = new PaintGraph();
            p.updateFile(f);
            Utiles.abrirNavegadorPredeterminadorWindows("d3/grafo.html");
        } 
        catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }
}
//        Grafo f = new GrafoNoDirigido(6);
//        System.out.println(f);
//        try {
//            f.insertar_arista(1, 3, 50.0);
//            f.insertar_arista(4, 5, 10.0);
//            System.out.println(f);
//            
//        } catch (Exception ex) {
//            System.out.println("Error "+ex);
////        }
//    }

//    public void insertarArista(Integer origen, Integer destino, Double peso) throws Exception {
//        if (origen <= num_vertice() && destino <= num_vertice()) {
//            if (!existe_arista(origen, destino)) {
//                getListaAdyacencia()[origen].Agregar(new Adyacencia(destino, peso));
//                getListaAdyacencia()[destino].Agregar(new Adyacencia(origen, peso));
//            }
//            numeroAristas++;
//        } 
//        else {
//            throw new VerticeException();
//        }
//    }
//}
