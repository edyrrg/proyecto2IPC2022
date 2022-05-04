/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.cronometro;

import com.ryuk.util.Constantes;
import javax.swing.JLabel;

/**
 *
 * @author edyrr
 */
public class Cronometro extends Thread implements Constantes {

    private JLabel crono;
    private int counter;
    public int segundos;
    public int minutos;
    public int horas;

    private boolean encendido;

    public Cronometro() {
        this.counter = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        this.encendido = false;
    }

    /**
     * Constructor cuando no se necesite definir el reloj del cronometro
     *
     * @param _cronometro
     */
    public Cronometro(JLabel _cronometro) {
        this.crono = _cronometro;
        this.counter = 0;
        this.segundos = 0;
        this.minutos = 0;
        this.horas = 0;
        this.encendido = false;
    }

    /**
     * Constructor cuando se necesite definir el reloj del cronometro
     *
     * @param _s
     * @param _m
     * @param _h
     * @param _cronometro
     */
    public Cronometro(int _s, int _m, int _h, JLabel _cronometro) {
        this.crono = _cronometro;
        this.counter = 0;
        this.segundos = _s;
        this.minutos = _m;
        this.horas = _h;
        this.encendido = false;
    }

    /**
     * Sobrecarga del metodo run de la clase Thread(Runnable) para iniciar el
     * cronometro, mientras encendido sea verdadero el reloj del cronometro se
     * ejecutara
     */
    @Override
    public void run() {
        try {
            while (encendido) {
                Thread.sleep(SECOND);
                ejecutarHiloCronometro(counter);
                counter++;
            }
            System.out.println(this.isAlive());
        } catch (Exception e) {
            System.err.println("Revisar cronometro, " + e.getMessage());
        }
        System.out.println("El cronometro termino su conteo");
    }

    /**
     * Logica detras del hilo para que el reloj funcione de manera correcta con
     * la referencia del label que se le manda del juego
     *
     * @param counter
     */
    private void ejecutarHiloCronometro(int counter) {
        segundos++;
        if (segundos > 59) {
            segundos = 0;
            minutos++;
        }
        if (minutos > 59) {
            minutos = 0;
            horas++;
        }

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
        //manda los datos del reloj para que sea impreso en el contador del juego
        String relog = txtH + ":" + txtM + ":" + txtS;
        crono.setText(relog);
    }

    /**
     * Inicia el hilo (cronometro)
     */
    public void iniciarCronometro() {

        encendido = true;
        this.start();

    }

    /**
     * Para el hilo (cronometro)
     */
    public void pararCronometro() {

        encendido = false;

    }

    public JLabel getCrono() {
        return crono;
    }

    public void setCrono(JLabel crono) {
        this.crono = crono;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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
