package Tests;

import Excepciones.*;
import Jugador.Ejercito;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import org.junit.Test;

import java.util.ArrayList;

public class EjercitoTest {

    @Test
    public void testPuedoCrearBatallonConSoldadosCercanos(){

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Unidad soldadoUno = new Soldado(posicionUno,"Jugador1");
        Unidad soldadoDos = new Soldado(posicionDos,"Jugador1");
        Unidad soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Unidad> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }


    @Test (expected = ExcepcionLasUnidadesEstanSeparadas.class)
    public void testNoPuedoCrearBatallonConSoldadosSeparados() {

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,4);

        Unidad soldadoUno = new Soldado(posicionUno,"Jugador1");
        Unidad soldadoDos = new Soldado(posicionDos,"Jugador1");
        Unidad soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Unidad> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test (expected = ExcepcionSoldadosNoPerteneceATuEjercito.class)
    public void testNoPuedoCrearBatallonConSoldadosDeDistintosJugadores() {

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Unidad soldadoUno = new Soldado(posicionUno,"Carlos");
        Unidad soldadoDos = new Soldado(posicionDos,"Esteban");
        Unidad soldadoTres = new Soldado(posicionTres,"Carlos");


        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Unidad> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);
    }

    @Test (expected = ExcepcionUnidadesNoSonSoldados.class)
    public void testNoPuedoCrearBatallonConUnidadesQueNoSonSoldados() {

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Unidad soldadoUno = new Soldado(posicionUno,"Jugador1");
        Unidad soldadoDos = new Soldado(posicionDos,"Jugador1");
        Unidad jinete = new Jinete(posicionTres,"Jugador1");


        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Unidad> soldados = new ArrayList<>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(jinete);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);
    }




}
