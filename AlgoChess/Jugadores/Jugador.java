package Jugadores;

import Unidades.Catapulta;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;

import java.util.ArrayList;

public class Jugador {
    private int puntos;
    private String nombre;
    private ArrayList<Unidad> unidades;

    Jugador(String nombre){
        this.puntos = 20;
        this.nombre = nombre;
        this.unidades = new ArrayList<Unidad>();
    }

    public void crearSoldadoEnPosicion(int fila,int columna){
        String nombre = this.nombre;
        Soldado unSoldado = new Soldado( fila,columna,nombre);
        unidades.add(unSoldado);
    }
    public void crearJineteEnPosicion(int fila,int columna){
        String nombreEjercito = this.nombre;
        Jinete unJinete = new Jinete(fila,columna,nombreEjercito);
        unidades.add(unJinete);
    }
    public void crearCatapultaEnPosicion(int fila,int columna){
        String nombreEjercito = this.nombre;
        Catapulta unaCatapulta = new Catapulta(fila, columna, nombreEjercito);
        unidades.add(unaCatapulta);
    }

}
