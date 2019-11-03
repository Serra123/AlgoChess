package Juego;

import Juego.Tablero.Tablero;

public class Juego {
    private Tablero tablero;
    private Jugador jugadorActual;
    private Jugador jugadorContrincante;

    public Juego() {

        tablero = new Tablero();
        jugadorActual = new Jugador();
        jugadorContrincante = new Jugador(); 

    }
}
