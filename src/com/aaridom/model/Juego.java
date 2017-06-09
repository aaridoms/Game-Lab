package com.aaridom.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by angad on 23/05/2017.
 */
public class Juego implements Comparable<Juego>, Comparator<Juego>, Serializable {

    private String nombre;
    private String genero;
    private String desarrolladora;
    private Date lanzamiento;
    private double nota;

    // Constructors
    public Juego() {

    }

    /**
     * Constructor con un solo parámetro que nos servirá para realizar la busqueda por nombre
     * @param nombre
     */
    public Juego(String nombre) {
        this.setNombre(nombre);
    }

    public Juego(String nombre, String genero, String desarrolladora, Date lanzamiento, double nota) {
        this.setNombre( nombre );
        this.setGenero( genero );
        this.setDesarrolladora( desarrolladora );
        this.setLanzamiento( lanzamiento );
        this.setNota( nota );
    }

    // Guetters and Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;

    }

    // Methods
    /**
     * Método de la interfaz comparable para realizar una ordenación por un parámetro.
     * @param juego
     * @return
     */
    @Override
    public int compareTo(Juego juego) {
        return Double.compare(juego.getNota(), this.getNota());
    }

    /**
     * Método de la interfaz comparator para realizar una ordenación por dos parámetros.
     * @param g1
     * @param g2
     * @return
     */
    @Override
    public int compare(Juego g1, Juego g2) {
        int result;

//        result = g1.getNombre().compareToIgnoreCase(g2.getNombre());
//
//        if ( result != 0) {
//            return result;
//        }

        return g1.getDesarrolladora().compareToIgnoreCase(g2.getDesarrolladora());
    }

    /**
     * Método estático de la interfaz comparator para realizar una ordenación por dos parámetros.
     */
    public static Comparator<Juego> comparadorPorGeneroYNombre = new Comparator<Juego>() {
        @Override
        public int compare(Juego j1, Juego j2) {
            int res;

//            res = j1.getNombre().compareToIgnoreCase(j2.getNombre() );
//
//            if ( res != 0) {
//                return res;
//            }

            return j1.getGenero().compareToIgnoreCase(j2.getGenero() );
        }
    };

    /**
     * Método equals utilizado para realizar una busqueda.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}

        if ( obj == null) {return false;}

        if ( this.getClass() != obj.getClass() ) {return false;}

        Juego gam = (Juego) obj;

        return Objects.equals( this.getNombre(), gam.getNombre() );
    }

    /**
     * Método toString utilizado para darle formato a la salida por pantalla.
     * @return
     */
    @Override
    public String toString() {
       String dateFormat = new SimpleDateFormat( "dd-MM-yyyy" ).format(getLanzamiento());

        return getNombre() + "(" + getGenero() + " | " + getDesarrolladora() + " | " + getLanzamiento() + " | " + getNota() + " en Metacritic" + ")";
    }
}
