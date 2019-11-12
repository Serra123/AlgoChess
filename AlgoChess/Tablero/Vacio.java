package Tablero;

import Unidades.Unidad;

public class Vacio implements EstadoOcupacion {
    private Unidad unidad;
    public Unidad contenido() throws ExcepcionCasilleroVacio{
        throw new ExcepcionCasilleroVacio();
    }
    public void setUnidad(Unidad unidad){
        this.unidad = unidad;
        throw new RuntimeException("Cambio de estado");
    }
    public EstadoOcupacion colocar(Unidad unaUnidad) {
        return new Ocupado(unaUnidad);
    }
    public EstadoOcupacion vaciar(){
        return this;
    }
    public EstadoOcupacion recibirUnidad(Unidad unaUnidad){
        return new Ocupado(unaUnidad);
    }
}
