package Unidades;

import Unidades.Posicion.Posicion;

public class Curandero extends UnidadMovible {

    private int valorCuracion;

    Curandero(int fila, int columna,String unNombreDeJugador){
        vida = 75;
        valorCuracion= 15;
        this.ejercito = unNombreDeJugador;
        this.posicion = new Posicion(fila,columna);
    }

    public void curar(Unidad unidadAliada) {

        unidadAliada.recibirCuracion(valorCuracion);
    }
}
