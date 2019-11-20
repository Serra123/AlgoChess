package Unidades;

import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Unidades.Posicion.Posicion;

public class Espada implements Arma {

    private static int DANIO = 5;
    private static int DISTANCIACORTA = 2;

    @Override
    public void atacar(Unidad enemigo, Posicion posicionAtacante) {
        double distanciaAEnemigo = posicionAtacante.calcularDistancia(enemigo.posicion);
        if(distanciaAEnemigo > DISTANCIACORTA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else{
            enemigo.recibirAtaque(DANIO);
        }
    }

}
