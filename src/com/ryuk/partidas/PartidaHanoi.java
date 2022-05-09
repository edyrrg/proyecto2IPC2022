package com.ryuk.partidas;

import com.ryuk.hanoi.Hanoi;
import com.ryuk.player.Player;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class PartidaHanoi extends Partida implements Serializable {

    private final int ID;
    private Hanoi ptHanoi;
    private final Player jugador;
    private int contadorMovimientos;
    private boolean partidaGanada;
    private boolean partidaPerdida;
    private boolean partidaAbandonada;
    private boolean partidaEnCurso;
    public static transient int contadorID;

    public PartidaHanoi(Hanoi ptHanoi, Player jugador, int contadorMovimientos) {
        
        this.ID = ++contadorID;
        this.ptHanoi = ptHanoi;
        this.jugador = jugador;
        this.partidaEnCurso = true;
        this.contadorMovimientos = contadorMovimientos;
    }

    public PartidaHanoi(Player jugador, int _contadorMovimientos, boolean partidaGanada) {
        
        this.ID = ++contadorID;
        this.jugador = jugador;
        this.contadorMovimientos = _contadorMovimientos;
        this.partidaGanada = partidaGanada;
        definirPartidaGanada();
    }

    public void definirPartidaGanada() {
        if (partidaGanada) {
            partidaPerdida = false;
            partidaAbandonada = false;
        }
        if (!partidaGanada) {
            partidaPerdida = true;
            partidaAbandonada = true;
        }
    }

    public boolean isPartidaEnCurso() {
        return partidaEnCurso;
    }

    public void setPartidaEnCurso(boolean partidaEnCurso) {
        this.partidaEnCurso = partidaEnCurso;
    }

    public boolean isPartidaPerdida() {
        return partidaPerdida;
    }

    public void setPartidaPerdida(boolean partidaPerdida) {
        this.partidaPerdida = partidaPerdida;
    }

    public boolean isPartidaAbandonada() {
        return partidaAbandonada;
    }

    public void setPartidaAbandonada(boolean partidaAbandonada) {
        this.partidaAbandonada = partidaAbandonada;
    }

    public int getContadorMovientos() {
        return contadorMovimientos;
    }

    public void setContadorMovientos(int contadorMoviemtos) {
        this.contadorMovimientos = contadorMoviemtos;
    }

    public int getID() {
        return ID;
    }

    public Player getJugador() {
        return jugador;
    }

    public Hanoi getPtHanoi() {
        return ptHanoi;
    }

    public void setPtHanoi(Hanoi ptHanoi) {
        this.ptHanoi = ptHanoi;
    }

    public boolean isPartidaGanada() {
        return partidaGanada;
    }

    public void setPartidaGanada(boolean partidaGanada) {
        this.partidaGanada = partidaGanada;
    }

    public static void setContadorPartida(int lastID) {
        contadorID = lastID;
    }
}
