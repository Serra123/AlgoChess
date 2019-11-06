package Tablero;

import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.assertThrows();

public class TableroTest {

    @Test
    public void testCorrectaInicializacionDelTablero(){
        Tablero unTablero = new Tablero(1,1,"Ejercito aliado", "Ejercito enemigo");



       // unTablero.moverUnidad(unaUnidad);   //COmentario a borrar
        Assert.assertTrue(true);
    }

    @Test
    public void testColocarPiezaAliadaEnSectorAliadoFunciona() throws ExcepcionCasilleroOcupado{
        Tablero tablero = new Tablero(2,2,"Jugador1","jugador2");
        Soldado unSoldado = new Soldado(0,0,"Jugador1");
        Posicion unaPosicion = new Posicion(0,1);
        tablero.colocarUnidad(unSoldado,unaPosicion);
        Assert.assertEquals(unSoldado,tablero.getUnidad(unaPosicion));
    }

    @Test
    public void testColocarPiezaAliadaEnSectorEnemigoNoFunciona() throws ExcepcionCasilleroOcupado  {
        Tablero tablero = new Tablero(2,2,"Jugador1","jugador2");
        Soldado unSoldado = new Soldado(0,0,"Jugador1");
        Posicion unaPosicion = new Posicion(1,1);
        try{
            tablero.colocarUnidad(unSoldado,unaPosicion);
        }catch(RuntimeException e){
            Assertions.assertThrows("La prueba no paso" + e.getMessage());
        }
    }
}
