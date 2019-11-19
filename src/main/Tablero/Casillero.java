package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Unidad;

public class Casillero {
    private EstadoOcupacion ocupacion;

    Casillero(){
        this.ocupacion = new Vacio();
    }

    public Unidad contenido() throws ExcepcionCasilleroVacio {
        return this.ocupacion.contenido();
    }

    public void colocar(Unidad unaUnidad) throws ExcepcionCasilleroOcupado {
        EstadoOcupacion unEstadoOcupacion = ocupacion.colocar(unaUnidad);
       this.ocupacion = unEstadoOcupacion;
    }

    public Unidad vaciarUnidad() throws ExcepcionCasilleroVacio {
        Unidad unaUnidad = this.ocupacion.contenido();
        EstadoOcupacion unEstado = this.ocupacion.vaciar();
        this.ocupacion = unEstado;
        return unaUnidad;
    }
    public void recibirUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado{
        EstadoOcupacion unEstado = this.ocupacion.recibirUnidad(unaUnidad);
        this.ocupacion = unEstado;
    }
}
