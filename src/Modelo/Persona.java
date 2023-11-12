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
    private Cuenta PersonaCuenta;
    private Rol RolPersona;

    public Persona(Integer Id_Persona, String TipoDNI, String DNI, String Nombre, String Apellido, String Direccion, Cuenta PersonaCuenta, Rol RolPersona) {
        this.Id_Persona = Id_Persona;
        this.TipoDNI = TipoDNI;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.PersonaCuenta = PersonaCuenta;
        this.RolPersona = RolPersona;
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

    public Cuenta getPersonaCuenta() {
        return PersonaCuenta;
    }

    public void setPersonaCuenta(Cuenta PersonaCuenta) {
        this.PersonaCuenta = PersonaCuenta;
    }

    public Rol getRolPersona() {
        return RolPersona;
    }

    public void setRolPersona(Rol RolPersona) {
        this.RolPersona = RolPersona;
    }
    
    @Override
    public String toString() {
        return "Id Persona: " + Id_Persona + ", Rol: " + RolPersona + ", Tipo DNI: " + TipoDNI + ", Numero DNI: " + DNI + ", Nombre: " + Nombre + ", Apellido: " + Apellido + ", Direccion: " + Direccion +", Correo: "+ PersonaCuenta.getCorreo()+", Contraseña: "+ PersonaCuenta.getContrasena()+", Estado de cuenta: "+ PersonaCuenta.getEstado_Cuenta()+"\n";
    }
    
}
