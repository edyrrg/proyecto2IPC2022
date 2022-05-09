/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.hanoi;

import com.ryuk.util.Constantes;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author edyrr
 */
public class Disco extends JLabel implements Constantes, Serializable {

    private int valor;

    public Disco(int _valor) {
        this.valor = _valor;
        ImageIcon tmp = seleccionarImg(this.valor);
        this.setIcon(tmp);
        this.setSize(240, 50);
        this.setVisible(true);
    }

    public ImageIcon seleccionarImg(int index) {
        switch (index) {
            case 0:
                return new ImageIcon(IMAGE_DISCO_VACIO);
            case 1:
                return new ImageIcon(IMAGE_DISCO_UNO);
            case 2:
                return new ImageIcon(IMAGE_DISCO_DOS);
            case 3:
                return new ImageIcon(IMAGE_DISCO_TRES);
            case 4:
                return new ImageIcon(IMAGE_DISCO_CUATRO);
            case 5:
                return new ImageIcon(IMAGE_DISCO_CINCO);
            case 6:
                return new ImageIcon(IMAGE_DISCO_SEIS);
            case 7:
                return new ImageIcon(IMAGE_DISCO_SIETE);
            case 8:
                return new ImageIcon(IMAGE_DISCO_OCHO);
            default:
                return null;
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
