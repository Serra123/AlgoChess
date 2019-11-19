package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionFinDelTablero;
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
    
    public void atacar(Unidad unaUnidad, Tablero unTablero) throws ExcepcionFinDelTablero{
        this.armaDeAtaque = this.obtenerArmaDeAtaque(unTablero);
        if(this.esAliado(unaUnidad)){
            throw new ExcepcionAtaqueAAliado();
        }
        this.armaDeAtaque.atacar(unaUnidad,this.posicion);
    }

    private Arma obtenerArmaDeAtaque(Tablero unTablero) throws ExcepcionFinDelTablero{
        try {
            boolean haySoldadoCerca = unTablero.haySoldadoAliadoCerca(this.posicion);
            boolean hayEnemigoCerca = unTablero.hayEnemigoCerca(this.posicion);
            if (!hayEnemigoCerca || haySoldadoCerca) {
                return new ArcoYFlecha();
            } else {
                return new Espada();
            }
        }catch(IndexOutOfBoundsException e){
            throw new ExcepcionFinDelTablero();
        }
    }

}

