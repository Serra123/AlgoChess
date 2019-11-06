package Unidades;

import Unidades.Posicion.Posicion;

public class Curandero extends UnidadMovible {

    private int valorCuracion;

    public Curandero(Posicion unaPosicion, String unNombreDeJugador){
        super(unaPosicion);
        vida = 75;
        valorCuracion= 15;
        this.ejercito = unNombreDeJugador;
    }

    public void curar(Unidad unidadAliada) {

        unidadAliada.recibirCuracion(valorCuracion);
    }
}
