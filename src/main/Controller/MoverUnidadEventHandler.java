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
import javafx.scene.text.Font;

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

        Label jugador = new Label("Es el turno de: " + jugadorActual.getNombre());
        jugador.setFont(new Font("Arial",25));
        jugador.setTranslateX(-150);
        jugador.setTranslateY(25);
        Label seleccionUnidadAMover = new Label("Seleccione que unidad desea mover y luego listo.");
        seleccionUnidadAMover.setTranslateY(60);
        seleccionUnidadAMover.setTranslateX(-150);
        Button listo = new Button ("listo");
        listo.setTranslateX(-150);
        listo.setTranslateY(80);
        infoCasilleroBox.setText("");
        statusTablero.getChildren().addAll(jugador,seleccionUnidadAMover,listo,infoCasilleroBox);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            Label seleccionCasillero = new Label("Seleccione a donde desea mover la unidad y luego listo.");
            seleccionCasillero.setTranslateX(-150);
            seleccionCasillero.setTranslateY(60);
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
                    String cabecera = "No podes moverte a un casillero ocupado";
                    String contenido = "Selecciona uno vacio al que moverte";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
                } catch (ExcepcionCasilleroVacio error) {
                    String cabecera = "Esta posicion esta vacia";
                    String contenido = "Selecciona una posicion con unidad";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
                } catch (ExcepcionMovimientoInvalido error) {
                    String cabecera = "Movimiento invalido";
                    String contenido = "Selecciona una distancia a la cual tu unidad se pueda mover";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
                } catch (ClassCastException error) {
                    String cabecera = "No podes mover una catapulta";
                    String contenido = "Selecciona una unidad que sí puedas mover";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error){
                    String cabecera = "No podes mover una unidad enemiga";
                    String contenido = "Selecciona una unidad propia";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
                }
            });
        });
    }
}
