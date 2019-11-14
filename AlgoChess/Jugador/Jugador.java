package Jugador;

import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

public class Jugador {

    private int puntos;
    private Ejercito ejercito;
    private FabricaDeUnidades fabrica;

    private static int PUNTOSINICIALES = 20;

    public Jugador(String nombre){
        this.puntos = PUNTOSINICIALES;
        this.ejercito = new Ejercito(nombre);
        this.fabrica = new FabricaDeUnidades(nombre);
    }
    private void reducirPuntos(int costo) {
        this.puntos -= costo;
        if(this.puntos < 0) throw new RuntimeException("No alcanzan los puntos");
    }

    public void crearUnidadEnPosicion(Posicion unaPosicion, String tipoUnidad){
        Unidad unaUnidad;
        unaUnidad = fabrica.crearUnidad(unaPosicion, tipoUnidad);
        this.reducirPuntos(unaUnidad.getCosto());
        this.ejercito.agregarUnidad(unaUnidad);
    }
}
