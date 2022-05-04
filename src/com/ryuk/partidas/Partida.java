/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.partidas;

import java.io.Serializable;

/**
 *
 * @author edyrr
 */
public class Partida implements Serializable {

    protected int[] registroCronometro;
    
    public Partida() {
        this.registroCronometro = new int[3];
    }

    public void setSegundo(int _s) {
        this.registroCronometro[0] = _s;
    }

    public void setMinutos(int _m) {
        this.registroCronometro[1] = _m;
    }

    public void setHoras(int _h) {
        this.registroCronometro[2] = _h;
    }

    public int getSegundos() {
        return this.registroCronometro[0];
    }

    public int getMinutos() {
        return this.registroCronometro[1];
    }

    public int getHoras() {
        return this.registroCronometro[2];
    }

    public int[] getRegistroCronometro() {
        return registroCronometro;
    }

    public void setRegistroCronometro(int[] registroCronometro) {
        this.registroCronometro = registroCronometro;
    }

}
