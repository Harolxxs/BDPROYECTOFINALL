/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente_1.findAll", query = "SELECT c FROM Cliente_1 c"),
    @NamedQuery(name = "Cliente_1.findByIdCliente", query = "SELECT c FROM Cliente_1 c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente_1.findByNombre", query = "SELECT c FROM Cliente_1 c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente_1.findByApellido", query = "SELECT c FROM Cliente_1 c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente_1.findByDireccion", query = "SELECT c FROM Cliente_1 c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente_1.findByTipoId", query = "SELECT c FROM Cliente_1 c WHERE c.tipoId = :tipoId")})
public class Cliente_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "tipo_id")
    private String tipoId;

    public Cliente_1() {
    }

    public Cliente_1(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente_1(Long idCliente, String nombre, String apellido, String direccion, String tipoId) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.tipoId = tipoId;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente_1)) {
            return false;
        }
        Cliente_1 other = (Cliente_1) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cliente_1[ idCliente=" + idCliente + " ]";
    }
    
}
