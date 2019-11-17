package Unidades;

import Unidades.Posicion.Posicion;

public abstract class Unidad {

    protected int vida;
    protected int vidaMaxima;
    protected int costo;
    protected Posicion posicion;
    protected String ejercito;
    protected Boolean estaVivo;

    public int getVida() {
        return vida;
    }
    public int getCosto(){ return costo; }
    public String getEjercito(){ return ejercito; }

    protected void recibirAtaque(int valorDanio) {
        vida -= valorDanio;
        this.estaVivo = this.vida > 0;

    }

    protected void recibirCuracion(int valorCuracion) {
        vida+=valorCuracion;
        if(vida>vidaMaxima){
            vida = vidaMaxima;
        }
    }
    public boolean esAliado(Unidad unaUnidad){
        return  (this.ejercito == unaUnidad.getEjercito());

    }

    public boolean getEstaMuerto() {
        return (!this.estaVivo);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }
}
