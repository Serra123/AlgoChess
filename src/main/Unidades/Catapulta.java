package Unidades;

import Excepciones.ExcepcionCatapultaNoAtacaAliados;
import Excepciones.ExcepcionCuracionACatapulta;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Catapulta extends Unidad {

    private static final int DISTANCIALEJANA = 6 ;
    private static final int DANIO = 20;
    private static final int COSTO = 5;
    private static final int VIDAINICIAL = 50;

    @Override
    public void atacar(Unidad cualquierUnidad, Tablero unTablero) throws ExcepcionDistanciaAtaqueInvalida{
        if(this.esAliado(cualquierUnidad)) {
            throw new ExcepcionCatapultaNoAtacaAliados();
        }
        if (this.distanciaA(cualquierUnidad) < DISTANCIALEJANA) {
            throw new ExcepcionDistanciaAtaqueInvalida();
        }else{
            ArrayList<Unidad> unidadesAfectadas = new ArrayList<>();
            unTablero.obtenerUnidadesDeExpansion(unidadesAfectadas,cualquierUnidad.getPosicion());
            unidadesAfectadas.forEach(e ->{
                Boolean estaEnSectorAliado = unTablero.estaEnSector(e);
                e.recibirAtaque(DANIO,estaEnSectorAliado);
            } );
        }
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

    @Override
    public String getTipoUnidad(){
        return "catapulta";
    }
}
