package Unidades;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public class UnidadMovible extends Unidad {
    UnidadMovible(int fila,int columna){
        this.posicion = new Posicion(fila,columna);

    }
        public void mover(Posicion nuevaPosicion, Tablero tablero){
            double distanciaMovimiento = this.posicion.calcularDistancia(nuevaPosicion);
            if(distanciaMovimiento < 2){
                tablero.moverUnidad(this.posicion,nuevaPosicion);
                this.posicion.mover(nuevaPosicion);
            } else throw new RuntimeException("No te podes mover tan lejos!");
        }


}
