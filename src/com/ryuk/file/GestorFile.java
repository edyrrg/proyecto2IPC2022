/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.file;

import com.ryuk.player.Player;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author edyrr
 */
public abstract class GestorFile {

    public abstract boolean cargarArchivo() throws IOException;
    
    public abstract void cerrarOutput() throws IOException;
    
    public abstract void cerrarInput() throws IOException;
    
    public abstract ArrayList leerLista() throws IOException, ClassNotFoundException;
    
    public abstract void escribirLista(ArrayList lista) throws FileNotFoundException, IOException;
}
