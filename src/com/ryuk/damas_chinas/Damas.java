/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.damas_chinas;

import com.ryuk.util.Constantes;
import java.awt.LayoutManager;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author edyrr
 */
public class Damas extends JPanel implements Constantes, Serializable {

    private Casilla[][] tablero;

    public Damas(LayoutManager _lm) {
        super(_lm);
        this.tablero = new Casilla[MAX_CASILLAS][MAX_CASILLAS];
    }

    public Casilla getCasilla(int x, int y) throws Casilla_Error {
        if (this.tablero[x][y] != null) {
            return tablero[x][y];
        }
        throw new Casilla_Error("No existe Casilla en esa posicion!");
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void hacerMovimiento(int posicionX, int posicionY) {
        try {
            Casilla tmp = this.getCasilla(posicionX, posicionY);
            System.out.println(posicionX + ", " + posicionY);
            System.out.println(tmp.getPosicionX() + ", " + tmp.getPosicionY());
        } catch (Casilla_Error e) {
            System.err.print(e);
        }

    }


    public class Casilla_Error extends Exception {

        public Casilla_Error() {

        }

        public Casilla_Error(String errMsg) {
            super(errMsg);
        }

    }
}
