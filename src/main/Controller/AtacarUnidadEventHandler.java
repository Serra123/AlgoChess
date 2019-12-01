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
        statusTablero.getChildren().addAll(jugador,seleccionUnidadAtacante,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            statusTablero.getChildren().clear();
            Label seleccionUnidadAtacada = new Label("Seleccione a que unidad que desea \natacar y luego listo");
            statusTablero.getChildren().addAll(jugador, seleccionUnidadAtacada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que la atacante sea del jugadorActual,la otra despues veo
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.cambiarJugador();
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                    infoCasilleroBox.setText("No podes atacar con una unidad que no pertenece a tu ejercito!!");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                } catch(ExcepcionAtaqueAAliado error){
                    infoCasilleroBox.setText("No podes atacar a un aliado!!");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                } catch(ExcepcionCuranderoNoAtaca error){
                    infoCasilleroBox.setText("No podes atacar con un curandero");
                }
                catch (ExcepcionDistanciaAtaqueInvalida error){
                    infoCasilleroBox.setText("La distancia de ataque NO es valida!");
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                }
            });
        });
    }
}
