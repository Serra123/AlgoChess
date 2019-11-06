package Tablero;

import Unidades.Unidad;

public class Vacio implements EstadoOcupacion {
    private Unidad unidad;
    public Unidad getUnidad(){
        throw new RuntimeException("El casillero esta Vacio!");
    }
    public void setUnidad(Unidad unidad){
        this.unidad = unidad;
        throw new RuntimeException("Cambio de estado");
    }
    public void verificarColocacion() throws ExcepcionDeCambioDeEstado {
        throw new ExcepcionDeCambioDeEstado();
    }
}
