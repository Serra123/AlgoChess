package Unidades;

import Excepciones.ExcepcionCuracionACatapulta;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public class Catapulta extends Unidad {

    private static final int DISTANCIALEJANA = 6 ;
    private static int DANIO = 20;
    private static int COSTO = 5;
    private static int VIDAINICIAL = 50;

    public void atacar(Unidad cualquierUnidad, Tablero unTablero) throws ExcepcionDistanciaAtaqueInvalida{
        if(this.posicion.calcularDistancia(cualquierUnidad.getPosicion()) >= DISTANCIALEJANA){
            cualquierUnidad.expandirAtaqueRecibido(DANIO, unTablero);
        }else throw new ExcepcionDistanciaAtaqueInvalida();
    }

    public Catapulta(Posicion unaPosicion, String unNombreDeJugador){

        this.vidaMaxima= VIDAINICIAL;
        this.costo = COSTO;
        this.vida = VIDAINICIAL;
        this.ejercito = unNombreDeJugador;
        this.posicion = unaPosicion;
    }
    @Override
    public void recibirCuracion(int valorCuracion) throws ExcepcionCuracionACatapulta{
        throw new ExcepcionCuracionACatapulta();
    }
}
