package Test;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test (expected = ExcepcionAtaqueAAliado.class)
    public void testJineteAtacaAJineteAliadoYSaltaExcepcion() {
        Ejercito unEjercito = new Ejercito("Fede");
        Tablero unTablero = new Tablero(20, 20, "Fede", "Juan");
        Posicion unaPosicion = new Posicion(5,5);
        Posicion otraPosicion = new Posicion(6,5);
        Jinete unJinete = new Jinete(unaPosicion, unEjercito);
        Jinete otroJinete = new Jinete(otraPosicion, unEjercito);
        unTablero.colocarUnidad(unJinete);
        unTablero.colocarUnidad(otroJinete);
        unJinete.atacar(otroJinete, unTablero);
    }

    @Test
    public void testJineteTieneSoldadoCercaAtacaConArcoYFlecha(){
        Ejercito unEjercito = new Ejercito("Fede");
        Ejercito otroEjercito = new Ejercito("Juan");
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionSoldadoAliado = new Posicion(9,4);
        Posicion posicionEnemigo = new Posicion(12,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, unEjercito);
        Soldado soldadoAliado = new Soldado(posicionSoldadoAliado, unEjercito);
        Jinete enemigo = new Jinete(posicionEnemigo, otroEjercito);

        Tablero unTablero = new Tablero(20,20,"Fede","Juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85,0);
    }

    @Test
    public void testJineteNoTieneEnemigosCercaAtacaConArcoYFlecha(){
        Ejercito unEjercito = new Ejercito("fede");
        Ejercito otroEjercito = new Ejercito("juan");
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(12,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, unEjercito);
        Jinete enemigo = new Jinete(posicionEnemigo, otroEjercito);

        Tablero unTablero = new Tablero(20,20,"fede","juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85,0);
    }

    @Test
    public void testJineteTieneEnemigosCercaAtacaConEspada(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Ejercito otroEjercito = new Ejercito("Jugador2");
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, unEjercito);
        Jinete enemigo = new Jinete(posicionEnemigo, otroEjercito);

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);
    }

    @Test
    public void testJineteNoTieneAliadosCercaPeroSiTieneEnemigoCercaAtacaConEspada(){
        Ejercito unEjercito = new Ejercito("Pedro");
        Ejercito otroEjercito = new Ejercito("Andy");
        Posicion posicionAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete aliado = new Jinete(posicionAliado,unEjercito);
        Jinete enemigo = new Jinete(posicionEnemigo, otroEjercito);

        Tablero unTablero = new Tablero(20,20,"Pedro","Andy");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        aliado.atacar(enemigo, unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);

    }

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testJineteSinAliadosCercaConUnEnemigoCercaYOtroNoQuiereAtacarAlSegundoYNoPuede(){
        Ejercito unEjercito = new Ejercito("Raul");
        Ejercito otroEjercito = new Ejercito("Lucas");
        Posicion posicionAliado = new Posicion(9,5);
        Posicion posicionEnemigoCercano = new Posicion(10,5);
        Posicion posicionEnemigoLejano = new Posicion(15,5);

        Jinete aliado = new Jinete(posicionAliado,unEjercito);
        Jinete enemigoCercano = new Jinete(posicionEnemigoCercano, otroEjercito);
        Jinete enemigoLejano = new Jinete(posicionEnemigoLejano, otroEjercito);


        Tablero unTablero = new Tablero(20,20,"Raul","Lucas");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigoCercano);
        unTablero.colocarUnidad(enemigoLejano);

        aliado.atacar(enemigoLejano, unTablero);
    }

    @Test
    public void testJineteEnBordeDeTableroAtacaEnemigoCorrectamente(){
        Ejercito unEjercito = new Ejercito("Pedro");
        Ejercito otroEjercito = new Ejercito("Carlos");
        Posicion posicionAliado = new Posicion(9,0);
        Posicion posicionEnemigo = new Posicion(10,0);

        Jinete aliado = new Jinete(posicionAliado,unEjercito);
        Jinete enemigo = new Jinete(posicionEnemigo,otroEjercito);

        Tablero unTablero = new Tablero(20,20,"Pedro","Carlos");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        aliado.atacar(enemigo,unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);
    }

    @Test
    public void testJineteAtacaASoldadoEnemigoQueNoSeEncuentraEnSuSector(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Ejercito otroEjercito = new Ejercito("Jugador2");
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Posicion nuevaPosicionEnemigo = new Posicion(9,1);

        Jinete aliado = new Jinete(unaPosicion,unEjercito);
        Soldado enemigo = new Soldado(otraPosicion,otroEjercito);

        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        enemigo.mover(nuevaPosicionEnemigo,unTablero);

        aliado.atacar(enemigo, unTablero);

        Assert.assertEquals(94.75, (enemigo.getVida()), 0.0);

    }

}
