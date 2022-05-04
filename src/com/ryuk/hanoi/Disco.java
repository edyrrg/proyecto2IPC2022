/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.hanoi;

import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author edyrr
 */
public class Disco extends JLabel {

    private int valor;

    public Disco(int _valor, ImageIcon _img, int _width, int _height) {
        this.valor = _valor;
        this.setIcon(_img);
        this.setSize(_width, _height);
        this.setVisible(true);
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
//                super.mouseClicked(me);
                System.out.println("Hago algo");
            }
        });
    }
}
