package Juego.Tablero;

import Juego.Casillero.Casillero;

public class Tablero {
    private Casillero[][] casilleros; //Comentario Fede



    Tablero(int filas, int columnas){
        this.casilleros = new Casillero[filas][columnas];
    }
}
