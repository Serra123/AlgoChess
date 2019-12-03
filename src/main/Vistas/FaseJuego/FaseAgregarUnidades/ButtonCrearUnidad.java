package Vistas.FaseJuego.FaseAgregarUnidades;

import Controller.CrearUnidadEventHandler;
import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ButtonCrearUnidad extends Button {

    public ButtonCrearUnidad(String unidadACrear, Jugador jugadorActual, JuegoPrincipal juegoPrincipal, Label puntosJugadorActual) {
        this.setText(unidadACrear);
        this.getStyleClass().add("botonEleccionUnidad");
        this.getStylesheets().removeAll();
        this.getStylesheets().add("botonEleccionUnidad.css");
        this.setOnAction(new CrearUnidadEventHandler(unidadACrear,jugadorActual,juegoPrincipal,puntosJugadorActual));
    }
}
