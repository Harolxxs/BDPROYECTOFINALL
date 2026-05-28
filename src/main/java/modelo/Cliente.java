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
public class Cliente extends Persona {
    public long nume1;
    public long nume2;
    public long nume3;

    public Cliente(long nume1, long nume2, long nume3) {
        this.nume1 = nume1;
        this.nume2 = nume2;
        this.nume3 = nume3;
    }

    public Cliente() {
    }

    public long getNume1() {
        return nume1;
    }

    public void setNume1(long nume1) {
        this.nume1 = nume1;
    }

    public long getNume2() {
        return nume2;
    }

    public void setNume2(long nume2) {
        this.nume2 = nume2;
    }

    public long getNume3() {
        return nume3;
    }

    public void setNume3(long nume3) {
        this.nume3 = nume3;
    }




}
