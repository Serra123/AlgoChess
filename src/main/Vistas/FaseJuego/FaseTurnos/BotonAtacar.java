package Vistas.FaseJuego.FaseTurnos;

import Controller.AtacarUnidadEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    public BotonAtacar(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Atacar");
        this.getStylesheets().add("botonEleccionUnidad.css");
        this.getStyleClass().add("botonEleccionUnidad");
        this.setOnAction(new AtacarUnidadEventHandler(juegoPrincipal, faseTurnos));
    }
}
