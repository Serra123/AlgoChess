package Unidades;

import Excepciones.ExcepcionCuracionACatapulta;
import Unidades.Posicion.Posicion;

public class Catapulta extends Unidad {

    private static int DANIO = 20;
    private static int COSTO = 5;
    private static int VIDAINICIAL = 50;

    public void atacar(Unidad cualquierUnidad){
        cualquierUnidad.recibirAtaque(DANIO);
    }

    public Catapulta(Posicion unaPosicion, String unNombreDeJugador){

        this.vidaMaxima=VIDAINICIAL;
        this.costo = COSTO;
        this.vida = VIDAINICIAL;
        this.ejercito = unNombreDeJugador;
        this.posicion = unaPosicion;
    }
    @Override
    public void recibirCuracion(int valorCuracion){
        throw new ExcepcionCuracionACatapulta();
    }
}
