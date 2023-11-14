/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Arreglos.Tabla;

import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private Persona personas[];
//    private ListaDinamica<Persona> personas;

//    public ListaDinamica<Persona> getPersonas() {
//        return personas;
//    }
//
//    public void setPersonas(ListaDinamica<Persona> personas) {
//        this.personas = personas;
//    }
//    
    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return personas.length;
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 9;
    }

    private String EstadoCuenta(int i) {
        
        Persona p = personas[i];
        
        if (p.getPersonaCuenta().getEstadoCuenta()) {
            return "Activa";
        } 
        else {
            return "Inactiva";
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        
        Persona p = personas[i];

        switch (i1) {
            case 0:
                return (p != null) ? p.getId_Persona(): "";
            case 1: 
                return (p != null) ? p.getRolPersona().getNombre_rol() : "";
            case 2:
                return (p != null) ? p.getTipoDNI(): "";
            case 3:
                return (p != null) ? p.getDNI() : "";
            case 4:
                return (p != null) ? p.getNombre() : "";
            case 5:
                return (p != null) ? p.getApellido() : "";
            case 6:
                return (p != null) ? p.getDireccion() : "";
            case 7:
                return (p != null) ? p.getPersonaCuenta().getCorreo() : "";
            case 8:
                return (p != null) ? EstadoCuenta(i): "";
                
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: 
                return "Id persona";
            case 1: 
                return "Tipo de rol";
            case 2:
                return "Tipo identificacion";
            case 3:
                return "Numero identidicacion";
            case 4:
                return "Nombre";
            case 5:
                return "Apellido";
            case 6:
                return "Direccion";
            case 7:
                return "Correo";
            case 8:
                return "Estado cuenta";
                
            default:
                return null;

        }
    }
}
