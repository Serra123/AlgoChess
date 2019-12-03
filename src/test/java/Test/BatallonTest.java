package Test;

import Excepciones.*;
import Jugador.Ejercito;
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
        Ejercito unEjercito = new Ejercito("Jugador1");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionCentral = new Posicion(1,2);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionCentral);
    }


    @Test
    public void testMuevoCorrectamenteLosSoldados(){

        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testMuevoCorrectamenteLosSoldadosEnHorizontal(){

        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(9,13);
        Posicion posicionDos = new Posicion(9,14);
        Posicion posicionTres = new Posicion(9,15);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(10,13);
        Posicion nuevaPosicionDos = new Posicion(10,14);
        Posicion nuevaPosicionTres = new Posicion(10,15);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testUnSoldadoNoSeMuevePeroLosOtrosSi(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCatapulta = new Posicion(1,1);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);
        Unidad catapulpa = new Catapulta(posicionCatapulta,unEjercito);

        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);
        unTablero.colocarUnidad(catapulpa);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean noMovioSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(posicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( noMovioSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testMuevoCorrectamenteLosSoldadosConPosicionesDistintasYSuperposicionEnElMedio(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,2);
        Posicion posicionTres = new Posicion(3,1);
        Posicion posicionCatapulta = new Posicion(2,1);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Unidad catapulta = new Catapulta(posicionCatapulta,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(1,0);
        Posicion nuevaPosicionDos = new Posicion(2,1);
        Posicion nuevaPosicionTres = new Posicion(3,0);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);
        unTablero.colocarUnidad(catapulta);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean noMovioSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(posicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );
        Assert.assertTrue( movioBienSoldadoUno && noMovioSoldadoDos && movioBienSoldadoTres);
    }

    @Test
    public void testSoldadosAlineadosNoSeSuperponenEntreSiAlMoverse(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(1,1);
        Posicion posicionDos = new Posicion(2,1);
        Posicion posicionTres = new Posicion(3,1);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(2,1);
        Posicion nuevaPosicionDos = new Posicion(3,1);
        Posicion nuevaPosicionTres = new Posicion(4,1);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }
    @Test
    public void testSoldadosEnDiagonalNoSeSuperponenEntreSiAlMoverse(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(2,2);
        Posicion posicionDos = new Posicion(1,1);
        Posicion posicionTres = new Posicion(0,0);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(3,3);
        Posicion nuevaPosicionDos = new Posicion(2,2);
        Posicion nuevaPosicionTres = new Posicion(1,1);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );

        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres);
    }

    @Test (expected = ExcepcionMovimientoInvalido.class)
    public void testNoPuedoMovermeMasDeUnCasilleroDeDistancia() {

        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20, 20, "Jugador1", "Jugador2");

        Posicion posicionUno = new Posicion(2, 2);
        Posicion posicionDos = new Posicion(1, 1);
        Posicion posicionTres = new Posicion(0, 0);

        Soldado soldadoUno = new Soldado(posicionUno, unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos, unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres, unEjercito);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);

        Posicion posicionCentralNueva = new Posicion(3, 3);

        batallon.moverBatallon(posicionCentralNueva);
    }


    @Test
    public void testBatallonSoloTieneTresSoldadosAunqueLeMandeMas() {
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCuatro = new Posicion(0,4);

        Soldado soldadoUno = new Soldado(posicionUno,unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);
        Soldado soldadoCuatro = new Soldado(posicionCuatro,unEjercito);

        Posicion nuevaPosicionUno = new Posicion(1,1);
        Posicion nuevaPosicionDos = new Posicion(1,2);
        Posicion nuevaPosicionTres = new Posicion(1,3);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);
        soldados.add(soldadoCuatro);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);
        unTablero.colocarUnidad(soldadoCuatro);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean movioBienSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(nuevaPosicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean movioBienSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(nuevaPosicionTres)) == 0 );
        boolean noMovioSoldadoCuatro = ((soldadoCuatro.getPosicion().calcularDistancia(posicionCuatro)) == 0 );
        Assert.assertTrue( movioBienSoldadoUno && movioBienSoldadoDos && movioBienSoldadoTres && noMovioSoldadoCuatro);

    }


    @Test
    public void testSoldadosNoExcedenLimiteDeTablero(){

        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion posicionUno = new Posicion(0,0);
        Posicion posicionDos = new Posicion(1,1);
        Posicion posicionTres = new Posicion(2,0);

        Soldado soldadoUno = new Soldado(posicionUno, unEjercito);
        Soldado soldadoDos = new Soldado(posicionDos,unEjercito);
        Soldado soldadoTres = new Soldado(posicionTres,unEjercito);

        Posicion nuevaPosicionDos = new Posicion(1,0);

        ArrayList<Soldado> soldados = new ArrayList<>();

        soldados.add(soldadoUno);
        soldados.add(soldadoDos);
        soldados.add(soldadoTres);

        unTablero.colocarUnidad(soldadoUno);
        unTablero.colocarUnidad(soldadoDos);
        unTablero.colocarUnidad(soldadoTres);

        Batallon batallon= new Batallon(soldados);
        batallon.agregarTablero(unTablero);
        batallon.moverBatallon(nuevaPosicionDos);    //La posicion central del batallon es la dos,asique muevo esta

        boolean noMovioSoldadoUno = ((soldadoUno.getPosicion().calcularDistancia(posicionUno)) == 0 );
        boolean movioBienSoldadoDos = ((soldadoDos.getPosicion().calcularDistancia(nuevaPosicionDos)) == 0 );
        boolean noMovioSoldadoTres = ((soldadoTres.getPosicion().calcularDistancia(posicionTres)) == 0 );

        Assert.assertTrue( noMovioSoldadoUno && movioBienSoldadoDos && noMovioSoldadoTres);
    }



}
