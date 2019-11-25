package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Unidad;

class Casillero {
    private EstadoOcupacion ocupacion;

    Casillero(){
        this.ocupacion = new Vacio();
    }

    Unidad contenido() throws ExcepcionCasilleroVacio {
        return this.ocupacion.contenido();
    }

    void colocar(Unidad unaUnidad) throws ExcepcionCasilleroOcupado {
        this.ocupacion = ocupacion.colocar(unaUnidad);
    }

    void vaciarUnidad() throws ExcepcionCasilleroVacio {
        this.ocupacion = this.ocupacion.vaciar();
    }

    void recibirUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado{
        this.ocupacion = this.ocupacion.recibirUnidad(unaUnidad);
    }
}
