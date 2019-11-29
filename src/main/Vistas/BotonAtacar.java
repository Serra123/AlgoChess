package Vistas;

import Controller.AtacarUnidadEventHandler;
import Controller.MoverUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    public BotonAtacar(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno){
        this.setPadding( new Insets(15,15,15,15));
        this.setText("OPCION Atacar");
        this.setOnAction(new AtacarUnidadEventHandler(tablero,infoCasillero,jugadorActual,tableroView,turno));
    }
}
