package Unidades;

import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public abstract class Unidad {

    private static final double PENALIZACIONSECTORENEMIGO = 1.05;
    double vida;
    int vidaMaxima;
    int costo;
    protected Posicion posicion;
    protected Ejercito ejercito;

    public double getVida() {
        return vida;
    }
    public int getCosto(){ return costo; }
    public String getNombreJugador(){ return ejercito.getNombreEjercito(); }
    public Ejercito getEjercito(){ return ejercito; }

    void recibirAtaque(int valorDanio, boolean estaEnSectorAliado) {
       if(estaEnSectorAliado){
           vida -= valorDanio;
       }
       else{
           vida -= (valorDanio * PENALIZACIONSECTORENEMIGO);
       }
        if(this.getVida() <= 0 ){
            this.getEjercito().eliminarUnidad(this);
        }
    }


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
        return  (this.ejercito.getNombreEjercito().equals(unaUnidad.getNombreJugador()));

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public boolean candidatoABatallonEn(Posicion unaPosicion){ return false; }

    boolean hayUnidadEnemiga(ArrayList<Unidad> unidadesCercanas) {
      return  unidadesCercanas.stream().anyMatch(unidad -> ( ! ( unidad.getNombreJugador().equals(this.ejercito.getNombreEjercito()) ) ) );
    }

    boolean haySoldadoAliado(ArrayList<Unidad> unidadesCercanas) {
        return unidadesCercanas.stream().anyMatch(unidad -> (unidad instanceof Soldado) &&
                                                            (unidad.getNombreJugador().equals(this.ejercito.getNombreEjercito())));
    }

    public abstract String getTipoUnidad();

    public abstract void atacar(Unidad unidadEnemiga, Tablero unTablero);
}
