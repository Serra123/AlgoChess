package Tests;

import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BatallonTest {
    @Test
    public void testMuevoCorrectamenteLosSoldados(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon = new Batallon(soldados,unTablero);
        batallon.moverCentroA(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testMuevoCorrectamenteLosSoldadosConPosicionesDistintasYSuperposicionEnElMedio(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,2);
        Posicion posicionTres = new Posicion(3,1);

        Posicion posicionCatapulta = new Posicion(2,1);


        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Jugador1");

        Unidad catapulpa = new Catapulta(posicionCatapulta,"Jugador1");

        Posicion nuevaPosicionUno = new Posicion(1,0);
        Posicion nuevaPosicionDos = new Posicion(2,1);
        Posicion nuevaPosicionTres = new Posicion(3,0);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);
        unTablero.colocarUnidad(catapulpa);

        Batallon batallon = new Batallon(soldados,unTablero);
        batallon.moverCentroA(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean noMovioSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(posicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && noMovioSoldadoDos && movioBienSoldadoTres);
    }


    @Test
    public void testUnSoldadoNoSeMueveSiColisionaConOtroPeroLosOtrosSi(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCatapulta = new Posicion(1,1);


        UnidadMovible soldadoUno = new Soldado(posicionUno,"Jugador1");
        UnidadMovible soldadoDos = new Soldado(posicionDos,"Jugador1");
        UnidadMovible soldadoTres = new Soldado(posicionTres,"Jugador1");

        Unidad catapulpa = new Catapulta(posicionCatapulta,"Jugador1");

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<UnidadMovible> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);
        unTablero.colocarUnidad(catapulpa);

        Batallon batallon = new Batallon(soldados,unTablero);
        batallon.moverCentroA(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean noMovioSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(posicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( noMovioSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


}
