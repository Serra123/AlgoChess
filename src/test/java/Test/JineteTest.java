package Test;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Excepciones.ExcepcionFinDelTablero;
import Tablero.Tablero;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test (expected = ExcepcionAtaqueAAliado.class)
    public void testJineteAtacaAJineteAliadoYSaltaExcepcion() {
        Tablero unTablero = new Tablero(20, 20, "Fede", "Juan");
        Posicion unaPosicion = new Posicion(5,5);
        Posicion otraPosicion = new Posicion(6,5);
        Jinete unJinete = new Jinete(unaPosicion, "Fede");
        Jinete otroJinete = new Jinete(otraPosicion, "Fede");
        unTablero.colocarUnidad(unJinete);
        unTablero.colocarUnidad(otroJinete);
        unJinete.atacar(otroJinete, unTablero);
    }

    @Test
    public void testJineteTieneSoldadoCercaAtacaConArcoYFlecha(){
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionSoldadoAliado = new Posicion(9,4);
        Posicion posicionEnemigo = new Posicion(12,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "Fede");
        Soldado soldadoAliado = new Soldado(posicionSoldadoAliado, "Fede");
        Jinete enemigo = new Jinete(posicionEnemigo, "Juan");

        Tablero unTablero = new Tablero(20,20,"Fede","Juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85,0);
    }

    @Test
    public void testJineteNoTieneEnemigosCercaAtacaConArcoYFlecha(){
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(12,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "fede");
        Jinete enemigo = new Jinete(posicionEnemigo, "juan");

        Tablero unTablero = new Tablero(20,20,"fede","juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85,0);
    }

    @Test
    public void testJineteTieneEnemigosCercaAtacaConEspada(){
        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "Jugador1");
        Jinete enemigo = new Jinete(posicionEnemigo, "Jugador2");

        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);
    }

    @Test
    public void testJineteNoTieneAliadosCercaPeroSiTieneEnemigoCercaAtacaConEspada(){
        Posicion posicionAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete aliado = new Jinete(posicionAliado,"Pedro");
        Jinete enemigo = new Jinete(posicionEnemigo, "Andy");

        Tablero unTablero = new Tablero(20,20,"Pedro","Andy");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        aliado.atacar(enemigo, unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);

    }

    @Test (expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testJineteSinAliadosCercaConUnEnemigoCercaYOtroNoQuiereAtacarAlSegundoYNoPuede(){
        Posicion posicionAliado = new Posicion(9,5);
        Posicion posicionEnemigoCercano = new Posicion(10,5);
        Posicion posicionEnemigoLejano = new Posicion(15,5);

        Jinete aliado = new Jinete(posicionAliado,"Raul");
        Jinete enemigoCercano = new Jinete(posicionEnemigoCercano, "Lucas");
        Jinete enemigoLejano = new Jinete(posicionEnemigoLejano, "Lucas");


        Tablero unTablero = new Tablero(20,20,"Raul","Lucas");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigoCercano);
        unTablero.colocarUnidad(enemigoLejano);

        aliado.atacar(enemigoLejano, unTablero);
    }

    @Test
    public void testJineteEnBordeDeTableroAtacaEnemigoCorrectamente(){
        Posicion posicionAliado = new Posicion(9,0);
        Posicion posicionEnemigo = new Posicion(10,0);

        Jinete aliado = new Jinete(posicionAliado,"Pedro");
        Jinete enemigo = new Jinete(posicionEnemigo,"Carlos");

        Tablero unTablero = new Tablero(20,20,"Pedro","Carlos");
        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        aliado.atacar(enemigo,unTablero);

        Assert.assertEquals(95,enemigo.getVida(),0);
    }

    @Test
    public void testJineteAtacaASoldadoEnemigoQueNoSeEncuentraEnSuSector(){
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Posicion nuevaPosicionEnemigo = new Posicion(9,1);

        Jinete aliado = new Jinete(unaPosicion,"Jugador1");
        Soldado enemigo = new Soldado(otraPosicion,"Jugador2");

        unTablero.colocarUnidad(aliado);
        unTablero.colocarUnidad(enemigo);

        enemigo.mover(nuevaPosicionEnemigo,unTablero);

        aliado.atacar(enemigo, unTablero);

        Assert.assertEquals(94.75, (enemigo.getVida()), 0.0);

    }

}
