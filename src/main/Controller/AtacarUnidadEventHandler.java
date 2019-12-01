package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
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

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public AtacarUnidadEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.faseTurnos = faseTurnos;

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        VBox statusTablero = faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAtacante = new Label("Seleccione con que unidad desea \natacar y luego listo");
        Button listo = new Button ("listo");

        infoCasilleroBox.setText("");
        statusTablero.getChildren().addAll(jugador,seleccionUnidadAtacante,listo,infoCasilleroBox);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            Label seleccionUnidadAtacada = new Label("Seleccione a que unidad que desea \natacar y luego listo");
            statusTablero.getChildren().addAll(jugador, seleccionUnidadAtacada, listo,infoCasilleroBox);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que la atacante sea del jugadorActual,la otra despues veo
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.cambiarJugador();
                } catch (ExcepcionCasilleroVacio error) {
                    String cabecera = "Esta posicion esta vacia";
                    String contenido = "Selecciona una posicion con unidad";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                    String cabecera = "No podes atacar con una unidad que no pertenece a tu ejercito";
                    String contenido = "Selecciona una unidad propia e intenta nuevamente";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch(ExcepcionAtaqueAAliado error){
                    String cabecera = "No podes atacar a un aliado";
                    String contenido = "Selecciona una unidad enemiga e intenta nuevamente";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch(ExcepcionCuranderoNoAtaca error){
                    String cabecera = "No podes con un curandero";
                    String contenido = "Selecciona una unidad que sí ataque";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                }
                catch (ExcepcionDistanciaAtaqueInvalida error){
                    String cabecera = "La unidad a atacar esta fuera de rando";
                    String contenido = "Selecciona una unidad a atacar que esté dentro del rango";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                }
            });
        });
    }
}
