package Vistas;

import Controller.MoverUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Turno extends VBox {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private MenuDeOpciones opcionesView;

    public Turno(TableroView tableroView, InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos, MenuDeOpciones opcionesView) {

        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.jugadorActual = jugadorUno;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.opcionesView = opcionesView;

        this.setTurno(false);
    }

    public void cambiarJugador(){
        if(jugadorUno.getNombre()==jugadorActual.getNombre()){
            jugadorActual=jugadorDos;
            this.setTurno(false);
        }else{
            jugadorActual=jugadorUno;
            this.setTurno(false);
        }
    }

    public void setTurno(boolean yaMovio) {
        this.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label opcionesDeTurno = new Label("Indique que accion desea realizar");

        BotonMover mover = new BotonMover(tablero, infoCasillero, jugadorActual, tableroView,this);

        BotonAtacar atacar = new BotonAtacar(tablero, infoCasillero, jugadorActual, tableroView,this);

        BotonCurar curar = new BotonCurar(tablero, infoCasillero, jugadorActual, tableroView,this);

        BotonCrearBatallon crearBatallon = new BotonCrearBatallon(tablero, infoCasillero, jugadorActual, tableroView,this);

        BotonPasar pasar = new BotonPasar(this);

        this.setSpacing(10);
        if(!yaMovio){
            this.getChildren().addAll(jugador,opcionesDeTurno,mover,crearBatallon,atacar,curar,pasar);
        }else {
            this.getChildren().addAll(jugador,opcionesDeTurno,atacar,curar,pasar);
        }
    }
}
