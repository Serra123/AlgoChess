package Vistas;

import Jugador.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FaseJuego extends Application{

    private static int FILAS = 20;
    private static int COLUMNAS = 20;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        BorderPane faseJuego = new BorderPane();

        Label tituloJuego = new Label("AlgoChess");
        faseJuego.setTop(tituloJuego);


        InfoTablero infoTablero = new InfoTablero("aaaaa");

        TableroView tableroView = new TableroView(infoTablero);
        faseJuego.setLeft(tableroView);
        faseJuego.setRight(infoTablero);

        Scene scene = new Scene(faseJuego,1300,800);
        stage.setScene(scene);
        stage.show();
    }

    //private void inicializarJuego()

}