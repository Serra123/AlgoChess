package Unidades;

import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Unidades.Posicion.Posicion;

public class ArcoYFlecha implements Arma {

    private static final int DANIO = 15;
    private static final int DISTANCIACORTA = 2;
    private static final int DISTANCIALEJANA = 6;

    @Override
    public void atacar(Unidad enemigo, Posicion posicionAtacante, boolean enemigoEstaEnSuSector) {
        double distanciaAEnemigo = posicionAtacante.calcularDistancia(enemigo.getPosicion());
        if(distanciaAEnemigo <= DISTANCIACORTA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else if(distanciaAEnemigo >= DISTANCIALEJANA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else{
            enemigo.recibirAtaque(DANIO, enemigoEstaEnSuSector);
        }
    }

}
