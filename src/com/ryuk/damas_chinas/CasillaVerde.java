package com.ryuk.damas_chinas;

import com.ryuk.util.Constantes;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edyrr
 */
public class CasillaVerde extends Casilla implements Constantes{
    public CasillaVerde(int _posicionX, int _posicionY) {
        super(new ImageIcon(IMAGE_CASILLA_VERDE), _posicionX, _posicionY);
        super.setVisible(true);
        super.setSize(75, 75);
    }
}
