package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Unidad;

import java.util.ArrayList;

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

    public void colocarUnidad(Unidad unidad)throws ExcepcionCasilleroOcupado,ExcepcionSectorEnemigo {
        Posicion unaPosicion = unidad.getPosicion();
        Fila unaFila = filas.get(unaPosicion.getFila());
        unaFila.colocarUnidadEnColumna(unidad,unaPosicion.getColumna());
    }
    public void moverUnidad(Posicion posicionAnterior,Posicion posicionNueva) throws ExcepcionCasilleroOcupado, ExcepcionCasilleroVacio{
        Fila filaAnterior = filas.get(posicionAnterior.getFila());
        Fila filaNueva = filas.get(posicionNueva.getFila());
        Unidad unaUnidad = filaAnterior.vaciarUnidad(posicionAnterior.getColumna());
        filaNueva.recibirUnidad(unaUnidad,posicionNueva.getColumna());
    }
    public Unidad getUnidad(Posicion unaPosicion){
        Fila unaFila = filas.get(unaPosicion.getFila());
        Casillero unCasillero = unaFila.getCasillero(unaPosicion.getColumna());
        return unCasillero.contenido();
    }
}
