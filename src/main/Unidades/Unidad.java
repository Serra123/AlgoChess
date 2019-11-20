package Unidades;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public abstract class Unidad {

    protected int vida;
    protected int vidaMaxima;
    protected int costo;
    protected Posicion posicion;
    protected String ejercito;

    public int getVida() {
        return vida;
    }
    public int getCosto(){ return costo; }
    public String getEjercito(){ return ejercito; }

    public void recibirAtaque(int valorDanio) {
        vida -= valorDanio;
    }

    public void expandirAtaqueRecibido(int valorDanio, Tablero unTablero){
        unTablero.expandirDanio(this.getPosicion(),valorDanio);
    }


    protected void recibirCuracion(int valorCuracion) {
        vida+=valorCuracion;
        if(vida>vidaMaxima){
            vida = vidaMaxima;
        }
    }
    public boolean esAliado(Unidad unaUnidad){
        return  (this.ejercito.equals(unaUnidad.getEjercito()));

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public boolean candidatoABatallonEn(Posicion unaPosicion){ return false; }
}
