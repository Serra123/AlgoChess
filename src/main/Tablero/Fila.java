package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;

import java.util.ArrayList;

public class Fila {

    private ArrayList<Casillero> casilleros;

    public Fila(int columnas) {
        casilleros = new ArrayList<Casillero>();
        for (int i = 0; i < columnas; i++) {
            Casillero unCasillero = new Casillero();
            casilleros.add(unCasillero);
        }
    }

    public Casillero getCasillero(int unaColumna) {
        return casilleros.get(unaColumna);
    }

    void colocarUnidadEnColumna(Unidad unaUnidad, int unaColumna) {
        Casillero unCasillero = this.getCasillero(unaColumna);
        unCasillero.colocar(unaUnidad);
    }

    void vaciarUnidad(int unaColumna) throws ExcepcionCasilleroVacio {
        Casillero unCasillero = this.getCasillero(unaColumna);
        unCasillero.vaciarUnidad();
    }

    void recibirUnidad(Unidad unaUnidad, int unaColumna)throws ExcepcionCasilleroOcupado {
        Casillero unCasillero = this.getCasillero(unaColumna);
        unCasillero.recibirUnidad(unaUnidad);
    }

    int getCantidadColumnas(){
        return casilleros.size();
    }

}
