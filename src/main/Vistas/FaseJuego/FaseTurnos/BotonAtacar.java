package Vistas.FaseJuego.FaseTurnos;

import Controller.AtacarUnidadEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    public BotonAtacar(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Atacar");

        this.setStyle("-fx-background-image: url('imagenBotonAtacar.jpg')");
        this.setOnAction(new AtacarUnidadEventHandler(juegoPrincipal, faseTurnos));
    }
}
