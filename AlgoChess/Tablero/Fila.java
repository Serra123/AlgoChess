package Tablero;

import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Fila {
    private ArrayList<Casillero> casilleros;
    public Fila(int columnas, String nombreUnJugador) {
        casilleros = new ArrayList<Casillero>();
        for(int i = 0; i<columnas;i++){
            Casillero unCasillero = new Casillero(nombreUnJugador);
            casilleros.add(unCasillero);
        }
    }
public Casillero getCasillero(Posicion unaPosicion){
    int columna = unaPosicion.getColumna();
    return casilleros.get(columna);
    }
}
