package Tests;

import Tablero.Fila;
import org.junit.Test;

public class FilaTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void testNoPuedoSeleccionarCasilleroFueraDeLimite(){
        Fila unaFila = new Fila(5,"Jugador1");
        unaFila.getCasillero(6);
    }
}
