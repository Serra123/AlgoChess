package Unidades;

import Unidades.Posicion.Posicion;

public class Unidad {
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected String ejercito;

    public int getVida() {
        return vida;
    }

    protected void recibirAtaque(int valorDanio) {
        vida -= valorDanio;
    }

    protected void recibirCuracion(int valorCuracion) {

        vida+=valorCuracion;
    }
}
