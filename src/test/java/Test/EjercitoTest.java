package Test;

import Excepciones.*;
import Jugador.Ejercito;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EjercitoTest {

    @Test (expected = ExcepcionPuntosInsuficientes.class)
    public void testJugadorNoLeAlcanzanLosPuntosParaAgregarNuevaUnidadSaltaExcepcion(){
        Jugador unJugador = new Jugador("Jugador1");

        Posicion posicionUno = new Posicion(0,0);
        Posicion posicionDos = new Posicion(1,0);
        Posicion posicionTres = new Posicion(2,0);
        Posicion posicionCuatro = new Posicion(3,0);
        Posicion posicionCinco = new Posicion(4,0);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        unJugador.crearUnidadEnPosicion(posicionUno,"Catapulta",unTablero);
        unJugador.crearUnidadEnPosicion(posicionDos,"Catapulta",unTablero);
        unJugador.crearUnidadEnPosicion(posicionTres,"Catapulta",unTablero);
        unJugador.crearUnidadEnPosicion(posicionCuatro,"Catapulta",unTablero);
        unJugador.crearUnidadEnPosicion(posicionCinco,"Catapulta",unTablero);
    }

    @Test (expected = ExcepcionPuntosInsuficientes.class)
    public void testJugadorIntentaAgregarUnidadSinPuntosNecesariosNoPuedeYLosPuntosQuedanIntactos(){
        Ejercito unEjercito = new Ejercito("Jugador 1");
        Ejercito otroEjercito = new Ejercito("Jugador2");

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,2);
        Posicion posicionTres = new Posicion(3,3);
        Posicion posicionCuatro = new Posicion(4,4);
        Posicion posicionCinco = new Posicion(5,5);

        Catapulta catapultaUno = new Catapulta(posicionUno,otroEjercito);
        Catapulta catapultaDos = new Catapulta(posicionDos,otroEjercito);
        Catapulta catapultaTres = new Catapulta(posicionTres,otroEjercito);
        Catapulta catapultaCuatro = new Catapulta(posicionCuatro,otroEjercito);
        Catapulta catapultaCinco = new Catapulta(posicionCinco,otroEjercito);

        unEjercito.agregarUnidad(catapultaUno);
        unEjercito.agregarUnidad(catapultaDos);
        unEjercito.agregarUnidad(catapultaTres);
        unEjercito.agregarUnidad(catapultaCuatro);
        unEjercito.agregarUnidad(catapultaCinco);

        Assert.assertEquals(0,unEjercito.getPuntos());
    }

}
