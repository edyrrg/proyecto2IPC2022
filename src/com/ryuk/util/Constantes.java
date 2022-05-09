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
    /**
     * Path donde se aloja las lista de jugadores
     */
    public final String RUTA_DATA_PLAYER = "data/dataPlayers/";
    /**
     * Nombre del archivo donde se guarda la lista de jugadores
     */
    public final String NAME_FILE_DATA_PLAYER = "listPlayers.list";
    /**
     * Path donde se alojan los archivos de las partidas
     */
    public final String RUTA_DATA_PARTIDAS = "data/dataPartida/";
    /**
     * Nombre del archivo donde se guardan la lista de partidas de tipo
     * PartidaDamas
     */
    public final String NAME_FILE_DATA_PTDAMAS = "listPtDamas.data";
    /**
     * Nombre del archivo donde se guardan la lista de partidas de tipo
     * PartidaHanoi
     */
    public final String NAME_FILE_DATA_PTHANOI = "listPtHanoi.data";
    /**
     * Path de la ubicacion de la imagen para el disco 1
     */
    public final String IMAGE_DISCO_UNO = "resource/disco1.png";
    /**
     * Path de la ubicacion de la imagen para el disco 2
     */
    public final String IMAGE_DISCO_DOS = "resource/disco2.png";
    /**
     * Path de la ubicacion de la imagen para el disco 3
     */
    public final String IMAGE_DISCO_TRES = "resource/disco3.png";
    /**
     * Path de la ubicacion de la imagen para el disco 4
     */
    public final String IMAGE_DISCO_CUATRO = "resource/disco4.png";
    /**
     * Path de la ubicacion de la imagen para el disco 5
     */
    public final String IMAGE_DISCO_CINCO = "resource/disco5.png";
    /**
     * Path de la ubicacion de la imagen para el disco 6
     */
    public final String IMAGE_DISCO_SEIS = "resource/disco6.png";
    /**
     * Path de la ubicacion de la imagen para el disco 7
     */
    public final String IMAGE_DISCO_SIETE = "resource/disco7.png";
    /**
     * Path de la ubicacion de la imagen para el disco 8
     */
    public final String IMAGE_DISCO_OCHO = "resource/disco8.png";
    /**
     * Path de la ubicacion de la imagen para el disco vacio
     */
    public final String IMAGE_DISCO_VACIO = "resource/discoVacio.png";
}
