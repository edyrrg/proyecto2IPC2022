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
public class Pila implements Serializable {

    private int contNodo = 0;
    private Nodo cabeza;

    public int getContNodo() {
        return contNodo;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void push(Nodo nuevoItem) {
        contNodo++;
        if (cabeza == null) {
            cabeza = nuevoItem;
            return;
        }
        nuevoItem.setAbajo(cabeza);
        cabeza.setArriba(nuevoItem);
        cabeza = nuevoItem;

    }

    public void pop() {
        if (contNodo > 0) {
            contNodo--;
            cabeza = cabeza.getAbajo();
        }
    }

    public Disco peek() {
        return cabeza.getDato();
    }
}
