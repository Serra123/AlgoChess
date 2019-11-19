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

    //La única forma en la cual puede actualizar el arma con la cual va a atacar es si conoce al mapa.
    public void atacar(Unidad unaUnidad, Tablero unTablero) throws ExcepcionFinDelTablero{
        this.armaDeAtaque = this.obtenerArmaDeAtaque(unTablero);
        if(this.esAliado(unaUnidad)){
            throw new ExcepcionAtaqueAAliado();
        }
        this.armaDeAtaque.atacar(unaUnidad,this.posicion);
    }

    //Suponemos que si hay Aliados cercanos que NO sean soldados, y hay enemigos cerca,
    // luego el arma de ataque es la espada.
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
