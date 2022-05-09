package com.ryuk.damas_chinas;

import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class Ficha implements Serializable {

    protected final ImageIcon img;
    protected int posicionX;
    protected int posicionY;

    public Ficha(ImageIcon _img, int _posicionX, int _posicionY) {
        this.img = _img;
        this.posicionX = _posicionX;
        this.posicionY = _posicionY;
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

    public ImageIcon getImg() {
        return img;
    }

}
