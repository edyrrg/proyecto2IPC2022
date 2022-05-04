/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.damas_chinas;

import com.ryuk.util.Constantes;

/**
 *
 * @author edyrr
 */
public class Movement implements Constantes {

    public static int posicionXi;
    public static int posicionYi;
    public static int posicionXf;
    public static int posicionYf;

    public static void registrarPrimeraPosicion(int x, int y) {
        posicionXi = x;
        posicionYi = y;
    }

    public static void registrarSegundaPosicion(int x, int y) {
        posicionXf = x;
        posicionYf = y;
    }
}
