package Vistas.FaseJuego.FaseTurnos;

import Controller.MoverUnidadEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonMover extends Button {

    public BotonMover(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {
        this.setText("Mover");
        this.setStyle("-fx-background-image: url('imagenBotonMover.jpg')");
        this.setPadding( new Insets(20,21,20,21));
        this.setOnAction(new MoverUnidadEventHandler(juegoPrincipal, faseTurnos));
    }
}
