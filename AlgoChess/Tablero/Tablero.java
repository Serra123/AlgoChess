package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class Tablero {

    private ArrayList<Fila> filas;
    private HashMap<String,Sector> sectores;

    public Tablero(int filas, int columnas, String nombreUnJugador, String nombreOtroJugador) {
        this.filas = new ArrayList<Fila>();

        this.sectores= new HashMap<String, Sector>();
        Sector sectorUno= new Sector(0 ,9);
        sectores.put(nombreUnJugador,sectorUno);
        Sector sectorDos= new Sector(10 ,19);
        sectores.put(nombreOtroJugador,sectorDos);

        for(int i=0; i < (filas/2);i++){
            Fila nuevaFila = new Fila(columnas,nombreUnJugador);
            this.filas.add(nuevaFila);

        }
        for(int i= (filas/2); i < filas;i++){
            Fila nuevaFila = new Fila(columnas,nombreOtroJugador);
            this.filas.add(nuevaFila);
        }



    }

    public boolean estaEnSector(String nombreEjercito,Posicion unaPosicion){

        Sector sector = sectores.get(nombreEjercito);

        return (sector.estaEnSector(unaPosicion.getFila()));

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
