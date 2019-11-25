package Unidades;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public abstract class Unidad {

    private static final double PENALIZACIONSECTORENEMIGO = 1.05;
    double vida;
    int vidaMaxima;
    int costo;
    protected Posicion posicion;
    protected String ejercito;

    public double getVida() {
        return vida;
    }
    public int getCosto(){ return costo; }
    public String getEjercito(){ return ejercito; }

    public void recibirAtaque(int valorDanio, boolean estaEnSectorAliado) {
       if(estaEnSectorAliado){
           vida -= valorDanio;
       }
       else{
           vida -= (valorDanio * PENALIZACIONSECTORENEMIGO);
       }
    }

    void expandirAtaqueRecibido(int valorDanio, Tablero unTablero){
        unTablero.expandirDanio(this.getPosicion(),valorDanio);
    }

    //Este método lo había propuesto el corrector, falta ponerlo en uso para los lugares donde se usaba en realidad
    //el calcular distancia de posición.
    double distanciaA(Unidad unaUnidad){
        return this.posicion.calcularDistancia(unaUnidad.getPosicion());
    }


    protected void recibirCuracion(int valorCuracion) {
        vida+=valorCuracion;
        if(vida>vidaMaxima){
            vida = vidaMaxima;
        }
    }
    boolean esAliado(Unidad unaUnidad){
        return  (this.ejercito.equals(unaUnidad.getEjercito()));

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public boolean candidatoABatallonEn(Posicion unaPosicion){ return false; }

    boolean hayUnidadEnemiga(ArrayList<Unidad> unidadesCercanas) {
      return  unidadesCercanas.stream().anyMatch(unidad -> ( ! ( unidad.getEjercito().equals(this.ejercito) ) ) );
    }

    boolean haySoldadoAliado(ArrayList<Unidad> unidadesCercanas) {
        return unidadesCercanas.stream().anyMatch(unidad -> (unidad instanceof Soldado) &&
                                                            (unidad.getEjercito().equals(this.ejercito)));
    }

    public abstract String getTipoUnidad();
}
