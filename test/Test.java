
import java.util.Arrays;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author edyrr
 */
public class Test {

    public static void main(String[] args) {
//        GestorFilePlayer gFile = new GestorFilePlayer();
//        //se crean lista de jugadores
//        ArrayList<Player> listaPlayers = new ArrayList<>();
//        ArrayList<Player> listaCargada = new ArrayList<>();
//        Player jugador = new Player("Rolando");
//        Player jugadorDos = new Player("Juan");
//        Player jugadorTres = new Player("Yulisa");
//        listaPlayers.add(jugador);
//        listaPlayers.add(jugadorDos);
//        try {
//            //escritura
//            gFile.abrirArchivoParaEscritura();
//            gFile.escribirListaJugadores(listaPlayers);
//            System.out.println("Guarde lista de jugadores: " + listaPlayers);
//            //lectura
//            gFile.abrirArchivoParaLectura();
//            listaCargada = gFile.leerListaJugadores();
//            for (Player player : listaCargada) {
//                System.out.println(player.getNombre());
//            }
//            listaCargada.add(jugadorTres);
//            //escritura
//            gFile.abrirArchivoParaEscritura();
//            gFile.escribirListaJugadores(listaCargada);
//            //lectura
//            gFile.abrirArchivoParaLectura();
//            listaCargada = gFile.leerListaJugadores();
//            for (Player player : listaCargada) {
//                System.out.println(player.getNombre());
//            }
//        } catch (IOException ex) {
//        } catch (NullPointerException ex) {
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
        areFriends2(new int[][]{
            {220, 284},
            {285, 220},
            {1184, 1210},
            {1211, 1185}});

    }

    public static boolean areFriends(int num1, int num2) {
        int acumulador = 0;
        // recorre todos lo numeros desde 1 hasta el num1
        for (int i = 1; i < num1; i++) {
            // comprueba si el modulo de num1 y el valor i del for son igual 0
            if (num1 % i == 0) {
                // acumula el numero i
                acumulador += i;
            }
        }
        // comprueba si los numero son amigos, true si lo son y false si no lo son
        if (acumulador == num2) {
            return true;
        }
        return false;
    }

    public static boolean[] areFriends2(int[][] numbers) {
        // [5][2] permitido [5][3] no permitido
        if (numbers == null) {
            return null;
        }
        if (numbers.length > 1) {
            return null;
        }
        if (numbers[0].length != 2 || numbers[0].length < 2) {
            return null;
        }

        // si el formato se cumple crea un arreglo del tamaño de filas de numbers
        boolean[] response = new boolean[numbers.length];
        System.out.println("hola");
        for (int i = 0; i < numbers.length; i++) {

            response[i] = areFriends(numbers[i][0], numbers[i][1]);
        }

        return response;
    }
}
