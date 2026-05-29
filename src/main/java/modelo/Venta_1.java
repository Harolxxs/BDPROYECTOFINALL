/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta_1.findAll",  query = "SELECT v FROM Venta_1 v"),
    @NamedQuery(name = "Venta_1.findByIdVenta", query = "SELECT v FROM Venta_1 v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta_1.findByPlacac",  query = "SELECT v FROM Venta_1 v WHERE v.placac = :placac")
})
public class Venta_1 implements Serializable {
         
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "placac", nullable = false)
    private String placac;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_vendedor", nullable = false)
    private Long idVendedor;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_venta", nullable = false)
    private Date fechaVenta;

    @Column(name = "valor_venta", nullable = false)
    private double valorVenta;

    @Column(name = "forma_pago", nullable = false)
    private String formaPago;  // "Contado" o "Credito"

    public Venta_1() {}

    public Venta_1(String placac, Long idCliente, Long idVendedor, Date fechaVenta, double valorVenta, String formaPago) {
        this.placac = placac;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.formaPago = formaPago;
    }

    public Long getIdVenta() { return idVenta; }
    public void setIdVenta(Long idVenta) { this.idVenta = idVenta; }

    public String getPlacac() {
        return placac;
    }

    public void setPlacac(String placac) {
        this.placac = placac;
    }

    

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
