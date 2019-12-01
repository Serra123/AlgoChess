package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CurarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public CurarUnidadEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {

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
        Label seleccionUnidadCuradora = new Label("Seleccione con que unidad desea curar \ny luego listo");
        Button listo = new Button ("listo");
        statusTablero.getChildren().addAll(jugador,seleccionUnidadCuradora,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            Label seleccionUnidadCurada = new Label("Seleccione a que unidad que desea \ncurar y luego listo");
            statusTablero.getChildren().addAll(jugador, seleccionUnidadCurada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    Curandero unidadCurandera =(Curandero) tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que sea de mi ejercito
                    Unidad unidadACurar =tablero.getUnidad(nuevaPosicion);
                    unidadCurandera.curar(unidadACurar);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.cambiarJugador();
                } catch (ExcepcionCasilleroVacio error) {
                    infoCasilleroBox.setText(" Esa posicion esta VACIA");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                } catch (ClassCastException error) {
                    infoCasilleroBox.setText(" No podes curar con una unidad que no es Curandero");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                } catch (ExcepcionCuracionAEnemigo error){
                    infoCasilleroBox.setText(" No podes curar a una unidad enemiga!!");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                }
            });
        });
    }
}
