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
import javafx.stage.Stage;

public class FaseJuego extends Application{

    private static int LADO = 20;
    private static Jugador jugadorUno;
    private static Jugador jugadorDos;
    private static Tablero tablero;

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){

        inicializarJuego();

        BorderPane faseJuego = new BorderPane();
        faseJuego.setPadding(new Insets(10,200,0,0));
        Label tituloJuego = new Label("AlgoChess");
        faseJuego.setAlignment(tituloJuego, Pos.CENTER);
        faseJuego.setTop(tituloJuego);

        InfoCasillero infoCasillero = new InfoCasillero("");

        TableroView tableroView = new TableroView(tablero,infoCasillero, jugadorUno, jugadorDos);

        StatusTablero statusTablero = new StatusTablero(tableroView,infoCasillero,tablero,jugadorUno,jugadorDos);

        faseJuego.setLeft(tableroView);
        faseJuego.setRight(statusTablero);

        Scene scene = new Scene(faseJuego,1300,800);
        stage.setScene(scene);
        stage.show();
    }

    private void inicializarJuego(){
        jugadorUno = new Jugador("JugadorUno");
        jugadorDos = new Jugador("JugadorDos");
        tablero = new Tablero(LADO,LADO,"JugadorUno","JugadorDos");
    }

}