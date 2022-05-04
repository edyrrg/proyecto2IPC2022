/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.util;

/**
 *
 * @author edyrr
 */
public interface Constantes {

    /**
     * Maximo de casillas del tablero
     */
    public final int MAX_CASILLAS = 8;
    /**
     * Maximo de pixeles del tablero
     */
    public final int MAX_SIZE_TABLERO = 600;
    /**
     * Un segundo en milisegundos
     */
    public final int SECOND = 1000;
    /**
     * Ruta del incono para las ventanas del proyecto
     */
    public final String ICON_UI_IMAGE = "resource/icono.png";
    /**
     * Ruta de la imagen para las casillas blancas
     */
    public final String IMAGE_CASILLA_BLANCA = "resource/casillaBlanca.png";
    /**
     * Ruta de la imagen para las casillas negras
     */
    public final String IMAGE_CASILLA_NEGRA = "resource/casillaNegra.png";
    /**
     * Ruta de la imagen para las casillas de posibles movimientos
     */
    public final String IMAGE_CASILLA_VERDE = "resource/casillaVerde.png";
    /**
     * Maximo de jugadores que se pueden elegir en un partida de damas chinas
     */
    public final int MAXIMO_JUGADORES_PARTIDA = 2;
    
    public final String RUTA_DATA_PLAYER = "data/dataPlayers/";
    
    public final String NAME_FILE_DATA_PLAYER = "listPlayers.list";
}
