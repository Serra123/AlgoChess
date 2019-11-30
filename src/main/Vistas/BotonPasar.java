package Vistas;

import Controller.MoverUnidadEventHandler;
import Controller.PasarEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonPasar extends Button {

    public BotonPasar(Turno turno) {
        this.setPadding( new Insets(20,24,20,24));
        this.setText("Pasar");
        this.setStyle("-fx-background-image: url('imagenBotonPasar.jpg')");
        this.setOnAction(new PasarEventHandler(turno));

    }
}
