
package Vista.Arreglos.Tabla;


import Controlador.TDA.Grafos.GradoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Vista.Arreglos.Util.UtilVista;
import Vista.utilidades.UtilesVista;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloAdyancencia  extends AbstractTableModel {
    private GradoDirigidoEtiquetado<Escuela> grafo;

    public GradoDirigidoEtiquetado<Escuela> getGrafo() {
        return grafo;
    }

    public void setGrafo(GradoDirigidoEtiquetado<Escuela> grafo) {
        this.grafo = grafo;
    }


    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return grafo.num_vertice();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return grafo.num_vertice();
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
                if (grafo.isEdgeE(o, d)) {
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
//
//        try {
//            Escuela p = escuela.getInfo(i);
//            
//            switch (i1) {
//                case 0:
//                    return (p != null) ? p.getId(): "";
//                case 1:
//                    return (p != null) ? p.getNombre() : "";
//                case 2:
//                    return (p != null) ? p.getEscudo(): "";
//                case 3:
//                    return (p != null) ? p.getPortada(): "";
//                case 4:
//                    return (p != null) ? p.getCordenadaEscuela().getLongitud(): "";
//                case 5:
//                    return (p != null) ? p.getCordenadaEscuela().getLatitud(): "";
//                    
//                default:
//                    return null;
//                    
//            }
////        Persona p = personas[i];
//        }  
//        catch (ListaVacia ex) {
//        } 
//        return escuela;

//}

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

        }
    }

