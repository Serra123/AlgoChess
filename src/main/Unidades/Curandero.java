package Unidades;

import Excepciones.ExcepcionCuracionAEnemigo;
import Excepciones.ExcepcionCuranderoNoAtaca;
import Excepciones.ExcepcionDistanciaCuracionInvalida;
import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public class Curandero extends UnidadMovible {

    private static final int DISTANCIACERCANA = 2 ;
    private static final int VALORCURACION = 15;
    private static final int VIDAINICIAL = 75;
    private static final int COSTO = 2;

    public Curandero(Posicion unaPosicion, Ejercito unEjercito){

        super(unaPosicion);
        this.vidaMaxima = VIDAINICIAL;
        this.vida = VIDAINICIAL;
        this.costo = COSTO;
        this.ejercito = unEjercito;
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
        return "curandero";
    }

    @Override
    public void atacar(Unidad unidad, Tablero tablero)throws ExcepcionCuranderoNoAtaca {
        throw new ExcepcionCuranderoNoAtaca();
    }
}
