package Controller;

import Unidades.Posicion.Posicion;
import Vistas.InfoTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CasilleroEventHandler implements EventHandler<ActionEvent> {
    private Posicion posicion;
    private InfoTablero infoTablero;

    public CasilleroEventHandler(Posicion unaPosicion,InfoTablero infoTablero) {
        this.posicion = unaPosicion;
        this.infoTablero = infoTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.infoTablero.actualizarPosicionClickeada(posicion);
    }
}
