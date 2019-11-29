package Controller;

import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PasarEventHandler implements EventHandler<ActionEvent> {

    private Turno turno;

    public PasarEventHandler(Turno turno) {
        this.turno = turno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        turno.getChildren().clear();
        turno.cambiarJugador();
    }
}
