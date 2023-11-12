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
    private Boolean Estado_Cuenta;

    public Cuenta(Integer id_Cuenta, String Cuenta, String Contrasena, Boolean Estado_Cuenta) {
        this.id_Cuenta = id_Cuenta;
        this.Correo = Cuenta;
        this.Contrasena = Contrasena;
        this.Estado_Cuenta = Estado_Cuenta;
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

    public Boolean getEstado_Cuenta() {
        return Estado_Cuenta;
    }

    public void setEstado_Cuenta(Boolean Estado_Cuenta) {
        this.Estado_Cuenta = Estado_Cuenta;
    }
    
}
