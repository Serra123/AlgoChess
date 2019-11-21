package Unidades;

import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Unidades.Posicion.Posicion;

public class ArcoYFlecha implements Arma {

    private static int DANIO = 15;
    private static int DISTANCIACORTA = 2;
    private static int DISTANCIALEJANA = 6;

    @Override
    public void atacar(Unidad enemigo, Posicion posicionAtacante) {
        double distanciaAEnemigo = posicionAtacante.calcularDistancia(enemigo.getPosicion());
        if(distanciaAEnemigo <= DISTANCIACORTA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else if(distanciaAEnemigo >= DISTANCIALEJANA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else{
            enemigo.recibirAtaque(DANIO);
        }
    }

}
