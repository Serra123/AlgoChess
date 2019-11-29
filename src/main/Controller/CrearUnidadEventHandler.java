package Controller;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Vistas.InfoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    private InfoCasillero infoCasillero;
    private String unidadACrear;
    private Tablero tablero;
    private Jugador jugadorActual;

    public CrearUnidadEventHandler(String unidadACrear, Tablero tablero, Jugador jugadorActual, InfoCasillero infoCasillero) {
        this.infoCasillero = infoCasillero;
        this.unidadACrear = unidadACrear;
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Posicion unaPosicion = infoCasillero.getPosicion();
        jugadorActual.crearUnidadEnPosicion(unaPosicion, unidadACrear, tablero);
    }
}
