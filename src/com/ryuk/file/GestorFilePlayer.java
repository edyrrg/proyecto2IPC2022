package com.ryuk.file;

import com.ryuk.player.Player;
import com.ryuk.util.Constantes;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.tools.FileObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class GestorFilePlayer extends GestorFile implements Constantes {

    private final File file;
    //lectura
    private FileInputStream fileInput;
    private ObjectInputStream inputObject;
    //escritura
    private FileOutputStream fileOutput;
    private ObjectOutputStream outputObject;

    public GestorFilePlayer() {
        this.file = new File(RUTA_DATA_PLAYER + NAME_FILE_DATA_PLAYER);
    }

    /**
     * Comprueba la carga del archivo, si el archivo no existe es creado
     *
     * @return true si se cargo el archivo, false si se creo el archivo
     * @throws IOException
     */
    @Override
    public boolean cargarArchivo() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Se creo archivo con ruta " + file.getPath());
            return false;
        }
        return true;
    }

    /**
     * Guarda al objeto ArrayList en archivo.list
     *
     * @param lista
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void escribirLista(ArrayList lista) throws FileNotFoundException, IOException {
        fileOutput = new FileOutputStream(file);
        outputObject = new ObjectOutputStream(fileOutput);
        if (outputObject != null) {
            outputObject.writeObject(lista);
        }
        this.cerrarOutput();
    }

    /**
     * Cierra y libera el recurso escritura
     *
     * @throws IOException
     */
    @Override
    public void cerrarOutput() throws IOException {
        if (outputObject != null) {
            fileOutput.close();
            outputObject.close();
            System.out.println("Se cerro flujo de salida");
        }
    }

    /**
     * lee y deserializa el ArrayList, se castea a su tipo y es retornado
     *
     * @return lista de jugadores
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList leerLista() throws IOException, ClassNotFoundException {
        fileInput = new FileInputStream(file);
        inputObject = new ObjectInputStream(fileInput);
        ArrayList<Player> tmpArrayList = new ArrayList<>();
        tmpArrayList = (ArrayList) inputObject.readObject();
        this.cerrarInput();
        return tmpArrayList;
    }

    /**
     * Cierra el flujo en entrada para liberar el recurso de escritura
     *
     * @throws IOException
     */
    @Override
    public void cerrarInput() throws IOException {
        if (inputObject != null) {
            fileInput.close();
            inputObject.close();
            System.out.println("Se cerro flujo de entrada");
        }
    }

}
