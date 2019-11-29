package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FaseJuego{

    private static int LADO = 20;
    private static Jugador jugadorUno;
    private static Jugador jugadorDos;
    private static Tablero tablero;


    public static void display(Jugador jugadorUno, Jugador jugadorDos){

        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("ALGOCHESS - FASE DE JUEGO");
        ventana.setMinWidth(500);

        inicializarJuego(jugadorUno,jugadorDos);

        BorderPane faseJuego = new BorderPane();
        faseJuego.setPadding(new Insets(10,200,0,0));
        Label tituloJuego = new Label("AlgoChess");
        BorderPane.setAlignment(tituloJuego, Pos.CENTER);
        faseJuego.setTop(tituloJuego);

        InfoCasillero infoCasillero = new InfoCasillero("");

        TableroView tableroView = new TableroView(tablero,infoCasillero, jugadorUno, jugadorDos);

        StatusTablero statusTablero = new StatusTablero(tableroView,infoCasillero,tablero,jugadorUno,jugadorDos);

        faseJuego.setLeft(tableroView);
        faseJuego.setRight(statusTablero);

        Scene scene = new Scene(faseJuego,1300,800);
        ventana.setScene(scene);
        ventana.show();
    }

    private static void inicializarJuego(Jugador jugadorUno,Jugador jugadorDos){
        FaseJuego.jugadorUno = jugadorUno;
        FaseJuego.jugadorDos = jugadorDos;
        FaseJuego.tablero = new Tablero(LADO,LADO,jugadorUno.getNombre(),jugadorDos.getNombre());
    }

}