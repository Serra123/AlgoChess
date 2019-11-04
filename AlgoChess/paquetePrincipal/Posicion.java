package paquetePrincipal;

public class Posicion {
    private int fila;
    private int columna;

    Posicion(int fila, int columna){
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
       double distancia = Math.sqrt(diferenciaFilas*diferenciaFilas + diferenciaColumnas*diferenciaColumnas);

       return distancia;
    }
}
