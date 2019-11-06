package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    //Faltaria chequear la correcta inicializacion de el tablero!

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
        Posicion unaPosicion = new Posicion(3,0);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        tablero.colocarUnidad(unSoldado);
    }
    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testColocarPiezaAliadaEnCasilleroAlidadoOcupado() throws ExcepcionSectorEnemigo,ExcepcionCasilleroOcupado{
        Tablero tablero = new Tablero(4,4,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Soldado unSoldado = new Soldado(unaPosicion,"Jugador1");
        Soldado otroSoldado = new Soldado(unaPosicion,"Jugador1");
        tablero.colocarUnidad(unSoldado);
        tablero.colocarUnidad(otroSoldado);
    }
}
