package Juego.Tablero;

import Juego.Casillero.Casillero;

public class Tablero {
    private Casillero[][] casilleros;

    Tablero(int filas, int columnas){
        this.casilleros = new Casillero[filas][columnas];
    }
}
