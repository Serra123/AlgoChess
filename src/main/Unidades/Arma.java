package Unidades;

import Unidades.Posicion.Posicion;

public abstract class Arma {

    abstract void atacar(Unidad enemigo, Posicion posicionAtacante);
}
