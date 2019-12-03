package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fila {

    private List<Casillero> casilleros;

    public Fila(int columnas) {
        casilleros= IntStream.range(0, columnas).mapToObj(x -> new Casillero()).collect(Collectors.toList());
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
