package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Excepciones.ExcepcionUnidadNoPerteneceATuEjercito;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.UnidadMovible;
import Vistas.FaseJuego.*;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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

        Posicion posicionAMover = infoCasilleroBox.getPosicion();
        LabelNombreJugador jugador = new LabelNombreJugador(-210,0,"Es el turno de: " + jugadorActual.getNombre());
        LabelDatosJuego instrucciones = new LabelDatosJuego(-210,60,"Seleccione a donde desea mover la unidad.");
        Button listo = new Button ("listo");
        infoCasilleroBox.setText("");
        statusTablero.getChildren().addAll(jugador,instrucciones,listo,infoCasilleroBox);

        listo.setOnAction(e -> {
            Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
            try {
                UnidadMovible unidad = (UnidadMovible) tablero.getUnidadDe(posicionAMover,jugadorActual);
                unidad.mover(nuevaPosicion, tablero);
                tableroView.actualizar();
                tableroView.mostrar(nuevaPosicion);
                faseTurnos.jugadorYaMovio();
            } catch (ExcepcionCasilleroOcupado error) {
                String cabecera = "No podes moverte a un casillero ocupado";
                String contenido = "Selecciona uno vacio al que moverte";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ExcepcionCasilleroVacio error) {
                String cabecera = "Esta posicion esta vacia";
                String contenido = "Selecciona una posicion con unidad";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ExcepcionMovimientoInvalido error) {
                String cabecera = "Movimiento invalido";
                String contenido = "Selecciona una distancia a la cual tu unidad se pueda mover";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ClassCastException error) {
                String cabecera = "No podes mover una catapulta";
                String contenido = "Selecciona una unidad que sí puedas mover";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ExcepcionUnidadNoPerteneceATuEjercito error){
                String cabecera = "No podes mover una unidad enemiga";
                String contenido = "Selecciona una unidad propia";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            }
        });
    }
}
