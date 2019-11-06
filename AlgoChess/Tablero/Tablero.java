package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Tablero {

    private ArrayList<Fila> filas;

    public Tablero(int filas, int columnas, String nombreUnJugador, String nombreOtroJugador) {
        this.filas = new ArrayList<Fila>();
        for(int i=0; i < (filas/2);i++){
            Fila nuevaFila = new Fila(columnas,nombreUnJugador);
            this.filas.add(nuevaFila);
        }
        for(int i= (filas/2); i < filas;i++){
            Fila nuevaFila = new Fila(columnas,nombreOtroJugador);
            this.filas.add(nuevaFila);
        }


    }

    public void colocarUnidad(Unidad unidad, Posicion posicion) {
        Casillero unCasillero = this.getCasillero(posicion);
        try {
            unCasillero.verificarColocacion();
        }catch(ExcepcionDeCambioDeEstado e){
            unCasillero.cambiarEstadoAOcupado(unidad);
        }

    }
    public Unidad getUnidad(Posicion unaPosicion){
        Casillero unCasillero = this.getCasillero(unaPosicion);
        return unCasillero.getUnidad();
    }
    private Casillero getCasillero(Posicion unaPosicion){
        int fila = unaPosicion.getFila();
        Casillero unCasillero = (filas.get(fila)).getCasillero(unaPosicion);
        return unCasillero;
    }
}
