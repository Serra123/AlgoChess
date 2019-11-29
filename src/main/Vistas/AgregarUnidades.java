package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AgregarUnidades extends VBox {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;


    public AgregarUnidades(InfoCasillero infoCasillero ,Tablero tablero, Jugador jugadorUno,Jugador jugadorDos, boolean jugadorUnoYaColoco) {

        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.jugadorActual = jugadorUno;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;

        this.iniciar();

    }

    public void cambiarJugador() {
        jugadorActual = jugadorDos;
        this.iniciar();
    }

    public void iniciar(){
        this.getChildren().clear();

        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear unidad \nY LUEGO la unidad que desee");
        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta",tablero,jugadorActual,infoCasillero);

        BotonFrenarCreacionUnidades botonFrenarCreacionUnidades = new BotonFrenarCreacionUnidades("Listo",jugadorUno,jugadorActual,this);

        this.getChildren().addAll(opcionesIngreso,crearSoldado,crearJinete,crearCurandero,crearCatapulta,botonFrenarCreacionUnidades);

    }
}

