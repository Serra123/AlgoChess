package Vistas;

import Controller.MoverUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonMover extends Button {

    public BotonMover(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.setText("Mover");
        this.setPadding( new Insets(20,21,20,21));
        this.setOnAction(new MoverUnidadEventHandler(tablero,infoCasillero,jugadorActual,tableroView,turno));
    }
}
