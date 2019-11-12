package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {

    private ArrayList<Fila> filas;
    private HashMap<String,Sector> sectores;

    public Tablero(int filas, int columnas, String nombreUnJugador, String nombreOtroJugador) {
        this.filas = new ArrayList<Fila>();

        this.sectores= new HashMap<String, Sector>();
        Sector sectorUno= new Sector(0 ,((filas/2)-1));
        sectores.put(nombreUnJugador,sectorUno);
        Sector sectorDos= new Sector(filas/2 ,filas);
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

    public void colocarUnidad(Unidad unidad)throws ExcepcionCasilleroOcupado, ExcepcionSectorEnemigo {
        String unEjercito = unidad.getEjercito();
        Posicion unaPosicion = unidad.getPosicion();
        if (this.estaEnSector(unEjercito, unaPosicion)) {
            Fila unaFila = filas.get(unaPosicion.getFila());
            unaFila.colocarUnidadEnColumna(unidad, unaPosicion.getColumna());
        } else throw new ExcepcionSectorEnemigo();
    }
    public void moverUnidad(UnidadMovible unaUnidadMovible,Posicion posicionNueva) throws ExcepcionCasilleroOcupado, ExcepcionCasilleroVacio {
        Posicion unaPosicion = unaUnidadMovible.getPosicion();
        Fila filaAnterior = filas.get(unaPosicion.getFila());
        Fila filaNueva = filas.get(posicionNueva.getFila());
        filaAnterior.vaciarUnidad(unaPosicion.getColumna());
        filaNueva.recibirUnidad(unaUnidadMovible,posicionNueva.getColumna());
    }
    public Unidad getUnidad(Posicion unaPosicion){
        Fila unaFila = filas.get(unaPosicion.getFila());
        Casillero unCasillero = unaFila.getCasillero(unaPosicion.getColumna());
        return unCasillero.contenido();
    }
}
