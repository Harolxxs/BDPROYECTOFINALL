/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.*;
import java.io.Serializable;
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
@Table(name = "vendedor")
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor_1 v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor_1 v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor_1 v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vendedor.findByApellido", query = "SELECT v FROM Vendedor_1 v WHERE v.apellido = :apellido"),
    @NamedQuery(name = "Vendedor.findByCorreo", query = "SELECT v FROM Vendedor_1 v WHERE v.correo = :correo")})
public class Vendedor_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_vendedor")
    private Long idVendedor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;

    public Vendedor_1() {
    }

    public Vendedor_1(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor_1(Long idVendedor, String nombre, String apellido, String correo) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor_1)) {
            return false;
        }
        Vendedor_1 other = (Vendedor_1) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }
}
