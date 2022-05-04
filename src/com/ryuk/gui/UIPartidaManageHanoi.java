/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ryuk.gui;

import com.ryuk.player.Player;
import static com.ryuk.util.Constantes.ICON_UI_IMAGE;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edyrr
 */
public class UIPartidaManageHanoi extends javax.swing.JFrame {

    private int seleccionPlayer;
    private final ArrayList<Player> listaJugadores;
    private UIMenu windowMain;

    /**
     * Creates new form UIPartidaManageHanoi
     */
    public UIPartidaManageHanoi(ArrayList<Player> _listaJugadores, UIMenu _windowMain) {
        initComponents();
        ImageIcon icon = new ImageIcon(ICON_UI_IMAGE);
        this.setIconImage(icon.getImage());
        this.listaJugadores = _listaJugadores;
        this.windowMain = _windowMain;
        tablaJugadores.setEnabled(false);
        cargarListaJugadores();
        this.setVisible(true);
    }

    public void cargarListaJugadores() {
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        model.getDataVector().removeAllElements();
        for (Player jugador : listaJugadores) {
            model.addRow(new Object[]{jugador.getId(), jugador.getNombre()});
        }
        tablaJugadores.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        bgPanel = new javax.swing.JPanel();
        btnPartidaNormal = new javax.swing.JButton();
        btnSolucionRapida = new javax.swing.JButton();
        btnIniciarPartida = new javax.swing.JButton();
        btnCargarPartida = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        lblJugadorElegido = new javax.swing.JLabel();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 490));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPartidaNormal.setBackground(new java.awt.Color(7, 7, 60));
        btnPartidaNormal.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnPartidaNormal.setForeground(new java.awt.Color(255, 255, 255));
        btnPartidaNormal.setText("Partida Normal");
        btnPartidaNormal.setPreferredSize(new java.awt.Dimension(170, 50));
        btnPartidaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaNormalActionPerformed(evt);
            }
        });
        bgPanel.add(btnPartidaNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, -1));

        btnSolucionRapida.setBackground(new java.awt.Color(7, 7, 60));
        btnSolucionRapida.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnSolucionRapida.setForeground(new java.awt.Color(255, 255, 255));
        btnSolucionRapida.setText("Solucion Rapida");
        btnSolucionRapida.setPreferredSize(new java.awt.Dimension(170, 50));
        bgPanel.add(btnSolucionRapida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        btnIniciarPartida.setBackground(new java.awt.Color(7, 7, 60));
        btnIniciarPartida.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnIniciarPartida.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarPartida.setText("Iniciar Partida");
        btnIniciarPartida.setEnabled(false);
        btnIniciarPartida.setPreferredSize(new java.awt.Dimension(170, 50));
        bgPanel.add(btnIniciarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        btnCargarPartida.setBackground(new java.awt.Color(7, 7, 60));
        btnCargarPartida.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnCargarPartida.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarPartida.setText("Cargar Partida");
        btnCargarPartida.setPreferredSize(new java.awt.Dimension(170, 50));
        bgPanel.add(btnCargarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        tablaJugadores.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tablaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJugadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        lblJugadorElegido.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        lblJugadorElegido.setForeground(new java.awt.Color(255, 255, 255));
        lblJugadorElegido.setText("Jugador Elegido: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblJugadorElegido)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblJugadorElegido)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        bgPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 400, 340));

        lblBackGround.setIcon(new javax.swing.ImageIcon("D:\\proyectos_u\\proyecto2\\resource\\BackGroundR3.jpg")); // NOI18N
        bgPanel.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 820, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Esta seguro de regresar al menu principal?",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 1) {
            return;
        }
        if (confirm == -1) {
            return;
        }
        windowMain.setFocusMain();
    }//GEN-LAST:event_formWindowClosing

    private void btnPartidaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaNormalActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Seleccione el jugador con el que desea empezar la partida...",
                "Damas Chinas", JOptionPane.INFORMATION_MESSAGE);
        tablaJugadores.setEnabled(true);
        btnPartidaNormal.setEnabled(false);
        btnCargarPartida.setEnabled(false);
        btnSolucionRapida.setEnabled(false);
        btnIniciarPartida.setEnabled(true);
    }//GEN-LAST:event_btnPartidaNormalActionPerformed

    private void tablaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadoresMouseClicked
        // TODO add your handling code here:
        elegirJugador();
    }//GEN-LAST:event_tablaJugadoresMouseClicked

    private void elegirJugador() {
        try {
            Player player;
            int confirm;
            int tmpSeleccion = tablaJugadores.getSelectedRow();
            player = listaJugadores.get(tmpSeleccion);
            confirm = JOptionPane.showConfirmDialog(this, "¿Desea elegir a " + player.getNombre() + " ?",
                    "Elegir Jugador", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == 1) {
                return;
            }
            if (confirm == -1) {
                return;
            }
            seleccionPlayer = tmpSeleccion;
            String tmpTxt = lblJugadorElegido.getText();
            lblJugadorElegido.setText(tmpTxt + " "
                    + listaJugadores.get(seleccionPlayer).getNombre());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("no apunto a nada");
        } catch (NullPointerException e) {
            System.err.println("no existo en la lista");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btnCargarPartida;
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnPartidaNormal;
    private javax.swing.JButton btnSolucionRapida;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblJugadorElegido;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
