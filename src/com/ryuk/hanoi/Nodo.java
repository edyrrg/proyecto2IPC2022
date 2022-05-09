/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.hanoi;

import java.io.Serializable;

/**
 *
 * @author edyrr
 */
public class Nodo implements Serializable{

    private Disco dato;
    private Nodo arriba;
    private Nodo abajo;

    public Disco getDato() {
        return dato;
    }

    public void setDato(Disco disco) {
        this.dato = disco;
    }

    public Nodo getArriba() {
        return arriba;
    }

    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

}
