/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author harol
 */

import java.io.Serializable;

import jakarta.persistence.*; 

public class Persona {
    public String nombre;
    public String direccion;
    public String ciudad;   
    public long id;
    public String tipo_id;

    public Persona(String nombre, String direccion, String ciudad, long id, String tipo_id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.id = id;
        this.tipo_id = tipo_id;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }
    
    
}
