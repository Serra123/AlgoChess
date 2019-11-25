package Test;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.UnidadMovible;
import org.junit.Assert;
import org.junit.Test;
import Tablero.*;

public class UnidadMovibleTest {
    @Test
    public void testUnidadMovibleSeMueveAbajo(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(1,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveArriba(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(0,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveIzquierda(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(0,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveDerecha(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(1,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveArribaIzquierda(){
        Tablero unTablero = new Tablero(10, 10, "Jugador1", "Jugador2");
        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(0, 0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion, "Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion, unTablero);
        Assert.assertTrue(0 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (0 == ((unaUnidadMovible.getPosicion()).getFila())));
    }
    @Test
    public void testUnidadMovibleSeMueveArribaDerecha(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);

        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
        (0 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoIzquierda(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertTrue(0 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (1 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoDerecha(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (1 == ((unaUnidadMovible.getPosicion()).getFila())));
    }



    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testUnidadMovibleNosePuedeMoverACasilleroOcupado(){
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible soldado = new Soldado(unaPosicion,"Jugador1");
        UnidadMovible otroSoldado = new Soldado(otraPosicion,"Jugador1");
        unTablero.colocarUnidad(soldado);
        unTablero.colocarUnidad(otroSoldado);

        soldado.mover(otraPosicion,unTablero);

    }


}
