package Juego.Tablero;

import Juego.Jugador;
import org.junit.Test;

public class TableroTest {
    @Test
    void tableroIniciadoCorrectamente(){
        Jugador jugador = new Jugador("juan");
        Tablero tablero = new Tablero(20,20);
        jugador.agregarSoldado(3,2,tablero);

    }
}
