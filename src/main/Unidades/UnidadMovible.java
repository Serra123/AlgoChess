package Unidades;

import Excepciones.ExcepcionMovimientoInvalido;
import Excepciones.ExcepcionSuperaLimitesDelTablero;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Excepciones.ExcepcionCasilleroOcupado;

public abstract class UnidadMovible extends Unidad {

    UnidadMovible(Posicion unaPosicion) {
        this.posicion = unaPosicion;

    }

    private boolean puedeMoverse(Posicion nuevaPosicion) {
        double distanciaMovimiento = this.posicion.calcularDistancia(nuevaPosicion);
        return (distanciaMovimiento < 2);
    }

    private boolean noSuperaLimitesDelTablero(Posicion nuevaPosicion, Tablero tablero){
        return  (tablero.posicionValida(nuevaPosicion));
    }

    public void mover(Posicion nuevaPosicion, Tablero tablero) throws ExcepcionCasilleroOcupado, ExcepcionMovimientoInvalido, ExcepcionSuperaLimitesDelTablero {
        if( !this.noSuperaLimitesDelTablero(nuevaPosicion,tablero)){
            throw new ExcepcionSuperaLimitesDelTablero();
        }
        if(this.puedeMoverse(nuevaPosicion)) {
            tablero.moverUnidad(this, nuevaPosicion);
            this.actualizaPosicion(nuevaPosicion);
        } else throw new ExcepcionMovimientoInvalido();
    }
    private void actualizaPosicion(Posicion nuevaPosicion){
        this.posicion.mover(nuevaPosicion);
    }
}
