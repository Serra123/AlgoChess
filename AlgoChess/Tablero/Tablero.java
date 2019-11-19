package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionFinDelTablero;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {

    private static final int DISTANCIACORTA = 2;
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

    public void colocarUnidad(Unidad unidad) throws ExcepcionCasilleroOcupado, ExcepcionSectorEnemigo {
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

    public boolean haySoldadoCerca(Posicion unaPosicion) throws ExcepcionCasilleroVacio {
        int numeroFila = unaPosicion.getFila();
        int numeroColumna = unaPosicion.getColumna();
        String ejercitoAliado = this.filas.get(numeroFila).getCasillero(numeroColumna).contenido().getEjercito();
        boolean haySoldadoAliadoCerca = false;
        boolean haySoldadoAliadoEnFila;
        Fila filaActual;
        for(int i = numeroFila - DISTANCIACORTA; i <= numeroFila + DISTANCIACORTA ; i++){
            filaActual = filas.get(i);
            try {
                haySoldadoAliadoEnFila = filaActual.hayAlgunSoldadoADistancia(unaPosicion,ejercitoAliado,DISTANCIACORTA);
                if(haySoldadoAliadoEnFila){
                    haySoldadoAliadoCerca = true;
                }
            }catch (ExcepcionCasilleroVacio e){
                //No hay que hacer nada sobre el manejo de esta excepción.
            }
        }

        return haySoldadoAliadoCerca;
    }

    public boolean hayEnemigoCerca(Posicion unaPosicion) throws ExcepcionCasilleroVacio {
        int numeroFila = unaPosicion.getFila();
        String ejercitoAliado = this.getUnidad(unaPosicion).getEjercito();
        boolean hayEnemigoCerca = false;
        boolean hayEnemigoEnFila;
        Fila filaActual;
        for(int i = numeroFila - DISTANCIACORTA; i <= numeroFila + DISTANCIACORTA ; i++){
            filaActual = filas.get(i);
            try {
                hayEnemigoEnFila = filaActual.hayEnemigoCerca(unaPosicion,ejercitoAliado);
                if(hayEnemigoEnFila){
                    hayEnemigoCerca = true;
                }
            }catch (ExcepcionCasilleroVacio e){
                //No hay que hacer nada sobre el manejo de esta excepción.
            }
        }

        return hayEnemigoCerca;
    }

    public void expandirDanio(Posicion unaPosicion,int unDanio){
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        posiciones.add(unaPosicion);
        this.obtenerUnidadesAfectadasPorExpansion(unaPosicion,posiciones);
        posiciones.forEach((posicion) -> this.getUnidad(posicion).recibirAtaque(unDanio));

    }

    public void obtenerUnidadesAfectadasPorExpansion(Posicion unaPosicion,ArrayList<Posicion> posiciones){
        int filaCentro = unaPosicion.getFila();
        int columnaCentro = unaPosicion.getColumna();
        Fila filaActual;

        for(int i = filaCentro -1; i <= filaCentro+1;i++) {
            try {
                filaActual = filas.get(i);
            }catch(IndexOutOfBoundsException e){
                continue;
            }
            for (int j = columnaCentro - 1; j <= columnaCentro + 1; j++) {
                if ((i != filaCentro) || (j != columnaCentro)) {
                    filaActual.agregarPosicionesAfectadasPorExpansion(j, posiciones, this);
                }
            }
        }
    }
}
