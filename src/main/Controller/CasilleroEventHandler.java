package Controller;

import Unidades.Posicion.Posicion;
import Vistas.InfoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CasilleroEventHandler implements EventHandler<ActionEvent> {
    private Posicion posicion;
    private InfoCasillero infoCasillero;

    public CasilleroEventHandler(Posicion unaPosicion, InfoCasillero infoCasillero) {
        this.posicion = unaPosicion;
        this.infoCasillero = infoCasillero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.infoCasillero.actualizarPosicionClickeada(posicion);
    }
}
