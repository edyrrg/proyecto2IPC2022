package com.ryuk.damas_chinas;

import com.ryuk.util.Constantes;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class CasillaBlanca extends Casilla implements Constantes {

    private Damas tablero;
    private JFrame ventanaMain;
    private Ficha ficha;

    public CasillaBlanca(int _posicionX, int _posicionY, Ficha _ficha, Damas _tablero, JFrame _ventanaMain) {
        super(new ImageIcon(IMAGE_CASILLA_BLANCA), _posicionX, _posicionY);
        super.setVisible(true);
        super.setSize(75, 75);
        this.ficha = _ficha;
        this.posicionarFicha();
        this.tablero = _tablero;
        this.ventanaMain = _ventanaMain;
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
//                super.mouseClicked(me);
                movimiento();
            }
        });
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void posicionarFicha() {
        if (this.ficha != null) {
            this.setIcon(ficha.getImg());
        }
    }

    public void movimiento() {
        
        revalidateTablero();
        posiblesMovimientos();
        repaintTablero();
    }
    
    public void enMovimiento(Casilla casillita){
        Movement.registrarPrimeraPosicion(posicionX, posicionY);
        System.out.println("se registro: " + Movement.posicionXi + "," + Movement.posicionYi);
    }
    
    public void posiblesMovimientos() {
        Casilla[][] tablerito = tablero.getTablero();
        Casilla casillita = tablerito[posicionX][posicionY];
        System.out.println("Estoy en: " + posicionX + "," + posicionY);
        if (casillita instanceof CasillaBlanca) {
            if (noExisteFichaEnCasilla(casillita)) {
                return;
            }
        }
        
        primerMovimiento(tablerito);
        segundoMovimiento(tablerito);
        tercerMovimiento(tablerito);
        cuartoMovimiento(tablerito);
    }

    public void primerMovimiento(Casilla[][] tablerito) {
        if (posicionX - 1 < 0) {
            return;
        }
        if (posicionY + 1 >= MAX_CASILLAS) {
            return;
        }
        System.out.println((posicionX - 1) + "," + (posicionY + 1));
        if (noExisteFichaEnCasilla(tablerito[posicionX - 1][posicionY + 1])) {
            tablerito[posicionX - 1][posicionY + 1].setIcon(new ImageIcon(IMAGE_CASILLA_VERDE));
        }
    }

    public void segundoMovimiento(Casilla[][] tablerito) {
        if (posicionX + 1 >= MAX_CASILLAS) {
            return;
        }
        if (posicionY + 1 >= MAX_CASILLAS) {
            return;
        }
        System.out.println((posicionX + 1) + "," + (posicionY + 1));
        if (noExisteFichaEnCasilla(tablerito[posicionX + 1][posicionY + 1])) {
            tablerito[posicionX + 1][posicionY + 1].setIcon(new ImageIcon(IMAGE_CASILLA_VERDE));
        }
    }

    public void tercerMovimiento(Casilla[][] tablerito) {
        if (posicionX + 1 >= MAX_CASILLAS) {
            return;
        }
        if (posicionY - 1 < 0) {
            return;
        }
        System.out.println((posicionX + 1) + "," + (posicionY - 1));
        if (noExisteFichaEnCasilla(tablerito[posicionX + 1][posicionY - 1])) {
            tablerito[posicionX + 1][posicionY - 1].setIcon(new ImageIcon(IMAGE_CASILLA_VERDE));
        }
    }

    public void cuartoMovimiento(Casilla[][] tablerito) {
        if (posicionX - 1 < 0) {
            return;
        }
        if (posicionY - 1 < 0) {
            return;
        }
        System.out.println((posicionX - 1) + "," + (posicionY - 1));
        if (noExisteFichaEnCasilla(tablerito[posicionX - 1][posicionY - 1])) {
            tablerito[posicionX - 1][posicionY - 1].setIcon(new ImageIcon(IMAGE_CASILLA_VERDE));
        }
    }

    /**
     * Verifica si existe una ficha en un casilla
     *
     * @param casillita
     * @return Falso si existe una ficha en esa casilla
     */
    public boolean noExisteFichaEnCasilla(Casilla casillita) {

        CasillaBlanca CasillitaBlanca = (CasillaBlanca) casillita;
        if (CasillitaBlanca.getFicha() == null) {
            System.out.println("No contengo una ficha");
            return true;
        }
        System.out.println("Contengo una ficha");
        return false;
    }

    public void revalidateTablero() {
        for (int i = 0; i < MAX_CASILLAS; i++) {
            for (int j = 0; j < MAX_CASILLAS; j++) {
                Casilla tmp = tablero.getTablero()[i][j];
                if (tmp instanceof CasillaBlanca) {
                    if (((CasillaBlanca) tmp).getFicha() instanceof Ficha) {
                        continue;
                    }
                    tmp.setIcon(new ImageIcon(IMAGE_CASILLA_BLANCA));
                }
                tablero.add(tmp);
            }
        }
        ventanaMain.revalidate();
        ventanaMain.repaint();
    }

    public void repaintTablero() {
        for (int i = 0; i < MAX_CASILLAS; i++) {
            for (int j = 0; j < MAX_CASILLAS; j++) {
                Casilla tmp = tablero.getTablero()[i][j];
                tablero.add(tmp);
            }
        }
        ventanaMain.revalidate();
        ventanaMain.repaint();
    }
}
