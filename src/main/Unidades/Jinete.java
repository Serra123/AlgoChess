package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionFinDelTablero;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Jinete extends UnidadMovible {

    private static int COSTO = 3;
    private static int VIDAINICIAL = 100;
    private static int DISTANCIACORTA = 2;

    private Arma armaDeAtaque;

    public Jinete(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        this.costo = COSTO;
        this.vida = VIDAINICIAL;
        this.vidaMaxima = VIDAINICIAL;
        this.ejercito = unNombreDeJugador;
        armaDeAtaque = new Espada();
    }

    public void atacar(Unidad unaUnidad, Tablero unTablero) throws ExcepcionFinDelTablero{
        this.armaDeAtaque = this.obtenerArmaDeAtaque(unTablero);
        if(this.esAliado(unaUnidad)){
            throw new ExcepcionAtaqueAAliado();
        }
        this.armaDeAtaque.atacar(unaUnidad,this.posicion);
    }

    //Los métodos haySoldadoAliadoCerca y hayUnidadEnemiga los puse en la clase Unidad, aunque lo podríamos
    //dejar tranquilamente en esta clase Jinte. Discutirlo.
    private Arma obtenerArmaDeAtaque(Tablero unTablero) throws ExcepcionFinDelTablero{
        ArrayList<Unidad> unidadesCercanas = unTablero.obtenerUnidadesADistancia(this.posicion, DISTANCIACORTA);
        boolean haySoldadoAliadoCerca = this.haySoldadoAliado(unidadesCercanas);
        boolean hayEnemigoCerca = this.hayUnidadEnemiga(unidadesCercanas);
        if (!hayEnemigoCerca || haySoldadoAliadoCerca) {
            return new ArcoYFlecha();
        } else {
            return new Espada();
        }
    }

    @Override
    public String getTipoUnidad(){
        String tipoUnidad = "jinete";
        return tipoUnidad;
    }
}

