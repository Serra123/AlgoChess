package Vistas.FaseJuego.FaseTurnos;

import Controller.CrearBatallonEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonCrearBatallon extends Button {

    public BotonCrearBatallon(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Crear Batallon");
        this.getStylesheets().add("botonEleccionUnidad.css");
        this.getStyleClass().add("botonEleccionUnidad");
        this.setOnAction(new CrearBatallonEventHandler(juegoPrincipal, faseTurnos));

    }
}
