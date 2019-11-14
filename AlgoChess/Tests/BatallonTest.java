package Tests;

import Jugador.Ejercito;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    public void testMuevoCorrectamenteLosSoldado(){

        Ejercito ejercito = new Ejercito("Jugador1");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Soldado soldadoUno = new Soldado(posicionUno,"Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos,"Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionCentral = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<Soldado> soldados = new ArrayList<Soldado>();
        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        ejercito.moverBatallon(soldados,nuevaPosicionCentral);

        boolean mismaFilaUno = nuevaPosicionUno.getFila()==soldadoUno.getPosicion().getFila();
        boolean mismaColumnaUno = nuevaPosicionUno.getColumna()==soldadoUno.getPosicion().getColumna();

        boolean mismaFilaDos = nuevaPosicionCentral.getFila()==soldadoDos.getPosicion().getFila();
        boolean mismaColumnaDos = nuevaPosicionCentral.getColumna()==soldadoDos.getPosicion().getColumna();

        boolean mismaFilaTres = nuevaPosicionTres.getFila()==soldadoTres.getPosicion().getFila();
        boolean mismaColumnaTres = nuevaPosicionTres.getColumna()==soldadoTres.getPosicion().getColumna();


        boolean movioBienSoldadoUno =  (mismaFilaUno && mismaColumnaUno);
        boolean movioBienSoldadoDos =  (mismaFilaDos && mismaColumnaDos);
        boolean movioBienSoldadoTres =  (mismaFilaTres && mismaColumnaTres);
        // por alguna razon no anda el tercer soldado
        Assert.assertTrue( movioBienSoldadoTres);
        //Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

}
