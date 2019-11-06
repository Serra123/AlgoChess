package Tablero;

import Unidades.Unidad;

public class Ocupado implements EstadoOcupacion {
    private Unidad unidad;

    Ocupado(Unidad unidad){
        this.unidad = unidad;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public void setUnidad(Unidad unidad){

    }

    public void verificarColocacion(){
        throw new RuntimeException("Ya hay una unidad en este casillero!");
    }
}
