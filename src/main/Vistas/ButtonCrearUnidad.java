package Vistas;

import Controller.CrearUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.control.Button;

public class ButtonCrearUnidad extends Button {


    public ButtonCrearUnidad(String unidadACrear, Tablero tablero, Jugador jugadorActual,InfoCasillero infoCasillero) {
        this.setText(unidadACrear);
        this.setOnAction(new CrearUnidadEventHandler(unidadACrear, tablero, jugadorActual,infoCasillero));
    }
}
