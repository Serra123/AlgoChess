package Jugador;

import Excepciones.ExcepcionPuntosInsuficientes;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

public class Jugador {

    private Ejercito ejercito;
    private FabricaDeUnidades fabrica;

    public Jugador(String nombre){
        this.ejercito = new Ejercito();
        this.fabrica = new FabricaDeUnidades(nombre);
    }

    public void crearUnidadEnPosicion(Posicion unaPosicion, String tipoUnidad, Tablero unTablero) throws ExcepcionPuntosInsuficientes {
        Unidad unaUnidad;
        unaUnidad = fabrica.crearUnidad(unaPosicion, tipoUnidad, unTablero);
        unTablero.colocarUnidad(unaUnidad);
        this.ejercito.agregarUnidad(unaUnidad);
    }

}
