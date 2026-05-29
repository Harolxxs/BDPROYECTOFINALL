/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

public class Venta {

    private Long idAuto;
    private Long idCliente;
    private Long idVendedor;
    private Date fechaVenta;
    private double valorVenta;
    private String formaPago;

    public Venta() {}

    public Venta(Long idAuto, Long idCliente, Long idVendedor, Date fechaVenta, double valorVenta, String formaPago) {
        this.idAuto = idAuto;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.formaPago = formaPago;
    }

    public Long getIdAuto() { return idAuto; }
    public void setIdAuto(Long idAuto) { this.idAuto = idAuto; }

    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public Long getIdVendedor() { return idVendedor; }
    public void setIdVendedor(Long idVendedor) { this.idVendedor = idVendedor; }

    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }

    public double getValorVenta() { return valorVenta; }
    public void setValorVenta(double valorVenta) { this.valorVenta = valorVenta; }

    public String getFormaPago() { return formaPago; }
    public void setFormaPago(String formaPago) { this.formaPago = formaPago; }
}