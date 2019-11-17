package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionFinDelTablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;

import java.util.ArrayList;

public class Fila {
    private ArrayList<Casillero> casilleros;

    public Fila(int columnas, String nombreUnJugador) {
        casilleros = new ArrayList<Casillero>();
        for (int i = 0; i < columnas; i++) {
            Casillero unCasillero = new Casillero(nombreUnJugador);
            casilleros.add(unCasillero);
        }
    }

    public Casillero getCasillero(int unaColumna) {
        return casilleros.get(unaColumna);

    }

    public void colocarUnidadEnColumna(Unidad unaUnidad, int unaColumna) {
        Casillero unCasillero = this.getCasillero(unaColumna);
        unCasillero.colocar(unaUnidad);
    }
    public Unidad vaciarUnidad(int unaColumna) throws ExcepcionCasilleroVacio {
        Casillero unCasillero = this.getCasillero(unaColumna);
        return unCasillero.vaciarUnidad();
    }
    public void recibirUnidad(Unidad unaUnidad, int unaColumna)throws ExcepcionCasilleroOcupado {
        Casillero unCasillero = this.getCasillero(unaColumna);
        unCasillero.recibirUnidad(unaUnidad);
    }

    public boolean hayAlgunSoldadoADistancia(int numeroColumna, int distancia){
        Casillero casilleroActual;
        for(int i = numeroColumna - distancia; i <= numeroColumna + distancia; i++){
            casilleroActual = casilleros.get(i);
            try{
                if((casilleroActual.contenido()) instanceof Soldado){
                    return true;
                }
            }catch (ExcepcionCasilleroVacio e){
                //Manjear esta excepcion.
            }

        }
        return false;
    }
    public void agregarPosicionesAfectadasPorExpansion(int unaColumna, ArrayList<Posicion> posicionesAfectadas, Tablero unTablero){
        boolean posicionNoAfectada = true;

        try{
            Casillero unCasillero = this.getCasillero(unaColumna);
            Unidad unaUnidad = unCasillero.contenido();
            Posicion unaPosicion = unaUnidad.getPosicion();
            for(int i = 0; i < posicionesAfectadas.size();i++){
                if(unaPosicion.equals(posicionesAfectadas.get(i))){

                    posicionNoAfectada = false;
                }
            }
            if(posicionNoAfectada){
                posicionesAfectadas.add(unaPosicion);
                unTablero.obtenerUnidadesAfectadasPorExpansion(unaPosicion,posicionesAfectadas);
            }

        }catch(ExcepcionCasilleroVacio e){
            // no tiene que hacer nada pues el casillero esta vacio
        }catch(IndexOutOfBoundsException e){
            // no tiene que hacer nada pues el casillero no existe
        }
    }
}
