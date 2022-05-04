/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.damas_chinas;

import com.ryuk.util.Constantes;
import javax.swing.ImageIcon;

/**
 *
 * @author edyrr
 */
public class CasillaNegra extends Casilla implements Constantes{

    public CasillaNegra(int _posicionX, int _posicionY) {
        super(new ImageIcon(IMAGE_CASILLA_NEGRA), _posicionX, _posicionY);
        super.setVisible(true);
        super.setSize(75, 75);
    }
}
