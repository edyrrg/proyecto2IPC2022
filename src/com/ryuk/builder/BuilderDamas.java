package com.ryuk.builder;

import com.ryuk.util.Constantes;
import com.ryuk.damas_chinas.Casilla;
import com.ryuk.damas_chinas.CasillaBlanca;
import com.ryuk.damas_chinas.CasillaNegra;
import com.ryuk.damas_chinas.FichaBlanca;
import com.ryuk.damas_chinas.FichaNegra;
import com.ryuk.damas_chinas.Damas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class BuilderDamas implements Constantes {

    /**
     * Construye el arreglo de casilla del tablero juntos sus fichas estas
     * tambien son agregadas al layout para ser mostrado en pantalla
     *
     * @param tablero
     * @param main
     */
    public static void generateTable(Damas tablero, JFrame main) {
        tablero.setBounds(40, 40, MAX_SIZE_TABLERO, MAX_SIZE_TABLERO);
        for (int i = 0; i < MAX_CASILLAS; i++) {
            for (int j = 0; j < MAX_CASILLAS; j++) {
                if ((i + 1) % 2 == 0) {
                    Casilla tmp = generateCasillaFilaImpar(i, j, tablero, main);
                    tablero.getTablero()[i][j] = tmp;
                    tablero.add(tmp);
                }
                if ((i + 1) % 2 != 0) {
                    Casilla tmp = generateCasillaFilaPar(i, j, tablero, main);
                    tablero.getTablero()[i][j] = tmp;
                    tablero.add(tmp);
                }
            }
        }
    }

    /**
     * Generador de casillas en fila impar segun la columna en la que es
     * generada
     *
     * @param x
     * @param y
     * @param tablero
     * @param main
     * @return la casilla creada segun los parametros
     */
    public static Casilla generateCasillaFilaImpar(int x, int y, Damas tablero, JFrame main) {
        if (y % 2 == 0) {
            if (x <= 2) {
                return new CasillaBlanca(x, y, new FichaNegra(x, y), tablero, main);
            }
            if (x >= 5) {
                return new CasillaBlanca(x, y, new FichaBlanca(x, y), tablero, main);
            }
            return new CasillaBlanca(x, y, null, tablero, main);
        }
        return new CasillaNegra(x, y);
    }

    /**
     * Generador de casillas en fila par segun la columna en la que es generada
     *
     * @param x
     * @param y
     * @param tablero
     * @param main
     * @return la casilla creada segun los parametros
     */
    public static Casilla generateCasillaFilaPar(int x, int y, Damas tablero, JFrame main) {
        if (y % 2 == 0) {
            return new CasillaNegra(x, y);
        }
        if (x <= 2) {
            return new CasillaBlanca(x, y, new FichaNegra(x, y), tablero, main);
        }
        if (x >= 5) {
            return new CasillaBlanca(x, y, new FichaBlanca(x, y), tablero, main);
        }
        return new CasillaBlanca(x, y, null, tablero, main);
    }

    public static void updateReference(Damas damas, JFrame main) {

        for (int i = 0; i < MAX_CASILLAS; i++) {
            for (int j = 0; j < MAX_CASILLAS; j++) {
                try {
                    //obtiene la casilla especificada
                    Casilla tmpTablero = damas.getCasilla(i, j);
                    //comprueba que la casilla sea una casilla tipo Blanca
                    if (tmpTablero instanceof CasillaBlanca) {
                        CasillaBlanca tmpCasillaBlanca;
                        tmpCasillaBlanca = (CasillaBlanca) tmpTablero;
                        tmpCasillaBlanca.setVentanaMain(main);
                        tmpCasillaBlanca.crearMiMouseClicked();
                    }
                } catch (Damas.Casilla_Error ex) {
                    System.err.println(ex);
                }

            }
        }
    }
}
