package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
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
                //En realidad no habría que hacer nada en el manejo de esta excepción.
            }

        }
        return false;
    }

    public boolean hayEnemigoCerca(int numeroColumna, int distancia, String ejercitoAliado) throws ExcepcionCasilleroVacio{
        Casillero casilleroActual;
        boolean hayEnemigoCerca = false;
        for(int i = numeroColumna - distancia; i <= numeroColumna + distancia; i++){
            casilleroActual = casilleros.get(i);
            Unidad unaUnidad;
            try{
                unaUnidad = casilleroActual.contenido();
                if(!(unaUnidad.getEjercito().equals(ejercitoAliado))){
                    hayEnemigoCerca = true;
                }
            }catch (ExcepcionCasilleroVacio e){
                //En realidad no habría que hacer nada en el manejo de esta excepción.
            }
        }
        return hayEnemigoCerca;
    }

}
