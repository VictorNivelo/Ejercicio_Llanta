/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Tabla;

import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaEscuela extends AbstractTableModel {

    private ListaDinamica<Escuela> escuela;

    public ListaDinamica<Escuela> getEscuela() {
        return escuela;
    }

    public void setEscuela(ListaDinamica<Escuela> escuela) {
        this.escuela = escuela;
    }

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return escuela.getLongitud();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 6;
    }
    

    @Override
    public Object getValueAt(int i, int i1) {

        try {
            Escuela p = escuela.getInfo(i);
            
            switch (i1) {
                case 0:
                    return (p != null) ? p.getId(): "";
                case 1:
                    return (p != null) ? p.getNombre() : "";
                case 2:
                    return (p != null) ? p.getEscudo(): "";
                case 3:
                    return (p != null) ? p.getPortada(): "";
                case 4:
                    return (p != null) ? p.getCordenadaEscuela().getLongitud(): "";
                case 5:
                    return (p != null) ? p.getCordenadaEscuela().getLatitud(): "";
                    
                default:
                    return null;
                    
            }
//        Persona p = personas[i];
        }  
        catch (ListaVacia ex) {
        } 
        return escuela;

}

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: 
                return "#";
            case 1: 
                return "Nombre";
            case 2:
                return "Ruta escudo";
            case 3:
                return "Ruta portada";
            case 4:
                return "Longitud";
            case 5:
                return "Latitud";
                
            default:
                return null;

        }
    }
}
