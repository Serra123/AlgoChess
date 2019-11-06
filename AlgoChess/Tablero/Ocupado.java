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

    public void verificarColocacion() throws ExcepcionCasilleroOcupado{
        throw new ExcepcionCasilleroOcupado();
    }
}
