package Tests;

import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Tablero.Tablero;
import Unidades.Catapulta;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

    @Test
    public void testCatapultaAtacaSoldadoEnemigoCorrectamente() {
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(6,6);

        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Catapulta unaCatapulta = new Catapulta(unaPosicion, "Jugador1");
        Soldado enemigo = new Soldado(otraPosicion, "Jugador2");

        unTablero.colocarUnidad(unaCatapulta);
        unTablero.colocarUnidad(enemigo);
        unaCatapulta.atacar(enemigo,unTablero);

        Assert.assertEquals(80, enemigo.getVida());
    }

    @Test
    public void testCatapultaAtacaSoldadoEnemigoContiguoCorrectamente() {
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(6,6);
        Posicion otraPosicion2 = new Posicion(7,7);

        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Catapulta unaCatapulta = new Catapulta(unaPosicion, "Jugador1");
        Soldado enemigo = new Soldado(otraPosicion, "Jugador2");
        Soldado enemigo2 = new Soldado(otraPosicion2,"Jugador2");

        unTablero.colocarUnidad(unaCatapulta);
        unTablero.colocarUnidad(enemigo);
        unTablero.colocarUnidad(enemigo2);
        unaCatapulta.atacar(enemigo,unTablero);


        Assert.assertEquals(80, enemigo2.getVida());
    }

    @Test
    public void testCatapultaAtacaSoldadosEnemigosContiguosCorrectamente() {
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(6,6);
        Posicion otraPosicion2 = new Posicion(7,7);
        Posicion otraPosicion3 = new Posicion(8,8);


        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Catapulta unaCatapulta = new Catapulta(unaPosicion, "Jugador1");
        Soldado enemigo = new Soldado(otraPosicion, "Jugador2");
        Soldado enemigo2 = new Soldado(otraPosicion2,"Jugador2");
        Soldado enemigo3 = new Soldado(otraPosicion3,"Jugador2");

        unTablero.colocarUnidad(unaCatapulta);
        unTablero.colocarUnidad(enemigo);
        unTablero.colocarUnidad(enemigo2);
        unTablero.colocarUnidad(enemigo3);
        unaCatapulta.atacar(enemigo,unTablero);


        Assert.assertEquals(80, enemigo3.getVida());
    }



    @Test
    public void testCatapultaAtacaSoldadoAliadoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(0,9);
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");

        Catapulta unaCatapulta = new Catapulta(unaPosicion,"Jugador1");
        Soldado aliado = new Soldado(otraPosicion,"Jugador1");
        unTablero.colocarUnidad(aliado);
        unaCatapulta.atacar(aliado,unTablero);

        Assert.assertEquals(80, aliado.getVida());
    }

    @Test(expected = ExcepcionDistanciaAtaqueInvalida.class)
    public void testCatapultaNoPuedeAtacarADistanciaCorta(){
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(10,0);
        Tablero unTablero = new Tablero(20,20,"Jugador1","Jugador2");
        Catapulta unaCatapulta = new Catapulta(unaPosicion,"Jugador1");
        Soldado unSoldado = new Soldado(otraPosicion,"Jugador1");
        unTablero.colocarUnidad(unaCatapulta);
        unaCatapulta.atacar(unSoldado,unTablero);
    }
}
