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
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private MenuDeOpciones opcionesView;

    public Turno(TableroView tableroView, InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos, MenuDeOpciones opcionesView) {

        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.opcionesView = opcionesView;

        this.setTurno(false,jugadorUno);
    }

    public void setTurno(boolean yaMovio,Jugador jugadorActual) {
        this.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label opcionesDeTurno = new Label("Indique que accion desea realizar");

        BotonMover mover = new BotonMover(tablero, infoCasillero, jugadorActual, tableroView,this);

        Button atacar = new Button("OPCION Atacar");
        atacar.setPadding( new Insets(15,15,15,15));
        //atacar.setOnAction( e-> atacar(jugadorDeTurno));

        Button curar = new Button("OPCION Curar");
        curar.setPadding( new Insets(15,15,15,15));
        //curar.setOnAction( e-> atacar(jugadorDeTurno));

        BotonPasar pasar = new BotonPasar(tablero, infoCasillero,jugadorUno,jugadorDos, jugadorActual, tableroView,this);
        this.setSpacing(10);
        if(!yaMovio){
            this.getChildren().addAll(jugador,opcionesDeTurno,mover,atacar,curar,pasar);
        }else {
            this.getChildren().addAll(jugador,opcionesDeTurno,atacar,curar,pasar);
        }
    }
}
