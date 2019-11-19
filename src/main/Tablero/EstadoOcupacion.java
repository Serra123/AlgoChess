package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Unidades.Unidad;

public interface EstadoOcupacion {
    Unidad contenido() throws ExcepcionCasilleroVacio;
    EstadoOcupacion recibirUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado;
    EstadoOcupacion vaciar();
    EstadoOcupacion colocar(Unidad unaUnidad) throws ExcepcionCasilleroOcupado;
}
