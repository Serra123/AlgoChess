package Test;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testSoldadoQuiereAtacarADistanciaLejanaYNoPuede(){
        Ejercito unEjercito = new Ejercito("juan");
        Ejercito otroEjercito = new Ejercito("fede");
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(17,0);
        Soldado unSoldado = new Soldado(unaPosicion, unEjercito);
        Soldado enemigo = new Soldado(otraPosicion, otroEjercito);
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);
    }

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testSoldadoQuiereAtacarADistanciaMediaYNoPuede(){
        Ejercito unEjercito = new Ejercito("juan");
        Ejercito otroEjercito = new Ejercito("fede");
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(13,0);
        Soldado unSoldado = new Soldado(unaPosicion, unEjercito);
        Soldado enemigo = new Soldado(otraPosicion, otroEjercito);
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);
    }

    @Test
    public void testSoldadoAtacaASoldadoEnemigoCorrectamente() {
        Ejercito unEjercito = new Ejercito("juan");
        Ejercito otroEjercito = new Ejercito("fede");
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Soldado unSoldado = new Soldado(unaPosicion, unEjercito);
        Soldado enemigo = new Soldado(otraPosicion, otroEjercito);
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);

        Assert.assertEquals(90, enemigo.getVida(),0);
    }

    @Test
    public void testSoldadoAtacaASoldadoAliadoYSaltaExcepcion() {
        Ejercito unEjercito = new Ejercito("juan");
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(5, 0);
        Soldado unSoldado = new Soldado(unaPosicion, unEjercito);
        Soldado otroSoldado = new Soldado(otraPosicion, unEjercito);
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(otroSoldado);
        try {
            unSoldado.atacar(otroSoldado, unTablero);
        }catch (ExcepcionAtaqueAAliado e) {
            //Aquí no se debería de manejar esta excepción.
        }
        Assert.assertEquals(otroSoldado.getVida(), 100,0);
    }

    @Test
    public void testSoldadoAtacaASoldadoEnemigoQueNoSeEncuentraEnSuSector(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Ejercito otroEjercito = new Ejercito("Jugador2");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Posicion nuevaPosicionEnemigo = new Posicion(9,1);

        Soldado aliado = new Soldado(unaPosicion,unEjercito);
        Soldado enemigo = new Soldado(otraPosicion,otroEjercito);

        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        enemigo.mover(nuevaPosicionEnemigo,unTablero);

        aliado.atacar(enemigo,unTablero);

        Assert.assertEquals(89.5, (enemigo.getVida()), 0.0);

    }

}
