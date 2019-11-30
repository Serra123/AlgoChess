package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
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

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private OpcionesTurno opcionesTurno;

    public AtacarUnidadEventHandler(JuegoPrincipal juegoPrincipal, OpcionesTurno opcionesTurno) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.opcionesTurno = opcionesTurno;

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        opcionesTurno.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAtacante = new Label("Seleccione con que unidad desea \natacar y luego listo");
        Button listo = new Button ("listo");
        opcionesTurno.getChildren().addAll(jugador,seleccionUnidadAtacante,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            opcionesTurno.getChildren().clear();
            Label seleccionUnidadAtacada = new Label("Seleccione a que unidad que desea \natacar y luego listo");
            opcionesTurno.getChildren().addAll(jugador, seleccionUnidadAtacada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                try {
                    Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que la atacante sea del jugadorActual,la otra despues veo
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    opcionesTurno.cambiarJugador();
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                    infoCasilleroBox.setText("No podes atacar con una unidad que no pertenece a tu ejercito!!");
                    opcionesTurno.setTurno(true);
                } catch(ExcepcionAtaqueAAliado error){
                    infoCasilleroBox.setText("No podes atacar a un aliado!!");
                    opcionesTurno.setTurno(true);
                } catch(ExcepcionCuranderoNoAtaca error){
                    infoCasilleroBox.setText("No podes atacar con un curandero");
                }
                catch (ExcepcionDistanciaAtaqueInvalida error){
                    infoCasilleroBox.setText("La distancia de ataque NO es valida!");
                    opcionesTurno.setTurno(true);
                }
            });
        });
    }
}
