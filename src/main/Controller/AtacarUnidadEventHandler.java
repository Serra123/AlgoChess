package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;
import Vistas.InfoCasillero;
import Vistas.TableroView;
import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private Turno turno;

    public AtacarUnidadEventHandler(Tablero tablero , InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {

        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.turno = turno;

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        turno.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label seleccionUnidadAtacante = new Label("Seleccione con que unidad desea \natacar y luego listo");
        Button listo = new Button ("Listo");
        turno.getChildren().addAll(jugador,seleccionUnidadAtacante,listo);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasillero.getPosicion();
            turno.getChildren().clear();
            Label seleccionUnidadAtacada = new Label("Seleccione a que unidad que desea \natacar y luego listo");
            turno.getChildren().addAll(jugador, seleccionUnidadAtacada, listo);

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasillero.getPosicion();
                try {
                    Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que la atacante sea del jugadorActual,la otra despues veo
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);

                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    turno.cambiarJugador();
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                    infoCasillero.setText("No podes atacar con una unidad que no pertenece a tu ejercito!!");
                    turno.setTurno(true);
                } catch(ExcepcionAtaqueAAliado error){
                    infoCasillero.setText("No podes atacar a un aliado!!");
                    turno.setTurno(true);
                } catch(ExcepcionCuranderoNoAtaca error){
                    infoCasillero.setText("No podes atacar con un curandero");
                } catch (ExcepcionDistanciaAtaqueInvalida error){
                    infoCasillero.setText("La distancia de ataque NO es valida!");
                    turno.setTurno(true);
                }
            });
        });
    }
}
