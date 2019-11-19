package Unidades;

import Excepciones.ExcepcionMovimientoInvalido;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Excepciones.ExcepcionCasilleroOcupado;

public abstract class UnidadMovible extends Unidad {
    UnidadMovible(Posicion unaPosicion) {
        this.posicion = unaPosicion;

    }

    public boolean puedeMoverse(Posicion nuevaPosicion) {
        double distanciaMovimiento = this.posicion.calcularDistancia(nuevaPosicion);
        return (distanciaMovimiento < 2);
    }

    public void mover(Posicion nuevaPosicion, Tablero tablero) throws ExcepcionCasilleroOcupado, ExcepcionMovimientoInvalido {
        if(this.puedeMoverse(nuevaPosicion)) {
            tablero.moverUnidad(this, nuevaPosicion);
            this.actualizaPosicion(nuevaPosicion);
        } else throw new ExcepcionMovimientoInvalido();
    }
    public void actualizaPosicion(Posicion nuevaPosicion){
        this.posicion.mover(nuevaPosicion);
    }
}
