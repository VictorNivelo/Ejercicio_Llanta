/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Rol {
    private Integer id_rol;
    private String Nombre_rol;
    private String Descripcion_rol;

    public Rol(Integer id_rol, String Nombre_rol, String Descripcion_rol) {
        this.id_rol = id_rol;
        this.Nombre_rol = Nombre_rol;
        this.Descripcion_rol = Descripcion_rol;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return Nombre_rol;
    }

    public void setNombre_rol(String Nombre_rol) {
        this.Nombre_rol = Nombre_rol;
    }

    public String getDescripcion_rol() {
        return Descripcion_rol;
    }

    public void setDescripcion_rol(String Descripcion_rol) {
        this.Descripcion_rol = Descripcion_rol;
    }

    @Override
    public String toString() {
        return   Nombre_rol ;
    }
    
    
}
