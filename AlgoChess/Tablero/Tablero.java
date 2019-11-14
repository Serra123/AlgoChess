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

    private static Tablero instancia;
    private static int cantFilas,cantColumnas;
    private static String nombreJugador1,nombreJugador2;


    private ArrayList<Fila> filas;
    private HashMap<String,Sector> sectores;

    public static Tablero getInstancia(){
        if(instancia == null){
            instancia = new Tablero();
        }
        return instancia;
    }

    private Tablero() {
        this.filas = new ArrayList<Fila>();

        this.sectores= new HashMap<String, Sector>();
        Sector sectorUno= new Sector(0 ,((Tablero.cantFilas/2)-1));
        sectores.put(Tablero.nombreJugador1,sectorUno);
        Sector sectorDos= new Sector(Tablero.cantFilas/2 ,Tablero.cantFilas);
        sectores.put(Tablero.nombreJugador2,sectorDos);

        for(int i=0; i < (Tablero.cantFilas/2);i++){
            Fila nuevaFila = new Fila(Tablero.cantColumnas,Tablero.nombreJugador1);
            this.filas.add(nuevaFila);

        }
        for(int i= (Tablero.cantFilas/2); i < Tablero.cantFilas;i++){
            Fila nuevaFila = new Fila(Tablero.cantColumnas,Tablero.nombreJugador2);
            this.filas.add(nuevaFila);
        }
    }
    public static void setParametrosConsigna(){
        Tablero.setCantColumnas(20);
        Tablero.setCantFilas(20);
        Tablero.setNombreJugador1("Jugador1");
        Tablero.setNombreJugador2("Jugador2");
    }

    private static void setCantFilas(int cantFilas){
        Tablero.cantFilas = cantFilas;
    }
    private static void setCantColumnas(int cantColumnas){
        Tablero.cantColumnas = cantColumnas;
    }
    private static void setNombreJugador1(String nombreJugador1){
        Tablero.nombreJugador1 = nombreJugador1;
    }
    private static void setNombreJugador2(String nombreJugador2){
        Tablero.nombreJugador2 = nombreJugador2;
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
