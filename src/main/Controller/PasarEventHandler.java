package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionMovimientoInvalido;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.UnidadMovible;
import Vistas.InfoCasillero;
import Vistas.MenuDeOpciones;
import Vistas.TableroView;
import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PasarEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private MenuDeOpciones opcionesView;
    private Posicion posicionAMover;
    private Turno turno;

    public PasarEventHandler(Tablero tablero, InfoCasillero infoCasillero,Jugador jugadorUno, Jugador jugadorDos, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.turno = turno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        turno.getChildren().clear();

        if(jugadorUno.getNombre()==jugadorActual.getNombre()){
            turno.setTurno(false,jugadorDos);
        }else{
            turno.setTurno(false,jugadorUno);
        }
    }
}
