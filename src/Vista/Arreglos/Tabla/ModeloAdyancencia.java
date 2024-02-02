
package Vista.Arreglos.Tabla;


import Controlador.TDA.Grafos.GrafoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Vista.utilidades.UtilesVista;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloAdyancencia  extends AbstractTableModel {
    private GrafoDirigidoEtiquetado<Escuela> grafo;

    @Override
    public int getRowCount() {
        return grafo.num_vertice()-1;
    }

    @Override
    public int getColumnCount() {
        return grafo.num_vertice();
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ESCUELA";
        } 
        else {
            try {
                return grafo.getEtiquetaE(column).toString();
            } 
            catch (Exception e) {
                return "";
            }
        }
    }

    public GrafoDirigidoEtiquetado<Escuela> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoDirigidoEtiquetado<Escuela> grafo) {
        this.grafo = grafo;
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        try {
            if (i1 == 0) {
                return grafo.getEtiquetaE(i + 1).toString();
            }
            else {
                Escuela o = grafo.getEtiquetaE(i + 1);
                Escuela d = grafo.getEtiquetaE(i1);
                if (grafo.isEdge(o, d)) {
                    return UtilesVista.redondear(grafo.peso_arista(i + 1, i1)).toString();
                }
                else {
                    return "--";
                }
            }
        } 
        catch (Exception e) {
            return "";
        }
    }

    
}
//        if(column == 0){
//            return "Escuelas";
//        }
//        else{
//            try {
//                return grafo.getetiqeuta(column.toString);
//            } catch (Exception e) {
//                return "";
//            }
//        }
//        switch (column) {
//            case 0: 
//                return "#";
//            case 1: 
//                return "Nombre";
//            case 2:
//                return "Ruta escudo";
//            case 3:
//                return "Ruta portada";
//            case 4:
//                return "Longitud";
//            case 5:
//                return "Latitud";
//                
//            default:
//                return null;
//
//        }
//    }
//
