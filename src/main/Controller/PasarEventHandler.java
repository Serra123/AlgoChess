package Controller;

import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PasarEventHandler implements EventHandler<ActionEvent> {

    private FaseTurnos faseTurnos;

    public PasarEventHandler(FaseTurnos faseTurnos) {
        this.faseTurnos = faseTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        faseTurnos.getStatusTablero().getChildren().clear();
        faseTurnos.cambiarJugador();
    }
}
