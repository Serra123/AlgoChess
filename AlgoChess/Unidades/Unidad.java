package Unidades;

import Unidades.Posicion.Posicion;

public class Unidad {
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected String ejercito;
    protected Boolean estaVivo;

    public int getVida() {
        return vida;
    }
    public int getCosto(){ return costo; }

    protected void recibirAtaque(int valorDanio) {
        vida -= valorDanio;
        this.estaVivo = this.vida > 0;

    }

    protected void recibirCuracion(int valorCuracion) {

        vida+=valorCuracion;
    }

}
