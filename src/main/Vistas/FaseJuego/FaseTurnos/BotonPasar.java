package Vistas.FaseJuego.FaseTurnos;

import Controller.PasarEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonPasar extends Button {

    public BotonPasar(FaseTurnos faseTurnos) {
        this.setPadding( new Insets(20,24,20,24));
        this.setText("Pasar");
        this.getStylesheets().add("botonEleccionUnidad.css");
        this.getStyleClass().add("botonEleccionUnidad");
        this.setOnAction(new PasarEventHandler(faseTurnos));

    }
}
