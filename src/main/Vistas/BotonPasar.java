package Vistas;

import Controller.MoverUnidadEventHandler;
import Controller.PasarEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonPasar extends Button {



    public BotonPasar(Turno turno) {
        this.setText("Pasar");
        this.setPadding( new Insets(20,24,20,24));
        this.setOnAction(new PasarEventHandler(turno));

    }
}