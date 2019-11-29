package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FaseJuego{

    private static final int LADO = 20;

    static void display(Jugador jugadorUno, Jugador jugadorDos){

        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("AlgoChess");
        ventana.setMinWidth(500);

        Tablero tablero = new Tablero(LADO,LADO,jugadorUno.getNombre(),jugadorDos.getNombre());

        BorderPane juegoView = new BorderPane();
        juegoView.setPadding(new Insets(10,200,0,0));
        Label tituloJuego = new Label("AlgoChess");
        BorderPane.setAlignment(tituloJuego, Pos.CENTER);
        juegoView.setTop(tituloJuego);

        InfoCasillero infoCasillero = new InfoCasillero("");

        TableroView tableroView = new TableroView(tablero, infoCasillero, jugadorUno, jugadorDos);

        StatusTablero statusTablero = new StatusTablero(tableroView,infoCasillero,tablero,jugadorUno,jugadorDos);

        juegoView.setLeft(tableroView);
        juegoView.setRight(statusTablero);

        Scene scene = new Scene(juegoView,1300,800);
        ventana.setScene(scene);
        ventana.show();
    }

}