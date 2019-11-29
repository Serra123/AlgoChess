package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.layout.VBox;

public class StatusTablero extends VBox {
    InfoCasillero infoCasillero;
    Tablero tablero;


    public StatusTablero(TableroView tableroView,InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.getChildren().add(new OpcionesView(tableroView,infoCasillero,tablero,jugadorUno,jugadorDos));
        this.getChildren().add(infoCasillero);
    }
}
