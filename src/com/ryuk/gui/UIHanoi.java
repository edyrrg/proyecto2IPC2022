/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ryuk.gui;

import com.ryuk.cronometro.Cronometro;
import com.ryuk.hanoi.Disco;
import com.ryuk.hanoi.Hanoi;
import com.ryuk.hanoi.Nodo;
import com.ryuk.hanoi.Pila;
import com.ryuk.partidas.PartidaHanoi;
import com.ryuk.player.Player;
import com.ryuk.util.Constantes;
import static com.ryuk.util.Constantes.ICON_UI_IMAGE;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author edyrr
 */
public class UIHanoi extends javax.swing.JFrame implements Constantes {

    private ArrayList<PartidaHanoi> listaHanoi;
    private Hanoi juegoHanoi;
    private Pila pila_A;
    private Pila pila_B;
    private Pila pila_C;
    private int numMovimientos;
    private int numDiscos;
    private UIMenu windowMain;
    private Player jugador;
    private Cronometro crono;
    private int ID;
    private boolean salir;

    /**
     * Constructor por defecto que crea la partida con los discos que fueron
     * mandados por el form anterior
     *
     * @param _listaHanoi
     * @param _jugador
     * @param _windowMain
     * @param _numDiscos
     */
    public UIHanoi(ArrayList<PartidaHanoi> _listaHanoi, Player _jugador, UIMenu _windowMain, int _numDiscos) {
        initComponents();
        this.pila_A = new Pila();
        this.pila_B = new Pila();
        this.pila_C = new Pila();
        this.juegoHanoi = new Hanoi();
        this.numMovimientos = 0;
        this.listaHanoi = _listaHanoi;
        this.jugador = _jugador;
        this.numDiscos = _numDiscos;
        this.windowMain = _windowMain;
        this.salir = false;
        this.ID = 0;
        this.crono = new Cronometro(lblCrono);
        ImageIcon icon = new ImageIcon(ICON_UI_IMAGE);
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        //calcula numero de movimiento en base a la cantidad de discos
        //luego lo muestra en el lbl
        double minMov = Math.pow(2, numDiscos) - 1;
        lblMinMov.setText(String.format("%.0f", minMov));
        //carga los layouts de los paneles, carga la pila A y precarga los demas
        configPanelesPilas();
        cargarPilaA();
        cargarPanelPilaA();
        cargarPanelPilaB();
        cargarPanelPilaC();
        //cargar datos a UIHanoi
        builderUIHanoi();
    }

    public UIHanoi(ArrayList<PartidaHanoi> _listaHanoi, UIMenu _windowMain, int _ID) {
        initComponents();
        //obtener datos de partida hanoi y asignar
        this.listaHanoi = _listaHanoi;
        PartidaHanoi tmpPartida = listaHanoi.get(ID);
        this.juegoHanoi = tmpPartida.getPtHanoi();
        Pila tmpPila_A = juegoHanoi.getPila_A();
        Pila tmpPila_B = juegoHanoi.getPila_B();
        Pila tmpPila_C = juegoHanoi.getPila_C();
        this.pila_A = tmpPila_A;
        this.pila_B = tmpPila_B;
        this.pila_C = tmpPila_C;
        this.numDiscos = juegoHanoi.getNumDiscos();
        this.numMovimientos = tmpPartida.getContadorMovientos();
        this.jugador = tmpPartida.getJugador();
        //obtenemos datos para buildear el reloj(cronometro)
        int s = tmpPartida.getSegundos();
        int m = tmpPartida.getMinutos();
        int h = tmpPartida.getHoras();
        this.crono = new Cronometro(s, m, h, lblCrono);
        //referencias y variables importantes
        this.windowMain = _windowMain;
        this.salir = false;
        this.ID = _ID;
        ImageIcon icon = new ImageIcon(ICON_UI_IMAGE);
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        //calcula numero de movimiento en base a la cantidad de discos
        //luego lo muestra en el lbl
        double minMov = Math.pow(2, numDiscos) - 1;
        lblMinMov.setText(String.format("%.0f", minMov));
        //carga los layouts de los paneles, carga la pila A y precarga los demas
        configPanelesPilas();
        cargarPanelPilaA();
        cargarPanelPilaB();
        cargarPanelPilaC();
        //cargar datos a UIHanoi
        builderUIHanoi();
    }

    /**
     * Settea los Layouts a los paneles de la GUI
     */
    private void configPanelesPilas() {
        panelPilaA.setLayout(new BoxLayout(panelPilaA, BoxLayout.Y_AXIS));
        panelPilaB.setLayout(new BoxLayout(panelPilaB, BoxLayout.Y_AXIS));
        panelPilaC.setLayout(new BoxLayout(panelPilaC, BoxLayout.Y_AXIS));
    }

    /**
     * Genera la pila A segun el numero de discos especificados cuando se
     * construye la UIHanoi
     */
    private void cargarPilaA() {
        try {
            for (int i = numDiscos; i >= 1; i--) {
                Nodo tmpNodo = new Nodo();
                Disco tmpDisco = new Disco(i);
                tmpNodo.setDato(tmpDisco);
                pila_A.push(tmpNodo);
            }
        } catch (Exception e) {
            System.err.println("error creando pila");
        }

    }

    /**
     * Agrega los labels a los paneles de forma de que se genera una torre de
     * Hanoi
     */
    private void cargarPanelPilaA() {
        panelPilaA.removeAll();
        panelPilaA.revalidate();
        panelPilaA.repaint();
        if (pila_A.getContNodo() <= 0) {
            return;
        }
        int numLlenar = (8 - pila_A.getContNodo());
        for (int i = 1; i <= numLlenar; i++) {
            panelPilaA.add(new Disco(0));
        }
        Nodo D;
        for (D = pila_A.getCabeza(); D.getAbajo() != null; D = D.getAbajo()) {
            Disco tmpDisco = D.getDato();

            panelPilaA.add(tmpDisco);
        }
        if (D.getAbajo() == null) {
            panelPilaA.add(D.getDato());
        }
        panelPilaA.revalidate();
        panelPilaA.repaint();
    }

    /**
     * Agrega los labels a los paneles de forma de que se genera una torre de
     * Hanoi
     */
    private void cargarPanelPilaB() {
        panelPilaB.removeAll();
        panelPilaB.revalidate();
        panelPilaB.repaint();
        if (pila_B.getContNodo() <= 0) {
            return;
        }
        int numLlenar = (8 - pila_B.getContNodo());
        for (int i = 1; i <= numLlenar; i++) {
            panelPilaB.add(new Disco(0));
        }
        Nodo D;
        for (D = pila_B.getCabeza(); D.getAbajo() != null; D = D.getAbajo()) {
            Disco tmpDisco = D.getDato();
            panelPilaB.add(tmpDisco);
        }
        if (D.getAbajo() == null) {
            panelPilaB.add(D.getDato());
        }
        panelPilaB.revalidate();
        panelPilaB.repaint();
    }

    private void builderUIHanoi() {
        lblJugador.setText("Jugador: " + jugador.getNombre());
        lblNumDiscos.setText("No. Discos: " + numDiscos);
    }

    /**
     * Agrega los labels a los paneles de forma de que se genera una torre de
     * Hanoi
     */
    private void cargarPanelPilaC() {
        panelPilaC.removeAll();
        panelPilaC.revalidate();
        panelPilaC.repaint();
        if (pila_C.getContNodo() <= 0) {
            return;
        }
        int numLlenar = (8 - pila_C.getContNodo());
        for (int i = 1; i <= numLlenar; i++) {
            panelPilaC.add(new Disco(0));
        }
        Nodo D;
        for (D = pila_C.getCabeza(); D.getAbajo() != null; D = D.getAbajo()) {
            Disco tmpDisco = D.getDato();

            panelPilaC.add(tmpDisco);
        }
        if (D.getAbajo() == null) {
            panelPilaC.add(D.getDato());
        }
        panelPilaC.revalidate();
        panelPilaC.repaint();
    }

    private void contarMovimiento() {
        numMovimientos++;
        lblContMov.setText(String.valueOf(numMovimientos));
    }

    private void iniciarPartida() {
        btnApilaB.setEnabled(true);
        btnApilaC.setEnabled(true);
        btnBpilaA.setEnabled(true);
        btnBpilaC.setEnabled(true);
        btnCpilaA.setEnabled(true);
        btnCpilaB.setEnabled(true);
        crono.iniciarCronometro();
        btnIniciar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        lblPilaA = new javax.swing.JLabel();
        lblPilaB = new javax.swing.JLabel();
        lblPilaC = new javax.swing.JLabel();
        lblCrono = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblNumDiscos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnApilaB = new javax.swing.JButton();
        btnApilaC = new javax.swing.JButton();
        btnBpilaA = new javax.swing.JButton();
        btnBpilaC = new javax.swing.JButton();
        btnCpilaA = new javax.swing.JButton();
        btnCpilaB = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        panelPilaA = new javax.swing.JPanel();
        panelPilaB = new javax.swing.JPanel();
        panelPilaC = new javax.swing.JPanel();
        contentInfo = new javax.swing.JPanel();
        lvlNoMinMov = new javax.swing.JLabel();
        lblNoMov = new javax.swing.JLabel();
        lblContMov = new javax.swing.JLabel();
        lblMinMov = new javax.swing.JLabel();
        lblBackGround = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mOpciones = new javax.swing.JMenu();
        btnGuardar = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Torres de Hanoi");
        setMinimumSize(new java.awt.Dimension(0, 731));
        setPreferredSize(new java.awt.Dimension(876, 731));
        setResizable(false);
        setSize(new java.awt.Dimension(876, 731));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        content.setMinimumSize(new java.awt.Dimension(0, 0));
        content.setPreferredSize(new java.awt.Dimension(876, 700));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPilaA.setBackground(new java.awt.Color(0, 0, 0));
        lblPilaA.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblPilaA.setForeground(new java.awt.Color(255, 255, 255));
        lblPilaA.setText("A");
        lblPilaA.setOpaque(true);
        lblPilaA.setPreferredSize(new java.awt.Dimension(20, 30));
        content.add(lblPilaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        lblPilaB.setBackground(new java.awt.Color(0, 0, 0));
        lblPilaB.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblPilaB.setForeground(new java.awt.Color(255, 255, 255));
        lblPilaB.setText("B");
        lblPilaB.setToolTipText("");
        lblPilaB.setOpaque(true);
        lblPilaB.setPreferredSize(new java.awt.Dimension(20, 30));
        content.add(lblPilaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        lblPilaC.setBackground(new java.awt.Color(0, 0, 0));
        lblPilaC.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblPilaC.setForeground(new java.awt.Color(255, 255, 255));
        lblPilaC.setText("C");
        lblPilaC.setOpaque(true);
        lblPilaC.setPreferredSize(new java.awt.Dimension(20, 30));
        content.add(lblPilaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        lblCrono.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblCrono.setForeground(new java.awt.Color(255, 255, 255));
        lblCrono.setText("00:00:00");
        content.add(lblCrono, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        lblJugador.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador.setText("Jugador:");
        content.add(lblJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lblNumDiscos.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblNumDiscos.setForeground(new java.awt.Color(255, 255, 255));
        lblNumDiscos.setText("No. Discos:");
        content.add(lblNumDiscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        content.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 54, 770, -1));

        btnApilaB.setBackground(new java.awt.Color(7, 7, 60));
        btnApilaB.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnApilaB.setForeground(new java.awt.Color(255, 255, 255));
        btnApilaB.setText(">> B");
        btnApilaB.setToolTipText("");
        btnApilaB.setEnabled(false);
        btnApilaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApilaBActionPerformed(evt);
            }
        });
        content.add(btnApilaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 75, 30));

        btnApilaC.setBackground(new java.awt.Color(7, 7, 60));
        btnApilaC.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnApilaC.setForeground(new java.awt.Color(255, 255, 255));
        btnApilaC.setText(">> C");
        btnApilaC.setEnabled(false);
        btnApilaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApilaCActionPerformed(evt);
            }
        });
        content.add(btnApilaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 75, 30));

        btnBpilaA.setBackground(new java.awt.Color(7, 7, 60));
        btnBpilaA.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnBpilaA.setForeground(new java.awt.Color(255, 255, 255));
        btnBpilaA.setText("A <<");
        btnBpilaA.setEnabled(false);
        btnBpilaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBpilaAActionPerformed(evt);
            }
        });
        content.add(btnBpilaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 75, 30));

        btnBpilaC.setBackground(new java.awt.Color(7, 7, 60));
        btnBpilaC.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnBpilaC.setForeground(new java.awt.Color(255, 255, 255));
        btnBpilaC.setText(">> C");
        btnBpilaC.setEnabled(false);
        btnBpilaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBpilaCActionPerformed(evt);
            }
        });
        content.add(btnBpilaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 75, 30));

        btnCpilaA.setBackground(new java.awt.Color(7, 7, 60));
        btnCpilaA.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnCpilaA.setForeground(new java.awt.Color(255, 255, 255));
        btnCpilaA.setText("A<<");
        btnCpilaA.setEnabled(false);
        btnCpilaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpilaAActionPerformed(evt);
            }
        });
        content.add(btnCpilaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 75, 30));

        btnCpilaB.setBackground(new java.awt.Color(7, 7, 60));
        btnCpilaB.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnCpilaB.setForeground(new java.awt.Color(255, 255, 255));
        btnCpilaB.setText("B<<");
        btnCpilaB.setEnabled(false);
        btnCpilaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpilaBActionPerformed(evt);
            }
        });
        content.add(btnCpilaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 75, 30));

        jButton1.setBackground(new java.awt.Color(7, 7, 60));
        jButton1.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        content.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 100, 30));

        btnIniciar.setBackground(new java.awt.Color(7, 7, 60));
        btnIniciar.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        content.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 100, 30));

        panelPilaA.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelPilaALayout = new javax.swing.GroupLayout(panelPilaA);
        panelPilaA.setLayout(panelPilaALayout);
        panelPilaALayout.setHorizontalGroup(
            panelPilaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelPilaALayout.setVerticalGroup(
            panelPilaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        content.add(panelPilaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 105, 240, 400));

        panelPilaB.setBackground(new java.awt.Color(51, 51, 51));
        panelPilaB.setPreferredSize(new java.awt.Dimension(240, 400));

        javax.swing.GroupLayout panelPilaBLayout = new javax.swing.GroupLayout(panelPilaB);
        panelPilaB.setLayout(panelPilaBLayout);
        panelPilaBLayout.setHorizontalGroup(
            panelPilaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPilaBLayout.setVerticalGroup(
            panelPilaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        content.add(panelPilaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 105, 240, 400));

        panelPilaC.setBackground(new java.awt.Color(51, 51, 51));
        panelPilaC.setPreferredSize(new java.awt.Dimension(240, 400));

        javax.swing.GroupLayout panelPilaCLayout = new javax.swing.GroupLayout(panelPilaC);
        panelPilaC.setLayout(panelPilaCLayout);
        panelPilaCLayout.setHorizontalGroup(
            panelPilaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPilaCLayout.setVerticalGroup(
            panelPilaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        content.add(panelPilaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 105, 240, 400));

        contentInfo.setBackground(new java.awt.Color(51, 51, 51));

        lvlNoMinMov.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        lvlNoMinMov.setForeground(new java.awt.Color(255, 255, 255));
        lvlNoMinMov.setText("No. minimo de mov. :");

        lblNoMov.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        lblNoMov.setForeground(new java.awt.Color(255, 255, 255));
        lblNoMov.setText("No. movimientos :");

        lblContMov.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        lblContMov.setForeground(new java.awt.Color(255, 255, 255));
        lblContMov.setText("0");

        lblMinMov.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        lblMinMov.setForeground(new java.awt.Color(255, 255, 255));
        lblMinMov.setText("0");

        javax.swing.GroupLayout contentInfoLayout = new javax.swing.GroupLayout(contentInfo);
        contentInfo.setLayout(contentInfoLayout);
        contentInfoLayout.setHorizontalGroup(
            contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNoMov)
                    .addComponent(lvlNoMinMov))
                .addGap(18, 18, 18)
                .addGroup(contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContMov)
                    .addComponent(lblMinMov))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        contentInfoLayout.setVerticalGroup(
            contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoMov)
                    .addComponent(lblContMov))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvlNoMinMov)
                    .addComponent(lblMinMov))
                .addContainerGap())
        );

        content.add(contentInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 230, -1));

        lblBackGround.setIcon(new javax.swing.ImageIcon("D:\\proyectos_u\\proyecto2\\resource\\BackGround700.jpg")); // NOI18N
        content.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 1060, 700));

        menuBar.setBackground(new java.awt.Color(7, 7, 60));
        menuBar.setForeground(new java.awt.Color(255, 255, 255));
        menuBar.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N

        mOpciones.setForeground(new java.awt.Color(255, 255, 255));
        mOpciones.setText("Opciones");
        mOpciones.setToolTipText("");
        mOpciones.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar Partida");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        mOpciones.add(btnGuardar);

        btnSalir.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        btnSalir.setText("Abandonar Partida");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        mOpciones.add(btnSalir);

        menuBar.add(mOpciones);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnApilaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApilaBActionPerformed
        // TODO add your handling code here:
        //moverAaB();
        moverXaY(pila_A, pila_B);
    }//GEN-LAST:event_btnApilaBActionPerformed

    private void btnApilaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApilaCActionPerformed
        // TODO add your handling code here:
        //moverAaC();
        moverZaC(pila_A);
    }//GEN-LAST:event_btnApilaCActionPerformed

    private void btnBpilaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBpilaAActionPerformed
        // TODO add your handling code here:
        moverXaY(pila_B, pila_A);
    }//GEN-LAST:event_btnBpilaAActionPerformed

    private void btnBpilaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBpilaCActionPerformed
        // TODO add your handling code here:
        moverZaC(pila_B);
    }//GEN-LAST:event_btnBpilaCActionPerformed

    private void btnCpilaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpilaAActionPerformed
        // TODO add your handling code here:
        moverXaY(pila_C, pila_A);
    }//GEN-LAST:event_btnCpilaAActionPerformed

    private void btnCpilaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpilaBActionPerformed
        // TODO add your handling code here:
        moverXaY(pila_C, pila_B);
    }//GEN-LAST:event_btnCpilaBActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Esta seguro de regresar al menu principal?\nLa partida sera considerada abandona y por lo tanto perida",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.NO_OPTION) {
            salir = false;
            return;
        }
        if (confirm == JOptionPane.CANCEL_OPTION) {
            salir = false;
            return;
        }
        registrarPartidaAbandonada();
        salir = true;
        this.dispose();
        windowMain.setFocusMain();
    }//GEN-LAST:event_formWindowClosing

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        iniciarPartida();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarPartida();
        salir = true;
        this.dispose();
        windowMain.setFocusMain();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Esta seguro de regresar al menu principal?\nLa partida sera considerada abandona y por lo tanto perida",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.NO_OPTION) {
            salir = false;
            return;
        }
        if (confirm == JOptionPane.CANCEL_OPTION) {
            salir = false;
            return;
        }
        registrarPartidaAbandonada();
        salir = true;
        this.dispose();
        windowMain.setFocusMain();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (!salir) {
            this.setAutoRequestFocus(true);
            this.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void moverXaY(Pila pilaX, Pila pilaY) {
        try {
            if (pilaX.getContNodo() > 0) {
                Nodo tmpNodo = new Nodo();
                tmpNodo.setDato(pilaX.peek());

                if (pilaY.getContNodo() > 0) {
                    if (tmpNodo.getDato().getValor() > pilaY.peek().getValor()) {
                        JOptionPane.showMessageDialog(this, "No se puede mover porque la ficha es mas grande D:");
                        return;
                    }
                }
                pilaX.pop();
                pilaY.push(tmpNodo);
                //actualizar los paneles y contar movimiento valido
                cargarPanelPilaA();
                cargarPanelPilaB();
                cargarPanelPilaC();
                contarMovimiento();
            }
        } catch (Exception e) {
            System.err.print("Error al mover X a Y");
        }
    }

    private void moverZaC(Pila pilaZ) {
        try {
            if (pilaZ.getContNodo() > 0) {
                Nodo tmpNodo = new Nodo();
                tmpNodo.setDato(pilaZ.peek());

                if (pila_C.getContNodo() > 0) {
                    if (tmpNodo.getDato().getValor() > pila_C.peek().getValor()) {
                        JOptionPane.showMessageDialog(this, "No se puede mover porque la ficha es mas grande D:");
                        return;
                    }
                }
                pilaZ.pop();
                pila_C.push(tmpNodo);
                //actualizar los paneles y contar movimiento valido
                cargarPanelPilaA();
                cargarPanelPilaB();
                cargarPanelPilaC();
                contarMovimiento();

                if (pila_C.getContNodo() == numDiscos) {
                    crono.pararCronometro();
                    JOptionPane.showMessageDialog(this, "El jugador ha Ganado :D :3");
                    registrarPartidaGanada();
                    this.dispose();
                    salir = true;
                    windowMain.setFocusMain();
                }
            }
        } catch (Exception e) {
            // Z puede ser A o B, dependiendo de el movimientos especificado
            System.err.print("Error al mover Z a C");
        }
    }

    public void guardarPartida() {
        //se guarda el cronometro
        crono.pararCronometro();
        int segundos = crono.getSegundos();
        int minutos = crono.getMinutos();
        int horas = crono.getHoras();
        //buildeo la partida para que sea guardada
        juegoHanoi.setPila_A(pila_A);
        juegoHanoi.setPila_B(pila_B);
        juegoHanoi.setPila_C(pila_C);
        juegoHanoi.setNumDiscos(numDiscos);
        PartidaHanoi tmpPartidaHanoi = new PartidaHanoi(juegoHanoi, jugador, numMovimientos);
        tmpPartidaHanoi.setSegundos(segundos);
        tmpPartidaHanoi.setMinutos(minutos);
        tmpPartidaHanoi.setHoras(horas);
        //busca la partida del id especificado, si ID 0, o no encuentra la partida, la crea;
        for (PartidaHanoi partida : listaHanoi) {
            if (partida.getID() == ID) {
                int index = listaHanoi.lastIndexOf(partida);
                listaHanoi.set(index, tmpPartidaHanoi);
                return;
            }
        }
        System.out.println("Cree una partida porque no encontre coincidencias");
        listaHanoi.add(tmpPartidaHanoi);
    }

    public void registrarPartidaGanada() {

        jugador.contarVictoria();
        int segundos = crono.getSegundos();
        int minutos = crono.getMinutos();
        int horas = crono.getHoras();
        //se buildea la partida finalizada
        PartidaHanoi tmpPartidaHanoi = new PartidaHanoi(jugador, numMovimientos, true);
        tmpPartidaHanoi.setSegundos(segundos);
        tmpPartidaHanoi.setMinutos(minutos);
        tmpPartidaHanoi.setHoras(horas);
        for (PartidaHanoi partida : listaHanoi) {
            if (partida.getID() == ID) {
                int index = listaHanoi.lastIndexOf(partida);
                listaHanoi.set(index, tmpPartidaHanoi);
                return;
            }
        }
        //se registra en la lista de partidas
        listaHanoi.add(tmpPartidaHanoi);
    }

    public void registrarPartidaAbandonada() {
        crono.pararCronometro();
        jugador.contarDerrota();
        int segundos = crono.getSegundos();
        int minutos = crono.getMinutos();
        int horas = crono.getHoras();
        //se buildea la partida finalizada
        PartidaHanoi tmpPartidaHanoi = new PartidaHanoi(jugador, numMovimientos, false);
        tmpPartidaHanoi.setSegundos(segundos);
        tmpPartidaHanoi.setMinutos(minutos);
        tmpPartidaHanoi.setHoras(horas);
        for (PartidaHanoi partida : listaHanoi) {
            if (partida.getID() == ID) {
                int index = listaHanoi.lastIndexOf(partida);
                listaHanoi.set(index, tmpPartidaHanoi);
                return;
            }
        }
        listaHanoi.add(tmpPartidaHanoi);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApilaB;
    private javax.swing.JButton btnApilaC;
    private javax.swing.JButton btnBpilaA;
    private javax.swing.JButton btnBpilaC;
    private javax.swing.JButton btnCpilaA;
    private javax.swing.JButton btnCpilaB;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JPanel content;
    private javax.swing.JPanel contentInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblContMov;
    private javax.swing.JLabel lblCrono;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMinMov;
    private javax.swing.JLabel lblNoMov;
    private javax.swing.JLabel lblNumDiscos;
    private javax.swing.JLabel lblPilaA;
    private javax.swing.JLabel lblPilaB;
    private javax.swing.JLabel lblPilaC;
    private javax.swing.JLabel lvlNoMinMov;
    private javax.swing.JMenu mOpciones;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelPilaA;
    private javax.swing.JPanel panelPilaB;
    private javax.swing.JPanel panelPilaC;
    // End of variables declaration//GEN-END:variables
}
