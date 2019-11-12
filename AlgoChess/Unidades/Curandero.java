package Unidades;

import Excepciones.ExcepcionCuracionAEnemigo;
import Unidades.Posicion.Posicion;

public class Curandero extends UnidadMovible {

    private static int VALORCURACION = 15;
    private static int VIDAINICIAL = 75;
    private static int COSTO = 2;

    public Curandero(Posicion unaPosicion, String unNombreDeJugador){

        super(unaPosicion);
        this.vidaMaxima = VIDAINICIAL;
        this.vida = VIDAINICIAL;
        this.costo = COSTO;
        this.ejercito = unNombreDeJugador;
    }

    public void curar(Unidad unidadAliada) {
        if(this.esAliado(unidadAliada)){
            unidadAliada.recibirCuracion(VALORCURACION);
        }else throw new ExcepcionCuracionAEnemigo();
    }
}
