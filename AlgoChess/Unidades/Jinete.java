package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public class Jinete extends UnidadMovible {

    private static int COSTO = 3;
    private static int VIDAINICIAL = 100;

    private Arma armaDeAtaque;

    public Jinete(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        this.costo = COSTO;
        this.vida = VIDAINICIAL;
        this.vidaMaxima = VIDAINICIAL;
        this.ejercito = unNombreDeJugador;
        armaDeAtaque = new Espada();
    }

    //La única forma en la cual puede actualizar el arma con la cual va a atacar es si conoce al mapa.
    public void atacar(Unidad unaUnidad, Tablero unTablero) throws ExcepcionCasilleroVacio {
        this.armaDeAtaque = this.obtenerArmaDeAtaque(unaUnidad, unTablero);
        if(this.esAliado(unaUnidad)){
            throw new ExcepcionAtaqueAAliado();
        }
        armaDeAtaque.atacar(unaUnidad);
    }

    private Arma obtenerArmaDeAtaque(Unidad unaUnidad, Tablero unTablero) throws ExcepcionCasilleroVacio {
       boolean haySoldadoCerca = unTablero.haySoldadoCerca(this.posicion);
       //boolean hayEnemigoCerca = unTablero.hayEnemigoCerca(this.posicion);
       //boolean hayAliadoCerca = unTablero.hayAliadoCerca(this.posicion);
        if(haySoldadoCerca){
            return new ArcoYFlecha();
        }
        return new Espada();
    }

    public void cambiarArmaAEspada(){
        armaDeAtaque = new Espada();
    }

    public void cambiarArmaAArcoYFlecha(){
        armaDeAtaque = new ArcoYFlecha();
    }
}
