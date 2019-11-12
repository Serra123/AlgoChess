package Unidades;

import Unidades.Posicion.Posicion;

public class Catapulta extends Unidad {

    private int danio;

    public void atacar(Unidad cualquierUnidad){
        cualquierUnidad.recibirAtaque(this.danio);
    }

    public Catapulta(Posicion unaPosicion, String unNombreDeJugador){
        this.vida = 50;
        this.costo = 5;
        this.danio = 20;
        this.ejercito = unNombreDeJugador;
        this.posicion = unaPosicion;
    }
    @Override
    public void recibirCuracion(int valorCuracion){
        throw new ExcepcionCuracionACatapulta();
    }
}
