/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Persona {
    private Integer Id_Persona;
    private String TipoDNI;
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private Rol Rol;

    public Persona(Integer Id_Persona, String TipoDNI, String DNI, String Nombre, String Apellido, String Direccion, Rol id_rol) {
        this.Id_Persona = Id_Persona;
        this.TipoDNI = TipoDNI;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Rol = id_rol;
    }

    public Integer getId_Persona() {
        return Id_Persona;
    }

    public void setId_Persona(Integer Id_Persona) {
        this.Id_Persona = Id_Persona;
    }

    public String getTipoDNI() {
        return TipoDNI;
    }

    public void setTipoDNI(String TipoDNI) {
        this.TipoDNI = TipoDNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    @Override
    public String toString() {
        return "Id Persona: " + Id_Persona + ", Rol: " + Rol + ", Tipo DNI: " + TipoDNI + ", Numero DNI: " + DNI + ", Nombre: " + Nombre + ", Apellido: " + Apellido + ", Direccion: " + Direccion +"\n";
    }
    
}
