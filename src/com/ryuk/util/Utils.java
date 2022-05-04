/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.util;

import com.ryuk.player.Player;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author edyrr
 */
public class Utils {

    /**
     * Crea JOptionPane para recibir el nombre del jugador y mostrar alertas si
     * no es valido el nombre, en caso de que el nombre no sea valido se llama a
     * si misma para hasta que se cree un nombre valido o en su defecto no se
     * prosiga con la creacion del usuario
     *
     * @param msg
     * @param title
     * @param cmp
     * @return nombre verificado
     */
    public static String checkName(String msg, String title, Component cmp) {
        String name = "";

        try {
            name = JOptionPane.showInputDialog(cmp, msg, title, JOptionPane.INFORMATION_MESSAGE).trim();
            if (name.length() <= 2) {
                JOptionPane.showMessageDialog(cmp, "Nombre Invalido", "¡Error!", JOptionPane.WARNING_MESSAGE);
                name = checkName(msg, title, cmp);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(cmp, "No se ingreso el nombre del jugador", "¡Error!", JOptionPane.WARNING_MESSAGE);
        }

        return name;
    }

    public static boolean checkName(String name, Component cmp) {
        try {
            name.trim();
            if (name.length() <= 2) {
                JOptionPane.showMessageDialog(cmp, "Nombre Invalido", "¡Error!",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (name.equals("Ingrese Nombre")) {
                JOptionPane.showMessageDialog(cmp, "Nombre Invalido", "¡Error!",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (name.equals("Ingrese")) {
                JOptionPane.showMessageDialog(cmp, "Nombre Invalido", "¡Error!",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (name.equals("Nombre")) {
                JOptionPane.showMessageDialog(cmp, "Nombre Invalido", "¡Error!",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(cmp, "No se ingreso el nombre del jugador",
                    "¡Error!", JOptionPane.WARNING_MESSAGE);
        }
        
        return true;
    }

    /**
     * Valida el nombre y crea un nuevo jugador y agg a la lista de jugadores
     *
     * @param name
     * @param lista
     * @param cmp
     */
    public static boolean validatePlayer(String name, ArrayList<Player> lista, Component cmp) {
        if (name.length() > 2 && name != null) {
            lista.add(new Player(name));
            JOptionPane.showMessageDialog(cmp, "Se creo un nuevo Jugador",
                    "Nuevo Jugador", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(cmp, "El jugador no fue creado!",
                "Alerta", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}
