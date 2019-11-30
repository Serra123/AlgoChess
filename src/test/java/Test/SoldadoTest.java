package Test;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testSoldadoQuiereAtacarADistanciaLejanaYNoPuede(){
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(17,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(otraPosicion, "fede");
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);
    }

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testSoldadoQuiereAtacarADistanciaMediaYNoPuede(){
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(13,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(otraPosicion, "fede");
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);
    }

    @Test
    public void testSoldadoAtacaASoldadoEnemigoCorrectamente() {
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(otraPosicion, "fede");
        unTablero.colocarUnidad(unSoldado);
        unTablero.colocarUnidad(enemigo);

        unSoldado.atacar(enemigo, unTablero);

        Assert.assertEquals(90, enemigo.getVida(),0);
    }

    @Test
    public void testSoldadoAtacaASoldadoAliadoYSaltaExcepcion() {
        Tablero unTablero = new Tablero(20,20,"juan","fede");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(5, 0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado otroSoldado = new Soldado(otraPosicion, "juan");
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
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Posicion nuevaPosicionEnemigo = new Posicion(9,1);

        Soldado aliado = new Soldado(unaPosicion,"Jugador1");
        Soldado enemigo = new Soldado(otraPosicion,"Jugador2");

        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        enemigo.mover(nuevaPosicionEnemigo,unTablero);

        aliado.atacar(enemigo,unTablero);

        Assert.assertEquals(89.5, (enemigo.getVida()), 0.0);

    }

}
