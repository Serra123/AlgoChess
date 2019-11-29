package Vistas;

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
    private OpcionesView opcionesView;

    public Turno(TableroView tableroView, InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos, boolean jugadorUnoYaColoco, OpcionesView opcionesView) {

        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.jugadorActual = jugadorUno;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.opcionesView = opcionesView;

        this.iniciarTurno();
    }
    public void cambiarJugador() {
        jugadorActual = jugadorDos;
        this.iniciarTurno();
    }
    private void iniciarTurno() {
        this.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label opcionesDeTurno = new Label("Opciones de turno:");

        Button mover = new Button("OPCION Mover");
        mover.setPadding( new Insets(15,15,15,15));
        //mover.setOnAction(e->moverUnidad(jugadorDeTurno));

        Button atacar = new Button("OPCION Atacar");
        atacar.setPadding( new Insets(15,15,15,15));
        //atacar.setOnAction( e-> atacar(jugadorDeTurno));

        Button curar = new Button("OPCION Curar");
        curar.setPadding( new Insets(15,15,15,15));
        //curar.setOnAction( e-> atacar(jugadorDeTurno));

        Button pasar = new Button("Pasar");
        pasar.setPadding( new Insets(15,15,15,15));
        this.setSpacing(10);
        this.getChildren().addAll(jugador,opcionesDeTurno,mover,atacar,curar,pasar);
    }
}
