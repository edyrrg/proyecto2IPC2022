/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.damas_chinas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author edyrr
 */
public class Casilla extends JLabel {
    
    protected int posicionX;
    protected int posicionY;

    public Casilla(ImageIcon img, int _posicionX, int _posicionY) {
        this.posicionX = _posicionX;
        this.posicionY = _posicionY;
        this.setIcon(img);
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
}
