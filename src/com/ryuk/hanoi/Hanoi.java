/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.hanoi;

import com.ryuk.cronometro.Cronometro;
import java.io.Serializable;

/**
 *
 * @author edyrr
 */
public class Hanoi implements Serializable {
    private int numDiscos;
    private Pila pila_A;
    private Pila pila_B;
    private Pila pila_C;

    public int getNumDiscos() {
        return numDiscos;
    }

    public void setNumDiscos(int numDiscos) {
        this.numDiscos = numDiscos;
    }

    public Pila getPila_A() {
        return pila_A;
    }

    public void setPila_A(Pila pila_A) {
        this.pila_A = pila_A;
    }

    public Pila getPila_B() {
        return pila_B;
    }

    public void setPila_B(Pila pila_B) {
        this.pila_B = pila_B;
    }

    public Pila getPila_C() {
        return pila_C;
    }

    public void setPila_C(Pila pila_C) {
        this.pila_C = pila_C;
    }

}
