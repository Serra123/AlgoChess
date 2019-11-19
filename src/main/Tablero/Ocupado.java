package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Unidades.Unidad;

public class Ocupado implements EstadoOcupacion {
    private Unidad unidad;

    Ocupado(Unidad unidad){
        this.unidad = unidad;
    }

    public Unidad contenido(){
        return this.unidad;
    }

    public EstadoOcupacion colocar(Unidad unaUnidad) throws ExcepcionCasilleroOcupado {
        throw new ExcepcionCasilleroOcupado();
    }

    public EstadoOcupacion vaciar(){
        return new Vacio();
    }
    public EstadoOcupacion recibirUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado{
        throw new ExcepcionCasilleroOcupado();
    }
}
