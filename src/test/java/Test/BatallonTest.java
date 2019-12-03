package Test;

import Excepciones.*;
import Jugador.Ejercito;
import Jugador.Jugador;
import Modelo.Batallon;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BatallonTest {

    @Test
    public void testPuedoCrearBatallon(){
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Jugador jugador = new Jugador("Jugador1");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionCentral);
    }


    @Test
    public void testMuevoCorrectamenteLosSoldados(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Jugador jugador = new Jugador("Jugador1");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionCentral);

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);


        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


    @Test
    public void testMuevoCorrectamenteLosSoldadosEnHorizontal(){

        Posicion posicionUno = new Posicion(9,13);
        Posicion posicionDos = new Posicion(9,14);
        Posicion posicionTres = new Posicion(9,15);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Jugador jugador = new Jugador("Jugador1");

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Posicion nuevaPosicionUno = new Posicion(10,13);
        Posicion nuevaPosicionDos = new Posicion(10,14);
        Posicion nuevaPosicionTres = new Posicion(10,15);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


    @Test
    public void testUnSoldadoNoSeMuevePeroLosOtrosSi(){

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCatapulta = new Posicion(1,1);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Jugador jugador = new Jugador("Jugador1");

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionCatapulta,"Catapulta",unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean noMovioSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(posicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( noMovioSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


    @Test
    public void testMuevoCorrectamenteLosSoldadosConPosicionesDistintasYSuperposicionEnElMedio() {

        Posicion posicionUno = new Posicion(1, 1);
        Posicion posicionDos = new Posicion(2, 2);
        Posicion posicionTres = new Posicion(3, 1);
        Posicion posicionCatapulta = new Posicion(2, 1);

        Tablero unTablero = new Tablero(20, 20, "Jugador1", "Jugador2");

        Jugador jugador = new Jugador("Jugador1");

        jugador.crearUnidadEnPosicion(posicionUno, "Soldado", unTablero);
        jugador.crearUnidadEnPosicion(posicionDos, "Soldado", unTablero);
        jugador.crearUnidadEnPosicion(posicionTres, "Soldado", unTablero);
        jugador.crearUnidadEnPosicion(posicionCatapulta, "Catapulta", unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        Posicion nuevaPosicionUno = new Posicion(1, 0);
        Posicion nuevaPosicionDos = new Posicion(2, 1);
        Posicion nuevaPosicionTres = new Posicion(3, 0);


        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);


        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean noMovioSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(posicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );
        Assert.assertTrue( movioBienSoldadoUno && noMovioSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testSoldadosAlineadosNoSeSuperponenEntreSiAlMoverse(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Jugador jugador = new Jugador("Jugador1");

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,1);
        Posicion posicionTres = new Posicion(3,1);

        Posicion nuevaPosicionUno = new Posicion(2,1);
        Posicion nuevaPosicionDos = new Posicion(3,1);
        Posicion nuevaPosicionTres = new Posicion(4,1);

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


    @Test
    public void testSoldadosEnDiagonalNoSeSuperponenEntreSiAlMoverse(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Jugador jugador = new Jugador("Jugador1");

        Posicion posicionUno = new Posicion(2,2);
        Posicion posicionDos = new Posicion(1,1);
        Posicion posicionTres = new Posicion(0,0);


        Posicion nuevaPosicionUno = new Posicion(3,3);
        Posicion nuevaPosicionDos = new Posicion(2,2);
        Posicion nuevaPosicionTres = new Posicion(1,1);

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);


        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }


    @Test (expected = ExcepcionMovimientoInvalido.class)
    public void testNoPuedoMovermeMasDeUnCasilleroDeDistancia() {

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(0, 0);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Jugador jugador = new Jugador("Jugador1");

        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        Posicion posicionCentralNueva = new Posicion(3, 3);
        batallon.moverBatallon(posicionCentralNueva);
    }

    @Test (expected = ExcepcionCantidadIncorrectaDePosiciones.class)
    public void testBatallonNoSeCreaSiLeMandoMasDeTresPosiciones() {
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCuatro = new Posicion(0,4);

        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionCuatro,"Soldado",unTablero);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);
        posiciones.add(posicionCuatro);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
    }

    @Test (expected = ExcepcionCantidadIncorrectaDePosiciones.class)
    public void testBatallonNoSeCreaSiLeMandoMenosDeTresPosiciones() {
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCuatro = new Posicion(0,4);

        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionCuatro,"Soldado",unTablero);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
    }

    @Test
    public void testBatallonSeCreaSiLeMandoPosicionesRepetidas() {
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCuatro = new Posicion(0,4);

        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionCuatro,"Soldado",unTablero);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);
        posiciones.add(posicionDos);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
    }

    @Test
    public void testSoldadosNoExcedenLimiteDeTablero(){

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,0);
        Posicion posicionDos = new Posicion(1,1);
        Posicion posicionTres = new Posicion(2,0);

        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);

        Unidad soldadoUno = unTablero.getUnidad(posicionUno);
        Unidad soldadoDos = unTablero.getUnidad(posicionDos);
        Unidad soldadoTres = unTablero.getUnidad(posicionTres);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon= new Batallon(posiciones,jugador,unTablero);
        batallon.moverBatallon(posicionUno);    //La posicion central del batallon es la dos,asique muevo esta

        boolean noMovioSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(posicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(posicionDos)) == 0 );
        boolean noMovioSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(posicionTres)) == 0 );

        Assert.assertTrue( noMovioSoldadoUno && movioBienSoldadoDos && noMovioSoldadoTres);
    }




    @Test (expected = ExcepcionLasUnidadesEstanSeparadas.class)
    public void testNoCreoBatallonSiPosicionesNoEstanContiguas() {

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 4);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);

        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionTres);

        Batallon batallon = new Batallon(posiciones,jugador,unTablero);
    }

    @Test (expected = ExcepcionCasilleroVacio.class)
    public void testLeMandoUnaPosicionQueNoTieneSoldado(){

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(3, 3);
        Posicion posicionSinSoldado = new Posicion(2, 3);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Jugador jugador = new Jugador("Jugador1");


        jugador.crearUnidadEnPosicion(posicionUno,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionDos,"Soldado",unTablero);
        jugador.crearUnidadEnPosicion(posicionTres,"Soldado",unTablero);


        ArrayList<Posicion> posiciones = new ArrayList<>();

        posiciones.add(posicionUno);
        posiciones.add(posicionDos);
        posiciones.add(posicionSinSoldado);

        Batallon batallon = new Batallon(posiciones,jugador,unTablero);
    }



}
