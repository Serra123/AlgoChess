package Juego;

import unidades.Unidad;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Unidad> unidades;
    private int puntos;
    private String nombre;

    Jugador(String nombre) {
        this.puntos = 20;
        this.nombre = nombre;
        this.unidades = new ArrayList<Unidad>();
    }

    public void agregarSoldado(int fila, int columna, Tablero tablero){
        this.puntos -=
    }
    public void posicionarJinete(){

    }
    public void posicionarCatapulta(){

    }
}
