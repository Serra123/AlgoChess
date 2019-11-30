package Vistas;

import Controller.AtacarUnidadEventHandler;
import Controller.CrearBatallonEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonCrearBatallon extends Button {

    public BotonCrearBatallon(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Crear Batallon");
        this.setOnAction(new CrearBatallonEventHandler(tablero,infoCasillero,jugadorActual,tableroView,turno));

    }
}
