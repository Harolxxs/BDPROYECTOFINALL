<<<<<<< HEAD

package modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "auto_nuevo")
@NamedQueries({
    @NamedQuery(name = "Auto_1.findAll",        query = "SELECT a FROM Auto_1 a"),
    @NamedQuery(name = "Auto_1.findByIdAuto",   query = "SELECT a FROM Auto_1 a WHERE a.idAuto = :idAuto"),
    @NamedQuery(name = "Auto_1.findByPlaca",    query = "SELECT a FROM Auto_1 a WHERE a.placa = :placa"),
    @NamedQuery(name = "Auto_1.findByMarca",    query = "SELECT a FROM Auto_1 a WHERE a.marca = :marca"),
    @NamedQuery(name = "Auto_1.findByCondicion",query = "SELECT a FROM Auto_1 a WHERE a.condicion = :condicion")
})
public class Auto_1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Long idAuto;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private int modelo;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "condicion", nullable = false)
    private String condicion;  // "Nuevo" o "Usado"

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "precio", nullable = false)
    private double precio;

    public Auto_1() {}

    public Auto_1(String marca, int modelo, String color, String condicion, String placa, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.condicion = condicion;
        this.placa = placa;
        this.precio = precio;
    }

    public Long getIdAuto() { return idAuto; }
    public void setIdAuto(Long idAuto) { this.idAuto = idAuto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getModelo() { return modelo; }
    public void setModelo(int modelo) { this.modelo = modelo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getCondicion() { return condicion; }
    public void setCondicion(String condicion) { this.condicion = condicion; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author harol
 */
@Entity
@Table(name = "auto")
@NamedQueries({
    @NamedQuery(name = "Auto_1.findAll", query = "SELECT a FROM Auto_1 a"),
    @NamedQuery(name = "Auto_1.findByPlaca", query = "SELECT a FROM Auto_1 a WHERE a.placa = :placa"),
    @NamedQuery(name = "Auto_1.findByMarca", query = "SELECT a FROM Auto_1 a WHERE a.marca = :marca"),
    @NamedQuery(name = "Auto_1.findByModelo", query = "SELECT a FROM Auto_1 a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Auto_1.findByColor", query = "SELECT a FROM Auto_1 a WHERE a.color = :color"),
    @NamedQuery(name = "Auto_1.findByValorVenta", query = "SELECT a FROM Auto_1 a WHERE a.valorVenta = :valorVenta")})
public class Auto_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_venta")
    private BigDecimal valorVenta;

    public Auto_1() {
    }

    public Auto_1(String placa) {
        this.placa = placa;
    }

    public Auto_1(String placa, String marca, int modelo, String color, BigDecimal valorVenta) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.valorVenta = valorVenta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(BigDecimal valorVenta) {
        this.valorVenta = valorVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auto_1)) {
            return false;
        }
        Auto_1 other = (Auto_1) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Auto_1[ placa=" + placa + " ]";
    }
    
}
>>>>>>> 7515cb150757f0a7c8d5382de865770d1c217827
