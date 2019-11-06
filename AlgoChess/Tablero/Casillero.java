package Tablero;

import Unidades.Unidad;

public class Casillero {
    private EstadoOcupacion ocupacion;
    private String nombreEjercito;

    Casillero(String nombreJugador){
        this.nombreEjercito = nombreJugador;
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

    public void verificarColocacion() throws ExcepcionDeCambioDeEstado,ExcepcionCasilleroOcupado {
        ocupacion.verificarColocacion();
    }

    public void verificarSector(Unidad unaUnidad) throws ExcepcionSectorEnemigo {
        if(this.nombreEjercito != unaUnidad.getEjercito()){
            throw new ExcepcionSectorEnemigo();
        }
    }

    public void cambiarEstadoAOcupado(Unidad unidad) {
        ocupacion = new Ocupado(unidad);
    }

    public void cambiarEstadoAVacio() { ocupacion = new Vacio();}
}
