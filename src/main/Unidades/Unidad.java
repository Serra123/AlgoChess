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

    void recibirAtaque(int valorDanio, boolean estaEnSectorAliado) {
       if(estaEnSectorAliado){
           vida -= valorDanio;
       }
       else{
           vida -= (valorDanio * PENALIZACIONSECTORENEMIGO);
       }
    }

    void expandirAtaqueRecibido(int valorDanio, Tablero unTablero){
        ArrayList<Posicion> posicionesAfectadas = new ArrayList<>();
        posicionesAfectadas = unTablero.obtenerPosicionesAfectadasPorExpansion(this.posicion,posicionesAfectadas);
        posicionesAfectadas.forEach((posicion) -> {
                    boolean estaEnSectorAliado = unTablero.estaEnSector(unTablero.getUnidad(posicion));
                    unTablero.getUnidad(posicion).recibirAtaque(valorDanio, estaEnSectorAliado);
                }
        );
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

    public abstract void atacar(Unidad unidadEnemiga, Tablero unTablero);
}
