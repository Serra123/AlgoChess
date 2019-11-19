package Tablero;

import Excepciones.ExcepcionCasilleroVacio;
import Unidades.Unidad;

public class Vacio implements EstadoOcupacion {

    public Unidad contenido() throws ExcepcionCasilleroVacio {
        throw new ExcepcionCasilleroVacio();
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
