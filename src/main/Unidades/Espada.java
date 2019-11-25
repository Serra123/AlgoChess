package Unidades;

import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Unidades.Posicion.Posicion;

public class Espada implements Arma {

    private static final int DANIO = 5;
    private static final int DISTANCIACORTA = 2;

    @Override
    public void atacar(Unidad enemigo, Posicion posicionAtacante, boolean enemigoEstaEnSuSector) {
        double distanciaAEnemigo = posicionAtacante.calcularDistancia(enemigo.getPosicion());
        if(distanciaAEnemigo > DISTANCIACORTA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else{
            enemigo.recibirAtaque(DANIO, enemigoEstaEnSuSector);
        }
    }

}
