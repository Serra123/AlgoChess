package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.layout.VBox;

public class StatusTablero extends VBox {
    InfoCasillero infoCasillero;
    Tablero tablero;


    public StatusTablero(InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.getChildren().add(new OpcionesView(infoCasillero,tablero,jugadorUno,jugadorDos));
        this.getChildren().add(infoCasillero);
    }
}
