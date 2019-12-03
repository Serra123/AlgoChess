package Test;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Ejercito;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.UnidadMovible;
import org.junit.Assert;
import org.junit.Test;
import Tablero.*;

public class UnidadMovibleTest {
    @Test
    public void testUnidadMovibleSeMueveAbajo(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(1,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveArriba(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(0,(unaUnidadMovible.getPosicion()).getFila());
    }

    @Test
    public void testUnidadMovibleSeMueveIzquierda(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(0,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveDerecha(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertEquals(1,(unaUnidadMovible.getPosicion()).getColumna());
    }

    @Test
    public void testUnidadMovibleSeMueveArribaIzquierda(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10, 10, "Jugador1", "Jugador2");
        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(0, 0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion, unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion, unTablero);
        Assert.assertTrue(0 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (0 == ((unaUnidadMovible.getPosicion()).getFila())));
    }
    @Test
    public void testUnidadMovibleSeMueveArribaDerecha(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);

        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
        (0 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoIzquierda(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertTrue(0 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (1 == ((unaUnidadMovible.getPosicion()).getFila())));
    }

    @Test
    public void testUnidadMovibleSeMueveAbajoDerecha(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new Soldado(unaPosicion,unEjercito);
        unTablero.colocarUnidad(unaUnidadMovible);
        unaUnidadMovible.mover(otraPosicion,unTablero);
        Assert.assertTrue(1 == ((unaUnidadMovible.getPosicion()).getColumna()) &&
                (1 == ((unaUnidadMovible.getPosicion()).getFila())));
    }



    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testUnidadMovibleNosePuedeMoverACasilleroOcupado(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero unTablero = new Tablero(10,10,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Posicion otraPosicion = new Posicion(1,1);
        UnidadMovible soldado = new Soldado(unaPosicion,unEjercito);
        UnidadMovible otroSoldado = new Soldado(otraPosicion,unEjercito);
        unTablero.colocarUnidad(soldado);
        unTablero.colocarUnidad(otroSoldado);

        soldado.mover(otraPosicion,unTablero);

    }


}
