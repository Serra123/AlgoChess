package Tests;

import Excepciones.ExcepcionAtaqueAAliado;
import Tablero.Tablero;
import Tablero.Fila;
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
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "Fede");
        Soldado soldadoAliado = new Soldado(posicionSoldadoAliado, "Fede");
        Jinete enemigo = new Jinete(posicionEnemigo, "Juan");

        Tablero unTablero = new Tablero(20,20,"Fede","Juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85);
    }

    @Test
    public void testJineteNoTieneEnemigosCercaAtacaConArcoYFlecha(){
        Posicion posicionJineteAliado = new Posicion(5,5);
        Posicion posicionEnemigo = new Posicion(18,4);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "fede");
        Jinete enemigo = new Jinete(posicionEnemigo, "juan");

        Tablero unTablero = new Tablero(20,20,"fede","juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),85);
    }

    @Test
    public void testJineteTieneEnemigosCercaAtacaConEspada(){
        Tablero unTablero = new Tablero(20,20,"Juan","Fede");

        Posicion posicionJineteAliado = new Posicion(9,5);
        Posicion posicionEnemigo = new Posicion(10,5);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "Juan");
        Jinete enemigo = new Jinete(posicionEnemigo, "Fede");

        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(enemigo);

        jineteAliado.atacar(enemigo, unTablero);

        Assert.assertEquals(enemigo.getVida(),95);
    }

}
