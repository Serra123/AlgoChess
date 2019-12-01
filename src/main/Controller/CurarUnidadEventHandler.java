package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.*;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
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

        LabelNombreJugador jugador = new LabelNombreJugador(0,0,jugadorActual.getNombre());
        LabelDatosJuego seleccionUnidadCuradora = new LabelDatosJuego(0,0,"Seleccione con que unidad desea curar \ny luego listo");
        Button listo = new Button ("listo");
        infoCasilleroBox.setText("");
        statusTablero.getChildren().addAll(jugador,seleccionUnidadCuradora,listo,infoCasilleroBox);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            LabelDatosJuego seleccionUnidadCurada = new LabelDatosJuego(0,0,"Seleccione a que unidad que desea \ncurar y luego listo");
            statusTablero.getChildren().addAll(jugador, seleccionUnidadCurada, listo,infoCasilleroBox);

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
                    String cabecera = "Esta posicion esta vacia";
                    String contenido = "Selecciona una posicion con unidad";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch (ClassCastException error) {
                    String cabecera = "No podes curar con una unidad que no es Curandero";
                    String contenido = "Selecciona una curandero o realiza otra accion";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch (ExcepcionCuracionAEnemigo error){
                    String cabecera = "No podes curar a una unidad enemiga";
                    String contenido = "Cura a una ajena o realiza otra accion";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                }
            });
        });
    }
}
