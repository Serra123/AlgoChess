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

    void agregarPosicionesAfectadasPorExpansion(int unaColumna, ArrayList<Posicion> posicionesAfectadas, Tablero unTablero){
        boolean posicionNoAfectada = true;

        try{
            Casillero unCasillero = this.getCasillero(unaColumna);
            Unidad unaUnidad = unCasillero.contenido();
            Posicion unaPosicion = unaUnidad.getPosicion();
            for (Posicion posicionesAfectada : posicionesAfectadas) {
                if (unaPosicion.equals(posicionesAfectada)) {
                    posicionNoAfectada = false;
                    break;
                }
            }
            if(posicionNoAfectada){
                posicionesAfectadas.add(unaPosicion);
                unTablero.obtenerUnidadesAfectadasPorExpansion(unaPosicion,posicionesAfectadas);
            }
        }catch(ExcepcionCasilleroVacio e){
            // no tiene que hacer nada pues el casillero esta vacio.
        }catch(IndexOutOfBoundsException e){
            // no tiene que hacer nada pues el casillero no existe.
        }
    }

    int getCantidadColumnas(){
        return casilleros.size();
    }

}
