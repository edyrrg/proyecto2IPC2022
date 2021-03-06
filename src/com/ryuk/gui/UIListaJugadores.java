/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ryuk.gui;

import com.ryuk.util.Constantes;
import static com.ryuk.util.Constantes.ICON_UI_IMAGE;
import com.ryuk.player.Player;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame que muestra la lista de los jugadores en una JTable
 *
 * @author edyrr
 * @version 1.0
 */
public class UIListaJugadores extends javax.swing.JFrame {

    private final ArrayList<Player> listaJugadores;
    private UIMenu windowMain;

    /**
     * Creates new form UIListaJugadores
     *
     * @param _listaJugadores
     */
    public UIListaJugadores(ArrayList<Player> _listaJugadores, UIMenu _windowMain) {
        initComponents();
        ImageIcon icon = new ImageIcon(ICON_UI_IMAGE);
        this.setIconImage(icon.getImage());
        this.listaJugadores = _listaJugadores;
        this.windowMain = _windowMain;
        cargarListaJugadores();
        this.setVisible(true);
    }

    public void cargarListaJugadores() {
        if (listaJugadores.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La lista de Jugadores esta vacia :C",
                    "Vacia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
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

        bgPanel = new javax.swing.JPanel();
        lblListaJugadores = new javax.swing.JLabel();
        pTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jugadores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        bgPanel.setMinimumSize(new java.awt.Dimension(475, 500));
        bgPanel.setPreferredSize(new java.awt.Dimension(475, 500));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblListaJugadores.setFont(new java.awt.Font("Lato Semibold", 1, 36)); // NOI18N
        lblListaJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblListaJugadores.setText("Lista de Jugadores");
        bgPanel.add(lblListaJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        pTable.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 400));

        tablaJugadores.setFont(new java.awt.Font("Lato Semibold", 1, 18)); // NOI18N
        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJugadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        javax.swing.GroupLayout pTableLayout = new javax.swing.GroupLayout(pTable);
        pTable.setLayout(pTableLayout);
        pTableLayout.setHorizontalGroup(
            pTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(pTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTableLayout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        pTableLayout.setVerticalGroup(
            pTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(pTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTableLayout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        bgPanel.add(pTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 440, 370));

        lblBackGround.setIcon(new javax.swing.ImageIcon("D:\\proyectos_u\\proyecto2\\resource\\BackGroundR2.jpg")); // NOI18N
        bgPanel.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 0, 810, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadoresMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaJugadoresMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        windowMain.setFocusMain();
    }//GEN-LAST:event_formWindowClosed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblListaJugadores;
    private javax.swing.JPanel pTable;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
