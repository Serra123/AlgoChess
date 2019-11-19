package Tests;

import Excepciones.*;
import Jugador.Ejercito;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class EjercitoTest {

    @Test
    public void testPuedoCrearBatallonConSoldadosCercanos(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Ejercito ejercito = new Ejercito();
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral,unTablero);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }


    @Test (expected = ExcepcionLasUnidadesEstanSeparadas.class)
    public void testNoPuedoCrearBatallonConSoldadosSeparados() {

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Ejercito ejercito = new Ejercito();
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,4);

        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral,unTablero);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test (expected = ExcepcionSoldadosNoPerteneceATuEjercito.class)
    public void testNoPuedoCrearBatallonConSoldadosDeDistintosJugadores() {

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Ejercito ejercito = new Ejercito();
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        UnidadMovible soldadoUno = new Soldado(posicionUno,"Carlos");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Esteban");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Carlos");


        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral,unTablero);
    }

    @Test (expected = ExcepcionTipoUnidadInvalida.class)
    public void testNoPuedoCrearBatallonConUnidadesQueNoSonSoldados() {

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Ejercito ejercito = new Ejercito();
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible jinete = new Jinete(posicionTres,"Jugador1");


        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(jinete);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral,unTablero);
    }

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
        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,2);
        Posicion posicionTres = new Posicion(3,3);
        Posicion posicionCuatro = new Posicion(4,4);
        Posicion posicionCinco = new Posicion(5,5);

        Catapulta catapultaUno = new Catapulta(posicionUno,"Jugador 2");
        Catapulta catapultaDos = new Catapulta(posicionDos,"Jugador 2");
        Catapulta catapultaTres = new Catapulta(posicionTres,"Jugador 2");
        Catapulta catapultaCuatro = new Catapulta(posicionCuatro,"Jugador 2");
        Catapulta catapultaCinco = new Catapulta(posicionCinco,"Jugador 2");

        unEjercito.agregarUnidad(catapultaUno);
        unEjercito.agregarUnidad(catapultaDos);
        unEjercito.agregarUnidad(catapultaTres);
        unEjercito.agregarUnidad(catapultaCuatro);
        unEjercito.agregarUnidad(catapultaCinco);

        Assert.assertEquals(0,unEjercito.getPuntos());
    }





}
