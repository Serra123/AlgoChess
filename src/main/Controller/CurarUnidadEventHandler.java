package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
import Vistas.FaseJuego.FaseTurnos.OpcionesTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CurarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private OpcionesTurno opcionesTurno;

    public CurarUnidadEventHandler(JuegoPrincipal juegoPrincipal, OpcionesTurno opcionesTurno) {

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
        Label seleccionUnidadCuradora = new Label("Seleccione con que unidad desea curar \ny luego listo");
        Button listo = new Button ("listo");
        opcionesTurno.getChildren().addAll(jugador,seleccionUnidadCuradora,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            opcionesTurno.getChildren().clear();
            Label seleccionUnidadCurada = new Label("Seleccione a que unidad que desea \ncurar y luego listo");
            opcionesTurno.getChildren().addAll(jugador, seleccionUnidadCurada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    Curandero unidadCurandera =(Curandero) tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que sea de mi ejercito
                    Unidad unidadACurar =tablero.getUnidad(nuevaPosicion);
                    unidadCurandera.curar(unidadACurar);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    opcionesTurno.cambiarJugador();
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasilleroBox.setText(" Esa posicion esta VACIA");
                    opcionesTurno.setTurno(true);
                } catch (ClassCastException error) {
                    infoCasilleroBox.setText(" No podes curar con una unidad que no es Curandero");
                    opcionesTurno.setTurno(true);
                } catch (ExcepcionCuracionAEnemigo error){
                    infoCasilleroBox.setText(" No podes curar a una unidad enemiga!!");
                    opcionesTurno.setTurno(true);
                }
            });
        });
    }
}
