package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.layout.VBox;

public class OpcionesView extends VBox {



    public OpcionesView(InfoCasillero infoCasillero,Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {
        this.getChildren().add(new AgregarUnidades(infoCasillero,tablero, jugadorUno));
    }
}
