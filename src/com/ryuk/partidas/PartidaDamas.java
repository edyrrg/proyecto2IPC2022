/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.partidas;

import com.ryuk.damas_chinas.Damas;
import com.ryuk.player.Player;

/**
 *
 * @author edyrr
 */
public class PartidaDamas extends Partida {

    private final int ID;
    private final Damas juegoDamas;
    private Player jugadorUno;
    private Player jugadorDos;
    private int contadorMovimientosJugadorUno;
    private int contadorMovimientoJugadorDos;
    private boolean partidaFinalizada;
    private int ganador;
    public static int contadorID;

    public PartidaDamas(Damas juegoDamas, Player jugadorUno, Player jugadorDos) {
        this.juegoDamas = juegoDamas;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.contadorMovimientosJugadorUno = 0;
        this.contadorMovimientoJugadorDos = 0;
        this.ID = ++contadorID;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (PartidaDamas) super.clone();
    }

    /**
     * Define el ganador de la partida, 0 para jugador uno, 1 para jugador dos
     *
     * @param value
     */
    public void definirGanador(int value) {
        if (value == 1 || value == 0) {
            this.ganador = value;
        } else {
            System.out.println("Error al definir ganador");
        }
    }

    public Player getGanador() {
        return (ganador == 0) ? jugadorUno : jugadorDos;
    }

    public Player getPerdedor() {
        return (ganador == 0) ? jugadorDos : jugadorUno;
    }

    public void contarMovimientoJuno() {
        this.contadorMovimientosJugadorUno++;
    }

    public void contarMovimientoJdos() {
        this.contadorMovimientoJugadorDos++;
    }

    public Player getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(Player jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    public Player getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(Player jugadorDos) {
        this.jugadorDos = jugadorDos;
    }

    public int getContadorMovimientosJugadorUno() {
        return contadorMovimientosJugadorUno;
    }

    public void setContadorMovimientosJugadorUno(int contadorMovimientosJugadorUno) {
        this.contadorMovimientosJugadorUno = contadorMovimientosJugadorUno;
    }

    public int getContadorMovimientoJugadorDos() {
        return contadorMovimientoJugadorDos;
    }

    public void setContadorMovimientoJugadorDos(int contadorMovimientoJugadorDos) {
        this.contadorMovimientoJugadorDos = contadorMovimientoJugadorDos;
    }

    public Damas getJuedoDamas() {
        return juegoDamas;
    }

    public boolean isPartidaFinalizada() {
        return partidaFinalizada;
    }

    public void setPartidaFinalizada(boolean partidaFinalizada) {
        this.partidaFinalizada = partidaFinalizada;
    }

    public int getID() {
        return ID;
    }

    public static void setContadorPartida(int lastID) {
        contadorID = lastID;
    }
}
