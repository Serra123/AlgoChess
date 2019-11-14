package Unidades;

import Unidades.Posicion.Posicion;

public class ArcoYFlecha extends Arma {

    private static int DANIO = 15;

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(DANIO);
    }
    @Override
    public boolean puedeAtacar(Posicion posicionDeOrigen,Posicion posicionEnemiga){
        double distanciaAtaque = posicionDeOrigen.calcularDistancia(posicionEnemiga);
        return (distanciaAtaque <= 5 && distanciaAtaque >2);
    }
}
