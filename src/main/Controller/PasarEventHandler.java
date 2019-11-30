package Controller;

import Vistas.FaseJuego.FaseTurnos.OpcionesTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PasarEventHandler implements EventHandler<ActionEvent> {

    private OpcionesTurno opcionesTurno;

    public PasarEventHandler(OpcionesTurno opcionesTurno) {
        this.opcionesTurno = opcionesTurno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        opcionesTurno.getChildren().clear();
        opcionesTurno.cambiarJugador();
    }
}
