/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryuk.file;

import com.ryuk.partidas.PartidaHanoi;
import com.ryuk.util.Constantes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author edyrr
 */
public class GestorFilePtHanoi extends GestorFile implements Constantes {

    private final File file;
    //lectura
    private FileInputStream fileInput;
    private ObjectInputStream inputObject;
    //escritura
    private FileOutputStream fileOutput;
    private ObjectOutputStream outputObject;

    public GestorFilePtHanoi() {
        this.file = new File(RUTA_DATA_PARTIDAS + NAME_FILE_DATA_PTHANOI);
    }

    @Override
    public boolean cargarArchivo() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Se creo archivo con ruta " + file.getPath());
            return false;
        }
        return true;
    }

    @Override
    public void cerrarOutput() throws IOException {
        if (outputObject != null) {
            fileOutput.close();
            outputObject.close();
            System.out.println("Se cerro flujo de salida");
        }
    }

    @Override
    public void cerrarInput() throws IOException {
        if (inputObject != null) {
            fileInput.close();
            inputObject.close();
            System.out.println("Se cerro flujo de entrada");
        }
    }

    @Override
    public ArrayList leerLista() throws IOException, ClassNotFoundException {
        fileInput = new FileInputStream(file);
        inputObject = new ObjectInputStream(fileInput);
        ArrayList<PartidaHanoi> tmpArrayList = new ArrayList<>();
        tmpArrayList = (ArrayList) inputObject.readObject();
        this.cerrarInput();
        return tmpArrayList;
    }

    @Override
    public void escribirLista(ArrayList listPtHanoi) throws FileNotFoundException, IOException {
        fileOutput = new FileOutputStream(file);
        outputObject = new ObjectOutputStream(fileOutput);
        if (outputObject != null) {
            outputObject.writeObject(listPtHanoi);
        }
        this.cerrarOutput();
    }

}
