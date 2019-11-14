package Tests;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionSectorEnemigo;
import Tablero.*;
import Unidades.*;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    //Faltaria chequear la correcta inicializacion de el tablero!

    @Test
    public void testColocarPiezaAliadaEnSectorAliadoFunciona(){
        Tablero.setParametrosConsigna();
        Tablero tablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(0,1);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        tablero.colocarUnidad(unSoldado);
        Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test(expected = ExcepcionSectorEnemigo.class)
    public void testColocarPiezaAliadaEnSectorEnemigoNoFunciona() throws ExcepcionSectorEnemigo, ExcepcionCasilleroOcupado {
        Tablero.setParametrosConsigna();
        Tablero tablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(16,0);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        tablero.colocarUnidad(unSoldado);
    }
    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testColocarPiezaAliadaEnCasilleroAliadoOcupado() throws ExcepcionSectorEnemigo, ExcepcionCasilleroOcupado {
        Tablero.setParametrosConsigna();
        Tablero tablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(1,0);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        Soldado otroSoldado = new Soldado(unaPosicion,"Jugador1");
        tablero.colocarUnidad(unSoldado);
        tablero.colocarUnidad(otroSoldado);
    }

    @Test
    public void testSectorInferiorPerteneceAPrimerJugador(){
        Tablero.setParametrosConsigna();
        Tablero tablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(1,0);
        Assert.assertTrue((tablero.estaEnSector("Jugador1", unaPosicion)));

    }

    @Test
    public void testSectorSuperiorPerteneceASegundoJugador(){
        Tablero.setParametrosConsigna();
        Tablero tablero = Tablero.getInstancia();
        Posicion unaPosicion = new Posicion(11,0);
        Assert.assertTrue((tablero.estaEnSector("Jugador2", unaPosicion)));

    }

}
