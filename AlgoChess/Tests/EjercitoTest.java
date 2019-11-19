package Tests;

import Excepciones.*;
import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import Unidades.UnidadMovible;
import org.junit.Test;

import java.util.ArrayList;

public class EjercitoTest {

    @Test
    public void testPuedoCrearBatallonConSoldadosCercanos(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Ejercito ejercito = new Ejercito("Jugador1");
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

        Ejercito ejercito = new Ejercito("Jugador1");
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

        Ejercito ejercito = new Ejercito("Jugador1");
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

        Ejercito ejercito = new Ejercito("Jugador1");
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




}
