/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author harol
 
 Los datos de los autos que el concesionario desea conservar se refieren a marca, modelo, color, condición (nuevo o usado), 
 * número de la placa y el precio para la venta.  
 * Una vez realizada la venta es necesario que sean registrados datos como fecha de la venta, 
 * cliente que realizó la compra, valor de la venta, vendedor y forma de pago (contado, crédito). 
 
 */
public class Auto {
    public String marca;
    public int modelo;
    public String color;
    public String placa;
    public double valor_venta;

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValor_venta() {
        return valor_venta;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }
    
    
}