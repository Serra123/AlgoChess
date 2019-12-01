package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Excepciones.ExcepcionUnidadNoPerteneceATuEjercito;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.UnidadMovible;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public MoverUnidadEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.faseTurnos = faseTurnos;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VBox statusTablero = faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAMover = new Label("Seleccione que unidad desea mover y luego listo");
        Button listo = new Button ("listo");
        infoCasilleroBox.setText("");
        statusTablero.getChildren().addAll(jugador,seleccionUnidadAMover,listo,infoCasilleroBox);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            Label seleccionCasillero = new Label("Seleccione a donde desea mover la unidad");
            statusTablero.getChildren().addAll(jugador, seleccionCasillero, listo,infoCasilleroBox);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    UnidadMovible unidad = (UnidadMovible) tablero.getUnidadDe(posicionAMover,jugadorActual);
                    unidad.mover(nuevaPosicion, tablero);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                } catch (ExcepcionCasilleroOcupado error) {
                    infoCasilleroBox.setText("No podes moverlo a un casillero ocupado");
                    faseTurnos.crearLayoutFaseParaJugadorActual(false);
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasilleroBox.setText(" Esa posicion esta VACIA");
                    faseTurnos.crearLayoutFaseParaJugadorActual(false);
                } catch (ExcepcionMovimientoInvalido error) {
                    infoCasilleroBox.setText("Movimiento invalido");
                    faseTurnos.crearLayoutFaseParaJugadorActual(false);
                } catch (ClassCastException error) {
                    infoCasilleroBox.setText(" No podes mover una catapulta");
                    faseTurnos.crearLayoutFaseParaJugadorActual(false);
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error){
                    infoCasilleroBox.setText(" No podes mover una unidad enemiga!!");
                }
            });
        });
    }
}
