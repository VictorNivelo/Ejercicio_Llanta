/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Grafos.Modelo;

/**
 *
 * @author Victor
 */
public class Escuela {
    private Integer id;
    private String Nombre;
    private String Portada;
    private String Escudo;
    private Coordenada cordenadaEscuela;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPortada() {
        return Portada;
    }

    public void setPortada(String Portada) {
        this.Portada = Portada;
    }

    public String getEscudo() {
        return Escudo;
    }

    public void setEscudo(String Escudo) {
        this.Escudo = Escudo;
    }

    public Coordenada getCordenadaEscuela() {
        if(cordenadaEscuela == null){
            cordenadaEscuela = new Coordenada();
        }
        return cordenadaEscuela;
    }

    public void setCordenadaEscuela(Coordenada cordenadaEscuela) {
        this.cordenadaEscuela = cordenadaEscuela;
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    
    
}
