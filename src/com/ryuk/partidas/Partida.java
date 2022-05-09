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
public class Partida implements Serializable, Cloneable {

    protected int segundos;
    protected int minutos;
    protected int horas;

    public Partida() {
        this.segundos = 0;
        this.minutos = 0;
        this.horas = 0;
    }

    public Partida(int segundos, int minutos, int horas) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    /**
     * construye un string en forma de reloj
     *
     * @return string con un registro de hora
     */
    public String timeToString() {
        String txtS = "", txtM = "", txtH = "";

        if (segundos < 10) {
            txtS = "0" + segundos;
        } else {
            txtS += segundos;
        }

        if (minutos < 10) {
            txtM = "0" + minutos;
        } else {
            txtM += minutos;
        }

        if (horas < 10) {
            txtH = "0" + horas;
        } else {
            txtH += horas;
        }
        String reloj = txtH + ":" + txtM + ":" + txtS;
        return reloj;
    }

    public void registrarReloj(int horas, int minutos, int segundos) {
        this.setHoras(horas);
        this.setMinutos(minutos);
        this.setSegundos(segundos);
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

}
