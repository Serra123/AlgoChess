package Unidades;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Tablero.ExcepcionCasilleroOcupado;

public abstract class UnidadMovible extends Unidad {
    UnidadMovible(Posicion unaPosicion){
        this.posicion = unaPosicion;

    }
        public void mover(Posicion nuevaPosicion, Tablero tablero)throws ExcepcionCasilleroOcupado {
            double distanciaMovimiento = this.posicion.calcularDistancia(nuevaPosicion);
            if(distanciaMovimiento < 2){
                tablero.moverUnidad(this.posicion,nuevaPosicion);
                this.posicion.mover(nuevaPosicion);
            } else throw new RuntimeException("No te podes mover tan lejos!");
        }


}
