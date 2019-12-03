package Vistas.FaseJuego.FaseTurnos;

import Controller.CurarUnidadEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonCurar extends Button {

    public BotonCurar(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos){
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Curar");
        this.getStylesheets().add("botonEleccionUnidad.css");
        this.getStyleClass().add("botonEleccionUnidad");
        this.setOnAction(new CurarUnidadEventHandler(juegoPrincipal, faseTurnos));
    }

}
