package Unidades;

import Unidades.Posicion.Posicion;

public abstract class Arma {

    abstract void atacar(Unidad enemigo);
    abstract boolean puedeAtacar(Posicion posicionDeOrigen, Posicion posicioinEnemiga);
}
