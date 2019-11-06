package Unidades;

import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;
import Tablero.*;

public class UnidadMovibleTest {
    @Test
    public void testUnidadMovibleSeMueveAbajo() throws ExcepcionCasilleroOcupado {
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(1,unaPosicion.getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveArriba()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(0,unaPosicion.getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveIzquierda()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveDerecha()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(1,unaPosicion.getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveArribaIzquierda()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(0,unaPosicion.getFila());
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveArribaDerecha()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(0,unaPosicion.getFila());
        Assert.assertEquals(1,unaPosicion.getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoIzquierda()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(1,unaPosicion.getFila());
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoDerecha()throws ExcepcionCasilleroOcupado{
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(otraPosicion,"Jugador1");
        unaUnidadMovible.mover(unaPosicion,unTablero);
        Assert.assertEquals(1,unaPosicion.getFila());
        Assert.assertEquals(1,unaPosicion.getColumna());
    }
    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testUnidadMovibleNosePuedeMoverACasilleroOcupado() throws ExcepcionSectorEnemigo, ExcepcionCasilleroOcupado {
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible soldado = new Soldado(unaPosicion,"Jugador1");
        UnidadMovible otroSoldado = new Soldado(otraPosicion,"Jugador1");
        try {
            unTablero.colocarUnidad(soldado);
            unTablero.colocarUnidad(otroSoldado);
        }catch(ExcepcionCasilleroOcupado e){
            Assert.fail();
        }
        soldado.mover(otraPosicion,unTablero);




    }


}
