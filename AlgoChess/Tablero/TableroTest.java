package Tablero;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testCorrectaInicializacionDelTablero(){
        Tablero unTablero = new Tablero(1,1,"Ejercito aliado", "Ejercito enemigo");



        unTablero.moverUnidad(unaUnidad);   //COmentario a borrar
        Assert.assertTrue();
    }
}
