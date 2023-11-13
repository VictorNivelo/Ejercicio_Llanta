/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Cuenta {
    private Integer id_Cuenta;
    private String Correo;
    private String Contrasena;
    private Boolean EstadoCuenta;

    public Cuenta(Integer id_Cuenta, String Correo, String Contrasena, Boolean EstadoCuenta) {
        this.id_Cuenta = id_Cuenta;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.EstadoCuenta = EstadoCuenta;
    }
    
    public Integer getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(Integer id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Boolean getEstadoCuenta() {
        return EstadoCuenta;
    }

    public void setEstadoCuenta(Boolean EstadoCuenta) {
        this.EstadoCuenta = EstadoCuenta;
    }
    
}
