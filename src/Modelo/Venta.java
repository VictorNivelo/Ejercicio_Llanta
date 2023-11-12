/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Venta {
    private Integer id_Venta;
    private Date Fecha;
    private TipoPago MetodoPago;
    private Double PrecioFactura;
    private Double Iva;
    private Double Subtotal;
    private Double Descuento;
    private String NroFactura;
    private Persona idPersona;

    public Integer getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(Integer id_Venta) {
        this.id_Venta = id_Venta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public TipoPago getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(TipoPago MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public Double getPrecioFactura() {
        return PrecioFactura;
    }

    public void setPrecioFactura(Double PrecioFactura) {
        this.PrecioFactura = PrecioFactura;
    }

    public Double getIva() {
        return Iva;
    }

    public void setIva(Double Iva) {
        this.Iva = Iva;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public Double getDescuento() {
        return Descuento;
    }

    public void setDescuento(Double Descuento) {
        this.Descuento = Descuento;
    }

    public String getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(String NroFactura) {
        this.NroFactura = NroFactura;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }
    
    
}
