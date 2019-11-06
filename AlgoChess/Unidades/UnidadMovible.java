package Unidades;

import Unidades.Posicion.Posicion;

public class UnidadMovible extends Unidad {
    UnidadMovible(int fila,int columna){
        this.posicion = new Posicion(fila,columna);

    }
        public void mover(Posicion nuevaPosicion){
            double distanciaMovimiento = this.posicion.calcularDistancia(nuevaPosicion);
            if(distanciaMovimiento < 2){
            this.posicion.mover(nuevaPosicion);
            } else throw new RuntimeException("No te podes mover tan lejos!");
        }


}
