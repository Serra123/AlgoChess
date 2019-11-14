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

    public void mover(Posicion nuevaPosicion) throws ExcepcionCasilleroOcupado, ExcepcionMovimientoInvalido {
        Tablero unTablero = Tablero.getInstancia();
        if(this.puedeMoverse(nuevaPosicion)) {
            unTablero.moverUnidad(this, nuevaPosicion);
            this.actualizarPosicion(nuevaPosicion);
        } else throw new ExcepcionMovimientoInvalido();
    }
    public void actualizarPosicion(Posicion nuevaPosicion){
        this.posicion.mover(nuevaPosicion);
    }
}
