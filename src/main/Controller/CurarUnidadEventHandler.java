package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Curandero;
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

public class CurarUnidadEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private Turno turno;

    public CurarUnidadEventHandler(Tablero tablero , InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {

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
        Label seleccionUnidadCuradora = new Label("Seleccione con que unidad desea curar \ny luego listo");
        Button listo = new Button ("listo");
        turno.getChildren().addAll(jugador,seleccionUnidadCuradora,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasillero.getPosicion();
            turno.getChildren().clear();
            Label seleccionUnidadCurada = new Label("Seleccione a que unidad que desea \ncurar y luego listo");
            turno.getChildren().addAll(jugador, seleccionUnidadCurada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasillero.getPosicion();
                try {
                    Curandero unidadACuradora =(Curandero) tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que sea de mi ejercito
                    Unidad unidadACurar =tablero.getUnidad(nuevaPosicion);
                    unidadACuradora.curar(unidadACurar);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    turno.cambiarJugador();
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasillero.setText(" Esa posicion esta VACIA");
                    turno.setTurno(true);
                } catch (ClassCastException error) {
                    infoCasillero.setText(" No podes curar con una unidad que no es Curandero");
                    turno.setTurno(true);
                } catch (ExcepcionCuracionAEnemigo error){
                    infoCasillero.setText(" No podes curar a una unidad enemiga!!");
                    turno.setTurno(true);
                }
            });
        });
    }
}
