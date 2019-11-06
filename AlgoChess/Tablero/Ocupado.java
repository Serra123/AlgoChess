package Tablero;

import Unidades.Unidad;

public class Ocupado implements EstadoOcupacion {
    private Unidad unidad;
    @Override
    public Unidad getUnidad(){
        return this.unidad;
    }
    @Override
    public void setUnidad(Unidad unidad){
        throw new RuntimeException("Ya hay una unidad en este casillero!");
    }
    Ocupado(Unidad unidad){
        this.unidad = unidad;
    }
}
