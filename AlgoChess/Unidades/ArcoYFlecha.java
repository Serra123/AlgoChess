package Unidades;

import Excepciones.ExcepcionAtaqueCercanoConArcoYFlecha;
import Excepciones.ExcepcionAtaqueLejanoConArcoYFlecha;
import Unidades.Posicion.Posicion;

public class ArcoYFlecha extends Arma {

    private static int DANIO = 15;
    private static int DISTANCIACORTA = 2;
    private static int DISTANCIALEJANA = 6;

    @Override
    public void atacar(Unidad enemigo, Posicion posicionAtacante) {
        double distanciaAEnemigo = posicionAtacante.calcularDistancia(enemigo.posicion);
        if(distanciaAEnemigo <= DISTANCIACORTA){
            throw new ExcepcionAtaqueCercanoConArcoYFlecha();
        }
        else if(distanciaAEnemigo >= DISTANCIALEJANA){
            throw new ExcepcionAtaqueLejanoConArcoYFlecha();
        }
        else{
            enemigo.recibirAtaque(DANIO);
        }
    }

}
