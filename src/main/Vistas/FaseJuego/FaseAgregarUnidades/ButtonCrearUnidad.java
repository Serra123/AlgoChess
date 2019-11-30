package Vistas.FaseJuego.FaseAgregarUnidades;

import Controller.CrearUnidadEventHandler;
import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.control.Button;

public class ButtonCrearUnidad extends Button {

    public ButtonCrearUnidad(String unidadACrear, Jugador jugadorActual, JuegoPrincipal juegoPrincipal) {
        this.setText(unidadACrear);
        this.setOnAction(new CrearUnidadEventHandler(unidadACrear,jugadorActual,juegoPrincipal));
    }
}
