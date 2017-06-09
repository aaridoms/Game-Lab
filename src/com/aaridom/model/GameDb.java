package com.aaridom.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

/**
 * Created by angad on 24/05/2017.
 */
public class GameDb {

    private ArrayList<Juego> juegos;

    /**
     * Constructor sin parámetros que usaremos para instanciar el ArrayList.
     */
    public GameDb() {
        juegos = new ArrayList<>();
    }

    /**
     * Método utilizado para añadir un juego a la lista.
     * @param juego
     */
    public void addGames(Juego juego) {
        if ( juego != null ) {
            juegos.add(juego);
        }
    }

    public void gameList() {
        showGameList();
    }

    private void showGameList() {
        for (Juego juego : juegos) {
            System.out.println(juego);
        }
    }

    /**
     * Método utilizado para buscar un juego a través de indexOf.
     * @return
     */
    public int buscarJuego(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Introduzca el nombre del juego: ");
        String nombre = scanner.nextLine();

        int index = juegos.indexOf( new Juego(nombre) );

        if ( index != -1) {
            return index;
        }else{
            System.out.println("No hemos encontrado el juego que buscas");
            return -1;
        }
    }

    /**
     * Método utilizado para eliminar un elemento del ArrayList.
     * Usa el método buscarJuego() para buscar el juego que se quiere eliminar.
     */
    public void delGame() {
        try {
            juegos.remove(buscarJuego() );
            System.out.println("El juego se a eliminado correctamente");
            System.out.println();
            showGameList();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();

        }
    }

    /**
     * Método de la interfaz comparable para la ordenación por un parámetro.
     */
    public void juegosPorNota() {
        Collections.sort( juegos );

        showGameList();
    }

    /**
     * Método de la interfaz comparator para la ordenación por el parámetro nombre.
     */
    public void juegosPorNombre() {
        Collections.sort( juegos, new Juego() );

        showGameList();
    }

    /**
     * Método de la interfaz comparator para la ordenación por el parámetro desarrolladora.
     */
    public void juegosPorDes() {
        Collections.sort( juegos, new Juego() );

        showGameList();
    }

    /**
     * Método estático de la interfaz comparator para realizar una ordenación con dos parámetros.
     */
    public void comparadorEstatico() {
        Collections.sort( juegos, new Juego() );

        showGameList();
    }

    /**
     * Método utilizado para guardar los datos en un archivo.
     */
    public void guardarFichero() {
        try {
            ObjectOutputStream guardar = new ObjectOutputStream( new FileOutputStream("juegos.dat"));
            guardar.writeObject( juegos );
            System.out.println("Los datos han sido guardados correctamente");
            guardar.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método utilizado para cargar los datos del archivo
     */
    public void cargarFichero() {
        try {
            ObjectInputStream cargar = new ObjectInputStream( new FileInputStream( "juegos.dat" ));
            juegos =  (ArrayList<Juego>) cargar.readObject();
            System.out.println("Los datos han sido cargados correctamente");
            cargar.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e){
            System.out.println("No hay ningún valor en el fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
