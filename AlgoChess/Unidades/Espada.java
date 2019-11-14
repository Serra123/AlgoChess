package Unidades;

import Unidades.Posicion.Posicion;

public class Espada extends Arma {

    private static int DANIO = 5;

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(DANIO);
    }
    @Override
    public boolean puedeAtacar(Posicion posicionDeOrigen, Posicion posicionEnemiga){
        double distanciaAtaque = posicionDeOrigen.calcularDistancia(posicionEnemiga);
        return (distanciaAtaque <= 2);
    }
}
