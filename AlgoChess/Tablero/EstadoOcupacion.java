package Tablero;

import Unidades.Unidad;

public interface EstadoOcupacion {
    Unidad contenido() throws ExcepcionCasilleroVacio;
    void setUnidad(Unidad unidad);
    EstadoOcupacion recibirUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado;
    EstadoOcupacion vaciar();
    EstadoOcupacion colocar(Unidad unaUnidad) throws ExcepcionCasilleroOcupado;
}
