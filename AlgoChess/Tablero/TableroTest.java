package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testCorrectaInicializacionDelTablero(){
        Tablero unTablero = new Tablero(1,1,"Ejercito aliado", "Ejercito enemigo");



       // unTablero.moverUnidad(unaUnidad);
        Assert.assertTrue(true);
    }

    @Test
    public void testColocarPiezaAliadaEnSectorAliadoFunciona() throws ExcepcionCasilleroOcupado{
        Tablero tablero = new Tablero(2,2,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        try {
            tablero.colocarUnidad(unSoldado);
        }catch (ExcepcionSectorEnemigo e) {
            Assert.fail();
        }
        Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test(expected = ExcepcionSectorEnemigo.class)
    public void testColocarPiezaAliadaEnSectorEnemigoNoFunciona() throws ExcepcionSectorEnemigo,ExcepcionCasilleroOcupado{
        Tablero tablero = new Tablero(4,4,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(0,0);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        Posicion otraPosicion = new Posicion(3,1);
        tablero.colocarUnidad(unSoldado);
    }

}
