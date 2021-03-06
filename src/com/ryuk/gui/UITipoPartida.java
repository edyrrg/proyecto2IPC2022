/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ryuk.gui;

import com.ryuk.partidas.PartidaDamas;
import static com.ryuk.util.Constantes.ICON_UI_IMAGE;
import com.ryuk.util.Utils;
import com.ryuk.player.Player;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author edyrr
 */
public class UITipoPartida extends javax.swing.JFrame {

    private ArrayList<PartidaDamas> listDamas;
    private final ArrayList<Player> listaJugadores;
    private UIMenu windowMain;

    /**
     * Constructor que recibe los parametros necesarios para enviar al siguiente
     * ventana para su funcionamiento adecuado
     *
     * @param _listaJugadores
     * @param _listDamas
     * @param _windowMain
     */
    public UITipoPartida(ArrayList<Player> _listaJugadores, ArrayList<PartidaDamas> _listDamas, UIMenu _windowMain) {
        initComponents();
        ImageIcon icon = new ImageIcon(ICON_UI_IMAGE);
        this.setIconImage(icon.getImage());
        this.listDamas = _listDamas;
        this.windowMain = _windowMain;
        this.listaJugadores = _listaJugadores;
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        lblTipoPartida = new javax.swing.JLabel();
        btnPtVersus = new javax.swing.JButton();
        btnPtMaquina = new javax.swing.JButton();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Damas Chinas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bgPanel.setPreferredSize(new java.awt.Dimension(400, 250));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTipoPartida.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N
        lblTipoPartida.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoPartida.setText("Tipo de Partida");
        bgPanel.add(lblTipoPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnPtVersus.setBackground(new java.awt.Color(7, 7, 60));
        btnPtVersus.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N
        btnPtVersus.setForeground(new java.awt.Color(255, 255, 255));
        btnPtVersus.setText("JcJ");
        btnPtVersus.setName(""); // NOI18N
        btnPtVersus.setPreferredSize(new java.awt.Dimension(110, 75));
        btnPtVersus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPtVersusActionPerformed(evt);
            }
        });
        bgPanel.add(btnPtVersus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        btnPtMaquina.setBackground(new java.awt.Color(7, 7, 60));
        btnPtMaquina.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N
        btnPtMaquina.setForeground(new java.awt.Color(255, 255, 255));
        btnPtMaquina.setText("JcM");
        btnPtMaquina.setPreferredSize(new java.awt.Dimension(110, 75));
        btnPtMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPtMaquinaActionPerformed(evt);
            }
        });
        bgPanel.add(btnPtMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        lblBackGround.setIcon(new javax.swing.ImageIcon("D:\\proyectos_u\\proyecto2\\resource\\BackGroundR4.jpg")); // NOI18N
        bgPanel.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 460, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPtVersusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPtVersusActionPerformed
        // TODO add your handling code here:
        if (Player.cantidadJugadores < 2) {
            JOptionPane.showMessageDialog(this, "\t\tSe necesitan al menos dos jugadores creados para este modo!",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
            int confirm = JOptionPane.showConfirmDialog(this, "??Desea crear un jugador?",
                    "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == 0) {
                if (!crearNuevoJugador()) {
                    return;
                }
            }
            if (confirm == 1 || confirm == -1) {
                return;
            }
        }
        new UIPartidaManageDamas(listaJugadores, listDamas, windowMain);
        this.dispose();
    }//GEN-LAST:event_btnPtVersusActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void btnPtMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPtMaquinaActionPerformed
        // TODO add your handling code here:
        //new UIPartidaManageDamas(listaJugadores, windowMain);
        this.dispose();
    }//GEN-LAST:event_btnPtMaquinaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        windowMain.setFocusMain();
    }//GEN-LAST:event_formWindowClosing

    private boolean crearNuevoJugador() {
        String name = Utils.checkName("Ingrese el nombre del jugador", "Nuevo Jugador", this);
        return Utils.validatePlayer(name, listaJugadores, this);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btnPtMaquina;
    private javax.swing.JButton btnPtVersus;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblTipoPartida;
    // End of variables declaration//GEN-END:variables
}
