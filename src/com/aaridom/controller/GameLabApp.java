package com.aaridom.controller;

import com.aaridom.model.GameDb;
import com.aaridom.model.Juego;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by angad on 23/05/2017.
 */
public class GameLabApp {

    private GameDb gamedb;

    public GameLabApp() {
        gamedb = new GameDb();
       // loadTestGames();
    }

    /**
     * Método utilizado para cargar una lista de juegos 
     */
//    private void loadTestGames() {
//       gamedb.addGames( new Juego("Counter-Strike: Global Ofensive", "FPS", "Valve", new Date(), 90.0));
//       gamedb.addGames( new Juego("World of Warcraft: Legion", "MMORPG", "Blizzard", new Date(), 92.0));
//       gamedb.addGames( new Juego("Gran Theft Auto V", "Acción y aventura", "Rockstar", new Date(), 88.0));
//       gamedb.addGames( new Juego("League of Legends", "Acción y RPG", "Riot Games", new Date(), 89.0));
//       gamedb.addGames( new Juego("Overwatch", "Acción, FPS", "Blizzard", new Date(), 91.0));
//       gamedb.addGames( new Juego("Diablo III", "Acción, RPG", "Blizzard", new Date(), 95.0));
//       gamedb.addGames( new Juego("Half Life 3", "Acción y aventura", "Valve", new Date(), 99.0));
//
//    }

    /**
     * Muestra una interfaz con las opciones que pueden ser utilizadas
     */
    public void start() {
        int option;
        try {
            while ((option = showMenu()) != 0) {
               switch ( option ) {
                   case 1:
                       // Añadir nuevo juego.
                       gamedb.addGames(askGameInfo());
                       break;
                   case 2:
                       // Listar juegos.
                       gamedb.gameList();
                       break;
                   case 3:
                       // Borrar por nombre.
                       gamedb.delGame();
                       break;
                   case 4:
                       // Ordenar por Nota.
                       gamedb.juegosPorNota();
                       break;
                   case 5:
                       // Ordenar por Nombre
                       gamedb.juegosPorNombre();
                       break;
                   case 6:
                       // Ordenar por Desarrolladora.
                       gamedb.juegosPorDes();
                       break;
                   case 7:
                       // Ordenar por Nombre y desarrolladora.
                       gamedb.comparadorEstatico();
                       break;
                   case 8:
                       // Guardar el fichero
                       gamedb.guardarFichero();
                       break;
                   case 9:
                       // Cargar el fichero guardado.
                       gamedb.cargarFichero();
                       break;
               }
            }
        } catch (InputMismatchException e) {
                System.out.println("Los valores no son correctos");

                start();
            }
    }

    /**
     * Método utilizado para introdicir un juego a mano
     * @return
     */
    private Juego askGameInfo() {
        Scanner scanner = new Scanner(System.in);
        String nombre, genero, desarrolladora;
        double nota;

        System.out.println("Añadir un nuevo juego");
        System.out.println("========================");

        do {
            System.out.println("Nombre del Juego: ");
            nombre = scanner.next().trim().replaceAll("\\s", " ");
        }while (nombre.equals(""));

        scanner.nextLine();

        do {
            System.out.println("Género del Juego: ");
            genero = scanner.nextLine().trim().replaceAll("\\s", " ");
        }while (genero.equals(""));

        do {
            System.out.println("Desarrolladora: ");
            desarrolladora = scanner.nextLine().trim().replaceAll("\\s", " ");
        }while (desarrolladora.equals(""));

        do {
            System.out.println("Nota en Metacritic: ");
            nota = scanner.nextDouble();
        }while (nota < 0.0);

        return new Juego(nombre, genero, desarrolladora, new Date(), nota);
    }

    /**
     * Imprime el menú por pantalla.
     * @return
     */
    private int showMenu() {
        Scanner scanner = new Scanner(System.in);

        int option;

        System.out.println("*****************************************");
        System.out.println("** 1 - Añadir Juego                    **");
        System.out.println("** 2 - Listar Juegos                   **");
        System.out.println("** 3 - Eliminar Juego                  **");
        System.out.println("** 4 - Ordenación por Nota             **");
        System.out.println("** 5 - Ordenación por Nombre           **");
        System.out.println("** 6 - Ordenación por Desarrolladora   **");
        System.out.println("** 7 - Ordenación por Nombre y Género  **");
        System.out.println("** 8 - Guardar en Fichero              **");
        System.out.println("** 9 - Cargar Fichero                  **");
        System.out.println("** 0 - Salir                           **");
        System.out.println("*****************************************");
        System.out.println("Opcion: ");

        option = scanner.nextInt();
        return option;
    }
}
