package Jugador;

import Controller.AlertaFinDeJuego;
import Excepciones.ExcepcionFinDeJuego;
import Excepciones.ExcepcionPuntosInsuficientes;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

public class Jugador {

    private Ejercito ejercito;
    private FabricaDeUnidades fabrica;
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.ejercito = new Ejercito(nombre);
        this.fabrica = new FabricaDeUnidades(this.ejercito);
    }

    public void crearUnidadEnPosicion(Posicion unaPosicion, String tipoUnidad, Tablero unTablero) throws ExcepcionPuntosInsuficientes {
        Unidad unaUnidad;
        this.ejercito.puedoCrearUnidad(tipoUnidad);
        unaUnidad = fabrica.crearUnidad(unaPosicion, tipoUnidad, unTablero);
        this.ejercito.agregarUnidad(unaUnidad);
    }
    public String getNombre(){ return nombre;}

    public Ejercito getEjercito(){ return ejercito;}

    public void verificarSiPierde() {
        if(this.ejercito.ejercitoVacio()){
            throw new ExcepcionFinDeJuego();
        }
    }
}
