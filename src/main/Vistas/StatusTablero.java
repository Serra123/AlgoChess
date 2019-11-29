package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.layout.VBox;

public class StatusTablero extends VBox {

    public StatusTablero(TableroView tableroView, InfoCasillero infoCasillero,
                         Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {

        this.getChildren().add(new MenuDeOpciones(tableroView,infoCasillero,tablero,jugadorUno,jugadorDos));
        this.getChildren().add(infoCasillero);

    }

}
