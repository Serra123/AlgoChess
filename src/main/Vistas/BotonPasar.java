package Vistas;

import Controller.MoverUnidadEventHandler;
import Controller.PasarEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonPasar extends Button {



    public BotonPasar(Tablero tablero, InfoCasillero infoCasillero,Jugador jugadorUno,Jugador jugadorDos, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.setText("pasar");
        this.setPadding( new Insets(15,15,15,15));
        this.setOnAction(new PasarEventHandler(tablero,infoCasillero,jugadorUno,jugadorDos,jugadorActual,tableroView,turno));

    }
}
