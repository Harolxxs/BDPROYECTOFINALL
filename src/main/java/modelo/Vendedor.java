/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author harol
 */
public class Vendedor extends Persona{
    
    public long id_vendedor;
    public String correo;

    public long getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Vendedor(long id_vendedor, String correo) {
        this.id_vendedor = id_vendedor;
        this.correo = correo;
    }

    public Vendedor() {
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
