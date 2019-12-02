package Unidades.Posicion;

import static java.lang.Math.abs;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public Posicion(Posicion posicionACopiar){
        this.fila = posicionACopiar.getFila();
        this.columna = posicionACopiar.getColumna();
    }

    public void mover(Posicion nuevaPosicion){
        this.fila = nuevaPosicion.getFila();
        this.columna = nuevaPosicion.getColumna();
    }

    public int getColumna() {
        return this.columna;
    }

    public int getFila() {
        return this.fila;
    }

    public double calcularDistancia(Posicion nuevaPosicion) {
       int diferenciaFilas = abs(this.fila - nuevaPosicion.getFila());
       int diferenciaColumnas = abs(this.columna - nuevaPosicion.getColumna());
       if(diferenciaColumnas > diferenciaFilas){
           return diferenciaColumnas;
       }else return diferenciaFilas;
    }

    public void mantenerDistanciaARespectoDe(Posicion posicionCentralNueva, Posicion posicionCentralVieja) {
        int distanciaFila = posicionCentralNueva.getFila() - posicionCentralVieja.getFila();
        int distanciaColumna = posicionCentralNueva.getColumna() - posicionCentralVieja.getColumna();
        fila+=distanciaFila;
        columna+=distanciaColumna;
    }

    public Posicion calcularNuevaPosicionRespectoDe(Posicion posicionCentralNueva, Posicion posicionCentralVieja) {
        int distanciaFila = posicionCentralNueva.getFila() - posicionCentralVieja.getFila();
        int distanciaColumna = posicionCentralNueva.getColumna() - posicionCentralVieja.getColumna();
        int nuevaFila= fila + distanciaFila;
        int nuevaColumna=columna + distanciaColumna;
        return (new Posicion(nuevaFila,nuevaColumna));
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Posicion)){
            return false;
        }
        boolean columnasIguales = this.columna == ((Posicion) o).getColumna();
        boolean filasIguales = this.fila == ((Posicion) o).getFila();

        return (columnasIguales && filasIguales);

    }


}
