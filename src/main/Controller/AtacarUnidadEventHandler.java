package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;
import Vistas.InfoCasillero;
import Vistas.TableroView;
import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private Turno turno;

    public AtacarUnidadEventHandler(Tablero tablero , InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {

        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.turno = turno;

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        turno.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAMover = new Label("Seleccione la unidad con la que desea atacar y luego listo");
        Button listo = new Button ("listo");
        turno.getChildren().addAll(jugador,seleccionUnidadAMover,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasillero.getPosicion();
            turno.getChildren().clear();
            Label seleccionCasillero = new Label("Seleccione la unidad que desee \natacar y luego listo");
            turno.getChildren().addAll(jugador, seleccionCasillero, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasillero.getPosicion();
                try {
                    Unidad unidadAtacante =tablero.getUnidad(posicionAMover);
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    turno.setTurno(true,jugadorActual);
                } catch (ExcepcionCasilleroOcupado error) {
                    infoCasillero.setText("No podes moverlo a un casillero ocupado");
                    turno.setTurno(true, jugadorActual);
                }
            });
        });
    }
}
