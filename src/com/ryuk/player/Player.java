/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.player;

import java.io.Serializable;

/**
 *
 * @author edyrr
 */
public class Player implements Serializable{

    private final int ID;
    private String nombre;
    private int victorias;
    private int derrotas;
    public static int cantidadJugadores = 0;

    public Player(String _nombre) {
        this.nombre = _nombre;
        this.victorias = 0;
        this.derrotas = 0;
        this.ID = ++cantidadJugadores;
    }


    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.ID;
    }
    
    public static void setCantidadJugadores(int lastID){
        cantidadJugadores = lastID;
    }
}
