package Tablero;

import Unidades.Posicion.Posicion;

import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private Map<Posicion, Casillero> casilleros;

    public Tablero(int filas, int columnas, String nombreUnJugador, String nombreOtroJugador) {

        this.casilleros = new HashMap<Posicion, Casillero>();

        for (int i = 0; i < (filas / 2); i++) {
            for (int j = 0; j < columnas; j++) {
                Posicion posicion = new Posicion(i, j);
                Casillero casillero = new Casillero(nombreUnJugador);
                this.casilleros.put(posicion, casillero);
            }
        }

        for (int i = (filas / 2); i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Posicion posicion = new Posicion(i, j);
                Casillero casillero = new Casillero(nombreOtroJugador);
                this.casilleros.put(posicion, casillero);
            }
        }
    }
}
