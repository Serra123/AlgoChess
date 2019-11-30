package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Excepciones.ExcepcionUnidadNoPerteneceATuEjercito;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.UnidadMovible;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
import Vistas.FaseJuego.FaseTurnos.OpcionesTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private OpcionesTurno opcionesTurno;

    public MoverUnidadEventHandler(JuegoPrincipal juegoPrincipal, OpcionesTurno opcionesTurno) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.opcionesTurno = opcionesTurno;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        opcionesTurno.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAMover = new Label("Seleccione que unidad desea mover y luego listo");
        Button listo = new Button ("listo");
        opcionesTurno.getChildren().addAll(jugador,seleccionUnidadAMover,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            opcionesTurno.getChildren().clear();
            Label seleccionCasillero = new Label("Seleccione a donde desea mover la unidad");
            opcionesTurno.getChildren().addAll(jugador, seleccionCasillero, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    UnidadMovible unidad = (UnidadMovible) tablero.getUnidadDe(posicionAMover,jugadorActual);
                    unidad.mover(nuevaPosicion, tablero);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    opcionesTurno.setTurno(true);
                } catch (ExcepcionCasilleroOcupado error) {
                    infoCasilleroBox.setText("No podes moverlo a un casillero ocupado");
                    opcionesTurno.setTurno(false);
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasilleroBox.setText(" Esa posicion esta VACIA");
                    opcionesTurno.setTurno(false);
                } catch (ExcepcionMovimientoInvalido error) {
                    infoCasilleroBox.setText("Movimiento invalido");
                    opcionesTurno.setTurno(false);
                } catch (ClassCastException error) {
                    infoCasilleroBox.setText(" No podes mover una catapulta");
                    opcionesTurno.setTurno(false);
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error){
                    infoCasilleroBox.setText(" No podes mover una unidad enemiga!!");
                }
            });
        });
    }
}
