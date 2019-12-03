package Test;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Ejercito;
import Tablero.*;
import Unidades.*;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testColocarPiezaAliadaEnSectorAliadoFunciona(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero tablero = new Tablero(2,2,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(0,1);
        Soldado unSoldado = new Soldado(unaPosicion,unEjercito);
        tablero.colocarUnidad(unSoldado);
        Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test(expected = ExcepcionSectorEnemigo.class)
    public void testColocarPiezaAliadaEnSectorEnemigoNoFunciona(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero tablero = new Tablero(4,4,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(3,0);
        Soldado unSoldado = new Soldado(unaPosicion,unEjercito);
        tablero.colocarUnidad(unSoldado);
    }
    @Test(expected = ExcepcionCasilleroOcupado.class)
    public void testColocarPiezaAliadaEnCasilleroAliadoOcupado(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero tablero = new Tablero(4,4,"Jugador1","jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Soldado unSoldado = new Soldado(unaPosicion,unEjercito);
        Soldado otroSoldado = new Soldado(unaPosicion,unEjercito);
        tablero.colocarUnidad(unSoldado);
        tablero.colocarUnidad(otroSoldado);
    }

    @Test
    public void testSectorInferiorPerteneceAPrimerJugador(){
        Ejercito unEjercito = new Ejercito("Jugador1");
        Tablero tablero = new Tablero(20,20,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(1,0);
        Soldado unSoldado = new Soldado(unaPosicion,unEjercito);
        Assert.assertTrue((tablero.estaEnSector(unSoldado)));
    }

    @Test
    public void testSectorSuperiorPerteneceASegundoJugador(){
        Ejercito unEjercito = new Ejercito("Jugador2");
        Tablero tablero = new Tablero(20,20,"Jugador1","Jugador2");
        Posicion unaPosicion = new Posicion(11,0);
        Soldado unSoldado = new Soldado(unaPosicion,unEjercito);
        Assert.assertTrue((tablero.estaEnSector(unSoldado)));
    }

}
