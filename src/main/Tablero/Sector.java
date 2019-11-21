package Tablero;

import Unidades.Posicion.Posicion;

class Sector {

    private int limiteInferior;
    private int limiteSuperior;

    Sector(int limiteInferior, int limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    boolean estaEnSector(Posicion unaPosicion) {
        return (unaPosicion.getFila() >= limiteInferior &&
                unaPosicion.getFila() <= limiteSuperior);
    }
}
