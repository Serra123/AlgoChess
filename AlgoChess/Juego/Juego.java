package Juego;

import Juego.Tablero.Tablero;

public class Juego {
    private Tablero tablero;
    private Jugador jugadorActual;
    private Jugador jugadorContrincante;

    public Juego(String nombreJugador1, String nombreJugador2) {

        tablero = new Tablero();
        jugadorActual = new Jugador(nombreJugador1);
        jugadorContrincante = new Jugador(nombreJugador2);

    }

    public void inicializar(){
        jugadorActual.posicionarUnidades();
        jugadorContrincante.posicionarUnidades();
    }
}
