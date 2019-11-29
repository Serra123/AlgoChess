package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.UnidadMovible;
import Vistas.InfoCasillero;
import Vistas.MenuDeOpciones;
import Vistas.TableroView;
import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private MenuDeOpciones opcionesView;
    private Posicion posicionAMover;
    private Turno turno;

    public MoverUnidadEventHandler(Tablero tablero , InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {

        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.turno = turno;


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        turno.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAMover = new Label("Seleccione que unidad desea mover y luego listo");
        Button listo = new Button ("listo");
        turno.getChildren().addAll(jugador,seleccionUnidadAMover,listo);

        listo.setOnAction(f-> {
            posicionAMover = infoCasillero.getPosicion();
            turno.getChildren().clear();
            Label seleccionCasillero = new Label("Seleccione a donde desea mover la unidad");
            turno.getChildren().addAll(jugador, seleccionCasillero, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasillero.getPosicion();
                try {
                    UnidadMovible unidad = (UnidadMovible) tablero.getUnidad(posicionAMover);
                    unidad.mover(nuevaPosicion, tablero);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    turno.setTurno(true,jugadorActual);
                } catch (ExcepcionCasilleroOcupado error) {
                    infoCasillero.setText("No podes moverlo a un casillero ocupado");
                    turno.setTurno(false,jugadorActual);
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasillero.setText(" Esa posicion esta VACIA");
                    turno.setTurno(false,jugadorActual);
                } catch (ExcepcionMovimientoInvalido error) {
                    infoCasillero.setText("Movimiento invalido");
                    turno.setTurno(false,jugadorActual);
                } catch (ClassCastException error) {
                    infoCasillero.setText(" No podes mover una catapulta");
                    turno.setTurno(false,jugadorActual);
                }
            });
        });
    }
}
