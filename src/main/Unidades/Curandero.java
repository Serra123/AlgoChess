package Unidades;

import Excepciones.ExcepcionCuracionAEnemigo;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Excepciones.ExcepcionDistanciaCuracionInvalida;
import Unidades.Posicion.Posicion;

public class Curandero extends UnidadMovible {

    private static final int DISTANCIACERCANA = 2 ;
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

    public void curar(Unidad unidadAliada) throws ExcepcionCuracionAEnemigo, ExcepcionDistanciaCuracionInvalida {
        if(this.distanciaA(unidadAliada) >= DISTANCIACERCANA){
            throw new ExcepcionDistanciaCuracionInvalida();
        }
        if(this.esAliado(unidadAliada)){
            unidadAliada.recibirCuracion(VALORCURACION);
        }else throw new ExcepcionCuracionAEnemigo();
    }
    @Override
    public String getTipoUnidad(){
        String tipoUnidad = "curandero";
        return tipoUnidad;
    }
}
