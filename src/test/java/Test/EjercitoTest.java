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


    @Test (expected = ExcepcionCantidadInsuficienteDePosiciones.class)
    public void testNoLeMandoSuficientesPosicionesParaBatallon() {

        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 3);

        Soldado soldadoUno = new Soldado(posicionUno, "Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos, "Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador 1");

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);

        unEjercito.crearBatallon(posiciones);
    }

    @Test
    public void testCreaBatallonConTresPosicionesAunqueLeMandeMas() {

        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 3);
        Posicion posicionCuatro = new Posicion(6, 6);

        Soldado soldadoUno = new Soldado(posicionUno, "Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos, "Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador 1");
        Soldado soldadoCuatro = new Soldado(posicionCuatro,"Jugador 1");

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);
        unEjercito.agregarUnidad(soldadoCuatro);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);
        posiciones.add(posicionCuatro);

        Batallon batallon = unEjercito.crearBatallon(posiciones);
        Assert.assertEquals(batallon.getCantidadSoldados(),3);
    }



    @Test (expected = ExcepcionLasUnidadesEstanSeparadas.class)
    public void testNoCreoBatallonSiPosicionesNoEstanContiguas() {

        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 4);

        Soldado soldadoUno = new Soldado(posicionUno, "Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos, "Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres, "Jugador1");

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        unEjercito.crearBatallon(posiciones);
    }

    @Test (expected = ExcepcionPosicionInvalida.class)
    public void testLeMandoUnaPosicionQueNoTieneSoldado(){
        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 3);
        Posicion posicionSinSoldado = new Posicion(2, 3);

        Soldado soldadoUno = new Soldado(posicionUno, "Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos, "Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador 1");

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionSinSoldado);

        unEjercito.crearBatallon(posiciones);
    }

    @Test
    public void testCreoUnBatallonExitosamente(){
        Ejercito unEjercito = new Ejercito();

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 3);

        Soldado soldadoUno = new Soldado(posicionUno, "Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos, "Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador 1");

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        unEjercito.crearBatallon(posiciones);
    }

    @Test
    public void testMuevoCorrectamenteLosSoldadosDeBatallon(){

        Ejercito unEjercito = new Ejercito();

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Soldado soldadoUno = new Soldado(posicionUno,"Jugador1");
        Soldado soldadoDos = new Soldado(posicionDos,"Jugador1");
        Soldado soldadoTres = new Soldado(posicionTres,"Jugador1");

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        unEjercito.agregarUnidad(soldadoUno);
        unEjercito.agregarUnidad(soldadoDos);
        unEjercito.agregarUnidad(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= unEjercito.crearBatallon(posiciones);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


}
