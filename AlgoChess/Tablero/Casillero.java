package Tablero;

import Unidades.Unidad;

public class Casillero {
    private EstadoOcupacion ocupacion;
    private String nombreJugador;

    Casillero(String nombreJugador){
        this.nombreJugador = nombreJugador;
        this.ocupacion = new Vacio();
    }
    public void setUnidad(Unidad unidad) {
        try {
            ocupacion.setUnidad(unidad);
        } catch (RuntimeException e) {
            this.ocupacion = new Ocupado(unidad);
        }
    }

    public Unidad getUnidad() {
        return this.ocupacion.getUnidad();
    }

    public void verificarColocacion() throws ExcepcionDeCambioDeEstado {
        ocupacion.verificarColocacion();
    }

    public void cambiarEstadoAOcupado(Unidad unidad) {
        ocupacion = new Ocupado(unidad);
    }
}
