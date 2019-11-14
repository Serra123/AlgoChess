package Tests;

import Excepciones.ExcepcionNoSePuedeCrearBatallon;
import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EjercitoTest {

    @Test
    public void testPuedoCrearBatallonConSoldadosCercanos(){

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Soldado soldadoUno = new Soldado(posicionUno,"Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos,"Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Soldado> soldados = new ArrayList<Soldado>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }


    @Test (expected = ExcepcionNoSePuedeCrearBatallon.class)
    public void testNoPuedoCrearBatallonConSoldadosLejanos() {

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,4);
        Soldado soldadoUno = new Soldado(posicionUno,"Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos,"Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Soldado> soldados = new ArrayList<Soldado>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);

        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }


}
