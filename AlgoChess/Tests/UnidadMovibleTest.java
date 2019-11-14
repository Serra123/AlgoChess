package Tests;

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
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(2,0);
        Posicion otraPosicion = new Posicion(3,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertEquals(3,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveArriba(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(9,0);
        Posicion otraPosicion = new Posicion(8,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertEquals(8,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveIzquierda(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(4,4);
        Posicion otraPosicion = new Posicion(4,3);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertEquals(3,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveDerecha(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(4,4);
        Posicion otraPosicion = new Posicion(4,5);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertEquals(5,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveArribaIzquierda(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(3, 3);
        Posicion otraPosicion = new Posicion(2, 2);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion, "Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertTrue(2 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (2 == ((unaUnidadMovible.getPosicion()).getFila())));
    }
    @Test
    public void testUnidadMovibleSeMueveArribaDerecha(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(6,0);
        Posicion otraPosicion = new Posicion(5,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);

        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
        (5 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoIzquierda(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(6,1);
        Posicion otraPosicion = new Posicion(7,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertTrue(0 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (7 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoDerecha() throws ExcepcionCasilleroOcupado, ExcepcionSectorEnemigo {
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,"Jugador1");
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion);
        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (1 == ((unaUnidadMovible.getPosicion()).getFila())));
    }



    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testUnidadMovibleNosePuedeMoverACasilleroOcupado() throws ExcepcionSectorEnemigo, ExcepcionCasilleroOcupado {
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible soldado = new Soldado(unaPosicion,"Jugador1");
        UnidadMovible otroSoldado = new Soldado(otraPosicion,"Jugador1");
        unTablero.colocarUnidad(soldado);
        unTablero.colocarUnidad(otroSoldado);
        soldado.mover(otraPosicion);

    }


}
