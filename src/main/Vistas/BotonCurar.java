package Vistas;

import Controller.AtacarUnidadEventHandler;
import Controller.CurarUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonCurar extends Button {

    public BotonCurar(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno){
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Curar");
        this.setStyle("-fx-background-image: url('imagenBotonCurar.jpg')");
        this.setOnAction(new CurarUnidadEventHandler(tablero,infoCasillero,jugadorActual,tableroView,turno));
    }

}
