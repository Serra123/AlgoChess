package Unidades.Posicion;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
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
       int diferenciaFilas = this.fila - nuevaPosicion.getFila();
       int diferenciaColumnas = this.columna - nuevaPosicion.getColumna();
        return (Math.sqrt(diferenciaFilas*diferenciaFilas + diferenciaColumnas*diferenciaColumnas));
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
}
